package com.tencent.av.business;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public class MsfServletProxy
{
  private final Map<String, String[]> a;
  private AppInterface b;
  private final ArrayList<String> c;
  
  public MsfServletProxy(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
    this.a = new ConcurrentHashMap();
    this.c = new ArrayList(10);
  }
  
  public AppInterface a()
  {
    return this.b;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      int i = (int)l;
      Object localObject = new byte[i + 4];
      PkgTools.dWord2Byte((byte[])localObject, 0, l + 4L);
      PkgTools.copyData((byte[])localObject, 4, paramToServiceMsg.getWupBuffer(), i);
      paramToServiceMsg.putWupBuffer((byte[])localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PB cmd: req cmd: ");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        QLog.d("MsfServletProxy", 2, ((StringBuilder)localObject).toString());
      }
      paramClass = new NewIntent(this.b.getApplication(), paramClass);
      paramClass.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
      this.b.startServlet(paramClass);
      l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("sendtimekey", l);
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
    {
      AppInterface localAppInterface = a();
      float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
      Object localObject1 = paramFromServiceMsg.getServiceCmd();
      if (paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          paramException = new StringBuilder();
          paramException.append("[RES]cmd=");
          paramException.append((String)localObject1);
          paramException.append(", app seq:");
          paramException.append(paramFromServiceMsg.getAppSeq());
          paramException.append(", sec.=");
          paramException.append(f);
          QLog.d("MsfServletProxy", 2, paramException.toString());
        }
      }
      else if (paramException != null)
      {
        localObject2 = new ByteArrayOutputStream();
        paramException.printStackTrace(new PrintStream((OutputStream)localObject2));
        paramException = new String(((ByteArrayOutputStream)localObject2).toByteArray());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[NOT SEND]cmd=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append(paramException);
          QLog.d("MsfServletProxy", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramException = new StringBuilder();
        paramException.append("[RES]cmd=");
        paramException.append((String)localObject1);
        paramException.append(", CODE=");
        paramException.append(paramFromServiceMsg.getResultCode());
        paramException.append(", sec.=");
        paramException.append(f);
        QLog.w("MsfServletProxy", 2, paramException.toString());
      }
      paramException = null;
      Object localObject2 = paramToServiceMsg.extraData;
      int i = 0;
      boolean bool = ((Bundle)localObject2).getBoolean("req_pb_protocol_flag", false);
      if (((paramBoolean) || (this.c.contains(localObject1))) && (bool))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("PB cmd: recv cmd: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("MsfServletProxy", 2, ((StringBuilder)localObject2).toString());
        }
        int j;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          j = paramFromServiceMsg.getWupBuffer().length - 4;
          if (j > 0)
          {
            paramException = new byte[j];
            PkgTools.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, j);
            paramFromServiceMsg.putWupBuffer(paramException);
          }
          paramException = paramFromServiceMsg.getWupBuffer();
        }
        localObject2 = (String[])this.a.get(localObject1);
        if ((localObject2 != null) && (localObject2.length > 0)) {
          j = localObject2.length;
        }
        while (i < j)
        {
          localObject1 = localAppInterface.getBusinessHandler(localObject2[i]);
          if (localObject1 != null) {
            try
            {
              ((BusinessHandler)localObject1).onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(localObject1.getClass().getSimpleName());
                localStringBuilder.append(" onReceive error,");
                QLog.w("MsfServletProxy", 2, localStringBuilder.toString(), localException);
              }
            }
          }
          i += 1;
          continue;
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append(" handlerIds no map ");
            paramToServiceMsg.append((String)localObject1);
            QLog.w("MsfServletProxy", 2, paramToServiceMsg.toString());
          }
        }
      }
      return;
    }
    paramException = new StringBuilder();
    paramException.append("handleResponse error req:");
    paramException.append(paramToServiceMsg);
    paramException.append("|");
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = "null";
    } else {
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    }
    paramException.append(paramToServiceMsg);
    AVLog.printAllUserLog("MsfServletProxy", paramException.toString());
  }
  
  public boolean a(String paramString, String[] paramArrayOfString)
  {
    return a(paramString, paramArrayOfString, false);
  }
  
  public boolean a(String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a.put(paramString, paramArrayOfString);
      if (paramBoolean) {
        this.c.add(paramString);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.MsfServletProxy
 * JD-Core Version:    0.7.0.1
 */
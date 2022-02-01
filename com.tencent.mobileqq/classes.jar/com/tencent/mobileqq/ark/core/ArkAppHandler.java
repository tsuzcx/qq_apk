package com.tencent.mobileqq.ark.core;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ArkAppHandler
  extends BusinessHandler
{
  protected static final String a = "com.tencent.mobileqq.ark.core.ArkAppHandler";
  protected static final String[] b = { a };
  
  public ArkAppHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = null;
    try
    {
      paramFromServiceMsg = (Proto.EchoRsp)new Proto.EchoRsp().mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null) {
        return null;
      }
      if (paramFromServiceMsg.msg.has()) {
        paramToServiceMsg = paramFromServiceMsg.msg.get();
      }
      paramFromServiceMsg = paramToServiceMsg;
      if (paramToServiceMsg == null) {
        paramFromServiceMsg = "";
      }
      return paramFromServiceMsg;
    }
    catch (Exception paramToServiceMsg) {}
    return null;
  }
  
  protected final Object a(Object paramObject)
  {
    try
    {
      paramObject = new String((byte[])paramObject, "UTF-8");
    }
    catch (Exception paramObject)
    {
      label20:
      Object localObject;
      break label20;
    }
    QLog.i("ArkApp.BusinessHandler", 1, String.format("onReceive_AppMsg, fail convert data to string", new Object[0]));
    paramObject = null;
    localObject = paramObject;
    if (paramObject == null) {
      localObject = "";
    }
    return localObject;
  }
  
  void a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    paramBusinessObserver = super.createToServiceMsg(paramString, paramBusinessObserver);
    paramBusinessObserver.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
    paramBusinessObserver.addAttribute("IsGenericCmd", Boolean.valueOf(paramBoolean));
    paramBusinessObserver.addAttribute("IsPanelRequest", Boolean.valueOf(false));
    paramBusinessObserver.addAttribute("NotifyType", Integer.valueOf(paramInt2));
    paramBusinessObserver.putWupBuffer(paramArrayOfByte);
    if (paramInt1 > 0) {
      paramBusinessObserver.setTimeout(paramInt1);
    }
    if (!Cmd2HandlerMapHelper.a(paramString)) {
      Cmd2HandlerMapHelper.a(paramString, b);
    }
    super.sendPbReq(paramBusinessObserver);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBusinessObserver != null))
    {
      paramBusinessObserver = super.createToServiceMsg(paramString, paramBusinessObserver);
      paramBusinessObserver.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
      paramBusinessObserver.addAttribute("IsGenericCmd", Boolean.valueOf(true));
      paramBusinessObserver.addAttribute("IsPanelRequest", Boolean.valueOf(true));
      paramBusinessObserver.addAttribute("NotifyType", Integer.valueOf(paramInt2));
      if (paramInt1 > 0) {
        paramBusinessObserver.setTimeout(paramInt1);
      }
      if (!Cmd2HandlerMapHelper.a(paramString)) {
        Cmd2HandlerMapHelper.a(paramString, b);
      }
      super.sendPbReq(paramBusinessObserver);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramBusinessObserver == null) {
        return false;
      }
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
    }
    try
    {
      paramString2 = str.getBytes("UTF-8");
      a(paramString1, true, paramString2, paramInt1, paramInt2, paramBusinessObserver);
      return true;
    }
    catch (Exception paramString2)
    {
      label47:
      break label47;
    }
    QLog.i("ArkApp.BusinessHandler", 1, String.format("sendAppMsg, fail convert content to bytes array, cmd=%s, content=%s", new Object[] { paramString1, str }));
    return false;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    long l1 = ((Long)paramToServiceMsg.getAttribute("SendTime")).longValue();
    long l2 = System.currentTimeMillis();
    boolean bool2 = ((Boolean)paramToServiceMsg.getAttribute("IsGenericCmd")).booleanValue();
    boolean bool3 = ((Boolean)paramToServiceMsg.getAttribute("IsPanelRequest")).booleanValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("NotifyType")).intValue();
    String str = paramFromServiceMsg.getServiceCmd();
    QLog.i("ArkApp.BusinessHandler", 1, String.format("onReceive, cmd=%s, app-msg=%s, panelRequest=%s, suc=%s, delay=%d, ", new Object[] { str, Boolean.toString(bool2), Boolean.toString(bool3), Boolean.toString(bool1), Long.valueOf(l2 - l1) }));
    if (bool1)
    {
      if (bool2)
      {
        if (bool3) {
          break label178;
        }
        paramObject = a(paramObject);
        break label178;
      }
      if (str.equalsIgnoreCase("ArkAppSvc.Echo"))
      {
        paramObject = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        break label178;
      }
    }
    paramObject = null;
    label178:
    if (paramObject != null)
    {
      super.notifyUI(paramToServiceMsg, i, true, paramObject);
      return;
    }
    super.notifyUI(paramToServiceMsg, i, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppHandler
 * JD-Core Version:    0.7.0.1
 */
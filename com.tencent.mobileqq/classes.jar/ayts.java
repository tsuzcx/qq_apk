import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.MobileQQServiceBase.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public abstract class ayts
  implements aljq
{
  public static volatile int a;
  public static HashMap<String, UniPacket> a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap<String, zdf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static boolean a(String paramString)
  {
    return ("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramString)) || ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(paramString)) || ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushC2CMsg".equalsIgnoreCase(paramString)) || ("ImStatus.ReqPushStatus".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(paramString));
  }
  
  public UniPacket a(ToServiceMsg paramToServiceMsg)
  {
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
    {
      String str = paramToServiceMsg.extraData.getString("filepath");
      UniPacket localUniPacket = (UniPacket)jdField_a_of_type_JavaUtilHashMap.get(str);
      Object localObject;
      if (localUniPacket == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQServiceBase", 2, "no saved packet, new one " + str);
        }
        localObject = new aytv(true);
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
      }
      for (;;)
      {
        paramToServiceMsg = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
        int i = azqa.b(str);
        if (paramToServiceMsg.shortValue() <= i)
        {
          jdField_a_of_type_JavaUtilHashMap.remove(str);
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "last stream, remove " + i + ", " + paramToServiceMsg);
          }
        }
        return localObject;
        localObject = localUniPacket;
        if (QLog.isColorLevel())
        {
          QLog.d("MobileQQServiceBase", 2, "got last packet, reuse it " + str);
          localObject = localUniPacket;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MobileQQServiceBase", 2, "not stream ptt");
    }
    return new UniPacket(true);
  }
  
  public abstract AppInterface a();
  
  public zdf a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        a();
      }
      i = paramString.indexOf('.');
      if (i <= 1) {
        return null;
      }
    }
    finally {}
    paramString = paramString.substring(0, i);
    return (zdf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, aoct paramaoct, Class<? extends MSFServlet> paramClass)
  {
    int j = 0;
    int i = 0;
    int k = 0;
    Object localObject2 = null;
    boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    AppInterface localAppInterface = a();
    Object localObject1;
    if (bool)
    {
      localObject1 = localObject2;
      j = i;
      i = k;
      long l;
      if (paramToServiceMsg.getWupBuffer() != null)
      {
        l = paramToServiceMsg.getWupBuffer().length;
        localObject1 = new byte[(int)l + 4];
        bdlr.a((byte[])localObject1, 0, 4L + l);
        bdlr.a((byte[])localObject1, 4, paramToServiceMsg.getWupBuffer(), (int)l);
        paramToServiceMsg.putWupBuffer((byte[])localObject1);
        int m = 1;
        localObject1 = localObject2;
        j = m;
        i = k;
        if (QLog.isColorLevel())
        {
          QLog.d("MobileQQServiceBase", 2, "PB cmd: req cmd: " + paramToServiceMsg.getServiceCmd());
          i = k;
          j = m;
          localObject1 = localObject2;
        }
      }
      if (j != 0)
      {
        paramToServiceMsg.actionListener = paramaoct;
        paramaoct = new NewIntent(localAppInterface.getApplication(), paramClass);
        paramaoct.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
        localAppInterface.startServlet(paramaoct);
        l = System.currentTimeMillis();
        paramToServiceMsg.extraData.putLong("sendtimekey", l);
      }
    }
    else
    {
      label220:
      localObject1 = a(paramToServiceMsg.getServiceCmd());
      if (localObject1 != null)
      {
        localObject2 = a(paramToServiceMsg);
        ((UniPacket)localObject2).setEncodeName("utf-8");
        i = jdField_a_of_type_Int;
        jdField_a_of_type_Int = i + 1;
        ((UniPacket)localObject2).setRequestId(i);
        if (((zdf)localObject1).a())
        {
          localObject2 = ((zdf)localObject1).a(paramToServiceMsg);
          if (localObject2 == null) {
            break label667;
          }
          paramToServiceMsg.putWupBuffer((byte[])localObject2);
        }
      }
    }
    label667:
    for (i = 1;; i = 0)
    {
      k = 1;
      j = i;
      i = k;
      for (;;)
      {
        break;
        if (((zdf)localObject1).a(paramToServiceMsg, (UniPacket)localObject2))
        {
          paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
          j = 1;
          i = 0;
          continue;
          if ("RegPrxySvc.infoSync".equals(paramToServiceMsg.getServiceCmd()))
          {
            QLog.i("MobileQQServiceBase", 1, "infoSync error! lookupCoder is null!");
            localObject2 = (MessageHandler)localAppInterface.getBusinessHandler(0);
            if (localObject2 != null)
            {
              ((MessageHandler)localObject2).notifyUI(4004, false, null);
              QLog.i("jensenweng", 1, "notifyUI failed!");
            }
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_uin", localAppInterface.getCurrentAccountUin());
            if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().size() > 0)) {
              ((HashMap)localObject2).put("param_coderMap", this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().toString());
            }
            azmz.a(BaseApplication.getContext()).a(null, "prxyLookupCoderNull", true, 0L, 0L, (HashMap)localObject2, null);
          }
          j = i;
          i = k;
          break;
          if ((!bool) && ((localObject1 == null) || (i != 0))) {
            break label220;
          }
          paramaoct = new FromServiceMsg(localAppInterface.getCurrentAccountUin(), paramToServiceMsg.getServiceCmd());
          paramClass = (int[])allh.a().get(paramToServiceMsg.getServiceCmd());
          if ((paramClass == null) || (paramClass.length <= 0)) {
            break label220;
          }
          j = paramClass.length;
          i = 0;
          label559:
          if (i < j)
          {
            localObject1 = (alko)localAppInterface.getBusinessHandler(paramClass[i]);
            if ((localObject1 != null) && (!bool)) {
              break label599;
            }
          }
          for (;;)
          {
            i += 1;
            break label559;
            break;
            try
            {
              label599:
              ((alko)localObject1).onReceive(paramToServiceMsg, paramaoct, null);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              QLog.w("MobileQQServiceBase", 2, localObject1.getClass().getSimpleName() + " onReceive error,", localException);
            }
          }
        }
        i = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    AppInterface localAppInterface = a();
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    label108:
    Object localObject;
    alko localalko;
    boolean bool;
    label173:
    int i;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceBase", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
      }
      localObject = null;
      localalko = null;
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if (QLog.isDevelopLevel()) {
        QLog.d("MobileQQServiceBase", 4, "bPbResp:" + bool);
      }
      if (bool) {
        break label703;
      }
      bool = a(paramFromServiceMsg.getServiceCmd());
      paramException = (IBaseActionListener)paramToServiceMsg.getAttribute("listener");
      if (paramException != null) {
        paramToServiceMsg.actionListener = paramException;
      }
      if (!bool) {
        localObject = a(paramFromServiceMsg.getServiceCmd());
      }
      paramException = localalko;
      if (paramBoolean)
      {
        if (!bool) {
          break label572;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQServiceBase", 2, "PB cmd: recv cmd: " + paramFromServiceMsg.getServiceCmd());
        }
        paramException = localalko;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramException = new byte[i];
          bdlr.a(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
    }
    label572:
    label703:
    label706:
    for (;;)
    {
      for (;;)
      {
        a(paramFromServiceMsg);
        if ((!bool) && (localObject == null)) {
          break;
        }
        localObject = (int[])allh.a().get(paramFromServiceMsg.getServiceCmd());
        if ((localObject == null) || (localObject.length <= 0)) {
          break;
        }
        int j = localObject.length;
        i = 0;
        label361:
        if (i >= j) {
          break;
        }
        localalko = (alko)localAppInterface.getBusinessHandler(localObject[i]);
        if (localalko != null) {}
        try
        {
          localalko.onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
          i += 1;
          break label361;
          if (paramException != null)
          {
            localObject = new ByteArrayOutputStream();
            paramException.printStackTrace(new PrintStream((OutputStream)localObject));
            paramException = new String(((ByteArrayOutputStream)localObject).toByteArray());
            if (!QLog.isColorLevel()) {
              break label108;
            }
            QLog.d("MobileQQServiceBase", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
            break label108;
          }
          if (!QLog.isColorLevel()) {
            break label108;
          }
          QLog.w("MobileQQServiceBase", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
          break label108;
          if (localObject != null) {}
          try
          {
            ((zdf)localObject).a(paramToServiceMsg, paramFromServiceMsg);
            paramException = ((zdf)localObject).a(paramToServiceMsg, paramFromServiceMsg);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            paramException = localalko;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "bpc null");
          }
          paramException = null;
          break label706;
          if (QLog.isColorLevel())
          {
            QLog.d("MobileQQServiceBase", 2, "", localException1);
            paramException = localalko;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("MobileQQServiceBase", 2, localalko.getClass().getSimpleName() + " onReceive error,", localException2);
            }
          }
        }
      }
      break label173;
    }
  }
  
  protected boolean a(zdf paramzdf)
  {
    int i = 0;
    String[] arrayOfString = paramzdf.a();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(arrayOfString[i], paramzdf);
      i += 1;
    }
    return true;
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, aoct paramaoct, Class<? extends MSFServlet> paramClass)
  {
    paramToServiceMsg = new MobileQQServiceBase.1(this, paramToServiceMsg, paramaoct, paramClass);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramToServiceMsg, 10, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  public void c()
  {
    e();
  }
  
  protected void d()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (zdf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null)
        {
          try
          {
            ((zdf)localObject).a();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "bpc destory error " + localException, localException);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayts
 * JD-Core Version:    0.7.0.1
 */
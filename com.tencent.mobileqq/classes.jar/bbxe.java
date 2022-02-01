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

public abstract class bbxe
  implements anhk
{
  public static volatile int a;
  public static HashMap<String, UniPacket> a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap<String, aber> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static boolean a(String paramString)
  {
    return ("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramString)) || ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(paramString)) || ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushC2CMsg".equalsIgnoreCase(paramString)) || ("ImStatus.ReqPushStatus".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(paramString));
  }
  
  public aber a(String paramString)
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
    return (aber)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
        localObject = new bbxi(true);
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
      }
      for (;;)
      {
        int i = paramToServiceMsg.extraData.getShort("PackSeq");
        int j = bcvj.b(str);
        if (i <= j)
        {
          jdField_a_of_type_JavaUtilHashMap.remove(str);
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "last stream, remove " + j + ", " + i);
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
  
  public void a(ToServiceMsg paramToServiceMsg, aqhm paramaqhm, Class<? extends MSFServlet> paramClass)
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
        bgva.a((byte[])localObject1, 0, 4L + l);
        bgva.a((byte[])localObject1, 4, paramToServiceMsg.getWupBuffer(), (int)l);
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
        paramToServiceMsg.actionListener = paramaqhm;
        paramaqhm = new NewIntent(localAppInterface.getApplication(), paramClass);
        paramaqhm.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
        localAppInterface.startServlet(paramaqhm);
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
        if (((aber)localObject1).a())
        {
          localObject2 = ((aber)localObject1).a(paramToServiceMsg);
          if (localObject2 == null) {
            break label666;
          }
          paramToServiceMsg.putWupBuffer((byte[])localObject2);
        }
      }
    }
    label666:
    for (i = 1;; i = 0)
    {
      k = 1;
      j = i;
      i = k;
      for (;;)
      {
        break;
        if (((aber)localObject1).a(paramToServiceMsg, (UniPacket)localObject2))
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
            bctj.a(BaseApplication.getContext()).a(null, "prxyLookupCoderNull", true, 0L, 0L, (HashMap)localObject2, null);
          }
          j = i;
          i = k;
          break;
          if ((!bool) && ((localObject1 == null) || (i != 0))) {
            break label220;
          }
          paramaqhm = new FromServiceMsg(localAppInterface.getCurrentAccountUin(), paramToServiceMsg.getServiceCmd());
          paramClass = (int[])anjf.a().get(paramToServiceMsg.getServiceCmd());
          if ((paramClass == null) || (paramClass.length <= 0)) {
            break label220;
          }
          j = paramClass.length;
          i = 0;
          label558:
          if (i < j)
          {
            localObject1 = (anii)localAppInterface.getBusinessHandler(paramClass[i]);
            if ((localObject1 != null) && (!bool)) {
              break label598;
            }
          }
          for (;;)
          {
            i += 1;
            break label558;
            break;
            try
            {
              label598:
              ((anii)localObject1).onReceive(paramToServiceMsg, paramaqhm, null);
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
    anii localanii;
    boolean bool;
    label173:
    int i;
    int j;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceBase", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
      }
      localObject = null;
      localanii = null;
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if (QLog.isDevelopLevel()) {
        QLog.d("MobileQQServiceBase", 4, "bPbResp:" + bool);
      }
      if (bool) {
        break label718;
      }
      bool = a(paramFromServiceMsg.getServiceCmd());
      paramException = (IBaseActionListener)paramToServiceMsg.getAttribute("listener");
      if (paramException != null) {
        paramToServiceMsg.actionListener = paramException;
      }
      if (!bool) {
        localObject = a(paramFromServiceMsg.getServiceCmd());
      }
      paramException = localanii;
      if (paramBoolean)
      {
        if (!bool) {
          break label587;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQServiceBase", 2, "PB cmd: recv cmd: " + paramFromServiceMsg.getServiceCmd());
        }
        paramException = localanii;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          i = paramFromServiceMsg.extraData.getInt("pb_msg_offset", 4);
          j = paramFromServiceMsg.getWupBuffer().length - i;
          paramException = new byte[j];
          bgva.a(paramException, 0, paramFromServiceMsg.getWupBuffer(), i, j);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
    }
    label587:
    label718:
    label721:
    for (;;)
    {
      for (;;)
      {
        a(paramFromServiceMsg);
        if ((!bool) && (localObject == null)) {
          break;
        }
        localObject = (int[])anjf.a().get(paramFromServiceMsg.getServiceCmd());
        if ((localObject == null) || (localObject.length <= 0)) {
          break;
        }
        j = localObject.length;
        i = 0;
        label376:
        if (i >= j) {
          break;
        }
        localanii = (anii)localAppInterface.getBusinessHandler(localObject[i]);
        if (localanii != null) {}
        try
        {
          localanii.onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
          i += 1;
          break label376;
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
            ((aber)localObject).a(paramToServiceMsg, paramFromServiceMsg);
            paramException = ((aber)localObject).a(paramToServiceMsg, paramFromServiceMsg);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            paramException = localanii;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "bpc null");
          }
          paramException = null;
          break label721;
          if (QLog.isColorLevel())
          {
            QLog.d("MobileQQServiceBase", 2, "", localException1);
            paramException = localanii;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("MobileQQServiceBase", 2, localanii.getClass().getSimpleName() + " onReceive error,", localException2);
            }
          }
        }
      }
      break label173;
    }
  }
  
  protected boolean a(aber paramaber)
  {
    int i = 0;
    String[] arrayOfString = paramaber.a();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(arrayOfString[i], paramaber);
      i += 1;
    }
    return true;
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, aqhm paramaqhm, Class<? extends MSFServlet> paramClass)
  {
    paramToServiceMsg = new MobileQQServiceBase.1(this, paramToServiceMsg, paramaqhm, paramClass);
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
        localObject = (aber)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null)
        {
          try
          {
            ((aber)localObject).a();
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
 * Qualified Name:     bbxe
 * JD-Core Version:    0.7.0.1
 */
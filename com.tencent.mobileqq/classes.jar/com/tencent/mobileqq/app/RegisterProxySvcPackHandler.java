package com.tencent.mobileqq.app;

import IPwdPxyMQQ.RespondQueryIPwdStat;
import RegisterProxySvcPack.OnlineInfos;
import RegisterProxySvcPack.SvcRespParam;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.statsvc.getonline.StatSvcGetOnline.Instance;
import tencent.im.statsvc.getonline.StatSvcGetOnline.ReqBody;
import tencent.im.statsvc.getonline.StatSvcGetOnline.RspBody;
import ziy;

public class RegisterProxySvcPackHandler
  extends BusinessHandler
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Handler a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int d = 1;
  private int e = 1;
  private int f;
  private int g = 1;
  
  RegisterProxySvcPackHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new ziy(this, Looper.getMainLooper());
  }
  
  public int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long a()
  {
    try
    {
      long l = this.jdField_a_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected Class a()
  {
    return RegisterProxySvcPackObserver.class;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      QLog.d("RegisterProxySvcPack", 2, "setSelfPcSuppViewPcVersion:" + paramLong);
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoAndroid")) {
      QLog.d("RegisterProxySvcPack", 2, "resp of RegPrxySvc.infoAndroid");
    }
    label142:
    label273:
    label282:
    label466:
    boolean bool;
    label492:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PushParam"))
              {
                if (paramObject != null)
                {
                  paramObject = (SvcRespParam)paramObject;
                  d(paramObject.iIsSupportDataLine);
                  e(paramObject.iIsSupportPrintable);
                  f(paramObject.iIsSupportViewPCFile);
                  a(paramObject.iPcVersion);
                  d(paramObject.uRoamFlag);
                  ArrayList localArrayList = paramObject.onlineinfos;
                  paramFromServiceMsg = null;
                  paramToServiceMsg = null;
                  if (localArrayList == null) {
                    break label832;
                  }
                  i = 0;
                  paramFromServiceMsg = paramToServiceMsg;
                  if (i >= localArrayList.size()) {
                    break label832;
                  }
                  paramFromServiceMsg = (OnlineInfos)localArrayList.get(i);
                  if (paramFromServiceMsg.clienType == 9)
                  {
                    i = paramFromServiceMsg.onlineStatus;
                    b(i);
                    if ((paramToServiceMsg == null) || (paramToServiceMsg.onlineStatus != 1)) {
                      break label282;
                    }
                    a(1);
                    b(66831L);
                    c(paramToServiceMsg.instanceId);
                  }
                  for (;;)
                  {
                    d();
                    QLog.d("RegisterProxySvcPack", 2, "online status of pc: state:" + paramObject.PCstat + "- ram:" + paramObject.iIsSupportC2CRoamMsg + "- supportdataline:" + paramObject.iIsSupportDataLine + "- PcVersion:" + paramObject.iPcVersion + "- uRoamFlag:" + paramObject.uRoamFlag);
                    return;
                    if (paramFromServiceMsg.clienType != 15) {
                      break label829;
                    }
                    paramToServiceMsg = paramFromServiceMsg;
                    i += 1;
                    break;
                    if ((paramObject.iPCClientType == 65793) || (paramObject.iPCClientType == 77313))
                    {
                      i = paramObject.PCstat;
                      if (paramObject.iIsSupportDataLine == 2) {
                        i = 0;
                      }
                      a(i);
                      if (i == 1)
                      {
                        b(paramObject.iPCClientType);
                        c(1L);
                      }
                      a(1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramObject.iIsSupportDataLine) });
                    }
                  }
                }
                QLog.d("RegisterProxySvcPack", 2, "RegPrxySvc.PushParam is null");
                return;
              }
              if (!paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.QueryIpwdStat")) {
                break label466;
              }
              if (paramObject == null) {
                break;
              }
              paramToServiceMsg = (RespondQueryIPwdStat)paramObject;
            } while (paramToServiceMsg == null);
            e(paramToServiceMsg.uIsSetPwd);
          } while (!QLog.isColorLevel());
          QLog.d("RegisterProxySvcPack", 2, "QueryIPwdStat:" + paramToServiceMsg.uIsSetPwd);
          return;
        } while (!QLog.isColorLevel());
        QLog.d("RegisterProxySvcPack", 2, "IPwdPxyMQQ.RespondQueryIPwdStat is null");
        return;
      } while (!paramFromServiceMsg.getServiceCmd().equals("StatSvc.GetOnlineStatus"));
      if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        break;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, "CMD_GET_SELFPCSTATUS_KICKED onReceive :" + bool);
      }
    } while (!bool);
    for (;;)
    {
      try
      {
        paramToServiceMsg = new StatSvcGetOnline.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        int j = paramToServiceMsg.error_code.get();
        if (j != 0) {
          break label774;
        }
        if (QLog.isColorLevel()) {
          QLog.e("RegisterProxySvcPack", 2, "errorCode: " + j);
        }
        if (i == 0) {
          break label780;
        }
        if ((!paramToServiceMsg.uint64_uin.has()) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() != paramToServiceMsg.uint64_uin.get()) || (!paramToServiceMsg.msg_instances.has())) {
          break;
        }
        paramToServiceMsg = paramToServiceMsg.msg_instances.get().iterator();
        if (!paramToServiceMsg.hasNext()) {
          break;
        }
        paramFromServiceMsg = (StatSvcGetOnline.Instance)paramToServiceMsg.next();
        if (paramFromServiceMsg == null) {
          continue;
        }
        i = paramFromServiceMsg.uint32_client_type.get();
        if (!QLog.isColorLevel()) {
          break label840;
        }
        QLog.e("RegisterProxySvcPack", 2, "uint32_client_type: " + i);
      }
      catch (Exception paramToServiceMsg) {}
      a(1);
      b(i);
      c(paramFromServiceMsg.uint32_instance_id.get());
      d();
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("RegisterProxySvcPack", 2, "CMD_GET_SELFPCSTATUS_KICKED onReceive fail: ", paramToServiceMsg);
      return;
      bool = false;
      break label492;
      label774:
      i = 0;
      continue;
      label780:
      if ((!paramToServiceMsg.error_msg.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("RegisterProxySvcPack", 2, "err msg: " + paramToServiceMsg.error_msg.get());
      return;
      label829:
      break label273;
      label832:
      i = 0;
      paramToServiceMsg = paramFromServiceMsg;
      break label142;
      label840:
      if ((i != 65793) && (i != 77313)) {
        if (i != 66831) {}
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int b()
  {
    try
    {
      int i = this.jdField_b_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    a(a("RegPrxySvc.infoAndroid"));
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(long paramLong)
  {
    try
    {
      this.jdField_b_of_type_Long = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    StatSvcGetOnline.ReqBody localReqBody = new StatSvcGetOnline.ReqBody();
    localReqBody.uint64_uin.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localReqBody.uint32_appid.set(0);
    ToServiceMsg localToServiceMsg = a("StatSvc.GetOnlineStatus");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    a(localToServiceMsg);
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(long paramLong)
  {
    try
    {
      this.jdField_c_of_type_Long = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxySvcPack", 2, "iState:" + this.jdField_a_of_type_Int + ", clientType:" + this.jdField_b_of_type_Long + ", appId:" + this.jdField_c_of_type_Long);
    }
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(102)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 500L);
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void d(long paramLong)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: lload_1
    //   5: lconst_1
    //   6: land
    //   7: lconst_1
    //   8: lcmp
    //   9: ifeq +15 -> 24
    //   12: lload_1
    //   13: ldc2_w 386
    //   16: land
    //   17: ldc2_w 386
    //   20: lcmp
    //   21: ifne +77 -> 98
    //   24: iconst_4
    //   25: istore_3
    //   26: aload_0
    //   27: getfield 261	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: ifnull +102 -> 132
    //   33: iload_3
    //   34: iconst_m1
    //   35: if_icmpeq +97 -> 132
    //   38: aload_0
    //   39: getfield 261	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 391	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   45: ldc_w 393
    //   48: iconst_0
    //   49: invokevirtual 399	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   52: invokeinterface 405 1 0
    //   57: new 60	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 407
    //   67: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_0
    //   71: getfield 261	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   74: invokevirtual 410	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   77: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: iload_3
    //   84: invokeinterface 416 3 0
    //   89: invokeinterface 419 1 0
    //   94: pop
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: lload_1
    //   99: ldc2_w 420
    //   102: land
    //   103: ldc2_w 420
    //   106: lcmp
    //   107: ifne +8 -> 115
    //   110: iconst_3
    //   111: istore_3
    //   112: goto -86 -> 26
    //   115: lload_1
    //   116: ldc2_w 422
    //   119: land
    //   120: ldc2_w 422
    //   123: lcmp
    //   124: ifeq -98 -> 26
    //   127: iconst_1
    //   128: istore_3
    //   129: goto -103 -> 26
    //   132: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq -40 -> 95
    //   138: ldc 58
    //   140: iconst_2
    //   141: new 60	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 425
    //   151: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: iload_3
    //   155: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: goto -69 -> 95
    //   167: astore 4
    //   169: aload_0
    //   170: monitorexit
    //   171: aload 4
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	RegisterProxySvcPackHandler
    //   0	174	1	paramLong	long
    //   1	154	3	i	int
    //   167	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	33	167	finally
    //   38	95	167	finally
    //   132	164	167	finally
  }
  
  public void e(int paramInt)
  {
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label166;
        }
        QLog.d("RegisterProxySvcPack", 2, "uIsSetPwd = " + paramLong);
      }
      finally {}
      if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (i != -1))
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_is_set_password" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i).commit();
        return;
        if (paramLong != 2L) {
          i = -1;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("RegisterProxySvcPack", 2, "RegisterProxySvcPackHandler.app is null or isSetPassword is error ,isSetPassword = " + i);
        continue;
        label166:
        if (paramLong != 1L) {
          break;
        }
        i = 1;
      }
    }
  }
  
  public int f()
  {
    try
    {
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f(int paramInt)
  {
    try
    {
      this.g = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int g()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int h()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int i()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RegisterProxySvcPackHandler
 * JD-Core Version:    0.7.0.1
 */
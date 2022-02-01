package com.tencent.mobileqq.app;

import android.os.Build.VERSION;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.comering_req;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.comering_rsp;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.plat_info;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.req;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class PPCLoginAuthHandler
  extends BusinessHandler
{
  private long a;
  protected QQAppInterface a;
  
  protected PPCLoginAuthHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    PPCLoginAuth.plat_info localplat_info = new PPCLoginAuth.plat_info();
    localplat_info.implat.set(109L);
    localplat_info.mqqver.set("8.7.0.5295");
    localplat_info.osver.set(Build.VERSION.RELEASE);
    PPCLoginAuth.comering_req localcomering_req = new PPCLoginAuth.comering_req();
    localcomering_req.id.set(String.valueOf(this.jdField_a_of_type_Long));
    PPCLoginAuth.req localreq = new PPCLoginAuth.req();
    localreq.comm.set(localplat_info);
    localreq.reqcmd_0x01.set(localcomering_req);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "Loginauth.1");
    ((ToServiceMsg)localObject).putWupBuffer(localreq.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPbReq called. req=");
      ((StringBuilder)localObject).append(localreq.toString());
      QLog.i("PPCLoginAuthHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramToServiceMsg = new PPCLoginAuth.rsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.ret.get() == 0L) && (((PPCLoginAuth.comering_rsp)paramToServiceMsg.rspcmd_0x01.get()).ret.get() != 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new PPCLoginAuthHandler.1(this));
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getCurrentAccountUin()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)((EntityManager)localObject).find(ExtensionInfo.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ((EntityManager)localObject).close();
    if ((localExtensionInfo != null) && (localExtensionInfo.commingRingId != 0L))
    {
      this.jdField_a_of_type_Long = localExtensionInfo.commingRingId;
      a();
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Loginauth.1".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PPCLoginAuthHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.PPCLoginAuthHandler
 * JD-Core Version:    0.7.0.1
 */
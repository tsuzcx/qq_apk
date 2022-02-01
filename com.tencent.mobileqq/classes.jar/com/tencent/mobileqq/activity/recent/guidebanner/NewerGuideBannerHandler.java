package com.tencent.mobileqq.activity.recent.guidebanner;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.ReqBody;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NewerGuideBannerHandler
  extends BusinessHandler
{
  protected NewerGuideBannerHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      localObject = null;
      bool2 = bool1;
      paramFromServiceMsg = localObject;
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        paramObject = new oidb_0x59f.RspBody();
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (!paramObject.msg_guidelines8410.has()) {
          continue;
        }
        paramFromServiceMsg = (oidb_0x59f.Guidelines_8410)paramObject.msg_guidelines8410.get();
        bool1 = true;
        bool2 = bool1;
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.d("NewerGuideBannerHandler", 1, "handlerGetNewerGuideBannerInfo failed", paramFromServiceMsg);
        bool2 = false;
        paramFromServiceMsg = localObject;
        continue;
      }
      QLog.d("NewerGuideBannerHandler", 1, "handlerGetNewerGuideBannerInfo, result " + bool2);
      notifyUI(0, bool2, paramFromServiceMsg);
      return;
      bool1 = false;
      break;
      QLog.d("NewerGuideBannerHandler", 1, "[handlerGetNewerGuideBannerInfo] msg_guidelines8410 does not exist");
      paramFromServiceMsg = null;
      bool1 = false;
    }
  }
  
  void a()
  {
    QLog.d("NewerGuideBannerHandler", 1, "requestGetNewerGuideBannerInfo");
    oidb_0x59f.ReqBody localReqBody = new oidb_0x59f.ReqBody();
    boolean bool = ((PhoneContactManagerImp)this.appRuntime.getManager(QQManagerFactory.CONTACT_MANAGER)).k();
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_contact_right;
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      sendPbReq(makeOIDBPkg("OidbSvc.0x59f_newer_guide_banner", 1439, 1, localReqBody.toByteArray()));
      return;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return NewerGuideBannerObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (TextUtils.equals("OidbSvc.0x59f_newer_guide_banner", paramFromServiceMsg.getServiceCmd()))) {
      a(paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerHandler
 * JD-Core Version:    0.7.0.1
 */
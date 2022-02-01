package com.tencent.mobileqq.app.automator.step;

import bctj;
import beaw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;

public class GetConfig$1
  implements Runnable
{
  GetConfig$1(GetConfig paramGetConfig) {}
  
  public void run()
  {
    TVK_SDKMgr.initSdk(BaseApplication.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (!TVK_SDKMgr.isInstalled(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "init TVK_SDKMgr SDK");
      }
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      bctj.a(BaseApplication.getContext()).a(null, "actSDKPredownload", true, 0L, 0L, (HashMap)localObject, "");
    }
    Object localObject = (beaw)this.this$0.a.app.getManager(193);
    if (((beaw)localObject).a()) {
      ((beaw)localObject).a("http://tvk_sdkmgr/unkown", -1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig.1
 * JD-Core Version:    0.7.0.1
 */
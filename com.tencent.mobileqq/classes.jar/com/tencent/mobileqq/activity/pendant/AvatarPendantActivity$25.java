package com.tencent.mobileqq.activity.pendant;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AvatarPendantActivity$25
  extends AvatarObserver
{
  AvatarPendantActivity$25(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting != null) && (this.a.L != null) && (this.a.L.uin.equals(paramSetting.uin)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetHeadInfo: uin=");
        ((StringBuilder)localObject).append(paramSetting.uin);
        QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
      }
      AvatarPendantActivity.g(this.a);
      if (!this.a.isResume()) {
        AvatarPendantActivity.a(this.a, true);
      }
      String str = AvatarDownloadUtil.get1080QQHeadDownLoadUrl(paramSetting.url, paramSetting.bFaceFlags);
      Object localObject = str;
      if (!TextUtils.isEmpty(str)) {
        localObject = MsfSdkUtils.insertMtype("QQHeadIcon", str);
      }
      this.a.ag = paramSetting.headImgTimestamp;
      ThreadManager.getUIHandler().post(new AvatarPendantActivity.25.2(this, (String)localObject));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHeadInfo， fail");
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    AvatarPendantActivity.g(this.a);
    if (!this.a.isResume()) {
      AvatarPendantActivity.a(this.a, true);
    }
    if (paramBoolean) {
      ThreadManager.excute(new AvatarPendantActivity.25.1(this), 32, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.25
 * JD-Core Version:    0.7.0.1
 */
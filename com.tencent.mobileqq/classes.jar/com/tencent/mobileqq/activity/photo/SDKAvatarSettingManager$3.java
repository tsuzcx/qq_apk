package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;

class SDKAvatarSettingManager$3
  extends ProtoUtils.TroopProtocolObserver
{
  SDKAvatarSettingManager$3(SDKAvatarSettingManager paramSDKAvatarSettingManager) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((SDKAvatarSettingManager.a(this.a).isFinishing()) || (this.a.a)) {
      return;
    }
    this.a.d();
    if (SDKAvatarSettingManager.a(this.a) != null) {
      SDKAvatarSettingManager.a(this.a).removeCallbacks(SDKAvatarSettingManager.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.e();
      return;
    }
    SDKAvatarSettingManager.a(this.a, SDKAvatarSettingManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.3
 * JD-Core Version:    0.7.0.1
 */
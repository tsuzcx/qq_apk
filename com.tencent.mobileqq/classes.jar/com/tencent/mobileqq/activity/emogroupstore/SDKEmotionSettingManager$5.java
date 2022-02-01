package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SDKEmotionSettingManager$5
  extends ProtoUtils.TroopProtocolObserver
{
  SDKEmotionSettingManager$5(SDKEmotionSettingManager paramSDKEmotionSettingManager) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction checkOpenidDiff errorCode =" + paramInt);
    if ((SDKEmotionSettingManager.a(this.a).isFinishing()) || (this.a.a))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
      return;
    }
    this.a.c();
    if (SDKEmotionSettingManager.a(this.a) != null) {
      SDKEmotionSettingManager.a(this.a).removeCallbacks(SDKEmotionSettingManager.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.d();
      return;
    }
    SDKEmotionSettingManager.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.5
 * JD-Core Version:    0.7.0.1
 */
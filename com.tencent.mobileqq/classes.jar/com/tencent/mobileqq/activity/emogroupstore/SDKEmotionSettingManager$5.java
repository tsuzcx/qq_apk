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
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(" checkJumpAction checkOpenidDiff errorCode =");
    paramArrayOfByte.append(paramInt);
    QLog.i("SDKEmotionSettingManager", 1, paramArrayOfByte.toString());
    if ((!SDKEmotionSettingManager.a(this.a).isFinishing()) && (!this.a.a))
    {
      this.a.d();
      if (SDKEmotionSettingManager.e(this.a) != null) {
        SDKEmotionSettingManager.e(this.a).removeCallbacks(SDKEmotionSettingManager.i(this.a));
      }
      if (paramInt == 16)
      {
        this.a.e();
        return;
      }
      SDKEmotionSettingManager.j(this.a);
      return;
    }
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.5
 * JD-Core Version:    0.7.0.1
 */
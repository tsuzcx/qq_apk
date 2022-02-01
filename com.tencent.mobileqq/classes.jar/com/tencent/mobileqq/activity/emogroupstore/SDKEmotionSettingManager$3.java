package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class SDKEmotionSettingManager$3
  implements APICallback
{
  SDKEmotionSettingManager$3(SDKEmotionSettingManager paramSDKEmotionSettingManager, String paramString) {}
  
  public void a()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void a(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if (!SDKEmotionSettingManager.a(this.b).isFinishing())
    {
      if (this.b.b) {
        return;
      }
      this.b.d();
      if (SDKEmotionSettingManager.e(this.b) != null) {
        SDKEmotionSettingManager.e(this.b).removeCallbacks(SDKEmotionSettingManager.f(this.b));
      }
      this.b.a(HardCodeUtil.a(2131911073), this.a);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((!SDKEmotionSettingManager.a(this.b).isFinishing()) && (!this.b.b))
    {
      this.b.d();
      if (SDKEmotionSettingManager.e(this.b) != null) {
        SDKEmotionSettingManager.e(this.b).removeCallbacks(SDKEmotionSettingManager.f(this.b));
      }
      this.b.a(HardCodeUtil.a(2131911072), this.a);
      return;
    }
    QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if (!SDKEmotionSettingManager.a(this.b).isFinishing())
    {
      if (this.b.b) {
        return;
      }
      if (SDKEmotionSettingManager.e(this.b) != null) {
        SDKEmotionSettingManager.e(this.b).removeCallbacks(SDKEmotionSettingManager.f(this.b));
      }
      SDKEmotionSettingManager.g(this.b);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.3
 * JD-Core Version:    0.7.0.1
 */
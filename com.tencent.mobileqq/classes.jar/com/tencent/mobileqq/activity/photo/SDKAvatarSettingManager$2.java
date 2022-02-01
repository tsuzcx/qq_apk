package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class SDKAvatarSettingManager$2
  implements APICallback
{
  SDKAvatarSettingManager$2(SDKAvatarSettingManager paramSDKAvatarSettingManager, String paramString) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onComplete");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if (!SDKAvatarSettingManager.a(this.b).isFinishing())
    {
      if (this.b.b) {
        return;
      }
      this.b.d();
      if (SDKAvatarSettingManager.b(this.b) != null) {
        SDKAvatarSettingManager.b(this.b).removeCallbacks(SDKAvatarSettingManager.c(this.b));
      }
      this.b.a(HardCodeUtil.a(2131911065), this.a);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
    if (!SDKAvatarSettingManager.a(this.b).isFinishing())
    {
      if (this.b.b) {
        return;
      }
      this.b.d();
      if (SDKAvatarSettingManager.b(this.b) != null) {
        SDKAvatarSettingManager.b(this.b).removeCallbacks(SDKAvatarSettingManager.c(this.b));
      }
      this.b.a(HardCodeUtil.a(2131911061), this.a);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if (!SDKAvatarSettingManager.a(this.b).isFinishing())
    {
      if (this.b.b) {
        return;
      }
      if (SDKAvatarSettingManager.b(this.b) != null) {
        SDKAvatarSettingManager.b(this.b).removeCallbacks(SDKAvatarSettingManager.c(this.b));
      }
      SDKAvatarSettingManager.d(this.b);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.2
 * JD-Core Version:    0.7.0.1
 */
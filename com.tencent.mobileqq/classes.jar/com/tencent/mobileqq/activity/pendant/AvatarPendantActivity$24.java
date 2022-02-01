package com.tencent.mobileqq.activity.pendant;

import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;

class AvatarPendantActivity$24
  extends CallBacker
{
  AvatarPendantActivity$24(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 1000L) && (paramString1.equals("pendant_market_json.android.v2")))
    {
      if (paramInt1 == 0) {
        this.a.g();
      }
    }
    else if ((paramLong == 23L) && (paramString1.equals("avatarInPendant_json")) && (paramInt1 == 0)) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.24
 * JD-Core Version:    0.7.0.1
 */
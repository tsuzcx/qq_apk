package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.jetbrains.annotations.Nullable;

class ChatSettingActivity$4
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ChatSettingActivity$4(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2) {}
  
  public void onLoadUserInfoSucceed(@Nullable String paramString, @Nullable ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (TextUtils.equals(paramString, ChatSettingActivity.a(this.a))) {
      ChatSettingActivity.b(this.a, ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getResultFaceUrl(paramReadInJoyUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */
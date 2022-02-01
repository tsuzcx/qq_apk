package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

class RIJPrivateChatHeadIconController$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  RIJPrivateChatHeadIconController$1(RIJPrivateChatHeadIconController paramRIJPrivateChatHeadIconController) {}
  
  public void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2) {}
  
  public void onLoadUserInfoSucceed(@Nullable String paramString, @Nullable ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (TextUtils.equals(paramString, RIJPrivateChatHeadIconController.a(this.a).senderuin)) {
      ThreadManager.getUIHandler().post(new RIJPrivateChatHeadIconController.1.1(this, paramReadInJoyUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.RIJPrivateChatHeadIconController.1
 * JD-Core Version:    0.7.0.1
 */
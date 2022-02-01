package com.tencent.mobileqq.activity.home;

import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetStateBannerProcessor;
import com.tencent.mobileqq.app.utils.NicknameAppendNetStateUtil;
import com.tencent.mobileqq.banner.BannerListener;
import com.tencent.mobileqq.banner.BannerManager;

class Conversation$1
  implements BannerListener
{
  Conversation$1(Conversation paramConversation) {}
  
  public void a(int paramInt)
  {
    if (((paramInt == IllegalNetworkBannerProcessor.a) || (paramInt == NetStateBannerProcessor.a)) && (Conversation.a(this.a) != null) && (Conversation.a(this.a).equals(Conversation.b(this.a).getText().toString()))) {
      NicknameAppendNetStateUtil.a(this.a.aF, Conversation.b(this.a), Conversation.a(this.a));
    }
  }
  
  public void b(int paramInt)
  {
    if (((paramInt == IllegalNetworkBannerProcessor.a) || (paramInt == NetStateBannerProcessor.a)) && (this.a.y != null) && (this.a.y.b(IllegalNetworkBannerProcessor.a) != 2) && (this.a.y.b(NetStateBannerProcessor.a) != 2) && (Conversation.a(this.a) != null) && (!Conversation.a(this.a).equals(Conversation.b(this.a).getText().toString()))) {
      Conversation.b(this.a).setText(Conversation.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.1
 * JD-Core Version:    0.7.0.1
 */
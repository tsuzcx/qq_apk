package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.guild.navigatebar.GuildLiveAioTips;
import com.tencent.mobileqq.widget.GuildLiveScrollerRunnable;
import java.util.Observer;

public class GuildLiveChannelScroller
  extends GuildScroller
{
  public void a(AIOContext paramAIOContext, ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1, AIOFooterViewDetector paramAIOFooterViewDetector)
  {
    super.a(paramAIOContext, paramChatXListView, paramChatAdapter1, paramAIOFooterViewDetector);
    this.d = new GuildLiveScrollerRunnable(paramChatXListView);
  }
  
  public void a(Observer paramObserver, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1)
  {
    if (this.e == null) {
      this.e = new GuildLiveAioTips(this.a);
    }
    super.a(paramObserver, paramRelativeLayout, paramChatAdapter1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.GuildLiveChannelScroller
 * JD-Core Version:    0.7.0.1
 */
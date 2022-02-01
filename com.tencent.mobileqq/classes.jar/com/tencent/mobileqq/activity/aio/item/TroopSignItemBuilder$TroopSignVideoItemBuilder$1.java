package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie.OnListViewScrollStateListener;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;

class TroopSignItemBuilder$TroopSignVideoItemBuilder$1
  implements TroopChatPie.OnListViewScrollStateListener
{
  TroopSignItemBuilder$TroopSignVideoItemBuilder$1(TroopSignItemBuilder.TroopSignVideoItemBuilder paramTroopSignVideoItemBuilder, TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder paramSignVideoItemHolder, BaseChatItemLayout paramBaseChatItemLayout) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.v.m();
      TroopSignItemBuilder.TroopSignVideoItemBuilder.i().removeCallbacksAndMessages(null);
      return;
    }
    if (this.b.getParent() != null)
    {
      TroopSignItemBuilder.TroopSignVideoItemBuilder.j().postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.1.1(this), 200L);
      return;
    }
    this.a.v.a();
    this.a.w.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
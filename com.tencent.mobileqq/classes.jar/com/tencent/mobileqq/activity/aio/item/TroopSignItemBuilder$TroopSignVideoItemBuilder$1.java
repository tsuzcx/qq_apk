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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder$SignVideoItemHolder.a.l();
      TroopSignItemBuilder.TroopSignVideoItemBuilder.a().removeCallbacksAndMessages(null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getParent() != null)
    {
      TroopSignItemBuilder.TroopSignVideoItemBuilder.b().postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.1.1(this), 200L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder$SignVideoItemHolder.a.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder$SignVideoItemHolder.e.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
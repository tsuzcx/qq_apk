package com.tencent.mobileqq.activity.aio.item;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;

class LongMsgItemBuilder$4
  implements AnimationTextView.OnDoubleClick
{
  LongMsgItemBuilder$4(LongMsgItemBuilder paramLongMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    if (LimitChatUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      return;
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */
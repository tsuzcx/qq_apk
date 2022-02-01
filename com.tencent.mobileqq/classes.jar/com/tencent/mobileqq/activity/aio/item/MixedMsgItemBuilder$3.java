package com.tencent.mobileqq.activity.aio.item;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;

class MixedMsgItemBuilder$3
  implements AnimationTextView.OnDoubleClick
{
  MixedMsgItemBuilder$3(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    if (this.a.a()) {
      return;
    }
    Object localObject = (FragmentActivity)paramView.getContext();
    if (localObject != null) {}
    for (localObject = ((FragmentActivity)localObject).getChatFragment();; localObject = null)
    {
      if (localObject == null)
      {
        ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext);
        return;
      }
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */
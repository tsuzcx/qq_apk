package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bhtk;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

class BaseChatPie$48
  implements Runnable
{
  BaseChatPie$48(BaseChatPie paramBaseChatPie, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message.frienduin)) && ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message.senderuin == null) || (!this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message.senderuin.equalsIgnoreCase(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) && (!this.this$0.n))
    {
      if (this.this$0.i == null)
      {
        BaseChatPie.a(this.this$0, new View(this.this$0.jdField_a_of_type_AndroidContentContext));
        BaseChatPie.a(this.this$0).setId(2131370834);
        BaseChatPie.a(this.this$0).setBackgroundColor(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166353));
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        this.this$0.b.addView(BaseChatPie.a(this.this$0), (ViewGroup.LayoutParams)localObject);
        this.this$0.i = new TextView(this.this$0.jdField_a_of_type_AndroidContentContext);
        this.this$0.i.setId(2131370831);
        this.this$0.i.setSingleLine();
        this.this$0.i.setBackgroundDrawable(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838955));
        this.this$0.i.setGravity(17);
        this.this$0.i.setTextSize(2, 14.0F);
        this.this$0.i.setBackgroundResource(2130838955);
        this.this$0.i.setTextColor(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166973));
        this.this$0.i.setPadding((int)(this.this$0.jdField_a_of_type_Float * 10.0F), this.this$0.i.getPaddingTop(), (int)(this.this$0.jdField_a_of_type_Float * 10.0F), this.this$0.i.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296956));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131370834);
        this.this$0.b.addView(this.this$0.i, (ViewGroup.LayoutParams)localObject);
        this.this$0.i.setOnClickListener(this.this$0);
      }
      if ((!ChatActivityUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (!ChatActivityUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
        break label577;
      }
      BaseChatPie.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      this.this$0.i.setVisibility(0);
      ThreadManager.postImmediately(new BaseChatPie.48.1(this), null, true);
      this.this$0.i.requestLayout();
      this.this$0.i.setTag(this.jdField_a_of_type_AndroidContentIntent);
      localObject = this.this$0.i.getHandler();
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
        ((Handler)localObject).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 10000L);
      }
      bhtk.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message, this.this$0.i);
      this.this$0.aR();
      return;
      label577:
      BaseChatPie.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.48
 * JD-Core Version:    0.7.0.1
 */
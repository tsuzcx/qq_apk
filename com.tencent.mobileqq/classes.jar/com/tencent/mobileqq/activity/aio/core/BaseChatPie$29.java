package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.notification.NotifyIdManager;

class BaseChatPie$29
  implements Runnable
{
  BaseChatPie$29(BaseChatPie paramBaseChatPie, Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentImcoreMessageMessage.frienduin)) && ((this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin == null) || (!this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin.equalsIgnoreCase(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) && (!this.this$0.l))
    {
      if (this.this$0.i == null)
      {
        BaseChatPie.a(this.this$0, new View(this.this$0.jdField_a_of_type_AndroidContentContext));
        BaseChatPie.a(this.this$0).setId(2131371970);
        BaseChatPie.a(this.this$0).setBackgroundColor(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166465));
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        this.this$0.b.addView(BaseChatPie.a(this.this$0), (ViewGroup.LayoutParams)localObject);
        this.this$0.i = new TextView(this.this$0.jdField_a_of_type_AndroidContentContext);
        this.this$0.i.setId(2131371967);
        this.this$0.i.setSingleLine();
        this.this$0.i.setBackgroundDrawable(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839252));
        this.this$0.i.setGravity(17);
        this.this$0.i.setTextSize(2, 14.0F);
        this.this$0.i.setBackgroundResource(2130839252);
        this.this$0.i.setTextColor(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167109));
        this.this$0.i.setPadding((int)(this.this$0.jdField_a_of_type_Float * 10.0F), this.this$0.i.getPaddingTop(), (int)(this.this$0.jdField_a_of_type_Float * 10.0F), this.this$0.i.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297098));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131371970);
        this.this$0.b.addView(this.this$0.i, (ViewGroup.LayoutParams)localObject);
        this.this$0.i.setOnClickListener(this.this$0);
      }
      if ((!ChatActivityUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (!this.this$0.B())) {
        break label567;
      }
      BaseChatPie.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      this.this$0.i.setVisibility(0);
      ThreadManager.postImmediately(new BaseChatPie.29.1(this), null, true);
      this.this$0.i.requestLayout();
      this.this$0.i.setTag(this.jdField_a_of_type_AndroidContentIntent);
      localObject = this.this$0.i.getHandler();
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
        ((Handler)localObject).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 10000L);
      }
      NotifyIdManager.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentImcoreMessageMessage, this.this$0.i);
      this.this$0.aI();
      return;
      label567:
      BaseChatPie.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.29
 * JD-Core Version:    0.7.0.1
 */
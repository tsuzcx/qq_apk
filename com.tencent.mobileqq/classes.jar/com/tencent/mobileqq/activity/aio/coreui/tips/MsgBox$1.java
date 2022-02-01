package com.tencent.mobileqq.activity.aio.coreui.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.rebuild.tips.TipsRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class MsgBox$1
  implements Runnable
{
  MsgBox$1(MsgBox paramMsgBox, AIOContext paramAIOContext, Message paramMessage, QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentImcoreMessageMessage.frienduin)) && ((this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin == null) || (!this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.h()))
    {
      if (MsgBox.a(this.this$0) == null)
      {
        MsgBox.a(this.this$0, new View(this.jdField_a_of_type_AndroidAppActivity));
        MsgBox.a(this.this$0).setId(2131371577);
        MsgBox.a(this.this$0).setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166476));
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        this.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(MsgBox.a(this.this$0), (ViewGroup.LayoutParams)localObject);
        MsgBox.a(this.this$0, new TextView(this.jdField_a_of_type_AndroidAppActivity));
        MsgBox.a(this.this$0).setId(2131371574);
        MsgBox.a(this.this$0).setSingleLine();
        MsgBox.a(this.this$0).setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839106));
        MsgBox.a(this.this$0).setGravity(17);
        MsgBox.a(this.this$0).setTextSize(2, 14.0F);
        MsgBox.a(this.this$0).setBackgroundResource(2130839106);
        MsgBox.a(this.this$0).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131167134));
        float f = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
        localObject = MsgBox.a(this.this$0);
        int i = (int)(f * 10.0F);
        ((TextView)localObject).setPadding(i, MsgBox.a(this.this$0).getPaddingTop(), i, MsgBox.a(this.this$0).getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297080));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131371577);
        this.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(MsgBox.a(this.this$0), (ViewGroup.LayoutParams)localObject);
        MsgBox.a(this.this$0).setOnClickListener(this.this$0);
      }
      if ((!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_Int)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.g())) {
        MsgBox.a(this.this$0).setVisibility(8);
      } else {
        MsgBox.a(this.this$0).setVisibility(0);
      }
      MsgBox.a(this.this$0).setVisibility(0);
      ThreadManager.postImmediately(new MsgBox.1.1(this), null, true);
      MsgBox.a(this.this$0).requestLayout();
      MsgBox.a(this.this$0).setTag(this.jdField_a_of_type_AndroidContentIntent);
      Object localObject = MsgBox.a(this.this$0).getHandler();
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
        ((Handler)localObject).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 10000L);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IMsgTipsListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentImcoreMessageMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.tips.MsgBox.1
 * JD-Core Version:    0.7.0.1
 */
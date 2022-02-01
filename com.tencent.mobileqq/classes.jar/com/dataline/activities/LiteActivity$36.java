package com.dataline.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class LiteActivity$36
  implements Runnable
{
  LiteActivity$36(LiteActivity paramLiteActivity, Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    if (((this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin == null) || (!this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin.equalsIgnoreCase(this.this$0.app.getCurrentAccountUin()))) && (!this.this$0.jdField_b_of_type_Boolean))
    {
      Object localObject;
      if (this.this$0.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        localObject = this.this$0;
        ((LiteActivity)localObject).jdField_b_of_type_AndroidWidgetTextView = new TextView((Context)localObject);
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setId(2131371574);
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.this$0.getResources().getDrawable(2130839106));
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130839106);
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.this$0.getResources().getColorStateList(2131167134));
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setPadding((int)(LiteActivity.a(this.this$0) * 10.0F), this.this$0.jdField_b_of_type_AndroidWidgetTextView.getPaddingTop(), (int)(LiteActivity.b(this.this$0) * 10.0F), this.this$0.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.this$0.getResources().getDimension(2131297080));
        this.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.this$0.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.this$0);
      }
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentImcoreMessageMessage.msgtype == -2016)
      {
        localObject = this.jdField_a_of_type_ComTencentImcoreMessageMessage.msg.split("\\|");
        if ((localObject != null) && (localObject.length > 0)) {
          localObject = localObject[0].trim();
        } else {
          localObject = "";
        }
      }
      else if (this.jdField_a_of_type_ComTencentImcoreMessageMessage.msgtype == -2011)
      {
        localObject = StructMsgFactory.a(this.jdField_a_of_type_ComTencentImcoreMessageMessage.msgData);
        if (localObject != null) {
          localObject = ((AbsStructMsg)localObject).mMsgBrief;
        } else {
          localObject = this.jdField_a_of_type_ComTencentImcoreMessageMessage.msg;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentImcoreMessageMessage.getMessageText();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentImcoreMessageMessage.nickName != null)
      {
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname"));
        localStringBuilder.append("-");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentImcoreMessageMessage.nickName);
      }
      else
      {
        String str3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
        if ((str3 != null) && (str3.length() != 0))
        {
          String str2;
          String str1;
          if (7000 == this.jdField_a_of_type_ComTencentImcoreMessageMessage.istroop)
          {
            str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("subAccountLatestNick");
            if (str2 != null)
            {
              str1 = str2;
              if (str2.length() != 0) {}
            }
            else
            {
              str1 = this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin;
            }
            localStringBuilder.append(str3);
            localStringBuilder.append("-");
            localStringBuilder.append(str1);
          }
          else if ((1010 != this.jdField_a_of_type_ComTencentImcoreMessageMessage.istroop) && (1001 != this.jdField_a_of_type_ComTencentImcoreMessageMessage.istroop) && (10002 != this.jdField_a_of_type_ComTencentImcoreMessageMessage.istroop))
          {
            localStringBuilder.append(str3);
          }
          else
          {
            if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(this.jdField_a_of_type_ComTencentImcoreMessageMessage.frienduin))
            {
              str2 = ContactUtils.g(this.this$0.app, this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin);
              str1 = str2;
              if (TextUtils.isEmpty(str2)) {
                str1 = this.jdField_a_of_type_ComTencentImcoreMessageMessage.senderuin;
              }
            }
            else
            {
              str2 = ContactUtils.g(this.this$0.app, this.jdField_a_of_type_ComTencentImcoreMessageMessage.frienduin);
              str1 = str2;
              if (TextUtils.isEmpty(str2)) {
                str1 = this.jdField_a_of_type_ComTencentImcoreMessageMessage.frienduin;
              }
            }
            localStringBuilder.append(str3);
            localStringBuilder.append("-");
            localStringBuilder.append(str1);
            if (this.jdField_a_of_type_ComTencentImcoreMessageMessage.msgtype == -1024) {
              localObject = String.format(this.this$0.getResources().getString(2131698742), new Object[] { str1 });
            }
          }
        }
        else
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentImcoreMessageMessage.frienduin);
        }
      }
      localStringBuilder.append(":");
      if ((localObject instanceof QQText))
      {
        try
        {
          this.this$0.jdField_b_of_type_AndroidWidgetTextView.setText(((QQText)localObject).append(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label868;
          }
        }
        QLog.e(LiteActivity.jdField_a_of_type_JavaLangString, 2, localException.toString());
      }
      else
      {
        localStringBuilder.append(localException);
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      }
      label868:
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_AndroidContentIntent);
      Handler localHandler = this.this$0.jdField_b_of_type_AndroidWidgetTextView.getHandler();
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
        localHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 10000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.36
 * JD-Core Version:    0.7.0.1
 */
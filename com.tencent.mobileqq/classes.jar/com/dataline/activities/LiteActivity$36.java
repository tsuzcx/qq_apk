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
    if (((this.a.senderuin == null) || (!this.a.senderuin.equalsIgnoreCase(this.this$0.app.getCurrentAccountUin()))) && (!this.this$0.v))
    {
      Object localObject;
      if (this.this$0.h == null)
      {
        localObject = this.this$0;
        ((LiteActivity)localObject).h = new TextView((Context)localObject);
        this.this$0.h.setId(2131438955);
        this.this$0.h.setSingleLine();
        this.this$0.h.setBackgroundDrawable(this.this$0.getResources().getDrawable(2130839262));
        this.this$0.h.setGravity(17);
        this.this$0.h.setTextSize(2, 14.0F);
        this.this$0.h.setBackgroundResource(2130839262);
        this.this$0.h.setTextColor(this.this$0.getResources().getColorStateList(2131168114));
        this.this$0.h.setPadding((int)(LiteActivity.g(this.this$0) * 10.0F), this.this$0.h.getPaddingTop(), (int)(LiteActivity.h(this.this$0) * 10.0F), this.this$0.h.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.this$0.getResources().getDimension(2131297461));
        this.this$0.i.addView(this.this$0.h, (ViewGroup.LayoutParams)localObject);
        this.this$0.h.setOnClickListener(this.this$0);
      }
      this.this$0.h.setVisibility(0);
      if (this.a.msgtype == -2016)
      {
        localObject = this.a.msg.split("\\|");
        if ((localObject != null) && (localObject.length > 0)) {
          localObject = localObject[0].trim();
        } else {
          localObject = "";
        }
      }
      else if (this.a.msgtype == -2011)
      {
        localObject = StructMsgFactory.a(this.a.msgData);
        if (localObject != null) {
          localObject = ((AbsStructMsg)localObject).mMsgBrief;
        } else {
          localObject = this.a.msg;
        }
      }
      else
      {
        localObject = this.a.getMessageText();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.a.nickName != null)
      {
        localStringBuilder.append(this.b.getStringExtra("uinname"));
        localStringBuilder.append("-");
        localStringBuilder.append(this.a.nickName);
      }
      else
      {
        String str3 = this.b.getStringExtra("uinname");
        if ((str3 != null) && (str3.length() != 0))
        {
          String str2;
          String str1;
          if (7000 == this.a.istroop)
          {
            str2 = this.b.getStringExtra("subAccountLatestNick");
            if (str2 != null)
            {
              str1 = str2;
              if (str2.length() != 0) {}
            }
            else
            {
              str1 = this.a.senderuin;
            }
            localStringBuilder.append(str3);
            localStringBuilder.append("-");
            localStringBuilder.append(str1);
          }
          else if ((1010 != this.a.istroop) && (1001 != this.a.istroop) && (10002 != this.a.istroop))
          {
            localStringBuilder.append(str3);
          }
          else
          {
            if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(this.a.frienduin))
            {
              str2 = ContactUtils.h(this.this$0.app, this.a.senderuin);
              str1 = str2;
              if (TextUtils.isEmpty(str2)) {
                str1 = this.a.senderuin;
              }
            }
            else
            {
              str2 = ContactUtils.h(this.this$0.app, this.a.frienduin);
              str1 = str2;
              if (TextUtils.isEmpty(str2)) {
                str1 = this.a.frienduin;
              }
            }
            localStringBuilder.append(str3);
            localStringBuilder.append("-");
            localStringBuilder.append(str1);
            if (this.a.msgtype == -1024) {
              localObject = String.format(this.this$0.getResources().getString(2131896700), new Object[] { str1 });
            }
          }
        }
        else
        {
          localStringBuilder.append(this.a.frienduin);
        }
      }
      localStringBuilder.append(":");
      if ((localObject instanceof QQText))
      {
        try
        {
          this.this$0.h.setText(((QQText)localObject).append(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label868;
          }
        }
        QLog.e(LiteActivity.a, 2, localException.toString());
      }
      else
      {
        localStringBuilder.append(localException);
        this.this$0.h.setText(localStringBuilder.toString());
      }
      label868:
      this.this$0.h.requestLayout();
      this.this$0.h.setTag(this.b);
      Handler localHandler = this.this$0.h.getHandler();
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.this$0.U);
        localHandler.postDelayed(this.this$0.U, 10000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.36
 * JD-Core Version:    0.7.0.1
 */
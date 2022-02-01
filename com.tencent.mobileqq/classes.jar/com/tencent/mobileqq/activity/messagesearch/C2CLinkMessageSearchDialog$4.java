package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class C2CLinkMessageSearchDialog$4
  implements View.OnClickListener
{
  C2CLinkMessageSearchDialog$4(C2CLinkMessageSearchDialog paramC2CLinkMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick, id = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 2131431492)
    {
      if ((i == 2131433636) && (this.a.j != null) && (this.a.B != null) && (this.a.B.structingMsg != null) && ((this.a.B.structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)this.a.B.structingMsg;
        Intent localIntent = new Intent(this.a.c, ForwardRecentActivity.class);
        localIntent.putExtra("forward_type", -3);
        localIntent.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
        localIntent.putExtra("is_need_show_sources", false);
        ForwardBaseOption.a((Activity)this.a.c, localIntent, 21);
      }
    }
    else if (this.a.j != null) {
      ((ClipboardManager)this.a.c.getSystemService("clipboard")).setText(this.a.j.b.msg);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */
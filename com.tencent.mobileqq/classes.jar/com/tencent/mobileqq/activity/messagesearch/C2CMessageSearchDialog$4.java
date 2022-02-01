package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class C2CMessageSearchDialog$4
  implements View.OnClickListener
{
  C2CMessageSearchDialog$4(C2CMessageSearchDialog paramC2CMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick, id = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    switch (i)
    {
    default: 
      break;
    case 2131445413: 
    case 2131445414: 
      if (QLog.isColorLevel()) {
        QLog.i("C2CMessageSearchDialog", 2, "OnClickListener, setMessageItems");
      }
      localObject = this.a;
      ((C2CMessageSearchDialog)localObject).x = false;
      C2CMessageSearchDialog.a((C2CMessageSearchDialog)localObject).setVisibility(8);
      C2CMessageSearchDialog.a(this.a, 0, null);
      this.a.o.a(C2CMessageSearchDialog.b(this.a), this.a.z, this.a.B);
      this.a.o.notifyDataSetChanged();
      localObject = this.a;
      ((C2CMessageSearchDialog)localObject).n = 1;
      VipUtils.a(((C2CMessageSearchDialog)localObject).f, "chat_history", "ChatSearch", "Clk_cloudtips", 0, 0, new String[0]);
      break;
    case 2131433636: 
      if (this.a.j != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("forward_type", -1);
        ((Bundle)localObject).putString("forward_text", this.a.j.b.msg);
        Intent localIntent = new Intent(this.a.c, ForwardRecentActivity.class);
        localIntent.putExtras((Bundle)localObject);
        ((Activity)this.a.c).startActivityForResult(localIntent, 21);
      }
      break;
    case 2131431492: 
      if (this.a.j != null) {
        ((ClipboardManager)this.a.c.getSystemService("clipboard")).setText(this.a.j.b.msg);
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */
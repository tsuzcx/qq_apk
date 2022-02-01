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
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAllMessageSearchDialog$4
  implements View.OnClickListener
{
  TroopAllMessageSearchDialog$4(TroopAllMessageSearchDialog paramTroopAllMessageSearchDialog) {}
  
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
    switch (i)
    {
    default: 
      break;
    case 2131445413: 
    case 2131445414: 
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageSearchDialog", 2, "OnClickListener, setMessageItems");
      }
      localObject = this.a;
      ((TroopAllMessageSearchDialog)localObject).x = false;
      TroopAllMessageSearchDialog.a((TroopAllMessageSearchDialog)localObject).setVisibility(8);
      TroopAllMessageSearchDialog.a(this.a, 0, null);
      this.a.o.a(TroopAllMessageSearchDialog.b(this.a), this.a.z, this.a.B);
      this.a.o.notifyDataSetChanged();
      this.a.n = 1;
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
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */
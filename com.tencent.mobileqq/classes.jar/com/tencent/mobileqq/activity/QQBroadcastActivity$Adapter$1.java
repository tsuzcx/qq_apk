package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class QQBroadcastActivity$Adapter$1
  implements View.OnLongClickListener
{
  QQBroadcastActivity$Adapter$1(QQBroadcastActivity.Adapter paramAdapter, long paramLong) {}
  
  public boolean onLongClick(View paramView)
  {
    DialogUtil.a(this.b.b, 230).setTitle(this.b.b.getString(2131916962)).setItems(2130968612, new QQBroadcastActivity.Adapter.1.1(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.Adapter.1
 * JD-Core Version:    0.7.0.1
 */
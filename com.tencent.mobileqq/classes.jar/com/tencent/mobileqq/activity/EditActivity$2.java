package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditActivity$2
  implements View.OnClickListener
{
  EditActivity$2(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    EditActivity localEditActivity = this.a;
    EditActivity.a(localEditActivity, EditActivity.c(localEditActivity) ^ true);
    if (EditActivity.c(this.a))
    {
      this.a.b();
      EditActivity.d(this.a).setImageResource(2130838075);
      if (EditActivity.e(this.a) != null) {
        EditActivity.e(this.a).setVisibility(0);
      }
    }
    else
    {
      if (EditActivity.e(this.a) != null) {
        EditActivity.e(this.a).setVisibility(4);
      }
      EditActivity.d(this.a).setImageResource(2130849798);
      this.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditActivity$3
  implements View.OnClickListener
{
  EditActivity$3(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    EditActivity.e(this.a).setVisibility(4);
    EditActivity.d(this.a).setImageResource(2130849798);
    EditActivity.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity.3
 * JD-Core Version:    0.7.0.1
 */
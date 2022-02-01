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
    boolean bool;
    if (!EditActivity.a(this.a))
    {
      bool = true;
      EditActivity.a(localEditActivity, bool);
      if (!EditActivity.a(this.a)) {
        break label86;
      }
      this.a.b();
      EditActivity.a(this.a).setImageResource(2130838192);
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label86:
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).setVisibility(4);
      }
      EditActivity.a(this.a).setImageResource(2130848264);
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity.2
 * JD-Core Version:    0.7.0.1
 */
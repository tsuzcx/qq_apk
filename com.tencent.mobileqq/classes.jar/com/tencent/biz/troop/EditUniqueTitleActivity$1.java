package com.tencent.biz.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditUniqueTitleActivity$1
  implements View.OnClickListener
{
  EditUniqueTitleActivity$1(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onClick(View paramView)
  {
    EditUniqueTitleActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity.1
 * JD-Core Version:    0.7.0.1
 */
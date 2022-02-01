package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.j;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class MMTipsBar$2
  implements View.OnClickListener
{
  MMTipsBar$2(j paramj, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    View.OnClickListener localOnClickListener = this.b;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMTipsBar.2
 * JD-Core Version:    0.7.0.1
 */
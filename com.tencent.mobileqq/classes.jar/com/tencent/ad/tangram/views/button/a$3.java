package com.tencent.ad.tangram.views.button;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.getDialog() != null) && (this.this$0.getDialog().isShowing())) {
      this.this$0.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.a.3
 * JD-Core Version:    0.7.0.1
 */
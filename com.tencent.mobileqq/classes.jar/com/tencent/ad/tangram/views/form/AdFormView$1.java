package com.tencent.ad.tangram.views.form;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdFormView$1
  implements View.OnClickListener
{
  AdFormView$1(AdFormView paramAdFormView) {}
  
  public void onClick(View paramView)
  {
    if (AdFormView.access$000(this.this$0)) {
      AdFormView.access$100(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.AdFormView.1
 * JD-Core Version:    0.7.0.1
 */
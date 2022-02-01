package com.tencent.map.sdk.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class js$3
  implements View.OnClickListener
{
  js$3(js paramjs) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.e != null) {
      this.a.e.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.js.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.keylogger;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KeyStepAnalyserActivity$1
  implements View.OnClickListener
{
  KeyStepAnalyserActivity$1(KeyStepAnalyserActivity paramKeyStepAnalyserActivity) {}
  
  public void onClick(View paramView)
  {
    KeyStepAnalyserActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.1
 * JD-Core Version:    0.7.0.1
 */
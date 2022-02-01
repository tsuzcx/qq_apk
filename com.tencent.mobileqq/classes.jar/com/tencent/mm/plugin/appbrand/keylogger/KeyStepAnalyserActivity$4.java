package com.tencent.mm.plugin.appbrand.keylogger;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KeyStepAnalyserActivity$4
  implements AdapterView.OnItemClickListener
{
  KeyStepAnalyserActivity$4(KeyStepAnalyserActivity paramKeyStepAnalyserActivity, KeyStepAnalyserActivity.a parama) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    KeyStepAnalyserActivity.a(this.b, this.a.a(paramInt));
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.4
 * JD-Core Version:    0.7.0.1
 */
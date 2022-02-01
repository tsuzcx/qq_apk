package com.tencent.mobileqq.apollo.debug;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameDebugView$4
  implements AdapterView.OnItemClickListener
{
  CmGameDebugView$4(CmGameDebugView paramCmGameDebugView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CmGameDebugView.a(this.a, paramInt);
    this.a.a(paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugView.4
 * JD-Core Version:    0.7.0.1
 */
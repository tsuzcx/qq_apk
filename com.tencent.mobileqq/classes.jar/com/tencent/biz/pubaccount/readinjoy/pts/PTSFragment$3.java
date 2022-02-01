package com.tencent.biz.pubaccount.readinjoy.pts;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PTSFragment$3
  implements View.OnClickListener
{
  PTSFragment$3(PTSFragment paramPTSFragment) {}
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment.3
 * JD-Core Version:    0.7.0.1
 */
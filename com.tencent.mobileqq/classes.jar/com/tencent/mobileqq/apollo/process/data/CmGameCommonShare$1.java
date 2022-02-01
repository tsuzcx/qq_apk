package com.tencent.mobileqq.apollo.process.data;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameCommonShare$1
  implements View.OnClickListener
{
  CmGameCommonShare$1(CmGameCommonShare paramCmGameCommonShare) {}
  
  public void onClick(View paramView)
  {
    CmGameCommonShare.a(this.a, true);
    this.a.a();
    CmGameCommonShare.a(this.a, -1, -1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.1
 * JD-Core Version:    0.7.0.1
 */
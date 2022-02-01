package com.tencent.mobileqq.apollo.api.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmShowEmotionAdapter$1
  implements View.OnClickListener
{
  CmShowEmotionAdapter$1(CmShowEmotionAdapter paramCmShowEmotionAdapter) {}
  
  public void onClick(View paramView)
  {
    CmShowEmotionAdapter.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.impl.CmShowEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */
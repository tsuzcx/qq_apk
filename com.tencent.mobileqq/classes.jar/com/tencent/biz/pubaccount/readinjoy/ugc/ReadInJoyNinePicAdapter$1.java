package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyNinePicAdapter$1
  implements View.OnClickListener
{
  ReadInJoyNinePicAdapter$1(ReadInJoyNinePicAdapter paramReadInJoyNinePicAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (ReadInJoyNinePicAdapter.a(this.a) != null) {
      ReadInJoyNinePicAdapter.a(this.a).a(paramView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyNinePicAdapter.1
 * JD-Core Version:    0.7.0.1
 */
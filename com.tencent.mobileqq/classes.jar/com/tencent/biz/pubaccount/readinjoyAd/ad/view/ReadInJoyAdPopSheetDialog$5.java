package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyAdPopSheetDialog$5
  implements View.OnClickListener
{
  ReadInJoyAdPopSheetDialog$5(ReadInJoyAdPopSheetDialog paramReadInJoyAdPopSheetDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.5
 * JD-Core Version:    0.7.0.1
 */
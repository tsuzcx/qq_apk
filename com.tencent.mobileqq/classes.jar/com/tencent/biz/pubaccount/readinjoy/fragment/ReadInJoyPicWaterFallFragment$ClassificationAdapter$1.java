package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ReadInJoyPicWaterFallFragment$ClassificationAdapter$1
  implements View.OnClickListener
{
  ReadInJoyPicWaterFallFragment$ClassificationAdapter$1(ReadInJoyPicWaterFallFragment.ClassificationAdapter paramClassificationAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a.a(paramView, i);
    GalleryReportedUtils.a(this.a.a.getActivity(), "0X8009A71", this.a.a.a(), ((ReadInJoyPicWaterFallFragment.ClassData)this.a.a.a.get(i)).a.mChannelCoverId);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.ClassificationAdapter.1
 * JD-Core Version:    0.7.0.1
 */
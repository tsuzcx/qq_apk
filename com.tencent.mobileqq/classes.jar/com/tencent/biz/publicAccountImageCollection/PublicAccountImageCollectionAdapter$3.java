package com.tencent.biz.publicAccountImageCollection;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountImageCollectionAdapter$3
  implements View.OnClickListener
{
  PublicAccountImageCollectionAdapter$3(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionAdapter.3
 * JD-Core Version:    0.7.0.1
 */
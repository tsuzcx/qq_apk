package com.tencent.biz.pubaccount.ecshopassit;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShopFolderAdapter$1
  implements View.OnClickListener
{
  ShopFolderAdapter$1(ShopFolderAdapter paramShopFolderAdapter, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.b.i != null) {
      this.b.i.b(this.b.c, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopFolderAdapter.1
 * JD-Core Version:    0.7.0.1
 */
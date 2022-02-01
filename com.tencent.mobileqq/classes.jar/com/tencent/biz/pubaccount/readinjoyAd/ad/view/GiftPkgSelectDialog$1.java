package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GiftPkgSelectDialog$1
  implements AdapterView.OnItemClickListener
{
  GiftPkgSelectDialog$1(GiftPkgSelectDialog paramGiftPkgSelectDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GiftPkgSelectDialog.a(this.a, paramInt);
    GiftPkgSelectDialog.a(this.a).notifyDataSetChanged();
    GiftPkgSelectDialog.d(this.a).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog.1
 * JD-Core Version:    0.7.0.1
 */
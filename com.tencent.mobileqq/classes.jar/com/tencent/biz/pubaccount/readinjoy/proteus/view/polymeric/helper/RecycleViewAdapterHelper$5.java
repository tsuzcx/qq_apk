package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class RecycleViewAdapterHelper$5
  extends EventCallback
{
  RecycleViewAdapterHelper$5(RecycleViewAdapterHelper paramRecycleViewAdapterHelper) {}
  
  public void onPagerChange(int paramInt)
  {
    RecycleViewAdapterHelper.b(paramInt);
    if ((RecycleViewAdapterHelper.b() != null) && (!RecycleViewAdapterHelper.b().contains(Integer.valueOf(paramInt)))) {
      RecycleViewAdapterHelper.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.5
 * JD-Core Version:    0.7.0.1
 */
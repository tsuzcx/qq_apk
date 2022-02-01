package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;

class ReadInJoyPicWaterFallFragment$3
  extends RecyclerView.OnScrollListener
{
  ReadInJoyPicWaterFallFragment$3(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0) {}
    for (;;)
    {
      if (ChannelModeConfigHandler.a()) {
        ReadInJoyLogicEngineEventDispatcher.a().k();
      }
      return;
      ReadInJoyPicWaterFallFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.3
 * JD-Core Version:    0.7.0.1
 */
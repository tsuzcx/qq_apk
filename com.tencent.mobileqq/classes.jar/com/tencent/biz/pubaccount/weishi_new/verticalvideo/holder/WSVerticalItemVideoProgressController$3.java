package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSVerticalItemVideoProgressController$3
  implements SeekBar.OnSeekBarChangeListener
{
  WSVerticalItemVideoProgressController$3(WSVerticalItemVideoProgressController paramWSVerticalItemVideoProgressController) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((paramSeekBar == null) || (WSVerticalItemVideoProgressController.a(this.a) == null) || (WSVerticalItemVideoProgressController.a(this.a) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)WSVerticalItemVideoProgressController.a(this.a).a;
      if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed)))
      {
        float f = paramSeekBar.getProgress();
        int i = localWSVerticalItemData.a().video.duration;
        int j = (int)(f / 1000.0F * i);
        WSLog.a("WS_VIDEO_seekBar", "WSVerticalItemVideoProgressController onStopTrackingTouch() progress:" + f + ", videoDuration:" + i + ", position:" + j);
        WSVerticalItemVideoProgressController.a(this.a).a(j, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.3
 * JD-Core Version:    0.7.0.1
 */
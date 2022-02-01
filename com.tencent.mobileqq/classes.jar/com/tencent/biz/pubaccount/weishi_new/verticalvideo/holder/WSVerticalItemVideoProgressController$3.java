package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

class WSVerticalItemVideoProgressController$3
  implements SeekBar.OnSeekBarChangeListener
{
  WSVerticalItemVideoProgressController$3(WSVerticalItemVideoProgressController paramWSVerticalItemVideoProgressController) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((paramSeekBar != null) && (WSVerticalItemVideoProgressController.f(this.a) != null))
    {
      if (WSVerticalItemVideoProgressController.g(this.a) == null) {
        return;
      }
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)WSVerticalItemVideoProgressController.g(this.a).e;
      if ((localWSVerticalItemData != null) && (localWSVerticalItemData.b() != null))
      {
        float f = paramSeekBar.getProgress();
        int i = localWSVerticalItemData.b().video.duration;
        int j = (int)(f / 1000.0F * i);
        paramSeekBar = new StringBuilder();
        paramSeekBar.append("WSVerticalItemVideoProgressController onStopTrackingTouch() progress:");
        paramSeekBar.append(f);
        paramSeekBar.append(", videoDuration:");
        paramSeekBar.append(i);
        paramSeekBar.append(", position:");
        paramSeekBar.append(j);
        WSLog.a("WS_VIDEO_seekBar", paramSeekBar.toString());
        WSVerticalItemVideoProgressController.f(this.a).a(j, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.3
 * JD-Core Version:    0.7.0.1
 */
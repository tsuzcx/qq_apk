package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoStatusListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

class VideoHandler$2
  implements VideoPlayManager.VideoStatusListener
{
  VideoHandler$2(VideoHandler paramVideoHandler) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((this.a.b() == 0) || (this.a.b() == 56) || (VideoAutoPlayController.c)) {
      return;
    }
    this.a.a().a(paramVideoPlayParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.2
 * JD-Core Version:    0.7.0.1
 */
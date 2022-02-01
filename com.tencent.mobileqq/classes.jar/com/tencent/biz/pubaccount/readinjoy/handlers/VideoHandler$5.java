package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;

class VideoHandler$5
  implements Runnable
{
  VideoHandler$5(VideoHandler paramVideoHandler, VideoPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void run()
  {
    if (!VideoHandler.a(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.this$0.a == null) || (this.this$0.a.a() == null) || (this.a == null));
        this.a.d = 0L;
      } while ((VideoHandler.a(this.this$0) == null) || (!VideoHandler.a(this.this$0).a()));
      int i = this.a.a;
      int j = VideoHandler.a(this.this$0).getHeaderViewsCount();
      VideoHandler.a(this.this$0).post(new VideoHandler.5.1(this, i + j));
    } while (!ReadInJoyHelper.a(ReadInJoyUtils.a()));
    QQToast.a(VideoHandler.a(this.this$0).getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.5
 * JD-Core Version:    0.7.0.1
 */
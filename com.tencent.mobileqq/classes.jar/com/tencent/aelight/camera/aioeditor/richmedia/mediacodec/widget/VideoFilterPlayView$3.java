package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget;

import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import java.util.List;

class VideoFilterPlayView$3
  implements Runnable
{
  VideoFilterPlayView$3(VideoFilterPlayView paramVideoFilterPlayView, int paramInt) {}
  
  public void run()
  {
    if (VideoFilterPlayView.b(this.this$0) != null)
    {
      List localList = VideoFilterPlayView.b(this.this$0).getQQFilters(160);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQTransferFilter))) {
        ((QQTransferFilter)localList.get(0)).setSpeedRate(HWVideoDecoder.getSpeedRate(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView.3
 * JD-Core Version:    0.7.0.1
 */
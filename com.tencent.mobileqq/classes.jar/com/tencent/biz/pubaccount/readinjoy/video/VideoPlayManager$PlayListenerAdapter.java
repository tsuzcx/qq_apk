package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

public class VideoPlayManager$PlayListenerAdapter
  extends MediaPlayListenerAdapter
{
  public VideoPlayManager$PlayListenerAdapter(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    VideoPlayManager.a(this.a, paramVideoPlayerWrapper, paramObject);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, String paramString)
  {
    if ((VideoPlayManager.a(this.a) != null) && (VideoPlayManager.a(this.a).a != null)) {
      VideoPlayManager.a(this.a).a.g = paramString;
    }
    if (VideoPlayManager.a(this.a) != null) {
      VideoBufferRangeController.a().a(paramVideoPlayerWrapper, VideoPlayManager.a(this.a).b, paramVideoPlayerWrapper.d());
    }
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (VideoPlayManager.a(this.a).size() >= 10)
    {
      paramVideoPlayerWrapper = (Pair)VideoPlayManager.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramVideoPlayerWrapper.first);
      }
    }
    if (paramBoolean) {
      VideoPlayManager.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((VideoPlayerWrapper)VideoPlayManager.a(this.a).get(Integer.valueOf(paramInt2))).l();
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return VideoPlayManager.a(this.a, paramVideoPlayerWrapper, paramInt1, paramInt2, paramInt3, paramString, paramObject);
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    return VideoPlayManager.a(this.a, paramVideoPlayerWrapper, paramInt, paramObject);
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    VideoPlayManager.a(this.a, paramVideoPlayerWrapper);
  }
  
  public void c(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoPlayManager.a, 2, "onSeekComplete(): video seek complete ! curPlayState:" + VideoPlayUtils.a(this.a.a()));
    }
    if ((paramVideoPlayerWrapper == VideoPlayManager.a(this.a)) && (this.a.a() != 5)) {
      VideoPlayManager.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.PlayListenerAdapter
 * JD-Core Version:    0.7.0.1
 */
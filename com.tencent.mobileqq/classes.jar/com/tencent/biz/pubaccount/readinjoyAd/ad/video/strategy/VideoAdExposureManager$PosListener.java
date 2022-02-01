package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.FixPosArticleInterface.FixPosArticleAsyncListener;
import java.lang.ref.WeakReference;

final class VideoAdExposureManager$PosListener
  implements FixPosArticleInterface.FixPosArticleAsyncListener
{
  private WeakReference<VideoAdExposureManager> a;
  
  public VideoAdExposureManager$PosListener(VideoAdExposureManager paramVideoAdExposureManager)
  {
    this.a = new WeakReference(paramVideoAdExposureManager);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      VideoAdExposureManager localVideoAdExposureManager = (VideoAdExposureManager)this.a.get();
      if ((localVideoAdExposureManager != null) && (VideoAdExposureManager.a(localVideoAdExposureManager) != null)) {
        VideoAdExposureManager.a(localVideoAdExposureManager).post(new VideoAdExposureManager.PosListener.1(this, localVideoAdExposureManager, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.PosListener
 * JD-Core Version:    0.7.0.1
 */
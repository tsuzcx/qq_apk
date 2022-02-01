package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface.FixPosArticleAsyncListener;
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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (VideoAdExposureManager)((WeakReference)localObject).get();
      if ((localObject != null) && (VideoAdExposureManager.a((VideoAdExposureManager)localObject) != null)) {
        VideoAdExposureManager.a((VideoAdExposureManager)localObject).post(new VideoAdExposureManager.PosListener.1(this, (VideoAdExposureManager)localObject, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.PosListener
 * JD-Core Version:    0.7.0.1
 */
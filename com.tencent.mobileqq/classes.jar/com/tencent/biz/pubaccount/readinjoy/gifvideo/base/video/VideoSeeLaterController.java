package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnWeChatVideoWatchLaterClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoSeeLaterController;", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "videoPlayController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;)V", "getVideoPlayController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "onStateChanged", "", "oldState", "", "newState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoSeeLaterController
  implements VideoPlayController.OnStateChangeListener
{
  @Nullable
  private VideoPlayController a;
  
  public VideoSeeLaterController(@Nullable VideoPlayController paramVideoPlayController)
  {
    this.a = paramVideoPlayController;
    paramVideoPlayController = this.a;
    if (paramVideoPlayController != null) {
      paramVideoPlayController.a((VideoPlayController.OnStateChangeListener)this);
    }
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.a;
      } while (localObject == null);
      localObject = ((VideoPlayController)localObject).a();
    } while (localObject == null);
    OnWeChatVideoWatchLaterClickListener.a((BaseArticleInfo)localObject, (int)(VideoDataManager.a.a(((BaseArticleInfo)localObject).innerUniqueID) / 1000), (int)(VideoDataManager.a.b(((BaseArticleInfo)localObject).innerUniqueID) / 1000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoSeeLaterController
 * JD-Core Version:    0.7.0.1
 */
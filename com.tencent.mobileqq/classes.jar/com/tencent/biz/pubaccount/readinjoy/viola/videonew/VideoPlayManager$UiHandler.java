package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class VideoPlayManager$UiHandler
  extends Handler
{
  private WeakReference<VideoPlayManager> a;
  
  public VideoPlayManager$UiHandler(VideoPlayManager paramVideoPlayManager)
  {
    this.a = new WeakReference(paramVideoPlayManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    VideoPlayManager localVideoPlayManager;
    if (this.a != null)
    {
      localVideoPlayManager = (VideoPlayManager)this.a.get();
      if (localVideoPlayManager != null) {
        switch (paramMessage.what)
        {
        }
      }
    }
    do
    {
      return;
      localVideoPlayManager = null;
      break;
    } while ((VideoPlayManager.a(localVideoPlayManager) == null) || (VideoPlayManager.VideoPlayParam.a(VideoPlayManager.a(localVideoPlayManager)) == null));
    Object localObject = VideoPlayManager.VideoPlayParam.a(VideoPlayManager.a(localVideoPlayManager));
    paramMessage = VideoPlayManager.a(localVideoPlayManager);
    if ((localObject != null) && (((VideoPlayerWrapper)localObject).f()))
    {
      long l = ((VideoPlayerWrapper)localObject).a();
      localObject = VideoPlayManager.a(localVideoPlayManager).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(paramMessage, ViolaVideoDelegate.a(l) * 1000);
      }
    }
    VideoPlayManager.a(localVideoPlayManager).sendEmptyMessageDelayed(0, VideoPlayManager.a(localVideoPlayManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.UiHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.qqonly;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import java.lang.ref.WeakReference;

class QQStoryGamePKFilter$OnFrameAvailableListener
  implements SurfaceTexture.OnFrameAvailableListener
{
  private WeakReference<QQStoryGamePKFilter> mFilter;
  private boolean mIsEnabled = true;
  
  public QQStoryGamePKFilter$OnFrameAvailableListener(QQStoryGamePKFilter paramQQStoryGamePKFilter)
  {
    this.mFilter = new WeakReference(paramQQStoryGamePKFilter);
  }
  
  public void disable()
  {
    this.mIsEnabled = false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mIsEnabled)
    {
      QQStoryGamePKFilter localQQStoryGamePKFilter = (QQStoryGamePKFilter)this.mFilter.get();
      if (localQQStoryGamePKFilter != null) {
        QQStoryGamePKFilter.access$600(localQQStoryGamePKFilter, paramSurfaceTexture);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.qqonly.QQStoryGamePKFilter.OnFrameAvailableListener
 * JD-Core Version:    0.7.0.1
 */
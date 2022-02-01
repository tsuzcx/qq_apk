package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class QQLiveImage$SDKInstallListener
  implements TVK_SDKMgr.InstallListener
{
  public void onInstallProgress(float paramFloat)
  {
    QQLiveImage.access$400().set(false);
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(QQLiveImage.TAG, 4, "[SDKInstallListener] onInstallProgress(): v= " + paramFloat);
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    QQLiveImage.access$400().set(false);
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.e(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledFailed():");
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledSuccessed():");
    }
    QQLiveImage.access$400().set(false);
    try
    {
      QQLiveImage.mLockForImageList.lock();
      if (QQLiveImage.access$000() != null)
      {
        int i = 0;
        while (i < QQLiveImage.access$000().size())
        {
          QQLiveImage localQQLiveImage = (QQLiveImage)QQLiveImage.access$000().get(i);
          if ((localQQLiveImage != null) && (localQQLiveImage.mParams != null)) {
            localQQLiveImage.initAndStartPlayer(localQQLiveImage.mParams.mStartPosi);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledSuccessed()", localException);
      }
      return;
    }
    finally
    {
      QQLiveImage.mLockForImageList.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.SDKInstallListener
 * JD-Core Version:    0.7.0.1
 */
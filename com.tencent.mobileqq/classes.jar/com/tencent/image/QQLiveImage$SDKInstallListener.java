package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class QQLiveImage$SDKInstallListener
  implements TVK_SDKMgr.InstallListener
{
  public void onInstallProgress(float paramFloat)
  {
    QQLiveImage.access$100().set(false);
    if (QLog.isDevelopLevel()) {
      QLog.d(QQLiveImage.TAG, 4, "[SDKInstallListener] onInstallProgress(): v= " + paramFloat);
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    QQLiveImage.access$100().set(false);
    if (QLog.isColorLevel()) {
      QLog.e(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledFailed():");
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledSuccessed():");
    }
    QQLiveImage.access$100().set(false);
    try
    {
      QQLiveImage.mLockForImageList.lock();
      if (QQLiveImage.access$200() != null)
      {
        int i = 0;
        while (i < QQLiveImage.access$200().size())
        {
          QQLiveImage localQQLiveImage = (QQLiveImage)QQLiveImage.access$200().get(i);
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
      if (QLog.isColorLevel()) {
        QLog.e(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledSuccessed()", localException);
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
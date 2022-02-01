package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

final class QQLiveImage$2
  implements Runnable
{
  public void run()
  {
    try
    {
      QQLiveImage.mLockForImageList.lock();
      if (QQLiveImage.access$000() != null)
      {
        int i = 0;
        while (i < QQLiveImage.access$000().size())
        {
          QQLiveImage localQQLiveImage = (QQLiveImage)QQLiveImage.access$000().get(i);
          if (localQQLiveImage != null)
          {
            localQQLiveImage.resume();
            URLDrawable.depImp.mLog.i(QQLiveImage.TAG, 1, "resumeAll().... i " + i + ", ID: " + localQQLiveImage.ID);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e(QQLiveImage.TAG, 2, "resumeAll()()", localException);
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
 * Qualified Name:     com.tencent.image.QQLiveImage.2
 * JD-Core Version:    0.7.0.1
 */
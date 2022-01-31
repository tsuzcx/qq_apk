package com.tencent.mobileqq.activity.photo;

import android.media.MediaMetadataRetriever;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MediaScanner$1
  implements Runnable
{
  MediaScanner$1(MediaScanner paramMediaScanner, WeakReference paramWeakReference1, WeakReference paramWeakReference2, int paramInt) {}
  
  public void run()
  {
    try
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.val$infoReference.get();
      MediaScanner.OnMediaScannerListener localOnMediaScannerListener = (MediaScanner.OnMediaScannerListener)this.val$listenerReference.get();
      if (localLocalMediaInfo != null)
      {
        if (localOnMediaScannerListener == null) {
          return;
        }
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(localLocalMediaInfo.path);
        String str = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        localLocalMediaInfo.mDuration = Long.parseLong(str);
        localOnMediaScannerListener.onPhotoListDatasetDurationChanged(this.val$position, localLocalMediaInfo);
        MediaScanner.access$000(MediaScanner.getInstance(BaseApplicationImpl.getContext())).updateMediaScnnerInfoDuration(localLocalMediaInfo.path, localLocalMediaInfo.mDuration);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaScanner", 2, "queryMediaInfoDuration() error=" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScanner.1
 * JD-Core Version:    0.7.0.1
 */
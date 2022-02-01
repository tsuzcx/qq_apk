package com.tencent.mobileqq.activity.photo;

import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.BaseApplication;
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
      localObject = (MediaScanner.OnMediaScannerListener)this.val$listenerReference.get();
      if (localLocalMediaInfo != null)
      {
        if (localObject == null) {
          return;
        }
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(localLocalMediaInfo.path);
        String str = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        localLocalMediaInfo.mDuration = Long.parseLong(str);
        ((MediaScanner.OnMediaScannerListener)localObject).onPhotoListDatasetDurationChanged(this.val$position, localLocalMediaInfo);
        MediaScanner.access$000(MediaScanner.getInstance(BaseApplication.getContext())).updateMediaScnnerInfoDuration(localLocalMediaInfo.path, localLocalMediaInfo.mDuration);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("queryMediaInfoDuration() error=");
        ((StringBuilder)localObject).append(localException.getMessage());
        QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScanner.1
 * JD-Core Version:    0.7.0.1
 */
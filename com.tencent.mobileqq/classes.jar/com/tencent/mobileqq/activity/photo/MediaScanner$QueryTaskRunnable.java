package com.tencent.mobileqq.activity.photo;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MediaScanner$QueryTaskRunnable
  implements Runnable
{
  LocalMediaInfo localMediaInfo;
  MediaScanner.OnMediaInfoScannerListener onMediaScannerListener;
  
  MediaScanner$QueryTaskRunnable(MediaScanner.OnMediaInfoScannerListener paramOnMediaInfoScannerListener, LocalMediaInfo paramLocalMediaInfo)
  {
    this.onMediaScannerListener = paramOnMediaInfoScannerListener;
    this.localMediaInfo = paramLocalMediaInfo;
  }
  
  private void getVideoInfoFromExif(LocalMediaInfo paramLocalMediaInfo, MediaScanner.OnMediaInfoScannerListener paramOnMediaInfoScannerListener)
  {
    Object localObject2 = new ExifInterface(paramLocalMediaInfo.path);
    Object localObject1 = ((ExifInterface)localObject2).getAttribute("GPSLatitude");
    String str1 = ((ExifInterface)localObject2).getAttribute("GPSLatitudeRef");
    String str2 = ((ExifInterface)localObject2).getAttribute("GPSLongitude");
    localObject2 = ((ExifInterface)localObject2).getAttribute("GPSLongitudeRef");
    if ((localObject1 != null) && (str1 != null) && (str2 != null) && (localObject2 != null))
    {
      if (!str1.equals("N")) {
        break label250;
      }
      paramLocalMediaInfo.latitude = MediaScanner.convertGpsToDegreeE6((String)localObject1);
      if (!((String)localObject2).equals("E")) {
        break label263;
      }
    }
    label263:
    for (paramLocalMediaInfo.longitude = MediaScanner.convertGpsToDegreeE6(str2);; paramLocalMediaInfo.longitude = (0 - MediaScanner.convertGpsToDegreeE6(str2)))
    {
      if ((paramLocalMediaInfo.mediaWidth == 0) || (paramLocalMediaInfo.mediaHeight == 0))
      {
        QLog.e("MediaScanner", 2, "queryMediaInfoAsync() width=0 || height=0, path=" + paramLocalMediaInfo.path);
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramLocalMediaInfo.path, (BitmapFactory.Options)localObject1);
        paramLocalMediaInfo.mediaWidth = ((BitmapFactory.Options)localObject1).outWidth;
        paramLocalMediaInfo.mediaHeight = ((BitmapFactory.Options)localObject1).outHeight;
        localObject1 = ((BitmapFactory.Options)localObject1).outMimeType;
        QLog.e("MediaScanner", 2, "queryMediaInfoAsync() After decode metadata width=" + paramLocalMediaInfo.mediaWidth + " height=" + paramLocalMediaInfo.mediaHeight + " mime=" + paramLocalMediaInfo.mMimeType);
      }
      paramOnMediaInfoScannerListener.onMediaInfoChanged(paramLocalMediaInfo, true);
      return;
      label250:
      paramLocalMediaInfo.latitude = (0 - MediaScanner.convertGpsToDegreeE6((String)localObject1));
      break;
    }
  }
  
  public void run()
  {
    Object localObject = new WeakReference(this.onMediaScannerListener);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)new WeakReference(this.localMediaInfo).get();
    localObject = (MediaScanner.OnMediaInfoScannerListener)((WeakReference)localObject).get();
    if ((localLocalMediaInfo == null) || (localObject == null)) {}
    try
    {
      QLog.e("MediaScanner", 2, "info == null || listener == null");
      return;
    }
    catch (Exception localException)
    {
      MediaMetadataRetriever localMediaMetadataRetriever;
      QLog.e("MediaScanner", 2, "queryMediaInfoAsync() error=" + localException.getMessage());
      QLog.e("MediaScanner", 2, "queryMediaInfoAsync() StackTrace=" + Log.getStackTraceString(localException));
      if (localObject == null) {
        return;
      }
      ((MediaScanner.OnMediaInfoScannerListener)localObject).onMediaInfoChanged(localLocalMediaInfo, false);
      return;
      getVideoInfoFromExif(localLocalMediaInfo, (MediaScanner.OnMediaInfoScannerListener)localObject);
    }
    if (localLocalMediaInfo.mMimeType.contains("video"))
    {
      localMediaMetadataRetriever = new MediaMetadataRetriever();
      MediaScanner.access$100(localLocalMediaInfo, localMediaMetadataRetriever);
      MediaScanner.access$200(localLocalMediaInfo, localMediaMetadataRetriever);
      MediaScanner.access$300(localLocalMediaInfo, localMediaMetadataRetriever);
      MediaScanner.access$400(localLocalMediaInfo, localMediaMetadataRetriever);
      localMediaMetadataRetriever.release();
      ((MediaScanner.OnMediaInfoScannerListener)localObject).onMediaInfoChanged(localLocalMediaInfo, true);
      MediaScanner.access$000(MediaScanner.getInstance(BaseApplication.getContext())).updateMediaScnnerInfoDuration(localLocalMediaInfo.path, localLocalMediaInfo.mDuration);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScanner.QueryTaskRunnable
 * JD-Core Version:    0.7.0.1
 */
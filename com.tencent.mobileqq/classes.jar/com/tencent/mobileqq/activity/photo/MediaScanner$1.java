package com.tencent.mobileqq.activity.photo;

import aglw;
import agmi;
import agmk;
import android.media.MediaMetadataRetriever;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class MediaScanner$1
  implements Runnable
{
  public MediaScanner$1(agmi paramagmi, WeakReference paramWeakReference1, WeakReference paramWeakReference2, int paramInt) {}
  
  public void run()
  {
    try
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      agmk localagmk = (agmk)this.b.get();
      if (localLocalMediaInfo != null)
      {
        if (localagmk == null) {
          return;
        }
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(localLocalMediaInfo.path);
        String str = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        localLocalMediaInfo.mDuration = Long.parseLong(str);
        localagmk.a(this.jdField_a_of_type_Int, localLocalMediaInfo);
        agmi.a(agmi.a(BaseApplicationImpl.getContext())).a(localLocalMediaInfo.path, localLocalMediaInfo.mDuration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScanner.1
 * JD-Core Version:    0.7.0.1
 */
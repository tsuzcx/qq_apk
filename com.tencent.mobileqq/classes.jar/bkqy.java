import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.SharePlugin.1;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class bkqy
{
  private static HashMap<Integer, String> a = new HashMap();
  
  public static LocalMediaInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return null;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      bheg.a(paramString, localOptions);
      localLocalMediaInfo.mediaWidth = localOptions.outWidth;
      localLocalMediaInfo.mediaHeight = localOptions.outHeight;
      localLocalMediaInfo.mMimeType = PhotoUtils.getImageMimeType(paramString);
      localLocalMediaInfo.fileSize = localFile.length();
      localLocalMediaInfo.modifiedDate = localFile.lastModified();
      return localLocalMediaInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("_photo", 1, localException, new Object[0]);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("_photo", 1, localOutOfMemoryError, new Object[0]);
      }
    }
  }
  
  public static PublishMoodInfo a(PublishMoodInfo paramPublishMoodInfo)
  {
    int k = 0;
    if (paramPublishMoodInfo == null) {
      return null;
    }
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    localPublishMoodInfo.mTag = paramPublishMoodInfo.mTag;
    localPublishMoodInfo.mPath = paramPublishMoodInfo.mPath;
    localPublishMoodInfo.mFootnote = paramPublishMoodInfo.mFootnote;
    Object localObject1;
    int j;
    int i;
    if ((paramPublishMoodInfo.mText != null) && (!TextUtils.isEmpty(paramPublishMoodInfo.mText)))
    {
      localObject1 = PublishMoodInfo.filterText(paramPublishMoodInfo.mText);
      j = ((String)localObject1).length() - PublishMoodInfo.MOOD_MAX_TEXT_COUNT;
      if (j > 0)
      {
        i = 1;
        paramPublishMoodInfo.mText = paramPublishMoodInfo.mText.substring(0, paramPublishMoodInfo.mText.length() - j);
        QLog.i("mini_SharePlugin", 2, "超出" + (((String)localObject1).length() - PublishMoodInfo.MOOD_MAX_TEXT_COUNT) + "个字,截断");
      }
    }
    for (;;)
    {
      localPublishMoodInfo.mText = paramPublishMoodInfo.mText;
      ArrayList localArrayList;
      int m;
      PublishMoodInfo.MediaInfo localMediaInfo;
      Object localObject2;
      if ((paramPublishMoodInfo.mMediaInfo != null) && (paramPublishMoodInfo.mMediaInfo.size() > 0))
      {
        j = i;
        if (paramPublishMoodInfo.mMediaInfo.size() > PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT)
        {
          j = i | 0x20;
          QLog.i("mini_SharePlugin", 2, "图片+视频个数超出大小");
        }
        localObject1 = new HashMap();
        localArrayList = new ArrayList();
        paramPublishMoodInfo = paramPublishMoodInfo.mMediaInfo.iterator();
        m = 0;
        i = j;
        j = m;
        for (;;)
        {
          if (paramPublishMoodInfo.hasNext())
          {
            localMediaInfo = (PublishMoodInfo.MediaInfo)paramPublishMoodInfo.next();
            localObject2 = new File(localMediaInfo.mPath);
            if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
              QLog.i("mini_SharePlugin", 2, "path is not exist, " + localMediaInfo);
            } else {
              switch (localMediaInfo.mType)
              {
              default: 
                QLog.i("mini_SharePlugin", 2, "invalid type" + localMediaInfo);
                label366:
                if (j + k >= PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT)
                {
                  label375:
                  j = i;
                  if (((HashMap)localObject1).size() > 0)
                  {
                    localPublishMoodInfo.mAllImageAndVideo = localArrayList;
                    localPublishMoodInfo.mMediaInfoHashMap = ((HashMap)localObject1);
                  }
                }
                break;
              }
            }
          }
        }
      }
      for (j = i;; j = i)
      {
        a(j);
        QLog.i("mini_SharePlugin", 2, "tip = " + j);
        return localPublishMoodInfo;
        localObject2 = a(localMediaInfo.mPath);
        if (localObject2 == null) {
          break label366;
        }
        if (a(((LocalMediaInfo)localObject2).fileSize))
        {
          localArrayList.add(localMediaInfo.mPath);
          ((HashMap)localObject1).put(localMediaInfo.mPath, localObject2);
          j += 1;
        }
        for (;;)
        {
          break;
          i |= 0x2;
          QLog.i("mini_SharePlugin", 2, "图片超出大小，" + localMediaInfo);
        }
        if (k >= PublishMoodInfo.MOOD_MAX_VIDEO_COUNT)
        {
          QLog.i("mini_SharePlugin", 2, "视频个数超出大小");
          i |= 0x10;
          break;
        }
        localObject2 = b(localMediaInfo.mPath);
        if (localObject2 == null) {
          break label366;
        }
        boolean bool1 = b(((LocalMediaInfo)localObject2).fileSize);
        boolean bool2 = c(((LocalMediaInfo)localObject2).mDuration);
        if ((bool1) && (bool2))
        {
          localArrayList.add(localMediaInfo.mPath);
          ((HashMap)localObject1).put(localMediaInfo.mPath, localObject2);
          k += 1;
        }
        for (;;)
        {
          break;
          m = i;
          if (!bool1) {
            m = i | 0x4;
          }
          i = m;
          if (!bool2) {
            i = m | 0x8;
          }
          QLog.i("mini_SharePlugin", 2, "单个视频大小/时长超出, " + localMediaInfo);
        }
        break;
        break label375;
      }
      i = 0;
    }
  }
  
  private static void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    AppBrandTask.runTaskOnUiThread(new SharePlugin.1(paramInt));
  }
  
  private static boolean a(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_PHOTO_SIZE;
  }
  
  @TargetApi(10)
  public static LocalMediaInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return null;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (!localFile.isFile()) || (Build.VERSION.SDK_INT <= 10));
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      localLocalMediaInfo.path = paramString;
      localLocalMediaInfo.mDuration = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
      localLocalMediaInfo.mMimeType = localMediaMetadataRetriever.extractMetadata(12);
      localLocalMediaInfo.fileSize = localFile.length();
      try
      {
        localMediaMetadataRetriever.release();
        return localLocalMediaInfo;
      }
      catch (RuntimeException paramString)
      {
        for (;;)
        {
          QZLog.e("mini_SharePlugin", "retriever.release error" + paramString);
        }
      }
      try
      {
        localMediaMetadataRetriever.release();
        throw paramString;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          QZLog.e("mini_SharePlugin", "retriever.release error" + localRuntimeException);
        }
      }
    }
    catch (IllegalArgumentException paramString)
    {
      paramString = paramString;
      QZLog.e("mini_SharePlugin", "IllegalArgumentException" + paramString);
      try
      {
        localMediaMetadataRetriever.release();
        return null;
      }
      catch (RuntimeException paramString)
      {
        QZLog.e("mini_SharePlugin", "retriever.release error" + paramString);
        return null;
      }
    }
    catch (RuntimeException paramString)
    {
      paramString = paramString;
      QZLog.e("mini_SharePlugin", "RuntimeException" + paramString);
      try
      {
        localMediaMetadataRetriever.release();
        return null;
      }
      catch (RuntimeException paramString)
      {
        QZLog.e("mini_SharePlugin", "retriever.release error" + paramString);
        return null;
      }
    }
    finally {}
  }
  
  private static boolean b(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_SIZE;
  }
  
  private static boolean c(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_DURATION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqy
 * JD-Core Version:    0.7.0.1
 */
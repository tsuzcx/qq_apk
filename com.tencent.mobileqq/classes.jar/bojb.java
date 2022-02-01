import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import java.io.File;

public class bojb
{
  public static LocalMediaInfo a(int paramInt1, int paramInt2, @NonNull String paramString1, @Nullable String paramString2, @NonNull String paramString3)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    Size localSize;
    if (paramString2 != null)
    {
      localSize = BitmapUtil.getImageSize(paramString2);
      localLocalMediaInfo.thumbHeight = localSize.getHeight();
    }
    for (localLocalMediaInfo.thumbWidth = localSize.getWidth();; localLocalMediaInfo.thumbWidth = 0)
    {
      localLocalMediaInfo.path = paramString1;
      localLocalMediaInfo.mediaHeight = paramInt1;
      localLocalMediaInfo.mediaWidth = paramInt2;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = paramString2;
      localLocalMediaInfo.mDuration = 0L;
      localLocalMediaInfo.isSystemMeidaStore = false;
      localLocalMediaInfo.isMakeVideo = false;
      localLocalMediaInfo.isVideoReady = false;
      localLocalMediaInfo.missionID = paramString3;
      return localLocalMediaInfo;
      localLocalMediaInfo.thumbHeight = 0;
    }
  }
  
  public static LocalMediaInfo a(@NonNull LocalMediaInfo paramLocalMediaInfo, @Nullable String paramString1, @Nullable String paramString2, int paramInt, @Nullable String paramString3)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString3)) {
      paramLocalMediaInfo.filterID = paramString3;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramLocalMediaInfo.materialID = paramString1;
      paramLocalMediaInfo.materialName = paramString2;
      i = 1;
    }
    if ((i != 0) && (paramInt == 1))
    {
      paramLocalMediaInfo.scheme = bqcc.a(paramString1, paramString3);
      bnzb.b("AELocalMediaInfoUtil", "[addTakeSamePhotoInfo] scheme :" + paramLocalMediaInfo.scheme);
    }
    return paramLocalMediaInfo;
  }
  
  public static LocalMediaInfo a(@NonNull String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    Size localSize = BitmapUtil.getImageSize(paramString);
    localLocalMediaInfo.mediaHeight = localSize.getHeight();
    localLocalMediaInfo.mediaWidth = localSize.getWidth();
    localLocalMediaInfo.mMimeType = "image/jpeg";
    localLocalMediaInfo.path = paramString;
    return localLocalMediaInfo;
  }
  
  @Nullable
  public static LocalMediaInfo a(@Nullable String paramString1, @Nullable String paramString2)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString1);
        int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
        int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
        int k = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(9));
        localLocalMediaInfo.path = paramString1;
        localLocalMediaInfo.mMimeType = "video/mp4";
        localLocalMediaInfo.addedDate = System.currentTimeMillis();
        localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
        localLocalMediaInfo.thumbnailPath = paramString2;
        localLocalMediaInfo.mDuration = k;
        if (paramString1 != null)
        {
          paramString1 = new File(paramString1);
          if (paramString1.exists())
          {
            localLocalMediaInfo.fileSize = paramString1.length();
            localLocalMediaInfo.isSystemMeidaStore = false;
            localLocalMediaInfo.isMakeVideo = true;
            localLocalMediaInfo.mediaWidth = j;
            localLocalMediaInfo.mediaHeight = i;
            if (paramString2 == null) {
              break;
            }
            paramString1 = BitmapUtil.getImageSize(paramString2);
            localLocalMediaInfo.thumbHeight = paramString1.getHeight();
            localLocalMediaInfo.thumbWidth = paramString1.getWidth();
            return localLocalMediaInfo;
          }
          localLocalMediaInfo.fileSize = 0L;
          continue;
        }
        localLocalMediaInfo.fileSize = 0L;
      }
      catch (Exception paramString1)
      {
        bnzb.d("AELocalMediaInfoUtil", "[buildLocalMediaInfoForReady] " + paramString1.getMessage());
        return null;
      }
    }
    localLocalMediaInfo.thumbHeight = 0;
    localLocalMediaInfo.thumbWidth = 0;
    return localLocalMediaInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojb
 * JD-Core Version:    0.7.0.1
 */
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import java.io.File;
import javax.annotation.Nonnull;

public class bpkw
{
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
      paramLocalMediaInfo.scheme = brdx.a(paramString1, paramString3);
      bpam.b("AELocalMediaInfoUtil", "[addTakeSamePhotoInfo] scheme :" + paramLocalMediaInfo.scheme);
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
  
  public static LocalMediaInfo a(@Nonnull String paramString1, int paramInt1, int paramInt2, @NonNull String paramString2, @Nullable String paramString3, @NonNull String paramString4)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    Object localObject;
    if (paramString3 != null)
    {
      localObject = BitmapUtil.getImageSize(paramString3);
      localLocalMediaInfo.thumbHeight = ((Size)localObject).getHeight();
    }
    for (localLocalMediaInfo.thumbWidth = ((Size)localObject).getWidth();; localLocalMediaInfo.thumbWidth = 0)
    {
      if (!bhsr.a(paramString1))
      {
        localLocalMediaInfo.mediaOriginSize = auog.a(paramString1);
        localObject = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject).setDataSource(paramString1);
        localLocalMediaInfo.mediaOriginBitrate = Long.valueOf(((MediaMetadataRetriever)localObject).extractMetadata(20)).longValue();
        localLocalMediaInfo.mediaOriginWidth = Integer.valueOf(((MediaMetadataRetriever)localObject).extractMetadata(18)).intValue();
        localLocalMediaInfo.mediaOriginHeight = Integer.valueOf(((MediaMetadataRetriever)localObject).extractMetadata(19)).intValue();
      }
      localLocalMediaInfo.path = paramString2;
      localLocalMediaInfo.mediaHeight = paramInt1;
      localLocalMediaInfo.mediaWidth = paramInt2;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = paramString3;
      localLocalMediaInfo.mDuration = 0L;
      localLocalMediaInfo.isSystemMeidaStore = false;
      localLocalMediaInfo.isMakeVideo = false;
      localLocalMediaInfo.isVideoReady = false;
      localLocalMediaInfo.missionID = paramString4;
      Log.d("AELocalMediaInfoUtil", "buildLocalMediaInfoForNotReady: info = " + localLocalMediaInfo.toString());
      return localLocalMediaInfo;
      localLocalMediaInfo.thumbHeight = 0;
    }
  }
  
  @Nullable
  public static LocalMediaInfo a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  @Nullable
  public static LocalMediaInfo a(String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    MediaMetadataRetriever localMediaMetadataRetriever1 = new MediaMetadataRetriever();
    MediaMetadataRetriever localMediaMetadataRetriever2 = new MediaMetadataRetriever();
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    for (;;)
    {
      try
      {
        if (!bhsr.a(paramString1))
        {
          localMediaMetadataRetriever1.setDataSource(paramString1);
          i = Integer.parseInt(localMediaMetadataRetriever1.extractMetadata(19));
          j = Integer.parseInt(localMediaMetadataRetriever1.extractMetadata(18));
          l = Long.parseLong(localMediaMetadataRetriever1.extractMetadata(20));
          localLocalMediaInfo.mediaOriginHeight = i;
          localLocalMediaInfo.mediaOriginWidth = j;
          localLocalMediaInfo.mediaOriginBitrate = l;
          localLocalMediaInfo.mediaOriginSize = auog.a(paramString1);
        }
        localMediaMetadataRetriever2.setDataSource(paramString2);
        int i = Integer.parseInt(localMediaMetadataRetriever2.extractMetadata(19));
        int j = Integer.parseInt(localMediaMetadataRetriever2.extractMetadata(18));
        int k = Integer.parseInt(localMediaMetadataRetriever2.extractMetadata(9));
        long l = Long.parseLong(localMediaMetadataRetriever2.extractMetadata(20));
        localLocalMediaInfo.path = paramString2;
        localLocalMediaInfo.mMimeType = "video/mp4";
        localLocalMediaInfo.addedDate = System.currentTimeMillis();
        localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
        localLocalMediaInfo.thumbnailPath = paramString3;
        localLocalMediaInfo.mDuration = k;
        localLocalMediaInfo.mediaBitrate = l;
        if (paramString2 != null)
        {
          paramString1 = new File(paramString2);
          if (paramString1.exists())
          {
            localLocalMediaInfo.fileSize = paramString1.length();
            localLocalMediaInfo.isSystemMeidaStore = false;
            localLocalMediaInfo.isMakeVideo = true;
            localLocalMediaInfo.mediaWidth = j;
            localLocalMediaInfo.mediaHeight = i;
            if (paramString3 == null) {
              break;
            }
            paramString1 = BitmapUtil.getImageSize(paramString3);
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
        bpam.d("AELocalMediaInfoUtil", "[buildLocalMediaInfoForReady] " + paramString1.getMessage());
        return null;
      }
    }
    localLocalMediaInfo.thumbHeight = 0;
    localLocalMediaInfo.thumbWidth = 0;
    return localLocalMediaInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkw
 * JD-Core Version:    0.7.0.1
 */
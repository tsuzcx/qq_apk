package com.tencent.aelight.camera.aeeditor.util;

import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.util.JumpUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import java.io.File;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class AELocalMediaInfoUtil
{
  public static LocalMediaInfo a(@NonNull LocalMediaInfo paramLocalMediaInfo, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt, @Nullable String paramString4)
  {
    if (!TextUtils.isEmpty(paramString4)) {
      paramLocalMediaInfo.filterID = paramString4;
    }
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramLocalMediaInfo.materialID = paramString1;
      paramLocalMediaInfo.materialName = paramString3;
      if (!paramLocalMediaInfo.mHashTagList.contains(paramString2)) {
        paramLocalMediaInfo.mHashTagList.add(paramString2);
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      paramLocalMediaInfo.scheme = JumpUtil.a(paramString1, paramString4);
      paramString1 = new StringBuilder();
      paramString1.append("[addTakeSamePhotoInfo] scheme :");
      paramString1.append(paramLocalMediaInfo.scheme);
      AEQLog.b("AELocalMediaInfoUtil", paramString1.toString());
    }
    paramString1 = new StringBuilder();
    paramString1.append("[addTakeSamePhotoInfo] takePhotoSame :");
    paramString1.append(paramInt);
    AEQLog.b("AELocalMediaInfoUtil", paramString1.toString());
    paramLocalMediaInfo.showCircleTakeSame = paramInt;
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
    return a("", null, paramString1, paramString2);
  }
  
  @Nullable
  public static LocalMediaInfo a(String paramString1, String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    MediaMetadataRetriever localMediaMetadataRetriever1 = new MediaMetadataRetriever();
    MediaMetadataRetriever localMediaMetadataRetriever2 = new MediaMetadataRetriever();
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      if ((!StringUtil.a(paramString2)) && ((paramString1 == null) || (!paramString1.startsWith("multi_video_"))))
      {
        localMediaMetadataRetriever1.setDataSource(paramString2);
        i = Integer.parseInt(localMediaMetadataRetriever1.extractMetadata(19));
        j = Integer.parseInt(localMediaMetadataRetriever1.extractMetadata(18));
        l = Long.parseLong(localMediaMetadataRetriever1.extractMetadata(20));
        localLocalMediaInfo.mediaOriginHeight = i;
        localLocalMediaInfo.mediaOriginWidth = j;
        localLocalMediaInfo.mediaOriginBitrate = l;
        localLocalMediaInfo.mediaOriginSize = FileUtil.a(paramString2);
      }
      localMediaMetadataRetriever2.setDataSource(paramString3);
      int i = Integer.parseInt(localMediaMetadataRetriever2.extractMetadata(19));
      int j = Integer.parseInt(localMediaMetadataRetriever2.extractMetadata(18));
      int k = Integer.parseInt(localMediaMetadataRetriever2.extractMetadata(9));
      long l = Long.parseLong(localMediaMetadataRetriever2.extractMetadata(20));
      localLocalMediaInfo.mDuration = k;
      localLocalMediaInfo.mediaBitrate = l;
      localLocalMediaInfo.mediaWidth = j;
      localLocalMediaInfo.mediaHeight = i;
      if (!TextUtils.isEmpty(paramString4))
      {
        paramString1 = BitmapUtil.getImageSize(paramString4);
        localLocalMediaInfo.thumbHeight = paramString1.getHeight();
        localLocalMediaInfo.thumbWidth = paramString1.getWidth();
      }
      else
      {
        localLocalMediaInfo.thumbHeight = 0;
        localLocalMediaInfo.thumbWidth = 0;
      }
    }
    catch (Exception paramString1) {}
    try
    {
      paramString1.printStackTrace();
      paramString2 = new StringBuilder();
      paramString2.append("error msg: ");
      paramString2.append(paramString1.getMessage());
      AEQLog.d("AELocalMediaInfoUtil", paramString2.toString());
      localLocalMediaInfo.path = paramString3;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = paramString4;
      if (paramString3 != null)
      {
        paramString1 = new File(paramString3);
        if (paramString1.exists()) {
          localLocalMediaInfo.fileSize = paramString1.length();
        } else {
          localLocalMediaInfo.fileSize = 0L;
        }
      }
      else
      {
        localLocalMediaInfo.fileSize = 0L;
      }
      localLocalMediaInfo.isSystemMeidaStore = false;
      localLocalMediaInfo.isMakeVideo = true;
      return localLocalMediaInfo;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramString2 = new StringBuilder();
      paramString2.append("[buildLocalMediaInfoForReady] ");
      paramString2.append(paramString1.getMessage());
      AEQLog.d("AELocalMediaInfoUtil", paramString2.toString());
    }
    return null;
  }
  
  public static LocalMediaInfo a(ArrayList<String> paramArrayList, @Nonnull String paramString1, int paramInt1, int paramInt2, @NonNull String paramString2, @Nullable String paramString3, @NonNull String paramString4)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    Object localObject;
    if (paramString3 != null)
    {
      localObject = BitmapUtil.getImageSize(paramString3);
      localLocalMediaInfo.thumbHeight = ((Size)localObject).getHeight();
      localLocalMediaInfo.thumbWidth = ((Size)localObject).getWidth();
    }
    else
    {
      localLocalMediaInfo.thumbHeight = 0;
      localLocalMediaInfo.thumbWidth = 0;
    }
    if (!StringUtil.a(paramString1))
    {
      localLocalMediaInfo.mediaOriginSize = FileUtil.a(paramString1);
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
    paramString1 = paramArrayList;
    if (paramArrayList == null) {
      paramString1 = new ArrayList();
    }
    localLocalMediaInfo.mOriginPath = paramString1;
    paramArrayList = new StringBuilder();
    paramArrayList.append("buildLocalMediaInfoForNotReady: info = ");
    paramArrayList.append(localLocalMediaInfo.toString());
    AEQLog.a("AELocalMediaInfoUtil", paramArrayList.toString());
    return localLocalMediaInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.util.AELocalMediaInfoUtil
 * JD-Core Version:    0.7.0.1
 */
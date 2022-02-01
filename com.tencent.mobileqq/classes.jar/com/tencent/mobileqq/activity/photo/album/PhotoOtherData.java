package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_OPERATION.PicInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.sveffects.SvEffectSdkInitor;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoOtherData
  implements OtherCommonData
{
  public int a;
  public long a;
  public HashMap<String, PicInfo> a;
  public boolean a;
  private boolean b = false;
  
  public PhotoOtherData()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = ((int)PicUploadFileSizeLimit.getLimitC2C());
  }
  
  public int a(PhotoCommonBaseData<PhotoOtherData> paramPhotoCommonBaseData, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramPhotoCommonBaseData, paramString) == null)) {
      return -1;
    }
    return AlbumUtil.getMediaType(a(paramPhotoCommonBaseData, paramString));
  }
  
  public LocalMediaInfo a(PhotoCommonBaseData<PhotoOtherData> paramPhotoCommonBaseData, String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = null;
    if (paramPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (paramPhotoCommonBaseData.allMediaInfoHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        MediaMetadataUtils.MetaData localMetaData = new MediaMetadataUtils.MetaData();
        MediaMetadataUtils.a(paramString, localMetaData);
        localLocalMediaInfo.mediaWidth = localMetaData.a[0];
        localLocalMediaInfo.mediaHeight = localMetaData.a[1];
        localLocalMediaInfo.rotation = localMetaData.a[2];
        if (paramPhotoCommonBaseData.allMediaInfoHashMap != null)
        {
          paramPhotoCommonBaseData = (LocalMediaInfo)paramPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
          if ((paramPhotoCommonBaseData != null) && ((paramPhotoCommonBaseData.mediaWidth == 0) || (paramPhotoCommonBaseData.mediaHeight == 0)))
          {
            paramPhotoCommonBaseData.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramPhotoCommonBaseData.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramPhotoCommonBaseData.rotation = localLocalMediaInfo.rotation;
          }
        }
      }
      return localLocalMediaInfo;
    }
  }
  
  public void a(boolean paramBoolean, PhotoCommonBaseData<PhotoOtherData> paramPhotoCommonBaseData)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      paramPhotoCommonBaseData.needMediaInfo = true;
      SvEffectSdkInitor.a();
    }
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    return this.b;
  }
  
  public boolean a(PhotoCommonBaseData<PhotoOtherData> paramPhotoCommonBaseData)
  {
    int i = 0;
    while (i < paramPhotoCommonBaseData.selectedPhotoList.size())
    {
      String str = (String)paramPhotoCommonBaseData.selectedPhotoList.get(i);
      if (ImageManager.isNetworkUrl(str)) {}
      while (a(paramPhotoCommonBaseData, str) != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoOtherData
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_OPERATION.PicInfo;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoOtherData
  implements OtherCommonData
{
  public int a;
  public long a;
  public String a;
  public HashMap<String, PicInfo> a;
  public boolean a;
  public int b = (int)((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
  
  public PhotoOtherData()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(PhotoCommonBaseData<PhotoOtherData> paramPhotoCommonBaseData, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a(paramPhotoCommonBaseData, paramString) != null)) {
      return QAlbumUtil.getMediaType(a(paramPhotoCommonBaseData, paramString));
    }
    return -1;
  }
  
  public LocalMediaInfo a(PhotoCommonBaseData<PhotoOtherData> paramPhotoCommonBaseData, String paramString)
  {
    Object localObject1;
    if (paramPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      localObject1 = (LocalMediaInfo)paramPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (paramPhotoCommonBaseData.allMediaInfoHashMap != null) {
        localObject2 = (LocalMediaInfo)paramPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
      }
    }
    if ((localObject2 != null) && ((((LocalMediaInfo)localObject2).mediaWidth == 0) || (((LocalMediaInfo)localObject2).mediaHeight == 0)))
    {
      localObject1 = new MediaMetadataUtils.MetaData();
      MediaMetadataUtils.a(paramString, (MediaMetadataUtils.MetaData)localObject1);
      ((LocalMediaInfo)localObject2).mediaWidth = localObject1.a[0];
      ((LocalMediaInfo)localObject2).mediaHeight = localObject1.a[1];
      ((LocalMediaInfo)localObject2).rotation = localObject1.a[2];
      if (paramPhotoCommonBaseData.allMediaInfoHashMap != null)
      {
        paramPhotoCommonBaseData = (LocalMediaInfo)paramPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
        if ((paramPhotoCommonBaseData != null) && ((paramPhotoCommonBaseData.mediaWidth == 0) || (paramPhotoCommonBaseData.mediaHeight == 0)))
        {
          paramPhotoCommonBaseData.mediaWidth = ((LocalMediaInfo)localObject2).mediaWidth;
          paramPhotoCommonBaseData.mediaHeight = ((LocalMediaInfo)localObject2).mediaHeight;
          paramPhotoCommonBaseData.rotation = ((LocalMediaInfo)localObject2).rotation;
        }
      }
    }
    return localObject2;
  }
  
  public boolean a(PhotoCommonBaseData<PhotoOtherData> paramPhotoCommonBaseData)
  {
    int i = 0;
    while (i < paramPhotoCommonBaseData.selectedPhotoList.size())
    {
      String str = (String)paramPhotoCommonBaseData.selectedPhotoList.get(i);
      if (ImageManager.isNetworkUrl(str)) {
        return false;
      }
      if (a(paramPhotoCommonBaseData, str) != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoOtherData
 * JD-Core Version:    0.7.0.1
 */
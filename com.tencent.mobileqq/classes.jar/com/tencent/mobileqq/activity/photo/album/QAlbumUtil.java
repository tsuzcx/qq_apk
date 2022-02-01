package com.tencent.mobileqq.activity.photo.album;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class QAlbumUtil
  extends QAlbumBaseUtil
{
  public static final String ALBUM_FILE_NAME = "album_file";
  public static final String ALBUM_KEY_ID = "album_key_id";
  public static final String ALBUM_KEY_NAME = "album_key_name";
  public static final int MEDIA_TYPE_CAMERA = 2;
  public static final int MEDIA_TYPE_IMAGE = 0;
  public static final HashMap<String, Integer> MEDIA_TYPE_MAPS;
  public static final int MEDIA_TYPE_NONE = -1;
  public static final int MEDIA_TYPE_VIDEO = 1;
  public static final long PHOTO_SLOT_TIME = 60000L;
  public static final String PROTOCOL_ALBUM_THUMB = "albumthumb";
  public static final String PROTOCOL_VIDEO_COVER = "videocover";
  public static SimpleDateFormat sDateFormatForHour;
  public static SimpleDateFormat sDateFormatForMinute = new SimpleDateFormat("yyyy年MM月dd HH点mm分");
  public static String sLastAlbumId;
  public static String sLastAlbumName;
  public static String sLastAlbumPath = "";
  public static HashMap<String, Integer> sLastAlbumPhotoCountMap;
  public static long sLastAlbumRecordTime;
  public static HashMap<String, Pair<String, String>> sSelectItemAlbum = new HashMap();
  public static HashMap<String, LinkedHashMap<String, Integer>> sSelectItemPosMap = new HashMap();
  
  static
  {
    sDateFormatForHour = new SimpleDateFormat("yyyy年MM月dd HH点");
    MEDIA_TYPE_MAPS = new HashMap();
    MEDIA_TYPE_MAPS.put("image", Integer.valueOf(0));
    MEDIA_TYPE_MAPS.put("video", Integer.valueOf(1));
    MEDIA_TYPE_MAPS.put("mobileqq", Integer.valueOf(2));
    sLastAlbumRecordTime = 0L;
    sLastAlbumPhotoCountMap = new HashMap();
  }
  
  private static void XInAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771992, 2130771993);
  }
  
  private static void XOutAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771988, 2130771989);
  }
  
  private static void YInAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771979, 2130771980);
  }
  
  private static void YOutAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771977, 2130771978);
  }
  
  public static void anim(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        XInAnim(paramActivity);
        return;
      }
      XOutAnim(paramActivity);
      return;
    }
    if (paramBoolean2)
    {
      YInAnim(paramActivity);
      return;
    }
    YOutAnim(paramActivity);
  }
  
  public static void clearSelectItemInfo()
  {
    sSelectItemAlbum.clear();
    sSelectItemPosMap.clear();
  }
  
  public static String createContentDescription(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      localStringBuilder.append("照片 ");
    }
    for (;;)
    {
      localStringBuilder.append("拍摄时间: ");
      paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
      localStringBuilder.append(sDateFormatForMinute.format(paramLocalMediaInfo));
      return localStringBuilder.toString();
      localStringBuilder.append("视频 ");
    }
  }
  
  public static String createContentDescriptionWithCheckBox(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      localStringBuilder.append("照片 ");
    }
    for (;;)
    {
      localStringBuilder.append("拍摄时间: ");
      paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
      localStringBuilder.append(sDateFormatForHour.format(paramLocalMediaInfo));
      return localStringBuilder.toString();
      localStringBuilder.append("视频 ");
    }
  }
  
  public static URL generateAlbumThumbURL(LocalMediaInfo paramLocalMediaInfo)
  {
    return generateAlbumThumbURL(paramLocalMediaInfo, null);
  }
  
  public static URL generateAlbumThumbURL(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumb");
    localStringBuilder.append("://");
    localStringBuilder.append(paramLocalMediaInfo.path);
    if (paramString != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString);
    }
    try
    {
      paramLocalMediaInfo = new URL(localStringBuilder.toString());
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public static URL generateAlbumVideoThumbURL(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("videocover");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
    }
    try
    {
      paramString1 = new URL(localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  public static int getMediaType(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return -1;
    }
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if (arrayOfString == null) {
      return 0;
    }
    Integer localInteger = (Integer)MEDIA_TYPE_MAPS.get(arrayOfString[0]);
    if (localInteger == null)
    {
      QLog.w("QAlbumUtil", 1, "getMediaType fail : " + paramLocalMediaInfo.mMimeType + " - " + arrayOfString[0]);
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static final boolean isNetUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  public static void putLastAlbumInfo(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("album_file", 0).edit();
    paramContext.putString("album_key_id", sLastAlbumId);
    paramContext.putString("album_key_name", sLastAlbumName);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QAlbumUtil
 * JD-Core Version:    0.7.0.1
 */
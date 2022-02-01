package com.tencent.mobileqq.activity.photo.album;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.webkit.MimeTypeMap;
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
  public static final HashMap<String, Integer> MEDIA_TYPE_MAPS = new HashMap();
  public static final int MEDIA_TYPE_NONE = -1;
  public static final int MEDIA_TYPE_VIDEO = 1;
  public static final long PHOTO_SLOT_TIME = 60000L;
  public static final String PROTOCOL_ALBUM_THUMB = "albumthumb";
  public static final String PROTOCOL_VIDEO_COVER = "videocover";
  public static SimpleDateFormat sDateFormatForHour;
  public static SimpleDateFormat sDateFormatForMinute = new SimpleDateFormat("yyyy年MM月dd HH点mm分");
  public static String sLastAlbumId;
  public static String sLastAlbumName;
  public static String sLastAlbumPath;
  public static HashMap<String, Integer> sLastAlbumPhotoCountMap;
  public static long sLastAlbumRecordTime;
  public static HashMap<String, Pair<String, String>> sSelectItemAlbum;
  public static HashMap<String, LinkedHashMap<String, Integer>> sSelectItemPosMap;
  
  static
  {
    sDateFormatForHour = new SimpleDateFormat("yyyy年MM月dd HH点");
    sLastAlbumRecordTime = 0L;
    sLastAlbumPhotoCountMap = new HashMap();
    sLastAlbumPath = "";
    sSelectItemAlbum = new HashMap();
    sSelectItemPosMap = new HashMap();
    MEDIA_TYPE_MAPS.put("image", Integer.valueOf(0));
    MEDIA_TYPE_MAPS.put("video", Integer.valueOf(1));
    MEDIA_TYPE_MAPS.put("mobileqq", Integer.valueOf(2));
  }
  
  public static void anim(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        xInAnim(paramActivity);
        return;
      }
      xOutAnim(paramActivity);
      return;
    }
    if (paramBoolean2)
    {
      yInAnim(paramActivity);
      return;
    }
    yOutAnim(paramActivity);
  }
  
  public static void clearSelectItemInfo()
  {
    sSelectItemAlbum.clear();
    sSelectItemPosMap.clear();
  }
  
  public static String createContentDescription(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 != 1) {
      localStringBuilder.append("照片 ");
    } else {
      localStringBuilder.append("视频 ");
    }
    localStringBuilder.append("拍摄时间: ");
    paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
    localStringBuilder.append(sDateFormatForMinute.format(paramLocalMediaInfo));
    return localStringBuilder.toString();
  }
  
  public static String createContentDescriptionWithCheckBox(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 != 1) {
      localStringBuilder.append("照片 ");
    } else {
      localStringBuilder.append("视频 ");
    }
    localStringBuilder.append("拍摄时间: ");
    paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
    localStringBuilder.append(sDateFormatForHour.format(paramLocalMediaInfo));
    return localStringBuilder.toString();
  }
  
  public static String formatTimeToString(long paramLong)
  {
    int j = (int)(paramLong / 1000L);
    int i = j % 60;
    j /= 60;
    Object localObject1;
    if (i > 9)
    {
      localObject1 = String.valueOf(i);
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(String.valueOf(i));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2;
    if (j > 9)
    {
      localObject2 = String.valueOf(j);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(String.valueOf(j));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
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
    Object localObject = (Integer)MEDIA_TYPE_MAPS.get(arrayOfString[0]);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMediaType fail : ");
      ((StringBuilder)localObject).append(paramLocalMediaInfo.mMimeType);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(arrayOfString[0]);
      QLog.w("QQAlbum", 1, ((StringBuilder)localObject).toString());
      return -1;
    }
    return ((Integer)localObject).intValue();
  }
  
  public static int getMediaType(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.contains(".")) {
        return -1;
      }
      paramString = paramString.substring(paramString.lastIndexOf(".") + 1);
      paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      if ((paramString != null) && (paramString.contains("video"))) {
        return 1;
      }
      if ((paramString != null) && (paramString.contains("image"))) {
        return 0;
      }
    }
    return -1;
  }
  
  public static boolean isGif(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public static final boolean isNetUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void putLastAlbumInfo(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("album_file", 0).edit();
    paramContext.putString("album_key_id", sLastAlbumId);
    paramContext.putString("album_key_name", sLastAlbumName);
    paramContext.commit();
  }
  
  public static void rotate180Degrees(View paramView, boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 180.0F;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramBoolean) {
      f2 = 360.0F;
    } else {
      f2 = 180.0F;
    }
    RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(300L);
    localRotateAnimation.setFillAfter(true);
    paramView.startAnimation(localRotateAnimation);
  }
  
  private static void xInAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772009, 2130772010);
  }
  
  private static void xOutAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772005, 2130772006);
  }
  
  private static void yInAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771996, 2130771997);
  }
  
  private static void yOutAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771994, 2130771995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QAlbumUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.photo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class MimeHelper
{
  public static final String IMAGE_BMP = "image/bmp";
  public static final String IMAGE_GIF = "image/gif";
  public static final String IMAGE_HEIC = "image/heic";
  public static final String IMAGE_HEIF = "image/heif";
  public static final String IMAGE_JPEG = "image/jpeg";
  public static final String IMAGE_PNG = "image/png";
  public static final String IMAGE_SUBTYPE_BITMAP = "bitmap";
  public static final String IMAGE_SUBTYPE_BMP = "bmp";
  public static final String IMAGE_SUBTYPE_GIF = "gif";
  public static final String IMAGE_SUBTYPE_HEIF = "heif";
  public static final String IMAGE_SUBTYPE_JPEG = "jpeg";
  public static final String IMAGE_SUBTYPE_JPG = "jpg";
  public static final String IMAGE_SUBTYPE_PNG = "png";
  public static final String IMAGE_SUBTYPE_WEBP = "webp";
  public static final String IMAGE_UNKNOWN = "*/*";
  public static final String IMAGE_UNKNOWN2 = "image/*";
  public static final String IMAGE_WEBP = "image/webp";
  public static final String MIME_TYPE_IMAGE = "image";
  public static final String MIME_TYPE_MOBILEQQ = "mobileqq";
  public static final String MIME_TYPE_MOBILEQQ_CAMERA = "mobileqq/camera";
  public static final String MIME_TYPE_VIDEO = "video";
  private static final String TAG = "QQAlbum";
  public static final String VIDEO_MP4 = "video/mp4";
  
  public static String[] getMimeType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString.split("/");
    if (localObject.length != 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Mimetype error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("QQAlbum", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    return localObject;
  }
  
  public static boolean validateImageType(String paramString)
  {
    if ((!"jpg".equals(paramString)) && (!"gif".equals(paramString)) && (!"png".equals(paramString)))
    {
      if ("jpeg".equals(paramString)) {
        return true;
      }
      if (paramString.lastIndexOf("bmp") == -1) {
        return paramString.lastIndexOf("bitmap") != -1;
      }
    }
    return true;
  }
  
  public static boolean validateVideoType(String paramString)
  {
    return "video/mp4".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MimeHelper
 * JD-Core Version:    0.7.0.1
 */
package com.dataline.util.file;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.qphone.base.util.QLog;

public class MediaStoreUtil
{
  public static int a(String paramString)
  {
    int i = JpegExifReader.readOrientation(paramString);
    if (i != 3)
    {
      if (i != 6)
      {
        if (i != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  @TargetApi(8)
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    int i = 1;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    FilePicURLDrawlableHelper.a(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    int j = ((BitmapFactory.Options)localObject).outWidth / paramInt1;
    paramInt2 = k / paramInt2;
    paramInt1 = paramInt2;
    if (j < paramInt2) {
      paramInt1 = j;
    }
    if (paramInt1 <= 0) {
      paramInt1 = i;
    }
    ((BitmapFactory.Options)localObject).inSampleSize = paramInt1;
    try
    {
      localObject = FilePicURLDrawlableHelper.a(paramString, (BitmapFactory.Options)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      break label125;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label88:
      break label88;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getImageThumbnail error(OOM)! imagePath is ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("wifiphoto", 2, ((StringBuilder)localObject).toString());
    return null;
    label125:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getImageThumbnail error imagePath is ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("wifiphoto", 2, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static void a(String paramString, int paramInt)
  {
    try
    {
      if (JpegExifReader.isCrashJpeg(paramString)) {
        return;
      }
      ExifInterface localExifInterface = new ExifInterface(paramString);
      if (paramInt != 90)
      {
        if (paramInt != 180)
        {
          if (paramInt != 270) {
            paramString = Integer.toString(1);
          } else {
            paramString = Integer.toString(8);
          }
        }
        else {
          paramString = Integer.toString(3);
        }
      }
      else {
        paramString = Integer.toString(6);
      }
      localExifInterface.setAttribute("Orientation", paramString);
      localExifInterface.saveAttributes();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @TargetApi(8)
  public static Bitmap b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    int j = 1;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    int i = ((BitmapFactory.Options)localObject).outHeight;
    int k = ((BitmapFactory.Options)localObject).outWidth / paramInt1;
    int m = i / paramInt2;
    i = m;
    if (k < m) {
      i = k;
    }
    if (i <= 0) {
      i = j;
    }
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    try
    {
      localObject = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      return ThumbnailUtils.extractThumbnail((Bitmap)localObject, paramInt1, paramInt2, 2);
    }
    catch (Exception localException)
    {
      break label134;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label97:
      break label97;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getImageThumbnailForSize error(OOM)! imagePath is ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("wifiphoto", 2, ((StringBuilder)localObject).toString());
    return null;
    label134:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getImageThumbnailForSize error imagePath is ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("wifiphoto", 2, ((StringBuilder)localObject).toString());
    return null;
  }
  
  @TargetApi(8)
  public static Bitmap c(String paramString, int paramInt1, int paramInt2)
  {
    return ThumbnailUtils.createVideoThumbnail(paramString, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.file.MediaStoreUtil
 * JD-Core Version:    0.7.0.1
 */
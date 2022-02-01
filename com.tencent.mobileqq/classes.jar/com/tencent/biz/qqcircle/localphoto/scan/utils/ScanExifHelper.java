package com.tencent.biz.qqcircle.localphoto.scan.utils;

import android.media.ExifInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.localphoto.scan.data.ExpandExifInterface;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo;
import com.tencent.biz.qqcircle.publish.util.ExifUtil;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;

public class ScanExifHelper
{
  public static ExpandExifInterface a(String paramString)
  {
    try
    {
      if (JpegExifReader.isCrashJpeg(paramString)) {
        return null;
      }
      paramString = new ExpandExifInterface(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("ScanExifHelper", 1, "[getExpandExif]", paramString);
    }
    return null;
  }
  
  public static void a(@NonNull LocalPhotoInfo paramLocalPhotoInfo)
  {
    boolean bool = "image/heif, image/heic".contains(paramLocalPhotoInfo.c);
    Object localObject1 = null;
    Object localObject4;
    Object localObject2;
    if (bool)
    {
      ExifInterface localExifInterface = ExifUtil.b(paramLocalPhotoInfo.b);
      if (localExifInterface != null)
      {
        localObject1 = localExifInterface.getAttribute("DateTime");
        paramLocalPhotoInfo.h = localExifInterface.getAttributeInt("Orientation", 0);
        if (b(paramLocalPhotoInfo)) {
          try
          {
            localObject4 = new float[2];
            localExifInterface.getLatLong((float[])localObject4);
            paramLocalPhotoInfo.i = localObject4[0];
            paramLocalPhotoInfo.j = localObject4[1];
          }
          catch (Exception localException2)
          {
            QLog.e("ScanExifHelper", 1, "scan", localException2);
          }
        }
      }
    }
    else
    {
      localObject4 = a(paramLocalPhotoInfo.b);
      if (localObject4 != null)
      {
        localObject3 = ((ExpandExifInterface)localObject4).a("DateTime");
        paramLocalPhotoInfo.h = ((ExpandExifInterface)localObject4).a("Orientation", 0);
        localObject1 = localObject3;
        if (b(paramLocalPhotoInfo)) {
          try
          {
            localObject1 = new float[2];
            ((ExpandExifInterface)localObject4).a((float[])localObject1);
            paramLocalPhotoInfo.i = localObject1[0];
            paramLocalPhotoInfo.j = localObject1[1];
            localObject1 = localObject3;
          }
          catch (Exception localException1)
          {
            QLog.e("ScanExifHelper", 1, "scan", localException1);
            localObject2 = localObject3;
          }
        }
      }
    }
    Object localObject3 = localObject2;
    if (!TextUtils.isEmpty(localObject2))
    {
      localObject3 = localObject2;
      if (localObject2.contains("?"))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("exifDateTime invalid, ");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.w("ScanExifHelper", 1, ((StringBuilder)localObject3).toString());
        localObject3 = "";
      }
    }
    long l = b((String)localObject3);
    if ((l != 0L) && (l != 1L)) {
      paramLocalPhotoInfo.d = l;
    }
  }
  
  private static int b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getSecondsFromDate] expireDate=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ScanExifHelper", 1, ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.trim().equals(" ")) {
        return 0;
      }
      try
      {
        if (paramString.matches("^[0-9]*$"))
        {
          if (paramString.length() >= 10) {
            return Integer.valueOf(paramString.substring(0, 10)).intValue();
          }
        }
        else
        {
          localObject = Calendar.getInstance();
          ((Calendar)localObject).set(Integer.parseInt(paramString.substring(0, 4)), Integer.parseInt(paramString.substring(5, 7)) - 1, Integer.parseInt(paramString.substring(8, 10)), Integer.parseInt(paramString.substring(11, 13)), Integer.parseInt(paramString.substring(14, 16)), Integer.parseInt(paramString.substring(17, 19)));
          long l = ((Calendar)localObject).getTime().getTime() / 1000L;
          return (int)l;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ScanExifHelper", 1, "[getSecondsFromDate] Exception: ", paramString);
      }
    }
    return 0;
  }
  
  private static boolean b(@NonNull LocalPhotoInfo paramLocalPhotoInfo)
  {
    return (Math.abs(paramLocalPhotoInfo.i - 0.0F) < 1.0E-006D) || (Math.abs(paramLocalPhotoInfo.j - 0.0F) < 1.0E-006D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.utils.ScanExifHelper
 * JD-Core Version:    0.7.0.1
 */
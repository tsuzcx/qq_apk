package com.tencent.mobileqq.activity.photo.incompatiblephoto;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PhotoIncompatibleBaseDecorator
  extends PhotoIncompatibleBase
{
  public PhotoIncompatibleBaseDecorator(PhotoIncompatibleBase paramPhotoIncompatibleBase)
  {
    super(paramPhotoIncompatibleBase);
  }
  
  public String a()
  {
    Object localObject = Utils.a(this.c, 2);
    StringBuilder localStringBuilder;
    if (!new File((String)localObject).exists())
    {
      boolean bool = a((String)localObject);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.b, bool, 0L, FileUtils.getFileSizes((String)localObject), null, "");
      if (bool)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("outputPath");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" originFile");
          localStringBuilder.append(this.c);
          localStringBuilder.append(" fileType:");
          localStringBuilder.append(this.a);
          Logger.a("PIC_TAG_ERROR", "check file type,generateCompatibleFile suc", localStringBuilder.toString());
        }
        return localObject;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" originFile");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" fileType:");
        ((StringBuilder)localObject).append(this.a);
        Logger.a("PIC_TAG_ERROR", "check file type,generateCompatibleFile fail", ((StringBuilder)localObject).toString());
      }
      return null;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("outputPath");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" originFile");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" fileType:");
      localStringBuilder.append(this.a);
      Logger.a("PIC_TAG_ERROR", "check file type,compatibleFile exists", localStringBuilder.toString());
    }
    return localObject;
  }
  
  boolean a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int j = BaseImageUtil.c(this.c);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("generate ");
    ((StringBuilder)localObject1).append(this.a);
    String str2 = ((StringBuilder)localObject1).toString();
    int i = 1;
    Object localObject2;
    while (i <= 4)
    {
      try
      {
        localOptions.inSampleSize = i;
        if (QLog.isColorLevel())
        {
          localObject1 = this.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str2);
          ((StringBuilder)localObject2).append(",localPath:");
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append(" sample:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" path:");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" degree:");
          ((StringBuilder)localObject2).append(j);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = SafeBitmapFactory.safeDecode(this.c, localOptions);
        localObject1 = localObject2;
        if (j != 0)
        {
          localObject1 = new Matrix();
          int k = ((Bitmap)localObject2).getWidth();
          int m = ((Bitmap)localObject2).getHeight();
          ((Matrix)localObject1).postRotate(j, k >> 1, m >> 1);
          localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, k, m, (Matrix)localObject1, true);
        }
        if (Utils.a(paramString, (Bitmap)localObject1, 80, "incompatible to jpg", null))
        {
          bool = true;
          break label422;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = this.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str2);
          ((StringBuilder)localObject2).append(",compressQuality fail");
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str2);
          localStringBuilder.append(",oom localPath:");
          localStringBuilder.append(this.c);
          localStringBuilder.append(" sample:");
          localStringBuilder.append(i);
          localStringBuilder.append(" degree:");
          localStringBuilder.append(j);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        localOutOfMemoryError.printStackTrace();
        System.gc();
      }
      i *= 2;
    }
    boolean bool = false;
    label422:
    if (QLog.isColorLevel())
    {
      String str1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(",result:");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(" sample:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" path:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" degree:");
      ((StringBuilder)localObject2).append(j);
      QLog.d(str1, 2, ((StringBuilder)localObject2).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBaseDecorator
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.publish.upload;

import com.tencent.biz.qqcircle.publish.util.ImageUtil.Size;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import cooperation.qqcircle.utils.NetworkState;

public class QCircleImageSizeStrategy
{
  public static QCircleImageSizeStrategy a = new QCircleImageSizeStrategy("ResolutionLow", "QualityLow", 1080, 1080, 1.0F, 1080, 10000, 1.0F, 10000, 1080);
  public static QCircleImageSizeStrategy b = new QCircleImageSizeStrategy("ResolutionLow", "WebPQualityLow", 1080, 1080, 1.0F, 1080, 10000, 1.0F, 10000, 1080);
  public static QCircleImageSizeStrategy c = new QCircleImageSizeStrategy("ResolutionHigh", "QualityHigh", 1200, 1200, 0.5F, 1200, 10000, 2.0F, 10000, 1200);
  public static QCircleImageSizeStrategy d = new QCircleImageSizeStrategy("ResolutionHigh", "QualityHigh", 1600, 1600, 1.0F, 1600, 10000, 1.0F, 10000, 1600);
  public static QCircleImageSizeStrategy e = new QCircleImageSizeStrategy("ResolutionHigh", "WebPQualityHigh", 1600, 1600, 0.5F, 1600, 10000, 2.0F, 10000, 1600);
  public String f;
  public String g;
  public int h;
  public int i;
  public float j;
  public int k;
  public int l;
  public float m;
  public int n;
  public int o;
  
  public QCircleImageSizeStrategy(String paramString1, String paramString2, int paramInt1, int paramInt2, float paramFloat1, int paramInt3, int paramInt4, float paramFloat2, int paramInt5, int paramInt6)
  {
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramFloat1;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramFloat2;
    this.n = paramInt5;
    this.o = paramInt6;
  }
  
  public static int a(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = paramString1.equals("PhotoUpload");
    String str = "80,80,80";
    if (bool)
    {
      if ((paramString2.equals("QualityLow")) || (paramString2.equals("QualityHigh"))) {
        break label100;
      }
      if (paramString2.equals("WebPQualityLow"))
      {
        str = "75,75,75";
        break label100;
      }
      if (paramString2.equals("WebPQualityHigh"))
      {
        str = "80,80,90";
        break label100;
      }
    }
    else if ((paramString1.equals("QzoneCover")) && (paramString2.equals("UploadQuality")))
    {
      str = "70,70,70";
      break label100;
    }
    str = "";
    try
    {
      label100:
      paramString1 = QCircleConfigHelper.a(paramString1, paramString2, str);
      if (paramString1 != null)
      {
        paramString1 = paramString1.split(",");
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if ((paramInt != 3) && (paramInt != 4) && (paramInt != 5)) {
              return 80;
            }
            paramInt = Integer.valueOf(paramString1[1]).intValue();
          }
          else
          {
            paramInt = Integer.valueOf(paramString1[0]).intValue();
          }
        }
        else {
          paramInt = Integer.valueOf(paramString1[2]).intValue();
        }
        return paramInt;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Service size format error:");
      paramString2.append(paramString1.getMessage());
      QLog.e("QCircleImageSizeStrategy", 1, paramString2.toString());
    }
    return 80;
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    QCircleImageSizeStrategy localQCircleImageSizeStrategy = b(paramInt, paramBoolean);
    return a(NetworkState.getNetworkType(), "PhotoUpload", localQCircleImageSizeStrategy.g);
  }
  
  private static ImageUtil.Size a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = paramInt3;
    float f1 = paramInt1;
    float f3 = f2 / f1;
    float f4 = paramInt4;
    f2 = paramInt2;
    f3 = Math.min(f3, f4 / f2);
    if (f3 < 1.0D) {
      return new ImageUtil.Size((int)(f1 * f3), (int)(f2 * f3));
    }
    return new ImageUtil.Size(paramInt1, paramInt2);
  }
  
  public static ImageUtil.Size a(String paramString, ImageUtil.Size paramSize, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramString = QCircleConfigHelper.a("PhotoUpload", paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sizeConfig:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("SizeConfig", 1, ((StringBuilder)localObject).toString());
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        localObject = paramString.split(",");
        paramString = "";
        int i1 = NetworkState.getNetworkType();
        if (i1 == 1) {
          break label298;
        }
        if (i1 == 2) {
          break label290;
        }
        if ((i1 == 3) || (i1 == 4) || (i1 == 5)) {
          break label282;
        }
        paramString = paramString.split("\\*");
        i1 = Integer.valueOf(paramString[0]).intValue();
        int i2 = Integer.valueOf(paramString[1]).intValue();
        paramString = new StringBuilder();
        paramString.append("@coverOptimize size[0] =");
        paramString.append(localObject[0]);
        paramString.append(" size[1]");
        paramString.append(localObject[1]);
        paramString.append(" size[2] ");
        paramString.append(localObject[2]);
        QLog.i("QCircleImageSizeStrategy", 1, paramString.toString());
        if (paramFloat1 < paramFloat2) {
          return new ImageUtil.Size(i1, i2);
        }
        if (paramFloat1 > paramFloat3) {
          return new ImageUtil.Size(i2, i1);
        }
        paramString = new ImageUtil.Size(i1, i1);
        return paramString;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Service size config format error:");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.w("QCircleImageSizeStrategy", 1, ((StringBuilder)localObject).toString());
      }
      return paramSize;
      label282:
      paramString = localObject[1];
      continue;
      label290:
      paramString = localObject[0];
      continue;
      label298:
      paramString = localObject[2];
    }
  }
  
  public static IUploadConfig.UploadImageSize a()
  {
    int i1 = 1080;
    try
    {
      String[] arrayOfString2 = QCircleConfigHelper.a("QzoneCover", "UploadResolution", "640*640,640*640,640*640").split(",");
      String[] arrayOfString1 = null;
      i2 = NetworkState.getNetworkType();
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if ((i2 == 3) || (i2 == 4) || (i2 == 5)) {
            arrayOfString1 = arrayOfString2[1].split("\\*");
          }
        }
        else {
          arrayOfString1 = arrayOfString2[0].split("\\*");
        }
      }
      else {
        arrayOfString1 = arrayOfString2[2].split("\\*");
      }
      if (arrayOfString1 != null)
      {
        i2 = Integer.parseInt(arrayOfString1[0]);
        try
        {
          i1 = Integer.parseInt(arrayOfString1[1]);
          i3 = i1;
        }
        catch (Exception localException1)
        {
          i1 = i2;
        }
        QLog.e("Upload Cover", 1, "getCoverUploadSize() exception occured=", localException2);
      }
    }
    catch (Exception localException2)
    {
      i1 = 1080;
    }
    int i3 = 1080;
    int i2 = i1;
    return new IUploadConfig.UploadImageSize(i2, i3, a(NetworkState.getNetworkType(), "QzoneCover", "UploadQuality"));
  }
  
  public static IUploadConfig.UploadImageSize a(ImageUtil.Size paramSize, int paramInt)
  {
    if (paramSize == null) {
      return new IUploadConfig.UploadImageSize(0, 0, paramInt);
    }
    if (paramSize.a > paramSize.b) {
      i1 = paramSize.a;
    } else {
      i1 = paramSize.b;
    }
    if (i1 < 960) {
      return new IUploadConfig.UploadImageSize(paramSize.a, paramSize.b, paramInt);
    }
    if (i1 == paramSize.a)
    {
      d1 = paramSize.b;
      d2 = paramSize.a;
      Double.isNaN(d1);
      Double.isNaN(d2);
      i2 = (int)(d1 / d2 * 960.0D);
      i1 = i2;
      if (i2 == 0) {
        i1 = paramSize.b;
      }
      return new IUploadConfig.UploadImageSize(960, i1, paramInt);
    }
    double d1 = paramSize.a;
    double d2 = paramSize.b;
    Double.isNaN(d1);
    Double.isNaN(d2);
    int i2 = (int)(d1 / d2 * 960.0D);
    int i1 = i2;
    if (i2 == 0) {
      i1 = paramSize.a;
    }
    return new IUploadConfig.UploadImageSize(i1, 960, paramInt);
  }
  
  public static IUploadConfig.UploadImageSize a(ImageUtil.Size paramSize, int paramInt, boolean paramBoolean)
  {
    if (paramSize == null) {
      return null;
    }
    return a(paramSize, b(paramInt, paramBoolean));
  }
  
  private static IUploadConfig.UploadImageSize a(ImageUtil.Size paramSize, QCircleImageSizeStrategy paramQCircleImageSizeStrategy)
  {
    if (paramSize == null) {
      return null;
    }
    if (paramQCircleImageSizeStrategy == null) {
      return new IUploadConfig.UploadImageSize(paramSize.a, paramSize.b, 100);
    }
    float f1 = paramSize.a / paramSize.b;
    if (f1 < paramQCircleImageSizeStrategy.j) {
      localSize = new ImageUtil.Size(paramQCircleImageSizeStrategy.k, paramQCircleImageSizeStrategy.l);
    } else if (f1 > paramQCircleImageSizeStrategy.m) {
      localSize = new ImageUtil.Size(paramQCircleImageSizeStrategy.n, paramQCircleImageSizeStrategy.o);
    } else {
      localSize = new ImageUtil.Size(paramQCircleImageSizeStrategy.h, paramQCircleImageSizeStrategy.i);
    }
    ImageUtil.Size localSize = a(paramQCircleImageSizeStrategy.f, localSize, f1, paramQCircleImageSizeStrategy.j, paramQCircleImageSizeStrategy.m);
    paramSize = a(paramSize.a, paramSize.b, localSize.a, localSize.b);
    return new IUploadConfig.UploadImageSize(paramSize.a, paramSize.b, a(NetworkState.getNetworkType(), "PhotoUpload", paramQCircleImageSizeStrategy.g));
  }
  
  private static QCircleImageSizeStrategy b(int paramInt, boolean paramBoolean)
  {
    QCircleImageSizeStrategy localQCircleImageSizeStrategy = a;
    if (paramInt == 0)
    {
      if (!paramBoolean) {
        return localQCircleImageSizeStrategy;
      }
      return b;
    }
    if (paramInt == 1) {
      return c;
    }
    if (paramInt == 2)
    {
      if (!paramBoolean) {
        return d;
      }
      localQCircleImageSizeStrategy = e;
    }
    return localQCircleImageSizeStrategy;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.f);
    localStringBuffer.append("(");
    localStringBuffer.append(this.h);
    localStringBuffer.append(",");
    localStringBuffer.append(this.i);
    localStringBuffer.append(")");
    localStringBuffer.append(" - min(");
    localStringBuffer.append(this.k);
    localStringBuffer.append(",");
    localStringBuffer.append(this.l);
    localStringBuffer.append(")");
    localStringBuffer.append(" - max(");
    localStringBuffer.append(this.n);
    localStringBuffer.append(",");
    localStringBuffer.append(this.o);
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.upload.QCircleImageSizeStrategy
 * JD-Core Version:    0.7.0.1
 */
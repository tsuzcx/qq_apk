package com.tencent.biz.qqcircle.publish.model;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.io.File;
import java.util.HashMap;

public class ImageInfo
  implements SmartParcelable
{
  @NeedParcel
  public String a;
  @NeedParcel
  public String b;
  @NeedParcel
  public long c;
  @NeedParcel
  public long d;
  @NeedParcel
  public String e;
  @NeedParcel
  public GpsInfo4LocalImage f;
  @NeedParcel
  public HashMap<String, String> g;
  @NeedParcel
  public HashMap<String, byte[]> h = new HashMap();
  @NeedParcel
  public int i;
  @NeedParcel
  public double j = -1.0D;
  @NeedParcel
  public int k;
  @NeedParcel
  public long l = 0L;
  @NeedParcel
  public int m;
  @NeedParcel
  public int n;
  @NeedParcel
  public int o;
  @NeedParcel
  public int p;
  @NeedParcel
  public long q;
  @NeedParcel
  public String r;
  
  public ImageInfo() {}
  
  public ImageInfo(String paramString)
  {
    paramString = new File(paramString);
    this.a = paramString.getAbsolutePath();
    this.b = paramString.getName();
    this.c = paramString.length();
    this.d = paramString.lastModified();
  }
  
  public ImageInfo(String paramString, boolean paramBoolean)
  {
    paramString = new File(paramString);
    if ((paramBoolean) && ((!paramString.exists()) || (paramString.isDirectory()))) {
      throw new ImageInfo.InvalidImageException("image file not exist!");
    }
    this.a = paramString.getAbsolutePath();
    this.b = paramString.getName();
    this.c = paramString.length();
    this.d = paramString.lastModified();
  }
  
  public static ImageInfo a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      try
      {
        paramString = new ImageInfo(paramString, true);
        return paramString;
      }
      catch (ImageInfo.InvalidImageException paramString)
      {
        QLog.e("[upload2]ImageInfo", 1, "create ImageInfo from path error.", paramString);
      }
    }
    return null;
  }
  
  private boolean a(ImageInfo paramImageInfo)
  {
    return (this.b.equals(paramImageInfo.b)) && (this.c == paramImageInfo.c) && (this.d == paramImageInfo.d) && (this.a.equals(paramImageInfo.a));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof ImageInfo))) {
      return a((ImageInfo)paramObject);
    }
    return false;
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    localStringBuilder.append(this.d);
    return localStringBuilder.toString().hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageInfo{mPath='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSize=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mModifiedDate=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mDescription='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", photoId=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", uploadProbability=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", panoramaType=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", photoWidth=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", photoHeight=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", mimeType='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.ImageInfo
 * JD-Core Version:    0.7.0.1
 */
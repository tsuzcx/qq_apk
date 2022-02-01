package com.tencent.biz.qqcircle.publish.model;

import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public class MediaWrapper
  implements SmartParcelable
{
  @NeedParcel
  public String a;
  @NeedParcel
  public String b;
  @NeedParcel
  public String c;
  @NeedParcel
  public String d;
  @NeedParcel
  public int e;
  @NeedParcel
  public int f;
  @NeedParcel
  public int g;
  @NeedParcel
  public long h;
  @NeedParcel
  public long i;
  @NeedParcel
  public long j;
  @NeedParcel
  public String k;
  @NeedParcel
  public float l;
  @NeedParcel
  public float m;
  @NeedParcel
  public float n;
  @NeedParcel
  public float o;
  @NeedParcel
  public float p;
  @NeedParcel
  public String q;
  @NeedParcel
  public String r;
  @NeedParcel
  public String s;
  @NeedParcel
  public String t;
  @NeedParcel
  public String u;
  @NeedParcel
  public String v;
  @NeedParcel
  private int w;
  @NeedParcel
  private ImageInfo x;
  @NeedParcel
  private ShuoshuoVideoInfo y;
  @NeedParcel
  private boolean z;
  
  public MediaWrapper()
  {
    this.z = false;
    this.k = "";
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = 0.0F;
    this.p = 0.0F;
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "";
    this.u = "";
    this.v = "";
  }
  
  public MediaWrapper(ImageInfo paramImageInfo)
  {
    this.z = false;
    this.k = "";
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = 0.0F;
    this.p = 0.0F;
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "";
    this.u = "";
    this.v = "";
    this.w = 0;
    this.x = paramImageInfo;
  }
  
  public MediaWrapper(ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    boolean bool = false;
    this.z = false;
    this.k = "";
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = 0.0F;
    this.p = 0.0F;
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "";
    this.u = "";
    this.v = "";
    this.w = 1;
    this.y = paramShuoshuoVideoInfo;
    int i1 = QCircleHostQzoneHelper.getVideoCanCompressLimitMs();
    ShuoshuoVideoInfo localShuoshuoVideoInfo = this.y;
    if (paramShuoshuoVideoInfo.t < i1) {
      bool = true;
    }
    localShuoshuoVideoInfo.n = bool;
  }
  
  public boolean a()
  {
    return this.w == 1;
  }
  
  public boolean b()
  {
    return this.w == 0;
  }
  
  public ShuoshuoVideoInfo c()
  {
    return this.y;
  }
  
  public ImageInfo d()
  {
    return this.x;
  }
  
  public boolean e()
  {
    if (a())
    {
      ShuoshuoVideoInfo localShuoshuoVideoInfo = this.y;
      if ((localShuoshuoVideoInfo != null) && (localShuoshuoVideoInfo.n) && (this.z)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("MediaWrapper{\n");
    localStringBuffer.append("materialID='");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", filterId='");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", materialName='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", scheme='");
    localStringBuffer.append(this.d);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", mKuolieId='");
    localStringBuffer.append(this.k);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", mKuolieCenterX=");
    localStringBuffer.append(this.l);
    localStringBuffer.append('\n');
    localStringBuffer.append(", mKuolieCenterY=");
    localStringBuffer.append(this.m);
    localStringBuffer.append('\n');
    localStringBuffer.append(", mKuolieRotate=");
    localStringBuffer.append(this.n);
    localStringBuffer.append('\n');
    localStringBuffer.append(", mKuolieWidthScale=");
    localStringBuffer.append(this.o);
    localStringBuffer.append('\n');
    localStringBuffer.append(", mKuolieHeightScale=");
    localStringBuffer.append(this.p);
    localStringBuffer.append('\n');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.MediaWrapper
 * JD-Core Version:    0.7.0.1
 */
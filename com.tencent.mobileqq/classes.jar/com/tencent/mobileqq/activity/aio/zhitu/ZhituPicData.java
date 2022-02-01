package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

public class ZhituPicData
{
  public String a;
  public String b;
  public String c;
  @Nullable
  public ZhituTextManager.DrawTextParam d;
  public boolean e;
  public String f;
  public int g;
  public String h;
  @Nullable
  public Drawable i;
  @Nullable
  public Drawable j;
  public boolean k;
  public ZhituReportData l;
  public boolean m;
  public String n;
  public String o;
  public boolean p;
  public boolean q;
  
  public void a(ZhituPicData paramZhituPicData)
  {
    this.a = paramZhituPicData.a;
    this.b = paramZhituPicData.b;
    this.c = paramZhituPicData.c;
    this.h = paramZhituPicData.h;
    this.g = paramZhituPicData.g;
    this.f = paramZhituPicData.f;
    this.i = paramZhituPicData.i;
    this.k = paramZhituPicData.k;
    this.l = paramZhituPicData.l;
    this.d = paramZhituPicData.d;
    this.e = paramZhituPicData.e;
    this.p = paramZhituPicData.p;
    this.q = paramZhituPicData.q;
    this.j = paramZhituPicData.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituPicData{url='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", originPath='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", drawTextParam=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", inCache=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", reqKey='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", idxInRes=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", pic_md5='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", drawable=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", originDrawable=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", isGif=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", reportData=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData
 * JD-Core Version:    0.7.0.1
 */
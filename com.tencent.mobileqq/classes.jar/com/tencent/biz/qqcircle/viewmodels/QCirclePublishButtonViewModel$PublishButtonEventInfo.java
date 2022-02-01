package com.tencent.biz.qqcircle.viewmodels;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;

public class QCirclePublishButtonViewModel$PublishButtonEventInfo
{
  public boolean a;
  public String b;
  public String c;
  public String d;
  public NinePatchDrawable e;
  public Drawable f;
  public String g;
  public long h;
  public long i;
  
  public int a()
  {
    if ((this.f != null) && (this.e != null)) {
      return 1;
    }
    if ((this.f != null) && (this.e == null)) {
      return 2;
    }
    return -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishButtonEventInfo{isShow=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", hashIcon='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hashTag='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", words='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", backImgDrawable=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", operatorDrawable=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", animationStartupTime=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", animationShowTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.PublishButtonEventInfo
 * JD-Core Version:    0.7.0.1
 */
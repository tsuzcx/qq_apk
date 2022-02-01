package com.tencent.mobileqq.activity.aio.pluspanel;

import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.NotNull;

public class PluginData
{
  public int a;
  public int b;
  public boolean c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public Drawable k;
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PluginData{drawable=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", actionId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", text='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contentDescription='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isShowNew=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appid=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", redDotId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", action='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", actionType='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PluginData
 * JD-Core Version:    0.7.0.1
 */
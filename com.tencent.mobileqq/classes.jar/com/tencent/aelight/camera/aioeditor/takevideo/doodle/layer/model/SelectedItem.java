package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class SelectedItem
{
  public final String a;
  public final String b;
  public final Drawable c;
  public final int d;
  
  public SelectedItem(@NonNull String paramString1, @NonNull String paramString2, Drawable paramDrawable, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramDrawable;
    this.d = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SelectedItem{");
    localStringBuilder.append("category='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", drawable=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isDynamic=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem
 * JD-Core Version:    0.7.0.1
 */
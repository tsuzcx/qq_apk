package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.support.annotation.NonNull;
import java.io.Serializable;

public class EditorPicInfo
  implements Serializable
{
  public double h;
  public double originPicHeight;
  public double originPicWidth;
  public String picPath;
  public double rotate;
  public double w;
  public double x;
  public double y;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditorPicInfo{picPath=");
    localStringBuilder.append(this.picPath);
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", w=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", h=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.rotate);
    localStringBuilder.append(", originPicWidth=");
    localStringBuilder.append(this.originPicWidth);
    localStringBuilder.append(", originPicHeight=");
    localStringBuilder.append(this.originPicHeight);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.opengl.multiplevideos.renderbase;

import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public abstract class ImageSource
{
  private String a;
  private List<Filter> b;
  
  public ImageSource()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
    this.b = new LinkedList();
    Log.d(this.a, "ImageSource: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.renderbase.ImageSource
 * JD-Core Version:    0.7.0.1
 */
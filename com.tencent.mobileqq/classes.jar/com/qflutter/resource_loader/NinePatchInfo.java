package com.qflutter.resource_loader;

import android.graphics.Rect;
import java.util.Arrays;

public class NinePatchInfo
{
  Rect centerSlice;
  int[] mDivX;
  int[] mDivY;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NinePatchInfo{centerSlice=");
    localStringBuilder.append(this.centerSlice);
    localStringBuilder.append(", mDivX=");
    localStringBuilder.append(Arrays.toString(this.mDivX));
    localStringBuilder.append(", mDivY=");
    localStringBuilder.append(Arrays.toString(this.mDivY));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qflutter.resource_loader.NinePatchInfo
 * JD-Core Version:    0.7.0.1
 */
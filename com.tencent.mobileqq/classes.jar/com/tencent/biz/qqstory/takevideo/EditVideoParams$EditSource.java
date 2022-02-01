package com.tencent.biz.qqstory.takevideo;

import android.os.Parcelable;
import android.support.annotation.NonNull;

public abstract interface EditVideoParams$EditSource
  extends Parcelable
{
  public abstract String checkParam();
  
  public abstract int getHeight();
  
  @NonNull
  public abstract String getSourcePath();
  
  public abstract int getWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource
 * JD-Core Version:    0.7.0.1
 */
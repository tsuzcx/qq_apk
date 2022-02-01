package com.tencent.ilive.opensdk.params;

import androidx.annotation.NonNull;

public class IAVMediaInfo$IVideoInfo
  implements IAVMediaInfo
{
  public String identifier = "";
  public int mHeight = 0;
  public int mRotate = 0;
  public int mWidth = 0;
  
  @NonNull
  public String toString()
  {
    return "IVideoInfo:[mWidth:" + this.mWidth + " mHeight:" + this.mHeight + " mRotate:" + this.mRotate + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.IAVMediaInfo.IVideoInfo
 * JD-Core Version:    0.7.0.1
 */
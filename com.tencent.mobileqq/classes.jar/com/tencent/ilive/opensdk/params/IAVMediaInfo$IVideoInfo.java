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
    StringBuilder localStringBuilder = new StringBuilder("IVideoInfo:[mWidth:");
    localStringBuilder.append(this.mWidth);
    localStringBuilder.append(" mHeight:");
    localStringBuilder.append(this.mHeight);
    localStringBuilder.append(" mRotate:");
    localStringBuilder.append(this.mRotate);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.IAVMediaInfo.IVideoInfo
 * JD-Core Version:    0.7.0.1
 */
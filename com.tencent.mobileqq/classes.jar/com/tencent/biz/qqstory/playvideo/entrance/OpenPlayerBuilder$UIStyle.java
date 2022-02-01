package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;

public class OpenPlayerBuilder$UIStyle
  implements Serializable
{
  public int bottomWidgetShowFlag = 0;
  public boolean hideBannerInfo = false;
  public boolean hideMoreIcon = false;
  public boolean hideVideoDetailInfo = false;
  public boolean mForDebug = false;
  public int mPlayerRepeatMode = 0;
  public boolean showVideoCoverList = true;
  public boolean showVideoNoInteresting = false;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UIStyle{showVideoCoverList=");
    localStringBuilder.append(this.showVideoCoverList);
    localStringBuilder.append(", hideVideoDetailInfo=");
    localStringBuilder.append(this.hideVideoDetailInfo);
    localStringBuilder.append(", bottomWidgetShowFlag=");
    localStringBuilder.append(this.bottomWidgetShowFlag);
    localStringBuilder.append(", mPlayerRepeatMode=");
    localStringBuilder.append(this.mPlayerRepeatMode);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle
 * JD-Core Version:    0.7.0.1
 */
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
    return "UIStyle{showVideoCoverList=" + this.showVideoCoverList + ", hideVideoDetailInfo=" + this.hideVideoDetailInfo + ", bottomWidgetShowFlag=" + this.bottomWidgetShowFlag + ", mPlayerRepeatMode=" + this.mPlayerRepeatMode + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle
 * JD-Core Version:    0.7.0.1
 */
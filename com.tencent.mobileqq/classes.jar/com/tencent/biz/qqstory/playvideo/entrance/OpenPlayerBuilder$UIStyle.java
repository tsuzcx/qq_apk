package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;

public class OpenPlayerBuilder$UIStyle
  implements Serializable
{
  public int bottomWidgetShowFlag;
  public boolean hideBannerInfo;
  public boolean hideMoreIcon;
  public boolean hideVideoDetailInfo;
  public boolean mForDebug;
  public int mPlayerRepeatMode = 0;
  public boolean showVideoCoverList = true;
  public boolean showVideoNoInteresting;
  
  public String toString()
  {
    return "UIStyle{showVideoCoverList=" + this.showVideoCoverList + ", hideVideoDetailInfo=" + this.hideVideoDetailInfo + ", bottomWidgetShowFlag=" + this.bottomWidgetShowFlag + ", mPlayerRepeatMode=" + this.mPlayerRepeatMode + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle
 * JD-Core Version:    0.7.0.1
 */
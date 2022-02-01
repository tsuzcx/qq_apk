package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;

public class OpenPlayerBuilder
{
  private OpenPlayerBuilder.Data a;
  
  public OpenPlayerBuilder(Serializable paramSerializable, int paramInt)
  {
    this.a = new OpenPlayerBuilder.Data(paramInt);
    this.a.mInfo = paramSerializable;
  }
  
  public OpenPlayerBuilder.Data a()
  {
    return this.a;
  }
  
  public OpenPlayerBuilder a()
  {
    this.a.mUIStyle.bottomWidgetShowFlag = 2;
    return this;
  }
  
  public OpenPlayerBuilder a(String paramString)
  {
    this.a.mReportData.openSessionId = paramString;
    return this;
  }
  
  public OpenPlayerBuilder a(boolean paramBoolean)
  {
    this.a.mUIStyle.showVideoCoverList = paramBoolean;
    return this;
  }
  
  public OpenPlayerBuilder b()
  {
    this.a.mUIStyle.hideMoreIcon = true;
    return this;
  }
  
  public OpenPlayerBuilder b(boolean paramBoolean)
  {
    this.a.mUIStyle.showVideoNoInteresting = paramBoolean;
    return this;
  }
  
  public OpenPlayerBuilder c()
  {
    this.a.mUIStyle.bottomWidgetShowFlag = 3;
    return this;
  }
  
  public OpenPlayerBuilder d()
  {
    this.a.mUIStyle.hideVideoDetailInfo = true;
    return this;
  }
  
  public OpenPlayerBuilder e()
  {
    this.a.mUIStyle.hideBannerInfo = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder
 * JD-Core Version:    0.7.0.1
 */
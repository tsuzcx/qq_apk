package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;

public class DetailLikeListLoader
{
  private String a;
  private boolean b = true;
  private int c = -1;
  private boolean d;
  
  public DetailLikeListLoader(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public DetailLikeListLoader(String paramString, boolean paramBoolean, int paramInt)
  {
    this.a = paramString;
    this.b = paramBoolean;
    this.c = paramInt;
  }
  
  private boolean a()
  {
    boolean bool = this.b;
    return (bool) && ((!bool) || (this.c != 0));
  }
  
  public void a(boolean paramBoolean)
  {
    DetailLikeListLoader.GetLikeListRequest localGetLikeListRequest = new DetailLikeListLoader.GetLikeListRequest();
    localGetLikeListRequest.e = this.a;
    localGetLikeListRequest.f = this.b;
    int i = this.c;
    if (i != -1) {
      localGetLikeListRequest.g = i;
    }
    CmdTaskManger.a().a(localGetLikeListRequest, new DetailLikeListLoader.2(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader
 * JD-Core Version:    0.7.0.1
 */
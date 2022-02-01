package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public abstract class BasePagePlayingListSync
  extends DefaultPlayerVideoListSynchronizer
{
  protected List<StoryVideoItem> b;
  public String c;
  protected boolean d;
  protected boolean e;
  public int f;
  public boolean g;
  protected String h;
  public boolean i;
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    if ((paramInt == -1) && (!this.a)) {
      a();
    }
    if (b(paramInt)) {
      b();
    }
  }
  
  protected abstract void b();
  
  protected boolean b(int paramInt)
  {
    if (this.d)
    {
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "not preload for end");
      return false;
    }
    if (this.e)
    {
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "can't preload for loading");
      return false;
    }
    paramInt = this.f - paramInt;
    if (paramInt < 2)
    {
      SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "can preload for left size:%d, preload size:%d", Integer.valueOf(paramInt), Integer.valueOf(2));
      return true;
    }
    return false;
  }
  
  public boolean isValidate()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BasePagePlayingListSync
 * JD-Core Version:    0.7.0.1
 */
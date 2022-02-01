package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public abstract class BasePagePlayingListSync
  extends DefaultPlayerVideoListSynchronizer
{
  public int a;
  public String a;
  protected List<StoryVideoItem> a;
  protected String b;
  protected boolean b;
  protected boolean c;
  public boolean d;
  public boolean e;
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    if ((paramInt == -1) && (!this.jdField_a_of_type_Boolean)) {
      a();
    }
    if (a(paramInt)) {
      b();
    }
  }
  
  protected boolean a(int paramInt)
  {
    if (this.b)
    {
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "not preload for end");
      return false;
    }
    if (this.c)
    {
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "can't preload for loading");
      return false;
    }
    paramInt = this.jdField_a_of_type_Int - paramInt;
    if (paramInt < 2)
    {
      SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "can preload for left size:%d, preload size:%d", Integer.valueOf(paramInt), Integer.valueOf(2));
      return true;
    }
    return false;
  }
  
  protected abstract void b();
  
  public boolean isValidate()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BasePagePlayingListSync
 * JD-Core Version:    0.7.0.1
 */
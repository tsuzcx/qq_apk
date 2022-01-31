package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.IEventReceiver;
import ncs;

public abstract class DefaultPlayerVideoListSynchronizer
  implements IEventReceiver
{
  public boolean a;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    Bosses.get().postJob(new ncs(this, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return false;
  }
  
  public void b() {}
  
  public abstract void b(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer
 * JD-Core Version:    0.7.0.1
 */
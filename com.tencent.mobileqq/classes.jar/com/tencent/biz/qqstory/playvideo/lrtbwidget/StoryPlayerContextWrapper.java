package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;

public class StoryPlayerContextWrapper
  extends StoryPlayerContext
{
  private StoryPlayerContext a;
  
  public Activity a()
  {
    return this.a.a();
  }
  
  public String a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public void a(Intent paramIntent)
  {
    this.a.a(paramIntent);
  }
  
  public void a(QQStoryObserver paramQQStoryObserver)
  {
    this.a.a(paramQQStoryObserver);
  }
  
  public void a(ActivityLifeCycle paramActivityLifeCycle)
  {
    this.a.a(paramActivityLifeCycle);
  }
  
  public void a(StoryPlayerContext paramStoryPlayerContext)
  {
    if (this.a == null)
    {
      this.a = paramStoryPlayerContext;
      return;
    }
    throw new IllegalStateException("Base context already set");
  }
  
  public void a(VideoHolderBase paramVideoHolderBase)
  {
    this.a.a(paramVideoHolderBase);
  }
  
  public void b(QQStoryObserver paramQQStoryObserver)
  {
    this.a.b(paramQQStoryObserver);
  }
  
  public void b(ActivityLifeCycle paramActivityLifeCycle)
  {
    this.a.b(paramActivityLifeCycle);
  }
  
  public boolean b()
  {
    return this.a.b();
  }
  
  public XViewPager c()
  {
    return this.a.c();
  }
  
  public OpenPlayerBuilder.Data i()
  {
    return this.a.i();
  }
  
  public PlayerStrategy j()
  {
    return this.a.j();
  }
  
  public StoryPlayerObjectRecycler k()
  {
    return this.a.k();
  }
  
  public boolean l()
  {
    return this.a.l();
  }
  
  public IDataProvider.StartInfo m()
  {
    return this.a.m();
  }
  
  public void n()
  {
    this.a.n();
  }
  
  public IDataProvider.GroupId o()
  {
    return this.a.o();
  }
  
  public StoryPlayerContext v()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerContextWrapper
 * JD-Core Version:    0.7.0.1
 */
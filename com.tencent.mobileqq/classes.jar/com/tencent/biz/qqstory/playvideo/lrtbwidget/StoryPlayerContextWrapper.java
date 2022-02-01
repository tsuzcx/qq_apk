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
  
  public IDataProvider.GroupId a()
  {
    return this.a.a();
  }
  
  public IDataProvider.StartInfo a()
  {
    return this.a.a();
  }
  
  public OpenPlayerBuilder.Data a()
  {
    return this.a.a();
  }
  
  public PlayerStrategy a()
  {
    return this.a.a();
  }
  
  public StoryPlayerContext a()
  {
    return this.a;
  }
  
  public StoryPlayerObjectRecycler a()
  {
    return this.a.a();
  }
  
  public XViewPager a()
  {
    return this.a.a();
  }
  
  public String a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public void a()
  {
    this.a.a();
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
    if (this.a != null) {
      throw new IllegalStateException("Base context already set");
    }
    this.a = paramStoryPlayerContext;
  }
  
  public void a(VideoHolderBase paramVideoHolderBase)
  {
    this.a.a(paramVideoHolderBase);
  }
  
  public boolean a()
  {
    return this.a.a();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerContextWrapper
 * JD-Core Version:    0.7.0.1
 */
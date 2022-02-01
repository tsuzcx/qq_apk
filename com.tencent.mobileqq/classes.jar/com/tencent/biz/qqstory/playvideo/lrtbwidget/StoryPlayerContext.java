package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;

public abstract class StoryPlayerContext
{
  public abstract Activity a();
  
  public abstract String a(String paramString);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(QQStoryObserver paramQQStoryObserver);
  
  public abstract void a(ActivityLifeCycle paramActivityLifeCycle);
  
  public abstract void a(VideoHolderBase paramVideoHolderBase);
  
  public abstract void b(QQStoryObserver paramQQStoryObserver);
  
  public abstract void b(ActivityLifeCycle paramActivityLifeCycle);
  
  public abstract boolean b();
  
  public abstract XViewPager c();
  
  public abstract OpenPlayerBuilder.Data i();
  
  public abstract PlayerStrategy j();
  
  public abstract StoryPlayerObjectRecycler k();
  
  public abstract boolean l();
  
  public abstract IDataProvider.StartInfo m();
  
  public abstract void n();
  
  public abstract IDataProvider.GroupId o();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerContext
 * JD-Core Version:    0.7.0.1
 */
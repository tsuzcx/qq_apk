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
  
  public abstract IDataProvider.GroupId a();
  
  public abstract IDataProvider.StartInfo a();
  
  public abstract OpenPlayerBuilder.Data a();
  
  public abstract PlayerStrategy a();
  
  public abstract StoryPlayerObjectRecycler a();
  
  public abstract XViewPager a();
  
  public abstract String a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(QQStoryObserver paramQQStoryObserver);
  
  public abstract void a(ActivityLifeCycle paramActivityLifeCycle);
  
  public abstract void a(VideoHolderBase paramVideoHolderBase);
  
  public abstract boolean a();
  
  public abstract void b(QQStoryObserver paramQQStoryObserver);
  
  public abstract void b(ActivityLifeCycle paramActivityLifeCycle);
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerContext
 * JD-Core Version:    0.7.0.1
 */
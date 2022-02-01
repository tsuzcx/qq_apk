package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayerStrategy;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerContext;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerObjectRecycler;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderBase;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class StoryPlayerImpl$StoryPlayerContextImpl
  extends StoryPlayerContext
  implements ActivityLifeCycle
{
  StoryPlayerObjectRecycler a = new StoryPlayerObjectRecycler();
  QQStoryObserver b = new StoryPlayerImpl.StoryPlayerContextImpl.1(this);
  private final StoryPlayerImpl.Ui d;
  private final XViewPager e;
  private final OpenPlayerBuilder.Data f;
  private final IDataProvider.StartInfo g;
  private final boolean h;
  private final PlayerStrategy i;
  private boolean j;
  private final CopyOnWriteArraySet<ActivityLifeCycle> k = new CopyOnWriteArraySet();
  private QQAppInterface l;
  private final Set<QQStoryObserver> m = new HashSet();
  
  private StoryPlayerImpl$StoryPlayerContextImpl(StoryPlayerImpl paramStoryPlayerImpl, StoryPlayerImpl.Ui paramUi, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, IDataProvider.StartInfo paramStartInfo)
  {
    paramStoryPlayerImpl = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramStoryPlayerImpl instanceof QQAppInterface))
    {
      this.l = ((QQAppInterface)paramStoryPlayerImpl);
      this.d = paramUi;
      this.e = paramXViewPager;
      this.f = paramData;
      this.g = new IDataProvider.StartInfo(paramStartInfo);
      this.i = PlayerStrategy.a(this);
      this.h = TVK_SDKMgr.isInstalled(paramUi.getContext());
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.h) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.d.getActivity();
  }
  
  public String a(String paramString)
  {
    return StoryPlayerImpl.b(this.c).a(paramString);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.k).iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.d.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.l.addObserver(this.b, false);
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(QQStoryObserver paramQQStoryObserver)
  {
    this.m.add(paramQQStoryObserver);
  }
  
  public void a(ActivityLifeCycle paramActivityLifeCycle)
  {
    this.k.add(paramActivityLifeCycle);
  }
  
  public void a(VideoHolderBase paramVideoHolderBase)
  {
    if (StoryPlayerImpl.b(this.c).b(paramVideoHolderBase)) {
      StoryPlayerImpl.a(this.c, paramVideoHolderBase);
    }
  }
  
  public void b(QQStoryObserver paramQQStoryObserver)
  {
    this.m.remove(paramQQStoryObserver);
  }
  
  public void b(ActivityLifeCycle paramActivityLifeCycle)
  {
    this.k.remove(paramActivityLifeCycle);
  }
  
  public boolean b()
  {
    return this.j;
  }
  
  public XViewPager c()
  {
    return this.e;
  }
  
  public void d()
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.j = true;
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    this.j = false;
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).g();
    }
  }
  
  public void h()
  {
    this.l.removeObserver(this.b);
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).h();
    }
  }
  
  public OpenPlayerBuilder.Data i()
  {
    return this.f;
  }
  
  public PlayerStrategy j()
  {
    return this.i;
  }
  
  public StoryPlayerObjectRecycler k()
  {
    return this.a;
  }
  
  public boolean l()
  {
    return this.h;
  }
  
  public IDataProvider.StartInfo m()
  {
    return this.g;
  }
  
  public void n()
  {
    StoryPlayerImpl.e(this.c).removeCallbacks(StoryPlayerImpl.d(this.c));
    StoryPlayerImpl.e(this.c).postDelayed(StoryPlayerImpl.d(this.c), 500L);
  }
  
  public IDataProvider.GroupId o()
  {
    return StoryPlayerImpl.b(this.c).o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.StoryPlayerContextImpl
 * JD-Core Version:    0.7.0.1
 */
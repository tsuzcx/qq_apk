package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BannerVideoInfoWidget3$BannerVideoInfoController
  implements IEventReceiver
{
  protected BannerVideoInfoWidget3 a;
  protected Set<ActivityLifeCycle> b;
  protected Map<Subscriber, String> c;
  protected boolean d;
  public boolean e;
  private long f = 0L;
  
  public Map<Subscriber, String> a()
  {
    return null;
  }
  
  public final void a(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    paramBannerViewHolder.a();
    b(paramBannerViewHolder, paramStoryPlayerVideoData);
  }
  
  public final void a(@NonNull BannerVideoInfoWidget3 paramBannerVideoInfoWidget3, int paramInt, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    BannerVideoInfoWidget3.a(paramBannerVideoInfoWidget3, paramInt);
    this.a = paramBannerVideoInfoWidget3;
    if (!this.d)
    {
      Object localObject1 = a();
      if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
      {
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          StoryDispatcher.a().registerSubscriber((String)localObject2, localSubscriber);
        }
        if (this.c == null) {
          this.c = new HashMap();
        }
        this.c.putAll((Map)localObject1);
      }
      localObject1 = b();
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
      {
        if (this.b == null) {
          this.b = new HashSet();
        }
        this.b.addAll((Collection)localObject1);
      }
      this.d = true;
    }
    a(paramBannerVideoInfoWidget3.u, paramStoryPlayerVideoData);
  }
  
  public boolean a(View paramView)
  {
    if (System.currentTimeMillis() - this.f < 500L) {
      return false;
    }
    this.f = System.currentTimeMillis();
    return true;
  }
  
  public Set<ActivityLifeCycle> b()
  {
    return null;
  }
  
  public abstract void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData);
  
  public void c()
  {
    Object localObject1 = this.c;
    Object localObject2;
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      localObject1 = this.c.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Subscriber)((Map.Entry)((Iterator)localObject1).next()).getKey();
        StoryDispatcher.a().unRegisterSubscriber((Subscriber)localObject2);
      }
      this.c.clear();
    }
    localObject1 = this.b;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
    {
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivityLifeCycle)((Iterator)localObject1).next();
        this.a.b((ActivityLifeCycle)localObject2);
      }
      this.b.clear();
    }
  }
  
  public boolean isValidate()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3.BannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */
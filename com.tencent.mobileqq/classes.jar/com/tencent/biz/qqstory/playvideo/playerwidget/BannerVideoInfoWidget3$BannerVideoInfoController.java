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
  private long a;
  protected BannerVideoInfoWidget3 a;
  protected Map<Subscriber, String> a;
  protected Set<ActivityLifeCycle> a;
  protected boolean a;
  public boolean b;
  
  public BannerVideoInfoWidget3$BannerVideoInfoController()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public Map<Subscriber, String> a()
  {
    return null;
  }
  
  public Set<ActivityLifeCycle> a()
  {
    return null;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap;
    Object localObject2;
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Subscriber)((Map.Entry)((Iterator)localObject1).next()).getKey();
        StoryDispatcher.a().unRegisterSubscriber((Subscriber)localObject2);
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    localObject1 = this.jdField_a_of_type_JavaUtilSet;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivityLifeCycle)((Iterator)localObject1).next();
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b((ActivityLifeCycle)localObject2);
      }
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public final void a(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    paramBannerViewHolder.a();
    b(paramBannerViewHolder, paramStoryPlayerVideoData);
  }
  
  public final void a(@NonNull BannerVideoInfoWidget3 paramBannerVideoInfoWidget3, int paramInt, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    BannerVideoInfoWidget3.a(paramBannerVideoInfoWidget3, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3 = paramBannerVideoInfoWidget3;
    if (!this.jdField_a_of_type_Boolean)
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
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          this.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilMap.putAll((Map)localObject1);
      }
      localObject1 = a();
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
      {
        if (this.jdField_a_of_type_JavaUtilSet == null) {
          this.jdField_a_of_type_JavaUtilSet = new HashSet();
        }
        this.jdField_a_of_type_JavaUtilSet.addAll((Collection)localObject1);
      }
      this.jdField_a_of_type_Boolean = true;
    }
    a(paramBannerVideoInfoWidget3.a, paramStoryPlayerVideoData);
  }
  
  public boolean a(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return false;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  public abstract void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData);
  
  public boolean isValidate()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3.BannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */
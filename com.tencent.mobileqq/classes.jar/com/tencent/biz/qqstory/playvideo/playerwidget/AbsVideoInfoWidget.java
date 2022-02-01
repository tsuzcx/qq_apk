package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.GroupHolderBase;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class AbsVideoInfoWidget
  extends GroupHolderBase
  implements IEventReceiver
{
  protected final String i;
  protected Dialog j;
  protected AbsVideoInfoWidget.ProgressView k;
  protected Map<Subscriber, String> l = new HashMap();
  protected boolean m = false;
  protected boolean n = false;
  protected boolean o = false;
  @Nullable
  public StoryPlayerVideoData p;
  public Handler q = new Handler(Looper.getMainLooper());
  public AbsVideoInfoWidget.MyActivityLifeCycle r;
  
  public AbsVideoInfoWidget(View paramView)
  {
    super(paramView);
    paramView = new StringBuilder();
    paramView.append("Q.qqstory.player.videoinfowidget.");
    paramView.append(t());
    this.i = paramView.toString();
  }
  
  public AbsVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("Q.qqstory.player.videoinfowidget.");
    paramViewGroup.append(t());
    this.i = paramViewGroup.toString();
  }
  
  private final void a(StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    if ((paramStoryPlayerVideoData != null) && (paramStoryPlayerVideoData.d()))
    {
      this.p = paramStoryPlayerVideoData;
      StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).b(paramStoryPlayerVideoData.b);
      if ((localStoryVideoItem != null) && (localStoryVideoItem.mErrorCode == 0))
      {
        if (a(paramStoryPlayerVideoData, localStoryVideoItem))
        {
          w();
          z();
          b(paramStoryPlayerVideoData, localStoryVideoItem);
          return;
        }
        A();
        return;
      }
      A();
      return;
    }
    this.p = null;
    A();
  }
  
  private final void h()
  {
    this.m = true;
    AbsVideoInfoWidget.GetVideoBasicListReceiver localGetVideoBasicListReceiver = new AbsVideoInfoWidget.GetVideoBasicListReceiver(this);
    this.l.clear();
    this.l.put(localGetVideoBasicListReceiver, "");
    StoryDispatcher.a().registerSubscriber("", localGetVideoBasicListReceiver);
    this.r = new AbsVideoInfoWidget.MyActivityLifeCycle(this);
    a(this.r);
    SLog.b(this.i, "onWidgetCreate!");
  }
  
  private final void p()
  {
    if (this.n) {
      r();
    }
    this.m = false;
    this.n = false;
    Object localObject = this.l.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)((Iterator)localObject).next()).getKey();
      StoryDispatcher.a().unRegisterSubscriber(localSubscriber);
    }
    this.l.clear();
    localObject = this.r;
    if (localObject != null) {
      b((ActivityLifeCycle)localObject);
    }
    SLog.b(this.i, "onWidgetDestroy!");
  }
  
  public final void A()
  {
    a(8);
  }
  
  public final boolean B()
  {
    return g() == 0;
  }
  
  public final int C()
  {
    return i().mReportData.from;
  }
  
  final String D()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((StoryPlayerVideoData)localObject).f();
      if ((localObject != null) && ((localObject instanceof ShareGroupFeedItem))) {
        return ((ShareGroupFeedItem)localObject).getOwner().getUnionId();
      }
    }
    return "";
  }
  
  public final void E()
  {
    this.q.removeCallbacksAndMessages(null);
    this.q.post(new AbsVideoInfoWidget.3(this));
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public final void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    boolean bool = this.h;
    super.a(paramInt, paramGroupInfo, paramArrayList);
    if (!bool) {
      h();
    }
    paramInt = ((StoryPlayerGroupHolder)d()).l;
    if ((paramInt < this.f.size()) && (paramInt >= 0))
    {
      a((StoryPlayerVideoData)this.f.get(paramInt));
      return;
    }
    SLog.d(this.i, "Position error , bind data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.f.size()) });
    x();
  }
  
  protected abstract void a(View paramView);
  
  public final void a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, true, 0L);
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, paramBoolean, 0L);
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    Activity localActivity = y();
    this.q.removeCallbacksAndMessages(null);
    this.q.postDelayed(new AbsVideoInfoWidget.2(this, localActivity, paramBoolean, paramCharSequence), paramLong);
  }
  
  protected abstract void a(@NonNull Map<Subscriber, String> paramMap);
  
  protected abstract boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem);
  
  protected abstract void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem);
  
  protected final void e()
  {
    super.e();
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)d();
    localStoryPlayerGroupHolder.j.a(new AbsVideoInfoWidget.1(this, localStoryPlayerGroupHolder));
  }
  
  public final void f()
  {
    super.f();
    p();
  }
  
  public final boolean isValidate()
  {
    return this.m;
  }
  
  protected abstract void q();
  
  protected abstract void r();
  
  protected abstract int s();
  
  public abstract String t();
  
  protected void w()
  {
    if (!this.n)
    {
      this.n = true;
      q();
      HashMap localHashMap = new HashMap();
      a(localHashMap);
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        StoryDispatcher.a().registerSubscriber((String)localObject, localSubscriber);
      }
      this.l.putAll(localHashMap);
      if (!this.o)
      {
        this.o = true;
        if (s() != -1)
        {
          AssertUtils.assertTrue(this.b instanceof ViewGroup);
          LayoutInflater.from(this.b.getContext()).inflate(s(), (ViewGroup)this.b, true);
        }
        a(this.b);
      }
    }
  }
  
  protected final void x()
  {
    a(this.p);
  }
  
  public final Activity y()
  {
    return a();
  }
  
  public final void z()
  {
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */
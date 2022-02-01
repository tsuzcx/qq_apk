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
  protected Dialog a;
  public Handler a;
  @Nullable
  public StoryPlayerVideoData a;
  public AbsVideoInfoWidget.MyActivityLifeCycle a;
  protected AbsVideoInfoWidget.ProgressView a;
  protected Map<Subscriber, String> a;
  protected final String b;
  protected boolean c = false;
  protected boolean d = false;
  protected boolean e = false;
  
  public AbsVideoInfoWidget(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramView = new StringBuilder();
    paramView.append("Q.qqstory.player.videoinfowidget.");
    paramView.append(a());
    this.jdField_b_of_type_JavaLangString = paramView.toString();
  }
  
  public AbsVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("Q.qqstory.player.videoinfowidget.");
    paramViewGroup.append(a());
    this.jdField_b_of_type_JavaLangString = paramViewGroup.toString();
  }
  
  private final void a(StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    if ((paramStoryPlayerVideoData != null) && (paramStoryPlayerVideoData.c()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = paramStoryPlayerVideoData;
      StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).b(paramStoryPlayerVideoData.a);
      if ((localStoryVideoItem != null) && (localStoryVideoItem.mErrorCode == 0))
      {
        if (a(paramStoryPlayerVideoData, localStoryVideoItem))
        {
          h();
          j();
          a(paramStoryPlayerVideoData, localStoryVideoItem);
          return;
        }
        k();
        return;
      }
      k();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = null;
    k();
  }
  
  private final void d()
  {
    this.c = true;
    AbsVideoInfoWidget.GetVideoBasicListReceiver localGetVideoBasicListReceiver = new AbsVideoInfoWidget.GetVideoBasicListReceiver(this);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.put(localGetVideoBasicListReceiver, "");
    StoryDispatcher.a().registerSubscriber("", localGetVideoBasicListReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$MyActivityLifeCycle = new AbsVideoInfoWidget.MyActivityLifeCycle(this);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$MyActivityLifeCycle);
    SLog.b(this.jdField_b_of_type_JavaLangString, "onWidgetCreate!");
  }
  
  private final void e()
  {
    if (this.d) {
      g();
    }
    this.c = false;
    this.d = false;
    Object localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)((Iterator)localObject).next()).getKey();
      StoryDispatcher.a().unRegisterSubscriber(localSubscriber);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$MyActivityLifeCycle;
    if (localObject != null) {
      b((ActivityLifeCycle)localObject);
    }
    SLog.b(this.jdField_b_of_type_JavaLangString, "onWidgetDestroy!");
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public abstract String a();
  
  public final void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    super.a(paramInt, paramGroupInfo, paramArrayList);
    if (!bool) {
      d();
    }
    paramInt = ((StoryPlayerGroupHolder)a()).b;
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt >= 0))
    {
      a((StoryPlayerVideoData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      return;
    }
    SLog.d(this.jdField_b_of_type_JavaLangString, "Position error , bind data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    i();
  }
  
  protected abstract void a(View paramView);
  
  protected abstract void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem);
  
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
    Activity localActivity = b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AbsVideoInfoWidget.2(this, localActivity, paramBoolean, paramCharSequence), paramLong);
  }
  
  protected abstract void a(@NonNull Map<Subscriber, String> paramMap);
  
  protected abstract boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem);
  
  protected abstract int b();
  
  public final Activity b()
  {
    return a();
  }
  
  final String b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
    if (localObject != null)
    {
      localObject = ((StoryPlayerVideoData)localObject).a();
      if ((localObject != null) && ((localObject instanceof ShareGroupFeedItem))) {
        return ((ShareGroupFeedItem)localObject).getOwner().getUnionId();
      }
    }
    return "";
  }
  
  protected final void b()
  {
    super.b();
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)a();
    localStoryPlayerGroupHolder.a.a(new AbsVideoInfoWidget.1(this, localStoryPlayerGroupHolder));
  }
  
  public final int c()
  {
    return a().mReportData.from;
  }
  
  public final void c()
  {
    super.c();
    e();
  }
  
  public final boolean c()
  {
    return a() == 0;
  }
  
  protected abstract void f();
  
  protected abstract void g();
  
  protected void h()
  {
    if (!this.d)
    {
      this.d = true;
      f();
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
      this.jdField_a_of_type_JavaUtilMap.putAll(localHashMap);
      if (!this.e)
      {
        this.e = true;
        if (b() != -1)
        {
          AssertUtils.assertTrue(this.jdField_a_of_type_AndroidViewView instanceof ViewGroup);
          LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(b(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, true);
        }
        a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  protected final void i()
  {
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData);
  }
  
  public final boolean isValidate()
  {
    return this.c;
  }
  
  public final void j()
  {
    a(0);
  }
  
  public final void k()
  {
    a(8);
  }
  
  public final void l()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new AbsVideoInfoWidget.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */
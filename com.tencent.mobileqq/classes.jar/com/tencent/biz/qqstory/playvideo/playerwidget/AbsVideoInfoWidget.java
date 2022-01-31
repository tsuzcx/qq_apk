package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
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
import umc;
import uvx;
import uwa;
import vpn;
import vsi;
import vtt;
import vza;
import vzb;
import vzc;
import wxe;
import xqq;

public abstract class AbsVideoInfoWidget
  extends vsi
  implements IEventReceiver
{
  protected Dialog a;
  public Handler a;
  protected AbsVideoInfoWidget.ProgressView a;
  protected Map<Subscriber, String> a;
  @Nullable
  public vtt a;
  public vzc a;
  public final String b;
  public boolean b;
  protected boolean c;
  protected boolean d;
  
  public AbsVideoInfoWidget(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.player.videoinfowidget." + a());
  }
  
  public AbsVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.player.videoinfowidget." + a());
  }
  
  private final void a(vtt paramvtt)
  {
    if ((paramvtt == null) || (!paramvtt.c()))
    {
      this.jdField_a_of_type_Vtt = null;
      k();
      return;
    }
    this.jdField_a_of_type_Vtt = paramvtt;
    StoryVideoItem localStoryVideoItem = ((uvx)uwa.a(5)).b(paramvtt.a);
    if ((localStoryVideoItem == null) || (localStoryVideoItem.mErrorCode != 0))
    {
      k();
      return;
    }
    if (a(paramvtt, localStoryVideoItem))
    {
      h();
      j();
      a(paramvtt, localStoryVideoItem);
      return;
    }
    k();
  }
  
  private final void d()
  {
    this.jdField_b_of_type_Boolean = true;
    vzb localvzb = new vzb(this);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.put(localvzb, "");
    umc.a().registerSubscriber("", localvzb);
    this.jdField_a_of_type_Vzc = new vzc(this);
    a(this.jdField_a_of_type_Vzc);
    wxe.b(this.jdField_b_of_type_JavaLangString, "onWidgetCreate!");
  }
  
  private final void e()
  {
    if (this.c) {
      g();
    }
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      umc.a().unRegisterSubscriber(localSubscriber);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_Vzc != null) {
      b(this.jdField_a_of_type_Vzc);
    }
    wxe.b(this.jdField_b_of_type_JavaLangString, "onWidgetDestroy!");
  }
  
  public final View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public abstract String a();
  
  public final void a(int paramInt, vpn paramvpn, @NonNull ArrayList<vtt> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramvpn, paramArrayList);
    if (!bool) {
      d();
    }
    paramInt = ((StoryPlayerGroupHolder)a()).b;
    if ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0))
    {
      wxe.d(this.jdField_b_of_type_JavaLangString, "Position error , bind data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      i();
      return;
    }
    a((vtt)this.jdField_a_of_type_JavaUtilList.get(paramInt));
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
    Activity localActivity = b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AbsVideoInfoWidget.2(this, localActivity, paramBoolean, paramCharSequence), paramLong);
  }
  
  protected abstract void a(@NonNull Map<Subscriber, String> paramMap);
  
  protected abstract void a(@NonNull vtt paramvtt, @NonNull StoryVideoItem paramStoryVideoItem);
  
  protected abstract boolean a(@NonNull vtt paramvtt, @NonNull StoryVideoItem paramStoryVideoItem);
  
  protected abstract int b();
  
  public final Activity b()
  {
    return a();
  }
  
  public final String b()
  {
    if (this.jdField_a_of_type_Vtt != null)
    {
      VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Vtt.a();
      if ((localVideoListFeedItem != null) && ((localVideoListFeedItem instanceof ShareGroupFeedItem))) {
        return ((ShareGroupFeedItem)localVideoListFeedItem).getOwner().getUnionId();
      }
    }
    return "";
  }
  
  public final void b()
  {
    super.b();
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)a();
    localStoryPlayerGroupHolder.a.a(new vza(this, localStoryPlayerGroupHolder));
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
    if (!this.c)
    {
      this.c = true;
      f();
      HashMap localHashMap = new HashMap();
      a(localHashMap);
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        umc.a().registerSubscriber((String)localObject, localSubscriber);
      }
      this.jdField_a_of_type_JavaUtilMap.putAll(localHashMap);
      if (!this.d)
      {
        this.d = true;
        if (b() != -1)
        {
          xqq.a(this.jdField_a_of_type_AndroidViewView instanceof ViewGroup);
          LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(b(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, true);
        }
        a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public final void i()
  {
    a(this.jdField_a_of_type_Vtt);
  }
  
  public final boolean isValidate()
  {
    return this.jdField_b_of_type_Boolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */
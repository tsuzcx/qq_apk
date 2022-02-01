package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.widget.XListView;
import java.util.List;

public class QQStoryWatcherListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private static final String q = HardCodeUtil.a(2131908741);
  XListView a;
  View b;
  TextView c;
  TextView d;
  TextView e;
  View f;
  View g;
  QQStoryWatcherListAdapter h;
  QQStoryWatcherListActivity.GetWatcherHelper i;
  String j;
  VideoListFeedItem k;
  int l;
  boolean m = true;
  boolean n = false;
  Drawable o;
  protected ChildViewClickListener p = new QQStoryWatcherListActivity.3(this);
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, QQStoryWatcherListActivity.class);
    localIntent.putExtra("feed_id", paramString);
    localIntent.putExtra("source", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, List<QQUserUIItem> paramList)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQStoryWatcherListActivity.2(this, paramBoolean1, paramBoolean2, paramList));
      return;
    }
    b(paramBoolean1, paramBoolean2, paramList);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, List<QQUserUIItem> paramList)
  {
    if (!paramBoolean1)
    {
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.b.setVisibility(0);
      this.a.setVisibility(8);
      return;
    }
    if (paramList != null)
    {
      this.n = paramBoolean2;
      if (this.m)
      {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        if (paramList.size() == 0)
        {
          this.g.setVisibility(0);
          this.a.setVisibility(8);
        }
        else
        {
          this.g.setVisibility(8);
          this.a.setVisibility(0);
          this.h.a(paramList);
        }
        this.m = false;
      }
      else
      {
        this.h.b(paramList);
      }
      if (paramBoolean2)
      {
        a(3);
        return;
      }
      a(1);
      return;
    }
    this.c.setVisibility(8);
    this.b.setVisibility(8);
    this.g.setVisibility(0);
    this.a.setVisibility(8);
    this.n = paramBoolean2;
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            if (this.i.i >= 2000L)
            {
              a(0);
            }
            else
            {
              this.f.setVisibility(0);
              localObject = String.format("%s人累计浏览%s次", new Object[] { UIUtils.a(this.i.i), UIUtils.a(this.i.j) });
              this.e.setText((CharSequence)localObject);
              this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              ((Animatable)this.o).stop();
              this.e.setOnClickListener(null);
            }
          }
        }
        else
        {
          this.f.setVisibility(0);
          this.e.setText(HardCodeUtil.a(2131908746));
          this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          ((Animatable)this.o).stop();
          this.e.setOnClickListener(this);
        }
      }
      else
      {
        this.f.setVisibility(0);
        this.e.setText(HardCodeUtil.a(2131908740));
        this.e.setCompoundDrawables(this.o, null, null, null);
        ((Animatable)this.o).start();
        this.e.setOnClickListener(null);
      }
    }
    else
    {
      this.f.setVisibility(8);
      this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      ((Animatable)this.o).stop();
      this.e.setOnClickListener(null);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFooterText: footerMode = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131628214);
    super.setTitle(q);
    this.leftView.setText(2131887625);
    super.findViewById(2131445137).setBackgroundColor(getResources().getColor(2131168094));
    this.b = super.findViewById(2131442635);
    this.c = ((TextView)super.findViewById(2131442794));
    this.a = ((XListView)super.findViewById(2131450033));
    this.g = super.findViewById(2131432533);
    this.d = ((TextView)super.findViewById(2131444737));
    try
    {
      this.d.setCompoundDrawablesWithIntrinsicBounds(0, 2130848407, 0, 0);
    }
    catch (OutOfMemoryError paramBundle)
    {
      CaughtExceptionReport.a(paramBundle);
    }
    this.d.setOnClickListener(this);
    this.f = LayoutInflater.from(this).inflate(2131628212, null);
    this.a.addFooterView(this.f);
    this.e = ((TextView)this.f.findViewById(2131437289));
    this.h = new QQStoryWatcherListAdapter(this, null);
    this.a.setAdapter(this.h);
    this.a.setOnScrollListener(new QQStoryWatcherListActivity.1(this));
    this.j = super.getIntent().getStringExtra("feed_id");
    this.l = super.getIntent().getIntExtra("source", 0);
    if (TextUtils.isEmpty(this.j))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, "doOnCreate: feedid is null!!!!");
      }
      return true;
    }
    this.k = ((VideoListFeedItem)((FeedManager)SuperManager.a(11)).b(this.j));
    paramBundle = this.k;
    if ((paramBundle != null) && (paramBundle.mViewTotalTime > 0L))
    {
      paramBundle = new StringBuilder();
      paramBundle.append(q);
      paramBundle.append(UIUtils.a(this.k.mViewTotalTime));
      super.setTitle(paramBundle.toString());
    }
    this.h.a(this.p);
    this.o = getResources().getDrawable(2130839585);
    paramBundle = this.o;
    paramBundle.setBounds(0, 0, paramBundle.getMinimumWidth(), this.o.getMinimumHeight());
    this.i = new QQStoryWatcherListActivity.GetWatcherHelper(this, this.j);
    this.i.a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Drawable localDrawable = this.o;
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131444737)
    {
      QQStoryWatcherListActivity.GetWatcherHelper localGetWatcherHelper = this.i;
      if (localGetWatcherHelper != null)
      {
        localGetWatcherHelper.a();
        this.d.setVisibility(8);
        this.c.setVisibility(0);
        this.b.setVisibility(0);
      }
    }
    else if (i1 == 2131437289)
    {
      a(1);
      QQStoryWatcherListActivity.GetWatcherHelper.a(this.i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity
 * JD-Core Version:    0.7.0.1
 */
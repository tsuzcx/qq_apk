package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryFailCommentCacher;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class Now
  extends Frame
{
  protected boolean a = false;
  ImmersiveTitleBar2 b;
  RelativeLayout c;
  RelativeLayout d;
  TextView e;
  TextView f;
  ImageView g;
  TextView h;
  protected StoryConfigManager i;
  protected ProgressBar j;
  public boolean k = false;
  public String l;
  protected QQStoryMainController m = new QQStoryMainController(new Now.2(this), QQStoryMainController.s);
  private RelativeLayout n;
  private MystoryListView o;
  private RelativeLayout p;
  private final Runnable q = new Now.1(this);
  private long r = -1L;
  
  public static void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 3: 
    case 12: 
    default: 
      paramInt2 = 2;
      break;
    case 8: 
    case 9: 
      paramInt2 = 3;
      break;
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 10: 
    case 11: 
    case 13: 
      paramInt2 = 4;
    }
    StoryReportor.a("home_page", "time_stay", paramInt2, paramInt1, new String[] { "1", "1" });
  }
  
  private void l()
  {
    this.m.c(false);
  }
  
  private void m()
  {
    this.b = ((ImmersiveTitleBar2)d(2131447582));
    IphoneTitleBarActivity.setLayerType(this.b);
    this.c = ((RelativeLayout)this.d.findViewById(2131447484));
    IphoneTitleBarActivity.setLayerType((ViewGroup)d(2131444897));
    this.n = ((RelativeLayout)this.d.findViewById(2131439491));
    this.n.setOnClickListener(new Now.4(this));
    this.e = ((TextView)d(2131436227));
    this.f = ((TextView)d(2131429704));
    this.e.setText(2131917006);
    this.f.setVisibility(8);
    this.g = ((ImageView)d(2131436202));
    this.h = ((TextView)d(2131448243));
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.j = ((ProgressBar)d(2131442792));
    this.j.setVisibility(8);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.c, true);
      a(this.b, true);
      a(this.n, true);
      this.e.setTextColor(-1);
      this.h.setTextColor(-1);
    }
    else
    {
      a(this.b, false);
      this.c.setBackgroundResource(2130852228);
      this.n.setBackgroundResource(2130852228);
      this.e.setTextColor(Q().getColorStateList(2131167990));
      this.h.setTextColor(Q().getColorStateList(2131167990));
    }
    SimpleUIUtil.a(this.b, P().getWindow());
  }
  
  private void n()
  {
    this.o = ((MystoryListView)d(2131442772));
    this.p = ((RelativeLayout)d(2131442723));
    this.o.setIsNowTab(true);
    this.o.setDivider(null);
    ((ViewGroup)this.o.getParent()).setBackgroundColor(Q().getColor(2131168094));
  }
  
  private void o()
  {
    ProgressBar localProgressBar = this.j;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(0);
    }
  }
  
  private void p()
  {
    ProgressBar localProgressBar = this.j;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(8);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    SLog.b("Q.qqstory.home:NowTab", "Now tab run onCreateView!");
    this.d = ((RelativeLayout)paramLayoutInflater.inflate(2131628103, null));
    return this.d;
  }
  
  protected void a()
  {
    super.a();
    this.i = ((StoryConfigManager)SuperManager.a(10));
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onCreate! action:%d", new Object[] { Integer.valueOf(P().getIntent().getIntExtra("action", 0)) });
    m();
    n();
    this.m.a(null);
    this.a = true;
    StoryUploadProcessor.checkUploadSessionKey();
    ((TrimmableManager)SuperManager.a(26)).a(0);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.m.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
    this.m.a(paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    SLog.a("Q.qqstory.home:NowTab", "Now tab run onResume! tabChange=%s", Boolean.valueOf(paramBoolean));
    paramBoolean = this.m.o();
    this.m.b(P());
    if (this.k)
    {
      if (FrameHelperActivity.G())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.H();
      }
      this.k = false;
    }
    if (!paramBoolean) {
      l();
    }
    Handler localHandler = new Handler();
    localHandler.removeCallbacks(this.q);
    localHandler.postDelayed(this.q, 100L);
    ApngImage.playByTag(5);
    Bosses.get().postLightWeightJob(new Now.3(this), 10);
    this.r = SystemClock.elapsedRealtime();
  }
  
  public void b(boolean paramBoolean) {}
  
  protected void bF_()
  {
    if (this.o.getFirstVisiblePosition() > 0) {
      this.o.setSelection(0);
    }
  }
  
  public void bQ_()
  {
    super.bQ_();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onPause!");
    this.m.b();
    new Handler().removeCallbacks(this.q);
    ApngImage.pauseByTag(5);
    this.m.n();
    if ((this.r > 0L) && (P().isResume()))
    {
      int i1 = P().getIntent().getIntExtra("action", 0);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.r;
      this.r = -1L;
      a((int)(l1 - l2), i1);
    }
  }
  
  public void c()
  {
    super.c();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onStop!");
    this.m.c(P());
  }
  
  protected void c(boolean paramBoolean)
  {
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    int i1 = 0;
    if (((Boolean)((StoryConfigManager)localObject).c("upload_video_use_bdh", Boolean.valueOf(false))).booleanValue())
    {
      localObject = P().findViewById(16908307);
      P().findViewById(16908305);
      if (!paramBoolean) {
        i1 = 8;
      }
      if (paramBoolean) {
        Q().getDimensionPixelSize(2131297771);
      }
      if (localObject != null) {
        ((View)localObject).setVisibility(i1);
      }
    }
  }
  
  public void cx_()
  {
    super.cx_();
    bF_();
    SLog.b("Q.qqstory.home:NowTab", "Now tab onFrameTabClick--------------");
  }
  
  protected void d()
  {
    super.d();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onDestroy!");
    this.m.d(P());
    StoryFailCommentCacher.a().c();
  }
  
  protected void f()
  {
    super.f();
    this.m.m();
    this.m.c();
  }
  
  public boolean h()
  {
    if (this.m.n()) {
      return true;
    }
    return super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now
 * JD-Core Version:    0.7.0.1
 */
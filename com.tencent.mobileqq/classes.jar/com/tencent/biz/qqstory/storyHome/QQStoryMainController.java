package com.tencent.biz.qqstory.storyHome;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.PullRefreshListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.TakeVideoButtonMainPart;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.StorySimpleLoadView;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.Map;
import mqq.os.MqqHandler;

public class QQStoryMainController
  implements QQStoryHomeJumpHelper.JumpListener, IMyStoryListView, MystoryListView.PullRefreshListener
{
  public static final int[] s = { 2131450138, 2131450137, 2131442727, 2131442751 };
  public static final int[] t = { 2131450138, 2131450137, 2131442727, 2131442726 };
  private long A;
  private boolean B = false;
  private boolean C = false;
  private Handler D;
  private GetRedPointExObserver E = new QQStoryMainController.7(this);
  private final int F = 1;
  public Activity a;
  public MystoryListView b;
  public StorySimpleLoadView c;
  public QQAppInterface d;
  public FeedManager e;
  public StoryInputBarView f;
  public StoryListPresenter g;
  public QQStoryMainController.ScreenActionBroadcastReceiver h;
  public QQStoryMainController.QQStoryMainView i;
  public View j;
  public TakeVideoButtonMainPart k;
  public StoryHomePushYellowBarHandler l = new StoryHomePushYellowBarHandler();
  public boolean m = false;
  public boolean n = false;
  public NewMessageYellowBar o;
  public View p;
  public OnItemSelectListener q = new QQStoryMainController.9(this);
  public int[] r = null;
  private ImageView v;
  private TextView w;
  private boolean x;
  private QQStoryHomeJumpHelper y;
  private boolean z;
  
  public QQStoryMainController(QQStoryMainController.QQStoryMainView paramQQStoryMainView, int[] paramArrayOfInt)
  {
    this.i = paramQQStoryMainView;
    this.r = paramArrayOfInt;
    this.D = new QQStoryMainController.ControllerHandler(this, null);
  }
  
  public static void a(Activity paramActivity, String paramString, ImageView paramImageView, TextView paramTextView)
  {
    if (paramTextView != null)
    {
      if (paramImageView == null) {
        return;
      }
      paramImageView.setVisibility(8);
      paramTextView.setVisibility(8);
      Object localObject1 = new QQStoryMainActivity.ButtonConfig(paramString);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initRightHallButton config = ");
      ((StringBuilder)localObject2).append(localObject1);
      SLog.d("Q.qqstory.home.QQStoryMainActivity", ((StringBuilder)localObject2).toString());
      if (((QQStoryMainActivity.ButtonConfig)localObject1).a != 0)
      {
        if (((QQStoryMainActivity.ButtonConfig)localObject1).a == 3) {
          return;
        }
        localObject2 = paramActivity.getResources().getDrawable(2130848465);
        if ((!TextUtils.isEmpty(((QQStoryMainActivity.ButtonConfig)localObject1).b)) && (HttpUtil.isValidUrl(((QQStoryMainActivity.ButtonConfig)localObject1).b)))
        {
          Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = DisplayUtil.a(paramActivity, 28.0F);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
          localObject3 = URLDrawable.getDrawable(((QQStoryMainActivity.ButtonConfig)localObject1).b, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setURLDrawableListener(new QQStoryMainController.1(paramImageView, (Drawable)localObject2));
          paramImageView.setVisibility(0);
          paramImageView.setContentDescription(HardCodeUtil.a(2131908544));
          paramImageView.setImageDrawable((Drawable)localObject3);
        }
        else if (!TextUtils.isEmpty(((QQStoryMainActivity.ButtonConfig)localObject1).c))
        {
          paramTextView.setVisibility(0);
          paramTextView.setText(((QQStoryMainActivity.ButtonConfig)localObject1).c);
        }
        else
        {
          paramImageView.setVisibility(0);
          paramImageView.setContentDescription(HardCodeUtil.a(2131908553));
          paramImageView.setImageDrawable((Drawable)localObject2);
        }
        paramImageView.getLayoutParams().width = -2;
        paramImageView.setPadding(0, 0, DisplayUtil.a(paramActivity, 5.0F), 0);
        localObject1 = new QQStoryMainController.2((QQStoryMainActivity.ButtonConfig)localObject1, paramActivity, paramString);
        paramImageView.setOnClickListener((View.OnClickListener)localObject1);
        paramTextView.setOnClickListener((View.OnClickListener)localObject1);
        if ("troopStoryHallConfig".equals(paramString)) {
          StoryReportor.a("story_grp", "exp_find_left", 0, 0, new String[] { "", "", "", "" });
        } else {
          StoryReportor.a("home_page", "push_find", 0, 0, new String[0]);
        }
        if ((paramActivity instanceof QQStoryMainActivity)) {
          StoryReportor.a("content_flow", "exp_entry", 0, 0, new String[0]);
        }
      }
    }
  }
  
  private void p()
  {
    ThreadManager.getUIHandler().postDelayed(new QQStoryMainController.4(this), 500L);
  }
  
  private void q()
  {
    this.d = QQStoryContext.j();
    Object localObject = (QQStoryManager)this.d.getManager(QQManagerFactory.QQSTORY_MANAGER);
    if ((!u) && (localObject == null)) {
      throw new AssertionError();
    }
    d();
    localObject = this.a.getIntent().getStringExtra("lebaVersion");
    String str = this.a.getIntent().getStringExtra("redid");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("story main from lebaVersion ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(str);
    SLog.b("Q.qqstory.home.position", localStringBuilder.toString());
    this.e = ((FeedManager)SuperManager.a(11));
    this.m = this.e.a("old".equals(localObject), TextUtils.isEmpty(str) ^ true);
    Bosses.get().postJob(new QQStoryMainController.5(this, "QQStoryMainController"));
    this.e = ((FeedManager)SuperManager.a(11));
    this.e.g.clear();
  }
  
  public NewMessageYellowBar a()
  {
    boolean bool;
    if (this.r != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    if (this.o == null)
    {
      ViewStub localViewStub = (ViewStub)this.p.findViewById(this.r[0]);
      if (localViewStub != null) {
        this.o = ((NewMessageYellowBar)localViewStub.inflate());
      } else {
        this.o = ((NewMessageYellowBar)this.p.findViewById(this.r[1]));
      }
    }
    return this.o;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SLog.b("QQStoryMainController", "onActivityResult %d %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.b.a(paramInt1, paramInt2, paramIntent);
    StoryListPresenter localStoryListPresenter = this.g;
    if (localStoryListPresenter != null) {
      localStoryListPresenter.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 10006) {
        switch (paramInt1)
        {
        default: 
          return;
        case 20002: 
          AtVideoTextWatcher.a(this.f.e, paramIntent);
          ThreadManager.getUIHandler().postDelayed(new QQStoryMainController.8(this), 100L);
          return;
        case 20001: 
          a(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
          return;
        }
      }
      if (paramIntent != null) {
        a(paramIntent.getStringExtra("new_video_extra_info"));
      }
      StoryVideoUploadManager.b("QQStoryMainController onActivityResult");
      return;
    }
    if ((paramInt1 == 20000) && (paramIntent != null) && (paramIntent.getBooleanExtra("back_when_cancel_from_shot", false))) {
      this.a.finish();
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a(Intent paramIntent)
  {
    c(null);
    a(paramIntent.getStringExtra("new_video_extra_info"));
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.a != null)
    {
      c(paramBundle);
      q();
      f();
      p();
      this.A = SystemClock.elapsedRealtime();
      return;
    }
    throw new IllegalStateException("mContext should not be null! should call onAttach() pass the activity");
  }
  
  public void a(boolean paramBoolean)
  {
    this.D.removeMessages(1);
    if (paramBoolean) {
      this.D.sendEmptyMessageDelayed(1, 30000L);
    }
    this.i.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      StoryListPresenter localStoryListPresenter = this.g;
      if (localStoryListPresenter != null) {
        localStoryListPresenter.a(NetConnInfoCenter.getServerTimeMillis());
      }
    }
    this.l.b();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    SystemClock.uptimeMillis();
    paramString = StoryPublishLauncher.a();
    String str1 = this.a.getIntent().getStringExtra("from_type");
    int i1 = this.a.getIntent().getIntExtra("capture_intent_mode", -1);
    int i2 = this.a.getIntent().getIntExtra("firsttab", -1);
    int i3 = this.a.getIntent().getIntExtra("secondtab", -1);
    String str2 = this.a.getIntent().getStringExtra("itemid");
    Bundle localBundle = new Bundle();
    if (TextUtils.equals(str1, "msgTab")) {
      localBundle.putInt("entrance_type", 103);
    } else {
      localBundle.putInt("entrance_type", paramInt);
    }
    localBundle.putInt("key_finish_jump_to_page", this.a.getIntent().getIntExtra("key_finish_jump_to_page", 1));
    if (i1 != -1) {
      paramString.a(this.a, localBundle, 2, i1, i2, i3, str2, "", "", true, 20000);
    } else {
      paramString.a(this.a, localBundle, 20000);
    }
    SLog.c("QQStoryMainController", "launchNewVideoTakeActivity by StoryPublishLauncher");
    this.a.overridePendingTransition(2130772373, 2130772092);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ((FeedSegment)this.b.b("FeedSegment")).d(paramString);
    return true;
  }
  
  public SegmentView b(String paramString)
  {
    return this.b.b(paramString);
  }
  
  public void b()
  {
    this.B = false;
    this.b.l();
    Object localObject = (FeedManager)SuperManager.a(11);
    if (this.b.getChildAt(0) != null) {
      ((FeedManager)localObject).c = this.b.getChildAt(0).getTop();
    }
    ((FeedManager)localObject).b = this.b.getFirstVisiblePosition();
    SLog.a("Q.qqstory.home.position", "save position:%d, offset:%d", Integer.valueOf(((FeedManager)localObject).b), Integer.valueOf(((FeedManager)localObject).c));
    localObject = this.g;
    if (localObject != null) {
      ((StoryListPresenter)localObject).g();
    }
  }
  
  public void b(Activity paramActivity)
  {
    this.B = true;
    QQLiveImage.onForeground(paramActivity);
    QQLiveImage.resumeAll(paramActivity);
    paramActivity = this.g;
    if (paramActivity != null) {
      paramActivity.f();
    }
    paramActivity = this.j;
    if (paramActivity != null) {
      paramActivity.setVisibility(0);
    }
    this.b.q();
    this.b.p();
    if (this.z)
    {
      this.z = false;
      c(true);
      SLog.c("QQStoryMainController", "force request net");
    }
    StoryVideoUploadManager.b("QQStoryMainController onResume");
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("bundle_has_jump", this.x);
  }
  
  public void b(boolean paramBoolean)
  {
    this.i.b(paramBoolean);
  }
  
  public void c()
  {
    SLog.b("QQStoryMainController", "reInitData");
    StoryListPresenter localStoryListPresenter = this.g;
    if (localStoryListPresenter != null)
    {
      localStoryListPresenter.h();
      this.g = null;
    }
    this.g = ((StoryListPresenter)StoryApi.a(StoryListPresenter.class, new Object[] { this.a }));
    this.g.a(this);
    this.g.a();
    this.b.i();
    q();
  }
  
  public void c(Activity paramActivity)
  {
    QQLiveImage.onBackground(paramActivity);
    QQLiveImage.pauseAll(paramActivity);
  }
  
  public void c(boolean paramBoolean)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131908542), 0).show();
      return;
    }
    StoryListPresenter localStoryListPresenter = this.g;
    if (localStoryListPresenter == null)
    {
      SLog.d("QQStoryMainController", "refreshIfNecessary, myStoryListPresenter = null!");
      return;
    }
    if (((localStoryListPresenter.i() | paramBoolean | this.g.j())) && (this.g.l()))
    {
      SLog.a("QQStoryMainController", "refreshIfNecessary, forceUpdate: %b, redPoint: %b, overTime: %b", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.g.i()), Boolean.valueOf(this.g.j()));
      g();
    }
  }
  
  public boolean c(Bundle paramBundle)
  {
    int i1 = this.a.getIntent().getIntExtra("action", 0);
    this.a.getIntent().putExtra("action", 0);
    boolean bool;
    if ((paramBundle != null) && (paramBundle.getBoolean("bundle_has_jump"))) {
      bool = true;
    } else {
      bool = false;
    }
    this.x = bool;
    this.y = new QQStoryHomeJumpHelper(this.a, this);
    if ((i1 != 0) && (!this.x))
    {
      bool = this.y.a(i1, this.a.getIntent());
      SLog.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b, result=%b", Integer.valueOf(i1), Boolean.valueOf(this.x), Boolean.valueOf(bool));
      if (bool)
      {
        this.x = true;
        this.z = true;
      }
      return bool;
    }
    SLog.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b", Integer.valueOf(i1), Boolean.valueOf(this.x));
    return false;
  }
  
  protected void d()
  {
    QQAppInterface localQQAppInterface = this.d;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(this.E);
    }
  }
  
  public void d(Activity paramActivity)
  {
    this.C = true;
    ThreadManager.post(new QQStoryMainController.3(this), 5, null, false);
    if (this.A > 0L)
    {
      int i1 = this.a.getIntent().getIntExtra("action", 0);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.A;
      this.A = -1L;
      Now.a((int)(l1 - l2), i1);
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((StoryInputBarView)localObject).d();
    }
    this.l.a();
    this.a.unregisterReceiver(this.h);
    TVKPreloader.b();
    e();
    this.b.m();
    localObject = this.g;
    if (localObject != null) {
      ((StoryListPresenter)localObject).h();
    }
    localObject = (StoryManager)SuperManager.a(5);
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    localFeedManager.g();
    localUserManager.e();
    ((StoryManager)localObject).c();
    ((PreloadDownloaderManager)SuperManager.a(6)).a(10000L);
    localFeedManager.g.clear();
    QQLiveImage.releaseAll(paramActivity);
  }
  
  protected void e()
  {
    QQAppInterface localQQAppInterface = this.d;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.E);
    }
  }
  
  public void f()
  {
    this.p = this.i.a();
    this.i.a(QQStoryConstant.a);
    this.j = this.p.findViewById(2131442746);
    this.k = new TakeVideoButtonMainPart(new QQStoryMainController.6(this), this.j);
    this.b = ((MystoryListView)this.p.findViewById(2131442772));
    this.b.setDisableAutoRefresh(this.m);
    this.b.a(this.a, this, this.j);
    this.b.setPullRefreshListener(this);
    this.b.setIsNowTab(false);
    ((ViewGroup)this.b.getParent()).setBackgroundColor(this.a.getResources().getColor(2131168094));
    this.c = new StorySimpleLoadView(this.a);
    this.c.setVisibility(8);
    this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((ViewGroup)this.b.getParent()).addView(this.c);
    this.b.setEmptyView(this.c);
    this.b.k();
    this.g = ((StoryListPresenter)StoryApi.a(StoryListPresenter.class, new Object[] { this.a }));
    this.g.a(this);
    this.g.a();
    a(this.a.getIntent().getStringExtra("new_video_extra_info"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    this.h = new QQStoryMainController.ScreenActionBroadcastReceiver();
    this.a.registerReceiver(this.h, localIntentFilter);
  }
  
  public void g()
  {
    this.b.i();
    this.l.b();
  }
  
  public StoryInputBarView h()
  {
    boolean bool;
    if (this.r != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    if (this.f == null)
    {
      ViewStub localViewStub = (ViewStub)this.p.findViewById(this.r[2]);
      if (localViewStub != null) {
        this.f = ((StoryInputBarView)localViewStub.inflate());
      } else {
        this.f = ((StoryInputBarView)this.p.findViewById(this.r[3]));
      }
    }
    return this.f;
  }
  
  public boolean i()
  {
    return this.B;
  }
  
  public void j()
  {
    this.i.f();
  }
  
  public void k()
  {
    this.i.e();
  }
  
  public void l()
  {
    this.g.l();
  }
  
  public void m()
  {
    e();
    this.d = QQStoryContext.j();
    d();
    StoryHomePushYellowBarHandler localStoryHomePushYellowBarHandler = this.l;
    if (localStoryHomePushYellowBarHandler != null) {
      localStoryHomePushYellowBarHandler.c();
    }
  }
  
  public boolean n()
  {
    this.f = h();
    StoryInputBarView localStoryInputBarView = this.f;
    if ((localStoryInputBarView != null) && (localStoryInputBarView.getVisibility() == 0))
    {
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.f.getWindowToken(), 0);
      this.f.clearFocus();
      this.f.setVisibility(8);
      this.j.setVisibility(0);
      return true;
    }
    return false;
  }
  
  public boolean o()
  {
    return this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController
 * JD-Core Version:    0.7.0.1
 */
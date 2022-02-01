package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.TraceUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class MystoryListView
  extends SegmentList
  implements FeedSegment.InputViewHideListener, IEventReceiver
{
  private long A = 0L;
  private AbsListView.OnScrollListener B = new MystoryListView.1(this);
  private ScrollerRunnable C;
  private View D;
  private StoryConfigManager E;
  private MystoryListView.FakeVideoCreateRec F;
  private long G = 0L;
  public IMyStoryListView a;
  public Activity b;
  protected boolean c = false;
  Runnable d = null;
  private boolean m = false;
  private int n;
  private MystoryListView.PullRefreshListener o;
  private int p = 0;
  private boolean q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w = 0;
  private boolean x = false;
  private AbsListView.OnScrollListener y;
  private boolean z;
  
  public MystoryListView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public MystoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MystoryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super.setOnScrollListener(this.B);
    this.C = new ScrollerRunnable(this);
  }
  
  private int getRedPointType()
  {
    QQStoryContext.a();
    Object localObject = QQStoryContext.j();
    if (localObject != null)
    {
      localObject = ((TroopRedTouchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).q();
      if ((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid.has()))
      {
        int i = ((oidb_0x791.RedDotInfo)localObject).uint32_appid.get();
        if (i != 8)
        {
          if (i != 11)
          {
            if (i != 35)
            {
              if (i != 52) {
                return 0;
              }
              return 3;
            }
            return 2;
          }
          return 4;
        }
        return 1;
      }
    }
    else
    {
      SLog.e("Q.qqstory.home.MyStoryListView", "Get the QQAppInterface is null,we dont know the red point state");
    }
    return 0;
  }
  
  private void v()
  {
    boolean bool = FeedSegment.d(FeedSegment.a(getContext()));
    String str3 = "1";
    String str1;
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    String str2;
    if (QQStoryMainActivity.a > 0L) {
      str2 = String.valueOf(System.currentTimeMillis() - QQStoryMainActivity.a);
    } else {
      str2 = "-1";
    }
    if (this.m) {
      str3 = "2";
    }
    StoryReportor.b("story_home_dev", "exp", 0, 0, new String[] { str3, str1, str2 });
    InfoPrinter.b("Q.qqstory.home.MyStoryListView", new Object[] { "listViewExposure auto_play_switch=", str1, ",cost=", str2 });
  }
  
  private void w()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.j();
    if (localQQAppInterface != null) {
      ((TroopRedTouchManager)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).t();
    }
  }
  
  protected void a()
  {
    super.setActTAG("list_qqstory_home");
    ((MystoryListView.MystoryListConfigApplier)StoryApi.a(MystoryListView.MystoryListConfigApplier.class, new Object[0])).a(this);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setContentBackground(2130839572);
  }
  
  public void a(Activity paramActivity, IMyStoryListView paramIMyStoryListView, View paramView)
  {
    this.a = paramIMyStoryListView;
    this.b = paramActivity;
    this.D = paramView;
    this.E = ((StoryConfigManager)SuperManager.a(10));
    this.p = ((Integer)this.E.c("qqstory_key_story_have_show_click_to_top", Integer.valueOf(0))).intValue();
  }
  
  public void a(@NonNull String paramString)
  {
    this.a.a(true);
    super.a(paramString);
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    if (this.m)
    {
      int i = UIUtils.a(getContext(), 36.0F);
      super.smoothScrollBy(i, i);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    if (paramBoolean) {
      w();
    }
    this.a.a(false);
    Object localObject = this.o;
    if (localObject != null) {
      ((MystoryListView.PullRefreshListener)localObject).a(paramBoolean, false);
    }
    if (this.G > 0L)
    {
      localObject = String.valueOf(System.currentTimeMillis() - this.G);
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      StoryReportor.b("story_home_dev", "ref_cost", 2, i, new String[] { String.valueOf(paramInt), localObject });
      this.G = 0L;
      InfoPrinter.b("Q.qqstory.home.MyStoryListView", new Object[] { "autoRefreshCompleted=", Boolean.valueOf(paramBoolean), ",errorCode=", Integer.valueOf(paramInt), ",cost time=", localObject });
    }
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().postDelayed(new MystoryListView.6(this), 300L);
    this.a.j();
  }
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    if (paramBoolean) {
      w();
    }
    this.a.a(false);
    SLog.a("Q.qqstory.home.MyStoryListView", "pullRefreshCompleted success=%s,isManualPullRefresh=%s", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.x));
    if (this.x)
    {
      this.x = false;
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      StoryReportor.a("home_page", "refresh", 0, 0, new String[] { localObject });
    }
    Object localObject = this.o;
    if (localObject != null) {
      ((MystoryListView.PullRefreshListener)localObject).a(paramBoolean, this.x);
    }
    if (this.G > 0L)
    {
      localObject = String.valueOf(System.currentTimeMillis() - this.G);
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      StoryReportor.b("story_home_dev", "ref_cost", 1, i, new String[] { String.valueOf(paramInt), localObject });
      this.G = 0L;
      InfoPrinter.b("Q.qqstory.home.MyStoryListView", new Object[] { "pullToRefreshCompleted=", Boolean.valueOf(paramBoolean), ",errorCode=", Integer.valueOf(paramInt), ",cost time=", localObject });
    }
  }
  
  public void c()
  {
    this.D.setVisibility(8);
    this.a.k();
  }
  
  public void d()
  {
    if (this.m)
    {
      int i = -UIUtils.a(getContext(), 232.0F);
      super.smoothScrollBy(i, i);
    }
  }
  
  public void e()
  {
    if (this.m)
    {
      int i = UIUtils.a(getContext(), 232.0F);
      super.smoothScrollBy(i, i);
    }
  }
  
  public void f()
  {
    if (this.A > 0L)
    {
      localObject = String.valueOf(System.currentTimeMillis() - this.A);
      int i = getCount();
      StoryReportor.b("story_home_dev", "local_cost", 0, i, new String[] { localObject });
      this.A = 0L;
      InfoPrinter.b("Q.qqstory.home.MyStoryListView", new Object[] { "onLoadCacheCompile getCount=", Integer.valueOf(i), ",cost time=", localObject });
    }
    v();
    if (!this.z)
    {
      ThreadManager.getUIHandler().postDelayed(new MystoryListView.2(this), 500L);
      return;
    }
    Object localObject = (FeedManager)SuperManager.a(11);
    SLog.a("Q.qqstory.home.position", "start auto jump position:%d, offset:%d", Integer.valueOf(((FeedManager)localObject).b), Integer.valueOf(((FeedManager)localObject).c));
    if ((((FeedManager)localObject).b != 0) && (((FeedManager)localObject).c != 0)) {
      setSelectionFromTop(((FeedManager)localObject).b, ((FeedManager)localObject).c);
    }
    SLog.a("Q.qqstory.home.position", "mDisableAutoRefresh：%b", Boolean.valueOf(this.z));
    h();
    this.i = true;
  }
  
  public boolean g()
  {
    return this.z;
  }
  
  public void h()
  {
    super.h();
    QQStoryContext.a();
    Object localObject = QQStoryContext.j();
    oidb_0x791.RedDotInfo localRedDotInfo;
    if (localObject != null)
    {
      localRedDotInfo = ((TroopRedTouchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).q();
    }
    else
    {
      SLog.e("Q.qqstory.home.MyStoryListView", "Get the QQAppInterface is null,we dont know the red point state");
      localRedDotInfo = null;
    }
    int i;
    if (((FeedSegment)b("FeedSegment")).a() > 0) {
      i = 1;
    } else {
      i = 2;
    }
    String str = StoryReportor.a("home_page-exp-d4");
    localObject = str;
    if (str == null) {
      if (this.m) {
        localObject = "2";
      } else {
        localObject = "1";
      }
    }
    StoryReportor.a("home_page-exp-d4", null);
    int k = this.n;
    int j = k;
    if (k == 0) {
      j = getRedPointType();
    }
    StoryReportor.a("home_page", "exp", j, i, new String[] { "", "", "", localObject });
    StoryReportor.a("home_page", "network", 0, 0, new String[] { "", "", StoryReportor.a(getContext()) });
    this.n = 0;
    if ((localRedDotInfo != null) && (localRedDotInfo.uint32_appid.get() == 52))
    {
      localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().i());
      if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        i = 1;
      } else {
        i = 2;
      }
      StoryReportor.a("play_video", "exp_grey", i, 0, new String[] { "", "", "", "" });
    }
  }
  
  public void i()
  {
    this.G = System.currentTimeMillis();
    this.a.a(true);
    super.setSelection(0);
    super.i();
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void j()
  {
    SLog.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), mOverScrollHeight %d firstVisiblePostion %d childCount %d", new Object[] { Integer.valueOf(this.mOverScrollHeight), Integer.valueOf(getFirstVisiblePosition()), Integer.valueOf(getChildCount()) });
    int[] arrayOfInt1 = new int[7];
    int[] tmp48_47 = arrayOfInt1;
    tmp48_47[0] = 0;
    int[] tmp52_48 = tmp48_47;
    tmp52_48[1] = 2;
    int[] tmp56_52 = tmp52_48;
    tmp56_52[2] = 2;
    int[] tmp60_56 = tmp56_52;
    tmp60_56[3] = 2;
    int[] tmp64_60 = tmp60_56;
    tmp64_60[4] = 2;
    int[] tmp68_64 = tmp64_60;
    tmp68_64[5] = 2;
    int[] tmp72_68 = tmp68_64;
    tmp72_68[6] = 1;
    tmp72_68;
    float[] arrayOfFloat = new float[7];
    arrayOfFloat[0] = (getHeight() / 2.0F);
    arrayOfFloat[1] = (getHeight() / 2.0F + this.mOverScrollHeight * 0.5F);
    arrayOfFloat[2] = (getHeight() / 2.0F + this.mOverScrollHeight * 1.0F);
    arrayOfFloat[3] = (getHeight() / 2.0F + this.mOverScrollHeight * 1.5F);
    arrayOfFloat[4] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.0F);
    arrayOfFloat[5] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.5F);
    arrayOfFloat[6] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.5F);
    int[] arrayOfInt2 = new int[7];
    int[] tmp226_224 = arrayOfInt2;
    tmp226_224[0] = 0;
    int[] tmp230_226 = tmp226_224;
    tmp230_226[1] = 50;
    int[] tmp235_230 = tmp230_226;
    tmp235_230[2] = 50;
    int[] tmp240_235 = tmp235_230;
    tmp240_235[3] = 50;
    int[] tmp245_240 = tmp240_235;
    tmp245_240[4] = 50;
    int[] tmp250_245 = tmp245_240;
    tmp250_245[5] = 50;
    int[] tmp255_250 = tmp250_245;
    tmp255_250[6] = 800;
    tmp255_250;
    boolean bool;
    if ((arrayOfInt1.length == arrayOfFloat.length) && (arrayOfFloat.length == arrayOfInt2.length)) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    this.d = new MystoryListView.3(this, arrayOfInt1, arrayOfInt2, arrayOfFloat);
    if ((getFirstVisiblePosition() == 0) && (getChildCount() > 0))
    {
      int i = getChildAt(0).getTop();
      SLog.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), child(0).top = %d", new Object[] { Integer.valueOf(i) });
      if (i >= 0)
      {
        post(this.d);
        this.d = null;
      }
    }
    if (this.d != null)
    {
      SLog.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), smoothScrollToPostion(0)!");
      this.C.a(0, 0, new MystoryListView.4(this), 4, false);
    }
  }
  
  public void k()
  {
    super.k();
    this.A = System.currentTimeMillis();
    this.n = getRedPointType();
    this.F = new MystoryListView.FakeVideoCreateRec(this);
    StoryDispatcher.a().registerSubscriber(this.F);
  }
  
  public void l()
  {
    super.l();
    URLDrawable.resume();
    StoryInputBarView localStoryInputBarView = this.a.h();
    if (StoryDepends.b())
    {
      this.D.setVisibility(0);
      localStoryInputBarView.c();
    }
    this.a.b(false);
  }
  
  protected void layoutChildren()
  {
    TraceUtils.traceBegin("MystoryList.layoutChildren");
    super.layoutChildren();
    if (this.c)
    {
      this.c = false;
      FeedSegment localFeedSegment = (FeedSegment)b("FeedSegment");
      if (localFeedSegment != null) {
        localFeedSegment.c(0);
      }
    }
    TraceUtils.traceEnd();
  }
  
  public void m()
  {
    super.m();
    URLDrawable.resume();
    if (this.F != null)
    {
      StoryDispatcher.a().unRegisterSubscriber(this.F);
      this.F = null;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
      this.b = null;
    }
  }
  
  public void n()
  {
    if (this.p != 1)
    {
      this.p = 1;
      this.E.d("qqstory_key_story_have_show_click_to_top", Integer.valueOf(1));
    }
    this.a.b(false);
    super.setSelection(0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    StoryInputBarView localStoryInputBarView = this.a.h();
    if (localStoryInputBarView.getVisibility() == 0)
    {
      ((InputMethodManager)this.b.getSystemService("input_method")).hideSoftInputFromWindow(localStoryInputBarView.getWindowToken(), 0);
      localStoryInputBarView.clearFocus();
      localStoryInputBarView.setVisibility(8);
      b();
      if (localStoryInputBarView.p != null)
      {
        paramMotionEvent = localStoryInputBarView.p.g;
        int i = StoryReportor.a(paramMotionEvent.getOwner());
        if (paramMotionEvent.getOwner().isMe()) {
          paramMotionEvent = "1";
        } else {
          paramMotionEvent = "2";
        }
        StoryReportor.a("home_page", "cancel_reply", i, 0, new String[] { paramMotionEvent, "1", "", "" });
      }
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.G = System.currentTimeMillis();
    super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    if (paramInt == 0)
    {
      this.x = true;
      paramView = this.o;
      if (paramView != null) {
        paramView.l();
      }
    }
    return true;
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (paramInt == 2)
    {
      URLDrawable.pause();
      return;
    }
    URLDrawable.resume();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.c = true;
  }
  
  public void setDisableAutoRefresh(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setIsNowTab(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.y = paramOnScrollListener;
  }
  
  public void setPullRefreshListener(MystoryListView.PullRefreshListener paramPullRefreshListener)
  {
    this.o = paramPullRefreshListener;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    FeedSegment localFeedSegment = (FeedSegment)b("FeedSegment");
    if (localFeedSegment == null) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    localFeedSegment.e(1);
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    localFeedSegment.e(0);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView
 * JD-Core Version:    0.7.0.1
 */
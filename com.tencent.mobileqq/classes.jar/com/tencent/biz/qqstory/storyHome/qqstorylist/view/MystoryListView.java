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
import bhtv;
import biby;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.ListView;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import mqq.os.MqqHandler;
import nan;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import umc;
import uqn;
import uqo;
import ust;
import uvt;
import uwa;
import uwm;
import uxe;
import woy;
import wrk;
import wtr;
import wts;
import wtt;
import wtu;
import wtv;
import wub;
import wuv;
import wxe;
import wxj;
import xqq;
import xsm;

public class MystoryListView
  extends SegmentList
  implements IEventReceiver, wuv
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Activity a;
  private View jdField_a_of_type_AndroidViewView;
  private bhtv jdField_a_of_type_Bhtv;
  private ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  private uvt jdField_a_of_type_Uvt;
  public wtr a;
  private wtt jdField_a_of_type_Wtt;
  private wtv jdField_a_of_type_Wtv;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private bhtv jdField_b_of_type_Bhtv = new wts(this);
  private boolean c;
  private boolean d;
  private boolean e;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
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
  
  private int a()
  {
    QQStoryContext.a();
    Object localObject = QQStoryContext.a();
    if (localObject != null)
    {
      localObject = ((nan)((QQAppInterface)localObject).getManager(70)).a();
      if ((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid.has())) {
        switch (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get())
        {
        }
      }
    }
    for (;;)
    {
      return 0;
      return 1;
      return 2;
      return 3;
      return 4;
      wxe.e("Q.qqstory.home.MyStoryListView", "Get the QQAppInterface is null,we dont know the red point state");
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super.setOnScrollListener(this.jdField_b_of_type_Bhtv);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this);
  }
  
  private void u()
  {
    String str1;
    String str2;
    if (wub.a(wub.a(getContext())))
    {
      str1 = "1";
      if (QQStoryMainActivity.jdField_a_of_type_Long <= 0L) {
        break label104;
      }
      str2 = String.valueOf(System.currentTimeMillis() - QQStoryMainActivity.jdField_a_of_type_Long);
      label35:
      if (!this.c) {
        break label110;
      }
    }
    label104:
    label110:
    for (String str3 = "2";; str3 = "1")
    {
      wxj.b("story_home_dev", "exp", 0, 0, new String[] { str3, str1, str2 });
      wrk.b("Q.qqstory.home.MyStoryListView", new Object[] { "listViewExposure auto_play_switch=", str1, ",cost=", str2 });
      return;
      str1 = "0";
      break;
      str2 = "-1";
      break label35;
    }
  }
  
  private void v()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    if (localQQAppInterface != null) {
      ((nan)localQQAppInterface.getManager(70)).a();
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_home");
    ((wtu)uqn.a(wtu.class, new Object[0])).a(this);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setContentBackground(2130839212);
  }
  
  public void a(Activity paramActivity, wtr paramwtr, View paramView)
  {
    this.jdField_a_of_type_Wtr = paramwtr;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Uvt = ((uvt)uwa.a(10));
    this.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_key_story_have_show_click_to_top", Integer.valueOf(0))).intValue();
  }
  
  public void a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Wtr.a(true);
    super.a(paramString);
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    if (this.c)
    {
      int m = xsm.a(getContext(), 36.0F);
      super.smoothScrollBy(m, m);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    if (paramBoolean) {
      v();
    }
    this.jdField_a_of_type_Wtr.a(false);
    if (this.jdField_a_of_type_Wtv != null) {
      this.jdField_a_of_type_Wtv.a(paramBoolean, false);
    }
    String str;
    if (this.jdField_b_of_type_Long > 0L)
    {
      str = String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      if (!paramBoolean) {
        break label149;
      }
    }
    label149:
    for (int m = 1;; m = 2)
    {
      wxj.b("story_home_dev", "ref_cost", 2, m, new String[] { String.valueOf(paramInt), str });
      this.jdField_b_of_type_Long = 0L;
      wrk.b("Q.qqstory.home.MyStoryListView", new Object[] { "autoRefreshCompleted=", Boolean.valueOf(paramBoolean), ",errorCode=", Integer.valueOf(paramInt), ",cost time=", str });
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.a(paramInt, paramView, paramListView);
    if (paramInt == 0)
    {
      this.e = true;
      if (this.jdField_a_of_type_Wtv != null) {
        this.jdField_a_of_type_Wtv.i();
      }
    }
    while (paramInt != 1) {
      return true;
    }
    return true;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().postDelayed(new MystoryListView.6(this), 300L);
    this.jdField_a_of_type_Wtr.g();
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    if (paramBoolean) {
      v();
    }
    this.jdField_a_of_type_Wtr.a(false);
    wxe.a("Q.qqstory.home.MyStoryListView", "pullRefreshCompleted success=%s,isManualPullRefresh=%s", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.e));
    String str;
    if (this.e)
    {
      this.e = false;
      if (paramBoolean)
      {
        str = "1";
        wxj.a("home_page", "refresh", 0, 0, new String[] { str });
      }
    }
    else
    {
      if (this.jdField_a_of_type_Wtv != null) {
        this.jdField_a_of_type_Wtv.a(paramBoolean, this.e);
      }
      if (this.jdField_b_of_type_Long > 0L)
      {
        str = String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long);
        if (!paramBoolean) {
          break label218;
        }
      }
    }
    label218:
    for (int m = 1;; m = 2)
    {
      wxj.b("story_home_dev", "ref_cost", 1, m, new String[] { String.valueOf(paramInt), str });
      this.jdField_b_of_type_Long = 0L;
      wrk.b("Q.qqstory.home.MyStoryListView", new Object[] { "pullToRefreshCompleted=", Boolean.valueOf(paramBoolean), ",errorCode=", Integer.valueOf(paramInt), ",cost time=", str });
      return;
      str = "2";
      break;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Wtr.h();
  }
  
  public void d()
  {
    if (this.c)
    {
      int m = xsm.a(getContext(), 232.0F);
      super.smoothScrollBy(-m, -m);
    }
  }
  
  public void e()
  {
    if (this.c)
    {
      int m = xsm.a(getContext(), 232.0F);
      super.smoothScrollBy(m, m);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Long > 0L)
    {
      localObject = String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      int m = getCount();
      wxj.b("story_home_dev", "local_cost", 0, m, new String[] { localObject });
      this.jdField_a_of_type_Long = 0L;
      wrk.b("Q.qqstory.home.MyStoryListView", new Object[] { "onLoadCacheCompile getCount=", Integer.valueOf(m), ",cost time=", localObject });
    }
    u();
    if (!this.jdField_f_of_type_Boolean)
    {
      ThreadManager.getUIHandler().postDelayed(new MystoryListView.2(this), 500L);
      return;
    }
    Object localObject = (woy)uwa.a(11);
    wxe.a("Q.qqstory.home.position", "start auto jump position:%d, offset:%d", Integer.valueOf(((woy)localObject).jdField_a_of_type_Int), Integer.valueOf(((woy)localObject).jdField_b_of_type_Int));
    if ((((woy)localObject).jdField_a_of_type_Int != 0) && (((woy)localObject).jdField_b_of_type_Int != 0)) {
      setSelectionFromTop(((woy)localObject).jdField_a_of_type_Int, ((woy)localObject).jdField_b_of_type_Int);
    }
    wxe.a("Q.qqstory.home.position", "mDisableAutoRefresh：%b", Boolean.valueOf(this.jdField_f_of_type_Boolean));
    g();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void g()
  {
    super.g();
    QQStoryContext.a();
    Object localObject = QQStoryContext.a();
    oidb_0x791.RedDotInfo localRedDotInfo;
    label48:
    label74:
    int n;
    if (localObject != null)
    {
      localRedDotInfo = ((nan)((QQAppInterface)localObject).getManager(70)).a();
      if (((wub)a("FeedSegment")).a() <= 0) {
        break label278;
      }
      m = 1;
      String str = wxj.a("home_page-exp-d4");
      localObject = str;
      if (str == null)
      {
        if (!this.c) {
          break label283;
        }
        localObject = "2";
      }
      wxj.a("home_page-exp-d4", null);
      if (this.jdField_a_of_type_Int != 0) {
        break label289;
      }
      n = a();
      label93:
      wxj.a("home_page", "exp", n, m, new String[] { "", "", "", localObject });
      wxj.a("home_page", "network", 0, 0, new String[] { "", "", wxj.a(getContext()) });
      this.jdField_a_of_type_Int = 0;
      if ((localRedDotInfo != null) && (localRedDotInfo.uint32_appid.get() == 52))
      {
        localObject = ((uwm)uwa.a(2)).b(QQStoryContext.a().b());
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label297;
        }
        m = 1;
        label219:
        if (m == 0) {
          break label302;
        }
      }
    }
    label278:
    label283:
    label289:
    label297:
    label302:
    for (int m = 1;; m = 2)
    {
      wxj.a("play_video", "exp_grey", m, 0, new String[] { "", "", "", "" });
      return;
      wxe.e("Q.qqstory.home.MyStoryListView", "Get the QQAppInterface is null,we dont know the red point state");
      localRedDotInfo = null;
      break;
      m = 2;
      break label48;
      localObject = "1";
      break label74;
      n = this.jdField_a_of_type_Int;
      break label93;
      m = 0;
      break label219;
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Wtr.a(true);
    super.setSelection(0);
    super.h();
  }
  
  public void i()
  {
    wxe.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), mOverScrollHeight %d firstVisiblePostion %d childCount %d", new Object[] { Integer.valueOf(this.mOverScrollHeight), Integer.valueOf(getFirstVisiblePosition()), Integer.valueOf(getChildCount()) });
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
    arrayOfFloat[1] = (getHeight() / 2.0F + 0.5F * this.mOverScrollHeight);
    arrayOfFloat[2] = (getHeight() / 2.0F + 1.0F * this.mOverScrollHeight);
    arrayOfFloat[3] = (getHeight() / 2.0F + 1.5F * this.mOverScrollHeight);
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
    if ((arrayOfInt1.length == arrayOfFloat.length) && (arrayOfFloat.length == arrayOfInt2.length)) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      this.jdField_a_of_type_JavaLangRunnable = new MystoryListView.3(this, arrayOfInt1, arrayOfInt2, arrayOfFloat);
      if ((getFirstVisiblePosition() == 0) && (getChildCount() > 0))
      {
        int m = getChildAt(0).getTop();
        wxe.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), child(0).top = %d", new Object[] { Integer.valueOf(m) });
        if (m >= 0)
        {
          post(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_JavaLangRunnable = null;
        }
      }
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        wxe.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), smoothScrollToPostion(0)!");
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, 0, new MystoryListView.4(this), 4);
      }
      return;
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void j()
  {
    super.j();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_Wtt = new wtt(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wtt);
  }
  
  public void k()
  {
    super.k();
    URLDrawable.resume();
    StoryInputBarView localStoryInputBarView = this.jdField_a_of_type_Wtr.a();
    if (uqo.b())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localStoryInputBarView.c();
    }
    this.jdField_a_of_type_Wtr.b(false);
  }
  
  public void l()
  {
    super.l();
    URLDrawable.resume();
    if (this.jdField_a_of_type_Wtt != null)
    {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wtt);
      this.jdField_a_of_type_Wtt = null;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
  }
  
  public void layoutChildren()
  {
    biby.a("MystoryList.layoutChildren");
    super.layoutChildren();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      wub localwub = (wub)a("FeedSegment");
      if (localwub != null) {
        localwub.b(0);
      }
    }
    biby.a();
  }
  
  public void m()
  {
    if (this.jdField_b_of_type_Int != 1)
    {
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_Uvt.b("qqstory_key_story_have_show_click_to_top", Integer.valueOf(1));
    }
    this.jdField_a_of_type_Wtr.b(false);
    super.setSelection(0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    StoryInputBarView localStoryInputBarView = this.jdField_a_of_type_Wtr.a();
    if (localStoryInputBarView.getVisibility() == 0)
    {
      ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(localStoryInputBarView.getWindowToken(), 0);
      localStoryInputBarView.clearFocus();
      localStoryInputBarView.setVisibility(8);
      b();
      int m;
      if (localStoryInputBarView.a != null)
      {
        paramMotionEvent = localStoryInputBarView.a.a;
        m = wxj.a(paramMotionEvent.getOwner());
        if (!paramMotionEvent.getOwner().isMe()) {
          break label129;
        }
      }
      label129:
      for (paramMotionEvent = "1";; paramMotionEvent = "2")
      {
        wxj.a("home_page", "cancel_reply", m, 0, new String[] { paramMotionEvent, "1", "", "" });
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void reportScrollStateChange(int paramInt)
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
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setDisableAutoRefresh(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNowTab(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOnScrollListener(bhtv parambhtv)
  {
    this.jdField_a_of_type_Bhtv = parambhtv;
  }
  
  public void setPullRefreshListener(wtv paramwtv)
  {
    this.jdField_a_of_type_Wtv = paramwtv;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    wub localwub = (wub)a("FeedSegment");
    if (localwub == null) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    localwub.c(1);
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    localwub.c(0);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView
 * JD-Core Version:    0.7.0.1
 */
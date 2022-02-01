package com.tencent.biz.pubaccount.readinjoy.video;

import Override;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import aqre;
import aqvh;
import bhmg;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import ocd;
import odr;
import odu;
import oix;
import org.json.JSONObject;
import ozs;
import pda;
import qig;
import qih;
import rlo;
import rlp;
import rmp;
import rot;
import rpt;
import rre;
import rrf;
import rrg;
import rrh;
import rrm;
import rsa;
import rsr;
import rsx;
import rue;
import rxx;
import ryi;
import sbf;
import sbg;
import sjv;

public class VideoFeedsPlayActivity
  extends FragmentActivity
  implements View.OnClickListener, rlp, rsa, rue
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aqre jdField_a_of_type_Aqre;
  private VideoFeedsCustomFrameLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout;
  private VideoFeedsRecommendFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment;
  private DragFrameLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private rlo jdField_a_of_type_Rlo;
  private rsr jdField_a_of_type_Rsr;
  private rsx jdField_a_of_type_Rsx;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e;
  
  private long a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null)) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a().a();
  }
  
  private VideoInfo a()
  {
    if (((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder instanceof rot)) && (((rot)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a.a != null)) {
      return ((rot)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a.a;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b() != null) {
        return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    }
    return null;
  }
  
  private rlo a()
  {
    if (this.jdField_a_of_type_Rlo == null) {
      switch (getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0))
      {
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_Rlo;
      this.jdField_a_of_type_Rlo = new VideoFeedsLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_Rlo = new VideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_Rlo = new rxx(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
    }
  }
  
  public static void a(Activity paramActivity)
  {
    rpt.a(paramActivity);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramString);
    }
  }
  
  static void a(String paramString, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramString, paramException);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (localFlingGestureHandler.mTopLayout != null)
      {
        localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(paramBoolean);
        localFlingGestureHandler.mTopLayout.setIsInterceptChildEventWhenScroll(paramBoolean);
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    int i;
    label31:
    Object localObject2;
    boolean bool;
    label165:
    label189:
    Object localObject3;
    label201:
    label238:
    Object localObject4;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label393;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
      Object localObject5 = new sbg("", "", "", "").b(this.jdField_a_of_type_JavaLangString).a(409409).b((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      if (localObject1 != null)
      {
        localObject2 = ((sbg)localObject5).e(((VideoInfo)localObject1).f).c(((VideoInfo)localObject1).p).l(i).s(((VideoInfo)localObject1).d()).t(this.jdField_b_of_type_Int + 1).d(((VideoInfo)localObject1).j).e(((VideoInfo)localObject1).jdField_a_of_type_JavaLangString).f(((VideoInfo)localObject1).g);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.d())) {
          break label398;
        }
        bool = true;
        ((sbg)localObject2).b(bool);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label404;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
      if (localObject2 == null) {
        break label410;
      }
      localObject3 = ((VideoInfo)localObject2).g;
      int j = getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      ((sbg)localObject5).h((String)localObject3).E(j).M(0);
      if (!paramBoolean) {
        break label416;
      }
      localObject3 = "1";
      if (!jdField_a_of_type_Boolean) {
        break label424;
      }
      localObject4 = "0X8009501";
      label249:
      ocd.a(null, "", (String)localObject4, (String)localObject4, 0, 0, (String)localObject3, "", "", ((sbg)localObject5).a().a(), false);
      String str1 = "";
      localObject4 = "";
      localObject5 = "";
      localObject3 = str1;
      if (localObject1 != null)
      {
        String str2 = String.valueOf(i + 1);
        localObject3 = str1;
        localObject4 = str2;
        if (((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
        {
          localObject3 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
          localObject4 = str2;
        }
      }
      localObject1 = localObject5;
      if (localObject2 != null) {
        if (((VideoInfo)localObject2).jdField_b_of_type_Int < ((VideoInfo)localObject2).c) {
          break label432;
        }
      }
    }
    label393:
    label398:
    label404:
    label410:
    label416:
    label424:
    label432:
    for (Object localObject1 = String.valueOf(1);; localObject1 = String.valueOf(2))
    {
      ocd.a(null, "", "0X800957B", "0X800957B", 0, 0, (String)localObject3, (String)localObject4, (String)localObject1, "", false);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label31;
      bool = false;
      break label165;
      localObject2 = null;
      break label189;
      localObject3 = null;
      break label201;
      localObject3 = "0";
      break label238;
      localObject4 = "0X8007DBB";
      break label249;
    }
  }
  
  private void g()
  {
    ThreadManager.post(new VideoFeedsPlayActivity.1(this), 1, null, true);
  }
  
  private void h()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_a_of_type_Int = i;
    if ((i == 9) || (i == 12) || (i == 21) || (i == 20) || (i == 22) || (i == 23)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("KEY_IS_WEISHI_MODE", jdField_a_of_type_Boolean);
      getIntent().putExtra("KEY_IS_WEISHI_MODE", jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    int i = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int j = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
    String str2 = null;
    String str3 = "";
    String str1 = "";
    String str4 = "";
    long l = 0L;
    if (localObject != null)
    {
      if ((((VideoInfo)localObject).jdField_a_of_type_Int != 0) || (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label207;
      }
      str2 = ((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    for (;;)
    {
      str3 = ((VideoInfo)localObject).j;
      str1 = ((VideoInfo)localObject).g;
      str4 = ((VideoInfo)localObject).jdField_a_of_type_JavaLangString;
      l = ((VideoInfo)localObject).a() * 1000L;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("session_id", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("video_session_id", this.jdField_b_of_type_JavaLangString);
        label148:
        if (!TextUtils.isEmpty(str1)) {}
        for (localObject = str1;; localObject = "0")
        {
          ocd.a(null, str3, "0X800740A", "0X800740A", 0, 0, String.valueOf(i), String.valueOf(j), (String)localObject, odr.a(str2, str3, str4, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(), l, localJSONObject), false);
          return;
          label207:
          str2 = null;
          break;
        }
      }
      catch (Exception localException)
      {
        break label148;
      }
    }
  }
  
  @TargetApi(11)
  private void j()
  {
    int i = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
    this.jdField_a_of_type_Rsr = new rsr(this);
    this.jdField_a_of_type_Rsr.a(i);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)findViewById(2131365757));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout = ((VideoFeedsCustomFrameLayout)findViewById(2131376935));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131370751));
    this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131368720);
    if (LiuHaiUtils.b())
    {
      i = LiuHaiUtils.b(this);
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), i + this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a().a(getLayoutInflater(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131370739));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      c(false);
    }
    k();
  }
  
  private void k()
  {
    this.jdField_a_of_type_Aqre = new aqre(this, true, false, true, true, 0);
    this.jdField_a_of_type_Aqre.a(this);
    this.jdField_a_of_type_Aqre.a(new rre(this));
    this.jdField_a_of_type_Aqre.a(new rrf(this));
    this.jdField_a_of_type_Aqre.a(new rrg(this));
  }
  
  private void l()
  {
    FlingGestureHandler localFlingGestureHandler;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (!(this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        break label87;
      }
      localFlingGestureHandler.setTopLayout(new TopEdgeGestureLayout(this));
    }
    for (;;)
    {
      localFlingGestureHandler.mTopLayout.setIsInterceptChildEventWhenScroll(false);
      localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(false);
      localFlingGestureHandler.mTopLayout.setInterceptScrollRLFlag(true);
      localFlingGestureHandler.mTopLayout.setOnFlingGesture(new rrh(this));
      return;
      label87:
      localFlingGestureHandler.setTopLayout(new TopGestureLayout(this));
    }
  }
  
  private void m()
  {
    try
    {
      Object localObject1 = getSupportFragmentManager();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = localObject1.getClass().getDeclaredField("mExecCommit");
      if (localObject2 != null)
      {
        ((Field)localObject2).setAccessible(true);
        localObject1 = ((Field)localObject2).get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = FragmentActivity.class.getDeclaredField("mHandler");
          if (localObject2 != null)
          {
            ((Field)localObject2).setAccessible(true);
            localObject2 = ((Field)localObject2).get(this);
            if (localObject2 != null)
            {
              ((Handler)localObject2).removeCallbacks((Runnable)localObject1);
              return;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void D_() {}
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) {
      this.jdField_a_of_type_Aqre.b();
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
      VideoInfo localVideoInfo;
      int j;
      if ((paramViewHolder instanceof rot))
      {
        paramViewHolder = (rot)paramViewHolder;
        localVideoInfo = paramViewHolder.a.a;
        if (this.jdField_a_of_type_Rsx != null) {
          this.jdField_a_of_type_Rsx.a(localVideoInfo);
        }
        j = paramViewHolder.c;
        if (j <= this.jdField_b_of_type_Int) {
          break label116;
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = j;
        this.jdField_a_of_type_JavaUtilSet.add(localVideoInfo.jdField_a_of_type_JavaLangString);
        qig.a.a().a(false, "MATCH_ALL_UIN");
        if (i != 0) {
          this.jdField_a_of_type_Aqre.a();
        }
        return;
        label116:
        j = this.jdField_b_of_type_Int;
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(false);
      }
    }
    for (;;)
    {
      qig.a.a().a(false, "MATCH_ALL_UIN");
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(true);
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = paramVideoFeedsRecommendFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131377503));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      c(bool);
      if (paramBoolean) {
        break label65;
      }
      e(false);
      if (this.jdField_a_of_type_Aqre != null) {
        this.jdField_a_of_type_Aqre.k();
      }
      a(this);
      if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(true);
      }
    }
    label65:
    do
    {
      return;
      bool = false;
      break;
      e(true);
      if (this.jdField_a_of_type_Aqre != null) {
        this.jdField_a_of_type_Aqre.j();
      }
    } while (!(this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat));
    ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(true);
    }
  }
  
  protected void b()
  {
    try
    {
      super.setContentView(2131560305);
      this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID")))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID");
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("session_id");
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_c_of_type_JavaLangString = odr.b();
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CHANNEL_SESSION_ID");
        h();
        j();
        g();
        l();
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "setContentView IllegalStateException", localIllegalStateException);
        continue;
        this.jdField_a_of_type_JavaLangString = rpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Aqre.h();
      return;
    }
    this.jdField_a_of_type_Aqre.g();
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Rsx = new rsx(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(), this.jdField_a_of_type_Int, jdField_a_of_type_Boolean, this, 0);
      this.jdField_a_of_type_Rsx.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a());
      this.jdField_a_of_type_Rsx.a(this.jdField_a_of_type_Aqre);
    }
    ThreadManager.excute(new VideoFeedsPlayActivity.2(this), 16, null, true);
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getUserVisibleHint())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_Aqre.b(this);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null))
    {
      finish();
      overridePendingTransition(0, 2130772012);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean(odu.jdField_a_of_type_JavaLangString)) {
        oix.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
      }
      return;
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    long l = localVideoFeedsPlayManager.a();
    Object localObject = localVideoFeedsPlayManager.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == localObject)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", localVideoFeedsPlayManager.a());
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", l);
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject).g);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      setResult(-1, (Intent)localObject);
      finish();
      overridePendingTransition(0, 2130772012);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_FROM_CONVERSATION")) {
        oix.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
      }
      a("finishActivityWithResult() position=" + l + ", currentPlayStatus=" + localVideoFeedsPlayManager.a());
      return;
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", 0);
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(paramBoolean);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      if (this.jdField_a_of_type_Rsx != null) {
        this.jdField_a_of_type_Rsx.a(paramInt1, paramInt2, paramIntent);
      }
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        rpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        continue;
        if (paramInt2 == -1)
        {
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new QQToast(getActivity().getApplicationContext());
          ((QQToast)localObject).d(2000);
          if (i != 0)
          {
            ((QQToast)localObject).a(QQToast.a(2));
            ((QQToast)localObject).c(2131691991);
            ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299011) - (int)bhmg.a(getActivity().getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).a(QQToast.a(1));
            ((QQToast)localObject).c(2131691992);
            ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299011) - (int)bhmg.a(getActivity().getApplicationContext(), 5.0F));
            continue;
            if (paramInt2 == -1) {
              QQToast.a(getActivity(), 2131718211, 0).a();
            }
          }
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c())) {
      return;
    }
    f(false);
    d();
    super.doOnBackPressed();
  }
  
  @TargetApi(11)
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      ozs.a("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    super.doOnCreate(paramBundle);
    if (VersionUtils.isIceScreamSandwich()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(this);
    }
    a(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ocd.a(null, "", "0X800AF10", "0X800AF10", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "doOnCreate: " + paramBundle);
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      finish();
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "doOnCreate: getIntent().getExtras() = null");
      return true;
    }
    b();
    if (paramBundle != null) {
      overridePendingTransition(2130772225, 0);
    }
    for (;;)
    {
      VideoReport.setPageId(this, "8006");
      VideoReport.setPageParams(this, new pda().a());
      VideoReport.addToDetectionWhitelist(this);
      return true;
      if (getIntent().getBooleanExtra("VIDEO_FEEDS_ANIM_ENABLE", true)) {
        a().a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout);
      }
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      this.jdField_c_of_type_Boolean = true;
      rlo localrlo = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
        localrlo.a(localVideoInfo);
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
        }
        if (this.jdField_a_of_type_Rsx != null) {
          this.jdField_a_of_type_Rsx.d();
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        if (this.jdField_a_of_type_Rsr != null) {
          this.jdField_a_of_type_Rsr.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        rmp.a().a();
        sjv.a(this).b();
        ryi.a().a("video_feeds", this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Aqre.c();
        a("VideoFeedsPlayActivity doOnDestroy()");
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        a("super.doOnDestroy failed. \n", localIllegalArgumentException);
        m();
        continue;
        Object localObject = null;
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Rsx != null) {
      this.jdField_a_of_type_Rsx.c();
    }
    if (!this.e) {
      this.jdField_a_of_type_Aqre.b();
    }
    this.e = false;
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsPlayActivity.7(this), 500L);
    if (this.jdField_a_of_type_Rsx != null) {
      this.jdField_a_of_type_Rsx.b();
    }
    sjv.a(this).a(-1, -1);
    this.jdField_a_of_type_Aqre.a();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void doOnStop()
  {
    super.doOnStop();
    sjv.a(getActivity()).a();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    a(this);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.h();
    }
  }
  
  public String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      f(false);
      d();
      continue;
      if (this.jdField_a_of_type_Rsx != null) {
        this.jdField_a_of_type_Rsx.a(0);
      }
      this.e = true;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onRestoreInstanceState: ");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onSaveInstanceState: ");
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    this.mActNeedImmersive = false;
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawable(null);
    setRequestedOrientation(1);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((Build.VERSION.SDK_INT == 26) && (this.d))
    {
      aqvh.a(this);
      this.d = false;
    }
    try
    {
      superSetRequestedOrientation(paramInt);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "setRequestedOrientation: ", localException);
    }
  }
  
  public boolean themeChangeRightNow()
  {
    return false;
  }
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ozs.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */
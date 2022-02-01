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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import aqge;
import bgme;
import bgtn;
import bqcd;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
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
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import oat;
import och;
import ock;
import ohp;
import org.json.JSONObject;
import pha;
import pkh;
import pmk;
import qps;
import qpt;
import rus;
import rut;
import rvt;
import rxy;
import ryx;
import sah;
import sai;
import saj;
import sak;
import sam;
import sar;
import sbe;
import sbu;
import sbv;
import sbx;
import sby;
import sce;
import sdj;
import sgt;
import she;
import skb;
import skc;
import ssr;

public class VideoFeedsPlayActivity
  extends FragmentActivity
  implements View.OnClickListener, rut, sbe, sbu, sbx, sdj
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
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private VideoFeedsCustomFrameLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout;
  private VideoFeedsRecommendFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment;
  private FrameLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat;
  private DragFrameLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private rus jdField_a_of_type_Rus;
  private sam jdField_a_of_type_Sam;
  private sbv jdField_a_of_type_Sbv;
  private sby jdField_a_of_type_Sby;
  private sce jdField_a_of_type_Sce;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g = true;
  
  private rus a()
  {
    if (this.jdField_a_of_type_Rus == null) {
      switch (getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0))
      {
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_Rus;
      this.jdField_a_of_type_Rus = new VideoFeedsLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_Rus = new VideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_Rus = new sgt(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
    }
  }
  
  public static void a(Activity paramActivity)
  {
    ryx.a(paramActivity);
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
    int i;
    label31:
    Object localObject2;
    boolean bool;
    label165:
    label189:
    Object localObject3;
    label201:
    label236:
    Object localObject4;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label391;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
      Object localObject5 = new skc("", "", "", "").b(this.jdField_a_of_type_JavaLangString).a(409409).b((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      if (localObject1 != null)
      {
        localObject2 = ((skc)localObject5).e(((VideoInfo)localObject1).f).c(((VideoInfo)localObject1).p).l(i).r(((VideoInfo)localObject1).d()).s(this.jdField_b_of_type_Int + 1).d(((VideoInfo)localObject1).j).e(((VideoInfo)localObject1).jdField_a_of_type_JavaLangString).f(((VideoInfo)localObject1).g);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.d())) {
          break label396;
        }
        bool = true;
        ((skc)localObject2).b(bool);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label402;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
      if (localObject2 == null) {
        break label408;
      }
      localObject3 = ((VideoInfo)localObject2).g;
      int j = getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      ((skc)localObject5).g((String)localObject3).F(j).N(0);
      if (!paramBoolean) {
        break label414;
      }
      localObject3 = "1";
      if (!jdField_a_of_type_Boolean) {
        break label422;
      }
      localObject4 = "0X8009501";
      label247:
      oat.a(null, "", (String)localObject4, (String)localObject4, 0, 0, (String)localObject3, "", "", ((skc)localObject5).a().a(), false);
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
          break label430;
        }
      }
    }
    label391:
    label396:
    label402:
    label408:
    label414:
    label422:
    label430:
    for (Object localObject1 = String.valueOf(1);; localObject1 = String.valueOf(2))
    {
      oat.a(null, "", "0X800957B", "0X800957B", 0, 0, (String)localObject3, (String)localObject4, (String)localObject1, "", false);
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
      break label236;
      localObject4 = "0X8007DBB";
      break label247;
    }
  }
  
  private void h()
  {
    ThreadManager.post(new VideoFeedsPlayActivity.1(this), 1, null, true);
  }
  
  private void i()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_a_of_type_Int = i;
    if ((i == 9) || (i == 12) || (i == 21) || (i == 20) || (i == 22) || (i == 23)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("KEY_IS_WEISHI_MODE", jdField_a_of_type_Boolean);
      getIntent().putExtra("KEY_IS_WEISHI_MODE", jdField_a_of_type_Boolean);
      l();
      this.jdField_a_of_type_Sam = new sam(this, null);
      return;
    }
  }
  
  private void j()
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
          oat.a(null, str3, "0X800740A", "0X800740A", 0, 0, String.valueOf(i), String.valueOf(j), (String)localObject, och.a(str2, str3, str4, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(), l, localJSONObject), false);
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
  private void k()
  {
    int i = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
    this.jdField_a_of_type_Sby = new sby(this);
    this.jdField_a_of_type_Sby.a(i);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)findViewById(2131365714));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout = ((VideoFeedsCustomFrameLayout)findViewById(2131376798));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131370647));
    this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131368646);
    if (bqcd.b())
    {
      i = bqcd.b(this);
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), i + this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a().a(getLayoutInflater(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131370635));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      c(false);
    }
  }
  
  private void l()
  {
    boolean bool2 = false;
    if (!ReadinjoyTabFrame.d_())
    {
      this.d = false;
      return;
    }
    int[] arrayOfInt = new int[9];
    int[] tmp23_21 = arrayOfInt;
    tmp23_21[0] = 0;
    int[] tmp27_23 = tmp23_21;
    tmp27_23[1] = 1;
    int[] tmp31_27 = tmp27_23;
    tmp31_27[2] = 9;
    int[] tmp36_31 = tmp31_27;
    tmp36_31[3] = 12;
    int[] tmp41_36 = tmp36_31;
    tmp41_36[4] = 20;
    int[] tmp46_41 = tmp41_36;
    tmp46_41[5] = 21;
    int[] tmp51_46 = tmp46_41;
    tmp51_46[6] = 22;
    int[] tmp57_51 = tmp51_46;
    tmp57_51[7] = 23;
    int[] tmp63_57 = tmp57_51;
    tmp63_57[8] = 24;
    tmp63_57;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (this.jdField_a_of_type_Int == k)
      {
        this.d = false;
        return;
      }
      i += 1;
    }
    boolean bool1 = bool2;
    if (RIJRedPacketManager.a().c())
    {
      bool1 = bool2;
      if (RIJRedPacketManager.a().e()) {
        bool1 = true;
      }
    }
    this.f = bool1;
    RIJRedPacketManager.a().a(new sai(this));
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.post(new VideoFeedsPlayActivity.5(this));
  }
  
  private void n()
  {
    FlingGestureHandler localFlingGestureHandler;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (!(this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        break label79;
      }
      localFlingGestureHandler.setTopLayout(new TopEdgeGestureLayout(this));
    }
    for (;;)
    {
      localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(true);
      localFlingGestureHandler.mTopLayout.setInterceptScrollRLFlag(true);
      localFlingGestureHandler.mTopLayout.setOnFlingGesture(new saj(this));
      return;
      label79:
      localFlingGestureHandler.setTopLayout(new TopGestureLayout(this));
    }
  }
  
  private void o()
  {
    int i = 3;
    if (!this.d) {
      return;
    }
    RIJRedPacketManager.a().a(this, 2, 1, 1);
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    skc localskc1 = new skc(localVideoInfo);
    Object localObject = localskc1.a("icon_position", Integer.valueOf(3));
    skc localskc2;
    if (this.e)
    {
      localskc2 = ((skc)localObject).a("icon_status", Integer.valueOf(i));
      if (localVideoInfo == null) {
        break label140;
      }
    }
    label140:
    for (localObject = localVideoInfo.g;; localObject = "")
    {
      localskc2.h((String)localObject);
      oat.a(null, "", "0X800ABBC", "0X800ABBC", 0, 0, "", "", localVideoInfo.g, localskc1.a().a(), false);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a() == 1)
      {
        i = 2;
        break;
      }
      i = 1;
      break;
    }
  }
  
  private void p()
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
  
  private void q()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
    if (this.jdField_a_of_type_Sbv.a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843105);
      return;
    }
    if ((localVideoInfo != null) && (this.jdField_a_of_type_Sbv.a(localVideoInfo)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843106);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849439);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843105);
  }
  
  public void D_() {}
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    VideoInfo localVideoInfo;
    int i;
    if ((paramViewHolder instanceof rxy))
    {
      paramViewHolder = (rxy)paramViewHolder;
      localVideoInfo = paramViewHolder.a.a;
      if (this.jdField_a_of_type_Sce != null) {
        this.jdField_a_of_type_Sce.a(localVideoInfo);
      }
      i = paramViewHolder.c;
      if (i <= this.jdField_b_of_type_Int) {
        break label86;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilSet.add(localVideoInfo.jdField_a_of_type_JavaLangString);
      qps.a.a().a(false, "MATCH_ALL_UIN");
      return;
      label86:
      i = this.jdField_b_of_type_Int;
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
      qps.a.a().a(false, "MATCH_ALL_UIN");
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131377361));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_Sbv = new sbv(this, this.f, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidViewViewGroup, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this.jdField_a_of_type_Sbv);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.d) {
      RIJRedPacketManager.a().a(new sah(this, paramString, paramLong));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      c(bool);
      if (paramBoolean) {
        break label46;
      }
      a(this);
      if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(true);
      }
    }
    label46:
    while (!(this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat))
    {
      return;
      bool = false;
      break;
    }
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
    super.setContentView(2131560293);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID"))) {}
    for (this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID");; this.jdField_a_of_type_JavaLangString = ryx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID")))
    {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("session_id");
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = och.b();
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CHANNEL_SESSION_ID");
      i();
      k();
      h();
      n();
      return;
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    q();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.d) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
      }
    }
    for (;;)
    {
      q();
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.d)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(8);
      }
    }
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Sce = new sce(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(), this.jdField_a_of_type_Int, jdField_a_of_type_Boolean, this, 0);
      this.jdField_a_of_type_Sce.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a());
    }
    ThreadManager.excute(new VideoFeedsPlayActivity.2(this), 16, null, true);
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getUserVisibleHint())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = ((RIJRedPacketProgressView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380657));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat = ((FrameLayoutCompat)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380633));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setOnClickListener(this);
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getUserVisibleHint())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
    }
    if (this.d) {
      m();
    }
    ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.getLayoutParams()).rightMargin = bgtn.a(36.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this);
    this.jdField_a_of_type_Sbv.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a());
    this.jdField_a_of_type_Sce.a(this.jdField_a_of_type_Sbv);
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    q();
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.d)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat == null) || (!this.d));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(8);
  }
  
  public void d()
  {
    if (this.d)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.c();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b(paramBoolean);
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
      if (this.jdField_a_of_type_Sce != null) {
        this.jdField_a_of_type_Sce.a(paramInt1, paramInt2, paramIntent);
      }
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        ryx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b().w)))
        {
          RIJRedPacketManager.a().a(new sak(this));
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
              ((QQToast)localObject).c(2131691987);
              ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131298998) - (int)bgme.a(getActivity().getApplicationContext(), 5.0F));
            }
            else
            {
              ((QQToast)localObject).a(QQToast.a(1));
              ((QQToast)localObject).c(2131691988);
              ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131298998) - (int)bgme.a(getActivity().getApplicationContext(), 5.0F));
              continue;
              if (paramInt2 == -1) {
                QQToast.a(getActivity(), 2131718078, 0).a();
              }
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
    e(false);
    e();
    super.doOnBackPressed();
  }
  
  @TargetApi(11)
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      pha.a("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    super.doOnCreate(paramBundle);
    if (VersionUtils.isIceScreamSandwich()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    bqcd.a(this);
    if (bqcd.b()) {
      bqcd.c(this);
    }
    a(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    oat.a(null, "", "0X800AF10", "0X800AF10", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
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
      VideoReport.setPageParams(this, new pkh().a());
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
      rus localrus = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
        localrus.a(localVideoInfo);
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
        }
        if (this.jdField_a_of_type_Sce != null) {
          this.jdField_a_of_type_Sce.d();
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        if (this.jdField_a_of_type_Sby != null) {
          this.jdField_a_of_type_Sby.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        rvt.a().a();
        ssr.a(this).b();
        pmk.a().b(this.jdField_a_of_type_Sam);
        she.a().a("video_feeds", this.jdField_b_of_type_Int);
        a("VideoFeedsPlayActivity doOnDestroy()");
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        a("super.doOnDestroy failed. \n", localIllegalArgumentException);
        p();
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
    if (this.jdField_a_of_type_Sce != null) {
      this.jdField_a_of_type_Sce.c();
    }
    pmk.a().b(this.jdField_a_of_type_Sam);
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    a(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsPlayActivity.7(this), 500L);
    if (this.jdField_a_of_type_Sce != null) {
      this.jdField_a_of_type_Sce.b();
    }
    ssr.a(this).a(-1, -1);
    pmk.a().a(this.jdField_a_of_type_Sam);
    super.doOnResume();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void doOnStop()
  {
    super.doOnStop();
    ssr.a(getActivity()).a();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    a(this);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null))
    {
      finish();
      overridePendingTransition(0, 2130772012);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean(ock.jdField_a_of_type_JavaLangString)) {
        ohp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
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
        ohp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
      }
      a("finishActivityWithResult() position=" + l + ", currentPlayStatus=" + localVideoFeedsPlayManager.a());
      return;
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", 0);
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.h();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.i();
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
      e(false);
      e();
      continue;
      if (this.jdField_a_of_type_Sce != null)
      {
        this.jdField_a_of_type_Sce.a(0);
        continue;
        o();
      }
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
    if ((Build.VERSION.SDK_INT == 26) && (this.g))
    {
      aqge.a(this);
      this.g = false;
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
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)pha.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */
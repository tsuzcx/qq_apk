package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import bdcd;
import bdcq;
import bdfq;
import bdkf;
import bhou;
import bjxj;
import bngs;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import nrt;
import ntd;
import ntg;
import nxu;
import org.json.JSONObject;
import ors;
import oxb;
import qyt;
import qyw;
import qyx;
import raa;
import rbt;
import rcn;
import rdm;
import rff;
import rfg;
import rfi;
import rfj;
import rfk;
import rfm;
import rfs;
import rgh;
import rgw;
import rgx;
import rgz;
import rha;
import rhf;
import rhs;
import rls;
import rmd;
import rom;
import ron;
import ruv;

public class VideoFeedsPlayActivity
  extends FragmentActivity
  implements View.OnClickListener, qyx, rgh, rgw, rgz, rhs
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private VideoFeedsCustomFrameLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout;
  private VideoFeedsRecommendFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment;
  private FrameLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat;
  private DragFrameLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private qyw jdField_a_of_type_Qyw;
  private rcn jdField_a_of_type_Rcn;
  private rfm jdField_a_of_type_Rfm;
  private rgx jdField_a_of_type_Rgx;
  private rha jdField_a_of_type_Rha;
  private rhf jdField_a_of_type_Rhf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  private qyw a()
  {
    if (this.jdField_a_of_type_Qyw == null) {
      switch (getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0))
      {
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_Qyw;
      this.jdField_a_of_type_Qyw = new VideoFeedsLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_Qyw = new VideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_Qyw = new rls(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
    }
  }
  
  public static void a(Activity paramActivity)
  {
    rdm.a(paramActivity);
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
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      VideoInfo localVideoInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
      VideoInfo localVideoInfo1 = localVideoInfo2;
      if (localVideoInfo2 == null) {
        localVideoInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      }
      ThreadManager.excute(new VideoFeedsPlayActivity.8(this, localVideoInfo1, paramString), 16, null, true);
    }
  }
  
  private void d(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayActivity.3(this, paramVideoInfo));
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
    label238:
    Object localObject4;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label394;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      Object localObject5 = new ron("", "", "", "").b(this.jdField_a_of_type_JavaLangString).a(409409).b((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      if (localObject1 != null)
      {
        localObject2 = ((ron)localObject5).e(((VideoInfo)localObject1).f).c(((VideoInfo)localObject1).o).l(i).r(((VideoInfo)localObject1).d()).s(this.jdField_b_of_type_Int + 1).d(((VideoInfo)localObject1).j).e(((VideoInfo)localObject1).jdField_a_of_type_JavaLangString).f(((VideoInfo)localObject1).g);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.d())) {
          break label399;
        }
        bool = true;
        ((ron)localObject2).b(bool);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label405;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
      if (localObject2 == null) {
        break label411;
      }
      localObject3 = ((VideoInfo)localObject2).g;
      int j = getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      ((ron)localObject5).g((String)localObject3).F(j).N(0);
      if (!paramBoolean) {
        break label417;
      }
      localObject3 = "1";
      if (!this.jdField_a_of_type_Boolean) {
        break label425;
      }
      localObject4 = "0X8009501";
      label250:
      nrt.a(null, "", (String)localObject4, (String)localObject4, 0, 0, (String)localObject3, "", "", ((ron)localObject5).a().a(), false);
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
          break label433;
        }
      }
    }
    label394:
    label399:
    label405:
    label411:
    label417:
    label425:
    label433:
    for (Object localObject1 = String.valueOf(1);; localObject1 = String.valueOf(2))
    {
      nrt.a(null, "", "0X800957B", "0X800957B", 0, 0, (String)localObject3, (String)localObject4, (String)localObject1, "", false);
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
      break label250;
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
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("KEY_IS_WEISHI_MODE", this.jdField_a_of_type_Boolean);
      getIntent().putExtra("KEY_IS_WEISHI_MODE", this.jdField_a_of_type_Boolean);
      this.d = bjxj.f(this.jdField_a_of_type_Int);
      l();
      this.jdField_a_of_type_Rfm = new rfm(this, null);
      return;
    }
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    int i = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int j = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
    String str2;
    if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0) && (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      str2 = ((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    for (;;)
    {
      String str3;
      label76:
      String str1;
      label88:
      String str4;
      label100:
      long l;
      label116:
      JSONObject localJSONObject;
      if (localObject != null)
      {
        str3 = ((VideoInfo)localObject).j;
        if (localObject == null) {
          break label222;
        }
        str1 = ((VideoInfo)localObject).g;
        if (localObject == null) {
          break label228;
        }
        str4 = ((VideoInfo)localObject).jdField_a_of_type_JavaLangString;
        if (localObject == null) {
          break label234;
        }
        l = ((VideoInfo)localObject).a() * 1000L;
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("session_id", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("video_session_id", this.jdField_b_of_type_JavaLangString);
        label151:
        if (!TextUtils.isEmpty(str1)) {}
        for (localObject = str1;; localObject = "0")
        {
          nrt.a(null, str3, "0X800740A", "0X800740A", 0, 0, String.valueOf(i), String.valueOf(j), (String)localObject, ntd.a(str2, str3, str4, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b(), l, localJSONObject), false);
          return;
          str2 = null;
          break;
          str3 = null;
          break label76;
          label222:
          str1 = null;
          break label88;
          label228:
          str4 = null;
          break label100;
          label234:
          l = 0L;
          break label116;
        }
      }
      catch (Exception localException)
      {
        break label151;
      }
    }
  }
  
  @TargetApi(11)
  private void k()
  {
    int i = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
    this.jdField_a_of_type_Rha = new rha(this);
    this.jdField_a_of_type_Rha.a(i);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)findViewById(2131365476));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout = ((VideoFeedsCustomFrameLayout)findViewById(2131375991));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367571));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131367570));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131367572));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131370188));
    this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131368327);
    if (bngs.b())
    {
      i = bngs.b(this);
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), i + this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a().a(getLayoutInflater(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131370175));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      c(false);
    }
  }
  
  private void l()
  {
    boolean bool2 = false;
    if (!ReadinjoyTabFrame.c_())
    {
      this.e = false;
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
        this.e = false;
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
    this.g = bool1;
    RIJRedPacketManager.a().a(new rfi(this));
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
        break label71;
      }
      localFlingGestureHandler.setTopLayout(new TopEdgeGestureLayout(this));
    }
    for (;;)
    {
      localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(true);
      localFlingGestureHandler.mTopLayout.setOnFlingGesture(new rfj(this));
      return;
      label71:
      localFlingGestureHandler.setTopLayout(new TopGestureLayout(this));
    }
  }
  
  private void o()
  {
    int i = 3;
    if (!this.e) {
      return;
    }
    RIJRedPacketManager.a().a(this, 2, 1, 1);
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    ron localron1 = new ron(localVideoInfo);
    Object localObject = localron1.a("icon_position", Integer.valueOf(3));
    ron localron2;
    if (this.f)
    {
      localron2 = ((ron)localObject).a("icon_status", Integer.valueOf(i));
      if (localVideoInfo == null) {
        break label140;
      }
    }
    label140:
    for (localObject = localVideoInfo.g;; localObject = "")
    {
      localron2.h((String)localObject);
      nrt.a(null, "", "0X800ABBC", "0X800ABBC", 0, 0, "", "", localVideoInfo.g, localron1.a().a(), false);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), ntg.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    if (qyt.a(this))
    {
      s();
      return;
    }
    bdcd.a(this, 230, getString(2131719000), getString(2131718998), getString(2131718997), getString(2131718999), new rfk(this), null).show();
  }
  
  private void q()
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
  
  private void r()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
    if (this.jdField_a_of_type_Rgx.a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842750);
      return;
    }
    if ((localVideoInfo != null) && (this.jdField_a_of_type_Rgx.a(localVideoInfo)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842751);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848868);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842750);
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout);
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    VideoInfo localVideoInfo;
    int i;
    if ((paramViewHolder instanceof rbt))
    {
      paramViewHolder = (rbt)paramViewHolder;
      localVideoInfo = paramViewHolder.a.a;
      if (this.jdField_a_of_type_Rhf != null) {
        this.jdField_a_of_type_Rhf.a(localVideoInfo);
      }
      i = paramViewHolder.c;
      if (i <= this.jdField_b_of_type_Int) {
        break label118;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = i;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(localVideoInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilSet.add(localVideoInfo.jdField_a_of_type_JavaLangString);
        if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          b("0X8009A26");
        }
      }
      d(localVideoInfo);
      return;
      label118:
      i = this.jdField_b_of_type_Int;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
      if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(false);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    } while (!(this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat));
    ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(true);
  }
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = paramVideoFeedsRecommendFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131376516));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_Rgx = new rgx(this, this.g, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidViewViewGroup, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rgx);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.e) {
      RIJRedPacketManager.a().a(new rfg(this, paramString, paramLong));
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
    if (((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder instanceof rbt)) && (((rbt)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a != null) && (((rbt)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).c == 0)) {
      d(((rbt)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a.a);
    }
  }
  
  protected void b()
  {
    super.setContentView(2131560148);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID"))) {}
    for (this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID");; this.jdField_a_of_type_JavaLangString = rdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID")))
    {
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
    r();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.d) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e())) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.e) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
      }
    }
    for (;;)
    {
      r();
      return;
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.d))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_Rcn != null) {
          this.jdField_a_of_type_Rcn.a();
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.e)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(8);
      }
    }
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Rhf = new rhf(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this, 0);
      this.jdField_a_of_type_Rhf.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a());
    }
    j();
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131370187));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getUserVisibleHint()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.d)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_Rcn = new rcn(this);
        this.jdField_a_of_type_Rcn.a(this.jdField_a_of_type_Rgx);
        this.jdField_a_of_type_Rgx.a(this.jdField_a_of_type_Rcn);
        this.jdField_a_of_type_Rcn.a(this.jdField_c_of_type_AndroidWidgetImageView);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = ((RIJRedPacketProgressView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379642));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat = ((FrameLayoutCompat)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379625));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setOnClickListener(this);
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getUserVisibleHint())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
    }
    if (this.e) {
      m();
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.getLayoutParams();
    if (this.d) {}
    for (localMarginLayoutParams.rightMargin = bdkf.a(72.0F);; localMarginLayoutParams.rightMargin = bdkf.a(36.0F))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this);
      this.jdField_a_of_type_Rgx.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a());
      this.jdField_a_of_type_Rhf.a(this.jdField_a_of_type_Rgx);
      return;
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    r();
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.d)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.e)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.d))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_Rcn != null) {
          this.jdField_a_of_type_Rcn.a();
        }
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat == null) || (!this.e));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(8);
  }
  
  public void d()
  {
    if (this.e)
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
      if (this.jdField_a_of_type_Rhf != null) {
        this.jdField_a_of_type_Rhf.a(paramInt1, paramInt2, paramIntent);
      }
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        rdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c().u)))
        {
          RIJRedPacketManager.a().a(new rff(this));
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
              ((QQToast)localObject).c(2131692401);
              ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdcq.a(getActivity().getApplicationContext(), 5.0F));
            }
            else
            {
              ((QQToast)localObject).a(QQToast.a(1));
              ((QQToast)localObject).c(2131692402);
              ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdcq.a(getActivity().getApplicationContext(), 5.0F));
              continue;
              if (paramInt2 == -1) {
                QQToast.a(getActivity(), 2131720103, 0).a();
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
      ors.a("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    super.doOnCreate(paramBundle);
    if (bhou.d()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    bngs.a(this);
    if (bngs.b()) {
      bngs.c(this);
    }
    a(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "doOnCreate: " + paramBundle);
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      finish();
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "doOnCreate: getIntent().getExtras() = null");
    }
    do
    {
      return true;
      b();
      if (paramBundle != null)
      {
        overridePendingTransition(2130772215, 0);
        return true;
      }
    } while (!getIntent().getBooleanExtra("VIDEO_FEEDS_ANIM_ENABLE", true));
    a().a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout);
    return true;
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      this.jdField_c_of_type_Boolean = true;
      qyw localqyw = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
        localqyw.a(localVideoInfo);
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
        }
        if (this.jdField_a_of_type_Rhf != null) {
          this.jdField_a_of_type_Rhf.d();
        }
        if (this.jdField_a_of_type_Rcn != null) {
          this.jdField_a_of_type_Rcn.b();
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        if (this.jdField_a_of_type_Rha != null) {
          this.jdField_a_of_type_Rha.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        raa.a().a();
        ruv.a(this).b();
        oxb.a().b(this.jdField_a_of_type_Rfm);
        rmd.a().a("video_feeds", this.jdField_b_of_type_Int);
        a("VideoFeedsPlayActivity doOnDestroy()");
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        a("super.doOnDestroy failed. \n", localIllegalArgumentException);
        q();
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
    if (this.jdField_a_of_type_Rhf != null) {
      this.jdField_a_of_type_Rhf.c();
    }
    oxb.a().b(this.jdField_a_of_type_Rfm);
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    a(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsPlayActivity.9(this), 500L);
    if (this.jdField_a_of_type_Rhf != null) {
      this.jdField_a_of_type_Rhf.b();
    }
    ruv.a(this).a(-1, -1);
    oxb.a().a(this.jdField_a_of_type_Rfm);
    super.doOnResume();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void doOnStop()
  {
    super.doOnStop();
    ruv.a(getActivity()).a();
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
      overridePendingTransition(0, 2130772011);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean(ntg.jdField_a_of_type_JavaLangString)) {
        nxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
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
      overridePendingTransition(0, 2130772011);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_FROM_CONVERSATION")) {
        nxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
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
    default: 
    case 2131370175: 
    case 2131376516: 
    case 2131370187: 
      do
      {
        do
        {
          return;
          e(false);
          e();
          return;
        } while (this.jdField_a_of_type_Rhf == null);
        this.jdField_a_of_type_Rhf.a(0);
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null));
      p();
      b("0X8009A27");
      return;
    }
    o();
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
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */
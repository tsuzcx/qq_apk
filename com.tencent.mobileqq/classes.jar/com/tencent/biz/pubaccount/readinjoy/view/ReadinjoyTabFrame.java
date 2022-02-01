package com.tencent.biz.pubaccount.readinjoy.view;

import acsb;
import acsc;
import afur;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anll;
import anlv;
import anni;
import bclx;
import bcnj;
import bctj;
import bdch;
import bggq;
import bgjq;
import bgln;
import bglp;
import bgnt;
import bgpa;
import bgsg;
import bgtn;
import bkni;
import bknl;
import bmqa;
import bmqj;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import oat;
import och;
import ogh;
import ohp;
import ooi;
import oon;
import oqm;
import oqr;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import ovj;
import oyp;
import pgk;
import pha;
import phi;
import plz;
import pmb;
import pmh;
import pmk;
import pmm;
import pmn;
import pmr;
import pol;
import puu;
import pwl;
import pxh;
import pxo;
import pxt;
import pyb;
import qak;
import qps;
import qpt;
import qzh;
import qzn;
import qzs;
import qzu;
import qzw;
import rac;
import rag;
import raj;
import rat;
import rcx;
import rdd;
import rfq;
import rjh;
import rup;
import rvd;
import ryj;
import ryx;
import seu;
import sfq;
import sgc;
import shr;
import skb;
import skc;
import smj;
import spq;
import suc;
import sui;
import suj;
import suk;
import sul;
import sum;
import sun;
import suo;
import sup;
import suq;
import sur;
import sus;
import sut;
import suu;
import suv;
import suw;
import sux;
import suy;
import suz;
import sva;
import svb;
import svc;
import svi;
import svw;
import svx;
import tdi;
import tek;
import tjj;
import tkf;
import tkg;
import ttd;
import txa;
import uac;
import ube;

public class ReadinjoyTabFrame
  extends anlv
  implements ViewTreeObserver.OnGlobalLayoutListener, plz, pmb, pol, pyb, rac, suc, svi
{
  public static int a;
  public static boolean a;
  private static boolean jdField_b_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new sul(this);
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private SparseArray<Bundle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new suv(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  private ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout;
  private DuplicateEventLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
  private ReadinjoySlidingIndicator jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator;
  private ReadinjoyTabFrame.InitWebProcessRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable = new ReadinjoyTabFrame.InitWebProcessRunnable();
  private ReadinjoyViewLayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
  private FrameFragment jdField_a_of_type_ComTencentMobileqqAppFrameFragment;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public Runnable a;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ogh jdField_a_of_type_Ogh;
  private pmn jdField_a_of_type_Pmn = new sum(this);
  private raj jdField_a_of_type_Raj;
  private ryj jdField_a_of_type_Ryj;
  private shr jdField_a_of_type_Shr;
  protected tdi a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[1];
  public int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ReadinjoyTabFrame.1(this);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView;
  private long jdField_g_of_type_Long;
  private View jdField_g_of_type_AndroidViewView;
  private View h;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ReadinjoyTabFrame(FrameFragment paramFrameFragment)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ReadinjoyTabFrame.16(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment = paramFrameFragment;
  }
  
  private void E()
  {
    Y();
    N();
    RecommendFeedsDiandianEntranceManager.a().b();
    if (this.jdField_a_of_type_Ryj != null) {
      this.jdField_a_of_type_Ryj.d();
    }
  }
  
  private void F()
  {
    a(2131379020).setBackgroundDrawable(null);
    this.jdField_a_of_type_Tdi = new tdi(a(), (ViewGroup)a(2131379020));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131376009));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131376026));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376007));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131377982));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131376576));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131364504));
    this.jdField_b_of_type_AndroidViewView = a(2131378796);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131377653));
    R();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378874));
    this.jdField_d_of_type_AndroidViewView = a(2131377827);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376078));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131376077));
    this.h = a(2131377046);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379887));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379886));
    label332:
    label340:
    Object localObject;
    if (pha.r())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131167279));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131167224));
      }
      if (!rjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label683;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (pha.j() != 0) {
        break label695;
      }
      i = 1;
      localObject = a(2131371394);
      if (i == 0) {
        break label700;
      }
    }
    label683:
    label695:
    label700:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.jdField_g_of_type_AndroidViewView = a(2131376053);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131371347));
      i = afur.a(3.0F, a());
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new suk(this));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131376285));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = ((RIJRedPacketProgressView)a(2131376284));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setOnClickListener(new sut(this));
      M();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131371857)).a(53).a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new sux(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new suy(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new suz(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      G_();
      ar_();
      K();
      J();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131364947);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      if ("2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnLongClickListener(new sva(this));
      }
      F_();
      this.jdField_a_of_type_Raj = new raj(new rag());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.addOnPageChangeListener(new svb(this));
      return;
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label332;
      i = 0;
      break label340;
    }
  }
  
  private void G()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {}
    for (;;)
    {
      return;
      boolean bool = rjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bool) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      while ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
      {
        QLog.i("ReadInJoyTabFrame", 2, "[refreshDeliverButton] needShow = " + bool);
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void H()
  {
    if ((RIJRedPacketManager.a().c()) && (d_()) && (RIJRedPacketManager.a().e()))
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a(1, false, null);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void I()
  {
    SelectPositionModule localSelectPositionModule = pmh.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void J()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Tdi);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Ogh = new ogh(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Ogh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_Ogh.a(this.jdField_a_of_type_Tdi);
  }
  
  private void K()
  {
    L();
  }
  
  private void L()
  {
    if (bmqa.j()) {}
    while (!bmqa.i()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new svc(this));
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          QLog.d("ReadInJoyTabFrame", 1, "show channel entrance failed.");
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(4);
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new sui(this));
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "set click listener failed.");
        return;
      }
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        localThrowable3.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "hide channel entrance failed.");
      }
    }
  }
  
  private void M()
  {
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131373627);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297253);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new suj(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    boolean bool = bmqa.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    switch (bmqa.d())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_Ryj = new ryj(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "is show video entrance button: " + bool);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849399));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849363));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130842739));
    }
  }
  
  private void N()
  {
    int i = RecommendFeedsDiandianEntranceManager.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null)
    {
      Drawable localDrawable = a().getDrawable(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
    }
  }
  
  private void O()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = bgsg.d((Context)localObject1);
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) {
          bool2 = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyTabFrame", 2, "initBubblePopWindow mEntranceLayout:" + bool1 + "   btnVisible:" + bool2);
        }
        if ((bgsg.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (bmqa.d() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          bgsg.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = bggq.a((Context)localObject1, 12.0F);
          int j = bggq.a((Context)localObject1, 9.0F);
          shr localshr = new shr((Context)localObject1);
          this.jdField_a_of_type_Shr = localshr;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localshr.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131717268));
          localshr.setAnimationStyle(2131755843);
          localshr.b(-16777216);
          localshr.setSoftInputMode(1);
          localshr.setInputMethodMode(2);
          localshr.a(localshr.b() / 2 - bggq.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = bclx.jdField_a_of_type_Int;
          j = bggq.a((Context)localObject1, 15.0F);
          int k = localshr.b();
          int m = localObject2[1];
          int n = localshr.a();
          int i1 = localshr.c();
          int i2 = bggq.a((Context)localObject1, 5.0F);
          localshr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.13(this), 3000L);
          oat.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new skc(null, null, null, null).a().a(), false);
        }
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool2 = false;
      }
      bool1 = false;
    }
  }
  
  private void P()
  {
    if (this.jdField_a_of_type_Shr != null) {
      this.jdField_a_of_type_Shr.dismiss();
    }
  }
  
  private void Q()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131376061)).inflate();
      }
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_f_of_type_AndroidViewView == null)
      {
        Object localObject = a();
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getLayoutInflater();
          if (localObject != null) {
            this.jdField_f_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131560226, null);
          }
        }
      }
      if (this.jdField_f_of_type_AndroidViewView != null)
      {
        if ((this.jdField_f_of_type_AndroidViewView.getParent() == null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_f_of_type_AndroidViewView);
        }
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_f_of_type_AndroidViewView == null);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void R()
  {
    int i = 0;
    if (i < 1)
    {
      switch (i)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anni.a(2131693162);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376065;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anni.a(2131711755);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376074;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anni.a(2131711683);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376089;
      }
    }
  }
  
  private void S()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131297253);
    }
  }
  
  private void T()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable.a(this);
    ThreadManager.executeOnSubThread(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable);
  }
  
  private void U()
  {
    if (!"2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bknl();
    ((bknl)localObject).jdField_a_of_type_Int = 0;
    ((bknl)localObject).jdField_a_of_type_JavaLangString = anni.a(2131711669);
    ((bknl)localObject).jdField_b_of_type_Int = 2130842495;
    localArrayList.add(localObject);
    localObject = new bknl();
    ((bknl)localObject).jdField_a_of_type_Int = 1;
    ((bknl)localObject).jdField_a_of_type_JavaLangString = anni.a(2131711862);
    ((bknl)localObject).jdField_b_of_type_Int = 2130842495;
    localArrayList.add(localObject);
    localObject = new bknl();
    ((bknl)localObject).jdField_a_of_type_Int = 2;
    ((bknl)localObject).jdField_a_of_type_JavaLangString = anni.a(2131711800);
    ((bknl)localObject).jdField_a_of_type_Float = 14.0F;
    ((bknl)localObject).jdField_b_of_type_Int = 2130842495;
    localArrayList.add(localObject);
    localObject = new bknl();
    ((bknl)localObject).jdField_a_of_type_Int = 3;
    ((bknl)localObject).jdField_a_of_type_JavaLangString = anni.a(2131711725);
    ((bknl)localObject).jdField_b_of_type_Int = 2130842495;
    localArrayList.add(localObject);
    bknl localbknl = new bknl();
    localbknl.jdField_a_of_type_Int = 4;
    if (!pha.n())
    {
      localObject = "打开预加载UI";
      localbknl.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbknl.jdField_b_of_type_Int = 2130842495;
      localArrayList.add(localbknl);
      localbknl = new bknl();
      localbknl.jdField_a_of_type_Int = 5;
      if (((Boolean)bmqa.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label379;
      }
      localObject = "打开动态频道feeds";
      label263:
      localbknl.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbknl.jdField_a_of_type_Float = 12.0F;
      localbknl.jdField_b_of_type_Int = 2130842495;
      localArrayList.add(localbknl);
      localbknl = new bknl();
      localbknl.jdField_a_of_type_Int = 6;
      if (bmqa.B(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label386;
      }
    }
    label386:
    for (localObject = anni.a(2131711624);; localObject = "切换到Web")
    {
      localbknl.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbknl.jdField_a_of_type_Float = 12.0F;
      localbknl.jdField_b_of_type_Int = 2130842495;
      localArrayList.add(localbknl);
      bkni.a(a(), localArrayList, new sur(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
      return;
      localObject = "取消预加载UI";
      break;
      label379:
      localObject = "取消动态频道feeds";
      break label263;
    }
  }
  
  private void V()
  {
    a("0X800AC6C", 0);
  }
  
  private void W()
  {
    a("0X800AC6E", 2);
  }
  
  private void X()
  {
    a("0X800AC6D", 3);
  }
  
  private void Y()
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null))
    {
      boolean bool = bmqa.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
      if (!bool) {
        break label85;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("should video entrance when change account: ");
        if (!bool) {
          break label105;
        }
      }
    }
    label85:
    label105:
    for (String str = "true";; str = "false")
    {
      QLog.d("ReadInJoyTabFrame", 2, str);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
      break;
    }
  }
  
  private void Z()
  {
    int i = 8;
    int k = 0;
    boolean bool = bdch.a();
    if (bool == this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = bool;
    int j;
    Object localObject;
    if (bdch.a())
    {
      j = 0;
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(j);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
        if (this.jdField_e_of_type_Boolean) {
          break label199;
        }
        bool = true;
        label102:
        ((ReadInJoyChannelViewPager)localObject).setSlideLeftAndRight(bool);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        localObject = this.jdField_d_of_type_AndroidWidgetImageView;
        if (!pha.g()) {
          break label205;
        }
      }
    }
    label199:
    label205:
    for (i = k;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((a() instanceof ReadInJoyRecommendFeedsFragment)) {
        Y();
      }
      QLog.d("ReadInJoyTabFrame", 1, "updateStudyModelUI, isStudyMode= " + this.jdField_e_of_type_Boolean);
      return;
      j = 8;
      i = 0;
      break;
      bool = false;
      break label102;
    }
  }
  
  private int a(@NotNull Context paramContext, List<bknl> paramList)
  {
    int i = afur.a(125.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 15.0F);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      bknl localbknl = (bknl)paramList.next();
      int j = (int)Math.ceil(localTextView.getPaint().measureText(localbknl.jdField_a_of_type_JavaLangString)) + afur.a(71.0F, paramContext.getResources());
      if (j <= i) {
        break label102;
      }
      i = j;
    }
    label102:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private bknl a(int paramInt, String paramString, Drawable paramDrawable)
  {
    bknl localbknl = new bknl();
    localbknl.jdField_a_of_type_Int = paramInt;
    localbknl.jdField_a_of_type_JavaLangString = paramString;
    localbknl.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return localbknl;
  }
  
  private VideoInfo a()
  {
    boolean bool1 = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    int i = (int)(bgln.i() * 0.4D);
    int j = (int)(bgln.j() * 0.4D);
    Object localObject1 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject1);
    int k = localObject1[0];
    int m = this.jdField_a_of_type_AndroidViewView.getWidth();
    int n = localObject1[1];
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    localBundle.putInt("item_x", k + m - i);
    localBundle.putInt("item_y", n + i1 - j);
    localBundle.putInt("item_width", i);
    localBundle.putInt("item_height", j);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null)
    {
      localBundle.putInt("item_image_width", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      localBundle.putInt("item_image_height", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.b());
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    Object localObject2 = null;
    localObject1 = localObject2;
    boolean bool2;
    if ((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Ryj != null)
      {
        bool2 = this.jdField_a_of_type_Ryj.a(localBundle);
        localObject1 = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
        if (bmqa.d() != 1) {
          break label297;
        }
        localObject2 = rup.a((VideoInfo)localObject1);
        if ((localObject2 == null) || (!(localObject2 instanceof ArticleInfo))) {
          break label271;
        }
        ReadInJoyListViewGroup.a(a(), null, (ArticleInfo)localObject2, 1004);
      }
    }
    return localObject1;
    label271:
    ohp.a(a(), 56, a().getString(2131718063), 3, 1004);
    return localObject1;
    label297:
    localObject2 = a();
    if (!bool2) {}
    for (;;)
    {
      ryx.a((Activity)localObject2, localBundle, bool1, 11);
      c(3);
      return localObject1;
      bool1 = false;
    }
  }
  
  private void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    Object localObject = a();
    switch (paramInt)
    {
    default: 
      QLog.e("ReadInJoyTabFrame", 2, "showLocationChangedDialog invalid type = " + paramInt);
      return;
    case 1: 
      localObject = bglp.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((bgpa)localObject).setPositiveButton("确认", new sun(this, paramPositionData));
      ((bgpa)localObject).setNegativeButton("取消", new suo(this));
      ((bgpa)localObject).setCanceledOnTouchOutside(true);
      ((bgpa)localObject).show();
      return;
    }
    paramPositionData = spq.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new sup(this));
    paramPositionData.setNegativeButton("取消", new suq(this));
    paramPositionData.show();
  }
  
  private void a(int paramInt, List<bknl> paramList)
  {
    Drawable localDrawable;
    if ((paramInt & 0x1) != 0)
    {
      localDrawable = a().getDrawable(2130842791).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(0, BaseApplicationImpl.getApplication().getString(2131716993), localDrawable));
    }
    if ((paramInt & 0x2) != 0)
    {
      localDrawable = a().getDrawable(2130842792).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(1, BaseApplicationImpl.getApplication().getString(2131716997), localDrawable));
    }
    if (rjh.c())
    {
      localDrawable = a().getDrawable(2130842987).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(2, rjh.a(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (rjh.d())
    {
      localDrawable = a().getDrawable(2130842991).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(3, rjh.b(BaseApplicationImpl.getContext()), localDrawable));
    }
  }
  
  private void a(long paramLong)
  {
    pha.b().postDelayed(new ReadinjoyTabFrame.35(this), paramLong);
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    a(bmqa.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bkni.a(paramActivity, localArrayList, new sus(this, paramActivity), new suu(this), a(paramActivity, localArrayList), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131298729) - paramActivity.getResources().getDimensionPixelSize(2131298725) + afur.a(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131298059));
    V();
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.22(this, paramVideoInfo, (rdd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)), 16, null, true);
  }
  
  private void a(String paramString, int paramInt)
  {
    int j = 1;
    phi localphi1 = new phi();
    phi localphi2;
    if (rjh.d())
    {
      i = 1;
      localphi2 = localphi1.a("ugc_video_flag", Integer.valueOf(i));
      if (!rjh.c()) {
        break label88;
      }
    }
    label88:
    for (int i = j;; i = 0)
    {
      localphi2.a("ugc_column_flag", Integer.valueOf(i));
      if (paramInt != 0) {
        localphi1.a("from", Integer.valueOf(paramInt));
      }
      oat.a(paramString, localphi1.a());
      return;
      i = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ReadinjoyTabFrame.14 local14 = new ReadinjoyTabFrame.14(this, paramBoolean, paramInt);
    if (pha.B())
    {
      ThreadManager.executeOnSubThread(local14);
      return;
    }
    local14.run();
  }
  
  private void aa()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
    ohp.b(a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = pha.a();
        localJSONObject.put("folder_status", pha.d);
        if (!bool) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", pha.e());
        localJSONObject.put("kandian_mode_new", och.a());
        localObject = (rdd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
        if ((((rdd)localObject).a() != 1) || (TextUtils.isEmpty(((rdd)localObject).a()))) {
          continue;
        }
        localObject = ((rdd)localObject).a();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
        localObject = new HashMap();
        ((Map)localObject).put("uin", pha.a());
        UserAction.onUserAction("actRIJSelfPage", (Map)localObject, false, false);
        UserAction.onUserAction("actRIJSelfPage", (Map)localObject, false, false);
      }
      catch (Exception localException)
      {
        int i;
        Object localObject;
        localException.printStackTrace();
        continue;
      }
      uac.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      localObject = "0";
    }
  }
  
  private void ab()
  {
    pxo localpxo = pmh.a().a();
    if (localpxo != null) {
      localpxo.a(pha.a(), new suw(this));
    }
  }
  
  private void ac()
  {
    bmqa.h();
    pha.b().post(new ReadinjoyTabFrame.36(this));
    a(2500L);
  }
  
  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    ovj.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772242, 2130772039);
  }
  
  private void b(View paramView)
  {
    j = tkg.jdField_b_of_type_Int;
    try
    {
      paramView = paramView.getTag();
      i = j;
      if (paramView != null) {
        i = Integer.parseInt(String.valueOf(paramView));
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        tkf localtkf;
        QLog.d("ReadInJoyTabFrame", 1, "parseInt error!");
        int i = j;
        continue;
        if ((localtkf instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
        {
          String str = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localtkf).c;
          QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo jumpSchema " + str);
          paramView = str;
          if (TextUtils.isEmpty(str)) {
            paramView = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localtkf).jdField_a_of_type_Int);
          }
          if (!TextUtils.isEmpty(paramView))
          {
            pha.a(a(), paramView);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
          }
        }
        else
        {
          if ((localtkf instanceof tkg))
          {
            paramView = (tkg)localtkf;
            QLog.d("ReadInJoyTabFrame", 1, "column button jump to red source!");
            if (paramView.a == null) {
              pha.a(a(), bmqa.b());
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
              RecommendFeedsDiandianEntranceManager.a().a(paramView, i, 0);
              break;
              ryx.a(a(), paramView.a);
            }
          }
          a(a());
          continue;
          j = RecommendFeedsDiandianEntranceManager.a().a();
          QLog.d("ReadInJoyTabFrame", 1, "diandian button jump to default url!");
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.jdField_a_of_type_Boolean))
          {
            RecommendFeedsDiandianEntranceManager.a().a(null, i, 0);
            pha.a(a(), bmqa.b());
          }
          else if ((j == 2) || (j == 1))
          {
            a(a());
          }
          else
          {
            pha.a(a(), RecommendFeedsDiandianEntranceManager.a(j));
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      localtkf = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localtkf instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localtkf).a != null))
      {
        paramView = (VideoInfo.EntranceDownloadInfo)localtkf;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        ryx.a(a(), paramView.a);
        if (this.jdField_a_of_type_Ryj != null)
        {
          ryj.b(paramView);
          this.jdField_a_of_type_Ryj.a();
        }
        if (pha.t()) {
          a(2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
        }
        return;
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = pha.a();
    if (paramBoolean1) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject1 = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a();
        Object localObject3;
        long l2;
        if (localObject1 == null)
        {
          i = 1;
          localObject3 = pha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          String str2 = pha.a.jdField_a_of_type_JavaLangString;
          String str3 = pha.g(pha.a.c);
          l2 = 0L;
          if (i == 1)
          {
            l1 = 0L;
            ((JSONObject)localObject2).put("costtime_type", l2);
            ((JSONObject)localObject2).put("tab_status", i);
            ((JSONObject)localObject2).put("strategy_id", localObject3);
            ((JSONObject)localObject2).put("costtime", l1);
            ((JSONObject)localObject2).put("algorithm_id", str2);
            if (i != 3) {
              break label939;
            }
            ((JSONObject)localObject2).put("reddot_num", ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get());
            break label939;
            ((JSONObject)localObject2).put("current_page", j);
            if (!bgnt.h(a())) {
              break label960;
            }
            j = 2;
            ((JSONObject)localObject2).put("network_type", j);
            ((JSONObject)localObject2).put("kandian_mode_new", och.a());
            if (pha.g != 0) {
              break label966;
            }
            j = 0;
            ((JSONObject)localObject2).put("button_state", j);
            ((JSONObject)localObject2).put("os", 1);
            ((JSONObject)localObject2).put("version", och.jdField_a_of_type_JavaLangString);
            if (ogh.a != null) {
              ((JSONObject)localObject2).put("channel_id", ogh.a.mChannelCoverId);
            }
            pha.a(true, (JSONObject)localObject2);
            oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, (String)localObject3, ((JSONObject)localObject2).toString(), false);
            if (localObject1 != null) {
              pha.a(21, str3, (String)localObject3, str2, "", -1);
            }
            if (paramBoolean2)
            {
              ube.a(false);
              localObject1 = (rdd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
              if ((((rdd)localObject1).a() != 1) || (TextUtils.isEmpty(((rdd)localObject1).a()))) {
                break label972;
              }
              localObject1 = ((rdd)localObject1).a();
              localObject2 = (rcx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
              localObject2 = rcx.b(a(), 0);
              localObject3 = new phi();
              localObject1 = ((phi)localObject3).e().f().a((String)localObject1);
              if (i == 1) {
                break label980;
              }
              paramBoolean1 = true;
              localObject1 = ((phi)localObject1).a(paramBoolean1);
              if (pha.g != 0) {
                break label985;
              }
              paramBoolean1 = true;
              ((phi)localObject1).b(paramBoolean1);
              localObject1 = a();
              if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
              {
                if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
                  break label990;
                }
                i = 1;
                ((phi)localObject3).a("ad_page", i);
              }
              oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, ((phi)localObject3).a(), false);
            }
            if (bgnt.h(a())) {
              oon.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if (!bmqa.j()) {
              break label931;
            }
            localObject1 = "recommend_tab_cost";
            uac.a(null, (String)localObject1);
          }
        }
        else
        {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 5) {
            break label949;
          }
          i = 3;
          continue;
        }
        if (pha.a.jdField_a_of_type_Long == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - pha.a.jdField_b_of_type_Long;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - pha.a.jdField_a_of_type_Long;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
        {
          i = 2;
          ((JSONObject)localObject2).put("reddot", i);
          ((JSONObject)localObject2).put("kandian_mode", pha.e());
          ((JSONObject)localObject2).put("kandian_mode_new", och.a());
          localObject1 = (rdd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
          if ((((rdd)localObject1).a() != 1) || (TextUtils.isEmpty(((rdd)localObject1).a()))) {
            break label886;
          }
          localObject1 = ((rdd)localObject1).a();
          localObject3 = (rcx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
          localObject3 = rcx.b(a(), 0);
          ((JSONObject)localObject2).put("skin_id", localObject1);
          localObject1 = a();
          if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
          {
            if ((localObject3 == null) || (!((RefreshData)localObject3).isAD)) {
              break label1003;
            }
            i = 1;
            ((JSONObject)localObject2).put("ad_page", i);
          }
          ((JSONObject)localObject2).put("button_state", 0);
        }
        switch (0)
        {
        default: 
          if (paramBoolean2) {
            break label894;
          }
          oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject1, null, null, ((JSONObject)localObject2).toString(), false);
          continue;
          i = 1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      continue;
      label886:
      String str1 = "0";
      continue;
      label894:
      oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, ((JSONObject)localObject2).toString(), false);
      continue;
      label931:
      str1 = "video_tab_cost";
      continue;
      label939:
      if (!paramBoolean2)
      {
        j = 0;
        continue;
        label949:
        i = 2;
      }
      else
      {
        j = 1;
        continue;
        label960:
        j = 1;
        continue;
        label966:
        j = 1;
        continue;
        label972:
        str1 = "0";
        continue;
        label980:
        paramBoolean1 = false;
        continue;
        label985:
        paramBoolean1 = false;
        continue;
        label990:
        i = 0;
        continue;
        str1 = "";
        continue;
        label1003:
        i = 0;
        continue;
        str1 = "1";
        continue;
        str1 = "2";
        continue;
        str1 = "3";
      }
    }
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Ryj != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_Ryj.a(paramInt);
    }
  }
  
  public static boolean d_()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public void A()
  {
    super.A();
  }
  
  public void F_()
  {
    Object localObject = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a();
    if (localObject != null)
    {
      int i = ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt;
      localObject = i + "";
      if (i > 99) {
        localObject = "99+";
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void G_()
  {
    Drawable localDrawable = a().getDrawable(2130842881);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842801);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842798);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166879, 2131166880, 2131166878);
      localDrawable.setColorFilter(a().getColor(2131165343), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(localDrawable);
    }
    for (;;)
    {
      Q();
      i(true);
      pmk.a().h();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850127);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840268);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850087);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166983, 2131166983, 2131166983);
      localDrawable.setColorFilter(a().getColor(2131166983), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
  }
  
  protected void H_()
  {
    if (VersionUtils.isM()) {
      a().getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    bcnj.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return 0;
    }
    if (paramInt1 != paramInt2)
    {
      b(false, false);
      return 0;
    }
    b(false, true);
    return 0;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560200, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer = new ReadinjoyViewLayer(a().getBaseContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout = new DuplicateEventLayout(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
  }
  
  public ReadInJoyBaseFragment a()
  {
    if (this.jdField_a_of_type_Ogh != null)
    {
      localObject = this.jdField_a_of_type_Ogh.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      bctj.a(BaseApplication.getContext()).a(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long, 0L, null, "", true);
      ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoyTabFrame.11(this, (ReadInJoyBaseFragment)localObject), 1000L);
      return null;
    }
    return localObject;
  }
  
  public RIJRedPacketProgressView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  }
  
  public String a()
  {
    return anni.a(2131693162);
  }
  
  public void a()
  {
    super.a();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (pha.j() == 0)
    {
      i = 1;
      localObject = a(2131371394);
      if (i == 0) {
        break label117;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      F_();
      ((rdd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      if (!rjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label123;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      E();
      oon.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      return;
      i = 0;
      break;
      label117:
      i = 8;
      break label50;
      label123:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int |= paramInt;
    QLog.d("ReadInJoyTabFrame", 2, "set operation flag : " + paramInt);
    if (paramInt != 1) {
      ube.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showErrorRedPacketDialog");
    new qzu((ViewGroup)a().getWindow().getDecorView(), BaseApplicationImpl.getContext().getString(2131717049), BaseApplicationImpl.getContext().getString(2131717247), paramInt1, paramInt2, null).a(false);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (a() != null) {
      a().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (paramIntent.getBooleanExtra("key_ugc_account_create", false)) {
        ab();
      }
    }
    else {
      return;
    }
    if (paramIntent.getBooleanExtra("key_ugc_account_edit", false))
    {
      ac();
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "ugc account create or edit profile canceled !");
  }
  
  protected void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    int i = 6;
    if ((paramInt == 9) || (paramInt == 6)) {
      i = 5;
    }
    for (;;)
    {
      ube.a(i, paramBoolean, paramLong, pha.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
      if (paramInt != 13) {
        i = 2;
      }
    }
  }
  
  protected void a(int paramInt, KandianMergeManager paramKandianMergeManager)
  {
    if ((paramKandianMergeManager.b()) || (paramKandianMergeManager.f() > 0))
    {
      i = 0;
      if (paramInt == 6)
      {
        paramInt = a().getIntent().getIntExtra("jump_activity_launch_channel_id", 0);
        paramKandianMergeManager = new JSONObject();
      }
    }
    try
    {
      paramKandianMergeManager.put("source", "304");
      paramKandianMergeManager.put("style", 0);
      oat.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", paramKandianMergeManager.toString(), false);
      i = paramInt;
    }
    catch (Exception paramKandianMergeManager)
    {
      for (;;)
      {
        QLog.d("ReadInJoyTabFrame", 1, paramKandianMergeManager.getMessage());
        i = paramInt;
      }
    }
    if ((i == 0) || (i == pwl.a())) {
      d(false);
    }
    QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + i);
  }
  
  public void a(long paramLong, String paramString1, @Nullable qzh paramqzh, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showOpenRedPacketDialog");
    ViewGroup localViewGroup = (ViewGroup)a().getWindow().getDecorView();
    if (paramqzh == null) {}
    for (paramString1 = new qzs(localViewGroup, paramLong, paramString2, paramString1, paramInt1, paramInt2, paramInt3, null);; paramString1 = new qzw(localViewGroup, paramLong, paramString1, paramqzh, paramString2, paramInt1, paramInt2, paramInt3, null))
    {
      paramString1.a(false);
      return;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = a().getDisplayMetrics();
    float f2 = anll.a() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramConfiguration.density / f1;
    QLog.d("ReadInJoyTabFrame", 1, "onConfigurationChanged densityNoScale : " + f1 + ", screenWidth : " + paramConfiguration.widthPixels);
    Utils.init(f1, paramConfiguration.widthPixels);
  }
  
  public void a(Drawable paramDrawable)
  {
    Object localObject = Aladdin.getConfig(313);
    String str1;
    String str2;
    if (localObject != null)
    {
      this.jdField_c_of_type_Int = ((AladdinConfig)localObject).getIntegerFromString("SearchBox_TopBGType", 0);
      str1 = "#" + ((AladdinConfig)localObject).getString("SearchBox_BGColor", "f5f6fa");
      str2 = "#" + ((AladdinConfig)localObject).getString("SearchBox_BorderColor", "faf6fa");
      localObject = "#" + ((AladdinConfig)localObject).getString("SearchBox_TextColor", "737373");
      if (this.jdField_c_of_type_Int != 1) {
        break label271;
      }
      a(this.jdField_d_of_type_AndroidViewView, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidViewView, true);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166983, 2131166983, 2131166983);
      paramDrawable.setColorFilter(a().getColor(2131166983), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(paramDrawable);
    }
    for (;;)
    {
      paramDrawable = (GradientDrawable)this.h.getBackground();
      paramDrawable.setStroke(bgtn.b(1.0F), Color.parseColor(str2));
      paramDrawable.setColor(Color.parseColor(str1));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject));
      return;
      label271:
      this.jdField_a_of_type_AndroidWidgetImageView.clearColorFilter();
      this.jdField_b_of_type_AndroidWidgetImageView.clearColorFilter();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.a(paramView);
  }
  
  protected void a(KandianMergeManager paramKandianMergeManager)
  {
    if ((paramKandianMergeManager.i()) && (System.currentTimeMillis() - this.jdField_f_of_type_Long > 180000L))
    {
      rvd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
      this.jdField_f_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ar_();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    ar_();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showErrorRedPacketDialog, wording = " + paramString1);
    new qzu((ViewGroup)a().getWindow().getDecorView(), paramString1, paramString2, paramInt1, paramInt2, null).a(false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showRedPacketDialog");
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((rcx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
  }
  
  public void a(tkf paramtkf)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtkf);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramtkf != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtkf);
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      P();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("ReadInJoyTabFrame", 1, "haveWallet = " + paramBoolean1 + " hasOpen = " + paramBoolean2);
  }
  
  public boolean a()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      seu localseu = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localseu != null) && (localseu.a() != null))
      {
        if (localseu.a().a())
        {
          localseu.a().j();
          localseu.a().c();
          return true;
        }
        if (oqm.a(localseu.a())) {
          localseu.a().c();
        }
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).f())) {
      return true;
    }
    return super.a();
  }
  
  public void ar_()
  {
    SparseIntArray localSparseIntArray = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a();
    int j = 0;
    if (j < localSparseIntArray.size())
    {
      int k = localSparseIntArray.keyAt(j);
      int m = localSparseIntArray.valueAt(j);
      int i;
      switch (k)
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        localMessage.arg1 = m;
        localMessage.arg2 = i;
        localMessage.obj = Integer.valueOf(k);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        j += 1;
        break;
        i = 2131376065;
        continue;
        i = 2131376089;
        continue;
        i = 2131376074;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.19(this));
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 13)
    {
      pha.c(6);
      Object localObject = a().getIntent().getExtras();
      if (smj.a((Bundle)localObject))
      {
        localObject = smj.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((tkf)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((tkf)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.32(this), 1000L);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ar_();
  }
  
  public void b(tkf paramtkf)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtkf);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramtkf != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtkf);
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      L();
      if (this.jdField_a_of_type_Ogh != null) {
        this.jdField_a_of_type_Ogh.e();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "init ChannelEntry failed.");
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 9216;
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) && (paramBoolean))
    {
      if (ImmersiveUtils.a())
      {
        ImmersiveUtils.a(a().getWindow(), true);
        if ((VersionUtils.isM()) && (bgjq.b()))
        {
          if (paramBoolean) {
            a().getWindow().getDecorView().setSystemUiVisibility(i);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
        }
      }
      for (;;)
      {
        if (this.jdField_c_of_type_Int == 1) {
          a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
        }
        return;
        i = 1280;
        break;
        if ((VersionUtils.isM()) && (!bgjq.b()) && (!bgjq.d()))
        {
          a().getWindow().getDecorView().setSystemUiVisibility(9216);
          this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-16777216);
        }
      }
    }
    if ((ImmersiveUtils.a()) && ((!VersionUtils.isM()) || (!bgjq.b()))) {
      ImmersiveUtils.a(a().getWindow(), false);
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ogh != null)
    {
      int j = 0;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (pwl.a() != -1) {
          i = pwl.a();
        }
      }
      this.jdField_a_of_type_Ogh.c(i);
    }
  }
  
  public void e()
  {
    super.e();
    VideoReport.addToDetectionWhitelist(a());
    pmk.a().a();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        acsb.a().a((Context)localObject, new acsc());
      }
      F();
      T();
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((rdd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      pmk.a().a(this.jdField_a_of_type_Pmn);
      oon.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      ttd.a();
      RIJRedPacketManager.a().e();
      this.jdField_a_of_type_Raj.a(this);
      return;
      if ((localObject instanceof FragmentActivity)) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentActivity)localObject).getSupportFragmentManager();
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (a() != null) {
      a().a(this);
    }
    Object localObject = a().findViewById(16908305);
    if (localObject != null) {
      SlideActiveAnimController.a((View)localObject);
    }
    jdField_a_of_type_Boolean = true;
    ApngImage.playByTag(8);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.e();
      if (!paramBoolean) {
        break label297;
      }
      c(1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = pmh.a().a();
        if (localObject != null) {
          ((pxh)localObject).a(false);
        }
        pha.g();
      }
      this.jdField_a_of_type_Tdi.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int i = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Ogh != null) {
          this.jdField_a_of_type_Ogh.c(i);
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      if (this.jdField_a_of_type_Ogh != null) {
        this.jdField_a_of_type_Ogh.b();
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        I();
        this.jdField_c_of_type_Boolean = true;
      }
      if (jdField_b_of_type_Boolean) {
        pha.b(true);
      }
      pmh.a().q();
      if (((Boolean)bmqa.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
      {
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (!((Intent)localObject).getBooleanExtra("is_watch_word_share", false))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.a(9);
        }
        bmqa.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
      }
      H();
      Z();
      return;
      label297:
      if (this.jdField_a_of_type_Ryj != null) {
        ryj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      }
    }
  }
  
  public void f()
  {
    super.f();
  }
  
  public void f(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
    i(paramBoolean);
    int i = a().getIntent().getIntExtra("launch_from", 5);
    a(paramBoolean, i);
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = pha.a.jdField_a_of_type_Long;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    h(paramBoolean);
    if (paramBoolean)
    {
      txa.a();
      a(i, localKandianMergeManager);
      qak.a();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_e_of_type_Long = 0L;
      this.jdField_b_of_type_Int = 0;
      ube.b();
      b(i);
      bmqa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      pmr.c();
      z();
      pha.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      y();
      sgc.a().a(a());
      x();
      RecommendFeedsDiandianEntranceManager.a().a();
      w();
      a(localKandianMergeManager);
      a(i, l1 - l2, true);
      ThreadManager.getFileThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
      oqr.a().b(0);
      v();
      puu.a.a();
      u();
      t();
      m();
    }
    for (;;)
    {
      g(paramBoolean);
      H();
      QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + i);
      Z();
      qps.a.a().a(false, "MATCH_ALL_UIN");
      return;
      txa.b();
      VideoReport.traverseExposure();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      RecommendFeedsDiandianEntranceManager.a().a(this.jdField_a_of_type_Long);
      s();
      r();
      localKandianMergeManager.p();
      q();
      rvd.a();
      rvd.a().b();
      sgc.a().b(a());
      sgc.a().a(false, "readInjoy doOnPause");
      a(i, this.jdField_b_of_type_Long, false);
      a().getIntent().removeExtra("launch_from");
      p();
      pha.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      pha.c();
      pgk.a();
      H_();
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      oqr.a().b(4);
      oqr.a().c(false);
      localKandianMergeManager.q();
      n();
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.b() != this) {
      S();
    }
    jdField_a_of_type_Boolean = false;
    P();
    ApngImage.pauseByTag(8);
    pmh.n();
    this.jdField_a_of_type_Tdi.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_Ogh != null) {
      this.jdField_a_of_type_Ogh.c();
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ogh != null) {
      this.jdField_a_of_type_Ogh.a(paramBoolean);
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    long l2 = this.jdField_e_of_type_Long;
    long l3 = this.jdField_d_of_type_Long;
    if (this.jdField_c_of_type_Long > 0L) {}
    for (long l1 = this.jdField_c_of_type_Long;; l1 = this.jdField_b_of_type_Long)
    {
      this.jdField_e_of_type_Long = (l3 - l1 + l2);
      sgc.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    ((ooi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(307)).a(a());
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      if (paramBoolean)
      {
        ogh.a(localReadInJoyBaseFragment.a(), 0);
        localReadInJoyBaseFragment.a(false, a(), null);
      }
    }
    else {
      return;
    }
    localReadInJoyBaseFragment.g();
  }
  
  public void i()
  {
    QLog.d("ReadInJoyTabFrame", 1, "dismissRedPacketDialog");
  }
  
  protected void i(boolean paramBoolean)
  {
    c(paramBoolean);
    bcnj.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  public void j()
  {
    QLog.d("ReadInJoyTabFrame", 1, "showOtherPopupView");
  }
  
  public void k()
  {
    super.k();
    ((rdd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    pmk.a().b(this.jdField_a_of_type_Pmn);
    this.jdField_a_of_type_Tdi.e();
    if (this.jdField_a_of_type_Ogh != null)
    {
      this.jdField_a_of_type_Ogh.d();
      this.jdField_a_of_type_Ogh = null;
    }
    if (this.jdField_a_of_type_Ryj != null) {
      this.jdField_a_of_type_Ryj.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    jdField_b_of_type_Boolean = false;
    oyp.a().a();
    bmqj.a().a();
    KandianVideoUploadService.a(null);
    RecommendFeedsDiandianEntranceManager.a().b(this);
    rat.a().c();
    this.jdField_a_of_type_Raj.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.i();
    }
  }
  
  public void l()
  {
    b(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    if (bmqa.i()) {
      oat.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", och.a(null), false);
    }
  }
  
  protected void m()
  {
    if (!d()) {
      D();
    }
  }
  
  protected void n()
  {
    tek.a().b();
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    O();
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoFailed, uin = ", paramString1, Character.valueOf('\n'), "errMsg = ", paramString2 });
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoSucceed uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo });
  }
  
  protected void p()
  {
    Object localObject = (pmm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    if ((localObject != null) && (((pmm)localObject).a() != null))
    {
      localObject = ((pmm)localObject).a().a();
      if (localObject != null) {
        ((ReadInJoyUserInfoModule)localObject).b();
      }
    }
  }
  
  protected void q()
  {
    long l = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
    if (l > 0L) {
      ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.17(this, l));
    }
  }
  
  protected void r()
  {
    int i = 0;
    while (i < 1)
    {
      ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
      if (localReadInJoyBaseFragment != null) {
        localReadInJoyBaseFragment.i();
      }
      i += 1;
    }
  }
  
  protected void s()
  {
    if (this.jdField_e_of_type_Long != 0L)
    {
      this.jdField_e_of_type_Long += this.jdField_a_of_type_Long - this.jdField_c_of_type_Long;
      return;
    }
    this.jdField_e_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
  }
  
  protected void t()
  {
    if ((bdch.a()) && (pha.g())) {
      pha.d("0X800AF05");
    }
  }
  
  protected void u()
  {
    if ((a() instanceof ReadInJoyRecommendFeedsFragment))
    {
      pxt localpxt = pmh.a().a();
      if (localpxt != null) {
        localpxt.a();
      }
    }
    else
    {
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "requestColumn0x6cf failed!");
  }
  
  protected void v()
  {
    if (pha.z()) {
      T();
    }
  }
  
  protected void w()
  {
    if (svw.a() != 8) {
      svw.a(5);
    }
    svx.a().a(false);
  }
  
  protected void x()
  {
    boolean bool = false;
    int j = 1;
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    int i;
    if ((a() != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
    {
      long l2 = bmqa.g(pha.a());
      if ((l1 >= l2) && (this.jdField_a_of_type_Long != 0L))
      {
        this.jdField_d_of_type_Boolean = true;
        pmk.a().l();
        QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l1, ", timeLimit = ", Long.valueOf(l2) });
        i = 1;
        if (bdch.a())
        {
          bool = true;
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        d(bool);
      }
      return;
      continue;
      i = 0;
      break;
      i = 0;
    }
  }
  
  protected void y()
  {
    if (bmqa.i())
    {
      pha.d(6);
      return;
    }
    pha.d(3);
  }
  
  protected void z()
  {
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.18(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view;

import acim;
import acin;
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
import android.support.v4.app.Fragment;
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
import anun;
import anvx;
import bdfk;
import bdvn;
import bhdj;
import bhhr;
import bleh;
import blek;
import bmhv;
import bmie;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
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
import olh;
import omx;
import oqy;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import osg;
import oxf;
import oyi;
import oyj;
import pac;
import pjg;
import pjr;
import pkh;
import pno;
import ppo;
import pqb;
import pqc;
import pqd;
import pqf;
import pqg;
import pqt;
import pqu;
import prh;
import pro;
import prp;
import prs;
import pti;
import pvb;
import pvd;
import pvj;
import pvm;
import pvp;
import pvq;
import pvu;
import pxu;
import qdk;
import qez;
import qft;
import qgs;
import qgx;
import qhd;
import qhl;
import qku;
import rao;
import rap;
import rjm;
import rjz;
import rmu;
import rna;
import rpn;
import rth;
import sfa;
import sfq;
import sij;
import six;
import spg;
import sqd;
import sqp;
import sse;
import sut;
import suu;
import syf;
import szq;
import tcs;
import tcy;
import tcz;
import tda;
import tdb;
import tdc;
import tdd;
import tde;
import tdf;
import tdg;
import tdh;
import tdi;
import tdj;
import tdk;
import tdl;
import tdm;
import tdn;
import tdo;
import tdp;
import tdq;
import tdr;
import tdx;
import tel;
import tem;
import tli;
import tmk;
import tro;
import tso;
import tsp;
import ucy;
import uet;
import uhx;
import uic;
import ujj;
import ukq;
import ukv;
import urp;
import uuq;
import uvs;

public class ReadinjoyTabFrame
  extends anun
  implements ViewTreeObserver.OnGlobalLayoutListener, pvb, pvd, pxu, qhl, tcs, tdx
{
  public static int a;
  public static boolean a;
  private static boolean jdField_b_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new tda(this);
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private SparseArray<Bundle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new tdk(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
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
  private oqy jdField_a_of_type_Oqy;
  private pvq jdField_a_of_type_Pvq = new tdb(this);
  private sij jdField_a_of_type_Sij;
  private sse jdField_a_of_type_Sse;
  protected tli a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[1];
  public int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
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
    this.jdField_a_of_type_JavaLangRunnable = new ReadinjoyTabFrame.15(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment = paramFrameFragment;
  }
  
  public static void A()
  {
    a("0X800AC6D", 3);
  }
  
  private void F()
  {
    c();
    O();
    RecommendFeedsDiandianEntranceManager.a().c();
    if (this.jdField_a_of_type_Sij != null) {
      this.jdField_a_of_type_Sij.d();
    }
  }
  
  private void G()
  {
    a(2131379248).setBackgroundDrawable(null);
    this.jdField_a_of_type_Tli = new tli(a(), (ViewGroup)a(2131379248));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131376160));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131376177));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376158));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131378194));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131376731));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131364651));
    this.jdField_b_of_type_AndroidViewView = a(2131379020);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131377844));
    S();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379099));
    this.jdField_d_of_type_AndroidViewView = a(2131378030);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376231));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131376230));
    this.h = a(2131377205);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380147));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380146));
    label328:
    label336:
    Object localObject;
    if (pqt.d())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131167363));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131167296));
      }
      if (!rth.m()) {
        break label655;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (pro.a() != 0) {
        break label667;
      }
      i = 1;
      localObject = a(2131371655);
      if (i == 0) {
        break label672;
      }
    }
    label655:
    label667:
    label672:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.jdField_g_of_type_AndroidViewView = a(2131376205);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131371607));
      i = AIOUtils.dp2px(3.0F, a());
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new tcz(this));
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131372122)).b(53).a();
      VideoReport.setElementId(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "head_sculpture_button");
      VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, ReportPolicy.REPORT_POLICY_CLICK);
      VideoReport.setElementParams(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, new pti().a("14").c("click_head_sculpture").a().a());
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new tdj(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new tdm(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new tdn(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      d();
      E_();
      K();
      J();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131365105);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      N();
      if ("2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnLongClickListener(new tdo(this));
      }
      c();
      return;
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label328;
      i = 0;
      break label336;
    }
  }
  
  private void H()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {}
    for (;;)
    {
      return;
      boolean bool = rth.m();
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
  
  private void I()
  {
    SelectPositionModule localSelectPositionModule = pvj.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void J()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Tli);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Oqy = new oqy(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Oqy.a(this.jdField_a_of_type_Tli);
    this.jdField_a_of_type_Oqy.a(new tdp(this));
  }
  
  private void K()
  {
    L();
  }
  
  private void L()
  {
    if (bmhv.n()) {}
    while (!bmhv.m()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new tdq(this));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new tdr(this));
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
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, "entrance_button");
    VideoReport.setElementParams(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, new pti().a("14").c("click_entrance").a(Integer.valueOf(0)).a().a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private void N()
  {
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131373885);
    M();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297321);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new tcy(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    c();
    switch (bmhv.f())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_Sij = new sij(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localBaseActivity);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849422));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849386));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130842831));
    }
  }
  
  private void O()
  {
    int i = RecommendFeedsDiandianEntranceManager.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null)
    {
      Drawable localDrawable = a().getDrawable(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
    }
  }
  
  private void P()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = bhhr.d((Context)localObject1);
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
        if ((bhhr.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (bmhv.f() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          bhhr.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = DisplayUtil.dip2px((Context)localObject1, 12.0F);
          int j = DisplayUtil.dip2px((Context)localObject1, 9.0F);
          sse localsse = new sse((Context)localObject1);
          this.jdField_a_of_type_Sse = localsse;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localsse.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131717983));
          localsse.setAnimationStyle(2131755849);
          localsse.b(-16777216);
          localsse.setSoftInputMode(1);
          localsse.setInputMethodMode(2);
          localsse.a(localsse.b() / 2 - DisplayUtil.dip2px((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = ScreenUtil.SCREEN_WIDTH;
          j = DisplayUtil.dip2px((Context)localObject1, 15.0F);
          int k = localsse.b();
          int m = localObject2[1];
          int n = localsse.a();
          int i1 = localsse.c();
          int i2 = DisplayUtil.dip2px((Context)localObject1, 5.0F);
          localsse.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.12(this), 3000L);
          olh.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new suu(null, null, null, null).a().a(), false);
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
  
  private void Q()
  {
    if (this.jdField_a_of_type_Sse != null) {
      this.jdField_a_of_type_Sse.dismiss();
    }
  }
  
  private void R()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (bool)
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131376213)).inflate();
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
            this.jdField_f_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131560291, null);
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
    for (;;)
    {
      k(bool);
      return;
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_f_of_type_AndroidViewView != null) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void S()
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
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anvx.a(2131693417);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376217;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anvx.a(2131712443);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376227;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anvx.a(2131712371);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376242;
      }
    }
  }
  
  private void T()
  {
    int i = bmhv.f();
    if (RecommendFeedsDiandianEntranceManager.a(i))
    {
      QLog.d("ReadInJoyTabFrame", 1, "request 0xdcb");
      RecommendFeedsDiandianEntranceManager.a().b();
    }
    if (RecommendFeedsDiandianEntranceManager.b(i))
    {
      QLog.d("ReadInJoyTabFrame", 1, "request 0x6cf coloumn");
      s();
    }
  }
  
  private void U()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131297321);
    }
  }
  
  private void V()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable.a(this);
    ThreadManager.executeOnSubThread(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable);
  }
  
  private void W()
  {
    if (!"2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new blek();
    ((blek)localObject).jdField_a_of_type_Int = 0;
    ((blek)localObject).jdField_a_of_type_JavaLangString = anvx.a(2131712357);
    ((blek)localObject).jdField_b_of_type_Int = 2130842584;
    localArrayList.add(localObject);
    localObject = new blek();
    ((blek)localObject).jdField_a_of_type_Int = 1;
    ((blek)localObject).jdField_a_of_type_JavaLangString = anvx.a(2131712550);
    ((blek)localObject).jdField_b_of_type_Int = 2130842584;
    localArrayList.add(localObject);
    localObject = new blek();
    ((blek)localObject).jdField_a_of_type_Int = 2;
    ((blek)localObject).jdField_a_of_type_JavaLangString = anvx.a(2131712488);
    ((blek)localObject).jdField_a_of_type_Float = 14.0F;
    ((blek)localObject).jdField_b_of_type_Int = 2130842584;
    localArrayList.add(localObject);
    localObject = new blek();
    ((blek)localObject).jdField_a_of_type_Int = 3;
    ((blek)localObject).jdField_a_of_type_JavaLangString = anvx.a(2131712413);
    ((blek)localObject).jdField_b_of_type_Int = 2130842584;
    localArrayList.add(localObject);
    blek localblek = new blek();
    localblek.jdField_a_of_type_Int = 4;
    if (!pkh.c())
    {
      localObject = "打开预加载UI";
      localblek.jdField_a_of_type_JavaLangString = ((String)localObject);
      localblek.jdField_b_of_type_Int = 2130842584;
      localArrayList.add(localblek);
      localblek = new blek();
      localblek.jdField_a_of_type_Int = 5;
      if (((Boolean)bmhv.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label379;
      }
      localObject = "打开动态频道feeds";
      label263:
      localblek.jdField_a_of_type_JavaLangString = ((String)localObject);
      localblek.jdField_a_of_type_Float = 12.0F;
      localblek.jdField_b_of_type_Int = 2130842584;
      localArrayList.add(localblek);
      localblek = new blek();
      localblek.jdField_a_of_type_Int = 6;
      if (bmhv.C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label386;
      }
    }
    label386:
    for (localObject = anvx.a(2131712312);; localObject = "切换到Web")
    {
      localblek.jdField_a_of_type_JavaLangString = ((String)localObject);
      localblek.jdField_a_of_type_Float = 12.0F;
      localblek.jdField_b_of_type_Int = 2130842584;
      localArrayList.add(localblek);
      bleh.a(a(), localArrayList, new tdg(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
      return;
      localObject = "取消预加载UI";
      break;
      label379:
      localObject = "取消动态频道feeds";
      break label263;
    }
  }
  
  private void X()
  {
    int i = 8;
    int k = 0;
    boolean bool = bdvn.a();
    if (bool == this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = bool;
    int j;
    Object localObject;
    if (bdvn.a())
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
          break label200;
        }
        bool = true;
        label102:
        ((ReadInJoyChannelViewPager)localObject).setSlideLeftAndRight(bool);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        localObject = this.jdField_d_of_type_AndroidWidgetImageView;
        if (!prh.a()) {
          break label206;
        }
      }
    }
    label200:
    label206:
    for (i = k;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((a() instanceof ReadInJoyRecommendFeedsFragment)) {
        c();
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
  
  private void Y()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
    osg.b(a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = pqf.a();
        localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
        if (!bool) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", pqu.a());
        localJSONObject.put("kandian_mode_new", omx.a());
        localObject = (rna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        if ((((rna)localObject).a() != 1) || (TextUtils.isEmpty(((rna)localObject).a()))) {
          continue;
        }
        localObject = ((rna)localObject).a();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
        localObject = new HashMap();
        ((Map)localObject).put("uin", pkh.a());
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
      uuq.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      localObject = "0";
    }
  }
  
  private void Z()
  {
    qgs localqgs = pvj.a().a();
    if (localqgs != null) {
      localqgs.a(pkh.a(), new tdl(this));
    }
  }
  
  private int a(@NotNull Context paramContext, List<blek> paramList)
  {
    int i = AIOUtils.dp2px(125.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 15.0F);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      blek localblek = (blek)paramList.next();
      int j = (int)Math.ceil(localTextView.getPaint().measureText(localblek.jdField_a_of_type_JavaLangString)) + AIOUtils.dp2px(71.0F, paramContext.getResources());
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
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo == null) {
      return 1;
    }
    if (paramRedTypeInfo.red_type.get() == 5) {
      return 3;
    }
    return 2;
  }
  
  private int a(boolean paramBoolean)
  {
    int j = a().getDimensionPixelOffset(2131297321);
    if (paramBoolean) {}
    for (int i = ViewUtils.dpToPx(5.0F); this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null; i = 0)
    {
      Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(MainFragment.class.getName());
      if (!(localFragment instanceof MainFragment)) {
        break;
      }
      int k = pjg.a.a((MainFragment)localFragment);
      if (k == 0) {
        break;
      }
      return k;
    }
    return j + i;
  }
  
  private long a(int paramInt)
  {
    long l = 0L;
    if (paramInt != 1)
    {
      if (prp.jdField_a_of_type_Rpn.jdField_a_of_type_Long == 0L) {
        l = NetConnInfoCenter.getServerTime() - prp.jdField_a_of_type_Rpn.jdField_b_of_type_Long;
      }
    }
    else {
      return l;
    }
    return NetConnInfoCenter.getServerTime() - prp.jdField_a_of_type_Rpn.jdField_a_of_type_Long;
  }
  
  private blek a(int paramInt, String paramString, Drawable paramDrawable)
  {
    blek localblek = new blek();
    localblek.jdField_a_of_type_Int = paramInt;
    localblek.jdField_a_of_type_JavaLangString = paramString;
    localblek.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return localblek;
  }
  
  private VideoInfo a()
  {
    boolean bool1 = false;
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    int i = (int)(DeviceInfoUtil.getPortraitWidth() * 0.4D);
    int j = (int)(DeviceInfoUtil.getPortraitHeight() * 0.4D);
    Object localObject2 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject2);
    int k = localObject2[0];
    int m = this.jdField_a_of_type_AndroidViewView.getWidth();
    int n = localObject2[1];
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    ((Bundle)localObject1).putInt("item_x", k + m - i);
    ((Bundle)localObject1).putInt("item_y", n + i1 - j);
    ((Bundle)localObject1).putInt("item_width", i);
    ((Bundle)localObject1).putInt("item_height", j);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null)
    {
      ((Bundle)localObject1).putInt("item_image_width", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      ((Bundle)localObject1).putInt("item_image_height", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.b());
    }
    if (this.jdField_a_of_type_Sij != null)
    {
      boolean bool2 = this.jdField_a_of_type_Sij.a((Bundle)localObject1);
      localObject2 = (VideoInfo)((Bundle)localObject1).getParcelable("VIDEO_OBJ");
      if (bmhv.f() == 1)
      {
        localObject1 = sfa.a((VideoInfo)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof ArticleInfo)))
        {
          ppo.a(a(), null, (ArticleInfo)localObject1, false, 0, 0, false, 1004);
          return localObject2;
        }
        osg.a(a(), 56, a().getString(2131718823), 3, 1004);
        return localObject2;
      }
      BaseActivity localBaseActivity = a();
      if (!bool2) {
        bool1 = true;
      }
      six.a(localBaseActivity, (Bundle)localObject1, bool1, 11);
      c(3);
      return localObject2;
    }
    QLog.d("ReadInJoyTabFrame", 1, "videoManager is null, can't jump to videoPlayActivity!");
    return null;
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
      localObject = bhdj.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((QQCustomDialog)localObject).setPositiveButton("确认", new tdc(this, paramPositionData));
      ((QQCustomDialog)localObject).setNegativeButton("取消", new tdd(this));
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(true);
      ((QQCustomDialog)localObject).show();
      return;
    }
    paramPositionData = szq.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new tde(this));
    paramPositionData.setNegativeButton("取消", new tdf(this));
    paramPositionData.show();
  }
  
  private void a(int paramInt, List<blek> paramList)
  {
    Drawable localDrawable;
    if (rth.g())
    {
      localDrawable = a().getDrawable(2130842890).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(0, rth.a(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (rth.a(paramInt))
    {
      localDrawable = a().getDrawable(2130842891).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(1, BaseApplicationImpl.getApplication().getString(2131717716), localDrawable));
    }
    if (rth.h())
    {
      localDrawable = a().getDrawable(2130843095).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(2, rth.b(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (rth.i())
    {
      localDrawable = a().getDrawable(2130843099).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(3, rth.c(BaseApplicationImpl.getContext()), localDrawable));
    }
  }
  
  private void a(long paramLong)
  {
    pno.b().postDelayed(new ReadinjoyTabFrame.33(this), paramLong);
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    a(bmhv.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bleh.a(paramActivity, localArrayList, new tdh(this, paramActivity), new tdi(this), a(paramActivity, localArrayList), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131298811) - paramActivity.getResources().getDimensionPixelSize(2131298807) + AIOUtils.dp2px(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131298139));
    y();
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.21(this, paramVideoInfo, (rna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)), 16, null, true);
  }
  
  private void a(String paramString)
  {
    bmhv.a("KEY_ENTRANCE_SCHEMA", paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    int j = 1;
    pqg localpqg1 = new pqg();
    pqg localpqg2;
    if (rth.i())
    {
      i = 1;
      localpqg2 = localpqg1.a("ugc_video_flag", Integer.valueOf(i));
      if (!rth.h()) {
        break label86;
      }
    }
    label86:
    for (int i = j;; i = 0)
    {
      localpqg2.a("ugc_column_flag", Integer.valueOf(i));
      if (paramInt != 0) {
        localpqg1.a("from", Integer.valueOf(paramInt));
      }
      olh.a(paramString, localpqg1.a());
      return;
      i = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ReadinjoyTabFrame.13 local13 = new ReadinjoyTabFrame.13(this, paramBoolean, paramInt);
    if (pqt.e())
    {
      ThreadManager.executeOnSubThread(local13);
      return;
    }
    local13.run();
  }
  
  private void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
    {
      i = 2;
      paramJSONObject.put("reddot", i);
      paramJSONObject.put("kandian_mode", pqu.a());
      paramJSONObject.put("kandian_mode_new", omx.a());
      localObject1 = (rna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if ((((rna)localObject1).a() != 1) || (TextUtils.isEmpty(((rna)localObject1).a()))) {
        break label220;
      }
      localObject1 = ((rna)localObject1).a();
      label86:
      Object localObject2 = (rmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
      localObject2 = rmu.b(a(), 0);
      paramJSONObject.put("skin_id", localObject1);
      localObject1 = a();
      if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
      {
        if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
          break label228;
        }
        i = 1;
        label155:
        paramJSONObject.put("ad_page", i);
      }
      paramJSONObject.put("button_state", 0);
      if (!paramBoolean) {
        break label233;
      }
    }
    label220:
    label228:
    label233:
    for (Object localObject1 = "0X80081C5";; localObject1 = "0X8007DB0")
    {
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 1, "1", null, null, paramJSONObject.toString(), false);
      return;
      i = 1;
      break;
      localObject1 = "0";
      break label86;
      i = 0;
      break label155;
    }
  }
  
  private void a(boolean paramBoolean, JSONObject paramJSONObject, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt)
  {
    String str1 = prp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str2 = prp.jdField_a_of_type_Rpn.jdField_a_of_type_JavaLangString;
    String str3 = pqc.a(prp.jdField_a_of_type_Rpn.c);
    paramJSONObject.put("costtime_type", b(paramInt));
    paramJSONObject.put("tab_status", paramInt);
    paramJSONObject.put("strategy_id", str1);
    paramJSONObject.put("costtime", a(paramInt));
    paramJSONObject.put("algorithm_id", str2);
    if (paramInt == 3) {
      paramJSONObject.put("reddot_num", paramRedTypeInfo.red_content.get());
    }
    if (paramBoolean)
    {
      paramInt = 1;
      paramJSONObject.put("current_page", paramInt);
      if (!NetworkUtil.isWifiConnected(a())) {
        break label289;
      }
      paramInt = 2;
      label137:
      paramJSONObject.put("network_type", paramInt);
      paramJSONObject.put("kandian_mode_new", omx.a());
      if (pqc.jdField_a_of_type_Int != 0) {
        break label295;
      }
    }
    label289:
    label295:
    for (paramInt = 0;; paramInt = 1)
    {
      paramJSONObject.put("button_state", paramInt);
      paramJSONObject.put("os", 1);
      paramJSONObject.put("version", omx.jdField_a_of_type_JavaLangString);
      if (oqy.a != null) {
        paramJSONObject.put("channel_id", oqy.a.mChannelCoverId);
      }
      pqc.a(true, paramJSONObject);
      pqd.a.a(paramJSONObject);
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, str1, paramJSONObject.toString(), false);
      if (paramRedTypeInfo != null) {
        pqb.a(21, str3, str1, str2, "", -1);
      }
      return;
      paramInt = 0;
      break;
      paramInt = 1;
      break label137;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = pqf.a();
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
        int i = a(localRedTypeInfo);
        a(paramBoolean2, (JSONObject)localObject, localRedTypeInfo, i);
        b(paramBoolean2, i);
        uic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bmhv.n()) {
          break label93;
        }
        localObject = "recommend_tab_cost";
        uuq.a(null, (String)localObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      a(paramBoolean2, (JSONObject)localObject);
      continue;
      label93:
      String str = "video_tab_cost";
    }
  }
  
  private void aa()
  {
    bmhv.h();
    pno.b().post(new ReadinjoyTabFrame.34(this));
    a(2500L);
  }
  
  private long b(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramInt != 1)
    {
      l1 = l2;
      if (prp.jdField_a_of_type_Rpn.jdField_a_of_type_Long == 0L) {
        l1 = 1L;
      }
    }
    return l1;
  }
  
  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    oxf.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772239, 2130772041);
  }
  
  private void b(View paramView)
  {
    j = tsp.jdField_b_of_type_Int;
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
        tso localtso;
        QLog.d("ReadInJoyTabFrame", 1, "parseInt error!");
        int i = j;
        continue;
        if ((localtso instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
        {
          String str = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localtso).c;
          QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo recommendfeeds jumpSchema " + str);
          paramView = str;
          if (TextUtils.isEmpty(str)) {
            paramView = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localtso).jdField_a_of_type_Int);
          }
          if (!TextUtils.isEmpty(paramView))
          {
            pkh.a(a(), paramView);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
            a(paramView);
          }
          RecommendFeedsDiandianEntranceManager.a().a();
        }
        else
        {
          if ((localtso instanceof tsp))
          {
            paramView = (tsp)localtso;
            QLog.d("ReadInJoyTabFrame", 1, "column button jump to red source! " + paramView);
            if (paramView.a == null) {
              pkh.a(a(), bmhv.b());
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
              RecommendFeedsDiandianEntranceManager.a().a(paramView, i, 0, a());
              break;
              six.a(a(), paramView.a);
            }
          }
          QLog.d("ReadInJoyTabFrame", 1, "lauch videofeeds");
          a(a());
          continue;
          j = RecommendFeedsDiandianEntranceManager.a().b();
          QLog.d("ReadInJoyTabFrame", 1, "diandian button jump to default url! feedType " + j);
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.jdField_a_of_type_Boolean))
          {
            QLog.d("ReadInJoyTabFrame", 1, "isColumnDiandianBtn true");
            RecommendFeedsDiandianEntranceManager.a().a(null, i, 0, a());
            pkh.a(a(), bmhv.b());
          }
          else if ((j == 2) || (j == 1))
          {
            QLog.d("ReadInJoyTabFrame", 1, "ENTRANCE_FEEDS_TYPE_VIDEO or ENTRANCE_FEEDS_TYPE_VIDEO_CHANNEL");
            a(a());
          }
          else
          {
            QLog.d("ReadInJoyTabFrame", 1, "jump default schema");
            pkh.a(a(), RecommendFeedsDiandianEntranceManager.a(j));
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      QLog.d("ReadInJoyTabFrame", 1, "entrancebutton has red dot: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      localtso = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localtso instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localtso).a != null))
      {
        QLog.d("ReadInJoyTabFrame", 1, "entrancebutton downloadinfo: " + ((VideoInfo.EntranceDownloadInfo)localtso).a);
        paramView = (VideoInfo.EntranceDownloadInfo)localtso;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        six.a(a(), paramView.a);
        if (this.jdField_a_of_type_Sij != null)
        {
          sij.b(paramView);
          this.jdField_a_of_type_Sij.a();
        }
        if (pqt.i()) {
          a(2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
        }
        return;
      }
    }
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    pqg localpqg;
    if (paramBoolean)
    {
      uvs.a(false);
      localObject = (rna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if ((((rna)localObject).a() != 1) || (TextUtils.isEmpty(((rna)localObject).a()))) {
        break label181;
      }
      localObject = ((rna)localObject).a();
      RefreshData localRefreshData = rmu.b(a(), 0);
      localpqg = new pqg();
      localObject = localpqg.e().f().a((String)localObject);
      if (paramInt == 1) {
        break label188;
      }
      paramBoolean = true;
      label84:
      localObject = ((pqg)localObject).a(paramBoolean);
      if (pqc.jdField_a_of_type_Int != 0) {
        break label193;
      }
      paramBoolean = true;
      label98:
      ((pqg)localObject).b(paramBoolean);
      localObject = a();
      if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).a() == 0)) {
        if ((localRefreshData == null) || (!localRefreshData.isAD)) {
          break label198;
        }
      }
    }
    label181:
    label188:
    label193:
    label198:
    for (paramInt = 1;; paramInt = 0)
    {
      localpqg.a("ad_page", paramInt);
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, localpqg.a(), false);
      return;
      localObject = "0";
      break;
      paramBoolean = false;
      break label84;
      paramBoolean = false;
      break label98;
    }
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Sij != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_Sij.a(paramInt);
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null))
    {
      int i;
      int j;
      label51:
      label71:
      StringBuilder localStringBuilder;
      if ((bmhv.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true)) && (oyi.a.a(a())))
      {
        i = 1;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0) {
          break label140;
        }
        j = 1;
        if (i == 0) {
          break label145;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
        localStringBuilder = new StringBuilder().append("setEntranceButton Visibility: ");
        if (i == 0) {
          break label165;
        }
      }
      label140:
      label145:
      label165:
      for (String str = "true";; str = "false")
      {
        QLog.d("ReadInJoyTabFrame", 1, str);
        if ((j == 0) && (i != 0)) {
          RecommendFeedsDiandianEntranceManager.a().a(0, a());
        }
        if (j == i) {
          break label172;
        }
        return true;
        i = 0;
        break;
        j = 0;
        break label51;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
        break label71;
      }
      label172:
      return false;
    }
    return false;
  }
  
  public static boolean d_()
  {
    return jdField_b_of_type_Boolean;
  }
  
  private void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null)
    {
      int i = a(paramBoolean);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getLayoutParams();
      localLayoutParams.bottomMargin = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public static void y()
  {
    a("0X800AC6C", 0);
  }
  
  public static void z()
  {
    a("0X800AC6E", 2);
  }
  
  public void B()
  {
    super.B();
  }
  
  protected void C_()
  {
    if (!e()) {
      E();
    }
  }
  
  protected void D_()
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
  
  public void E_()
  {
    SparseIntArray localSparseIntArray = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
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
        i = 2131376217;
        continue;
        i = 2131376242;
        continue;
        i = 2131376227;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.18(this));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Oqy != null) {
      return this.jdField_a_of_type_Oqy.b();
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return 0;
    }
    if (paramInt1 != paramInt2)
    {
      a(false, false);
      return 0;
    }
    a(false, true);
    return 0;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560265, null);
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
    if (this.jdField_a_of_type_Oqy != null)
    {
      localObject = this.jdField_a_of_type_Oqy.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long, 0L, null, "", true);
      ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoyTabFrame.10(this, (ReadInJoyBaseFragment)localObject), 1000L);
      return null;
    }
    return localObject;
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  }
  
  public String a()
  {
    return anvx.a(2131693417);
  }
  
  public void a()
  {
    super.a();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (pro.a() == 0)
    {
      i = 1;
      localObject = a(2131371655);
      if (i == 0) {
        break label119;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      c();
      ((rna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      if (!rth.m()) {
        break label125;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      oyi.a.b();
      F();
      uic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e();
      return;
      i = 0;
      break;
      label119:
      i = 8;
      break label50;
      label125:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int |= paramInt;
    QLog.d("ReadInJoyTabFrame", 2, "set operation flag : " + paramInt);
    if (paramInt != 1) {
      uvs.a(paramInt);
    }
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
        Z();
      }
    }
    else {
      return;
    }
    if (paramIntent.getBooleanExtra("key_ugc_account_edit", false))
    {
      aa();
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
      uvs.a(i, paramBoolean, paramLong, prp.jdField_a_of_type_Rpn.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
      olh.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", paramKandianMergeManager.toString(), false);
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
    if ((i == 0) || (i == qez.a())) {
      d(false);
    }
    QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + i);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = a().getDisplayMetrics();
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131167023, 2131167023, 2131167023);
      paramDrawable.setColorFilter(a().getColor(2131167023), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(paramDrawable);
    }
    for (;;)
    {
      paramDrawable = (GradientDrawable)this.h.getBackground();
      paramDrawable.setStroke(ViewUtils.dpToPx(1.0F), Color.parseColor(str2));
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
      sfq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
      this.jdField_f_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    E_();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    E_();
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((rmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
  }
  
  public void a(tso paramtso)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtso);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramtso != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtso);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      Q();
    }
  }
  
  public boolean a()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      spg localspg = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localspg != null) && (localspg.a() != null))
      {
        if (localspg.a().a())
        {
          localspg.a().j();
          localspg.a().c();
          return true;
        }
        if (ukv.a(localspg.a())) {
          localspg.a().c();
        }
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).f())) {
      return true;
    }
    return super.a();
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 13)
    {
      pkh.a(6);
      Object localObject = a().getIntent().getExtras();
      if (syf.a((Bundle)localObject))
      {
        localObject = syf.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((tso)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((tso)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.30(this), 1000L);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    E_();
  }
  
  public void b(tso paramtso)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtso);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramtso != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtso);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      L();
      if (this.jdField_a_of_type_Oqy != null) {
        this.jdField_a_of_type_Oqy.e();
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
  
  public void c()
  {
    Object localObject = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
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
  
  public void c(boolean paramBoolean)
  {
    int i = 9216;
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) && (paramBoolean))
    {
      if (ImmersiveUtils.a())
      {
        ImmersiveUtils.a(a().getWindow(), true);
        if ((VersionUtils.isM()) && (SystemUtil.isMIUI()))
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
        if ((VersionUtils.isM()) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
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
    if ((ImmersiveUtils.a()) && ((!VersionUtils.isM()) || (!SystemUtil.isMIUI()))) {
      ImmersiveUtils.a(a().getWindow(), false);
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
  }
  
  public void d()
  {
    Drawable localDrawable = a().getDrawable(2130842985);
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) || (ThemeUtil.isSimpleDayTheme(false)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842901);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842897);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166916, 2131166917, 2131166915);
      localDrawable.setColorFilter(a().getColor(2131165357), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(localDrawable);
    }
    for (;;)
    {
      R();
      j(true);
      pvm.a().h();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850149);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840352);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850109);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131167023, 2131167023, 2131167023);
      localDrawable.setColorFilter(a().getColor(2131167023), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Oqy != null)
    {
      int j = 0;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (qez.a() != -1) {
          i = qez.a();
        }
      }
      this.jdField_a_of_type_Oqy.c(i);
    }
  }
  
  public void e()
  {
    super.e();
    VideoReport.addToDetectionWhitelist(a());
    VideoReport.ignorePageInOutEvent(a(), true);
    pvm.a().a();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        acim.a().a((Context)localObject, new acin());
      }
      G();
      V();
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((rna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      pvm.a().a(this.jdField_a_of_type_Pvq);
      uic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e();
      ucy.a();
      rjz.b().a();
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
        break label323;
      }
      c(1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = pvj.a().a();
        if (localObject != null) {
          ((qft)localObject).a(false);
        }
        prs.a();
      }
      this.jdField_a_of_type_Tli.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int i = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Oqy != null)
        {
          this.jdField_a_of_type_Oqy.c(i);
          if ((((Intent)localObject).getBooleanExtra("edit_video_jump_and_refresh", false)) && (a() != null)) {
            a().f();
          }
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      if (this.jdField_a_of_type_Oqy != null) {
        this.jdField_a_of_type_Oqy.b();
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        I();
        this.jdField_c_of_type_Boolean = true;
      }
      if (jdField_b_of_type_Boolean) {
        pqc.a(true);
      }
      pvj.a().q();
      if (((Boolean)bmhv.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
      {
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (!((Intent)localObject).getBooleanExtra("is_watch_word_share", false))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.a(9);
        }
        bmhv.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
      }
      X();
      h(true);
      return;
      label323:
      if (this.jdField_a_of_type_Sij != null) {
        sij.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
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
    j(paramBoolean);
    int i = a().getIntent().getIntExtra("launch_from", 5);
    a(paramBoolean, i);
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = prp.jdField_a_of_type_Rpn.jdField_a_of_type_Long;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    i(paramBoolean);
    if (paramBoolean)
    {
      urp.a();
      a(i, localKandianMergeManager);
      qku.a();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_e_of_type_Long = 0L;
      this.jdField_b_of_type_Int = 0;
      uvs.b();
      b(i);
      bmhv.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      pvu.c();
      x();
      pno.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      w();
      sqp.a().a(a());
      v();
      T();
      u();
      a(localKandianMergeManager);
      a(i, l1 - l2, true);
      ThreadManager.getFileThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
      t();
      qdk.a.a();
      r();
      C_();
      h(true);
      qgx.a().a();
      pqd.a.a();
      k(ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    for (;;)
    {
      g(paramBoolean);
      QLog.d("Q.readinjoy.4tab", 1, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + i);
      X();
      rao.a.a().a(false, "MATCH_ALL_UIN");
      return;
      urp.b();
      VideoReport.traverseExposure();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      q();
      D_();
      localKandianMergeManager.o();
      o();
      sfq.a();
      sfq.a().b();
      sqp.a().b(a());
      sqp.a().a(false, "readInjoy doOnPause");
      a(i, this.jdField_b_of_type_Long, false);
      a().getIntent().removeExtra("launch_from");
      n();
      prp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      pkh.b();
      pjr.a();
      m();
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      localKandianMergeManager.p();
      l();
      h(false);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.b() != this) {
      U();
    }
    jdField_a_of_type_Boolean = false;
    Q();
    ApngImage.pauseByTag(8);
    pvj.n();
    this.jdField_a_of_type_Tli.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_Oqy != null) {
      this.jdField_a_of_type_Oqy.c();
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Oqy != null) {
      this.jdField_a_of_type_Oqy.a(paramBoolean);
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
      sqp.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ujj.a.b(-1);
      ukq.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : visible = " + paramBoolean);
      return;
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      ujj.a.b(localReadInJoyBaseFragment.a());
      ukq.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId " + localReadInJoyBaseFragment.a() + " : visible = " + paramBoolean);
      return;
    }
    ujj.a.b(-1);
    ukq.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : visible = " + paramBoolean);
  }
  
  public void i()
  {
    super.i();
    ((rna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    pvm.a().b(this.jdField_a_of_type_Pvq);
    this.jdField_a_of_type_Tli.e();
    if (this.jdField_a_of_type_Oqy != null)
    {
      this.jdField_a_of_type_Oqy.d();
      this.jdField_a_of_type_Oqy = null;
    }
    if (this.jdField_a_of_type_Sij != null) {
      this.jdField_a_of_type_Sij.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    jdField_b_of_type_Boolean = false;
    pac.a().a();
    bmie.a().a();
    KandianVideoUploadService.a(null);
    RecommendFeedsDiandianEntranceManager.a().b(this);
    rjm.a().c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.i();
    }
    uet.a.a();
  }
  
  protected void i(boolean paramBoolean)
  {
    ((uhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER)).a(a());
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      if (paramBoolean)
      {
        oqy.a(localReadInJoyBaseFragment.a(), 0);
        localReadInJoyBaseFragment.a(false, a(), null);
      }
    }
    else {
      return;
    }
    localReadInJoyBaseFragment.g();
  }
  
  public void j()
  {
    a(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    if (bmhv.m()) {
      olh.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", omx.a(null), false);
    }
  }
  
  protected void j(boolean paramBoolean)
  {
    c(paramBoolean);
    bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  protected void l()
  {
    tmk.a().b();
  }
  
  protected void m()
  {
    if (VersionUtils.isM()) {
      a().getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  protected void n()
  {
    Object localObject = (pvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if ((localObject != null) && (((pvp)localObject).a() != null))
    {
      localObject = ((pvp)localObject).a().a();
      if (localObject != null) {
        ((ReadInJoyUserInfoModule)localObject).b();
      }
    }
  }
  
  protected void o()
  {
    long l = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
    if (l > 0L) {
      ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.16(this, l));
    }
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    P();
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoFailed, uin = ", paramString1, Character.valueOf('\n'), "errMsg = ", paramString2 });
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoSucceed uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo });
  }
  
  protected void q()
  {
    if (this.jdField_e_of_type_Long != 0L)
    {
      this.jdField_e_of_type_Long += this.jdField_a_of_type_Long - this.jdField_c_of_type_Long;
      return;
    }
    this.jdField_e_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
  }
  
  protected void r()
  {
    if ((bdvn.a()) && (prh.a())) {
      prh.b("0X800AF05");
    }
  }
  
  protected void s()
  {
    if ((a() instanceof ReadInJoyRecommendFeedsFragment))
    {
      qhd localqhd = pvj.a().a();
      if (localqhd != null) {
        localqhd.a();
      }
    }
    else
    {
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "requestColumn0x6cf failed!");
  }
  
  protected void t()
  {
    if (pqt.g()) {
      V();
    }
  }
  
  protected void u()
  {
    if (tel.a() != 8) {
      tel.a(5);
    }
    tem.a().a(false);
  }
  
  protected void v()
  {
    boolean bool = false;
    int j = 1;
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    int i;
    if ((a() != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
    {
      long l2 = bmhv.f(pkh.a());
      if ((l1 >= l2) && (this.jdField_a_of_type_Long != 0L))
      {
        this.jdField_d_of_type_Boolean = true;
        pvm.a().l();
        QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l1, ", timeLimit = ", Long.valueOf(l2) });
        i = 1;
        if (bdvn.a())
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
  
  protected void w()
  {
    if (bmhv.m())
    {
      pqu.a(6);
      return;
    }
    pqu.a(3);
  }
  
  protected void x()
  {
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.17(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */
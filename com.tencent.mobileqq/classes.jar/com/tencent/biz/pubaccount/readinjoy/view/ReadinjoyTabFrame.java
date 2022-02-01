package com.tencent.biz.pubaccount.readinjoy.view;

import absn;
import abso;
import amrz;
import amtj;
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
import bbyp;
import bcoo;
import bfur;
import bfyz;
import bjsv;
import bjsy;
import bkwm;
import bkwv;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
import odq;
import ofe;
import ojc;
import okj;
import oph;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import osc;
import pai;
import pay;
import pbg;
import pgk;
import pil;
import pke;
import pkg;
import pkm;
import pkp;
import pks;
import pkt;
import pkx;
import pmw;
import psn;
import puf;
import puz;
import pvs;
import pvx;
import pwf;
import pyp;
import qoj;
import qok;
import qxg;
import qxt;
import rao;
import rau;
import rdh;
import rha;
import rsl;
import rtb;
import rwh;
import rwv;
import sdc;
import sdy;
import sek;
import sfz;
import sid;
import sie;
import skv;
import smg;
import sph;
import spn;
import spo;
import spp;
import spq;
import spr;
import sps;
import spt;
import spu;
import spv;
import spw;
import spx;
import spy;
import spz;
import sqa;
import sqb;
import sqc;
import sqd;
import sqe;
import sqf;
import sqg;
import sqm;
import sra;
import srb;
import sya;
import szc;
import ted;
import tfb;
import tfc;
import tpj;
import ttq;
import ttv;
import tvi;
import twp;
import twu;
import uds;
import ugt;
import uhv;

public class ReadinjoyTabFrame
  extends amrz
  implements ViewTreeObserver.OnGlobalLayoutListener, pke, pkg, pmw, pwf, sph, sqm
{
  public static int a;
  public static boolean a;
  private static boolean jdField_b_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new spp(this);
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private SparseArray<Bundle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new spz(this);
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
  private ojc jdField_a_of_type_Ojc;
  private pkt jdField_a_of_type_Pkt = new spq(this);
  private rwh jdField_a_of_type_Rwh;
  private sfz jdField_a_of_type_Sfz;
  protected sya a;
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
  
  private void D()
  {
    a(2131378954).setBackgroundDrawable(null);
    this.jdField_a_of_type_Sya = new sya(a(), (ViewGroup)a(2131378954));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131375913));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131375930));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131375911));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131377908));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131376476));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131364569));
    this.jdField_b_of_type_AndroidViewView = a(2131378727);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131377570));
    P();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378806));
    this.jdField_d_of_type_AndroidViewView = a(2131377749);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131375984));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131375983));
    this.h = a(2131376933);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379821));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379820));
    label326:
    label334:
    Object localObject;
    if (pay.r())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131167337));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131167276));
      }
      if (!rha.m()) {
        break label668;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (pay.j() != 0) {
        break label680;
      }
      i = 1;
      localObject = a(2131371469);
      if (i == 0) {
        break label685;
      }
    }
    label668:
    label680:
    label685:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.jdField_g_of_type_AndroidViewView = a(2131375958);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131371422));
      i = AIOUtils.dp2px(3.0F, a());
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new spo(this));
      K();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131371931)).a(53).a();
      VideoReport.setElementId(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "head_sculpture_button");
      VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, ReportPolicy.REPORT_POLICY_CLICK);
      VideoReport.setElementParams(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, new pil().a("14").c("click_head_sculpture").a().a());
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new spy(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new sqb(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new sqc(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      d();
      C_();
      H();
      G();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131365021);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      if ("2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnLongClickListener(new sqd(this));
      }
      c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.addOnPageChangeListener(new sqe(this));
      return;
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      i = 0;
      break label334;
    }
  }
  
  private void E()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {}
    for (;;)
    {
      return;
      boolean bool = rha.m();
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
  
  private void F()
  {
    SelectPositionModule localSelectPositionModule = pkm.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void G()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Sya);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Ojc = new ojc(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Ojc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_Ojc.a(this.jdField_a_of_type_Sya);
  }
  
  private void H()
  {
    I();
  }
  
  private void I()
  {
    if (bkwm.k()) {}
    while (!bkwm.j()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new sqf(this));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new sqg(this));
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
  
  private void J()
  {
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, "entrance_button");
    VideoReport.setElementParams(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, new pil().a("14").c("click_entrance").a(Integer.valueOf(0)).a().a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private void K()
  {
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131373668);
    J();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297320);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new spn(this));
    k(ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    boolean bool = bkwm.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    switch (bkwm.f())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_Rwh = new rwh(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "is show video entrance button: " + bool);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849330));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849294));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130842799));
    }
  }
  
  private void L()
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
  
  private void M()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = bfyz.d((Context)localObject1);
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
        if ((bfyz.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (bkwm.f() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          bfyz.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = DisplayUtil.dip2px((Context)localObject1, 12.0F);
          int j = DisplayUtil.dip2px((Context)localObject1, 9.0F);
          sfz localsfz = new sfz((Context)localObject1);
          this.jdField_a_of_type_Sfz = localsfz;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localsfz.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131717616));
          localsfz.setAnimationStyle(2131755846);
          localsfz.b(-16777216);
          localsfz.setSoftInputMode(1);
          localsfz.setInputMethodMode(2);
          localsfz.a(localsfz.b() / 2 - DisplayUtil.dip2px((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = ScreenUtil.SCREEN_WIDTH;
          j = DisplayUtil.dip2px((Context)localObject1, 15.0F);
          int k = localsfz.b();
          int m = localObject2[1];
          int n = localsfz.a();
          int i1 = localsfz.c();
          int i2 = DisplayUtil.dip2px((Context)localObject1, 5.0F);
          localsfz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.12(this), 3000L);
          odq.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new sie(null, null, null, null).a().a(), false);
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
  
  private void N()
  {
    if (this.jdField_a_of_type_Sfz != null) {
      this.jdField_a_of_type_Sfz.dismiss();
    }
  }
  
  private void O()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (bool)
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131375966)).inflate();
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
            this.jdField_f_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131560245, null);
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
  
  private void P()
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
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = amtj.a(2131693237);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131375970;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = amtj.a(2131712096);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131375980;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = amtj.a(2131712024);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131375995;
      }
    }
  }
  
  private void Q()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131297320);
    }
  }
  
  private void R()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable.a(this);
    ThreadManager.executeOnSubThread(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable);
  }
  
  private void S()
  {
    if (!"2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bjsy();
    ((bjsy)localObject).jdField_a_of_type_Int = 0;
    ((bjsy)localObject).jdField_a_of_type_JavaLangString = amtj.a(2131712010);
    ((bjsy)localObject).jdField_b_of_type_Int = 2130842554;
    localArrayList.add(localObject);
    localObject = new bjsy();
    ((bjsy)localObject).jdField_a_of_type_Int = 1;
    ((bjsy)localObject).jdField_a_of_type_JavaLangString = amtj.a(2131712203);
    ((bjsy)localObject).jdField_b_of_type_Int = 2130842554;
    localArrayList.add(localObject);
    localObject = new bjsy();
    ((bjsy)localObject).jdField_a_of_type_Int = 2;
    ((bjsy)localObject).jdField_a_of_type_JavaLangString = amtj.a(2131712141);
    ((bjsy)localObject).jdField_a_of_type_Float = 14.0F;
    ((bjsy)localObject).jdField_b_of_type_Int = 2130842554;
    localArrayList.add(localObject);
    localObject = new bjsy();
    ((bjsy)localObject).jdField_a_of_type_Int = 3;
    ((bjsy)localObject).jdField_a_of_type_JavaLangString = amtj.a(2131712066);
    ((bjsy)localObject).jdField_b_of_type_Int = 2130842554;
    localArrayList.add(localObject);
    bjsy localbjsy = new bjsy();
    localbjsy.jdField_a_of_type_Int = 4;
    if (!pay.n())
    {
      localObject = "打开预加载UI";
      localbjsy.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbjsy.jdField_b_of_type_Int = 2130842554;
      localArrayList.add(localbjsy);
      localbjsy = new bjsy();
      localbjsy.jdField_a_of_type_Int = 5;
      if (((Boolean)bkwm.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label379;
      }
      localObject = "打开动态频道feeds";
      label263:
      localbjsy.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbjsy.jdField_a_of_type_Float = 12.0F;
      localbjsy.jdField_b_of_type_Int = 2130842554;
      localArrayList.add(localbjsy);
      localbjsy = new bjsy();
      localbjsy.jdField_a_of_type_Int = 6;
      if (bkwm.C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label386;
      }
    }
    label386:
    for (localObject = amtj.a(2131711965);; localObject = "切换到Web")
    {
      localbjsy.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbjsy.jdField_a_of_type_Float = 12.0F;
      localbjsy.jdField_b_of_type_Int = 2130842554;
      localArrayList.add(localbjsy);
      bjsv.a(a(), localArrayList, new spv(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
      return;
      localObject = "取消预加载UI";
      break;
      label379:
      localObject = "取消动态频道feeds";
      break label263;
    }
  }
  
  private void T()
  {
    a("0X800AC6C", 0);
  }
  
  private void U()
  {
    a("0X800AC6E", 2);
  }
  
  private void V()
  {
    a("0X800AC6D", 3);
  }
  
  private void W()
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null))
    {
      boolean bool = bkwm.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
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
  
  private void X()
  {
    int i = 8;
    int k = 0;
    boolean bool = bcoo.a();
    if (bool == this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = bool;
    int j;
    Object localObject;
    if (bcoo.a())
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
        if (!pay.g()) {
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
        W();
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
    okj.b(a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = pay.a();
        localJSONObject.put("folder_status", pay.d);
        if (!bool) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", pay.e());
        localJSONObject.put("kandian_mode_new", ofe.a());
        localObject = (rau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
        if ((((rau)localObject).a() != 1) || (TextUtils.isEmpty(((rau)localObject).a()))) {
          continue;
        }
        localObject = ((rau)localObject).a();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
        localObject = new HashMap();
        ((Map)localObject).put("uin", pay.a());
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
      ugt.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      localObject = "0";
    }
  }
  
  private void Z()
  {
    pvs localpvs = pkm.a().a();
    if (localpvs != null) {
      localpvs.a(pay.a(), new sqa(this));
    }
  }
  
  private int a(@NotNull Context paramContext, List<bjsy> paramList)
  {
    int i = AIOUtils.dp2px(125.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 15.0F);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      bjsy localbjsy = (bjsy)paramList.next();
      int j = (int)Math.ceil(localTextView.getPaint().measureText(localbjsy.jdField_a_of_type_JavaLangString)) + AIOUtils.dp2px(71.0F, paramContext.getResources());
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
  
  private bjsy a(int paramInt, String paramString, Drawable paramDrawable)
  {
    bjsy localbjsy = new bjsy();
    localbjsy.jdField_a_of_type_Int = paramInt;
    localbjsy.jdField_a_of_type_JavaLangString = paramString;
    localbjsy.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return localbjsy;
  }
  
  private VideoInfo a()
  {
    boolean bool1 = false;
    Bundle localBundle = new Bundle();
    localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    int i = (int)(DeviceInfoUtil.getPortraitWidth() * 0.4D);
    int j = (int)(DeviceInfoUtil.getPortraitHeight() * 0.4D);
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
      if (this.jdField_a_of_type_Rwh != null)
      {
        bool2 = this.jdField_a_of_type_Rwh.a(localBundle);
        localObject1 = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
        if (bkwm.f() != 1) {
          break label301;
        }
        localObject2 = rsl.a((VideoInfo)localObject1);
        if ((localObject2 == null) || (!(localObject2 instanceof ArticleInfo))) {
          break label275;
        }
        pgk.a(a(), null, (ArticleInfo)localObject2, false, 0, 0, false, 1004);
      }
    }
    return localObject1;
    label275:
    okj.a(a(), 56, a().getString(2131718437), 3, 1004);
    return localObject1;
    label301:
    localObject2 = a();
    if (!bool2) {
      bool1 = true;
    }
    rwv.a((Context)localObject2, localBundle, bool1, 11);
    c(3);
    return localObject1;
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
      localObject = bfur.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((QQCustomDialog)localObject).setPositiveButton("确认", new spr(this, paramPositionData));
      ((QQCustomDialog)localObject).setNegativeButton("取消", new sps(this));
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(true);
      ((QQCustomDialog)localObject).show();
      return;
    }
    paramPositionData = smg.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new spt(this));
    paramPositionData.setNegativeButton("取消", new spu(this));
    paramPositionData.show();
  }
  
  private void a(int paramInt, List<bjsy> paramList)
  {
    Drawable localDrawable;
    if (rha.g())
    {
      localDrawable = a().getDrawable(2130842858).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(0, rha.a(BaseApplicationImpl.getContext()), localDrawable));
    }
    if ((paramInt & 0x2) != 0)
    {
      localDrawable = a().getDrawable(2130842859).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(1, BaseApplicationImpl.getApplication().getString(2131717350), localDrawable));
    }
    if (rha.h())
    {
      localDrawable = a().getDrawable(2130843060).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(2, rha.b(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (rha.i())
    {
      localDrawable = a().getDrawable(2130843064).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(3, rha.c(BaseApplicationImpl.getContext()), localDrawable));
    }
  }
  
  private void a(long paramLong)
  {
    pay.b().postDelayed(new ReadinjoyTabFrame.33(this), paramLong);
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    a(bkwm.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bjsv.a(paramActivity, localArrayList, new spw(this, paramActivity), new spx(this), a(paramActivity, localArrayList), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131298807) - paramActivity.getResources().getDimensionPixelSize(2131298803) + AIOUtils.dp2px(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131298136));
    T();
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.21(this, paramVideoInfo, (rau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)), 16, null, true);
  }
  
  private void a(String paramString)
  {
    bkwm.a("KEY_ENTRANCE_SCHEMA", paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    int j = 1;
    pbg localpbg1 = new pbg();
    pbg localpbg2;
    if (rha.i())
    {
      i = 1;
      localpbg2 = localpbg1.a("ugc_video_flag", Integer.valueOf(i));
      if (!rha.h()) {
        break label88;
      }
    }
    label88:
    for (int i = j;; i = 0)
    {
      localpbg2.a("ugc_column_flag", Integer.valueOf(i));
      if (paramInt != 0) {
        localpbg1.a("from", Integer.valueOf(paramInt));
      }
      odq.a(paramString, localpbg1.a());
      return;
      i = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ReadinjoyTabFrame.13 local13 = new ReadinjoyTabFrame.13(this, paramBoolean, paramInt);
    if (pay.A())
    {
      ThreadManager.executeOnSubThread(local13);
      return;
    }
    local13.run();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = pay.a();
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
          localObject3 = pay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          String str2 = pay.a.jdField_a_of_type_JavaLangString;
          String str3 = pay.g(pay.a.c);
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
              break label931;
            }
            ((JSONObject)localObject2).put("reddot_num", ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get());
            break label931;
            ((JSONObject)localObject2).put("current_page", j);
            if (!NetworkUtil.isWifiConnected(a())) {
              break label952;
            }
            j = 2;
            ((JSONObject)localObject2).put("network_type", j);
            ((JSONObject)localObject2).put("kandian_mode_new", ofe.a());
            if (pay.g != 0) {
              break label958;
            }
            j = 0;
            ((JSONObject)localObject2).put("button_state", j);
            ((JSONObject)localObject2).put("os", 1);
            ((JSONObject)localObject2).put("version", ofe.jdField_a_of_type_JavaLangString);
            if (ojc.a != null) {
              ((JSONObject)localObject2).put("channel_id", ojc.a.mChannelCoverId);
            }
            pay.a(true, (JSONObject)localObject2);
            odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, (String)localObject3, ((JSONObject)localObject2).toString(), false);
            if (localObject1 != null) {
              pay.a(21, str3, (String)localObject3, str2, "", -1);
            }
            if (paramBoolean2)
            {
              uhv.a(false);
              localObject1 = (rau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
              if ((((rau)localObject1).a() != 1) || (TextUtils.isEmpty(((rau)localObject1).a()))) {
                break label964;
              }
              localObject1 = ((rau)localObject1).a();
              localObject2 = (rao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
              localObject2 = rao.b(a(), 0);
              localObject3 = new pbg();
              localObject1 = ((pbg)localObject3).e().f().a((String)localObject1);
              if (i == 1) {
                break label972;
              }
              paramBoolean1 = true;
              localObject1 = ((pbg)localObject1).a(paramBoolean1);
              if (pay.g != 0) {
                break label977;
              }
              paramBoolean1 = true;
              ((pbg)localObject1).b(paramBoolean1);
              localObject1 = a();
              if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
              {
                if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
                  break label982;
                }
                i = 1;
                ((pbg)localObject3).a("ad_page", i);
              }
              odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, ((pbg)localObject3).a(), false);
            }
            ttv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (!bkwm.k()) {
              break label923;
            }
            localObject1 = "recommend_tab_cost";
            ugt.a(null, (String)localObject1);
          }
        }
        else
        {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 5) {
            break label941;
          }
          i = 3;
          continue;
        }
        if (pay.a.jdField_a_of_type_Long == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - pay.a.jdField_b_of_type_Long;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - pay.a.jdField_a_of_type_Long;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
        {
          i = 2;
          ((JSONObject)localObject2).put("reddot", i);
          ((JSONObject)localObject2).put("kandian_mode", pay.e());
          ((JSONObject)localObject2).put("kandian_mode_new", ofe.a());
          localObject1 = (rau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
          if ((((rau)localObject1).a() != 1) || (TextUtils.isEmpty(((rau)localObject1).a()))) {
            break label878;
          }
          localObject1 = ((rau)localObject1).a();
          localObject3 = (rao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
          localObject3 = rao.b(a(), 0);
          ((JSONObject)localObject2).put("skin_id", localObject1);
          localObject1 = a();
          if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
          {
            if ((localObject3 == null) || (!((RefreshData)localObject3).isAD)) {
              break label995;
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
            break label886;
          }
          odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject1, null, null, ((JSONObject)localObject2).toString(), false);
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
      label878:
      String str1 = "0";
      continue;
      label886:
      odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, ((JSONObject)localObject2).toString(), false);
      continue;
      label923:
      str1 = "video_tab_cost";
      continue;
      label931:
      if (!paramBoolean2)
      {
        j = 0;
        continue;
        label941:
        i = 2;
      }
      else
      {
        j = 1;
        continue;
        label952:
        j = 1;
        continue;
        label958:
        j = 1;
        continue;
        label964:
        str1 = "0";
        continue;
        label972:
        paramBoolean1 = false;
        continue;
        label977:
        paramBoolean1 = false;
        continue;
        label982:
        i = 0;
        continue;
        str1 = "";
        continue;
        label995:
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
  
  private void aa()
  {
    bkwm.h();
    pay.b().post(new ReadinjoyTabFrame.34(this));
    a(2500L);
  }
  
  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    oph.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772240, 2130772041);
  }
  
  private void b(View paramView)
  {
    j = tfc.jdField_b_of_type_Int;
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
        tfb localtfb;
        QLog.d("ReadInJoyTabFrame", 1, "parseInt error!");
        int i = j;
        continue;
        if ((localtfb instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
        {
          String str = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localtfb).c;
          QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo recommendfeeds jumpSchema " + str);
          paramView = str;
          if (TextUtils.isEmpty(str)) {
            paramView = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localtfb).jdField_a_of_type_Int);
          }
          if (!TextUtils.isEmpty(paramView))
          {
            pay.a(a(), paramView);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
            a(paramView);
          }
        }
        else
        {
          if ((localtfb instanceof tfc))
          {
            paramView = (tfc)localtfb;
            QLog.d("ReadInJoyTabFrame", 1, "column button jump to red source! " + paramView);
            if (paramView.a == null) {
              pay.a(a(), bkwm.b());
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
              RecommendFeedsDiandianEntranceManager.a().a(paramView, i, 0);
              break;
              rwv.a(a(), paramView.a);
            }
          }
          QLog.d("ReadInJoyTabFrame", 1, "lauch videofeeds");
          a(a());
          continue;
          j = RecommendFeedsDiandianEntranceManager.a().a();
          QLog.d("ReadInJoyTabFrame", 1, "diandian button jump to default url! feedType " + j);
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.jdField_a_of_type_Boolean))
          {
            QLog.d("ReadInJoyTabFrame", 1, "isColumnDiandianBtn true");
            RecommendFeedsDiandianEntranceManager.a().a(null, i, 0);
            pay.a(a(), bkwm.b());
          }
          else if ((j == 2) || (j == 1))
          {
            QLog.d("ReadInJoyTabFrame", 1, "ENTRANCE_FEEDS_TYPE_VIDEO or ENTRANCE_FEEDS_TYPE_VIDEO_CHANNEL");
            a(a());
          }
          else
          {
            QLog.d("ReadInJoyTabFrame", 1, "jump default schema");
            pay.a(a(), RecommendFeedsDiandianEntranceManager.a(j));
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      QLog.d("ReadInJoyTabFrame", 1, "entrancebutton has red dot: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      localtfb = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localtfb instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localtfb).a != null))
      {
        QLog.d("ReadInJoyTabFrame", 1, "entrancebutton downloadinfo: " + ((VideoInfo.EntranceDownloadInfo)localtfb).a);
        paramView = (VideoInfo.EntranceDownloadInfo)localtfb;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        rwv.a(a(), paramView.a);
        if (this.jdField_a_of_type_Rwh != null)
        {
          rwh.b(paramView);
          this.jdField_a_of_type_Rwh.a();
        }
        if (pay.t()) {
          a(2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
        }
        return;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Rwh != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_Rwh.a(paramInt);
    }
  }
  
  public static boolean d_()
  {
    return jdField_b_of_type_Boolean;
  }
  
  private void k(boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams;
    int j;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getLayoutParams();
      j = a().getDimensionPixelOffset(2131297320);
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int i = ViewUtils.dpToPx(5.0F);; i = 0)
    {
      localLayoutParams.bottomMargin = (i + j);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  private void z()
  {
    W();
    L();
    RecommendFeedsDiandianEntranceManager.a().b();
    if (this.jdField_a_of_type_Rwh != null) {
      this.jdField_a_of_type_Rwh.d();
    }
  }
  
  protected void A_()
  {
    if (!e()) {
      C();
    }
  }
  
  protected void B_()
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
  
  public void C_()
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
        i = 2131375970;
        continue;
        i = 2131375995;
        continue;
        i = 2131375980;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.18(this));
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560219, null);
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
    if (this.jdField_a_of_type_Ojc != null)
    {
      localObject = this.jdField_a_of_type_Ojc.a();
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
    return amtj.a(2131693237);
  }
  
  public void a()
  {
    super.a();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (pay.j() == 0)
    {
      i = 1;
      localObject = a(2131371469);
      if (i == 0) {
        break label113;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      c();
      ((rau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      if (!rha.m()) {
        break label119;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      z();
      ttv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e();
      return;
      i = 0;
      break;
      label113:
      i = 8;
      break label50;
      label119:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int |= paramInt;
    QLog.d("ReadInJoyTabFrame", 2, "set operation flag : " + paramInt);
    if (paramInt != 1) {
      uhv.a(paramInt);
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
      uhv.a(i, paramBoolean, paramLong, pay.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
      odq.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", paramKandianMergeManager.toString(), false);
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
    if ((i == 0) || (i == puf.a())) {
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131167009, 2131167009, 2131167009);
      paramDrawable.setColorFilter(a().getColor(2131167009), PorterDuff.Mode.SRC_IN);
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
      rtb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
      this.jdField_f_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    C_();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    C_();
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((rao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
  }
  
  public void a(tfb paramtfb)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtfb);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramtfb != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtfb);
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
      N();
    }
  }
  
  public boolean a()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      sdc localsdc = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localsdc != null) && (localsdc.a() != null))
      {
        if (localsdc.a().a())
        {
          localsdc.a().j();
          localsdc.a().c();
          return true;
        }
        if (twu.a(localsdc.a())) {
          localsdc.a().c();
        }
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).f())) {
      return true;
    }
    return super.a();
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 13)
    {
      pay.c(6);
      Object localObject = a().getIntent().getExtras();
      if (skv.a((Bundle)localObject))
      {
        localObject = skv.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((tfb)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((tfb)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.30(this), 1000L);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    C_();
  }
  
  public void b(tfb paramtfb)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtfb);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramtfb != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtfb);
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
      I();
      if (this.jdField_a_of_type_Ojc != null) {
        this.jdField_a_of_type_Ojc.e();
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
    Drawable localDrawable = a().getDrawable(2130842953);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842869);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842865);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166902, 2131166903, 2131166901);
      localDrawable.setColorFilter(a().getColor(2131165351), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(localDrawable);
    }
    for (;;)
    {
      O();
      j(true);
      pkp.a().h();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850056);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840316);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850016);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131167009, 2131167009, 2131167009);
      localDrawable.setColorFilter(a().getColor(2131167009), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ojc != null)
    {
      int j = 0;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (puf.a() != -1) {
          i = puf.a();
        }
      }
      this.jdField_a_of_type_Ojc.c(i);
    }
  }
  
  public void e()
  {
    super.e();
    VideoReport.addToDetectionWhitelist(a());
    VideoReport.ignorePageInOutEvent(a(), true);
    pkp.a().a();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        absn.a().a((Context)localObject, new abso());
      }
      D();
      R();
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((rau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      pkp.a().a(this.jdField_a_of_type_Pkt);
      ttv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e();
      tpj.a();
      qxt.b().a();
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
        localObject = pkm.a().a();
        if (localObject != null) {
          ((puz)localObject).a(false);
        }
        pay.g();
      }
      this.jdField_a_of_type_Sya.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int i = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Ojc != null)
        {
          this.jdField_a_of_type_Ojc.c(i);
          if ((((Intent)localObject).getBooleanExtra("edit_video_jump_and_refresh", false)) && (a() != null)) {
            a().f();
          }
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      if (this.jdField_a_of_type_Ojc != null) {
        this.jdField_a_of_type_Ojc.b();
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        F();
        this.jdField_c_of_type_Boolean = true;
      }
      if (jdField_b_of_type_Boolean) {
        pay.b(true);
      }
      pkm.a().q();
      if (((Boolean)bkwm.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
      {
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (!((Intent)localObject).getBooleanExtra("is_watch_word_share", false))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.a(9);
        }
        bkwm.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
      }
      X();
      h(true);
      return;
      label323:
      if (this.jdField_a_of_type_Rwh != null) {
        rwh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
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
    long l2 = pay.a.jdField_a_of_type_Long;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    i(paramBoolean);
    if (paramBoolean)
    {
      uds.a();
      a(i, localKandianMergeManager);
      pyp.a();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_e_of_type_Long = 0L;
      this.jdField_b_of_type_Int = 0;
      uhv.b();
      b(i);
      bkwm.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      pkx.c();
      x();
      pay.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      w();
      sek.a().a(a());
      v();
      RecommendFeedsDiandianEntranceManager.a().a();
      u();
      a(localKandianMergeManager);
      a(i, l1 - l2, true);
      ThreadManager.getFileThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
      t();
      psn.a.a();
      s();
      r();
      A_();
      h(true);
    }
    for (;;)
    {
      g(paramBoolean);
      QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + i);
      X();
      qoj.a.a().a(false, "MATCH_ALL_UIN");
      return;
      uds.b();
      VideoReport.traverseExposure();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      q();
      B_();
      localKandianMergeManager.o();
      o();
      rtb.a();
      rtb.a().b();
      sek.a().b(a());
      sek.a().a(false, "readInjoy doOnPause");
      a(i, this.jdField_b_of_type_Long, false);
      a().getIntent().removeExtra("launch_from");
      n();
      pay.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      pay.c();
      pai.a();
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
      Q();
    }
    jdField_a_of_type_Boolean = false;
    N();
    ApngImage.pauseByTag(8);
    pkm.n();
    this.jdField_a_of_type_Sya.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_Ojc != null) {
      this.jdField_a_of_type_Ojc.c();
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ojc != null) {
      this.jdField_a_of_type_Ojc.a(paramBoolean);
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
      sek.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      tvi.a.b(-1);
      twp.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : visible = " + paramBoolean);
      return;
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      tvi.a.b(localReadInJoyBaseFragment.a());
      twp.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId " + localReadInJoyBaseFragment.a() + " : visible = " + paramBoolean);
      return;
    }
    tvi.a.b(-1);
    twp.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : visible = " + paramBoolean);
  }
  
  public void i()
  {
    super.i();
    ((rau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    pkp.a().b(this.jdField_a_of_type_Pkt);
    this.jdField_a_of_type_Sya.e();
    if (this.jdField_a_of_type_Ojc != null)
    {
      this.jdField_a_of_type_Ojc.d();
      this.jdField_a_of_type_Ojc = null;
    }
    if (this.jdField_a_of_type_Rwh != null) {
      this.jdField_a_of_type_Rwh.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    jdField_b_of_type_Boolean = false;
    osc.a().a();
    bkwv.a().a();
    KandianVideoUploadService.a(null);
    RecommendFeedsDiandianEntranceManager.a().b(this);
    qxg.a().c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.i();
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    ((ttq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(307)).a(a());
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      if (paramBoolean)
      {
        ojc.a(localReadInJoyBaseFragment.a(), 0);
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
    if (bkwm.j()) {
      odq.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", ofe.a(null), false);
    }
  }
  
  protected void j(boolean paramBoolean)
  {
    c(paramBoolean);
    bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  protected void l()
  {
    szc.a().b();
  }
  
  protected void m()
  {
    if (VersionUtils.isM()) {
      a().getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  protected void n()
  {
    Object localObject = (pks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    if ((localObject != null) && (((pks)localObject).a() != null))
    {
      localObject = ((pks)localObject).a().a();
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
    M();
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
    if ((bcoo.a()) && (pay.g())) {
      pay.d("0X800AF05");
    }
  }
  
  protected void s()
  {
    if ((a() instanceof ReadInJoyRecommendFeedsFragment))
    {
      pvx localpvx = pkm.a().a();
      if (localpvx != null) {
        localpvx.a();
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
    if (pay.y()) {
      R();
    }
  }
  
  protected void u()
  {
    if (sra.a() != 8) {
      sra.a(5);
    }
    srb.a().a(false);
  }
  
  protected void v()
  {
    boolean bool = false;
    int j = 1;
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    int i;
    if ((a() != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
    {
      long l2 = bkwm.f(pay.a());
      if ((l1 >= l2) && (this.jdField_a_of_type_Long != 0L))
      {
        this.jdField_d_of_type_Boolean = true;
        pkp.a().l();
        QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l1, ", timeLimit = ", Long.valueOf(l2) });
        i = 1;
        if (bcoo.a())
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
    if (bkwm.j())
    {
      pay.d(6);
      return;
    }
    pay.d(3);
  }
  
  protected void x()
  {
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.17(this));
  }
  
  public void y()
  {
    super.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */
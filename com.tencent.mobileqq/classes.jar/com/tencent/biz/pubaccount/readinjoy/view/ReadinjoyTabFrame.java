package com.tencent.biz.pubaccount.readinjoy.view;

import acwf;
import acwg;
import agej;
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
import anxh;
import anxr;
import anzj;
import bdep;
import bdgb;
import bdmc;
import bduy;
import bhgr;
import bhjr;
import bhlo;
import bhlq;
import bhnv;
import bhpc;
import bhsi;
import bhtq;
import blol;
import bloo;
import bnrf;
import bnro;
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
import ocd;
import odr;
import ohp;
import oix;
import onw;
import ord;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import ozc;
import ozs;
import paa;
import pes;
import peu;
import pfa;
import pfd;
import pfg;
import pfh;
import pfl;
import phj;
import pnh;
import pox;
import ppr;
import ppy;
import pqd;
import pql;
import psv;
import qig;
import qih;
import qrn;
import qtq;
import qtw;
import qwj;
import rab;
import rll;
import rlz;
import rpf;
import rpt;
import rvy;
import rwu;
import rxg;
import ryv;
import sbf;
import sbg;
import sdn;
import sgu;
import slg;
import slm;
import sln;
import slo;
import slp;
import slq;
import slr;
import sls;
import slt;
import slu;
import slv;
import slw;
import slx;
import sly;
import slz;
import sma;
import smb;
import smc;
import smd;
import sme;
import smf;
import sml;
import smz;
import sna;
import sua;
import svc;
import tad;
import tay;
import taz;
import tjz;
import tnt;
import tny;
import tqd;
import tqi;
import txc;
import uae;
import ubg;

public class ReadinjoyTabFrame
  extends anxr
  implements ViewTreeObserver.OnGlobalLayoutListener, pes, peu, phj, pql, slg, sml
{
  public static int a;
  public static boolean a;
  private static boolean jdField_b_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new slo(this);
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private SparseArray<Bundle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new sly(this);
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
  private ohp jdField_a_of_type_Ohp;
  private pfh jdField_a_of_type_Pfh = new slp(this);
  private rpf jdField_a_of_type_Rpf;
  private ryv jdField_a_of_type_Ryv;
  protected sua a;
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
  
  private void C()
  {
    V();
    K();
    RecommendFeedsDiandianEntranceManager.a().b();
    if (this.jdField_a_of_type_Rpf != null) {
      this.jdField_a_of_type_Rpf.d();
    }
  }
  
  private void D()
  {
    a(2131379184).setBackgroundDrawable(null);
    this.jdField_a_of_type_Sua = new sua(a(), (ViewGroup)a(2131379184));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131376149));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131376166));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376147));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131378137));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131376708));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131364548));
    this.jdField_b_of_type_AndroidViewView = a(2131378956);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131377801));
    O();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379037));
    this.jdField_d_of_type_AndroidViewView = a(2131377980);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376218));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131376217));
    this.h = a(2131377185);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380069));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380068));
    label328:
    label336:
    Object localObject;
    if (ozs.r())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131167302));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131167247));
      }
      if (!rab.m()) {
        break label618;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (ozs.j() != 0) {
        break label630;
      }
      i = 1;
      localObject = a(2131371501);
      if (i == 0) {
        break label635;
      }
    }
    label618:
    label630:
    label635:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.jdField_g_of_type_AndroidViewView = a(2131376194);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131371454));
      i = agej.a(3.0F, a());
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new sln(this));
      J();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131371966)).a(53).a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new slx(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new sma(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new smb(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      G_();
      ar_();
      H();
      G();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131364994);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      if ("2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnLongClickListener(new smc(this));
      }
      F_();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.addOnPageChangeListener(new smd(this));
      return;
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label328;
      i = 0;
      break label336;
    }
  }
  
  private void E()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {}
    for (;;)
    {
      return;
      boolean bool = rab.m();
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
    SelectPositionModule localSelectPositionModule = pfa.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void G()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Sua);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Ohp = new ohp(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Ohp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_Ohp.a(this.jdField_a_of_type_Sua);
  }
  
  private void H()
  {
    I();
  }
  
  private void I()
  {
    if (bnrf.j()) {}
    while (!bnrf.i()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new sme(this));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new smf(this));
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
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131373746);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297265);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new slm(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    boolean bool = bnrf.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    switch (bnrf.e())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_Rpf = new rpf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "is show video entrance button: " + bool);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849418));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849382));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130842753));
    }
  }
  
  private void K()
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
  
  private void L()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = bhsi.d((Context)localObject1);
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
        if ((bhsi.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (bnrf.e() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          bhsi.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = bhgr.a((Context)localObject1, 12.0F);
          int j = bhgr.a((Context)localObject1, 9.0F);
          ryv localryv = new ryv((Context)localObject1);
          this.jdField_a_of_type_Ryv = localryv;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localryv.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131717384));
          localryv.setAnimationStyle(2131755844);
          localryv.b(-16777216);
          localryv.setSoftInputMode(1);
          localryv.setInputMethodMode(2);
          localryv.a(localryv.b() / 2 - bhgr.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = bdep.jdField_a_of_type_Int;
          j = bhgr.a((Context)localObject1, 15.0F);
          int k = localryv.b();
          int m = localObject2[1];
          int n = localryv.a();
          int i1 = localryv.c();
          int i2 = bhgr.a((Context)localObject1, 5.0F);
          localryv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.12(this), 3000L);
          ocd.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new sbg(null, null, null, null).a().a(), false);
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
  
  private void M()
  {
    if (this.jdField_a_of_type_Ryv != null) {
      this.jdField_a_of_type_Ryv.dismiss();
    }
  }
  
  private void N()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131376202)).inflate();
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
            this.jdField_f_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131560238, null);
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
  
  private void O()
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
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anzj.a(2131693174);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376206;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anzj.a(2131711864);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376214;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = anzj.a(2131711792);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376229;
      }
    }
  }
  
  private void P()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131297265);
    }
  }
  
  private void Q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable.a(this);
    ThreadManager.executeOnSubThread(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable);
  }
  
  private void R()
  {
    if (!"2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bloo();
    ((bloo)localObject).jdField_a_of_type_Int = 0;
    ((bloo)localObject).jdField_a_of_type_JavaLangString = anzj.a(2131711778);
    ((bloo)localObject).jdField_b_of_type_Int = 2130842508;
    localArrayList.add(localObject);
    localObject = new bloo();
    ((bloo)localObject).jdField_a_of_type_Int = 1;
    ((bloo)localObject).jdField_a_of_type_JavaLangString = anzj.a(2131711971);
    ((bloo)localObject).jdField_b_of_type_Int = 2130842508;
    localArrayList.add(localObject);
    localObject = new bloo();
    ((bloo)localObject).jdField_a_of_type_Int = 2;
    ((bloo)localObject).jdField_a_of_type_JavaLangString = anzj.a(2131711909);
    ((bloo)localObject).jdField_a_of_type_Float = 14.0F;
    ((bloo)localObject).jdField_b_of_type_Int = 2130842508;
    localArrayList.add(localObject);
    localObject = new bloo();
    ((bloo)localObject).jdField_a_of_type_Int = 3;
    ((bloo)localObject).jdField_a_of_type_JavaLangString = anzj.a(2131711834);
    ((bloo)localObject).jdField_b_of_type_Int = 2130842508;
    localArrayList.add(localObject);
    bloo localbloo = new bloo();
    localbloo.jdField_a_of_type_Int = 4;
    if (!ozs.n())
    {
      localObject = "打开预加载UI";
      localbloo.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbloo.jdField_b_of_type_Int = 2130842508;
      localArrayList.add(localbloo);
      localbloo = new bloo();
      localbloo.jdField_a_of_type_Int = 5;
      if (((Boolean)bnrf.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label379;
      }
      localObject = "打开动态频道feeds";
      label263:
      localbloo.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbloo.jdField_a_of_type_Float = 12.0F;
      localbloo.jdField_b_of_type_Int = 2130842508;
      localArrayList.add(localbloo);
      localbloo = new bloo();
      localbloo.jdField_a_of_type_Int = 6;
      if (bnrf.B(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label386;
      }
    }
    label386:
    for (localObject = anzj.a(2131711733);; localObject = "切换到Web")
    {
      localbloo.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbloo.jdField_a_of_type_Float = 12.0F;
      localbloo.jdField_b_of_type_Int = 2130842508;
      localArrayList.add(localbloo);
      blol.a(a(), localArrayList, new slu(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
      return;
      localObject = "取消预加载UI";
      break;
      label379:
      localObject = "取消动态频道feeds";
      break label263;
    }
  }
  
  private void S()
  {
    a("0X800AC6C", 0);
  }
  
  private void T()
  {
    a("0X800AC6E", 2);
  }
  
  private void U()
  {
    a("0X800AC6D", 3);
  }
  
  private void V()
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null))
    {
      boolean bool = bnrf.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
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
  
  private void W()
  {
    int i = 8;
    int k = 0;
    boolean bool = bduy.a();
    if (bool == this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = bool;
    int j;
    Object localObject;
    if (bduy.a())
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
        if (!ozs.g()) {
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
        V();
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
  
  private void X()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
    oix.b(a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = ozs.a();
        localJSONObject.put("folder_status", ozs.d);
        if (!bool) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", ozs.e());
        localJSONObject.put("kandian_mode_new", odr.a());
        localObject = (qtw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
        if ((((qtw)localObject).a() != 1) || (TextUtils.isEmpty(((qtw)localObject).a()))) {
          continue;
        }
        localObject = ((qtw)localObject).a();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
        localObject = new HashMap();
        ((Map)localObject).put("uin", ozs.a());
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
      uae.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      localObject = "0";
    }
  }
  
  private void Y()
  {
    ppy localppy = pfa.a().a();
    if (localppy != null) {
      localppy.a(ozs.a(), new slz(this));
    }
  }
  
  private void Z()
  {
    bnrf.g();
    ozs.b().post(new ReadinjoyTabFrame.35(this));
    a(2500L);
  }
  
  private int a(@NotNull Context paramContext, List<bloo> paramList)
  {
    int i = agej.a(125.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 15.0F);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      bloo localbloo = (bloo)paramList.next();
      int j = (int)Math.ceil(localTextView.getPaint().measureText(localbloo.jdField_a_of_type_JavaLangString)) + agej.a(71.0F, paramContext.getResources());
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
  
  private bloo a(int paramInt, String paramString, Drawable paramDrawable)
  {
    bloo localbloo = new bloo();
    localbloo.jdField_a_of_type_Int = paramInt;
    localbloo.jdField_a_of_type_JavaLangString = paramString;
    localbloo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return localbloo;
  }
  
  private VideoInfo a()
  {
    boolean bool1 = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    int i = (int)(bhlo.i() * 0.4D);
    int j = (int)(bhlo.j() * 0.4D);
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
      if (this.jdField_a_of_type_Rpf != null)
      {
        bool2 = this.jdField_a_of_type_Rpf.a(localBundle);
        localObject1 = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
        if (bnrf.e() != 1) {
          break label297;
        }
        localObject2 = rll.a((VideoInfo)localObject1);
        if ((localObject2 == null) || (!(localObject2 instanceof ArticleInfo))) {
          break label271;
        }
        ReadInJoyListViewGroup.a(a(), null, (ArticleInfo)localObject2, 1004);
      }
    }
    return localObject1;
    label271:
    oix.a(a(), 56, a().getString(2131718196), 3, 1004);
    return localObject1;
    label297:
    localObject2 = a();
    if (!bool2) {}
    for (;;)
    {
      rpt.a((Context)localObject2, localBundle, bool1, 11);
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
      localObject = bhlq.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((bhpc)localObject).setPositiveButton("确认", new slq(this, paramPositionData));
      ((bhpc)localObject).setNegativeButton("取消", new slr(this));
      ((bhpc)localObject).setCanceledOnTouchOutside(true);
      ((bhpc)localObject).show();
      return;
    }
    paramPositionData = sgu.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new sls(this));
    paramPositionData.setNegativeButton("取消", new slt(this));
    paramPositionData.show();
  }
  
  private void a(int paramInt, List<bloo> paramList)
  {
    Drawable localDrawable;
    if (rab.g())
    {
      localDrawable = a().getDrawable(2130842805).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(0, rab.a(BaseApplicationImpl.getContext()), localDrawable));
    }
    if ((paramInt & 0x2) != 0)
    {
      localDrawable = a().getDrawable(2130842806).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(1, BaseApplicationImpl.getApplication().getString(2131717113), localDrawable));
    }
    if (rab.h())
    {
      localDrawable = a().getDrawable(2130843006).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(2, rab.b(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (rab.i())
    {
      localDrawable = a().getDrawable(2130843010).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(3, rab.c(BaseApplicationImpl.getContext()), localDrawable));
    }
  }
  
  private void a(long paramLong)
  {
    ozs.b().postDelayed(new ReadinjoyTabFrame.34(this), paramLong);
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    a(bnrf.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    blol.a(paramActivity, localArrayList, new slv(this, paramActivity), new slw(this), a(paramActivity, localArrayList), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131298742) - paramActivity.getResources().getDimensionPixelSize(2131298738) + agej.a(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131298071));
    S();
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.21(this, paramVideoInfo, (qtw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)), 16, null, true);
  }
  
  private void a(String paramString)
  {
    bnrf.a("KEY_ENTRANCE_SCHEMA", paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    int j = 1;
    paa localpaa1 = new paa();
    paa localpaa2;
    if (rab.i())
    {
      i = 1;
      localpaa2 = localpaa1.a("ugc_video_flag", Integer.valueOf(i));
      if (!rab.h()) {
        break label88;
      }
    }
    label88:
    for (int i = j;; i = 0)
    {
      localpaa2.a("ugc_column_flag", Integer.valueOf(i));
      if (paramInt != 0) {
        localpaa1.a("from", Integer.valueOf(paramInt));
      }
      ocd.a(paramString, localpaa1.a());
      return;
      i = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ReadinjoyTabFrame.13 local13 = new ReadinjoyTabFrame.13(this, paramBoolean, paramInt);
    if (ozs.B())
    {
      ThreadManager.executeOnSubThread(local13);
      return;
    }
    local13.run();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = ozs.a();
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
          localObject3 = ozs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          String str2 = ozs.a.jdField_a_of_type_JavaLangString;
          String str3 = ozs.g(ozs.a.c);
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
            if (!bhnv.h(a())) {
              break label952;
            }
            j = 2;
            ((JSONObject)localObject2).put("network_type", j);
            ((JSONObject)localObject2).put("kandian_mode_new", odr.a());
            if (ozs.g != 0) {
              break label958;
            }
            j = 0;
            ((JSONObject)localObject2).put("button_state", j);
            ((JSONObject)localObject2).put("os", 1);
            ((JSONObject)localObject2).put("version", odr.jdField_a_of_type_JavaLangString);
            if (ohp.a != null) {
              ((JSONObject)localObject2).put("channel_id", ohp.a.mChannelCoverId);
            }
            ozs.a(true, (JSONObject)localObject2);
            ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, (String)localObject3, ((JSONObject)localObject2).toString(), false);
            if (localObject1 != null) {
              ozs.a(21, str3, (String)localObject3, str2, "", -1);
            }
            if (paramBoolean2)
            {
              ubg.a(false);
              localObject1 = (qtw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
              if ((((qtw)localObject1).a() != 1) || (TextUtils.isEmpty(((qtw)localObject1).a()))) {
                break label964;
              }
              localObject1 = ((qtw)localObject1).a();
              localObject2 = (qtq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
              localObject2 = qtq.b(a(), 0);
              localObject3 = new paa();
              localObject1 = ((paa)localObject3).e().f().a((String)localObject1);
              if (i == 1) {
                break label972;
              }
              paramBoolean1 = true;
              localObject1 = ((paa)localObject1).a(paramBoolean1);
              if (ozs.g != 0) {
                break label977;
              }
              paramBoolean1 = true;
              ((paa)localObject1).b(paramBoolean1);
              localObject1 = a();
              if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
              {
                if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
                  break label982;
                }
                i = 1;
                ((paa)localObject3).a("ad_page", i);
              }
              ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, ((paa)localObject3).a(), false);
            }
            tny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (!bnrf.j()) {
              break label923;
            }
            localObject1 = "recommend_tab_cost";
            uae.a(null, (String)localObject1);
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
        if (ozs.a.jdField_a_of_type_Long == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - ozs.a.jdField_b_of_type_Long;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - ozs.a.jdField_a_of_type_Long;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
        {
          i = 2;
          ((JSONObject)localObject2).put("reddot", i);
          ((JSONObject)localObject2).put("kandian_mode", ozs.e());
          ((JSONObject)localObject2).put("kandian_mode_new", odr.a());
          localObject1 = (qtw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
          if ((((qtw)localObject1).a() != 1) || (TextUtils.isEmpty(((qtw)localObject1).a()))) {
            break label878;
          }
          localObject1 = ((qtw)localObject1).a();
          localObject3 = (qtq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
          localObject3 = qtq.b(a(), 0);
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
          ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject1, null, null, ((JSONObject)localObject2).toString(), false);
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
      ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, ((JSONObject)localObject2).toString(), false);
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
  
  private String b()
  {
    return (String)bnrf.a("KEY_ENTRANCE_SCHEMA", "");
  }
  
  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    onw.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772242, 2130772039);
  }
  
  private void b(View paramView)
  {
    j = taz.jdField_b_of_type_Int;
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
        tay localtay;
        QLog.d("ReadInJoyTabFrame", 1, "parseInt error!");
        int i = j;
        continue;
        if ((localtay instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
        {
          String str = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localtay).c;
          QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo jumpSchema " + str);
          paramView = str;
          if (TextUtils.isEmpty(str)) {
            paramView = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localtay).jdField_a_of_type_Int);
          }
          if (!TextUtils.isEmpty(paramView))
          {
            ozs.a(a(), paramView);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
            a(paramView);
          }
        }
        else
        {
          if ((localtay instanceof taz))
          {
            paramView = (taz)localtay;
            QLog.d("ReadInJoyTabFrame", 1, "column button jump to red source!");
            if (paramView.a == null) {
              ozs.a(a(), bnrf.b());
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
              RecommendFeedsDiandianEntranceManager.a().a(paramView, i, 0);
              break;
              rpt.a(a(), paramView.a);
            }
          }
          a(a());
          continue;
          if (c())
          {
            paramView = b();
            QLog.d("ReadInJoyTabFrame", 1, "hasEntranceStorageSchema: " + paramView);
            ozs.a(a(), paramView);
          }
          else
          {
            j = RecommendFeedsDiandianEntranceManager.a().a();
            QLog.d("ReadInJoyTabFrame", 1, "diandian button jump to default url!");
            if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.jdField_a_of_type_Boolean))
            {
              RecommendFeedsDiandianEntranceManager.a().a(null, i, 0);
              ozs.a(a(), bnrf.b());
            }
            else if ((j == 2) || (j == 1))
            {
              a(a());
            }
            else
            {
              ozs.a(a(), RecommendFeedsDiandianEntranceManager.a(j));
            }
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      localtay = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localtay instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localtay).a != null))
      {
        paramView = (VideoInfo.EntranceDownloadInfo)localtay;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        rpt.a(a(), paramView.a);
        if (this.jdField_a_of_type_Rpf != null)
        {
          rpf.b(paramView);
          this.jdField_a_of_type_Rpf.a();
        }
        if (ozs.t()) {
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
    if ((this.jdField_a_of_type_Rpf != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_Rpf.a(paramInt);
    }
  }
  
  private boolean c()
  {
    return !TextUtils.isEmpty(b());
  }
  
  public static boolean d_()
  {
    return jdField_b_of_type_Boolean;
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
    Drawable localDrawable = a().getDrawable(2130842899);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842815);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842812);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166883, 2131166884, 2131166882);
      localDrawable.setColorFilter(a().getColor(2131165343), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(localDrawable);
    }
    for (;;)
    {
      N();
      i(true);
      pfd.a().h();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850139);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840278);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850099);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166987, 2131166987, 2131166987);
      localDrawable.setColorFilter(a().getColor(2131166987), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
  }
  
  protected void H_()
  {
    long l = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
    if (l > 0L) {
      ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.16(this, l));
    }
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560212, null);
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
    if (this.jdField_a_of_type_Ohp != null)
    {
      localObject = this.jdField_a_of_type_Ohp.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      bdmc.a(BaseApplication.getContext()).a(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long, 0L, null, "", true);
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
    return anzj.a(2131693174);
  }
  
  public void a()
  {
    super.a();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (ozs.j() == 0)
    {
      i = 1;
      localObject = a(2131371501);
      if (i == 0) {
        break label113;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      F_();
      ((qtw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      if (!rab.m()) {
        break label119;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      C();
      tny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
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
      ubg.a(paramInt);
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
        Y();
      }
    }
    else {
      return;
    }
    if (paramIntent.getBooleanExtra("key_ugc_account_edit", false))
    {
      Z();
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
      ubg.a(i, paramBoolean, paramLong, ozs.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
      ocd.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", paramKandianMergeManager.toString(), false);
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
    if ((i == 0) || (i == pox.a())) {
      d(false);
    }
    QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + i);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = a().getDisplayMetrics();
    float f2 = anxh.a() / 16.0F;
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166987, 2131166987, 2131166987);
      paramDrawable.setColorFilter(a().getColor(2131166987), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(paramDrawable);
    }
    for (;;)
    {
      paramDrawable = (GradientDrawable)this.h.getBackground();
      paramDrawable.setStroke(bhtq.b(1.0F), Color.parseColor(str2));
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
      rlz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
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
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((qtq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
  }
  
  public void a(tay paramtay)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtay);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramtay != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtay);
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
      M();
    }
  }
  
  public boolean a()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      rvy localrvy = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localrvy != null) && (localrvy.a() != null))
      {
        if (localrvy.a().a())
        {
          localrvy.a().j();
          localrvy.a().c();
          return true;
        }
        if (tqd.a(localrvy.a())) {
          localrvy.a().c();
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
        i = 2131376206;
        continue;
        i = 2131376229;
        continue;
        i = 2131376214;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.18(this));
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 13)
    {
      ozs.c(6);
      Object localObject = a().getIntent().getExtras();
      if (sdn.a((Bundle)localObject))
      {
        localObject = sdn.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((tay)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((tay)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.31(this), 1000L);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ar_();
  }
  
  public void b(tay paramtay)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtay);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramtay != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtay);
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
      if (this.jdField_a_of_type_Ohp != null) {
        this.jdField_a_of_type_Ohp.e();
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
        if ((VersionUtils.isM()) && (bhjr.b()))
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
        if ((VersionUtils.isM()) && (!bhjr.b()) && (!bhjr.d()))
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
    if ((ImmersiveUtils.a()) && ((!VersionUtils.isM()) || (!bhjr.b()))) {
      ImmersiveUtils.a(a().getWindow(), false);
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ohp != null)
    {
      int j = 0;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (pox.a() != -1) {
          i = pox.a();
        }
      }
      this.jdField_a_of_type_Ohp.c(i);
    }
  }
  
  public void e()
  {
    super.e();
    VideoReport.addToDetectionWhitelist(a());
    pfd.a().a();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        acwf.a().a((Context)localObject, new acwg());
      }
      D();
      Q();
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((qtw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      pfd.a().a(this.jdField_a_of_type_Pfh);
      tny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
      tjz.a();
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
        break label318;
      }
      c(1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = pfa.a().a();
        if (localObject != null) {
          ((ppr)localObject).a(false);
        }
        ozs.g();
      }
      this.jdField_a_of_type_Sua.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int i = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Ohp != null)
        {
          this.jdField_a_of_type_Ohp.c(i);
          if ((((Intent)localObject).getBooleanExtra("edit_video_jump_and_refresh", false)) && (a() != null)) {
            a().f();
          }
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      if (this.jdField_a_of_type_Ohp != null) {
        this.jdField_a_of_type_Ohp.b();
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        F();
        this.jdField_c_of_type_Boolean = true;
      }
      if (jdField_b_of_type_Boolean) {
        ozs.b(true);
      }
      pfa.a().q();
      if (((Boolean)bnrf.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
      {
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (!((Intent)localObject).getBooleanExtra("is_watch_word_share", false))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.a(9);
        }
        bnrf.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
      }
      W();
      return;
      label318:
      if (this.jdField_a_of_type_Rpf != null) {
        rpf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
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
    long l2 = ozs.a.jdField_a_of_type_Long;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    h(paramBoolean);
    if (paramBoolean)
    {
      txc.a();
      a(i, localKandianMergeManager);
      psv.a();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_e_of_type_Long = 0L;
      this.jdField_b_of_type_Int = 0;
      ubg.b();
      b(i);
      bnrf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      pfl.c();
      x();
      ozs.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      w();
      rxg.a().a(a());
      v();
      RecommendFeedsDiandianEntranceManager.a().a();
      u();
      a(localKandianMergeManager);
      a(i, l1 - l2, true);
      ThreadManager.getFileThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
      tqi.a().b(0);
      t();
      pnh.a.a();
      s();
      r();
      k();
    }
    for (;;)
    {
      g(paramBoolean);
      QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + i);
      W();
      qig.a.a().a(false, "MATCH_ALL_UIN");
      return;
      txc.b();
      VideoReport.traverseExposure();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      q();
      p();
      localKandianMergeManager.p();
      H_();
      rlz.a();
      rlz.a().b();
      rxg.a().b(a());
      rxg.a().a(false, "readInjoy doOnPause");
      a(i, this.jdField_b_of_type_Long, false);
      a().getIntent().removeExtra("launch_from");
      n();
      ozs.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ozs.c();
      ozc.a();
      m();
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      tqi.a().b(4);
      tqi.a().c(false);
      localKandianMergeManager.q();
      l();
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.b() != this) {
      P();
    }
    jdField_a_of_type_Boolean = false;
    M();
    ApngImage.pauseByTag(8);
    pfa.n();
    this.jdField_a_of_type_Sua.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_Ohp != null) {
      this.jdField_a_of_type_Ohp.c();
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ohp != null) {
      this.jdField_a_of_type_Ohp.a(paramBoolean);
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
      rxg.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    ((tnt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(307)).a(a());
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      if (paramBoolean)
      {
        ohp.a(localReadInJoyBaseFragment.a(), 0);
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
    super.i();
    ((qtw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    pfd.a().b(this.jdField_a_of_type_Pfh);
    this.jdField_a_of_type_Sua.e();
    if (this.jdField_a_of_type_Ohp != null)
    {
      this.jdField_a_of_type_Ohp.d();
      this.jdField_a_of_type_Ohp = null;
    }
    if (this.jdField_a_of_type_Rpf != null) {
      this.jdField_a_of_type_Rpf.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    jdField_b_of_type_Boolean = false;
    ord.a().a();
    bnro.a().a();
    KandianVideoUploadService.a(null);
    RecommendFeedsDiandianEntranceManager.a().b(this);
    qrn.a().c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.i();
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    c(paramBoolean);
    bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  public void j()
  {
    a(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    if (bnrf.i()) {
      ocd.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", odr.a(null), false);
    }
  }
  
  protected void k()
  {
    if (!e()) {
      B();
    }
  }
  
  protected void l()
  {
    svc.a().b();
  }
  
  protected void m()
  {
    if (VersionUtils.isM()) {
      a().getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  protected void n()
  {
    Object localObject = (pfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    if ((localObject != null) && (((pfg)localObject).a() != null))
    {
      localObject = ((pfg)localObject).a().a();
      if (localObject != null) {
        ((ReadInJoyUserInfoModule)localObject).b();
      }
    }
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    L();
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
    if ((bduy.a()) && (ozs.g())) {
      ozs.d("0X800AF05");
    }
  }
  
  protected void s()
  {
    if ((a() instanceof ReadInJoyRecommendFeedsFragment))
    {
      pqd localpqd = pfa.a().a();
      if (localpqd != null) {
        localpqd.a();
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
    if (ozs.z()) {
      Q();
    }
  }
  
  protected void u()
  {
    if (smz.a() != 8) {
      smz.a(5);
    }
    sna.a().a(false);
  }
  
  protected void v()
  {
    boolean bool = false;
    int j = 1;
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    int i;
    if ((a() != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
    {
      long l2 = bnrf.g(ozs.a());
      if ((l1 >= l2) && (this.jdField_a_of_type_Long != 0L))
      {
        this.jdField_d_of_type_Boolean = true;
        pfd.a().l();
        QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l1, ", timeLimit = ", Long.valueOf(l2) });
        i = 1;
        if (bduy.a())
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
    if (bnrf.i())
    {
      ozs.d(6);
      return;
    }
    ozs.d(3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */
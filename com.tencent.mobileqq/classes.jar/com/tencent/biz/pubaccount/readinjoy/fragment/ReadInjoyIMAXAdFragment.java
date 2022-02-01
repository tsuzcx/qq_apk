package com.tencent.biz.pubaccount.readinjoy.fragment;

import abrl;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ClipLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import oar;
import obb;
import pql;
import pqm;
import pqn;
import pqo;
import pqp;
import pqq;
import pqr;
import pqs;
import pqt;
import pqu;
import pqv;
import pqw;
import rwv;
import rzv;
import sdi;
import trn;
import uhs;

public class ReadInjoyIMAXAdFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static long a;
  public static Drawable a;
  public static long b;
  public static boolean c;
  public static boolean d;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClipLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString = "3";
  private oar jdField_a_of_type_Oar;
  private pqu jdField_a_of_type_Pqu;
  public boolean a;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int jdField_d_of_type_Int = 1;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 1;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 1;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int m;
  private int n;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Long = -1L;
  }
  
  private Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  private void a(int paramInt)
  {
    a(paramInt);
    if ((this.jdField_a_of_type_Pqu != null) && (this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!this.jdField_l_of_type_Boolean) && (paramInt >= this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImgDisplayMs))
    {
      this.jdField_l_of_type_Boolean = true;
      if (this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxJumpLandingPage == 1) {
        e(this);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "startIMAX: time=" + System.currentTimeMillis());
    }
    this.jdField_i_of_type_Boolean = true;
    if ((this.jdField_g_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setAlpha(1.0F);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.2F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setNeedClip(true);
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "viewHeight =" + paramInt2 + ",viewWidth =" + paramInt1);
      QLog.d("ReadInjoyIMAXAdFragment", 2, "startLeft =" + this.jdField_j_of_type_Int + ",startTop =" + this.jdField_k_of_type_Int + ",startRight =" + this.jdField_h_of_type_Int + ",startBottom =" + this.jdField_i_of_type_Int);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new pqo(this, paramInt1, paramInt2));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new pqp(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Pqu != null) && (this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        break label63;
      }
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration() - this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowSlipAllowMs;
      if ((l1 > 0L) && (l1 < paramLong)) {
        m();
      }
    }
    label63:
    while (this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowSlipAllowMs >= paramLong)
    {
      long l1;
      return;
    }
    m();
  }
  
  public static void a(Context paramContext, pqu parampqu)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("w", parampqu.jdField_c_of_type_Int);
    localIntent.putExtra("h", parampqu.jdField_d_of_type_Int);
    localIntent.putExtra("top", parampqu.jdField_b_of_type_Int);
    localIntent.putExtra("left", parampqu.jdField_a_of_type_Int);
    localIntent.putExtra("ad", parampqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, ReadInjoyIMAXAdFragment.class);
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (TextUtils.isEmpty(paramAdvertisementInfo.mImaxImg)) {
      f(this);
    }
    int i1;
    int i2;
    do
    {
      return;
      this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      Object localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView, 0, (ViewGroup.LayoutParams)localObject);
      this.jdField_f_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
      paramAdvertisementInfo = URLDrawable.getDrawable(paramAdvertisementInfo.mImaxImg, (URLDrawable.URLDrawableOptions)localObject);
      localObject = ((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17) {
        ((Display)localObject).getRealMetrics(localDisplayMetrics);
      }
      for (;;)
      {
        i1 = localDisplayMetrics.widthPixels;
        i2 = localDisplayMetrics.heightPixels + this.n;
        if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.getStatus() != 2)) {
          break;
        }
        paramAdvertisementInfo.restartDownload();
        return;
        ((Display)localObject).getMetrics(localDisplayMetrics);
      }
      if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.getStatus() == 1))
      {
        this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(paramAdvertisementInfo);
        a(i1, i2);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(-2);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(-2);
        return;
      }
    } while (paramAdvertisementInfo == null);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(paramAdvertisementInfo);
    paramAdvertisementInfo.setURLDrawableListener(new pqn(this, i1, i2));
  }
  
  private void a(AppInterface paramAppInterface, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("stat_src", this.jdField_a_of_type_JavaLangString);
    obb.a(new trn().a(paramAppInterface).a(a()).a(paramInt).b(obb.ag).a(this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(obb.a(localHashMap)).a());
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      obb.a(new trn().a(paramAppInterface).a(a()).a(obb.jdField_f_of_type_Int).b(obb.ag).a(this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(obb.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, (int)this.jdField_c_of_type_Long, obb.aP, 0)).d(obb.a(localHashMap)).a());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    QLog.i("ReadInjoyIMAXAdFragment", 1, "preloadToolsProcess running");
    Object localObject = null;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = localObject;
      if (BaseApplicationImpl.getApplication() != null)
      {
        paramQQAppInterface = localObject;
        if (BaseApplicationImpl.getApplication().getRuntime() == null) {}
      }
    }
    for (paramQQAppInterface = (WebProcessManager)BaseApplicationImpl.getApplication().getRuntime().getManager(13);; paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13))
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(200);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    return true;
  }
  
  private boolean a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if ((paramProteusBannerVideoItemData1 == null) || (paramProteusBannerVideoItemData2 == null)) {}
    while ((!TextUtils.isEmpty(paramProteusBannerVideoItemData1.o)) && (!paramProteusBannerVideoItemData1.o.equals(paramProteusBannerVideoItemData2.o))) {
      return true;
    }
    return false;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new pqv(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout = ((ClipLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131380512));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131368472));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131368471));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131368475));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131379993));
    this.jdField_a_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131370180);
    this.jdField_b_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131370240);
    this.jdField_c_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131376641);
    this.jdField_d_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131376640);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131372007));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131380520));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    paramContext = new pql(this, new GestureDetector(getActivity(), new pqt(this)));
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(paramContext);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(paramContext);
    ((FrameLayout)getActivity().findViewById(16908290)).setForeground(new ColorDrawable(0));
  }
  
  private void c(Context paramContext)
  {
    this.jdField_a_of_type_Int = 3;
    i();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (paramContext != null) && (this.jdField_a_of_type_Oar != null))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(paramContext);
      Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      pqw localpqw = new pqw(this);
      ((IVideoViewBase)localObject).addViewCallBack(localpqw);
      this.jdField_e_of_type_AndroidViewView = ((View)localObject);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout != null)
      {
        this.jdField_e_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.addView(this.jdField_e_of_type_AndroidViewView, 0);
        localObject = new TVK_UserInfo("", "");
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, obb.a(this.jdField_a_of_type_Oar.d), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", sdi.jdField_a_of_type_JavaLangString);
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext.getApplicationContext(), (IVideoViewBase)this.jdField_e_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(localpqw);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(localpqw);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(localpqw);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, this.jdField_a_of_type_Oar.d, 0L, 0L, (TVK_UserInfo)localObject, localTVK_PlayerVideoInfo);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyIMAXAdFragment", 2, "openMediaPlayerByUrl: time=" + System.currentTimeMillis());
          }
        }
      }
    }
  }
  
  private void d(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      TVK_SDKMgr.installPlugin(paramContext.getApplicationContext(), new pqr(this));
      return;
    }
    catch (Throwable paramContext)
    {
      abrl.a("ReadInjoyIMAXAdFragment", "installSDK t==" + paramContext.toString());
    }
  }
  
  private static void e(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    paramReadInjoyIMAXAdFragment.jdField_a_of_type_Int = 9;
    jdField_d_of_type_Boolean = true;
    if (paramReadInjoyIMAXAdFragment.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      paramReadInjoyIMAXAdFragment.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    if (paramReadInjoyIMAXAdFragment.jdField_g_of_type_Boolean) {
      return;
    }
    paramReadInjoyIMAXAdFragment.jdField_g_of_type_Boolean = true;
    f(paramReadInjoyIMAXAdFragment);
    paramReadInjoyIMAXAdFragment.a(paramReadInjoyIMAXAdFragment.getActivity().app, obb.w);
  }
  
  private static void f(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    if ((paramReadInjoyIMAXAdFragment.jdField_a_of_type_Pqu == null) || (paramReadInjoyIMAXAdFragment.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    uhs.a(paramReadInjoyIMAXAdFragment.getActivity(), paramReadInjoyIMAXAdFragment.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdLandingPage, paramReadInjoyIMAXAdFragment.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    paramReadInjoyIMAXAdFragment.jdField_b_of_type_AndroidOsHandler.postDelayed(new ReadInjoyIMAXAdFragment.8(paramReadInjoyIMAXAdFragment), 400L);
  }
  
  private void j()
  {
    e(this);
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "videoPreparedInitialization: time=" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      boolean bool = a(this.jdField_a_of_type_Oar.d, this.jdField_a_of_type_Oar.d);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyIMAXAdFragment", 2, "native ad preload cache state: " + bool);
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
      jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Int = 4;
      this.jdField_g_of_type_Int = 2;
      i();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(4);
      if (!this.jdField_i_of_type_Boolean)
      {
        this.jdField_i_of_type_Boolean = true;
        a(((IVideoViewBase)this.jdField_e_of_type_AndroidViewView).getViewWidth(), ((IVideoViewBase)this.jdField_e_of_type_AndroidViewView).getViewHeight());
      }
      if (QLog.isColorLevel()) {
        QLog.i("ReadInjoyIMAXAdFragment", 2, "ReadInjoyIMAXAdFragment onVideoPrepared isRetry start");
      }
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(-2);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(-2);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_Int = 6;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      i();
    }
  }
  
  private void m()
  {
    if ((this.jdField_e_of_type_AndroidWidgetImageView != null) && (this.jdField_e_of_type_AndroidWidgetImageView.getAnimation() != null)) {}
    while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_e_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 0.2F);
    localTranslateAnimation1.setDuration(900L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.2F, 1, 0.0F);
    localTranslateAnimation2.setDuration(900L);
    localTranslateAnimation2.setFillAfter(true);
    localTranslateAnimation1.setAnimationListener(new pqs(this, localTranslateAnimation2));
    localTranslateAnimation2.setAnimationListener(new pqm(this, localTranslateAnimation1));
    this.jdField_e_of_type_AndroidWidgetImageView.startAnimation(localTranslateAnimation1);
  }
  
  public void a()
  {
    Object localObject = getActivity().getIntent();
    this.jdField_a_of_type_Pqu = new pqu();
    this.jdField_a_of_type_Pqu.jdField_c_of_type_Int = ((Intent)localObject).getIntExtra("w", 0);
    this.jdField_a_of_type_Pqu.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("h", 0);
    this.jdField_a_of_type_Pqu.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("top", 0);
    this.jdField_a_of_type_Pqu.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("left", 0);
    this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)((Intent)localObject).getParcelableExtra("ad"));
    if (this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().app;
    this.jdField_l_of_type_Int = this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowAdType;
    this.jdField_j_of_type_Int = (this.jdField_a_of_type_Pqu.jdField_a_of_type_Int + 0);
    this.jdField_k_of_type_Int = (this.jdField_a_of_type_Pqu.jdField_b_of_type_Int + 0);
    this.jdField_h_of_type_Int = (this.jdField_j_of_type_Int + this.jdField_a_of_type_Pqu.jdField_c_of_type_Int - 0);
    this.jdField_i_of_type_Int = (this.jdField_k_of_type_Int + this.jdField_a_of_type_Pqu.jdField_d_of_type_Int - 0);
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Pqu.jdField_c_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Pqu.jdField_d_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_k_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_j_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(0.97F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(0.97F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setAlpha(0.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setNeedClip(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt);
    }
    if (this.jdField_l_of_type_Int == 1001)
    {
      this.jdField_a_of_type_JavaLangString = "3";
      this.jdField_a_of_type_Oar = new oar();
      this.jdField_a_of_type_Oar.d = this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxVideoUrl;
      a(null, this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, null);
    }
    for (;;)
    {
      a(getActivity().app);
      localObject = this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdLandingPage;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intent localIntent = new Intent(localBaseApplicationImpl.getBaseContext(), PreloadWebService.class);
      localIntent.putExtra("url", (String)localObject);
      try
      {
        localBaseApplicationImpl.getBaseContext().startService(localIntent);
        localObject = new HashMap();
        ((HashMap)localObject).put("stat_src", this.jdField_a_of_type_JavaLangString);
        obb.a(new trn().a(getActivity()).a(obb.jdField_b_of_type_Int).b(obb.ag).a(this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(obb.a((HashMap)localObject)).a());
        return;
        if (this.jdField_l_of_type_Int != 1002) {
          continue;
        }
        this.jdField_a_of_type_JavaLangString = "10";
        a(this.jdField_a_of_type_Pqu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInjoyIMAXAdFragment", 2, "preDownloadIfNecessary=>" + localThrowable.getMessage());
          }
        }
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (!this.jdField_e_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_e_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext.getApplicationContext()))
    {
      c(paramContext);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInjoyIMAXAdFragment.6(this, paramContext));
  }
  
  public void a(oar paramoar, AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if (paramoar == null) {
      this.jdField_a_of_type_Oar = new oar();
    }
    this.jdField_a_of_type_Oar.d = paramAdvertisementInfo.mImaxVideoUrl;
    if ((jdField_a_of_type_Long == -1L) || (System.currentTimeMillis() - jdField_a_of_type_Long > 1000L) || (a(paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2)))
    {
      a(a());
      jdField_a_of_type_Long = System.currentTimeMillis();
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.mImaxImg)) {
      return;
    }
    this.jdField_g_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    paramoar = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.getChildCount() == 0) {}
    for (int i1 = 0;; i1 = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.addView(this.jdField_g_of_type_AndroidWidgetImageView, i1, paramoar);
      this.jdField_g_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      paramoar = URLDrawable.URLDrawableOptions.obtain();
      paramoar.mPlayGifImage = true;
      paramoar.mLoadingDrawable = new ColorDrawable(-16777216);
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramAdvertisementInfo.mImaxImg, paramoar);
      paramoar = ((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay();
      paramAdvertisementInfo = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17) {
        paramoar.getRealMetrics(paramAdvertisementInfo);
      }
      int i2;
      for (;;)
      {
        i1 = paramAdvertisementInfo.widthPixels;
        i2 = paramAdvertisementInfo.heightPixels + this.n;
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 2)) {
          break;
        }
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
        return;
        paramoar.getMetrics(paramAdvertisementInfo);
      }
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1))
      {
        this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
        a(i1, i2);
        return;
      }
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
        break;
      }
      this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new pqq(this, i1, i2));
      return;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return false;
    }
    String str1 = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        str1 = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        str1 = obb.a(paramString1);
      }
    }
    paramString2 = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str1, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", sdi.jdField_a_of_type_JavaLangString);
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str2 = arrayOfString[i1];
      int i3 = localTVK_ICacheMgr.isVideoCached(a(), paramString1, paramString2, localTVK_PlayerVideoInfo, str2);
      if ((i3 == 2) || (i3 == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInjoyIMAXAdFragment", 2, str1 + " checkIsVideoCached(), definition = " + str2 + ", cacheStatus = " + i3 + ", return TRUE");
        }
        return true;
      }
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, str1 + " checkIsVideoCached() return FALSE");
    }
    return false;
  }
  
  public void b()
  {
    do
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
        }
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(this, 5));
          }
          return;
        }
      }
      finally {}
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.removeAllViews();
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout = null;
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      jdField_d_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    i();
  }
  
  public void e()
  {
    k();
  }
  
  public void f()
  {
    l();
  }
  
  public void g()
  {
    c(a());
  }
  
  public void h()
  {
    b();
  }
  
  public void i()
  {
    if ((Looper.myLooper() != Looper.getMainLooper()) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(this, 1));
    }
    do
    {
      do
      {
        return;
        switch (this.jdField_a_of_type_Int)
        {
        case 1: 
        case 2: 
        case 6: 
        case 7: 
        default: 
          return;
        }
      } while (this.jdField_a_of_type_Int != 8);
      return;
    } while (this.jdField_g_of_type_AndroidWidgetImageView == null);
    rwv.a(this.jdField_g_of_type_AndroidWidgetImageView, 8, 300);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.getWindow().setSoftInputMode(17);
    rwv.a(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
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
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
          this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130842935));
        }
        else
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
          this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130842936));
          continue;
          getActivity().finish();
          if (!this.jdField_h_of_type_Boolean)
          {
            this.jdField_h_of_type_Boolean = true;
            a(getActivity().app, obb.u);
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_f_of_type_AndroidViewView = rzv.a(2131560212, true, new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = paramViewGroup.getContext();
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater;
    b(paramLayoutInflater);
    rwv.a(getActivity());
    getActivity().getWindow().setFlags(1024, 1024);
    LiuHaiUtils.a(getActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getActivity());
    }
    if (LiuHaiUtils.b())
    {
      this.n = LiuHaiUtils.b(getActivity());
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      int i1 = paramLayoutInflater.topMargin + this.n;
      paramLayoutInflater.topMargin = i1;
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramLayoutInflater.topMargin = i1;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramLayoutInflater);
    }
    a();
    paramLayoutInflater = this.jdField_f_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    b();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_f_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    c();
  }
  
  public void onResume()
  {
    super.onResume();
    rwv.a(getActivity());
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing())) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment
 * JD-Core Version:    0.7.0.1
 */
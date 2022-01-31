package com.tencent.biz.pubaccount.readinjoy.fragment;

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
import bkur;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ClipLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
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
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nlt;
import nmf;
import nyg;
import owg;
import owh;
import owi;
import owj;
import owk;
import owl;
import owm;
import own;
import owo;
import owp;
import owq;
import owr;
import qol;
import qrr;
import qua;
import sht;
import yxs;

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
  private ClipLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString = "3";
  private nlt jdField_a_of_type_Nlt;
  private owp jdField_a_of_type_Owp;
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
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      return this.jdField_a_of_type_AndroidContentContext;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    a(paramInt);
    if ((this.jdField_a_of_type_Owp != null) && (this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!this.jdField_l_of_type_Boolean) && (paramInt >= this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImgDisplayMs))
    {
      this.jdField_l_of_type_Boolean = true;
      if (this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxJumpLandingPage == 1) {
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.setAlpha(1.0F);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.2F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.setNeedClip(true);
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "viewHeight =" + paramInt2 + ",viewWidth =" + paramInt1);
      QLog.d("ReadInjoyIMAXAdFragment", 2, "startLeft =" + this.jdField_j_of_type_Int + ",startTop =" + this.jdField_k_of_type_Int + ",startRight =" + this.jdField_h_of_type_Int + ",startBottom =" + this.jdField_i_of_type_Int);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new owj(this, paramInt1, paramInt2));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new owk(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Owp != null) && (this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        break label63;
      }
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration() - this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowSlipAllowMs;
      if ((l1 > 0L) && (l1 < paramLong)) {
        m();
      }
    }
    label63:
    while (this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowSlipAllowMs >= paramLong)
    {
      long l1;
      return;
    }
    m();
  }
  
  public static void a(Context paramContext, owp paramowp)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("w", paramowp.jdField_c_of_type_Int);
    localIntent.putExtra("h", paramowp.jdField_d_of_type_Int);
    localIntent.putExtra("top", paramowp.jdField_b_of_type_Int);
    localIntent.putExtra("left", paramowp.jdField_a_of_type_Int);
    localIntent.putExtra("ad", paramowp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView, 0, (ViewGroup.LayoutParams)localObject);
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
    paramAdvertisementInfo.setURLDrawableListener(new owi(this, i1, i2));
  }
  
  private void a(AppInterface paramAppInterface, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("stat_src", this.jdField_a_of_type_JavaLangString);
    nmf.a(new nyg().a(paramAppInterface).a(a()).a(paramInt).b(nmf.ae).a(this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nmf.a(localHashMap)).a());
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      nmf.a(new nyg().a(paramAppInterface).a(a()).a(nmf.jdField_f_of_type_Int).b(nmf.ae).a(this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nmf.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, (int)this.jdField_c_of_type_Long, nmf.aE, 0)).d(nmf.a(localHashMap)).a());
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
    while ((!TextUtils.isEmpty(paramProteusBannerVideoItemData1.w)) && (!paramProteusBannerVideoItemData1.w.equals(paramProteusBannerVideoItemData2.w))) {
      return true;
    }
    return false;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new owq(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout = ((ClipLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131378938));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131367902));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131367901));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131367905));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378484));
    this.jdField_a_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131369413);
    this.jdField_b_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131369464);
    this.jdField_c_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131375457);
    this.jdField_d_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131375456);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131371031));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378943));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    paramContext = new owg(this, new GestureDetector(getActivity(), new owo(this)));
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(paramContext);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(paramContext);
    ((FrameLayout)getActivity().findViewById(16908290)).setForeground(new ColorDrawable(0));
  }
  
  private void c(Context paramContext)
  {
    this.jdField_a_of_type_Int = 3;
    i();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (paramContext != null) && (this.jdField_a_of_type_Nlt != null))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(paramContext);
      Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      owr localowr = new owr(this);
      ((IVideoViewBase)localObject).addViewCallBack(localowr);
      this.jdField_e_of_type_AndroidViewView = ((View)localObject);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout != null)
      {
        this.jdField_e_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.addView(this.jdField_e_of_type_AndroidViewView, 0);
        localObject = new TVK_UserInfo("", "");
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, nmf.a(this.jdField_a_of_type_Nlt.d), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qua.jdField_a_of_type_JavaLangString);
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext.getApplicationContext(), (IVideoViewBase)this.jdField_e_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(localowr);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(localowr);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(localowr);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, this.jdField_a_of_type_Nlt.d, 0L, 0L, (TVK_UserInfo)localObject, localTVK_PlayerVideoInfo);
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
      TVK_SDKMgr.installPlugin(paramContext.getApplicationContext(), new owm(this));
      return;
    }
    catch (Throwable paramContext)
    {
      yxs.a("ReadInjoyIMAXAdFragment", "installSDK t==" + paramContext.toString());
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
    paramReadInjoyIMAXAdFragment.a(paramReadInjoyIMAXAdFragment.getActivity().app, nmf.v);
  }
  
  private static void f(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    if ((paramReadInjoyIMAXAdFragment.jdField_a_of_type_Owp == null) || (paramReadInjoyIMAXAdFragment.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    sht.a(paramReadInjoyIMAXAdFragment.getActivity(), paramReadInjoyIMAXAdFragment.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdLandingPage, paramReadInjoyIMAXAdFragment.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
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
      boolean bool = a(this.jdField_a_of_type_Nlt.d, this.jdField_a_of_type_Nlt.d);
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
    localTranslateAnimation1.setAnimationListener(new own(this, localTranslateAnimation2));
    localTranslateAnimation2.setAnimationListener(new owh(this, localTranslateAnimation1));
    this.jdField_e_of_type_AndroidWidgetImageView.startAnimation(localTranslateAnimation1);
  }
  
  public void a()
  {
    Object localObject = getActivity().getIntent();
    this.jdField_a_of_type_Owp = new owp();
    this.jdField_a_of_type_Owp.jdField_c_of_type_Int = ((Intent)localObject).getIntExtra("w", 0);
    this.jdField_a_of_type_Owp.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("h", 0);
    this.jdField_a_of_type_Owp.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("top", 0);
    this.jdField_a_of_type_Owp.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("left", 0);
    this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)((Intent)localObject).getParcelableExtra("ad"));
    if (this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().app;
    this.jdField_l_of_type_Int = this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowAdType;
    this.jdField_j_of_type_Int = (this.jdField_a_of_type_Owp.jdField_a_of_type_Int + 0);
    this.jdField_k_of_type_Int = (this.jdField_a_of_type_Owp.jdField_b_of_type_Int + 0);
    this.jdField_h_of_type_Int = (this.jdField_j_of_type_Int + this.jdField_a_of_type_Owp.jdField_c_of_type_Int - 0);
    this.jdField_i_of_type_Int = (this.jdField_k_of_type_Int + this.jdField_a_of_type_Owp.jdField_d_of_type_Int - 0);
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Owp.jdField_c_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Owp.jdField_d_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_k_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_j_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(0.97F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(0.97F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.setAlpha(0.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.setNeedClip(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt);
    }
    if (this.jdField_l_of_type_Int == 1001)
    {
      this.jdField_a_of_type_JavaLangString = "3";
      this.jdField_a_of_type_Nlt = new nlt();
      this.jdField_a_of_type_Nlt.d = this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxVideoUrl;
      a(null, this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, null);
    }
    for (;;)
    {
      a(getActivity().app);
      localObject = this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdLandingPage;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intent localIntent = new Intent(localBaseApplicationImpl.getBaseContext(), PreloadWebService.class);
      localIntent.putExtra("url", (String)localObject);
      try
      {
        localBaseApplicationImpl.getBaseContext().startService(localIntent);
        localObject = new HashMap();
        ((HashMap)localObject).put("stat_src", this.jdField_a_of_type_JavaLangString);
        nmf.a(new nyg().a(getActivity()).a(nmf.jdField_b_of_type_Int).b(nmf.ae).a(this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nmf.a((HashMap)localObject)).a());
        return;
        if (this.jdField_l_of_type_Int != 1002) {
          continue;
        }
        this.jdField_a_of_type_JavaLangString = "10";
        a(this.jdField_a_of_type_Owp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
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
  
  public void a(nlt paramnlt, AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if (paramnlt == null) {
      this.jdField_a_of_type_Nlt = new nlt();
    }
    this.jdField_a_of_type_Nlt.d = paramAdvertisementInfo.mImaxVideoUrl;
    if ((jdField_a_of_type_Long == -1L) || (System.currentTimeMillis() - jdField_a_of_type_Long > 1000L) || (a(paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2)))
    {
      a(a());
      jdField_a_of_type_Long = System.currentTimeMillis();
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.mImaxImg)) {
      return;
    }
    this.jdField_g_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    paramnlt = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.getChildCount() == 0) {}
    for (int i1 = 0;; i1 = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.addView(this.jdField_g_of_type_AndroidWidgetImageView, i1, paramnlt);
      this.jdField_g_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      paramnlt = URLDrawable.URLDrawableOptions.obtain();
      paramnlt.mPlayGifImage = true;
      paramnlt.mLoadingDrawable = new ColorDrawable(-16777216);
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramAdvertisementInfo.mImaxImg, paramnlt);
      paramnlt = ((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay();
      paramAdvertisementInfo = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17) {
        paramnlt.getRealMetrics(paramAdvertisementInfo);
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
        paramnlt.getMetrics(paramAdvertisementInfo);
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
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new owl(this, i1, i2));
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
        str1 = nmf.a(paramString1);
      }
    }
    paramString2 = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str1, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qua.jdField_a_of_type_JavaLangString);
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
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout.removeAllViews();
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewClipLayout = null;
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
    qol.a(this.jdField_g_of_type_AndroidWidgetImageView, 8, 300);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.getWindow().setSoftInputMode(17);
    qol.a(paramActivity);
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
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130842358));
        return;
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130842359));
      return;
      getActivity().finish();
    } while (this.jdField_h_of_type_Boolean);
    this.jdField_h_of_type_Boolean = true;
    a(getActivity().app, nmf.t);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_f_of_type_AndroidViewView = ((ViewGroup)qrr.a(2131559949, true, new ViewGroup.LayoutParams(-1, -1)));
    paramLayoutInflater = paramViewGroup.getContext();
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater;
    b(paramLayoutInflater);
    qol.a(getActivity());
    getActivity().getWindow().setFlags(1024, 1024);
    bkur.a(getActivity());
    if (bkur.b()) {
      bkur.c(getActivity());
    }
    if (bkur.b())
    {
      this.n = bkur.b(getActivity());
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      int i1 = paramLayoutInflater.topMargin + this.n;
      paramLayoutInflater.topMargin = i1;
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramLayoutInflater.topMargin = i1;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramLayoutInflater);
    }
    a();
    return this.jdField_f_of_type_AndroidViewView;
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
    qol.a(getActivity());
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing())) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment
 * JD-Core Version:    0.7.0.1
 */
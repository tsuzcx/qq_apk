package com.tencent.biz.pubaccount.readinjoy.ad.view;

import acqy;
import afur;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anni;
import bhhb;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import nxm;
import nxw;
import oat;
import oml;
import omp;
import ono;
import ood;
import opu;
import opz;
import oqi;
import oqk;
import otb;
import otc;
import ote;
import otf;
import otg;
import ryx;
import sfa;
import tyc;
import ubb;

public class ReadInJoyArticleBottomVideoView
  extends ViewBase
  implements View.OnClickListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener, ono
{
  public static long a;
  public static String a;
  private static int jdField_b_of_type_Int = 10000;
  public static long b;
  public static boolean c;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ProteusBannerVideoItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData;
  private ReadInJoyAdVideoGuide jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyArticleBottomVideoView.WeakReferenceRunnable(this, 3);
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private nxm jdField_a_of_type_Nxm;
  protected ote a;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 1;
  private boolean jdField_h_of_type_Boolean;
  private int i;
  private int j;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Long = -1L;
  }
  
  public ReadInJoyArticleBottomVideoView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVafContext.getContext());
    b(paramVafContext.getContext());
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!ood.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      j();
    }
  }
  
  private void B()
  {
    ood.jdField_b_of_type_Boolean = false;
    ood.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_a_of_type_Boolean = false;
    d(a());
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
    }
  }
  
  private Context a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  private void a(long paramLong)
  {
    this.jdField_g_of_type_Int = 2;
    this.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
    this.jdField_e_of_type_Int = 0;
    jdField_b_of_type_Long = paramLong;
    ood.jdField_b_of_type_Boolean = false;
    ood.jdField_c_of_type_Boolean = true;
  }
  
  private void a(View paramView, boolean paramBoolean, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData != null)
    {
      localObject2 = oqk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_b_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        }
      }
      if (localObject1 != null) {
        ((AdvertisementInfo)localObject1).clickPos = paramInt;
      }
      if (!ubb.a(paramView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, (AdvertisementInfo)localObject1)) {}
    }
    else
    {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = ubb.a(paramView.getContext(), (AdvertisementInfo)localObject1, null, 2, paramBoolean, new oml(bool));
      if (localObject2 == null) {
        break;
      }
      ((GdtHandler.Params)localObject2).jdField_f_of_type_Boolean = oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData);
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        l = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
        ((GdtHandler.Params)localObject2).jdField_a_of_type_Long = l;
      }
      if (localObject1 != null) {
        ((AdvertisementInfo)localObject1).setClickPos(paramInt);
      }
      if ((localObject1 != null) && (((AdvertisementInfo)localObject1).isCommentAd()))
      {
        opu.a(paramView.getContext(), l, (AdvertisementInfo)localObject1);
        if (localObject1 != null) {
          ((AdvertisementInfo)localObject1).setClickPos(paramInt);
        }
        ood.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject2;
        if (ood.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
          break label322;
        }
      }
      label322:
      for (l = SystemClock.elapsedRealtime();; l = -2147483648L)
      {
        ood.jdField_a_of_type_Long = l;
        if ((localObject1 != null) && (!((AdvertisementInfo)localObject1).isCommentAd())) {
          nxw.a(new omp().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(BaseApplication.getContext()).a(nxw.jdField_a_of_type_Int).b(nxw.T).a((AdvertisementInfo)localObject1).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData)).d(paramInt).a());
        }
        q();
        return;
        ubb.a((GdtHandler.Params)localObject2, paramView.getContext(), (AdvertisementInfo)localObject1);
        break;
      }
    }
  }
  
  private void a(ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    if (NetworkState.isWifiConn())
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    String str2 = anni.a(2131711821);
    String str1;
    if (bhhb.a() == 1) {
      str1 = anni.a(2131711554);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      return;
      str1 = str2;
      if (paramProteusBannerVideoItemData != null)
      {
        str1 = str2;
        if (paramProteusBannerVideoItemData.jdField_a_of_type_Long > 0L) {
          str1 = ryx.b(paramProteusBannerVideoItemData.jdField_a_of_type_Long) + anni.a(2131711578);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean a(long paramLong)
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && ((jdField_b_of_type_Long == -1L) || (paramLong - jdField_b_of_type_Long > 1000L));
  }
  
  private boolean a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if ((paramProteusBannerVideoItemData1 == null) || (paramProteusBannerVideoItemData2 == null)) {}
    while ((TextUtils.isEmpty(paramProteusBannerVideoItemData1.w)) || (paramProteusBannerVideoItemData1.w.equals(paramProteusBannerVideoItemData2.w))) {
      return false;
    }
    return true;
  }
  
  private int b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isCommentAd())) {
      return nxw.aq;
    }
    return nxw.M;
  }
  
  private void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_d_of_type_AndroidViewView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560050, null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext.getApplicationContext());
    t();
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 408	ood:jdField_a_of_type_Boolean	Z
    //   6: ifeq +18 -> 24
    //   9: getstatic 349	com/tencent/biz/pubaccount/readinjoy/ad/view/ReadInJoyArticleBottomVideoView:jdField_c_of_type_Boolean	Z
    //   12: istore_0
    //   13: iload_0
    //   14: ifne +10 -> 24
    //   17: iconst_1
    //   18: istore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_0
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_0
    //   26: goto -7 -> 19
    //   29: astore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	14	0	bool	boolean
    //   29	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	29	finally
  }
  
  private void c(Context paramContext)
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_Ote = new ote(this);
      AppNetConnInfo.registerConnectionChangeReceiver(paramContext, this.jdField_a_of_type_Ote);
    }
  }
  
  private boolean c()
  {
    return (this.jdField_c_of_type_Int != 0) || (this.jdField_d_of_type_Int != 0) || (this.jdField_f_of_type_Int != 0) || (this.jdField_e_of_type_Int != 0);
  }
  
  private void d(Context paramContext)
  {
    this.jdField_a_of_type_Int = 3;
    j();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (paramContext != null) && (this.jdField_a_of_type_Nxm != null))
    {
      f(paramContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(paramContext);
      Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      otg localotg = new otg(this);
      ((IVideoViewBase)localObject).addViewCallBack(localotg);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, 0);
        localObject = new TVK_UserInfo("", "");
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, nxw.a(this.jdField_a_of_type_Nxm.d), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", sfa.jdField_a_of_type_JavaLangString);
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext.getApplicationContext(), (IVideoViewBase)this.jdField_c_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(localotg);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(localotg);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(localotg);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, this.jdField_a_of_type_Nxm.d, 0L, 0L, (TVK_UserInfo)localObject, localTVK_PlayerVideoInfo);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
        }
      }
    }
  }
  
  private void e(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      TVK_SDKMgr.installPlugin(paramContext.getApplicationContext(), new otc(this));
      return;
    }
    catch (Throwable paramContext)
    {
      acqy.a("ReadInJoyArticleBottomVideoView", "installSDK t==" + paramContext.toString());
    }
  }
  
  private void f(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(paramContext.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new otf(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(0);
  }
  
  private void t()
  {
    if (this.jdField_d_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131380533));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131362786));
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131362787));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131362790);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131362792));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131380599));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_d_of_type_AndroidViewView.findViewById(2131362059));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setAdGuideClickListener(new otb(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_d_of_type_AndroidViewView.findViewById(2131380534));
    this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131380732);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131381354));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    a(false);
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843178);
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = afur.a(50.0F, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
      localLayoutParams.height = afur.a(50.0F, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void v()
  {
    if (NetworkState.isWifiConn())
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void x()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      w();
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(8);
    }
  }
  
  private void y()
  {
    int k;
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Nxm != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      this.jdField_f_of_type_Boolean = true;
      boolean bool = a(this.jdField_a_of_type_Nxm.d, this.jdField_a_of_type_Nxm.d);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleBottomVideoView", 0, "native ad preload cache state: " + bool);
      }
      String str = "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdUin;
      if (bool)
      {
        k = 1;
        oat.a(null, str, "0X80093B8", "0X80093B8", 0, k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId, "", "", "");
      }
    }
    else if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(3);
      x();
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)) {
        break label247;
      }
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_h_of_type_Boolean = false;
      }
      ood.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Int = 4;
      this.jdField_h_of_type_Int = 2;
      j();
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyArticleBottomVideoView", 3, "WebFastProteusViewAdBannerVideoCreator onVideoPrepared isRetry start");
      }
    }
    label247:
    do
    {
      return;
      k = 0;
      break;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        n();
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.i == this.j));
    n();
  }
  
  private void z()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!ood.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Int = 6;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      j();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData == null) {}
    while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_b_of_type_Boolean) {
      return 2;
    }
    return 3;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
  }
  
  public void a()
  {
    j();
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_b_of_type_Boolean) && (ood.jdField_c_of_type_Boolean)) {
      return;
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_d_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext.getApplicationContext()))
    {
      d(paramContext);
      return;
    }
    e(paramContext);
  }
  
  public void a(nxm paramnxm, AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    this.jdField_a_of_type_Nxm = paramnxm;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.hashCode();
    }
    if (paramAdvertisementInfo != null) {
      this.j = paramAdvertisementInfo.hashCode();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData = paramProteusBannerVideoItemData1;
    o();
    u();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide != null) && (paramProteusBannerVideoItemData1 != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setAppInfo(paramProteusBannerVideoItemData1.jdField_d_of_type_Int, paramProteusBannerVideoItemData1.J, paramProteusBannerVideoItemData1.q, paramProteusBannerVideoItemData1.p, opz.g(paramProteusBannerVideoItemData1));
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_a_of_type_Boolean) {
      w();
    }
    for (;;)
    {
      if (((jdField_a_of_type_Long == -1L) || (System.currentTimeMillis() - jdField_a_of_type_Long > 1000L) || (a(paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2))) && (oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), a())))
      {
        a(a());
        jdField_a_of_type_Long = System.currentTimeMillis();
      }
      c(a());
      return;
      a(paramProteusBannerVideoItemData1);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
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
        str1 = nxw.a(paramString1);
      }
    }
    paramString2 = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str1, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", sfa.jdField_a_of_type_JavaLangString);
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int m = arrayOfString.length;
    int k = 0;
    while (k < m)
    {
      String str2 = arrayOfString[k];
      int n = localTVK_ICacheMgr.isVideoCached(a(), paramString1, paramString2, localTVK_PlayerVideoInfo, str2);
      if ((n == 2) || (n == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleBottomVideoView", 0, str1 + " checkIsVideoCached(), definition = " + str2 + ", cacheStatus = " + n + ", return TRUE");
        }
        return true;
      }
      k += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleBottomVideoView", 0, str1 + " checkIsVideoCached() return FALSE");
    }
    return false;
  }
  
  public void b()
  {
    y();
  }
  
  public void c()
  {
    z();
  }
  
  public void d()
  {
    d(a());
  }
  
  public void e()
  {
    l();
  }
  
  public void f()
  {
    C();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public int getComMeasuredHeight()
  {
    if (this.jdField_d_of_type_AndroidViewView != null) {
      return this.jdField_d_of_type_AndroidViewView.getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (this.jdField_d_of_type_AndroidViewView != null) {
      return this.jdField_d_of_type_AndroidViewView.getMeasuredWidth();
    }
    return 0;
  }
  
  public View getNativeView()
  {
    return this.jdField_d_of_type_AndroidViewView;
  }
  
  public void h()
  {
    if (!oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), a())) {
      z();
    }
  }
  
  public void i()
  {
    if (oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), a()))
    {
      A();
      return;
    }
    z();
  }
  
  public void j()
  {
    if ((Looper.myLooper() != Looper.getMainLooper()) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyArticleBottomVideoView.WeakReferenceRunnable(this, 1));
    }
    do
    {
      return;
      switch (this.jdField_a_of_type_Int)
      {
      case 7: 
      default: 
        return;
      case 1: 
      case 2: 
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      case 6: 
        v();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (ood.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          long l = System.currentTimeMillis();
          if (!a(l)) {
            break;
          }
          this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          if (c()) {
            nxw.a(new omp().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(a()).a(nxw.jdField_f_of_type_Int).b(b()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nxw.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, (int)this.jdField_c_of_type_Long, nxw.aH, 0)).a());
          }
          a(l);
          return;
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
      case 4: 
      case 5: 
        x();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      case 3: 
      case 8: 
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        o();
      }
    } while (this.jdField_a_of_type_Int != 8);
    nxw.a(new omp().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(a()).a(nxw.jdField_f_of_type_Int).b(b()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nxw.a(0, 0, 0, 0, 0, 0, (int)this.jdField_c_of_type_Long, nxw.aH, 2)).a());
    return;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isCommentAd()))
    {
      w();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(0);
      return;
    }
    B();
  }
  
  public void k()
  {
    o();
    l();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Ote != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Ote);
      this.jdField_a_of_type_Ote = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    a(true);
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void l()
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
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyArticleBottomVideoView.WeakReferenceRunnable(this, 5));
        }
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide = null;
  }
  
  public void m() {}
  
  public void n()
  {
    if (!oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), a()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyArticleBottomVideoView", 0, "net switch:" + oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), a()));
      }
      QLog.d("ReadInJoyArticleBottomVideoView", 1, "net switch:" + oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), a()));
    }
    for (int k = 0;; k = 1)
    {
      if (!oqk.a(this.jdField_a_of_type_ComTencentImageURLImageView))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyArticleBottomVideoView", 0, "is auto play:" + oqk.a(this.jdField_a_of_type_ComTencentImageURLImageView));
        }
        QLog.d("ReadInJoyArticleBottomVideoView", 1, "is auto play:" + oqk.a(this.jdField_a_of_type_ComTencentImageURLImageView));
        k = 0;
      }
      int m = k;
      if (ood.jdField_b_of_type_Boolean)
      {
        m = k;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData != null)
        {
          m = k;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyArticleBottomVideoView", 0, "isCommentAd:" + ood.jdField_b_of_type_Boolean);
            }
            QLog.d("ReadInJoyArticleBottomVideoView", 1, "isCommentAd:" + ood.jdField_b_of_type_Boolean);
            m = 0;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyArticleBottomVideoView", 0, " mVideoPlayer:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer + " deltaTime:" + (System.currentTimeMillis() - jdField_a_of_type_Long));
      }
      if (m != 0)
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
          break label436;
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        this.jdField_a_of_type_Int = 4;
        this.jdField_h_of_type_Int = 2;
        j();
        ood.jdField_b_of_type_Boolean = true;
        this.jdField_e_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.i("WebFastProteusViewAdBannerVideoCreator", 3, "WebFastProteusViewAdBannerVideoCreator startVideo state:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
        }
      }
      return;
      label436:
      this.jdField_a_of_type_Boolean = true;
      jdField_a_of_type_Long = System.currentTimeMillis();
      a(a());
      return;
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {}
    for (;;)
    {
      return;
      if ((!this.jdField_h_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_a_of_type_Boolean))
      {
        v();
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      try
      {
        if ((this.jdField_a_of_type_Nxm != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Nxm.e)))
        {
          jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Nxm.e;
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "fast_web";
          localObject = URLDrawable.getDrawable(tyc.a(jdField_a_of_type_JavaLangString, 4), (URLDrawable.URLDrawableOptions)localObject);
          if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
            ((URLDrawable)localObject).restartDownload();
          }
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int k = 5;
    if (a()) {
      k = 6;
    }
    a(paramView, false, k);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.measure(paramInt1, paramInt2);
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_Int = 9;
    ood.jdField_c_of_type_Boolean = true;
    j();
    r();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_a_of_type_Boolean = true;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleBottomVideoView", 0, "error msg = " + paramString);
    }
    this.jdField_a_of_type_Int = 8;
    j();
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyArticleBottomVideoView", 3, "WebFastProteusViewAdBannerVideoCreator start video error");
    }
    return false;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if ((Looper.myLooper() != Looper.getMainLooper()) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyArticleBottomVideoView.WeakReferenceRunnable(this, 2));
      return;
    }
    y();
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.a();
    }
  }
  
  public void q()
  {
    long l = System.currentTimeMillis();
    if (a(l))
    {
      this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_Int = 6;
      if (c()) {
        nxw.a(new omp().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(a()).a(nxw.jdField_f_of_type_Int).b(b()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nxw.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, (int)this.jdField_c_of_type_Long, nxw.aH, 0)).a());
      }
      a(l);
      j();
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_d_of_type_Int = ((int)this.jdField_c_of_type_Long);
        this.jdField_f_of_type_Int = 1;
        nxw.a(new omp().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(a()).a(nxw.jdField_f_of_type_Int).b(b()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nxw.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, (int)this.jdField_c_of_type_Long, nxw.aH, 0)).a());
        this.jdField_c_of_type_Int = 0;
        this.jdField_e_of_type_Int = 1;
        this.jdField_f_of_type_Int = 0;
        this.jdField_e_of_type_Boolean = true;
      }
    }
  }
  
  public void s()
  {
    if (!ood.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = 9;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      j();
      ood.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView
 * JD-Core Version:    0.7.0.1
 */
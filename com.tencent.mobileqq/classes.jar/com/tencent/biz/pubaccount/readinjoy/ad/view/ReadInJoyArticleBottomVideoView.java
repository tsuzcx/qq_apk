package com.tencent.biz.pubaccount.readinjoy.ad.view;

import ajyc;
import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bbwc;
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
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import nlt;
import nmf;
import noo;
import nyc;
import nyg;
import nyr;
import nze;
import oal;
import oat;
import oav;
import ocp;
import ocq;
import ocs;
import oct;
import ocu;
import qol;
import qua;
import sfd;
import sht;
import yxs;

public class ReadInJoyArticleBottomVideoView
  extends ViewBase
  implements View.OnClickListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener, nyr
{
  public static long a;
  public static String a;
  public static long b;
  public static boolean b;
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
  private nlt jdField_a_of_type_Nlt;
  protected ocs a;
  public boolean a;
  private int jdField_b_of_type_Int = 10000;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 1;
  private boolean jdField_g_of_type_Boolean;
  private int h = 1;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Long = -1L;
  }
  
  public ReadInJoyArticleBottomVideoView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVafContext.getContext());
    b(paramVafContext.getContext());
  }
  
  private void A()
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
  
  private void a(View paramView, boolean paramBoolean, int paramInt)
  {
    AdvertisementInfo localAdvertisementInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData != null)
    {
      localAdvertisementInfo = oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData);
      if (!sht.a((Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, localAdvertisementInfo)) {}
    }
    else
    {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      localAdvertisementInfo.setClickPos(paramInt);
      GdtHandler.Params localParams = sht.a((Activity)paramView.getContext(), localAdvertisementInfo, null, 2, paramBoolean, new nyc(bool));
      if (localParams == null) {
        break;
      }
      localParams.jdField_f_of_type_Boolean = oat.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData);
      sht.a(localParams, paramView.getContext(), localAdvertisementInfo);
      nze.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = localParams;
      if (nze.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
      for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
      {
        nze.jdField_a_of_type_Long = l;
        oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData);
        p();
        return;
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
    String str2 = ajyc.a(2131713047);
    String str1;
    if (bbwc.a() == 1) {
      str1 = ajyc.a(2131712780);
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
          str1 = qol.b(paramProteusBannerVideoItemData.jdField_a_of_type_Long) + ajyc.a(2131712804);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if ((paramProteusBannerVideoItemData1 == null) || (paramProteusBannerVideoItemData2 == null)) {}
    while ((TextUtils.isEmpty(paramProteusBannerVideoItemData1.w)) || (paramProteusBannerVideoItemData1.w.equals(paramProteusBannerVideoItemData2.w))) {
      return false;
    }
    return true;
  }
  
  private void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_d_of_type_AndroidViewView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559809, null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext.getApplicationContext());
    s();
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 316	nze:jdField_a_of_type_Boolean	Z
    //   6: ifeq +18 -> 24
    //   9: getstatic 266	com/tencent/biz/pubaccount/readinjoy/ad/view/ReadInJoyArticleBottomVideoView:jdField_b_of_type_Boolean	Z
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
    if (!this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_Ocs = new ocs(this);
      AppNetConnInfo.registerConnectionChangeReceiver(paramContext, this.jdField_a_of_type_Ocs);
    }
  }
  
  private void d(Context paramContext)
  {
    this.jdField_a_of_type_Int = 3;
    j();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (paramContext != null) && (this.jdField_a_of_type_Nlt != null))
    {
      f(paramContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(paramContext);
      Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      ocu localocu = new ocu(this);
      ((IVideoViewBase)localObject).addViewCallBack(localocu);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, 0);
        localObject = new TVK_UserInfo("", "");
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, nmf.a(this.jdField_a_of_type_Nlt.d), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qua.jdField_a_of_type_JavaLangString);
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext.getApplicationContext(), (IVideoViewBase)this.jdField_c_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(localocu);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(localocu);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(localocu);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, this.jdField_a_of_type_Nlt.d, 0L, 0L, (TVK_UserInfo)localObject, localTVK_PlayerVideoInfo);
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
      TVK_SDKMgr.installPlugin(paramContext.getApplicationContext(), new ocq(this));
      return;
    }
    catch (Throwable paramContext)
    {
      yxs.a("ReadInJoyArticleBottomVideoView", "installSDK t==" + paramContext.toString());
    }
  }
  
  private void f(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(paramContext.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new oct(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(0);
  }
  
  private void s()
  {
    if (this.jdField_d_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131378885));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131362651));
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131362652));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131362655);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131362657));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131378938));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_d_of_type_AndroidViewView.findViewById(2131362001));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setAdGuideClickListener(new ocp(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_d_of_type_AndroidViewView.findViewById(2131378886));
    this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131379036);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131379543));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    a(false);
  }
  
  private void t()
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
  
  private void u()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      u();
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(8);
    }
  }
  
  private void w()
  {
    String str;
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Nlt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      this.jdField_e_of_type_Boolean = true;
      boolean bool = a(this.jdField_a_of_type_Nlt.d, this.jdField_a_of_type_Nlt.d);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleBottomVideoView", 0, "native ad preload cache state: " + bool);
      }
      str = "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdUin;
      if (!bool) {
        break label242;
      }
    }
    label242:
    for (int i = 1;; i = 0)
    {
      noo.a(null, str, "0X80093B8", "0X80093B8", 0, i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId, "", "", "");
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(3);
        v();
        if ((this.jdField_a_of_type_Boolean) || (this.jdField_g_of_type_Boolean))
        {
          if (this.jdField_g_of_type_Boolean) {
            this.jdField_g_of_type_Boolean = false;
          }
          nze.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
          this.jdField_a_of_type_Int = 4;
          this.h = 2;
          j();
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyArticleBottomVideoView", 3, "WebFastProteusViewAdBannerVideoCreator onVideoPrepared isRetry start");
          }
        }
      }
      return;
    }
  }
  
  private void x()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!nze.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Int = 6;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      j();
    }
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!nze.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      j();
    }
  }
  
  private void z()
  {
    nze.jdField_b_of_type_Boolean = false;
    nze.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_a_of_type_Boolean = false;
    d(a());
  }
  
  public void a()
  {
    j();
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {}
    while (nze.jdField_c_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_c_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext.getApplicationContext()))
    {
      d(paramContext);
      return;
    }
    e(paramContext);
  }
  
  public void a(nlt paramnlt, AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    this.jdField_a_of_type_Nlt = paramnlt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData = paramProteusBannerVideoItemData1;
    o();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide != null) && (paramProteusBannerVideoItemData1 != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setAppInfo(paramProteusBannerVideoItemData1.jdField_d_of_type_Int, paramProteusBannerVideoItemData1.J, paramProteusBannerVideoItemData1.q, paramProteusBannerVideoItemData1.p, oal.f(paramProteusBannerVideoItemData1));
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_a_of_type_Boolean) {
      u();
    }
    for (;;)
    {
      if (((jdField_a_of_type_Long == -1L) || (System.currentTimeMillis() - jdField_a_of_type_Long > 1000L) || (a(paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2))) && (oat.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), 2)))
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
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      int k = localTVK_ICacheMgr.isVideoCached(a(), paramString1, paramString2, localTVK_PlayerVideoInfo, str2);
      if ((k == 2) || (k == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleBottomVideoView", 0, str1 + " checkIsVideoCached(), definition = " + str2 + ", cacheStatus = " + k + ", return TRUE");
        }
        return true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleBottomVideoView", 0, str1 + " checkIsVideoCached() return FALSE");
    }
    return false;
  }
  
  public void b()
  {
    w();
  }
  
  public void c()
  {
    x();
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
    A();
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
    if (!oat.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), 2)) {
      x();
    }
  }
  
  public void i()
  {
    if (oat.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), 2))
    {
      y();
      return;
    }
    x();
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
        t();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (nze.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          nmf.a(new nyg().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(a()).a(nmf.jdField_f_of_type_Int).b(nmf.K).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nmf.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.h, (int)this.jdField_c_of_type_Long, nmf.aD, 0)).a());
          this.jdField_g_of_type_Int = 2;
          this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          this.jdField_e_of_type_Int = 0;
          return;
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
      case 4: 
      case 5: 
        v();
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
    nmf.a(new nyg().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(a()).a(nmf.jdField_f_of_type_Int).b(nmf.K).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nmf.a(0, 0, 0, 0, 0, 0, (int)this.jdField_c_of_type_Long, nmf.aD, 2)).a());
    return;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton)
    {
      u();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(0);
      return;
    }
    z();
  }
  
  public void k()
  {
    o();
    l();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Ocs != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Ocs);
      this.jdField_a_of_type_Ocs = null;
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
    this.jdField_f_of_type_Boolean = false;
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
    if ((oat.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), 2)) && (oav.a(this.jdField_a_of_type_ComTencentImageURLImageView)) && (!nze.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebFastProteusViewAdBannerVideoCreator", 3, "WebFastProteusViewAdBannerVideoCreator is auto play :" + oav.a(this.jdField_a_of_type_ComTencentImageURLImageView) + " isVideoAlreadyStart:" + nze.jdField_b_of_type_Boolean + " net switch:" + oat.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData, a(), 2) + " mVideoPlayer:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer + " deltaTime:" + (System.currentTimeMillis() - jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        break label215;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Int = 4;
      this.h = 2;
      j();
      nze.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.i("WebFastProteusViewAdBannerVideoCreator", 3, "WebFastProteusViewAdBannerVideoCreator startVideo state:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
      }
    }
    return;
    label215:
    this.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Long = System.currentTimeMillis();
    a(a());
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {}
    for (;;)
    {
      return;
      if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusBannerVideoItemData.jdField_a_of_type_Boolean))
      {
        t();
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      try
      {
        if ((this.jdField_a_of_type_Nlt != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Nlt.e)))
        {
          jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Nlt.e;
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "fast_web";
          localObject = URLDrawable.getDrawable(sfd.a(jdField_a_of_type_JavaLangString, 4), (URLDrawable.URLDrawableOptions)localObject);
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
    int i = 5;
    if (a()) {
      i = 6;
    }
    a(paramView, false, i);
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
    nze.jdField_c_of_type_Boolean = true;
    j();
    q();
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
    w();
  }
  
  public void p()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && ((jdField_b_of_type_Long == -1L) || (l - jdField_b_of_type_Long > 1000L)))
    {
      this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      nmf.a(new nyg().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(a()).a(nmf.jdField_f_of_type_Int).b(nmf.K).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nmf.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.h, (int)this.jdField_c_of_type_Long, nmf.aD, 0)).a());
      this.jdField_g_of_type_Int = 2;
      this.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_e_of_type_Int = 0;
      jdField_b_of_type_Long = l;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      nze.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Int = ((int)this.jdField_c_of_type_Long);
        this.jdField_f_of_type_Int = 1;
        nmf.a(new nyg().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(a()).a(nmf.jdField_f_of_type_Int).b(nmf.K).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(nmf.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.h, (int)this.jdField_c_of_type_Long, nmf.aD, 0)).a());
        this.jdField_c_of_type_Int = 0;
        this.jdField_e_of_type_Int = 1;
        this.jdField_f_of_type_Int = 0;
        this.jdField_d_of_type_Boolean = true;
      }
    }
  }
  
  public void r()
  {
    if (!nze.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = 9;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      j();
      nze.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView
 * JD-Core Version:    0.7.0.1
 */
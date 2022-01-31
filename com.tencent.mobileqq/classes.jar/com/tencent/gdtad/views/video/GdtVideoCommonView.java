package com.tencent.gdtad.views.video;

import aaqj;
import aase;
import aatc;
import aatp;
import aatt;
import aatu;
import aaup;
import aauq;
import aaur;
import aaus;
import aaut;
import aauu;
import aauv;
import aauw;
import aaux;
import aepi;
import alud;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import arri;
import asyf;
import bcyz;
import bdin;
import com.tencent.ad.tangram.Ad;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import noy;

public class GdtVideoCommonView
  extends RelativeLayout
  implements aatu, View.OnClickListener, SeekBar.OnSeekBarChangeListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private aaqj jdField_a_of_type_Aaqj;
  private aatt jdField_a_of_type_Aatt;
  private aaus jdField_a_of_type_Aaus;
  private aaut jdField_a_of_type_Aaut;
  private aauu jdField_a_of_type_Aauu;
  private aauv jdField_a_of_type_Aauv;
  private aaux jdField_a_of_type_Aaux;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private GdtVideoData jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aaur(this);
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtVideoCommonView.6(this);
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<aauw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = 10000;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new GdtVideoCommonView.7(this);
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Runnable jdField_c_of_type_JavaLangRunnable = new GdtVideoCommonView.8(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private volatile boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = -16777216;
  private boolean jdField_l_of_type_Boolean;
  private boolean m = true;
  private boolean n = true;
  private boolean o;
  
  public GdtVideoCommonView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559141, this);
    k();
  }
  
  public GdtVideoCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559141, this);
    k();
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_Aatt != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
      }
      this.jdField_a_of_type_Aatt.a(this.jdField_a_of_type_JavaLangRefWeakReference);
      aase.a("GdtVideoCommonView", "playBindController " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void a(long paramLong)
  {
    aase.a("GdtVideoCommonView", "playVideo startElapsed -->" + paramLong + "|" + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (this.jdField_a_of_type_Int != 3))
    {
      this.jdField_a_of_type_Int = 3;
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      String str2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getTencent_video_id();
      localTVK_PlayerVideoInfo.setVid(str2);
      String str1 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getUrl();
      if (asyf.a(str2)) {
        str1 = asyf.a(str2);
      }
      aase.a("GdtVideoCommonView", "playVideo url -->" + str1);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, str1, paramLong, 0L, localTVK_PlayerVideoInfo);
      if (this.jdField_a_of_type_Int == 8) {
        aase.a("GdtVideoCommonView", "playVideo STATE_ERROR return -->" + paramLong);
      }
    }
    else
    {
      return;
    }
    e();
  }
  
  private void a(Context paramContext)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_c_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      c(paramContext);
      return;
    }
    b(paramContext);
  }
  
  private void a(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aauw)localIterator.next()).a(paramView);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    aase.a("GdtVideoCommonView", "letsShowOff " + paramBoolean + " " + this.jdField_a_of_type_JavaLangString + " mVideoState " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int != 5) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
    for (;;)
    {
      t();
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    aase.a("GdtVideoCommonView", "setStateOfMediaSound volume =" + paramInt + " viewReusmed " + paramBoolean1 + " isFromVolumeChanged " + paramBoolean2 + " isSilentMode = " + this.jdField_b_of_type_Boolean + ", isVolumOpen = " + this.n + ", hasNotifyCompleted = " + this.o);
    if ((!paramBoolean1) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)) {
      return;
    }
    if (paramInt > 0) {
      if ((!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute()) || (paramBoolean2))
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840210);
        this.n = true;
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131705617));
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int != 6) && (this.jdField_a_of_type_Int != 8) && (this.jdField_a_of_type_Int != 7)) {
        b(this.n);
      }
      t();
      return;
      this.n = false;
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840209);
      continue;
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840209);
      this.n = false;
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131705624));
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      TVK_SDKMgr.installPlugin(paramContext, new aauq(this, paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      aase.a("GdtVideoCommonView", "installSDK t==" + paramContext.toString() + " " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aase.a("GdtVideoCommonView", "[requestSystemAudioFocus] gain is called!");
      this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
      return;
    }
    aase.a("GdtVideoCommonView", "[requestSystemAudioFocus] release is called!");
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
  }
  
  private void c(Context paramContext)
  {
    aase.a("GdtVideoCommonView", "initVideo " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      this.jdField_d_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext));
      if (this.jdField_d_of_type_AndroidViewView != null)
      {
        setBackgroundColor(this.jdField_l_of_type_Int);
        this.jdField_d_of_type_AndroidViewView.setBackgroundColor(this.jdField_l_of_type_Int);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        addView(this.jdField_d_of_type_AndroidViewView, 0);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)this.jdField_d_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
          break label154;
        }
        aase.d("GdtVideoCommonView", "initVideo return mVideoPlayer == null");
      }
    }
    return;
    label154:
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop())
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(true);
      aase.a("GdtVideoCommonView", "initVideo isSilentMode = " + this.jdField_b_of_type_Boolean + ", isVolumOpen = " + this.n);
      if (this.jdField_b_of_type_Boolean) {
        this.n = false;
      }
      paramContext = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      if (this.n) {
        break label325;
      }
    }
    label325:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setOutputMute(bool);
      b(this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3), true, false);
      a(this.jdField_b_of_type_Long);
      return;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
      break;
    }
  }
  
  private void k()
  {
    if (bdin.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      aase.a("GdtVideoCommonView", "netType " + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131367108));
      this.jdField_e_of_type_AndroidViewView = findViewById(2131369793);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131365982);
      this.jdField_g_of_type_AndroidViewView = findViewById(2131367112);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367104));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367102));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367103));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372339));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131376325));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131376327));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378220));
      int i1 = aatp.a(5.0F, getResources());
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367111));
      aatp.a(this.jdField_e_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367109));
      aatp.a(this.jdField_a_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364327));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131367107);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367105));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131367106);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getContext().getSystemService("audio"));
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
      this.jdField_a_of_type_Aaqj = new aaqj(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Aaqj.a();
      this.jdField_a_of_type_Aaqj.a(new aaup(this));
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_Aaus = new aaus(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aaus, localIntentFilter);
      this.jdField_a_of_type_Aauu = new aauu(this, null);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aauu, localIntentFilter);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131362700);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367079));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131367077));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367080));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367078));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      c();
      return;
      if (bdin.d(this.jdField_a_of_type_AndroidContentContext)) {
        this.jdField_c_of_type_Int = 2;
      }
    }
  }
  
  private void l()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || ((localObject instanceof QQAppInterface)) || (AppSetting.jdField_c_of_type_Boolean)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = (AccessibilityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          bool1 = true;
          AppSetting.jdField_c_of_type_Boolean = bool1;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      boolean bool1 = false;
    }
  }
  
  private void m()
  {
    if ((!b()) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null) && (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getProductType() != 19))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      r();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      n();
    }
    for (;;)
    {
      t();
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      r();
      if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene() == 7) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
      {
        d();
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null))
    {
      aase.a("GdtVideoCommonView", "updateDownloadBtnLable " + this.jdField_a_of_type_JavaLangString);
      if (!(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd() instanceof GdtAd)) {
        break label102;
      }
    }
    label102:
    for (GdtAd localGdtAd = (GdtAd)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd(); localGdtAd == null; localGdtAd = null)
    {
      aase.d("GdtVideoCommonView", "updateDownloadBtnLable gdtAd == null " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (localGdtAd.isAppProductType())
    {
      String str = localGdtAd.getAppPackageName();
      if (noy.a(this.jdField_a_of_type_AndroidContentContext, str))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(alud.a(2131705622));
        return;
      }
      if (aatc.a(this.jdField_a_of_type_AndroidContentContext, localGdtAd.getAppPackageName()))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(alud.a(2131705614));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(alud.a(2131705618));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(alud.a(2131705625));
  }
  
  private void o()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.5(this));
      return;
    }
    aase.a("GdtVideoCommonView", "doStartPlay " + this.jdField_a_of_type_JavaLangString);
    A();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      aase.d("GdtVideoCommonView", "doStartPlay return mVideoPlayer == null");
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      aase.d("GdtVideoCommonView", "doStartPlay isSilentMode is true");
      this.n = false;
    }
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (!this.n) {}
    for (boolean bool = true;; bool = false)
    {
      localTVK_IMediaPlayer.setOutputMute(bool);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Int = 5;
      e();
      b(this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3), true, false);
      return;
    }
  }
  
  private void p()
  {
    if (a())
    {
      aase.a("GdtVideoCommonView", "pauseVideoInternal " + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_Int = 6;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      e();
    }
    for (;;)
    {
      b(false);
      return;
      aase.a("GdtVideoCommonView", "pauseVideoInternal return " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void q()
  {
    aase.a("GdtVideoCommonView", "resumeVideByNet netType " + this.jdField_c_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      arri.a(2131689627);
      this.jdField_a_of_type_Int = 8;
      e();
      return;
    case 1: 
      o();
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      o();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  private void r()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void s()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aatt != null) {
      this.jdField_a_of_type_Aatt.jdField_a_of_type_AndroidViewView = this;
    }
  }
  
  private void t()
  {
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      findViewById(2131369635).setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.10(this));
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      aase.d("GdtVideoCommonView", "checkIsCompleted return mVideoPlayer == null");
    }
    long l1;
    do
    {
      return;
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    } while ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) || (!this.jdField_a_of_type_Boolean));
    if (Math.abs(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() - l1) < 1000L) {
      if (!this.o) {
        z();
      }
    }
    for (this.o = true;; this.o = false)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtVideoCommonView.11(this), 300L);
      return;
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Aaux != null) {
      this.jdField_a_of_type_Aaux.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
    }
    b(false);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Aaux != null)
    {
      if (this.jdField_d_of_type_Int <= 0) {
        break label74;
      }
      this.jdField_a_of_type_Aaux.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
    for (;;)
    {
      v();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ((aauw)localIterator.next()).b(this);
        continue;
        label74:
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
          break label90;
        }
        aase.d("GdtVideoCommonView", "notifyStarted return mVideoPlayer == null");
      }
      return;
      label90:
      this.jdField_a_of_type_Aaux.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    }
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_Aaux != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.jdField_a_of_type_Aaux.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aauw)localIterator.next()).c(this);
    }
    b(false);
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Aaux != null) {
      this.jdField_a_of_type_Aaux.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aauw)localIterator.next()).d(this);
    }
    b(false);
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
    aase.c("GdtVideoCommonView", "play from OUT_CONTROL " + this.jdField_a_of_type_JavaLangString);
    h();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" doResumeVideo " + paramInt);
    localStringBuilder.append(" isViewResume " + paramBoolean1);
    localStringBuilder.append(" stopPlayByUser " + paramBoolean2);
    localStringBuilder.append(" mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    aase.a("GdtVideoCommonView", localStringBuilder.toString());
    if ((paramBoolean2) || (!paramBoolean1)) {
      return;
    }
    if ((this.jdField_a_of_type_Aatt != null) && (this.jdField_a_of_type_Aatt.jdField_a_of_type_AndroidViewView != this))
    {
      aase.a("GdtVideoCommonView", "returned FocusedVideo " + this.jdField_a_of_type_Aatt.jdField_a_of_type_AndroidViewView + "!=this " + hashCode());
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    default: 
      return;
    }
    q();
  }
  
  public void a(aauw paramaauw)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramaauw)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaauw);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Int == 5);
  }
  
  public void b()
  {
    aase.c("GdtVideoCommonView", "pause from OUT_CONTROL " + this.jdField_a_of_type_JavaLangString);
    f();
  }
  
  public boolean b()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public void c()
  {
    l();
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131705626));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription(alud.a(2131705627));
    }
  }
  
  public void d()
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    s();
    if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 4))
    {
      a(2, this.jdField_a_of_type_Boolean, false);
      return;
    }
    a(this.jdField_b_of_type_Long);
  }
  
  public void e()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.2(this));
      return;
    }
    aase.a("GdtVideoCommonView", "updateView " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131705619));
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      r();
    case 3: 
    case 5: 
    case 8: 
    case 7: 
      for (;;)
      {
        t();
        return;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        r();
        continue;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_Boolean = false;
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        r();
        a(false);
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
        x();
        continue;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        r();
        w();
        continue;
        m();
        z();
      }
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      r();
      y();
      break;
      if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      }
    }
  }
  
  public void f()
  {
    aase.a("GdtVideoCommonView", "pauseVideo " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
    p();
  }
  
  public void g()
  {
    this.jdField_f_of_type_Boolean = true;
    p();
  }
  
  public void h()
  {
    aase.a("GdtVideoCommonView", "resumeVideo " + this.jdField_a_of_type_JavaLangString);
    s();
    a(1, this.jdField_a_of_type_Boolean, this.jdField_f_of_type_Boolean);
    if (this.jdField_j_of_type_Boolean) {
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(3846);
    }
    n();
  }
  
  public void i()
  {
    aase.a("GdtVideoCommonView", "releaseMediaPlayer");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void j()
  {
    aase.a("GdtVideoCommonView", "onDestroy");
    i();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Aaqj != null) {
      this.jdField_a_of_type_Aaqj.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Aaus != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aaus);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Aauu != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aauu);
    }
    if (this.jdField_a_of_type_Aaux != null) {
      this.jdField_a_of_type_Aaux = null;
    }
    if (this.jdField_a_of_type_Aatt != null)
    {
      this.jdField_a_of_type_Aatt.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Aatt = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_d_of_type_Long < 350L) {
      aase.a("GdtVideoCommonView", "onClick too fast not allowed  " + this.jdField_a_of_type_JavaLangString);
    }
    label253:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_d_of_type_Long = l1;
            switch (paramView.getId())
            {
            default: 
              return;
            case 2131364327: 
              aase.a("GdtVideoCommonView", "onClick  closeBtn exitFullScreen " + this.jdField_j_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
              if (!this.jdField_j_of_type_Boolean) {
                break label463;
              }
            }
          } while (this.jdField_a_of_type_Aauv == null);
          this.jdField_a_of_type_Aauv.a();
          return;
          int i1;
          if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)
          {
            i1 = 1;
            if (i1 != 0) {
              break label253;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            a(bool);
            a(paramView);
            return;
            i1 = 0;
            break;
          }
          aase.a("GdtVideoCommonView", "onClick  gdt_video_center_play mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
          d();
          return;
          aase.a("GdtVideoCommonView", "onClick  gdt_video_center_pause mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
          g();
          return;
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
          {
            aase.d("GdtVideoCommonView", "gdt_video_volume_switch click return mVideoPlayer == null");
            return;
          }
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute())
          {
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
            b(1, true, false);
            return;
          }
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
          b(0, true, false);
          return;
          a(this.jdField_b_of_type_Long);
          return;
        } while (this.jdField_a_of_type_Aauv == null);
        if (this.jdField_j_of_type_Boolean)
        {
          this.jdField_a_of_type_Aauv.a();
          return;
        }
        this.jdField_a_of_type_Aauv.b();
        return;
        d();
        return;
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      paramView = (Activity)this.jdField_a_of_type_AndroidContentContext;
      paramView.finish();
      paramView.overridePendingTransition(17432576, 17432577);
      return;
      aase.a("GdtVideoCommonView", "click playagain mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      d();
      return;
      aase.a("GdtVideoCommonView", "click download mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    } while ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)));
    label463:
    paramView = (Activity)this.jdField_a_of_type_AndroidContentContext;
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = 7;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd());
    localParams.jdField_a_of_type_Boolean = false;
    localParams.jdField_b_of_type_Boolean = true;
    localParams.jdField_a_of_type_JavaLangClass = null;
    localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
    GdtHandler.a(localParams);
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_Int = 7;
    e();
    aase.a("GdtVideoCommonView", "onCompletion" + this.jdField_a_of_type_Int);
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    aase.a("GdtVideoCommonView", "onError errorType " + paramInt1 + " errorCode " + paramInt2);
    this.jdField_a_of_type_Int = 8;
    if ((this.jdField_a_of_type_Aaut != null) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_Aaut.a(false);
    }
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = true;
      if (this.jdField_a_of_type_Aaux != null) {
        this.jdField_a_of_type_Aaux.c(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
      }
    }
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, alud.a(2131705615), 0).show();
    e();
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    this.jdField_c_of_type_Long = paramTVK_NetVideoInfo.getFileSize();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    aase.a("GdtVideoCommonView", "onNetVideoInfo size:" + this.jdField_c_of_type_Long + " hasShowTips " + this.jdField_k_of_type_Boolean);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(aatp.a(paramInt * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    aase.a("GdtVideoCommonView", "onStartTrackingTouch " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    aase.a("GdtVideoCommonView", "onStopTrackingTouch " + this.jdField_a_of_type_Int);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Int = ((int)(paramSeekBar.getProgress() * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    s();
    if ((this.jdField_a_of_type_Int < 4) || (this.jdField_a_of_type_Int > 6))
    {
      a(this.jdField_d_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      aase.d("GdtVideoCommonView", "onStopTrackingTouch return mVideoPlayer == null");
      return;
    }
    if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 4))
    {
      if ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6)) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      }
      A();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_Int = 5;
      e();
      return;
    }
    aase.a("GdtVideoCommonView", "onStopTrackingTouch no answer " + this.jdField_a_of_type_Int);
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    aase.a("GdtVideoCommonView", "onVideoPrepared " + this.jdField_a_of_type_Int + " isViewResume " + this.jdField_a_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Aaut != null) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_Aaut.a(true);
    }
    if ((this.jdField_a_of_type_Long < 0L) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() <= 0L) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setDurationMillis(this.jdField_a_of_type_Long);
      }
      if ((this.jdField_a_of_type_Long < 1000L) && (!this.jdField_i_of_type_Boolean))
      {
        this.jdField_i_of_type_Boolean = true;
        aase.a("GdtVideoCommonView", "Video error for reason:<1s ");
        if (this.jdField_a_of_type_Aaux != null) {
          this.jdField_a_of_type_Aaux.c(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.4(this));
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      paramTVK_IMediaPlayer = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramTVK_IMediaPlayer.hasNext()) {
        ((aauw)paramTVK_IMediaPlayer.next()).a(this);
      }
      this.jdField_a_of_type_Int = 4;
      a(3, this.jdField_a_of_type_Boolean, this.jdField_f_of_type_Boolean);
    }
  }
  
  public void setData(GdtVideoData paramGdtVideoData, aatt paramaatt)
  {
    this.jdField_a_of_type_Aatt = paramaatt;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData = paramGdtVideoData;
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isDirectPlay();
    this.jdField_l_of_type_Int = paramGdtVideoData.getVideoDefaultBackgroundColor();
    this.jdField_l_of_type_Boolean = paramGdtVideoData.isForceNotShowControllerView();
    this.jdField_b_of_type_Long = paramGdtVideoData.getStartPositionMillis();
    this.n = paramGdtVideoData.isVolumOpen();
    boolean bool;
    if (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() != 2) {
      bool = true;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      a(this.jdField_a_of_type_AndroidContentContext);
      if (!TextUtils.isEmpty(paramGdtVideoData.getCoverUrl())) {}
      try
      {
        paramaatt = new URL(paramGdtVideoData.getCoverUrl());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.a(paramaatt);
        Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_logo();
        paramaatt = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_image_name();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          Resources localResources = getResources();
          localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130845085);
          localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130845085);
          localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
          int i1 = aepi.a(55.0F, localResources);
          ((URLDrawable)localObject).setTag(bcyz.b(i1, i1, aatp.a(21, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext))));
          ((URLDrawable)localObject).setDecodeHandler(bcyz.c);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        if (!TextUtils.isEmpty(paramaatt)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramaatt);
        }
        if (paramGdtVideoData.needReport()) {
          this.jdField_a_of_type_Aaux = new aaux(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene());
        }
        t();
        return;
        bool = false;
      }
      catch (Exception paramaatt)
      {
        for (;;)
        {
          paramaatt.printStackTrace();
        }
      }
    }
  }
  
  public void setGdtVideoCloseIcon(int paramInt) {}
  
  public void setGdtVideoFcIcon(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setLoadListener(aaut paramaaut)
  {
    this.jdField_a_of_type_Aaut = paramaaut;
  }
  
  public void setOnVideoFullScreen(aauv paramaauv)
  {
    this.jdField_a_of_type_Aauv = paramaauv;
  }
  
  public void setisFullScreen(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_j_of_type_Boolean != paramBoolean)
    {
      this.jdField_j_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label215;
      }
      localObject1 = (Activity)getContext();
      localObject2 = ((Activity)localObject1).getWindow();
      ((Window)localObject2).setFlags(1024, 1024);
      ((Activity)localObject1).setRequestedOrientation(0);
      localObject2 = ((Window)localObject2).getDecorView();
      this.jdField_g_of_type_Int = ((View)localObject2).getSystemUiVisibility();
      ((View)localObject2).setSystemUiVisibility(3846);
      localObject2 = getLayoutParams();
      this.jdField_e_of_type_Int = ((ViewGroup.LayoutParams)localObject2).width;
      this.jdField_f_of_type_Int = ((ViewGroup.LayoutParams)localObject2).height;
      localObject1 = aatp.a((Activity)localObject1);
      int i1 = localObject1[0];
      ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
      ((ViewGroup.LayoutParams)localObject2).height = i1;
      setLayoutParams((ViewGroup.LayoutParams)localObject2);
      setGdtVideoFcIcon(2130841445);
      setGdtVideoCloseIcon(paramInt);
      localObject1 = getParent();
      if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
      {
        localObject1 = (ViewGroup)localObject1;
        this.jdField_h_of_type_Int = ((ViewGroup)localObject1).getPaddingTop();
        this.jdField_i_of_type_Int = ((ViewGroup)localObject1).getPaddingBottom();
        this.jdField_j_of_type_Int = ((ViewGroup)localObject1).getPaddingLeft();
        this.jdField_k_of_type_Int = ((ViewGroup)localObject1).getPaddingRight();
        ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
      }
    }
    return;
    label215:
    Object localObject1 = (Activity)getContext();
    ((Activity)localObject1).getWindow().setFlags(1024, 8);
    ((Activity)localObject1).setRequestedOrientation(1);
    ((Activity)localObject1).getWindow().getDecorView().setSystemUiVisibility(this.jdField_g_of_type_Int);
    localObject1 = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = this.jdField_e_of_type_Int;
    ((ViewGroup.LayoutParams)localObject1).height = this.jdField_f_of_type_Int;
    Object localObject2 = getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
      ((ViewGroup)localObject2).setPadding(this.jdField_j_of_type_Int, this.jdField_h_of_type_Int, this.jdField_k_of_type_Int, this.jdField_i_of_type_Int);
    }
    setLayoutParams((ViewGroup.LayoutParams)localObject1);
    setGdtVideoFcIcon(2130841446);
    setGdtVideoCloseIcon(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView
 * JD-Core Version:    0.7.0.1
 */
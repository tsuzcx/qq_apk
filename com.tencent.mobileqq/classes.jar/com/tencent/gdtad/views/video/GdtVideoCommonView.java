package com.tencent.gdtad.views.video;

import aciy;
import ajjy;
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
import apcb;
import aqjb;
import azue;
import badq;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
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
import nbe;
import yjr;
import yjs;
import ymn;
import yny;
import yox;
import ypk;
import yqj;
import yqk;
import yrn;
import yro;
import yrp;
import yrq;
import yrr;
import yrs;
import yrt;
import yru;
import yrv;

public class GdtVideoCommonView
  extends RelativeLayout
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener, yqk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
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
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new yrp(this);
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtVideoCommonView.6(this);
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<yru> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ymn jdField_a_of_type_Ymn;
  private yqj jdField_a_of_type_Yqj;
  private yrq jdField_a_of_type_Yrq;
  private yrr jdField_a_of_type_Yrr;
  private yrs jdField_a_of_type_Yrs;
  private yrt jdField_a_of_type_Yrt;
  private yrv jdField_a_of_type_Yrv;
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
    View.inflate(paramContext, 2131493530, this);
    k();
  }
  
  public GdtVideoCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131493530, this);
    k();
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_Yqj != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
      }
      this.jdField_a_of_type_Yqj.a(this.jdField_a_of_type_JavaLangRefWeakReference);
      yny.a("GdtVideoCommonView", "playBindController " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void a(long paramLong)
  {
    yny.a("GdtVideoCommonView", "playVideo startElapsed -->" + paramLong + "|" + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (this.jdField_a_of_type_Int != 3))
    {
      this.jdField_a_of_type_Int = 3;
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      String str2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getTencent_video_id();
      localTVK_PlayerVideoInfo.setVid(str2);
      String str1 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getUrl();
      if (aqjb.a(str2)) {
        str1 = aqjb.a(str2);
      }
      yny.a("GdtVideoCommonView", "playVideo url -->" + str1);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, str1, paramLong, 0L, localTVK_PlayerVideoInfo);
      if (this.jdField_a_of_type_Int == 8) {
        yny.a("GdtVideoCommonView", "playVideo STATE_ERROR return -->" + paramLong);
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
      ((yru)localIterator.next()).a(paramView);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    yny.a("GdtVideoCommonView", "letsShowOff " + paramBoolean + " " + this.jdField_a_of_type_JavaLangString + " mVideoState " + this.jdField_a_of_type_Int);
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
    yny.a("GdtVideoCommonView", "setStateOfMediaSound volume =" + paramInt + " viewReusmed " + paramBoolean1 + " isFromVolumeChanged " + paramBoolean2 + " isSilentMode = " + this.jdField_b_of_type_Boolean + ", isVolumOpen = " + this.n + ", hasNotifyCompleted = " + this.o);
    if ((!paramBoolean1) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)) {
      return;
    }
    if (paramInt > 0) {
      if ((!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute()) || (paramBoolean2))
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840060);
        this.n = true;
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131639437));
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
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840059);
      continue;
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840059);
      this.n = false;
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131639444));
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      TVK_SDKMgr.installPlugin(paramContext, new yro(this, paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      yny.a("GdtVideoCommonView", "installSDK t==" + paramContext.toString() + " " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      yny.a("GdtVideoCommonView", "[requestSystemAudioFocus] gain is called!");
      this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
      return;
    }
    yny.a("GdtVideoCommonView", "[requestSystemAudioFocus] release is called!");
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
  }
  
  private void c(Context paramContext)
  {
    yny.a("GdtVideoCommonView", "initVideo " + this.jdField_a_of_type_JavaLangString);
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
        yny.d("GdtVideoCommonView", "initVideo return mVideoPlayer == null");
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
      yny.a("GdtVideoCommonView", "initVideo isSilentMode = " + this.jdField_b_of_type_Boolean + ", isVolumOpen = " + this.n);
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
    if (badq.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      yny.a("GdtVideoCommonView", "netType " + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131301367));
      this.jdField_e_of_type_AndroidViewView = findViewById(2131303838);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131300294);
      this.jdField_g_of_type_AndroidViewView = findViewById(2131301370);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301363));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301361));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301362));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131306305));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131310010));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131310012));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311809));
      int i1 = ypk.a(5.0F, getResources());
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301369));
      ypk.a(this.jdField_e_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301368));
      ypk.a(this.jdField_a_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298701));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131301366);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301364));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131301365);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getContext().getSystemService("audio"));
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
      this.jdField_a_of_type_Ymn = new ymn(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Ymn.a();
      this.jdField_a_of_type_Ymn.a(new yrn(this));
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_Yrq = new yrq(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Yrq, localIntentFilter);
      this.jdField_a_of_type_Yrs = new yrs(this, null);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Yrs, localIntentFilter);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131297133);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301339));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131301337));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301340));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301338));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      c();
      return;
      if (badq.d(this.jdField_a_of_type_AndroidContentContext)) {
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
    GdtAd localGdtAd;
    if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null))
    {
      yny.a("GdtVideoCommonView", "updateDownloadBtnLable " + this.jdField_a_of_type_JavaLangString);
      localGdtAd = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd();
      if (localGdtAd == null) {
        yny.d("GdtVideoCommonView", "updateDownloadBtnLable gdtAd == null " + this.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      return;
    }
    if (localGdtAd.isAppProductType())
    {
      String str = localGdtAd.getAppPackageName();
      if (nbe.a(this.jdField_a_of_type_AndroidContentContext, str))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(ajjy.a(2131639442));
        return;
      }
      if (yox.a(this.jdField_a_of_type_AndroidContentContext, localGdtAd.getAppPackageName()))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(ajjy.a(2131639434));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(ajjy.a(2131639438));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(ajjy.a(2131639445));
  }
  
  private void o()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.5(this));
      return;
    }
    yny.a("GdtVideoCommonView", "doStartPlay " + this.jdField_a_of_type_JavaLangString);
    A();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      yny.d("GdtVideoCommonView", "doStartPlay return mVideoPlayer == null");
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      yny.d("GdtVideoCommonView", "doStartPlay isSilentMode is true");
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
      yny.a("GdtVideoCommonView", "pauseVideoInternal " + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_Int = 6;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      e();
    }
    for (;;)
    {
      b(false);
      return;
      yny.a("GdtVideoCommonView", "pauseVideoInternal return " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void q()
  {
    yny.a("GdtVideoCommonView", "resumeVideByNet netType " + this.jdField_c_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      apcb.a(2131624087);
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
    if (this.jdField_a_of_type_Yqj != null) {
      this.jdField_a_of_type_Yqj.jdField_a_of_type_AndroidViewView = this;
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
      findViewById(2131303703).setVisibility(8);
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
      yny.d("GdtVideoCommonView", "checkIsCompleted return mVideoPlayer == null");
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
    if (this.jdField_a_of_type_Yrv != null) {
      this.jdField_a_of_type_Yrv.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
    }
    b(false);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Yrv != null)
    {
      if (this.jdField_d_of_type_Int <= 0) {
        break label74;
      }
      this.jdField_a_of_type_Yrv.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
    for (;;)
    {
      v();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ((yru)localIterator.next()).b(this);
        continue;
        label74:
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
          break label90;
        }
        yny.d("GdtVideoCommonView", "notifyStarted return mVideoPlayer == null");
      }
      return;
      label90:
      this.jdField_a_of_type_Yrv.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    }
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_Yrv != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.jdField_a_of_type_Yrv.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((yru)localIterator.next()).c(this);
    }
    b(false);
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Yrv != null) {
      this.jdField_a_of_type_Yrv.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((yru)localIterator.next()).d(this);
    }
    b(false);
  }
  
  public void a()
  {
    yny.c("GdtVideoCommonView", "play from OUT_CONTROL " + this.jdField_a_of_type_JavaLangString);
    h();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" doResumeVideo " + paramInt);
    localStringBuilder.append(" isViewResume " + paramBoolean1);
    localStringBuilder.append(" stopPlayByUser " + paramBoolean2);
    localStringBuilder.append(" mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    yny.a("GdtVideoCommonView", localStringBuilder.toString());
    if ((paramBoolean2) || (!paramBoolean1)) {
      return;
    }
    if ((this.jdField_a_of_type_Yqj != null) && (this.jdField_a_of_type_Yqj.jdField_a_of_type_AndroidViewView != this))
    {
      yny.a("GdtVideoCommonView", "returned FocusedVideo " + this.jdField_a_of_type_Yqj.jdField_a_of_type_AndroidViewView + "!=this " + hashCode());
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
  
  public void a(yru paramyru)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramyru)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramyru);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Int == 5);
  }
  
  public void b()
  {
    yny.c("GdtVideoCommonView", "pause from OUT_CONTROL " + this.jdField_a_of_type_JavaLangString);
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
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131639446));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription(ajjy.a(2131639447));
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
    yny.a("GdtVideoCommonView", "updateView " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131639439));
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
    yny.a("GdtVideoCommonView", "pauseVideo " + this.jdField_a_of_type_JavaLangString);
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
    yny.a("GdtVideoCommonView", "resumeVideo " + this.jdField_a_of_type_JavaLangString);
    s();
    a(1, this.jdField_a_of_type_Boolean, this.jdField_f_of_type_Boolean);
    if (this.jdField_j_of_type_Boolean) {
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(3846);
    }
    n();
  }
  
  public void i()
  {
    yny.a("GdtVideoCommonView", "releaseMediaPlayer");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void j()
  {
    yny.a("GdtVideoCommonView", "onDestroy");
    i();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Ymn != null) {
      this.jdField_a_of_type_Ymn.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Yrq != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Yrq);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Yrs != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Yrs);
    }
    if (this.jdField_a_of_type_Yrv != null) {
      this.jdField_a_of_type_Yrv = null;
    }
    if (this.jdField_a_of_type_Yqj != null)
    {
      this.jdField_a_of_type_Yqj.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Yqj = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_d_of_type_Long < 350L) {
      yny.a("GdtVideoCommonView", "onClick too fast not allowed  " + this.jdField_a_of_type_JavaLangString);
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
            case 2131298701: 
              yny.a("GdtVideoCommonView", "onClick  closeBtn exitFullScreen " + this.jdField_j_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
              if (!this.jdField_j_of_type_Boolean) {
                break label463;
              }
            }
          } while (this.jdField_a_of_type_Yrt == null);
          this.jdField_a_of_type_Yrt.h();
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
          yny.a("GdtVideoCommonView", "onClick  gdt_video_center_play mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
          d();
          return;
          yny.a("GdtVideoCommonView", "onClick  gdt_video_center_pause mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
          g();
          return;
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
          {
            yny.d("GdtVideoCommonView", "gdt_video_volume_switch click return mVideoPlayer == null");
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
        } while (this.jdField_a_of_type_Yrt == null);
        if (this.jdField_j_of_type_Boolean)
        {
          this.jdField_a_of_type_Yrt.h();
          return;
        }
        this.jdField_a_of_type_Yrt.i();
        return;
        d();
        return;
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      paramView = (Activity)this.jdField_a_of_type_AndroidContentContext;
      paramView.finish();
      paramView.overridePendingTransition(17432576, 17432577);
      return;
      yny.a("GdtVideoCommonView", "click playagain mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      d();
      return;
      yny.a("GdtVideoCommonView", "click download mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    } while ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)));
    label463:
    paramView = (Activity)this.jdField_a_of_type_AndroidContentContext;
    yjs localyjs = new yjs();
    localyjs.jdField_a_of_type_Int = 7;
    localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd();
    localyjs.jdField_a_of_type_Boolean = false;
    localyjs.jdField_b_of_type_Boolean = true;
    localyjs.jdField_a_of_type_JavaLangClass = null;
    localyjs.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
    yjr.a(localyjs);
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_Int = 7;
    e();
    yny.a("GdtVideoCommonView", "onCompletion" + this.jdField_a_of_type_Int);
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    yny.a("GdtVideoCommonView", "onError errorType " + paramInt1 + " errorCode " + paramInt2);
    this.jdField_a_of_type_Int = 8;
    if ((this.jdField_a_of_type_Yrr != null) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_Yrr.b(false);
    }
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = true;
      if (this.jdField_a_of_type_Yrv != null) {
        this.jdField_a_of_type_Yrv.c(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
      }
    }
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131639435), 0).show();
    e();
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    this.jdField_c_of_type_Long = paramTVK_NetVideoInfo.getFileSize();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    yny.a("GdtVideoCommonView", "onNetVideoInfo size:" + this.jdField_c_of_type_Long + " hasShowTips " + this.jdField_k_of_type_Boolean);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ypk.a(paramInt * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    yny.a("GdtVideoCommonView", "onStartTrackingTouch " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    yny.a("GdtVideoCommonView", "onStopTrackingTouch " + this.jdField_a_of_type_Int);
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
      yny.d("GdtVideoCommonView", "onStopTrackingTouch return mVideoPlayer == null");
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
    yny.a("GdtVideoCommonView", "onStopTrackingTouch no answer " + this.jdField_a_of_type_Int);
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    yny.a("GdtVideoCommonView", "onVideoPrepared " + this.jdField_a_of_type_Int + " isViewResume " + this.jdField_a_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Yrr != null) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_Yrr.b(true);
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
        yny.a("GdtVideoCommonView", "Video error for reason:<1s ");
        if (this.jdField_a_of_type_Yrv != null) {
          this.jdField_a_of_type_Yrv.c(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
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
        ((yru)paramTVK_IMediaPlayer.next()).a(this);
      }
      this.jdField_a_of_type_Int = 4;
      a(3, this.jdField_a_of_type_Boolean, this.jdField_f_of_type_Boolean);
    }
  }
  
  public void setData(GdtVideoData paramGdtVideoData, yqj paramyqj)
  {
    this.jdField_a_of_type_Yqj = paramyqj;
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
        paramyqj = new URL(paramGdtVideoData.getCoverUrl());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.a(paramyqj);
        Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_logo();
        paramyqj = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_image_name();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          Resources localResources = getResources();
          localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130844567);
          localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130844567);
          localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
          int i1 = aciy.a(55.0F, localResources);
          ((URLDrawable)localObject).setTag(azue.b(i1, i1, ypk.a(21, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext))));
          ((URLDrawable)localObject).setDecodeHandler(azue.c);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        if (!TextUtils.isEmpty(paramyqj)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramyqj);
        }
        if (paramGdtVideoData.needReport()) {
          this.jdField_a_of_type_Yrv = new yrv(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene());
        }
        t();
        return;
        bool = false;
      }
      catch (Exception paramyqj)
      {
        for (;;)
        {
          paramyqj.printStackTrace();
        }
      }
    }
  }
  
  public void setGdtVideoCloseIcon(int paramInt) {}
  
  public void setGdtVideoFcIcon(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setLoadListener(yrr paramyrr)
  {
    this.jdField_a_of_type_Yrr = paramyrr;
  }
  
  public void setOnVideoFullScreen(yrt paramyrt)
  {
    this.jdField_a_of_type_Yrt = paramyrt;
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
      localObject1 = ypk.a((Activity)localObject1);
      int i1 = localObject1[0];
      ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
      ((ViewGroup.LayoutParams)localObject2).height = i1;
      setLayoutParams((ViewGroup.LayoutParams)localObject2);
      setGdtVideoFcIcon(2130841247);
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
    setGdtVideoFcIcon(2130841248);
    setGdtVideoCloseIcon(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView
 * JD-Core Version:    0.7.0.1
 */
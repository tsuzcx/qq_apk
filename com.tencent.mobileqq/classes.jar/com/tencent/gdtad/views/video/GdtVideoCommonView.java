package com.tencent.gdtad.views.video;

import acfk;
import acib;
import acik;
import aciv;
import aciz;
import acja;
import acjz;
import acka;
import ackb;
import ackc;
import ackd;
import acke;
import ackf;
import ackg;
import ackh;
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
import anvx;
import audr;
import avqv;
import bapt;
import bgxc;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import ois;

public class GdtVideoCommonView
  extends RelativeLayout
  implements acja, View.OnClickListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private acfk jdField_a_of_type_Acfk;
  private final acib jdField_a_of_type_Acib = new acib();
  private aciz jdField_a_of_type_Aciz;
  private ackc jdField_a_of_type_Ackc;
  private ackd jdField_a_of_type_Ackd;
  private acke jdField_a_of_type_Acke;
  private ackf jdField_a_of_type_Ackf;
  private ackh jdField_a_of_type_Ackh;
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
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ackb(this);
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private ISPlayerVideoView jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtVideoCommonView.6(this);
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<ackg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
  private volatile boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = -16777216;
  private boolean jdField_l_of_type_Boolean = true;
  private boolean m = true;
  private boolean n;
  
  public GdtVideoCommonView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559259, this);
    k();
  }
  
  public GdtVideoCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559259, this);
    k();
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_Ackh != null) {
      this.jdField_a_of_type_Ackh.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_Acib);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ackg)localIterator.next()).d(this);
    }
    b(false);
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_Aciz != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
      }
      this.jdField_a_of_type_Aciz.a(this.jdField_a_of_type_JavaLangRefWeakReference);
      QLog.i("GdtVideoCommonView", 1, "playBindController " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)) {
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "setStateOfMediaSound volume =" + paramInt + " viewReusmed " + paramBoolean1 + " isFromVolumeChanged " + paramBoolean2 + " isSilentMode = " + this.jdField_b_of_type_Boolean + ", isVolumOpen = " + this.m + ", hasNotifyCompleted = " + this.n + "，isOutputMute = " + paramBoolean3);
    if (paramInt > 0) {
      if ((!paramBoolean3) || (paramBoolean2))
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840476);
        this.m = true;
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131704700));
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int != 6) && (this.jdField_a_of_type_Int != 8) && (this.jdField_a_of_type_Int != 7)) {
        b(this.m);
      }
      u();
      return;
      this.m = false;
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840475);
      continue;
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840475);
      this.m = false;
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131704707));
      }
    }
  }
  
  private void a(long paramLong)
  {
    QLog.i("GdtVideoCommonView", 1, "playVideo startElapsed -->" + paramLong + "|" + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    String str;
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (!this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()) && (this.jdField_a_of_type_Int != 3))
    {
      this.jdField_a_of_type_Int = 3;
      str = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getTencent_video_id();
      localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getUrl();
      StringBuffer localStringBuffer = new StringBuffer("playVideo url=").append((String)localObject).append(",vid=").append(str);
      if (avqv.a(str))
      {
        localObject = avqv.a(str);
        localStringBuffer.append(",changeUrl=").append((String)localObject);
      }
      QLog.i("GdtVideoCommonView", 1, localStringBuffer.toString());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label252;
      }
    }
    for (Object localObject = SuperPlayerFactory.createVideoInfoForUrl((String)localObject, 104, str, null);; localObject = SuperPlayerFactory.createVideoInfoForTVideo(str))
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
      o();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, (SuperPlayerVideoInfo)localObject, paramLong);
      if (this.jdField_a_of_type_Int != 8) {
        break;
      }
      QLog.i("GdtVideoCommonView", 1, "playVideo STATE_ERROR return -->" + paramLong);
      label252:
      do
      {
        return;
      } while (TextUtils.isEmpty(str));
    }
    e();
  }
  
  private void a(Context paramContext)
  {
    if (bapt.a())
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
      ((ackg)localIterator.next()).a(paramView);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("GdtVideoCommonView", 1, "letsShowOff " + paramBoolean + " " + this.jdField_a_of_type_JavaLangString + " mVideoState " + this.jdField_a_of_type_Int);
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
      u();
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      QLog.i("VideoGdtGdtVideoCommonView", 1, "installSDK");
      bapt.a(BaseApplicationImpl.getApplication(), new acka(this, paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("VideoGdtGdtVideoCommonView", 1, "installSDK", paramContext);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("GdtVideoCommonView", 1, "[requestSystemAudioFocus] gain is called!");
      this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "[requestSystemAudioFocus] release is called!");
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
  }
  
  private void c(Context paramContext)
  {
    QLog.i("GdtVideoCommonView", 1, "initVideo " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
    if (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView != null)
    {
      setBackgroundColor(this.jdField_l_of_type_Int);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(this.jdField_l_of_type_Int);
      if (!(this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView instanceof View)) {
        break label148;
      }
      paramContext = (View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
      paramContext.setBackgroundColor(this.jdField_l_of_type_Int);
      paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      addView(paramContext, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 110, this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
        break;
      }
      QLog.i("GdtVideoCommonView", 1, "initVideo return mVideoPlayer == null");
      return;
      label148:
      QLog.i("GdtVideoCommonView", 1, "!mVideoView instanceof View)");
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnTVideoNetInfoUpdateListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    o();
    QLog.i("GdtVideoCommonView", 1, "initVideo isSilentMode = " + this.jdField_b_of_type_Boolean + ", isVolumOpen = " + this.m);
    if (this.jdField_b_of_type_Boolean) {
      this.m = false;
    }
    paramContext = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    int i1;
    if (!this.m)
    {
      bool = true;
      paramContext.setOutputMute(bool);
      i1 = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if (this.m) {
        break label319;
      }
    }
    label319:
    for (boolean bool = true;; bool = false)
    {
      a(i1, true, false, bool);
      a(this.jdField_b_of_type_Long);
      return;
      bool = false;
      break;
    }
  }
  
  private void k()
  {
    if (NetworkUtil.isWifiEnabled(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      QLog.i("GdtVideoCommonView", 1, "netType " + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131367621));
      this.jdField_e_of_type_AndroidViewView = findViewById(2131370478);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131366414);
      this.jdField_g_of_type_AndroidViewView = findViewById(2131367625);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367617));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367615));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367616));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373226));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131377267));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131377269));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379301));
      int i1 = aciv.a(5.0F, getResources());
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367624));
      aciv.a(this.jdField_e_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367622));
      aciv.a(this.jdField_a_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364699));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131367620);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367618));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131367619);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getContext().getSystemService("audio"));
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
      this.jdField_a_of_type_Acfk = new acfk(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Acfk.a();
      this.jdField_a_of_type_Acfk.a(new acjz(this));
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_Ackc = new ackc(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ackc, localIntentFilter);
      this.jdField_a_of_type_Acke = new acke(this, null);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Acke, localIntentFilter);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131362851);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367587));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131367585));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367588));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367586));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131380879);
      c();
      return;
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) {
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
        QLog.e("GdtVideoCommonView", 1, "initAppSettingInOntherProcess", localThrowable);
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
      s();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      n();
    }
    for (;;)
    {
      u();
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      s();
      if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene() == 7) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null))
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
      QLog.i("GdtVideoCommonView", 1, "updateDownloadBtnLable " + this.jdField_a_of_type_JavaLangString);
      if (!(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd() instanceof GdtAd)) {
        break label104;
      }
    }
    label104:
    for (GdtAd localGdtAd = (GdtAd)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd(); localGdtAd == null; localGdtAd = null)
    {
      QLog.i("GdtVideoCommonView", 1, "updateDownloadBtnLable gdtAd == null " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (localGdtAd.isAppProductType())
    {
      String str = localGdtAd.getAppPackageName();
      if (ois.a(this.jdField_a_of_type_AndroidContentContext, str))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(anvx.a(2131704705));
        return;
      }
      if (acik.a(this.jdField_a_of_type_AndroidContentContext, localGdtAd.getAppPackageName()))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(anvx.a(2131704697));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(anvx.a(2131704701));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(anvx.a(2131704708));
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData == null) || (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null))
    {
      QLog.i("GdtVideoCommonView", 1, "setVideoPlayByData failed");
      return;
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(true);
    }
    for (;;)
    {
      QLog.i("GdtVideoCommonView", 1, "setVideoPlayByData dataLoop=" + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop() + ",videoLoop = " + this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isLoopBack());
      return;
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(false);
    }
  }
  
  private void p()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.5(this));
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "doStartPlay " + this.jdField_a_of_type_JavaLangString);
    B();
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)
    {
      QLog.i("GdtVideoCommonView", 1, "doStartPlay return mVideoPlayer == null");
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.i("GdtVideoCommonView", 1, "doStartPlay isSilentMode is true");
      this.m = false;
    }
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    int i1;
    if (!this.m)
    {
      bool = true;
      localISuperPlayer.setOutputMute(bool);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      this.jdField_a_of_type_Int = 5;
      e();
      i1 = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if (this.m) {
        break label168;
      }
    }
    label168:
    for (boolean bool = true;; bool = false)
    {
      a(i1, true, false, bool);
      return;
      bool = false;
      break;
    }
  }
  
  private void q()
  {
    if (a())
    {
      QLog.i("GdtVideoCommonView", 1, "pauseVideoInternal " + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      this.jdField_a_of_type_Int = 6;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      e();
    }
    for (;;)
    {
      b(false);
      return;
      QLog.i("GdtVideoCommonView", 1, "pauseVideoInternal return " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void r()
  {
    QLog.i("GdtVideoCommonView", 1, "resumeVideByNet netType " + this.jdField_c_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      audr.a(2131689549);
      this.jdField_a_of_type_Int = 8;
      this.jdField_a_of_type_Acib.c(2);
      e();
      return;
    case 1: 
      p();
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      p();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  private void s()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void t()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aciz != null) {
      this.jdField_a_of_type_Aciz.jdField_a_of_type_AndroidViewView = this;
    }
  }
  
  private void u()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      findViewById(2131370321).setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.10(this));
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      QLog.i("GdtVideoCommonView", 1, "checkIsCompleted return mVideoPlayer == null");
    }
    long l1;
    do
    {
      return;
      l1 = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    } while ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) || (!this.jdField_a_of_type_Boolean));
    if (Math.abs(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() - l1) < 1000L) {
      if (!this.n) {
        A();
      }
    }
    for (this.n = true;; this.n = false)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtVideoCommonView.11(this), 300L);
      return;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Ackh != null) {
      this.jdField_a_of_type_Ackh.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), this.jdField_a_of_type_Acib);
    }
    b(false);
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Ackh != null)
    {
      if (this.jdField_d_of_type_Int <= 0) {
        break label74;
      }
      this.jdField_a_of_type_Ackh.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
    for (;;)
    {
      w();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ((ackg)localIterator.next()).b(this);
        continue;
        label74:
        if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
          break label91;
        }
        QLog.i("GdtVideoCommonView", 1, "notifyStarted return mVideoPlayer == null");
      }
      return;
      label91:
      this.jdField_a_of_type_Ackh.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    }
  }
  
  private void z()
  {
    if ((this.jdField_a_of_type_Ackh != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)) {
      this.jdField_a_of_type_Ackh.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), this.jdField_a_of_type_Acib);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ackg)localIterator.next()).c(this);
    }
    b(false);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
  }
  
  public acib a()
  {
    return this.jdField_a_of_type_Acib;
  }
  
  public void a()
  {
    QLog.i("GdtVideoCommonView", 1, "play from OUT_CONTROL " + this.jdField_a_of_type_JavaLangString);
    h();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" doResumeVideo " + paramInt);
    localStringBuilder.append(" isViewResume " + paramBoolean1);
    localStringBuilder.append(" stopPlayByUser " + paramBoolean2);
    localStringBuilder.append(" mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    if ((paramBoolean2) || (!paramBoolean1)) {
      return;
    }
    if ((this.jdField_a_of_type_Aciz != null) && (this.jdField_a_of_type_Aciz.jdField_a_of_type_AndroidViewView != this))
    {
      QLog.i("GdtVideoCommonView", 1, "returned FocusedVideo " + this.jdField_a_of_type_Aciz.jdField_a_of_type_AndroidViewView + "!=this " + hashCode());
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
    r();
  }
  
  public void a(ackg paramackg)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramackg)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramackg);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_Int == 5);
  }
  
  public void b()
  {
    QLog.i("GdtVideoCommonView", 1, "pause from OUT_CONTROL " + this.jdField_a_of_type_JavaLangString);
    f();
  }
  
  public boolean b()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public void c()
  {
    l();
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131704709));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription(anvx.a(2131704710));
    }
  }
  
  public void d()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    t();
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
    QLog.i("GdtVideoCommonView", 1, "updateView " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131704702));
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
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
      s();
    case 3: 
    case 5: 
    case 8: 
    case 7: 
      for (;;)
      {
        u();
        return;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        s();
        continue;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_Boolean = false;
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        s();
        a(false);
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
        y();
        continue;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        s();
        x();
        continue;
        m();
        A();
      }
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      s();
      z();
      break;
      if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      }
    }
  }
  
  public void f()
  {
    QLog.i("GdtVideoCommonView", 1, "pauseVideo " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
    q();
  }
  
  public void g()
  {
    this.jdField_e_of_type_Boolean = true;
    q();
  }
  
  public void h()
  {
    QLog.i("GdtVideoCommonView", 1, "resumeVideo " + this.jdField_a_of_type_JavaLangString);
    t();
    a(1, this.jdField_a_of_type_Boolean, this.jdField_e_of_type_Boolean);
    if (this.jdField_i_of_type_Boolean) {
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(3846);
    }
    n();
  }
  
  public void i()
  {
    QLog.i("GdtVideoCommonView", 1, "releaseMediaPlayer");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
    }
  }
  
  public void j()
  {
    QLog.i("GdtVideoCommonView", 1, "onDestroy");
    i();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Acfk != null) {
      this.jdField_a_of_type_Acfk.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Ackc != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ackc);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Acke != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Acke);
    }
    if (this.jdField_a_of_type_Ackh != null) {
      this.jdField_a_of_type_Ackh = null;
    }
    if (this.jdField_a_of_type_Aciz != null)
    {
      this.jdField_a_of_type_Aciz.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Aciz = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_d_of_type_Long < 350L) {
      QLog.i("GdtVideoCommonView", 1, "onClick too fast not allowed  " + this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_d_of_type_Long = l1;
      label243:
      Activity localActivity;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364699: 
        QLog.i("GdtVideoCommonView", 1, "onClick  closeBtn exitFullScreen " + this.jdField_i_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
        if (this.jdField_i_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Ackf == null) {
            continue;
          }
          this.jdField_a_of_type_Ackf.a();
        }
        break;
      case 2131367625: 
        int i1;
        if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          i1 = 1;
          if (i1 != 0) {
            break label269;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          a(bool);
          a(paramView);
          break;
          i1 = 0;
          break label243;
        }
      case 2131367616: 
        QLog.i("GdtVideoCommonView", 1, "onClick  gdt_video_center_play mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
        d();
        break;
      case 2131367615: 
        QLog.i("GdtVideoCommonView", 1, "onClick  gdt_video_center_pause mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Acib.b(1);
        g();
        break;
      case 2131367624: 
        if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)
        {
          QLog.i("GdtVideoCommonView", 1, "gdt_video_volume_switch click return mVideoPlayer == null");
        }
        else if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isOutputMute())
        {
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(false);
          a(1, true, false, false);
        }
        else
        {
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(true);
          a(0, true, false, true);
        }
        break;
      case 2131366414: 
        a(this.jdField_b_of_type_Long);
        break;
      case 2131367622: 
        if (this.jdField_a_of_type_Ackf != null) {
          if (this.jdField_i_of_type_Boolean) {
            this.jdField_a_of_type_Ackf.a();
          } else {
            this.jdField_a_of_type_Ackf.b();
          }
        }
        break;
      case 2131367618: 
      case 2131367619: 
        d();
        continue;
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
          localActivity.finish();
          localActivity.overridePendingTransition(17432576, 17432577);
        }
        break;
      case 2131367587: 
        QLog.i("GdtVideoCommonView", 1, "click playagain mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        d();
        break;
      case 2131367585: 
        label269:
        QLog.i("GdtVideoCommonView", 1, "click download mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
        {
          localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.jdField_c_of_type_Int = 7;
          localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
          localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd());
          localParams.jdField_a_of_type_Boolean = false;
          localParams.jdField_b_of_type_Boolean = true;
          localParams.jdField_a_of_type_JavaLangClass = null;
          localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
          GdtHandler.a(localParams);
        }
        break;
      }
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_Int = 7;
    e();
    QLog.i("GdtVideoCommonView", 1, "onCompletion" + this.jdField_a_of_type_Int);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.i("GdtVideoCommonView", 1, "onError errorType " + paramInt2 + " errorCode " + paramInt3 + " extraInfo " + paramString);
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_Acib.a(paramInt2, paramInt3);
    if ((this.jdField_a_of_type_Ackd != null) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_Ackd.a(false);
    }
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131704698), 0).show();
    e();
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(aciv.a(paramInt * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.i("GdtVideoCommonView", 1, "onStartTrackingTouch " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch " + this.jdField_a_of_type_Int);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = ((int)(paramSeekBar.getProgress() * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    t();
    if ((this.jdField_a_of_type_Int < 4) || (this.jdField_a_of_type_Int > 6)) {
      a(this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)
      {
        QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch return mVideoPlayer == null");
      }
      else if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 4))
      {
        if ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6)) {
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
        }
        B();
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(this.jdField_d_of_type_Int);
        this.jdField_a_of_type_Int = 5;
        e();
      }
      else
      {
        QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch no answer " + this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    if (paramTVideoNetInfo == null)
    {
      QLog.i("GdtVideoCommonView", 1, "onTVideoNetInfoUpdate netInfo == null");
      return;
    }
    this.jdField_c_of_type_Long = paramTVideoNetInfo.getVideoSize();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    QLog.i("GdtVideoCommonView", 1, "onTVideoNetInfoUpdate size:" + this.jdField_c_of_type_Long + " hasShowTips " + this.jdField_j_of_type_Boolean);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.i("GdtVideoCommonView", 1, "onVideoPrepared " + this.jdField_a_of_type_Int + " isViewResume " + this.jdField_a_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Ackd != null) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_Ackd.a(true);
    }
    if ((this.jdField_a_of_type_Long < 0L) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null))
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() <= 0L) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setDurationMillis(this.jdField_a_of_type_Long);
      }
      if ((this.jdField_a_of_type_Long < 1000L) && (!this.jdField_h_of_type_Boolean))
      {
        this.jdField_h_of_type_Boolean = true;
        QLog.i("GdtVideoCommonView", 1, "Video error for reason:<1s ");
        if (this.jdField_a_of_type_Ackh != null)
        {
          this.jdField_a_of_type_Acib.c(3);
          this.jdField_a_of_type_Ackh.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), this.jdField_a_of_type_Acib);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.4(this));
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      paramISuperPlayer = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramISuperPlayer.hasNext()) {
        ((ackg)paramISuperPlayer.next()).a(this);
      }
      this.jdField_a_of_type_Int = 4;
      a(3, this.jdField_a_of_type_Boolean, this.jdField_e_of_type_Boolean);
    }
  }
  
  public void setData(GdtVideoData paramGdtVideoData, aciz paramaciz)
  {
    this.jdField_a_of_type_Aciz = paramaciz;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData = paramGdtVideoData;
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isDirectPlay();
    this.jdField_l_of_type_Int = paramGdtVideoData.getVideoDefaultBackgroundColor();
    this.jdField_k_of_type_Boolean = paramGdtVideoData.isForceNotShowControllerView();
    int i1;
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Int == 1)) {
      i1 = 11;
    }
    for (;;)
    {
      this.jdField_a_of_type_Acib.a(i1);
      this.jdField_b_of_type_Long = paramGdtVideoData.getStartPositionMillis();
      this.m = paramGdtVideoData.isVolumOpen();
      boolean bool;
      if (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() != 2)
      {
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        a(this.jdField_a_of_type_AndroidContentContext);
        if (TextUtils.isEmpty(paramGdtVideoData.getCoverUrl())) {}
      }
      try
      {
        paramaciz = new URL(paramGdtVideoData.getCoverUrl());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage(paramaciz);
        Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_logo();
        paramaciz = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_image_name();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          Resources localResources = getResources();
          localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130845460);
          localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130845460);
          localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
          i1 = AIOUtils.dp2px(55.0F, localResources);
          ((URLDrawable)localObject).setTag(bgxc.b(i1, i1, aciv.a(21, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext))));
          ((URLDrawable)localObject).setDecodeHandler(bgxc.c);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        if (!TextUtils.isEmpty(paramaciz)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramaciz);
        }
        if (paramGdtVideoData.needReport()) {
          this.jdField_a_of_type_Ackh = new ackh(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene());
        }
        u();
        return;
        i1 = 12;
        continue;
        bool = false;
      }
      catch (Exception paramaciz)
      {
        for (;;)
        {
          QLog.e("GdtVideoCommonView", 1, "getCoverUrl", paramaciz);
        }
      }
    }
  }
  
  public void setGdtVideoCloseIcon(int paramInt) {}
  
  public void setGdtVideoFcIcon(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setLoadListener(ackd paramackd)
  {
    this.jdField_a_of_type_Ackd = paramackd;
  }
  
  public void setOnVideoFullScreen(ackf paramackf)
  {
    this.jdField_a_of_type_Ackf = paramackf;
  }
  
  public void setisFullScreen(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_i_of_type_Boolean != paramBoolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
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
      localObject1 = aciv.a((Activity)localObject1);
      int i1 = localObject1[0];
      ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
      ((ViewGroup.LayoutParams)localObject2).height = i1;
      setLayoutParams((ViewGroup.LayoutParams)localObject2);
      setGdtVideoFcIcon(2130841816);
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
    setGdtVideoFcIcon(2130841817);
    setGdtVideoCloseIcon(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView
 * JD-Core Version:    0.7.0.1
 */
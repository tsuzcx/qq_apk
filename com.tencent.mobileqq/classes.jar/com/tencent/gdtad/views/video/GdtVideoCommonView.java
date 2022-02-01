package com.tencent.gdtad.views.video;

import actj;
import acwa;
import acwn;
import acwr;
import acws;
import acxr;
import acxs;
import acxt;
import acxu;
import acxv;
import acxw;
import acxx;
import acxy;
import acxz;
import agej;
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
import anzj;
import auna;
import avya;
import bapg;
import bhez;
import bhnv;
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
import nzq;

public class GdtVideoCommonView
  extends RelativeLayout
  implements acws, View.OnClickListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private actj jdField_a_of_type_Actj;
  private acwr jdField_a_of_type_Acwr;
  private acxu jdField_a_of_type_Acxu;
  private acxv jdField_a_of_type_Acxv;
  private acxw jdField_a_of_type_Acxw;
  private acxx jdField_a_of_type_Acxx;
  private acxz jdField_a_of_type_Acxz;
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
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new acxt(this);
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private ISPlayerVideoView jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtVideoCommonView.6(this);
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<acxy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
    View.inflate(paramContext, 2131559213, this);
    k();
  }
  
  public GdtVideoCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559213, this);
    k();
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_Acxz != null) {
      this.jdField_a_of_type_Acxz.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((acxy)localIterator.next()).d(this);
    }
    b(false);
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_Acwr != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
      }
      this.jdField_a_of_type_Acwr.a(this.jdField_a_of_type_JavaLangRefWeakReference);
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
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840400);
        this.m = true;
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131704120));
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
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840399);
      continue;
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840399);
      this.m = false;
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131704127));
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
      if (avya.a(str))
      {
        localObject = avya.a(str);
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
    if (bapg.a())
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
      ((acxy)localIterator.next()).a(paramView);
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
      bapg.a(BaseApplicationImpl.getApplication(), new acxs(this, paramContext));
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
    if (bhnv.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      QLog.i("GdtVideoCommonView", 1, "netType " + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131367461));
      this.jdField_e_of_type_AndroidViewView = findViewById(2131370331);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131366282);
      this.jdField_g_of_type_AndroidViewView = findViewById(2131367465);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367457));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367455));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367456));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373046));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131377245));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131377247));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379238));
      int i1 = acwn.a(5.0F, getResources());
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367464));
      acwn.a(this.jdField_e_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367462));
      acwn.a(this.jdField_a_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364584));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131367460);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367458));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131367459);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getContext().getSystemService("audio"));
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
      this.jdField_a_of_type_Actj = new actj(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Actj.a();
      this.jdField_a_of_type_Actj.a(new acxr(this));
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_Acxu = new acxu(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Acxu, localIntentFilter);
      this.jdField_a_of_type_Acxw = new acxw(this, null);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Acxw, localIntentFilter);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131362827);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367427));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131367425));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367428));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367426));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131380813);
      c();
      return;
      if (bhnv.d(this.jdField_a_of_type_AndroidContentContext)) {
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
      if (nzq.a(this.jdField_a_of_type_AndroidContentContext, str))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(anzj.a(2131704125));
        return;
      }
      if (acwa.a(this.jdField_a_of_type_AndroidContentContext, localGdtAd.getAppPackageName()))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(anzj.a(2131704117));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(anzj.a(2131704121));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(anzj.a(2131704128));
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
      auna.a(2131689550);
      this.jdField_a_of_type_Int = 8;
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
    if (this.jdField_a_of_type_Acwr != null) {
      this.jdField_a_of_type_Acwr.jdField_a_of_type_AndroidViewView = this;
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
      findViewById(2131370155).setVisibility(8);
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
    if (this.jdField_a_of_type_Acxz != null) {
      this.jdField_a_of_type_Acxz.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
    }
    b(false);
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Acxz != null)
    {
      if (this.jdField_d_of_type_Int <= 0) {
        break label74;
      }
      this.jdField_a_of_type_Acxz.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
    for (;;)
    {
      w();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ((acxy)localIterator.next()).b(this);
        continue;
        label74:
        if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
          break label91;
        }
        QLog.i("GdtVideoCommonView", 1, "notifyStarted return mVideoPlayer == null");
      }
      return;
      label91:
      this.jdField_a_of_type_Acxz.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    }
  }
  
  private void z()
  {
    if ((this.jdField_a_of_type_Acxz != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)) {
      this.jdField_a_of_type_Acxz.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((acxy)localIterator.next()).c(this);
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
    if ((this.jdField_a_of_type_Acwr != null) && (this.jdField_a_of_type_Acwr.jdField_a_of_type_AndroidViewView != this))
    {
      QLog.i("GdtVideoCommonView", 1, "returned FocusedVideo " + this.jdField_a_of_type_Acwr.jdField_a_of_type_AndroidViewView + "!=this " + hashCode());
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
  
  public void a(acxy paramacxy)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramacxy)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramacxy);
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
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131704129));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription(anzj.a(2131704130));
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
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131704122));
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
    if (this.jdField_a_of_type_Actj != null) {
      this.jdField_a_of_type_Actj.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Acxu != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Acxu);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Acxw != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Acxw);
    }
    if (this.jdField_a_of_type_Acxz != null) {
      this.jdField_a_of_type_Acxz = null;
    }
    if (this.jdField_a_of_type_Acwr != null)
    {
      this.jdField_a_of_type_Acwr.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Acwr = null;
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
      case 2131364584: 
        QLog.i("GdtVideoCommonView", 1, "onClick  closeBtn exitFullScreen " + this.jdField_i_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
        if (this.jdField_i_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Acxx == null) {
            continue;
          }
          this.jdField_a_of_type_Acxx.a();
        }
        break;
      case 2131367465: 
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
      case 2131367456: 
        QLog.i("GdtVideoCommonView", 1, "onClick  gdt_video_center_play mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
        d();
        break;
      case 2131367455: 
        QLog.i("GdtVideoCommonView", 1, "onClick  gdt_video_center_pause mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
        g();
        break;
      case 2131367464: 
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
      case 2131366282: 
        a(this.jdField_b_of_type_Long);
        break;
      case 2131367462: 
        if (this.jdField_a_of_type_Acxx != null) {
          if (this.jdField_i_of_type_Boolean) {
            this.jdField_a_of_type_Acxx.a();
          } else {
            this.jdField_a_of_type_Acxx.b();
          }
        }
        break;
      case 2131367458: 
      case 2131367459: 
        d();
        continue;
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
          localActivity.finish();
          localActivity.overridePendingTransition(17432576, 17432577);
        }
        break;
      case 2131367427: 
        QLog.i("GdtVideoCommonView", 1, "click playagain mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        d();
        break;
      case 2131367425: 
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
    QLog.i("GdtVideoCommonView", 1, "onError errorType " + paramInt1 + " errorCode " + paramInt2);
    this.jdField_a_of_type_Int = 8;
    if ((this.jdField_a_of_type_Acxv != null) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_Acxv.a(false);
    }
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = true;
      if (this.jdField_a_of_type_Acxz != null) {
        this.jdField_a_of_type_Acxz.c(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
      }
    }
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131704118), 0).show();
    e();
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(acwn.a(paramInt * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
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
    if ((this.jdField_a_of_type_Acxv != null) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_Acxv.a(true);
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
        if (this.jdField_a_of_type_Acxz != null) {
          this.jdField_a_of_type_Acxz.c(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
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
        ((acxy)paramISuperPlayer.next()).a(this);
      }
      this.jdField_a_of_type_Int = 4;
      a(3, this.jdField_a_of_type_Boolean, this.jdField_e_of_type_Boolean);
    }
  }
  
  public void setData(GdtVideoData paramGdtVideoData, acwr paramacwr)
  {
    this.jdField_a_of_type_Acwr = paramacwr;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData = paramGdtVideoData;
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isDirectPlay();
    this.jdField_l_of_type_Int = paramGdtVideoData.getVideoDefaultBackgroundColor();
    this.jdField_k_of_type_Boolean = paramGdtVideoData.isForceNotShowControllerView();
    this.jdField_b_of_type_Long = paramGdtVideoData.getStartPositionMillis();
    this.m = paramGdtVideoData.isVolumOpen();
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
        paramacwr = new URL(paramGdtVideoData.getCoverUrl());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage(paramacwr);
        Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_logo();
        paramacwr = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_image_name();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          Resources localResources = getResources();
          localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130845496);
          localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130845496);
          localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
          int i1 = agej.a(55.0F, localResources);
          ((URLDrawable)localObject).setTag(bhez.b(i1, i1, acwn.a(21, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext))));
          ((URLDrawable)localObject).setDecodeHandler(bhez.c);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        if (!TextUtils.isEmpty(paramacwr)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramacwr);
        }
        if (paramGdtVideoData.needReport()) {
          this.jdField_a_of_type_Acxz = new acxz(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene());
        }
        u();
        return;
        bool = false;
      }
      catch (Exception paramacwr)
      {
        for (;;)
        {
          QLog.e("GdtVideoCommonView", 1, "getCoverUrl", paramacwr);
        }
      }
    }
  }
  
  public void setGdtVideoCloseIcon(int paramInt) {}
  
  public void setGdtVideoFcIcon(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setLoadListener(acxv paramacxv)
  {
    this.jdField_a_of_type_Acxv = paramacxv;
  }
  
  public void setOnVideoFullScreen(acxx paramacxx)
  {
    this.jdField_a_of_type_Acxx = paramacxx;
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
      localObject1 = acwn.a((Activity)localObject1);
      int i1 = localObject1[0];
      ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
      ((ViewGroup.LayoutParams)localObject2).height = i1;
      setLayoutParams((ViewGroup.LayoutParams)localObject2);
      setGdtVideoFcIcon(2130841764);
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
    setGdtVideoFcIcon(2130841765);
    setGdtVideoCloseIcon(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView
 * JD-Core Version:    0.7.0.1
 */
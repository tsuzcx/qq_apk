package com.tencent.gdtad.views.video;

import android.app.Activity;
import android.content.BroadcastReceiver;
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
import com.tencent.ad.tangram.Ad;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;
import com.tencent.gdtad.util.GdtAppOpenUtil;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.volume.VolumeChangeObserver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
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

public class GdtVideoCommonView
  extends RelativeLayout
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener
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
  private final GdtImpressionReporter.GdtVideoReportInfo jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo = new GdtImpressionReporter.GdtVideoReportInfo();
  private GdtVideoCommonView.HeadsetDetectReceiver jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$HeadsetDetectReceiver;
  private GdtVideoCommonView.LoadListener jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener;
  private GdtVideoCommonView.SilentModeReceiver jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$SilentModeReceiver;
  private GdtVideoCommonView.VideoFullScreenListener jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener;
  private GdtVideoData jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
  private GdtVideoReportListenerImp jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
  private VolumeChangeObserver jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver;
  private ResizeURLImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new GdtVideoCommonView.9(this);
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private ISPlayerVideoView jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtVideoCommonView.6(this);
  public String a;
  private ArrayList<GdtVideoCommonView.VideoListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = 10000;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new GdtVideoCommonView.7(this);
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
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
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private volatile boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = -16777216;
  private boolean jdField_l_of_type_Boolean = true;
  private boolean m = true;
  private boolean n = false;
  
  public GdtVideoCommonView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559171, this);
    i();
  }
  
  public GdtVideoCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559171, this);
    i();
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setStateOfMediaSound volume =");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" viewReusmed ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isFromVolumeChanged ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" isSilentMode = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(", isVolumOpen = ");
      localStringBuilder.append(this.m);
      localStringBuilder.append(", hasNotifyCompleted = ");
      localStringBuilder.append(this.n);
      localStringBuilder.append("，isOutputMute = ");
      localStringBuilder.append(paramBoolean3);
      QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
      if (paramInt > 0)
      {
        if ((paramBoolean3) && (!paramBoolean2))
        {
          this.m = false;
          this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840487);
        }
        else
        {
          this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840488);
          this.m = true;
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705320));
          }
        }
      }
      else
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130840487);
        this.m = false;
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705327));
        }
      }
      paramInt = this.jdField_a_of_type_Int;
      if ((paramInt != 6) && (paramInt != 8) && (paramInt != 7)) {
        b(this.m);
      }
      s();
    }
  }
  
  private void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playVideo startElapsed -->");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if ((localObject != null) && (!((ISuperPlayer)localObject).isPlaying()) && (this.jdField_a_of_type_Int != 3))
    {
      this.jdField_a_of_type_Int = 3;
      String str = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getTencent_video_id();
      localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getUrl();
      StringBuffer localStringBuffer = new StringBuffer("playVideo url=");
      localStringBuffer.append((String)localObject);
      localStringBuffer.append(",vid=");
      localStringBuffer.append(str);
      if (ImaxAdVideoPreloadManager.a(str))
      {
        localObject = ImaxAdVideoPreloadManager.a(str);
        localStringBuffer.append(",changeUrl=");
        localStringBuffer.append((String)localObject);
      }
      QLog.i("GdtVideoCommonView", 1, localStringBuffer.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = SuperPlayerFactory.createVideoInfoForUrl((String)localObject, 104, str, null);
      }
      else
      {
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localObject = SuperPlayerFactory.createVideoInfoForTVideo(str);
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
      m();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, (SuperPlayerVideoInfo)localObject, paramLong);
      if (this.jdField_a_of_type_Int == 8)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playVideo STATE_ERROR return -->");
        ((StringBuilder)localObject).append(paramLong);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        return;
      }
      c();
    }
  }
  
  private void a(Context paramContext)
  {
    if (QQVideoPlaySDKManager.a())
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
      ((GdtVideoCommonView.VideoListener)localIterator.next()).a(paramView);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("letsShowOff ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mVideoState ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
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
    else
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    s();
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      QLog.i("VideoGdtGdtVideoCommonView", 1, "installSDK");
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), new GdtVideoCommonView.3(this, paramContext));
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
    paramContext = new StringBuilder();
    paramContext.append("initVideo ");
    paramContext.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, paramContext.toString());
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
    if (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView != null)
    {
      setBackgroundColor(this.jdField_l_of_type_Int);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(this.jdField_l_of_type_Int);
      paramContext = this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
      if ((paramContext instanceof View))
      {
        paramContext = (View)paramContext;
        paramContext.setBackgroundColor(this.jdField_l_of_type_Int);
        paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(paramContext, 0);
      }
      else
      {
        QLog.i("GdtVideoCommonView", 1, "!mVideoView instanceof View)");
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 110, this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
      paramContext = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
      if (paramContext == null)
      {
        QLog.i("GdtVideoCommonView", 1, "initVideo return mVideoPlayer == null");
        return;
      }
      paramContext.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnTVideoNetInfoUpdateListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      m();
      paramContext = new StringBuilder();
      paramContext.append("initVideo isSilentMode = ");
      paramContext.append(this.jdField_b_of_type_Boolean);
      paramContext.append(", isVolumOpen = ");
      paramContext.append(this.m);
      QLog.i("GdtVideoCommonView", 1, paramContext.toString());
      if (this.jdField_b_of_type_Boolean) {
        this.m = false;
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(this.m ^ true);
      a(this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3), true, false, this.m ^ true);
      a(this.jdField_b_of_type_Long);
    }
  }
  
  private void i()
  {
    if (NetworkUtil.isWifiEnabled(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_c_of_type_Int = 1;
    } else if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_c_of_type_Int = 2;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("netType ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
    QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView = ((ResizeURLImageView)findViewById(2131367595));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131370396);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131366460);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131367599);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367591));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367589));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367590));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373130));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131377124));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131377126));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379063));
    int i1 = GdtUIUtils.a(5.0F, getResources());
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367598));
    GdtUIUtils.a(this.jdField_e_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367596));
    GdtUIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364703));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131367594);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367592));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367593);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getContext().getSystemService("audio"));
    ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver = new VolumeChangeObserver(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver.a();
    this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver.a(new GdtVideoCommonView.1(this));
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$HeadsetDetectReceiver = new GdtVideoCommonView.HeadsetDetectReceiver(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.HEADSET_PLUG");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$HeadsetDetectReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$SilentModeReceiver = new GdtVideoCommonView.SilentModeReceiver(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.media.RINGER_MODE_CHANGED");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$SilentModeReceiver, (IntentFilter)localObject);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131362844);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367541));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131367539));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367542));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367540));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131380584);
    a();
  }
  
  private void j()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!(localObject instanceof QQAppInterface))) {
      if (AppSetting.jdField_d_of_type_Boolean) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject = (AccessibilityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((!bool1) || (!bool2)) {
          break label79;
        }
        bool1 = true;
        AppSetting.jdField_d_of_type_Boolean = bool1;
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GdtVideoCommonView", 1, "initAppSettingInOntherProcess", localThrowable);
      }
      return;
      label79:
      boolean bool1 = false;
    }
  }
  
  private void k()
  {
    if (!b())
    {
      localGdtVideoData = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
      if ((localGdtVideoData != null) && (!localGdtVideoData.isLoop()) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getProductType() != 19))
      {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        q();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        l();
        break label223;
      }
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
    q();
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
    if ((localGdtVideoData != null) && (localGdtVideoData.getPlayScene() == 7) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null))
    {
      b();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label223:
    s();
  }
  
  private void l()
  {
    if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateDownloadBtnLable ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
      if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd() instanceof GdtAd)) {
        localObject = (GdtAd)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd();
      } else {
        localObject = null;
      }
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateDownloadBtnLable gdtAd == null ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if (((GdtAd)localObject).isAppProductType())
      {
        String str = ((GdtAd)localObject).getAppPackageName();
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(this.jdField_a_of_type_AndroidContentContext, str))
        {
          this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705325));
          return;
        }
        if (GdtAppOpenUtil.a(this.jdField_a_of_type_AndroidContentContext, ((GdtAd)localObject).getAppPackageName()))
        {
          this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705317));
          return;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705321));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705328));
    }
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null))
    {
      if (((GdtVideoData)localObject).isLoop()) {
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(true);
      } else {
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(false);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setVideoPlayByData dataLoop=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop());
      ((StringBuilder)localObject).append(",videoLoop = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isLoopBack());
      QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "setVideoPlayByData failed");
  }
  
  private void n()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.5(this));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doStartPlay ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
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
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(this.m ^ true);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
    this.jdField_a_of_type_Int = 5;
    c();
    a(this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3), true, false, this.m ^ true);
  }
  
  private void o()
  {
    StringBuilder localStringBuilder;
    if (a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseVideoInternal ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      this.jdField_a_of_type_Int = 6;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      c();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseVideoInternal return ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    }
    b(false);
  }
  
  private void p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeVideByNet netType ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    int i1 = this.jdField_c_of_type_Int;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        if (this.jdField_d_of_type_Boolean)
        {
          n();
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        return;
      }
      n();
      return;
    }
    FMToastUtil.a(2131689586);
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.c(2);
    c();
  }
  
  private void q()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void r()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void s()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      findViewById(2131370242).setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void t()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(new GdtVideoCommonView.10(this));
    }
  }
  
  private void u()
  {
    Object localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localObject == null)
    {
      QLog.i("GdtVideoCommonView", 1, "checkIsCompleted return mVideoPlayer == null");
      return;
    }
    long l1 = ((ISuperPlayer)localObject).getCurrentPositionMs();
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
    if ((localObject != null) && (((GdtVideoData)localObject).isLoop()))
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (Math.abs(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() - l1) < 1000L)
      {
        if (!this.n) {
          y();
        }
        this.n = true;
      }
      else
      {
        this.n = false;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtVideoCommonView.11(this), 300L);
    }
  }
  
  private void v()
  {
    GdtVideoReportListenerImp localGdtVideoReportListenerImp = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
    if (localGdtVideoReportListenerImp != null) {
      localGdtVideoReportListenerImp.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
    }
    b(false);
  }
  
  private void w()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
    if (localObject != null)
    {
      int i1 = this.jdField_d_of_type_Int;
      if (i1 > 0)
      {
        ((GdtVideoReportListenerImp)localObject).a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, i1);
        this.jdField_d_of_type_Int = -1;
      }
      else
      {
        ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
        if (localISuperPlayer == null)
        {
          QLog.i("GdtVideoCommonView", 1, "notifyStarted return mVideoPlayer == null");
          return;
        }
        ((GdtVideoReportListenerImp)localObject).a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, localISuperPlayer.getCurrentPositionMs());
      }
      u();
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GdtVideoCommonView.VideoListener)((Iterator)localObject).next()).b(this);
    }
  }
  
  private void x()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
    if (localObject != null)
    {
      ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
      if (localISuperPlayer != null) {
        ((GdtVideoReportListenerImp)localObject).b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, localISuperPlayer.getCurrentPositionMs(), this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GdtVideoCommonView.VideoListener)((Iterator)localObject).next()).c(this);
    }
    b(false);
  }
  
  private void y()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
    if (localObject != null) {
      ((GdtVideoReportListenerImp)localObject).a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GdtVideoCommonView.VideoListener)((Iterator)localObject).next()).d(this);
    }
    b(false);
  }
  
  public long a()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer == null) {
      return 0L;
    }
    return localISuperPlayer.getCurrentPositionMs();
  }
  
  public GdtImpressionReporter.GdtVideoReportInfo a()
  {
    return this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo;
  }
  
  public void a()
  {
    j();
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705329));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription(HardCodeUtil.a(2131705330));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" doResumeVideo ");
    localStringBuilder2.append(paramInt);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" isViewResume ");
    localStringBuilder2.append(paramBoolean1);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" stopPlayByUser ");
    localStringBuilder2.append(paramBoolean2);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mVideoState ");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder2.append(" ");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    QLog.i("GdtVideoCommonView", 1, localStringBuilder1.toString());
    if (!paramBoolean2)
    {
      if (!paramBoolean1) {
        return;
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
      case 4: 
      case 6: 
        p();
      }
    }
  }
  
  public void a(GdtVideoCommonView.VideoListener paramVideoListener)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramVideoListener)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramVideoListener);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_Int == 5);
  }
  
  public void b()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    r();
    int i1 = this.jdField_a_of_type_Int;
    if ((i1 != 6) && (i1 != 4))
    {
      a(this.jdField_b_of_type_Long);
      return;
    }
    a(2, this.jdField_a_of_type_Boolean, false);
  }
  
  public boolean b()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public void c()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.2(this));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateView ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705322));
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    int i1 = this.jdField_a_of_type_Int;
    if (i1 != 3)
    {
      if (i1 != 5)
      {
        if (i1 != 6)
        {
          if (i1 != 7)
          {
            if (i1 != 8)
            {
              this.jdField_c_of_type_AndroidViewView.setVisibility(8);
              this.jdField_e_of_type_AndroidViewView.setVisibility(8);
              this.jdField_f_of_type_AndroidViewView.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
              this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
              q();
            }
            else
            {
              this.jdField_c_of_type_AndroidViewView.setVisibility(8);
              this.jdField_e_of_type_AndroidViewView.setVisibility(8);
              this.jdField_f_of_type_AndroidViewView.setVisibility(0);
              this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(8);
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
              q();
              v();
            }
          }
          else
          {
            k();
            y();
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          if (this.jdField_e_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(8);
          }
          else
          {
            localObject = this.jdField_a_of_type_AndroidContentContext;
            if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
              this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
            }
          }
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          q();
          x();
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_Boolean = false;
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        q();
        a(false);
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
        w();
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      q();
    }
    s();
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseVideo ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = false;
    o();
  }
  
  public void e()
  {
    this.jdField_e_of_type_Boolean = true;
    o();
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeVideo ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    r();
    a(1, this.jdField_a_of_type_Boolean, this.jdField_e_of_type_Boolean);
    if (this.jdField_i_of_type_Boolean) {
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(3846);
    }
    l();
  }
  
  public void g()
  {
    QLog.i("GdtVideoCommonView", 1, "releaseMediaPlayer");
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null)
    {
      localISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
    }
  }
  
  public void h()
  {
    QLog.i("GdtVideoCommonView", 1, "onDestroy");
    g();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver;
    if (localObject1 != null) {
      ((VolumeChangeObserver)localObject1).b();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
    if (localObject1 != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject1);
    }
    localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$HeadsetDetectReceiver;
      if (localObject2 != null) {
        ((Context)localObject1).unregisterReceiver((BroadcastReceiver)localObject2);
      }
    }
    localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$SilentModeReceiver;
      if (localObject2 != null) {
        ((Context)localObject1).unregisterReceiver((BroadcastReceiver)localObject2);
      }
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (l1 - this.jdField_d_of_type_Long < 350L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick too fast not allowed  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      this.jdField_d_of_type_Long = l1;
      int i2 = paramView.getId();
      int i1 = 0;
      switch (i2)
      {
      default: 
        break;
      case 2131367599: 
        if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0) {
          i1 = 1;
        }
        a(i1 ^ 0x1);
        a(paramView);
        break;
      case 2131367598: 
        localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
        if (localObject == null)
        {
          QLog.i("GdtVideoCommonView", 1, "gdt_video_volume_switch click return mVideoPlayer == null");
        }
        else if (((ISuperPlayer)localObject).isOutputMute())
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
      case 2131367596: 
        localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener;
        if (localObject != null) {
          if (this.jdField_i_of_type_Boolean) {
            ((GdtVideoCommonView.VideoFullScreenListener)localObject).a();
          } else {
            ((GdtVideoCommonView.VideoFullScreenListener)localObject).b();
          }
        }
        break;
      case 2131367592: 
      case 2131367593: 
        b();
        break;
      case 2131367590: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick  gdt_video_center_play mVideoState ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        b();
        break;
      case 2131367589: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick  gdt_video_center_pause mVideoState ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.b(1);
        e();
        break;
      case 2131367541: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click playagain mVideoState ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        b();
        break;
      case 2131367539: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click download mVideoState ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        localObject = this.jdField_a_of_type_AndroidContentContext;
        if ((localObject != null) && ((localObject instanceof Activity)))
        {
          localObject = (Activity)localObject;
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.jdField_c_of_type_Int = 7;
          localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
          localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd());
          localParams.jdField_a_of_type_Boolean = false;
          localParams.jdField_b_of_type_Boolean = true;
          GdtHandler.a(localParams);
        }
        break;
      case 2131366460: 
        a(this.jdField_b_of_type_Long);
        break;
      case 2131364703: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick  closeBtn exitFullScreen ");
        ((StringBuilder)localObject).append(this.jdField_i_of_type_Boolean);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        if (this.jdField_i_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener;
          if (localObject != null) {
            ((GdtVideoCommonView.VideoFullScreenListener)localObject).a();
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidContentContext;
          if (localObject != null)
          {
            localObject = (Activity)localObject;
            ((Activity)localObject).finish();
            ((Activity)localObject).overridePendingTransition(17432576, 17432577);
          }
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_Int = 7;
    c();
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onCompletion");
    paramISuperPlayer.append(this.jdField_a_of_type_Int);
    QLog.i("GdtVideoCommonView", 1, paramISuperPlayer.toString());
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onError errorType ");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(" errorCode ");
    paramISuperPlayer.append(paramInt3);
    paramISuperPlayer.append(" extraInfo ");
    paramISuperPlayer.append(paramString);
    QLog.i("GdtVideoCommonView", 1, paramISuperPlayer.toString());
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.a(paramInt2, paramInt3);
    paramISuperPlayer = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener;
    if ((paramISuperPlayer != null) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      paramISuperPlayer.a(false);
    }
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705318), 0).show();
    c();
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(GdtUIUtils.a(paramInt * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    paramSeekBar = new StringBuilder();
    paramSeekBar.append("onStartTrackingTouch ");
    paramSeekBar.append(this.jdField_a_of_type_Int);
    QLog.i("GdtVideoCommonView", 1, paramSeekBar.toString());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStopTrackingTouch ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = ((int)(paramSeekBar.getProgress() * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    r();
    int i1 = this.jdField_a_of_type_Int;
    if ((i1 >= 4) && (i1 <= 6))
    {
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)
      {
        QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch return mVideoPlayer == null");
      }
      else if ((i1 != 6) && (i1 != 5) && (i1 != 4))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onStopTrackingTouch no answer ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
      }
      else
      {
        i1 = this.jdField_a_of_type_Int;
        if ((i1 == 4) || (i1 == 6)) {
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
        }
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(this.jdField_d_of_type_Int);
        this.jdField_a_of_type_Int = 5;
        c();
      }
    }
    else {
      a(this.jdField_d_of_type_Int);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
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
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onTVideoNetInfoUpdate size:");
    paramISuperPlayer.append(this.jdField_c_of_type_Long);
    paramISuperPlayer.append(" hasShowTips ");
    paramISuperPlayer.append(this.jdField_j_of_type_Boolean);
    QLog.i("GdtVideoCommonView", 1, paramISuperPlayer.toString());
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onVideoPrepared ");
    paramISuperPlayer.append(this.jdField_a_of_type_Int);
    paramISuperPlayer.append(" isViewResume ");
    paramISuperPlayer.append(this.jdField_a_of_type_Boolean);
    paramISuperPlayer.append(" ");
    paramISuperPlayer.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtVideoCommonView", 1, paramISuperPlayer.toString());
    paramISuperPlayer = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener;
    if ((paramISuperPlayer != null) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      paramISuperPlayer.a(true);
    }
    if (this.jdField_a_of_type_Long < 0L)
    {
      paramISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
      if (paramISuperPlayer != null)
      {
        this.jdField_a_of_type_Long = paramISuperPlayer.getDurationMs();
        if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() <= 0L) {
          this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setDurationMillis(this.jdField_a_of_type_Long);
        }
        if ((this.jdField_a_of_type_Long < 1000L) && (!this.jdField_h_of_type_Boolean))
        {
          this.jdField_h_of_type_Boolean = true;
          QLog.i("GdtVideoCommonView", 1, "Video error for reason:<1s ");
          if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null)
          {
            this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.c(3);
            this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new GdtVideoCommonView.4(this));
      }
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      break;
    case 3: 
    case 5: 
      this.jdField_a_of_type_Int = 4;
      a(3, this.jdField_a_of_type_Boolean, this.jdField_e_of_type_Boolean);
    }
    paramISuperPlayer = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramISuperPlayer.hasNext()) {
      ((GdtVideoCommonView.VideoListener)paramISuperPlayer.next()).a(this);
    }
  }
  
  public void setData(GdtVideoData paramGdtVideoData)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData = paramGdtVideoData;
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isDirectPlay();
    this.jdField_l_of_type_Int = paramGdtVideoData.getVideoDefaultBackgroundColor();
    this.jdField_k_of_type_Boolean = paramGdtVideoData.isForceNotShowControllerView();
    int i1;
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Int != 1)) {
      i1 = 12;
    } else {
      i1 = 11;
    }
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.a(i1);
    this.jdField_b_of_type_Long = paramGdtVideoData.getStartPositionMillis();
    this.m = paramGdtVideoData.isVolumOpen();
    boolean bool;
    if (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    a(this.jdField_a_of_type_AndroidContentContext);
    if (!TextUtils.isEmpty(paramGdtVideoData.getCoverUrl())) {
      try
      {
        URL localURL = new URL(paramGdtVideoData.getCoverUrl());
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setImage(localURL);
      }
      catch (Exception localException)
      {
        QLog.e("GdtVideoCommonView", 1, "getCoverUrl", localException);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_logo();
    String str = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_image_name();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Resources localResources = getResources();
      localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130845650);
      localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130845650);
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      i1 = AIOUtils.b(55.0F, localResources);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(i1, i1, GdtUIUtils.a(21, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext))));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.c);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (paramGdtVideoData.needReport()) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp = new GdtVideoReportListenerImp(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene());
    }
    s();
  }
  
  public void setGdtVideoCloseIcon(int paramInt) {}
  
  public void setGdtVideoFcIcon(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setLoadListener(GdtVideoCommonView.LoadListener paramLoadListener)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener = paramLoadListener;
  }
  
  public void setOnVideoFullScreen(GdtVideoCommonView.VideoFullScreenListener paramVideoFullScreenListener)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener = paramVideoFullScreenListener;
  }
  
  public void setisFullScreen(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_i_of_type_Boolean != paramBoolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      Object localObject1;
      Object localObject2;
      if (paramBoolean)
      {
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
        localObject1 = GdtUIUtils.a((Activity)localObject1);
        int i1 = localObject1[0];
        ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
        ((ViewGroup.LayoutParams)localObject2).height = i1;
        setLayoutParams((ViewGroup.LayoutParams)localObject2);
        setGdtVideoFcIcon(2130841851);
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
      else
      {
        localObject1 = (Activity)getContext();
        ((Activity)localObject1).getWindow().setFlags(1024, 8);
        ((Activity)localObject1).setRequestedOrientation(1);
        ((Activity)localObject1).getWindow().getDecorView().setSystemUiVisibility(this.jdField_g_of_type_Int);
        localObject1 = getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.jdField_e_of_type_Int;
        ((ViewGroup.LayoutParams)localObject1).height = this.jdField_f_of_type_Int;
        localObject2 = getParent();
        if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
          ((ViewGroup)localObject2).setPadding(this.jdField_j_of_type_Int, this.jdField_h_of_type_Int, this.jdField_k_of_type_Int, this.jdField_i_of_type_Int);
        }
        setLayoutParams((ViewGroup.LayoutParams)localObject1);
        setGdtVideoFcIcon(2130841852);
        setGdtVideoCloseIcon(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView
 * JD-Core Version:    0.7.0.1
 */
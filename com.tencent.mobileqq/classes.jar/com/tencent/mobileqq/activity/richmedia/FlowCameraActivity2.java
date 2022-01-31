package com.tencent.mobileqq.activity.richmedia;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoState;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.ForceReleaseLockOnPause;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr.ViewBitmapSource;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwAutoSegmentMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwOutputNotify;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.SurfacePreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.mobileqq.shortvideo.widget.SimpleProgressBar;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar.DelEvent;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.HorizontalItemIndicator;
import com.tencent.mobileqq.widget.TransCircleMaskView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xlh;
import xli;
import xlj;
import xlk;
import xll;
import xlm;
import xln;
import xlo;
import xlp;
import xlq;
import xlr;
import xls;
import xlu;
import xlv;
import xlw;
import xlx;
import xly;
import xlz;
import xma;
import xmb;
import xmc;
import xmd;

@TargetApi(14)
public class FlowCameraActivity2
  extends FlowActivity
  implements View.OnClickListener, View.OnLongClickListener, RMVideoSwitchCameraPicMgr.ViewBitmapSource, RMViewSTInterface, ImageViewVideoPlayer.IMPlayerEndListener, TCProgressBar.DelEvent
{
  public double a;
  float jdField_a_of_type_Float = 0.0F;
  public int a;
  long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new xlv(this);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  public View.OnTouchListener a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private FlowComponentInterface jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
  public FlowPlusPanel a;
  public RMVideoStateMgr a;
  public CameraCover a;
  public CameraGLSurfaceView a;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  private SVHwAutoSegmentMgr jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr = new SVHwAutoSegmentMgr();
  private volatile SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new xlo(this);
  CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  SimpleProgressBar jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar;
  public TCProgressBar a;
  public QQCustomDialog a;
  HorizontalItemIndicator jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator;
  TransCircleMaskView jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  Runnable jdField_a_of_type_JavaLangRunnable = new xlh(this);
  public String a;
  public boolean a;
  public double b;
  float jdField_b_of_type_Float = 0.0F;
  private long jdField_b_of_type_Long;
  View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new xll(this);
  View jdField_b_of_type_AndroidViewView;
  public Button b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  Runnable jdField_b_of_type_JavaLangRunnable = new xlx(this);
  public String b;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  public Button c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  Runnable jdField_c_of_type_JavaLangRunnable = new xlr(this);
  private String jdField_c_of_type_JavaLangString;
  public int d;
  View jdField_d_of_type_AndroidViewView;
  Button jdField_d_of_type_AndroidWidgetButton;
  public boolean d;
  public int e;
  public View e;
  boolean e;
  int f;
  public View f;
  public boolean f;
  int g;
  public View g;
  public boolean g;
  int jdField_h_of_type_Int = 0;
  View jdField_h_of_type_AndroidViewView;
  boolean jdField_h_of_type_Boolean;
  int i;
  public View i;
  public boolean i;
  int j;
  public View j;
  public boolean j;
  public int k;
  View jdField_k_of_type_AndroidViewView;
  boolean jdField_k_of_type_Boolean;
  int l;
  public boolean l;
  private int m;
  public boolean m;
  private int n;
  public boolean n;
  private int jdField_o_of_type_Int = 0;
  boolean jdField_o_of_type_Boolean = false;
  private int jdField_p_of_type_Int = 1;
  private boolean jdField_p_of_type_Boolean = true;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.a());
      }
      int i1 = VideoEnvironment.a("AVCodec", null, true);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "LoadExtractedShortVideoSo :code=" + i1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public FlowCameraActivity2()
  {
    this.jdField_l_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new xlk(this);
  }
  
  private void B()
  {
    if (this.jdField_q_of_type_Int == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_q_of_type_Int = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void C()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
    {
      RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, f1, localRMVideoClipSpec.jdField_e_of_type_Int);
    }
  }
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mHwEncoder=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new xmc(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setEnabled(true);
    }
    this.jdField_j_of_type_AndroidViewView.setEnabled(true);
    VideoAnimation.a(this.jdField_c_of_type_AndroidWidgetImageView, false, 250);
    if (this.jdField_i_of_type_AndroidViewView.isEnabled()) {
      this.jdField_i_of_type_AndroidViewView.setEnabled(false);
    }
    this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130843130);
    a(1002, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().b();
    this.jdField_i_of_type_AndroidViewView.setEnabled(true);
  }
  
  private void F()
  {
    int i2 = 1;
    int i3 = 2;
    Object localObject1 = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Object localObject2;
    int i1;
    if ((localObject1 != null) && (HwEnvData.b()) && (this.s) && (this.jdField_o_of_type_Int == 0) && (VideoEnvironment.b(2)))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = new SVHwEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, ((RMVideoClipSpec)localObject2).jdField_e_of_type_Int, ((RMVideoClipSpec)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(-1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000);
      if (CodecParam.jdField_o_of_type_Int != 16) {
        break label296;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (CodecParam.jdField_p_of_type_Int == 2) {
        i2 = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(CodecParam.jdField_q_of_type_Int, i1, 128000, i2);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null) {
          break label321;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        localObject2 = RichmediaClient.a().a();
        C();
        i1 = i3;
        if (this.jdField_g_of_type_Boolean) {
          i1 = 3;
        }
        localObject1 = ((VideoCompoundController)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder, (SessionInfo)localObject1, i1);
        this.jdField_a_of_type_JavaLangString = ((CompoundProcessor)localObject1).a();
        LogTag.a(this.jdField_a_of_type_JavaLangString, "start", "[peak]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((SVHwOutputNotify)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_e_of_type_Boolean);
        return;
        label296:
        if (CodecParam.jdField_o_of_type_Int != 12) {
          break label342;
        }
        i1 = 2;
        break;
        if (CodecParam.jdField_p_of_type_Int != 3) {
          i2 = 2;
        }
      }
      label321:
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@] previewSizeAdjustUI: rmStateMgr.videoContext=null,do not hwencode...");
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
      return;
      label342:
      i1 = 1;
    }
  }
  
  private void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt, paramFloat, true, ScreenUtil.a(5.0F));
    int i1 = (int)(paramInt * paramFloat);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = i1;
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  private void b(Bundle paramBundle)
  {
    this.y = paramBundle.getBoolean("enable_big_video", false);
    this.w = paramBundle.getBoolean("enable_local_video", false);
    this.x = paramBundle.getBoolean("enable_front", false);
    this.jdField_n_of_type_Int = paramBundle.getInt("set_sdcard_min_size", 0);
    this.jdField_o_of_type_Int = paramBundle.getInt("from_type", 0);
    this.jdField_p_of_type_Int = paramBundle.getInt("clip_strategy", 1);
    FlowCameraMqqAction.jdField_a_of_type_Int = this.jdField_o_of_type_Int;
    if ((this.jdField_n_of_type_Int >= 57671680L) && (this.jdField_n_of_type_Int <= 314572800L)) {
      com.tencent.mobileqq.shortvideo.util.storage.StorageManager.jdField_a_of_type_Long = this.jdField_n_of_type_Int;
    }
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("short_video_refer");
    paramBundle = paramBundle.getString("set_user_callback");
    if (paramBundle == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramBundle = Class.forName(paramBundle).newInstance();
          if ((paramBundle instanceof FlowComponentInterface))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = ((FlowComponentInterface)paramBundle);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.b(this.jdField_c_of_type_JavaLangString);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("FlowCameraActivity", 2, "initComponentParamData:exp =" + paramBundle);
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    label133:
    for (;;)
    {
      return;
      HwEnvData.b = paramBundle.getBoolean("key_video_presend_enable", false);
      HwEnvData.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_video_hard_encode_enable", false);
      float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
      if (f1 > 0.0F) {
        HwEnvData.jdField_a_of_type_Int = (int)(f1 * 1000.0F);
      }
      if (HwEnvData.a()) {
        this.s = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(16);
      }
      for (;;)
      {
        if (!this.y) {
          break label133;
        }
        HwEnvData.jdField_a_of_type_Boolean = false;
        HwEnvData.b = false;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FlowCameraActivity", 2, "enable big video: mComonent_BigVideo=" + this.y);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
      }
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    }
    int i1;
    int i2;
    do
    {
      return false;
      i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
      i2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d();
    } while ((i1 > 0) || (i2 > 0) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null) || (this.jdField_c_of_type_AndroidWidgetButton.isEnabled()));
    return true;
  }
  
  public void A()
  {
    super.finish();
  }
  
  public void G_()
  {
    E();
    b(true);
  }
  
  public void Y_() {}
  
  int a()
  {
    if (this.jdField_f_of_type_Int == 0) {
      this.jdField_f_of_type_Int = getResources().getDimensionPixelSize(2131559177);
    }
    return this.jdField_f_of_type_Int;
  }
  
  int a(int paramInt)
  {
    int i1 = paramInt;
    if (HwEnvData.a())
    {
      int i2 = paramInt % 16;
      i1 = paramInt;
      if (i2 > 0) {
        i1 = paramInt + (16 - i2);
      }
    }
    return i1;
  }
  
  int a(int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getMeasuredHeight();
    int i4 = (int)(paramInt2 * FlowCameraConstant.jdField_a_of_type_Float);
    int i1;
    int i2;
    if (i3 <= this.jdField_a_of_type_Float)
    {
      i1 = (int)(i3 * 0.83F);
      i2 = (i3 - i1) / 2;
      i3 = i1 * paramInt2 / i4;
      i1 = i1 * paramInt1 / i4;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = i4;
      paramInt1 = i3;
    }
    for (;;)
    {
      if (paramBoolean) {
        i1 = paramInt1;
      }
      i3 = paramInt1;
      if (paramInt1 % 2 != 0) {
        i3 = paramInt1 - 1;
      }
      paramInt1 = i1;
      if (i1 % 2 != 0) {
        paramInt1 = i1 - 1;
      }
      paramArrayOfInt[2] = i3;
      paramArrayOfInt[3] = paramInt1;
      paramArrayOfInt[4] = paramInt2;
      paramArrayOfInt[5] = i4;
      return i2;
      i2 = (int)this.jdField_a_of_type_Float;
      i1 = (int)(this.jdField_a_of_type_Float * paramInt1 / paramInt2);
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = ((int)(i3 * paramInt2 / this.jdField_a_of_type_Float));
      i3 = (i3 - i2) / 2;
      paramInt1 = i2;
      i2 = i3;
    }
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_n_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildAt(0);
      if (TextureView.class.isInstance(localView)) {
        return ((TextureView)localView).getBitmap(paramInt1, paramInt2);
      }
    }
    return null;
  }
  
  protected FlowPanel a()
  {
    if (this.jdField_k_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowPlusPanel = ((FlowPlusPanel)FlowPanelFactory.a(this, 0));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowPlusPanel;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      if (!this.jdField_d_of_type_Boolean) {}
    }
    else {
      while ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c() > 0) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d() > 0)) {
        return;
      }
    }
    Object localObject = getResources();
    int i2;
    int i1;
    if (paramFloat > 0.0F)
    {
      ((Resources)localObject).getDimensionPixelSize(2131559176);
      i2 = a();
      if (this.jdField_p_of_type_Boolean)
      {
        ((Resources)localObject).getDimensionPixelSize(2131559180);
        i1 = c();
        localObject = Integer.valueOf(-14342358);
        a(i2, i1, ((Integer)localObject).intValue());
        if (paramFloat <= 0.0F) {
          break label410;
        }
        this.jdField_d_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.a();
        this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.rgb(18, 183, 245));
        this.jdField_b_of_type_AndroidWidgetButton.setText(2131438144);
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130843137);
        if (!this.jdField_g_of_type_Boolean)
        {
          if (!this.y) {
            break label359;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setTextSize(2, 18.0F);
          i1 = ScreenUtil.a(80.0F);
          localObject = this.jdField_b_of_type_AndroidWidgetButton.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = i1;
          ((ViewGroup.LayoutParams)localObject).width = i1;
          this.jdField_b_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    for (;;)
    {
      FlowCameraMqqAction.a("", "0X8005F5D");
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setContentDescription("短视频模式，可调，用一个手指左右轻扫来调整");
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("录制短视频");
      return;
      ((Resources)localObject).getDimensionPixelSize(2131559179);
      i1 = b();
      break;
      a();
      i2 = ((Resources)localObject).getDimensionPixelSize(2131559176);
      if (this.jdField_p_of_type_Boolean) {
        c();
      }
      for (i1 = ((Resources)localObject).getDimensionPixelSize(2131559180);; i1 = ((Resources)localObject).getDimensionPixelSize(2131559179))
      {
        localObject = Integer.valueOf(1275068416);
        break;
        b();
      }
      label359:
      this.jdField_b_of_type_AndroidWidgetButton.setTextSize(2, 21.0F);
      i1 = ScreenUtil.a(110.0F);
      localObject = this.jdField_b_of_type_AndroidWidgetButton.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i1;
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.jdField_b_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label410:
    c(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setContentDescription("相机模式，可调，用一个手指左右轻扫来调整");
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("拍照");
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d();
      if (i1 > 0)
      {
        int i2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(i2, i1, true);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d();
        CompoundProcessor localCompoundProcessor = RichmediaClient.a().a().a(this.jdField_a_of_type_JavaLangString);
        if (localCompoundProcessor != null) {
          localCompoundProcessor.a(paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@] previewSizeAdjustUI:width=" + paramInt1 + " height=" + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FlowCameraActivity", 2, "[previewSizeAdjustUI]rmStateMgr " + null);
      }
      return;
    }
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    this.r = true;
    Object localObject;
    if (!this.jdField_g_of_type_Boolean)
    {
      e(true);
      if ((this.r) && (this.jdField_q_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
        F();
      }
      for (;;)
      {
        paramInt1 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null) {
          paramInt1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
        }
        if ((VersionUtils.c()) && (!this.jdField_c_of_type_AndroidWidgetButton.isEnabled()) && (paramInt1 <= 0)) {
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if (paramInt1 >= CodecParam.jdField_c_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        return;
        if (c())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, ((RMVideoClipSpec)localObject).jdField_e_of_type_Int, ((RMVideoClipSpec)localObject).jdField_f_of_type_Int);
          C();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(-1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("FlowCameraActivity", 2, "[@] previewSizeAdjustUI:[changeCamera] rmStateMgr.videoContext=null,do not hwencode...");
            }
            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.b();
            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
          }
        }
      }
    }
    int[] arrayOfInt = new int[6];
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    label367:
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
      if (localObject != this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView) {
        break label563;
      }
      bool = true;
      label379:
      int i2 = a(paramInt1, paramInt2, arrayOfInt, bool);
      int i3 = TransCircleMaskView.a(this);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a((View)localObject);
      localLayoutParams.width = arrayOfInt[2];
      localLayoutParams.height = arrayOfInt[3];
      localLayoutParams.topMargin = (i3 + i2);
      ((View)localObject).setLayoutParams(localLayoutParams);
      localRMVideoClipSpec.jdField_c_of_type_Int = arrayOfInt[0];
      localRMVideoClipSpec.jdField_d_of_type_Int = arrayOfInt[1];
      localRMVideoClipSpec.jdField_e_of_type_Int = paramInt1;
      localRMVideoClipSpec.jdField_f_of_type_Int = paramInt2;
      if (!this.jdField_n_of_type_Boolean) {
        break label569;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, localRMVideoClipSpec, 0);
    }
    for (;;)
    {
      localRMVideoClipSpec.jdField_e_of_type_Int = arrayOfInt[4];
      localRMVideoClipSpec.jdField_f_of_type_Int = arrayOfInt[5];
      a(localRMVideoClipSpec);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setPreviewSize(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, localRMVideoClipSpec);
      break;
      localObject = a(2131362087);
      break label367;
      label563:
      bool = false;
      break label379;
      label569:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, localRMVideoClipSpec, 0);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = paramInt1;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    if (this.jdField_p_of_type_Boolean)
    {
      localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(paramInt3);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(paramInt3);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramInt3);
      return;
      localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "onPreviewResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
    }
    if (paramInt1 == 1002)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.u = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.e();
    }
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    if (this.y)
    {
      c(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
      return;
    }
    b(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
  }
  
  void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (this.y)
    {
      c(paramInt1, paramInt2, paramArrayOfInt);
      return;
    }
    b(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    runOnUiThread(new xls(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_g_of_type_Boolean) {
        break label100;
      }
      RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      localRMVideoStateMgr.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setProgress(paramInt, paramBoolean);
      if (paramBoolean) {
        h(true);
      }
    }
    else
    {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(paramInt, i1);
    h(this.jdField_o_of_type_Boolean);
    if (this.jdField_o_of_type_Boolean)
    {
      this.jdField_o_of_type_Boolean = false;
      return;
    }
    this.jdField_o_of_type_Boolean = true;
    return;
    label100:
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(paramInt, paramBoolean);
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FlowCameraActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        h();
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624515);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969181);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363381));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FlowCameraActivity", 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  public void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof GradientDrawable)) {
      ((GradientDrawable)paramDrawable).setColor(paramInt);
    }
    while (!(paramDrawable instanceof ColorDrawable)) {
      return;
    }
    ((ColorDrawable)paramDrawable).setColor(paramInt);
  }
  
  protected void a(Bundle paramBundle)
  {
    int i2 = 1;
    super.a(paramBundle);
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.v = false;
    this.t = false;
    this.u = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.jdField_q_of_type_Boolean = false;
    this.r = false;
    FlowCameraConstant.jdField_a_of_type_Int = 2;
    FlowCameraConstant.jdField_a_of_type_Float = 0.75F;
    if (paramBundle == null) {
      return;
    }
    this.jdField_g_of_type_Boolean = paramBundle.getBoolean("flow_camera_ptv_mode", false);
    b(paramBundle);
    c(paramBundle);
    this.jdField_e_of_type_Boolean = paramBundle.getBoolean("flow_camera_use_surfaceview", false);
    this.jdField_i_of_type_Boolean = paramBundle.getBoolean("flow_camera_capture_mode", false);
    this.jdField_j_of_type_Boolean = paramBundle.getBoolean("flow_camera_video_mode", false);
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = paramBundle.getBoolean("flow_camera_show_panel", true);
      FlowCameraConstant.jdField_a_of_type_Int = 1;
      if (!CameraAbility.c()) {
        FlowCameraConstant.jdField_a_of_type_Int = 2;
      }
      FlowCameraConstant.jdField_a_of_type_Float = 1.0F;
      this.jdField_c_of_type_Int = paramBundle.getInt("flow_key_ptv_max_time", 20);
    }
    String str = paramBundle.getString("sv_config");
    boolean bool = paramBundle.getBoolean("sv_whitelist");
    paramBundle = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    if (paramBundle != null) {}
    for (int i1 = paramBundle.jdField_a_of_type_Int;; i1 = 0)
    {
      int i3 = NetworkUtil.a(this);
      if (this.jdField_g_of_type_Boolean) {
        i2 = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), i2, str, bool, i1, i3, this.jdField_c_of_type_Int);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, FlowCameraMqqAction.a(this), this))
      {
        super.finish();
        return;
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new xmb(this, this));
      paramBundle = getResources().getDisplayMetrics();
      this.jdField_a_of_type_Float = paramBundle.widthPixels;
      this.jdField_b_of_type_Float = paramBundle.heightPixels;
      this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float / this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new xlu(this, this);
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FlowCameraActivity", 2, "initData(), mPtvMode:" + this.jdField_g_of_type_Boolean + ",mCaptureMode:" + this.jdField_i_of_type_Boolean + ", config=" + str + ", white=" + bool);
      return;
    }
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2130970312, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)a(2131363402));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131362825));
    this.jdField_b_of_type_AndroidViewView = a(2131370008);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator = ((HorizontalItemIndicator)a(2131370009));
    this.jdField_c_of_type_AndroidViewView = a(2131365884);
    this.jdField_a_of_type_AndroidViewView = a(2131368934);
    this.jdField_g_of_type_AndroidViewView = a(2131369733);
    this.jdField_h_of_type_AndroidViewView = a(2131362086);
    this.jdField_e_of_type_AndroidViewView = a(2131370000);
    this.jdField_f_of_type_AndroidViewView = a(2131370001);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131368941));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)a(2131370003));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)a(2131368556));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369999));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131369737));
    this.jdField_i_of_type_AndroidViewView = a(2131370004);
    this.jdField_j_of_type_AndroidViewView = a(2131370006);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369736));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131370005));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131364382));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131364386));
    a((int)this.jdField_a_of_type_Float, 0.75F);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.a(new String[] { "照片", "短视频" });
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar = ((SimpleProgressBar)a(2131370002));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131438145);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130843112);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438147);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8355712);
      paramViewGroup = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getLayoutParams();
      if (paramViewGroup.height != this.jdField_b_of_type_Int)
      {
        paramViewGroup.height = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setLayoutParams(paramViewGroup);
      }
      if (!"mounted".equals(Environment.getExternalStorageState()))
      {
        paramViewGroup = (TextView)a(2131363409);
        paramViewGroup.setVisibility(0);
        paramViewGroup.setText(2131438140);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!CameraAbility.a())
      {
        a(2131363409).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView = new TransCircleMaskView(this);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildCount() - 2, paramViewGroup);
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("按住说话");
      if (this.jdField_g_of_type_Boolean) {
        break label861;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(64);
      label701:
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_g_of_type_Boolean);
      if (paramViewGroup == null) {
        break label873;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar = ((TCProgressBar)a(2131370010));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setMax(CodecParam.jdField_g_of_type_Int, CodecParam.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundResource(2130838676);
      if (!CameraAbility.c()) {
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(1275068416);
      if (this.jdField_i_of_type_Boolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      }
      if (this.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1275068416);
      this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(false);
      break;
      label861:
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(32);
      break label701;
      label873:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
    }
  }
  
  void a(RMVideoClipSpec paramRMVideoClipSpec)
  {
    paramRMVideoClipSpec.jdField_e_of_type_Int = 240;
    paramRMVideoClipSpec.jdField_f_of_type_Int = 240;
  }
  
  public void a(File paramFile)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
    if (a(2131369735) == null) {
      ((ViewStub)a(2131369734)).setVisibility(0);
    }
    if (this.jdField_d_of_type_AndroidViewView == null) {
      this.jdField_d_of_type_AndroidViewView = a(2131369735);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(this.jdField_d_of_type_AndroidViewView, 2131370061));
    }
    Object localObject = URLDrawable.getDrawable(paramFile, URLDrawable.URLDrawableOptions.obtain());
    ((URLDrawable)localObject).downloadImediatly();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_f_of_type_Boolean = true;
    localObject = (Button)a(this.jdField_d_of_type_AndroidViewView, 2131370062);
    Button localButton = (Button)a(this.jdField_d_of_type_AndroidViewView, 2131370063);
    ((Button)localObject).setOnClickListener(new xlm(this, paramFile));
    localButton.setOnClickListener(new xln(this, paramFile, localButton));
  }
  
  public void a(boolean paramBoolean)
  {
    f();
    E();
    if (paramBoolean) {
      b(true);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "onTouchCaptureBtn: on=" + paramBoolean1 + ", up=" + paramBoolean2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {}
    label134:
    do
    {
      return;
      if (paramBoolean2)
      {
        if (this.jdField_l_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "onTouchCaptureBtn: 发送已录制的");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e())) {
            break label134;
          }
          c(this.jdField_l_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_l_of_type_Boolean = false;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "onTouchCaptureBtn: 删除已录制的");
          }
          FlowCameraMqqAction.a("", "0X8005E93");
          break;
          if (QLog.isColorLevel()) {
            QLog.e("FlowCameraActivity", 2, "onTouchCaptureBtn: rmStateMgr.exitRecordMode() true, 段无效。");
          }
          c(false);
        }
      }
    } while (this.jdField_l_of_type_Boolean == paramBoolean1);
    this.jdField_l_of_type_Boolean = paramBoolean1;
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131438145);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("上滑取消");
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837704);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.jdField_c_of_type_Int);
      if (this.jdField_k_of_type_AndroidViewView != null) {
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130843112);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("松手取消");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837705);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.jdField_d_of_type_Int);
    if (this.jdField_k_of_type_AndroidViewView == null)
    {
      this.jdField_k_of_type_AndroidViewView = new View(this);
      this.jdField_k_of_type_AndroidViewView.setBackgroundColor(871775498);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_k_of_type_AndroidViewView, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130843109);
      return;
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  int b()
  {
    if (this.jdField_g_of_type_Int == 0) {
      this.jdField_g_of_type_Int = getResources().getDimensionPixelSize(2131559178);
    }
    return this.jdField_g_of_type_Int;
  }
  
  void b(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    int i3 = (int)(this.jdField_a_of_type_Float * FlowCameraConstant.jdField_a_of_type_Float);
    int i1;
    if (paramBoolean)
    {
      i1 = (int)this.jdField_a_of_type_Float;
      paramInt1 = (int)(paramInt1 * this.jdField_a_of_type_Float / paramInt2);
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = ((int)(i3 * paramInt2 / this.jdField_a_of_type_Float));
    }
    for (paramInt2 = i1;; paramInt2 = i1)
    {
      paramArrayOfInt[1] = a(paramArrayOfInt[1]);
      paramArrayOfInt[2] = paramInt2;
      paramArrayOfInt[3] = paramInt1;
      return;
      i1 = (int)(paramInt2 * this.jdField_b_of_type_Float / paramInt1);
      int i2 = (int)this.jdField_b_of_type_Float;
      paramArrayOfInt[0] = ((int)(this.jdField_a_of_type_Float * paramInt2 / i1));
      paramArrayOfInt[1] = ((int)(i3 * paramInt1 / this.jdField_b_of_type_Float));
      paramInt1 = i2;
    }
  }
  
  void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    paramArrayOfInt = a(2131362087);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a(paramArrayOfInt);
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    paramArrayOfInt.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int i3 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
    int i1 = this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();
    int i2 = (int)(this.jdField_a_of_type_Float * FlowCameraConstant.jdField_a_of_type_Float);
    i2 = (int)this.jdField_b_of_type_Float - i3 - i2;
    if (paramInt2 >= this.jdField_b_of_type_Float) {
      paramInt2 = i2 - i1;
    }
    for (;;)
    {
      this.jdField_f_of_type_Int = i1;
      this.jdField_h_of_type_Int = paramInt2;
      this.jdField_i_of_type_Int = (i1 * this.jdField_e_of_type_Int / paramInt1);
      this.jdField_j_of_type_Int = ((paramInt2 + i3) * this.jdField_e_of_type_Int / paramInt1);
      paramArrayOfInt = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramArrayOfInt.topMargin = (this.jdField_f_of_type_Int + ScreenUtil.a(13.0F));
      paramArrayOfInt.topMargin += ScreenUtil.a(3.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramArrayOfInt);
      if (this.jdField_j_of_type_Boolean) {
        a(5.0F);
      }
      return;
      paramInt2 = (int)this.jdField_b_of_type_Float - paramInt2;
      if (this.jdField_n_of_type_Boolean)
      {
        paramInt2 = i2 - i1;
      }
      else if (i1 >= paramInt2)
      {
        paramInt2 = i2 - i1;
      }
      else
      {
        i2 -= paramInt2;
        i1 = paramInt2;
        paramInt2 = i2;
      }
    }
  }
  
  void b(RMVideoClipSpec paramRMVideoClipSpec)
  {
    int i2 = paramRMVideoClipSpec.jdField_c_of_type_Int;
    int i3 = paramRMVideoClipSpec.jdField_d_of_type_Int;
    int i4 = GloableValue.c.length;
    int i1 = 0;
    for (;;)
    {
      int i6;
      if (i1 < i4)
      {
        int i5 = a(GloableValue.c[(i1 + 1)]);
        i6 = a(GloableValue.c[(i1 + 3)]);
        if ((i2 >= GloableValue.c[i1]) && (i3 >= i5))
        {
          paramRMVideoClipSpec.jdField_e_of_type_Int = GloableValue.c[i1];
          paramRMVideoClipSpec.jdField_f_of_type_Int = i5;
        }
      }
      else
      {
        return;
      }
      if ((i2 >= GloableValue.c[(i1 + 2)]) && (i3 >= i6))
      {
        paramRMVideoClipSpec.jdField_e_of_type_Int = GloableValue.c[(i1 + 2)];
        paramRMVideoClipSpec.jdField_f_of_type_Int = i6;
        return;
      }
      i1 += 4;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject3 = getResources().getDisplayMetrics();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    if ((VersionUtils.d()) && (!this.jdField_e_of_type_Boolean))
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext)))
      {
        ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        this.jdField_n_of_type_Boolean = false;
        if (this.jdField_g_of_type_Boolean)
        {
          ConfigurationInfo localConfigurationInfo = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
          paramBoolean = VideoEnvironment.a();
          if ((localConfigurationInfo == null) || (localConfigurationInfo.reqGlEsVersion < 131072) || (!paramBoolean)) {
            break label429;
          }
          localObject3 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
          ((FrameLayout.LayoutParams)localObject3).height = this.jdField_b_of_type_Int;
          ((FrameLayout.LayoutParams)localObject3).width = ((int)(this.jdField_b_of_type_Int * FlowCameraConstant.jdField_a_of_type_Float));
          ((FrameLayout.LayoutParams)localObject3).gravity = 49;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)a(2131362089));
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVideoContext(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((FrameLayout.LayoutParams)localObject1).height = 1;
        }
      }
    }
    for (((FrameLayout.LayoutParams)localObject1).width = 1;; ((FrameLayout.LayoutParams)localObject1).width = ((int)(this.jdField_b_of_type_Int * FlowCameraConstant.jdField_a_of_type_Float)))
    {
      ((FrameLayout.LayoutParams)localObject1).gravity = 81;
      if (this.jdField_n_of_type_Boolean) {
        ((FrameLayout.LayoutParams)localObject1).gravity = 49;
      }
      ((View)localObject2).setId(2131362087);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
      this.jdField_m_of_type_Boolean = true;
      return;
      ((CameraTextureView)localObject2).a = new TexturePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof SurfacePreviewContext))) {}
      for (((CameraPreview)localObject2).a = ((SurfacePreviewContext)localObject1);; ((CameraPreview)localObject2).a = new SurfacePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        this.jdField_n_of_type_Boolean = true;
        break;
      }
      label429:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)a(2131362089));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = null;
      ((FrameLayout.LayoutParams)localObject1).height = this.jdField_b_of_type_Int;
    }
  }
  
  boolean b()
  {
    return false;
  }
  
  int c()
  {
    if (this.jdField_h_of_type_Int == 0) {
      this.jdField_h_of_type_Int = getResources().getDimensionPixelSize(2131559180);
    }
    return this.jdField_h_of_type_Int;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(null);
    }
  }
  
  void c(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = (int)this.jdField_a_of_type_Float;
      paramInt1 = (int)(paramInt1 * this.jdField_a_of_type_Float / paramInt2);
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = ((int)(this.jdField_b_of_type_Float * paramInt2 / this.jdField_a_of_type_Float));
    }
    for (paramInt2 = i1;; paramInt2 = i1)
    {
      paramArrayOfInt[1] = a(paramArrayOfInt[1]);
      paramArrayOfInt[2] = paramInt2;
      paramArrayOfInt[3] = paramInt1;
      return;
      i1 = (int)(paramInt2 * this.jdField_b_of_type_Float / paramInt1);
      int i2 = (int)this.jdField_b_of_type_Float;
      paramArrayOfInt[0] = ((int)(this.jdField_a_of_type_Float * paramInt2 / i1));
      paramArrayOfInt[1] = paramInt1;
      paramInt1 = i2;
    }
  }
  
  void c(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Object localObject = a(2131362087);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a((View)localObject);
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    paramInt2 = this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();
    this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_h_of_type_Int = ScreenUtil.a(140.0F);
    localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = (this.jdField_f_of_type_Int + ScreenUtil.a(13.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin += ScreenUtil.a(3.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i1 = ScreenUtil.a(5.0F);
    localObject = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i1;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.z)
    {
      this.jdField_j_of_type_Int = 0;
      this.jdField_i_of_type_Int = 0;
      this.jdField_c_of_type_AndroidViewView.setAlpha(0.5F);
      this.jdField_b_of_type_AndroidViewView.setAlpha(0.5F);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.5F);
    }
    for (;;)
    {
      if (this.jdField_j_of_type_Boolean) {
        a(5.0F);
      }
      return;
      this.jdField_i_of_type_Int = (paramInt2 * this.jdField_e_of_type_Int / paramInt1);
      this.jdField_j_of_type_Int = ((this.jdField_h_of_type_Int + i1) * this.jdField_e_of_type_Int / paramInt1);
      paramArrayOfInt[1] = (((int)this.jdField_b_of_type_Float - this.jdField_f_of_type_Int - this.jdField_h_of_type_Int - i1) * this.jdField_e_of_type_Int / paramInt1);
      paramInt1 = paramArrayOfInt[0];
      paramArrayOfInt[0] -= paramInt1 % 4;
      paramInt1 = paramArrayOfInt[1];
      paramArrayOfInt[1] -= paramInt1 % 4;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "ptvRevert(): sendVideo:" + paramBoolean + ",mIsVideoMode: " + this.jdField_d_of_type_Boolean + ", mPtvMode: " + this.jdField_g_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
      if (this.jdField_d_of_type_Boolean) {}
    }
    else
    {
      return;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      j();
      if (paramBoolean)
      {
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_h_of_type_Boolean = false;
        }
        if (RichmediaClient.a().a().a(this.jdField_a_of_type_JavaLangString) != null) {
          break label256;
        }
        LogTag.a(this.jdField_a_of_type_JavaLangString, "sendShortVideo", "[peak] old procedure");
        getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
        if (this.jdField_g_of_type_Boolean) {
          f1 = 1.0F;
        }
        FlowCameraMqqAction.a(this, (RMVideoStateMgr)localObject, f1, this.jdField_g_of_type_Boolean, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, 0);
        if (VideoEnvironment.d())
        {
          localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
          }
        }
      }
      label224:
      if (paramBoolean) {
        break label296;
      }
    }
    label256:
    label296:
    for (paramBoolean = true;; paramBoolean = false)
    {
      d(paramBoolean);
      this.jdField_d_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.y();
      break;
      if ((VideoEnvironment.d()) && (!this.jdField_g_of_type_Boolean))
      {
        setResult(1001);
        finish();
      }
      LogTag.a(this.jdField_a_of_type_JavaLangString, "sendShortVideo", "[peak] preupload procedure");
      break label224;
    }
  }
  
  public int d()
  {
    if (!this.jdField_g_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a();
    }
    return -1;
  }
  
  public void d()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      l();
      return;
    }
    Object localObject = null;
    if (this.jdField_g_of_type_Boolean) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_n_of_type_Boolean, this.jdField_g_of_type_Boolean, (RMVideoClipSpec)localObject);
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
    {
      c(false);
      return;
    }
    localObject = RichmediaClient.a().a().a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      ((CompoundProcessor)localObject).a(103);
    }
    for (;;)
    {
      localObject = getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      setResult(1001, (Intent)localObject);
      super.onBackPressed();
      return;
      c();
    }
  }
  
  void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "exitVideoMode(), mPtvMode = " + this.jdField_g_of_type_Boolean + ", clearCache = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if (paramBoolean)
      {
        a(103);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
        {
          int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount();
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(0, i1, true);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      }
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(paramBoolean);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.b)) {
        this.jdField_h_of_type_Boolean = false;
      }
    }
  }
  
  public void e()
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.2F);
  }
  
  public void e(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[6];
    if ((this.jdField_d_of_type_Int == -1) || (this.jdField_e_of_type_Int == -1)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FlowCameraActivity", 2, "[changeVideoPreviewMapSize]rmStateMgr " + null);
    return;
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    float f1 = this.jdField_d_of_type_Int * 1.0F / this.jdField_e_of_type_Int;
    if (this.jdField_c_of_type_Float > f1) {}
    for (boolean bool = false;; bool = true)
    {
      if (CameraCompatibleList.a()) {
        bool = true;
      }
      if (paramBoolean) {
        a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, bool, arrayOfInt);
      }
      try
      {
        a(arrayOfInt[2], arrayOfInt[3], arrayOfInt);
        label138:
        if (!paramBoolean) {
          a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, bool, arrayOfInt);
        }
        localRMVideoClipSpec.jdField_c_of_type_Int = arrayOfInt[0];
        localRMVideoClipSpec.jdField_d_of_type_Int = arrayOfInt[1];
        localRMVideoClipSpec.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
        localRMVideoClipSpec.jdField_f_of_type_Int = this.jdField_e_of_type_Int;
        if (bool) {
          if (this.jdField_n_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, localRMVideoClipSpec, this.jdField_i_of_type_Int);
            if (!this.y) {
              break label314;
            }
            localRMVideoClipSpec.jdField_e_of_type_Int = localRMVideoClipSpec.jdField_c_of_type_Int;
            localRMVideoClipSpec.jdField_f_of_type_Int = localRMVideoClipSpec.jdField_d_of_type_Int;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, false);
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, localRMVideoClipSpec, this.jdField_j_of_type_Int);
          break;
          if (this.jdField_n_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(2, localRMVideoClipSpec, this.jdField_i_of_type_Int);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(5, localRMVideoClipSpec, this.jdField_j_of_type_Int);
          break;
          label314:
          b(localRMVideoClipSpec);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        break label138;
      }
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@] event: current=" + i1);
    }
    if ((i1 >= CodecParam.jdField_c_of_type_Int) && (this.jdField_b_of_type_AndroidWidgetButton.isEnabled()))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131438146);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-14531501);
    }
    if (i1 < CodecParam.jdField_c_of_type_Int)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131438144);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-15550475);
    }
    if (i1 == 0)
    {
      if ((this.jdField_j_of_type_AndroidViewView.isEnabled()) && (this.jdField_i_of_type_AndroidViewView.isEnabled()))
      {
        VideoAnimation.a(this.jdField_j_of_type_AndroidViewView, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        VideoAnimation.a(this.jdField_i_of_type_AndroidViewView, 0.0F, -8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        this.jdField_j_of_type_AndroidViewView.setEnabled(false);
        this.jdField_i_of_type_AndroidViewView.setEnabled(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d() <= 0) && (!this.jdField_j_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.getVisibility() == 4)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      VideoAnimation.a(this.jdField_c_of_type_AndroidWidgetButton, true);
      if ((this.w) && (!this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    for (;;)
    {
      v();
      if (paramBoolean) {
        FlowCameraMqqAction.a("", "0X8005F60");
      }
      return;
      if (i1 > 0)
      {
        if (this.jdField_c_of_type_AndroidWidgetButton.isEnabled())
        {
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
          VideoAnimation.b(this.jdField_c_of_type_AndroidWidgetButton, true);
        }
        if ((!this.jdField_j_of_type_AndroidViewView.isEnabled()) && (!this.jdField_i_of_type_AndroidViewView.isEnabled()))
        {
          VideoAnimation.a(this.jdField_j_of_type_AndroidViewView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
          VideoAnimation.a(this.jdField_i_of_type_AndroidViewView, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
          this.jdField_j_of_type_AndroidViewView.setEnabled(true);
          this.jdField_i_of_type_AndroidViewView.setEnabled(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(4);
        }
        if ((this.w) && (this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.jdField_o_of_type_Int == 1) && (this.t)) {
      overridePendingTransition(0, 2131034133);
    }
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double == 0.0D)
    {
      d();
      FlowCameraMqqAction.b("", "0X800656F", "1");
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃录制，当前视频将会被删除");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃", 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new xlz(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void g(boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b();
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@] deleteLastVideoSegment: current= " + i1 + ",deleteNative = " + paramBoolean);
      }
      CompoundProcessor localCompoundProcessor = RichmediaClient.a().a().a(this.jdField_a_of_type_JavaLangString);
      if ((paramBoolean) && (localCompoundProcessor != null)) {
        localCompoundProcessor.a(110);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(i1, 1, paramBoolean);
    }
  }
  
  void h()
  {
    if (QLog.isColorLevel()) {
      QLog.e("FlowCameraActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void h(boolean paramBoolean)
  {
    runOnUiThread(new xmd(this, paramBoolean));
  }
  
  public void i()
  {
    b(false);
  }
  
  void j()
  {
    int i1 = this.jdField_e_of_type_AndroidViewView.getMeasuredHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_e_of_type_AndroidViewView.getMeasuredHeight(), 0 });
    localValueAnimator.addUpdateListener(new xli(this, i1));
    localValueAnimator.addListener(new xlj(this));
    localValueAnimator.start();
  }
  
  public void k()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131438145);
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130843112);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438147);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8355712);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.jdField_c_of_type_Int);
    if (this.jdField_k_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_k_of_type_AndroidViewView);
      this.jdField_k_of_type_AndroidViewView = null;
    }
  }
  
  public void l()
  {
    if (!this.jdField_i_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "enterVideoMode(), mPtvMode = " + this.jdField_g_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
  }
  
  public void n()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(0);
      localStringBuilder.append("\"");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a(3);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a = this;
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      if (this.w)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.jdField_b_of_type_Int = CodecParam.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(0, false);
  }
  
  public void o()
  {
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a(1);
      if ((this.jdField_j_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_i_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_j_of_type_AndroidViewView.isEnabled()) && (this.jdField_i_of_type_AndroidViewView.isEnabled()))
      {
        VideoAnimation.a(this.jdField_j_of_type_AndroidViewView, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        VideoAnimation.a(this.jdField_i_of_type_AndroidViewView, 0.0F, -8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      this.jdField_j_of_type_AndroidViewView.setEnabled(false);
      this.jdField_i_of_type_AndroidViewView.setEnabled(false);
      VideoAnimation.a(this.jdField_b_of_type_AndroidWidgetButton, 1.0F, 1.08F, 1.0F, 1.08F, 200, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double <= 0.0D) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(4);
      }
      if (this.jdField_c_of_type_AndroidWidgetButton.isEnabled())
      {
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
        VideoAnimation.b(this.jdField_c_of_type_AndroidWidgetButton, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
      Drawable[] arrayOfDrawable = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      if (arrayOfDrawable[0] != null) {
        a(arrayOfDrawable[0], Color.argb(255, 255, 0, 43));
      }
      if ((this.w) && (this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if (this.jdField_d_of_type_AndroidWidgetButton.isEnabled())
      {
        this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_d_of_type_AndroidWidgetButton.setAlpha(0.2F);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
    {
      g();
      return;
    }
    d();
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_m_of_type_Boolean) {}
    label977:
    do
    {
      int i1;
      do
      {
        do
        {
          do
          {
            return;
            i1 = paramView.getId();
            if (i1 != 2131368941) {
              break;
            }
          } while ((!Utils.a()) || (this.jdField_g_of_type_Boolean) || (this.jdField_d_of_type_Boolean));
          if (QLog.isColorLevel()) {
            QLog.i("FlowCameraActivity", 2, "Press the capture button.");
          }
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
          this.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(null);
          paramView = new File(AppConstants.aR);
          if (!paramView.exists()) {
            paramView.mkdirs();
          }
          this.jdField_b_of_type_JavaLangString = FlowCameraConstant.a();
          paramView = new File(this.jdField_b_of_type_JavaLangString);
          CameraControl localCameraControl = CameraControl.a();
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(localCameraControl.jdField_a_of_type_Int, localCameraInfo);
          i1 = (this.jdField_k_of_type_Int + 45) / 90 * 90;
          if (localCameraInfo.facing == 1) {}
          for (i1 = (localCameraInfo.orientation - i1 + 360) % 360;; i1 = (i1 + localCameraInfo.orientation) % 360)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.a(paramView, new xma(this, paramView), i1, false);
            if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
              break;
            }
            FlowCameraMqqAction.b("", "0X8005F5A", "0");
            return;
          }
          FlowCameraMqqAction.b("", "0X8005F5A", "1");
          return;
          if (i1 != 2131370004) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4)
          {
            a(true);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c() <= 0);
        if (QLog.isColorLevel()) {
          QLog.d("FlowCameraActivity", 2, "mVideoDrawablePlayer.getVFileAndAFile=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString) != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(0, "视频文件不存在", false);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Boolean = true;
        this.jdField_i_of_type_AndroidViewView.setEnabled(false);
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.f();
        }
        a(this, 2131436128);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
        h();
        this.u = true;
        paramView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
        if (paramView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(paramView);
          this.jdField_a_of_type_Boolean = false;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) || (this.y))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
          float f1 = paramView.jdField_f_of_type_Int * 1.0F / paramView.jdField_e_of_type_Int;
          a((int)this.jdField_a_of_type_Float, f1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
        FlowCameraMqqAction.a("", "0X8005F5F");
        return;
        if (i1 == 2131370006)
        {
          paramView = new DCShortVideo(BaseApplication.getContext());
          for (;;)
          {
            try
            {
              i1 = FlowCameraConstant.jdField_a_of_type_Int;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount() <= 1) {
                continue;
              }
              bool = true;
              paramView.a(i1, bool);
            }
            catch (NullPointerException paramView)
            {
              boolean bool;
              continue;
              paramView = null;
              continue;
              paramView = null;
              continue;
            }
            this.t = true;
            D();
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
            a(102);
            LogTag.a(this.jdField_a_of_type_JavaLangString, "SendBtn Click ", ",(int)rmStateMgr.mTotalTime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double + ",frames = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() + " VideoABTest:" + SystemClock.uptimeMillis());
            paramView = RichmediaClient.a().a().a(this.jdField_a_of_type_JavaLangString);
            if (paramView != null) {
              paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), this.jdField_b_of_type_Long, this.jdField_m_of_type_Int);
            }
            c(true);
            if (!this.jdField_g_of_type_Boolean) {
              continue;
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_n_of_type_Boolean, this.jdField_g_of_type_Boolean, paramView);
            if (!VideoEnvironment.d())
            {
              setResult(1001);
              finish();
            }
            if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
              continue;
            }
            FlowCameraMqqAction.b("", "0X8005F5E", "0");
            return;
            bool = false;
          }
          FlowCameraMqqAction.b("", "0X8005F5E", "1");
          return;
        }
        if (i1 == 2131370003)
        {
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
          if (!this.jdField_n_of_type_Boolean)
          {
            if (!this.jdField_g_of_type_Boolean) {
              break;
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_n_of_type_Boolean, this.jdField_g_of_type_Boolean, paramView);
            if (paramView != null)
            {
              this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              a(104);
              this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a(3);
              this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.invalidate();
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
              if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
                break label977;
              }
            }
          }
          for (FlowCameraConstant.jdField_a_of_type_Int = 2;; FlowCameraConstant.jdField_a_of_type_Int = 1)
          {
            i();
            this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.j();
            return;
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838676);
            break;
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838676);
            break;
          }
        }
        if (i1 == 2131368556)
        {
          if ((this.jdField_d_of_type_Boolean) || (this.jdField_g_of_type_Boolean))
          {
            onBackPressed();
            return;
          }
          paramView = getIntent();
          paramView.putExtra("flow_back", 0);
          setResult(1001, paramView);
          finish();
          return;
        }
      } while (i1 != 2131370005);
      if (QLog.isColorLevel()) {
        QLog.e("FlowCameraActivity", 2, "flow_camera_btn_video_local");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("SERIAL=").append(Build.SERIAL).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("FlowCameraActivity", 2, localStringBuilder.toString());
    }
    this.U = true;
    this.V = b();
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    PerfTracer.traceEnd("Video_component_onCreate");
    this.jdField_b_of_type_Long = 0L;
    this.jdField_m_of_type_Int = 0;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.jdField_q_of_type_Int == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_q_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FlowCameraActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_g_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().a();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!this.jdField_m_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FlowCameraActivity", 2, "onLongClick mIsCameraSetup false just return;");
      }
      return false;
    }
    if (paramView.getId() == 2131368941)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "onLongClick mPtvMode = " + this.jdField_g_of_type_Boolean + ", mIsVideoMode = " + this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_g_of_type_Boolean) {
        break label114;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.x();
        m();
      }
    }
    for (;;)
    {
      return true;
      label114:
      int i1 = this.jdField_e_of_type_AndroidViewView.getMeasuredHeight();
      paramView = ValueAnimator.ofInt(new int[] { 0, i1 });
      paramView.addUpdateListener(new xlp(this, i1));
      paramView.addListener(new xlq(this));
      paramView.start();
      FlowCameraMqqAction.a("", "0X8005E92");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
      }
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_o_of_type_Int == 1) {
      QzoneOnlineTimeCollectRptService.a().a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) {
      f();
    }
    View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
    if ((CameraCompatibleList.d(CameraCompatibleList.jdField_b_of_type_JavaLangString)) && (localView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
    if ((!this.jdField_g_of_type_Boolean) && (!this.v) && (!this.t) && (!this.u))
    {
      this.v = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300000L);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((!this.jdField_h_of_type_Boolean) && (this.jdField_m_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    }
    View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
    if (((!this.jdField_h_of_type_Boolean) || (localView == null)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4))
    {
      if (localView != null) {
        break label144;
      }
      Looper.myQueue().addIdleHandler(new xlw(this));
    }
    for (;;)
    {
      this.jdField_h_of_type_Boolean = false;
      if ((!this.jdField_g_of_type_Boolean) && (this.v) && (!this.t) && (!this.u))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.v = false;
      }
      if (this.jdField_o_of_type_Int == 1) {
        QzoneOnlineTimeCollectRptService.a().b(4);
      }
      return;
      label144:
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    B();
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new xly(this, 1, true, true, 0L, false, false, "FlowCameraActivity2");
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null)
    {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.jdField_m_of_type_Boolean) {}
    while ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (!this.jdField_b_of_type_AndroidWidgetButton.isClickable())) {
      return bool;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void p()
  {
    float f1 = 1.0F;
    Object localObject;
    float f2;
    int i1;
    String str;
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d() <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a(2);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("FlowCameraActivity", 2, "initUI_IdleState:mSendButton.getVisibility=" + this.jdField_j_of_type_AndroidViewView.getVisibility());
        QLog.i("FlowCameraActivity", 2, "initUI_IdleState:mPreviewButton.getVisibility=" + this.jdField_i_of_type_AndroidViewView.getVisibility());
      }
      if ((this.jdField_j_of_type_AndroidViewView.getVisibility() == 4) && (this.jdField_i_of_type_AndroidViewView.getVisibility() == 4))
      {
        this.jdField_j_of_type_AndroidViewView.setVisibility(0);
        this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("FlowCameraActivity", 2, "initUI_IdleState:mSendButton.isEnabled=" + this.jdField_j_of_type_AndroidViewView.isEnabled());
        QLog.i("FlowCameraActivity", 2, "initUI_IdleState:mPreviewButton.isEnabled=" + this.jdField_i_of_type_AndroidViewView.isEnabled());
      }
      if (!this.jdField_j_of_type_AndroidViewView.isEnabled())
      {
        VideoAnimation.a(this.jdField_j_of_type_AndroidViewView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        this.jdField_j_of_type_AndroidViewView.setEnabled(true);
      }
      VideoAnimation.a(this.jdField_i_of_type_AndroidViewView, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      this.jdField_i_of_type_AndroidViewView.setEnabled(true);
      if (this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
        VideoAnimation.a(this.jdField_b_of_type_AndroidWidgetButton, 1.08F, 1.0F, 1.08F, 1.0F, 200, null);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      if (localObject[0] != null)
      {
        localObject[0].setAlpha(255);
        a(localObject[0], -1);
      }
      f(false);
      if (!this.jdField_d_of_type_AndroidWidgetButton.isEnabled())
      {
        this.jdField_d_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_d_of_type_AndroidWidgetButton.setAlpha(1.0F);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean)
      {
        f2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        i1 = 320;
        if (RMVideoStateMgr.jdField_a_of_type_Boolean) {
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr;
        str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
        if (!this.jdField_g_of_type_Boolean) {
          break label515;
        }
      }
    }
    for (;;)
    {
      ((RMVideoThumbGenMgr)localObject).a(str, f1, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (!bool))
      {
        f1 = (float)(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() * 1000.0F / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(f1, -1);
      }
      return;
      label515:
      f1 = f2;
    }
  }
  
  public void q()
  {
    if (this.jdField_j_of_type_AndroidViewView.isEnabled()) {
      this.jdField_j_of_type_AndroidViewView.setEnabled(false);
    }
    if (this.jdField_b_of_type_AndroidWidgetButton.isEnabled())
    {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-14531501);
    }
    if (this.jdField_d_of_type_AndroidWidgetButton.isEnabled())
    {
      this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_d_of_type_AndroidWidgetButton.setAlpha(0.2F);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.isEnabled())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setEnabled(false);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d();
    i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(i2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.jdField_c_of_type_Int, i1, i2, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeFile(((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label235:
      break label235;
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(super.getResources(), localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
    if (!this.jdField_i_of_type_AndroidViewView.isEnabled())
    {
      this.jdField_i_of_type_AndroidViewView.setEnabled(true);
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130843141);
    }
  }
  
  public void r()
  {
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    }
    this.jdField_q_of_type_Boolean = true;
    if ((this.jdField_q_of_type_Boolean) && (this.r) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
      F();
    }
    boolean bool = CameraCompatibleList.a(CameraCompatibleList.q);
    if ((!this.jdField_a_of_type_Boolean) && (bool)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  public void s()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(255);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
    }
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(0);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  public void t()
  {
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
    }
  }
  
  public void u() {}
  
  public void v()
  {
    int i3 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
    int i2 = i3 / 1000;
    int i4 = i3 % 1000;
    int i1 = i2;
    if (i4 >= 500) {
      i1 = i2 + 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@] adjustRecordTime: time= " + i3 + ",seconds = " + i1 + ", ms=" + i4);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("\"");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
  }
  
  public void w()
  {
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a();
    }
  }
  
  public void x()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(false);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c() > 0)
      {
        this.jdField_i_of_type_AndroidViewView.setVisibility(0);
        this.jdField_j_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        if (!this.jdField_c_of_type_AndroidWidgetButton.isEnabled())
        {
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
          VideoAnimation.a(this.jdField_c_of_type_AndroidWidgetButton, true);
        }
        return;
        this.jdField_i_of_type_AndroidViewView.setVisibility(4);
        this.jdField_j_of_type_AndroidViewView.setVisibility(4);
      }
    }
    this.jdField_a_of_type_Int = ((int)((this.jdField_e_of_type_AndroidViewView.getMeasuredHeight() - this.jdField_b_of_type_AndroidWidgetButton.getHeight()) * 0.5F) + getResources().getDimensionPixelSize(2131559187));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setVisibility(0);
  }
  
  public void y()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_i_of_type_AndroidViewView.setVisibility(4);
      this.jdField_j_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(true);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130843113);
      this.jdField_b_of_type_AndroidWidgetButton.setText(null);
      if (!this.jdField_c_of_type_AndroidWidgetButton.isEnabled())
      {
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
        VideoAnimation.a(this.jdField_c_of_type_AndroidWidgetButton, true);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(0, false);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(null);
    this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(true);
  }
  
  public void z()
  {
    if (!this.jdField_g_of_type_Boolean) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new xmc(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "recordVideoFinish(): mOnCaptureBtn = " + this.jdField_l_of_type_Boolean);
      }
    } while (!this.jdField_l_of_type_Boolean);
    c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2
 * JD-Core Version:    0.7.0.1
 */
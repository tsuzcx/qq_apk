package com.tencent.mobileqq.activity.richmedia;

import Override;
import akrf;
import akrg;
import akrh;
import akri;
import akrj;
import akrk;
import akrl;
import akrm;
import akrn;
import akrp;
import akrq;
import akrr;
import akrs;
import akrt;
import akru;
import akrv;
import akrw;
import akrx;
import akry;
import akrz;
import aksa;
import aksb;
import aktw;
import akvi;
import akvn;
import akvo;
import akvr;
import akvs;
import akvt;
import akvv;
import amtj;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
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
import azzd;
import azzj;
import azzo;
import badr;
import bbsu;
import bbtm;
import bbtn;
import bbtw;
import bbua;
import bbub;
import bbuc;
import bbui;
import bbuj;
import bbuk;
import bbvb;
import bbvc;
import bbxx;
import bbyf;
import bftf;
import bfwl;
import bjms;
import bjnw;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.mobileqq.shortvideo.widget.SimpleProgressBar;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.HorizontalItemIndicator;
import com.tencent.mobileqq.widget.TransCircleMaskView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.VersionUtils;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(14)
public class FlowCameraActivity2
  extends FlowActivity
  implements akvr, akvv, View.OnClickListener, View.OnLongClickListener, bbyf, ImageViewVideoPlayer.IMPlayerEndListener
{
  public double a;
  float jdField_a_of_type_Float = 0.0F;
  long jdField_a_of_type_Long;
  private akry jdField_a_of_type_Akry;
  public aksb a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new akrq(this);
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
  private bbtn jdField_a_of_type_Bbtn = new bbtn();
  bbuj jdField_a_of_type_Bbuj = new akrl(this);
  bbuk jdField_a_of_type_Bbuk;
  bjnw jdField_a_of_type_Bjnw;
  public RMVideoStateMgr a;
  public CameraCover a;
  public CameraGLSurfaceView a;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  private volatile SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  SimpleProgressBar jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar;
  public TCProgressBar a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  HorizontalItemIndicator jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator;
  TransCircleMaskView jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView;
  Runnable jdField_a_of_type_JavaLangRunnable = new FlowCameraActivity2.1(this);
  String jdField_a_of_type_JavaLangString;
  public double b;
  float jdField_b_of_type_Float = 0.0F;
  public int b;
  private long jdField_b_of_type_Long;
  View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new akri(this);
  View jdField_b_of_type_AndroidViewView;
  public Button b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new FlowCameraActivity2.6(this);
  public String b;
  boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  public Button c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  Runnable jdField_c_of_type_JavaLangRunnable = new FlowCameraActivity2.22(this);
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  public int d;
  View jdField_d_of_type_AndroidViewView;
  Button jdField_d_of_type_AndroidWidgetButton;
  boolean jdField_d_of_type_Boolean;
  public int e;
  public View e;
  public boolean e;
  int f;
  public View f;
  public boolean f;
  int jdField_g_of_type_Int = 0;
  public View g;
  boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int = 0;
  View jdField_h_of_type_AndroidViewView;
  public boolean h;
  int jdField_i_of_type_Int = 0;
  View jdField_i_of_type_AndroidViewView;
  public boolean i;
  int jdField_j_of_type_Int = 0;
  public View j;
  boolean jdField_j_of_type_Boolean;
  public int k;
  View k;
  public boolean k;
  int l;
  public boolean l;
  private int m;
  public boolean m;
  private int jdField_n_of_type_Int;
  boolean jdField_n_of_type_Boolean = false;
  private int jdField_o_of_type_Int = 0;
  private boolean jdField_o_of_type_Boolean = true;
  private int jdField_p_of_type_Int = 1;
  private boolean jdField_p_of_type_Boolean;
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
  
  static
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.getShortVideoSoLibLoadStatus());
      }
      int i1 = VideoEnvironment.loadAVCodecSoNotify("AVCodec", null, true);
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
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new akrh(this);
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mHwEncoder=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new FlowCameraActivity2.HandleEndVideoEncode(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setEnabled(true);
    }
    this.jdField_j_of_type_AndroidViewView.setEnabled(true);
    bbxx.a(this.jdField_c_of_type_AndroidWidgetImageView, false, 250);
    if (this.jdField_i_of_type_AndroidViewView.isEnabled()) {
      this.jdField_i_of_type_AndroidViewView.setEnabled(false);
    }
    this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130845887);
    a(1002, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().b();
    this.jdField_i_of_type_AndroidViewView.setEnabled(true);
  }
  
  private void C()
  {
    int i2 = 1;
    int i3 = 2;
    Object localObject1 = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Object localObject2;
    int i1;
    if ((localObject1 != null) && (bbtm.b()) && (this.r) && (this.jdField_o_of_type_Int == 0) && (VideoEnvironment.getAVCodecSurpportFeature(2)))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = new SVHwEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, ((akvi)localObject2).jdField_e_of_type_Int, ((akvi)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(-1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000);
      if (CodecParam.mAudioChannel != 16) {
        break label296;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (CodecParam.mAudioFormat == 2) {
        i2 = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(CodecParam.mAudioSampleRate, i1, 128000, i2);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null) {
          break label321;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
        this.jdField_a_of_type_Bbtn.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        localObject2 = azzj.a().a();
        z();
        i1 = i3;
        if (this.jdField_f_of_type_Boolean) {
          i1 = 3;
        }
        localObject1 = ((azzo)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder, (SessionInfo)localObject1, i1);
        this.jdField_a_of_type_JavaLangString = ((azzd)localObject1).a();
        bfwl.a(this.jdField_a_of_type_JavaLangString, "start", "[peak]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((bbtw)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_e_of_type_Boolean);
        return;
        label296:
        if (CodecParam.mAudioChannel != 12) {
          break label342;
        }
        i1 = 2;
        break;
        if (CodecParam.mAudioFormat != 3) {
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
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.updateUISize(paramInt, paramFloat, true, ScreenUtil.dip2px(5.0F));
    int i1 = (int)(paramInt * paramFloat);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = i1;
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  private void b(Bundle paramBundle)
  {
    this.x = paramBundle.getBoolean("enable_big_video", false);
    this.v = paramBundle.getBoolean("enable_local_video", false);
    this.w = paramBundle.getBoolean("enable_front", false);
    this.jdField_n_of_type_Int = paramBundle.getInt("set_sdcard_min_size", 0);
    this.jdField_o_of_type_Int = paramBundle.getInt("from_type", 0);
    this.jdField_p_of_type_Int = paramBundle.getInt("clip_strategy", 1);
    akrx.jdField_a_of_type_Int = this.jdField_o_of_type_Int;
    if ((this.jdField_n_of_type_Int >= 57671680L) && (this.jdField_n_of_type_Int <= 314572800L)) {
      bbxy.jdField_a_of_type_Long = this.jdField_n_of_type_Int;
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
          if ((paramBundle instanceof akry))
          {
            this.jdField_a_of_type_Akry = ((akry)paramBundle);
            this.jdField_a_of_type_Akry.setRefer(this.jdField_c_of_type_JavaLangString);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          this.jdField_a_of_type_Akry = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("FlowCameraActivity", 2, "initComponentParamData:exp =" + paramBundle);
  }
  
  private boolean b()
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
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    label133:
    for (;;)
    {
      return;
      bbtm.jdField_b_of_type_Boolean = paramBundle.getBoolean("key_video_presend_enable", false);
      bbtm.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_video_hard_encode_enable", false);
      float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
      if (f1 > 0.0F) {
        bbtm.jdField_a_of_type_Int = (int)(f1 * 1000.0F);
      }
      if (bbtm.a()) {
        this.r = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(16);
      }
      for (;;)
      {
        if (!this.x) {
          break label133;
        }
        bbtm.jdField_a_of_type_Boolean = false;
        bbtm.jdField_b_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FlowCameraActivity", 2, "enable big video: mComonent_BigVideo=" + this.x);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
      }
    }
  }
  
  private void y()
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
  
  private void z()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
    {
      akvi localakvi = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, f1, localakvi.jdField_e_of_type_Int);
    }
  }
  
  int a()
  {
    if (this.jdField_f_of_type_Int == 0) {
      this.jdField_f_of_type_Int = getResources().getDimensionPixelSize(2131297093);
    }
    return this.jdField_f_of_type_Int;
  }
  
  int a(int paramInt)
  {
    int i1 = paramInt;
    if (bbtm.a())
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
    int i4 = (int)(paramInt2 * akrw.jdField_a_of_type_Float);
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
  
  protected akrz a()
  {
    if (this.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_Aksb = ((aksb)aksa.a(this, 0));
    }
    return this.jdField_a_of_type_Aksb;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_m_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildAt(0);
      if (TextureView.class.isInstance(localView)) {
        return ((TextureView)localView).getBitmap(paramInt1, paramInt2);
      }
    }
    return null;
  }
  
  void a()
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
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      if (!this.jdField_c_of_type_Boolean) {}
    }
    else {
      while ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c() > 0) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d() > 0)) {
        return;
      }
    }
    Object localObject = getResources();
    int i2;
    int i1;
    if (paramFloat > 0.0F)
    {
      ((Resources)localObject).getDimensionPixelSize(2131297090);
      i2 = a();
      if (this.jdField_o_of_type_Boolean)
      {
        ((Resources)localObject).getDimensionPixelSize(2131297091);
        i1 = c();
        localObject = Integer.valueOf(-14342358);
        a(i2, i1, ((Integer)localObject).intValue());
        if (paramFloat <= 0.0F) {
          break label416;
        }
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.a();
        this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.rgb(18, 183, 245));
        this.jdField_b_of_type_AndroidWidgetButton.setText(2131692338);
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845894);
        if (!this.jdField_f_of_type_Boolean)
        {
          if (!this.x) {
            break label365;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setTextSize(2, 18.0F);
          i1 = ScreenUtil.dip2px(80.0F);
          localObject = this.jdField_b_of_type_AndroidWidgetButton.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = i1;
          ((ViewGroup.LayoutParams)localObject).width = i1;
          this.jdField_b_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    for (;;)
    {
      akrx.a("", "0X8005F5D");
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setContentDescription(amtj.a(2131703777));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(amtj.a(2131703767));
      return;
      ((Resources)localObject).getDimensionPixelSize(2131297083);
      i1 = b();
      break;
      a();
      i2 = ((Resources)localObject).getDimensionPixelSize(2131297090);
      if (this.jdField_o_of_type_Boolean) {
        c();
      }
      for (i1 = ((Resources)localObject).getDimensionPixelSize(2131297091);; i1 = ((Resources)localObject).getDimensionPixelSize(2131297083))
      {
        localObject = Integer.valueOf(1275068416);
        break;
        b();
      }
      label365:
      this.jdField_b_of_type_AndroidWidgetButton.setTextSize(2, 21.0F);
      i1 = ScreenUtil.dip2px(110.0F);
      localObject = this.jdField_b_of_type_AndroidWidgetButton.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i1;
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.jdField_b_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label416:
    c(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setContentDescription(amtj.a(2131703768));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(amtj.a(2131703765));
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d();
      if (i1 > 0)
      {
        int i2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(i2, i1, true);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d();
        azzd localazzd = azzj.a().a().a(this.jdField_a_of_type_JavaLangString);
        if (localazzd != null) {
          localazzd.a(paramInt);
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
    this.jdField_q_of_type_Boolean = true;
    Object localObject;
    if (!this.jdField_f_of_type_Boolean)
    {
      e(true);
      if ((this.jdField_q_of_type_Boolean) && (this.jdField_p_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
        C();
      }
      for (;;)
      {
        paramInt1 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null) {
          paramInt1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
        }
        if ((VersionUtils.isGingerBread()) && (!this.jdField_c_of_type_AndroidWidgetButton.isEnabled()) && (paramInt1 <= 0)) {
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if (paramInt1 >= CodecParam.RECORD_MAX_TIME) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        return;
        if (b())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, ((akvi)localObject).jdField_e_of_type_Int, ((akvi)localObject).jdField_f_of_type_Int);
          z();
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
    akvi localakvi = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams((View)localObject);
      localLayoutParams.width = arrayOfInt[2];
      localLayoutParams.height = arrayOfInt[3];
      localLayoutParams.topMargin = (i3 + i2);
      ((View)localObject).setLayoutParams(localLayoutParams);
      localakvi.jdField_c_of_type_Int = arrayOfInt[0];
      localakvi.jdField_d_of_type_Int = arrayOfInt[1];
      localakvi.jdField_e_of_type_Int = paramInt1;
      localakvi.jdField_f_of_type_Int = paramInt2;
      if (!this.jdField_m_of_type_Boolean) {
        break label569;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, localakvi, 0);
    }
    for (;;)
    {
      localakvi.jdField_e_of_type_Int = arrayOfInt[4];
      localakvi.jdField_f_of_type_Int = arrayOfInt[5];
      a(localakvi);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localakvi, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setPreviewSize(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, localakvi);
      break;
      localObject = findViewById(2131366841);
      break label367;
      label563:
      bool = false;
      break label379;
      label569:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, localakvi, 0);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = paramInt1;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    if (this.jdField_o_of_type_Boolean)
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
      this.t = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.e();
    }
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    if (this.x)
    {
      c(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
      return;
    }
    b(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
  }
  
  void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (this.x)
    {
      c(paramInt1, paramInt2, paramArrayOfInt);
      return;
    }
    b(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    runOnUiThread(new FlowCameraActivity2.23(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_f_of_type_Boolean) {
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
    this.jdField_a_of_type_Bbtn.a(paramInt, i1);
    h(this.jdField_n_of_type_Boolean);
    if (this.jdField_n_of_type_Boolean)
    {
      this.jdField_n_of_type_Boolean = false;
      return;
    }
    this.jdField_n_of_type_Boolean = true;
    return;
    label100:
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(paramInt, paramBoolean);
  }
  
  void a(akvi paramakvi)
  {
    paramakvi.jdField_e_of_type_Int = 240;
    paramakvi.jdField_f_of_type_Int = 240;
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FlowCameraActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        e();
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131755826);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559574);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372546));
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
  
  void a(Drawable paramDrawable, int paramInt)
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
    this.jdField_b_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.u = false;
    this.s = false;
    this.t = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    akrw.jdField_a_of_type_Int = 2;
    akrw.jdField_a_of_type_Float = 0.75F;
    if (paramBundle == null) {
      return;
    }
    this.jdField_f_of_type_Boolean = paramBundle.getBoolean("flow_camera_ptv_mode", false);
    b(paramBundle);
    c(paramBundle);
    this.jdField_d_of_type_Boolean = paramBundle.getBoolean("flow_camera_use_surfaceview", false);
    this.jdField_h_of_type_Boolean = paramBundle.getBoolean("flow_camera_capture_mode", false);
    this.jdField_i_of_type_Boolean = paramBundle.getBoolean("flow_camera_video_mode", false);
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_j_of_type_Boolean = paramBundle.getBoolean("flow_camera_show_panel", true);
      akrw.jdField_a_of_type_Int = 1;
      if (!bbua.c()) {
        akrw.jdField_a_of_type_Int = 2;
      }
      akrw.jdField_a_of_type_Float = 1.0F;
      this.jdField_c_of_type_Int = paramBundle.getInt("flow_key_ptv_max_time", 20);
    }
    String str = paramBundle.getString("sv_config");
    boolean bool = paramBundle.getBoolean("sv_whitelist");
    paramBundle = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    if (paramBundle != null) {}
    for (int i1 = paramBundle.curType;; i1 = 0)
    {
      int i3 = NetworkUtil.getSystemNetwork(this);
      if (this.jdField_f_of_type_Boolean) {
        i2 = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), i2, str, bool, i1, i3, this.jdField_c_of_type_Int);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, akrx.a(this), this))
      {
        super.finish();
        return;
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new akrv(this, this));
      paramBundle = getResources().getDisplayMetrics();
      this.jdField_a_of_type_Float = paramBundle.widthPixels;
      this.jdField_b_of_type_Float = paramBundle.heightPixels;
      this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float / this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new akrp(this, this);
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      this.jdField_a_of_type_Bbuk = new bbuk(this, this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_Bbuk);
      this.jdField_a_of_type_Bbuk.a(new bbui(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Bbuj));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FlowCameraActivity", 2, "initData(), mPtvMode:" + this.jdField_f_of_type_Boolean + ",mCaptureMode:" + this.jdField_h_of_type_Boolean + ", config=" + str + ", white=" + bool);
      return;
    }
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2131561091, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)findViewById(2131366922));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366944));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131366881);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator = ((HorizontalItemIndicator)findViewById(2131366882));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131366915);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366861);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131366905);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131366842);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131366919);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131366920);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131366845));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131366913));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131366911));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366910));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366909));
    this.jdField_i_of_type_AndroidViewView = findViewById(2131366855);
    this.jdField_j_of_type_AndroidViewView = findViewById(2131366856);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366897));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366854));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)findViewById(2131366865));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366895));
    a((int)this.jdField_a_of_type_Float, 0.75F);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.a(new String[] { amtj.a(2131703764), amtj.a(2131703766) });
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar = ((SimpleProgressBar)findViewById(2131366862));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131692337);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845869);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692335);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8355712);
      paramViewGroup = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getLayoutParams();
      if (paramViewGroup.height != this.jdField_a_of_type_Int)
      {
        paramViewGroup.height = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setLayoutParams(paramViewGroup);
      }
      if (!"mounted".equals(Environment.getExternalStorageState()))
      {
        paramViewGroup = (TextView)findViewById(2131366894);
        paramViewGroup.setVisibility(0);
        paramViewGroup.setText(2131717701);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!bbua.a())
      {
        findViewById(2131366894).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView = new TransCircleMaskView(this);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildCount() - 2, paramViewGroup);
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(amtj.a(2131703773));
      if (this.jdField_f_of_type_Boolean) {
        break label870;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(64);
      label710:
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_f_of_type_Boolean);
      if (paramViewGroup == null) {
        break label882;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar = ((TCProgressBar)findViewById(2131366903));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setMax(CodecParam.VIDEO_FPS, CodecParam.RECORD_MAX_TIME);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundResource(2130839547);
      if (!bbua.c()) {
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(1275068416);
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      }
      if (this.jdField_i_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1275068416);
      this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(false);
      break;
      label870:
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(32);
      break label710;
      label882:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
    }
  }
  
  public void a(File paramFile)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
    if (findViewById(2131366900) == null) {
      ((ViewStub)findViewById(2131366901)).setVisibility(0);
    }
    if (this.jdField_d_of_type_AndroidViewView == null) {
      this.jdField_d_of_type_AndroidViewView = findViewById(2131366900);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(this.jdField_d_of_type_AndroidViewView, 2131366896));
    }
    Object localObject = URLDrawable.getDrawable(paramFile, URLDrawable.URLDrawableOptions.obtain());
    ((URLDrawable)localObject).downloadImediatly();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_Boolean = true;
    localObject = (Button)findViewById(this.jdField_d_of_type_AndroidViewView, 2131366899);
    Button localButton = (Button)findViewById(this.jdField_d_of_type_AndroidViewView, 2131366898);
    ((Button)localObject).setOnClickListener(new akrj(this, paramFile));
    localButton.setOnClickListener(new akrk(this, paramFile, localButton));
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    B();
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
        if (this.jdField_k_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "onTouchCaptureBtn: 发送已录制的");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e())) {
            break label134;
          }
          c(this.jdField_k_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_k_of_type_Boolean = false;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "onTouchCaptureBtn: 删除已录制的");
          }
          akrx.a("", "0X8005E93");
          break;
          if (QLog.isColorLevel()) {
            QLog.e("FlowCameraActivity", 2, "onTouchCaptureBtn: rmStateMgr.exitRecordMode() true, 段无效。");
          }
          c(false);
        }
      }
    } while (this.jdField_k_of_type_Boolean == paramBoolean1);
    this.jdField_k_of_type_Boolean = paramBoolean1;
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131692337);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131703776));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838233);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.jdField_c_of_type_Int);
      if (this.jdField_k_of_type_AndroidViewView != null) {
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845869);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131703775));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838234);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.jdField_d_of_type_Int);
    if (this.jdField_k_of_type_AndroidViewView == null)
    {
      this.jdField_k_of_type_AndroidViewView = new View(this);
      this.jdField_k_of_type_AndroidViewView.setBackgroundColor(871775498);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_k_of_type_AndroidViewView, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845866);
      return;
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  boolean a()
  {
    return false;
  }
  
  int b()
  {
    if (this.jdField_g_of_type_Int == 0) {
      this.jdField_g_of_type_Int = getResources().getDimensionPixelSize(2131297092);
    }
    return this.jdField_g_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      i();
      return;
    }
    Object localObject = null;
    if (this.jdField_f_of_type_Boolean) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_m_of_type_Boolean, this.jdField_f_of_type_Boolean, (akvi)localObject);
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      c(false);
      return;
    }
    localObject = azzj.a().a().a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      ((azzd)localObject).a(103);
    }
    for (;;)
    {
      localObject = getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      setResult(1001, (Intent)localObject);
      super.onBackPressed();
      return;
      a();
    }
  }
  
  void b(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    int i3 = (int)(this.jdField_a_of_type_Float * akrw.jdField_a_of_type_Float);
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
    paramArrayOfInt = findViewById(2131366841);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams(paramArrayOfInt);
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    paramArrayOfInt.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int i3 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
    int i1 = this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();
    int i2 = (int)(this.jdField_a_of_type_Float * akrw.jdField_a_of_type_Float);
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
      paramArrayOfInt.topMargin = (this.jdField_f_of_type_Int + ScreenUtil.dip2px(13.0F));
      paramArrayOfInt.topMargin += ScreenUtil.dip2px(3.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramArrayOfInt);
      if (this.jdField_i_of_type_Boolean) {
        a(5.0F);
      }
      return;
      paramInt2 = (int)this.jdField_b_of_type_Float - paramInt2;
      if (this.jdField_m_of_type_Boolean)
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
  
  void b(akvi paramakvi)
  {
    int i2 = paramakvi.jdField_c_of_type_Int;
    int i3 = paramakvi.jdField_d_of_type_Int;
    int i4 = bbsu.c.length;
    int i1 = 0;
    for (;;)
    {
      int i6;
      if (i1 < i4)
      {
        int i5 = a(bbsu.c[(i1 + 1)]);
        i6 = a(bbsu.c[(i1 + 3)]);
        if ((i2 >= bbsu.c[i1]) && (i3 >= i5))
        {
          paramakvi.jdField_e_of_type_Int = bbsu.c[i1];
          paramakvi.jdField_f_of_type_Int = i5;
        }
      }
      else
      {
        return;
      }
      if ((i2 >= bbsu.c[(i1 + 2)]) && (i3 >= i6))
      {
        paramakvi.jdField_e_of_type_Int = bbsu.c[(i1 + 2)];
        paramakvi.jdField_f_of_type_Int = i6;
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
    if (findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366841) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    if ((VersionUtils.isIceScreamSandwich()) && (!this.jdField_d_of_type_Boolean))
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof bbvc)))
      {
        ((CameraTextureView)localObject2).a = ((bbvc)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        this.jdField_m_of_type_Boolean = false;
        if (this.jdField_f_of_type_Boolean)
        {
          ConfigurationInfo localConfigurationInfo = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
          paramBoolean = VideoEnvironment.isBeautySupported();
          if ((localConfigurationInfo == null) || (localConfigurationInfo.reqGlEsVersion < 131072) || (!paramBoolean)) {
            break label429;
          }
          localObject3 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
          ((FrameLayout.LayoutParams)localObject3).height = this.jdField_a_of_type_Int;
          ((FrameLayout.LayoutParams)localObject3).width = ((int)(this.jdField_a_of_type_Int * akrw.jdField_a_of_type_Float));
          ((FrameLayout.LayoutParams)localObject3).gravity = 49;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)findViewById(2131366880));
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVideoContext(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((FrameLayout.LayoutParams)localObject1).height = 1;
        }
      }
    }
    for (((FrameLayout.LayoutParams)localObject1).width = 1;; ((FrameLayout.LayoutParams)localObject1).width = ((int)(this.jdField_a_of_type_Int * akrw.jdField_a_of_type_Float)))
    {
      ((FrameLayout.LayoutParams)localObject1).gravity = 81;
      if (this.jdField_m_of_type_Boolean) {
        ((FrameLayout.LayoutParams)localObject1).gravity = 49;
      }
      ((View)localObject2).setId(2131366841);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
      this.jdField_l_of_type_Boolean = true;
      return;
      ((CameraTextureView)localObject2).a = new bbvc(this.jdField_a_of_type_Bbuk, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof bbvb))) {}
      for (((CameraPreview)localObject2).a = ((bbvb)localObject1);; ((CameraPreview)localObject2).a = new bbvb(this.jdField_a_of_type_Bbuk, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        this.jdField_m_of_type_Boolean = true;
        break;
      }
      label429:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)findViewById(2131366880));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = null;
      ((FrameLayout.LayoutParams)localObject1).height = this.jdField_a_of_type_Int;
    }
  }
  
  int c()
  {
    if (this.jdField_h_of_type_Int == 0) {
      this.jdField_h_of_type_Int = getResources().getDimensionPixelSize(2131297091);
    }
    return this.jdField_h_of_type_Int;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
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
    Object localObject = findViewById(2131366841);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams((View)localObject);
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    paramInt2 = this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();
    this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_h_of_type_Int = ScreenUtil.dip2px(140.0F);
    localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = (this.jdField_f_of_type_Int + ScreenUtil.dip2px(13.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin += ScreenUtil.dip2px(3.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i1 = ScreenUtil.dip2px(5.0F);
    localObject = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i1;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.y)
    {
      this.jdField_j_of_type_Int = 0;
      this.jdField_i_of_type_Int = 0;
      this.jdField_c_of_type_AndroidViewView.setAlpha(0.5F);
      this.jdField_b_of_type_AndroidViewView.setAlpha(0.5F);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.5F);
    }
    for (;;)
    {
      if (this.jdField_i_of_type_Boolean) {
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
      QLog.d("FlowCameraActivity", 2, "ptvRevert(): sendVideo:" + paramBoolean + ",mIsVideoMode: " + this.jdField_c_of_type_Boolean + ", mPtvMode: " + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
      if (this.jdField_c_of_type_Boolean) {}
    }
    else
    {
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      g();
      if (paramBoolean)
      {
        if (this.jdField_f_of_type_Boolean) {
          this.jdField_g_of_type_Boolean = false;
        }
        if (azzj.a().a().a(this.jdField_a_of_type_JavaLangString) != null) {
          break label256;
        }
        bfwl.a(this.jdField_a_of_type_JavaLangString, "sendShortVideo", "[peak] old procedure");
        getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
        if (this.jdField_f_of_type_Boolean) {
          f1 = 1.0F;
        }
        akrx.a(this, (RMVideoStateMgr)localObject, f1, this.jdField_f_of_type_Boolean, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_Akry, 0);
        if (VideoEnvironment.supportSubmitCallback())
        {
          localObject = findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366841);
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
      this.jdField_c_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvv.v();
      break;
      if ((VideoEnvironment.supportSubmitCallback()) && (!this.jdField_f_of_type_Boolean))
      {
        setResult(1001);
        finish();
      }
      bfwl.a(this.jdField_a_of_type_JavaLangString, "sendShortVideo", "[peak] preupload procedure");
      break label224;
    }
  }
  
  public int d()
  {
    if (!this.jdField_f_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a();
    }
    return -1;
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double == 0.0D)
    {
      b();
      akrx.b("", "0X800656F", "1");
      return;
    }
    if (this.jdField_a_of_type_Bjnw == null) {
      this.jdField_a_of_type_Bjnw = bjnw.a(this, false);
    }
    this.jdField_a_of_type_Bjnw.a(amtj.a(2131703770));
    this.jdField_a_of_type_Bjnw.a(amtj.a(2131703769), 3);
    this.jdField_a_of_type_Bjnw.d(amtj.a(2131703771));
    this.jdField_a_of_type_Bjnw.a(new akrt(this));
    this.jdField_a_of_type_Bjnw.show();
  }
  
  void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "exitVideoMode(), mPtvMode = " + this.jdField_f_of_type_Boolean + ", clearCache = " + paramBoolean);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvs != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvs.a();
      }
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(paramBoolean);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvo.jdField_b_of_type_Boolean)) {
        this.jdField_g_of_type_Boolean = false;
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void e()
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
    akvi localakvi = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
    float f1 = this.jdField_d_of_type_Int * 1.0F / this.jdField_e_of_type_Int;
    if (this.jdField_c_of_type_Float > f1) {}
    for (boolean bool = false;; bool = true)
    {
      if (bbub.a()) {
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
        localakvi.jdField_c_of_type_Int = arrayOfInt[0];
        localakvi.jdField_d_of_type_Int = arrayOfInt[1];
        localakvi.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
        localakvi.jdField_f_of_type_Int = this.jdField_e_of_type_Int;
        if (bool) {
          if (this.jdField_m_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, localakvi, this.jdField_i_of_type_Int);
            if (!this.x) {
              break label314;
            }
            localakvi.jdField_e_of_type_Int = localakvi.jdField_c_of_type_Int;
            localakvi.jdField_f_of_type_Int = localakvi.jdField_d_of_type_Int;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localakvi, false);
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, localakvi, this.jdField_j_of_type_Int);
          break;
          if (this.jdField_m_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(2, localakvi, this.jdField_i_of_type_Int);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(5, localakvi, this.jdField_j_of_type_Int);
          break;
          label314:
          b(localakvi);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        break label138;
      }
    }
  }
  
  public void f()
  {
    b(false);
  }
  
  public void f(boolean paramBoolean)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@] event: current=" + i1);
    }
    if ((i1 >= CodecParam.RECORD_MAX_TIME) && (this.jdField_b_of_type_AndroidWidgetButton.isEnabled()))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131692339);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-14531501);
    }
    if (i1 < CodecParam.RECORD_MAX_TIME)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131692338);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-15550475);
    }
    if (i1 == 0)
    {
      if ((this.jdField_j_of_type_AndroidViewView.isEnabled()) && (this.jdField_i_of_type_AndroidViewView.isEnabled()))
      {
        bbxx.a(this.jdField_j_of_type_AndroidViewView, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        bbxx.a(this.jdField_i_of_type_AndroidViewView, 0.0F, -8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        this.jdField_j_of_type_AndroidViewView.setEnabled(false);
        this.jdField_i_of_type_AndroidViewView.setEnabled(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.d() <= 0) && (!this.jdField_i_of_type_Boolean) && (!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.getVisibility() == 4)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      bbxx.a(this.jdField_c_of_type_AndroidWidgetButton, true);
      if ((this.v) && (!this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    for (;;)
    {
      s();
      if (paramBoolean) {
        akrx.a("", "0X8005F60");
      }
      return;
      if (i1 > 0)
      {
        if (this.jdField_c_of_type_AndroidWidgetButton.isEnabled())
        {
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
          bbxx.b(this.jdField_c_of_type_AndroidWidgetButton, true);
        }
        if ((!this.jdField_j_of_type_AndroidViewView.isEnabled()) && (!this.jdField_i_of_type_AndroidViewView.isEnabled()))
        {
          bbxx.a(this.jdField_j_of_type_AndroidViewView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
          bbxx.a(this.jdField_i_of_type_AndroidViewView, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
          this.jdField_j_of_type_AndroidViewView.setEnabled(true);
          this.jdField_i_of_type_AndroidViewView.setEnabled(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(4);
        }
        if ((this.v) && (this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
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
    if ((this.jdField_o_of_type_Int == 1) && (this.s)) {
      overridePendingTransition(0, 2130771993);
    }
  }
  
  void g()
  {
    int i1 = this.jdField_e_of_type_AndroidViewView.getMeasuredHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_e_of_type_AndroidViewView.getMeasuredHeight(), 0 });
    localValueAnimator.addUpdateListener(new akrf(this, i1));
    localValueAnimator.addListener(new akrg(this));
    localValueAnimator.start();
  }
  
  public void g(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b();
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@] deleteLastVideoSegment: current= " + i1 + ",deleteNative = " + paramBoolean);
      }
      azzd localazzd = azzj.a().a().a(this.jdField_a_of_type_JavaLangString);
      if ((paramBoolean) && (localazzd != null)) {
        localazzd.a(110);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(i1, 1, paramBoolean);
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131692337);
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845869);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692335);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8355712);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.jdField_c_of_type_Int);
    if (this.jdField_k_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_k_of_type_AndroidViewView);
      this.jdField_k_of_type_AndroidViewView = null;
    }
  }
  
  void h(boolean paramBoolean)
  {
    runOnUiThread(new FlowCameraActivity2.RefreshUITimer(this, paramBoolean));
  }
  
  public void i()
  {
    if (!this.jdField_h_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "enterVideoMode(), mPtvMode = " + this.jdField_f_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
  }
  
  public void k()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(0);
      localStringBuilder.append("\"");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a(3);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a = this;
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      if (this.v)
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
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.jdField_b_of_type_Int = CodecParam.RECORD_MAX_TIME;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(0, false);
  }
  
  public void l()
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a(1);
      if ((this.jdField_j_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_i_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_j_of_type_AndroidViewView.isEnabled()) && (this.jdField_i_of_type_AndroidViewView.isEnabled()))
      {
        bbxx.a(this.jdField_j_of_type_AndroidViewView, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        bbxx.a(this.jdField_i_of_type_AndroidViewView, 0.0F, -8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      this.jdField_j_of_type_AndroidViewView.setEnabled(false);
      this.jdField_i_of_type_AndroidViewView.setEnabled(false);
      bbxx.a(this.jdField_b_of_type_AndroidWidgetButton, 1.0F, 1.08F, 1.0F, 1.08F, 200, null);
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
        bbxx.b(this.jdField_c_of_type_AndroidWidgetButton, true);
      }
      this.jdField_a_of_type_Bbtn.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
      Drawable[] arrayOfDrawable = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      if (arrayOfDrawable[0] != null) {
        a(arrayOfDrawable[0], Color.argb(255, 255, 0, 43));
      }
      if ((this.v) && (this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
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
  
  public void m()
  {
    float f1 = 1.0F;
    Object localObject;
    float f2;
    int i1;
    String str;
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
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
        bbxx.a(this.jdField_j_of_type_AndroidViewView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        this.jdField_j_of_type_AndroidViewView.setEnabled(true);
      }
      bbxx.a(this.jdField_i_of_type_AndroidViewView, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      this.jdField_i_of_type_AndroidViewView.setEnabled(true);
      if (this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
        bbxx.a(this.jdField_b_of_type_AndroidWidgetButton, 1.08F, 1.0F, 1.08F, 1.0F, 200, null);
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
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi.jdField_e_of_type_Int;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvs;
        str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
        if (!this.jdField_f_of_type_Boolean) {
          break label515;
        }
      }
    }
    for (;;)
    {
      ((akvs)localObject).a(str, f1, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLoadingBitmap = null;
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
  
  public void n()
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
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.initPlayer(CodecParam.RECORD_MAX_TIME, i1, i2, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvs.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((akvt)localObject2).jdField_c_of_type_JavaLangString != null) && (((akvt)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLoadingBitmap == null))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeFile(((akvt)localObject2).jdField_c_of_type_JavaLangString, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label235:
      break label235;
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLoadingBitmap = new BitmapDrawable(super.getResources(), localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
    if (!this.jdField_i_of_type_AndroidViewView.isEnabled())
    {
      this.jdField_i_of_type_AndroidViewView.setEnabled(true);
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130845898);
    }
  }
  
  public void o()
  {
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    }
    this.jdField_p_of_type_Boolean = true;
    if ((this.jdField_p_of_type_Boolean) && (this.jdField_q_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
      C();
    }
    boolean bool = bbub.a(bbub.q);
    if ((!this.jdField_b_of_type_Boolean) && (bool)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Akry != null) {
      this.jdField_a_of_type_Akry.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      d();
      return;
    }
    b();
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_l_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i1 = paramView.getId();
      Object localObject1;
      if (i1 == 2131366845)
      {
        if ((bftf.a()) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FlowCameraActivity", 2, "Press the capture button.");
          }
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
          this.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(null);
          localObject1 = new File(aktw.jdField_b_of_type_JavaLangString);
          if (!((File)localObject1).exists()) {
            ((File)localObject1).mkdirs();
          }
          this.jdField_b_of_type_JavaLangString = akrw.a();
          localObject1 = new File(this.jdField_b_of_type_JavaLangString);
          bbuc localbbuc = bbuc.a();
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(localbbuc.jdField_a_of_type_Int, localCameraInfo);
          i1 = (this.jdField_k_of_type_Int + 45) / 90 * 90;
          if (localCameraInfo.facing == 1) {}
          for (i1 = (localCameraInfo.orientation - i1 + 360) % 360;; i1 = (i1 + localCameraInfo.orientation) % 360)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.a((File)localObject1, new akru(this, (File)localObject1), i1, false);
            if (akrw.jdField_a_of_type_Int != 1) {
              break label253;
            }
            akrx.b("", "0X8005F5A", "0");
            break;
          }
          label253:
          akrx.b("", "0X8005F5A", "1");
        }
      }
      else if (i1 == 2131366855)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4)
        {
          a(true);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "mVideoDrawablePlayer.getVFileAndAFile=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getVFileAndAFile(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString) != 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(0, amtj.a(2131703772), false);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mSecurityChecked = true;
            this.jdField_i_of_type_AndroidViewView.setEnabled(false);
            if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.f();
            }
            a(this, 2131694451);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
            e();
            this.t = true;
            localObject1 = findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366841);
            if (localObject1 != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject1);
              this.jdField_b_of_type_Boolean = false;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) || (this.x))
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
              float f1 = ((akvi)localObject1).jdField_f_of_type_Int * 1.0F / ((akvi)localObject1).jdField_e_of_type_Int;
              a((int)this.jdField_a_of_type_Float, f1);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
            akrx.a("", "0X8005F5F");
          }
        }
      }
      else if (i1 == 2131366856)
      {
        localObject1 = new badr(BaseApplication.getContext());
        for (;;)
        {
          try
          {
            i1 = akrw.jdField_a_of_type_Int;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount() <= 1) {
              continue;
            }
            bool = true;
            ((badr)localObject1).a(i1, bool);
          }
          catch (NullPointerException localNullPointerException)
          {
            boolean bool;
            continue;
            Object localObject2 = null;
            continue;
            localObject2 = null;
            continue;
          }
          this.s = true;
          A();
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
          a(102);
          bfwl.a(this.jdField_a_of_type_JavaLangString, "SendBtn Click ", ",(int)rmStateMgr.mTotalTime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double + ",frames = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() + " VideoABTest:" + SystemClock.uptimeMillis());
          localObject1 = azzj.a().a().a(this.jdField_a_of_type_JavaLangString);
          if (localObject1 != null) {
            ((azzd)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), this.jdField_b_of_type_Long, this.jdField_m_of_type_Int);
          }
          c(true);
          if (!this.jdField_f_of_type_Boolean) {
            continue;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_m_of_type_Boolean, this.jdField_f_of_type_Boolean, (akvi)localObject1);
          if (!VideoEnvironment.supportSubmitCallback())
          {
            setResult(1001);
            finish();
          }
          if (akrw.jdField_a_of_type_Int != 1) {
            continue;
          }
          akrx.b("", "0X8005F5E", "0");
          break;
          bool = false;
        }
        akrx.b("", "0X8005F5E", "1");
      }
      else
      {
        if (i1 == 2131366913)
        {
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
          if (!this.jdField_m_of_type_Boolean)
          {
            if (!this.jdField_f_of_type_Boolean) {
              break;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvi;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_m_of_type_Boolean, this.jdField_f_of_type_Boolean, (akvi)localObject1);
            if (localObject1 != null)
            {
              this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
              label931:
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              a(104);
              this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a(3);
              this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.invalidate();
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
              if (akrw.jdField_a_of_type_Int != 1) {
                break label1027;
              }
            }
          }
          label1027:
          for (akrw.jdField_a_of_type_Int = 2;; akrw.jdField_a_of_type_Int = 1)
          {
            f();
            this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.j();
            break;
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839547);
            break label931;
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839547);
            break label931;
          }
        }
        if (i1 == 2131366911)
        {
          if ((this.jdField_c_of_type_Boolean) || (this.jdField_f_of_type_Boolean))
          {
            onBackPressed();
          }
          else
          {
            localObject1 = getIntent();
            ((Intent)localObject1).putExtra("flow_back", 0);
            setResult(1001, (Intent)localObject1);
            finish();
          }
        }
        else if (i1 == 2131366854)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FlowCameraActivity", 2, "flow_camera_btn_video_local");
          }
          if (this.jdField_a_of_type_Akry != null) {
            this.jdField_a_of_type_Akry.localVideoClick(this);
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
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
      localStringBuilder.append("SERIAL=").append(bjms.c()).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("FlowCameraActivity", 2, localStringBuilder.toString());
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = a();
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    PerfTracer.traceEnd("Video_component_onCreate");
    this.jdField_b_of_type_Long = 0L;
    this.jdField_m_of_type_Int = 0;
    StatisticCollector.report("exposure_flowCamera");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.jdField_q_of_type_Int == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_q_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Bjnw != null) {
        this.jdField_a_of_type_Bjnw.dismiss();
      }
      if (!this.jdField_f_of_type_Boolean) {
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
  
  public void onDrawLastFrameEnd()
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLastFramePicture;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getCurrentBitmap();
    }
    if (localBitmap1 != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.2F);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_f_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().a();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!this.jdField_l_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FlowCameraActivity", 2, "onLongClick mIsCameraSetup false just return;");
      }
      return false;
    }
    if (paramView.getId() == 2131366845)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "onLongClick mPtvMode = " + this.jdField_f_of_type_Boolean + ", mIsVideoMode = " + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_f_of_type_Boolean) {
        break label114;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Akvv.u();
        j();
      }
    }
    for (;;)
    {
      return true;
      label114:
      int i1 = this.jdField_e_of_type_AndroidViewView.getMeasuredHeight();
      paramView = ValueAnimator.ofInt(new int[] { 0, i1 });
      paramView.addUpdateListener(new akrm(this, i1));
      paramView.addListener(new akrn(this));
      paramView.start();
      akrx.a("", "0X8005E92");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
      }
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.jdField_o_of_type_Int == 1) {
      QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) {
      c();
    }
    View localView = findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366841);
    if ((bbub.d(bbub.jdField_b_of_type_JavaLangString)) && (localView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
    if ((!this.jdField_f_of_type_Boolean) && (!this.u) && (!this.s) && (!this.t))
    {
      this.u = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300000L);
    }
  }
  
  public void onPlayerEnd()
  {
    B();
    b(true);
  }
  
  public void onPlayerRecyle() {}
  
  public void onResume()
  {
    super.onResume();
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_l_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    }
    View localView = findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366841);
    if (((!this.jdField_g_of_type_Boolean) || (localView == null)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4))
    {
      if (localView != null) {
        break label144;
      }
      Looper.myQueue().addIdleHandler(new akrr(this));
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = false;
      if ((!this.jdField_f_of_type_Boolean) && (this.u) && (!this.s) && (!this.t))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.u = false;
      }
      if (this.jdField_o_of_type_Int == 1) {
        QzoneOnlineTimeCollectRptService.getInstance().beginTrace(4);
      }
      return;
      label144:
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    y();
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new akrs(this, 1, true, true, 0L, false, false, "FlowCameraActivity2");
    SosoInterface.startLocation(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null)
    {
      SosoInterface.removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.jdField_l_of_type_Boolean) {}
    while ((this.jdField_f_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (!this.jdField_b_of_type_AndroidWidgetButton.isClickable())) {
      return bool;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void p()
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
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(0);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  public void q()
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.c();
    }
  }
  
  public void r() {}
  
  void s()
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
  
  public void t()
  {
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a();
    }
  }
  
  public void u()
  {
    if (!this.jdField_f_of_type_Boolean)
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
          bbxx.a(this.jdField_c_of_type_AndroidWidgetButton, true);
        }
        return;
        this.jdField_i_of_type_AndroidViewView.setVisibility(4);
        this.jdField_j_of_type_AndroidViewView.setVisibility(4);
      }
    }
    this.jdField_b_of_type_Int = ((int)((this.jdField_e_of_type_AndroidViewView.getMeasuredHeight() - this.jdField_b_of_type_AndroidWidgetButton.getHeight()) * 0.5F) + getResources().getDimensionPixelSize(2131297082));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setVisibility(0);
  }
  
  public void v()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_i_of_type_AndroidViewView.setVisibility(4);
      this.jdField_j_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(true);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845870);
      this.jdField_b_of_type_AndroidWidgetButton.setText(null);
      if (!this.jdField_c_of_type_AndroidWidgetButton.isEnabled())
      {
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
        bbxx.a(this.jdField_c_of_type_AndroidWidgetButton, true);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(0, false);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(null);
    this.jdField_b_of_type_AndroidWidgetButton.setLongClickable(true);
  }
  
  public void w()
  {
    if (!this.jdField_f_of_type_Boolean) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new FlowCameraActivity2.HandleEndVideoEncode(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "recordVideoFinish(): mOnCaptureBtn = " + this.jdField_k_of_type_Boolean);
      }
    } while (!this.jdField_k_of_type_Boolean);
    c(true);
  }
  
  public void x()
  {
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2
 * JD-Core Version:    0.7.0.1
 */
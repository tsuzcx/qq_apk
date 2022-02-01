package com.tencent.aelight.camera.aebase.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.download.AEResManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.aebase.activity.CaptureQmcfSoDownloadActivity;
import com.tencent.aelight.camera.api.ICaptureSoDownloadListener;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CameraPermissionListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadFragment
  extends BaseFragment
  implements View.OnClickListener, IAEDownloadCallBack, CameraCaptureView.CameraPermissionListener, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig, GestureMgr.GestureStatusListener
{
  private CircleProgress a;
  private CameraCaptureView b;
  private TextView c;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private volatile int k = 0;
  private QQAppInterface l;
  private String m;
  private volatile boolean n = false;
  private volatile boolean o = false;
  private volatile boolean p = false;
  
  private void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    paramSVConfigItem.name = "new_qq_android_native_short_video_66";
    paramSVConfigItem.arm_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.armv7a_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.x86_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.arm64v8a_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_for64bit_66_test_1.zip";
    paramSVConfigItem.arm_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.armv7a_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.x86_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.arm64v8a_md5 = "480b96a75193cee3979c62fea8018768";
    paramSVConfigItem.versionCode = 66;
    paramSVConfigItem.predownload = false;
  }
  
  private void a(String paramString)
  {
    h();
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.2(this, paramString));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadConfig netUsable=");
    localStringBuilder.append(bool);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
    if (bool)
    {
      if (!paramBoolean1) {
        AEResManager.a().a(AEResInfo.AE_RES_BASE_PACKAGE, this, false);
      }
      if (!paramBoolean2) {
        AEResManager.a().a(AEResInfo.LIGHT_RES_BASE_PACKAGE, this, false);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("【END】startDownloadGyBase:");
      localStringBuilder.append(HardCodeUtil.a(2131899609));
      AEQLog.d("CaptureQmcfSoDownloadFragment", localStringBuilder.toString());
      b(HardCodeUtil.a(2131899609));
    }
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.3(this, paramString));
  }
  
  private void f()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadConfig netUsable=");
    localStringBuilder.append(bool);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131899616), null);
      ShortVideoResourceManager.b(this.l, this);
      return;
    }
    b(HardCodeUtil.a(2131899628));
  }
  
  private void g()
  {
    if (i())
    {
      if ((this.h) && (this.k > 100) && (this.i) && (this.j)) {
        c();
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isAvCodecDownloaded]");
      localStringBuilder.append(this.h);
      AEQLog.b("CaptureQmcfSoDownloadFragment", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isAEKitBaseDownloaded]");
      localStringBuilder.append(this.i);
      AEQLog.b("CaptureQmcfSoDownloadFragment", localStringBuilder.toString());
      if ((this.h) && (this.i) && (this.j)) {
        c();
      }
    }
  }
  
  private void h()
  {
    if (i())
    {
      int i1 = (this.g + this.k) / 2;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131899630));
      localStringBuilder.append(i1);
      localStringBuilder.append("%");
      b(localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131899639));
    localStringBuilder.append(this.g);
    localStringBuilder.append("%");
    b(localStringBuilder.toString());
  }
  
  private boolean i()
  {
    return false;
  }
  
  protected int a()
  {
    return 2064056512;
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.6(this, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.5(this, paramBoolean1, paramInt));
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = this.l;
    if (localQQAppInterface != null)
    {
      ShortVideoResourceManager.b(localQQAppInterface, this);
      this.l = null;
    }
    AEResManager.a().a(this);
  }
  
  protected void c()
  {
    try
    {
      this.p = true;
      if ((!this.n) || (this.o))
      {
        ICaptureSoDownloadListener localICaptureSoDownloadListener = (ICaptureSoDownloadListener)getBaseActivity();
        if (localICaptureSoDownloadListener != null) {
          localICaptureSoDownloadListener.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    this.k = 0;
    GestureMgr.e().a(true, this);
    boolean bool = GestureMgr.e().b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadGestureRes:");
      localStringBuilder.append(bool);
      QLog.d("CaptureQmcfSoDownloadFragment", 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.4(this));
      return;
    }
    this.k = 101;
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    this.o = false;
    Object localObject = getBaseActivity();
    int i1;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i1 != 0) && (i2 != 0)) {
      localObject = DialogUtil.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
    } else if (i1 != 0) {
      localObject = DialogUtil.a(new String[] { "android.permission.CAMERA" });
    } else {
      localObject = DialogUtil.a(new String[] { "android.permission.RECORD_AUDIO" });
    }
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.7(this, (String)localObject));
  }
  
  public void e()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if ((getBaseActivity() instanceof CaptureQmcfSoDownloadActivity))
    {
      CaptureQmcfSoDownloadActivity localCaptureQmcfSoDownloadActivity = (CaptureQmcfSoDownloadActivity)getBaseActivity();
      int i1;
      if (localCaptureQmcfSoDownloadActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2;
      if (localCaptureQmcfSoDownloadActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if ((i1 != 0) && (i2 != 0))
      {
        this.n = true;
        localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        return;
      }
      if (i1 != 0)
      {
        this.n = true;
        localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
        return;
      }
      this.n = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    try
    {
      this.o = true;
      if (this.p)
      {
        ICaptureSoDownloadListener localICaptureSoDownloadListener = (ICaptureSoDownloadListener)getBaseActivity();
        if (localICaptureSoDownloadListener != null) {
          localICaptureSoDownloadListener.a();
        }
      }
      else
      {
        this.b.setCameraPermissionResult(true);
      }
      return;
    }
    finally {}
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    paramString = new StringBuilder();
    paramString.append("【onAEResDownloadResult】[packageIdx] :");
    paramString.append(paramAEResInfo.index);
    paramString.append("[isDownloaded] :");
    paramString.append(paramBoolean);
    paramString.append("[errorType] :");
    paramString.append(paramInt);
    AEQLog.b("CaptureQmcfSoDownloadFragment", paramString.toString());
    if (paramAEResInfo == AEResInfo.AE_RES_BASE_PACKAGE)
    {
      if (paramBoolean)
      {
        paramString = new StringBuilder();
        paramString.append("[onAEDownloadFinish] success, package=");
        paramString.append(paramAEResInfo.description);
        AEQLog.d("CaptureQmcfSoDownloadFragment", paramString.toString());
        this.e = 100;
        this.g = ((this.d + this.e + this.f) / 3);
        a("doUserDownloadResource:");
        this.i = true;
        g();
        return;
      }
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append("[onAEDownloadFinish] error:");
      paramAEResInfo.append(paramInt);
      AEQLog.d("CaptureQmcfSoDownloadFragment", paramAEResInfo.toString());
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append(HardCodeUtil.a(2131899608));
      paramAEResInfo.append(paramInt);
      paramAEResInfo.append("]");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", paramAEResInfo.toString(), null);
      ShortVideoResourceManager.b(HardCodeUtil.a(2131899624));
      ShortVideoErrorReport.a(2, paramInt);
      return;
    }
    if (paramAEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE)
    {
      if (paramBoolean)
      {
        paramString = new StringBuilder();
        paramString.append("[onAEDownloadFinish] success, package=");
        paramString.append(paramAEResInfo.description);
        AEQLog.d("CaptureQmcfSoDownloadFragment", paramString.toString());
        this.f = 100;
        this.g = ((this.d + this.e + this.f) / 3);
        a("doUserDownloadResource:");
        this.j = true;
        g();
        return;
      }
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append("[onAEDownloadFinish] error:");
      paramAEResInfo.append(paramInt);
      AEQLog.d("CaptureQmcfSoDownloadFragment", paramAEResInfo.toString());
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append(HardCodeUtil.a(2131899608));
      paramAEResInfo.append(paramInt);
      paramAEResInfo.append("]");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", paramAEResInfo.toString(), null);
      ShortVideoResourceManager.b(HardCodeUtil.a(2131899624));
      ShortVideoErrorReport.a(2, paramInt);
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    int i1 = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramAEResInfo == AEResInfo.AE_RES_BASE_PACKAGE) {
      this.e = i1;
    } else if (paramAEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE) {
      this.f = i1;
    }
    this.g = ((this.d + this.e + this.f) / 3);
    a("doUserDownloadResource:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("packageIdx=");
    localStringBuilder.append(paramAEResInfo.index);
    localStringBuilder.append(",totalLen=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",curOffset=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",localProgress=");
    localStringBuilder.append(i1);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2063990954) {
      return;
    }
    getBaseActivity().doOnBackPressed();
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onConfigResult]result:");
      ((StringBuilder)localObject).append(paramInt1);
      AEQLog.d("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899634));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString(), null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899626));
      ((StringBuilder)localObject).append("result:");
      ((StringBuilder)localObject).append(paramInt1);
      ShortVideoResourceManager.b(((StringBuilder)localObject).toString());
      ShortVideoErrorReport.a(1, paramInt2);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onConfigResult]:serverError");
      ((StringBuilder)localObject).append(paramInt2);
      AEQLog.d("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899605));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString(), null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899621));
      ((StringBuilder)localObject).append("serverError");
      ((StringBuilder)localObject).append(paramInt2);
      ShortVideoResourceManager.b(((StringBuilder)localObject).toString());
      ShortVideoErrorReport.a(1, paramInt2);
      ShortVideoResourceManager.a(this.l, this);
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.l, (List)localObject);
    if (paramInt1 == 0)
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]:success");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131899636), null);
      ShortVideoResourceManager.a(this.l, (List)localObject, this);
      return;
    }
    if (paramInt1 == -2)
    {
      paramInt1 = 0;
      while (paramInt1 < ((List)localObject).size())
      {
        a((ShortVideoResourceManager.SVConfigItem)((List)localObject).get(paramInt1));
        paramInt1 += 1;
      }
      AEQLog.d("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2064187578));
      ShortVideoResourceManager.a(this.l, (List)localObject, this);
      return;
    }
    if (paramInt1 == -101)
    {
      ShortVideoResourceManager.SVConfigItem localSVConfigItem = new ShortVideoResourceManager.SVConfigItem();
      a(localSVConfigItem);
      ((List)localObject).add(localSVConfigItem);
      AEQLog.d("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2064187579));
      ShortVideoResourceManager.a(this.l, (List)localObject, this);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onConfigResult]:errCode");
    ((StringBuilder)localObject).append(paramInt1);
    AEQLog.d("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131899620));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString(), null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131899607));
    ((StringBuilder)localObject).append("errorCode:");
    ((StringBuilder)localObject).append(paramInt1);
    ShortVideoResourceManager.b(((StringBuilder)localObject).toString());
    ShortVideoErrorReport.a(1, paramInt1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i1 = a();
    boolean bool3 = false;
    paramLayoutInflater = paramLayoutInflater.inflate(i1, paramViewGroup, false);
    this.b = ((CameraCaptureView)paramLayoutInflater.findViewById(2063990947));
    this.b.setDarkModeEnable(false);
    this.b.setCameraPermissionListener(this);
    paramViewGroup = DovSVParamManager.a().a(paramLayoutInflater.getContext());
    paramViewGroup.a(false);
    this.b.c(false);
    this.b.setCaptureParam(paramViewGroup);
    ((Button)paramLayoutInflater.findViewById(2063990954)).setOnClickListener(this);
    this.a = ((CircleProgress)paramLayoutInflater.findViewById(2063990988));
    this.a.setBgAndProgressColor(100, getResources().getColor(2131168464), 100, getResources().getColor(2131165591));
    this.a.setStrokeWidth(6.0F);
    this.a.setProgress(0.0F);
    this.a.setOnClickListener(this);
    this.c = ((TextView)paramLayoutInflater.findViewById(2063991106));
    this.l = ((QQAppInterface)getBaseActivity().getAppInterface());
    boolean bool1 = VideoEnvironment.supportShortVideoRecordAndPlay();
    this.m = getBaseActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    if (!bool1)
    {
      QQToast.makeText(VideoEnvironment.getContext(), HardCodeUtil.a(2131899622), 1);
      return paramLayoutInflater;
    }
    if (i()) {
      d();
    } else {
      this.k = 101;
    }
    boolean bool4 = VideoEnvironment.checkAndLoadAVCodec();
    if ((AEResUtil.e(AEResInfo.AE_RES_BASE_PACKAGE) != 2) && (AEResUtil.c(AEResInfo.AE_RES_BASE_PACKAGE))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (AEResUtil.e(AEResInfo.LIGHT_RES_BASE_PACKAGE) != 2)
    {
      bool2 = bool3;
      if (AEResUtil.c(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
        bool2 = true;
      }
    }
    if ((bool4) && (bool1) && (bool2))
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】onSoDownloadCompleted()");
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("checkAVCodecLoadIsOK loaded=true, activityId=");
      paramViewGroup.append(this.m);
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", paramViewGroup.toString(), null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragment.1(this), 5L);
      return paramLayoutInflater;
    }
    if (!bool4)
    {
      ShortVideoErrorReport.a(2);
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】startDownloadConfig");
      f();
    }
    else
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】AVcodec isReady");
      this.h = true;
      this.d = 100;
    }
    if ((bool1) && (bool2))
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】isAEKitBaseDownloaded=true, isLightBaseDownloaded=true");
      this.i = true;
      this.j = true;
      this.e = 100;
      return paramLayoutInflater;
    }
    AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】startDownloadAEKitBase / LightBase");
    if (bool1) {
      this.i = true;
    }
    if (bool2) {
      this.j = true;
    }
    a(bool1, bool2);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GestureMgr.e().a(false, this);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 4, "in CaptureQmcfSoDownloadFragment onDestroy");
    }
    b();
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onDownloadFinish] error result");
        localStringBuilder.append(paramInt);
        AEQLog.d("CaptureQmcfSoDownloadFragment", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131899640));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
        ShortVideoResourceManager.b(HardCodeUtil.a(2131899617));
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        AEQLog.d("CaptureQmcfSoDownloadFragment", "[onDownloadFinish] success");
        this.d = 100;
        this.h = true;
        g();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
  }
  
  public void onNetWorkNone()
  {
    b(HardCodeUtil.a(2131899618));
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131899606), null);
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.onResume();
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(getBaseActivity().getWindow());
    }
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i1 = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.d = i1;
    }
    this.g = ((this.d + this.e + this.f) / 3);
    a("doUserDownloadResource:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",totalLen=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",curOffset=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",localProgress=");
    localStringBuilder.append(i1);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */
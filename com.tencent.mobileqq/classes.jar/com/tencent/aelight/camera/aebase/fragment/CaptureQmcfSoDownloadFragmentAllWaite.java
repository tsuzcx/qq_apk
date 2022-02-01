package com.tencent.aelight.camera.aebase.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.api.ICaptureSoDownloadListener;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadFragmentAllWaite
  extends BaseFragment
  implements View.OnClickListener, IAEDownloadCallBack, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig, GestureMgr.GestureStatusListener
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
  
  private void a(AEResInfo paramAEResInfo)
  {
    int n = AEResUtil.e(paramAEResInfo);
    if (n == 2)
    {
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(paramAEResInfo, this, false);
      return;
    }
    if (n == 1) {
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(paramAEResInfo, null, false);
    }
  }
  
  private void a(String paramString)
  {
    g();
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.2(this, paramString));
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.3(this, paramString));
  }
  
  private void d()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadConfig netUsable=");
    localStringBuilder.append(bool);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131899638), null);
      ShortVideoResourceManager.b(this.l, this);
      return;
    }
    b(HardCodeUtil.a(2131899637));
  }
  
  private void e()
  {
    int n = AEResUtil.e(AEResInfo.AE_RES_BASE_PACKAGE);
    int i1 = AEResUtil.e(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PtvFilterSoLoad.getFilterSoState aeBaseCode=");
    localStringBuilder.append(n);
    localStringBuilder.append(" lightBaseCode= ");
    localStringBuilder.append(i1);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
    a(AEResInfo.AE_RES_BASE_PACKAGE);
    a(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    if ((n == 1) && (i1 == 1))
    {
      this.e = 100;
      this.i = true;
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportSVFilterDownloadSo=false", null);
    }
  }
  
  private void f()
  {
    if (h())
    {
      if ((this.h) && (this.i) && (this.j) && (this.k > 100)) {
        b();
      }
    }
    else if ((this.h) && (this.i) && (this.j)) {
      b();
    }
  }
  
  private void g()
  {
    if (h())
    {
      int n = (this.g + this.k) / 2;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131899631));
      localStringBuilder.append(n);
      localStringBuilder.append("%");
      b(localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131899615));
    localStringBuilder.append(this.g);
    localStringBuilder.append("%");
    b(localStringBuilder.toString());
  }
  
  private boolean h()
  {
    return false;
  }
  
  private boolean i()
  {
    return true;
  }
  
  protected int a()
  {
    return 2064056512;
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.6(this, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.5(this, paramBoolean1, paramInt));
  }
  
  protected void b()
  {
    ICaptureSoDownloadListener localICaptureSoDownloadListener = (ICaptureSoDownloadListener)getBaseActivity();
    if (localICaptureSoDownloadListener != null) {
      localICaptureSoDownloadListener.a();
    }
  }
  
  public void c()
  {
    this.k = 0;
    GestureMgr.e().a(true, this);
    boolean bool = GestureMgr.e().b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadGestureRes:");
      localStringBuilder.append(bool);
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.4(this));
      return;
    }
    this.k = 101;
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramAEResInfo != null) && (paramAEResInfo.resPrefix != null) && (paramAEResInfo.resPrefix.equals(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix)))
    {
      if (paramInt != 0)
      {
        paramAEResInfo = new StringBuilder();
        paramAEResInfo.append("[onAEDownloadFinish] error:");
        paramAEResInfo.append(paramInt);
        AEQLog.d("CaptureSoDownloadFragmentAllWaite", paramAEResInfo.toString());
        paramAEResInfo = new StringBuilder();
        paramAEResInfo.append(HardCodeUtil.a(2131899611));
        paramAEResInfo.append(paramInt);
        paramAEResInfo.append("]");
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", paramAEResInfo.toString(), null);
        ShortVideoResourceManager.b(HardCodeUtil.a(2131899603));
        ShortVideoErrorReport.a(2, paramInt);
        return;
      }
      AEQLog.d("CaptureSoDownloadFragmentAllWaite", "[onAEDownloadFinish] mFilterState:100");
      this.e = 100;
      this.i = true;
      f();
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    int n = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if ((paramAEResInfo != null) && (paramAEResInfo.resPrefix != null) && (paramAEResInfo.resPrefix.equals(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix))) {
      this.e = n;
    }
    if (i()) {
      this.g = ((this.d + this.e + this.f) / 3);
    } else {
      this.g = ((this.d + this.e) / 2);
    }
    a("doUserDownloadResourceAVCodec:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    if (paramAEResInfo == null) {
      paramAEResInfo = "null";
    } else {
      paramAEResInfo = paramAEResInfo.resPrefix;
    }
    localStringBuilder.append(paramAEResInfo);
    localStringBuilder.append(",totalLen=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",curOffset=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",localProgress=");
    localStringBuilder.append(n);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
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
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899612));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", ((StringBuilder)localObject).toString(), null);
      ShortVideoResourceManager.b(HardCodeUtil.a(2131899625));
      ShortVideoErrorReport.a(1, paramInt2);
      e();
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899627));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", ((StringBuilder)localObject).toString(), null);
      ShortVideoResourceManager.b(HardCodeUtil.a(2131899613));
      ShortVideoErrorReport.a(1, paramInt2);
      ShortVideoResourceManager.a(this.l, this);
      e();
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.l, (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131899619), null);
      ShortVideoResourceManager.a(this.l, (List)localObject, this);
      e();
      paramInt1 = PtvFilterSoLoad.g();
      if ((i()) && (paramInt1 != 0))
      {
        ShortVideoResourceManager.b(this.l, (List)localObject, this);
        return;
      }
      this.f = 100;
      this.j = true;
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportQmcfDownloadSo=false", null);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131899604));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", ((StringBuilder)localObject).toString(), null);
    ShortVideoResourceManager.b(HardCodeUtil.a(2131899629));
    ShortVideoErrorReport.a(1, paramInt1);
    e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.b = ((CameraCaptureView)paramLayoutInflater.findViewById(2063990947));
    this.b.setDarkModeEnable(false);
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
    int i1 = 1;
    if (!bool1)
    {
      QQToast.makeText(VideoEnvironment.getContext(), HardCodeUtil.a(2131899633), 1);
      return paramLayoutInflater;
    }
    if (h()) {
      c();
    } else {
      this.k = 101;
    }
    bool1 = VideoEnvironment.checkAndLoadAVCodec();
    boolean bool2 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isLightCameraResExist();
    int n = i1;
    if (i()) {
      if (PtvFilterSoLoad.g() != 2) {
        n = i1;
      } else {
        n = 0;
      }
    }
    if ((bool1) && (bool2) && (n != 0))
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("checkAVCodecLoadIsOK loaded=true, activityId=");
      paramViewGroup.append(this.m);
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", paramViewGroup.toString(), null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragmentAllWaite.1(this), 5L);
      return paramLayoutInflater;
    }
    ShortVideoErrorReport.a(2);
    d();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQAppInterface localQQAppInterface = this.l;
    if (localQQAppInterface != null)
    {
      ShortVideoResourceManager.b(localQQAppInterface, this);
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).removeCallBack(this);
      ShortVideoResourceManager.c(this.l, this);
    }
    GestureMgr.e().a(false, this);
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131899602));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
        ShortVideoResourceManager.b(HardCodeUtil.a(2131899614));
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        this.d = 100;
        this.h = true;
        f();
      }
    }
    else if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131899635));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
        ShortVideoResourceManager.b(HardCodeUtil.a(2131899623));
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        this.f = 100;
        this.j = true;
        f();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
  }
  
  public void onNetWorkNone()
  {
    b(HardCodeUtil.a(2131899632));
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131899610), null);
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
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int n = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.d = n;
    } else if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      this.f = n;
    }
    if (i()) {
      this.g = ((this.d + this.e + this.f) / 3);
    } else {
      this.g = ((this.d + this.e) / 2);
    }
    a("doUserDownloadResourceAVCodec:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",totalLen=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",curOffset=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",localProgress=");
    localStringBuilder.append(n);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragmentAllWaite
 * JD-Core Version:    0.7.0.1
 */
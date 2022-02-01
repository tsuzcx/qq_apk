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
  private int jdField_a_of_type_Int = 0;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = 0;
  private volatile int e = 0;
  
  private void a(AEResInfo paramAEResInfo)
  {
    int i = AEResUtil.a(paramAEResInfo);
    if (i == 2)
    {
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(paramAEResInfo, this, false);
      return;
    }
    if (i == 1) {
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(paramAEResInfo, null, false);
    }
  }
  
  private void a(String paramString)
  {
    f();
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.2(this, paramString));
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.3(this, paramString));
  }
  
  private boolean b()
  {
    return true;
  }
  
  private void c()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadConfig netUsable=");
    localStringBuilder.append(bool);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701616), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(HardCodeUtil.a(2131701615));
  }
  
  private void d()
  {
    int i = AEResUtil.a(AEResInfo.AE_RES_BASE_PACKAGE);
    int j = AEResUtil.a(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PtvFilterSoLoad.getFilterSoState aeBaseCode=");
    localStringBuilder.append(i);
    localStringBuilder.append(" lightBaseCode= ");
    localStringBuilder.append(j);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
    a(AEResInfo.AE_RES_BASE_PACKAGE);
    a(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    if ((i == 1) && (j == 1))
    {
      this.jdField_b_of_type_Int = 100;
      this.jdField_b_of_type_Boolean = true;
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportSVFilterDownloadSo=false", null);
    }
  }
  
  private void e()
  {
    if (a())
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.e > 100)) {
        a();
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      a();
    }
  }
  
  private void f()
  {
    if (a())
    {
      int i = (this.d + this.e) / 2;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131701609));
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      b(localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131701593));
    localStringBuilder.append(this.d);
    localStringBuilder.append("%");
    b(localStringBuilder.toString());
  }
  
  protected int a()
  {
    return 2064318682;
  }
  
  protected void a()
  {
    ICaptureSoDownloadListener localICaptureSoDownloadListener = (ICaptureSoDownloadListener)getBaseActivity();
    if (localICaptureSoDownloadListener != null) {
      localICaptureSoDownloadListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.6(this, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.5(this, paramBoolean1, paramInt));
  }
  
  public void b()
  {
    this.e = 0;
    GestureMgr.a().a(true, this);
    boolean bool = GestureMgr.a().a();
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
    this.e = 101;
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
        paramAEResInfo.append(HardCodeUtil.a(2131701589));
        paramAEResInfo.append(paramInt);
        paramAEResInfo.append("]");
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", paramAEResInfo.toString(), null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131701581));
        ShortVideoErrorReport.a(2, paramInt);
        return;
      }
      AEQLog.d("CaptureSoDownloadFragmentAllWaite", "[onAEDownloadFinish] mFilterState:100");
      this.jdField_b_of_type_Int = 100;
      this.jdField_b_of_type_Boolean = true;
      e();
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if ((paramAEResInfo != null) && (paramAEResInfo.resPrefix != null) && (paramAEResInfo.resPrefix.equals(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix))) {
      this.jdField_b_of_type_Int = i;
    }
    if (b()) {
      this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
    } else {
      this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
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
    localStringBuilder.append(i);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2064122021) {
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
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131701590));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", ((StringBuilder)localObject).toString(), null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131701603));
      ShortVideoErrorReport.a(1, paramInt2);
      d();
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131701605));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", ((StringBuilder)localObject).toString(), null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131701591));
      ShortVideoErrorReport.a(1, paramInt2);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      d();
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701597), null);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, this);
      d();
      paramInt1 = PtvFilterSoLoad.a();
      if ((b()) && (paramInt1 != 0))
      {
        ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, this);
        return;
      }
      this.jdField_c_of_type_Int = 100;
      this.jdField_c_of_type_Boolean = true;
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportQmcfDownloadSo=false", null);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131701582));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", ((StringBuilder)localObject).toString(), null);
    ShortVideoResourceManager.a(HardCodeUtil.a(2131701607));
    ShortVideoErrorReport.a(1, paramInt1);
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2064122016));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    paramViewGroup = DovSVParamManager.a().a(paramLayoutInflater.getContext());
    paramViewGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(paramViewGroup);
    ((Button)paramLayoutInflater.findViewById(2064122021)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2064122074));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167394), 100, getResources().getColor(2131165349));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2064122224));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppInterface());
    boolean bool1 = VideoEnvironment.supportShortVideoRecordAndPlay();
    this.jdField_a_of_type_JavaLangString = getBaseActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    int j = 1;
    if (!bool1)
    {
      QQToast.a(VideoEnvironment.getContext(), HardCodeUtil.a(2131701611), 1);
      return paramLayoutInflater;
    }
    if (a()) {
      b();
    } else {
      this.e = 101;
    }
    bool1 = VideoEnvironment.checkAndLoadAVCodec();
    boolean bool2 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isLightCameraResExist();
    int i = j;
    if (b()) {
      if (PtvFilterSoLoad.a() != 2) {
        i = j;
      } else {
        i = 0;
      }
    }
    if ((bool1) && (bool2) && (i != 0))
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("checkAVCodecLoadIsOK loaded=true, activityId=");
      paramViewGroup.append(this.jdField_a_of_type_JavaLangString);
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", paramViewGroup.toString(), null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragmentAllWaite.1(this), 5L);
      return paramLayoutInflater;
    }
    ShortVideoErrorReport.a(2);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      ShortVideoResourceManager.b(localQQAppInterface, this);
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).removeCallBack(this);
      ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
    GestureMgr.a().a(false, this);
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131701580));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131701592));
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        this.jdField_a_of_type_Int = 100;
        this.jdField_a_of_type_Boolean = true;
        e();
      }
    }
    else if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131701613));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131701601));
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        this.jdField_c_of_type_Int = 100;
        this.jdField_c_of_type_Boolean = true;
        e();
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
    b(HardCodeUtil.a(2131701610));
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701588), null);
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onResume();
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    } else if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      this.jdField_c_of_type_Int = i;
    }
    if (b()) {
      this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
    } else {
      this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
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
    localStringBuilder.append(i);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", localStringBuilder.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragmentAllWaite
 * JD-Core Version:    0.7.0.1
 */
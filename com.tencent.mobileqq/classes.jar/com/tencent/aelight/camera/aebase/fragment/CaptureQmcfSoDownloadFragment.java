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
  private int jdField_d_of_type_Int = 0;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private volatile int jdField_e_of_type_Int = 0;
  private volatile boolean jdField_e_of_type_Boolean = false;
  private volatile boolean f = false;
  
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
    g();
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
      localStringBuilder.append(HardCodeUtil.a(2131701587));
      AEQLog.d("CaptureQmcfSoDownloadFragment", localStringBuilder.toString());
      b(HardCodeUtil.a(2131701587));
    }
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.3(this, paramString));
  }
  
  private void e()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadConfig netUsable=");
    localStringBuilder.append(bool);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701594), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(HardCodeUtil.a(2131701606));
  }
  
  private void f()
  {
    if (a())
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Int > 100) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
        b();
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isAvCodecDownloaded]");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      AEQLog.b("CaptureQmcfSoDownloadFragment", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isAEKitBaseDownloaded]");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      AEQLog.b("CaptureQmcfSoDownloadFragment", localStringBuilder.toString());
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
        b();
      }
    }
  }
  
  private void g()
  {
    if (a())
    {
      int i = (this.jdField_d_of_type_Int + this.jdField_e_of_type_Int) / 2;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131701608));
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      b(localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131701617));
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("%");
    b(localStringBuilder.toString());
  }
  
  protected int a()
  {
    return 2064318682;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      ShortVideoResourceManager.b(localQQAppInterface, this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    AEResManager.a().a(this);
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.6(this, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.5(this, paramBoolean1, paramInt));
  }
  
  protected void b()
  {
    try
    {
      this.f = true;
      if ((!this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean))
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
  
  public void c()
  {
    this.jdField_e_of_type_Int = 0;
    GestureMgr.a().a(true, this);
    boolean bool = GestureMgr.a().a();
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
    this.jdField_e_of_type_Int = 101;
  }
  
  public void d()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if ((getBaseActivity() instanceof CaptureQmcfSoDownloadActivity))
    {
      CaptureQmcfSoDownloadActivity localCaptureQmcfSoDownloadActivity = (CaptureQmcfSoDownloadActivity)getBaseActivity();
      int i;
      if (localCaptureQmcfSoDownloadActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (localCaptureQmcfSoDownloadActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        j = 1;
      } else {
        j = 0;
      }
      if ((i != 0) && (j != 0))
      {
        this.jdField_d_of_type_Boolean = true;
        localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        return;
      }
      if (i != 0)
      {
        this.jdField_d_of_type_Boolean = true;
        localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
    }
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    Object localObject = getBaseActivity();
    int i;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0)) {
      localObject = DialogUtil.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
    } else if (i != 0) {
      localObject = DialogUtil.a(new String[] { "android.permission.CAMERA" });
    } else {
      localObject = DialogUtil.a(new String[] { "android.permission.RECORD_AUDIO" });
    }
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.7(this, (String)localObject));
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    try
    {
      this.jdField_e_of_type_Boolean = true;
      if (this.f)
      {
        ICaptureSoDownloadListener localICaptureSoDownloadListener = (ICaptureSoDownloadListener)getBaseActivity();
        if (localICaptureSoDownloadListener != null) {
          localICaptureSoDownloadListener.a();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionResult(true);
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
        this.jdField_b_of_type_Int = 100;
        this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
        a("doUserDownloadResource:");
        this.jdField_b_of_type_Boolean = true;
        f();
        return;
      }
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append("[onAEDownloadFinish] error:");
      paramAEResInfo.append(paramInt);
      AEQLog.d("CaptureQmcfSoDownloadFragment", paramAEResInfo.toString());
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append(HardCodeUtil.a(2131701586));
      paramAEResInfo.append(paramInt);
      paramAEResInfo.append("]");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", paramAEResInfo.toString(), null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131701602));
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
        this.jdField_c_of_type_Int = 100;
        this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
        a("doUserDownloadResource:");
        this.jdField_c_of_type_Boolean = true;
        f();
        return;
      }
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append("[onAEDownloadFinish] error:");
      paramAEResInfo.append(paramInt);
      AEQLog.d("CaptureQmcfSoDownloadFragment", paramAEResInfo.toString());
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append(HardCodeUtil.a(2131701586));
      paramAEResInfo.append(paramInt);
      paramAEResInfo.append("]");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", paramAEResInfo.toString(), null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131701602));
      ShortVideoErrorReport.a(2, paramInt);
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramAEResInfo == AEResInfo.AE_RES_BASE_PACKAGE) {
      this.jdField_b_of_type_Int = i;
    } else if (paramAEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE) {
      this.jdField_c_of_type_Int = i;
    }
    this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
    a("doUserDownloadResource:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("packageIdx=");
    localStringBuilder.append(paramAEResInfo.index);
    localStringBuilder.append(",totalLen=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",curOffset=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",localProgress=");
    localStringBuilder.append(i);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
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
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onConfigResult]result:");
      ((StringBuilder)localObject).append(paramInt1);
      AEQLog.d("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131701612));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString(), null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131701604));
      ((StringBuilder)localObject).append("result:");
      ((StringBuilder)localObject).append(paramInt1);
      ShortVideoResourceManager.a(((StringBuilder)localObject).toString());
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
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131701583));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString(), null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131701599));
      ((StringBuilder)localObject).append("serverError");
      ((StringBuilder)localObject).append(paramInt2);
      ShortVideoResourceManager.a(((StringBuilder)localObject).toString());
      ShortVideoErrorReport.a(1, paramInt2);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject);
    if (paramInt1 == 0)
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]:success");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701614), null);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, this);
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
      AEQLog.d("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2064515231));
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, this);
      return;
    }
    if (paramInt1 == -101)
    {
      ShortVideoResourceManager.SVConfigItem localSVConfigItem = new ShortVideoResourceManager.SVConfigItem();
      a(localSVConfigItem);
      ((List)localObject).add(localSVConfigItem);
      AEQLog.d("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2064515232));
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, this);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onConfigResult]:errCode");
    ((StringBuilder)localObject).append(paramInt1);
    AEQLog.d("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131701598));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", ((StringBuilder)localObject).toString(), null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131701585));
    ((StringBuilder)localObject).append("errorCode:");
    ((StringBuilder)localObject).append(paramInt1);
    ShortVideoResourceManager.a(((StringBuilder)localObject).toString());
    ShortVideoErrorReport.a(1, paramInt1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = a();
    boolean bool3 = false;
    paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2064122016));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionListener(this);
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
    if (!bool1)
    {
      QQToast.a(VideoEnvironment.getContext(), HardCodeUtil.a(2131701600), 1);
      return paramLayoutInflater;
    }
    if (a()) {
      c();
    } else {
      this.jdField_e_of_type_Int = 101;
    }
    boolean bool4 = VideoEnvironment.checkAndLoadAVCodec();
    if ((AEResUtil.a(AEResInfo.AE_RES_BASE_PACKAGE) != 2) && (AEResUtil.a(AEResInfo.AE_RES_BASE_PACKAGE))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (AEResUtil.a(AEResInfo.LIGHT_RES_BASE_PACKAGE) != 2)
    {
      bool2 = bool3;
      if (AEResUtil.a(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
        bool2 = true;
      }
    }
    if ((bool4) && (bool1) && (bool2))
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】onSoDownloadCompleted()");
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("checkAVCodecLoadIsOK loaded=true, activityId=");
      paramViewGroup.append(this.jdField_a_of_type_JavaLangString);
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", paramViewGroup.toString(), null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragment.1(this), 5L);
      return paramLayoutInflater;
    }
    if (!bool4)
    {
      ShortVideoErrorReport.a(2);
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】startDownloadConfig");
      e();
    }
    else
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】AVcodec isReady");
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 100;
    }
    if ((bool1) && (bool2))
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】isAEKitBaseDownloaded=true, isLightBaseDownloaded=true");
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Int = 100;
      return paramLayoutInflater;
    }
    AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】startDownloadAEKitBase / LightBase");
    if (bool1) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (bool2) {
      this.jdField_c_of_type_Boolean = true;
    }
    a(bool1, bool2);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GestureMgr.a().a(false, this);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 4, "in CaptureQmcfSoDownloadFragment onDestroy");
    }
    a();
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
        localStringBuilder.append(HardCodeUtil.a(2131701618));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131701595));
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        AEQLog.d("CaptureQmcfSoDownloadFragment", "[onDownloadFinish] success");
        this.jdField_a_of_type_Int = 100;
        this.jdField_a_of_type_Boolean = true;
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
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
  }
  
  public void onNetWorkNone()
  {
    b(HardCodeUtil.a(2131701596));
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701584), null);
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
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(getBaseActivity().getWindow());
    }
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
    a("doUserDownloadResource:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",totalLen=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",curOffset=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",localProgress=");
    localStringBuilder.append(i);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", localStringBuilder.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */
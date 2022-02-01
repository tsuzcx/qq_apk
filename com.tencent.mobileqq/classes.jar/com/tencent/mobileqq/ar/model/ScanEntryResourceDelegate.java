package com.tencent.mobileqq.ar.model;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.IArConfigListener;
import com.tencent.mobileqq.ar.IArFaceResourceListener;
import com.tencent.mobileqq.ar.IArSoListener;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public final class ScanEntryResourceDelegate
  implements IArConfigListener, IArFaceResourceListener, IArSoListener, SDKInitListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RemoteArConfigManager jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager;
  private ScanEntryResourceDelegate.ARBaseResDownLoadCallBack jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack;
  private ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack;
  private ScanEntryResourceDelegate.OnAREntryResourcePreapreListener jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$OnAREntryResourcePreapreListener;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  
  public ScanEntryResourceDelegate(Activity paramActivity, RemoteArConfigManager paramRemoteArConfigManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = paramRemoteArConfigManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(long paramLong)
  {
    long l = 0x2 & paramLong;
    if ((l != 0L) && (!this.jdField_b_of_type_Boolean)) {
      g();
    }
    if (((paramLong & 0x8) != 0L) && (!this.jdField_d_of_type_Boolean)) {
      h();
    }
    if ((l != 0L) && ((!this.g) || (!this.jdField_d_of_type_Boolean))) {
      i();
    }
  }
  
  private boolean a(long paramLong)
  {
    return (this.jdField_a_of_type_Long & 0x2) != 0L;
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      ScanEntryResourceDelegate.ARBaseResDownLoadCallBack localARBaseResDownLoadCallBack = this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack;
      if (localARBaseResDownLoadCallBack != null) {
        localARBaseResDownLoadCallBack.a();
      }
    }
    else if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack != null)
      {
        QLog.d("ScanEntryResourceDelegate", 1, "ARBaseSo res download fail");
        this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack.b();
      }
    }
  }
  
  private void k()
  {
    boolean bool = a(2L);
    int j = 0;
    if (bool) {
      j = 0 + this.jdField_a_of_type_Int;
    }
    int k = j;
    if (a(8L)) {
      k = j + this.jdField_b_of_type_Int;
    }
    ScanEntryResourceDelegate.ARBaseResDownLoadCallBack localARBaseResDownLoadCallBack = this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack;
    if (localARBaseResDownLoadCallBack != null) {
      localARBaseResDownLoadCallBack.a(k / 2);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1) {
        this.jdField_d_of_type_Int = paramInt2;
      }
    }
    else {
      this.jdField_c_of_type_Int = paramInt2;
    }
    ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack localAsyncFaceResDownloadCallBack = this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack;
    if (localAsyncFaceResDownloadCallBack != null) {
      localAsyncFaceResDownloadCallBack.a((this.jdField_c_of_type_Int + this.jdField_d_of_type_Int) / 2);
    }
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong, ScanEntryResourceDelegate.ARBaseResDownLoadCallBack paramARBaseResDownLoadCallBack, ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack paramAsyncFaceResDownloadCallBack)
  {
    if (paramLong == 0L) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack = paramARBaseResDownLoadCallBack;
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack = paramAsyncFaceResDownloadCallBack;
    a(paramLong);
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (this.i) {
      return;
    }
    ScanEntryResourceDelegate.OnAREntryResourcePreapreListener localOnAREntryResourcePreapreListener = this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$OnAREntryResourcePreapreListener;
    if (localOnAREntryResourcePreapreListener != null) {
      localOnAREntryResourcePreapreListener.a(paramARCommonConfigInfo);
    }
    this.i = true;
  }
  
  public void a(ArConfigInfo paramArConfigInfo) {}
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    ARDeviceController.a().a(paramArEffectConfig);
  }
  
  public void a(ScanEntryResourceDelegate.OnAREntryResourcePreapreListener paramOnAREntryResourcePreapreListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$OnAREntryResourcePreapreListener = paramOnAREntryResourcePreapreListener;
  }
  
  public boolean a()
  {
    if ((a(2L)) && (!a(2))) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    boolean bool1 = bool2;
    if (a(8L)) {
      if ((bool2) && (a(8))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    boolean bool2 = bool1;
    if (a(4L))
    {
      if ((bool1) && (a(4))) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 2)
    {
      if (paramInt != 4)
      {
        if (paramInt != 8) {
          return false;
        }
        return this.jdField_c_of_type_Boolean;
      }
      bool1 = bool2;
      if (this.e)
      {
        bool1 = bool2;
        if (this.f) {
          return true;
        }
      }
    }
    else
    {
      bool1 = this.jdField_a_of_type_Boolean;
    }
    return bool1;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onArSoDownloadProcess process.");
    localStringBuilder.append(paramInt);
    QLog.d("ScanEntryResourceDelegate", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Int = paramInt;
    k();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1)
      {
        this.f = false;
        this.h = false;
      }
    }
    else
    {
      this.e = false;
      this.g = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack != null)
    {
      QLog.d("ScanEntryResourceDelegate", 1, "face so download not ready download fail");
      this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack.b();
    }
  }
  
  public boolean b()
  {
    boolean bool1 = a(2L);
    boolean bool3 = false;
    if (bool1) {
      bool1 = this.jdField_b_of_type_Boolean;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (a(8L)) {
      bool2 = this.jdField_d_of_type_Boolean;
    } else {
      bool2 = false;
    }
    int j;
    if ((a(4L)) && ((this.g) || (this.h))) {
      j = 1;
    } else {
      j = 0;
    }
    if ((!bool1) && (!bool2))
    {
      bool1 = bool3;
      if (j == 0) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 100;
    j();
  }
  
  public void c(int paramInt)
  {
    QLog.d("ScanEntryResourceDelegate", 2, new Object[] { "notifyVoiceScanStatusChange state.", Integer.valueOf(paramInt) });
    RemoteArConfigManager localRemoteArConfigManager = this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager;
    if (localRemoteArConfigManager != null) {
      try
      {
        localRemoteArConfigManager.b(paramInt);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("ScanEntryResourceDelegate", 1, "notifyVoiceScanStatusChange fail.", localException);
      }
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    j();
  }
  
  public boolean d()
  {
    return (this.e) && (this.f);
  }
  
  public void e()
  {
    long l = this.jdField_a_of_type_Long;
    if (l == 0L) {
      return;
    }
    a(l, this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack, this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack = null;
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack = null;
  }
  
  public void g()
  {
    try
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
      }
      else
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Int = 100;
      }
      QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARResource mIsArSoReady=%s mArSoDownloading=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
      return;
    }
    catch (Exception localException)
    {
      label80:
      break label80;
    }
    QLog.d("ScanEntryResourceDelegate", 1, "downloadARResource fail");
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = QQVideoPlaySDKManager.a();
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      if (!QQVideoPlaySDKManager.a()) {
        QQVideoPlaySDKManager.a(BaseApplicationImpl.getContext(), this);
      }
    }
    else
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 100;
    }
    QLog.d("ScanEntryResourceDelegate", 1, String.format("installVideoPlugin mIsVideoPluginReady=%s mVideoPluginDownloading=%s", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
  }
  
  public void h_(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.f = true;
        this.h = false;
        this.jdField_d_of_type_Int = 100;
      }
    }
    else
    {
      this.e = true;
      this.g = false;
      this.jdField_c_of_type_Int = 100;
    }
    if ((this.e) && (this.f))
    {
      ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack localAsyncFaceResDownloadCallBack = this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack;
      if (localAsyncFaceResDownloadCallBack != null) {
        localAsyncFaceResDownloadCallBack.a();
      }
    }
  }
  
  public void i()
  {
    this.f = true;
    this.e = true;
    this.g = false;
    this.jdField_c_of_type_Int = 100;
    QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceSoReady=%s mFaceSoDownloading=%s", new Object[] { Boolean.valueOf(this.f), Boolean.valueOf(this.h) }));
    QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceModelReady=%s mFaceModelDownloading=%s", new Object[] { Boolean.valueOf(this.e), Boolean.valueOf(this.g) }));
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSDKInited result.");
    localStringBuilder.append(paramBoolean);
    QLog.d("ScanEntryResourceDelegate", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 100;
      j();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate
 * JD-Core Version:    0.7.0.1
 */
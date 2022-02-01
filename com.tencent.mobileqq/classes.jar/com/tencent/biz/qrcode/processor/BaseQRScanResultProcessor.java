package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.IQRScanResultProcessor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public abstract class BaseQRScanResultProcessor
  implements IQRScanResultProcessor
{
  protected OnQRHandleResultCallback a;
  protected AppRuntime a;
  
  public BaseQRScanResultProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqQrscanOnQRHandleResultCallback = paramOnQRHandleResultCallback;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return b();
  }
  
  protected boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    return false;
  }
  
  protected boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    if ((!((QQAppInterface)localObject).isRingerVibrate()) && (!((QQAppInterface)localObject).isRingerSilent()) && (!((QQAppInterface)localObject).isRingEqualsZero())) {
      AudioUtil.b(2131230765, false);
    }
  }
  
  protected boolean b()
  {
    Object localObject = (Activity)this.jdField_a_of_type_ComTencentMobileqqQrscanOnQRHandleResultCallback.a();
    if (!HttpUtil.isConnect((Context)localObject))
    {
      localObject = DialogUtil.a((Context)localObject, 230);
      ((QQCustomDialog)localObject).setMessage(2131718419);
      BaseQRScanResultProcessor.1 local1 = new BaseQRScanResultProcessor.1(this);
      ((QQCustomDialog)localObject).setPositiveButton(2131694583, local1);
      ((QQCustomDialog)localObject).setOnCancelListener(local1);
      ((QQCustomDialog)localObject).show();
      return false;
    }
    return true;
  }
  
  protected boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public boolean b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("handleActivityResult requestCode=%d resultCode=%d data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
    return c(paramInt1, paramInt2, paramIntent);
  }
  
  public final boolean b(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    boolean bool = a();
    QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("handleQRResult result=%s qBarType=%s checkNetWork=%b scannerParams=%s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool), paramScannerParams }));
    if (bool)
    {
      b();
      return a(paramString1, paramString2, paramScannerParams);
    }
    return false;
  }
  
  protected boolean c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
 * JD-Core Version:    0.7.0.1
 */
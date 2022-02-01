package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class CardQRProcessor
  extends BaseQRScanResultProcessor
{
  private int a;
  
  public CardQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static int a(String paramString)
  {
    String str = paramString.toLowerCase();
    if ((Pattern.compile("^mecard.*").matcher(str).matches()) && ((paramString.length() > 7) || (paramString.contains(":")))) {
      j = 0;
    } else {
      j = -1;
    }
    int i = j;
    if (Pattern.compile("^begin:vcard[\\s\\S]*end:vcard").matcher(str).matches()) {
      if (paramString.length() <= 21)
      {
        i = j;
        if (!paramString.contains(":")) {}
      }
      else
      {
        i = 1;
      }
    }
    int j = i;
    if (Pattern.compile("^bizcard.*;;$").matcher(str).matches()) {
      if (paramString.length() <= 11)
      {
        j = i;
        if (!paramString.contains(":")) {}
      }
      else
      {
        j = 2;
      }
    }
    return j;
  }
  
  public String a()
  {
    return "CardQRProcessor";
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    this.jdField_a_of_type_Int = a(paramString1);
    paramString2 = a();
    boolean bool2 = false;
    QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("intercept proc=[%s] cardMode=%d result=%s", new Object[] { paramString2, Integer.valueOf(this.jdField_a_of_type_Int), paramString1 }));
    boolean bool1 = bool2;
    if (a(paramInt))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      return false;
    }
    paramString2 = (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
    paramScannerParams = (Activity)this.jdField_a_of_type_ComTencentMobileqqQrscanOnQRHandleResultCallback.a();
    if (this.jdField_a_of_type_Int != -1)
    {
      ((IQRJumpApi)QRoute.api(IQRJumpApi.class)).displayQRCard(paramString2, paramScannerParams, paramString1, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqQrscanOnQRHandleResultCallback.b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.CardQRProcessor
 * JD-Core Version:    0.7.0.1
 */
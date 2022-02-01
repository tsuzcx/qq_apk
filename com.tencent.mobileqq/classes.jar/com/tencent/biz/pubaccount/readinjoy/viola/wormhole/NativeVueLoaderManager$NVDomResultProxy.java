package com.tencent.biz.pubaccount.readinjoy.viola.wormhole;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.nativevue.NativeVueEngine.DomResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;

class NativeVueLoaderManager$NVDomResultProxy
  implements NativeVueEngine.DomResult, Runnable
{
  private long jdField_a_of_type_Long;
  private NativeVueEngine.DomResult jdField_a_of_type_ComTencentNativevueNativeVueEngine$DomResult;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public NativeVueLoaderManager$NVDomResultProxy(NativeVueLoaderManager paramNativeVueLoaderManager, NativeVueEngine.DomResult paramDomResult, String paramString)
  {
    this.jdField_a_of_type_ComTencentNativevueNativeVueEngine$DomResult = paramDomResult;
    this.jdField_a_of_type_JavaLangString = paramString;
    NativeVueLoaderManager.a(paramNativeVueLoaderManager).postDelayed(this, 1300L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onResult(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.e("NativeVueLoaderManager", 1, "waiting native vue timeout");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    NativeVueLoaderManager.a(this.this$0).removeCallbacks(this);
    if (this.jdField_a_of_type_ComTencentNativevueNativeVueEngine$DomResult != null) {
      this.jdField_a_of_type_ComTencentNativevueNativeVueEngine$DomResult.onResult(paramString);
    }
    NativeVueLoaderManager.a(this.this$0, l1 - l2, this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = "1";; paramString = "2")
    {
      ViolaUtils.reportNVProcess(paramString, this.jdField_a_of_type_JavaLangString);
      NativeVueLoaderManager.a(this.this$0, null);
      return;
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentNativevueNativeVueEngine$DomResult != null) {
      this.jdField_a_of_type_ComTencentNativevueNativeVueEngine$DomResult.onResult("");
    }
    QLog.e("NativeVueLoaderManager", 1, "NativeVue create Dom timeout, url: " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager.NVDomResultProxy
 * JD-Core Version:    0.7.0.1
 */
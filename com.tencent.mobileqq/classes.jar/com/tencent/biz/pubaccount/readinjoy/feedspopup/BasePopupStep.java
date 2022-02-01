package com.tencent.biz.pubaccount.readinjoy.feedspopup;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public abstract class BasePopupStep
{
  @NotNull
  private RIJPopupAutomator jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator;
  @NotNull
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public BasePopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, @NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator = paramRIJPopupAutomator;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public RIJPopupAutomator a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onCreate");
    }
  }
  
  @UiThread
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.a(this, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onDestroy");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onResume");
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onPause");
    }
  }
  
  public void e()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onShowSelf");
    }
  }
  
  public void f()
  {
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onHideSelf");
    }
  }
  
  protected abstract void g();
  
  protected abstract void h();
  
  @NonNull
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep
 * JD-Core Version:    0.7.0.1
 */
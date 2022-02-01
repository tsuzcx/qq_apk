package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.BaseActivity;

class AIOImageProviderService$6
  implements Runnable
{
  AIOImageProviderService$6(AIOImageProviderService paramAIOImageProviderService, boolean paramBoolean, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
      return;
    }
    NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.b, this.jdField_a_of_type_JavaLangString, this.c, NewReportPlugin.a(this.jdField_a_of_type_Int), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.6
 * JD-Core Version:    0.7.0.1
 */
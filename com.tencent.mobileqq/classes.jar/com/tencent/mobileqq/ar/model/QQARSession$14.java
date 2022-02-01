package com.tencent.mobileqq.ar.model;

import apgw;
import apiv;
import apof;
import apoh;
import apse;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQARSession$14
  implements Runnable
{
  public QQARSession$14(apse paramapse, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    if (((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a())) && ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())) && (apse.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (apse.a(this.this$0) != null))
    {
      localObject = apse.a(this.this$0);
      if (!this.jdField_a_of_type_Boolean) {
        break label174;
      }
    }
    label174:
    for (int i = 4;; i = 5)
    {
      ((apof)localObject).a(1, i);
      if (apse.a(this.this$0) != null)
      {
        apse.b(apse.a(this.this$0));
        apse.a(this.this$0, null);
      }
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end.");
      apse.b(this.this$0, false);
      apse.b(this.this$0);
      ThreadManager.getUIHandler().post(new QQARSession.14.1(this));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a()) {
      if ((apse.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (apse.a(this.this$0) != null)) {
        apse.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 10, 0, null);
      }
    }
    for (;;)
    {
      apse.b(this.this$0, false);
      this.this$0.b = null;
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b()) {
        break;
      }
      if ((apse.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.c;
    if ((!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) && (apse.d(this.this$0)))
    {
      if ((apse.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (apse.a(this.this$0) != null)) {
        apse.a(this.this$0).a(1L, new apiv(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo));
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f()) {
        break label584;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f()) {
        apgw.a().a(1);
      }
      this.this$0.a(1L);
      apse.a(this.this$0, 1L, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 0, 0.0F, 0.0F, 0.0F);
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
        apse.c(this.this$0, false);
      }
    }
    for (;;)
    {
      if (this.this$0.jdField_a_of_type_Apoh != null)
      {
        this.this$0.jdField_a_of_type_Apoh.a((String)localObject, str, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        apse.a(this.this$0, 0L);
        apse.b(this.this$0, 0L);
      }
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end. isNeedInternalRender = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f() + ", isNeedExternalRender = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g() + ", isNeedWaitUserOperation = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h());
      break;
      label584:
      if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h()) || (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g())
        {
          this.this$0.a(1L);
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
            apse.c(this.this$0, true);
          }
        }
      }
      else {
        apse.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.14
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.model;

import amqa;
import amrz;
import amxp;
import anbo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQARSession$18
  implements Runnable
{
  public QQARSession$18(anbo paramanbo, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    int i;
    if (((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())) && (anbo.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (anbo.a(this.this$0) != null))
    {
      amxp localamxp = anbo.a(this.this$0);
      if (this.jdField_a_of_type_Boolean)
      {
        i = 4;
        localamxp.a(1, i);
      }
    }
    else
    {
      if (anbo.a(this.this$0) != null)
      {
        QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
        anbo.b(anbo.a(this.this$0));
        anbo.a(this.this$0, null);
      }
      if (this.jdField_a_of_type_Boolean) {
        break label161;
      }
      QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete end.");
      this.this$0.o();
      ThreadManager.getUIHandler().post(new QQARSession.18.1(this));
    }
    label161:
    do
    {
      do
      {
        return;
        i = 5;
        break;
        QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete end. isNeedInternalRender = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f() + ", isNeedExternalRender = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g() + ", isNeedWaitUserOperation = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h());
        if (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b()) {
          break label265;
        }
      } while ((!anbo.b(this.this$0)) || (this.this$0.jdField_a_of_type_Int != 2));
      this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      return;
      if ((anbo.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (anbo.a(this.this$0) != null)) {
        anbo.a(this.this$0).a(2048L, new amrz(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
      {
        this.this$0.o();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f())
      {
        amqa.a().a(2);
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
          anbo.c(this.this$0, false);
        }
        anbo.a(this.this$0, 2048L, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, -1, 0.0F, 0.0F, 0.0F);
        return;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h()) && (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g())) {
        break label446;
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()));
    label265:
    anbo.c(this.this$0, true);
    return;
    label446:
    this.this$0.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.18
 * JD-Core Version:    0.7.0.1
 */
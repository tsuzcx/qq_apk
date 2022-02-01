package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QQARSession$18
  implements Runnable
{
  QQARSession$18(QQARSession paramQQARSession, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    if (((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())) && (QQARSession.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (QQARSession.a(this.this$0) != null))
    {
      localObject = QQARSession.a(this.this$0);
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 4;
      } else {
        i = 5;
      }
      ((AREngineCallback)localObject).a(1, i);
    }
    if (QQARSession.a(this.this$0) != null)
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
      QQARSession.b(QQARSession.a(this.this$0));
      QQARSession.a(this.this$0, null);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete end.");
      this.this$0.q();
      ThreadManager.getUIHandler().post(new QQARSession.18.1(this));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onARSceneRecogDownloadComplete end. isNeedInternalRender = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f());
    ((StringBuilder)localObject).append(", isNeedExternalRender = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g());
    ((StringBuilder)localObject).append(", isNeedWaitUserOperation = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h());
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())
    {
      if ((QQARSession.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      }
    }
    else
    {
      if ((QQARSession.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (QQARSession.a(this.this$0) != null)) {
        QQARSession.a(this.this$0).a(2048L, new ARTarget(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
      {
        this.this$0.q();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f())
      {
        ARVideoRecordUIControllerImpl.a().a(2);
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
          QQARSession.c(this.this$0, false);
        }
        QQARSession.a(this.this$0, 2048L, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, -1, 0.0F, 0.0F, 0.0F);
        return;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h()) && (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()))
      {
        this.this$0.q();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()) && (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())) {
        QQARSession.c(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.18
 * JD-Core Version:    0.7.0.1
 */
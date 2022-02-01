package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QQARSession$14
  implements Runnable
{
  QQARSession$14(QQARSession paramQQARSession, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    Object localObject1;
    if (((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a())) && ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())) && (QQARSession.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (QQARSession.a(this.this$0) != null))
    {
      localObject1 = QQARSession.a(this.this$0);
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 4;
      } else {
        i = 5;
      }
      ((AREngineCallback)localObject1).a(1, i);
    }
    if (QQARSession.a(this.this$0) != null)
    {
      QQARSession.b(QQARSession.a(this.this$0));
      QQARSession.a(this.this$0, null);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end.");
      QQARSession.b(this.this$0, false);
      QQARSession.b(this.this$0);
      ThreadManager.getUIHandler().post(new QQARSession.14.1(this));
      return;
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a())
    {
      if ((QQARSession.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (QQARSession.a(this.this$0) != null))
      {
        localObject1 = QQARSession.a(this.this$0);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
        ((AREngineCallback)localObject1).a((ArCloudConfigInfo)localObject2, (ArCloudConfigInfo)localObject2, 10, 0, null);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())
    {
      if ((QQARSession.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.a;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.c;
      if ((!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) && (QQARSession.d(this.this$0)))
      {
        if ((QQARSession.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (QQARSession.a(this.this$0) != null)) {
          QQARSession.a(this.this$0).a(1L, new ARTarget(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f()) {
            ARVideoRecordUIControllerImpl.a().a(1);
          }
          this.this$0.a(1L);
          QQARSession.a(this.this$0, 1L, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 0, 0.0F, 0.0F, 0.0F);
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
            QQARSession.c(this.this$0, false);
          }
        }
        else if ((!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h()) && (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()))
        {
          QQARSession.b(this.this$0);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g())
        {
          this.this$0.a(1L);
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
            QQARSession.c(this.this$0, true);
          }
        }
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a((String)localObject1, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        QQARSession.a(this.this$0, 0L);
        QQARSession.b(this.this$0, 0L);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processCloudMarkerRecogResult end. isNeedInternalRender = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f());
      ((StringBuilder)localObject1).append(", isNeedExternalRender = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g());
      ((StringBuilder)localObject1).append(", isNeedWaitUserOperation = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h());
      QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
    }
    QQARSession.b(this.this$0, false);
    this.this$0.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.14
 * JD-Core Version:    0.7.0.1
 */
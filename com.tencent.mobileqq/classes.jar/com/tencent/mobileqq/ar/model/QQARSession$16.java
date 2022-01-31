package com.tencent.mobileqq.ar.model;

import akzl;
import albk;
import alha;
import alkz;
import axqw;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQARSession$16
  implements Runnable
{
  public QQARSession$16(alkz paramalkz, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    int i;
    if (((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())) && (alkz.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (alkz.a(this.this$0) != null))
    {
      alha localalha = alkz.a(this.this$0);
      if (this.jdField_a_of_type_Boolean)
      {
        i = 4;
        localalha.a(1, i);
      }
    }
    else
    {
      if (alkz.a(this.this$0) != null)
      {
        QLog.i("AREngine_QQARSession", 1, "processCloudObjectClassifyResult post task for handle timeout");
        alkz.b(alkz.a(this.this$0));
        alkz.a(this.this$0, null);
      }
      if (this.jdField_a_of_type_Boolean) {
        break label161;
      }
      QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete end.");
      this.this$0.m();
      ThreadManager.getUIHandler().post(new QQARSession.16.1(this));
    }
    for (;;)
    {
      return;
      i = 5;
      break;
      label161:
      QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete end. isNeedInternalRender = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f() + ", isNeedExternalRender = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g() + ", isNeedWaitUserOperation = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h());
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())
      {
        if ((alkz.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2)) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
        }
      }
      else
      {
        if ((alkz.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (alkz.a(this.this$0) != null)) {}
        try
        {
          axqw.b(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b + "", "2", "", "");
          alkz.a(this.this$0).a(2L, new albk(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo));
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
          {
            this.this$0.m();
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("AREngine_QQARSession", 1, "0X80081DE. error = " + localException.getMessage());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f())
          {
            akzl.a().a(2);
            if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
              alkz.c(this.this$0, false);
            }
            alkz.a(this.this$0, 2L, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, -1, 0.0F, 0.0F, 0.0F);
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h()) || (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()) && (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())) {
              alkz.c(this.this$0, true);
            }
          }
          else {
            this.this$0.m();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.16
 * JD-Core Version:    0.7.0.1
 */
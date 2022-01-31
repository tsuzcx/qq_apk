package com.tencent.mobileqq.ar.model;

import amup;
import amwo;
import anby;
import anfx;
import azqs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQARSession$16
  implements Runnable
{
  public QQARSession$16(anfx paramanfx, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    int i;
    if (((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b())) && (anfx.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (anfx.a(this.this$0) != null))
    {
      anby localanby = anfx.a(this.this$0);
      if (this.jdField_a_of_type_Boolean)
      {
        i = 4;
        localanby.a(1, i);
      }
    }
    else
    {
      if (anfx.a(this.this$0) != null)
      {
        QLog.i("AREngine_QQARSession", 1, "processCloudObjectClassifyResult post task for handle timeout");
        anfx.b(anfx.a(this.this$0));
        anfx.a(this.this$0, null);
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
        if ((anfx.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2)) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
        }
      }
      else
      {
        if ((anfx.b(this.this$0)) && (this.this$0.jdField_a_of_type_Int == 2) && (anfx.a(this.this$0) != null)) {}
        try
        {
          azqs.b(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.b + "", "2", "", "");
          anfx.a(this.this$0).a(2L, new amwo(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo));
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
            amup.a().a(2);
            if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
              anfx.c(this.this$0, false);
            }
            anfx.a(this.this$0, 2L, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, -1, 0.0F, 0.0F, 0.0F);
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h()) || (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()) && (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())) {
              anfx.c(this.this$0, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.16
 * JD-Core Version:    0.7.0.1
 */
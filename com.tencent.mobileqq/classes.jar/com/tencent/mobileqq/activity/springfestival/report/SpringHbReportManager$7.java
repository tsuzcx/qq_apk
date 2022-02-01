package com.tencent.mobileqq.activity.springfestival.report;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.new_year_2021.Unisso.UniSsoServerRsp;
import tencent.im.new_year_2021.newyear_report.NYReportRsp;

class SpringHbReportManager$7
  implements BusinessObserver
{
  SpringHbReportManager$7(SpringHbReportManager paramSpringHbReportManager, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shua2021report_SpringHbReportManager", 2, "[reportlistener] onReceive:type:" + paramInt + ",isSucc:" + paramBoolean + ",reqSeq:" + this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      try
      {
        SpringHbReportManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalReportSpringHbReportManager, this.jdField_a_of_type_Long);
        Object localObject = paramBundle.getByteArray("data");
        if ((localObject == null) || (!paramBoolean)) {
          break;
        }
        paramBundle = new Unisso.UniSsoServerRsp();
        paramBundle.mergeFrom((byte[])localObject);
        long l = paramBundle.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("shua2021report_SpringHbReportManager", 1, new Object[] { "[reportlistener] unissoRes=", Long.valueOf(l) });
        }
        localObject = new newyear_report.NYReportRsp();
        ((newyear_report.NYReportRsp)localObject).mergeFrom(paramBundle.rspdata.get().toByteArray());
        paramInt = ((newyear_report.NYReportRsp)localObject).ret.get();
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("shua2021report_SpringHbReportManager", 2, "[reportlistener] onreceive success:" + localObject);
          }
          if (paramInt == 110002)
          {
            SpringHbReportManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalReportSpringHbReportManager, true);
            SpringHbReportManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalReportSpringHbReportManager, this.jdField_a_of_type_Long, paramInt);
            paramInt = ((newyear_report.NYReportRsp)localObject).batchSize.get();
            SpringHbReportManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalReportSpringHbReportManager, paramInt);
            paramInt = ((newyear_report.NYReportRsp)localObject).reportLevel.get();
            SpringHbReportManager.c(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalReportSpringHbReportManager, paramInt);
            paramInt = ((newyear_report.NYReportRsp)localObject).reportLevelTime.get();
            SpringHbReportManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalReportSpringHbReportManager, paramInt);
          }
        }
        else
        {
          QLog.e("shua2021report_SpringHbReportManager", 1, "[reportlistener] onreceive fail:" + localObject);
          continue;
        }
        SpringHbReportManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalReportSpringHbReportManager, false);
      }
      catch (Throwable paramBundle)
      {
        paramBundle.printStackTrace();
        QLog.e("shua2021report_SpringHbReportManager", 1, "[reportlistener] onreceive fail exception:" + paramBundle.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.7
 * JD-Core Version:    0.7.0.1
 */
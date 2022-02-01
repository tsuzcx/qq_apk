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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[reportlistener] onReceive:type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",isSucc:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",reqSeq:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      SpringHbReportManager.a(this.b, this.a);
      paramBundle = paramBundle.getByteArray("data");
      if ((paramBundle != null) && (paramBoolean))
      {
        localObject = new Unisso.UniSsoServerRsp();
        ((Unisso.UniSsoServerRsp)localObject).mergeFrom((byte[])paramBundle);
        long l = ((Unisso.UniSsoServerRsp)localObject).ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("shua2021report_SpringHbReportManager", 1, new Object[] { "[reportlistener] unissoRes=", Long.valueOf(l) });
        }
        paramBundle = new newyear_report.NYReportRsp();
        paramBundle.mergeFrom(((Unisso.UniSsoServerRsp)localObject).rspdata.get().toByteArray());
        paramInt = paramBundle.ret.get();
        if (paramInt == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[reportlistener] onreceive success:");
            ((StringBuilder)localObject).append(paramBundle);
            QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[reportlistener] onreceive fail:");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.e("shua2021report_SpringHbReportManager", 1, ((StringBuilder)localObject).toString());
        }
        if (paramInt == 110002) {
          SpringHbReportManager.b(this.b, true);
        } else {
          SpringHbReportManager.b(this.b, false);
        }
        SpringHbReportManager.a(this.b, this.a, paramInt);
        paramInt = paramBundle.batchSize.get();
        SpringHbReportManager.b(this.b, paramInt);
        paramInt = paramBundle.reportLevel.get();
        SpringHbReportManager.c(this.b, paramInt);
        paramInt = paramBundle.reportLevelTime.get();
        SpringHbReportManager.b(this.b, paramInt);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[reportlistener] onreceive fail exception:");
      ((StringBuilder)localObject).append(paramBundle.getMessage());
      QLog.e("shua2021report_SpringHbReportManager", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.7
 * JD-Core Version:    0.7.0.1
 */
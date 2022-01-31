package com.dataline.activities;

import amfy;
import amjd;
import at;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;
import dt;

public class LiteActivity$27$2
  implements Runnable
{
  public LiteActivity$27$2(at paramat, boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_At.a.a(1048576L);
    }
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_At.a.app.a().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_At.a.app.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!this.jdField_a_of_type_At.a.jdField_a_of_type_Dt.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView)) {
        this.jdField_a_of_type_At.a.jdField_a_of_type_Dt.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_At.a.app.a().a(this.jdField_a_of_type_Int).e();
      if (QLog.isColorLevel()) {
        QLog.d(LiteActivity.jdField_a_of_type_JavaLangString, 2, "LiteActivity.onRecvFile, msgId[" + this.jdField_a_of_type_Long + "], sPath = " + this.jdField_a_of_type_JavaLangString + "], set[" + localDataLineMsgSet + "], msgItem[" + localDataLineMsgRecord);
      }
      return;
      this.jdField_a_of_type_At.a.jdField_a_of_type_Dt.notifyDataSetChanged();
      if ((localDataLineMsgRecord != null) && (!localDataLineMsgRecord.bIsResendOrRecvFile))
      {
        LiteActivity.a(this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView);
        LiteActivity.a(this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.2
 * JD-Core Version:    0.7.0.1
 */
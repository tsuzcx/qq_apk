package com.dataline.activities;

import amfy;
import amjd;
import at;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import dt;

public class LiteActivity$27$1
  implements Runnable
{
  public LiteActivity$27$1(at paramat, int paramInt, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_At.a.app.a().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_At.a.app.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!this.jdField_a_of_type_At.a.jdField_a_of_type_Dt.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView)) {
        this.jdField_a_of_type_At.a.jdField_a_of_type_Dt.notifyDataSetChanged();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_At.a.jdField_a_of_type_Dt.notifyDataSetChanged();
    } while ((localDataLineMsgRecord == null) || (localDataLineMsgRecord.bIsResendOrRecvFile));
    LiteActivity.a(this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.1
 * JD-Core Version:    0.7.0.1
 */
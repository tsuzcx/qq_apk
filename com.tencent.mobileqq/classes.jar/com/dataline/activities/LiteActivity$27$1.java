package com.dataline.activities;

import akpg;
import aksz;
import cl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import fk;

public class LiteActivity$27$1
  implements Runnable
{
  public LiteActivity$27$1(cl paramcl, int paramInt, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Cl.a.app.a().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Cl.a.app.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!this.jdField_a_of_type_Cl.a.jdField_a_of_type_Fk.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Cl.a.jdField_a_of_type_ComTencentWidgetXListView)) {
        this.jdField_a_of_type_Cl.a.jdField_a_of_type_Fk.notifyDataSetChanged();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Cl.a.jdField_a_of_type_Fk.notifyDataSetChanged();
    } while ((localDataLineMsgRecord == null) || (localDataLineMsgRecord.bIsResendOrRecvFile));
    LiteActivity.a(this.jdField_a_of_type_Cl.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Cl.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_Cl.a.jdField_a_of_type_ComTencentWidgetXListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.1
 * JD-Core Version:    0.7.0.1
 */
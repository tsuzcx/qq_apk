package com.dataline.activities;

import aofa;
import aonc;
import ay;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import dy;

public class LiteActivity$27$4
  implements Runnable
{
  public LiteActivity$27$4(ay paramay, int paramInt, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Ay.a.app.a().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (localDataLineMsgRecord.isSendFromLocal());
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Ay.a.app.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
        if ((localDataLineMsgSet == null) || (localDataLineMsgSet.isSingle())) {
          break;
        }
      } while (this.jdField_a_of_type_Ay.a.jdField_a_of_type_Dy.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Ay.a.jdField_a_of_type_ComTencentWidgetXListView));
      this.jdField_a_of_type_Ay.a.jdField_a_of_type_Dy.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_Ay.a.jdField_a_of_type_Dy.notifyDataSetChanged();
    } while (localDataLineMsgRecord.bIsResendOrRecvFile);
    LiteActivity.a(this.jdField_a_of_type_Ay.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Ay.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_Ay.a.jdField_a_of_type_ComTencentWidgetXListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.4
 * JD-Core Version:    0.7.0.1
 */
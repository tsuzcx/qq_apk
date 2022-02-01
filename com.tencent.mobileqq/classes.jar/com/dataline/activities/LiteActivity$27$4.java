package com.dataline.activities;

import com.dataline.util.DatalineSessionAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class LiteActivity$27$4
  implements Runnable
{
  LiteActivity$27$4(LiteActivity.27 param27, int paramInt, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.app.getMessageFacade().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.isSendFromLocal()) {
      return;
    }
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.app.getDataLineMsgProxy(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle()))
    {
      if (!this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentWidgetXListView)) {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    else
    {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      if (!localDataLineMsgRecord.bIsResendOrRecvFile)
      {
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentWidgetXListView);
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentWidgetXListView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.4
 * JD-Core Version:    0.7.0.1
 */
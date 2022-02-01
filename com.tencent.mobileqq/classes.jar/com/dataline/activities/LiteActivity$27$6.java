package com.dataline.activities;

import com.dataline.util.DatalineSessionAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;

class LiteActivity$27$6
  implements Runnable
{
  LiteActivity$27$6(LiteActivity.27 param27, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.app.getMessageFacade().a(this.jdField_a_of_type_Int).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.6
 * JD-Core Version:    0.7.0.1
 */
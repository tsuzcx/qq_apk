package com.dataline.util;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager;

class DatalineSessionAdapter$4
  implements QQFileManagerUtil.TipsClickedInterface
{
  DatalineSessionAdapter$4(DatalineSessionAdapter paramDatalineSessionAdapter, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void onClick(View paramView)
  {
    ((DataLineMessageSpreadManager)this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter.4
 * JD-Core Version:    0.7.0.1
 */
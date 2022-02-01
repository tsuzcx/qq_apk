package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import java.util.ArrayList;
import java.util.Iterator;

class LiteActivity$29$1
  implements DialogInterface.OnClickListener
{
  LiteActivity$29$1(LiteActivity.29 param29) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause;
    paramInt = 1;
    if ((!bool) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause = true;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) {
        DataLineReportUtil.m(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      } else {
        DataLineReportUtil.k(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
      DataLineReportUtil.o(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
    }
    DataLineMsgSet localDataLineMsgSet = null;
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() != -2335))
    {
      localDataLineHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, true);
    }
    else
    {
      Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (localIterator.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
        localDataLineHandler.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, true);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().size() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2005))
      {
        int i = this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(((DataLineMsgRecord)this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().get(0)).sessionid) + 1;
        if ((i < this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) && (((DataLineMsgRecord)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i).values().get(0)).msgtype == -5041) && (Long.parseLong(((DataLineMsgRecord)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i).values().get(0)).getExtInfoFromExtStr("tim_aio_file_msg_uiniseq")) == ((DataLineMsgRecord)this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().get(0)).sessionid))
        {
          localDataLineMsgSet = this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i);
          break label455;
        }
      }
    }
    paramInt = 0;
    label455:
    localDataLineHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet);
    if (paramInt != 0) {
      localDataLineHandler.a(localDataLineMsgSet);
    }
    this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.b();
    this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.29.1
 * JD-Core Version:    0.7.0.1
 */
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
    Object localObject;
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause = true;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) {
        DataLineReportUtil.m(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
        DataLineReportUtil.o(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) || (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335)) {
        break label252;
      }
      localDataLineHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, true);
      localObject = null;
      paramInt = 0;
    }
    for (;;)
    {
      localDataLineHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet);
      if (paramInt != 0) {
        localDataLineHandler.a((DataLineMsgSet)localObject);
      }
      this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.b();
      this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      paramDialogInterface.dismiss();
      return;
      DataLineReportUtil.k(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      break;
      label252:
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        localDataLineHandler.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, true);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().size() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2005))
      {
        paramInt = this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(((DataLineMsgRecord)this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().get(0)).sessionid) + 1;
        if ((paramInt < this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) && (((DataLineMsgRecord)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).values().get(0)).msgtype == -5041) && (Long.parseLong(((DataLineMsgRecord)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).values().get(0)).getExtInfoFromExtStr("tim_aio_file_msg_uiniseq")) == ((DataLineMsgRecord)this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().get(0)).sessionid))
        {
          localObject = this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
          paramInt = 1;
          continue;
        }
      }
      localObject = null;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.29.1
 * JD-Core Version:    0.7.0.1
 */
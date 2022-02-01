package com.dataline.activities;

import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DLFilesViewerActivity$1$1
  implements FMDialogUtil.FMDialogInterface
{
  DLFilesViewerActivity$1$1(DLFilesViewerActivity.1 param1, DataLineMsgRecord paramDataLineMsgRecord, DataLineHandler paramDataLineHandler) {}
  
  public void a()
  {
    Object localObject1 = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b(112);
    }
    DLFilesViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity$1.a).setPaused(false);
    Iterator localIterator = DLFilesViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity$1.a).values().iterator();
    Object localObject2 = null;
    if (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      DLFileInfo localDLFileInfo = DatalineFilesAdapter.a(localDataLineMsgRecord);
      Object localObject3;
      if (localDLFileInfo.a == 1)
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = new ArrayList();
        }
        ((ArrayList)localObject3).add(localDataLineMsgRecord);
        localObject2 = localObject3;
      }
      for (;;)
      {
        break;
        if (localDLFileInfo.a != 4)
        {
          localObject3 = localObject1;
          if (localDLFileInfo.a != 2) {}
        }
        else
        {
          if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
            DataLineReportUtil.e(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity$1.a.app);
          }
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new ArrayList();
          }
          ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
          localDataLineMsgRecord.fileMsgStatus = 0L;
          int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
          this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity$1.a.app.getMessageFacade().a(i).d(localDataLineMsgRecord.msgId);
        }
        localObject1 = localObject3;
      }
    }
    if ((localObject2 != null) && (localObject2.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(localObject2, true);
    }
    if ((localObject1 != null) && (localObject1.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(localObject1);
    }
    DLFilesViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity$1.a).notifyDataSetChanged();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity.1.1
 * JD-Core Version:    0.7.0.1
 */
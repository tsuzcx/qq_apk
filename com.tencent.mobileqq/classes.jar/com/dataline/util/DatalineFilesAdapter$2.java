package com.dataline.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DatalineFilesAdapter$2
  implements View.OnClickListener
{
  DatalineFilesAdapter$2(DatalineFilesAdapter paramDatalineFilesAdapter) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((DatalineFilesAdapter.ItemHolder)localObject).a.jdField_a_of_type_Long);
    DataLineMsgRecord localDataLineMsgRecord = DatalineFilesAdapter.a(this.a).getMessageFacade().a(i).a(((DatalineFilesAdapter.ItemHolder)localObject).a.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      DLFileInfo localDLFileInfo = ((DatalineFilesAdapter.ItemHolder)localObject).a;
      switch (localDLFileInfo.jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
      case 3: 
        localObject = (DataLineHandler)DatalineFilesAdapter.a(this.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if ((localDataLineMsgRecord.strMoloKey != null) && (!localDataLineMsgRecord.isReportPause))
        {
          localDataLineMsgRecord.isReportPause = true;
          DataLineReportUtil.m(DatalineFilesAdapter.a(this.a));
        }
        ((DataLineHandler)localObject).a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
        if (localDataLineMsgRecord.isSendFromLocal()) {
          localDLFileInfo.jdField_a_of_type_Int = 1;
        }
        break;
      case 1: 
      case 2: 
      case 4: 
        if (NetworkUtil.d(DatalineFilesAdapter.a(this.a)))
        {
          if ((FileManagerUtil.a()) && (localDLFileInfo.b > 3145728L))
          {
            if (localDLFileInfo.jdField_a_of_type_Int == 1) {}
            for (;;)
            {
              FileManagerUtil.a(bool, DatalineFilesAdapter.a(this.a), new DatalineFilesAdapter.2.1(this, localDataLineMsgRecord, (DatalineFilesAdapter.ItemHolder)localObject));
              break;
              bool = false;
            }
          }
          i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
          DataLineMsgSet localDataLineMsgSet = DatalineFilesAdapter.a(this.a).getDataLineMsgProxy(i).a(localDataLineMsgRecord.sessionid);
          if (localDataLineMsgSet != null) {
            localDataLineMsgSet.setPaused(false);
          }
          if (localDLFileInfo.jdField_a_of_type_Int != 1)
          {
            if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
              DataLineReportUtil.e(DatalineFilesAdapter.a(this.a));
            }
            DatalineFilesAdapter.a(this.a, (DatalineFilesAdapter.ItemHolder)localObject, localDataLineMsgRecord);
          }
          else
          {
            DatalineFilesAdapter.b(this.a, (DatalineFilesAdapter.ItemHolder)localObject, localDataLineMsgRecord);
          }
        }
        else
        {
          FMToastUtil.a(2131694510);
        }
        break;
      case 5: 
        DatalineFilesAdapter.a(this.a, localDataLineMsgRecord);
        continue;
        localDLFileInfo.jdField_a_of_type_Int = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.DatalineFilesAdapter.2
 * JD-Core Version:    0.7.0.1
 */
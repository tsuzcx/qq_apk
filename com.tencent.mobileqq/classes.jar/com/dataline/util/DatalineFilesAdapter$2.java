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
    Object localObject = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((DatalineFilesAdapter.ItemHolder)localObject).a.a);
    DataLineMsgRecord localDataLineMsgRecord = DatalineFilesAdapter.a(this.a).getMessageFacade().d(i).a(((DatalineFilesAdapter.ItemHolder)localObject).a.a);
    if (localDataLineMsgRecord != null)
    {
      DLFileInfo localDLFileInfo = ((DatalineFilesAdapter.ItemHolder)localObject).a;
      i = localDLFileInfo.b;
      boolean bool = false;
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if (i == 3) {
            break label297;
          }
          if (i != 4)
          {
            if (i != 5) {
              break label386;
            }
            DatalineFilesAdapter.a(this.a, localDataLineMsgRecord);
            break label386;
          }
        }
        if (NetworkUtil.isNetSupport(DatalineFilesAdapter.c(this.a)))
        {
          if ((FileManagerUtil.b()) && (localDLFileInfo.e > 3145728L))
          {
            if (localDLFileInfo.b == 1) {
              bool = true;
            }
            FileManagerUtil.a(bool, DatalineFilesAdapter.c(this.a), new DatalineFilesAdapter.2.1(this, localDataLineMsgRecord, (DatalineFilesAdapter.ItemHolder)localObject));
            break label386;
          }
          i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
          DataLineMsgSet localDataLineMsgSet = DatalineFilesAdapter.a(this.a).getDataLineMsgProxy(i).c(localDataLineMsgRecord.sessionid);
          if (localDataLineMsgSet != null) {
            localDataLineMsgSet.setPaused(false);
          }
          if (localDLFileInfo.b != 1)
          {
            if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
              DataLineReportUtil.e(DatalineFilesAdapter.a(this.a));
            }
            DatalineFilesAdapter.a(this.a, (DatalineFilesAdapter.ItemHolder)localObject, localDataLineMsgRecord);
            break label386;
          }
          DatalineFilesAdapter.b(this.a, (DatalineFilesAdapter.ItemHolder)localObject, localDataLineMsgRecord);
          break label386;
        }
        FMToastUtil.a(2131892157);
        break label386;
      }
      label297:
      localObject = (DataLineHandler)DatalineFilesAdapter.a(this.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if ((localDataLineMsgRecord.strMoloKey != null) && (!localDataLineMsgRecord.isReportPause))
      {
        localDataLineMsgRecord.isReportPause = true;
        DataLineReportUtil.m(DatalineFilesAdapter.a(this.a));
      }
      ((DataLineHandler)localObject).a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
      if (localDataLineMsgRecord.isSendFromLocal()) {
        localDLFileInfo.b = 1;
      } else {
        localDLFileInfo.b = 4;
      }
    }
    label386:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineFilesAdapter.2
 * JD-Core Version:    0.7.0.1
 */
package com.dataline.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DLFilesViewerActivity$1
  implements View.OnClickListener
{
  DLFilesViewerActivity$1(DLFilesViewerActivity paramDLFilesViewerActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = DLFilesViewerActivity.a(this.a).values().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = DatalineFilesAdapter.a((DataLineMsgRecord)((Iterator)localObject1).next());
      if ((((DLFileInfo)localObject2).a == 0) || (((DLFileInfo)localObject2).a == 3))
      {
        i = 1;
        break label61;
      }
    }
    int i = 0;
    label61:
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    Object localObject3;
    if (i != 0)
    {
      if ((!DLFilesViewerActivity.a(this.a).isReportPause) && (DLFilesViewerActivity.a(this.a).getGroupType() == -2335))
      {
        DLFilesViewerActivity.a(this.a).isReportPause = true;
        DataLineReportUtil.m(this.a.app);
      }
      DLFilesViewerActivity.a(this.a).setPaused(true);
      if ((!DLFilesViewerActivity.a(this.a).isSingle()) && (DLFilesViewerActivity.a(this.a).getGroupType() != -2335))
      {
        localDataLineHandler.a(DLFilesViewerActivity.a(this.a).getGroupId(), 0L, false);
      }
      else
      {
        localObject1 = DLFilesViewerActivity.a(this.a).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DataLineMsgRecord)((Iterator)localObject1).next();
          localObject3 = DatalineFilesAdapter.a((DataLineMsgRecord)localObject2);
          if ((((DLFileInfo)localObject3).a == 0) || (((DLFileInfo)localObject3).a == 3)) {
            localDataLineHandler.a(((DataLineMsgRecord)localObject2).groupId, ((DataLineMsgRecord)localObject2).sessionid, false);
          }
        }
      }
      DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    }
    else if (NetworkUtil.isNetSupport(this.a))
    {
      if ((FileManagerUtil.a()) && (DLFilesViewerActivity.a(this.a).getFileTotalSize() > 3145728L))
      {
        localObject1 = DLFilesViewerActivity.a(this.a).getFirstItem();
        FileManagerUtil.a(((DataLineMsgRecord)localObject1).isSendFromLocal(), this.a, new DLFilesViewerActivity.1.1(this, (DataLineMsgRecord)localObject1, localDataLineHandler));
      }
      else
      {
        localObject1 = DLFilesViewerActivity.a(this.a).getFirstItem();
        if ((localObject1 != null) && (!((DataLineMsgRecord)localObject1).isSendFromLocal()) && (((DataLineMsgRecord)localObject1).strMoloKey != null)) {
          localDataLineHandler.b(112);
        }
        DLFilesViewerActivity.a(this.a).setPaused(false);
        Iterator localIterator = DLFilesViewerActivity.a(this.a).values().iterator();
        localObject2 = null;
        localObject1 = null;
        while (localIterator.hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
          localObject3 = DatalineFilesAdapter.a(localDataLineMsgRecord);
          if (((DLFileInfo)localObject3).a == 1)
          {
            localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = new ArrayList();
            }
            ((ArrayList)localObject3).add(localDataLineMsgRecord);
            localObject2 = localObject3;
          }
          else if ((((DLFileInfo)localObject3).a == 4) || (((DLFileInfo)localObject3).a == 2))
          {
            if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
              DataLineReportUtil.e(this.a.app);
            }
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new ArrayList();
            }
            ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
            localDataLineMsgRecord.fileMsgStatus = 0L;
            i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
            this.a.app.getMessageFacade().a(i).d(localDataLineMsgRecord.msgId);
            localObject1 = localObject3;
          }
        }
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
          localDataLineHandler.a((ArrayList)localObject2, true);
        }
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
          localDataLineHandler.a((List)localObject1);
        }
        DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
      }
    }
    else
    {
      FMToastUtil.a(2131694475);
    }
    DLFilesViewerActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity.1
 * JD-Core Version:    0.7.0.1
 */
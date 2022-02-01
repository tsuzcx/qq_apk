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
    Object localObject1 = this.a;
    if ((localObject1 != null) && (!((DataLineMsgRecord)localObject1).isSendFromLocal()) && (this.a.strMoloKey != null)) {
      this.b.e(112);
    }
    DLFilesViewerActivity.a(this.c.a).setPaused(false);
    Iterator localIterator = DLFilesViewerActivity.a(this.c.a).values().iterator();
    Object localObject2 = null;
    localObject1 = null;
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      Object localObject3 = DatalineFilesAdapter.a(localDataLineMsgRecord);
      if (((DLFileInfo)localObject3).b == 1)
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = new ArrayList();
        }
        ((ArrayList)localObject3).add(localDataLineMsgRecord);
        localObject2 = localObject3;
      }
      else if ((((DLFileInfo)localObject3).b == 4) || (((DLFileInfo)localObject3).b == 2))
      {
        if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
          DataLineReportUtil.e(this.c.a.app);
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new ArrayList();
        }
        ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
        localDataLineMsgRecord.fileMsgStatus = 0L;
        int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
        this.c.a.app.getMessageFacade().d(i).f(localDataLineMsgRecord.msgId);
        localObject1 = localObject3;
      }
    }
    if ((localObject2 != null) && (localObject2.size() > 0)) {
      this.b.a(localObject2, true);
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      this.b.b((List)localObject1);
    }
    DLFilesViewerActivity.b(this.c.a).notifyDataSetChanged();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity.1.1
 * JD-Core Version:    0.7.0.1
 */
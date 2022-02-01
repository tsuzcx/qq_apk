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

class LiteMutiPicViewerActivity$1
  implements FMDialogUtil.FMDialogInterface
{
  LiteMutiPicViewerActivity$1(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity, DataLineHandler paramDataLineHandler) {}
  
  public void a()
  {
    LiteMutiPicViewerActivity.a(this.b).setPaused(false);
    if ((LiteMutiPicViewerActivity.a(this.b).getGroupType() == -2000) && (!LiteMutiPicViewerActivity.a(this.b).isSingle())) {
      DataLineReportUtil.p(this.b.app);
    }
    Iterator localIterator = LiteMutiPicViewerActivity.a(this.b).values().iterator();
    Object localObject2 = null;
    Object localObject1 = null;
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
          if (DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
            DataLineReportUtil.d(this.b.app);
          } else {
            DataLineReportUtil.e(this.b.app);
          }
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new ArrayList();
        }
        ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
        int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.b.app.getMessageFacade().d(i).f(localDataLineMsgRecord.msgId);
        localObject1 = localObject3;
      }
    }
    if ((localObject2 != null) && (localObject2.size() > 0)) {
      this.a.a(localObject2, true);
    }
    if ((localObject1 != null) && (localObject1.size() > 0)) {
      this.a.b(localObject1);
    }
    LiteMutiPicViewerActivity.b(this.b);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity.1
 * JD-Core Version:    0.7.0.1
 */
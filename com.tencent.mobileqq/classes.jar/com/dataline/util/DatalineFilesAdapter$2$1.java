package com.dataline.util;

import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class DatalineFilesAdapter$2$1
  implements FMDialogUtil.FMDialogInterface
{
  DatalineFilesAdapter$2$1(DatalineFilesAdapter.2 param2, DataLineMsgRecord paramDataLineMsgRecord, DatalineFilesAdapter.ItemHolder paramItemHolder) {}
  
  public void a()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.a.sessionid);
    DataLineMsgSet localDataLineMsgSet = DatalineFilesAdapter.a(this.c.a).getDataLineMsgProxy(i).c(this.a.sessionid);
    if (localDataLineMsgSet != null) {
      localDataLineMsgSet.setPaused(false);
    }
    if (this.b.a.b != 1)
    {
      if ((this.a.fileMsgStatus == 1L) && (this.a.strMoloKey != null)) {
        DataLineReportUtil.e(DatalineFilesAdapter.a(this.c.a));
      }
      DatalineFilesAdapter.a(this.c.a, this.b, this.a);
      return;
    }
    DatalineFilesAdapter.b(this.c.a, this.b, this.a);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineFilesAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */
package com.dataline.util;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterActivity;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class PrinterSessionAdapter$1
  implements View.OnClickListener
{
  PrinterSessionAdapter$1(PrinterSessionAdapter paramPrinterSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (PrinterItemMsgRecord)((ItemHolder)paramView.getTag()).a();
    if (localObject != null)
    {
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a((PrinterItemMsgRecord)localObject);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10009);
      localForwardFileInfo.d(6);
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(localFileManagerEntity.fileName);
      localForwardFileInfo.c(((PrinterItemMsgRecord)localObject).uSessionID);
      localForwardFileInfo.d(localFileManagerEntity.fileSize);
      localForwardFileInfo.a(localFileManagerEntity.getFilePath());
      localObject = new Intent(this.a.a.getApplicationContext(), FileBrowserActivity.class);
      if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
        ((Intent)localObject).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
      }
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      this.a.a.startActivityForResult((Intent)localObject, 102);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.PrinterSessionAdapter.1
 * JD-Core Version:    0.7.0.1
 */
package com.dataline.util;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class DatalineFilesAdapter$1
  implements View.OnClickListener
{
  DatalineFilesAdapter$1(DatalineFilesAdapter paramDatalineFilesAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    if (((DatalineFilesAdapter.ItemHolder)localObject1).a != null)
    {
      int i = DataLineMsgRecord.getDevTypeBySeId(((DatalineFilesAdapter.ItemHolder)localObject1).a.a);
      Object localObject2 = DatalineFilesAdapter.a(this.a).getMessageFacade().d(i).a(((DatalineFilesAdapter.ItemHolder)localObject1).a.a);
      if (localObject2 != null)
      {
        localObject1 = FileManagerUtil.a((DataLineMsgRecord)localObject2);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(10009);
        localForwardFileInfo.d(6);
        localForwardFileInfo.b(((FileManagerEntity)localObject1).nSessionId);
        localForwardFileInfo.d(((DataLineMsgRecord)localObject2).filename);
        localForwardFileInfo.c(((DataLineMsgRecord)localObject2).sessionid);
        localForwardFileInfo.d(((DataLineMsgRecord)localObject2).filesize);
        localForwardFileInfo.a(((DataLineMsgRecord)localObject2).path);
        localObject2 = new Intent(DatalineFilesAdapter.b(this.a).getApplicationContext(), FileBrowserActivity.class);
        if ((((FileManagerEntity)localObject1).nFileType == 0) || (((FileManagerEntity)localObject1).nFileType == 1))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
          ((Intent)localObject2).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
        }
        ((Intent)localObject2).putExtra("fileinfo", localForwardFileInfo);
        DatalineFilesAdapter.c(this.a).startActivityForResult((Intent)localObject2, 102);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineFilesAdapter.1
 * JD-Core Version:    0.7.0.1
 */
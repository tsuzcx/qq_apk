package com.dataline.util;

import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.DatalineFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

class DatalineSessionAdapter$2
  implements View.OnClickListener
{
  DatalineSessionAdapter$2(DatalineSessionAdapter paramDatalineSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b())
    {
      this.a.a();
      Object localObject1 = (ItemHolder)paramView.getTag();
      Object localObject3 = ((ItemHolder)localObject1).a();
      Object localObject2 = ((DataLineMsgSet)localObject3).getFirstItem();
      if (((DataLineMsgSet)localObject3).isSingle())
      {
        if (-1000 != ((DataLineMsgRecord)localObject2).msgtype)
        {
          FileManagerEntity localFileManagerEntity = FileManagerUtil.a((DataLineMsgRecord)localObject2);
          if ((((DataLineMsgRecord)localObject2).nOpType != 31) && (!FileManagerUtil.j(localFileManagerEntity)))
          {
            if (((DataLineMsgRecord)localObject2).nOpType == 29)
            {
              DatalineSessionAdapter.b(this.a, (DataLineMsgRecord)localObject2);
            }
            else if ((localFileManagerEntity.nFileType != 0) && (localFileManagerEntity.nFileType != 2))
            {
              localObject1 = new FileModelAdapter(this.a.d, localFileManagerEntity, 3);
              localObject2 = new FileBrowserParam().a(11);
              ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.a.b, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
            }
            else
            {
              localObject3 = new DatalineFileBrowserParams(this.a.d, this.a.b, localFileManagerEntity);
              ArrayList localArrayList = new ArrayList();
              if (localFileManagerEntity.nFileType == 0)
              {
                Iterator localIterator = DatalineSessionAdapter.a(this.a).iterator();
                label396:
                while (localIterator.hasNext())
                {
                  Object localObject4 = (DataLineMsgSet)localIterator.next();
                  if (((DataLineMsgSet)localObject4).isSingle())
                  {
                    localObject4 = ((DataLineMsgSet)localObject4).values().iterator();
                    for (;;)
                    {
                      if (!((Iterator)localObject4).hasNext()) {
                        break label396;
                      }
                      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject4).next();
                      int j = FileManagerUtil.c(localDataLineMsgRecord.filename);
                      int i = j;
                      if (j == -1)
                      {
                        i = j;
                        if (localDataLineMsgRecord.msgtype == -2000) {
                          i = 0;
                        }
                      }
                      if (i != localFileManagerEntity.nFileType) {
                        break;
                      }
                      if (localDataLineMsgRecord != localObject2) {
                        localArrayList.add(String.valueOf(FileManagerUtil.a(localDataLineMsgRecord).nSessionId));
                      } else {
                        localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
                      }
                    }
                  }
                }
                if (localArrayList.size() == 0) {
                  localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
                }
                ((DatalineFileBrowserParams)localObject3).a(localArrayList);
              }
              localObject1 = QFileUtils.a(((ItemHolder)localObject1).c().a, localFileManagerEntity.fileName);
              localObject2 = new FileBrowserCreator(this.a.b, (IFileBrowserParams)localObject3);
              ((FileBrowserCreator)localObject2).a(11);
              ((FileBrowserCreator)localObject2).a((Rect)localObject1);
              ((FileBrowserCreator)localObject2).a();
            }
          }
          else {
            DatalineSessionAdapter.a(this.a, (DataLineMsgRecord)localObject2);
          }
        }
      }
      else if (((DataLineMsgSet)localObject3).getGroupType() == -2000)
      {
        localObject1 = new Intent(this.a.c, LiteMutiPicViewerActivity.class);
        ((Intent)localObject1).putExtra("dataline_group_id", ((DataLineMsgSet)localObject3).getGroupId());
        this.a.c.startActivity((Intent)localObject1);
      }
      else
      {
        localObject1 = new Intent(this.a.c, DLFilesViewerActivity.class);
        ((Intent)localObject1).putExtra("dl_files_groupid", ((DataLineMsgSet)localObject3).getGroupId());
        this.a.c.startActivityForResult((Intent)localObject1, 102);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter.2
 * JD-Core Version:    0.7.0.1
 */
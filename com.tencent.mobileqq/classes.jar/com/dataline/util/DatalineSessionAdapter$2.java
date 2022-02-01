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
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.DatalineFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.QRLocalManager;
import java.util.ArrayList;
import java.util.Iterator;

class DatalineSessionAdapter$2
  implements View.OnClickListener
{
  DatalineSessionAdapter$2(DatalineSessionAdapter paramDatalineSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a();
      Object localObject1 = (ItemHolder)paramView.getTag();
      Object localObject3 = ((ItemHolder)localObject1).a();
      Object localObject2 = ((DataLineMsgSet)localObject3).getFirstItem();
      if (((DataLineMsgSet)localObject3).isSingle())
      {
        if (-1000 != ((DataLineMsgRecord)localObject2).msgtype)
        {
          FileManagerEntity localFileManagerEntity = FileManagerUtil.a((DataLineMsgRecord)localObject2);
          if (QRLocalManager.a().a(localFileManagerEntity))
          {
            QRLocalManager.a().a(this.a.jdField_a_of_type_AndroidContentContext, localFileManagerEntity.getFilePath(), true);
          }
          else if ((((DataLineMsgRecord)localObject2).nOpType == 31) || (FileManagerUtil.e(localFileManagerEntity)))
          {
            DatalineSessionAdapter.a(this.a, (DataLineMsgRecord)localObject2);
          }
          else if (((DataLineMsgRecord)localObject2).nOpType == 29)
          {
            DatalineSessionAdapter.b(this.a, (DataLineMsgRecord)localObject2);
          }
          else
          {
            localObject3 = new DatalineFileBrowserParams(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localFileManagerEntity);
            ArrayList localArrayList = new ArrayList();
            if (localFileManagerEntity.nFileType == 0)
            {
              Iterator localIterator = DatalineSessionAdapter.a(this.a).iterator();
              label357:
              while (localIterator.hasNext())
              {
                Object localObject4 = (DataLineMsgSet)localIterator.next();
                if (((DataLineMsgSet)localObject4).isSingle())
                {
                  localObject4 = ((DataLineMsgSet)localObject4).values().iterator();
                  for (;;)
                  {
                    if (!((Iterator)localObject4).hasNext()) {
                      break label357;
                    }
                    DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject4).next();
                    int j = FileManagerUtil.a(localDataLineMsgRecord.filename);
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
            localObject1 = QFileUtils.a(((ItemHolder)localObject1).a().a, localFileManagerEntity.fileName);
            localObject2 = new FileBrowserCreator(this.a.jdField_a_of_type_AndroidContentContext, (IFileBrowserParams)localObject3);
            ((FileBrowserCreator)localObject2).a(11);
            ((FileBrowserCreator)localObject2).a((Rect)localObject1);
            ((FileBrowserCreator)localObject2).a();
          }
        }
      }
      else if (((DataLineMsgSet)localObject3).getGroupType() == -2000)
      {
        localObject1 = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, LiteMutiPicViewerActivity.class);
        ((Intent)localObject1).putExtra("dataline_group_id", ((DataLineMsgSet)localObject3).getGroupId());
        this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivity((Intent)localObject1);
      }
      else
      {
        localObject1 = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, DLFilesViewerActivity.class);
        ((Intent)localObject1).putExtra("dl_files_groupid", ((DataLineMsgSet)localObject3).getGroupId());
        this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult((Intent)localObject1, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.av.wtogether.adapter.QVideoC2CFileExpandableListAdapter;
import com.tencent.av.wtogether.callback.C2CFileClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QRecentC2CAVFileListContentView
  extends QBaseFileListContentView
{
  private C2CFileClickListener jdField_a_of_type_ComTencentAvWtogetherCallbackC2CFileClickListener;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new QRecentC2CAVFileListContentView.2(this);
  
  public QRecentC2CAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QRecentC2CAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QRecentC2CAVFileListContentView(Context paramContext, C2CFileClickListener paramC2CFileClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackC2CFileClickListener = paramC2CFileClickListener;
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QVideoC2CFileExpandableListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_ComTencentAvWtogetherCallbackC2CFileClickListener);
  }
  
  public void a()
  {
    super.a();
    ReportController.b(null, "dc00898", "", "", "0X800B624", "0X800B624", 0, 0, "", "", "", "");
  }
  
  protected void a(List<OfflineFileInfo> paramList)
  {
    Collections.sort(paramList, new QRecentC2CAVFileListContentView.1(this));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (OfflineFileInfo)paramList.next();
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
        String str = ((OfflineFileInfo)localObject1).jdField_a_of_type_JavaLangString.replace("/offline", "");
        if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {}
        for (;;)
        {
          i = 1;
          break label197;
          if ((Math.abs(localFileManagerEntity.srvTime - ((OfflineFileInfo)localObject1).jdField_d_of_type_Long) >= 60000L) || (localFileManagerEntity.fileSize != ((OfflineFileInfo)localObject1).b) || (localFileManagerEntity.peerUin == null) || (!localFileManagerEntity.peerUin.equalsIgnoreCase(String.valueOf(((OfflineFileInfo)localObject1).jdField_a_of_type_Long))) || (localFileManagerEntity.fileName == null) || (!localFileManagerEntity.fileName.equalsIgnoreCase(((OfflineFileInfo)localObject1).c))) {
            break;
          }
        }
      }
      int i = 0;
      label197:
      if (i == 0)
      {
        localObject2 = FileManagerUtil.a((OfflineFileInfo)localObject1, 0);
        ((FileManagerEntity)localObject2).strFileMd5 = ((OfflineFileInfo)localObject1).jdField_d_of_type_JavaLangString;
        ((FileManagerEntity)localObject2).cloudType = 3;
        if (((FileManagerEntity)localObject2).nFileType == 0)
        {
          ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).getFileManagerEngine().a((FileManagerEntity)localObject2, 5);
        }
        else if (((FileManagerEntity)localObject2).nFileType == 2)
        {
          localObject1 = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).getFileManagerEngine().a((FileManagerEntity)localObject2);
          if (localObject1 != null) {
            ((FileManagerEntity)localObject2).strThumbPath = ((String)localObject1);
          }
        }
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mergeOfflineList,addEntity:fileName[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).fileName);
          ((StringBuilder)localObject1).append("],fileSize[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).fileSize);
          ((StringBuilder)localObject1).append("],bSend[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).bSend);
          ((StringBuilder)localObject1).append("],Uuid[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).Uuid);
          ((StringBuilder)localObject1).append("],ThumbPath[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).strThumbPath);
          ((StringBuilder)localObject1).append("]");
          QLog.i("QRecentC2CAVFileListContentView", 2, ((StringBuilder)localObject1).toString());
        }
        ((FileManagerEntity)localObject2).bOnceSuccess = true;
        a((FileManagerEntity)localObject2);
      }
    }
  }
  
  protected void e()
  {
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).getFileTransferHandler().b(0, 30, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, 3);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).getFileTransferHandler().a(0, 30, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView
 * JD-Core Version:    0.7.0.1
 */
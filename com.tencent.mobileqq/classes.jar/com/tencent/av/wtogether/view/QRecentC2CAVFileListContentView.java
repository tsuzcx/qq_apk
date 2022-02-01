package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import atab;
import athn;
import atht;
import atib;
import auea;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mxw;
import mya;
import nat;
import nau;

public class QRecentC2CAVFileListContentView
  extends QBaseFileListContentView
{
  private atib jdField_a_of_type_Atib = new nau(this);
  private mya jdField_a_of_type_Mya;
  
  public QRecentC2CAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QRecentC2CAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QRecentC2CAVFileListContentView(Context paramContext, mya parammya)
  {
    super(paramContext);
    this.jdField_a_of_type_Mya = parammya;
  }
  
  protected atab a()
  {
    return new mxw(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_Mya);
  }
  
  public void a()
  {
    super.a();
    bdla.b(null, "dc00898", "", "", "0X800B624", "0X800B624", 0, 0, "", "", "", "");
  }
  
  public void a(List<OfflineFileInfo> paramList)
  {
    Collections.sort(paramList, new nat(this));
    paramList = paramList.iterator();
    label385:
    label388:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      label49:
      FileManagerEntity localFileManagerEntity;
      int i;
      if (paramList.hasNext())
      {
        localObject1 = (OfflineFileInfo)paramList.next();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label385;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
        String str = ((OfflineFileInfo)localObject1).jdField_a_of_type_JavaLangString.replace("/offline", "");
        if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {
          i = 1;
        }
      }
      for (;;)
      {
        label107:
        if (i != 0) {
          break label388;
        }
        localObject2 = auea.a((OfflineFileInfo)localObject1, 0);
        ((FileManagerEntity)localObject2).strFileMd5 = ((OfflineFileInfo)localObject1).jdField_d_of_type_JavaLangString;
        ((FileManagerEntity)localObject2).cloudType = 3;
        if (((FileManagerEntity)localObject2).nFileType == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((FileManagerEntity)localObject2, 5);
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("QRecentC2CAVFileListContentView", 2, "mergeOfflineList,addEntity:fileName[" + ((FileManagerEntity)localObject2).fileName + "],fileSize[" + ((FileManagerEntity)localObject2).fileSize + "],bSend[" + ((FileManagerEntity)localObject2).bSend + "],Uuid[" + ((FileManagerEntity)localObject2).Uuid + "],ThumbPath[" + ((FileManagerEntity)localObject2).strThumbPath + "]");
          }
          ((FileManagerEntity)localObject2).bOnceSuccess = true;
          a((FileManagerEntity)localObject2);
          break;
          if ((Math.abs(localFileManagerEntity.srvTime - ((OfflineFileInfo)localObject1).jdField_d_of_type_Long) >= 60000L) || (localFileManagerEntity.fileSize != ((OfflineFileInfo)localObject1).b) || (localFileManagerEntity.peerUin == null) || (!localFileManagerEntity.peerUin.equalsIgnoreCase(String.valueOf(((OfflineFileInfo)localObject1).jdField_a_of_type_Long))) || (localFileManagerEntity.fileName == null) || (!localFileManagerEntity.fileName.equalsIgnoreCase(((OfflineFileInfo)localObject1).c))) {
            break label49;
          }
          i = 1;
          break label107;
          if (((FileManagerEntity)localObject2).nFileType == 2)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((FileManagerEntity)localObject2);
            if (localObject1 != null) {
              ((FileManagerEntity)localObject2).strThumbPath = ((String)localObject1);
            }
          }
        }
        return;
        i = 0;
      }
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(0, 30, this.jdField_a_of_type_Atib, 3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(0, 30, this.jdField_a_of_type_Atib, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView
 * JD-Core Version:    0.7.0.1
 */
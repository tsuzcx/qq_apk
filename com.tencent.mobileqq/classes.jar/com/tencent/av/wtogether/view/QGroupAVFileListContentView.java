package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.av.wtogether.adapter.QVideoGroupFileExpandableListAdapter;
import com.tencent.av.wtogether.adapter.QVideoGroupFileExpandableListAdapter.UIEvent;
import com.tencent.av.wtogether.handler.WatchTogetherHandler;
import com.tencent.av.wtogether.observer.WatchTogetherObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QGroupAVFileListContentView
  extends QBaseFileListContentView
{
  private long jdField_a_of_type_Long;
  private QVideoGroupFileExpandableListAdapter.UIEvent jdField_a_of_type_ComTencentAvWtogetherAdapterQVideoGroupFileExpandableListAdapter$UIEvent;
  private WatchTogetherObserver jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver = new QGroupAVFileListContentView.2(this);
  
  public QGroupAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QGroupAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QGroupAVFileListContentView(Context paramContext, QVideoGroupFileExpandableListAdapter.UIEvent paramUIEvent, long paramLong)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterQVideoGroupFileExpandableListAdapter$UIEvent = paramUIEvent;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QVideoGroupFileExpandableListAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_ComTencentAvWtogetherAdapterQVideoGroupFileExpandableListAdapter$UIEvent);
  }
  
  public String a(TroopFileSearchItemData paramTroopFileSearchItemData)
  {
    String str = "";
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileSearchItemData.jdField_a_of_type_Long);
    TroopFileInfo localTroopFileInfo = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    TroopFileStatusInfo localTroopFileStatusInfo = ((TroopFileTransferManager)localObject).a(localTroopFileInfo.jdField_b_of_type_JavaLangString);
    if (localTroopFileStatusInfo != null) {
      str = localTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = str;
      if (!FileUtils.b(str)) {
        localObject = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.j;
      }
      return localObject;
      ((TroopFileTransferManager)localObject).a(localTroopFileInfo.jdField_b_of_type_JavaLangString, localTroopFileInfo.c, localTroopFileInfo.jdField_a_of_type_Int, 128);
    }
  }
  
  protected void a(List<TroopFileSearchItemData> paramList)
  {
    Collections.sort(paramList, new QGroupAVFileListContentView.1(this));
    paramList = paramList.iterator();
    label49:
    label472:
    label475:
    for (;;)
    {
      TroopFileSearchItemData localTroopFileSearchItemData;
      Object localObject;
      FileManagerEntity localFileManagerEntity;
      int i;
      if (paramList.hasNext())
      {
        localTroopFileSearchItemData = (TroopFileSearchItemData)paramList.next();
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label472;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        String str = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_JavaLangString;
        if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label475;
        }
        localObject = new FileManagerEntity();
        ((FileManagerEntity)localObject).nSessionId = FileManagerUtil.a().longValue();
        ((FileManagerEntity)localObject).Uuid = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_JavaLangString;
        ((FileManagerEntity)localObject).setCloudType(4);
        ((FileManagerEntity)localObject).fileName = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c;
        ((FileManagerEntity)localObject).fileSize = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Long;
        ((FileManagerEntity)localObject).nFileType = 2;
        ((FileManagerEntity)localObject).strTroopFileSha1 = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.d;
        ((FileManagerEntity)localObject).busId = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Int;
        ((FileManagerEntity)localObject).TroopUin = localTroopFileSearchItemData.jdField_a_of_type_Long;
        ((FileManagerEntity)localObject).strFileMd5 = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e;
        ((FileManagerEntity)localObject).peerType = 1;
        ((FileManagerEntity)localObject).peerUin = String.valueOf(localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_Long);
        ((FileManagerEntity)localObject).srvTime = (localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_Int * 1000L);
        ((FileManagerEntity)localObject).peerNick = localTroopFileSearchItemData.jdField_b_of_type_JavaLangString;
        ((FileManagerEntity)localObject).strThumbPath = a(localTroopFileSearchItemData);
        if (QLog.isDevelopLevel()) {
          QLog.i("QGroupAVFileListContentView", 2, "mergeTroopFileList,addEntity:fileName[" + ((FileManagerEntity)localObject).fileName + "],fileSize[" + ((FileManagerEntity)localObject).fileSize + "],Uuid[" + ((FileManagerEntity)localObject).Uuid + "],ThumbPath[" + ((FileManagerEntity)localObject).strThumbPath + "]");
        }
        ((FileManagerEntity)localObject).bOnceSuccess = true;
        a((FileManagerEntity)localObject);
        break;
        if ((Math.abs(localFileManagerEntity.srvTime - localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_Int) >= 60000L) || (localFileManagerEntity.fileSize != localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Long) || (localFileManagerEntity.peerUin == null) || (!localFileManagerEntity.peerUin.equalsIgnoreCase(String.valueOf(localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_Long))) || (localFileManagerEntity.fileName == null) || (!localFileManagerEntity.fileName.equalsIgnoreCase(localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c))) {
          break label49;
        }
        i = 1;
        continue;
        return;
        i = 0;
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver);
    super.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver);
    super.d();
  }
  
  protected void e()
  {
    ((WatchTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QAV_WT_HANDLER)).a(this.jdField_a_of_type_Long, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupAVFileListContentView
 * JD-Core Version:    0.7.0.1
 */
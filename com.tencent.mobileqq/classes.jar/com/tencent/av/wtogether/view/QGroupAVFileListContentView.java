package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.av.wtogether.adapter.QVideoGroupFileExpandableListAdapter;
import com.tencent.av.wtogether.callback.GroupFileClickListener;
import com.tencent.av.wtogether.handler.WatchTogetherHandler;
import com.tencent.av.wtogether.observer.WatchTogetherObserver;
import com.tencent.common.app.business.BaseQQAppInterface;
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
  private GroupFileClickListener jdField_a_of_type_ComTencentAvWtogetherCallbackGroupFileClickListener;
  private WatchTogetherObserver jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver = new QGroupAVFileListContentView.2(this);
  
  public QGroupAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QGroupAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QGroupAVFileListContentView(Context paramContext, GroupFileClickListener paramGroupFileClickListener, long paramLong)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackGroupFileClickListener = paramGroupFileClickListener;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QVideoGroupFileExpandableListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_ComTencentAvWtogetherCallbackGroupFileClickListener);
  }
  
  public String a(TroopFileSearchItemData paramTroopFileSearchItemData)
  {
    Object localObject1 = TroopFileTransferManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramTroopFileSearchItemData.jdField_a_of_type_Long);
    Object localObject2 = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    TroopFileStatusInfo localTroopFileStatusInfo = ((TroopFileTransferManager)localObject1).a(((TroopFileInfo)localObject2).jdField_b_of_type_JavaLangString);
    if (localTroopFileStatusInfo != null)
    {
      localObject1 = localTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
    }
    else
    {
      ((TroopFileTransferManager)localObject1).a(((TroopFileInfo)localObject2).jdField_b_of_type_JavaLangString, ((TroopFileInfo)localObject2).c, ((TroopFileInfo)localObject2).jdField_a_of_type_Int, 128);
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject1)) {
      localObject2 = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.j;
    }
    return localObject2;
  }
  
  protected void a(List<TroopFileSearchItemData> paramList)
  {
    Collections.sort(paramList, new QGroupAVFileListContentView.1(this));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (TroopFileSearchItemData)paramList.next();
      int j = 0;
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = j;
      if (((Iterator)localObject2).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
        String str = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_JavaLangString;
        if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {}
        for (;;)
        {
          i = 1;
          break label214;
          if ((Math.abs(localFileManagerEntity.srvTime - ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_Int) >= 60000L) || (localFileManagerEntity.fileSize != ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Long) || (localFileManagerEntity.peerUin == null) || (!localFileManagerEntity.peerUin.equalsIgnoreCase(String.valueOf(((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_Long))) || (localFileManagerEntity.fileName == null) || (!localFileManagerEntity.fileName.equalsIgnoreCase(((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c))) {
            break;
          }
        }
      }
      label214:
      if (i == 0)
      {
        localObject2 = new FileManagerEntity();
        ((FileManagerEntity)localObject2).nSessionId = FileManagerUtil.a().longValue();
        ((FileManagerEntity)localObject2).Uuid = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_JavaLangString;
        ((FileManagerEntity)localObject2).setCloudType(4);
        ((FileManagerEntity)localObject2).fileName = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c;
        ((FileManagerEntity)localObject2).fileSize = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Long;
        ((FileManagerEntity)localObject2).nFileType = 2;
        ((FileManagerEntity)localObject2).strTroopFileSha1 = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.d;
        ((FileManagerEntity)localObject2).busId = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Int;
        ((FileManagerEntity)localObject2).TroopUin = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_Long;
        ((FileManagerEntity)localObject2).strFileMd5 = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e;
        ((FileManagerEntity)localObject2).peerType = 1;
        ((FileManagerEntity)localObject2).peerUin = String.valueOf(((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_Long);
        ((FileManagerEntity)localObject2).srvTime = (((TroopFileSearchItemData)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_Int * 1000L);
        ((FileManagerEntity)localObject2).peerNick = ((TroopFileSearchItemData)localObject1).jdField_b_of_type_JavaLangString;
        ((FileManagerEntity)localObject2).strThumbPath = a((TroopFileSearchItemData)localObject1);
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mergeTroopFileList,addEntity:fileName[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).fileName);
          ((StringBuilder)localObject1).append("],fileSize[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).fileSize);
          ((StringBuilder)localObject1).append("],Uuid[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).Uuid);
          ((StringBuilder)localObject1).append("],ThumbPath[");
          ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).strThumbPath);
          ((StringBuilder)localObject1).append("]");
          QLog.i("QGroupAVFileListContentView", 2, ((StringBuilder)localObject1).toString());
        }
        ((FileManagerEntity)localObject2).bOnceSuccess = true;
        a((FileManagerEntity)localObject2);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver);
    super.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver);
    super.d();
  }
  
  protected void e()
  {
    ((WatchTogetherHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QAV_WT_HANDLER)).a(this.jdField_a_of_type_Long, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupAVFileListContentView
 * JD-Core Version:    0.7.0.1
 */
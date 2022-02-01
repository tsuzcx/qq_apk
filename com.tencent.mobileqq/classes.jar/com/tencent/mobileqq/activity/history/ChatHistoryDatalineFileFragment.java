package com.tencent.mobileqq.activity.history;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter;
import com.tencent.mobileqq.activity.history.adapter.ChatHistoryDatalineFileAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.open.DatalineFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.multioperate.DatalineFileMultiOperate;
import com.tencent.mobileqq.filemanager.multioperate.IQFileMultiOperate;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ChatHistoryDatalineFileFragment
  extends ChatHistoryC2CFileFragment
{
  private DataLineObserver a;
  
  private DataLineMsgRecord a(FileManagerEntity paramFileManagerEntity)
  {
    long l = paramFileManagerEntity.datalineEntitySessionId;
    int i = DataLineMsgRecord.getDevTypeBySeId(l);
    paramFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(l);
    if (paramFileManagerEntity == null) {
      QLog.i("ChatHistoryDatalineFileFragment", 1, "getSourceDatalineFile：do not find sessionId[" + l + "]");
    }
    return paramFileManagerEntity;
  }
  
  private List<FileManagerEntity> a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(0);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((DatalineMessageManager)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(FileManagerUtil.a((DataLineMsgRecord)((Iterator)localObject2).next()));
    }
    return localObject1;
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return paramFileManagerEntity.peerType == 6000;
  }
  
  protected ChatHistoryC2CFileAdapter a()
  {
    return new ChatHistoryDatalineFileAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap);
  }
  
  protected IQFileMultiOperate a()
  {
    return new DatalineFileMultiOperate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  protected LinkedHashMap<String, List<Object>> a()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(a()));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    if (TextUtils.equals(a(), QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      localArrayList2.addAll(a());
    }
    Collections.sort(localArrayList2, new ChatHistoryDatalineFileFragment.2(this));
    return a(localArrayList2);
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity)
  {
    if (b(paramFileManagerEntity))
    {
      paramFileManagerEntity = a(paramFileManagerEntity);
      if (paramFileManagerEntity == null)
      {
        QLog.e("ChatHistoryDatalineFileFragment", 1, "onActionResume. can not find a DataLineMsgRecord");
        return;
      }
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramFileManagerEntity.sessionid));
      localDataLineHandler.a(localArrayList);
      return;
    }
    super.a(paramFileManagerEntity);
  }
  
  protected LinkedHashMap<String, List<Object>> b()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().b(a()));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    if (TextUtils.equals(a(), QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      localArrayList2.addAll(a());
    }
    Collections.sort(localArrayList2, new ChatHistoryDatalineFileFragment.3(this));
    return a(localArrayList2);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new ChatHistoryDatalineFileFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  protected void b(FileManagerEntity paramFileManagerEntity)
  {
    if (b(paramFileManagerEntity))
    {
      paramFileManagerEntity = a(paramFileManagerEntity);
      if (paramFileManagerEntity == null)
      {
        QLog.e("ChatHistoryDatalineFileFragment", 1, "onActionPause. can not find a DataLineMsgRecord");
        return;
      }
      ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramFileManagerEntity.groupId, paramFileManagerEntity.sessionid, false);
      return;
    }
    super.b(paramFileManagerEntity);
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    if (b(paramFileManagerEntity))
    {
      paramFileManagerEntity = a(paramFileManagerEntity);
      if (paramFileManagerEntity == null)
      {
        QLog.e("ChatHistoryDatalineFileFragment", 1, "onActionDownload. can not find a DataLineMsgRecord");
        return;
      }
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramFileManagerEntity.sessionid));
      localDataLineHandler.a(localArrayList);
      return;
    }
    super.c(paramFileManagerEntity);
  }
  
  protected void e(FileManagerEntity paramFileManagerEntity)
  {
    if (b(paramFileManagerEntity))
    {
      int i = FileManagerUtil.a(paramFileManagerEntity.fileName);
      DatalineFileBrowserParams localDatalineFileBrowserParams = new DatalineFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramFileManagerEntity);
      if (i == 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(paramFileManagerEntity.nSessionId));
        localDatalineFileBrowserParams.a(localArrayList);
      }
      paramFileManagerEntity = new FileBrowserCreator(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localDatalineFileBrowserParams);
      paramFileManagerEntity.a(11);
      paramFileManagerEntity.a();
      return;
    }
    super.e(paramFileManagerEntity);
  }
  
  protected void k()
  {
    super.k();
  }
  
  protected void l()
  {
    super.l();
  }
  
  protected void m()
  {
    super.m();
  }
  
  protected void n()
  {
    super.n();
  }
  
  protected void o()
  {
    super.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryDatalineFileFragment
 * JD-Core Version:    0.7.0.1
 */
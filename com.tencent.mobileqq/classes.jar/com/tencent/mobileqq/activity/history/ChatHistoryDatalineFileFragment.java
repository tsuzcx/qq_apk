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
  private DataLineObserver v;
  
  private boolean h(FileManagerEntity paramFileManagerEntity)
  {
    return paramFileManagerEntity.peerType == 6000;
  }
  
  private DataLineMsgRecord i(FileManagerEntity paramFileManagerEntity)
  {
    long l = paramFileManagerEntity.datalineEntitySessionId;
    int i = DataLineMsgRecord.getDevTypeBySeId(l);
    paramFileManagerEntity = this.a.getMessageFacade().d(i).a(l);
    if (paramFileManagerEntity == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSourceDatalineFile：do not find sessionId[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("ChatHistoryDatalineFileFragment", 1, localStringBuilder.toString());
    }
    return paramFileManagerEntity;
  }
  
  private List<FileManagerEntity> x()
  {
    Object localObject1 = this.a.getMessageFacade().d(0);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((DatalineMessageManager)localObject1).d();
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(FileManagerUtil.a((DataLineMsgRecord)((Iterator)localObject2).next()));
    }
    return localObject1;
  }
  
  protected ChatHistoryC2CFileAdapter a()
  {
    return new ChatHistoryDatalineFileAdapter(this.a, this.d, this.t);
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity)
  {
    if (h(paramFileManagerEntity))
    {
      paramFileManagerEntity = i(paramFileManagerEntity);
      if (paramFileManagerEntity == null)
      {
        QLog.e("ChatHistoryDatalineFileFragment", 1, "onActionResume. can not find a DataLineMsgRecord");
        return;
      }
      DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramFileManagerEntity.sessionid));
      localDataLineHandler.b(localArrayList);
      return;
    }
    super.a(paramFileManagerEntity);
  }
  
  protected IQFileMultiOperate b()
  {
    return new DatalineFileMultiOperate(this.a, this.d);
  }
  
  protected void b(FileManagerEntity paramFileManagerEntity)
  {
    if (h(paramFileManagerEntity))
    {
      paramFileManagerEntity = i(paramFileManagerEntity);
      if (paramFileManagerEntity == null)
      {
        QLog.e("ChatHistoryDatalineFileFragment", 1, "onActionPause. can not find a DataLineMsgRecord");
        return;
      }
      ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramFileManagerEntity.groupId, paramFileManagerEntity.sessionid, false);
      return;
    }
    super.b(paramFileManagerEntity);
  }
  
  protected void c()
  {
    super.c();
    this.v = new ChatHistoryDatalineFileFragment.1(this);
    this.a.addObserver(this.v);
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    if (h(paramFileManagerEntity))
    {
      paramFileManagerEntity = i(paramFileManagerEntity);
      if (paramFileManagerEntity == null)
      {
        QLog.e("ChatHistoryDatalineFileFragment", 1, "onActionDownload. can not find a DataLineMsgRecord");
        return;
      }
      DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramFileManagerEntity.sessionid));
      localDataLineHandler.b(localArrayList);
      return;
    }
    super.c(paramFileManagerEntity);
  }
  
  protected void d()
  {
    super.d();
    this.a.removeObserver(this.v);
  }
  
  protected void e(FileManagerEntity paramFileManagerEntity)
  {
    if (h(paramFileManagerEntity))
    {
      int i = FileManagerUtil.c(paramFileManagerEntity.fileName);
      DatalineFileBrowserParams localDatalineFileBrowserParams = new DatalineFileBrowserParams(this.a, this.d, paramFileManagerEntity);
      if (i == 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(paramFileManagerEntity.nSessionId));
        localDatalineFileBrowserParams.a(localArrayList);
      }
      paramFileManagerEntity = new FileBrowserCreator(this.d, localDatalineFileBrowserParams);
      paramFileManagerEntity.a(11);
      paramFileManagerEntity.a();
      return;
    }
    super.e(paramFileManagerEntity);
  }
  
  protected void p()
  {
    super.p();
  }
  
  protected void q()
  {
    super.q();
  }
  
  protected void r()
  {
    super.r();
  }
  
  protected void s()
  {
    super.s();
  }
  
  protected void t()
  {
    super.t();
  }
  
  protected LinkedHashMap<String, List<Object>> v()
  {
    ArrayList localArrayList1 = new ArrayList(this.a.getFileManagerProxy().a(g()));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    if (TextUtils.equals(g(), QFileAssistantUtils.b(this.a))) {
      localArrayList2.addAll(x());
    }
    Collections.sort(localArrayList2, new ChatHistoryDatalineFileFragment.2(this));
    return a(localArrayList2);
  }
  
  protected LinkedHashMap<String, List<Object>> w()
  {
    ArrayList localArrayList1 = new ArrayList(this.a.getFileManagerProxy().b(g()));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    if (TextUtils.equals(g(), QFileAssistantUtils.b(this.a))) {
      localArrayList2.addAll(x());
    }
    Collections.sort(localArrayList2, new ChatHistoryDatalineFileFragment.3(this));
    return a(localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryDatalineFileFragment
 * JD-Core Version:    0.7.0.1
 */
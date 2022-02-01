package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter.OnSelectedListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.openbrowser.RecentMediaFileBrowseProcessor;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatHistoryFileView
  extends ChatHistoryViewBase
  implements Handler.Callback, ChatHistoryFileAdapter.OnSelectedListener
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ChatHistoryFileAdapter jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  final String jdField_a_of_type_JavaLangString = "ChatHistoryFileView<FileAssistant>";
  private List<Object> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private String jdField_b_of_type_JavaLangString;
  
  public ChatHistoryFileView()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private ArrayList<TencentDocData> a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInt("retcode") == 0)
      {
        ArrayList localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("recent_file_list");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get(i);
          TencentDocData localTencentDocData = new TencentDocData();
          JSONObject localJSONObject2 = (JSONObject)localJSONObject1.get("doc_info");
          localTencentDocData.peerTips = localJSONObject1.getString("peer_tips");
          TencentDocData.obtainFromJsonObject(localJSONObject2, (JSONObject)localJSONObject1.get("qq_share_common_msg"), localTencentDocData);
          localArrayList.add(localTencentDocData);
          i += 1;
        }
        return localArrayList;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryFileView<FileAssistant>", 1, paramJSONObject.getMessage());
      }
    }
    return null;
  }
  
  private LinkedHashMap<String, List<Object>> a()
  {
    Object localObject1 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(this.jdField_b_of_type_JavaLangString));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject1).next();
      if ((localFileManagerEntity != null) && (!localFileManagerEntity.bDelInAio))
      {
        int i = this.jdField_a_of_type_Int;
        if (i == 1 ? (localFileManagerEntity.nFileType == 3) && (localFileManagerEntity.nFileType == 9) && (localFileManagerEntity.nFileType == 7) && (localFileManagerEntity.nFileType == 6) && (localFileManagerEntity.nFileType == 10) : (i != 3) || ((localFileManagerEntity.nFileType != 3) && (localFileManagerEntity.nFileType != 9) && (localFileManagerEntity.nFileType != 7) && (localFileManagerEntity.nFileType != 6) && (localFileManagerEntity.nFileType != 0) && (localFileManagerEntity.nFileType != 10) && (localFileManagerEntity.nFileType != 2)))
        {
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("ChatHistory Query Entity[");
            ((StringBuilder)localObject2).append(localFileManagerEntity.getId());
            ((StringBuilder)localObject2).append("] SessionId:");
            ((StringBuilder)localObject2).append(localFileManagerEntity.nSessionId);
            QLog.d("ChatHistoryFileView<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
          }
          Object localObject2 = QfileTimeUtils.a(localFileManagerEntity.srvTime);
          if (!localLinkedHashMap.containsKey(localObject2)) {
            localLinkedHashMap.put(localObject2, new ArrayList());
          }
          ((List)localLinkedHashMap.get(localObject2)).add(localFileManagerEntity);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private void a()
  {
    ThreadManager.post(new ChatHistoryFileView.1(this), 8, null, true);
  }
  
  private void a(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    paramLinkedHashMap = paramLinkedHashMap.values().iterator();
    while (paramLinkedHashMap.hasNext()) {
      Collections.sort((List)paramLinkedHashMap.next(), new ChatHistoryFileView.2(this));
    }
  }
  
  private void a(JSONObject paramJSONObject, LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = a(paramJSONObject);
      if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(paramJSONObject))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tencent doc size: ");
          ((StringBuilder)localObject).append(paramJSONObject.size());
          QLog.d("ChatHistoryFileView<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        }
        paramJSONObject = paramJSONObject.iterator();
        while (paramJSONObject.hasNext())
        {
          localObject = (TencentDocData)paramJSONObject.next();
          String str = QfileTimeUtils.a(((TencentDocData)localObject).aioTime);
          if (!paramLinkedHashMap.containsKey(str)) {
            paramLinkedHashMap.put(str, new ArrayList());
          }
          ((List)paramLinkedHashMap.get(str)).add(localObject);
        }
        FileManagerReporter.a("0X8009A9E");
      }
      a(paramLinkedHashMap);
    }
    paramJSONObject = new Message();
    paramJSONObject.what = 1;
    paramJSONObject.obj = paramLinkedHashMap;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramJSONObject);
  }
  
  private void b(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      localObject = paramLinkedHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilList.add(str);
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramLinkedHashMap.get(str));
      }
    }
  }
  
  private void g()
  {
    b(a());
    h();
  }
  
  private void h()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ChatHistoryFileView.3(this);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ChatHistoryFileView.4(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1)
    {
      a();
      return;
    }
    g();
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    j();
    i();
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter = new ChatHistoryFileAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this);
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.a(this);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560791, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370164));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371931));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter);
    paramIntent = this.jdField_a_of_type_AndroidViewView.findViewById(2131366812);
    paramQQAppInterface = paramIntent.findViewById(2131373966);
    paramIntent.setVisibility(8);
    paramQQAppInterface.setVisibility(8);
  }
  
  public void a(TencentDocData paramTencentDocData)
  {
    if (b())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramTencentDocData))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramTencentDocData);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a()) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramTencentDocData);
      }
    }
    else
    {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).clickWebTDDoc(paramTencentDocData.docUrl, this.jdField_a_of_type_AndroidContentContext);
      FileManagerReporter.a("0X8009A9F");
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if (b())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a()) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity);
      }
      if ((paramFileManagerEntity.cloudType == 3) && (!FileUtil.a(paramFileManagerEntity.getFilePath())))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(FileManagerUtil.c(paramFileManagerEntity.fileName));
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131701814));
        FMToastUtil.a(((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
      return;
    }
    boolean bool = c();
    int i = 2;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryFileView<FileAssistant>", 2, "click too fast , wait a minute.");
      }
      return;
    }
    k();
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
    ((FileManagerReporter.FileAssistantReportData)localObject).c = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
    FileManagerReporter.a("0X8004AE4");
    if ((paramFileManagerEntity.nFileType != 0) && (paramFileManagerEntity.nFileType != 2))
    {
      localObject = new FileModelAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
      if (paramFileManagerEntity.peerType != 0) {
        if (paramFileManagerEntity.peerType == 3000) {
          i = 6;
        } else {
          i = 7;
        }
      }
      paramFileManagerEntity = new FileBrowserParam().a(i).a(this.jdField_b_of_type_JavaLangString);
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.jdField_a_of_type_AndroidContentContext, (IFileBrowserModel)localObject, paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity = new RecentMediaFileBrowseProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, paramFileManagerEntity).a();
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(this.jdField_a_of_type_AndroidContentContext, paramFileManagerEntity);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ChatHistoryFileView.5(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
    super.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.a(true);
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.a(false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    b((LinkedHashMap)paramMessage.obj);
    h();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileView
 * JD-Core Version:    0.7.0.1
 */
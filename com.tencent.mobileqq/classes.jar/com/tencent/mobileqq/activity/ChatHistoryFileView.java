package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import rxl;
import rxm;
import rxp;

public class ChatHistoryFileView
  extends ChatHistoryViewBase
{
  private int jdField_a_of_type_Int;
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ChatHistoryFileAdapter a;
  public QQAppInterface a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  final String jdField_a_of_type_JavaLangString = "ChatHistoryFileView<FileAssistant>";
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private String jdField_b_of_type_JavaLangString;
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new rxl(this);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new rxm(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString);
    if (localObject1 == null) {
      return;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (!((FileManagerEntity)localObject2).bDelInAio) {
        if (this.jdField_a_of_type_Int == 1)
        {
          if ((((FileManagerEntity)localObject2).nFileType != 3) && (((FileManagerEntity)localObject2).nFileType != 9) && (((FileManagerEntity)localObject2).nFileType != 7) && (((FileManagerEntity)localObject2).nFileType != 6) && (((FileManagerEntity)localObject2).nFileType != 10)) {}
        }
        else {
          do
          {
            do
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("ChatHistoryFileView<FileAssistant>", 1, "ChatHistory Query Entity[" + ((FileManagerEntity)localObject2).getId() + "] SessionId:" + ((FileManagerEntity)localObject2).nSessionId);
              }
              String str = QfileTimeUtils.a(((FileManagerEntity)localObject2).srvTime);
              if (!localLinkedHashMap.containsKey(str)) {
                localLinkedHashMap.put(str, new ArrayList());
              }
              ((List)localLinkedHashMap.get(str)).add(localObject2);
              break;
            } while (this.jdField_a_of_type_Int != 3);
            if ((((FileManagerEntity)localObject2).nFileType == 3) || (((FileManagerEntity)localObject2).nFileType == 9) || (((FileManagerEntity)localObject2).nFileType == 7) || (((FileManagerEntity)localObject2).nFileType == 6) || (((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 10)) {
              break;
            }
          } while (((FileManagerEntity)localObject2).nFileType != 2);
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localLinkedHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilList.add(localObject2);
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localLinkedHashMap.get(localObject2));
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    g();
    f();
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter = new ChatHistoryFileAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130970007, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367398));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368735));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (a()) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
        if ((paramFileManagerEntity.cloudType == 3) && (!FileUtil.b(paramFileManagerEntity.strFilePath)))
        {
          FMToastUtil.a(FileManagerUtil.d(paramFileManagerEntity.fileName) + "为空文件，无法发送！");
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity);
      break;
      if (b()) {
        break label143;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatHistoryFileView<FileAssistant>", 2, "click too fast , wait a minute.");
    return;
    label143:
    k();
    Object localObject = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
    ((FileManagerReporter.fileAssistantReportData)localObject).c = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.fileAssistantReportData)localObject);
    FileManagerReporter.a("0X8004AE4");
    localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).d(paramFileManagerEntity.getCloudType());
    ((ForwardFileInfo)localObject).b(10001);
    ((ForwardFileInfo)localObject).b(paramFileManagerEntity.nSessionId);
    ((ForwardFileInfo)localObject).c(paramFileManagerEntity.uniseq);
    ((ForwardFileInfo)localObject).d(paramFileManagerEntity.fileName);
    ((ForwardFileInfo)localObject).d(paramFileManagerEntity.fileSize);
    ((ForwardFileInfo)localObject).b(paramFileManagerEntity.Uuid);
    ((ForwardFileInfo)localObject).a(paramFileManagerEntity.getFilePath());
    paramFileManagerEntity = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
    paramFileManagerEntity.putExtra("fileinfo", (Parcelable)localObject);
    paramFileManagerEntity.putExtra("from_qlink_enter_recent", false);
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
      paramFileManagerEntity.putExtra("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
    }
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramFileManagerEntity, 102);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new rxp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileView
 * JD-Core Version:    0.7.0.1
 */
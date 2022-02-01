package com.tencent.mobileqq.activity.history;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter;
import com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter.OnSelectedListener;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.multioperate.IQFileMultiOperate;
import com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ChatHistoryC2CFileFragment
  extends ChatHistoryBaseFragment
  implements View.OnClickListener, ChatHistoryC2CFileAdapter.OnSelectedListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ChatHistoryC2CFileFragment.6(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected ChatHistoryC2CFileAdapter a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private IQFileMultiOperate<FileManagerEntity> jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateIQFileMultiOperate;
  private QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  protected LinkedHashMap<String, List<Object>> a;
  protected List<FileManagerEntity> a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ChatHistoryC2CFileFragment.9(this);
  private View jdField_b_of_type_AndroidViewView;
  private View c;
  private boolean d = false;
  private boolean e = true;
  
  private void a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter.notifyDataSetChanged();
      if (!this.e) {
        return;
      }
      this.e = false;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new ChatHistoryC2CFileFragment.4(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new ChatHistoryC2CFileFragment.5(this));
  }
  
  private void a(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {}
    while (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(paramLinkedHashMap);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while (this.jdField_a_of_type_JavaUtilList.size() < 20) {
      return false;
    }
    return true;
  }
  
  private void c(boolean paramBoolean)
  {
    ThreadManagerV2.executeOnSubThread(new ChatHistoryC2CFileFragment.1(this, paramBoolean));
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter.a(paramBoolean);
    this.d = paramBoolean;
    r();
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a();
      this.c.setPadding(0, i, 0, 0);
      this.c.setVisibility(0);
      return;
    }
    this.c.setPadding(0, 0, 0, 0);
    this.c.setVisibility(8);
  }
  
  private void g(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity)) {
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
    }
  }
  
  private void h(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramFileManagerEntity);
  }
  
  private void q()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 2, 0, "", "", "", "");
    FileSearchActivity.a(getActivity(), 2, a());
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  protected ChatHistoryC2CFileAdapter a()
  {
    return new ChatHistoryC2CFileAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap);
  }
  
  protected IQFileMultiOperate a()
  {
    return new OfflineFileMultiOperate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  protected LinkedHashMap<String, List<Object>> a()
  {
    return a(new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(a())));
  }
  
  @NotNull
  protected LinkedHashMap<String, List<Object>> a(List<FileManagerEntity> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
      if ((localFileManagerEntity != null) && (!localFileManagerEntity.bDelInAio) && (localFileManagerEntity.nFileType != 13))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "ChatHistory Query Entity[" + localFileManagerEntity.getId() + "] SessionId:" + localFileManagerEntity.nSessionId);
        }
        String str = QfileTimeUtils.a(localFileManagerEntity.srvTime);
        if (!localLinkedHashMap.containsKey(str)) {
          localLinkedHashMap.put(str, new ArrayList());
        }
        ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    return localLinkedHashMap;
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = paramFileManagerEntity.isSend();
    FileModel.a(paramFileManagerEntity).a(bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new ChatHistoryC2CFileFragment.7(this, paramFileManagerEntity));
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity);
  }
  
  protected LinkedHashMap<String, List<Object>> b()
  {
    return a(new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().b(a())));
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ChatHistoryC2CFileFragment.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  protected void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.getCloudType() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramFileManagerEntity.nSessionId);
      return;
    }
    if (paramFileManagerEntity.getCloudType() == 6)
    {
      ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, paramFileManagerEntity.uniseq, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramFileManagerEntity.nSessionId);
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 3, 0, "", "", "", "");
    }
    d(paramBoolean);
    if (!paramBoolean) {
      r();
    }
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    FileModel.a(paramFileManagerEntity).a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new ChatHistoryC2CFileFragment.8(this, paramFileManagerEntity));
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(localArrayList);
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if (this.d)
    {
      if (a(paramFileManagerEntity)) {
        h(paramFileManagerEntity);
      }
      for (;;)
      {
        if ((paramFileManagerEntity.cloudType == 3) && (!FileUtil.b(paramFileManagerEntity.getFilePath())))
        {
          FMToastUtil.a(FileManagerUtil.d(paramFileManagerEntity.fileName) + HardCodeUtil.a(2131701715));
          h(paramFileManagerEntity);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter.notifyDataSetChanged();
        do
        {
          return;
        } while (a());
        g(paramFileManagerEntity);
      }
    }
    e(paramFileManagerEntity);
  }
  
  public void e()
  {
    super.e();
    c(false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 4, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(false);
  }
  
  protected void e(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).b = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
    ((FileManagerReporter.FileAssistantReportData)localObject).c = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
    FileManagerReporter.a("0X8004AE4");
    localObject = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.trim().length() != 0))
    {
      localBundle.putString("c2c_discussion_recentfile", a());
      localBundle.putString("file_browser_extra_params_uin", a());
    }
    ((CommonFileBrowserParams)localObject).a(localBundle);
    localObject = new FileBrowserCreator(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (IFileBrowserParams)localObject);
    if (paramFileManagerEntity.peerType == 0) {
      ((FileBrowserCreator)localObject).a(2);
    }
    for (;;)
    {
      ((FileBrowserCreator)localObject).a(true);
      ((FileBrowserCreator)localObject).a();
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        ((FileBrowserCreator)localObject).a(6);
      }
    }
  }
  
  public void f()
  {
    super.f();
    d(false);
  }
  
  public void f(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = this.jdField_a_of_type_JavaUtilList.iterator();
    do
    {
      if (!paramFileManagerEntity.hasNext()) {
        break;
      }
    } while (((FileManagerEntity)paramFileManagerEntity.next()).fileSize <= 104857600L);
    for (boolean bool = false;; bool = true)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(5, bool);
      return;
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  protected void k()
  {
    super.k();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateIQFileMultiOperate.a(localArrayList, 1, null);
    h();
    d(false);
    r();
  }
  
  protected void l()
  {
    super.l();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateIQFileMultiOperate.a(localArrayList, 4, null);
    h();
    d(false);
    r();
  }
  
  protected void m()
  {
    super.m();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateIQFileMultiOperate.a(localArrayList, 2, null);
    h();
    d(false);
    r();
  }
  
  protected void n()
  {
    super.n();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    localActionSheet.setMainTitle(2131696078);
    localActionSheet.addButton(getActivity().getString(2131692345), 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new ChatHistoryC2CFileFragment.10(this, localActionSheet));
    localActionSheet.show();
  }
  
  protected void o()
  {
    super.o();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateIQFileMultiOperate.a(localArrayList, 5, null);
    h();
    d(false);
    r();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      q();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateIQFileMultiOperate == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateIQFileMultiOperate = a();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.c = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560943, null);
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560918, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131372346));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter.b(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370504));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.c);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167305);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
      paramLayoutInflater = this.jdField_b_of_type_AndroidViewView.findViewById(2131366950);
      ((TextView)paramLayoutInflater.findViewById(2131374417)).setText(2131690870);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131374416));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    }
    paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.history;

import android.os.Bundle;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.multioperate.IQFileMultiOperate;
import com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.openbrowser.RecentMediaFileBrowseProcessor;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
  private boolean A = false;
  private FMObserver B = null;
  private IQFileMultiOperate<FileManagerEntity> C;
  private boolean D = true;
  private View.OnClickListener E = new ChatHistoryC2CFileFragment.6(this);
  private View.OnClickListener F = new ChatHistoryC2CFileFragment.9(this);
  protected ChatHistoryC2CFileAdapter s;
  protected LinkedHashMap<String, List<Object>> t;
  protected List<FileManagerEntity> u;
  private View v;
  private QfilePinnedHeaderExpandableListView w;
  private RelativeLayout x;
  private LinearLayout y;
  private View z;
  
  private void A()
  {
    List localList = this.u;
    if (localList != null) {
      localList.clear();
    }
  }
  
  private void a(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {
      return;
    }
    LinkedHashMap localLinkedHashMap = this.t;
    if (localLinkedHashMap != null)
    {
      localLinkedHashMap.clear();
      this.t.putAll(paramLinkedHashMap);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ThreadManagerV2.executeOnSubThread(new ChatHistoryC2CFileFragment.1(this, paramBoolean));
  }
  
  private void d(boolean paramBoolean)
  {
    this.s.a(paramBoolean);
    this.A = paramBoolean;
    A();
    if (paramBoolean)
    {
      int i = this.h.d();
      this.z.setPadding(0, i, 0, 0);
      this.z.setVisibility(0);
      return;
    }
    this.z.setPadding(0, 0, 0, 0);
    this.z.setVisibility(8);
  }
  
  private void h(FileManagerEntity paramFileManagerEntity)
  {
    if (this.u == null) {
      this.u = new ArrayList();
    }
    if (!this.u.contains(paramFileManagerEntity)) {
      this.u.add(paramFileManagerEntity);
    }
  }
  
  private void i(FileManagerEntity paramFileManagerEntity)
  {
    List localList = this.u;
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      this.u.remove(paramFileManagerEntity);
    }
  }
  
  private void x()
  {
    LinkedHashMap localLinkedHashMap = this.t;
    int i = 0;
    if ((localLinkedHashMap != null) && (localLinkedHashMap.size() != 0))
    {
      this.y.setVisibility(8);
      this.w.setVisibility(0);
      this.g.a(this, true);
    }
    else
    {
      this.y.setVisibility(0);
      this.w.setVisibility(8);
      this.g.a(this, false);
    }
    this.v.setVisibility(0);
    this.s.notifyDataSetChanged();
    if (this.D)
    {
      this.D = false;
      while (i < this.s.getGroupCount())
      {
        this.w.expandGroup(i);
        i += 1;
      }
      this.w.setOnGroupCollapseListener(new ChatHistoryC2CFileFragment.4(this));
      this.w.setOnGroupExpandListener(new ChatHistoryC2CFileFragment.5(this));
    }
  }
  
  private void y()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 2, 0, "", "", "", "");
    FileSearchActivity.a(getBaseActivity(), 2, g());
  }
  
  private boolean z()
  {
    List localList = this.u;
    boolean bool = false;
    if (localList == null)
    {
      this.u = new ArrayList();
      return false;
    }
    if (localList.size() >= 20) {
      bool = true;
    }
    return bool;
  }
  
  protected ChatHistoryC2CFileAdapter a()
  {
    return new ChatHistoryC2CFileAdapter(this.d, this.t);
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
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ChatHistory Query Entity[");
          ((StringBuilder)localObject).append(localFileManagerEntity.getId());
          ((StringBuilder)localObject).append("] SessionId:");
          ((StringBuilder)localObject).append(localFileManagerEntity.nSessionId);
          QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, ((StringBuilder)localObject).toString());
        }
        Object localObject = QfileTimeUtils.a(localFileManagerEntity.srvTime);
        if (!localLinkedHashMap.containsKey(localObject)) {
          localLinkedHashMap.put(localObject, new ArrayList());
        }
        ((List)localLinkedHashMap.get(localObject)).add(localFileManagerEntity);
      }
    }
    return localLinkedHashMap;
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = paramFileManagerEntity.isSend();
    FileModel.a(paramFileManagerEntity).a(bool, this.d, new ChatHistoryC2CFileFragment.7(this, paramFileManagerEntity));
  }
  
  protected IQFileMultiOperate b()
  {
    return new OfflineFileMultiOperate(this.a, this.d);
  }
  
  protected void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.getCloudType() == 0)
    {
      this.a.getOnlineFileSessionCenter().c(paramFileManagerEntity.nSessionId);
      return;
    }
    if (paramFileManagerEntity.getCloudType() == 6)
    {
      ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, paramFileManagerEntity.uniseq, false);
      return;
    }
    this.a.getFileManagerEngine().a(paramFileManagerEntity.nSessionId);
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      ReportController.b(this.a, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 3, 0, "", "", "", "");
    }
    d(paramBoolean);
    if (!paramBoolean) {
      A();
    }
  }
  
  protected void c()
  {
    if (this.B != null) {
      return;
    }
    this.B = new ChatHistoryC2CFileFragment.3(this);
    this.a.getFileManagerNotifyCenter().addObserver(this.B);
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    FileModel.a(paramFileManagerEntity).a(false, this.d, new ChatHistoryC2CFileFragment.8(this, paramFileManagerEntity));
  }
  
  protected void d()
  {
    if (this.B != null)
    {
      this.a.getFileManagerNotifyCenter().deleteObserver(this.B);
      this.B = null;
    }
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    this.a.getFileManagerDataCenter().b();
    if (this.A)
    {
      if (f(paramFileManagerEntity))
      {
        i(paramFileManagerEntity);
      }
      else
      {
        if (z()) {
          return;
        }
        h(paramFileManagerEntity);
      }
      if ((paramFileManagerEntity.cloudType == 3) && (!FileUtil.b(paramFileManagerEntity.getFilePath())))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(FileManagerUtil.j(paramFileManagerEntity.fileName));
        localStringBuilder.append(HardCodeUtil.a(2131899872));
        FMToastUtil.a(localStringBuilder.toString());
        i(paramFileManagerEntity);
      }
      this.s.notifyDataSetChanged();
      return;
    }
    e(paramFileManagerEntity);
  }
  
  protected void e(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).b = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject).c = 73;
    ((FileManagerReporter.FileAssistantReportData)localObject).d = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject).e = paramFileManagerEntity.fileSize;
    FileManagerReporter.a(this.a.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
    FileManagerReporter.a("0X8004AE4");
    if (paramFileManagerEntity.nFileType != 0)
    {
      int j = paramFileManagerEntity.nFileType;
      int i = 2;
      if (j != 2)
      {
        Bundle localBundle = new Bundle();
        if ((this.e != null) && (this.e.trim().length() != 0))
        {
          localBundle.putString("c2c_discussion_recentfile", g());
          localBundle.putString("file_browser_extra_params_uin", g());
        }
        localObject = new FileModelAdapter(this.a, paramFileManagerEntity);
        ((IFileBrowserModel)localObject).a(localBundle);
        if (paramFileManagerEntity.peerType != 0) {
          if (paramFileManagerEntity.peerType == 3000) {
            i = 6;
          } else {
            i = 7;
          }
        }
        paramFileManagerEntity = new FileBrowserParam().a(i);
        if ((this.e != null) && (this.e.trim().length() != 0)) {
          paramFileManagerEntity.a(g());
        }
        ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.d, (IFileBrowserModel)localObject, paramFileManagerEntity);
        return;
      }
    }
    paramFileManagerEntity = new RecentMediaFileBrowseProcessor(this.a, this.e, paramFileManagerEntity).a();
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(this.d, paramFileManagerEntity);
  }
  
  public boolean f(FileManagerEntity paramFileManagerEntity)
  {
    List localList = this.u;
    if ((localList != null) && (localList.size() > 0)) {
      return this.u.contains(paramFileManagerEntity);
    }
    return false;
  }
  
  public void g(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = this.u.iterator();
    while (paramFileManagerEntity.hasNext()) {
      if (((FileManagerEntity)paramFileManagerEntity.next()).fileSize > 104857600L)
      {
        bool = false;
        break label45;
      }
    }
    boolean bool = true;
    label45:
    this.h.a(5, bool);
  }
  
  protected void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    this.h.a(localArrayList);
  }
  
  public void i()
  {
    super.i();
    c(false);
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 4, 0, "", "", "", "");
    this.g.a(this, false);
  }
  
  public void j()
  {
    super.j();
    d(false);
  }
  
  public void k()
  {
    super.k();
  }
  
  protected int l()
  {
    return 1602;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441950) {
      y();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.C == null) {
      this.C = b();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.v == null)
    {
      this.t = new LinkedHashMap();
      this.u = new ArrayList();
      this.z = View.inflate(this.d, 2131627076, null);
      this.z.setVisibility(8);
      this.v = paramLayoutInflater.inflate(2131627050, paramViewGroup, false);
      this.y = ((LinearLayout)this.v.findViewById(2131439376));
      this.y.setVisibility(8);
      this.s = a();
      this.s.a(this);
      this.s.a(this.E);
      this.s.b(this.F);
      this.w = ((QfilePinnedHeaderExpandableListView)this.v.findViewById(2131437330));
      this.w.setVisibility(8);
      this.w.setAdapter(this.s);
      this.w.addFooterView(this.z);
      this.w.setSelector(2131168376);
      this.w.setAdapter(this.s);
      this.s.a(this.w);
      this.w.setTranscriptMode(0);
      this.w.setWhetherImageTab(false);
      paramLayoutInflater = this.v.findViewById(2131433134);
      ((TextView)paramLayoutInflater.findViewById(2131441951)).setText(2131887728);
      this.x = ((RelativeLayout)paramLayoutInflater.findViewById(2131441950));
      this.x.setOnClickListener(this);
    }
    paramLayoutInflater = (ViewGroup)this.v.getParent();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.removeView(this.v);
    }
    paramLayoutInflater = this.v;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void p()
  {
    super.p();
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.u);
    this.C.a(localArrayList, 1, null);
    m();
    d(false);
    A();
  }
  
  protected void q()
  {
    super.q();
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.u);
    this.C.a(localArrayList, 4, null);
    m();
    d(false);
    A();
  }
  
  protected void r()
  {
    super.r();
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.u);
    this.C.a(localArrayList, 2, null);
    m();
    d(false);
    A();
  }
  
  protected void s()
  {
    super.s();
    ReportController.b(this.a, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    localActionSheet.setMainTitle(2131893858);
    localActionSheet.addButton(getBaseActivity().getString(2131889261), 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ChatHistoryC2CFileFragment.10(this, localActionSheet));
    localActionSheet.show();
  }
  
  protected void t()
  {
    super.t();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.u);
    this.C.a(localArrayList, 5, null);
    m();
    d(false);
    A();
  }
  
  protected LinkedHashMap<String, List<Object>> v()
  {
    return a(new ArrayList(this.a.getFileManagerProxy().a(g())));
  }
  
  protected LinkedHashMap<String, List<Object>> w()
  {
    return a(new ArrayList(this.a.getFileManagerProxy().b(g())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.history;

import ahut;
import ahuu;
import ahuv;
import ahuw;
import ahuz;
import ahva;
import ahzb;
import ahzd;
import ahzt;
import alpo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqnl;
import aqsc;
import aqse;
import aqxp;
import arhh;
import arhj;
import arhm;
import arkx;
import arky;
import armz;
import arng;
import arnh;
import arni;
import arof;
import aroy;
import azmj;
import bhpy;
import bhql;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ChatHistoryC2CFileFragment
  extends ChatHistoryBaseFragment
  implements ahzd, View.OnClickListener
{
  private ahzb jdField_a_of_type_Ahzb;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahuw(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private aqnl jdField_a_of_type_Aqnl;
  private arkx<FileManagerEntity> jdField_a_of_type_Arkx;
  private QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  private LinkedHashMap<String, List<Object>> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<FileManagerEntity> jdField_a_of_type_JavaUtilList;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ahuz(this);
  private View jdField_b_of_type_AndroidViewView;
  private View c;
  private boolean d;
  private boolean e = true;
  
  private LinkedHashMap<String, List<Object>> a()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(a()));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "waterTest load : Entity[" + localFileManagerEntity.hashCode() + "]");
      if ((localFileManagerEntity != null) && (!localFileManagerEntity.bDelInAio) && (localFileManagerEntity.nFileType != 13))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "ChatHistory Query Entity[" + localFileManagerEntity.getId() + "] SessionId:" + localFileManagerEntity.nSessionId);
        }
        String str = aroy.a(localFileManagerEntity.srvTime);
        if (!localLinkedHashMap.containsKey(str)) {
          localLinkedHashMap.put(str, new ArrayList());
        }
        ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    return localLinkedHashMap;
  }
  
  private void a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Ahzb.notifyDataSetChanged();
      if (!this.e) {
        return;
      }
      this.e = false;
      while (i < this.jdField_a_of_type_Ahzb.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new ahuu(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new ahuv(this));
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
  
  private LinkedHashMap<String, List<Object>> b()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(a()));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "waterTest load : Entity[" + localFileManagerEntity.hashCode() + "]");
      if ((localFileManagerEntity != null) && (!localFileManagerEntity.bDelInAio) && (localFileManagerEntity.nFileType != 13))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "ChatHistory Query Entity[" + localFileManagerEntity.getId() + "] SessionId:" + localFileManagerEntity.nSessionId);
        }
        String str = aroy.a(localFileManagerEntity.srvTime);
        if (!localLinkedHashMap.containsKey(str)) {
          localLinkedHashMap.put(str, new ArrayList());
        }
        ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    return localLinkedHashMap;
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity)) {
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramFileManagerEntity);
  }
  
  private void c(boolean paramBoolean)
  {
    ThreadManagerV2.executeOnSubThread(new ChatHistoryC2CFileFragment.1(this, paramBoolean));
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ahzb.a(paramBoolean);
    this.d = paramBoolean;
    q();
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Ahzt.a();
      this.c.setPadding(0, i, 0, 0);
      this.c.setVisibility(0);
      return;
    }
    this.c.setPadding(0, 0, 0, 0);
    this.c.setVisibility(8);
  }
  
  private void p()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 2, 0, "", "", "", "");
    FileSearchActivity.a(getActivity(), 2, a());
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (this.d)
    {
      if (a(paramFileManagerEntity)) {
        c(paramFileManagerEntity);
      }
      for (;;)
      {
        if ((paramFileManagerEntity.cloudType == 3) && (!arof.b(paramFileManagerEntity.strFilePath)))
        {
          armz.a(arni.d(paramFileManagerEntity.fileName) + alpo.a(2131702015));
          c(paramFileManagerEntity);
        }
        this.jdField_a_of_type_Ahzb.notifyDataSetChanged();
        do
        {
          return;
        } while (a());
        b(paramFileManagerEntity);
      }
    }
    Object localObject = new arnh();
    ((arnh)localObject).b = "file_viewer_in";
    ((arnh)localObject).jdField_a_of_type_Int = 73;
    ((arnh)localObject).c = arof.a(paramFileManagerEntity.fileName);
    ((arnh)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (arnh)localObject);
    arng.a("0X8004AE4");
    localObject = new arhh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.trim().length() != 0))
    {
      localBundle.putString("c2c_discussion_recentfile", a());
      localBundle.putString("file_browser_extra_params_uin", a());
    }
    ((arhh)localObject).a(localBundle);
    localObject = new arhj(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (arhm)localObject);
    if (paramFileManagerEntity.peerType == 0) {
      ((arhj)localObject).a(2);
    }
    for (;;)
    {
      ((arhj)localObject).a(true);
      ((arhj)localObject).a();
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        ((arhj)localObject).a(6);
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aqnl != null) {
      return;
    }
    this.jdField_a_of_type_Aqnl = new ahut(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 3, 0, "", "", "", "");
    }
    d(paramBoolean);
    if (!paramBoolean) {
      q();
    }
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Aqnl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
      this.jdField_a_of_type_Aqnl = null;
    }
  }
  
  public void e()
  {
    super.e();
    c(false);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 4, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    d(false);
  }
  
  public void g()
  {
    super.g();
  }
  
  protected void k()
  {
    super.k();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Arkx.a(localArrayList, 1, null);
    h();
    d(false);
    q();
  }
  
  protected void l()
  {
    super.l();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Arkx.a(localArrayList, 4, null);
    h();
    d(false);
    q();
  }
  
  protected void m()
  {
    super.m();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Arkx.a(localArrayList, 2, null);
    h();
    d(false);
    q();
  }
  
  protected void n()
  {
    super.n();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
    bhpy localbhpy = (bhpy)bhql.a(getActivity(), null);
    localbhpy.a(2131696568);
    localbhpy.a(getActivity().getString(2131692485), 3);
    localbhpy.c(2131690648);
    localbhpy.a(new ahva(this, localbhpy));
    localbhpy.show();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    p();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_Arkx == null) {
      this.jdField_a_of_type_Arkx = new arky(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.c = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560660, null);
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560638, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131371196));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Ahzb = new ahzb(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap);
      this.jdField_a_of_type_Ahzb.a(this);
      this.jdField_a_of_type_Ahzb.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Ahzb.b(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369552));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Ahzb);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.c);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167138);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Ahzb);
      this.jdField_a_of_type_Ahzb.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
      paramLayoutInflater = this.jdField_b_of_type_AndroidViewView.findViewById(2131366329);
      ((TextView)paramLayoutInflater.findViewById(2131373236)).setText(2131690773);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131373235));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    }
    paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    return this.jdField_b_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment
 * JD-Core Version:    0.7.0.1
 */
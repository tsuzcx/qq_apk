package com.tencent.mobileqq.activity.history;

import akal;
import akbf;
import akbg;
import akbh;
import akbi;
import akbl;
import akbm;
import akfn;
import akfp;
import akgf;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import atpa;
import atup;
import atur;
import atzd;
import auhr;
import auht;
import auhw;
import auky;
import aukz;
import auna;
import aunh;
import auni;
import aunj;
import auog;
import auoy;
import bdll;
import blir;
import blji;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ChatHistoryC2CFileFragment
  extends ChatHistoryBaseFragment
  implements akfp, View.OnClickListener
{
  private akfn jdField_a_of_type_Akfn;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akbi(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private atpa jdField_a_of_type_Atpa;
  private auky<FileManagerEntity> jdField_a_of_type_Auky;
  private QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  private LinkedHashMap<String, List<Object>> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<FileManagerEntity> jdField_a_of_type_JavaUtilList;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new akbl(this);
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
      if ((localFileManagerEntity == null) || (localFileManagerEntity.bDelInAio))
      {
        QLog.w("ChatHistoryC2CFileFragment<QFile>", 1, "getLocalDataMap Entity[null]");
      }
      else
      {
        QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, " getLocalDataMap : Entity[" + localFileManagerEntity.hashCode() + "]");
        if (localFileManagerEntity.nFileType != 13)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "ChatHistory Query Entity[" + localFileManagerEntity.getId() + "] SessionId:" + localFileManagerEntity.nSessionId);
          }
          String str = auoy.a(localFileManagerEntity.srvTime);
          if (!localLinkedHashMap.containsKey(str)) {
            localLinkedHashMap.put(str, new ArrayList());
          }
          ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
        }
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
      this.jdField_a_of_type_Akal.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Akfn.notifyDataSetChanged();
      if (!this.e) {
        return;
      }
      this.e = false;
      while (i < this.jdField_a_of_type_Akfn.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(0);
      this.jdField_a_of_type_Akal.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new akbg(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new akbh(this));
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
        String str = auoy.a(localFileManagerEntity.srvTime);
        if (!localLinkedHashMap.containsKey(str)) {
          localLinkedHashMap.put(str, new ArrayList());
        }
        ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    return localLinkedHashMap;
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity)) {
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ThreadManagerV2.executeOnSubThread(new ChatHistoryC2CFileFragment.1(this, paramBoolean));
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramFileManagerEntity);
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Akfn.a(paramBoolean);
    this.d = paramBoolean;
    r();
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Akgf.a();
      this.c.setPadding(0, i, 0, 0);
      this.c.setVisibility(0);
      return;
    }
    this.c.setPadding(0, 0, 0, 0);
    this.c.setVisibility(8);
  }
  
  private void q()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 2, 0, "", "", "", "");
    FileSearchActivity.a(getActivity(), 2, a());
  }
  
  private void r()
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
        d(paramFileManagerEntity);
      }
      for (;;)
      {
        if ((paramFileManagerEntity.cloudType == 3) && (!auog.b(paramFileManagerEntity.getFilePath())))
        {
          auna.a(aunj.d(paramFileManagerEntity.fileName) + anzj.a(2131700554));
          d(paramFileManagerEntity);
        }
        this.jdField_a_of_type_Akfn.notifyDataSetChanged();
        do
        {
          return;
        } while (a());
        c(paramFileManagerEntity);
      }
    }
    Object localObject = new auni();
    ((auni)localObject).b = "file_viewer_in";
    ((auni)localObject).jdField_a_of_type_Int = 73;
    ((auni)localObject).c = auog.a(paramFileManagerEntity.fileName);
    ((auni)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (auni)localObject);
    aunh.a("0X8004AE4");
    localObject = new auhr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.trim().length() != 0))
    {
      localBundle.putString("c2c_discussion_recentfile", a());
      localBundle.putString("file_browser_extra_params_uin", a());
    }
    ((auhr)localObject).a(localBundle);
    localObject = new auht(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (auhw)localObject);
    if (paramFileManagerEntity.peerType == 0) {
      ((auht)localObject).a(2);
    }
    for (;;)
    {
      ((auht)localObject).a(true);
      ((auht)localObject).a();
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        ((auht)localObject).a(6);
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
    if (this.jdField_a_of_type_Atpa != null) {
      return;
    }
    this.jdField_a_of_type_Atpa = new akbf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
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
      this.jdField_a_of_type_Akgf.a(5, bool);
      return;
    }
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 3, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Atpa != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
      this.jdField_a_of_type_Atpa = null;
    }
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    this.jdField_a_of_type_Akgf.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    c(false);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 4, 0, "", "", "", "");
    this.jdField_a_of_type_Akal.a(false);
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
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Auky.a(localArrayList, 1, null);
    h();
    d(false);
    r();
  }
  
  protected void l()
  {
    super.l();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Auky.a(localArrayList, 4, null);
    h();
    d(false);
    r();
  }
  
  protected void m()
  {
    super.m();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Auky.a(localArrayList, 2, null);
    h();
    d(false);
    r();
  }
  
  protected void n()
  {
    super.n();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
    blir localblir = (blir)blji.a(getActivity(), null);
    localblir.a(2131695439);
    localblir.a(getActivity().getString(2131692075), 3);
    localblir.c(2131690580);
    localblir.a(new akbm(this, localblir));
    localblir.show();
  }
  
  protected void o()
  {
    super.o();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Auky.a(localArrayList, 5, null);
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
    if (this.jdField_a_of_type_Auky == null) {
      this.jdField_a_of_type_Auky = new aukz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.c = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560911, null);
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560887, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131371886));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Akfn = new akfn(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap);
      this.jdField_a_of_type_Akfn.a(this);
      this.jdField_a_of_type_Akfn.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Akfn.b(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370063));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Akfn);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.c);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167247);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Akfn);
      this.jdField_a_of_type_Akfn.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
      paramLayoutInflater = this.jdField_b_of_type_AndroidViewView.findViewById(2131366633);
      ((TextView)paramLayoutInflater.findViewById(2131374126)).setText(2131690649);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131374125));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment
 * JD-Core Version:    0.7.0.1
 */
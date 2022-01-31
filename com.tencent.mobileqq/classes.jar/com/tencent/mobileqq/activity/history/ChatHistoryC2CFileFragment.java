package com.tencent.mobileqq.activity.history;

import afle;
import aflf;
import afli;
import aflj;
import afps;
import ahzj;
import ahzl;
import ajjy;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aodp;
import aoig;
import aoii;
import aons;
import aowq;
import aows;
import aowv;
import aozx;
import aozy;
import apcb;
import apci;
import apcj;
import apck;
import apdh;
import apea;
import awqx;
import begr;
import behe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ChatHistoryC2CFileFragment
  extends ChatHistoryBaseFragment
  implements ahzl, View.OnClickListener
{
  private ahzj jdField_a_of_type_Ahzj;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aflf(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private aodp jdField_a_of_type_Aodp;
  private aozx<FileManagerEntity> jdField_a_of_type_Aozx;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<Object> jdField_a_of_type_JavaUtilList;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new afli(this);
  private View jdField_b_of_type_AndroidViewView;
  private List<FileManagerEntity> jdField_b_of_type_JavaUtilList;
  private View c;
  private boolean d;
  
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
        String str = apea.a(localFileManagerEntity.srvTime);
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
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Ahzj.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  private void a(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        Iterator localIterator = paramLinkedHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.add(str);
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramLinkedHashMap.get(str));
        }
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    while (this.jdField_b_of_type_JavaUtilList.size() < 20) {
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
        String str = apea.a(localFileManagerEntity.srvTime);
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
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramFileManagerEntity)) {
      this.jdField_b_of_type_JavaUtilList.add(paramFileManagerEntity);
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramFileManagerEntity);
  }
  
  private void c(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new ChatHistoryC2CFileFragment.1(this, paramBoolean));
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ahzj.a(paramBoolean);
    this.d = paramBoolean;
    q();
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Afps.a();
      this.c.setPadding(0, i, 0, 0);
      this.c.setVisibility(0);
      return;
    }
    this.c.setPadding(0, 0, 0, 0);
    this.c.setVisibility(8);
  }
  
  private void p()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 2, 0, "", "", "", "");
    FileSearchActivity.a(getActivity(), 2, a());
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
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
        if ((paramFileManagerEntity.cloudType == 3) && (!apdh.b(paramFileManagerEntity.strFilePath)))
        {
          apcb.a(apck.d(paramFileManagerEntity.fileName) + ajjy.a(2131635847));
          c(paramFileManagerEntity);
        }
        this.jdField_a_of_type_Ahzj.notifyDataSetChanged();
        do
        {
          return;
        } while (a());
        b(paramFileManagerEntity);
      }
    }
    Object localObject = new apcj();
    ((apcj)localObject).b = "file_viewer_in";
    ((apcj)localObject).jdField_a_of_type_Int = 73;
    ((apcj)localObject).c = apdh.a(paramFileManagerEntity.fileName);
    ((apcj)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apcj)localObject);
    apci.a("0X8004AE4");
    localObject = new aowq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.trim().length() != 0))
    {
      localBundle.putString("c2c_discussion_recentfile", a());
      localBundle.putString("file_browser_extra_params_uin", a());
    }
    ((aowq)localObject).a(localBundle);
    localObject = new aows(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (aowv)localObject);
    if (paramFileManagerEntity.peerType == 0) {
      ((aows)localObject).a(2);
    }
    for (;;)
    {
      ((aows)localObject).a(true);
      ((aows)localObject).a();
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        ((aows)localObject).a(6);
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramFileManagerEntity);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aodp != null) {
      return;
    }
    this.jdField_a_of_type_Aodp = new afle(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 3, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Aodp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
      this.jdField_a_of_type_Aodp = null;
    }
  }
  
  public void e()
  {
    super.e();
    c(false);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 4, 0, "", "", "", "");
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
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Aozx.a(localArrayList, 1, null);
    h();
    d(false);
    q();
  }
  
  protected void l()
  {
    super.l();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Aozx.a(localArrayList, 4, null);
    h();
    d(false);
    q();
  }
  
  protected void m()
  {
    super.m();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Aozx.a(localArrayList, 2, null);
    h();
    d(false);
    q();
  }
  
  protected void n()
  {
    super.n();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
    begr localbegr = (begr)behe.a(getActivity(), null);
    localbegr.a(2131630692);
    localbegr.a(getActivity().getString(2131626808), 3);
    localbegr.c(2131625035);
    localbegr.a(new aflj(this, localbegr));
    localbegr.show();
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
    if (this.jdField_a_of_type_Aozx == null) {
      this.jdField_a_of_type_Aozx = new aozy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_Ahzj = new ahzj(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
      this.jdField_a_of_type_Ahzj.a(this);
      this.c = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131494914, null);
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131494891, paramViewGroup, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131303648));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131305214));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahzj);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.c);
      paramLayoutInflater = this.jdField_b_of_type_AndroidViewView.findViewById(2131300639);
      ((TextView)paramLayoutInflater.findViewById(2131307085)).setText(2131625160);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131307084));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    }
    paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    return this.jdField_b_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment
 * JD-Core Version:    0.7.0.1
 */
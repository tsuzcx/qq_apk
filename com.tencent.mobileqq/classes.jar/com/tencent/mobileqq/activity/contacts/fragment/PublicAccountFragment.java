package com.tencent.mobileqq.activity.contacts.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import wkq;
import wkr;
import wks;
import wkt;
import wku;
import wkw;
import wkx;
import wky;
import wkz;
import wlb;

public class PublicAccountFragment
  extends ContactsBaseFragment
  implements IndexView.OnIndexChangedListener, AdapterView.OnItemClickListener
{
  protected Drawable a;
  protected Handler.Callback a;
  protected PublicAccountFragment.ListAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wkx(this);
  public PublicAccountDataManager a;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new wky(this);
  protected IndexView a;
  protected PinnedDividerListView a;
  private Comparator jdField_a_of_type_JavaUtilComparator = new wkw(this);
  protected List a;
  protected MqqHandler a;
  protected View b;
  protected View c;
  private boolean c;
  
  public PublicAccountFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new wkq(this);
  }
  
  private wkz a(PublicAccountInfo paramPublicAccountInfo)
  {
    wkz localwkz = new wkz(paramPublicAccountInfo);
    localwkz.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localwkz.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localwkz;
  }
  
  private void j()
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      if (this.jdField_b_of_type_AndroidViewView == null) {}
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)this.jdField_b_of_type_AndroidViewView.findViewById(2131363098);
      } while (localViewStub == null);
      this.jdField_c_of_type_AndroidViewView = localViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.findViewById(2131365633).setOnClickListener(new wks(this));
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "getView");
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2130968802, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363806));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363807));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
    for (;;)
    {
      return this.jdField_b_of_type_AndroidViewView;
      paramLayoutInflater = this.jdField_b_of_type_AndroidViewView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_b_of_type_AndroidViewView);
      }
    }
  }
  
  public void a()
  {
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter = null;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    paramView = paramView.getTag();
    if ((paramView instanceof wlb)) {
      paramAdapterView = ((wlb)paramView).a;
    }
    if (paramAdapterView == null) {
      if (QLog.isColorLevel()) {
        QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - info = null[position = " + paramInt + "]");
      }
    }
    String str;
    do
    {
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
      str = paramAdapterView.a.getUin();
      paramInt = 1008;
      if (paramAdapterView.a.extendType == 2)
      {
        paramView.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      if (!TextUtils.isEmpty(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - uin = null");
    return;
    paramView.putExtra("uin", str);
    paramView.putExtra("uintype", paramInt);
    paramView.putExtra("uinname", paramAdapterView.a.name);
    paramView.putExtra("selfSet_leftViewText", getString(2131437754));
    paramView.putExtra("jump_from", 3);
    startActivity(paramView);
    PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, str, "", "", "", false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, str, "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (paramBoolean) {
        d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter = new PublicAccountFragment.ListAdapter(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55));
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager == null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a)
    {
      this.jdField_b_of_type_AndroidViewView.postDelayed(new wkr(this), 200L);
      return;
    }
    h();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "refresh");
    }
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    if (localPublicAccountHandler != null) {
      localPublicAccountHandler.a();
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.c();
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter = new PublicAccountFragment.ListAdapter(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter);
        i();
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = null;
    }
  }
  
  protected void h()
  {
    ThreadManager.post(new wkt(this), 5, new wku(this), true);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QidianManager localQidianManager = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((localQidianManager == null) || (!localQidianManager.f(localPublicAccountInfo.getUin()))) {
          this.jdField_a_of_type_JavaUtilList.add(a(localPublicAccountInfo));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment$ListAdapter.notifyDataSetChanged();
      return;
    }
    j();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */
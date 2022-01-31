package com.tencent.mobileqq.activity.contacts.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceObserver;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import wna;
import wnb;
import wnc;
import wnd;
import wne;
import wnf;

public class DeviceFragment
  extends ContactsBaseFragment
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final SmartDeviceObserver jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver = new wnf(this);
  public ContactsDeviceAdapter a;
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new wnd(this);
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wne(this);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new wnc(this);
  public XListView a;
  public boolean c;
  public boolean d;
  public boolean e;
  
  private void h()
  {
    Object localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (((SmartDeviceProxyMgr)localObject1).a())
    {
      DeviceInfo[] arrayOfDeviceInfo = ((SmartDeviceProxyMgr)localObject1).a();
      if (arrayOfDeviceInfo != null)
      {
        ((SmartDeviceProxyMgr)localObject1).a(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
        ThreadManager.post(new wnb(this), 5, null, true);
      }
    }
    try
    {
      localObject1 = getActivity().getApplicationContext().getPackageManager().getPackageInfo(getActivity().getApplicationContext().getPackageName(), 0).packageName;
      EquipmentLockImpl.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, 0L);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public int a()
  {
    return 2;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetXListView.setId(2131362392);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentWidgetXListView;
      paramLayoutInflater = this.jdField_a_of_type_ComTencentWidgetXListView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_ComTencentWidgetXListView);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DeviceFragment", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.X_();
    }
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DeviceFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter = new ContactsDeviceAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new wna(this), 500L);
  }
  
  public void b()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localSmartDeviceProxyMgr != null)
    {
      if (!localSmartDeviceProxyMgr.a()) {
        break label34;
      }
      this.e = true;
      localSmartDeviceProxyMgr.f();
    }
    label34:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener.a(2, true, null);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DeviceFragment", 2, "doOnPause:" + paramBoolean);
    }
    if (paramBoolean) {
      e();
    }
  }
  
  public void c()
  {
    if ((this.b) && (this.jdField_a_of_type_ComTencentWidgetXListView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter = new ContactsDeviceAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.a(this.c, AppConstants.y);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.a(this.d, AppConstants.z);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.notifyDataSetChanged();
      h();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.X_();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment
 * JD-Core Version:    0.7.0.1
 */
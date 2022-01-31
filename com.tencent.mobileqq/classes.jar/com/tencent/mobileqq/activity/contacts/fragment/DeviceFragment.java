package com.tencent.mobileqq.activity.contacts.fragment;

import aekt;
import ahna;
import ahoj;
import ahol;
import ahom;
import ahon;
import ahoo;
import aljq;
import almg;
import alox;
import alsi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aofo;
import aofp;
import aofq;
import apwu;
import bhoe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import zoz;
import zpa;

public class DeviceFragment
  extends ContactsBaseFragment
  implements Handler.Callback, aofq
{
  public ahna a;
  private final almg jdField_a_of_type_Almg = new ahom(this);
  private final alox jdField_a_of_type_Alox = new ahon(this);
  private final alsi jdField_a_of_type_Alsi = new ahol(this);
  private bhoe jdField_a_of_type_Bhoe = new bhoe(Looper.getMainLooper(), this);
  protected XListView a;
  private final zoz jdField_a_of_type_Zoz = new ahoo(this);
  public boolean c;
  public boolean d;
  public boolean e;
  protected boolean f = true;
  
  private void i()
  {
    Object localObject1 = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (((zpa)localObject1).a())
    {
      DeviceInfo[] arrayOfDeviceInfo = ((zpa)localObject1).a();
      if (arrayOfDeviceInfo != null)
      {
        ((zpa)localObject1).notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
        ThreadManager.post(new DeviceFragment.2(this), 5, null, true);
      }
    }
    try
    {
      localObject1 = getActivity().getApplicationContext().getPackageManager().getPackageInfo(getActivity().getApplicationContext().getPackageName(), 0).packageName;
      apwu.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, 0L);
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
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetXListView.setId(2131369871);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, aekt.a(54.0F, getResources()));
      this.jdField_a_of_type_ComTencentWidgetXListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setScrollBarStyle(33554432);
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
    if (this.jdField_a_of_type_Ahna != null)
    {
      this.jdField_a_of_type_Ahna.a();
      this.jdField_a_of_type_Ahna.c();
    }
    e();
    this.jdField_a_of_type_Bhoe.removeCallbacksAndMessages(null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aofp paramaofp)
  {
    if ((paramaofp != null) && ("smart_devices_discovery_config".equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceFragment", 2, "handleConfigForTag smartDeviceDiscoverCfg content = " + paramaofp.a);
      }
      ThreadManager.post(new DeviceFragment.7(this, paramaofp), 5, null, true);
    }
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
    if (this.jdField_a_of_type_Ahna == null)
    {
      this.jdField_a_of_type_Ahna = new ahna(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahna);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    i();
    h();
    this.jdField_a_of_type_Ahna.notifyDataSetChanged();
    this.jdField_a_of_type_Bhoe.postDelayed(new DeviceFragment.1(this), 500L);
  }
  
  public void av_()
  {
    zpa localzpa = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localzpa != null)
    {
      if (!localzpa.a()) {
        break label34;
      }
      this.e = true;
      localzpa.e();
    }
    label34:
    while (this.jdField_a_of_type_Ahoj == null) {
      return;
    }
    this.jdField_a_of_type_Ahoj.a(b(), true, null);
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
      this.jdField_a_of_type_Ahna = new ahna(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahna);
      this.jdField_a_of_type_Ahna.a(this.c, aljq.z);
      this.jdField_a_of_type_Ahna.a(this.d, aljq.A);
      h();
      this.jdField_a_of_type_Ahna.notifyDataSetChanged();
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhoe.removeCallbacksAndMessages(null);
      return;
      if (this.jdField_a_of_type_Ahna != null) {
        this.jdField_a_of_type_Ahna.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Almg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Zoz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("smart_devices_discovery_config", this);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Ahna != null)
    {
      this.jdField_a_of_type_Ahna.a();
      this.jdField_a_of_type_Ahna.c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
      this.jdField_a_of_type_Ahna = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Almg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Zoz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("smart_devices_discovery_config", this);
    }
  }
  
  public void h()
  {
    boolean bool = true;
    if (BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "smart_device_discovery_config_file", 0).getInt("smart_device_discovery_config_switch", 1) == 1) {}
    for (;;)
    {
      this.f = bool;
      if (this.jdField_a_of_type_Ahna != null) {
        this.jdField_a_of_type_Ahna.a(this.f);
      }
      return;
      bool = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      label36:
      if (bool1 == this.f) {
        break label88;
      }
      if (this.f) {
        break label90;
      }
    }
    label88:
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.f = bool1;
      if (this.jdField_a_of_type_Ahna == null) {
        break;
      }
      this.jdField_a_of_type_Ahna.a(this.f);
      this.jdField_a_of_type_Ahna.notifyDataSetChanged();
      return false;
      bool1 = false;
      break label36;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment
 * JD-Core Version:    0.7.0.1
 */
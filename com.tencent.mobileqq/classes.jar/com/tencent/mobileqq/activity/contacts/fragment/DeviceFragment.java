package com.tencent.mobileqq.activity.contacts.fragment;

import aciy;
import afdp;
import afex;
import afez;
import affa;
import affb;
import affc;
import ajed;
import ajgs;
import ajjh;
import ajmm;
import alzb;
import alzc;
import alzd;
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
import anoc;
import beez;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import xrg;
import xrh;

public class DeviceFragment
  extends ContactsBaseFragment
  implements alzd, Handler.Callback
{
  public afdp a;
  private final ajgs jdField_a_of_type_Ajgs = new affa(this);
  private final ajjh jdField_a_of_type_Ajjh = new affb(this);
  private final ajmm jdField_a_of_type_Ajmm = new afez(this);
  private beez jdField_a_of_type_Beez = new beez(Looper.getMainLooper(), this);
  protected XListView a;
  private final xrg jdField_a_of_type_Xrg = new affc(this);
  public boolean c;
  public boolean d;
  public boolean e;
  protected boolean f = true;
  
  private void i()
  {
    Object localObject1 = (xrh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (((xrh)localObject1).a())
    {
      DeviceInfo[] arrayOfDeviceInfo = ((xrh)localObject1).a();
      if (arrayOfDeviceInfo != null)
      {
        ((xrh)localObject1).notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
        ThreadManager.post(new DeviceFragment.2(this), 5, null, true);
      }
    }
    try
    {
      localObject1 = getActivity().getApplicationContext().getPackageManager().getPackageInfo(getActivity().getApplicationContext().getPackageName(), 0).packageName;
      anoc.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, 0L);
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
      this.jdField_a_of_type_ComTencentWidgetXListView.setId(2131303932);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, aciy.a(54.0F, getResources()));
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
    if (this.jdField_a_of_type_Afdp != null)
    {
      this.jdField_a_of_type_Afdp.a();
      this.jdField_a_of_type_Afdp.c();
    }
    e();
    this.jdField_a_of_type_Beez.removeCallbacksAndMessages(null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, alzc paramalzc)
  {
    if ((paramalzc != null) && ("smart_devices_discovery_config".equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceFragment", 2, "handleConfigForTag smartDeviceDiscoverCfg content = " + paramalzc.a);
      }
      ThreadManager.post(new DeviceFragment.7(this, paramalzc), 5, null, true);
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
    if (this.jdField_a_of_type_Afdp == null)
    {
      this.jdField_a_of_type_Afdp = new afdp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afdp);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    i();
    h();
    this.jdField_a_of_type_Afdp.notifyDataSetChanged();
    this.jdField_a_of_type_Beez.postDelayed(new DeviceFragment.1(this), 500L);
  }
  
  public void aq_()
  {
    xrh localxrh = (xrh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localxrh != null)
    {
      if (!localxrh.a()) {
        break label34;
      }
      this.e = true;
      localxrh.e();
    }
    label34:
    while (this.jdField_a_of_type_Afex == null) {
      return;
    }
    this.jdField_a_of_type_Afex.a(b(), true, null);
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
      this.jdField_a_of_type_Afdp = new afdp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afdp);
      this.jdField_a_of_type_Afdp.a(this.c, ajed.z);
      this.jdField_a_of_type_Afdp.a(this.d, ajed.A);
      h();
      this.jdField_a_of_type_Afdp.notifyDataSetChanged();
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_Beez.removeCallbacksAndMessages(null);
      return;
      if (this.jdField_a_of_type_Afdp != null) {
        this.jdField_a_of_type_Afdp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajgs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Xrg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("smart_devices_discovery_config", this);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Afdp != null)
    {
      this.jdField_a_of_type_Afdp.a();
      this.jdField_a_of_type_Afdp.c();
      this.jdField_a_of_type_Afdp = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajgs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Xrg);
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
      if (this.jdField_a_of_type_Afdp != null) {
        this.jdField_a_of_type_Afdp.a(this.f);
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
      if (this.jdField_a_of_type_Afdp == null) {
        break;
      }
      this.jdField_a_of_type_Afdp.a(this.f);
      this.jdField_a_of_type_Afdp.notifyDataSetChanged();
      return false;
      bool1 = false;
      break label36;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment
 * JD-Core Version:    0.7.0.1
 */
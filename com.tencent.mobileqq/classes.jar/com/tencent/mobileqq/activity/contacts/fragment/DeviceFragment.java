package com.tencent.mobileqq.activity.contacts.fragment;

import actn;
import afpl;
import afqu;
import afqw;
import afqx;
import afqy;
import afqz;
import ajsf;
import ajuv;
import ajxl;
import akav;
import amor;
import amos;
import amot;
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
import aoen;
import bfmt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import yaj;
import yak;

public class DeviceFragment
  extends ContactsBaseFragment
  implements amot, Handler.Callback
{
  public afpl a;
  private final ajuv jdField_a_of_type_Ajuv = new afqx(this);
  private final ajxl jdField_a_of_type_Ajxl = new afqy(this);
  private final akav jdField_a_of_type_Akav = new afqw(this);
  private bfmt jdField_a_of_type_Bfmt = new bfmt(Looper.getMainLooper(), this);
  protected XListView a;
  private final yaj jdField_a_of_type_Yaj = new afqz(this);
  public boolean c;
  public boolean d;
  public boolean e;
  protected boolean f = true;
  
  private void i()
  {
    Object localObject1 = (yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (((yak)localObject1).a())
    {
      DeviceInfo[] arrayOfDeviceInfo = ((yak)localObject1).a();
      if (arrayOfDeviceInfo != null)
      {
        ((yak)localObject1).notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
        ThreadManager.post(new DeviceFragment.2(this), 5, null, true);
      }
    }
    try
    {
      localObject1 = getActivity().getApplicationContext().getPackageManager().getPackageInfo(getActivity().getApplicationContext().getPackageName(), 0).packageName;
      aoen.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, 0L);
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
      this.jdField_a_of_type_ComTencentWidgetXListView.setId(2131369608);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, actn.a(54.0F, getResources()));
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
    if (this.jdField_a_of_type_Afpl != null)
    {
      this.jdField_a_of_type_Afpl.a();
      this.jdField_a_of_type_Afpl.c();
    }
    e();
    this.jdField_a_of_type_Bfmt.removeCallbacksAndMessages(null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, amos paramamos)
  {
    if ((paramamos != null) && ("smart_devices_discovery_config".equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceFragment", 2, "handleConfigForTag smartDeviceDiscoverCfg content = " + paramamos.a);
      }
      ThreadManager.post(new DeviceFragment.7(this, paramamos), 5, null, true);
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
    if (this.jdField_a_of_type_Afpl == null)
    {
      this.jdField_a_of_type_Afpl = new afpl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afpl);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    i();
    h();
    this.jdField_a_of_type_Afpl.notifyDataSetChanged();
    this.jdField_a_of_type_Bfmt.postDelayed(new DeviceFragment.1(this), 500L);
  }
  
  public void an_()
  {
    yak localyak = (yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localyak != null)
    {
      if (!localyak.a()) {
        break label34;
      }
      this.e = true;
      localyak.e();
    }
    label34:
    while (this.jdField_a_of_type_Afqu == null) {
      return;
    }
    this.jdField_a_of_type_Afqu.a(b(), true, null);
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
      this.jdField_a_of_type_Afpl = new afpl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afpl);
      this.jdField_a_of_type_Afpl.a(this.c, ajsf.z);
      this.jdField_a_of_type_Afpl.a(this.d, ajsf.A);
      h();
      this.jdField_a_of_type_Afpl.notifyDataSetChanged();
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfmt.removeCallbacksAndMessages(null);
      return;
      if (this.jdField_a_of_type_Afpl != null) {
        this.jdField_a_of_type_Afpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akav);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuv);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Yaj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("smart_devices_discovery_config", this);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Afpl != null)
    {
      this.jdField_a_of_type_Afpl.a();
      this.jdField_a_of_type_Afpl.c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
      this.jdField_a_of_type_Afpl = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akav);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuv);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Yaj);
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
      if (this.jdField_a_of_type_Afpl != null) {
        this.jdField_a_of_type_Afpl.a(this.f);
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
      if (this.jdField_a_of_type_Afpl == null) {
        break;
      }
      this.jdField_a_of_type_Afpl.a(this.f);
      this.jdField_a_of_type_Afpl.notifyDataSetChanged();
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
package com.tencent.mobileqq.activity.contacts.device;

import abgl;
import abgm;
import ajju;
import ajkl;
import ajko;
import ajkp;
import ajkq;
import ajkr;
import ajks;
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
import ansy;
import anvi;
import anyz;
import aocp;
import aqwg;
import aqwh;
import aqwi;
import asll;
import bkyc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;

public class DeviceFragment
  extends ContactsBaseFragment
  implements Handler.Callback, aqwi
{
  private final abgl jdField_a_of_type_Abgl = new ajks(this);
  public ajkl a;
  private final ansy jdField_a_of_type_Ansy = new ajkq(this);
  private final anvi jdField_a_of_type_Anvi = new ajkr(this);
  private final anyz jdField_a_of_type_Anyz = new ajkp(this);
  private aocp jdField_a_of_type_Aocp = new ajko(this);
  private bkyc jdField_a_of_type_Bkyc = new bkyc(Looper.getMainLooper(), this);
  protected XListView a;
  public boolean c;
  public boolean d;
  public boolean e;
  protected boolean f = true;
  
  private void i()
  {
    Object localObject1 = (abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (((abgm)localObject1).a())
    {
      DeviceInfo[] arrayOfDeviceInfo = ((abgm)localObject1).a();
      if (arrayOfDeviceInfo != null)
      {
        ((abgm)localObject1).notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
        ThreadManager.post(new DeviceFragment.3(this), 5, null, true);
      }
    }
    try
    {
      localObject1 = getActivity().getApplicationContext().getPackageManager().getPackageInfo(getActivity().getApplicationContext().getPackageName(), 0).packageName;
      asll.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, 0L);
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
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetXListView.setId(2131370584);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, AIOUtils.dp2px(54.0F, getResources()));
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
    if (this.jdField_a_of_type_Ajkl != null)
    {
      this.jdField_a_of_type_Ajkl.a();
      this.jdField_a_of_type_Ajkl.c();
    }
    e();
    this.jdField_a_of_type_Bkyc.removeCallbacksAndMessages(null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aqwh paramaqwh)
  {
    if ((paramaqwh != null) && ("smart_devices_discovery_config".equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceFragment", 2, "handleConfigForTag smartDeviceDiscoverCfg content = " + paramaqwh.a);
      }
      ThreadManager.post(new DeviceFragment.8(this, paramaqwh), 5, null, true);
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
    if (this.jdField_a_of_type_Ajkl == null)
    {
      this.jdField_a_of_type_Ajkl = new ajkl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajkl);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    i();
    h();
    this.jdField_a_of_type_Ajkl.notifyDataSetChanged();
    this.jdField_a_of_type_Bkyc.postDelayed(new DeviceFragment.2(this), 500L);
  }
  
  public void ah_()
  {
    abgm localabgm = (abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (localabgm != null)
    {
      if (!localabgm.a()) {
        break label35;
      }
      this.e = true;
      localabgm.e();
    }
    label35:
    while (this.jdField_a_of_type_Ajju == null) {
      return;
    }
    this.jdField_a_of_type_Ajju.a(b(), true, null);
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
      this.jdField_a_of_type_Ajkl = new ajkl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajkl);
      this.jdField_a_of_type_Ajkl.a(this.c, AppConstants.DATALINE_PC_UIN);
      this.jdField_a_of_type_Ajkl.a(this.d, AppConstants.DATALINE_IPAD_UIN);
      h();
      this.jdField_a_of_type_Ajkl.notifyDataSetChanged();
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkyc.removeCallbacksAndMessages(null);
      return;
      if (this.jdField_a_of_type_Ajkl != null) {
        this.jdField_a_of_type_Ajkl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ansy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Abgl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocp);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a("smart_devices_discovery_config", this);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ajkl != null)
    {
      this.jdField_a_of_type_Ajkl.a();
      this.jdField_a_of_type_Ajkl.c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
      this.jdField_a_of_type_Ajkl = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ansy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Abgl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocp);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().b("smart_devices_discovery_config", this);
    }
  }
  
  public void h()
  {
    boolean bool = true;
    if (BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "smart_device_discovery_config_file", 0).getInt("smart_device_discovery_config_switch", 1) == 1) {}
    for (;;)
    {
      this.f = bool;
      if (this.jdField_a_of_type_Ajkl != null) {
        this.jdField_a_of_type_Ajkl.a(this.f);
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
      if (this.jdField_a_of_type_Ajkl == null) {
        break;
      }
      this.jdField_a_of_type_Ajkl.a(this.f);
      this.jdField_a_of_type_Ajkl.notifyDataSetChanged();
      return false;
      bool1 = false;
      break label36;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment
 * JD-Core Version:    0.7.0.1
 */
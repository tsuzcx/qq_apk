package com.tencent.mobileqq.activity.contacts.device;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceObserver;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.mobileqq.config.CfgProcess.OnGetConfigListener;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;

public class DeviceFragment
  extends ContactsBaseFragment
  implements Handler.Callback, CfgProcess.OnGetConfigListener
{
  private final SmartDeviceObserver jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver = new DeviceFragment.7(this);
  protected ContactsDeviceAdapter a;
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new DeviceFragment.5(this);
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new DeviceFragment.6(this);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new DeviceFragment.4(this);
  private RegisterProxySvcPackObserver jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver = new DeviceFragment.1(this);
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  protected XListView a;
  protected boolean d;
  protected boolean e;
  protected boolean f = false;
  protected boolean g = true;
  
  private void i()
  {
    Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    boolean bool = ((SmartDeviceProxyMgr)localObject2).a();
    Object localObject1 = null;
    if (bool)
    {
      DeviceInfo[] arrayOfDeviceInfo = ((SmartDeviceProxyMgr)localObject2).a();
      if (arrayOfDeviceInfo != null)
      {
        ((SmartDeviceProxyMgr)localObject2).notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
        ThreadManager.post(new DeviceFragment.3(this), 5, null, true);
      }
    }
    try
    {
      localObject2 = getBaseActivity().getApplicationContext().getPackageManager().getPackageInfo(getBaseActivity().getApplicationContext().getPackageName(), 0).packageName;
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    EquipmentLockImpl.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1, 0L);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    paramLayoutInflater = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (paramLayoutInflater == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetXListView.setId(2131370505);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, AIOUtils.b(54.0F, getResources()));
      this.jdField_a_of_type_ComTencentWidgetXListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setScrollBarStyle(33554432);
      this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
    }
    else
    {
      paramLayoutInflater = paramLayoutInflater.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_ComTencentWidgetXListView);
      }
    }
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DeviceFragment", 2, "doOnDestroy");
    }
    ContactsDeviceAdapter localContactsDeviceAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter;
    if (localContactsDeviceAdapter != null)
    {
      localContactsDeviceAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter.c();
    }
    e();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("contacts.fragment.DeviceFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter = new ContactsDeviceAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter);
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
    i();
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new DeviceFragment.2(this), 500L);
  }
  
  public void ae_()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (localSmartDeviceProxyMgr != null)
    {
      if (localSmartDeviceProxyMgr.a())
      {
        this.f = true;
        localSmartDeviceProxyMgr.e();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener.a(b(), true, null);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause:");
      localStringBuilder.append(paramBoolean);
      QLog.d("contacts.fragment.DeviceFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      e();
    }
  }
  
  public void c()
  {
    if ((this.b) && (this.jdField_a_of_type_ComTencentWidgetXListView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter = new ContactsDeviceAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 104, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter.a(this.d, AppConstants.DATALINE_PC_UIN);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter.a(this.e, AppConstants.DATALINE_IPAD_UIN);
      h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter.notifyDataSetChanged();
      i();
    }
    else
    {
      ContactsDeviceAdapter localContactsDeviceAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter;
      if (localContactsDeviceAdapter != null) {
        localContactsDeviceAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a("smart_devices_discovery_config", this);
    }
  }
  
  protected void e()
  {
    ContactsDeviceAdapter localContactsDeviceAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter;
    if (localContactsDeviceAdapter != null)
    {
      localContactsDeviceAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter.c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().b("smart_devices_discovery_config", this);
    }
  }
  
  public void h()
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("smart_device_discovery_config_file");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    boolean bool = true;
    if (((SharedPreferences)localObject).getInt("smart_device_discovery_config_switch", 1) != 1) {
      bool = false;
    }
    this.g = bool;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter;
    if (localObject != null) {
      ((ContactsDeviceAdapter)localObject).a(this.g);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    boolean bool1;
    if (paramMessage.arg1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = this.g;
    if (bool1 != bool2)
    {
      this.g = (bool2 ^ true);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter;
      if (paramMessage != null)
      {
        paramMessage.a(this.g);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter.notifyDataSetChanged();
      }
    }
    return false;
  }
  
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("smart_devices_discovery_config".equals(paramString)))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleConfigForTag smartDeviceDiscoverCfg content = ");
        paramQQAppInterface.append(paramCfgParseResult.a);
        QLog.d("DeviceFragment", 2, paramQQAppInterface.toString());
      }
      ThreadManager.post(new DeviceFragment.8(this, paramCfgParseResult), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment
 * JD-Core Version:    0.7.0.1
 */
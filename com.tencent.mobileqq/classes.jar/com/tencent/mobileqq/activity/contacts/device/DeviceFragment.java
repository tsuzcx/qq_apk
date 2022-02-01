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
  protected XListView a;
  protected ContactsDeviceAdapter b;
  protected boolean c;
  protected boolean d;
  protected boolean e = false;
  protected boolean f = true;
  private MqqWeakReferenceHandler g = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private RegisterProxySvcPackObserver h = new DeviceFragment.1(this);
  private final MessageObserver i = new DeviceFragment.4(this);
  private final DataLineObserver j = new DeviceFragment.5(this);
  private final FriendListObserver k = new DeviceFragment.6(this);
  private final SmartDeviceObserver l = new DeviceFragment.7(this);
  
  private void k()
  {
    Object localObject2 = (SmartDeviceProxyMgr)this.s.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    boolean bool = ((SmartDeviceProxyMgr)localObject2).c();
    Object localObject1 = null;
    if (bool)
    {
      DeviceInfo[] arrayOfDeviceInfo = ((SmartDeviceProxyMgr)localObject2).e();
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
    EquipmentLockImpl.a().b(this.s, localObject1, 0L);
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    paramLayoutInflater = this.a;
    if (paramLayoutInflater == null)
    {
      this.a = new XListView(this.w);
      this.a.setId(2131437777);
      this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.a.setNeedCheckSpringback(true);
      this.a.setCacheColorHint(0);
      this.a.setDivider(null);
      this.a.setOverScrollMode(0);
      this.a.setPadding(0, 0, 0, AIOUtils.b(54.0F, getResources()));
      this.a.setClipToPadding(false);
      this.a.setScrollBarStyle(33554432);
      this.a.mForContacts = true;
    }
    else
    {
      paramLayoutInflater = paramLayoutInflater.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.a);
      }
    }
    return this.a;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DeviceFragment", 2, "doOnDestroy");
    }
    ContactsDeviceAdapter localContactsDeviceAdapter = this.b;
    if (localContactsDeviceAdapter != null)
    {
      localContactsDeviceAdapter.a();
      this.b.c();
    }
    e();
    this.g.removeCallbacksAndMessages(null);
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
    if (this.a == null) {
      return;
    }
    d();
    if (this.b == null)
    {
      this.b = new ContactsDeviceAdapter(this.w, this.s, this.a, 104, true);
      this.a.setAdapter(this.b);
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
    k();
    j();
    this.b.notifyDataSetChanged();
    this.g.postDelayed(new DeviceFragment.2(this), 500L);
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
  
  public void bU_()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.s.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (localSmartDeviceProxyMgr != null)
    {
      if (localSmartDeviceProxyMgr.c())
      {
        this.e = true;
        localSmartDeviceProxyMgr.h();
        return;
      }
      if (this.q != null) {
        this.q.a(i(), true, null);
      }
    }
  }
  
  public void c()
  {
    if ((this.v) && (this.a != null))
    {
      this.b = new ContactsDeviceAdapter(this.w, this.s, this.a, 104, true);
      this.a.setAdapter(this.b);
      this.b.a(this.c, AppConstants.DATALINE_PC_UIN);
      this.b.a(this.d, AppConstants.DATALINE_IPAD_UIN);
      j();
      this.b.notifyDataSetChanged();
      k();
    }
    else
    {
      ContactsDeviceAdapter localContactsDeviceAdapter = this.b;
      if (localContactsDeviceAdapter != null) {
        localContactsDeviceAdapter.a(this.s);
      }
    }
    this.g.removeCallbacksAndMessages(null);
  }
  
  protected void d()
  {
    if ((this.s != null) && (this.v))
    {
      this.s.addObserver(this.i);
      this.s.addObserver(this.j);
      this.s.addObserver(this.k);
      this.s.addObserver(this.l);
      this.s.addObserver(this.h);
      this.s.getConfigProcess().a("smart_devices_discovery_config", this);
    }
  }
  
  protected void e()
  {
    ContactsDeviceAdapter localContactsDeviceAdapter = this.b;
    if (localContactsDeviceAdapter != null)
    {
      localContactsDeviceAdapter.a();
      this.b.c();
      this.a.setAdapter(null);
      this.b = null;
    }
    if (this.s != null)
    {
      this.s.removeObserver(this.i);
      this.s.removeObserver(this.j);
      this.s.removeObserver(this.k);
      this.s.removeObserver(this.l);
      this.s.removeObserver(this.h);
      this.s.getConfigProcess().b("smart_devices_discovery_config", this);
    }
  }
  
  public View getScrollableView()
  {
    return this.a;
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
    boolean bool2 = this.f;
    if (bool1 != bool2)
    {
      this.f = (bool2 ^ true);
      paramMessage = this.b;
      if (paramMessage != null)
      {
        paramMessage.a(this.f);
        this.b.notifyDataSetChanged();
      }
    }
    return false;
  }
  
  public void j()
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.s.getCurrentAccountUin());
    localStringBuilder.append("smart_device_discovery_config_file");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    boolean bool = true;
    if (((SharedPreferences)localObject).getInt("smart_device_discovery_config_switch", 1) != 1) {
      bool = false;
    }
    this.f = bool;
    localObject = this.b;
    if (localObject != null) {
      ((ContactsDeviceAdapter)localObject).a(this.f);
    }
  }
  
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("smart_devices_discovery_config".equals(paramString)))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleConfigForTag smartDeviceDiscoverCfg content = ");
        paramQQAppInterface.append(paramCfgParseResult.d);
        QLog.d("DeviceFragment", 2, paramQQAppInterface.toString());
      }
      ThreadManager.post(new DeviceFragment.8(this, paramCfgParseResult), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment
 * JD-Core Version:    0.7.0.1
 */
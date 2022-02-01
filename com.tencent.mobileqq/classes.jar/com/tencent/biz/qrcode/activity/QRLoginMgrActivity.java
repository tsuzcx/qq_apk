package com.tencent.biz.qrcode.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter;
import com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter.OnDeviceItemClickListener;
import com.tencent.biz.qrcode.logindev.LoginDevItem;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager.IDevListRefreshListener;
import com.tencent.biz.qrcode.logindev.LoginDevicesUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.DeviceManageConfBean;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, LoginDevInfoAdapter.OnDeviceItemClickListener
{
  private TextView a;
  private TextView b;
  private ImageView c;
  private ListView d;
  private Switch e;
  private MqqHandler f = ThreadManager.getUIHandler();
  private ConcurrentHashMap<Long, LoginDevItem> g = null;
  private Set<Long> h = null;
  private LoginDevInfoAdapter i;
  private QQProgressDialog j;
  private LoginDevicesManager k;
  private Context l;
  private String m;
  private long n;
  private CompoundButton.OnCheckedChangeListener o = new QRLoginMgrActivity.1(this);
  private LoginDevicesManager.IDevListRefreshListener p = new QRLoginMgrActivity.6(this);
  private FriendListObserver q = new QRLoginMgrActivity.7(this);
  
  private void a(int paramInt)
  {
    this.f.post(new QRLoginMgrActivity.4(this, paramInt));
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    a(1);
    Object localObject1 = this.h;
    if (localObject1 != null)
    {
      ((Set)localObject1).clear();
      this.h = null;
    }
    if (this.g == null) {
      this.g = new ConcurrentHashMap();
    }
    this.g.clear();
    localObject1 = this.i.a().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LoginDevItem)((Iterator)localObject1).next();
      this.g.put(Long.valueOf(((LoginDevItem)localObject2).a), localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "confirmQRLogout allLogout:", Boolean.valueOf(paramBoolean), " appid:", Long.valueOf(paramLong), " size:", Integer.valueOf(this.g.size()) });
    }
    if (paramBoolean)
    {
      localObject1 = this.g.keySet().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Long)((Iterator)localObject1).next();
      } while (EquipmentLockImpl.a().a(this.app, ((Long)localObject2).longValue(), (byte)0, new byte[0], 101));
      d();
      QQToast.makeText(getApplicationContext(), 1, 2131914134, 0).show();
      return;
    }
    if (!EquipmentLockImpl.a().a(this.app, paramLong, (byte)0, new byte[0], 100))
    {
      d();
      QQToast.makeText(getApplicationContext(), 1, 2131914134, 0).show();
    }
  }
  
  private void b()
  {
    this.d = ((ListView)findViewById(2131431825));
    this.i = new LoginDevInfoAdapter();
    this.i.a(this);
    View localView = LayoutInflater.from(this).inflate(2131626486, null);
    this.e = ((Switch)localView.findViewById(2131439078));
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);
    this.e.setChecked(bool);
    this.e.setOnCheckedChangeListener(this.o);
    this.d.addFooterView(localView);
    this.d.setAdapter(this.i);
    if (((DeviceManageConfBean)QConfigManager.b().b(528)).a == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.k = ((LoginDevicesManager)this.app.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER));
    this.k.a(this.p);
  }
  
  private void d()
  {
    this.f.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(LoginDevItem paramLoginDevItem)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByQRLogin(this, "qrlogin_appid", paramLoginDevItem.a, 2);
    ReportController.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramLoginDevItem.d, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131626484);
    super.setTitle(2131914147);
    this.b = ((TextView)findViewById(2131439298));
    this.c = ((ImageView)findViewById(2131432718));
    this.a = ((TextView)findViewById(2131439561));
    this.a.setOnClickListener(this);
    b();
  }
  
  public void a(LoginDevItem paramLoginDevItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramLoginDevItem.b) });
    }
    Intent localIntent;
    if (LoginDevicesUtils.a(paramLoginDevItem.b))
    {
      if (QFileAssistantUtils.a(this.app))
      {
        QFileAssistantUtils.a(this);
      }
      else
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
    }
    else if (LoginDevicesUtils.b(paramLoginDevItem.b))
    {
      if (QFileAssistantUtils.a(this.app))
      {
        QFileAssistantUtils.a(this);
      }
      else
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
    }
    else if (LoginDevicesUtils.c(paramLoginDevItem.b)) {
      QQToast.makeText(getApplicationContext(), getString(2131914154), 0).show(getTitleBarHeight());
    }
    ReportController.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramLoginDevItem.d, 0, "", "", "", "");
  }
  
  public void b(LoginDevItem paramLoginDevItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramLoginDevItem.b) });
    }
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.makeText(this.l, 1, 2131893879, 0).show(getTitleBarHeight());
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(getString(2131914132, new Object[] { paramLoginDevItem.e, paramLoginDevItem.f }));
    localQQCustomDialog.setPositiveButton(2131914157, new QRLoginMgrActivity.8(this, paramLoginDevItem));
    localQQCustomDialog.setNegativeButton(2131887648, new QRLoginMgrActivity.9(this));
    localQQCustomDialog.show();
    ReportController.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramLoginDevItem.d, 0, "", "", "", "");
  }
  
  public void c(LoginDevItem paramLoginDevItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramLoginDevItem.b) });
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (LoginDevicesUtils.a(paramLoginDevItem.b))
    {
      localDataLineHandler.b = AppConstants.DATALINE_PC_UIN;
      localDataLineHandler.c = 0;
    }
    else if (LoginDevicesUtils.b(paramLoginDevItem.b))
    {
      localDataLineHandler.b = AppConstants.DATALINE_IPAD_UIN;
      localDataLineHandler.c = 1;
    }
    if (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new QRLoginMgrActivity.10(this, paramLoginDevItem));
      return;
    }
    d(paramLoginDevItem);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      long l1 = paramIntent.getLongExtra("qrlogin_appid", -1L);
      if (l1 == -1L)
      {
        QLog.w("QRLoginMgrActivity", 1, "appid is -1 !");
        return;
      }
      paramIntent = this.i.a().iterator();
      while (paramIntent.hasNext())
      {
        LoginDevItem localLoginDevItem = (LoginDevItem)paramIntent.next();
        if (localLoginDevItem.a == l1) {
          a(localLoginDevItem);
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (this.app == null)
    {
      super.finish();
      return true;
    }
    this.l = this;
    this.m = getIntent().getStringExtra("qrlogin_position");
    this.n = getIntent().getLongExtra("qrlogin_appid", -1L);
    paramBundle = this.app.getCurrentAccountUin();
    this.b.setText(ContactUtils.f(this.app, paramBundle));
    paramBundle = FaceDrawable.getUserFaceDrawable(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.c.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.q);
    ReportController.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.q);
    this.f.removeCallbacksAndMessages(null);
    LoginDevicesManager localLoginDevicesManager = this.k;
    if (localLoginDevicesManager != null) {
      localLoginDevicesManager.b(this.p);
    }
    this.l = null;
    this.g = null;
    this.h = null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131439561) {
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.makeText(this.l, 1, 2131893879, 0).show(getTitleBarHeight());
      }
      else
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
        localQQCustomDialog.setTitle(2131914123);
        LoginDevicesManager localLoginDevicesManager = this.k;
        if (localLoginDevicesManager != null) {
          localQQCustomDialog.setMessage(localLoginDevicesManager.a(this.l));
        } else {
          localQQCustomDialog.setMessage(2131914124);
        }
        localQQCustomDialog.setPositiveButton(2131914157, new QRLoginMgrActivity.2(this));
        localQQCustomDialog.setNegativeButton(2131887648, new QRLoginMgrActivity.3(this));
        localQQCustomDialog.show();
        ReportController.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity
 * JD-Core Version:    0.7.0.1
 */
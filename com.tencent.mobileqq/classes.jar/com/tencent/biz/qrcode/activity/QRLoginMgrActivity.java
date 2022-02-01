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
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new QRLoginMgrActivity.1(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LoginDevInfoAdapter jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter;
  private LoginDevicesManager.IDevListRefreshListener jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager$IDevListRefreshListener = new QRLoginMgrActivity.6(this);
  private LoginDevicesManager jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QRLoginMgrActivity.7(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet = null;
  private ConcurrentHashMap<Long, LoginDevItem> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private TextView b;
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.4(this, paramInt));
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    a(1);
    Object localObject1 = this.jdField_a_of_type_JavaUtilSet;
    if (localObject1 != null)
    {
      ((Set)localObject1).clear();
      this.jdField_a_of_type_JavaUtilSet = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    localObject1 = this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter.a().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LoginDevItem)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((LoginDevItem)localObject2).jdField_a_of_type_Long), localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "confirmQRLogout allLogout:", Boolean.valueOf(paramBoolean), " appid:", Long.valueOf(paramLong), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
    }
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Long)((Iterator)localObject1).next();
      } while (EquipmentLockImpl.a().a(this.app, ((Long)localObject2).longValue(), (byte)0, new byte[0], 101));
      d();
      QQToast.a(getApplicationContext(), 1, 2131716670, 0).a();
      return;
    }
    if (!EquipmentLockImpl.a().a(this.app, paramLong, (byte)0, new byte[0], 100))
    {
      d();
      QQToast.a(getApplicationContext(), 1, 2131716670, 0).a();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131365598));
    this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter = new LoginDevInfoAdapter();
    this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560441, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131371657));
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter);
    if (((DeviceManageConfBean)QConfigManager.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager = ((LoginDevicesManager)this.app.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER));
    this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager.a(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager$IDevListRefreshListener);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(LoginDevItem paramLoginDevItem)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByQRLogin(this, "qrlogin_appid", paramLoginDevItem.jdField_a_of_type_Long, 2);
    ReportController.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramLoginDevItem.c, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131560439);
    super.setTitle(2131716683);
    this.b = ((TextView)findViewById(2131371857));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366405));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372093));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(LoginDevItem paramLoginDevItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramLoginDevItem.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (LoginDevicesUtils.a(paramLoginDevItem.jdField_a_of_type_Int))
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
    else if (LoginDevicesUtils.b(paramLoginDevItem.jdField_a_of_type_Int))
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
    else if (LoginDevicesUtils.c(paramLoginDevItem.jdField_a_of_type_Int)) {
      QQToast.a(getApplicationContext(), getString(2131716690), 0).b(getTitleBarHeight());
    }
    ReportController.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramLoginDevItem.c, 0, "", "", "", "");
  }
  
  public void b(LoginDevItem paramLoginDevItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramLoginDevItem.jdField_a_of_type_Int) });
    }
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696114, 0).b(getTitleBarHeight());
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(getString(2131716668, new Object[] { paramLoginDevItem.jdField_a_of_type_JavaLangString, paramLoginDevItem.b }));
    localQQCustomDialog.setPositiveButton(2131716693, new QRLoginMgrActivity.8(this, paramLoginDevItem));
    localQQCustomDialog.setNegativeButton(2131690728, new QRLoginMgrActivity.9(this));
    localQQCustomDialog.show();
    ReportController.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramLoginDevItem.c, 0, "", "", "", "");
  }
  
  public void c(LoginDevItem paramLoginDevItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramLoginDevItem.jdField_a_of_type_Int) });
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (LoginDevicesUtils.a(paramLoginDevItem.jdField_a_of_type_Int))
    {
      localDataLineHandler.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
      localDataLineHandler.jdField_a_of_type_Int = 0;
    }
    else if (LoginDevicesUtils.b(paramLoginDevItem.jdField_a_of_type_Int))
    {
      localDataLineHandler.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_IPAD_UIN;
      localDataLineHandler.jdField_a_of_type_Int = 1;
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
      long l = paramIntent.getLongExtra("qrlogin_appid", -1L);
      if (l == -1L)
      {
        QLog.w("QRLoginMgrActivity", 1, "appid is -1 !");
        return;
      }
      paramIntent = this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter.a().iterator();
      while (paramIntent.hasNext())
      {
        LoginDevItem localLoginDevItem = (LoginDevItem)paramIntent.next();
        if (localLoginDevItem.jdField_a_of_type_Long == l) {
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
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("qrlogin_position");
    this.jdField_a_of_type_Long = getIntent().getLongExtra("qrlogin_appid", -1L);
    paramBundle = this.app.getCurrentAccountUin();
    this.b.setText(ContactUtils.e(this.app, paramBundle));
    paramBundle = FaceDrawable.getUserFaceDrawable(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    ReportController.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    LoginDevicesManager localLoginDevicesManager = this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager;
    if (localLoginDevicesManager != null) {
      localLoginDevicesManager.b(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager$IDevListRefreshListener);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    this.jdField_a_of_type_JavaUtilSet = null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131372093) {
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696114, 0).b(getTitleBarHeight());
      }
      else
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
        localQQCustomDialog.setTitle(2131716660);
        LoginDevicesManager localLoginDevicesManager = this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager;
        if (localLoginDevicesManager != null) {
          localQQCustomDialog.setMessage(localLoginDevicesManager.a(this.jdField_a_of_type_AndroidContentContext));
        } else {
          localQQCustomDialog.setMessage(2131716661);
        }
        localQQCustomDialog.setPositiveButton(2131716693, new QRLoginMgrActivity.2(this));
        localQQCustomDialog.setNegativeButton(2131690728, new QRLoginMgrActivity.3(this));
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
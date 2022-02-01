package com.tencent.biz.qrcode.activity;

import Override;
import amqd;
import amsu;
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
import apub;
import apxf;
import arhf;
import bcef;
import bfur;
import bhht;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import yws;
import ywv;
import yww;
import ywx;
import ywy;
import ywz;
import yxa;
import yxb;
import yxw;
import yya;
import yyc;
import yyd;
import yyf;
import yyg;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, yya
{
  private long jdField_a_of_type_Long;
  private amsu jdField_a_of_type_Amsu = new ywz(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new yws(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhht jdField_a_of_type_Bhht;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<Long, yyc> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private yxw jdField_a_of_type_Yxw;
  private yyd jdField_a_of_type_Yyd;
  private yyf jdField_a_of_type_Yyf = new ywy(this);
  private TextView b;
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.4(this, paramInt));
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    a(1);
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      this.jdField_a_of_type_JavaUtilSet = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_Yxw.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (yyc)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((yyc)localObject).jdField_a_of_type_Long), localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "confirmQRLogout allLogout:", Boolean.valueOf(paramBoolean), " appid:", Long.valueOf(paramLong), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
    }
    if (paramBoolean)
    {
      localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Long)localIterator.next();
        if (!arhf.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          d();
          QQToast.a(getApplicationContext(), 1, 2131716166, 0).a();
        }
      }
    }
    while (arhf.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    d();
    QQToast.a(getApplicationContext(), 1, 2131716166, 0).a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131365507));
    this.jdField_a_of_type_Yxw = new yxw();
    this.jdField_a_of_type_Yxw.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560415, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131371559));
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Yxw);
    if (((apxf)apub.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Yyd = ((yyd)this.app.getManager(335));
    this.jdField_a_of_type_Yyd.a(this.jdField_a_of_type_Yyf);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(yyc paramyyc)
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qrlogin_appid", paramyyc.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 2);
    bcef.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramyyc.c, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131560413);
    super.setTitle(2131716178);
    this.b = ((TextView)findViewById(2131371772));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366245));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372015));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(yyc paramyyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramyyc.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (yyg.a(paramyyc.jdField_a_of_type_Int))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramyyc.c, 0, "", "", "", "");
      return;
      if (yyg.b(paramyyc.jdField_a_of_type_Int))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (yyg.c(paramyyc.jdField_a_of_type_Int))
      {
        QQToast.a(getApplicationContext(), getString(2131716185), 0).b(getTitleBarHeight());
      }
    }
  }
  
  public void b(yyc paramyyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramyyc.jdField_a_of_type_Int) });
    }
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695597, 0).b(getTitleBarHeight());
      return;
    }
    QQCustomDialog localQQCustomDialog = bfur.a(this, 230);
    localQQCustomDialog.setMessage(getString(2131716164, new Object[] { paramyyc.jdField_a_of_type_JavaLangString, paramyyc.b }));
    localQQCustomDialog.setPositiveButton(2131716188, new yxa(this, paramyyc));
    localQQCustomDialog.setNegativeButton(2131690620, new yxb(this));
    localQQCustomDialog.show();
    bcef.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramyyc.c, 0, "", "", "", "");
  }
  
  public void c(yyc paramyyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramyyc.jdField_a_of_type_Int) });
    }
    amqd localamqd = (amqd)this.app.getBusinessHandler(8);
    if (yyg.a(paramyyc.jdField_a_of_type_Int))
    {
      localamqd.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
      localamqd.jdField_a_of_type_Int = 0;
    }
    while (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new ywv(this, paramyyc));
      return;
      if (yyg.b(paramyyc.jdField_a_of_type_Int))
      {
        localamqd.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_IPAD_UIN;
        localamqd.jdField_a_of_type_Int = 1;
      }
    }
    d(paramyyc);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    long l;
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      l = paramIntent.getLongExtra("qrlogin_appid", -1L);
      if (l != -1L) {
        break label48;
      }
      QLog.w("QRLoginMgrActivity", 1, "appid is -1 !");
    }
    label48:
    yyc localyyc;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Yxw.a().iterator();
      }
      localyyc = (yyc)paramIntent.next();
    } while (localyyc.jdField_a_of_type_Long != l);
    a(localyyc);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
    this.b.setText(ContactUtils.getAccountNickName(this.app, paramBundle));
    paramBundle = FaceDrawable.getUserFaceDrawable(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_Amsu);
    bcef.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Yyd != null) {
      this.jdField_a_of_type_Yyd.b(this.jdField_a_of_type_Yyf);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    this.jdField_a_of_type_JavaUtilSet = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.isNetworkAvailable(this)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695597, 0).b(getTitleBarHeight());
    }
    QQCustomDialog localQQCustomDialog = bfur.a(this, 230);
    localQQCustomDialog.setTitle(2131716156);
    if (this.jdField_a_of_type_Yyd != null) {
      localQQCustomDialog.setMessage(this.jdField_a_of_type_Yyd.a(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      localQQCustomDialog.setPositiveButton(2131716188, new yww(this));
      localQQCustomDialog.setNegativeButton(2131690620, new ywx(this));
      localQQCustomDialog.show();
      bcef.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      break;
      localQQCustomDialog.setMessage(2131716157);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qrcode.activity;

import Override;
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
import anhk;
import anjx;
import anmu;
import aoch;
import aqlk;
import aqoh;
import asfr;
import bcst;
import bglf;
import bglp;
import bgnt;
import bgpa;
import biau;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
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
import ztm;
import ztp;
import ztq;
import ztr;
import zts;
import ztt;
import ztu;
import ztv;
import zuq;
import zuu;
import zuw;
import zux;
import zuz;
import zva;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, zuu
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ztm(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anmu jdField_a_of_type_Anmu = new ztt(this);
  private biau jdField_a_of_type_Biau;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<Long, zuw> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private zuq jdField_a_of_type_Zuq;
  private zux jdField_a_of_type_Zux;
  private zuz jdField_a_of_type_Zuz = new zts(this);
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
    Iterator localIterator = this.jdField_a_of_type_Zuq.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (zuw)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((zuw)localObject).jdField_a_of_type_Long), localObject);
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
        if (!asfr.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          d();
          QQToast.a(getApplicationContext(), 1, 2131715823, 0).a();
        }
      }
    }
    while (asfr.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    d();
    QQToast.a(getApplicationContext(), 1, 2131715823, 0).a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131365431));
    this.jdField_a_of_type_Zuq = new zuq();
    this.jdField_a_of_type_Zuq.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560390, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131371483));
    boolean bool = SettingCloneUtil.readValue(this, this.app.c(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Zuq);
    if (((aqoh)aqlk.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Zux = ((zux)this.app.getManager(335));
    this.jdField_a_of_type_Zux.a(this.jdField_a_of_type_Zuz);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(zuw paramzuw)
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", anhk.z);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qrlogin_appid", paramzuw.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 2);
    bcst.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramzuw.c, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131560388);
    super.setTitle(2131715835);
    this.b = ((TextView)findViewById(2131371700));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366168));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371936));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(zuw paramzuw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramzuw.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (zva.a(paramzuw.jdField_a_of_type_Int))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", anhk.z);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramzuw.c, 0, "", "", "", "");
      return;
      if (zva.b(paramzuw.jdField_a_of_type_Int))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", anhk.A);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (zva.c(paramzuw.jdField_a_of_type_Int))
      {
        QQToast.a(getApplicationContext(), getString(2131715842), 0).b(getTitleBarHeight());
      }
    }
  }
  
  public void b(zuw paramzuw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramzuw.jdField_a_of_type_Int) });
    }
    if (!bgnt.g(this))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695415, 0).b(getTitleBarHeight());
      return;
    }
    bgpa localbgpa = bglp.a(this, 230);
    localbgpa.setMessage(getString(2131715821, new Object[] { paramzuw.jdField_a_of_type_JavaLangString, paramzuw.b }));
    localbgpa.setPositiveButton(2131715845, new ztu(this, paramzuw));
    localbgpa.setNegativeButton(2131690582, new ztv(this));
    localbgpa.show();
    bcst.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramzuw.c, 0, "", "", "", "");
  }
  
  public void c(zuw paramzuw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramzuw.jdField_a_of_type_Int) });
    }
    anjx localanjx = (anjx)this.app.a(8);
    if (zva.a(paramzuw.jdField_a_of_type_Int))
    {
      localanjx.jdField_a_of_type_JavaLangString = anhk.z;
      localanjx.jdField_a_of_type_Int = 0;
    }
    while (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new ztp(this, paramzuw));
      return;
      if (zva.b(paramzuw.jdField_a_of_type_Int))
      {
        localanjx.jdField_a_of_type_JavaLangString = anhk.A;
        localanjx.jdField_a_of_type_Int = 1;
      }
    }
    d(paramzuw);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
    zuw localzuw;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Zuq.a().iterator();
      }
      localzuw = (zuw)paramIntent.next();
    } while (localzuw.jdField_a_of_type_Long != l);
    a(localzuw);
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
    this.b.setText(bglf.h(this.app, paramBundle));
    paramBundle = aoch.a(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_Anmu);
    bcst.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_Anmu);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Zux != null) {
      this.jdField_a_of_type_Zux.b(this.jdField_a_of_type_Zuz);
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
      if (bgnt.g(this)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695415, 0).b(getTitleBarHeight());
    }
    bgpa localbgpa = bglp.a(this, 230);
    localbgpa.setTitle(2131715813);
    if (this.jdField_a_of_type_Zux != null) {
      localbgpa.setMessage(this.jdField_a_of_type_Zux.a(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      localbgpa.setPositiveButton(2131715845, new ztq(this));
      localbgpa.setNegativeButton(2131690582, new ztr(this));
      localbgpa.show();
      bcst.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      break;
      localbgpa.setMessage(2131715814);
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
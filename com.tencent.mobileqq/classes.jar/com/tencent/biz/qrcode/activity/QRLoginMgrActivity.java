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
import antf;
import anvu;
import anyu;
import aoot;
import aran;
import ardp;
import asvf;
import bdll;
import bhlg;
import bhlq;
import bhnv;
import bhpc;
import bjbs;
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
import zxh;
import zxk;
import zxl;
import zxm;
import zxn;
import zxo;
import zxp;
import zxq;
import zyl;
import zyp;
import zyr;
import zys;
import zyu;
import zyv;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, zyp
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new zxh(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anyu jdField_a_of_type_Anyu = new zxo(this);
  private bjbs jdField_a_of_type_Bjbs;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<Long, zyr> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private zyl jdField_a_of_type_Zyl;
  private zys jdField_a_of_type_Zys;
  private zyu jdField_a_of_type_Zyu = new zxn(this);
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
    Iterator localIterator = this.jdField_a_of_type_Zyl.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (zyr)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((zyr)localObject).jdField_a_of_type_Long), localObject);
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
        if (!asvf.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          d();
          QQToast.a(getApplicationContext(), 1, 2131715932, 0).a();
        }
      }
    }
    while (asvf.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    d();
    QQToast.a(getApplicationContext(), 1, 2131715932, 0).a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131365475));
    this.jdField_a_of_type_Zyl = new zyl();
    this.jdField_a_of_type_Zyl.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560405, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131371591));
    boolean bool = SettingCloneUtil.readValue(this, this.app.c(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Zyl);
    if (((ardp)aran.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Zys = ((zys)this.app.getManager(335));
    this.jdField_a_of_type_Zys.a(this.jdField_a_of_type_Zyu);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(zyr paramzyr)
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", antf.z);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qrlogin_appid", paramzyr.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 2);
    bdll.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramzyr.c, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131560403);
    super.setTitle(2131715944);
    this.b = ((TextView)findViewById(2131371808));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366217));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372050));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(zyr paramzyr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramzyr.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (zyv.a(paramzyr.jdField_a_of_type_Int))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", antf.z);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramzyr.c, 0, "", "", "", "");
      return;
      if (zyv.b(paramzyr.jdField_a_of_type_Int))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", antf.A);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (zyv.c(paramzyr.jdField_a_of_type_Int))
      {
        QQToast.a(getApplicationContext(), getString(2131715951), 0).b(getTitleBarHeight());
      }
    }
  }
  
  public void b(zyr paramzyr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramzyr.jdField_a_of_type_Int) });
    }
    if (!bhnv.g(this))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695458, 0).b(getTitleBarHeight());
      return;
    }
    bhpc localbhpc = bhlq.a(this, 230);
    localbhpc.setMessage(getString(2131715930, new Object[] { paramzyr.jdField_a_of_type_JavaLangString, paramzyr.b }));
    localbhpc.setPositiveButton(2131715954, new zxp(this, paramzyr));
    localbhpc.setNegativeButton(2131690580, new zxq(this));
    localbhpc.show();
    bdll.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramzyr.c, 0, "", "", "", "");
  }
  
  public void c(zyr paramzyr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramzyr.jdField_a_of_type_Int) });
    }
    anvu localanvu = (anvu)this.app.a(8);
    if (zyv.a(paramzyr.jdField_a_of_type_Int))
    {
      localanvu.jdField_a_of_type_JavaLangString = antf.z;
      localanvu.jdField_a_of_type_Int = 0;
    }
    while (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new zxk(this, paramzyr));
      return;
      if (zyv.b(paramzyr.jdField_a_of_type_Int))
      {
        localanvu.jdField_a_of_type_JavaLangString = antf.A;
        localanvu.jdField_a_of_type_Int = 1;
      }
    }
    d(paramzyr);
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
    zyr localzyr;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Zyl.a().iterator();
      }
      localzyr = (zyr)paramIntent.next();
    } while (localzyr.jdField_a_of_type_Long != l);
    a(localzyr);
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
    this.b.setText(bhlg.h(this.app, paramBundle));
    paramBundle = aoot.a(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_Anyu);
    bdll.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Zys != null) {
      this.jdField_a_of_type_Zys.b(this.jdField_a_of_type_Zyu);
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
      if (bhnv.g(this)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695458, 0).b(getTitleBarHeight());
    }
    bhpc localbhpc = bhlq.a(this, 230);
    localbhpc.setTitle(2131715922);
    if (this.jdField_a_of_type_Zys != null) {
      localbhpc.setMessage(this.jdField_a_of_type_Zys.a(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      localbhpc.setPositiveButton(2131715954, new zxl(this));
      localbhpc.setNegativeButton(2131690580, new zxm(this));
      localbhpc.show();
      bdll.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      break;
      localbhpc.setMessage(2131715923);
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
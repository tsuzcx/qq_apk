package com.tencent.biz.qrcode.activity;

import aljq;
import allz;
import alox;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import aogj;
import aoiy;
import apwu;
import azmj;
import bcxb;
import bdbt;
import bdcd;
import bdee;
import bdfq;
import bepp;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import xvl;
import xvo;
import xvp;
import xvq;
import xvr;
import xvs;
import xvt;
import xvu;
import xwp;
import xwt;
import xwv;
import xww;
import xwy;
import xwz;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, xwt
{
  private long jdField_a_of_type_Long;
  private alox jdField_a_of_type_Alox = new xvs(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new xvl(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bepp jdField_a_of_type_Bepp;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<Long, xwv> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private xwp jdField_a_of_type_Xwp;
  private xww jdField_a_of_type_Xww;
  private xwy jdField_a_of_type_Xwy = new xvr(this);
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
    Iterator localIterator = this.jdField_a_of_type_Xwp.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (xwv)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((xwv)localObject).jdField_a_of_type_Long), localObject);
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
        if (!apwu.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          d();
          QQToast.a(getApplicationContext(), 1, 2131717586, 0).a();
        }
      }
    }
    while (apwu.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    d();
    QQToast.a(getApplicationContext(), 1, 2131717586, 0).a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131365188));
    this.jdField_a_of_type_Xwp = new xwp();
    this.jdField_a_of_type_Xwp.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560239, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131370899));
    boolean bool = SettingCloneUtil.readValue(this, this.app.c(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Xwp);
    if (((aoiy)aogj.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Xww = ((xww)this.app.getManager(335));
    this.jdField_a_of_type_Xww.a(this.jdField_a_of_type_Xwy);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(xwv paramxwv)
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", aljq.z);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qrlogin_appid", paramxwv.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 2);
    azmj.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramxwv.c, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131560237);
    super.setTitle(2131717598);
    this.b = ((TextView)findViewById(2131371123));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365914));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371349));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(xwv paramxwv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramxwv.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (xwz.a(paramxwv.jdField_a_of_type_Int))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", aljq.z);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramxwv.c, 0, "", "", "", "");
      return;
      if (xwz.b(paramxwv.jdField_a_of_type_Int))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", aljq.A);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (xwz.c(paramxwv.jdField_a_of_type_Int))
      {
        QQToast.a(getApplicationContext(), getString(2131717605), 0).b(getTitleBarHeight());
      }
    }
  }
  
  public void b(xwv paramxwv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramxwv.jdField_a_of_type_Int) });
    }
    if (!bdee.g(this))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696588, 0).b(getTitleBarHeight());
      return;
    }
    bdfq localbdfq = bdcd.a(this, 230);
    localbdfq.setMessage(getString(2131717584, new Object[] { paramxwv.jdField_a_of_type_JavaLangString, paramxwv.b }));
    localbdfq.setPositiveButton(2131717608, new xvt(this, paramxwv));
    localbdfq.setNegativeButton(2131690648, new xvu(this));
    localbdfq.show();
    azmj.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramxwv.c, 0, "", "", "", "");
  }
  
  public void c(xwv paramxwv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramxwv.jdField_a_of_type_Int) });
    }
    allz localallz = (allz)this.app.a(8);
    if (xwz.a(paramxwv.jdField_a_of_type_Int))
    {
      localallz.jdField_a_of_type_JavaLangString = aljq.z;
      localallz.jdField_a_of_type_Int = 0;
    }
    while (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new xvo(this, paramxwv));
      return;
      if (xwz.b(paramxwv.jdField_a_of_type_Int))
      {
        localallz.jdField_a_of_type_JavaLangString = aljq.A;
        localallz.jdField_a_of_type_Int = 1;
      }
    }
    d(paramxwv);
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
    xwv localxwv;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Xwp.a().iterator();
      }
      localxwv = (xwv)paramIntent.next();
    } while (localxwv.jdField_a_of_type_Long != l);
    a(localxwv);
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
    this.b.setText(bdbt.h(this.app, paramBundle));
    paramBundle = bcxb.a(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_Alox);
    azmj.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Xww != null) {
      this.jdField_a_of_type_Xww.b(this.jdField_a_of_type_Xwy);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    this.jdField_a_of_type_JavaUtilSet = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (!bdee.g(this))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696588, 0).b(getTitleBarHeight());
      return;
    }
    paramView = bdcd.a(this, 230);
    paramView.setTitle(2131717576);
    if (this.jdField_a_of_type_Xww != null) {
      paramView.setMessage(this.jdField_a_of_type_Xww.a(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      paramView.setPositiveButton(2131717608, new xvp(this));
      paramView.setNegativeButton(2131690648, new xvq(this));
      paramView.show();
      azmj.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      return;
      paramView.setMessage(2131717577);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity
 * JD-Core Version:    0.7.0.1
 */
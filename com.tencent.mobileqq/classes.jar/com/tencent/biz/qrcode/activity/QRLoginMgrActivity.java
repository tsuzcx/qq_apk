package com.tencent.biz.qrcode.activity;

import ajsd;
import ajum;
import ajxj;
import ampl;
import amsa;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import aoes;
import axqy;
import bayh;
import bbcz;
import bbdj;
import bbfj;
import bbgu;
import bcqf;
import bcql;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import wgt;
import wgw;
import wgx;
import wgy;
import wgz;
import wha;
import whb;
import whc;
import whx;
import wib;
import wid;
import wie;
import wig;
import wih;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, wib
{
  private long jdField_a_of_type_Long;
  private ajxj jdField_a_of_type_Ajxj = new wha(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new wgt(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcqf jdField_a_of_type_Bcqf;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<Long, wid> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private whx jdField_a_of_type_Whx;
  private wie jdField_a_of_type_Wie;
  private wig jdField_a_of_type_Wig = new wgz(this);
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
    Iterator localIterator = this.jdField_a_of_type_Whx.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (wid)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((wid)localObject).jdField_a_of_type_Long), localObject);
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
        if (!aoes.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          d();
          bcql.a(getApplicationContext(), 1, 2131717214, 0).a();
        }
      }
    }
    while (aoes.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    d();
    bcql.a(getApplicationContext(), 1, 2131717214, 0).a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131365103));
    this.jdField_a_of_type_Whx = new whx();
    this.jdField_a_of_type_Whx.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560131, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131370594));
    boolean bool = SettingCloneUtil.readValue(this, this.app.c(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Whx);
    if (((amsa)ampl.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Wie = ((wie)this.app.getManager(335));
    this.jdField_a_of_type_Wie.a(this.jdField_a_of_type_Wig);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(wid paramwid)
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", ajsd.z);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qrlogin_appid", paramwid.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 2);
    axqy.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramwid.c, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131560129);
    super.setTitle(2131717226);
    this.b = ((TextView)findViewById(2131370812));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365828));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371036));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(wid paramwid)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramwid.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (wih.a(paramwid.jdField_a_of_type_Int))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", ajsd.z);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      axqy.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramwid.c, 0, "", "", "", "");
      return;
      if (wih.b(paramwid.jdField_a_of_type_Int))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", ajsd.A);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (wih.c(paramwid.jdField_a_of_type_Int))
      {
        bcql.a(getApplicationContext(), getString(2131717233), 0).b(getTitleBarHeight());
      }
    }
  }
  
  public void b(wid paramwid)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramwid.jdField_a_of_type_Int) });
    }
    if (!bbfj.g(this))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696414, 0).b(getTitleBarHeight());
      return;
    }
    bbgu localbbgu = bbdj.a(this, 230);
    localbbgu.setMessage(getString(2131717212, new Object[] { paramwid.jdField_a_of_type_JavaLangString, paramwid.b }));
    localbbgu.setPositiveButton(2131717236, new whb(this, paramwid));
    localbbgu.setNegativeButton(2131690596, new whc(this));
    localbbgu.show();
    axqy.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramwid.c, 0, "", "", "", "");
  }
  
  public void c(wid paramwid)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramwid.jdField_a_of_type_Int) });
    }
    ajum localajum = (ajum)this.app.a(8);
    if (wih.a(paramwid.jdField_a_of_type_Int))
    {
      localajum.jdField_a_of_type_JavaLangString = ajsd.z;
      localajum.jdField_a_of_type_Int = 0;
    }
    while (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new wgw(this, paramwid));
      return;
      if (wih.b(paramwid.jdField_a_of_type_Int))
      {
        localajum.jdField_a_of_type_JavaLangString = ajsd.A;
        localajum.jdField_a_of_type_Int = 1;
      }
    }
    d(paramwid);
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
    wid localwid;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Whx.a().iterator();
      }
      localwid = (wid)paramIntent.next();
    } while (localwid.jdField_a_of_type_Long != l);
    a(localwid);
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
    this.b.setText(bbcz.h(this.app, paramBundle));
    paramBundle = bayh.a(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_Ajxj);
    axqy.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Wie != null) {
      this.jdField_a_of_type_Wie.b(this.jdField_a_of_type_Wig);
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
    if (!bbfj.g(this))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696414, 0).b(getTitleBarHeight());
      return;
    }
    paramView = bbdj.a(this, 230);
    paramView.setTitle(2131717204);
    if (this.jdField_a_of_type_Wie != null) {
      paramView.setMessage(this.jdField_a_of_type_Wie.a(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      paramView.setPositiveButton(2131717236, new wgx(this));
      paramView.setNegativeButton(2131690596, new wgy(this));
      paramView.show();
      axqy.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      return;
      paramView.setMessage(2131717205);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qrcode.activity;

import ajsf;
import ajuo;
import ajxl;
import ampm;
import amsb;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import aoen;
import axqw;
import baxt;
import bbcl;
import bbcv;
import bbev;
import bbgg;
import bcpq;
import bcpw;
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
import wgw;
import wgz;
import wha;
import whb;
import whc;
import whd;
import whe;
import whf;
import wia;
import wie;
import wig;
import wih;
import wij;
import wik;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, wie
{
  private long jdField_a_of_type_Long;
  private ajxl jdField_a_of_type_Ajxl = new whd(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new wgw(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcpq jdField_a_of_type_Bcpq;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<Long, wig> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private wia jdField_a_of_type_Wia;
  private wih jdField_a_of_type_Wih;
  private wij jdField_a_of_type_Wij = new whc(this);
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
    Iterator localIterator = this.jdField_a_of_type_Wia.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (wig)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((wig)localObject).jdField_a_of_type_Long), localObject);
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
        if (!aoen.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          d();
          bcpw.a(getApplicationContext(), 1, 2131717203, 0).a();
        }
      }
    }
    while (aoen.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    d();
    bcpw.a(getApplicationContext(), 1, 2131717203, 0).a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131365104));
    this.jdField_a_of_type_Wia = new wia();
    this.jdField_a_of_type_Wia.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560131, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131370595));
    boolean bool = SettingCloneUtil.readValue(this, this.app.c(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Wia);
    if (((amsb)ampm.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Wih = ((wih)this.app.getManager(335));
    this.jdField_a_of_type_Wih.a(this.jdField_a_of_type_Wij);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(wig paramwig)
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", ajsf.z);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qrlogin_appid", paramwig.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 2);
    axqw.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramwig.c, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131560129);
    super.setTitle(2131717215);
    this.b = ((TextView)findViewById(2131370812));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365828));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371036));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(wig paramwig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramwig.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (wik.a(paramwig.jdField_a_of_type_Int))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", ajsf.z);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      axqw.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramwig.c, 0, "", "", "", "");
      return;
      if (wik.b(paramwig.jdField_a_of_type_Int))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", ajsf.A);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (wik.c(paramwig.jdField_a_of_type_Int))
      {
        bcpw.a(getApplicationContext(), getString(2131717222), 0).b(getTitleBarHeight());
      }
    }
  }
  
  public void b(wig paramwig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramwig.jdField_a_of_type_Int) });
    }
    if (!bbev.g(this))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696413, 0).b(getTitleBarHeight());
      return;
    }
    bbgg localbbgg = bbcv.a(this, 230);
    localbbgg.setMessage(getString(2131717201, new Object[] { paramwig.jdField_a_of_type_JavaLangString, paramwig.b }));
    localbbgg.setPositiveButton(2131717225, new whe(this, paramwig));
    localbbgg.setNegativeButton(2131690596, new whf(this));
    localbbgg.show();
    axqw.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramwig.c, 0, "", "", "", "");
  }
  
  public void c(wig paramwig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramwig.jdField_a_of_type_Int) });
    }
    ajuo localajuo = (ajuo)this.app.a(8);
    if (wik.a(paramwig.jdField_a_of_type_Int))
    {
      localajuo.jdField_a_of_type_JavaLangString = ajsf.z;
      localajuo.jdField_a_of_type_Int = 0;
    }
    while (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new wgz(this, paramwig));
      return;
      if (wik.b(paramwig.jdField_a_of_type_Int))
      {
        localajuo.jdField_a_of_type_JavaLangString = ajsf.A;
        localajuo.jdField_a_of_type_Int = 1;
      }
    }
    d(paramwig);
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
    wig localwig;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Wia.a().iterator();
      }
      localwig = (wig)paramIntent.next();
    } while (localwig.jdField_a_of_type_Long != l);
    a(localwig);
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
    this.b.setText(bbcl.h(this.app, paramBundle));
    paramBundle = baxt.a(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_Ajxl);
    axqw.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Wih != null) {
      this.jdField_a_of_type_Wih.b(this.jdField_a_of_type_Wij);
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
    if (!bbev.g(this))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696413, 0).b(getTitleBarHeight());
      return;
    }
    paramView = bbcv.a(this, 230);
    paramView.setTitle(2131717193);
    if (this.jdField_a_of_type_Wih != null) {
      paramView.setMessage(this.jdField_a_of_type_Wih.a(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      paramView.setPositiveButton(2131717225, new wha(this));
      paramView.setNegativeButton(2131690596, new whb(this));
      paramView.show();
      axqw.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      return;
      paramView.setMessage(2131717194);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity
 * JD-Core Version:    0.7.0.1
 */
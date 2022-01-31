package com.tencent.biz.qrcode.activity;

import alof;
import alqo;
import altm;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import aoks;
import aonh;
import aqbd;
import azqs;
import bdbk;
import bdgc;
import bdgm;
import bdin;
import bdjz;
import bety;
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
import xzu;
import xzx;
import xzy;
import xzz;
import yaa;
import yab;
import yac;
import yad;
import yay;
import ybc;
import ybe;
import ybf;
import ybh;
import ybi;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, ybc
{
  private long jdField_a_of_type_Long;
  private altm jdField_a_of_type_Altm = new yab(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new xzu(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bety jdField_a_of_type_Bety;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<Long, ybe> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private yay jdField_a_of_type_Yay;
  private ybf jdField_a_of_type_Ybf;
  private ybh jdField_a_of_type_Ybh = new yaa(this);
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
    Iterator localIterator = this.jdField_a_of_type_Yay.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (ybe)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((ybe)localObject).jdField_a_of_type_Long), localObject);
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
        if (!aqbd.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          d();
          QQToast.a(getApplicationContext(), 1, 2131717598, 0).a();
        }
      }
    }
    while (aqbd.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    d();
    QQToast.a(getApplicationContext(), 1, 2131717598, 0).a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131365190));
    this.jdField_a_of_type_Yay = new yay();
    this.jdField_a_of_type_Yay.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560238, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131370918));
    boolean bool = SettingCloneUtil.readValue(this, this.app.c(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Yay);
    if (((aonh)aoks.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ybf = ((ybf)this.app.getManager(335));
    this.jdField_a_of_type_Ybf.a(this.jdField_a_of_type_Ybh);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(ybe paramybe)
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", alof.z);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qrlogin_appid", paramybe.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 2);
    azqs.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramybe.c, 0, "", "", "", "");
  }
  
  protected void a()
  {
    super.setContentView(2131560236);
    super.setTitle(2131717610);
    this.b = ((TextView)findViewById(2131371142));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365916));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371368));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(ybe paramybe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramybe.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (ybi.a(paramybe.jdField_a_of_type_Int))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", alof.z);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramybe.c, 0, "", "", "", "");
      return;
      if (ybi.b(paramybe.jdField_a_of_type_Int))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", alof.A);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (ybi.c(paramybe.jdField_a_of_type_Int))
      {
        QQToast.a(getApplicationContext(), getString(2131717617), 0).b(getTitleBarHeight());
      }
    }
  }
  
  public void b(ybe paramybe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramybe.jdField_a_of_type_Int) });
    }
    if (!bdin.g(this))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696590, 0).b(getTitleBarHeight());
      return;
    }
    bdjz localbdjz = bdgm.a(this, 230);
    localbdjz.setMessage(getString(2131717596, new Object[] { paramybe.jdField_a_of_type_JavaLangString, paramybe.b }));
    localbdjz.setPositiveButton(2131717620, new yac(this, paramybe));
    localbdjz.setNegativeButton(2131690648, new yad(this));
    localbdjz.show();
    azqs.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramybe.c, 0, "", "", "", "");
  }
  
  public void c(ybe paramybe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramybe.jdField_a_of_type_Int) });
    }
    alqo localalqo = (alqo)this.app.a(8);
    if (ybi.a(paramybe.jdField_a_of_type_Int))
    {
      localalqo.jdField_a_of_type_JavaLangString = alof.z;
      localalqo.jdField_a_of_type_Int = 0;
    }
    while (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new xzx(this, paramybe));
      return;
      if (ybi.b(paramybe.jdField_a_of_type_Int))
      {
        localalqo.jdField_a_of_type_JavaLangString = alof.A;
        localalqo.jdField_a_of_type_Int = 1;
      }
    }
    d(paramybe);
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
    ybe localybe;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Yay.a().iterator();
      }
      localybe = (ybe)paramIntent.next();
    } while (localybe.jdField_a_of_type_Long != l);
    a(localybe);
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
    this.b.setText(bdgc.h(this.app, paramBundle));
    paramBundle = bdbk.a(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_Altm);
    azqs.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Ybf != null) {
      this.jdField_a_of_type_Ybf.b(this.jdField_a_of_type_Ybh);
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
    if (!bdin.g(this))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696590, 0).b(getTitleBarHeight());
      return;
    }
    paramView = bdgm.a(this, 230);
    paramView.setTitle(2131717588);
    if (this.jdField_a_of_type_Ybf != null) {
      paramView.setMessage(this.jdField_a_of_type_Ybf.a(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      paramView.setPositiveButton(2131717620, new xzy(this));
      paramView.setNegativeButton(2131690648, new xzz(this));
      paramView.show();
      azqs.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      return;
      paramView.setMessage(2131717589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity
 * JD-Core Version:    0.7.0.1
 */
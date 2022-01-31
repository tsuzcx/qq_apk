package com.tencent.biz.qrcode.activity;

import ajed;
import ajgm;
import ajjh;
import alzw;
import amcb;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import anoc;
import awqx;
import azwp;
import babh;
import babr;
import badq;
import bafb;
import bbms;
import bbmy;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import vua;
import vud;
import vue;
import vuf;
import vug;
import vuh;
import vui;
import vvd;
import vvh;
import vvj;
import vvk;
import vvm;
import vvn;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, vvh
{
  private long jdField_a_of_type_Long;
  private ajjh jdField_a_of_type_Ajjh = new vug(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new vua(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbms jdField_a_of_type_Bbms;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<Long, vvj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private vvd jdField_a_of_type_Vvd;
  private vvk jdField_a_of_type_Vvk;
  private vvm jdField_a_of_type_Vvm = new vuf(this);
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
    Iterator localIterator = this.jdField_a_of_type_Vvd.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (vvj)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((vvj)localObject).jdField_a_of_type_Long), localObject);
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
        if (!anoc.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          d();
          bbmy.a(getApplicationContext(), 1, 2131651411, 0).a();
        }
      }
    }
    while (anoc.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    d();
    bbmy.a(getApplicationContext(), 1, 2131651411, 0).a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131299536));
    this.jdField_a_of_type_Vvd = new vvd();
    this.jdField_a_of_type_Vvd.a(this);
    View localView = LayoutInflater.from(this).inflate(2131494559, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131304929));
    boolean bool = SettingCloneUtil.readValue(this, this.app.c(), null, "qqsetting_qrlogin_set_mute", false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Vvd);
    if (((amcb)alzw.a().a(528)).jdField_a_of_type_Int == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Vvk = ((vvk)this.app.getManager(335));
    this.jdField_a_of_type_Vvk.a(this.jdField_a_of_type_Vvm);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QRLoginMgrActivity.5(this));
  }
  
  protected void a()
  {
    super.setContentView(2131494557);
    super.setTitle(2131651423);
    this.b = ((TextView)findViewById(2131305139));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300230));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305344));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  public void a(vvj paramvvj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramvvj.jdField_a_of_type_Int) });
    }
    Intent localIntent;
    if (vvn.a(paramvvj.jdField_a_of_type_Int))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", ajed.z);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", "0X800A471", "0X800A471", paramvvj.c, 0, "", "", "", "");
      return;
      if (vvn.b(paramvvj.jdField_a_of_type_Int))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", ajed.A);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (vvn.c(paramvvj.jdField_a_of_type_Int))
      {
        bbmy.a(getApplicationContext(), getString(2131651430), 0).b(getTitleBarHeight());
      }
    }
  }
  
  public void b(vvj paramvvj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramvvj.jdField_a_of_type_Int) });
    }
    if (!badq.g(this))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131630710, 0).b(getTitleBarHeight());
      return;
    }
    bafb localbafb = babr.a(this, 230);
    localbafb.setMessage(getString(2131651409, new Object[] { paramvvj.jdField_a_of_type_JavaLangString, paramvvj.b }));
    localbafb.setPositiveButton(2131651433, new vuh(this, paramvvj));
    localbafb.setNegativeButton(2131625035, new vui(this));
    localbafb.show();
    awqx.b(null, "dc00898", "", "", "0X800A473", "0X800A473", paramvvj.c, 0, "", "", "", "");
  }
  
  public void c(vvj paramvvj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramvvj.jdField_a_of_type_Int) });
    }
    Object localObject = (ajgm)this.app.a(8);
    if (vvn.a(paramvvj.jdField_a_of_type_Int))
    {
      ((ajgm)localObject).jdField_a_of_type_JavaLangString = ajed.z;
      ((ajgm)localObject).jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localObject = new Intent(getApplicationContext(), FMActivity.class);
      ((Intent)localObject).putExtra("category", 6);
      ((Intent)localObject).putExtra("selectMode", true);
      ((Intent)localObject).putExtra("targetUin", ajed.z);
      ((Intent)localObject).putExtra("tab_tab_type", 5);
      ((Intent)localObject).putExtra("max_select_count", 50);
      ((Intent)localObject).putExtra("qrlogin_appid", paramvvj.jdField_a_of_type_Long);
      startActivityForResult((Intent)localObject, 2);
      awqx.b(null, "dc00898", "", "", "0X800A472", "0X800A472", paramvvj.c, 0, "", "", "", "");
      return;
      if (vvn.b(paramvvj.jdField_a_of_type_Int))
      {
        ((ajgm)localObject).jdField_a_of_type_JavaLangString = ajed.A;
        ((ajgm)localObject).jdField_a_of_type_Int = 1;
      }
    }
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
    vvj localvvj;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Vvd.a().iterator();
      }
      localvvj = (vvj)paramIntent.next();
    } while (localvvj.jdField_a_of_type_Long != l);
    a(localvvj);
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
    this.b.setText(babh.h(this.app, paramBundle));
    paramBundle = azwp.a(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    c();
    addObserver(this.jdField_a_of_type_Ajjh);
    awqx.b(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Vvk != null) {
      this.jdField_a_of_type_Vvk.b(this.jdField_a_of_type_Vvm);
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
    if (!badq.g(this))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131630710, 0).b(getTitleBarHeight());
      return;
    }
    paramView = babr.a(this, 230);
    paramView.setTitle(2131651401);
    if (this.jdField_a_of_type_Vvk != null) {
      paramView.setMessage(this.jdField_a_of_type_Vvk.a(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      paramView.setPositiveButton(2131651433, new vud(this));
      paramView.setNegativeButton(2131625035, new vue(this));
      paramView.show();
      awqx.b(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      return;
      paramView.setMessage(2131651402);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity
 * JD-Core Version:    0.7.0.1
 */
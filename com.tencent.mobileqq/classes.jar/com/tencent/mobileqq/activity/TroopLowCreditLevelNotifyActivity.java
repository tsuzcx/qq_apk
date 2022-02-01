package com.tencent.mobileqq.activity;

import Override;
import aftr;
import afts;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anzj;
import aoip;
import aojs;
import bhlq;
import bhmq;
import bhpc;
import bjbs;
import bmtd;
import bmtk;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopFileProxyActivity;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;

public class TroopLowCreditLevelNotifyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public Context a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected aojs a;
  protected bjbs a;
  public String a;
  public View[] a;
  public boolean[] a;
  protected TextView b;
  protected String b;
  protected TextView c;
  protected TextView d;
  
  public TroopLowCreditLevelNotifyActivity()
  {
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[4];
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[4];
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aojs = new afts(this);
  }
  
  private String a(String paramString, long paramLong)
  {
    String str = this.app.getCurrentAccountUin();
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      paramString = paramString.replace("$GCODE$", this.jdField_a_of_type_JavaLangString).replace("$CLIENTVER$", "android8.4.5").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject).replace("$ENTERSOURCE$", "1");
      return paramString + "&credit=1";
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) == 1L) {
        localObject = "1";
      } else {
        localObject = "2";
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379385));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379490));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379536));
    this.c = ((TextView)findViewById(2131370426));
    this.d = ((TextView)findViewById(2131371338));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368865));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378185));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setTitle(2131696881);
    this.c.setText(2131696889);
    this.d.setText(2131696888);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    a(2131696929, 2131696837, this.jdField_a_of_type_ArrayOfBoolean[0], 0);
    a(2131696925, 2131696837, this.jdField_a_of_type_ArrayOfBoolean[1], 1);
    a(2131696926, 2131696835, this.jdField_a_of_type_ArrayOfBoolean[2], 2);
    a(2131696928, 2131696836, this.jdField_a_of_type_ArrayOfBoolean[3], 3);
    Bitmap localBitmap = this.app.a(this.jdField_a_of_type_JavaLangString, (byte)3, false, false);
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    while (b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      localBitmap = bhmq.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public oidb_0xe83.AppInfo a(long paramLong)
  {
    Object localObject1 = ((TroopManager)this.app.getManager(52)).a(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new oidb_0xe83.RspBody();
        ((oidb_0xe83.RspBody)localObject2).mergeFrom((byte[])localObject1);
        localObject2 = ((oidb_0xe83.RspBody)localObject2).infos.get();
        if (localObject2 == null) {
          break label168;
        }
        if (((List)localObject2).size() != 0) {
          break label174;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        long l;
        if (!QLog.isColorLevel()) {
          break label166;
        }
        QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "getAppInfo: " + paramLong + ", " + localException.toString());
      }
      label166:
      label168:
      oidb_0xe83.AppInfo localAppInfo;
      if (i < ((List)localObject2).size())
      {
        localObject1 = (oidb_0xe83.AppInfo)((List)localObject2).get(i);
        l = ((oidb_0xe83.AppInfo)localObject1).appid.get();
        if (l != paramLong) {
          i += 1;
        }
      }
      else
      {
        return null;
        localAppInfo = null;
      }
      return localAppInfo;
      label174:
      int i = 0;
    }
  }
  
  public void a()
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
        {
          i = 1;
          if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
            break label133;
          }
          j = 1;
        }
      }
    }
    for (;;)
    {
      label56:
      if ((i == 0) && (j == 0))
      {
        localObject = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(getString(2131718699)).setMessage(anzj.a(2131714264));
        ((bhpc)localObject).setPositiveButton(2131696883, new aftr(this));
        ((bhpc)localObject).setNegativeButton("", null);
        ((bhpc)localObject).setCancelable(false);
        ((bhpc)localObject).show();
      }
      label133:
      do
      {
        return;
        i = 0;
        break;
        j = 0;
        break label56;
        localObject = (aoip)this.app.a(20);
      } while (localObject == null);
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "getTroopCreditInfo:" + this.jdField_a_of_type_JavaLangString);
      }
      ((aoip)localObject).d(this.jdField_a_of_type_JavaLangString, true);
      c();
      return;
      j = 0;
      i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563035, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131368993);
    TextView localTextView2 = (TextView)localView.findViewById(2131368920);
    TextView localTextView3 = (TextView)localView.findViewById(2131368988);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramInt2);
    if (paramBoolean) {
      localTextView3.setVisibility(0);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt3] = localView;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      return;
      localTextView3.setVisibility(8);
    }
  }
  
  public void a(oidb_0xe83.AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    paramAppInfo = a(paramAppInfo.url.get(), paramAppInfo.appid.get());
    localIntent.putExtra("url", paramAppInfo);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult(localIntent, 1001);
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "openTroopAnnounce:" + paramAppInfo);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopUin");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject).getTroopName();
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        }
      }
      localObject = getSharedPreferences("sp_tp_credit_md_stat_" + this.app.getCurrentAccountUin(), 0).getString(this.jdField_a_of_type_JavaLangString, "");
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "initParams, modifyStatusJson:" + (String)localObject);
      }
      localObject = new JSONObject((String)localObject);
      this.jdField_a_of_type_ArrayOfBoolean[0] = ((JSONObject)localObject).optBoolean("TROOP_INFO_ITEM");
      this.jdField_a_of_type_ArrayOfBoolean[1] = ((JSONObject)localObject).optBoolean("TROOP_ANNOUNCE_ITEM");
      this.jdField_a_of_type_ArrayOfBoolean[2] = ((JSONObject)localObject).optBoolean("TROOP_FILE_ITEM");
      this.jdField_a_of_type_ArrayOfBoolean[3] = ((JSONObject)localObject).optBoolean("TROOP_ALBUM_ITEM");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "initParams:" + localException.toString());
        }
      }
    }
    return true;
    return false;
  }
  
  public void b()
  {
    try
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("sp_tp_credit_md_stat_" + this.app.getCurrentAccountUin(), 0).edit();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("TROOP_INFO_ITEM", this.jdField_a_of_type_ArrayOfBoolean[0]);
      localJSONObject.put("TROOP_ANNOUNCE_ITEM", this.jdField_a_of_type_ArrayOfBoolean[1]);
      localJSONObject.put("TROOP_FILE_ITEM", this.jdField_a_of_type_ArrayOfBoolean[2]);
      localJSONObject.put("TROOP_ALBUM_ITEM", this.jdField_a_of_type_ArrayOfBoolean[3]);
      localEditor.putString(this.jdField_a_of_type_JavaLangString, localJSONObject.toString());
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "saveStatus:" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "saveStatus:" + localException.toString());
    }
  }
  
  public boolean b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBoolean.length)
    {
      if (this.jdField_a_of_type_ArrayOfBoolean[i] == 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(this);
    }
    this.jdField_a_of_type_Bjbs.c(2131696887);
    this.jdField_a_of_type_Bjbs.b(getTitleBarHeight());
    this.jdField_a_of_type_Bjbs.show();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
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
    int i = -1;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
        paramInt1 = i;
      }
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1].findViewById(2131368988).setVisibility(0);
        this.jdField_a_of_type_ArrayOfBoolean[paramInt1] = true;
      }
      if (!b()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      paramInt1 = 0;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
      continue;
      paramInt1 = 3;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "doOnCreate:" + this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString);
    }
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2131563036);
    e();
    addObserver(this.jdField_a_of_type_Aojs);
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Aojs);
    b();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == 2131378185)
    {
      localObject1 = "https://qqweb.qq.com/m/business/qunlevel/index.html?gc=" + this.jdField_a_of_type_JavaLangString + "&from=0&_wv=1027";
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      startActivity((Intent)localObject2);
    }
    label365:
    label368:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_ArrayOfAndroidViewView[0])
      {
        localObject1 = (TroopManager)this.app.getManager(52);
        if (localObject1 == null) {
          break label365;
        }
      }
      for (localObject1 = ((TroopManager)localObject1).b(this.jdField_a_of_type_JavaLangString);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label368;
        }
        localObject2 = TroopInfoActivity.a(this.jdField_a_of_type_JavaLangString, 28, ((TroopInfo)localObject1).troopLat, ((TroopInfo)localObject1).troopLon, 0, "");
        ((Bundle)localObject2).putInt("troop_type_ex", ((TroopInfo)localObject1).troopTypeExt);
        TroopInfoActivity.a(this, (Bundle)localObject2, 1000);
        break;
        if (paramView == this.jdField_a_of_type_ArrayOfAndroidViewView[1])
        {
          localObject1 = a(1101236949L);
          if (localObject1 != null)
          {
            a((oidb_0xe83.AppInfo)localObject1);
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onClick, appInfo for announce is null, req from server");
          }
          c();
          localObject1 = (aoip)this.app.a(20);
          if (localObject1 == null) {
            break;
          }
          ((aoip)localObject1).a(this.jdField_a_of_type_JavaLangString, false, 0, 1);
          break;
        }
        if (paramView == this.jdField_a_of_type_ArrayOfAndroidViewView[2])
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("param_from", 1000);
          TroopFileProxyActivity.a(this, (Intent)localObject1, 1002, this.app.getCurrentAccountUin());
          break;
        }
        if (paramView != this.jdField_a_of_type_ArrayOfAndroidViewView[3]) {
          break;
        }
        localObject1 = bmtk.a();
        ((bmtk)localObject1).jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        ((bmtk)localObject1).jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
        bmtd.a(this, (bmtk)localObject1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 3, 1003, "qunnotice");
        break;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.troop;

import Override;
import aanu;
import aanv;
import aanw;
import aanx;
import aany;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import anwd;
import bcst;
import bglp;
import bgpa;
import biau;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import niq;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class EditUniqueTitleActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected final int a;
  protected TextWatcher a;
  protected View a;
  public EditText a;
  public ImageButton a;
  public TextView a;
  protected biau a;
  protected String a;
  public boolean a;
  protected int b;
  protected TextView b;
  protected String b;
  protected int c;
  protected String c;
  protected String d;
  
  public EditUniqueTitleActivity()
  {
    this.jdField_a_of_type_Int = 6;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTextTextWatcher = new aanv(this);
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    paramContext = new Intent(paramContext, EditUniqueTitleActivity.class);
    paramContext.putExtra("from", String.valueOf(paramInt1));
    paramContext.putExtra("memberUin", paramString2);
    paramContext.putExtra("troopUin", paramString1);
    paramContext.putExtra("memberRole", paramInt2);
    paramContext.putExtra("uniqueTitle", paramString3);
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_Int != 2) {
      c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditUniqueTitleActivity", 2, "onSetUniqueTitle, errCode=" + paramInt);
    }
    if (paramInt == 0)
    {
      Object localObject = (TroopManager)this.app.getManager(52);
      ((TroopManager)localObject).a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, false);
      ((TroopManager)localObject).b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d, -1);
      if (this.jdField_b_of_type_Int == 2) {
        QQToast.a(this, getResources().getString(2131695607), 1).a();
      }
      localObject = getIntent();
      ((Intent)localObject).putExtra("newUniqueTitle", this.d);
      setResult(-1, (Intent)localObject);
      finish();
      ((anwd)this.app.a(20)).notifyUI(64, true, new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d });
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      setResult(0, getIntent());
      finish();
      QQToast.a(this, getResources().getString(2131695608), 1).a();
      return;
    }
    if (paramInt == 1281)
    {
      QQToast.a(this, getResources().getString(2131695605), 1).a();
      return;
    }
    QQToast.a(this, getResources().getString(2131695609), 1).a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, BusinessObserver paramBusinessObserver)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      Oidb_0x8fc.ReqBody localReqBody = new Oidb_0x8fc.ReqBody();
      Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
      Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
      try
      {
        localObject = ((TroopManager)localObject).c(paramString1, paramString2);
        localReqBody.uint64_group_code.set(Long.parseLong(paramString1));
        localMemberInfo.uint64_uin.set(Long.parseLong(paramString2));
        localMemberInfo.bytes_uin_name.set(ByteStringMicro.copyFromUtf8((String)localObject));
        if (paramString3 != null) {
          localMemberInfo.bytes_special_title.set(ByteStringMicro.copyFromUtf8(paramString3));
        }
        localMemberInfo.uint32_special_title_expire_time.set(-1);
        localReqBody.rpt_mem_level_info.add(localMemberInfo);
        paramString1 = new oidb_sso.OIDBSSOPkg();
        paramString1.uint32_command.set(2300);
        paramString1.uint32_service_type.set(2);
        paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
        paramString2 = new NewIntent(paramQQAppInterface.getApp(), niq.class);
        paramString2.putExtra("cmd", "OidbSvc.0x8fc_2");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(paramBusinessObserver);
        paramQQAppInterface.startServlet(paramString2);
        return;
      }
      catch (NumberFormatException paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("EditUniqueTitleActivity", 2, "setUniqueTitle exp", paramQQAppInterface);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, gc=" + paramString1 + ", memberUin=" + paramString2 + ", from=" + this.jdField_b_of_type_Int);
    }
    if (paramString3.equals(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, equals and return");
      }
      finish();
      return;
    }
    if (this.jdField_b_of_type_Int != 2) {
      b();
    }
    a(this.app, paramString1, paramString2, paramString3, new aany(this));
  }
  
  private boolean a()
  {
    boolean bool = true;
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.jdField_b_of_type_Int = Integer.parseInt(localIntent.getStringExtra("from"));
        this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("memberUin");
        this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("troopUin");
        this.jdField_c_of_type_Int = localIntent.getIntExtra("memberRole", 1);
        this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("uniqueTitle");
        if (this.jdField_b_of_type_Int == 2)
        {
          bcst.b(this.app, "P_CliOper", "Grp_manage", "", "grp_aio", "Clk_expire", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167066));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0/6");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      if (this.jdField_c_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(getString(2131693464));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.length());
      return;
      if (this.jdField_c_of_type_Int == 3)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(getString(2131718848));
        continue;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    this.d = str;
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if ((!TextUtils.isEmpty(str)) && (!str.equals(getString(2131693464))))
      {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
        return;
      }
      if (((TextUtils.isEmpty(str)) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(getString(2131693464)))) || ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str != null) && (str.equals(getString(2131693464)))) || ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(getString(2131693464))) && (this.jdField_c_of_type_JavaLangString.equals(str))) || ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))))
      {
        finish();
        return;
      }
      this.d = "";
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
      return;
    case 3: 
      if ((!TextUtils.isEmpty(str)) && (!str.equals(getString(2131718848))))
      {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
        return;
      }
      if (((TextUtils.isEmpty(str)) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(getString(2131718848)))) || ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str != null) && (str.equals(getString(2131718848)))) || ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(getString(2131718848))) && (this.jdField_c_of_type_JavaLangString.equals(str))) || ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))))
      {
        finish();
        return;
      }
      this.d = "";
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      finish();
      return;
    }
    this.d = "";
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
  }
  
  protected void a()
  {
    bcst.b(this.app, "dc00899", "Grp_title", "", "grp_data", "clk_finish", 0, 0, "", "", "", "");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(str)))
    {
      bglp.a(this, getString(2131695446), 2131690582, 2131695445, new aanw(this), new aanx(this)).show();
      return;
    }
    e();
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Biau == null)
      {
        this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
        this.jdField_a_of_type_Biau.c(2131694158);
        this.jdField_a_of_type_Biau.c(false);
      }
      this.jdField_a_of_type_Biau.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("EditUniqueTitleActivity", 2, localException.toString());
    }
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
        this.jdField_a_of_type_Biau.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("EditUniqueTitleActivity", 2, localException.toString());
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2131560584);
    setTitle(2131695495);
    setLeftButton(2131690582, new aanu(this));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365805));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364528));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365824));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380430));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = "1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setRightHighlightButton(2131692257, this);
    if (!this.jdField_a_of_type_Boolean) {
      this.rightViewText.setAlpha(0.5F);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376437);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_c_of_type_Int == 2)
    {
      paramBundle = getString(2131693464);
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!paramBundle.equals(this.jdField_c_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        bcst.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
    }
    for (;;)
    {
      bcst.b(this.app, "dc00899", "Grp_title", "", "grp_data", "edit_exp", 0, 0, "", "", "", "");
      d();
      return false;
      if (this.jdField_c_of_type_Int == 3)
      {
        paramBundle = getString(2131718848);
        if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!paramBundle.equals(this.jdField_c_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          bcst.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
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
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      continue;
      a();
      continue;
      this.d = "";
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
      bcst.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, this.jdField_b_of_type_JavaLangString, "0", "0", "0");
      bcst.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
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
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity
 * JD-Core Version:    0.7.0.1
 */
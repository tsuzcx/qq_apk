package com.tencent.biz.troop;

import ajtg;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import awqx;
import babr;
import bafb;
import bbms;
import bbmy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mmi;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import win;
import wio;
import wip;
import wiq;
import wir;

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
  protected bbms a;
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
    this.jdField_a_of_type_AndroidTextTextWatcher = new wio(this);
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
        bbmy.a(this, getResources().getString(2131630892), 1).a();
      }
      localObject = getIntent();
      ((Intent)localObject).putExtra("newUniqueTitle", this.d);
      setResult(-1, (Intent)localObject);
      finish();
      ((ajtg)this.app.a(20)).notifyUI(64, true, new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d });
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      setResult(0, getIntent());
      finish();
      bbmy.a(this, getResources().getString(2131630893), 1).a();
      return;
    }
    if (paramInt == 1281)
    {
      bbmy.a(this, getResources().getString(2131630890), 1).a();
      return;
    }
    bbmy.a(this, getResources().getString(2131630894), 1).a();
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
        paramString2 = new NewIntent(paramQQAppInterface.getApp(), mmi.class);
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
    a(this.app, paramString1, paramString2, paramString3, new wir(this));
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
          awqx.b(this.app, "P_CliOper", "Grp_manage", "", "grp_aio", "Clk_expire", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131101338));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0/6");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      if (this.jdField_c_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(getString(2131628435));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.length());
      return;
      if (this.jdField_c_of_type_Int == 3)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(getString(2131654652));
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
      if ((!TextUtils.isEmpty(str)) && (!str.equals(getString(2131628435))))
      {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
        return;
      }
      if (((TextUtils.isEmpty(str)) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(getString(2131628435)))) || ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str != null) && (str.equals(getString(2131628435)))) || ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(getString(2131628435))) && (this.jdField_c_of_type_JavaLangString.equals(str))) || ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))))
      {
        finish();
        return;
      }
      this.d = "";
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
      return;
    case 3: 
      if ((!TextUtils.isEmpty(str)) && (!str.equals(getString(2131654652))))
      {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
        return;
      }
      if (((TextUtils.isEmpty(str)) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(getString(2131654652)))) || ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str != null) && (str.equals(getString(2131654652)))) || ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(getString(2131654652))) && (this.jdField_c_of_type_JavaLangString.equals(str))) || ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))))
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
    awqx.b(this.app, "dc00899", "Grp_title", "", "grp_data", "clk_finish", 0, 0, "", "", "", "");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(str)))
    {
      babr.a(this, getString(2131630741), 2131625035, 2131630740, new wip(this), new wiq(this)).show();
      return;
    }
    e();
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Bbms == null)
      {
        this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
        this.jdField_a_of_type_Bbms.c(2131629253);
        this.jdField_a_of_type_Bbms.c(false);
      }
      this.jdField_a_of_type_Bbms.show();
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
      if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
        this.jdField_a_of_type_Bbms.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("EditUniqueTitleActivity", 2, localException.toString());
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2131494750);
    setTitle(2131630789);
    setLeftButton(2131625035, new win(this));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299906));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131298690));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299924));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312990));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = "1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setRightHighlightButton(2131626982, this);
    if (!this.jdField_a_of_type_Boolean) {
      this.rightViewText.setAlpha(0.5F);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131309428);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_c_of_type_Int == 2)
    {
      paramBundle = getString(2131628435);
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!paramBundle.equals(this.jdField_c_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        awqx.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
    }
    for (;;)
    {
      awqx.b(this.app, "dc00899", "Grp_title", "", "grp_data", "edit_exp", 0, 0, "", "", "", "");
      d();
      return false;
      if (this.jdField_c_of_type_Int == 3)
      {
        paramBundle = getString(2131654652);
        if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!paramBundle.equals(this.jdField_c_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          awqx.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
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
    default: 
      return;
    case 2131298690: 
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    case 2131302832: 
      a();
      return;
    }
    this.d = "";
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
    awqx.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, this.jdField_b_of_type_JavaLangString, "0", "0", "0");
    awqx.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity
 * JD-Core Version:    0.7.0.1
 */
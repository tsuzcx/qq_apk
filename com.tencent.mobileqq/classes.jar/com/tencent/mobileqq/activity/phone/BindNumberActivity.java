package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import agip;
import agiq;
import agir;
import agis;
import agit;
import agiu;
import agiv;
import agiw;
import agix;
import ajxj;
import ajya;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import askn;
import aumg;
import axqy;
import bayh;
import bbdj;
import bbfj;
import bbfx;
import bbgu;
import bfob;
import bftz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class BindNumberActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, bftz
{
  private int jdField_a_of_type_Int = -1;
  public ajxj a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new bfob(Looper.getMainLooper(), this);
  protected ViewGroup a;
  protected Button a;
  protected CheckBox a;
  public EditText a;
  protected TextView a;
  public aumg a;
  public bbgu a;
  public String a;
  public boolean a;
  public aumg b;
  public bbgu b;
  protected String b;
  public boolean b;
  public bbgu c;
  public String c;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  public boolean f;
  
  public BindNumberActivity()
  {
    this.jdField_a_of_type_JavaLangString = "+86";
    this.jdField_b_of_type_JavaLangString = ajya.a(2131701128);
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("finish2 [%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    super.finish();
    if (a()) {
      overridePendingTransition(2130771990, 2130772280);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + " " + paramString2;
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramString1, 0, paramString1.length(), localRect);
    int i = getResources().getDimensionPixelSize(2131297305);
    int j = getResources().getDimensionPixelSize(2131297304);
    if (localRect.right > i - j) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    for (;;)
    {
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + ajya.a(2131701130));
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new BindNumberActivity.1(this), 300L);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Boolean) {
      a("dc00898", "0X8009EC3", 0);
    }
    a("dc00898", "0X8009F12", 0);
    if (this.d)
    {
      if (this.jdField_a_of_type_Bbgu == null) {
        this.jdField_a_of_type_Bbgu = bbdj.a(this, 230, null, ajya.a(2131701137), getString(2131690596), getString(2131694794), new agiq(this), new agir(this));
      }
      if ((this.jdField_a_of_type_Bbgu != null) && (!this.jdField_a_of_type_Bbgu.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_Bbgu.show();
      }
      return;
    }
    i();
  }
  
  private void i()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      a(ajya.a(2131701138));
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("+86")) && (this.jdField_c_of_type_JavaLangString.length() != 11))
    {
      b(2131695051);
      return;
    }
    if (!bbfj.d(this))
    {
      b(2131694673);
      return;
    }
    if (this.d)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a()
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    if (this.f)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() > 0)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        bool1 = true;
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 100L);
    }
  }
  
  protected void a(int paramInt, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      if (paramList != null) {
        break label81;
      }
    }
    View localView;
    label81:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.i("BindNumberActivity", 2, String.format("updateFrdInPhoneContact [%s, %s]", new Object[] { Integer.valueOf(paramInt), localObject }));
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366693);
      if ((paramInt >= 10) && (paramList != null) && (paramList.size() >= 3)) {
        break;
      }
      localView.setVisibility(8);
      return;
    }
    ((TextView)localView.findViewById(2131370747)).setText(String.format(getString(2131695036), new Object[] { Integer.valueOf(paramInt) }));
    int[] arrayOfInt = new int[3];
    int[] tmp136_134 = arrayOfInt;
    tmp136_134[0] = 2131367377;
    int[] tmp142_136 = tmp136_134;
    tmp142_136[1] = 2131367378;
    int[] tmp148_142 = tmp142_136;
    tmp148_142[2] = 2131367379;
    tmp148_142;
    paramInt = 0;
    label157:
    ImageView localImageView;
    if (paramInt < arrayOfInt.length)
    {
      localImageView = (ImageView)localView.findViewById(arrayOfInt[paramInt]);
      if (localImageView != null) {
        break label190;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label157;
      break;
      label190:
      if (paramInt < paramList.size()) {}
      for (localObject = (String)paramList.get(paramInt);; localObject = null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label233;
        }
        localImageView.setVisibility(8);
        break;
      }
      label233:
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(bayh.a(this.app, 1, (String)localObject));
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setSupportMaskView(true);
      }
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramIntent == null)
    {
      paramIntent = null;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "onBindSuc src: " + this.jdField_a_of_type_Int + ", per: " + paramIntent);
      }
      if (this.jdField_a_of_type_Int != 10) {
        break label168;
      }
      paramIntent = new Intent(this, SplashActivity.class);
      paramIntent.putExtra("main_tab_id", 1);
      paramIntent.setFlags(603979776);
      startActivity(paramIntent);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      a(paramInt);
      if (this.jdField_b_of_type_Boolean) {
        axqy.b(this.app, "dc00898", "", "", "0X8009EC4", "0X8009EC4", 0, 0, "", "", "", "");
      }
      return;
      paramIntent = paramIntent.getStringExtra("check_permission_result");
      break;
      label168:
      if (this.jdField_a_of_type_Int != 21) {
        if (this.jdField_c_of_type_Boolean)
        {
          paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
          paramIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
          paramIntent.putExtra("kBindNew", true);
          startActivity(paramIntent);
        }
        else if (("permission_denied".equals(paramIntent)) || ("permission_denied_by_user".equals(paramIntent)))
        {
          localIntent.putExtra("check_permission_result", paramIntent);
          paramIntent = new Intent(this, GuideBindPhoneActivity.class);
          paramIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
          paramIntent.putExtra("fromKeyForContactBind", 1);
          startActivity(paramIntent);
        }
        else if ("permission_granted".equals(paramIntent))
        {
          ContactBindedActivity.a(this.app, this.jdField_a_of_type_Int, 1, localIntent);
          localIntent.putExtra("check_permission_result", paramIntent);
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    a("dc00898", "0X8009F14", 0);
    Object localObject = paramBundle.getString("k_uin");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (paramBundle = this.jdField_c_of_type_JavaLangString;; paramBundle = this.jdField_a_of_type_JavaLangString + " " + this.jdField_c_of_type_JavaLangString)
    {
      localObject = getResources().getString(2131695054, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
      int i = ((String)localObject).indexOf(paramBundle);
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramBundle.length() + i, 17);
      paramBundle = bbdj.a(this, 230, null, (CharSequence)localObject, getString(2131690596), getString(2131694794), new agiu(this), new agiv(this));
      if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
        paramBundle.show();
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    axqy.b(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
  
  protected boolean a()
  {
    boolean bool = false;
    if ((this.e) || (this.jdField_a_of_type_Int == 9) || (this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 10)) {
      bool = true;
    }
    return bool;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    a();
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this, BindVerifyActivity.class);
    localIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
    localIntent.putExtra("kBindType", 0);
    localIntent.putExtra("keyReqBindMode", 0);
    localIntent.putExtra("k_number", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("k_country_code", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
    localIntent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
    localIntent.putExtra("cmd_param_is_from_uni", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
    localIntent.putExtra("cmd_param_is_from_change_bind", this.jdField_b_of_type_Boolean);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    if (!isFinishing()) {
      startActivityForResult(localIntent, 2);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == 10)
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("main_tab_id", 1);
      ((Intent)localObject).setFlags(603979776);
      startActivity((Intent)localObject);
    }
    for (;;)
    {
      setResult(-1);
      a(3);
      return;
      localObject = (PhoneContactManagerImp)this.app.getManager(11);
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManagerImp)localObject).a();
      if ((!((PhoneContactManagerImp)localObject).e()) && (localRespondQueryQQBindingStat != null) && (!localRespondQueryQQBindingStat.isStopFindMatch))
      {
        localObject = new Intent(this, PhoneMatchActivity.class);
        ((Intent)localObject).putExtra("key_from_contact_first", true);
        startActivity((Intent)localObject);
      }
    }
  }
  
  public void d()
  {
    axqy.b(this.app, "CliOper", "", "", "0X8005B78", "0X8005B78", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Bbgu == null) {
      this.jdField_b_of_type_Bbgu = bbdj.a(this, 230, null, "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, ajya.a(2131701129), new agiw(this), null);
    }
    if ((this.jdField_b_of_type_Bbgu != null) && (!this.jdField_b_of_type_Bbgu.isShowing()) && (!isFinishing())) {
      this.jdField_b_of_type_Bbgu.show();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_name");
        this.jdField_a_of_type_JavaLangString = ("+" + paramIntent.getStringExtra("k_code"));
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      return;
      if ((paramInt1 == 2) && (paramInt2 != 0))
      {
        setResult(paramInt2, paramIntent);
        if (paramInt2 != -1) {
          break;
        }
        a(paramIntent, 3);
        if (this.jdField_a_of_type_Int == 7) {
          axqy.b(this.app, "CliOper", "", "", "0X80053E2", "0X80053E2", 0, 0, "", "", "", "");
        }
        while (this.jdField_a_of_type_Int == 11)
        {
          axqy.b(this.app, "CliOper", "", "", "0X8006EFA", "0X8006EFA", 0, 0, "", "", "", "");
          return;
          if (this.jdField_a_of_type_Int == 12) {
            axqy.b(this.app, "CliOper", "", "", "0X80053DC", "0X80053DC", 0, 0, "", "", "", "");
          }
        }
      }
    }
    a(3);
  }
  
  public void doOnBackPressed()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11))
    {
      if (this.jdField_a_of_type_Int == 10) {
        bool = true;
      }
      a(bool);
      return;
    }
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      axqy.b(this.app, "CliOper", "", "", "0X80053D4", "0X80053D4", 0, 0, "", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.d = getIntent().getBooleanExtra("kNeedUnbind", false);
    this.e = getIntent().getBooleanExtra("key_is_modal_pop", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("kUnityWebBind", false);
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    getWindow().setSoftInputMode(18);
    setContentView(2131559364);
    Resources localResources;
    if ((Build.MANUFACTURER.equalsIgnoreCase("Letv")) && (Build.MODEL.equalsIgnoreCase("X900+")))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370744));
      localResources = getResources();
      if (!this.jdField_b_of_type_Boolean) {
        break label685;
      }
      paramBundle = localResources.getString(2131695039);
      label222:
      setTitle("", "");
      if (!a()) {
        break label725;
      }
      setLeftButton(2131690832, null);
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      setRightButton(2131690832, this);
      label271:
      ((TextView)findViewById(2131370748)).setText(paramBundle);
      paramBundle = localResources.getString(2131695034);
      if (!this.jdField_b_of_type_Boolean) {
        break label814;
      }
      paramBundle = localResources.getString(2131695035);
    }
    label685:
    label814:
    for (;;)
    {
      ((TextView)findViewById(2131370746)).setText(paramBundle);
      f();
      label358:
      int i;
      if (0 != 0)
      {
        this.jdField_b_of_type_JavaLangString = "";
        new StringBuilder().append('+');
        throw new NullPointerException();
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364795));
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131377619));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(ajya.a(2131701139));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370993));
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
        this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_JavaLangString.length());
        }
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364526));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        a();
        findViewById(2131377620).setOnClickListener(this);
        findViewById(2131377622).setOnClickListener(this);
        switch (this.jdField_a_of_type_Int)
        {
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 13: 
        case 16: 
        default: 
          i = 0;
        }
      }
      for (;;)
      {
        a("dc00898", "0X8009F11", i);
        return true;
        paramBundle = (BounceScrollView)findViewById(2131363402);
        if (paramBundle == null) {
          break;
        }
        paramBundle.setOnSizeChangeListener(this);
        break;
        if ((this.jdField_a_of_type_Int == 12) || (this.jdField_a_of_type_Int == 14))
        {
          paramBundle = localResources.getString(2131695037);
          break label222;
        }
        paramBundle = localResources.getString(2131695038);
        break label222;
        label725:
        setLeftViewName(2131690331);
        break label271;
        paramBundle = bbfx.b(this);
        if ("86".equals(paramBundle)) {
          break label358;
        }
        this.jdField_b_of_type_JavaLangString = "";
        this.jdField_a_of_type_JavaLangString = ('+' + paramBundle);
        break label358;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 1;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aumg != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Aumg);
      this.jdField_a_of_type_Aumg = null;
    }
    if (this.jdField_b_of_type_Aumg != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_Aumg);
      this.jdField_b_of_type_Aumg = null;
    }
    if (this.jdField_a_of_type_Ajxj != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_Ajxj = null;
    }
    if (this.jdField_a_of_type_Bbgu != null)
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      this.jdField_a_of_type_Bbgu = null;
    }
    if (this.jdField_b_of_type_Bbgu != null)
    {
      this.jdField_b_of_type_Bbgu.dismiss();
      this.jdField_b_of_type_Bbgu = null;
    }
    if (this.jdField_c_of_type_Bbgu != null)
    {
      this.jdField_c_of_type_Bbgu.dismiss();
      this.jdField_c_of_type_Bbgu = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      g();
    }
  }
  
  public void e()
  {
    axqy.b(this.app, "CliOper", "", "", "0X8005B77", "0X8005B77", 0, 0, "", "", "", "");
    if (this.jdField_c_of_type_Bbgu == null) {
      this.jdField_c_of_type_Bbgu = bbdj.a(this, 230, null, ajya.a(2131701135), null, ajya.a(2131701133), new agix(this), null);
    }
    if ((this.jdField_c_of_type_Bbgu != null) && (!this.jdField_c_of_type_Bbgu.isShowing()) && (!isFinishing())) {
      this.jdField_c_of_type_Bbgu.show();
    }
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 15) || (this.jdField_a_of_type_Int == 17) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 12) || (this.jdField_a_of_type_Int == 14)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        a(0, null);
        return;
      }
      Object localObject = (askn)this.app.getManager(11);
      if (localObject != null)
      {
        localObject = ((askn)localObject).a();
        i = ((Integer)localObject[0]).intValue();
        localObject = (List)localObject[1];
      }
      for (;;)
      {
        a(i, (List)localObject);
        if (this.jdField_a_of_type_Ajxj == null)
        {
          this.jdField_a_of_type_Ajxj = new agip(this);
          this.app.addObserver(this.jdField_a_of_type_Ajxj);
        }
        localObject = (FriendListHandler)this.app.a(1);
        if (localObject == null) {
          break;
        }
        ((FriendListHandler)localObject).b(3);
        return;
        localObject = null;
        i = 0;
      }
    }
  }
  
  public void finish()
  {
    a(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 0: 
      if (this.jdField_b_of_type_Aumg == null)
      {
        this.jdField_b_of_type_Aumg = new agis(this);
        this.app.registObserver(this.jdField_b_of_type_Aumg);
      }
      paramMessage = (askn)this.app.getManager(11);
      a(2131719292, 1000L, true);
      paramMessage.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    }
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_Aumg == null)
        {
          this.jdField_a_of_type_Aumg = new agit(this);
          this.app.registObserver(this.jdField_a_of_type_Aumg);
        }
        this.f = true;
        a();
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
      } while (3 == paramMessage.what);
      a(2131719292, 1000L, true);
      return true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      paramMessage = (BounceScrollView)findViewById(2131363402);
    } while (paramMessage == null);
    paramMessage.fullScroll(130);
    return true;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11))
    {
      if (this.jdField_a_of_type_Int == 10) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        return true;
      }
    }
    a("dc00898", "0X8009F13", 0);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_user_cancel", 1);
    setResult(0, (Intent)localObject);
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      localObject = (InputMethodManager)getSystemService("input_method");
      if (localObject != null) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      }
    }
    finish();
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(ajya.a(2131701140));
    }
    for (;;)
    {
      a();
      return;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(ajya.a(2131701136));
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramView.getId())
    {
    default: 
      this.app.logout(true);
      startActivity(new Intent(this, LoginActivity.class));
      a(1);
      a("CliOper", "0X80053D3", 0);
      return;
    case 2131364795: 
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      return;
    case 2131368429: 
    case 2131368431: 
    case 2131368457: 
      if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11))
      {
        if (this.jdField_a_of_type_Int == 10) {}
        for (;;)
        {
          a(bool1);
          return;
          bool1 = false;
        }
      }
      setResult(0);
      finish();
      return;
    case 2131364526: 
      h();
      return;
    case 2131377622: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", "http://vac.qq.com/hall/phone/phone_tos.html?_wv=3");
      startActivity(paramView);
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramView.setChecked(bool1);
      return;
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramView == this.jdField_a_of_type_AndroidWidgetEditText) && (66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      i();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity
 * JD-Core Version:    0.7.0.1
 */
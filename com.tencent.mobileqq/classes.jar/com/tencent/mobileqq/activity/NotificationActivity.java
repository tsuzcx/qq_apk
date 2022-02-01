package com.tencent.mobileqq.activity;

import Override;
import aejb;
import aejc;
import aejd;
import aeje;
import aejf;
import aejg;
import aejh;
import aeji;
import aejj;
import aejk;
import aejl;
import aejm;
import aejn;
import aejo;
import aejp;
import aejq;
import aejr;
import aejs;
import aejt;
import aeju;
import aejv;
import aejw;
import aejx;
import aejy;
import aejz;
import aeka;
import aekc;
import aekd;
import aeke;
import aekf;
import aekg;
import aekh;
import aeki;
import aekj;
import aekl;
import aekm;
import aekn;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import ansg;
import anvx;
import aozj;
import axrb;
import azit;
import bdla;
import bdxs;
import bhdj;
import bhhr;
import bhzc;
import bisl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class NotificationActivity
  extends BaseActivity
  implements Handler.Callback
{
  public static NotificationActivity a;
  public static final ArrayList<String> a;
  private int jdField_a_of_type_Int;
  private aekm jdField_a_of_type_Aekm = new aekm(this);
  private aekn jdField_a_of_type_Aekn = new aekn(this, 1);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aekh(this);
  private bhzc jdField_a_of_type_Bhzc;
  private bisl jdField_a_of_type_Bisl;
  private String jdField_a_of_type_JavaLangString;
  private Constants.LogoutReason jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.tips;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private aekn jdField_b_of_type_Aekn = new aekn(this, 2);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = "";
  private int jdField_g_of_type_Int;
  private final String jdField_g_of_type_JavaLangString = "lhPaySn";
  private final int h = 1;
  private final int i = 2;
  private final int j = 3;
  private final int k = 4;
  private final int l = 5;
  private final int m = 6;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new String[] { "0X800AA2F", "0X800AA30", "0X800AA31", "0X800AA32" }));
  }
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2131559562);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131365659);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131365658);
    localObject = (TextView)((Window)localObject).findViewById(2131365681);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131698111) + "8.4.10" + getString(2131698110));
    localButton1.setOnClickListener(new aeka(this));
    localButton2.setOnClickListener(new aekc(this));
    return localAlertDialog;
  }
  
  private CharSequence a(String paramString, boolean paramBoolean)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    String str1 = getString(2131698593);
    paramString = getString(2131693731);
    String str2 = str1 + paramString + "。";
    int n = ((String)localObject).length();
    n = str1.length() + n;
    localObject = new SpannableString((String)localObject + str2);
    ((SpannableString)localObject).setSpan(new aejz(this, paramBoolean), n, paramString.length() + n, 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-11692801), n, paramString.length() + n, 33);
    return localObject;
  }
  
  private String a(boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      paramMap = "";
    }
    String str;
    do
    {
      return paramMap;
      if (!paramBoolean) {
        break;
      }
      str = (String)paramMap.get("uin");
      paramMap = str;
    } while (!TextUtils.isEmpty(str));
    return this.jdField_c_of_type_JavaLangString;
    return this.jdField_c_of_type_JavaLangString;
  }
  
  private void a(int paramInt)
  {
    QLog.i("NotificationActivity", 1, "myShowDialog: invoked.  id: " + paramInt);
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    label443:
    Object localObject1;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      switch (paramInt)
      {
      default: 
        sendBroadcast(new Intent("before_account_change"));
        a(false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("NotificationActivity", 1, "myShowDialog: invoked.  throwable: " + localThrowable);
        continue;
        this.jdField_a_of_type_JavaLangString = getString(2131693139);
        this.jdField_b_of_type_JavaLangString = getString(2131693140);
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.jdField_b_of_type_JavaLangString).setPositiveButton(17039370, new aeki(this));
        continue;
        TextView localTextView = new TextView(this);
        localTextView.setLinksClickable(true);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localTextView.setTextSize(getResources().getInteger(2131427336));
        localTextView.setTextColor(getResources().getColor(2131165497));
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("true"))) {}
        for (;;)
        {
          try
          {
            String str1 = getPackageName();
            localTextView.setText(this.jdField_b_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setMessage(this.jdField_b_of_type_JavaLangString).addView(localTextView).setPositiveButton(2131699123, new aekj(this, str1), false);
            paramInt = 1;
            if (paramInt != 0) {
              break;
            }
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              break label443;
            }
            localTextView.setText(Html.fromHtml(this.jdField_b_of_type_JavaLangString));
            this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setMessage(this.jdField_b_of_type_JavaLangString).addView(localTextView).setPositiveButton(2131692031, new aekl(this));
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
          paramInt = 0;
          continue;
          localTextView.setText(Html.fromHtml(getString(2131692891)));
        }
        try
        {
          this.jdField_a_of_type_AndroidAppDialog = a();
        }
        catch (Exception localException1)
        {
          c();
        }
      }
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        localObject1 = this.app.getKickIntent();
        if (localObject1 != null)
        {
          this.jdField_a_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("title");
          this.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("msg");
          this.jdField_a_of_type_MqqAppConstants$LogoutReason = ((Constants.LogoutReason)((Intent)localObject1).getSerializableExtra("reason"));
        }
      }
      if (QQPlayerService.a()) {
        sendBroadcast(new Intent("qqplayer_exit_action"));
      }
      axrb.a().d();
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.kicked) {}
    }
    for (paramInt = 2131694336;; paramInt = 2131694399)
    {
      for (;;)
      {
        int n = 0;
        if (aozj.a().a(this.jdField_b_of_type_JavaLangString))
        {
          bdla.a(null, "dc00898", "", "", "0X800B427", "0X800B427", 0, 0, "", "", "", "");
          n = 1;
        }
        localObject1 = aozj.a().a(this.jdField_b_of_type_JavaLangString, this, n);
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230, this.jdField_a_of_type_JavaLangString, (CharSequence)localObject1, paramInt, 2131694399, null, new aejc(this));
        if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked)
        {
          if ((getIntent() == null) || (!getIntent().getBooleanExtra("isSameDevice", false)) || (isInMultiWindow())) {
            break label741;
          }
          this.jdField_a_of_type_AndroidAppDialog = null;
          d(true);
        }
        for (;;)
        {
          this.app.setKickIntent(null);
          break;
          label741:
          ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131692547, new aejd(this));
          localObject1 = new Intent("com.tencent.tim.kickedLogin.otherDevice");
          ((Intent)localObject1).putExtra("kickedUin", this.app.getAccount());
          ((Intent)localObject1).putExtra("msg", this.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).setPackage("com.tencent.tim");
          sendBroadcast((Intent)localObject1);
        }
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.jdField_b_of_type_JavaLangString).setPositiveButton(17039370, new aeje(this));
        break;
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.jdField_b_of_type_JavaLangString).setPositiveButton(17039370, new aejf(this));
        break;
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle(getString(2131693728)).setMessage(getString(2131718447)).setPositiveButton(getString(2131718449), new aejh(this)).setNegativeButton(getString(2131718446), new aejg(this));
        break;
        if (this.jdField_b_of_type_Int == 40)
        {
          bdla.a(this.app, "dc00898", "", this.jdField_c_of_type_JavaLangString, "0X800AA2F", "0X800AA2F", 0, 0, "", "", "", this.jdField_b_of_type_JavaLangString);
          localObject1 = getIntent();
          if (localObject1 == null) {
            break;
          }
          a((Intent)localObject1);
          b(this.jdField_d_of_type_Boolean);
          break;
        }
        switch (this.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidAppDialog = bhdj.b(this, 230).setMessageWithUrl(this.jdField_b_of_type_JavaLangString).setTitle(getString(2131698791)).setPositiveButton(17039370, new aejj(this));
          break;
        case 41: 
        case 116: 
          localObject1 = (Long)bhzc.a.get(this.jdField_c_of_type_JavaLangString);
          if ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() < 30000L))
          {
            this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle(anvx.a(2131707078)).setMessage(anvx.a(2131707076)).setNegativeButton(anvx.a(2131707085), new aeji(this));
            break;
          }
          i();
          break;
          Object localObject2 = getIntent().getExtras();
          localObject1 = ((Bundle)localObject2).getString("dlg_title");
          String str2 = ((Bundle)localObject2).getString("dlg_content");
          String str3 = ((Bundle)localObject2).getString("dlg_lbutton");
          String str4 = ((Bundle)localObject2).getString("dlg_rbutton");
          localObject2 = ((Bundle)localObject2).getString("dlg_url");
          this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle((String)localObject1).setMessage(str2).setPositiveButton(str4, new aejl(this, (String)localObject2)).setNegativeButton(str3, new aejk(this));
          break;
          localObject1 = getResources().getString(2131693775);
          str2 = getResources().getString(2131693774);
          str3 = getResources().getString(2131693771);
          str4 = getResources().getString(2131693773);
          Object localObject3 = getResources().getString(2131693772);
          localObject2 = new CheckBox(this);
          ((CheckBox)localObject2).setText((CharSequence)localObject3);
          ((CheckBox)localObject2).setTextSize(getResources().getInteger(2131427336));
          ((CheckBox)localObject2).setTextColor(getResources().getColor(2131165497));
          localObject3 = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
          boolean bool = ((SharedPreferences)localObject3).getBoolean("MemoryAlertAutoClear", false);
          ((CheckBox)localObject2).setChecked(bool);
          this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle((String)localObject1).setMessage(str2).setView((View)localObject2).setPositiveButton(str4, new aejn(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3)).setNegativeButton(str3, new aejm(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3));
          break;
          try
          {
            localObject3 = getIntent().getExtras();
            localObject1 = ((Bundle)localObject3).getString("dlg_title", "");
            str2 = ((Bundle)localObject3).getString("dlg_content", "");
            str3 = ((Bundle)localObject3).getString("dlg_lbutton", "");
            str4 = ((Bundle)localObject3).getString("dlg_rbutton", "");
            localObject2 = ((Bundle)localObject3).getString("dlg_url", "");
            paramInt = ((Bundle)localObject3).getInt("dlg_lbtnid", 0);
            n = ((Bundle)localObject3).getInt("dlg_rbtnid", 0);
            localObject3 = String.format("%d", new Object[] { Integer.valueOf(((Bundle)localObject3).getInt("dlg_seccmd", 0)) });
            this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle((String)localObject1).setMessage(str2);
            if (this.jdField_a_of_type_AndroidAppDialog == null) {
              break;
            }
            if (!TextUtils.isEmpty(str4)) {
              ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(str4, new aejo(this, (String)localObject2, n, (String)localObject3));
            }
            if (!TextUtils.isEmpty(str3)) {
              ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setNegativeButton(str3, new aejp(this, paramInt, (String)localObject3));
            }
            bdla.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007534", "0X8007534", 0, 0, (String)localObject3, "", "", "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      break;
    }
  }
  
  private void a(int paramInt, TextView... paramVarArgs)
  {
    int i1 = paramVarArgs.length;
    int n = 0;
    while (n < i1)
    {
      TextView localTextView = paramVarArgs[n];
      if (localTextView != null) {
        localTextView.setTextColor(paramInt);
      }
      n += 1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("parseIntentErrorData", 1, "loginFailedIntent == null");
      return;
    }
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = 2098;
    if (paramIntent.getBooleanExtra("keyFromLoginView", false)) {
      bdla.a(this.app, "dc00898", "", "", "0X800B292", "0X800B292", 0, 0, "", "", this.jdField_b_of_type_JavaLangString, "");
    }
    for (;;)
    {
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("errorUrl");
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("errorver", 0);
      boolean bool = paramIntent.getBooleanExtra("is_need_login_with_mask", false);
      this.jdField_d_of_type_Boolean = aozj.a().a(paramIntent.getByteArrayExtra("tlverror"));
      this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("errortitle");
      this.jdField_f_of_type_Int = aozj.a().a(paramIntent.getByteArrayExtra("tlverror"));
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break;
      }
      c(bool);
      return;
      if (paramIntent.getBooleanExtra("keyFromAddAccount", false)) {
        bdla.a(this.app, "dc00898", "", "", "0X800B294", "0X800B294", 0, 0, "", "", this.jdField_b_of_type_JavaLangString, "");
      }
    }
  }
  
  private void a(QQCustomDialog paramQQCustomDialog)
  {
    if (!"1103".equals(ThemeUtil.getCurrentThemeId())) {
      return;
    }
    TextView localTextView1 = paramQQCustomDialog.getTitleTextView();
    TextView localTextView2 = paramQQCustomDialog.getMessageTextView();
    TextView localTextView3 = paramQQCustomDialog.getBtnLeft();
    TextView localTextView4 = paramQQCustomDialog.getBtnight();
    paramQQCustomDialog = (TextView)paramQQCustomDialog.findViewById(2131365623);
    try
    {
      int n = Color.parseColor("#FFFFFF");
      a(n, new TextView[] { localTextView1, localTextView2, localTextView3, localTextView4, paramQQCustomDialog });
      return;
    }
    catch (Exception paramQQCustomDialog)
    {
      QLog.e("NotificationActivity", 1, "setDialogTextColor: parseColor error", paramQQCustomDialog);
    }
  }
  
  private void a(String paramString)
  {
    if (a())
    {
      localObject = getIntent();
      if (localObject != null) {
        break label44;
      }
    }
    label44:
    for (Object localObject = "";; localObject = ((Intent)localObject).getStringExtra("uin"))
    {
      bdla.b(null, "dc00898", "", (String)localObject, paramString, paramString, 0, 0, "", "", this.jdField_b_of_type_JavaLangString, "");
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      paramString1 = "https://haoma.qq.com/m/expire.html?num=" + this.jdField_c_of_type_JavaLangString;
      paramString2 = new Intent(this, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      startActivity(paramString2);
      c(0);
      finish();
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("unit", anvx.a(2131707079));
        localJSONObject.put("userId", this.jdField_c_of_type_JavaLangString);
        localJSONObject.put("openMonth", paramString1);
        localJSONObject.put("offerId", "1450000833");
        localJSONObject.put("aid", paramString2);
        localJSONObject.put("ticketValue", SecUtil.toHexString(this.jdField_a_of_type_ArrayOfByte));
        localJSONObject.put("ticketName", "vask_27");
        localJSONObject.put("isCanChange", paramBoolean2);
        if (paramBoolean1)
        {
          localJSONObject.put("serviceCode", "CJCLUBT");
          localJSONObject.put("serviceName", "QQ超级会员");
          paramString1 = new Intent(this, PayBridgeActivity.class);
          paramString2 = new Bundle();
          paramString2.putString("json", localJSONObject.toString());
          paramString2.putString("callbackSn", "lhPaySn");
          paramString1.putExtras(paramString2);
          paramString1.putExtra("payparmas_from_is_login_state", false);
          paramString1.putExtra("pay_requestcode", 4);
          startActivityForResult(paramString1, 1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        c(0);
        finish();
        return;
      }
      localJSONObject.put("serviceCode", "LTMCLUB");
      localJSONObject.put("serviceName", "QQ会员");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("NotificationActivity", 1, "showDialog: invoked.  inResume: " + paramBoolean + " isDialogShow: " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {}
    while (((!paramBoolean) && (Build.VERSION.SDK_INT >= 28)) || (this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (isFinishing())) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 8) && (this.jdField_b_of_type_Int == 40))
    {
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new aekg(this));
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        this.jdField_a_of_type_Boolean = true;
        return;
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("NotificationActivity", 1, "showDialog: invoked.  t: " + localThrowable);
      }
    }
  }
  
  private boolean a()
  {
    return this.jdField_e_of_type_Int == 1;
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 41) && (paramInt != 116)) {
      return;
    }
    if (paramInt == 116) {}
    for (boolean bool = true;; bool = false)
    {
      a("3", "mvip.gongneng.android.haoma_03", bool, true);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      d();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      }
      return;
      e();
    }
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("lh_is_from_login_verify_code", false))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("NotificationActivity", 4, String.format(Locale.getDefault(), "checkSetResult, isFromLH: %s, resultCode: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      }
      if (bool)
      {
        localIntent = new Intent();
        localIntent.putExtra("lh_is_from_login_verify_code", true);
        setResult(paramInt, localIntent);
      }
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = MiniAppSecurityUtil.getArgumentsFromURL(this.jdField_d_of_type_JavaLangString);
    if (localObject == null) {
      QLog.e("handleMiniAppFeature", 1, "paramMap == null");
    }
    String str;
    do
    {
      return;
      str = (String)((Map)localObject).get("forbid_token");
      this.jdField_e_of_type_JavaLangString = ((String)((Map)localObject).get("forbid_status"));
    } while ((TextUtils.isEmpty(str)) || (this.jdField_d_of_type_Int != 1));
    this.jdField_c_of_type_Boolean = true;
    localObject = a(paramBoolean, (Map)localObject);
    MiniAppSecurityUtil.updateLoginMiniAppUin(BaseApplicationImpl.sApplication, (String)localObject);
    MiniAppSecurityUtil.updateLoginMiniAppForbidToken(BaseApplicationImpl.sApplication, (String)localObject, str);
  }
  
  private void d()
  {
    bdla.a(this.app, "dc00898", "", "", "0X800B42B", "0X800B42B", 0, 0, "", "", "", "");
    CharSequence localCharSequence = aozj.a().a(this.jdField_b_of_type_JavaLangString + "你也可以对帐号进行<TITLE=\"资金管理\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">。", this, 2);
    int n = 2131694399;
    if (this.jdField_f_of_type_Int == 2)
    {
      this.jdField_g_of_type_Int = 2201;
      n = 2131719825;
    }
    this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230, this.jdField_f_of_type_JavaLangString, localCharSequence, 2131690697, n, new aejq(this), new aejr(this));
  }
  
  private void d(boolean paramBoolean)
  {
    String str = null;
    Object localObject1 = this.app.getApplication().getAllAccounts();
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = this.app.getAccount();
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        localObject3 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (SimpleAccount)((Iterator)localObject3).next();
        } while (!((String)localObject2).equals(((SimpleAccount)localObject1).getUin()));
      }
    }
    for (;;)
    {
      finish();
      this.app.setKickIntent(null);
      if (localObject1 != null)
      {
        bhhr.a(getApplication().getApplicationContext(), ((SimpleAccount)localObject1).getUin(), true);
        if (paramBoolean)
        {
          new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new NotificationActivity.35(this, (SimpleAccount)localObject1), 500L);
          return;
        }
        this.app.login((SimpleAccount)localObject1);
        return;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("password", null);
      if (!azit.a().a(this.app, this.app.getCurrentAccountUin()))
      {
        this.app.updateSubAccountLogin(this.app.getCurrentAccountUin(), false);
        this.app.getApplication().refreAccountList();
      }
      localObject3 = (bdxs)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      localObject1 = str;
      if (localObject3 != null) {
        localObject1 = ((bdxs)localObject3).a();
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          if (!azit.a().a(this.app, str))
          {
            this.app.updateSubAccountLogin(str, false);
            this.app.getApplication().refreAccountList();
          }
        }
      }
      startActivity(new Intent(this, LoginActivity.class).putExtras((Bundle)localObject2).addFlags(67108864));
      return;
      localObject1 = null;
    }
  }
  
  private void e()
  {
    Object localObject;
    String str1;
    if (this.jdField_c_of_type_Boolean)
    {
      bdla.a(this.app, "dc00898", "", "", "0X800AA15", "0X800AA15", 0, 0, "", "", this.jdField_e_of_type_JavaLangString, "");
      str3 = this.jdField_a_of_type_JavaLangString;
      if (a())
      {
        localObject = a(this.jdField_b_of_type_JavaLangString, true);
        if (!a()) {
          break label187;
        }
        str1 = getString(2131693730);
        label77:
        if (!a()) {
          break label198;
        }
      }
      label187:
      label198:
      for (str2 = getString(2131693733);; str2 = getString(2131693731))
      {
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 0, str3, (CharSequence)localObject, str1, str2, getString(2131693734), new aejs(this), new aejt(this), new aeju(this));
        if (a())
        {
          ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).getMessageTextView().setMovementMethod(LinkMovementMethod.getInstance());
          a((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog);
          a("0X800B653");
        }
        return;
        localObject = this.jdField_b_of_type_JavaLangString;
        break;
        str1 = getString(2131693732);
        break label77;
      }
    }
    String str3 = this.jdField_a_of_type_JavaLangString;
    if (a())
    {
      localObject = a(this.jdField_b_of_type_JavaLangString, false);
      label231:
      if (!a()) {
        break label317;
      }
      str1 = getString(2131693730);
      label246:
      if (!a()) {
        break label328;
      }
    }
    label317:
    label328:
    for (String str2 = getString(2131693733);; str2 = getString(2131693731))
    {
      this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 0, str3, (CharSequence)localObject, str1, str2, getString(2131693734), new aejv(this), new aejx(this), new aejy(this));
      break;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label231;
      str1 = getString(2131693735);
      break label246;
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
    this.app.getApp().sendBroadcast(localIntent);
  }
  
  private void g()
  {
    ansg localansg = (ansg)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    if (localansg != null) {
      localansg.b();
    }
  }
  
  private void h()
  {
    int n = this.jdField_a_of_type_Bhzc.b();
    int i1 = this.jdField_a_of_type_Bhzc.a();
    if ((i1 == -1) || (n == -1))
    {
      QQToast.a(this, anvx.a(2131707089), 0).a();
      finish();
      return;
    }
    String str = i1 + "";
    if (n == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, "mvip.p.lh.pay_over", bool, false);
      return;
    }
  }
  
  private void i()
  {
    ThreadManagerV2.excute(new NotificationActivity.36(this), 16, null, true);
  }
  
  private void j()
  {
    ThreadManagerV2.excute(new NotificationActivity.39(this), 16, null, true);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
    }
    if (!this.jdField_a_of_type_Bisl.isShowing())
    {
      this.jdField_a_of_type_Bisl.a(anvx.a(2131707080));
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void a()
  {
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void b()
  {
    Object localObject1 = null;
    if (aozj.a().a(this.jdField_b_of_type_JavaLangString)) {
      bdla.a(null, "dc00898", "", "", "0X800B42A", "0X800B42A", 0, 0, "", "", "", "");
    }
    finish();
    Bundle localBundle = new Bundle();
    localBundle.putString("password", null);
    localBundle.putBoolean("is_from_account_another_login_exit", true);
    if (!azit.a().a(this.app, this.app.getCurrentAccountUin()))
    {
      this.app.updateSubAccountLogin(this.app.getCurrentAccountUin(), false);
      this.app.getApplication().refreAccountList();
    }
    Object localObject2 = (bdxs)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localObject2 != null) {
      localObject1 = ((bdxs)localObject2).a();
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!azit.a().a(this.app, (String)localObject2))
        {
          this.app.updateSubAccountLogin((String)localObject2, false);
          this.app.getApplication().refreAccountList();
        }
      }
    }
    startActivity(new Intent(this, LoginActivity.class).putExtras(localBundle).addFlags(67108864));
  }
  
  public void c()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.app.exit(false);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (LiangHaoBuyFragment.a(paramIntent) != 0) {
        break label24;
      }
    }
    label24:
    for (paramInt1 = -1;; paramInt1 = 0)
    {
      c(paramInt1);
      finish();
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559556);
    Object localObject = "";
    paramBundle = (Bundle)localObject;
    try
    {
      this.jdField_a_of_type_Int = getIntent().getIntExtra("type", 0);
      paramBundle = (Bundle)localObject;
      localObject = getIntent().getAction();
      paramBundle = (Bundle)localObject;
      if (QLog.isColorLevel())
      {
        paramBundle = (Bundle)localObject;
        QLog.d("NotificationActivity", 2, "NotificationActivity action = " + (String)localObject);
      }
      paramBundle = (Bundle)localObject;
      if (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(localObject)) {
        break label366;
      }
      paramBundle = (Bundle)localObject;
      this.jdField_a_of_type_Int = 1;
      paramBundle = (Bundle)localObject;
      g();
    }
    catch (Exception localException)
    {
      try
      {
        do
        {
          for (;;)
          {
            String str;
            paramBundle.mergeFrom((byte[])localObject);
            if (paramBundle.has()) {
              break label502;
            }
            return false;
            paramBundle = (Bundle)localObject;
            if ("mqq.intent.action.ACCOUNT_TIPS".equals(localObject))
            {
              paramBundle = (Bundle)localObject;
              this.jdField_a_of_type_Int = 6;
              continue;
              localException = localException;
              localObject = paramBundle;
              paramBundle = (Bundle)localObject;
              if (QLog.isColorLevel())
              {
                QLog.e("NotificationActivity", 2, "doOnCreate exception", localException);
                paramBundle = (Bundle)localObject;
              }
            }
            else
            {
              paramBundle = (Bundle)localObject;
              if ("mqq.intent.action.ACCOUNT_KICKED".equals(localObject))
              {
                paramBundle = (Bundle)localObject;
                f();
                paramBundle = (Bundle)localObject;
                g();
                paramBundle = (Bundle)localObject;
                this.jdField_a_of_type_Int = 5;
              }
              else
              {
                paramBundle = (Bundle)localObject;
                if (!"mqq.intent.action.GRAY".equals(localObject)) {
                  break;
                }
                paramBundle = (Bundle)localObject;
                this.jdField_a_of_type_Int = 2;
              }
            }
          }
          paramBundle = (Bundle)localObject;
        } while (!"mqq.intent.action.SUSPEND".equals(localObject));
        paramBundle = (Bundle)localObject;
        this.jdField_a_of_type_Int = 4;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if ((paramBundle.str_packname.has()) && (paramBundle.u32_check_result.has()) && (paramBundle.str_right_button.has()) && (paramBundle.str_url.has())) {
          break label560;
        }
        if (!QLog.isColorLevel()) {
          break label558;
        }
        QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
        return false;
        ThreadManager.post(new NotificationActivity.2(this, paramBundle.u32_check_result.get(), paramBundle.u32_cache_time.get()), 5, null, false);
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.jdField_b_of_type_JavaLangString).setPositiveButton(paramBundle.str_right_button.get(), new aejw(this, paramBundle));
        if (!paramBundle.str_left_button.has()) {
          break label668;
        }
        ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setNegativeButton(paramBundle.str_left_button.get(), new aekf(this));
        a(false);
        return true;
      }
    }
    paramBundle = (Bundle)localObject;
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("title");
    paramBundle = (Bundle)localObject;
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("msg");
    paramBundle = (Bundle)localObject;
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("loginalias");
    paramBundle = (Bundle)localObject;
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("expiredSig");
    paramBundle = (Bundle)localObject;
    this.jdField_b_of_type_Int = getIntent().getIntExtra("loginret", 0);
    paramBundle = (Bundle)localObject;
    this.jdField_e_of_type_Int = getIntent().getIntExtra("keyTipsScenesId", 0);
    paramBundle = (Bundle)localObject;
    this.jdField_a_of_type_MqqAppConstants$LogoutReason = ((Constants.LogoutReason)getIntent().getSerializableExtra("reason"));
    paramBundle = (Bundle)localObject;
    str = getIntent().getStringExtra("securityScan");
    if (str != null)
    {
      paramBundle = (Bundle)localObject;
      if ("security_scan".equals(str))
      {
        paramBundle = (Bundle)localObject;
        this.jdField_a_of_type_Int = 7;
      }
    }
    paramBundle = (Bundle)localObject;
    QLog.d("NotificationActivity", 1, "notification activity type:" + this.jdField_a_of_type_Int);
    label558:
    label560:
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramBundle))
    {
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.secKicked)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "NotificationActivity:sec kick");
        }
        localObject = getIntent().getByteArrayExtra("data");
        paramBundle = new signature.SignatureKickData();
      }
      label366:
      label502:
      PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
    }
    label668:
    this.jdField_a_of_type_Bhzc = new bhzc(this.jdField_c_of_type_JavaLangString);
    a(this.jdField_a_of_type_Int);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.closeNotification"));
    return true;
  }
  
  public void doOnDestroy()
  {
    QLog.i("NotificationActivity", 1, "doOnDestroy: invoked.  isDialogShow: " + this.jdField_a_of_type_Boolean);
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
        super.doOnDestroy();
        if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
          jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
        }
        return;
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.i("NotificationActivity", 1, "doOnDestroy: invoked.  t: " + localThrowable2);
        }
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a(true);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131699122, new aejb(this));
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 5))
    {
      this.jdField_e_of_type_Boolean = false;
      b();
    }
  }
  
  public void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
    if (this.jdField_a_of_type_Int == 3) {
      c();
    }
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    super.finish();
    if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, getResources().getString(2131693504), getResources().getString(2131693494), getResources().getString(2131693490), this.jdField_a_of_type_Aekn, anvx.a(2131707088), this.jdField_a_of_type_Aekn, this.jdField_a_of_type_Aekm);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
    case 2: 
      this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, getResources().getString(2131693504), getResources().getString(2131693493), getResources().getString(2131693491), this.jdField_b_of_type_Aekn, getResources().getString(2131693489), this.jdField_b_of_type_Aekn, this.jdField_a_of_type_Aekm);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
    case 3: 
      if (this.jdField_b_of_type_Int == 41) {}
      for (paramMessage = getString(2131694764);; paramMessage = getString(2131694763))
      {
        String str = getString(2131694762);
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230).setMessage(paramMessage).setTitle(str).setNegativeButton(2131694761, new aeke(this)).setPositiveButton(2131694760, new aekd(this));
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.show();
        return true;
      }
    case 4: 
      k();
      return true;
    case 5: 
      l();
      QQToast.a(this, 2, anvx.a(2131707083), 0).b(getTitleBarHeight());
      bhzc.a.put(this.jdField_c_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
      finish();
      return true;
    }
    l();
    QQToast.a(this, 1, anvx.a(2131707082), 0).b(getTitleBarHeight());
    finish();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = this;
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity
 * JD-Core Version:    0.7.0.1
 */
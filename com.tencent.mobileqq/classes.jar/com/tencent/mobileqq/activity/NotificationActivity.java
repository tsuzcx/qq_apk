package com.tencent.mobileqq.activity;

import Override;
import aeqf;
import aeqg;
import aeqh;
import aeqi;
import aeqj;
import aeqk;
import aeql;
import aeqm;
import aeqn;
import aeqo;
import aeqp;
import aeqq;
import aeqr;
import aeqs;
import aeqt;
import aequ;
import aeqv;
import aeqw;
import aeqx;
import aeqy;
import aeqz;
import aerb;
import aerc;
import aerd;
import aere;
import aerf;
import aerg;
import aerh;
import aeri;
import aerk;
import aerl;
import aerm;
import aern;
import aero;
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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import anjo;
import anni;
import axey;
import aywm;
import bcst;
import bdeh;
import bglp;
import bgny;
import bgpa;
import bgsg;
import bhht;
import biau;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class NotificationActivity
  extends BaseActivity
  implements Handler.Callback
{
  public static NotificationActivity a;
  public static final ArrayList<String> a;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">");
  private static final String jdField_g_of_type_JavaLangString;
  private int jdField_a_of_type_Int;
  private aern jdField_a_of_type_Aern = new aern(this);
  private aero jdField_a_of_type_Aero = new aero(this, 1);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aerg(this);
  private bhht jdField_a_of_type_Bhht;
  private biau jdField_a_of_type_Biau;
  private String jdField_a_of_type_JavaLangString;
  private Constants.LogoutReason jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.tips;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private aero jdField_b_of_type_Aero = new aero(this, 2);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private final int jdField_e_of_type_Int = 1;
  private String jdField_e_of_type_JavaLangString;
  private final int jdField_f_of_type_Int = 2;
  private final String jdField_f_of_type_JavaLangString = "lhPaySn";
  private final int jdField_g_of_type_Int = 3;
  private final int h = 4;
  private final int i = 5;
  private final int j = 6;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new String[] { "0X800AA2F", "0X800AA30", "0X800AA31", "0X800AA32" }));
    jdField_g_of_type_JavaLangString = bgny.c.pattern() + "|" + bgny.d.pattern();
  }
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2131559522);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131365490);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131365489);
    localObject = (TextView)((Window)localObject).findViewById(2131365513);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131697598) + "8.4.1" + getString(2131697597));
    localButton1.setOnClickListener(new aeqz(this));
    localButton2.setOnClickListener(new aerc(this));
    return localAlertDialog;
  }
  
  private void a(int paramInt)
  {
    QLog.i("NotificationActivity", 1, "myShowDialog: invoked.  id: " + paramInt);
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
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
        this.jdField_a_of_type_JavaLangString = getString(2131692939);
        this.jdField_b_of_type_JavaLangString = getString(2131692940);
        this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.jdField_b_of_type_JavaLangString).setPositiveButton(17039370, new aerh(this));
        continue;
        TextView localTextView = new TextView(this);
        localTextView.setLinksClickable(true);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localTextView.setTextSize(getResources().getInteger(2131427336));
        localTextView.setTextColor(getResources().getColor(2131165485));
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("true"))) {}
        for (;;)
        {
          try
          {
            String str1 = getPackageName();
            localTextView.setText(this.jdField_b_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setMessage(this.jdField_b_of_type_JavaLangString).addView(localTextView).setPositiveButton(2131698444, new aeri(this, str1), false);
            paramInt = 1;
            if (paramInt != 0) {
              break;
            }
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              break label438;
            }
            localTextView.setText(Html.fromHtml(this.jdField_b_of_type_JavaLangString));
            this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setMessage(this.jdField_b_of_type_JavaLangString).addView(localTextView).setPositiveButton(2131691891, new aerk(this));
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
          paramInt = 0;
          continue;
          label438:
          localTextView.setText(Html.fromHtml(getString(2131692730)));
        }
        try
        {
          this.jdField_a_of_type_AndroidAppDialog = a();
        }
        catch (Exception localException1)
        {
          a();
        }
        continue;
        if (QQPlayerService.a()) {
          sendBroadcast(new Intent("qqplayer_exit_action"));
        }
        axey.a().d();
        paramInt = 2131694081;
        if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
          paramInt = 2131694020;
        }
        localObject1 = a(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230, this.jdField_a_of_type_JavaLangString, (CharSequence)localObject1, paramInt, 2131694081, null, new aerl(this));
        if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
          if ((getIntent() != null) && (getIntent().getBooleanExtra("isSameDevice", false)) && (!isInMultiWindow()))
          {
            this.jdField_a_of_type_AndroidAppDialog = null;
            b(true);
          }
          else
          {
            ((bgpa)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131692392, new aeqg(this));
            localObject1 = new Intent("com.tencent.tim.kickedLogin.otherDevice");
            ((Intent)localObject1).putExtra("kickedUin", this.app.getAccount());
            ((Intent)localObject1).putExtra("msg", this.jdField_b_of_type_JavaLangString);
            ((Intent)localObject1).setPackage("com.tencent.tim");
            sendBroadcast((Intent)localObject1);
            continue;
            this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.jdField_b_of_type_JavaLangString).setPositiveButton(17039370, new aeqh(this));
            continue;
            this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.jdField_b_of_type_JavaLangString).setPositiveButton(17039370, new aeqi(this));
            continue;
            this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle(getString(2131693440)).setMessage(getString(2131717693)).setPositiveButton(getString(2131717695), new aeqk(this)).setNegativeButton(getString(2131717692), new aeqj(this));
          }
        }
      }
      if (this.jdField_b_of_type_Int != 40) {
        break label1196;
      }
    }
    bcst.a(this.app, "dc00898", "", this.jdField_c_of_type_JavaLangString, "0X800AA2F", "0X800AA2F", 0, 0, "", "", "", this.jdField_b_of_type_JavaLangString);
    Object localObject1 = getIntent();
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    String str2;
    if (localObject1 != null)
    {
      this.jdField_d_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("errorUrl");
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("errorver", 0);
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        localObject1 = MiniAppSecurityUtil.getArgumentsFromURL(this.jdField_d_of_type_JavaLangString);
        if (localObject1 != null)
        {
          str2 = (String)((Map)localObject1).get("forbid_token");
          this.jdField_e_of_type_JavaLangString = ((String)((Map)localObject1).get("forbid_status"));
          if ((!TextUtils.isEmpty(str2)) && (this.jdField_d_of_type_Int == 1))
          {
            MiniAppSecurityUtil.updateLoginMiniAppUin(BaseApplicationImpl.sApplication, this.jdField_c_of_type_JavaLangString);
            MiniAppSecurityUtil.updateLoginMiniAppForbidToken(BaseApplicationImpl.sApplication, this.jdField_c_of_type_JavaLangString, str2);
          }
        }
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      for (;;)
      {
        if (paramInt != 0)
        {
          bcst.a(this.app, "dc00898", "", "", "0X800AA15", "0X800AA15", 0, 0, "", "", this.jdField_e_of_type_JavaLangString, "");
          this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 0, null, this.jdField_b_of_type_JavaLangString, getString(2131693443), getString(2131693442), getString(2131693444), new aeql(this), new aeqm(this), new aeqn(this));
          break;
        }
        this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 0, null, this.jdField_b_of_type_JavaLangString, getString(2131693445), getString(2131693442), getString(2131693444), new aeqo(this), new aeqp(this), new aeqq(this));
        break;
        label1196:
        switch (this.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidAppDialog = bglp.b(this, 230).setMessageWithUrl(this.jdField_b_of_type_JavaLangString).setTitle(getString(2131698223)).setPositiveButton(17039370, new aeqs(this));
          break;
        case 41: 
        case 116: 
          localObject1 = (Long)bhht.a.get(this.jdField_c_of_type_JavaLangString);
          if ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() < 30000L))
          {
            this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle(anni.a(2131706389)).setMessage(anni.a(2131706387)).setNegativeButton(anni.a(2131706396), new aeqr(this));
            break;
          }
          e();
          break;
          Object localObject2 = getIntent().getExtras();
          localObject1 = ((Bundle)localObject2).getString("dlg_title");
          str2 = ((Bundle)localObject2).getString("dlg_content");
          String str3 = ((Bundle)localObject2).getString("dlg_lbutton");
          String str4 = ((Bundle)localObject2).getString("dlg_rbutton");
          localObject2 = ((Bundle)localObject2).getString("dlg_url");
          this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle((String)localObject1).setMessage(str2).setPositiveButton(str4, new aequ(this, (String)localObject2)).setNegativeButton(str3, new aeqt(this));
          break;
          localObject1 = getResources().getString(2131693484);
          str2 = getResources().getString(2131693483);
          str3 = getResources().getString(2131693480);
          str4 = getResources().getString(2131693482);
          Object localObject3 = getResources().getString(2131693481);
          localObject2 = new CheckBox(this);
          ((CheckBox)localObject2).setText((CharSequence)localObject3);
          ((CheckBox)localObject2).setTextSize(getResources().getInteger(2131427336));
          ((CheckBox)localObject2).setTextColor(getResources().getColor(2131165485));
          localObject3 = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
          boolean bool = ((SharedPreferences)localObject3).getBoolean("MemoryAlertAutoClear", false);
          ((CheckBox)localObject2).setChecked(bool);
          this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle((String)localObject1).setMessage(str2).setView((View)localObject2).setPositiveButton(str4, new aeqw(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3)).setNegativeButton(str3, new aeqv(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3));
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
            int k = ((Bundle)localObject3).getInt("dlg_rbtnid", 0);
            localObject3 = String.format("%d", new Object[] { Integer.valueOf(((Bundle)localObject3).getInt("dlg_seccmd", 0)) });
            this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle((String)localObject1).setMessage(str2);
            if (this.jdField_a_of_type_AndroidAppDialog == null) {
              break;
            }
            if (!TextUtils.isEmpty(str4)) {
              ((bgpa)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(str4, new aeqx(this, (String)localObject2, k, (String)localObject3));
            }
            if (!TextUtils.isEmpty(str3)) {
              ((bgpa)this.jdField_a_of_type_AndroidAppDialog).setNegativeButton(str3, new aeqy(this, paramInt, (String)localObject3));
            }
            bcst.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007534", "0X8007534", 0, 0, (String)localObject3, "", "", "");
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
        localJSONObject.put("unit", anni.a(2131706390));
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
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("NotificationActivity", 1, "showDialog: invoked.  t: " + localThrowable);
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
    }
    Intent localIntent = new Intent();
    if (localIntent != null)
    {
      localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
      this.app.getApp().sendBroadcast(localIntent);
    }
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
        bgsg.a(getApplication().getApplicationContext(), ((SimpleAccount)localObject1).getUin(), true);
        if (paramBoolean)
        {
          new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new NotificationActivity.31(this, (SimpleAccount)localObject1), 500L);
          return;
        }
        this.app.login((SimpleAccount)localObject1);
        return;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("password", null);
      if (!aywm.a().a(this.app, this.app.getCurrentAccountUin()))
      {
        this.app.updateSubAccountLogin(this.app.getCurrentAccountUin(), false);
        this.app.getApplication().refreAccountList();
      }
      localObject3 = (bdeh)this.app.getManager(61);
      localObject1 = str;
      if (localObject3 != null) {
        localObject1 = ((bdeh)localObject3).a();
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          if (!aywm.a().a(this.app, str))
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
  
  private void c()
  {
    anjo localanjo = (anjo)this.app.a(4);
    if (localanjo != null) {
      localanjo.b();
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
  
  private void d()
  {
    int k = this.jdField_a_of_type_Bhht.b();
    int m = this.jdField_a_of_type_Bhht.a();
    if ((m == -1) || (k == -1))
    {
      QQToast.a(this, anni.a(2131706400), 0).a();
      finish();
      return;
    }
    String str = m + "";
    if (k == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, "mvip.p.lh.pay_over", bool, false);
      return;
    }
  }
  
  private void e()
  {
    ThreadManagerV2.excute(new NotificationActivity.32(this), 16, null, true);
  }
  
  private void f()
  {
    ThreadManagerV2.excute(new NotificationActivity.35(this), 16, null, true);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Biau == null) {
      this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
    }
    if (!this.jdField_a_of_type_Biau.isShowing())
    {
      this.jdField_a_of_type_Biau.a(anni.a(2131706391));
      this.jdField_a_of_type_Biau.show();
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
      this.jdField_a_of_type_Biau.dismiss();
    }
  }
  
  public CharSequence a(String paramString)
  {
    if (paramString == null) {}
    while (!bgny.b.matcher(paramString).find()) {
      return paramString;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    int n = 0;
    int k = 0;
    int m = 0;
    String str;
    Object localObject;
    if (localMatcher.find())
    {
      n = localMatcher.start(0);
      m = localMatcher.end(0);
      str = paramString.substring(localMatcher.start(1), localMatcher.end(1));
      localObject = paramString.substring(localMatcher.start(2), localMatcher.end(2));
      if (k == n) {
        break label401;
      }
      localSpannableStringBuilder.append(paramString.substring(k, n));
      k = m;
    }
    label401:
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new aerm((String)localObject, new WeakReference(this)), 0, str.length(), 33);
      localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131165783)), 0, str.length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
      n = 1;
      break;
      if (n != 0)
      {
        localSpannableStringBuilder.append(paramString.substring(m));
        return localSpannableStringBuilder;
      }
      localMatcher = Pattern.compile(jdField_g_of_type_JavaLangString, 2).matcher(paramString);
      k = 0;
      m = 0;
      while (localMatcher.find())
      {
        int i1 = localMatcher.start();
        m = localMatcher.end();
        str = paramString.substring(i1, m);
        n = k;
        if (k != i1)
        {
          localSpannableStringBuilder.append(paramString.substring(k, i1));
          n = m;
        }
        localObject = new SpannableString(str);
        ((SpannableString)localObject).setSpan(new aerm(str, new WeakReference(this)), 0, str.length(), 33);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(2131165783)), 0, str.length(), 33);
        localSpannableStringBuilder.append((CharSequence)localObject);
        k = n;
      }
      localSpannableStringBuilder.append(paramString.substring(m));
      return localSpannableStringBuilder;
    }
  }
  
  public void a()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.app.b(false);
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
    super.setContentView(2131559516);
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
        break label347;
      }
      paramBundle = (Bundle)localObject;
      this.jdField_a_of_type_Int = 1;
      paramBundle = (Bundle)localObject;
      c();
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
              break label482;
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
                b();
                paramBundle = (Bundle)localObject;
                c();
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
          break label540;
        }
        if (!QLog.isColorLevel()) {
          break label538;
        }
        QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
        return false;
        ThreadManager.post(new NotificationActivity.2(this, paramBundle.u32_check_result.get(), paramBundle.u32_cache_time.get()), 5, null, false);
        this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.jdField_b_of_type_JavaLangString).setPositiveButton(paramBundle.str_right_button.get(), new aerb(this, paramBundle));
        if (!paramBundle.str_left_button.has()) {
          break label648;
        }
        ((bgpa)this.jdField_a_of_type_AndroidAppDialog).setNegativeButton(paramBundle.str_left_button.get(), new aerf(this));
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
    label538:
    label540:
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
      label347:
      label482:
      PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
    }
    label648:
    this.jdField_a_of_type_Bhht = new bhht(this.jdField_c_of_type_JavaLangString);
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
      ((bgpa)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131698443, new aeqf(this));
    }
  }
  
  public void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
    if (this.jdField_a_of_type_Int == 3) {
      a();
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
      this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, getResources().getString(2131693223), getResources().getString(2131693213), getResources().getString(2131693209), this.jdField_a_of_type_Aero, anni.a(2131706399), this.jdField_a_of_type_Aero, this.jdField_a_of_type_Aern);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
    case 2: 
      this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, getResources().getString(2131693223), getResources().getString(2131693212), getResources().getString(2131693210), this.jdField_b_of_type_Aero, getResources().getString(2131693208), this.jdField_b_of_type_Aero, this.jdField_a_of_type_Aern);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
    case 3: 
      if (this.jdField_b_of_type_Int == 41) {}
      for (paramMessage = getString(2131694407);; paramMessage = getString(2131694406))
      {
        String str = getString(2131694405);
        this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, 230).setMessage(paramMessage).setTitle(str).setNegativeButton(2131694404, new aere(this)).setPositiveButton(2131694403, new aerd(this));
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.show();
        return true;
      }
    case 4: 
      g();
      return true;
    case 5: 
      h();
      QQToast.a(this, 2, anni.a(2131706394), 0).b(getTitleBarHeight());
      bhht.a.put(this.jdField_c_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
      finish();
      return true;
    }
    h();
    QQToast.a(this, 1, anni.a(2131706393), 0).b(getTitleBarHeight());
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
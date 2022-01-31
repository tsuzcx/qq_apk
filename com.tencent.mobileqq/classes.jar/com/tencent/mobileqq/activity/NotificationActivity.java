package com.tencent.mobileqq.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tcf;
import tch;
import tci;
import tcj;
import tck;
import tcl;
import tcm;
import tcn;
import tco;
import tcp;
import tcq;
import tcr;
import tcs;
import tct;
import tcu;
import tcv;
import tcw;
import tcx;
import tcy;
import tcz;
import tdb;
import tdc;
import tdd;
import tde;
import tdf;
import tdg;
import tdh;
import tdk;
import tdl;
import tdm;

public class NotificationActivity
  extends BaseActivity
{
  public static NotificationActivity a;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">");
  private static final String e = Patterns.c.pattern() + "|" + Patterns.d.pattern();
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new tdf(this);
  String jdField_a_of_type_JavaLangString = "http://fwd.z.qq.com:8080/forward.jsp?bid=906";
  private Constants.LogoutReason jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.tips;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private final int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString;
  private String d = "";
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2130969141);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131365343);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131365342);
    localObject = (TextView)((Window)localObject).findViewById(2131365337);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131435049) + "7.6.3" + getString(2131435050));
    localButton1.setOnClickListener(new tcz(this));
    localButton2.setOnClickListener(new tdb(this));
    return localAlertDialog;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      sendBroadcast(new Intent("before_account_change"));
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      this.jdField_b_of_type_JavaLangString = getString(2131433792);
      this.jdField_c_of_type_JavaLangString = getString(2131433794);
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString).setPositiveButton(17039370, new tdg(this));
      continue;
      TextView localTextView = new TextView(this);
      localTextView.setLinksClickable(true);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      localTextView.setTextSize(getResources().getInteger(2131689474));
      localTextView.setTextColor(getResources().getColor(2131492879));
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals("true"))) {}
      for (;;)
      {
        try
        {
          String str1 = getPackageName();
          localTextView.setText(this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(this.jdField_c_of_type_JavaLangString).addView(localTextView).setPositiveButton(2131437491, new tdh(this, str1), false);
          paramInt = 1;
          if (paramInt != 0) {
            break;
          }
          if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            break label408;
          }
          localTextView.setText(Html.fromHtml(this.jdField_c_of_type_JavaLangString));
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(this.jdField_c_of_type_JavaLangString).addView(localTextView).setPositiveButton(2131433519, new tdk(this));
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
        paramInt = 0;
        continue;
        label408:
        localTextView.setText(Html.fromHtml(getString(2131433217)));
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
      GameRoomAVController.a().d();
      paramInt = 2131433016;
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
        paramInt = 2131436544;
      }
      Object localObject1 = a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230, this.jdField_b_of_type_JavaLangString, (CharSequence)localObject1, paramInt, 2131433016, null, new tdl(this));
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
        if ((getIntent() != null) && (getIntent().getBooleanExtra("isSameDevice", false)) && (!isInMultiWindow()))
        {
          this.jdField_a_of_type_AndroidAppDialog = null;
          a(true);
        }
        else
        {
          ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131433234, new tch(this));
          localObject1 = new Intent("com.tencent.tim.kickedLogin.otherDevice");
          ((Intent)localObject1).putExtra("kickedUin", this.app.getAccount());
          ((Intent)localObject1).putExtra("msg", this.jdField_c_of_type_JavaLangString);
          ((Intent)localObject1).setPackage("com.tencent.tim");
          sendBroadcast((Intent)localObject1);
          continue;
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString).setPositiveButton(17039370, new tci(this));
          continue;
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString).setPositiveButton(17039370, new tcj(this));
          continue;
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131435148)).setMessage(getString(2131435151)).setPositiveButton(getString(2131435149), new tcl(this)).setNegativeButton(getString(2131435150), new tck(this));
          continue;
          if (this.jdField_b_of_type_Int == 40) {
            this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 0, null, this.jdField_c_of_type_JavaLangString, getString(2131436528), getString(2131436530), getString(2131436529), new tcm(this), new tcn(this), new tco(this));
          } else {
            switch (this.jdField_b_of_type_Int)
            {
            default: 
              this.jdField_a_of_type_AndroidAppDialog = DialogUtil.b(this, 230).setMessageWithUrl(this.jdField_c_of_type_JavaLangString).setTitle(getString(2131433875)).setPositiveButton(17039370, new tcs(this));
              break;
            case 41: 
            case 116: 
              if (this.jdField_b_of_type_Int == 41) {}
              for (localObject1 = getString(2131435152);; localObject1 = getString(2131435153))
              {
                str2 = getString(2131435162);
                this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage((CharSequence)localObject1).setTitle(str2).setNegativeButton(2131435154, new tcq(this)).setPositiveButton(2131435155, new tcp(this));
                break;
              }
              Object localObject2 = getIntent().getExtras();
              localObject1 = ((Bundle)localObject2).getString("dlg_title");
              String str2 = ((Bundle)localObject2).getString("dlg_content");
              String str3 = ((Bundle)localObject2).getString("dlg_lbutton");
              String str4 = ((Bundle)localObject2).getString("dlg_rbutton");
              localObject2 = ((Bundle)localObject2).getString("dlg_url");
              this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2).setPositiveButton(str4, new tcu(this, (String)localObject2)).setNegativeButton(str3, new tct(this));
              continue;
              localObject1 = getResources().getString(2131437007);
              str2 = getResources().getString(2131437008);
              str3 = getResources().getString(2131437011);
              str4 = getResources().getString(2131437010);
              Object localObject3 = getResources().getString(2131437009);
              localObject2 = new CheckBox(this);
              ((CheckBox)localObject2).setText((CharSequence)localObject3);
              ((CheckBox)localObject2).setTextSize(getResources().getInteger(2131689474));
              ((CheckBox)localObject2).setTextColor(getResources().getColor(2131492879));
              localObject3 = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
              boolean bool = ((SharedPreferences)localObject3).getBoolean("MemoryAlertAutoClear", false);
              ((CheckBox)localObject2).setChecked(bool);
              this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2).setView((View)localObject2).setPositiveButton(str4, new tcw(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3)).setNegativeButton(str3, new tcv(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3));
              continue;
              try
              {
                localObject3 = getIntent().getExtras();
                localObject1 = ((Bundle)localObject3).getString("dlg_title", "");
                str2 = ((Bundle)localObject3).getString("dlg_content", "");
                str3 = ((Bundle)localObject3).getString("dlg_lbutton", "");
                str4 = ((Bundle)localObject3).getString("dlg_rbutton", "");
                localObject2 = ((Bundle)localObject3).getString("dlg_url", "");
                paramInt = ((Bundle)localObject3).getInt("dlg_lbtnid", 0);
                int i = ((Bundle)localObject3).getInt("dlg_rbtnid", 0);
                localObject3 = String.format("%d", new Object[] { Integer.valueOf(((Bundle)localObject3).getInt("dlg_seccmd", 0)) });
                this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2);
                if (this.jdField_a_of_type_AndroidAppDialog != null)
                {
                  if (!TextUtils.isEmpty(str4)) {
                    ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(str4, new tcx(this, (String)localObject2, i, (String)localObject3));
                  }
                  if (!TextUtils.isEmpty(str3)) {
                    ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setNegativeButton(str3, new tcy(this, paramInt, (String)localObject3));
                  }
                  ReportController.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007534", "0X8007534", 0, 0, (String)localObject3, "", "", "");
                }
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
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
        SharedPreUtils.a(getApplication().getApplicationContext(), ((SimpleAccount)localObject1).getUin(), true);
        if (paramBoolean)
        {
          new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new tdc(this, (SimpleAccount)localObject1), 500L);
          return;
        }
        this.app.login((SimpleAccount)localObject1);
        return;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("password", null);
      if (!PhoneNumLoginImpl.a().a(this.app, this.app.getCurrentAccountUin()))
      {
        this.app.updateSubAccountLogin(this.app.getCurrentAccountUin(), false);
        this.app.getApplication().refreAccountList();
      }
      localObject3 = (SubAccountManager)this.app.getManager(60);
      localObject1 = str;
      if (localObject3 != null) {
        localObject1 = ((SubAccountManager)localObject3).a();
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          if (!PhoneNumLoginImpl.a().a(this.app, str))
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
    Object localObject;
    Intent localIntent;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      localObject = "http://haoma.qq.com/m/expire.html?num=" + this.d;
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      startActivity(localIntent);
      finish();
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("unit", "月");
        ((JSONObject)localObject).put("userId", this.d);
        ((JSONObject)localObject).put("openMonth", "3");
        ((JSONObject)localObject).put("offerId", "1450000833");
        ((JSONObject)localObject).put("aid", "mvip.gongneng.android.haoma_03");
        ((JSONObject)localObject).put("ticketValue", SecUtil.toHexString(this.jdField_a_of_type_ArrayOfByte));
        ((JSONObject)localObject).put("ticketName", "vask_27");
        switch (paramInt)
        {
        case 41: 
          localIntent = new Intent(this, PayBridgeActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putString("json", ((JSONObject)localObject).toString());
          localBundle.putString("callbackSn", "0");
          localIntent.putExtras(localBundle);
          localIntent.putExtra("payparmas_from_is_login_state", false);
          localIntent.putExtra("pay_requestcode", 4);
          startActivityForResult(localIntent, 1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        finish();
        return;
      }
      localException.put("serviceCode", "LTMCLUB");
      localException.put("serviceName", "QQ会员");
      continue;
      localException.put("serviceCode", "CJCLUBT");
      localException.put("serviceName", "QQ超级会员");
    }
  }
  
  private void c()
  {
    ConfigHandler localConfigHandler = (ConfigHandler)this.app.a(4);
    if (localConfigHandler != null) {
      localConfigHandler.b();
    }
  }
  
  public CharSequence a(String paramString)
  {
    if (paramString == null) {}
    while (!Patterns.b.matcher(paramString).find()) {
      return paramString;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    int k = 0;
    int i = 0;
    int j = 0;
    String str;
    Object localObject;
    if (localMatcher.find())
    {
      k = localMatcher.start(0);
      j = localMatcher.end(0);
      str = paramString.substring(localMatcher.start(1), localMatcher.end(1));
      localObject = paramString.substring(localMatcher.start(2), localMatcher.end(2));
      if (i == k) {
        break label401;
      }
      localSpannableStringBuilder.append(paramString.substring(i, k));
      i = j;
    }
    label401:
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new tdm((String)localObject, new WeakReference(this)), 0, str.length(), 33);
      localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131493045)), 0, str.length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
      k = 1;
      break;
      if (k != 0)
      {
        localSpannableStringBuilder.append(paramString.substring(j));
        return localSpannableStringBuilder;
      }
      localMatcher = Pattern.compile(e, 2).matcher(paramString);
      i = 0;
      j = 0;
      while (localMatcher.find())
      {
        int m = localMatcher.start();
        j = localMatcher.end();
        str = paramString.substring(m, j);
        k = i;
        if (i != m)
        {
          localSpannableStringBuilder.append(paramString.substring(i, m));
          k = j;
        }
        localObject = new SpannableString(str);
        ((SpannableString)localObject).setSpan(new tdm(str, new WeakReference(this)), 0, str.length(), 33);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(2131493045)), 0, str.length(), 33);
        localSpannableStringBuilder.append((CharSequence)localObject);
        i = k;
      }
      localSpannableStringBuilder.append(paramString.substring(j));
      return localSpannableStringBuilder;
    }
  }
  
  public void a()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.app.b(false);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130969139);
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
        break label349;
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
              break label485;
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
          break label543;
        }
        if (!QLog.isColorLevel()) {
          break label541;
        }
        QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
        return false;
        ThreadManager.post(new tcr(this, paramBundle.u32_check_result.get(), paramBundle.u32_cache_time.get()), 5, null, false);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString).setPositiveButton(paramBundle.str_right_button.get(), new tdd(this, paramBundle));
        if (!paramBundle.str_left_button.has()) {
          break label651;
        }
        ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setNegativeButton(paramBundle.str_left_button.get(), new tde(this));
        if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (isFinishing())) {
          break label690;
        }
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.show();
        return true;
      }
    }
    paramBundle = (Bundle)localObject;
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("title");
    paramBundle = (Bundle)localObject;
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("msg");
    paramBundle = (Bundle)localObject;
    this.d = getIntent().getStringExtra("loginalias");
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
    QLog.d("qqBaseActivity", 1, "notification activity type:" + this.jdField_a_of_type_Int);
    label541:
    label543:
    label690:
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
      label349:
      label485:
      PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
    }
    label651:
    a(this.jdField_a_of_type_Int);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.closeNotification"));
    return false;
  }
  
  protected void doOnDestroy()
  {
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
      super.doOnDestroy();
      if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
        jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131437492, new tcf(this));
    }
  }
  
  protected void doOnUserLeaveHint()
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = this;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity
 * JD-Core Version:    0.7.0.1
 */
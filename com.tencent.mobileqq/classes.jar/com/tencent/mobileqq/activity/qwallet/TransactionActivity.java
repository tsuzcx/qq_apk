package com.tencent.mobileqq.activity.qwallet;

import aepi;
import aiww;
import aiwx;
import aiwy;
import aiwz;
import aixa;
import aixb;
import ajeu;
import altm;
import alto;
import alud;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import azri;
import bdao;
import bdbk;
import bdgc;
import bdgm;
import bdjz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.widget.YellowTipsLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class TransactionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  altm jdField_a_of_type_Altm = new aiwy(this);
  private Context jdField_a_of_type_AndroidContentContext;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  protected TextWatcher b;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 140;
  private View jdField_d_of_type_AndroidViewView;
  private EditText jdField_d_of_type_AndroidWidgetEditText;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  
  public TransactionActivity()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new aiww(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new aiwz(this);
  }
  
  private String a(float paramFloat)
  {
    if ((paramFloat >= 1000.0F) && (paramFloat <= 9999.0F)) {
      return alud.a(2131715435);
    }
    if ((paramFloat >= 10000.0F) && (paramFloat <= 99999.0F)) {
      return alud.a(2131715439);
    }
    if ((paramFloat >= 100000.0F) && (paramFloat <= 999999.0F)) {
      return alud.a(2131715438);
    }
    if ((paramFloat >= 1000000.0F) && (paramFloat <= 9999999.0F)) {
      return alud.a(2131715436);
    }
    if ((paramFloat >= 10000000.0F) && (paramFloat < 1.0E+008F)) {
      return alud.a(2131715434);
    }
    return "";
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new BigDecimal(paramString);
      BigDecimal localBigDecimal = new BigDecimal("100");
      paramString = new DecimalFormat("#").format(paramString.multiply(localBigDecimal).doubleValue());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt < 0) {
      return "0";
    }
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "0";
  }
  
  private void a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("TargetUin", this.jdField_f_of_type_JavaLangString);
      localJSONObject.put("PayeeNick", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("pay_status", paramString);
      paramString = new JSONObject();
      paramString.put("userId", this.jdField_a_of_type_JavaLangString);
      paramString.put("viewTag", "transferPush");
      paramString.put("comeForm", this.jdField_a_of_type_Int);
      paramString.put("appInfo", this.h);
      paramString.put("extra_data", localJSONObject.toString());
      PayBridgeActivity.tenpay(this, paramString.toString(), 5, "0");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((!ImmersiveUtils.a(true, getWindow())) && (Build.VERSION.SDK_INT >= 21)) {
        getWindow().setStatusBarColor(637534208);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#f8f8f8"));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130842910, 0, 0, 0);
      return;
    }
    if ((!ImmersiveUtils.a(false, getWindow())) && (Build.VERSION.SDK_INT >= 21)) {
      getWindow().setStatusBarColor(0);
    }
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { getResources().getColor(2131166108), getResources().getColor(2131166107) });
    if (Build.VERSION.SDK_INT <= 15) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(localGradientDrawable);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130846923, 0, 0, 0);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackground(localGradientDrawable);
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if ((paramString.indexOf('.') != 0) && ((paramString.indexOf('.') <= 0) || (paramString.indexOf('.') >= paramString.length() - 3))) {
        try
        {
          double d1 = Double.valueOf(paramString).doubleValue();
          if (d1 > 0.0D) {
            if (this.jdField_d_of_type_Boolean)
            {
              int i1 = this.jdField_c_of_type_Int;
              if (i1 > d1 * 100.0D) {}
            }
            else
            {
              return true;
            }
          }
        }
        catch (Exception paramString) {}
      }
    }
    return false;
  }
  
  private void c()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.p)) {}
      for (String str = "向陌生人转账最低1.00元！";; str = this.p)
      {
        ThreadManager.getUIHandler().post(new TransactionActivity.4(this, str));
        return;
      }
    }
    ThreadManager.getUIHandler().post(new TransactionActivity.5(this));
  }
  
  private void d()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_JavaLangString);; localObject = "")
    {
      localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("skey", (String)localObject);
      localBundle.putString("skey_type", "2");
      localBundle.putInt("PayInvokerId", 21);
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, this.app, localBundle);
      return;
    }
  }
  
  private void e()
  {
    JSONObject localJSONObject = YellowTipsLayout.getYellowTipsConfig(getApplicationContext(), this.jdField_a_of_type_JavaLangString);
    YellowTipsLayout localYellowTipsLayout = (YellowTipsLayout)findViewById(2131371054);
    if ((localYellowTipsLayout != null) && (localYellowTipsLayout.setYellowTipsJsonConfig(localJSONObject, "transfer_ad"))) {
      this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
    }
  }
  
  public int a(Context paramContext)
  {
    try
    {
      int i1 = paramContext.getResources().getDimensionPixelSize(2131298914);
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      return i1 - (int)(f1 * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  @TargetApi(14)
  protected void a()
  {
    Object localObject1;
    try
    {
      setContentView(2131561786);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376034));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131373031);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131373065);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131376044);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131363254);
      e();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378250));
      this.jdField_e_of_type_AndroidViewView = findViewById(2131370421);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378251));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131362556));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371635));
      this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131377570));
      this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370158));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371646));
      this.jdField_c_of_type_AndroidWidgetEditText.setOnEditorActionListener(new aixa(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378247));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131377564));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377589));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377588));
      String str = ajeu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_d_of_type_JavaLangString, aepi.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str + "(" + this.jdField_f_of_type_JavaLangString + ")");
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378248));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368655));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(alud.a(2131715437));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ("transferInput".equals(this.i))
      {
        a(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131697462);
        getWindow().setWindowAnimations(2131755460);
        this.jdField_d_of_type_AndroidWidgetEditText.requestFocus();
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
        {
          this.jdField_d_of_type_AndroidWidgetEditText.setText(this.jdField_f_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetEditText.setSelection(this.jdField_f_of_type_JavaLangString.length());
        }
        this.j = "3";
        this.jdField_a_of_type_Int = 2;
        if ((this.jdField_e_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_AndroidWidgetButton.performClick();
          this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378249));
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        finish();
        continue;
        new Handler().postDelayed(new TransactionActivity.7(this), 100L);
      }
      a(true);
      localObject1 = (alto)this.app.getManager(51);
      if (((alto)localObject1).e(this.jdField_f_of_type_JavaLangString) == null) {
        break label907;
      }
    }
    label724:
    Object localObject2;
    if (((alto)localObject1).b(this.jdField_f_of_type_JavaLangString))
    {
      localObject1 = getString(2131697529);
      if (this.jdField_a_of_type_Int != 2) {
        break label923;
      }
      localObject2 = (String)localObject1 + getString(2131697533);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697536));
      label771:
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        break label975;
      }
      if (!TextUtils.isEmpty(this.m)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.m);
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_e_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, "100", 2);
        this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = bdbk.a(this.app, 1, this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break;
      label907:
      localObject1 = getString(2131697531);
      this.jdField_d_of_type_Boolean = true;
      break label724;
      label923:
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Int != 5) {
        break label771;
      }
      localObject2 = (String)localObject1 + getString(2131697532);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697541));
      break label771;
      label975:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#f8f8f8"));
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      new Handler().postDelayed(new TransactionActivity.8(this), 100L);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      new Bundle();
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("resultCode", paramInt);
      label29:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.jdField_g_of_type_JavaLangString);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", paramBundle.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).b(a(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    paramString5 = new StringBuilder();
    paramString5.append("Tenpay_mqq");
    paramString5.append("|");
    paramString5.append(paramString1);
    paramString5.append("||");
    paramString5.append(paramInt1);
    paramString5.append("|");
    paramString5.append(paramString2);
    paramString5.append("|0|1|0|android.");
    try
    {
      paramString5.append(this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName);
      paramString5.append("|");
      paramString5.append(bdao.a());
      paramString5.append("|");
      if ((!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
      {
        paramString5.append(paramString3);
        paramString5.append(".");
        paramString5.append(paramString4);
      }
      paramString5.append("|");
      paramString5.append(this.jdField_a_of_type_Int);
      paramString5.append(".");
      if (!TextUtils.isEmpty(this.h)) {
        paramString5.append(this.h.replace("|", ","));
      }
      paramString5.append("|");
      VACDReportUtil.a(this.jdField_a_of_type_Long, null, paramString2, "op_type=" + paramInt1, 0, "");
      azri.a(BaseApplication.getContext()).b(this.app, paramString5.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("PayeeUin", this.jdField_f_of_type_JavaLangString);
      localJSONObject1.put("PayeeNick", this.jdField_d_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        localJSONObject1.put("Amout", a(this.jdField_e_of_type_JavaLangString));
        localJSONObject1.put("Memo", this.m);
      }
      for (;;)
      {
        localJSONObject1.put("ComeFrom", this.jdField_a_of_type_Int);
        localJSONObject1.put("HistransSign", this.jdField_c_of_type_JavaLangString);
        localJSONObject1.put("source", this.j);
        localJSONObject1.put("group_type", this.k);
        localJSONObject1.put("group_uin", this.l);
        localJSONObject1.put("na_from_h5_data", this.n);
        localJSONObject1.put("h5_success", true);
        JSONObject localJSONObject2 = new JSONObject();
        if ("transferInput".equals(this.i))
        {
          localJSONObject2.put("getpayee_type", 1);
          localJSONObject2.put("payee_uin", this.jdField_f_of_type_JavaLangString);
          localJSONObject2.put("payee_nick", this.jdField_d_of_type_JavaLangString);
        }
        localJSONObject2.put("fromPage", "AioTransfer");
        localJSONObject1.put("transPay_data", localJSONObject2.toString());
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("userId", this.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("viewTag", "transferInfor");
        localJSONObject2.put("comeForm", this.jdField_a_of_type_Int);
        localJSONObject2.put("appInfo", this.h);
        localJSONObject2.put("extra_data", localJSONObject1.toString());
        PayBridgeActivity.tenpay(this, localJSONObject2.toString(), 5, "0");
        return;
        localJSONObject1.put("Amout", a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
        localJSONObject1.put("Memo", this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.jdField_a_of_type_Long = getIntent().getLongExtra("vacreport_key_seq", 0L);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "transfer", "transinvoke", null, 0, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext = this;
      addObserver(this.jdField_a_of_type_Altm);
      try
      {
        this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        this.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
        this.jdField_a_of_type_Int = getIntent().getIntExtra("come_from", 1);
        this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("callbackSn");
        this.h = getIntent().getStringExtra("app_info");
        this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("fromJump", false);
        this.i = getIntent().getStringExtra("tag");
        this.jdField_e_of_type_Boolean = getIntent().getBooleanExtra("avoidInput", false);
        paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
        this.jdField_f_of_type_JavaLangString = paramBundle.optString("targetUin");
        this.jdField_d_of_type_JavaLangString = paramBundle.optString("targetNickname");
        this.jdField_e_of_type_JavaLangString = paramBundle.optString("trans_fee");
        this.m = paramBundle.optString("desc");
        this.jdField_c_of_type_JavaLangString = paramBundle.optString("sign");
        this.j = paramBundle.optString("source");
        this.k = paramBundle.optString("group_type");
        this.l = paramBundle.optString("group_uin");
        this.n = paramBundle.optString("na_from_h5_data");
        a();
        a("1");
        ThreadManager.getFileThreadHandler().post(new TransactionActivity.3(this));
        if (QWalletHelper.isNeedPreConnect(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, "type_mqq_and_myun")) {
          d();
        }
        return true;
        VACDReportUtil.a(this.jdField_a_of_type_Long, null, "transinvoke", null, 0, null);
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Altm);
    super.doOnDestroy();
    if (this.jdField_a_of_type_Long != 0L) {
      VACDReportUtil.endReport(this.jdField_a_of_type_Long, "transfer.qqid.destroy", null, 0, null);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    try
    {
      getWindow().setSoftInputMode(16);
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
      {
        a(this.jdField_a_of_type_JavaLangString, 128, "transfer.qqid.show", "", "", this.jdField_a_of_type_Int, "");
        return;
      }
      a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amount.show", "", "", this.jdField_a_of_type_Int, "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_c_of_type_Boolean = false;
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("result");
      if ((paramIntent == null) || (paramIntent.length() <= 0)) {
        break label114;
      }
    }
    int i1;
    label114:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject(paramIntent);
            i1 = paramInt2;
            if (localObject1 == null) {
              break label128;
            }
            localObject1 = null;
          }
          catch (Exception paramIntent)
          {
            try
            {
              i1 = ((JSONObject)localObject1).optInt("resultCode", -1);
              paramInt2 = i1;
              paramIntent = new JSONObject(((JSONObject)localObject1).optString("retmsg"));
              if ((i1 != 0) || (paramIntent == null)) {
                break;
              }
              switch (paramInt1)
              {
              default: 
                return;
              }
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              i1 = paramInt2;
            }
            paramIntent = paramIntent;
            paramIntent.printStackTrace();
          }
          continue;
          paramIntent = null;
        }
        if (this.app != null) {
          getSharedPreferences("transfer", 0).edit().putBoolean("is_need_dialog_" + this.app.getCurrentAccountUin() + this.jdField_f_of_type_JavaLangString, false).commit();
        }
        localObject1 = paramIntent.optString("callback_url");
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject1 = new StringBuffer(Uri.decode((String)localObject1));
      Object localObject2 = paramIntent.optString("sp_data");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuffer)localObject1).append("&sp_data=");
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      localObject2 = paramIntent.optString("transaction_id");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuffer)localObject1).append("&transaction_id=");
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      localObject2 = paramIntent.optString("total_fee");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuffer)localObject1).append("&total_fee=");
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      localObject2 = paramIntent.optString("pay_time");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuffer)localObject1).append("&pay_time=");
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      localObject2 = new JSONObject();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("callback_url", ((StringBuffer)localObject1).toString());
        localJSONObject.put("exec_code", paramIntent.optString("exec_code"));
        localJSONObject.put("uin", this.jdField_f_of_type_JavaLangString);
        localJSONObject.put("url", ((StringBuffer)localObject1).toString());
        ((JSONObject)localObject2).put("resultCode", 0);
        ((JSONObject)localObject2).put("retmsg", "SUCCESS");
        if (this.jdField_a_of_type_Int == 5) {
          ((JSONObject)localObject2).put("retdata", localJSONObject);
        }
        for (;;)
        {
          paramIntent = new Intent();
          paramIntent.putExtra("callbackSn", this.jdField_g_of_type_JavaLangString);
          paramIntent.putExtra("PayInvokerId", 5);
          paramIntent.putExtra("result", ((JSONObject)localObject2).toString());
          setResult(-1, paramIntent);
          finish();
          return;
          ((JSONObject)localObject2).put("data", localJSONObject);
        }
      }
      catch (Exception paramIntent)
      {
        break label481;
      }
    } while (i1 <= 0);
    label128:
    label481:
    Object localObject1 = ((JSONObject)localObject1).optString("retmsg");
    paramIntent = (Intent)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramIntent = getString(2131697353);
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramIntent, 0).a();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131368624) {
      if (("transferInput".equals(this.i)) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (!this.jdField_e_of_type_Boolean)) {
        if (this.jdField_a_of_type_Boolean)
        {
          a(this.jdField_a_of_type_JavaLangString, 128, "transfer.qqid.keyback", "", "", this.jdField_a_of_type_Int, "");
          this.jdField_d_of_type_AndroidWidgetEditText.requestFocus();
          a(false);
          this.jdField_d_of_type_JavaLangString = null;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          this.jdField_c_of_type_AndroidWidgetTextView.setText("");
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131697530);
        }
      }
    }
    label357:
    label508:
    do
    {
      long l1;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              a(this.jdField_a_of_type_JavaLangString, 128, "transfer.qqid.back", "", "", this.jdField_a_of_type_Int, "");
              break;
              if (this.jdField_a_of_type_Boolean) {
                a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amout.keyback", "", "", this.jdField_a_of_type_Int, "");
              }
              for (;;)
              {
                a("2");
                a(-1, null);
                if (this.jdField_a_of_type_AndroidContentContext != null) {
                  ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_c_of_type_AndroidWidgetEditText.getWindowToken(), 0);
                }
                finish();
                return;
                a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amount.back", "", "", this.jdField_a_of_type_Int, "");
              }
              if (i1 != 2131368655) {
                break label357;
              }
              i1 = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment".indexOf(':');
            } while (i1 == -1);
            paramView = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment".substring(0, i1);
          } while (TextUtils.isEmpty(paramView));
          paramView = paramView.toLowerCase();
        } while ((paramView.compareTo("http") != 0) && (paramView.compareTo("https") != 0));
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment");
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivityForResult(paramView, -1);
        return;
        if (i1 != 2131378247) {
          break label508;
        }
        l1 = System.currentTimeMillis();
      } while (this.jdField_b_of_type_Long + 1000L >= l1);
      if (getSharedPreferences("transfer", 0).getBoolean("is_need_dialog_" + this.jdField_a_of_type_JavaLangString + this.jdField_f_of_type_JavaLangString, true)) {
        bdgm.a(this.jdField_a_of_type_AndroidContentContext, 233, null, getString(2131697537), 2131690648, 2131720099, new aixb(this), new aiwx(this)).show();
      }
      for (;;)
      {
        this.jdField_b_of_type_Long = l1;
        return;
        a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amount.go", "", "", this.jdField_a_of_type_Int, "");
        b();
      }
      if (i1 == 2131377564)
      {
        this.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
        a(true);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_d_of_type_JavaLangString = bdgc.b(this.app, this.jdField_f_of_type_JavaLangString, true);
        paramView = ajeu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_d_of_type_JavaLangString, aepi.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_c_of_type_AndroidWidgetTextView.getPaint());
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramView + "(" + this.jdField_f_of_type_JavaLangString + ")");
        paramView = bdbk.a(this.app, 1, this.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        a(this.jdField_a_of_type_JavaLangString, 128, "transfer.qqid.next", "", "", this.jdField_a_of_type_Int, "");
        paramView = getString(2131697531) + getString(2131697533);
        if ("transferInput".equals(this.i))
        {
          alto localalto = (alto)this.app.getManager(51);
          if ((localalto.e(this.jdField_f_of_type_JavaLangString) != null) && (localalto.b(this.jdField_f_of_type_JavaLangString))) {
            paramView = getString(2131697529) + getString(2131697533);
          }
        }
        for (this.jdField_d_of_type_Boolean = false;; this.jdField_d_of_type_Boolean = true)
        {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramView);
          c();
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          return;
        }
      }
    } while (i1 != 2131378248);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.performClick();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TransactionActivity
 * JD-Core Version:    0.7.0.1
 */
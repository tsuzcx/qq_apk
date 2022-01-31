package com.tencent.mobileqq.activity.qwallet;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.activity.qwallet.widget.YellowTipsLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import xby;
import xbz;
import xca;
import xcb;
import xcc;
import xcd;

public class TransactionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new xcd(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 140;
  private View jdField_c_of_type_AndroidViewView;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private EditText jdField_d_of_type_AndroidWidgetEditText;
  private String jdField_d_of_type_JavaLangString;
  private EditText jdField_e_of_type_AndroidWidgetEditText;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  
  public TransactionActivity()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new xby(this);
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
      localJSONObject.put("TargetUin", this.f);
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
            return true;
          }
        }
        catch (Exception paramString) {}
      }
    }
    return false;
  }
  
  private void c()
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
      QWalletPayBridge.getWalletDataByService(BaseApplicationImpl.sApplication, this.app, localBundle);
      return;
    }
  }
  
  private void d()
  {
    JSONObject localJSONObject = YellowTipsLayout.getYellowTipsConfig(getApplicationContext(), this.jdField_a_of_type_JavaLangString);
    YellowTipsLayout localYellowTipsLayout = (YellowTipsLayout)findViewById(2131365307);
    if ((localYellowTipsLayout != null) && (localYellowTipsLayout.setYellowTipsJsonConfig(localJSONObject, "transfer_ad"))) {
      this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
    }
  }
  
  public int a(Context paramContext)
  {
    try
    {
      int i1 = paramContext.getResources().getDimensionPixelSize(2131558448);
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      return i1 - (int)(f1 * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  @TargetApi(14)
  protected void a()
  {
    try
    {
      setContentView(2130969840);
      Object localObject1 = findViewById(2131362854);
      new ImmersionBar(this, getResources().getColor(17170444), (View)localObject1);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131368244);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131368246);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365636);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131367630);
      d();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363245));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131367985));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131367783));
      this.jdField_e_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131367708));
      this.jdField_e_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368023));
      this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368245));
      this.jdField_c_of_type_AndroidWidgetEditText.setOnEditorActionListener(new xca(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368247));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131367710));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368241));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368242));
      localObject1 = QWalletTools.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_d_of_type_JavaLangString, AIOUtils.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_b_of_type_AndroidWidgetTextView.getPaint());
      this.jdField_b_of_type_AndroidWidgetTextView.setText((String)localObject1 + "(" + this.f + ")");
      if ("transferInput".equals(this.i))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("输入QQ号");
        getWindow().setWindowAnimations(2131624732);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetEditText.requestFocus();
        if (!TextUtils.isEmpty(this.f))
        {
          this.jdField_e_of_type_AndroidWidgetEditText.setText(this.f);
          this.jdField_e_of_type_AndroidWidgetEditText.setSelection(this.f.length());
        }
        new Handler().postDelayed(new xcb(this), 100L);
        this.j = "3";
        this.jdField_a_of_type_Int = 2;
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        finish();
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131431247);
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        break label720;
      }
    }
    if (!TextUtils.isEmpty(this.m)) {
      this.jdField_d_of_type_AndroidWidgetEditText.setText(this.m);
    }
    Object localObject2;
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_e_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, "100", 2);
      localObject2 = this.jdField_e_of_type_JavaLangString + getString(2131430855);
      this.jdField_b_of_type_AndroidWidgetEditText.setText((CharSequence)localObject2);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    for (;;)
    {
      localObject2 = FaceDrawable.a(this.app, 1, this.f);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      return;
      label720:
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      new Handler().postDelayed(new xcc(this), 100L);
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
      localIntent.putExtra("callbackSn", this.g);
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
      paramString5.append(CommonUtil.a());
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
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, paramString5.toString());
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
  
  protected void b()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("PayeeUin", this.f);
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
          localJSONObject2.put("payee_uin", this.f);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
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
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      try
      {
        this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        this.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
        this.jdField_a_of_type_Int = getIntent().getIntExtra("come_from", 1);
        this.g = getIntent().getStringExtra("callbackSn");
        this.h = getIntent().getStringExtra("app_info");
        this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("fromJump", false);
        this.i = getIntent().getStringExtra("tag");
        paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
        this.f = paramBundle.optString("targetUin");
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
        ThreadManager.getFileThreadHandler().post(new xbz(this));
        if (QWalletHelper.isNeedPreConnect(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, "type_mqq_and_myun")) {
          c();
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
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.doOnDestroy();
    if (this.jdField_a_of_type_Long != 0L) {
      VACDReportUtil.endReport(this.jdField_a_of_type_Long, "transfer.qqid.destroy", null, 0, null);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
    {
      a(this.jdField_a_of_type_JavaLangString, 128, "transfer.qqid.show", "", "", this.jdField_a_of_type_Int, "");
      return;
    }
    a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amount.show", "", "", this.jdField_a_of_type_Int, "");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        localJSONObject.put("uin", this.f);
        localJSONObject.put("url", ((StringBuffer)localObject1).toString());
        ((JSONObject)localObject2).put("resultCode", 0);
        ((JSONObject)localObject2).put("retmsg", "SUCCESS");
        if (this.jdField_a_of_type_Int == 5) {
          ((JSONObject)localObject2).put("retdata", localJSONObject);
        }
        for (;;)
        {
          paramIntent = new Intent();
          paramIntent.putExtra("callbackSn", this.g);
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
        break label415;
      }
    } while (i1 <= 0);
    label128:
    label415:
    Object localObject1 = ((JSONObject)localObject1).optString("retmsg");
    paramIntent = (Intent)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramIntent = getString(2131430858);
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramIntent, 0).a();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131363245) {
      if (("transferInput".equals(this.i)) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        if (this.jdField_a_of_type_Boolean)
        {
          a(this.jdField_a_of_type_JavaLangString, 128, "transfer.qqid.keyback", "", "", this.jdField_a_of_type_Int, "");
          this.jdField_e_of_type_AndroidWidgetEditText.requestFocus();
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_JavaLangString = null;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
          this.jdField_c_of_type_AndroidWidgetTextView.setText("输入QQ号");
        }
      }
    }
    label316:
    do
    {
      long l1;
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
        if (i1 != 2131368247) {
          break label316;
        }
        l1 = System.currentTimeMillis();
      } while (this.jdField_b_of_type_Long + 1000L >= l1);
      this.jdField_b_of_type_Long = l1;
      a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amount.go", "", "", this.jdField_a_of_type_Int, "");
      b();
      return;
    } while (i1 != 2131367710);
    this.f = this.jdField_e_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_d_of_type_JavaLangString = ContactUtils.b(this.app, this.f, true);
    paramView = QWalletTools.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_d_of_type_JavaLangString, AIOUtils.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_b_of_type_AndroidWidgetTextView.getPaint());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramView + "(" + this.f + ")");
    paramView = FaceDrawable.a(this.app, 1, this.f);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    a(this.jdField_a_of_type_JavaLangString, 128, "transfer.qqid.next", "", "", this.jdField_a_of_type_Int, "");
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131431247);
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TransactionActivity
 * JD-Core Version:    0.7.0.1
 */
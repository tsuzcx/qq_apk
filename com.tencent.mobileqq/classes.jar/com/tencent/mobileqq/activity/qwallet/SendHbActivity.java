package com.tencent.mobileqq.activity.qwallet;

import airu;
import airx;
import airy;
import airz;
import aitl;
import aitw;
import aiun;
import aius;
import ajaf;
import alpo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import arum;
import bdbt;
import bdcd;
import bdfq;
import bixy;
import biyf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SendHbActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  public int a;
  public long a;
  private aiun jdField_a_of_type_Aiun;
  private aius jdField_a_of_type_Aius;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new airu(this);
  Intent jdField_a_of_type_AndroidContentIntent = new Intent();
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseHbFragment jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment;
  private QWalletPayProgressDialog jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog;
  public String a;
  List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(32768), Integer.valueOf(16384), Integer.valueOf(128), Integer.valueOf(256), Integer.valueOf(512), Integer.valueOf(2048) }));
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new airz(this);
  private Intent jdField_b_of_type_AndroidContentIntent;
  private View jdField_b_of_type_AndroidViewView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k = "";
  private String l = "";
  private String m;
  private String n;
  
  private Bundle a()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)this.jdField_a_of_type_JavaUtilMap.get(str));
    }
    localBundle.putString("channel", String.valueOf(this.jdField_a_of_type_Int));
    return localBundle;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(a(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "0";
  }
  
  private Map<String, String> a(String paramString)
  {
    QLog.i("SendHbActivity", 2, "extra_data = " + paramString);
    paramString = ajaf.a(paramString);
    String str = (String)paramString.remove("extra_info");
    if (!TextUtils.isEmpty(str)) {
      paramString.putAll(ajaf.a(str));
    }
    paramString.put("send_name", this.f);
    paramString.put("send_uin", this.j);
    return paramString;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      ((FrameLayout)getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localImageView.setVisibility(i1);
      return;
    }
  }
  
  private void d()
  {
    this.j = this.app.getCurrentAccountUin();
    this.f = this.app.getCurrentNickname();
    this.jdField_c_of_type_Boolean = this.jdField_b_of_type_AndroidContentIntent.getBooleanExtra("theme", false);
    this.jdField_a_of_type_Aius = new aius(this);
    this.jdField_a_of_type_Aiun = new aiun();
    this.jdField_a_of_type_Long = this.jdField_b_of_type_AndroidContentIntent.getLongExtra("vacreport_key_seq", 0L);
    this.jdField_b_of_type_Boolean = this.jdField_b_of_type_AndroidContentIntent.getBooleanExtra("is_H5", false);
    this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidContentIntent.getIntExtra("come_from", 1);
    this.g = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("callbackSn");
    this.h = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("app_info");
    String str = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("extra_data");
    this.jdField_a_of_type_JavaUtilMap = a(str);
    d(str);
    this.n = ajaf.a(this.jdField_a_of_type_JavaUtilMap, "hb_from_type", "0");
    this.jdField_e_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get("recv_uin"));
    this.jdField_d_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get("recv_type"));
    this.i = this.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Int = bixy.a(this.jdField_a_of_type_JavaUtilMap.get("channel"), 1);
    QLog.i("SendHbActivity", 2, "mChannel = " + this.jdField_a_of_type_Int);
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get("theme_type"));
    }
    try
    {
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (Integer.valueOf(this.jdField_c_of_type_JavaLangString).intValue() > 1)) {
        this.jdField_c_of_type_Boolean = true;
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("theme_type");
      }
      if (5 == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = 16;
      }
      if (6 == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = 32;
      }
      if ((5 == this.jdField_a_of_type_Int) || (16 == this.jdField_a_of_type_Int) || (128 == this.jdField_a_of_type_Int) || (256 == this.jdField_a_of_type_Int))
      {
        this.f = bdbt.q(this.app, this.j);
        if (TextUtils.isEmpty(this.f)) {
          this.f = this.app.getCurrentNickname();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("isH5=").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("&comeFrom=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("&callbackSn=").append(this.g);
    localStringBuilder.append("&appInfo=").append(this.h);
    localStringBuilder.append("&extra=").append(paramString);
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "hbinvoke", localStringBuilder.toString(), 0, null);
      return;
    }
    VACDReportUtil.a(this.jdField_a_of_type_Long, null, "hbinvoke", localStringBuilder.toString(), 0, null);
  }
  
  private void e()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.qwallet.report");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void e(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment instanceof aitl))) {
      ((aitl)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment).a();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", paramString);
      localJSONObject.put("comeForm", this.jdField_b_of_type_Int);
      localJSONObject.put("h5_success", true);
      localJSONObject.put("appInfo", this.h);
      paramString = new Bundle();
      paramString.putString("json", localJSONObject.toString());
      paramString.putString("callbackSn", "0");
      paramString.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      PayBridgeActivity.a(this, 9, paramString);
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
  
  private void f()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(this.j);; localObject = "")
    {
      localBundle.putString("uin", this.j);
      localBundle.putString("skey", (String)localObject);
      localBundle.putString("skey_type", "2");
      localBundle.putInt("PayInvokerId", 21);
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, this.app, localBundle);
      return;
    }
  }
  
  private void g()
  {
    this.jdField_c_of_type_AndroidViewView = findViewById(2131376953);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375981);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376346);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131376342));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    ((Button)findViewById(2131376343)).setOnClickListener(this);
  }
  
  private void h()
  {
    int i1 = 1;
    Object localObject;
    if ("1".equals(ajaf.a(this.jdField_a_of_type_JavaUtilMap, "makeHb_type", "0")))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.k = ((String)this.jdField_a_of_type_JavaUtilMap.get("total_amount"));
      this.l = ((String)this.jdField_a_of_type_JavaUtilMap.get("total_num"));
      if (this.n.equals("100"))
      {
        localObject = a();
        ((Map)localObject).put("type", "1");
        new aitw(this).a((Map)localObject);
        return;
      }
      new aitw(this).a();
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && ("h5".equals(this.jdField_a_of_type_JavaUtilMap.get("invoke_from"))) && (this.jdField_a_of_type_Int == 2048))
    {
      new aitw(this).a("", this.j);
      finish();
      return;
    }
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Int == 64))
    {
      i();
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment instanceof SendHbMainFragment)) {
        new ImmersionBar(this, -1308622848, this.jdField_c_of_type_AndroidViewView);
      }
      j();
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_Int == 4096) {
        if (("1".equals(this.jdField_d_of_type_JavaLangString)) || ("7".equals(this.jdField_d_of_type_JavaLangString)) || ("6".equals(this.jdField_d_of_type_JavaLangString))) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      localObject = getString(2131697226);
      if (this.jdField_a_of_type_Int == 512) {
        localObject = getString(2131697493);
      }
      boolean bool = getIntent().getBooleanExtra("isFromPanel", false);
      Bundle localBundle = a();
      localBundle.putBoolean("isFromPanel", bool);
      localBundle.putInt("tabMask", i1);
      localBundle.putString("hbTitle", (String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment = new SendHbMainFragment();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment.setArguments(localBundle);
      break;
      b();
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment = new ThemeHbFragment();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment.setArguments(a());
      break;
      i1 = 2;
      continue;
      if (!biyf.jdField_a_of_type_JavaUtilList.contains(this.jdField_d_of_type_JavaLangString)) {
        if (this.jdField_a_of_type_Int == 2048) {
          i1 = 3;
        } else if (this.jdField_a_of_type_Int == 512) {
          i1 = 3;
        } else {
          i1 = 0;
        }
      }
    }
  }
  
  private void i()
  {
    boolean bool = false;
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localObject = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("theme_config");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (String str = "hb_theme_";; str = "")
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has("hb_theme_id")) {
          continue;
        }
        this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString(String.format("%sid", new Object[] { str }));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        Bundle localBundle = a();
        localBundle.putString("theme_type", this.jdField_c_of_type_JavaLangString);
        if (64 != this.jdField_a_of_type_Int) {
          break label183;
        }
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("group_id");
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("group_member_number");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment = new ThemeHbFragment();
        localBundle.putString("group_count", this.jdField_a_of_type_JavaLangString);
        if ((!"2".equals(this.jdField_d_of_type_JavaLangString)) && (!"3".equals(this.jdField_d_of_type_JavaLangString))) {
          break label233;
        }
        bool = true;
        localBundle.putBoolean("isGroupThemeHb", bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment.setArguments(localBundle);
      }
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break;
      }
      QLog.i("SendHbActivity", 2, "params error, no theme id...");
      QQToast.a(this, "params error, no theme id...", 0).a();
      finish();
      return;
    }
    label183:
    label233:
    return;
  }
  
  private void j()
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment != null)
    {
      ((FrameLayout)findViewById(2131364961)).setVisibility(0);
      localFragmentTransaction.add(2131364961, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment);
      localFragmentTransaction.commit();
    }
  }
  
  private void k()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void l()
  {
    if (ajaf.a(this.jdField_a_of_type_JavaUtilMap, "makeHb_type", "0").equals("1")) {
      finish();
    }
  }
  
  public int a()
  {
    int i1;
    if (this.jdField_b_of_type_Boolean) {
      i1 = 131;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendHbActivity", 2, "getProcessType: processFlag:" + i1);
      }
      return i1;
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        if (biyf.b.contains(this.jdField_d_of_type_JavaLangString)) {
          i1 = 133;
        } else {
          i1 = 132;
        }
      }
      else {
        i1 = 499;
      }
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
  
  public aiun a()
  {
    return this.jdField_a_of_type_Aiun;
  }
  
  public aius a()
  {
    return this.jdField_a_of_type_Aius;
  }
  
  public Intent a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("result", paramInt);
      return localIntent;
      localIntent.putExtra("retmsg", paramString1);
    }
  }
  
  public String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wishing", paramJSONObject.optString("wishing"));
      localJSONObject.put("total_num", paramJSONObject.optString("total_num"));
      localJSONObject.put("recv_num", paramJSONObject.optString("recv_num"));
      localJSONObject.put("qr_data", paramJSONObject.optString("qr_data"));
      localJSONObject.put("send_listid", paramJSONObject.optString("send_listid"));
      paramJSONObject = new JSONArray();
      paramJSONObject.put(localJSONObject);
      paramJSONObject = paramJSONObject.toString();
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  public Map<String, String> a()
  {
    HashMap localHashMap = new HashMap(this.jdField_a_of_type_JavaUtilMap);
    localHashMap.put("name", this.f);
    if (2048 != this.jdField_a_of_type_Int) {
      localHashMap.put("recv_type", this.i);
    }
    localHashMap.put("hb_from_type", this.n + "");
    return localHashMap;
  }
  
  public void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", -1);
      label17:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.g);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", localJSONObject.toString());
      setResult(0, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(this.j, paramInt1, paramString, "", "");
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).b(a(this));
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QWalletHelper.saveQRTokenConfig(this, paramString, this.j);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    ajaf.a(this.app, paramString1, this.jdField_b_of_type_Int, this.h, this.jdField_a_of_type_Long, paramInt, paramString2, paramString3, paramString4);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    int i1 = 1;
    QLog.i("SendHbActivity", 2, "sendConfirmRequest viewtag = " + paramString1 + " sp_data = " + paramString2);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("sp_data", paramString2);
        if (32768 == this.jdField_a_of_type_Int)
        {
          if (this.jdField_d_of_type_JavaLangString.equals("1"))
          {
            localJSONObject.put("channel", i1);
            paramString2 = new JSONObject();
            paramString2.put("userId", this.j);
            paramString2.put("viewTag", paramString1);
            paramString2.put("comeForm", 2);
            paramString2.put("appInfo", this.h);
            paramString2.put("extra_data", localJSONObject.toString());
            PayBridgeActivity.tenpay(this, paramString2.toString(), 5, "0");
          }
        }
        else
        {
          localJSONObject.put("channel", String.valueOf(this.jdField_a_of_type_Int));
          continue;
        }
        i1 = 1024;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(this.j, a(), paramString1, paramString2, "");
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    bdcd.a(this, 230, null, paramString1, paramString2, paramString3, new airx(this), new airy(this)).show();
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    if ("2".equals(paramString)) {
      localIntent.putExtra("param_only_discussion_member", true);
    }
    for (;;)
    {
      localIntent.putExtra("param_title", getString(2131697108));
      localIntent.putExtra("param_min", 0);
      localIntent.putExtra("param_done_button_wording", getString(2131719700));
      localIntent.putExtra("param_done_button_highlight_wording", getString(2131719701));
      localIntent.putExtra("param_max", 5);
      localIntent.putExtra("param_entrance", 25);
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label211;
      }
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        new ResultRecord().jdField_a_of_type_JavaLangString = str;
        paramString.add(SelectMemberActivity.a(str, "", 0, this.j));
      }
      if ("3".equals(paramString)) {
        localIntent.putExtra("param_only_troop_member", true);
      }
    }
    localIntent.putExtra("param_selected_records_for_create_discussion", paramString);
    label211:
    localIntent.putExtra("group_uin", this.jdField_e_of_type_JavaLangString);
    paramString = getCurrentAccountUin();
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new ArrayList();
      paramArrayList.add(paramString);
      localIntent.putExtra("param_uins_hide", paramArrayList);
    }
    startActivityForResult(localIntent, 1024);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("send_name", this.f);
      localJSONObject.putOpt("send_uin", this.j);
      localJSONObject.putOpt("send_listid", paramJSONObject.optString("send_listid"));
      localJSONObject.putOpt("amount", paramJSONObject.optString("amount"));
      localJSONObject.putOpt("feedsid", this.jdField_a_of_type_JavaUtilMap.get("feedsid"));
      localJSONObject.putOpt("channel", this.jdField_a_of_type_Int + "");
      paramJSONObject = new JSONObject();
    }
    catch (JSONException paramJSONObject)
    {
      try
      {
        paramJSONObject.putOpt("resultCode", Integer.valueOf(0));
        paramJSONObject.putOpt("retmsg", "");
        paramJSONObject.putOpt("data", localJSONObject.toString());
        localIntent.putExtra("result", paramJSONObject.toString());
        localIntent.putExtra("callbackSn", this.g);
        localIntent.putExtra("PayInvokerId", 5);
        setResult(-1, localIntent);
        finish();
        return;
        paramJSONObject = paramJSONObject;
        paramJSONObject.printStackTrace();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public int b()
  {
    String str = ajaf.a(ajaf.a((String)this.jdField_a_of_type_JavaUtilMap.get("selector")), "friend_type", "1");
    int i1 = 0;
    if (str.equals("1")) {
      i1 = 1;
    }
    do
    {
      return i1;
      if (str.equals("2")) {
        return 16;
      }
      if (str.equals("3")) {
        return 256;
      }
      if (str.equals("1|2")) {
        return 17;
      }
      if (str.equals("1|3")) {
        return 257;
      }
      if (str.equals("2|3")) {
        return 272;
      }
    } while (!str.equals("1|2|3"));
    return 273;
  }
  
  public Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", this.j);
    localHashMap.put("viewTag", "sendHb");
    localHashMap.put("comeForm", "2");
    localHashMap.put("appInfo", this.h);
    return localHashMap;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment = new QzoneHbFragment();
    Bundle localBundle = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment.setArguments(localBundle);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  public void b(String paramString)
  {
    this.k = paramString;
    try
    {
      Object localObject = a();
      ((Map)localObject).put("total_num", ajaf.a(this.jdField_a_of_type_JavaUtilMap, "total_num", "1"));
      ((Map)localObject).put("total_amount", a(paramString));
      ((Map)localObject).put("channel", String.valueOf(this.jdField_a_of_type_Int));
      ((Map)localObject).put("recv_uin", this.jdField_e_of_type_JavaLangString);
      ((Map)localObject).put("bus_type", this.jdField_a_of_type_JavaUtilMap.get("bus_type"));
      ((Map)localObject).put("recv_type", "1");
      ((Map)localObject).put("type", "1");
      paramString = b();
      paramString.put("extra_data", new JSONObject((Map)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putString("json", new JSONObject(paramString).toString());
      ((Bundle)localObject).putString("callbackSn", "0");
      ((Bundle)localObject).putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      PayBridgeActivity.a(this, 5, (Bundle)localObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("retmsg", paramJSONObject.toString());
    setResult(-1, localIntent);
    finish();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("hb_id", this.m);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("send_uin", this.j);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("hb_type", "1");
    this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_text", getString(2131697492));
    HashMap localHashMap = ajaf.a((String)this.jdField_a_of_type_JavaUtilMap.get("selector"));
    int i1 = ajaf.a(localHashMap, "type", 0);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("item", 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_type", 17);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("invoke_from", "qwallet");
      arum.a(this, this.jdField_a_of_type_AndroidContentIntent);
      return;
      if ((this.n.equals("100")) && (i1 == 1))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("item", b());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("title", ajaf.a(localHashMap, "title", alpo.a(2131714201)));
      }
    }
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  public void c(String paramString)
  {
    a(this.j, a(), paramString, "", "");
  }
  
  protected void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("userId", this.j);
        ((JSONObject)localObject).put("viewTag", "qrcodeHb");
        ((JSONObject)localObject).put("comeForm", 2);
        JSONObject localJSONObject = new JSONObject();
        str = a(paramJSONObject);
        if (!TextUtils.isEmpty(str)) {
          localJSONObject.putOpt("qrData", str);
        }
        localJSONObject.putOpt("comeFrom", Integer.valueOf(this.jdField_b_of_type_Int));
        a(paramJSONObject.optString("qr_token"));
        ((JSONObject)localObject).put("extra_data", localJSONObject.toString());
        paramJSONObject = new Bundle();
        paramJSONObject.putString("json", ((JSONObject)localObject).toString());
        paramJSONObject.putString("callbackSn", "0");
        paramJSONObject.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
        localObject = ajaf.a(this.jdField_a_of_type_JavaUtilMap, "from_plugin", "");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          PayBridgeActivity.a(this, 5, paramJSONObject);
          finish();
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      if ("1".equals(localObject))
      {
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("qrData", str);
        setResult(-1, paramJSONObject);
      }
    }
  }
  
  public void d(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  protected void d(JSONObject paramJSONObject)
  {
    QLog.i("SendHbActivity", 2, "onFaceHbResult bundle_data = " + paramJSONObject);
    Object localObject = paramJSONObject.optJSONObject("data");
    if (localObject == null) {}
    for (;;)
    {
      QLog.i("SendHbActivity", 2, "onFaceHbResult final data = " + paramJSONObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("callbackSn", this.g);
      ((Intent)localObject).putExtra("PayInvokerId", 5);
      JSONObject localJSONObject = new JSONObject();
      label250:
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          int i1 = paramJSONObject.optInt("retcode", -1);
          paramJSONObject.printStackTrace();
        }
        catch (Exception paramJSONObject)
        {
          try
          {
            ((Intent)localObject).putExtra("result", i1 + "");
            ((Intent)localObject).putExtra("retmsg", paramJSONObject.optString("retmsg"));
            localJSONObject.put("send_listid", paramJSONObject.optString("send_listid"));
            if (i1 == 0) {
              a(this.j, a(), "bqredpacket.pay.expose", "", "");
            }
            QLog.i("SendHbActivity", 2, "onFaceHbResult back jdata = " + localJSONObject);
            ((Intent)localObject).putExtra("data", localJSONObject.toString());
            setResult(-1, (Intent)localObject);
            finish();
            return;
          }
          catch (Exception paramJSONObject)
          {
            break label250;
          }
          paramJSONObject = paramJSONObject;
          i1 = -1;
        }
      }
      paramJSONObject = (JSONObject)localObject;
    }
  }
  
  public void doOnBackPressed()
  {
    QLog.i("SendHbActivity", 2, "SendHbActivity doOnBackPressed...");
    setResult(0, new Intent());
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.jdField_b_of_type_AndroidContentIntent = localIntent;
    localIntent.putExtra("fling_action_key", 0);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    try
    {
      e();
      setProgressBarIndeterminateVisibility(false);
      setRequestedOrientation(1);
      setContentView(2131560369);
      d();
      g();
      h();
      k();
      QWalletHelper.preloadQWallet(this.app);
      if (QWalletHelper.isNeedPreConnect(this, this.j, "type_mqq_and_myun")) {
        f();
      }
      return true;
    }
    catch (OutOfMemoryError paramBundle) {}
    return false;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Aius.a();
    try
    {
      if (this.jdField_a_of_type_Long != 0L) {
        VACDReportUtil.endReport(this.jdField_a_of_type_Long, "hongbao.wrap.destroy", null, this.jdField_d_of_type_Int, null);
      }
      if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      }
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Boolean = false;
    a(this.j, a(), "hongbao.wrap.show", "", "");
    a("1103".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Aius.b();
  }
  
  /* Error */
  protected void e(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 193
    //   2: iconst_2
    //   3: new 195	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 1106
    //   13: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: ifnonnull +4 -> 31
    //   30: return
    //   31: new 1108	java/lang/StringBuffer
    //   34: dup
    //   35: aload_1
    //   36: ldc_w 1110
    //   39: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokestatic 1115	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokespecial 1116	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_1
    //   50: ldc_w 839
    //   53: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifne +17 -> 78
    //   64: aload_2
    //   65: ldc_w 1118
    //   68: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   71: pop
    //   72: aload_2
    //   73: aload_3
    //   74: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: aload_1
    //   79: ldc_w 1123
    //   82: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +17 -> 107
    //   93: aload_2
    //   94: ldc_w 1125
    //   97: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   100: pop
    //   101: aload_2
    //   102: aload_3
    //   103: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: pop
    //   107: aload_1
    //   108: ldc_w 1127
    //   111: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +17 -> 136
    //   122: aload_2
    //   123: ldc_w 1129
    //   126: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: aload_2
    //   131: aload_3
    //   132: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   135: pop
    //   136: aload_1
    //   137: ldc_w 1131
    //   140: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore_1
    //   144: aload_1
    //   145: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +17 -> 165
    //   151: aload_2
    //   152: ldc_w 1133
    //   155: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: aload_2
    //   160: aload_1
    //   161: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: pop
    //   165: new 470	org/json/JSONObject
    //   168: dup
    //   169: invokespecial 471	org/json/JSONObject:<init>	()V
    //   172: astore_1
    //   173: new 470	org/json/JSONObject
    //   176: dup
    //   177: invokespecial 471	org/json/JSONObject:<init>	()V
    //   180: astore_3
    //   181: aload_3
    //   182: ldc_w 1110
    //   185: aload_2
    //   186: invokevirtual 1134	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   189: invokevirtual 476	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   192: pop
    //   193: aload_1
    //   194: ldc_w 795
    //   197: iconst_0
    //   198: invokevirtual 481	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload_1
    //   203: ldc_w 770
    //   206: ldc_w 1136
    //   209: invokevirtual 476	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload_1
    //   214: ldc_w 759
    //   217: aload_3
    //   218: invokevirtual 476	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   221: pop
    //   222: ldc 193
    //   224: iconst_2
    //   225: new 195	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 1138
    //   235: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: new 86	android/content/Intent
    //   251: dup
    //   252: invokespecial 87	android/content/Intent:<init>	()V
    //   255: astore_2
    //   256: aload_2
    //   257: ldc_w 358
    //   260: aload_0
    //   261: getfield 363	com/tencent/mobileqq/activity/qwallet/SendHbActivity:g	Ljava/lang/String;
    //   264: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   267: pop
    //   268: aload_2
    //   269: ldc_w 520
    //   272: iconst_5
    //   273: invokevirtual 768	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   276: pop
    //   277: aload_2
    //   278: ldc_w 765
    //   281: aload_1
    //   282: invokevirtual 491	org/json/JSONObject:toString	()Ljava/lang/String;
    //   285: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   288: pop
    //   289: aload_0
    //   290: iconst_m1
    //   291: aload_2
    //   292: invokevirtual 799	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   295: aload_0
    //   296: invokevirtual 597	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   299: return
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 420	java/lang/Exception:printStackTrace	()V
    //   305: return
    //   306: astore_2
    //   307: goto -85 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	SendHbActivity
    //   0	310	1	paramJSONObject	JSONObject
    //   48	244	2	localObject1	Object
    //   306	1	2	localException	Exception
    //   56	162	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	78	300	java/lang/Exception
    //   78	107	300	java/lang/Exception
    //   107	136	300	java/lang/Exception
    //   136	165	300	java/lang/Exception
    //   165	173	300	java/lang/Exception
    //   222	299	300	java/lang/Exception
    //   173	222	306	java/lang/Exception
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 193
    //   2: iconst_2
    //   3: new 195	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 1142
    //   13: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: iload_1
    //   17: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc_w 1144
    //   23: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_2
    //   27: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: ldc 193
    //   38: iconst_2
    //   39: new 195	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 1146
    //   49: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_3
    //   53: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 464	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment	Lcom/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment;
    //   66: ifnull +13 -> 79
    //   69: aload_0
    //   70: getfield 464	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment	Lcom/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment;
    //   73: iload_1
    //   74: iload_2
    //   75: aload_3
    //   76: invokevirtual 1148	com/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment:onActivityResult	(IILandroid/content/Intent;)V
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 806	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Boolean	Z
    //   84: aload_3
    //   85: ifnull +1216 -> 1301
    //   88: iload_2
    //   89: iconst_m1
    //   90: if_icmpne +1211 -> 1301
    //   93: aload_3
    //   94: ldc_w 765
    //   97: invokevirtual 361	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 6
    //   102: aconst_null
    //   103: astore 5
    //   105: aload 6
    //   107: ifnull +203 -> 310
    //   110: aload 6
    //   112: invokevirtual 1151	java/lang/String:length	()I
    //   115: ifle +195 -> 310
    //   118: new 470	org/json/JSONObject
    //   121: dup
    //   122: aload 6
    //   124: invokespecial 659	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   127: astore 4
    //   129: ldc 193
    //   131: iconst_2
    //   132: new 195	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 1153
    //   142: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 4
    //   147: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload 4
    //   158: ifnull +1156 -> 1314
    //   161: aload 4
    //   163: ldc_w 770
    //   166: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 5
    //   171: aload 4
    //   173: ldc_w 795
    //   176: iconst_m1
    //   177: invokevirtual 1017	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   180: istore_2
    //   181: aload_0
    //   182: iload_2
    //   183: putfield 59	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_Int	I
    //   186: aload 4
    //   188: ldc_w 759
    //   191: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +125 -> 321
    //   199: aload_3
    //   200: invokevirtual 1151	java/lang/String:length	()I
    //   203: ifle +118 -> 321
    //   206: new 470	org/json/JSONObject
    //   209: dup
    //   210: aload_3
    //   211: invokespecial 659	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   214: astore_3
    //   215: aload_0
    //   216: getfield 59	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_Int	I
    //   219: ifeq +44 -> 263
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 236	com/tencent/mobileqq/activity/qwallet/SendHbActivity:j	Ljava/lang/String;
    //   227: aload_0
    //   228: invokevirtual 850	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()I
    //   231: new 195	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   238: aload 5
    //   240: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 1155
    //   246: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: iload_2
    //   250: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: ldc 44
    //   258: ldc 44
    //   260: invokevirtual 803	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 834	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   267: invokevirtual 1158	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   270: iload_2
    //   271: ifne +740 -> 1011
    //   274: aload_3
    //   275: ifnull +736 -> 1011
    //   278: iload_1
    //   279: lookupswitch	default:+25->304, 5:+47->326, 9:+419->698
    //   305: astore_3
    //   306: aload_3
    //   307: invokevirtual 420	java/lang/Exception:printStackTrace	()V
    //   310: aconst_null
    //   311: astore 4
    //   313: goto -184 -> 129
    //   316: astore_3
    //   317: aload_3
    //   318: invokevirtual 420	java/lang/Exception:printStackTrace	()V
    //   321: aconst_null
    //   322: astore_3
    //   323: goto -108 -> 215
    //   326: aload_0
    //   327: getfield 829	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   330: ifeq +259 -> 589
    //   333: aload_0
    //   334: iconst_0
    //   335: putfield 829	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   338: aload_0
    //   339: iconst_m1
    //   340: putfield 50	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_Int	I
    //   343: aload_3
    //   344: ldc_w 1160
    //   347: invokevirtual 1162	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   350: istore_1
    //   351: iconst_1
    //   352: iload_1
    //   353: if_icmpeq +8 -> 361
    //   356: iconst_2
    //   357: iload_1
    //   358: if_icmpne +168 -> 526
    //   361: aload_0
    //   362: getfield 384	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   365: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: ifeq +67 -> 435
    //   371: aload_0
    //   372: getfield 546	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   375: iconst_0
    //   376: invokevirtual 573	android/view/View:setVisibility	(I)V
    //   379: aload_0
    //   380: getfield 549	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   383: iconst_0
    //   384: invokevirtual 573	android/view/View:setVisibility	(I)V
    //   387: aload_0
    //   388: getfield 543	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   391: ifnull +13 -> 404
    //   394: aload_0
    //   395: getfield 543	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   398: ldc_w 604
    //   401: invokevirtual 1165	android/view/View:setBackgroundColor	(I)V
    //   404: aload_0
    //   405: aload_3
    //   406: ldc_w 779
    //   409: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   412: putfield 138	com/tencent/mobileqq/activity/qwallet/SendHbActivity:m	Ljava/lang/String;
    //   415: aload_0
    //   416: aload_0
    //   417: getfield 236	com/tencent/mobileqq/activity/qwallet/SendHbActivity:j	Ljava/lang/String;
    //   420: aload_0
    //   421: invokevirtual 850	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()I
    //   424: ldc_w 1167
    //   427: ldc 44
    //   429: ldc 44
    //   431: invokevirtual 803	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   434: return
    //   435: sipush 256
    //   438: aload_0
    //   439: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   442: if_icmpeq +68 -> 510
    //   445: sipush 128
    //   448: aload_0
    //   449: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   452: if_icmpeq +58 -> 510
    //   455: sipush 512
    //   458: aload_0
    //   459: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   462: if_icmpeq +48 -> 510
    //   465: sipush 2048
    //   468: aload_0
    //   469: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   472: if_icmpeq +38 -> 510
    //   475: aload_0
    //   476: getfield 1169	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   479: ifnull +832 -> 1311
    //   482: aload_0
    //   483: getfield 1169	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   486: astore_3
    //   487: aload_0
    //   488: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   491: sipush 16384
    //   494: if_icmpne +10 -> 504
    //   497: aload_0
    //   498: aload 4
    //   500: invokevirtual 1171	com/tencent/mobileqq/activity/qwallet/SendHbActivity:d	(Lorg/json/JSONObject;)V
    //   503: return
    //   504: aload_0
    //   505: aload_3
    //   506: invokevirtual 1173	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Lorg/json/JSONObject;)V
    //   509: return
    //   510: sipush 2048
    //   513: aload_0
    //   514: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   517: if_icmpne -213 -> 304
    //   520: aload_0
    //   521: aload_3
    //   522: invokevirtual 1175	com/tencent/mobileqq/activity/qwallet/SendHbActivity:c	(Lorg/json/JSONObject;)V
    //   525: return
    //   526: sipush 256
    //   529: aload_0
    //   530: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   533: if_icmpeq +22 -> 555
    //   536: sipush 128
    //   539: aload_0
    //   540: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   543: if_icmpeq +12 -> 555
    //   546: aload_0
    //   547: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   550: ldc 64
    //   552: if_icmpne +9 -> 561
    //   555: aload_0
    //   556: aload_3
    //   557: invokevirtual 1177	com/tencent/mobileqq/activity/qwallet/SendHbActivity:b	(Lorg/json/JSONObject;)V
    //   560: return
    //   561: sipush 512
    //   564: aload_0
    //   565: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   568: if_icmpne +9 -> 577
    //   571: aload_0
    //   572: aload_3
    //   573: invokevirtual 1179	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Lorg/json/JSONObject;)V
    //   576: return
    //   577: aload_0
    //   578: aload_0
    //   579: ldc_w 1180
    //   582: invokevirtual 617	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   585: invokevirtual 950	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   588: return
    //   589: bipush 64
    //   591: aload_0
    //   592: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   595: if_icmpeq +12 -> 607
    //   598: aload_0
    //   599: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   602: bipush 64
    //   604: if_icmpne +71 -> 675
    //   607: new 470	org/json/JSONObject
    //   610: dup
    //   611: invokespecial 471	org/json/JSONObject:<init>	()V
    //   614: astore 4
    //   616: aload 4
    //   618: ldc_w 1182
    //   621: aload_3
    //   622: ldc_w 1182
    //   625: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   628: invokevirtual 926	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   631: pop
    //   632: aload 4
    //   634: ldc_w 575
    //   637: aload_0
    //   638: getfield 46	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   641: invokevirtual 926	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   644: pop
    //   645: aload_0
    //   646: iconst_m1
    //   647: aload_0
    //   648: iload_2
    //   649: ldc 44
    //   651: aload 4
    //   653: invokevirtual 491	org/json/JSONObject:toString	()Ljava/lang/String;
    //   656: invokevirtual 1184	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(ILjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   659: invokevirtual 799	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   662: aload_0
    //   663: invokevirtual 597	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   666: return
    //   667: astore_3
    //   668: aload_3
    //   669: invokevirtual 501	org/json/JSONException:printStackTrace	()V
    //   672: goto -27 -> 645
    //   675: aload_0
    //   676: aload_3
    //   677: ldc_w 1186
    //   680: invokevirtual 1162	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   683: putfield 50	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_Int	I
    //   686: aload_0
    //   687: aload_3
    //   688: ldc_w 1182
    //   691: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   694: invokespecial 1188	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Ljava/lang/String;)V
    //   697: return
    //   698: aload_3
    //   699: ldc_w 1110
    //   702: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   705: astore 4
    //   707: new 1108	java/lang/StringBuffer
    //   710: dup
    //   711: invokespecial 1189	java/lang/StringBuffer:<init>	()V
    //   714: astore 5
    //   716: aload 5
    //   718: ldc_w 1191
    //   721: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   724: pop
    //   725: aload 5
    //   727: aload_0
    //   728: getfield 48	com/tencent/mobileqq/activity/qwallet/SendHbActivity:l	Ljava/lang/String;
    //   731: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   734: pop
    //   735: aload 5
    //   737: ldc_w 1193
    //   740: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   743: pop
    //   744: ldc_w 564
    //   747: aload_0
    //   748: getfield 388	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   751: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   754: ifne +42 -> 796
    //   757: ldc_w 611
    //   760: aload_0
    //   761: getfield 388	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   764: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   767: ifne +29 -> 796
    //   770: ldc_w 1195
    //   773: aload_0
    //   774: getfield 388	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   777: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   780: ifne +16 -> 796
    //   783: ldc_w 1197
    //   786: aload_0
    //   787: getfield 388	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   790: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   793: ifeq +147 -> 940
    //   796: aload 5
    //   798: ldc_w 1199
    //   801: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   804: pop
    //   805: aload 5
    //   807: ldc_w 1201
    //   810: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   813: pop
    //   814: aload 5
    //   816: aload_0
    //   817: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   820: invokevirtual 1204	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   823: pop
    //   824: aload 5
    //   826: ldc_w 1206
    //   829: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   832: pop
    //   833: aload 5
    //   835: aload_0
    //   836: getfield 46	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   839: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   842: pop
    //   843: aload_0
    //   844: aload_0
    //   845: getfield 236	com/tencent/mobileqq/activity/qwallet/SendHbActivity:j	Ljava/lang/String;
    //   848: aload_0
    //   849: invokevirtual 850	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()I
    //   852: ldc_w 1208
    //   855: aload 5
    //   857: invokevirtual 1134	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   860: aconst_null
    //   861: invokevirtual 803	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   864: aload 4
    //   866: ifnull -562 -> 304
    //   869: aload_0
    //   870: getfield 384	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   873: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   876: ifne +30 -> 906
    //   879: aload_0
    //   880: getfield 50	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_Int	I
    //   883: iconst_1
    //   884: if_icmpeq +22 -> 906
    //   887: aload_0
    //   888: getfield 79	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   891: aload_0
    //   892: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   895: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   898: invokeinterface 654 2 0
    //   903: ifeq +86 -> 989
    //   906: aload_3
    //   907: ldc_w 839
    //   910: invokevirtual 675	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   913: astore 4
    //   915: sipush 2048
    //   918: aload_0
    //   919: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   922: if_icmpne +55 -> 977
    //   925: aload_0
    //   926: ldc_w 1210
    //   929: aload 4
    //   931: invokevirtual 1211	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   934: aload_0
    //   935: aload_3
    //   936: putfield 1169	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   939: return
    //   940: ldc_w 518
    //   943: aload_0
    //   944: getfield 388	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   947: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   950: ifeq +15 -> 965
    //   953: aload 5
    //   955: ldc_w 1213
    //   958: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   961: pop
    //   962: goto -157 -> 805
    //   965: aload 5
    //   967: ldc_w 1215
    //   970: invokevirtual 1121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   973: pop
    //   974: goto -169 -> 805
    //   977: aload_0
    //   978: ldc_w 1217
    //   981: aload 4
    //   983: invokevirtual 1211	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   986: goto -52 -> 934
    //   989: aload_0
    //   990: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   993: sipush 16384
    //   996: if_icmpne +9 -> 1005
    //   999: aload_0
    //   1000: aload_3
    //   1001: invokevirtual 1171	com/tencent/mobileqq/activity/qwallet/SendHbActivity:d	(Lorg/json/JSONObject;)V
    //   1004: return
    //   1005: aload_0
    //   1006: aload_3
    //   1007: invokevirtual 1173	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Lorg/json/JSONObject;)V
    //   1010: return
    //   1011: iload_2
    //   1012: ifle +213 -> 1225
    //   1015: aload_0
    //   1016: getfield 829	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   1019: ifeq +51 -> 1070
    //   1022: sipush 256
    //   1025: aload_0
    //   1026: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   1029: if_icmpeq +13 -> 1042
    //   1032: sipush 128
    //   1035: aload_0
    //   1036: getfield 132	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   1039: if_icmpne +81 -> 1120
    //   1042: new 86	android/content/Intent
    //   1045: dup
    //   1046: invokespecial 87	android/content/Intent:<init>	()V
    //   1049: astore_3
    //   1050: aload_3
    //   1051: ldc_w 770
    //   1054: aload 6
    //   1056: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1059: pop
    //   1060: aload_0
    //   1061: iconst_m1
    //   1062: aload_3
    //   1063: invokevirtual 799	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1066: aload_0
    //   1067: invokevirtual 597	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   1070: aload_0
    //   1071: ldc_w 1218
    //   1074: invokevirtual 617	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1077: astore_3
    //   1078: iload_2
    //   1079: ldc_w 1219
    //   1082: if_icmpne +66 -> 1148
    //   1085: aload_0
    //   1086: sipush 230
    //   1089: aconst_null
    //   1090: aload 5
    //   1092: aconst_null
    //   1093: aload_0
    //   1094: ldc_w 1220
    //   1097: invokevirtual 617	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1100: new 1222	airv
    //   1103: dup
    //   1104: aload_0
    //   1105: invokespecial 1223	airv:<init>	(Lcom/tencent/mobileqq/activity/qwallet/SendHbActivity;)V
    //   1108: aconst_null
    //   1109: invokestatic 862	bdcd:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lbdfq;
    //   1112: invokevirtual 865	bdfq:show	()V
    //   1115: aload_0
    //   1116: invokespecial 240	com/tencent/mobileqq/activity/qwallet/SendHbActivity:l	()V
    //   1119: return
    //   1120: aload_0
    //   1121: getfield 384	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1124: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1127: ifne -57 -> 1070
    //   1130: aload_0
    //   1131: getfield 1169	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   1134: ifnull -64 -> 1070
    //   1137: aload_0
    //   1138: aload_0
    //   1139: getfield 1169	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   1142: invokevirtual 1173	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Lorg/json/JSONObject;)V
    //   1145: goto -75 -> 1070
    //   1148: iload_2
    //   1149: ldc_w 1224
    //   1152: if_icmpne +51 -> 1203
    //   1155: aload 5
    //   1157: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1160: ifne +43 -> 1203
    //   1163: aload_0
    //   1164: invokevirtual 809	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isFinishing	()Z
    //   1167: ifne -52 -> 1115
    //   1170: aload_0
    //   1171: sipush 230
    //   1174: aconst_null
    //   1175: aload 5
    //   1177: aconst_null
    //   1178: aload_0
    //   1179: ldc_w 1225
    //   1182: invokevirtual 617	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1185: new 1227	airw
    //   1188: dup
    //   1189: aload_0
    //   1190: invokespecial 1228	airw:<init>	(Lcom/tencent/mobileqq/activity/qwallet/SendHbActivity;)V
    //   1193: aconst_null
    //   1194: invokestatic 862	bdcd:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lbdfq;
    //   1197: invokevirtual 865	bdfq:show	()V
    //   1200: goto -85 -> 1115
    //   1203: aload 5
    //   1205: ifnull +12 -> 1217
    //   1208: aload_0
    //   1209: aload 5
    //   1211: invokevirtual 950	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1214: goto -99 -> 1115
    //   1217: aload_0
    //   1218: aload_3
    //   1219: invokevirtual 950	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1222: goto -107 -> 1115
    //   1225: iload_2
    //   1226: bipush 246
    //   1228: if_icmpge +35 -> 1263
    //   1231: aload_0
    //   1232: new 195	java/lang/StringBuilder
    //   1235: dup
    //   1236: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1239: ldc_w 1229
    //   1242: invokestatic 987	alpo:a	(I)Ljava/lang/String;
    //   1245: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: iload_2
    //   1249: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokevirtual 950	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1258: aload_0
    //   1259: invokespecial 240	com/tencent/mobileqq/activity/qwallet/SendHbActivity:l	()V
    //   1262: return
    //   1263: new 86	android/content/Intent
    //   1266: dup
    //   1267: invokespecial 87	android/content/Intent:<init>	()V
    //   1270: astore_3
    //   1271: aload_3
    //   1272: ldc_w 520
    //   1275: iconst_5
    //   1276: invokevirtual 768	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1279: pop
    //   1280: aload_3
    //   1281: ldc_w 765
    //   1284: aload 6
    //   1286: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1289: pop
    //   1290: aload_0
    //   1291: iconst_m1
    //   1292: aload_3
    //   1293: invokevirtual 799	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1296: aload_0
    //   1297: invokespecial 240	com/tencent/mobileqq/activity/qwallet/SendHbActivity:l	()V
    //   1300: return
    //   1301: aload_0
    //   1302: invokespecial 240	com/tencent/mobileqq/activity/qwallet/SendHbActivity:l	()V
    //   1305: return
    //   1306: astore 7
    //   1308: goto -1038 -> 270
    //   1311: goto -824 -> 487
    //   1314: aconst_null
    //   1315: astore_3
    //   1316: goto -1053 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1319	0	this	SendHbActivity
    //   0	1319	1	paramInt1	int
    //   0	1319	2	paramInt2	int
    //   0	1319	3	paramIntent	Intent
    //   127	855	4	localObject1	Object
    //   103	1107	5	localObject2	Object
    //   100	1185	6	str	String
    //   1306	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   118	129	305	java/lang/Exception
    //   206	215	316	java/lang/Exception
    //   616	645	667	org/json/JSONException
    //   263	270	1306	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131376343)
    {
      a(this.j, a(), "hongbao.wrapped.send", "", "");
      c();
    }
    while (i1 != 2131376342) {
      return;
    }
    String str = getString(2131697358) + getString(2131697037);
    paramView = getString(2131697312);
    if (this.jdField_c_of_type_Boolean)
    {
      str = getString(2131697358);
      paramView = getString(2131697119);
    }
    a(str, paramView, getString(2131697361));
    if (this.jdField_d_of_type_Boolean)
    {
      a(this.j, a(), "hongbao.wrapped.keyback", "", "");
      return;
    }
    a(this.j, a(), "hongbao.wrapped.close", "", "");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    QLog.i("SendHbActivity", 2, "SendHbActivity onKeyDown keyCode = " + paramInt + " event = " + paramKeyEvent);
    if (paramInt == 4)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment instanceof SendHbMainFragment)) {
          ((SendHbMainFragment)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment).a();
        }
        c("theme.pack.keyback");
        a();
        this.jdField_d_of_type_Int = -1;
        finish();
      }
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
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.SendHbActivity
 * JD-Core Version:    0.7.0.1
 */
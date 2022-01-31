package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.FragmentInterface;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbLogic;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
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
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xhb;
import xhd;
import xhe;
import xhf;

public class SendHbActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private String A;
  private String B = "";
  private String C = "0";
  private String D = "0";
  private String E = "";
  public int a;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new xhb(this);
  private Context jdField_a_of_type_AndroidContentContext;
  Intent jdField_a_of_type_AndroidContentIntent = new Intent();
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private QWalletPayProgressDialog jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog;
  public String a;
  List jdField_a_of_type_JavaUtilList = new ArrayList(Arrays.asList(new String[] { String.valueOf(32768), String.valueOf(16384), "128", "256", "512", "2048" }));
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new xhf(this);
  private Intent jdField_b_of_type_AndroidContentIntent;
  private View jdField_b_of_type_AndroidViewView;
  public String b;
  private JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  public String d;
  private boolean d;
  public String e;
  private boolean e;
  public String f;
  private boolean f;
  public String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private final String q = "video_reward";
  private String r = "0";
  private String s = "1";
  private String t;
  private String u;
  private String v = "";
  private String w;
  private String x;
  private String y;
  private String z;
  
  public SendHbActivity()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
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
  
  private ArrayList a(Intent paramIntent)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (paramIntent == null) {
      return localArrayList1;
    }
    Object localObject1 = paramIntent.getParcelableArrayListExtra("result_set");
    if (localObject1 != null)
    {
      paramIntent = (FriendsManager)this.app.getManager(50);
      localObject1 = ((ArrayList)localObject1).iterator();
      label181:
      label359:
      while (((Iterator)localObject1).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty(localResultRecord.jdField_a_of_type_JavaLangString))
        {
          localArrayList2.add(localResultRecord.jdField_a_of_type_JavaLangString);
          Object localObject2;
          if (TextUtils.isEmpty(localResultRecord.jdField_b_of_type_JavaLangString))
          {
            if (!this.h.equals("1")) {
              break label181;
            }
            localObject2 = paramIntent.c(localResultRecord.jdField_a_of_type_JavaLangString);
            if (localObject2 != null) {
              localResultRecord.jdField_b_of_type_JavaLangString = ((Friends)localObject2).getFriendNick();
            }
          }
          for (;;)
          {
            if (TextUtils.isEmpty(localResultRecord.jdField_b_of_type_JavaLangString)) {
              break label359;
            }
            localArrayList3.add(localResultRecord.jdField_b_of_type_JavaLangString);
            break;
            if (this.h.equals("2"))
            {
              localObject2 = ((DiscussionManager)this.app.getManager(52)).a(this.k, localResultRecord.jdField_a_of_type_JavaLangString);
              if (localObject2 != null) {
                localResultRecord.jdField_b_of_type_JavaLangString = ((DiscussionMemberInfo)localObject2).getDiscussionMemberName();
              }
            }
            else if (this.h.equals("3"))
            {
              localObject2 = DBUtils.a().a(this.app, this.k, localResultRecord.jdField_a_of_type_JavaLangString);
              if (localObject2 != null) {
                if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark)) {
                  localResultRecord.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).autoremark;
                } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick)) {
                  localResultRecord.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).troopnick;
                } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick)) {
                  localResultRecord.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).friendnick;
                } else {
                  localResultRecord.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).memberuin;
                }
              }
            }
          }
        }
      }
    }
    localArrayList1.add(localArrayList2);
    localArrayList1.add(localArrayList3);
    return localArrayList1;
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
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.qwallet.report");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void b(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null)
    {
      ((FrameLayout)findViewById(2131368189)).setVisibility(0);
      localFragmentTransaction.add(2131368189, this.jdField_a_of_type_AndroidSupportV4AppFragment);
      localFragmentTransaction.commit();
    }
    this.jdField_c_of_type_AndroidViewView = findViewById(2131362859);
    new ImmersionBar(this, paramInt, this.jdField_c_of_type_AndroidViewView);
  }
  
  private void c()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(this.w);; localObject = "")
    {
      localBundle.putString("uin", this.w);
      localBundle.putString("skey", (String)localObject);
      localBundle.putString("skey_type", "2");
      localBundle.putInt("PayInvokerId", 21);
      QWalletPayBridge.getWalletDataByService(BaseApplicationImpl.sApplication, this.app, localBundle);
      return;
    }
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof FragmentInterface))) {
      ((FragmentInterface)this.jdField_a_of_type_AndroidSupportV4AppFragment).c();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", paramString);
      localJSONObject.put("comeForm", this.jdField_b_of_type_Int);
      localJSONObject.put("h5_success", true);
      localJSONObject.put("appInfo", this.n);
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
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362845);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368190);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368191));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    ((Button)findViewById(2131368193)).setOnClickListener(this);
  }
  
  private void e()
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
  
  private void f()
  {
    if (this.r.equals("1")) {
      if (!this.jdField_a_of_type_OrgJsonJSONObject.has("hb_from_type")) {
        break label44;
      }
    }
    label44:
    for (this.D = this.jdField_a_of_type_OrgJsonJSONObject.optString("hb_from_type");; this.D = "1")
    {
      finish();
      return;
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    boolean bool = false;
    if (this.r.equals("1"))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("total_amount");
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("total_num");
      if (this.jdField_a_of_type_OrgJsonJSONObject.has("hb_from_type")) {}
      for (this.D = this.jdField_a_of_type_OrgJsonJSONObject.optString("hb_from_type");; this.D = "1")
      {
        new SendHbLogic(this).a(this.jdField_a_of_type_OrgJsonJSONObject);
        return;
      }
    }
    int i1 = getResources().getColor(2131493719);
    if ((this.jdField_b_of_type_Boolean) && ("h5".equals(this.v)) && (this.jdField_a_of_type_Int == 2048))
    {
      new SendHbLogic(this).a("", this.w);
      finish();
      return;
    }
    int i2;
    if (this.jdField_c_of_type_Boolean)
    {
      i2 = 64;
      switch (i2)
      {
      default: 
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(16777215);
        paramJSONObject = new Bundle();
        paramJSONObject.putString("channel", String.valueOf(this.jdField_a_of_type_Int));
        paramJSONObject.putString("placeholder", this.p);
        paramJSONObject.putString("people_num", this.x);
        paramJSONObject.putString("recv_type", this.h);
        paramJSONObject.putString("bus_type", this.z);
        paramJSONObject.putString("recv_uin", this.k);
        paramJSONObject.putString("redgift_type", this.i);
        paramJSONObject.putString("redgift_subtype", this.j);
      }
    }
    try
    {
      localObject = (QWalletConfigManager)this.app.getManager(244);
      if (localObject != null) {
        paramJSONObject.putString("config", ((QWalletConfigManager)localObject).a("voice_pwd"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
      }
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = new CommonHbFragment();
    this.jdField_a_of_type_AndroidSupportV4AppFragment.setArguments(paramJSONObject);
    for (;;)
    {
      b(i1);
      return;
      i2 = this.jdField_a_of_type_Int;
      break;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(16777215);
      if (paramJSONObject != null) {
        this.B = paramJSONObject.optString("feedsid");
      }
      paramJSONObject = new Bundle();
      paramJSONObject.putString("channel", this.jdField_a_of_type_Int + "");
      paramJSONObject.putString("feedsid", this.B);
      paramJSONObject.putString("send_name", this.l);
      paramJSONObject.putString("send_uin", this.w);
      paramJSONObject.putString("placeholder", this.p);
      paramJSONObject.putString("people_num", this.x);
      paramJSONObject.putString("recv_type", this.h);
      paramJSONObject.putString("bus_type", this.z);
      paramJSONObject.putString("wish_switch", this.C);
      this.jdField_a_of_type_AndroidSupportV4AppFragment = new CommonHbFragment();
      this.jdField_a_of_type_AndroidSupportV4AppFragment.setArguments(paramJSONObject);
      continue;
      a(paramJSONObject, "-1");
      i1 = -1308622848;
      continue;
      a(paramJSONObject, "-1");
      i1 = -1308622848;
      continue;
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        localObject = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("theme_config");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      for (paramJSONObject = "hb_theme_";; paramJSONObject = "")
      {
        try
        {
          localObject = new JSONObject((String)localObject);
          if (!((JSONObject)localObject).has("hb_theme_id")) {
            continue;
          }
          this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString(String.format("%sid", new Object[] { paramJSONObject }));
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject.printStackTrace();
          }
          paramJSONObject = new Bundle();
          paramJSONObject.putString("theme_type", this.jdField_c_of_type_JavaLangString);
          if ((!"64".equals(String.valueOf(this.jdField_a_of_type_Int))) && ((this.jdField_a_of_type_Int & 0x40) <= 0)) {
            break label823;
          }
          this.jdField_c_of_type_Boolean = true;
          this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("group_id");
          this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("group_member_number");
          this.jdField_a_of_type_AndroidSupportV4AppFragment = new ThemeHbFragment();
          paramJSONObject.putString("group_count", this.jdField_a_of_type_JavaLangString);
          paramJSONObject.putString("channel", String.valueOf(this.jdField_a_of_type_Int));
          if ((!"2".equals(this.h)) && (!"3".equals(this.h))) {
            break label887;
          }
          bool = true;
          paramJSONObject.putBoolean("isGroupThemeHb", bool);
          this.jdField_a_of_type_AndroidSupportV4AppFragment.setArguments(paramJSONObject);
          i1 = -1308622848;
        }
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          break;
        }
        QLog.i("SendHbActivity", 2, "params error, no theme id...");
        QQToast.a(this, "params error, no theme id...", 0).a();
        finish();
        return;
      }
      label823:
      label887:
      continue;
      paramJSONObject = new Bundle();
      paramJSONObject.putString("channel", String.valueOf(this.jdField_a_of_type_Int));
      paramJSONObject.putString("recv_uin", this.jdField_a_of_type_OrgJsonJSONObject.optString("recv_uin"));
      this.jdField_a_of_type_AndroidSupportV4AppFragment = new ThemeHbFragment();
      this.jdField_a_of_type_AndroidSupportV4AppFragment.setArguments(paramJSONObject);
      i1 = -1308622848;
    }
  }
  
  public int a()
  {
    String str = String.valueOf(this.jdField_a_of_type_Int);
    if (("5".equals(str)) || ("16".equals(str)))
    {
      if (("1".equals(this.h)) || ("7".equals(this.h))) {
        return 146;
      }
      return 145;
    }
    if (str.equals("32768")) {
      return 171;
    }
    if (str.equals("16384")) {
      return 170;
    }
    if (this.jdField_b_of_type_Boolean) {
      return 131;
    }
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && ((this.jdField_a_of_type_Int & 0x40) == 0)) {
      return 149;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && ((this.jdField_a_of_type_Int & 0x40) == 0)) {
      return 157;
    }
    if ((this.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_Int & 0x40) > 0)) {
      return 156;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CommonHbFragment)) && (((CommonHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a() == 2)) {
      return 150;
    }
    if (("1".equals(this.h)) && (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CommonHbFragment)) && (((CommonHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a() == 1)) {
      return 153;
    }
    if (("4".equals(this.h)) || ("5".equals(this.h))) {
      return 155;
    }
    if (("1".equals(this.h)) || ("7".equals(this.h))) {
      return 133;
    }
    return 132;
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
  
  public String a()
  {
    String str2 = String.valueOf(this.jdField_a_of_type_Int);
    String str1 = str2;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null)
    {
      str1 = str2;
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CommonHbFragment)) {
        str1 = ((CommonHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
      }
    }
    return str1;
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
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("1");
    return localArrayList;
  }
  
  public Map a()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_OrgJsonJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, this.jdField_a_of_type_OrgJsonJSONObject.optString(str));
    }
    localHashMap.put("name", this.l);
    if (!"2048".equals(String.valueOf(this.jdField_a_of_type_Int)))
    {
      localHashMap.put("recv_uin", this.k);
      localHashMap.put("recv_type", this.u);
    }
    localHashMap.put("hb_from_type", this.D + "");
    localHashMap.put("na_from_h5_data", this.t);
    localHashMap.put("session_token", this.o);
    return localHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("hb_id", this.y);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("send_uin", this.w);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("hb_type", "1");
    this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_text", getString(2131431548));
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("item", 1);
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_type", 17);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("invoke_from", "qwallet");
    ForwardBaseOption.a(this, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  public void a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", paramInt);
      label17:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.m);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", localJSONObject.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(this.w, paramInt1, paramString, "", "");
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a(this.w, a(), paramString1, paramString2, "");
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).b(a(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QWalletHelper.saveQRTokenConfig(this, paramString, this.w);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(this.w, a(), paramString, "", "");
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    QWalletTools.a(this.app, paramString1, this.jdField_b_of_type_Int, this.n, this.jdField_a_of_type_Long, paramInt, paramString2, paramString3, paramString4);
  }
  
  protected void a(String paramString1, String paramString2)
  {
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
          if (this.h.equals("1"))
          {
            paramString2 = "1";
            localJSONObject.put("channel", paramString2);
            paramString2 = new JSONObject();
            paramString2.put("userId", this.w);
            paramString2.put("viewTag", paramString1);
            paramString2.put("comeForm", 2);
            paramString2.put("appInfo", this.n);
            paramString2.put("extra_data", localJSONObject.toString());
            PayBridgeActivity.tenpay(this, paramString2.toString(), 5, "0");
          }
        }
        else
        {
          localJSONObject.put("channel", String.valueOf(this.jdField_a_of_type_Int));
          continue;
        }
        paramString2 = "1024";
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
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    DialogUtil.a(this, 230, null, paramString1, paramString2, paramString3, new xhd(this), new xhe(this)).show();
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    if ("2".equals(paramString)) {
      localIntent.putExtra("param_only_discussion_member", true);
    }
    for (;;)
    {
      localIntent.putExtra("param_title", getString(2131431541));
      localIntent.putExtra("param_min", 0);
      localIntent.putExtra("param_done_button_wording", getString(2131435984));
      localIntent.putExtra("param_done_button_highlight_wording", getString(2131435985));
      localIntent.putExtra("param_max", 5);
      localIntent.putExtra("param_entrance", 25);
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label210;
      }
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        new ResultRecord().jdField_a_of_type_JavaLangString = str;
        paramString.add(SelectMemberActivity.a(str, "", 0, this.w));
      }
      if ("3".equals(paramString)) {
        localIntent.putExtra("param_only_troop_member", true);
      }
    }
    localIntent.putExtra("param_selected_records_for_create_discussion", paramString);
    label210:
    localIntent.putExtra("group_uin", this.k);
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
      localJSONObject.putOpt("send_name", this.l);
      localJSONObject.putOpt("send_uin", this.w);
      localJSONObject.putOpt("send_listid", paramJSONObject.optString("send_listid"));
      localJSONObject.putOpt("amount", paramJSONObject.optString("amount"));
      localJSONObject.putOpt("feedsid", this.B);
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
        localIntent.putExtra("callbackSn", this.m);
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
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      this.B = paramJSONObject.optString("feedsid");
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragment = new QzoneHbFragment();
    paramString = new Bundle();
    paramString.putString("send_name", this.l);
    paramString.putString("recv_name", this.A);
    paramString.putString("feedsid", this.B);
    paramString.putString("recv_uin", this.k);
    paramString.putString("send_uin", this.w);
    paramString.putString("channel", String.valueOf(this.jdField_a_of_type_Int));
    if (paramJSONObject != null)
    {
      paramString.putString("grab_uin_list", paramJSONObject.optString("grab_uin_list"));
      paramString.putString("recv_type", paramJSONObject.optString("recv_type"));
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment.setArguments(paramString);
  }
  
  public Map b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", this.w);
    localHashMap.put("viewTag", "sendHb");
    localHashMap.put("comeForm", "2");
    localHashMap.put("appInfo", this.n);
    return localHashMap;
  }
  
  public void b(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    try
    {
      Object localObject = a();
      ((Map)localObject).put("total_num", this.s);
      ((Map)localObject).put("total_amount", a(paramString));
      ((Map)localObject).put("channel", String.valueOf(this.jdField_a_of_type_Int));
      ((Map)localObject).put("recv_uin", this.k);
      ((Map)localObject).put("bus_type", this.z);
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
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  protected void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("userId", this.w);
        localJSONObject1.put("viewTag", "qrcodeHb");
        localJSONObject1.put("comeForm", 2);
        JSONObject localJSONObject2 = new JSONObject();
        str = a(paramJSONObject);
        if (!TextUtils.isEmpty(str)) {
          localJSONObject2.putOpt("qrData", str);
        }
        localJSONObject2.putOpt("comeFrom", Integer.valueOf(this.jdField_b_of_type_Int));
        a(paramJSONObject.optString("qr_token"));
        localJSONObject1.put("extra_data", localJSONObject2.toString());
        paramJSONObject = new Bundle();
        paramJSONObject.putString("json", localJSONObject1.toString());
        paramJSONObject.putString("callbackSn", "0");
        paramJSONObject.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
        if (TextUtils.isEmpty(this.E))
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
      if ("1".equals(this.E))
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
      ((Intent)localObject).putExtra("callbackSn", this.m);
      ((Intent)localObject).putExtra("PayInvokerId", 5);
      JSONObject localJSONObject = new JSONObject();
      label253:
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
              a(this.w, a(), "bqredpacket.pay.expose", "", "");
            }
            QLog.i("SendHbActivity", 2, "onFaceHbResult back jdata = " + localJSONObject);
            ((Intent)localObject).putExtra("data", localJSONObject.toString());
            setResult(-1, (Intent)localObject);
            finish();
            return;
          }
          catch (Exception paramJSONObject)
          {
            break label253;
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    this.jdField_b_of_type_AndroidContentIntent = ((Intent)localObject);
    ((Intent)localObject).putExtra("fling_action_key", 0);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    b();
    this.jdField_c_of_type_Boolean = this.jdField_b_of_type_AndroidContentIntent.getBooleanExtra("theme", false);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.jdField_a_of_type_AndroidContentContext = this;
    for (;;)
    {
      try
      {
        this.w = this.app.getCurrentAccountUin();
        this.l = this.app.getCurrentNickname();
        this.jdField_b_of_type_Boolean = this.jdField_b_of_type_AndroidContentIntent.getBooleanExtra("is_H5", false);
        this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidContentIntent.getIntExtra("come_from", 1);
        this.m = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("callbackSn");
        this.n = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("app_info");
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(this.jdField_b_of_type_AndroidContentIntent.getStringExtra("extra_data"));
        paramBundle = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("extra_info");
        if (paramBundle != null)
        {
          this.i = paramBundle.optString("redgift_type");
          this.j = paramBundle.optString("redgift_subtype");
        }
        QLog.i("SendHbActivity", 2, "extra_data = " + this.jdField_a_of_type_OrgJsonJSONObject);
        this.k = this.jdField_a_of_type_OrgJsonJSONObject.optString("recv_uin");
        this.A = this.jdField_a_of_type_OrgJsonJSONObject.optString("recv_name");
        this.x = this.jdField_a_of_type_OrgJsonJSONObject.optString("people_num");
        this.h = this.jdField_a_of_type_OrgJsonJSONObject.optString("recv_type");
        this.C = this.jdField_a_of_type_OrgJsonJSONObject.optString("hide_wishing");
        this.E = this.jdField_a_of_type_OrgJsonJSONObject.optString("from_plugin", "");
        this.u = this.h;
        this.z = this.jdField_a_of_type_OrgJsonJSONObject.optString("bus_type");
        this.o = this.jdField_a_of_type_OrgJsonJSONObject.optString("session_token");
        localObject = this.jdField_a_of_type_OrgJsonJSONObject.optString("channel", "1");
        paramBundle = (Bundle)localObject;
        if (((String)localObject).equals("")) {
          paramBundle = "1";
        }
        this.r = this.jdField_a_of_type_OrgJsonJSONObject.optString("makeHb_type");
        this.s = this.jdField_a_of_type_OrgJsonJSONObject.optString("total_num", "1");
        QLog.i("SendHbActivity", 2, "mChannel = " + paramBundle);
        this.v = this.jdField_a_of_type_OrgJsonJSONObject.optString("invoke_from");
        if (!this.jdField_c_of_type_Boolean) {
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("theme_type");
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
        VACDReportUtil.a(this.jdField_a_of_type_Long, null, "hbinvoke", paramBundle.toString(), 0, null);
        continue;
      }
      try
      {
        if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (Integer.valueOf(this.jdField_c_of_type_JavaLangString).intValue() > 1)) {
          this.jdField_c_of_type_Boolean = true;
        }
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("theme_type");
        }
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("feedsid");
        this.g = this.jdField_a_of_type_OrgJsonJSONObject.optString("poi");
        if ("5".equals(paramBundle))
        {
          paramBundle = "16";
          localObject = paramBundle;
          if ("6".equals(paramBundle)) {
            localObject = "32";
          }
          this.jdField_f_of_type_Boolean = this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("feedback", false);
          this.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
          if (("5".equals(localObject)) || ("16".equals(localObject)) || ("128".equals(localObject)) || ("256".equals(localObject)))
          {
            this.l = ContactUtils.q(this.app, this.w);
            if (TextUtils.isEmpty(this.l)) {
              this.l = this.app.getCurrentNickname();
            }
          }
          this.p = this.jdField_a_of_type_OrgJsonJSONObject.optString("placeholder");
          this.t = this.jdField_a_of_type_OrgJsonJSONObject.optString("na_from_h5_data");
          this.jdField_a_of_type_Long = this.jdField_b_of_type_AndroidContentIntent.getLongExtra("vacreport_key_seq", 0L);
          paramBundle = new StringBuilder(256);
          paramBundle.append("isH5=").append(this.jdField_b_of_type_Boolean);
          paramBundle.append("&comeFrom=").append(this.jdField_b_of_type_Int);
          paramBundle.append("&callbackSn=").append(this.m);
          paramBundle.append("&appInfo=").append(this.n);
          paramBundle.append("&extra=").append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
          if (this.jdField_a_of_type_Long == 0L) {
            this.jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "hbinvoke", paramBundle.toString(), 0, null);
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          setContentView(2130969839);
          d();
          f(this.jdField_a_of_type_OrgJsonJSONObject);
          e();
          QWalletHelper.preloadQWallet(this.app);
          if (QWalletHelper.isNeedPreConnect(this.jdField_a_of_type_AndroidContentContext, this.w, "type_mqq_and_myun")) {
            c();
          }
          return true;
        }
        catch (OutOfMemoryError paramBundle)
        {
          return false;
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    try
    {
      this.mSystemBarComp = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (this.jdField_a_of_type_Long != 0L) {
        VACDReportUtil.endReport(this.jdField_a_of_type_Long, "hongbao.wrap.destroy", null, 0, null);
      }
      if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      }
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Boolean = false;
    a(this.w, a(), "hongbao.wrap.show", "", "");
    a("1103".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  /* Error */
  protected void e(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 654
    //   3: iconst_2
    //   4: new 608	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 609	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 1186
    //   14: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 988	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 617	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 661	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_1
    //   28: ifnonnull +4 -> 32
    //   31: return
    //   32: new 1188	java/lang/StringBuffer
    //   35: dup
    //   36: aload_1
    //   37: ldc_w 1190
    //   40: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 1195	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokespecial 1196	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_1
    //   51: ldc_w 865
    //   54: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_3
    //   58: aload_3
    //   59: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +17 -> 79
    //   65: aload_2
    //   66: ldc_w 1198
    //   69: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: aload_2
    //   74: aload_3
    //   75: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   78: pop
    //   79: aload_1
    //   80: ldc_w 1203
    //   83: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +17 -> 108
    //   94: aload_2
    //   95: ldc_w 1205
    //   98: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: pop
    //   102: aload_2
    //   103: aload_3
    //   104: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   107: pop
    //   108: aload_1
    //   109: ldc_w 1207
    //   112: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +17 -> 137
    //   123: aload_2
    //   124: ldc_w 1209
    //   127: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   130: pop
    //   131: aload_2
    //   132: aload_3
    //   133: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: aload_1
    //   138: ldc_w 1211
    //   141: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_1
    //   145: aload_1
    //   146: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +17 -> 166
    //   152: aload_2
    //   153: ldc_w 1213
    //   156: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: aload_2
    //   161: aload_1
    //   162: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   165: pop
    //   166: new 442	org/json/JSONObject
    //   169: dup
    //   170: invokespecial 443	org/json/JSONObject:<init>	()V
    //   173: astore_1
    //   174: new 442	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 443	org/json/JSONObject:<init>	()V
    //   181: astore_3
    //   182: aload_3
    //   183: ldc_w 1190
    //   186: aload_2
    //   187: invokevirtual 1214	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   190: invokevirtual 449	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload_1
    //   195: ldc_w 810
    //   198: iconst_0
    //   199: invokevirtual 456	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload_1
    //   204: ldc_w 739
    //   207: ldc_w 1216
    //   210: invokevirtual 449	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload_1
    //   215: ldc_w 728
    //   218: aload_3
    //   219: invokevirtual 449	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: ldc_w 654
    //   226: iconst_2
    //   227: new 608	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 609	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 1218
    //   237: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_1
    //   241: invokevirtual 988	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 617	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 661	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: new 128	android/content/Intent
    //   253: dup
    //   254: invokespecial 129	android/content/Intent:<init>	()V
    //   257: astore_2
    //   258: aload_2
    //   259: ldc_w 471
    //   262: aload_0
    //   263: getfield 812	com/tencent/mobileqq/activity/qwallet/SendHbActivity:m	Ljava/lang/String;
    //   266: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   269: pop
    //   270: aload_2
    //   271: ldc_w 418
    //   274: iconst_5
    //   275: invokevirtual 737	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   278: pop
    //   279: aload_2
    //   280: ldc_w 734
    //   283: aload_1
    //   284: invokevirtual 469	org/json/JSONObject:toString	()Ljava/lang/String;
    //   287: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   290: pop
    //   291: aload_0
    //   292: iconst_m1
    //   293: aload_2
    //   294: invokevirtual 816	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   297: aload_0
    //   298: invokevirtual 523	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   301: return
    //   302: astore_1
    //   303: aload_1
    //   304: invokevirtual 488	java/lang/Exception:printStackTrace	()V
    //   307: return
    //   308: astore_2
    //   309: goto -86 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	SendHbActivity
    //   0	312	1	paramJSONObject	JSONObject
    //   49	245	2	localObject1	Object
    //   308	1	2	localException	Exception
    //   57	162	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	79	302	java/lang/Exception
    //   79	108	302	java/lang/Exception
    //   108	137	302	java/lang/Exception
    //   137	166	302	java/lang/Exception
    //   166	174	302	java/lang/Exception
    //   223	301	302	java/lang/Exception
    //   174	223	308	java/lang/Exception
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 654
    //   3: iconst_2
    //   4: new 608	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 609	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 1222
    //   14: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: iload_1
    //   18: invokevirtual 613	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: ldc_w 1224
    //   24: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 613	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 617	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 661	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: ldc_w 654
    //   40: iconst_2
    //   41: new 608	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 609	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 1226
    //   51: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 988	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 617	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 661	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iload_1
    //   65: sipush 1024
    //   68: if_icmpne +48 -> 116
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpne +43 -> 116
    //   76: aload_3
    //   77: ifnull +39 -> 116
    //   80: aload_0
    //   81: aload_3
    //   82: invokespecial 1228	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Landroid/content/Intent;)Ljava/util/ArrayList;
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 375	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_AndroidSupportV4AppFragment	Landroid/support/v4/app/Fragment;
    //   91: ifnull +25 -> 116
    //   94: aload_0
    //   95: getfield 375	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_AndroidSupportV4AppFragment	Landroid/support/v4/app/Fragment;
    //   98: instanceof 595
    //   101: ifeq +15 -> 116
    //   104: aload_0
    //   105: getfield 375	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_AndroidSupportV4AppFragment	Landroid/support/v4/app/Fragment;
    //   108: checkcast 595	com/tencent/mobileqq/activity/qwallet/fragment/CommonHbFragment
    //   111: aload 5
    //   113: invokevirtual 1231	com/tencent/mobileqq/activity/qwallet/fragment/CommonHbFragment:a	(Ljava/util/ArrayList;)V
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 828	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Boolean	Z
    //   121: aload_3
    //   122: ifnull +1152 -> 1274
    //   125: iload_2
    //   126: iconst_m1
    //   127: if_icmpne +1147 -> 1274
    //   130: aload_3
    //   131: ldc_w 734
    //   134: invokevirtual 640	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 8
    //   139: aconst_null
    //   140: astore_3
    //   141: aload 8
    //   143: ifnull +185 -> 328
    //   146: aload 8
    //   148: invokevirtual 1234	java/lang/String:length	()I
    //   151: ifle +177 -> 328
    //   154: new 442	org/json/JSONObject
    //   157: dup
    //   158: aload 8
    //   160: invokespecial 643	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   163: astore 5
    //   165: ldc_w 654
    //   168: iconst_2
    //   169: new 608	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 609	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1236
    //   179: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 5
    //   184: invokevirtual 988	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 617	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 661	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 5
    //   195: ifnull +150 -> 345
    //   198: aload 5
    //   200: ldc_w 739
    //   203: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 6
    //   208: aload 5
    //   210: ldc_w 810
    //   213: iconst_m1
    //   214: invokevirtual 1000	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   217: istore 4
    //   219: aload 5
    //   221: ldc_w 728
    //   224: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 7
    //   229: aload 6
    //   231: astore_3
    //   232: iload 4
    //   234: istore_2
    //   235: aload 7
    //   237: ifnull +108 -> 345
    //   240: aload 6
    //   242: astore_3
    //   243: iload 4
    //   245: istore_2
    //   246: aload 7
    //   248: invokevirtual 1234	java/lang/String:length	()I
    //   251: ifle +94 -> 345
    //   254: new 442	org/json/JSONObject
    //   257: dup
    //   258: aload 7
    //   260: invokespecial 643	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   263: astore_3
    //   264: iload 4
    //   266: istore_2
    //   267: aload_0
    //   268: getfield 860	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   271: invokevirtual 1239	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   274: aload_0
    //   275: getfield 553	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   278: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   281: astore 7
    //   283: iload_2
    //   284: ifne +758 -> 1042
    //   287: aload_3
    //   288: ifnull +754 -> 1042
    //   291: iload_1
    //   292: lookupswitch	default:+28->320, 5:+65->357, 9:+443->735
    //   321: astore 5
    //   323: aload 5
    //   325: invokevirtual 488	java/lang/Exception:printStackTrace	()V
    //   328: aconst_null
    //   329: astore 5
    //   331: goto -166 -> 165
    //   334: astore_3
    //   335: aload_3
    //   336: invokevirtual 488	java/lang/Exception:printStackTrace	()V
    //   339: iload 4
    //   341: istore_2
    //   342: aload 6
    //   344: astore_3
    //   345: aconst_null
    //   346: astore 7
    //   348: aload_3
    //   349: astore 6
    //   351: aload 7
    //   353: astore_3
    //   354: goto -87 -> 267
    //   357: aload_0
    //   358: getfield 855	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   361: ifeq +262 -> 623
    //   364: aload_0
    //   365: iconst_0
    //   366: putfield 855	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   369: aload_0
    //   370: iconst_m1
    //   371: putfield 80	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_Int	I
    //   374: aload_3
    //   375: ldc_w 1241
    //   378: invokevirtual 1243	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   381: istore_1
    //   382: iconst_1
    //   383: iload_1
    //   384: if_icmpeq +8 -> 392
    //   387: iconst_2
    //   388: iload_1
    //   389: if_icmpne +169 -> 558
    //   392: aload_0
    //   393: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   396: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifeq +67 -> 466
    //   402: aload_0
    //   403: getfield 491	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   406: iconst_0
    //   407: invokevirtual 527	android/view/View:setVisibility	(I)V
    //   410: aload_0
    //   411: getfield 494	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   414: iconst_0
    //   415: invokevirtual 527	android/view/View:setVisibility	(I)V
    //   418: aload_0
    //   419: getfield 393	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   422: ifnull +13 -> 435
    //   425: aload_0
    //   426: getfield 393	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   429: ldc_w 631
    //   432: invokevirtual 559	android/view/View:setBackgroundColor	(I)V
    //   435: aload_0
    //   436: aload_3
    //   437: ldc_w 750
    //   440: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   443: putfield 135	com/tencent/mobileqq/activity/qwallet/SendHbActivity:y	Ljava/lang/String;
    //   446: aload_0
    //   447: aload_0
    //   448: getfield 351	com/tencent/mobileqq/activity/qwallet/SendHbActivity:w	Ljava/lang/String;
    //   451: aload_0
    //   452: invokevirtual 825	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()I
    //   455: ldc_w 1245
    //   458: ldc 70
    //   460: ldc 70
    //   462: invokevirtual 823	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   465: return
    //   466: ldc 106
    //   468: aload 7
    //   470: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   473: ifne +69 -> 542
    //   476: ldc 104
    //   478: aload 7
    //   480: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   483: ifne +59 -> 542
    //   486: ldc 108
    //   488: aload 7
    //   490: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   493: ifne +49 -> 542
    //   496: ldc 110
    //   498: aload 7
    //   500: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifne +39 -> 542
    //   506: aload_0
    //   507: getfield 1247	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   510: ifnull +774 -> 1284
    //   513: aload_0
    //   514: getfield 1247	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   517: astore_3
    //   518: aload 7
    //   520: ldc_w 700
    //   523: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   526: ifeq +10 -> 536
    //   529: aload_0
    //   530: aload 5
    //   532: invokevirtual 1249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:d	(Lorg/json/JSONObject;)V
    //   535: return
    //   536: aload_0
    //   537: aload_3
    //   538: invokevirtual 1251	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Lorg/json/JSONObject;)V
    //   541: return
    //   542: ldc 110
    //   544: aload 7
    //   546: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   549: ifeq -229 -> 320
    //   552: aload_0
    //   553: aload_3
    //   554: invokevirtual 1253	com/tencent/mobileqq/activity/qwallet/SendHbActivity:c	(Lorg/json/JSONObject;)V
    //   557: return
    //   558: ldc 106
    //   560: aload 7
    //   562: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   565: ifne +24 -> 589
    //   568: ldc 104
    //   570: aload 7
    //   572: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   575: ifne +14 -> 589
    //   578: aload 7
    //   580: ldc_w 698
    //   583: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   586: ifeq +9 -> 595
    //   589: aload_0
    //   590: aload_3
    //   591: invokevirtual 1255	com/tencent/mobileqq/activity/qwallet/SendHbActivity:b	(Lorg/json/JSONObject;)V
    //   594: return
    //   595: ldc 108
    //   597: aload 7
    //   599: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   602: ifeq +9 -> 611
    //   605: aload_0
    //   606: aload_3
    //   607: invokevirtual 1256	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Lorg/json/JSONObject;)V
    //   610: return
    //   611: aload_0
    //   612: aload_0
    //   613: ldc_w 1257
    //   616: invokevirtual 795	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   619: invokevirtual 961	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   622: return
    //   623: ldc_w 673
    //   626: aload 7
    //   628: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   631: ifne +13 -> 644
    //   634: aload_0
    //   635: getfield 553	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Int	I
    //   638: bipush 64
    //   640: iand
    //   641: ifle +71 -> 712
    //   644: new 442	org/json/JSONObject
    //   647: dup
    //   648: invokespecial 443	org/json/JSONObject:<init>	()V
    //   651: astore 5
    //   653: aload 5
    //   655: ldc_w 1259
    //   658: aload_3
    //   659: ldc_w 1259
    //   662: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   665: invokevirtual 941	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 5
    //   671: ldc_w 529
    //   674: aload_0
    //   675: getfield 74	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   678: invokevirtual 941	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   681: pop
    //   682: aload_0
    //   683: iconst_m1
    //   684: aload_0
    //   685: iload_2
    //   686: ldc 70
    //   688: aload 5
    //   690: invokevirtual 469	org/json/JSONObject:toString	()Ljava/lang/String;
    //   693: invokevirtual 1261	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(ILjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   696: invokevirtual 816	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   699: aload_0
    //   700: invokevirtual 523	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   703: return
    //   704: astore_3
    //   705: aload_3
    //   706: invokevirtual 487	org/json/JSONException:printStackTrace	()V
    //   709: goto -27 -> 682
    //   712: aload_0
    //   713: aload_3
    //   714: ldc_w 1263
    //   717: invokevirtual 1243	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   720: putfield 80	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_Int	I
    //   723: aload_0
    //   724: aload_3
    //   725: ldc_w 1259
    //   728: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   731: invokespecial 1265	com/tencent/mobileqq/activity/qwallet/SendHbActivity:c	(Ljava/lang/String;)V
    //   734: return
    //   735: aload_3
    //   736: ldc_w 1190
    //   739: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   742: astore 5
    //   744: new 1188	java/lang/StringBuffer
    //   747: dup
    //   748: invokespecial 1266	java/lang/StringBuffer:<init>	()V
    //   751: astore 6
    //   753: aload 6
    //   755: ldc_w 1268
    //   758: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   761: pop
    //   762: aload 6
    //   764: aload_0
    //   765: getfield 76	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   768: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   771: pop
    //   772: aload 6
    //   774: ldc_w 1270
    //   777: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   780: pop
    //   781: ldc 66
    //   783: aload_0
    //   784: getfield 231	com/tencent/mobileqq/activity/qwallet/SendHbActivity:h	Ljava/lang/String;
    //   787: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   790: ifne +42 -> 832
    //   793: ldc_w 696
    //   796: aload_0
    //   797: getfield 231	com/tencent/mobileqq/activity/qwallet/SendHbActivity:h	Ljava/lang/String;
    //   800: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   803: ifne +29 -> 832
    //   806: ldc_w 706
    //   809: aload_0
    //   810: getfield 231	com/tencent/mobileqq/activity/qwallet/SendHbActivity:h	Ljava/lang/String;
    //   813: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   816: ifne +16 -> 832
    //   819: ldc_w 692
    //   822: aload_0
    //   823: getfield 231	com/tencent/mobileqq/activity/qwallet/SendHbActivity:h	Ljava/lang/String;
    //   826: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   829: ifeq +142 -> 971
    //   832: aload 6
    //   834: ldc_w 1272
    //   837: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   840: pop
    //   841: aload 6
    //   843: ldc_w 1274
    //   846: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   849: pop
    //   850: aload 6
    //   852: aload_0
    //   853: invokevirtual 1275	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()Ljava/lang/String;
    //   856: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   859: pop
    //   860: aload 6
    //   862: ldc_w 1277
    //   865: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   868: pop
    //   869: aload 6
    //   871: aload_0
    //   872: getfield 74	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   875: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   878: pop
    //   879: aload_0
    //   880: aload_0
    //   881: getfield 351	com/tencent/mobileqq/activity/qwallet/SendHbActivity:w	Ljava/lang/String;
    //   884: aload_0
    //   885: invokevirtual 825	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()I
    //   888: ldc_w 1279
    //   891: aload 6
    //   893: invokevirtual 1214	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   896: aconst_null
    //   897: invokevirtual 823	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   900: aload 5
    //   902: ifnull -582 -> 320
    //   905: aload_0
    //   906: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   909: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   912: ifne +25 -> 937
    //   915: aload_0
    //   916: getfield 80	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_Int	I
    //   919: iconst_1
    //   920: if_icmpeq +17 -> 937
    //   923: aload_0
    //   924: getfield 121	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   927: aload 7
    //   929: invokeinterface 1282 2 0
    //   934: ifeq +85 -> 1019
    //   937: aload_3
    //   938: ldc_w 865
    //   941: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   944: astore 5
    //   946: ldc 110
    //   948: aload 7
    //   950: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   953: ifeq +54 -> 1007
    //   956: aload_0
    //   957: ldc_w 1284
    //   960: aload 5
    //   962: invokevirtual 1285	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   965: aload_0
    //   966: aload_3
    //   967: putfield 1247	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   970: return
    //   971: ldc 245
    //   973: aload_0
    //   974: getfield 231	com/tencent/mobileqq/activity/qwallet/SendHbActivity:h	Ljava/lang/String;
    //   977: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   980: ifeq +15 -> 995
    //   983: aload 6
    //   985: ldc_w 1287
    //   988: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   991: pop
    //   992: goto -151 -> 841
    //   995: aload 6
    //   997: ldc_w 1289
    //   1000: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1003: pop
    //   1004: goto -163 -> 841
    //   1007: aload_0
    //   1008: ldc_w 1291
    //   1011: aload 5
    //   1013: invokevirtual 1285	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1016: goto -51 -> 965
    //   1019: aload 7
    //   1021: ldc_w 700
    //   1024: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1027: ifeq +9 -> 1036
    //   1030: aload_0
    //   1031: aload_3
    //   1032: invokevirtual 1249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:d	(Lorg/json/JSONObject;)V
    //   1035: return
    //   1036: aload_0
    //   1037: aload_3
    //   1038: invokevirtual 1251	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Lorg/json/JSONObject;)V
    //   1041: return
    //   1042: iload_2
    //   1043: ifle +158 -> 1201
    //   1046: aload_0
    //   1047: getfield 855	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   1050: ifeq +51 -> 1101
    //   1053: ldc 106
    //   1055: aload 7
    //   1057: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1060: ifne +13 -> 1073
    //   1063: ldc 104
    //   1065: aload 7
    //   1067: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1070: ifeq +81 -> 1151
    //   1073: new 128	android/content/Intent
    //   1076: dup
    //   1077: invokespecial 129	android/content/Intent:<init>	()V
    //   1080: astore_3
    //   1081: aload_3
    //   1082: ldc_w 739
    //   1085: aload 8
    //   1087: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1090: pop
    //   1091: aload_0
    //   1092: iconst_m1
    //   1093: aload_3
    //   1094: invokevirtual 816	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1097: aload_0
    //   1098: invokevirtual 523	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   1101: aload_0
    //   1102: ldc_w 1292
    //   1105: invokevirtual 795	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1108: astore_3
    //   1109: iload_2
    //   1110: ldc_w 1293
    //   1113: if_icmpne +66 -> 1179
    //   1116: aload_0
    //   1117: sipush 230
    //   1120: aconst_null
    //   1121: aload 6
    //   1123: aconst_null
    //   1124: aload_0
    //   1125: ldc_w 1294
    //   1128: invokevirtual 795	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1131: new 1296	xhc
    //   1134: dup
    //   1135: aload_0
    //   1136: invokespecial 1297	xhc:<init>	(Lcom/tencent/mobileqq/activity/qwallet/SendHbActivity;)V
    //   1139: aconst_null
    //   1140: invokestatic 889	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1143: invokevirtual 892	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1146: aload_0
    //   1147: invokespecial 283	com/tencent/mobileqq/activity/qwallet/SendHbActivity:f	()V
    //   1150: return
    //   1151: aload_0
    //   1152: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   1155: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1158: ifne -57 -> 1101
    //   1161: aload_0
    //   1162: getfield 1247	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   1165: ifnull -64 -> 1101
    //   1168: aload_0
    //   1169: aload_0
    //   1170: getfield 1247	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   1173: invokevirtual 1251	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Lorg/json/JSONObject;)V
    //   1176: goto -75 -> 1101
    //   1179: aload 6
    //   1181: ifnull +12 -> 1193
    //   1184: aload_0
    //   1185: aload 6
    //   1187: invokevirtual 961	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1190: goto -44 -> 1146
    //   1193: aload_0
    //   1194: aload_3
    //   1195: invokevirtual 961	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1198: goto -52 -> 1146
    //   1201: iload_2
    //   1202: bipush 246
    //   1204: if_icmpge +32 -> 1236
    //   1207: aload_0
    //   1208: new 608	java/lang/StringBuilder
    //   1211: dup
    //   1212: invokespecial 609	java/lang/StringBuilder:<init>	()V
    //   1215: ldc_w 1299
    //   1218: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: iload_2
    //   1222: invokevirtual 613	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1225: invokevirtual 617	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokevirtual 961	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1231: aload_0
    //   1232: invokespecial 283	com/tencent/mobileqq/activity/qwallet/SendHbActivity:f	()V
    //   1235: return
    //   1236: new 128	android/content/Intent
    //   1239: dup
    //   1240: invokespecial 129	android/content/Intent:<init>	()V
    //   1243: astore_3
    //   1244: aload_3
    //   1245: ldc_w 418
    //   1248: iconst_5
    //   1249: invokevirtual 737	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1252: pop
    //   1253: aload_3
    //   1254: ldc_w 734
    //   1257: aload 8
    //   1259: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1262: pop
    //   1263: aload_0
    //   1264: iconst_m1
    //   1265: aload_3
    //   1266: invokevirtual 816	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1269: aload_0
    //   1270: invokespecial 283	com/tencent/mobileqq/activity/qwallet/SendHbActivity:f	()V
    //   1273: return
    //   1274: aload_0
    //   1275: invokespecial 283	com/tencent/mobileqq/activity/qwallet/SendHbActivity:f	()V
    //   1278: return
    //   1279: astore 7
    //   1281: goto -1007 -> 274
    //   1284: goto -766 -> 518
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1287	0	this	SendHbActivity
    //   0	1287	1	paramInt1	int
    //   0	1287	2	paramInt2	int
    //   0	1287	3	paramIntent	Intent
    //   217	123	4	i1	int
    //   85	135	5	localObject1	Object
    //   321	3	5	localException1	Exception
    //   329	683	5	localObject2	Object
    //   206	980	6	localObject3	Object
    //   227	839	7	str1	String
    //   1279	1	7	localException2	Exception
    //   137	1121	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   154	165	321	java/lang/Exception
    //   254	264	334	java/lang/Exception
    //   653	682	704	org/json/JSONException
    //   267	274	1279	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131368193)
    {
      a(this.w, a(), "hongbao.wrapped.send", "", "");
      a();
    }
    while (i1 != 2131368191) {
      return;
    }
    String str = getString(2131431546) + getString(2131431547);
    paramView = getString(2131431545);
    if (this.jdField_c_of_type_Boolean)
    {
      str = getString(2131431546);
      paramView = getString(2131431544);
    }
    a(str, paramView, getString(2131431543));
    if (this.jdField_d_of_type_Boolean)
    {
      a(this.w, a(), "hongbao.wrapped.keyback", "", "");
      return;
    }
    a(this.w, a(), "hongbao.wrapped.close", "", "");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    QLog.i("SendHbActivity", 2, "SendHbActivity onKeyDown keyCode = " + paramInt + " event = " + paramKeyEvent);
    if (paramInt == 4)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CommonHbFragment))
        {
          if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8) {
            break label135;
          }
          ((CommonHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).b();
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof ThemeHbFragment))
        {
          a("theme.pack.keyback", 2);
          a(-1);
          finish();
        }
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof QzoneHbFragment)) {
          ((QzoneHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
        }
        return true;
        label135:
        this.jdField_a_of_type_AndroidWidgetImageButton.performClick();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.SendHbActivity
 * JD-Core Version:    0.7.0.1
 */
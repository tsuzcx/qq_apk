package com.tencent.biz.pubaccount.readinjoy.viola.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.earlydownload.handler.ViolaBizLibHandler;
import com.tencent.mobileqq.earlydownload.handler.ViolaLibHandler;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.viola.core.ViolaSDKManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaUiDelegate
{
  public static String A = "content_full_screen";
  public static String B = "title_default_title_alpha";
  public static String C = "title_default_gray_float";
  public static String D = "title_default_is_channel";
  public static String E = "statusBarStyle=2";
  public static String F = "v_content_full=1";
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  private int jdField_a_of_type_Int = 0;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyChannelActivity.SerializableMap jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private ViolaUiDelegate.OnTitleChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaUiDelegate$OnTitleChangeListener;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private WebViewProgressBarController jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  static
  {
    jdField_a_of_type_JavaLangString = "title_name";
    jdField_b_of_type_JavaLangString = "title_hide";
    jdField_c_of_type_JavaLangString = "title_nav_background_color";
    jdField_d_of_type_JavaLangString = "title_nav_text_color";
    jdField_e_of_type_JavaLangString = "title_nav_center_text_color";
    jdField_f_of_type_JavaLangString = "title_nav_alpha";
    jdField_g_of_type_JavaLangString = "title_status_bar_color";
    jdField_h_of_type_JavaLangString = "title_status_color";
    jdField_i_of_type_JavaLangString = "title_status_font_color";
    jdField_j_of_type_JavaLangString = "title_status_immersive";
    jdField_k_of_type_JavaLangString = "title_full_screen";
    jdField_l_of_type_JavaLangString = "title_hide_nav_bar";
    jdField_m_of_type_JavaLangString = "title_suspension";
    n = "title_border_radius";
    o = "title_margin_top";
    p = "title_default_gray_bar";
    q = "title_default_pop_anim";
    r = "title_default_back_bar";
    s = "title_default_auto_top";
    t = "title_default_interrupt_back";
    u = "title_default_title_height";
    v = "bundle_is_splash_activity";
    w = "bundle_is_suspension_anyplace";
    x = "bundle_is_bid_anyplace";
    y = "title_content_color";
    z = "title_status_visiable";
  }
  
  public ViolaUiDelegate(Fragment paramFragment)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public ViolaUiDelegate(ViolaFragment paramViolaFragment)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = paramViolaFragment;
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity();
    }
    return this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity();
  }
  
  private TopGestureLayout a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return null;
    }
    int i1 = 0;
    while (i1 < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i1);
      if ((localView instanceof TopGestureLayout)) {
        return (TopGestureLayout)localView;
      }
      if ((localView instanceof ViewGroup)) {
        return a((ViewGroup)localView);
      }
      i1 += 1;
    }
    return null;
  }
  
  private static HashMap<String, Object> a(String paramString)
  {
    boolean bool2 = false;
    if (!TextUtils.isEmpty(paramString))
    {
      HashMap localHashMap = new HashMap();
      String str = jdField_b_of_type_JavaLangString;
      int i1;
      if (paramString.contains("hideNav=1"))
      {
        i1 = 1;
        localHashMap.put(str, Integer.valueOf(i1));
        localHashMap.put(jdField_h_of_type_JavaLangString, Boolean.valueOf(paramString.contains("statusColor=1")));
        if (!TextUtils.isEmpty(ViolaAccessHelper.a(paramString, "v_nav_bgclr"))) {
          localHashMap.put(jdField_c_of_type_JavaLangString, ViolaAccessHelper.a(paramString, "v_nav_bgclr"));
        }
        if (!TextUtils.isEmpty(ViolaAccessHelper.a(paramString, "v_nav_txtclr"))) {
          localHashMap.put(jdField_d_of_type_JavaLangString, ViolaAccessHelper.a(paramString, "v_nav_txtclr"));
        }
        if (!TextUtils.isEmpty(ViolaAccessHelper.a(paramString, "v_nav_titleclr"))) {
          localHashMap.put(jdField_e_of_type_JavaLangString, ViolaAccessHelper.a(paramString, "v_nav_titleclr"));
        }
        if (!TextUtils.isEmpty(ViolaAccessHelper.a(paramString, "v_nav_alpha"))) {
          localHashMap.put(jdField_f_of_type_JavaLangString, ViolaAccessHelper.a(paramString, "v_nav_alpha"));
        }
        localHashMap.put(jdField_i_of_type_JavaLangString, Boolean.valueOf(paramString.contains("statusBarStyle=1")));
        if (!TextUtils.isEmpty(ViolaAccessHelper.a(paramString, "statusBarColor"))) {
          localHashMap.put(jdField_g_of_type_JavaLangString, ViolaAccessHelper.a(paramString, "statusBarColor"));
        }
        localHashMap.put(jdField_j_of_type_JavaLangString, Boolean.valueOf(paramString.contains("v_nav_immer=1")));
        localHashMap.put(B, Boolean.valueOf(paramString.contains("v_present_title_alpha=1")));
        localHashMap.put(C, Boolean.valueOf(paramString.contains("v_present_gray_float=1")));
        localHashMap.put(jdField_k_of_type_JavaLangString, Boolean.valueOf(paramString.contains("v_full_screen=1")));
        localHashMap.put(jdField_l_of_type_JavaLangString, Boolean.valueOf(paramString.contains("v_hide_nav=1")));
        str = jdField_m_of_type_JavaLangString;
        if ((!paramString.contains("v_present=2")) && (!paramString.contains("v_present=1"))) {
          break label795;
        }
        bool1 = true;
        label352:
        localHashMap.put(str, Boolean.valueOf(bool1));
        localHashMap.put("title_trans_anim", Boolean.valueOf(paramString.contains("v_push_animated_disable=1")));
        localHashMap.put("error_view_white", Boolean.valueOf(paramString.contains("v_error_white=1")));
        if (!TextUtils.isEmpty(ViolaAccessHelper.a(paramString, "v_present_radius"))) {
          localHashMap.put(n, ViolaAccessHelper.a(paramString, "v_present_radius"));
        }
        if (!TextUtils.isEmpty(ViolaAccessHelper.a(paramString, "v_present_top"))) {
          localHashMap.put(o, ViolaAccessHelper.a(paramString, "v_present_top"));
        }
        if (!TextUtils.isEmpty(ViolaAccessHelper.a(paramString, "v_present_titleHeight"))) {
          localHashMap.put(u, ViolaAccessHelper.a(paramString, "v_present_titleHeight"));
        }
        localHashMap.put(v, Boolean.valueOf(paramString.contains("from_splash_activity=1")));
        localHashMap.put(w, Boolean.valueOf(paramString.contains("v_present=2")));
        localHashMap.put(x, Boolean.valueOf(paramString.contains("&v_bid_apply_anywhere=0")));
        str = p;
        if (paramString.contains("v_present_bar=0")) {
          break label800;
        }
        bool1 = true;
        label563:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = q;
        if (paramString.contains("v_present_pop=0")) {
          break label805;
        }
      }
      label795:
      label800:
      label805:
      for (boolean bool1 = true;; bool1 = false)
      {
        localHashMap.put(str, Boolean.valueOf(bool1));
        localHashMap.put(r, Boolean.valueOf(paramString.contains("v_present_back_bar=1")));
        str = s;
        bool1 = bool2;
        if (!paramString.contains("v_present_auto_top=0")) {
          bool1 = true;
        }
        localHashMap.put(str, Boolean.valueOf(bool1));
        localHashMap.put(t, Boolean.valueOf(paramString.contains("v_present_interrupt_back=1")));
        if (paramString.contains("v_bg_color")) {
          localHashMap.put(y, "#" + ViolaAccessHelper.a(paramString, "v_bg_color"));
        }
        if (paramString.contains(E)) {
          localHashMap.put(z, Boolean.valueOf(true));
        }
        if (paramString.contains(F)) {
          localHashMap.put(A, Boolean.valueOf(true));
        }
        if (paramString.contains("channelId")) {
          localHashMap.put(D, Boolean.valueOf(true));
        }
        return localHashMap;
        i1 = 0;
        break;
        bool1 = false;
        break label352;
        bool1 = false;
        break label563;
      }
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if (!ViolaBaseView.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      String str = "网络类型：" + HttpUtil.getNetWorkTypeByStr() + "，网速：" + BandwidthPredictor.a().a() + "kb/s\n已超时协议：\n" + BridgeModule.ssoTimeOutRecordStr;
      try
      {
        ((JSONObject)localObject).put("title", "网络状态");
        ((JSONObject)localObject).put("text", str);
        ((JSONObject)localObject).put("needOkBtn", true);
        ((JSONObject)localObject).put("needCancelBtn", true);
        ((JSONObject)localObject).put("okBtnText", "复制文本");
        ((JSONObject)localObject).put("cancelBtnText", "关闭");
        localObject = BridgeModuleHelper.a(null, (JSONObject)localObject, null);
        if (localObject == null) {
          continue;
        }
        ((QQCustomDialog)localObject).setPositiveButton("复制文本", new ViolaUiDelegate.3(paramContext, str));
        return;
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
  
  private void a(HashMap<String, Object> paramHashMap)
  {
    String str = (String)paramHashMap.get(jdField_g_of_type_JavaLangString);
    if (str.startsWith("0x")) {
      paramHashMap = str.replace("0x", "#");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setStatusBarColor(paramHashMap);
      return;
      paramHashMap = str;
      if (str.startsWith("0X")) {
        paramHashMap = str.replace("0X", "#");
      }
    }
  }
  
  private void b(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    if (paramHashMap.containsKey(jdField_m_of_type_JavaLangString)) {
      this.jdField_e_of_type_Boolean = ((Boolean)paramHashMap.get(jdField_m_of_type_JavaLangString)).booleanValue();
    }
    if (paramHashMap.containsKey("title_trans_anim")) {
      this.jdField_f_of_type_Boolean = ((Boolean)paramHashMap.get("title_trans_anim")).booleanValue();
    }
    if (paramHashMap.containsKey("error_view_white")) {
      this.jdField_g_of_type_Boolean = ((Boolean)paramHashMap.get("error_view_white")).booleanValue();
    }
    if (paramHashMap.containsKey(n)) {
      c(paramHashMap, paramViewGroup);
    }
    if (paramHashMap.containsKey(u))
    {
      int i1 = Integer.valueOf((String)paramHashMap.get(u)).intValue();
      this.jdField_a_of_type_JavaUtilHashMap.put(u, Integer.valueOf(i1));
    }
    if (paramHashMap.containsKey(o)) {
      d(paramHashMap, paramViewGroup);
    }
    if (paramHashMap.containsKey(p)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(p, paramHashMap.get(p));
    }
    if (paramHashMap.containsKey(q)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(q, paramHashMap.get(q));
    }
    if (paramHashMap.containsKey(r)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(r, paramHashMap.get(r));
    }
    if (paramHashMap.containsKey(jdField_j_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_j_of_type_JavaLangString, paramHashMap.get(jdField_j_of_type_JavaLangString));
    }
    if (paramHashMap.containsKey(s)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(s, paramHashMap.get(s));
    }
    if (paramHashMap.containsKey(t)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(t, paramHashMap.get(t));
    }
    if (paramHashMap.containsKey(y))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(y, paramHashMap.get(y));
      this.jdField_b_of_type_Int = Color.parseColor((String)paramHashMap.get(y));
    }
    if (paramHashMap.containsKey(B)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(B, paramHashMap.get(B));
    }
    if (paramHashMap.containsKey(C)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(C, paramHashMap.get(C));
    }
    if (paramHashMap.containsKey(v)) {
      this.jdField_i_of_type_Boolean = ((Boolean)paramHashMap.get(v)).booleanValue();
    }
    if (paramHashMap.containsKey(w)) {
      this.jdField_j_of_type_Boolean = ((Boolean)paramHashMap.get(w)).booleanValue();
    }
    if (paramHashMap.containsKey(x)) {
      this.jdField_k_of_type_Boolean = ((Boolean)paramHashMap.get(x)).booleanValue();
    }
    if (b()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setStatusBarFontColor(Boolean.valueOf(true));
    }
    if (paramHashMap.containsKey(y)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setContentViewColor((String)paramHashMap.get(y));
    }
    if (paramHashMap.containsKey(z)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.hideStatusBarByParams();
    }
    if ((paramHashMap.containsKey(A)) && (!paramHashMap.containsKey(D))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setContentFullScreen();
    }
  }
  
  private void c(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    int i1 = Integer.valueOf((String)paramHashMap.get(n)).intValue();
    this.jdField_a_of_type_JavaUtilHashMap.put(n, Integer.valueOf(i1));
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131374174));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void d(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      int i1 = Integer.valueOf((String)paramHashMap.get(o)).intValue();
      this.jdField_a_of_type_Int = AIOUtils.a(i1, paramViewGroup.getResources());
      this.jdField_a_of_type_JavaUtilHashMap.put(o, Integer.valueOf(i1));
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaUiDelegate$OnTitleChangeListener == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaUiDelegate$OnTitleChangeListener = new ViolaUiDelegate.1(this);
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private boolean f()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof ReadInJoyViolaChannelFragment)) {}
    while ((RIJXTabFrameUtils.a.a()) && (this.jdField_i_of_type_Boolean)) {
      return true;
    }
    return false;
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ViolaUiDelegate.OnTitleChangeListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaUiDelegate$OnTitleChangeListener;
  }
  
  public TopGestureLayout a()
  {
    Object localObject = null;
    if (a() == null) {
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)a().getWindow().getDecorView();
    int i1 = 0;
    for (;;)
    {
      if (i1 < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i1);
        localObject = localView;
        if ((localView instanceof DragFrameLayout)) {
          localObject = ((DragFrameLayout)localView).getChildAt(0);
        }
        if (!(localObject instanceof TopGestureLayout)) {}
      }
      else
      {
        if ((localObject == null) || (!(localObject instanceof TopGestureLayout))) {
          break;
        }
        return (TopGestureLayout)localObject;
      }
      i1 += 1;
    }
    return a(localViewGroup);
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((b()) || (d()))
      {
        f();
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() == 0));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      b(this.jdField_m_of_type_Boolean);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
  }
  
  public void a(Bundle paramBundle)
  {
    boolean bool2 = true;
    if (paramBundle != null)
    {
      if (paramBundle.getInt(jdField_b_of_type_JavaLangString, 0) != 1) {
        break label431;
      }
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.hideTitleBar();
      }
      if ((!this.jdField_b_of_type_Boolean) && (paramBundle.getBoolean("is_channel", false)))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.hideTitleBar();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap = ((ReadInJoyChannelActivity.SerializableMap)paramBundle.getSerializable(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap != null) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_b_of_type_JavaLangString)) {
          if (((Integer)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_b_of_type_JavaLangString)).intValue() != 1) {
            break label436;
          }
        }
      }
    }
    label431:
    label436:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.hideTitleBar();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_h_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = ((Boolean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_h_of_type_JavaLangString)).booleanValue();
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setStatusBarColor("#ffffff");
        }
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_c_of_type_JavaLangString))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setTitleContainerBackgroundColor(paramBundle);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_d_of_type_JavaLangString))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_d_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setLeftTextColor(paramBundle);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setRightTextColor(paramBundle);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_e_of_type_JavaLangString))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setCenterTextColor(paramBundle);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_f_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_f_of_type_JavaLangString) != null))
        {
          paramBundle = (Float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_f_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setTitleAlpha(paramBundle.floatValue());
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getUrl()), paramViewGroup);
  }
  
  public void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    a(paramViewGroup, paramOnClickListener, null);
  }
  
  public void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if ((!b()) && (!d()))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131381682));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131381683)).inflate();
      if (this.jdField_b_of_type_Int != -1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376550));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376549));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.getResources().getString(2131718345));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    if (paramOnLongClickListener != null) {
      this.jdField_a_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickListener);
    }
    if ((this.jdField_b_of_type_Int == -1) || (e())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839418));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup.getResources().getColor(2131166909));
      ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.a(10.0F, paramViewGroup.getResources());
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839623));
    }
  }
  
  public void a(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      b(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(paramOnGestureListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof ViolaUiDelegate.OnTitleChangeListener))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaUiDelegate$OnTitleChangeListener = ((ViolaUiDelegate.OnTitleChangeListener)paramObject);
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    Object localObject;
    boolean bool;
    if (paramHashMap != null)
    {
      if (paramHashMap.containsKey(jdField_j_of_type_JavaLangString))
      {
        this.jdField_d_of_type_Boolean = ((Boolean)paramHashMap.get(jdField_j_of_type_JavaLangString)).booleanValue();
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setStatusBarImmersive();
          if ((paramHashMap.containsKey(jdField_l_of_type_JavaLangString)) && (((Boolean)paramHashMap.get(jdField_l_of_type_JavaLangString)).booleanValue()))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
            ViolaFragment.hideNavBar(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity());
          }
        }
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        if (paramHashMap.containsKey(jdField_h_of_type_JavaLangString))
        {
          this.jdField_c_of_type_Boolean = ((Boolean)paramHashMap.get(jdField_h_of_type_JavaLangString)).booleanValue();
          if (this.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setStatusBarColor("#ffffff");
          }
        }
        if (paramHashMap.containsKey(jdField_g_of_type_JavaLangString)) {
          a(paramHashMap);
        }
      }
      if ((paramHashMap.containsKey(jdField_k_of_type_JavaLangString)) && (((Boolean)paramHashMap.get(jdField_k_of_type_JavaLangString)).booleanValue())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setFullScreen();
      }
      if (paramHashMap.containsKey(jdField_i_of_type_JavaLangString))
      {
        localObject = (Boolean)paramHashMap.get(jdField_i_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setStatusBarFontColor((Boolean)localObject);
      }
      if (paramHashMap.containsKey(jdField_b_of_type_JavaLangString))
      {
        if (((Integer)paramHashMap.get(jdField_b_of_type_JavaLangString)).intValue() != 1) {
          break label283;
        }
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label288;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.hideTitleBar();
    }
    for (;;)
    {
      e();
      b(paramHashMap, paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.useNightMode();
      return;
      label283:
      bool = false;
      break;
      label288:
      if (paramHashMap.containsKey(jdField_c_of_type_JavaLangString))
      {
        localObject = (String)paramHashMap.get(jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setTitleContainerBackgroundColor((String)localObject);
      }
      if (paramHashMap.containsKey(jdField_d_of_type_JavaLangString))
      {
        localObject = (String)paramHashMap.get(jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setLeftTextColor((String)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setRightTextColor((String)localObject);
      }
      if (paramHashMap.containsKey(jdField_e_of_type_JavaLangString))
      {
        localObject = (String)paramHashMap.get(jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setCenterTextColor((String)localObject);
      }
      if ((paramHashMap.containsKey(jdField_f_of_type_JavaLangString)) && (paramHashMap.get(jdField_f_of_type_JavaLangString) != null))
      {
        localObject = (String)paramHashMap.get(jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setTitleAlpha(Float.valueOf((String)localObject).floatValue());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setLeftButtonText(HardCodeUtil.a(2131716296), null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setReadInjoyTitleStyle();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((b()) || (d()))
      {
        g();
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() == 2));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)2);
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((b()) || (d()))
      {
        d(paramViewGroup);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = new WebViewProgressBar(paramViewGroup.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setId(2131373555);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(3.0F, paramViewGroup.getContext().getResources()));
      localLayoutParams.addRule(10, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setLayoutParams(localLayoutParams);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
    } while ((ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getUrl())) && (ViolaBizLibHandler.i()) && (ViolaLibHandler.i()));
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
    {
      this.jdField_m_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_e_of_type_Boolean) && ((f()) || (this.jdField_j_of_type_Boolean)) && (!this.jdField_k_of_type_Boolean);
  }
  
  public void c()
  {
    if ((b()) && (this.jdField_h_of_type_Boolean)) {
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaUiDelegate.2(this), 350L);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.setContentViewColor("white");
  }
  
  public void c(ViewGroup paramViewGroup)
  {
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131381682));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
      b(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return (this.jdField_l_of_type_Boolean) && (!this.jdField_k_of_type_Boolean);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean d()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean e()
  {
    return this.jdField_g_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate
 * JD-Core Version:    0.7.0.1
 */
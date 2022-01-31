import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class bbbt
  extends bbas
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, bemt
{
  public static final int[] a;
  public static long b;
  public int a;
  public long a;
  public Activity a;
  public bahv a;
  private bbbz jdField_a_of_type_Bbbz;
  public WebViewFragment a;
  public String a;
  public final ArrayList<String> a;
  private qno jdField_a_of_type_Qno;
  wis jdField_a_of_type_Wis = null;
  public xdt a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<nct> b;
  public boolean b;
  private int c;
  public String c;
  public boolean c;
  private int jdField_d_of_type_Int;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  public boolean e;
  public boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l = true;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 95, 100, 107, 115, 127 };
    jdField_b_of_type_Long = -1L;
  }
  
  public bbbt()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 4L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 1;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131654241, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131625730) });
    }
    if (paramInt == 3) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131654241, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131653622) });
    }
    if (paramInt == 10) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131654241, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131653617) });
    }
    if (paramInt == 12) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131654241, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131631000) });
    }
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131654241, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131654748) });
  }
  
  private void a(int paramInt, String paramString)
  {
    babr.a(this.jdField_a_of_type_AndroidAppActivity, a(paramInt), 2131626319, 2131654987, new bbbw(this, paramInt, paramString), new bbbx(this, paramInt, paramString)).show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
      this.jdField_a_of_type_Xdt.a(paramString1, 3, true);
    }
    for (;;)
    {
      awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
      if ((paramString2 != null) && (!"".equals(paramString2))) {
        ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, paramString2, paramString4, paramString3, AccountDetailActivity.a(paramString3), false);
      }
      bcad.a().a("", "", "", "1000", "103", "0", false);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.s))
      {
        this.jdField_a_of_type_Xdt.i();
        continue;
      }
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_Xdt.a != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("type", 2);
        label159:
        zva.b(this.jdField_a_of_type_Xdt.a, localJSONObject);
        this.jdField_a_of_type_Xdt.a(paramString1, 3, true);
      }
      catch (JSONException localJSONException)
      {
        break label159;
      }
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      b(paramString);
    }
    do
    {
      return;
      if (paramInt == 3)
      {
        e(paramString);
        return;
      }
      if (paramInt == 10)
      {
        d(paramString);
        return;
      }
    } while (paramInt != 12);
    c(paramString);
  }
  
  private void b(String paramString)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString);
    vvp.a(2, 2131625733);
    if ((this.i) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p))) {
      this.jdField_a_of_type_Xdt.e();
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
      this.jdField_a_of_type_Xdt.a(paramString, 8, false);
    }
    for (;;)
    {
      String str = this.jdField_e_of_type_JavaLangString;
      if (this.jdField_a_of_type_Bbat.a() != null) {
        str = this.jdField_a_of_type_Bbat.a().getUrl();
      }
      paramString = "";
      Object localObject = Uri.parse(str);
      try
      {
        localObject = ((Uri)localObject).getQueryParameter("article_id");
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      ndn.a(null, "", "0X800787A", "0X800787A", 0, 0, (String)localObject, str, "", "");
      rtr.a(1005, str, this.jdField_e_of_type_Int);
      return;
      this.jdField_a_of_type_Xdt.a(paramString, 8, false);
    }
  }
  
  private void d(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
      this.jdField_a_of_type_Xdt.a(paramString, 4, true);
    }
    for (;;)
    {
      awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      bcad.a().a("", "", "", "1000", "104", "0", false);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.t))
      {
        this.jdField_a_of_type_Xdt.j();
        continue;
      }
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_Xdt.a != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("type", 3);
        label120:
        zva.b(this.jdField_a_of_type_Xdt.a, localJSONObject);
        this.jdField_a_of_type_Xdt.a(paramString, 4, true);
      }
      catch (JSONException localJSONException)
      {
        break label120;
      }
    }
  }
  
  private void e()
  {
    if (a(this.jdField_a_of_type_Xdt.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "is not need load share js..");
      }
    }
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "loadShareJs");
      }
      a(System.currentTimeMillis());
      int n = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int m = n;
      if (n < 0) {
        m = 190;
      }
      str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(m), Integer.valueOf(m) });
    } while (this.jdField_a_of_type_Bbat.a() == null);
    this.jdField_a_of_type_Bbat.a().loadUrl("javascript:" + str + ";");
  }
  
  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
      this.jdField_a_of_type_Xdt.a(paramString, 2, false);
    }
    for (;;)
    {
      bcad.a().a("", "", "", "1000", "102", "0", false);
      awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.r))
      {
        this.jdField_a_of_type_Xdt.h();
        continue;
      }
      if (this.jdField_a_of_type_Xdt.a != null) {
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("type", 1);
        label120:
        zva.b(this.jdField_a_of_type_Xdt.a, paramString);
        this.jdField_a_of_type_Xdt.a();
      }
      catch (JSONException localJSONException)
      {
        break label120;
      }
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Xdt == null) {
      return "";
    }
    return this.jdField_a_of_type_Xdt.a();
  }
  
  public wis a()
  {
    if (this.jdField_a_of_type_Wis == null)
    {
      this.jdField_a_of_type_Wis = wis.a();
      this.jdField_a_of_type_Wis.a();
    }
    return this.jdField_a_of_type_Wis;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a();
    }
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("url");
    if (this.jdField_e_of_type_JavaLangString == null)
    {
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.jdField_e_of_type_JavaLangString == null) {
        this.jdField_e_of_type_JavaLangString = "";
      }
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("uin_type");
      this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("puin");
      this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("msg_id");
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = "";
      }
      this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("source_puin");
      if (this.jdField_c_of_type_JavaLangString == null) {
        this.jdField_c_of_type_JavaLangString = "";
      }
      this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("friendUin");
      if (this.jdField_d_of_type_JavaLangString == null) {
        this.jdField_d_of_type_JavaLangString = "";
      }
      ((Bundle)localObject).getBoolean("isOpeningQunApp");
      this.jdField_c_of_type_Int = ((Bundle)localObject).getInt("appid");
      this.jdField_d_of_type_Int = ((Bundle)localObject).getInt("troopid");
      if (((Bundle)localObject).getString("extraParams") == null) {}
      this.jdField_e_of_type_Int = ((Bundle)localObject).getInt("articalChannelId", 100);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = a();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_e_of_type_JavaLangString;
    }
    localObject1 = "";
    Object localObject3 = Uri.parse((String)localObject2);
    if ((!"article.mp.qq.com".equalsIgnoreCase(((Uri)localObject3).getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(((Uri)localObject3).getHost()))) {
      return;
    }
    try
    {
      localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1001", "");
      return;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      return;
    case 1: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, (String)localObject3, (String)localObject2, "1011", "");
      return;
    case 2: 
    case 3: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1002", "");
      return;
    case 9: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1003", "");
      return;
    case 10: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1004", "");
      return;
    case 5: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1005", "");
      return;
    case 4: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1006", "");
      return;
    case 6: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1007", "");
      return;
    case 11: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1008", "");
      return;
    case 8: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
      return;
    case 7: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1010", "");
      return;
    case 12: 
      awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1012", "");
      return;
    }
    awqx.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1013", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    c(paramInt2);
    a().a(this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_d_of_type_Boolean = true;
        if (this.jdField_a_of_type_Qno != null) {
          this.jdField_a_of_type_Qno.a();
        }
        if (this.jdField_a_of_type_Wis != null) {
          this.jdField_a_of_type_Wis.b();
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      } while ((paramBundle == null) || (paramBundle.getInt("state_machine_step", -1) != 1));
      d();
      return;
      if (this.jdField_a_of_type_Bahv != null) {
        this.jdField_a_of_type_Bahv.f();
      }
    } while ((this.jdField_a_of_type_Qno == null) || (!this.jdField_a_of_type_Qno.a()));
    this.jdField_a_of_type_Qno.b();
    c();
  }
  
  @TargetApi(12)
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    String str7 = "";
    String str6;
    String str5;
    String str4;
    String str3;
    String str2;
    int n;
    int m;
    if (paramBundle != null)
    {
      str6 = paramBundle.getString("qq", "");
      str5 = paramBundle.getString("public_uin", "");
      str4 = paramBundle.getString("source_public_uin", "");
      str3 = paramBundle.getString("default_url", "");
      str2 = paramBundle.getString("msg_id", "");
      n = paramBundle.getInt("troop_app_id", 0);
      m = paramBundle.getInt("troop_id", 0);
      str7 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
    }
    for (;;)
    {
      Object localObject1 = this.jdField_e_of_type_JavaLangString;
      Object localObject2;
      Object localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_e_of_type_JavaLangString;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView();
        localObject1 = localObject2;
        if (localObject3 == null) {}
      }
      for (localObject1 = ((WebView)localObject3).getOriginalUrl();; localObject1 = null)
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(paramString))) {}
        for (;;)
        {
          try
          {
            localObject3 = Uri.parse((String)localObject1);
            String str9 = ((Uri)localObject3).getHost();
            String str8 = null;
            if (((Uri)localObject3).isHierarchical()) {
              str8 = ((Uri)localObject3).getQueryParameter("_pflag");
            }
            localObject3 = paramString;
            if (!TextUtils.isEmpty(str8)) {
              if (!"post.mp.qq.com".equalsIgnoreCase(str9))
              {
                localObject3 = paramString;
                if (!"url.cn".equalsIgnoreCase(str9)) {}
              }
              else
              {
                int i1 = Integer.parseInt(str8);
                localObject3 = paramString;
                if ((i1 >> 3 & 0x1) == 1) {
                  localObject3 = localObject1;
                }
              }
            }
            paramString = (String)localObject3;
          }
          catch (Exception localException)
          {
            continue;
            b(paramString);
            continue;
            if (paramInt != 11) {
              continue;
            }
            paramBundle = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(paramString);
            m = 0;
            if (!paramBundle.matches()) {
              continue;
            }
            m = 1;
            try
            {
              paramString = URLEncoder.encode(paramString, "UTF-8");
              if (m != 0)
              {
                localObject2 = String.valueOf(NetConnInfoCenter.getServerTime());
                localObject1 = bcdu.b(paramString + 200 + (String)localObject2 + "jubao@article@123");
                paramBundle = (Bundle)localObject1;
                if (localObject1 != null)
                {
                  paramBundle = (Bundle)localObject1;
                  if (!((String)localObject1).isEmpty()) {
                    paramBundle = ((String)localObject1).toLowerCase();
                  }
                }
                paramString = "https://post.mp.qq.com/jubao/index?qq=" + str6 + "&mp_uin=" + str5 + "&scene=200&sub_appname=article_webview&timestamp=" + (String)localObject2 + "&sign=" + paramBundle + "&article_url=" + paramString + "&_wv=3";
                paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                paramBundle.putExtra("url", paramString);
                paramBundle.putExtra("hide_more_button", true);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
                awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
                if ((str4 == null) || ("".equals(str4))) {
                  continue;
                }
                ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, str4, str2, str3, AccountDetailActivity.a(str3), false);
              }
            }
            catch (UnsupportedEncodingException paramString)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
              }
              paramString = null;
              continue;
              paramString = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + paramString + "&qq=" + str6 + "&_wv=7";
              continue;
            }
            if (paramInt != 2) {
              continue;
            }
            if (this.jdField_a_of_type_Bbbz == null) {
              continue;
            }
            this.jdField_a_of_type_Bbbz.a(paramString);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
              continue;
            }
            throw new InvalidParameterException("ACTION_REFRESH_FREIEND_VIEW should be handled by QQBrowserActivity!");
            paramBundle = (bbca)this.jdField_a_of_type_Bbat.a().a(-2);
            if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())) || (paramBundle == null)) {
              continue;
            }
            String str1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
            if ((TextUtils.isEmpty(paramBundle.jdField_d_of_type_JavaLangString)) || ((!paramBundle.jdField_d_of_type_JavaLangString.equals(str1)) && (!paramBundle.jdField_d_of_type_JavaLangString.equals(paramString)))) {
              continue;
            }
            boolean bool = true;
            this.jdField_a_of_type_Xdt.g = bool;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "ShareArkFromH5 mShare.isShareArk=", Boolean.valueOf(this.jdField_a_of_type_Xdt.g), ",\n shareUrl=", mpw.b(paramString, new String[0]) });
            a(paramString, (String)localObject2, (String)localObject1);
            continue;
            if (paramInt != 4) {
              continue;
            }
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
            paramBundle.putExtra("normal", true);
            paramBundle.putExtra("big_brother_source_key", "biz_src_jc_ac");
            localObject1 = new WeakReference(this.jdField_a_of_type_AndroidAppActivity);
            try
            {
              JefsClass.getInstance().a(this.jdField_a_of_type_AndroidAppActivity, paramBundle, paramString, new SwiftBrowserShareMenuHandler.1(this, (WeakReference)localObject1, paramBundle));
              awqx.b(null, "P_CliOper", "VIPCOMIC", "", "0X800619F", "0X800619F", 1000, 0, mpw.b(str3, new String[0]), null, null, null);
              awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
              if ((str4 == null) || ("".equals(str4))) {
                continue;
              }
              ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1006, 0, str4, str2, str3, AccountDetailActivity.a(str3), false);
            }
            catch (Throwable paramString)
            {
              QLog.e("SwiftBrowserShareMenuHandler", 1, paramString, new Object[0]);
              continue;
            }
            if (paramInt != 5) {
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) {
              continue;
            }
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            paramBundle = new HashMap();
            paramBundle.put("KEY_PID", String.valueOf(50079));
            paramBundle.put("KEY_EUSESTAT", String.valueOf(5));
            paramBundle.put("ChannelID", BaseApplicationImpl.getContext().getApplicationInfo().processName);
            paramBundle.put("PosID", Integer.toString(0));
            paramString = MttLoader.getValidQBUrl(BaseApplicationImpl.getContext(), paramString);
            m = MttLoader.loadUrl(BaseApplicationImpl.getContext(), paramString, paramBundle, null);
            if ((4 != m) && (5 != m) && (m == 0)) {
              continue;
            }
            paramString = (bbce)this.jdField_a_of_type_Bbat.a().a(16);
            if (paramString == null) {
              continue;
            }
            paramString.a("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10367", true);
            awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
            awqx.b(null, "P_CliOper", "VIPCOMIC", "", "0X80061A0", "0X80061A0", 1000, 0, mpw.b(str3, new String[0]), null, null, null);
            if ((str4 == null) || ("".equals(str4))) {
              continue;
            }
            ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1005, 0, str4, str2, str3, AccountDetailActivity.a(str3), false);
            continue;
            throw new InvalidParameterException("ACTION_OPEN_IN_QQ_BROWSER should be handled by QQBrowserActivity!");
            if (paramInt != 3) {
              continue;
            }
            jdField_b_of_type_Long = System.currentTimeMillis();
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            rtr.a(1002, (String)localObject1, this.jdField_e_of_type_Int);
            if ((this.jdField_a_of_type_Xdt.a() == null) || (this.jdField_a_of_type_Xdt.a().jdField_a_of_type_Int != 0)) {
              continue;
            }
            a(paramInt, paramString);
            continue;
            e(paramString);
            continue;
            if (paramInt != 6) {
              continue;
            }
            if (!this.jdField_a_of_type_Xdt.a(paramString)) {
              continue;
            }
            this.jdField_a_of_type_Xdt.a(paramString, 9, false);
            if ((str4 == null) || ("".equals(str4))) {
              continue;
            }
            ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, str4, str2, str3, AccountDetailActivity.a(str3), false);
            continue;
            if ((paramInt != 9) && (paramInt != 10)) {
              continue;
            }
            m = -1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            if (paramInt != 9) {
              continue;
            }
            rtr.a(1003, (String)localObject1, this.jdField_e_of_type_Int);
            if (WXShareHelper.a().a()) {
              continue;
            }
            m = 2131655008;
            if (m == -1) {
              continue;
            }
            vvp.a(0, m);
            continue;
            rtr.a(1004, (String)localObject1, this.jdField_e_of_type_Int);
            continue;
            if (WXShareHelper.a().b()) {
              continue;
            }
            m = 2131655009;
            continue;
            if (paramInt != 9) {
              continue;
            }
            if (this.jdField_a_of_type_Xdt.a() == null) {
              continue;
            }
            this.jdField_a_of_type_Xdt.a().show();
            ThreadManager.excute(new SwiftBrowserShareMenuHandler.2(this, paramString, str4, str3, str2), 128, null, false);
            continue;
            a(paramString, str4, str3, str2);
            continue;
            if ((this.jdField_a_of_type_Xdt.a() == null) || (this.jdField_a_of_type_Xdt.a().jdField_a_of_type_Int != 0)) {
              continue;
            }
            a(paramInt, paramString);
            continue;
            d(paramString);
            continue;
            if (paramInt != 13) {
              continue;
            }
            this.jdField_a_of_type_Xdt.a(paramString, 5, true);
            continue;
            if (paramInt != 15) {
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
              continue;
            }
            throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
            if (badq.d(BaseApplicationImpl.getContext())) {
              continue;
            }
            bbmy.a(BaseApplicationImpl.getContext(), 2, 2131654501, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
            return;
            a().a(n, new bbbu(this));
            awqx.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, "" + m, "" + n, "", "");
            continue;
            if (paramInt != 16) {
              continue;
            }
            paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            paramString.putExtra("url", str7);
            paramString.putExtra("hide_operation_bar", true);
            paramString.putExtra("hide_more_button", true);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
            awqx.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, "" + m, "" + n, "", "");
            continue;
            if (paramInt != 17) {
              continue;
            }
            paramString = "";
            if (paramBundle == null) {
              continue;
            }
            paramString = paramBundle.getString("troop_app_share_url", "");
            paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            paramBundle.putExtra("url", paramString);
            paramBundle.putExtra("hide_operation_bar", true);
            paramBundle.putExtra("hide_more_button", true);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
            awqx.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, "" + m, "" + n, "", "");
            continue;
            if (paramInt != 18) {
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
              continue;
            }
            throw new InvalidParameterException("ACTION_REFRESH_TROOP_APP_VIEW should be handled by QQBrowserActivity!");
            paramString = (bbca)this.jdField_a_of_type_Bbat.a().a(-2);
            if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())) || (paramString == null)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bbca.h = false;
            paramString.q = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.reload();
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnCustomScrollChangeListener(null);
            paramString.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 1, 0, 0, 0, 0, null);
            awqx.b(null, "P_CliOper", "Grp_open", "", "third_app", "refresh_menu", 0, 1, 0, "" + m, "" + n, "", "");
            continue;
            paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b();
            if ((TextUtils.isEmpty(paramBundle)) || (paramString == null)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bbca.h = false;
            paramString.q = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramBundle);
            paramString.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView, paramBundle, 1, 0, 0, 0, 0, null);
            continue;
            if (paramInt != 7) {
              continue;
            }
            c();
            continue;
            if ((paramInt != 19) && (paramInt != 20)) {
              continue;
            }
            if (paramInt != 19) {
              continue;
            }
            m = 6;
            if (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
              continue;
            }
            this.jdField_a_of_type_Xdt.a(paramString, m, false);
            continue;
            m = 7;
            continue;
            this.jdField_a_of_type_Xdt.a(paramString, m, true);
            continue;
            if (paramInt != 21) {
              continue;
            }
            paramString = (bbbo)this.jdField_a_of_type_Bbat.a().a(64);
            if (paramString == null) {
              continue;
            }
            paramString.a(null, null, 2);
            paramString = "";
            paramBundle = Uri.parse(this.jdField_e_of_type_JavaLangString);
            try
            {
              paramBundle = paramBundle.getQueryParameter("article_id");
              paramString = paramBundle;
            }
            catch (Exception paramBundle)
            {
              paramBundle.printStackTrace();
              continue;
            }
            paramBundle = paramString;
            if (paramString != null) {
              continue;
            }
            paramBundle = "";
            ndn.a(null, "", "0X8007071", "0X8007071", 0, 0, paramBundle, "", "", "");
            ndn.a("0X8007071", "", paramBundle, "", "", "");
            continue;
            if (paramInt != 12) {
              continue;
            }
            if ((this.jdField_a_of_type_Xdt.a() == null) || (this.jdField_a_of_type_Xdt.a().jdField_a_of_type_Int != 0)) {
              continue;
            }
            a(paramInt, paramString);
            continue;
            c(paramString);
            continue;
            if (paramInt != 34) {
              continue;
            }
            if (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
              continue;
            }
            this.jdField_a_of_type_Xdt.d();
            continue;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("diandian", 2, "dian dian is here");
            continue;
            if (paramInt != 35) {
              continue;
            }
            long l2 = 0L;
            paramBundle = null;
            long l1 = l2;
            paramString = paramBundle;
            if (this.jdField_b_of_type_JavaUtilArrayList == null) {
              continue;
            }
            localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            l1 = l2;
            paramString = paramBundle;
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            paramString = (nct)((Iterator)localObject1).next();
            if (paramString.jdField_a_of_type_Int != 3) {
              continue;
            }
            try
            {
              paramString = new JSONObject(paramString.jdField_b_of_type_JavaLangString);
              l1 = paramString.getLong("uin");
              paramString = paramString.optString("name");
              paramString = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, l1 + "", null, 3096, 1, paramString, null, null, null, null);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
              ndn.a(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
            }
            catch (JSONException paramString)
            {
              paramString.printStackTrace();
              return;
            }
            if (paramInt != 30) {
              continue;
            }
            if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (!this.jdField_e_of_type_Boolean)) {
              continue;
            }
            paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            if (!paramString.hasNext()) {
              continue;
            }
            paramBundle = (nct)paramString.next();
            if (paramBundle.jdField_a_of_type_Int != 1) {
              continue;
            }
            try
            {
              l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
              paramString = new Intent();
              paramBundle = new Bundle();
              paramString.setComponent(new ComponentName(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class));
              paramBundle.putString("uin", String.valueOf(l1));
              paramBundle.putInt("uintype", 1008);
              paramString.putExtras(paramBundle);
              paramString.putExtra("is_come_from_readinjoy", true);
              paramString.setFlags(67108864);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
              ndn.a(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
            }
            catch (JSONException paramString)
            {
              paramString.printStackTrace();
              return;
            }
            if ((paramInt != 37) || (!this.f)) {
              continue;
            }
            if (this.jdField_b_of_type_JavaUtilArrayList == null) {
              continue;
            }
            paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            if (!paramString.hasNext()) {
              continue;
            }
            paramBundle = (nct)paramString.next();
            if (paramBundle.jdField_a_of_type_Int != 1) {
              continue;
            }
            try
            {
              l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
              paramString = aciy.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
              paramString.putExtra("uin", l1 + "");
              paramString.putExtra("uintype", 0);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
              ndn.a(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
              return;
            }
            catch (JSONException paramString)
            {
              paramString.printStackTrace();
              return;
            }
            if (paramInt != 31) {
              continue;
            }
            if (this.jdField_b_of_type_JavaUtilArrayList == null) {
              continue;
            }
            paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            if (!paramString.hasNext()) {
              continue;
            }
            paramBundle = (nct)paramString.next();
            if (paramBundle.jdField_a_of_type_Int != 2) {
              continue;
            }
            try
            {
              l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("puin");
              paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
              paramString.putExtra("uin", l1 + "");
              paramString.putExtra("from_js", true);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
              ndn.a(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
            }
            catch (JSONException paramString)
            {
              paramString.printStackTrace();
              return;
            }
            if (paramInt != 38) {
              continue;
            }
            this.jdField_a_of_type_Xdt.f();
            continue;
            if (paramInt != 68) {
              continue;
            }
            if (!(this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser)) {
              continue;
            }
            m = 0;
            axea.a(1, m);
            paramBundle = a();
            paramString = paramBundle;
            if (paramBundle != null) {
              continue;
            }
            paramString = this.jdField_e_of_type_JavaLangString;
            if (this.jdField_a_of_type_Xdt != null) {
              continue;
            }
            paramBundle = "";
            axea.a(paramString, paramBundle);
            continue;
            m = 1;
            continue;
            paramBundle = this.jdField_a_of_type_Xdt.b();
            continue;
            if (paramInt != 70) {
              continue;
            }
            paramString = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).a();
            if (paramString == null) {
              continue;
            }
            if (paramString.c()) {
              continue;
            }
            if (!paramString.b()) {
              continue;
            }
            paramString.e();
            this.jdField_a_of_type_AndroidAppActivity.finish();
            continue;
            paramString.i();
            continue;
            paramString.f();
            continue;
            if (paramInt != 71) {
              continue;
            }
            awqx.b(null, "dc00898", "", "", "0X800A9A4", "0X800A9A4", 0, 0, "1", "", "", "");
            azyy.a(this.jdField_a_of_type_Bbat.a(), new bbbv(this));
            continue;
            l1 = 0L;
            continue;
            l1 = 0L;
            continue;
            l1 = 0L;
            continue;
            localObject1 = localObject2;
            continue;
            localObject1 = localObject2;
            continue;
            bool = false;
            continue;
          }
          if (paramInt == 1) {
            if ((this.jdField_a_of_type_Xdt.a() != null) && (this.jdField_a_of_type_Xdt.a().jdField_a_of_type_Int == 0))
            {
              a(paramInt, paramString);
              a(paramInt);
              return;
            }
          }
        }
        localObject2 = localObject1;
      }
      m = 0;
      n = 0;
      str2 = "";
      str3 = "";
      str4 = "";
      str5 = "";
      str6 = "";
    }
  }
  
  public void a(long paramLong)
  {
    ((bbca)this.jdField_a_of_type_Bbat.a().a(-2)).jdField_a_of_type_Long = paramLong;
  }
  
  public void a(bbbz parambbbz)
  {
    this.jdField_a_of_type_Bbbz = parambbbz;
  }
  
  public void a(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      rtr.a(1001, paramString3, this.jdField_e_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
        this.jdField_a_of_type_Xdt.a(paramString1, 1, false);
      }
      for (;;)
      {
        bcad.a().a("", "", "", "1000", "101", "0", false);
        awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
        return;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.q))
        {
          this.jdField_a_of_type_Xdt.g();
        }
        else
        {
          if (this.jdField_a_of_type_Xdt.a != null) {
            paramString2 = new JSONObject();
          }
          try
          {
            paramString2.put("type", 0);
            label138:
            zva.b(this.jdField_a_of_type_Xdt.a, paramString2);
            this.jdField_a_of_type_Xdt.a(paramString1, 1, false);
          }
          catch (JSONException paramString3)
          {
            break label138;
          }
        }
      }
      paramString3 = paramString2;
    }
  }
  
  public void a(xdt paramxdt, long paramLong)
  {
    if (paramxdt == null) {}
    label283:
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
        {
          Object localObject1 = this.jdField_e_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_e_of_type_JavaLangString;
          }
          rtr.a((String)localObject1);
          this.jdField_a_of_type_Xdt = paramxdt;
          this.jdField_a_of_type_Long = paramLong;
          a();
          e();
          a();
          if (this.jdField_a_of_type_Bahv == null) {
            this.jdField_a_of_type_Bahv = new bahv(this.jdField_a_of_type_AndroidAppActivity);
          }
          paramxdt = null;
          localObject1 = (bbbo)this.jdField_a_of_type_Bbat.a().a(64);
          if (localObject1 != null) {
            paramxdt = ((bbbo)localObject1).a();
          }
          localObject1 = (bbca)this.jdField_a_of_type_Bbat.a().a(-2);
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (localObject1 != null))
          {
            if (((bbca)localObject1).m)
            {
              paramxdt = "<font color='#777777'>应用由 </font><font color='#00a5e0'>" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.o + "</font><font color='#777777'> 提供</font>";
              this.jdField_a_of_type_Bahv.a(Html.fromHtml(paramxdt));
              awqx.b(null, "P_CliOper", "Grp_open", "", "third_app", "exp_menu", 0, 1, 0, "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_Int, "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.i, "", "");
            }
          }
          else
          {
            this.jdField_a_of_type_Bahv.a(a());
            this.jdField_a_of_type_Bahv.a(this);
            this.jdField_a_of_type_Bahv.a(this);
          }
          try
          {
            this.jdField_a_of_type_Bahv.a();
            Object localObject2;
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_Int == 1008))
            {
              paramxdt = a();
              localObject1 = paramxdt;
              if (paramxdt == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_JavaLangString;
              }
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_JavaLangString))
              {
                paramxdt = "";
                localObject2 = Uri.parse((String)localObject1);
              }
            }
            else
            {
              try
              {
                localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
                paramxdt = (xdt)localObject2;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                }
              }
              localObject2 = paramxdt;
              if (paramxdt == null) {
                localObject2 = "";
              }
              ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005F78", "0X8005F78", 0, 0, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.k, (String)localObject2, false);
              if (this.f)
              {
                ndn.a(null, "", "0X8008CAA", "0X8008CAA", 0, 0, "", "", "", "", false);
                return;
                if (!TextUtils.isEmpty(paramxdt))
                {
                  this.jdField_a_of_type_Bahv.a(paramxdt);
                  break label283;
                }
                this.jdField_a_of_type_Bahv.a(BaseApplicationImpl.getApplication().getString(2131653614));
              }
            }
          }
          catch (Exception paramxdt)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "actionSheet.show exception=" + paramxdt);
              }
            }
          }
        }
      }
    } while (!this.jdField_e_of_type_Boolean);
    ndn.a(null, "", "0X8008CAB", "0X8008CAB", 0, 0, "", "", "", "", false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (((bbcj)this.jdField_a_of_type_Bbat.a().a(2)).a.jdField_e_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_Bbat.a() != null)
    {
      this.jdField_a_of_type_Bbat.a();
      int m = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if ((m > 0) && (m < 36201))
      {
        this.jdField_a_of_type_Boolean = false;
        return this.jdField_a_of_type_Boolean;
      }
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return this.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_Xdt.a();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.b()))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.c()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(mpw.a(paramString, new String[0]))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public List<bahx>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = (bbca)this.jdField_a_of_type_Bbat.a().a(-2);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (localObject1 != null) && (((bbca)localObject1).m))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631784);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842974;
      ((bahx)localObject1).jdField_c_of_type_Int = 15;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631787);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842976;
      ((bahx)localObject1).jdField_c_of_type_Int = 16;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631790);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842979;
      ((bahx)localObject1).jdField_c_of_type_Int = 17;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631789);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842978;
      ((bahx)localObject1).jdField_c_of_type_Int = 18;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
      return (List[])new ArrayList[] { localArrayList1 };
    }
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {}
    for (localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (this.h) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630988);
        ((bahx)localObject2).jdField_b_of_type_Int = 2130842035;
        ((bahx)localObject2).jdField_b_of_type_Boolean = true;
        ((bahx)localObject2).jdField_c_of_type_Int = 34;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630983);
        ((bahx)localObject2).jdField_b_of_type_Int = 2130838732;
        ((bahx)localObject2).jdField_b_of_type_Boolean = true;
        ((bahx)localObject2).jdField_c_of_type_Int = 2;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630996);
        ((bahx)localObject2).jdField_b_of_type_Int = 2130838733;
        ((bahx)localObject2).jdField_b_of_type_Boolean = true;
        ((bahx)localObject2).jdField_c_of_type_Int = 3;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (bgmq.a()) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:kandian")) && (localObject1 != null))
      {
        localObject2 = "readinjoy_" + ((AppRuntime)localObject1).getAccount() + "_" + 1;
        localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
        if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false)))
        {
          localObject2 = new bahx();
          ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630997);
          ((bahx)localObject2).jdField_b_of_type_Int = 2130838731;
          ((bahx)localObject2).jdField_b_of_type_Boolean = true;
          ((bahx)localObject2).jdField_c_of_type_Int = 13;
          ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
          localArrayList1.add(localObject2);
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631003);
        ((bahx)localObject2).jdField_b_of_type_Int = 2130838736;
        ((bahx)localObject2).jdField_c_of_type_Int = 9;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630986);
        ((bahx)localObject2).jdField_b_of_type_Int = 2130838730;
        ((bahx)localObject2).jdField_c_of_type_Int = 10;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      if ((this.g) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631000);
        ((bahx)localObject2).jdField_b_of_type_Boolean = true;
        ((bahx)localObject2).jdField_b_of_type_Int = 2130838735;
        ((bahx)localObject2).jdField_c_of_type_Int = 12;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630979);
        ((bahx)localObject2).jdField_b_of_type_Int = 2130842038;
        ((bahx)localObject2).jdField_c_of_type_Int = 5;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630980);
        ((bahx)localObject2).jdField_b_of_type_Boolean = true;
        ((bahx)localObject2).jdField_b_of_type_Int = 2130842034;
        ((bahx)localObject2).jdField_c_of_type_Int = 4;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      Object localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
      if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
        bcpn.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList1);
      }
      if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630994);
        ((bahx)localObject2).jdField_b_of_type_Boolean = true;
        ((bahx)localObject2).jdField_b_of_type_Int = 2130843511;
        ((bahx)localObject2).jdField_c_of_type_Int = 20;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject2);
      }
      ArrayList localArrayList2 = new ArrayList();
      Object localObject3;
      int m;
      if (this.k)
      {
        localObject3 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
        localObject2 = ((QQBrowserActivity)localObject3).getOriginalUrl();
        localObject3 = ((QQBrowserActivity)localObject3).a();
        if ((localObject3 != null) && (((alrv)localObject3).a()) && (((alrv)localObject3).e()) && (!alsr.c((String)localObject2)))
        {
          boolean bool = ((alrv)localObject3).c();
          localObject2 = new bahx();
          localObject3 = BaseApplicationImpl.getApplication();
          if (bool) {
            break label1607;
          }
          m = 2131625288;
          ((bahx)localObject2).jdField_a_of_type_JavaLangString = ((BaseApplicationImpl)localObject3).getString(m);
          if (bool) {
            break label1614;
          }
          m = 2130841707;
          label1423:
          ((bahx)localObject2).jdField_b_of_type_Int = m;
          ((bahx)localObject2).jdField_b_of_type_Boolean = true;
          ((bahx)localObject2).jdField_c_of_type_Int = 70;
          ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
          localArrayList2.add(localObject2);
        }
      }
      label1480:
      bahx localbahx;
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1696;
          }
          localObject3 = (nct)((Iterator)localObject2).next();
          localbahx = new bahx();
          switch (((nct)localObject3).jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nct)localObject3).jdField_a_of_type_JavaLangString)) {}
            for (localbahx.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131629864);; localbahx.jdField_a_of_type_JavaLangString = ((nct)localObject3).jdField_a_of_type_JavaLangString)
            {
              localbahx.jdField_b_of_type_Int = 2130842040;
              localbahx.jdField_b_of_type_Boolean = true;
              localbahx.jdField_c_of_type_Int = 30;
              localbahx.jdField_b_of_type_JavaLangString = "";
              localArrayList2.add(localbahx);
              break label1480;
              m = 2131625291;
              break;
              m = 2130841709;
              break label1423;
            }
          case 2: 
            label1607:
            label1614:
            localObject3 = new bahx();
            ((bahx)localObject3).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131629925);
            ((bahx)localObject3).jdField_b_of_type_Int = 2130842032;
            ((bahx)localObject3).jdField_b_of_type_Boolean = true;
            ((bahx)localObject3).jdField_c_of_type_Int = 31;
            ((bahx)localObject3).jdField_b_of_type_JavaLangString = "";
            localArrayList2.add(localObject3);
          }
        }
      }
      label1696:
      if ((this.f) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (nct)((Iterator)localObject2).next();
          localbahx = new bahx();
          switch (((nct)localObject3).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nct)localObject3).jdField_a_of_type_JavaLangString)) {}
            for (localbahx.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131629864);; localbahx.jdField_a_of_type_JavaLangString = ((nct)localObject3).jdField_a_of_type_JavaLangString)
            {
              localbahx.jdField_b_of_type_Int = 2130842040;
              localbahx.jdField_b_of_type_Boolean = true;
              localbahx.jdField_c_of_type_Int = 37;
              localbahx.jdField_b_of_type_JavaLangString = "";
              localArrayList2.add(localbahx);
              break;
            }
          case 3: 
            localObject3 = new bahx();
            ((bahx)localObject3).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630984);
            ((bahx)localObject3).jdField_b_of_type_Int = 2130842041;
            ((bahx)localObject3).jdField_b_of_type_Boolean = true;
            ((bahx)localObject3).jdField_c_of_type_Int = 35;
            ((bahx)localObject3).jdField_b_of_type_JavaLangString = "";
            localArrayList2.add(localObject3);
          }
        }
      }
      localObject2 = (bbbo)this.jdField_a_of_type_Bbat.a().a(64);
      if ((localObject2 != null) && (((bbbo)localObject2).a()) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631007);
        ((bahx)localObject2).jdField_b_of_type_Boolean = true;
        ((bahx)localObject2).jdField_b_of_type_Int = 2130842039;
        ((bahx)localObject2).jdField_c_of_type_Int = 21;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
      {
        localObject2 = new bahx();
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630969);
        ((bahx)localObject2).jdField_b_of_type_Boolean = true;
        ((bahx)localObject2).jdField_b_of_type_Int = 2130843306;
        ((bahx)localObject2).jdField_c_of_type_Int = 6;
        ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((bbcj)this.jdField_a_of_type_Bbat.a().a(2)).a.jdField_b_of_type_Long & 0x4000) == 0L))
      {
        localObject2 = a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.jdField_e_of_type_JavaLangString;
        }
        if (axea.a((String)localObject1))
        {
          localObject1 = new bahx();
          ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630977);
          ((bahx)localObject1).jdField_b_of_type_Boolean = true;
          ((bahx)localObject1).jdField_b_of_type_Int = 2130849183;
          ((bahx)localObject1).jdField_c_of_type_Int = 68;
          ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
          localArrayList2.add(localObject1);
          axea.a(0, 1);
        }
      }
      if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
      {
        localObject1 = new bahx();
        ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630978);
        ((bahx)localObject1).jdField_b_of_type_Int = 2130842036;
        ((bahx)localObject1).jdField_b_of_type_Boolean = true;
        ((bahx)localObject1).jdField_c_of_type_Int = 7;
        ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject1);
      }
      if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
      {
        localObject1 = new bahx();
        ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630975);
        ((bahx)localObject1).jdField_b_of_type_Int = 2130838728;
        ((bahx)localObject1).jdField_b_of_type_Boolean = true;
        ((bahx)localObject1).jdField_c_of_type_Int = 1;
        ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject1);
      }
      if (((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (!"docs.qq.com".equals(Uri.parse(this.jdField_e_of_type_JavaLangString).getHost()))) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenLongShotShare")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L) && (this.jdField_a_of_type_Bbat != null) && (this.jdField_a_of_type_Bbat.a() != null) && (this.jdField_a_of_type_Bbat.a().getX5WebViewExtension() != null))
      {
        localObject1 = new bahx();
        ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131653209);
        ((bahx)localObject1).jdField_b_of_type_Int = 2130845081;
        ((bahx)localObject1).jdField_b_of_type_Boolean = true;
        ((bahx)localObject1).jdField_c_of_type_Int = 71;
        ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject1);
      }
      if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle")) && (this.jdField_b_of_type_Boolean))
      {
        localObject1 = new bahx();
        ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630981);
        ((bahx)localObject1).jdField_b_of_type_Int = 2130842024;
        ((bahx)localObject1).jdField_b_of_type_Boolean = true;
        ((bahx)localObject1).jdField_c_of_type_Int = 11;
        ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject1);
      }
      return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Bbat.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Bbat.a();
    a();
  }
  
  public void b(int paramInt)
  {
    String str = a();
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
    {
      localBundle.putString("qq", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.f);
      localBundle.putString("public_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_JavaLangString);
      localBundle.putString("source_public_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.l);
      localBundle.putString("default_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_JavaLangString);
      localBundle.putString("msg_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.k);
      localBundle.putString("troop_app_info_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.q);
      localBundle.putString("troop_app_share_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.p);
      localBundle.putInt("troop_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_Int);
      localBundle.putInt("troop_app_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.i);
      localBundle.putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_Int);
    }
    a(paramInt, str, localBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Qno = new qnq(this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater()).a(this).a(this.jdField_b_of_type_Int).a().a(this.jdField_a_of_type_Bbat.a());
  }
  
  @TargetApi(14)
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Bbat.a() == null) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    paramInt = jdField_a_of_type_ArrayOfInt[paramInt];
    this.jdField_a_of_type_Bbat.a().getSettings().setTextZoom(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void d()
  {
    if (a())
    {
      a().f(new bbby(this));
      return;
    }
    c(1);
  }
  
  public void d(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean d()
  {
    return this.j;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (((this.jdField_a_of_type_Long & 0x20000) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.D();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bbcj != null) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a() instanceof TeamWorkDocEditBrowserActivity)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_JavaLangString.contains("sheet"))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bbcj.h();
    }
    try
    {
      if ((this.jdField_a_of_type_Xdt != null) && (this.jdField_a_of_type_Xdt.a() != null)) {
        this.jdField_a_of_type_Xdt.a().dismiss();
      }
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, paramDialogInterface, new Object[0]);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("SwiftBrowserShareMenuHandler", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Bahv.b();
    b(((baia)paramAdapterView).a.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbbt
 * JD-Core Version:    0.7.0.1
 */
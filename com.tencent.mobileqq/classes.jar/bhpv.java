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
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
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

public class bhpv
  extends bhou
  implements DialogInterface.OnDismissListener, bknt, ShareActionSheet.OnItemClickListener
{
  public static final int[] a;
  public static long b;
  public int a;
  public long a;
  aanz jdField_a_of_type_Aanz = null;
  public abcr a;
  public Activity a;
  protected Bundle a;
  private bhqb jdField_a_of_type_Bhqb;
  public ShareActionSheetBuilder a;
  public WebViewFragment a;
  public String a;
  public final ArrayList<String> a;
  private smp jdField_a_of_type_Smp;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<nzw> b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  public String c;
  public boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long = -1L;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  private int e;
  public String e;
  public boolean e;
  private String f;
  public boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l = true;
  private boolean m;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 95, 100, 107, 115, 127 };
    jdField_b_of_type_Long = -1L;
  }
  
  public bhpv()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 4L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_JavaLangString = "general_url";
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("pluginName", "web_share");
    return localIntent;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131718485, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131691139) });
    }
    if (paramInt == 3) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131718485, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131718034) });
    }
    if (paramInt == 10) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131718485, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131718030) });
    }
    if (paramInt == 12) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131718485, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131695712) });
    }
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131718485, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131718942) });
  }
  
  private void a(int paramInt, String paramString)
  {
    bglp.a(this.jdField_a_of_type_AndroidAppActivity, a(paramInt), 2131691639, 2131719153, new bhpy(this, paramInt, paramString), new bhpz(this, paramInt, paramString)).show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p)) {
      this.jdField_a_of_type_Abcr.a(paramString1, 3, true);
    }
    for (;;)
    {
      bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
      if ((paramString2 != null) && (!"".equals(paramString2))) {
        oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, paramString2, paramString4, paramString3, AccountDetailActivity.a(paramString3), false);
      }
      bipi.a().a("", "", "", "1000", "103", "0", false);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.t))
      {
        this.jdField_a_of_type_Abcr.i();
        continue;
      }
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_Abcr.a != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("type", 2);
        label159:
        adhh.b(this.jdField_a_of_type_Abcr.a, localJSONObject);
        this.jdField_a_of_type_Abcr.a(paramString1, 3, true);
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
    zvc.a(2, 2131691142);
    if ((this.i) && (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p))) {
      this.jdField_a_of_type_Abcr.e();
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p)) {
      this.jdField_a_of_type_Abcr.a(paramString, 8, false);
    }
    for (;;)
    {
      String str = this.jdField_f_of_type_JavaLangString;
      if (this.jdField_a_of_type_Bhov.a() != null) {
        str = this.jdField_a_of_type_Bhov.a().getUrl();
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
      oat.a(null, "", "0X800787A", "0X800787A", 0, 0, (String)localObject, str, "", "");
      tzo.a(1005, str, this.jdField_e_of_type_Int);
      return;
      this.jdField_a_of_type_Abcr.a(paramString, 8, false);
    }
  }
  
  private void d(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p)) {
      this.jdField_a_of_type_Abcr.a(paramString, 4, true);
    }
    for (;;)
    {
      bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      bipi.a().a("", "", "", "1000", "104", "0", false);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.u))
      {
        this.jdField_a_of_type_Abcr.j();
        continue;
      }
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_Abcr.a != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("type", 3);
        label120:
        adhh.b(this.jdField_a_of_type_Abcr.a, localJSONObject);
        this.jdField_a_of_type_Abcr.a(paramString, 4, true);
      }
      catch (JSONException localJSONException)
      {
        break label120;
      }
    }
  }
  
  private void e()
  {
    if (a(this.jdField_a_of_type_Abcr.a())) {
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
      int i1 = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int n = i1;
      if (i1 < 0) {
        n = 190;
      }
      str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(n), Integer.valueOf(n) });
    } while (this.jdField_a_of_type_Bhov.a() == null);
    this.jdField_a_of_type_Bhov.a().loadUrl("javascript:" + str + ";");
  }
  
  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p)) {
      this.jdField_a_of_type_Abcr.a(paramString, 2, false);
    }
    for (;;)
    {
      bipi.a().a("", "", "", "1000", "102", "0", false);
      bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.s))
      {
        this.jdField_a_of_type_Abcr.h();
        continue;
      }
      if (this.jdField_a_of_type_Abcr.a != null) {
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("type", 1);
        label120:
        adhh.b(this.jdField_a_of_type_Abcr.a, paramString);
        this.jdField_a_of_type_Abcr.a();
      }
      catch (JSONException localJSONException)
      {
        break label120;
      }
    }
  }
  
  public aanz a()
  {
    if (this.jdField_a_of_type_Aanz == null)
    {
      this.jdField_a_of_type_Aanz = aanz.a();
      this.jdField_a_of_type_Aanz.a();
    }
    return this.jdField_a_of_type_Aanz;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Abcr == null) {
      return "";
    }
    return this.jdField_a_of_type_Abcr.a();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getIntent();
    }
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("url");
    if (this.jdField_f_of_type_JavaLangString == null)
    {
      this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.jdField_f_of_type_JavaLangString == null) {
        this.jdField_f_of_type_JavaLangString = "";
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
      this.m = ((Bundle)localObject).getBoolean("fromFav");
      if (this.m)
      {
        this.jdField_c_of_type_Long = ((Bundle)localObject).getLong("favID");
        this.jdField_d_of_type_Long = ((Bundle)localObject).getLong("favGroupID");
      }
      this.jdField_e_of_type_Int = ((Bundle)localObject).getInt("articalChannelId", 100);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = a();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_f_of_type_JavaLangString;
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
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1001", "");
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
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, (String)localObject3, (String)localObject2, "1011", "");
      return;
    case 2: 
    case 3: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1002", "");
      return;
    case 9: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1003", "");
      return;
    case 10: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1004", "");
      return;
    case 5: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1005", "");
      return;
    case 4: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1006", "");
      return;
    case 6: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1007", "");
      return;
    case 11: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1008", "");
      return;
    case 8: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
      return;
    case 7: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1010", "");
      return;
    case 12: 
      bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1012", "");
      return;
    }
    bcst.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1013", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    b(paramInt2);
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
        if (this.jdField_a_of_type_Smp != null) {
          this.jdField_a_of_type_Smp.a();
        }
        if (this.jdField_a_of_type_Aanz != null) {
          this.jdField_a_of_type_Aanz.b();
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      } while ((paramBundle == null) || (paramBundle.getInt("state_machine_step", -1) != 1));
      d();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.onConfigurationChanged();
      }
    } while ((this.jdField_a_of_type_Smp == null) || (!this.jdField_a_of_type_Smp.a()));
    this.jdField_a_of_type_Smp.b();
    c();
  }
  
  public void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    String str = a();
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
    {
      localBundle.putString("qq", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.uin);
      localBundle.putString("public_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.publicUin);
      localBundle.putString("source_public_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.sourcePuin);
      localBundle.putString("default_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUrl);
      localBundle.putString("msg_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.msgid);
      localBundle.putString("troop_app_info_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.troopAppInfoUrl);
      localBundle.putString("troop_app_share_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.troopAppShareUrl);
      localBundle.putInt("troop_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.troopId);
      localBundle.putInt("troop_app_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.appId);
      localBundle.putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.uinType);
    }
    if ((paramInt == 72) && (paramActionSheetItem != null))
    {
      localBundle.putString("to_qq", paramActionSheetItem.uin);
      localBundle.putString("to_uin_name", paramActionSheetItem.label);
      localBundle.putInt("to_uin_type", paramActionSheetItem.uinType);
    }
    a(paramInt, str, localBundle);
  }
  
  @TargetApi(12)
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    String str6 = "";
    String str5 = "";
    String str4 = "";
    String str3 = "";
    String str2 = "";
    int i2 = 0;
    int i1 = 0;
    String str9 = "";
    int n = 0;
    String str8 = "";
    String str7 = "";
    if (paramBundle != null)
    {
      str6 = paramBundle.getString("qq", "");
      str5 = paramBundle.getString("public_uin", "");
      str4 = paramBundle.getString("source_public_uin", "");
      str3 = paramBundle.getString("default_url", "");
      str2 = paramBundle.getString("msg_id", "");
      i2 = paramBundle.getInt("troop_app_id", 0);
      i1 = paramBundle.getInt("troop_id", 0);
      str9 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
      n = paramBundle.getInt("to_uin_type", 0);
      str8 = paramBundle.getString("to_qq", "");
      str7 = paramBundle.getString("to_uin_name", "");
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    }
    Object localObject1 = this.jdField_f_of_type_JavaLangString;
    Object localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mRedirect302Url;
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
          String str11 = ((Uri)localObject3).getHost();
          String str10 = null;
          if (((Uri)localObject3).isHierarchical()) {
            str10 = ((Uri)localObject3).getQueryParameter("_pflag");
          }
          localObject3 = paramString;
          if (!TextUtils.isEmpty(str10)) {
            if (!"post.mp.qq.com".equalsIgnoreCase(str11))
            {
              localObject3 = paramString;
              if (!"url.cn".equalsIgnoreCase(str11)) {}
            }
            else
            {
              int i3 = Integer.parseInt(str10);
              localObject3 = paramString;
              if ((i3 >> 3 & 0x1) == 1) {
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
          bhek.a.a(this.jdField_a_of_type_AndroidAppActivity, paramString);
          continue;
          if (paramInt != 11) {
            continue;
          }
          paramBundle = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(paramString);
          n = 0;
          if (!paramBundle.matches()) {
            continue;
          }
          n = 1;
          paramBundle = null;
          try
          {
            paramString = URLEncoder.encode(paramString, "UTF-8");
            if (n != 0)
            {
              localObject2 = String.valueOf(NetConnInfoCenter.getServerTime());
              localObject1 = bita.b(paramString + 200 + (String)localObject2 + "jubao@article@123");
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
              bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
              if ((str4 == null) || ("".equals(str4))) {
                continue;
              }
              oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, str4, str2, str3, AccountDetailActivity.a(str3), false);
            }
          }
          catch (UnsupportedEncodingException paramString)
          {
            paramString = paramBundle;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
            paramString = paramBundle;
            continue;
            paramString = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + paramString + "&qq=" + str6 + "&_wv=7";
            continue;
          }
          if ((paramInt != 2) && (paramInt != 72) && (paramInt != 73)) {
            continue;
          }
          if (this.jdField_a_of_type_Bhqb == null) {
            continue;
          }
          this.jdField_a_of_type_Bhqb.a(paramString);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
            continue;
          }
          throw new InvalidParameterException("ACTION_REFRESH_FREIEND_VIEW should be handled by QQBrowserActivity!");
          paramBundle = (bhqc)this.jdField_a_of_type_Bhov.a().a(-2);
          if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView.getUrl())) || (paramBundle == null)) {
            continue;
          }
          String str1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView.getUrl();
          if ((TextUtils.isEmpty(paramBundle.jdField_d_of_type_JavaLangString)) || ((!paramBundle.jdField_d_of_type_JavaLangString.equals(str1)) && (!paramBundle.jdField_d_of_type_JavaLangString.equals(paramString)))) {
            continue;
          }
          boolean bool = true;
          this.jdField_a_of_type_Abcr.g = bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "ShareArkFromH5 mShare.isShareArk=", Boolean.valueOf(this.jdField_a_of_type_Abcr.g), ",\n shareUrl=", nmj.b(paramString, new String[0]) });
          if ((paramInt != 72) || (TextUtils.isEmpty(this.jdField_a_of_type_Abcr.r))) {
            continue;
          }
          this.jdField_a_of_type_Abcr.a(n, str8, str7);
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
            bcst.b(null, "P_CliOper", "VIPCOMIC", "", "0X800619F", "0X800619F", 1000, 0, nmj.b(str3, new String[0]), null, null, null);
            bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
            if ((str4 == null) || ("".equals(str4))) {
              continue;
            }
            oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1006, 0, str4, str2, str3, AccountDetailActivity.a(str3), false);
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
          n = MttLoader.loadUrl(BaseApplicationImpl.getContext(), paramString, paramBundle, null);
          if ((4 != n) && (5 != n) && (n == 0)) {
            continue;
          }
          paramString = (bhqg)this.jdField_a_of_type_Bhov.a().a(16);
          if (paramString == null) {
            continue;
          }
          paramString.a("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10367", true);
          bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
          bcst.b(null, "P_CliOper", "VIPCOMIC", "", "0X80061A0", "0X80061A0", 1000, 0, nmj.b(str3, new String[0]), null, null, null);
          if ((str4 == null) || ("".equals(str4))) {
            continue;
          }
          oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1005, 0, str4, str2, str3, AccountDetailActivity.a(str3), false);
          continue;
          throw new InvalidParameterException("ACTION_OPEN_IN_QQ_BROWSER should be handled by QQBrowserActivity!");
          if (paramInt != 3) {
            continue;
          }
          jdField_b_of_type_Long = System.currentTimeMillis();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          tzo.a(1002, (String)localObject1, this.jdField_e_of_type_Int);
          if ((this.jdField_a_of_type_Abcr.a() == null) || (this.jdField_a_of_type_Abcr.a().jdField_a_of_type_Int != 0)) {
            continue;
          }
          a(paramInt, paramString);
          continue;
          e(paramString);
          continue;
          if (paramInt != 6) {
            continue;
          }
          if (!this.jdField_a_of_type_Abcr.a(paramString)) {
            continue;
          }
          this.jdField_a_of_type_Abcr.a(paramString, 9, false);
          if ((str4 == null) || ("".equals(str4))) {
            continue;
          }
          oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, str4, str2, str3, AccountDetailActivity.a(str3), false);
          continue;
          if (paramInt != 129) {
            continue;
          }
          bljn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Long, this.jdField_d_of_type_Long);
          continue;
          if ((paramInt != 9) && (paramInt != 10)) {
            continue;
          }
          n = -1;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          if (paramInt != 9) {
            continue;
          }
          tzo.a(1003, (String)localObject1, this.jdField_e_of_type_Int);
          if (WXShareHelper.a().a()) {
            continue;
          }
          n = 2131719199;
          if (n == -1) {
            continue;
          }
          zvc.a(0, n);
          continue;
          tzo.a(1004, (String)localObject1, this.jdField_e_of_type_Int);
          continue;
          if (WXShareHelper.a().b()) {
            continue;
          }
          n = 2131719200;
          continue;
          if (paramInt != 9) {
            continue;
          }
          if (this.jdField_a_of_type_Abcr.a() == null) {
            continue;
          }
          this.jdField_a_of_type_Abcr.a().show();
          ThreadManager.excute(new SwiftBrowserShareMenuHandler.2(this, paramString, str4, str3, str2), 128, null, false);
          continue;
          a(paramString, str4, str3, str2);
          continue;
          if ((this.jdField_a_of_type_Abcr.a() == null) || (this.jdField_a_of_type_Abcr.a().jdField_a_of_type_Int != 0)) {
            continue;
          }
          a(paramInt, paramString);
          continue;
          d(paramString);
          continue;
          if (paramInt != 13) {
            continue;
          }
          this.jdField_a_of_type_Abcr.a(paramString, 5, true);
          continue;
          if (paramInt != 15) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
            continue;
          }
          throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
          if (bgnt.d(BaseApplicationImpl.getContext())) {
            continue;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 2, 2131718678, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getTitleBarHeight());
          return;
          a().a(i2, new bhpw(this));
          bcst.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, "" + i1, "" + i2, "", "");
          continue;
          if (paramInt != 16) {
            continue;
          }
          paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
          paramString.putExtra("url", str9);
          paramString.putExtra("hide_operation_bar", true);
          paramString.putExtra("hide_more_button", true);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
          bcst.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, "" + i1, "" + i2, "", "");
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
          bcst.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, "" + i1, "" + i2, "", "");
          continue;
          if (paramInt != 18) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
            continue;
          }
          throw new InvalidParameterException("ACTION_REFRESH_TROOP_APP_VIEW should be handled by QQBrowserActivity!");
          paramString = (bhqc)this.jdField_a_of_type_Bhov.a().a(-2);
          if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView.getUrl())) || (paramString == null)) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mStatistics.h = false;
          paramString.q = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView.reload();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView.setOnCustomScrollChangeListener(null);
          paramString.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView.getUrl(), 1, 0, 0, 0, 0, null);
          bcst.b(null, "P_CliOper", "Grp_open", "", "third_app", "refresh_menu", 0, 1, 0, "" + i1, "" + i2, "", "");
          continue;
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getCurrentUrl();
          if ((TextUtils.isEmpty(paramBundle)) || (paramString == null)) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mStatistics.h = false;
          paramString.q = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView.loadUrl(paramBundle);
          paramString.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView, paramBundle, 1, 0, 0, 0, 0, null);
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
          n = 6;
          if (TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p)) {
            continue;
          }
          this.jdField_a_of_type_Abcr.a(paramString, n, false);
          continue;
          n = 7;
          continue;
          this.jdField_a_of_type_Abcr.a(paramString, n, true);
          continue;
          if (paramInt != 21) {
            continue;
          }
          paramString = (bhpq)this.jdField_a_of_type_Bhov.a().a(64);
          if (paramString == null) {
            continue;
          }
          paramString.a(null, null, 2);
          paramString = "";
          paramBundle = Uri.parse(this.jdField_f_of_type_JavaLangString);
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
          oat.a(null, "", "0X8007071", "0X8007071", 0, 0, paramBundle, "", "", "");
          oat.a("0X8007071", "", paramBundle, "", "", "");
          continue;
          if (paramInt != 12) {
            continue;
          }
          if ((this.jdField_a_of_type_Abcr.a() == null) || (this.jdField_a_of_type_Abcr.a().jdField_a_of_type_Int != 0)) {
            continue;
          }
          a(paramInt, paramString);
          continue;
          c(paramString);
          continue;
          if (paramInt != 34) {
            continue;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p)) {
            continue;
          }
          this.jdField_a_of_type_Abcr.d();
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
          paramString = (nzw)((Iterator)localObject1).next();
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
            oat.a(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
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
          paramBundle = (nzw)paramString.next();
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
            oat.a(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if ((paramInt != 37) || (!this.jdField_f_of_type_Boolean)) {
            continue;
          }
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            continue;
          }
          paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!paramString.hasNext()) {
            continue;
          }
          paramBundle = (nzw)paramString.next();
          if (paramBundle.jdField_a_of_type_Int != 1) {
            continue;
          }
          try
          {
            l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
            paramString = afur.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
            paramString.putExtra("uin", l1 + "");
            paramString.putExtra("uintype", 0);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
            oat.a(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
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
          paramBundle = (nzw)paramString.next();
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
            oat.a(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if (paramInt != 38) {
            continue;
          }
          this.jdField_a_of_type_Abcr.f();
          continue;
          if (paramInt != 68) {
            continue;
          }
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser)) {
            continue;
          }
          n = 0;
          bdho.a(1, n);
          paramBundle = a();
          paramString = paramBundle;
          if (paramBundle != null) {
            continue;
          }
          paramString = this.jdField_f_of_type_JavaLangString;
          if (this.jdField_a_of_type_Abcr != null) {
            continue;
          }
          paramBundle = "";
          bdho.a(paramString, paramBundle);
          continue;
          n = 1;
          continue;
          paramBundle = this.jdField_a_of_type_Abcr.b();
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
          bcst.b(null, "dc00898", "", "", "0X800A9A4", "0X800A9A4", 0, 0, "1", "", "", "");
          bgim.a(this.jdField_a_of_type_Bhov.a(), new bhpx(this));
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
        if (paramInt == 1)
        {
          if ((this.jdField_a_of_type_Abcr.a() != null) && (this.jdField_a_of_type_Abcr.a().jdField_a_of_type_Int == 0)) {
            a(paramInt, paramString);
          }
        }
        else
        {
          if (paramInt != 133) {
            continue;
          }
          if ((this.jdField_a_of_type_Abcr.a() == null) || (this.jdField_a_of_type_Abcr.a().jdField_a_of_type_Int != 0)) {
            continue;
          }
          a(paramInt, paramString);
          a(paramInt);
          return;
        }
      }
      localObject2 = localObject1;
    }
  }
  
  public void a(long paramLong)
  {
    ((bhqc)this.jdField_a_of_type_Bhov.a().a(-2)).jdField_a_of_type_Long = paramLong;
  }
  
  public void a(abcr paramabcr, long paramLong)
  {
    if (paramabcr == null) {}
    label296:
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
        {
          Object localObject1 = this.jdField_f_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mRedirect302Url;
          }
          tzo.a((String)localObject1);
          this.jdField_a_of_type_Abcr = paramabcr;
          this.jdField_a_of_type_Long = paramLong;
          a();
          e();
          a();
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity, false, 2);
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setIntentForStartForwardRecentActivity(a());
          }
          paramabcr = null;
          localObject1 = (bhpq)this.jdField_a_of_type_Bhov.a().a(64);
          if (localObject1 != null) {
            paramabcr = ((bhpq)localObject1).a();
          }
          localObject1 = (bhqc)this.jdField_a_of_type_Bhov.a().a(-2);
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (localObject1 != null))
          {
            if (((bhqc)localObject1).m)
            {
              paramabcr = "<font color='#777777'>应用由 </font><font color='#00a5e0'>" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.troopAppCompanyName + "</font><font color='#777777'> 提供</font>";
              this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(Html.fromHtml(paramabcr));
              bcst.b(null, "P_CliOper", "Grp_open", "", "third_app", "exp_menu", 0, 1, 0, "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.troopId, "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.appId, "", "");
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListenerV2(this);
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(this);
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
            Object localObject2;
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.uinType == 1008))
            {
              paramabcr = a();
              localObject1 = paramabcr;
              if (paramabcr == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUrl;
              }
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.publicUin))
              {
                paramabcr = "";
                localObject2 = Uri.parse((String)localObject1);
              }
            }
            else
            {
              try
              {
                localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
                paramabcr = (abcr)localObject2;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                }
              }
              localObject2 = paramabcr;
              if (paramabcr == null) {
                localObject2 = "";
              }
              oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005F78", "0X8005F78", 0, 0, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.publicUin, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.msgid, (String)localObject2, false);
              if (this.jdField_f_of_type_Boolean)
              {
                oat.a(null, "", "0X8008CAA", "0X8008CAA", 0, 0, "", "", "", "", false);
                return;
                if (!TextUtils.isEmpty(paramabcr))
                {
                  this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(paramabcr);
                  break label296;
                }
                this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(BaseApplicationImpl.getApplication().getString(2131717991));
              }
            }
          }
          catch (Exception paramabcr)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "actionSheet.show exception=" + paramabcr);
              }
            }
          }
        }
      }
    } while (!this.jdField_e_of_type_Boolean);
    oat.a(null, "", "0X8008CAB", "0X8008CAB", 0, 0, "", "", "", "", false);
  }
  
  public void a(bhqb parambhqb)
  {
    this.jdField_a_of_type_Bhqb = parambhqb;
  }
  
  public void a(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      tzo.a(1001, paramString3, this.jdField_e_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p)) {
        this.jdField_a_of_type_Abcr.a(paramString1, 1, false);
      }
      for (;;)
      {
        bipi.a().a("", "", "", "1000", "101", "0", false);
        bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
        return;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.q))
        {
          this.jdField_a_of_type_Abcr.g();
        }
        else
        {
          if (this.jdField_a_of_type_Abcr.a != null) {
            paramString2 = new JSONObject();
          }
          try
          {
            paramString2.put("type", 0);
            label138:
            adhh.b(this.jdField_a_of_type_Abcr.a, paramString2);
            this.jdField_a_of_type_Abcr.a(paramString1, 1, false);
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
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (((bhql)this.jdField_a_of_type_Bhov.a().a(2)).a.jdField_e_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_Bhov.a() != null)
    {
      this.jdField_a_of_type_Bhov.a();
      int n = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if ((n > 0) && (n < 36201))
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
    String str = this.jdField_a_of_type_Abcr.a();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.b()))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.c()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(nmj.a(paramString, new String[0]))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = (bhqc)this.jdField_a_of_type_Bhov.a().a(-2);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (localObject1 != null) && (((bhqc)localObject1).m))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(15));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(16));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(17));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(18));
      return (List[])new ArrayList[] { localArrayList1 };
    }
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {}
    for (localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (this.h) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")) && (!TextUtils.isEmpty(this.jdField_a_of_type_Abcr.p))) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(34));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      }
      if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (bmqa.a()) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:kandian")) && (localObject1 != null))
      {
        localObject2 = "readinjoy_" + ((AppRuntime)localObject1).getAccount() + "_" + 1;
        localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
        if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false))) {
          localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(13));
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      }
      if ((this.g) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo"))) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(12));
      }
      if ((!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(5));
      }
      if ((!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(4));
      }
      Object localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
      if ((!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
        bjft.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList1);
      }
      if ((!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(20));
      }
      ArrayList localArrayList2 = new ArrayList();
      int n;
      if ((!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyWatchWord")) && ((this.jdField_a_of_type_Long & 0x2) == 0L) && (aqyv.a(a())) && (a().contains("?")))
      {
        n = bhek.a.a(a()).intValue();
        if (n != -1)
        {
          bcst.b(null, "dc00898", "", "", "qq_vip", "0X800AF77", n, 0, "", "", "", "");
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(133));
        }
      }
      Object localObject3;
      if (this.k)
      {
        localObject3 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
        localObject2 = ((QQBrowserActivity)localObject3).getOriginalUrl();
        localObject3 = ((QQBrowserActivity)localObject3).a();
        if ((localObject3 != null) && (((aqcb)localObject3).a()) && (((aqcb)localObject3).e()) && (!aqda.c((String)localObject2)))
        {
          boolean bool = ((aqcb)localObject3).c();
          localObject3 = ShareActionSheetBuilder.ActionSheetItem.build(70);
          localObject2 = BaseApplicationImpl.getApplication();
          if (bool) {
            break label1091;
          }
          n = 2131717929;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).label = ((BaseApplicationImpl)localObject2).getString(n);
          if (bool) {
            break label1098;
          }
          n = 2130846271;
          label923:
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = n;
          if (bkpg.a())
          {
            if (bool) {
              break label1105;
            }
            n = 2130846272;
            label943:
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = n;
          }
          if (bool) {
            break label1112;
          }
          localObject2 = "colornote";
          label958:
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).reportID = ((String)localObject2);
          localArrayList2.add(localObject3);
        }
      }
      label996:
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1147;
          }
          localObject3 = (nzw)((Iterator)localObject2).next();
          localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(30);
          switch (((nzw)localObject3).jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nzw)localObject3).jdField_a_of_type_JavaLangString)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131694598);; localActionSheetItem.label = ((nzw)localObject3).jdField_a_of_type_JavaLangString)
            {
              localArrayList2.add(localActionSheetItem);
              break label996;
              n = 2131690748;
              break;
              n = 2130846280;
              break label923;
              n = 2130846281;
              break label943;
              localObject2 = "colornote_cancel";
              break label958;
            }
          case 2: 
            label1091:
            label1098:
            label1105:
            label1112:
            localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(31));
          }
        }
      }
      label1147:
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (nzw)((Iterator)localObject2).next();
          localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(37);
          switch (((nzw)localObject3).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nzw)localObject3).jdField_a_of_type_JavaLangString)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131694598);; localActionSheetItem.label = ((nzw)localObject3).jdField_a_of_type_JavaLangString)
            {
              localArrayList2.add(localActionSheetItem);
              break;
            }
          case 3: 
            localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(35));
          }
        }
      }
      localObject2 = (bhpq)this.jdField_a_of_type_Bhov.a().a(64);
      if ((localObject2 != null) && (((bhpq)localObject2).a()) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare"))) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(21));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
      }
      if (this.m) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(129));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((bhql)this.jdField_a_of_type_Bhov.a().a(2)).a.jdField_b_of_type_Long & 0x4000) == 0L))
      {
        localObject2 = a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.jdField_f_of_type_JavaLangString;
        }
        if (bdho.a((String)localObject1))
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(68));
          bdho.a(0, 1);
        }
      }
      if ((!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(7));
      }
      if ((!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
      }
      if (((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (!"docs.qq.com".equals(Uri.parse(this.jdField_f_of_type_JavaLangString).getHost()))) && (!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenLongShotShare")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L) && (this.jdField_a_of_type_Bhov != null) && (this.jdField_a_of_type_Bhov.a() != null) && (this.jdField_a_of_type_Bhov.a().getX5WebViewExtension() != null)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(71));
      }
      if ((!tym.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle")) && (this.jdField_b_of_type_Boolean)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
      }
      return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Bhov.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Bhov.a();
    a();
  }
  
  @TargetApi(14)
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Bhov.a() == null) || (this.jdField_d_of_type_Boolean)) {}
    int n;
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt;
      n = jdField_a_of_type_ArrayOfInt[paramInt];
      this.jdField_a_of_type_Bhov.a().getSettings().setTextZoom(n);
    } while (this.jdField_a_of_type_Abcr == null);
    this.jdField_a_of_type_Abcr.a(paramInt, n);
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
    this.jdField_a_of_type_Smp = new smr(this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater()).a(this).a(this.jdField_b_of_type_Int).a().a(this.jdField_a_of_type_Bhov.a());
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
      a().f(new bhqa(this));
      return;
    }
    b(1);
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
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.hideVirtualNavBar();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUIStyleHandler != null) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getHostActivity() instanceof TeamWorkDocEditBrowserActivity)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUrl)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUrl.contains("sheet"))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUIStyleHandler.j();
    }
    try
    {
      if ((this.jdField_a_of_type_Abcr != null) && (this.jdField_a_of_type_Abcr.a() != null)) {
        this.jdField_a_of_type_Abcr.a().dismiss();
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (QLog.isColorLevel())) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onDismiss() called don't clear mExtraParams for time sequence problems");
      }
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("SwiftBrowserShareMenuHandler", 1, paramDialogInterface, new Object[0]);
      }
    }
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    a(paramActionSheetItem.action, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpv
 * JD-Core Version:    0.7.0.1
 */
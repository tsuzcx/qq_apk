import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinEngine;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bejh
  extends behq
  implements View.OnClickListener, Animation.AnimationListener
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public Activity a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public View a;
  public ViewGroup a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public FrameLayout a;
  public ImageView a;
  public ProgressBar a;
  public TextView a;
  public befo a;
  public beft a;
  private beiy jdField_a_of_type_Beiy;
  public final bejk a;
  public bewj a;
  public WebViewFragment a;
  public WebViewProgressBar a;
  public String a;
  public boolean a;
  public int b;
  public View b;
  public ViewGroup b;
  Animation b;
  public ImageView b;
  public TextView b;
  public boolean b;
  public View c;
  public ViewGroup c;
  public TextView c;
  public boolean c;
  public ViewGroup d;
  public boolean d;
  private boolean e;
  
  public bejh()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bejk = new bejk();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private int a(String paramString)
  {
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("0x")) {
        break label86;
      }
      paramString = paramString.substring(2);
    }
    label86:
    for (;;)
    {
      String str = paramString;
      try
      {
        if (!paramString.startsWith("#")) {
          str = "#" + paramString;
        }
        i = Color.parseColor(str);
      }
      catch (NumberFormatException paramString)
      {
        do
        {
          i = j;
        } while (!QLog.isDevelopLevel());
        QLog.d("SwiftBrowserUIStyleHandler", 4, "Illegal getColorIntFromUrlParams");
        return -1;
      }
      return i;
    }
  }
  
  private WebViewTitleStyle a(String paramString)
  {
    int i1 = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Uri.parse(paramString);
    String str1;
    String str2;
    int k;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      paramString = ((Uri)localObject).getQueryParameter("_wvNb");
      str1 = ((Uri)localObject).getQueryParameter("_wvNs");
      str2 = ((Uri)localObject).getQueryParameter("_wvNt");
      localObject = ((Uri)localObject).getQueryParameter("_wvNi");
      k = 0;
    }
    int j;
    for (int i = 0;; i = j)
    {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          i = a(paramString);
          k = 1;
        }
        catch (Exception paramString)
        {
          j = -1;
          m = -1;
          i = -1;
        }
        try
        {
          if (!TextUtils.isEmpty(str1))
          {
            m = a(str1);
            k = 1;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            j = -1;
            m = -1;
          }
        }
        try
        {
          if (TextUtils.isEmpty(str2)) {
            break label240;
          }
          j = a(str2);
          k = 1;
        }
        catch (Exception paramString)
        {
          j = -1;
          break label195;
        }
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label234;
          }
          n = a((String)localObject);
          k = i1;
          if (k == 0) {
            break label229;
          }
          paramString = new WebViewTitleStyle();
          paramString.jdField_b_of_type_Int = m;
          paramString.jdField_c_of_type_Int = i;
          paramString.d = j;
          paramString.e = n;
          return paramString;
        }
        catch (Exception paramString)
        {
          break label195;
        }
        int m = i;
        continue;
        label195:
        QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = ", paramString);
        int n = -1;
        continue;
        label229:
        paramString = null;
        continue;
        label234:
        n = -1;
        continue;
        label240:
        j = -1;
      }
      j = -1;
      k = i;
    }
  }
  
  private void a(Uri paramUri)
  {
    String str = "unknown";
    if (paramUri != null) {}
    try
    {
      str = paramUri.getHost();
      if ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x20000) != 0L) {
        azqs.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 131072, 0, "", "", str, "");
      }
      if ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x1000000) != 0L) {
        azqs.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 16777216, 0, "", "", str, "");
      }
      if ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x2) != 0L) {
        azqs.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 2, 0, "", "", str, "");
      }
      return;
    }
    catch (Throwable paramUri)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramUri, new Object[0]);
    }
  }
  
  private WebViewTitleStyle b(String paramString)
  {
    int j = 0;
    int i1 = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Uri.parse(paramString);
    String str1;
    String str2;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      paramString = ((Uri)localObject).getQueryParameter("_nav_bgclr");
      str1 = ((Uri)localObject).getQueryParameter("_nav_statusclr");
      str2 = ((Uri)localObject).getQueryParameter("_nav_titleclr");
      localObject = ((Uri)localObject).getQueryParameter("_nav_txtclr");
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label248;
        }
        k = a(paramString);
        i = 1;
      }
      catch (Exception paramString)
      {
        i = -1;
        m = -1;
        k = -1;
      }
      try
      {
        if (!TextUtils.isEmpty(str1))
        {
          m = a(str1);
          j = 1;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label192:
          m = -1;
          n = -1;
          j = i;
          i = n;
        }
      }
      try
      {
        if (TextUtils.isEmpty(str2)) {
          break label243;
        }
        i = a(str2);
        j = 1;
      }
      catch (Exception paramString)
      {
        i = -1;
        break label192;
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label237;
        }
        n = a((String)localObject);
        j = i1;
        if (j == 0) {
          break label232;
        }
        paramString = new WebViewTitleStyle();
        paramString.jdField_b_of_type_Int = m;
        paramString.jdField_c_of_type_Int = k;
        paramString.d = i;
        paramString.e = n;
        return paramString;
      }
      catch (Exception paramString)
      {
        break label192;
      }
      int m = 0;
      j = i;
      continue;
      QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = ", paramString);
      int n = -1;
      continue;
      label232:
      paramString = null;
      continue;
      label237:
      n = -1;
      continue;
      label243:
      int i = -1;
      continue;
      label248:
      i = 0;
      int k = -1;
    }
  }
  
  public TouchWebView a()
  {
    return (TouchWebView)this.jdField_a_of_type_Behr.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Behr.a() != null)
    {
      WebView localWebView = this.jdField_a_of_type_Behr.a();
      localWebView.setId(2131380175);
      if (this.jdField_b_of_type_Int != -1) {
        localWebView.setBackgroundColor(this.jdField_b_of_type_Int);
      }
      this.jdField_c_of_type_AndroidViewViewGroup.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    case 5: 
    default: 
      return;
    case 2: 
      ndq.a("Web_updateTitleBarUI");
      if (this.jdField_a_of_type_Bejk.s) {
        this.jdField_a_of_type_Beft.h();
      }
      ndq.b("Web_updateTitleBarUI");
      return;
    case 3: 
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        paramBundle = this.jdField_b_of_type_AndroidViewView.getParent();
        if ((paramBundle != null) && ((paramBundle instanceof ViewGroup))) {
          ((ViewGroup)paramBundle).removeView(this.jdField_b_of_type_AndroidViewView);
        }
      }
      this.jdField_a_of_type_Beft.f();
      return;
    case 4: 
      if ((this.jdField_a_of_type_Befo.jdField_a_of_type_AndroidViewView != null) && (8 == this.jdField_a_of_type_Befo.jdField_c_of_type_AndroidViewView.getVisibility())) {
        this.jdField_a_of_type_Befo.a();
      }
      if (paramBundle.containsKey("Configuration")) {}
      for (paramBundle = (Configuration)paramBundle.getParcelable("Configuration"); (paramBundle != null) && (this.jdField_a_of_type_Befo.jdField_c_of_type_AndroidViewView != null) && (paramBundle.orientation == 2) && (this.jdField_a_of_type_Befo.jdField_c_of_type_AndroidViewView.getVisibility() == 0); paramBundle = null)
      {
        this.jdField_a_of_type_Befo.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
    case 6: 
      if ((!this.jdField_a_of_type_Beiy.j) && (this.jdField_a_of_type_Bewj != null) && (this.jdField_a_of_type_Bewj.b() != 0)) {
        this.jdField_a_of_type_Bewj.a((byte)0);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((paramBundle == null) || (!paramBundle.containsKey("url"))) {
        break;
      }
    }
    for (paramBundle = paramBundle.getString("url");; paramBundle = null)
    {
      if (!TextUtils.isEmpty(paramBundle)) {
        localObject1 = Uri.parse(paramBundle);
      }
      if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()) && ("simple".equals(((Uri)localObject1).getQueryParameter("style"))))
      {
        this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Bejk.y = true;
      }
      a(this.jdField_a_of_type_Behr.a());
      return;
      if (this.jdField_a_of_type_Bewj != null) {
        this.jdField_a_of_type_Bewj.a((byte)2);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((this.jdField_a_of_type_Bejk.D) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
        break;
      }
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Int == -1)) {
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2131167190);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Behr.a() == null) {
        break;
      }
      localObject1 = (TouchWebView)this.jdField_a_of_type_Behr.a();
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label564;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        paramBundle = localObject2;
        if ((this.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
          paramBundle = (RefreshView)this.jdField_c_of_type_AndroidViewViewGroup;
        }
        if ((paramBundle == null) || (!this.jdField_b_of_type_Boolean)) {
          break;
        }
        ((TouchWebView)localObject1).setOnOverScrollHandler(new beji(this, (TouchWebView)localObject1, paramBundle));
        ((TouchWebView)localObject1).setOnScrollChangedListener(new bejj(this));
        b(this.jdField_a_of_type_Behr.a());
        return;
        label564:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    int i;
    boolean bool;
    if (((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x20000) != 0L) || (paramIntent.getBooleanExtra("isFullScreen", false)))
    {
      i = 1;
      if (i != 0) {
        this.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean = true;
      }
      bejk localbejk = this.jdField_a_of_type_Bejk;
      if (((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x1000000) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitle", false))) {
        break label696;
      }
      bool = true;
      label76:
      localbejk.jdField_b_of_type_Boolean = bool;
      localbejk = this.jdField_a_of_type_Bejk;
      if (((this.jdField_a_of_type_Bejk.jdField_b_of_type_Long & 1L) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitleAndClickable", false))) {
        break label701;
      }
      bool = true;
      label115:
      localbejk.m = bool;
      localbejk = this.jdField_a_of_type_Bejk;
      if (((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x2) == 0L) && (!paramIntent.getBooleanExtra("hide_more_button", false))) {
        break label706;
      }
      bool = true;
      label156:
      localbejk.e = bool;
      localbejk = this.jdField_a_of_type_Bejk;
      if (((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 1L) == 0L) && (!paramIntent.getBooleanExtra("hide_operation_bar", false)) && (!"noBottomBar".equals(paramIntent.getStringExtra("webStyle")))) {
        break label711;
      }
      bool = true;
      label211:
      localbejk.f = bool;
      localbejk = this.jdField_a_of_type_Bejk;
      if ((this.jdField_a_of_type_Bejk.jdField_b_of_type_Long & 0x100) == 0L) {
        break label716;
      }
      bool = true;
      label241:
      localbejk.o = bool;
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_params_qq")))
      {
        this.jdField_a_of_type_Bejk.e = true;
        this.jdField_a_of_type_Bejk.f = true;
      }
      i = paramIntent.getIntExtra("reqType", -1);
      if ((!this.jdField_a_of_type_Bejk.f) && (i == 6)) {
        this.jdField_a_of_type_Bejk.f = true;
      }
      this.jdField_a_of_type_Bejk.g = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
      this.jdField_a_of_type_Bejk.q = paramIntent.getBooleanExtra("rightTopCancel", false);
      this.jdField_a_of_type_Bejk.r = paramIntent.getBooleanExtra("webViewMoveTop", false);
      if ((!this.jdField_a_of_type_Bejk.e) && ((i == 3) || (i == 1) || (!paramIntent.getBooleanExtra("ba_is_login", true)) || (i == 7))) {
        this.jdField_a_of_type_Bejk.e = true;
      }
      if ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x20000) > 0L) {
        this.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x20000000) != 0L) {
        this.jdField_a_of_type_Bejk.s = true;
      }
      if ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x800) > 0L)
      {
        this.jdField_a_of_type_Bejk.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Bejk.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
      if ((this.jdField_a_of_type_Bejk.jdField_b_of_type_Long & 0x4) > 0L)
      {
        this.jdField_a_of_type_Bejk.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_Bejk.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
      if ((this.jdField_a_of_type_Bejk.jdField_b_of_type_Long & 0x2) > 0L) {
        this.jdField_a_of_type_Bejk.h = true;
      }
      if ((this.jdField_a_of_type_Bejk.jdField_b_of_type_Long & 0x200) > 0L) {
        this.jdField_a_of_type_Bejk.D = true;
      }
      if ((this.jdField_a_of_type_Bejk.jdField_b_of_type_Long & 0x400) > 0L)
      {
        localbejk = this.jdField_a_of_type_Bejk;
        this.jdField_a_of_type_Bejk.B = true;
        localbejk.E = true;
      }
      if ((this.jdField_a_of_type_Bejk.jdField_b_of_type_Long & 0x2000) > 0L) {
        this.jdField_a_of_type_Bejk.p = true;
      }
      if ((this.jdField_a_of_type_Bejk.jdField_d_of_type_Long & 1L) > 0L) {
        this.jdField_a_of_type_Bejk.jdField_b_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_Bejk.jdField_d_of_type_Long & 0x8) > 0L) {
        this.jdField_a_of_type_Bejk.m = true;
      }
      if (!paramIntent.getBooleanExtra("from_single_task", false)) {
        break label721;
      }
      this.jdField_a_of_type_Bejk.G = true;
    }
    label696:
    label701:
    label706:
    label711:
    label716:
    label721:
    while ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x80000000) <= 0L)
    {
      return;
      i = 0;
      break;
      bool = false;
      break label76;
      bool = false;
      break label115;
      bool = false;
      break label156;
      bool = false;
      break label211;
      bool = false;
      break label241;
    }
    this.jdField_a_of_type_Bejk.F = myl.a().j(paramIntent.getStringExtra("url"));
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_Beft.a(paramIntent, paramString);
    a(this.jdField_a_of_type_Bejk.jdField_a_of_type_OrgJsonJSONObject, false);
    d();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Beft.a(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    do
    {
      return;
      int i;
      if ((this.jdField_a_of_type_Bejk.B) && (!"1000".equals(ThemeUtil.getCurrentThemeId()))) {
        i = 1;
      }
      Drawable localDrawable;
      while (paramBoolean)
      {
        if (i != 0)
        {
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt1);
          if (localDrawable != null)
          {
            paramView.setBackgroundDrawable(localDrawable);
            return;
            i = 0;
            continue;
          }
        }
        paramView.setBackgroundResource(paramInt2);
        return;
      }
      if ((paramView instanceof ImageView))
      {
        paramView = (ImageView)paramView;
        if (i != 0)
        {
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt1);
          if (localDrawable != null)
          {
            paramView.setImageDrawable(localDrawable);
            return;
          }
        }
        paramView.setImageResource(paramInt2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AbsBaseWebViewActivity", 2, "-->setShowDefaultThemeIcon err! resId=" + paramInt1);
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_Beft.a(paramTouchWebView);
  }
  
  @TargetApi(14)
  public void a(WebBrowserViewContainer paramWebBrowserViewContainer, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramWebBrowserViewContainer.findViewById(2131367003));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bejk.jdField_c_of_type_Long != 0L))
    {
      paramWebBrowserViewContainer.b(this.jdField_a_of_type_Bejk.H);
      this.jdField_a_of_type_Befo.a(paramWebBrowserViewContainer, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Befo.a(this.jdField_a_of_type_AndroidAppActivity);
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Beiy.s = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372342));
    this.jdField_a_of_type_Bewj = new bewj();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Bewj);
    paramIntent = this.jdField_a_of_type_Bewj;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.a(bool);
      if ((this.jdField_a_of_type_Beiy.j) && (this.jdField_a_of_type_Bewj != null) && (this.jdField_a_of_type_Bewj.b() != 0)) {
        this.jdField_a_of_type_Bewj.a((byte)0);
      }
      ndq.a("Web_qqbrowser_initView_WebViewWrapper");
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380185));
      ndq.b("Web_qqbrowser_initView_WebViewWrapper");
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Beiy.m = (l2 - l1);
      if (!this.jdField_a_of_type_Bejk.D)
      {
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363461);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363462));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131377475));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        if ((this.jdField_a_of_type_Bejk.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))) {
          ((ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();
        }
      }
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131375588));
      }
      if ((this.jdField_a_of_type_Bejk.C) && (this.jdField_c_of_type_AndroidViewView != null)) {
        this.jdField_c_of_type_AndroidViewView.setPadding(0, (int)bdgz.a(BaseApplicationImpl.getContext(), 30.0F), 0, 0);
      }
      l();
      this.jdField_a_of_type_AndroidAppActivity.getWindow().setBackgroundDrawable(null);
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      }
      a();
      if (this.jdField_b_of_type_Int != -1) {
        paramWebBrowserViewContainer.setBackgroundColor(this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Beft != null) {
        this.jdField_a_of_type_Beft.b();
      }
      return;
    }
  }
  
  public void a(WebView paramWebView)
  {
    if (this.jdField_a_of_type_Bejk.g)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = Uri.parse(paramString);
    String str1;
    if (paramString.isHierarchical())
    {
      str1 = paramString.getQueryParameter("_wv");
      if (str1 == null) {}
    }
    try
    {
      this.jdField_a_of_type_Bejk.jdField_a_of_type_Long = Long.parseLong(str1, 10);
      str1 = paramString.getQueryParameter("_fv");
      if (str1 == null) {}
    }
    catch (NumberFormatException localNumberFormatException7)
    {
      try
      {
        this.jdField_a_of_type_Bejk.jdField_c_of_type_Long = Long.parseLong(str1, 10);
        str1 = paramString.getQueryParameter("_fu");
        this.jdField_a_of_type_Bejk.jdField_c_of_type_Boolean = false;
        if (str1 == null) {}
      }
      catch (NumberFormatException localNumberFormatException7)
      {
        try
        {
          if (Long.parseLong(str1) == 2019L) {
            this.jdField_a_of_type_Bejk.jdField_c_of_type_Boolean = true;
          }
          str1 = paramString.getQueryParameter("_wwv");
          if (str1 == null) {}
        }
        catch (NumberFormatException localNumberFormatException7)
        {
          try
          {
            this.jdField_a_of_type_Bejk.jdField_b_of_type_Long = Long.parseLong(str1, 10);
            str2 = paramString.getQueryParameter("_cwv");
            if (str2 == null) {}
          }
          catch (NumberFormatException localNumberFormatException7)
          {
            try
            {
              String str2;
              this.jdField_a_of_type_Bejk.jdField_d_of_type_Long = Long.parseLong(str2, 10);
              str1 = paramString.getQueryParameter("channel");
              if (!TextUtils.isEmpty(str1)) {
                this.jdField_a_of_type_Bejk.jdField_a_of_type_JavaLangString = URLDecoder.decode(str1);
              }
              str1 = paramString.getQueryParameter("subIndex");
              if (TextUtils.isEmpty(str1)) {}
            }
            catch (NumberFormatException localNumberFormatException7)
            {
              try
              {
                this.jdField_a_of_type_Bejk.jdField_a_of_type_Int = Integer.parseInt(str1.trim());
                str1 = paramString.getQueryParameter("bgColor");
                if (TextUtils.isEmpty(str1)) {}
              }
              catch (NumberFormatException localNumberFormatException7)
              {
                try
                {
                  this.jdField_b_of_type_Int = ((int)Long.parseLong(str1, 16));
                  str1 = paramString.getQueryParameter("titleAlpha");
                  if (TextUtils.isEmpty(str1)) {}
                }
                catch (NumberFormatException localNumberFormatException7)
                {
                  try
                  {
                    for (;;)
                    {
                      this.jdField_a_of_type_Bejk.jdField_b_of_type_Int = Integer.parseInt(str1.trim());
                      str1 = paramString.getAuthority();
                      if ((TextUtils.isEmpty(str1)) || (!str1.endsWith("urlshare.cn"))) {
                        break;
                      }
                      this.jdField_a_of_type_Bejk.H = true;
                      a(paramString);
                      return;
                      localNumberFormatException1 = localNumberFormatException1;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wv param(" + str1 + ") error:" + localNumberFormatException1.getMessage());
                      continue;
                      localNumberFormatException2 = localNumberFormatException2;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + str1 + ") error:" + localNumberFormatException2.getMessage());
                      continue;
                      localNumberFormatException3 = localNumberFormatException3;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + str1 + ") error:" + localNumberFormatException3.getMessage());
                      continue;
                      localNumberFormatException4 = localNumberFormatException4;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wwv param(" + str1 + ") error:" + localNumberFormatException4.getMessage());
                      continue;
                      localNumberFormatException5 = localNumberFormatException5;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _cwv param(" + str1 + ") error:" + localNumberFormatException5.getMessage());
                      continue;
                      localNumberFormatException6 = localNumberFormatException6;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser subIndex param(" + str1 + ") error:" + localNumberFormatException6.getMessage());
                    }
                    localNumberFormatException7 = localNumberFormatException7;
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser bgColor param(" + str1 + ") error:" + localNumberFormatException7.getMessage());
                  }
                  catch (NumberFormatException localNumberFormatException8)
                  {
                    for (;;)
                    {
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser titleAlpha param(" + str1 + ") error:" + localNumberFormatException8.getMessage());
                      continue;
                      this.jdField_a_of_type_Bejk.H = false;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_Beft.a(paramJSONObject, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bejk.n == paramBoolean) {}
    Object localObject;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bejk.n = paramBoolean;
      localObject = null;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
        localObject = ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarView();
      }
      while (localObject != null)
      {
        ((View)localObject).setBackgroundColor(BaseApplicationImpl.getContext().getResources().getColor(2131166959));
        if (!paramBoolean) {
          break label98;
        }
        a((View)localObject, 255, 0, 200);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
          localObject = this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidViewViewGroup;
        }
      }
    }
    label98:
    a((View)localObject, 0, 255, 200);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup == null) {}
    Object localObject;
    int i;
    label40:
    do
    {
      do
      {
        return;
        localObject = this.jdField_b_of_type_AndroidViewViewGroup;
        if (!paramBoolean) {
          break;
        }
        i = 0;
        ((ViewGroup)localObject).setVisibility(i);
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (paramInt != 0) {
          break label118;
        }
        paramInt = 2131693982;
        ((TextView)localObject).setText(paramInt);
      } while (this.jdField_a_of_type_Behr.a() == null);
      localObject = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
    } while (localObject == null);
    if (paramBoolean) {}
    for (((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density * 75.0F));; ((FrameLayout.LayoutParams)localObject).bottomMargin = 0)
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i = 8;
      break;
      label118:
      paramInt = 2131693983;
      break label40;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_Behr.a() == null) {
      return;
    }
    this.jdField_a_of_type_Beft.a((TouchWebView)this.jdField_a_of_type_Behr.a(), paramBoolean1, paramInt1, paramInt2, paramInt3, paramBoolean2, paramString1, paramString2, paramString3);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Bejk.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_Bejk.jdField_a_of_type_OrgJsonJSONObject = this.jdField_a_of_type_Beft.a(paramString);
      }
    } while ((this.jdField_a_of_type_Bejk.jdField_a_of_type_OrgJsonJSONObject == null) || (this.jdField_a_of_type_Bejk.jdField_a_of_type_OrgJsonJSONObject.length() == 0));
    if (this.jdField_a_of_type_Bejk.jdField_a_of_type_OrgJsonJSONObject.optInt("trans", -1) == 0) {
      this.jdField_a_of_type_Bejk.w = true;
    }
    if (!this.jdField_a_of_type_Bejk.w) {
      this.jdField_a_of_type_Bejk.w = this.jdField_a_of_type_Beft.a();
    }
    return true;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Behr.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Behr.a();
    this.jdField_a_of_type_Beiy = ((beiy)this.jdField_a_of_type_Behr.a().a(-2));
  }
  
  public void b(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.getStringExtra("url")))) {}
    do
    {
      Uri localUri;
      do
      {
        return;
        localObject = paramIntent.getStringExtra("url");
        localUri = Uri.parse((String)localObject);
      } while ((localUri == null) || (!localUri.isHierarchical()));
      if ("1".equals(localUri.getQueryParameter("_qStyle")))
      {
        paramIntent = new WebViewTitleStyle();
        paramIntent.jdField_b_of_type_Int = -16777216;
        paramIntent.jdField_c_of_type_Int = -1;
        paramIntent.d = -16777216;
        paramIntent.e = -16777216;
        this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
        return;
      }
      WebViewTitleStyle localWebViewTitleStyle = a((String)localObject);
      if (localWebViewTitleStyle != null)
      {
        this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = localWebViewTitleStyle;
        return;
      }
      Object localObject = b((String)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = ((WebViewTitleStyle)localObject);
        return;
      }
      paramIntent = (WebViewTitleStyle)paramIntent.getParcelableExtra("titleStyle");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
        return;
      }
      paramIntent = localUri.getHost();
      paramIntent = (WebViewTitleStyle)befg.a().a.get(paramIntent);
    } while (paramIntent == null);
    this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if (this.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidViewViewGroup != null) || (!this.jdField_a_of_type_Bejk.g));
      paramIntent = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363416);
    } while (paramIntent == null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramIntent.inflate());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363020));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366760));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    int i = (int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density * 50.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  public void b(WebView paramWebView)
  {
    if (this.jdField_a_of_type_Bejk.g)
    {
      if (!this.jdField_a_of_type_Bejk.k) {
        break label26;
      }
      a(paramWebView);
    }
    label26:
    do
    {
      return;
      boolean bool = paramWebView.canGoBack();
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(bool);
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(paramWebView.canGoForward());
  }
  
  public void b(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Bejk.g) || (this.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean)) {}
    TouchWebView localTouchWebView;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.e == paramBoolean));
      if (!paramBoolean) {
        break;
      }
      localTouchWebView = (TouchWebView)this.jdField_a_of_type_Behr.a();
    } while ((localTouchWebView != null) && (!localTouchWebView.canGoBack()) && (!localTouchWebView.canGoForward()));
    this.e = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.start();
    azqs.a(null, "dc00898", "", "", "0X8009B1E", "0X8009B1E", 0, 0, "", "", "", "");
    return;
    this.e = false;
    h();
    this.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.start();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Beft = beeq.a(this);
    this.jdField_a_of_type_Befo = befn.a(this);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Befo.a(paramBoolean);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Behr.a() != null) && (!this.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean)) {
      a((TouchWebView)this.jdField_a_of_type_Behr.a());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Beft.jdField_a_of_type_Bejk.l = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Beft.a("");
      return;
    }
    this.jdField_a_of_type_Beft.d();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bejk.r) && (!this.jdField_a_of_type_Bejk.w)) {
      this.jdField_a_of_type_Bejk.w = this.jdField_a_of_type_Beft.a();
    }
  }
  
  public void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363375);
    if (localViewStub == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378613));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void g()
  {
    ViewStub localViewStub;
    if (this.jdField_a_of_type_Bejk.q)
    {
      localViewStub = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366494);
      if (localViewStub != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = localViewStub.inflate();
    this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void h()
  {
    FrameLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Behr.a() != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
      if (localLayoutParams != null) {}
    }
    else
    {
      return;
    }
    DisplayMetrics localDisplayMetrics;
    float f;
    if (this.e)
    {
      localDisplayMetrics = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
      f = this.jdField_a_of_type_Bejk.jdField_c_of_type_Int;
    }
    for (localLayoutParams.bottomMargin = ((int)(localDisplayMetrics.density * f));; localLayoutParams.bottomMargin = 0)
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Befo.g != null) {
      this.jdField_a_of_type_Befo.g.setVisibility(0);
    }
    if ((this.jdField_a_of_type_Befo.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_Befo.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_Befo.jdField_a_of_type_AndroidViewView.getVisibility() == 4))) {
      this.jdField_a_of_type_Befo.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_Bejk.h = true;
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(2);
  }
  
  public void k()
  {
    this.jdField_a_of_type_Bejk.h = true;
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getConfiguration().orientation;
    if (QLog.isColorLevel()) {
      QLog.d("restoreOrientationFollowSenSor", 2, "--> orientation = " + i);
    }
    if (i == 1) {
      l();
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(2);
    } while (!QLog.isColorLevel());
    QLog.d("restoreOrientationFollowSenSor", 2, "--> orientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR 4");
  }
  
  public void l()
  {
    int i;
    boolean bool;
    if ((this.jdField_a_of_type_Bejk.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Bejk.jdField_a_of_type_JavaLangBoolean.booleanValue()))
    {
      i = 1;
      if (i != 0) {
        break label74;
      }
      if ((!this.jdField_a_of_type_Bejk.e) || (this.jdField_a_of_type_Bejk.h)) {
        break label69;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        break label88;
      }
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      return;
      i = 0;
      break;
      label69:
      bool = false;
      continue;
      label74:
      bool = this.jdField_a_of_type_Bejk.jdField_a_of_type_JavaLangBoolean.booleanValue();
    }
    label88:
    if (this.jdField_a_of_type_Bejk.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(-1);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      h();
    }
    while ((paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof View.OnClickListener)) {
      ((View.OnClickListener)this.jdField_a_of_type_AndroidAppActivity).onClick(paramView);
    }
    TouchWebView localTouchWebView = (TouchWebView)this.jdField_a_of_type_Behr.a();
    switch (paramView.getId())
    {
    }
    HashMap localHashMap;
    do
    {
      do
      {
        return;
      } while ((localTouchWebView == null) || (!localTouchWebView.canGoBack()));
      localTouchWebView.stopLoading();
      localTouchWebView.goBack();
      paramView = localTouchWebView.getPluginEngine();
      if (paramView != null)
      {
        localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(3));
        paramView.a(localTouchWebView.getUrl(), 8589934610L, localHashMap);
      }
      b(localTouchWebView);
      azqs.a(null, "dc00898", "", "", "0X8009B21", "0X8009B21", 0, 0, "", "", "", "");
      return;
    } while ((localTouchWebView == null) || (!localTouchWebView.canGoForward()));
    localTouchWebView.stopLoading();
    localTouchWebView.goForward();
    paramView = localTouchWebView.getPluginEngine();
    if (paramView != null)
    {
      localHashMap = new HashMap(1);
      localHashMap.put("target", Integer.valueOf(3));
      paramView.a(localTouchWebView.getUrl(), 8589934602L, localHashMap);
    }
    b(localTouchWebView);
    azqs.a(null, "dc00898", "", "", "0X8009B20", "0X8009B20", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejh
 * JD-Core Version:    0.7.0.1
 */
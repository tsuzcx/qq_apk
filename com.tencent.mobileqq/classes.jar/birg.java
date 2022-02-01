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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinEngine;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class birg
  extends bipp
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
  public binl a;
  public binq a;
  private biqx jdField_a_of_type_Biqx;
  public final birj a;
  public bjef a;
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
  
  public birg()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Birj = new birj();
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
      if ((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x20000) != 0L) {
        bdll.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 131072, 0, "", "", str, "");
      }
      if ((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x1000000) != 0L) {
        bdll.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 16777216, 0, "", "", str, "");
      }
      if ((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x2) != 0L) {
        bdll.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 2, 0, "", "", str, "");
      }
      return;
    }
    catch (Throwable paramUri)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramUri, new Object[0]);
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (!"1".equals(niz.a().a("wv_ctrl_switch", "")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserUIStyleHandler", 2, "checkWvParamAuthorize disable");
        }
      }
      else
      {
        if ((!niz.a().a(paramString2, paramString1)) && ((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & paramLong) != 0L))
        {
          paramString1 = this.jdField_a_of_type_Birj;
          paramString1.jdField_a_of_type_Long &= (0xFFFFFFFF ^ paramLong);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserUIStyleHandler", 2, new Object[] { "no authorize for wv param domain:", paramString2, " wv:", Long.valueOf(paramLong) });
          }
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserUIStyleHandler", 2, new Object[] { "checkWvParamAuthorize cost:", Long.valueOf(l2 - l1), " domain:", paramString2, " wv:", Long.valueOf(paramLong) });
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramString1, new Object[0]);
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
    return (TouchWebView)this.jdField_a_of_type_Bipq.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bipq.a() != null)
    {
      WebView localWebView = this.jdField_a_of_type_Bipq.a();
      localWebView.setId(2131381325);
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
      noe.a("Web_updateTitleBarUI");
      if (this.jdField_a_of_type_Birj.s) {
        this.jdField_a_of_type_Binq.h();
      }
      noe.b("Web_updateTitleBarUI");
      return;
    case 3: 
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        paramBundle = this.jdField_b_of_type_AndroidViewView.getParent();
        if ((paramBundle != null) && ((paramBundle instanceof ViewGroup))) {
          ((ViewGroup)paramBundle).removeView(this.jdField_b_of_type_AndroidViewView);
        }
      }
      this.jdField_a_of_type_Binq.f();
      return;
    case 4: 
      if ((this.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView != null) && (8 == this.jdField_a_of_type_Binl.jdField_c_of_type_AndroidViewView.getVisibility())) {
        this.jdField_a_of_type_Binl.a();
      }
      if (paramBundle.containsKey("Configuration")) {}
      for (paramBundle = (Configuration)paramBundle.getParcelable("Configuration"); (paramBundle != null) && (this.jdField_a_of_type_Binl.jdField_c_of_type_AndroidViewView != null) && (paramBundle.orientation == 2) && (this.jdField_a_of_type_Binl.jdField_c_of_type_AndroidViewView.getVisibility() == 0); paramBundle = null)
      {
        this.jdField_a_of_type_Binl.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
    case 6: 
      if ((!this.jdField_a_of_type_Biqx.j) && (this.jdField_a_of_type_Bjef != null) && (this.jdField_a_of_type_Bjef.b() != 0)) {
        this.jdField_a_of_type_Bjef.a((byte)0);
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
        this.jdField_a_of_type_Binq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Birj.y = true;
      }
      a(this.jdField_a_of_type_Bipq.a());
      return;
      if (this.jdField_a_of_type_Bjef != null) {
        this.jdField_a_of_type_Bjef.a((byte)2);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((this.jdField_a_of_type_Birj.D) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
        break;
      }
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Int == -1)) {
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2131167298);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Bipq.a() == null) {
        break;
      }
      localObject1 = (TouchWebView)this.jdField_a_of_type_Bipq.a();
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label566;
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
        ((TouchWebView)localObject1).setOnOverScrollHandler(new birh(this, (TouchWebView)localObject1, paramBundle));
        ((TouchWebView)localObject1).setOnScrollChangedListener(new biri(this));
        b(this.jdField_a_of_type_Bipq.a());
        return;
        label566:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    int i;
    boolean bool;
    if (((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x20000) != 0L) || (paramIntent.getBooleanExtra("isFullScreen", false)))
    {
      i = 1;
      if (i != 0) {
        this.jdField_a_of_type_Birj.jdField_a_of_type_Boolean = true;
      }
      birj localbirj = this.jdField_a_of_type_Birj;
      if (((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x1000000) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitle", false))) {
        break label696;
      }
      bool = true;
      label76:
      localbirj.jdField_b_of_type_Boolean = bool;
      localbirj = this.jdField_a_of_type_Birj;
      if (((this.jdField_a_of_type_Birj.jdField_b_of_type_Long & 1L) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitleAndClickable", false))) {
        break label701;
      }
      bool = true;
      label115:
      localbirj.m = bool;
      localbirj = this.jdField_a_of_type_Birj;
      if (((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x2) == 0L) && (!paramIntent.getBooleanExtra("hide_more_button", false))) {
        break label706;
      }
      bool = true;
      label156:
      localbirj.e = bool;
      localbirj = this.jdField_a_of_type_Birj;
      if (((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 1L) == 0L) && (!paramIntent.getBooleanExtra("hide_operation_bar", false)) && (!"noBottomBar".equals(paramIntent.getStringExtra("webStyle")))) {
        break label711;
      }
      bool = true;
      label211:
      localbirj.f = bool;
      localbirj = this.jdField_a_of_type_Birj;
      if ((this.jdField_a_of_type_Birj.jdField_b_of_type_Long & 0x100) == 0L) {
        break label716;
      }
      bool = true;
      label241:
      localbirj.o = bool;
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_params_qq")))
      {
        this.jdField_a_of_type_Birj.e = true;
        this.jdField_a_of_type_Birj.f = true;
      }
      i = paramIntent.getIntExtra("reqType", -1);
      if ((!this.jdField_a_of_type_Birj.f) && (i == 6)) {
        this.jdField_a_of_type_Birj.f = true;
      }
      this.jdField_a_of_type_Birj.g = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
      this.jdField_a_of_type_Birj.q = paramIntent.getBooleanExtra("rightTopCancel", false);
      this.jdField_a_of_type_Birj.r = paramIntent.getBooleanExtra("webViewMoveTop", false);
      if ((!this.jdField_a_of_type_Birj.e) && ((i == 3) || (i == 1) || (!paramIntent.getBooleanExtra("ba_is_login", true)) || (i == 7))) {
        this.jdField_a_of_type_Birj.e = true;
      }
      if ((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x20000) > 0L) {
        this.jdField_a_of_type_Birj.jdField_a_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x20000000) != 0L) {
        this.jdField_a_of_type_Birj.s = true;
      }
      if ((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x800) > 0L)
      {
        this.jdField_a_of_type_Birj.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Birj.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
      if ((this.jdField_a_of_type_Birj.jdField_b_of_type_Long & 0x4) > 0L)
      {
        this.jdField_a_of_type_Birj.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_Birj.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
      if ((this.jdField_a_of_type_Birj.jdField_b_of_type_Long & 0x2) > 0L) {
        this.jdField_a_of_type_Birj.h = true;
      }
      if ((this.jdField_a_of_type_Birj.jdField_b_of_type_Long & 0x200) > 0L) {
        this.jdField_a_of_type_Birj.D = true;
      }
      if ((this.jdField_a_of_type_Birj.jdField_b_of_type_Long & 0x400) > 0L)
      {
        localbirj = this.jdField_a_of_type_Birj;
        this.jdField_a_of_type_Birj.B = true;
        localbirj.E = true;
      }
      if ((this.jdField_a_of_type_Birj.jdField_b_of_type_Long & 0x2000) > 0L) {
        this.jdField_a_of_type_Birj.p = true;
      }
      if ((this.jdField_a_of_type_Birj.jdField_d_of_type_Long & 1L) > 0L) {
        this.jdField_a_of_type_Birj.jdField_b_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_Birj.jdField_d_of_type_Long & 0x8) > 0L) {
        this.jdField_a_of_type_Birj.m = true;
      }
      if (!paramIntent.getBooleanExtra("from_single_task", false)) {
        break label721;
      }
      this.jdField_a_of_type_Birj.G = true;
    }
    label696:
    label701:
    label706:
    label711:
    label716:
    label721:
    while ((this.jdField_a_of_type_Birj.jdField_a_of_type_Long & 0x80000000) <= 0L)
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
    this.jdField_a_of_type_Birj.F = niz.a().j(paramIntent.getStringExtra("url"));
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_Binq.a(paramIntent, paramString);
    a(this.jdField_a_of_type_Birj.jdField_a_of_type_OrgJsonJSONObject, false);
    d();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Binq.a(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    do
    {
      return;
      int i;
      if ((this.jdField_a_of_type_Birj.B) && (!"1000".equals(ThemeUtil.getCurrentThemeId()))) {
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
    this.jdField_a_of_type_Binq.a(paramTouchWebView);
  }
  
  @TargetApi(14)
  public void a(WebBrowserViewContainer paramWebBrowserViewContainer, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramWebBrowserViewContainer.findViewById(2131367325));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((this.jdField_a_of_type_Birj.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Birj.jdField_c_of_type_Long != 0L))
    {
      paramWebBrowserViewContainer.b(this.jdField_a_of_type_Birj.H);
      this.jdField_a_of_type_Binl.a(paramWebBrowserViewContainer, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Binl.a(this.jdField_a_of_type_AndroidAppActivity);
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Biqx.s = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373049));
    this.jdField_a_of_type_Bjef = new bjef();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Bjef);
    paramIntent = this.jdField_a_of_type_Bjef;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.a(bool);
      if ((this.jdField_a_of_type_Biqx.j) && (this.jdField_a_of_type_Bjef != null) && (this.jdField_a_of_type_Bjef.b() != 0)) {
        this.jdField_a_of_type_Bjef.a((byte)0);
      }
      noe.a("Web_qqbrowser_initView_WebViewWrapper");
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381335));
      noe.b("Web_qqbrowser_initView_WebViewWrapper");
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Biqx.m = (l2 - l1);
      if (!this.jdField_a_of_type_Birj.D)
      {
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363681);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363682));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378469));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        if ((this.jdField_a_of_type_Birj.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))) {
          ((ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();
        }
      }
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131376445));
      }
      if ((this.jdField_a_of_type_Birj.C) && (this.jdField_c_of_type_AndroidViewView != null)) {
        this.jdField_c_of_type_AndroidViewView.setPadding(0, (int)bhmg.a(BaseApplicationImpl.getContext(), 30.0F), 0, 0);
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
      if (this.jdField_a_of_type_Binq != null) {
        this.jdField_a_of_type_Binq.b();
      }
      return;
    }
  }
  
  public void a(WebView paramWebView)
  {
    if (this.jdField_a_of_type_Birj.g)
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
    Uri localUri = Uri.parse(paramString);
    String str;
    if (localUri.isHierarchical())
    {
      str = localUri.getQueryParameter("_wv");
      if (str == null) {}
    }
    try
    {
      this.jdField_a_of_type_Birj.jdField_a_of_type_Long = Long.parseLong(str, 10);
      a("ui.wvHideActionBtn", paramString, 2L);
      a("ui.wvFullScreen", paramString, 131072L);
      a("ui.wvTransparentTitle", paramString, 16777216L);
      paramString = localUri.getQueryParameter("_fv");
      if (paramString == null) {}
    }
    catch (NumberFormatException localNumberFormatException6)
    {
      try
      {
        this.jdField_a_of_type_Birj.jdField_c_of_type_Long = Long.parseLong(paramString, 10);
        paramString = localUri.getQueryParameter("_fu");
        this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean = false;
        if (paramString == null) {}
      }
      catch (NumberFormatException localNumberFormatException6)
      {
        try
        {
          if (Long.parseLong(paramString) == 2019L) {
            this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean = true;
          }
          paramString = localUri.getQueryParameter("_wwv");
          if (paramString == null) {}
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          try
          {
            this.jdField_a_of_type_Birj.jdField_b_of_type_Long = Long.parseLong(paramString, 10);
            str = localUri.getQueryParameter("_cwv");
            if (str == null) {}
          }
          catch (NumberFormatException localNumberFormatException6)
          {
            try
            {
              this.jdField_a_of_type_Birj.jdField_d_of_type_Long = Long.parseLong(str, 10);
              paramString = localUri.getQueryParameter("channel");
              if (!TextUtils.isEmpty(paramString)) {
                this.jdField_a_of_type_Birj.jdField_a_of_type_JavaLangString = URLDecoder.decode(paramString);
              }
              paramString = localUri.getQueryParameter("subIndex");
              if (TextUtils.isEmpty(paramString)) {}
            }
            catch (NumberFormatException localNumberFormatException6)
            {
              try
              {
                this.jdField_a_of_type_Birj.jdField_a_of_type_Int = Integer.parseInt(paramString.trim());
                paramString = localUri.getQueryParameter("bgColor");
                if (TextUtils.isEmpty(paramString)) {}
              }
              catch (NumberFormatException localNumberFormatException6)
              {
                try
                {
                  this.jdField_b_of_type_Int = ((int)Long.parseLong(paramString, 16));
                  paramString = localUri.getQueryParameter("titleAlpha");
                  if (TextUtils.isEmpty(paramString)) {}
                }
                catch (NumberFormatException localNumberFormatException6)
                {
                  try
                  {
                    for (;;)
                    {
                      this.jdField_a_of_type_Birj.jdField_b_of_type_Int = Integer.parseInt(paramString.trim());
                      paramString = localUri.getAuthority();
                      if ((TextUtils.isEmpty(paramString)) || (!paramString.endsWith("urlshare.cn"))) {
                        break;
                      }
                      this.jdField_a_of_type_Birj.H = true;
                      a(localUri);
                      return;
                      localNumberFormatException8 = localNumberFormatException8;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wv param(" + str + ") error:" + localNumberFormatException8.getMessage());
                      continue;
                      localNumberFormatException1 = localNumberFormatException1;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + paramString + ") error:" + localNumberFormatException1.getMessage());
                      continue;
                      localNumberFormatException2 = localNumberFormatException2;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + paramString + ") error:" + localNumberFormatException2.getMessage());
                      continue;
                      localNumberFormatException3 = localNumberFormatException3;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wwv param(" + paramString + ") error:" + localNumberFormatException3.getMessage());
                      continue;
                      localNumberFormatException4 = localNumberFormatException4;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _cwv param(" + paramString + ") error:" + localNumberFormatException4.getMessage());
                      continue;
                      localNumberFormatException5 = localNumberFormatException5;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser subIndex param(" + paramString + ") error:" + localNumberFormatException5.getMessage());
                    }
                    localNumberFormatException6 = localNumberFormatException6;
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser bgColor param(" + paramString + ") error:" + localNumberFormatException6.getMessage());
                  }
                  catch (NumberFormatException localNumberFormatException7)
                  {
                    for (;;)
                    {
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser titleAlpha param(" + paramString + ") error:" + localNumberFormatException7.getMessage());
                      continue;
                      this.jdField_a_of_type_Birj.H = false;
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
    this.jdField_a_of_type_Binq.a(paramJSONObject, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Birj.n == paramBoolean) {}
    Object localObject;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Birj.n = paramBoolean;
      localObject = null;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
        localObject = ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarView();
      }
      while (localObject != null)
      {
        ((View)localObject).setBackgroundColor(BaseApplicationImpl.getContext().getResources().getColor(2131167048));
        if (!paramBoolean) {
          break label98;
        }
        a((View)localObject, 255, 0, 200);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
          localObject = this.jdField_a_of_type_Binq.jdField_a_of_type_AndroidViewViewGroup;
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
        paramInt = 2131693293;
        ((TextView)localObject).setText(paramInt);
      } while (this.jdField_a_of_type_Bipq.a() == null);
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
      paramInt = 2131693294;
      break label40;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_Bipq.a() == null) {
      return;
    }
    this.jdField_a_of_type_Binq.a((TouchWebView)this.jdField_a_of_type_Bipq.a(), paramBoolean1, paramInt1, paramInt2, paramInt3, paramBoolean2, paramString1, paramString2, paramString3);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Birj.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_Birj.jdField_a_of_type_OrgJsonJSONObject = this.jdField_a_of_type_Binq.a(paramString);
      }
    } while ((this.jdField_a_of_type_Birj.jdField_a_of_type_OrgJsonJSONObject == null) || (this.jdField_a_of_type_Birj.jdField_a_of_type_OrgJsonJSONObject.length() == 0));
    if (this.jdField_a_of_type_Birj.jdField_a_of_type_OrgJsonJSONObject.optInt("trans", -1) == 0) {
      this.jdField_a_of_type_Birj.w = true;
    }
    if (!this.jdField_a_of_type_Birj.w) {
      this.jdField_a_of_type_Birj.w = this.jdField_a_of_type_Binq.a();
    }
    return true;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Bipq.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Bipq.a();
    this.jdField_a_of_type_Biqx = ((biqx)this.jdField_a_of_type_Bipq.a().a(-2));
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
        this.jdField_a_of_type_Birj.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
        return;
      }
      WebViewTitleStyle localWebViewTitleStyle = a((String)localObject);
      if (localWebViewTitleStyle != null)
      {
        this.jdField_a_of_type_Birj.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = localWebViewTitleStyle;
        return;
      }
      Object localObject = b((String)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_Birj.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = ((WebViewTitleStyle)localObject);
        return;
      }
      paramIntent = (WebViewTitleStyle)paramIntent.getParcelableExtra("titleStyle");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Birj.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
        return;
      }
      paramIntent = localUri.getHost();
      paramIntent = (WebViewTitleStyle)bind.a().a.get(paramIntent);
    } while (paramIntent == null);
    this.jdField_a_of_type_Birj.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if (this.jdField_a_of_type_Birj.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidViewViewGroup != null) || (!this.jdField_a_of_type_Birj.g));
      paramIntent = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363634);
    } while (paramIntent == null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramIntent.inflate());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363229));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367078));
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
    if (this.jdField_a_of_type_Birj.g)
    {
      if (!this.jdField_a_of_type_Birj.k) {
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
    if ((!this.jdField_a_of_type_Birj.g) || (this.jdField_a_of_type_Birj.jdField_a_of_type_Boolean)) {}
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
      localTouchWebView = (TouchWebView)this.jdField_a_of_type_Bipq.a();
    } while ((localTouchWebView != null) && (!localTouchWebView.canGoBack()) && (!localTouchWebView.canGoForward()));
    this.e = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.start();
    bdll.a(null, "dc00898", "", "", "0X8009B1E", "0X8009B1E", 0, 0, "", "", "", "");
    return;
    this.e = false;
    h();
    this.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.start();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Binq = bimn.a(this);
    this.jdField_a_of_type_Binl = bink.a(this);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Binl.a(paramBoolean);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bipq.a() != null) && (!this.jdField_a_of_type_Birj.jdField_a_of_type_Boolean)) {
      a((TouchWebView)this.jdField_a_of_type_Bipq.a());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Binq.jdField_a_of_type_Birj.l = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Binq.a("");
      return;
    }
    this.jdField_a_of_type_Binq.d();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Birj.r) && (!this.jdField_a_of_type_Birj.w)) {
      this.jdField_a_of_type_Birj.w = this.jdField_a_of_type_Binq.a();
    }
  }
  
  public void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363592);
    if (localViewStub == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379631));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void g()
  {
    ViewStub localViewStub;
    if (this.jdField_a_of_type_Birj.q)
    {
      localViewStub = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366810);
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
    if ((this.jdField_a_of_type_Bipq.a() != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
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
      f = this.jdField_a_of_type_Birj.jdField_c_of_type_Int;
    }
    for (localLayoutParams.bottomMargin = ((int)(localDisplayMetrics.density * f));; localLayoutParams.bottomMargin = 0)
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Binl.g != null) {
      this.jdField_a_of_type_Binl.g.setVisibility(0);
    }
    if ((this.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView.getVisibility() == 4))) {
      this.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_Birj.h = true;
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(2);
  }
  
  public void k()
  {
    this.jdField_a_of_type_Birj.h = true;
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
    if ((this.jdField_a_of_type_Birj.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Birj.jdField_a_of_type_JavaLangBoolean.booleanValue()))
    {
      i = 1;
      if (i != 0) {
        break label74;
      }
      if ((!this.jdField_a_of_type_Birj.e) || (this.jdField_a_of_type_Birj.h)) {
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
      bool = this.jdField_a_of_type_Birj.jdField_a_of_type_JavaLangBoolean.booleanValue();
    }
    label88:
    if (this.jdField_a_of_type_Birj.jdField_d_of_type_Boolean)
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
    TouchWebView localTouchWebView = (TouchWebView)this.jdField_a_of_type_Bipq.a();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localTouchWebView != null) && (localTouchWebView.canGoBack()))
      {
        localTouchWebView.stopLoading();
        localTouchWebView.goBack();
        WebViewPluginEngine localWebViewPluginEngine = localTouchWebView.getPluginEngine();
        HashMap localHashMap;
        if (localWebViewPluginEngine != null)
        {
          localHashMap = new HashMap(1);
          localHashMap.put("target", Integer.valueOf(3));
          localWebViewPluginEngine.a(localTouchWebView.getUrl(), 8589934610L, localHashMap);
        }
        b(localTouchWebView);
        bdll.a(null, "dc00898", "", "", "0X8009B21", "0X8009B21", 0, 0, "", "", "", "");
        continue;
        if ((localTouchWebView != null) && (localTouchWebView.canGoForward()))
        {
          localTouchWebView.stopLoading();
          localTouchWebView.goForward();
          localWebViewPluginEngine = localTouchWebView.getPluginEngine();
          if (localWebViewPluginEngine != null)
          {
            localHashMap = new HashMap(1);
            localHashMap.put("target", Integer.valueOf(3));
            localWebViewPluginEngine.a(localTouchWebView.getUrl(), 8589934602L, localHashMap);
          }
          b(localTouchWebView);
          bdll.a(null, "dc00898", "", "", "0X8009B20", "0X8009B20", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birg
 * JD-Core Version:    0.7.0.1
 */
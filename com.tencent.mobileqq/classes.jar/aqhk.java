import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public final class aqhk
  extends bcaz
  implements TouchWebView.OnScrollChangedListener
{
  public int a;
  public boolean a;
  public boolean b;
  boolean c = false;
  
  public aqhk(CommonTabFragment paramCommonTabFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      mvs.a();
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) {
        this.mUrl = this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.tabUrl;
      }
      if (!TextUtils.isEmpty(this.mUrl)) {
        if (!this.mUrl.contains("?")) {
          break label351;
        }
      }
      label351:
      for (this.mUrl += "&";; this.mUrl += "?")
      {
        this.mUrl += this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_JavaLangString;
        this.mWebview = new TouchWebView(this.mContext);
        buildBaseWebView(this.mInterface);
        this.c = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
        if (this.c) {
          this.mWebview.setMask(true);
        }
        this.mWebview.setBackgroundColor(-1);
        this.mWebview.setOnScrollChangedListener(this);
        setmTimeBeforeLoadUrl(System.currentTimeMillis());
        if (QLog.isDevelopLevel()) {
          atbr.a("WebSpeedTrace", "mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.mTimeBeforeLoadUrl) });
        }
        this.mWebview.loadUrl(this.mUrl);
        if (QLog.isColorLevel()) {
          atbr.a("AbsWebView", new Object[] { "HotChatWebView.init", this.mUrl });
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k != 0L)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k = (System.currentTimeMillis() - l);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        atbr.a("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k) });
        return;
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.doOnCreate(paramIntent);
  }
  
  public void b()
  {
    super.doOnResume();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList.add(new bcim());
    }
  }
  
  public void c()
  {
    super.doOnPause();
  }
  
  public void d()
  {
    super.doOnDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_Aqjw != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_Aqjw.b(false).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_Aqjw.a();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.b = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_Aqjw != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_Aqjw.b(true).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_Aqjw.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.b != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.b.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.b.setVisibility(8);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.mWebview != null) {
      this.jdField_a_of_type_Int = this.mWebview.getWebScrollY();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqhk
 * JD-Core Version:    0.7.0.1
 */
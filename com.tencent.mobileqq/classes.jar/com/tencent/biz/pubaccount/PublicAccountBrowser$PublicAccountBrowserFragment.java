package com.tencent.biz.pubaccount;

import akxe;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import aohr;
import bdll;
import bhlq;
import bhmg;
import bhnv;
import bhpc;
import binq;
import bipn;
import biqq;
import birg;
import birj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import niz;
import noe;
import oar;
import oas;
import oat;
import oau;
import ocd;
import tzq;
import zyx;

public class PublicAccountBrowser$PublicAccountBrowserFragment
  extends WebViewFragment
{
  private int a;
  protected Bundle a;
  protected String a;
  protected boolean a;
  protected boolean b = true;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  
  public PublicAccountBrowser$PublicAccountBrowserFragment()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramString.startsWith("qqnews://")) {
      localObject1 = "即将离开\"QQ\"\r\n打开" + "\"腾讯新闻\"";
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return localObject1;
                        if ((paramString.startsWith("tenvideo://")) || (paramString.startsWith("tenvideo2://")) || (paramString.startsWith("tenvideo3://")) || (paramString.startsWith("tencent1004498506://"))) {
                          return "即将离开\"QQ\"\r\n打开" + "\"腾讯视频\"";
                        }
                        if (paramString.startsWith("mttbrowser://")) {
                          return "即将离开\"QQ\"\r\n打开" + "\"QQ浏览器\"";
                        }
                        if (paramString.startsWith("qnreading://")) {
                          return "即将离开\"QQ\"\r\n打开" + "\"天天快报\"";
                        }
                        if ((paramString.startsWith("weishiandroidscheme://")) || (paramString.startsWith("weishi://"))) {
                          return "即将离开\"QQ\"\r\n打开" + "\"微视\"";
                        }
                        if (paramString.startsWith("tnow://")) {
                          return "即将离开\"QQ\"\r\n打开" + "\"NOW直播\"";
                        }
                        localObject1 = localObject2;
                      } while (paramString.startsWith("sms://"));
                      localObject1 = localObject2;
                    } while (paramString.startsWith("tel://"));
                    localObject1 = localObject2;
                  } while (paramString.startsWith("tel://"));
                  localObject1 = localObject2;
                } while (paramString.startsWith("mailto://"));
                localObject1 = localObject2;
              } while (paramString.startsWith("file://"));
              localObject1 = localObject2;
            } while (paramString.startsWith("ftp://"));
            localObject1 = localObject2;
          } while (paramString.startsWith("mqqapi://"));
          localObject1 = localObject2;
        } while (paramString.startsWith("http://"));
        localObject1 = localObject2;
      } while (paramString.startsWith("https://"));
      localObject1 = localObject2;
    } while (paramString.indexOf("://") == -1);
    return "即将离开\"QQ\"\r\n打开" + anzj.a(2131707662);
  }
  
  private void a()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidOsBundle = this.intent.getExtras();
    this.uin = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin_name");
    this.uinType = this.jdField_a_of_type_AndroidOsBundle.getInt("uin_type");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("token");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewFragment", 2, "url not found, use \"\" default");
      }
      localObject1 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "get a url:" + noe.b((String)localObject1, new String[0]));
    }
    localObject2 = localObject1;
    if (((String)localObject1).startsWith("http://browserApp.p.qq.com/"))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("?")) {
        localObject2 = (String)localObject1 + "?";
      }
      localObject2 = (String)localObject2 + "&openid=" + str1 + "&token=" + str2;
      this.intent.putExtra("url", (String)localObject2);
    }
    localObject1 = Uri.parse((String)localObject2);
    if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()))
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("_wv");
      if (localObject1 == null) {}
    }
    try
    {
      this.mUIStyle.jdField_a_of_type_Long = Long.parseLong(((String)localObject1).trim());
      this.mUIStyleHandler.a.jdField_a_of_type_Long = this.mUIStyle.jdField_a_of_type_Long;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("call_from");
      this.intent.removeExtra("call_from");
      this.publicUin = this.jdField_a_of_type_AndroidOsBundle.getString("puin");
      this.msgid = this.jdField_a_of_type_AndroidOsBundle.getString("msg_id");
      if (this.msgid == null) {
        this.msgid = "";
      }
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hide_operation_bar"))
      {
        bool1 = true;
        this.b = bool1;
        if ((!((String)localObject2).startsWith("http://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("http://s.p.qq.com/pub/show"))) {
          break label671;
        }
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
        if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("hide_operation_bar"))
        {
          if (this.jdField_a_of_type_Boolean) {
            break label676;
          }
          bool1 = true;
          this.b = bool1;
          localObject1 = this.intent;
          if (this.b) {
            break label681;
          }
          bool1 = true;
          ((Intent)localObject1).putExtra("hide_operation_bar", bool1);
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("webStyle");
        if ((localObject1 != null) && (((String)localObject1).equals("noBottomBar"))) {
          this.b = false;
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("disableshare");
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hideRightButton", false))
        {
          bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (!((String)localObject1).equals("true")) {}
          }
        }
        else
        {
          bool1 = true;
        }
        this.c = bool1;
        localObject1 = (biqq)this.mComponentsProvider.a(4);
        if ((!this.c) && ((this.mUIStyle.jdField_a_of_type_Long & 0x2378) == 9080L) && (!((biqq)localObject1).a())) {
          this.c = true;
        }
        localObject1 = localObject2;
        if (tzq.f((String)localObject2)) {
          localObject1 = tzq.a((String)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 1, "initParams url = " + (String)localObject1);
        }
        this.intent.putExtra("url", (String)localObject1);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool1;
        if (QLog.isDevelopLevel())
        {
          QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
          continue;
          bool1 = false;
          continue;
          label671:
          bool1 = false;
          continue;
          label676:
          bool1 = false;
          continue;
          label681:
          bool1 = false;
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if ((this.mApp != null) && (!bhnv.d(this.mApp.getApplication()))) {
      QQToast.a(this.mApp.getApplication(), 2131693963, 0).b(super.getTitleBarHeight());
    }
    if (!this.mUIStyleHandler.a.jdField_a_of_type_Boolean)
    {
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("assignBackText");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      }
      if (this.c) {
        break label206;
      }
      this.mSwiftTitleUI.c.setText("");
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840295);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(super.getText(2131692394));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1001)
      {
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.mSwiftTitleUI.c.setText(anzj.a(2131707618));
        this.mSwiftTitleUI.c.setOnClickListener(this);
        this.mSwiftTitleUI.c.setVisibility(0);
      }
      return;
      label206:
      this.mSwiftTitleUI.c.setVisibility(8);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      int i = (int)bhmg.a(BaseApplicationImpl.getApplication(), 8.0F);
      if (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).setMargins(i, 0, i, 0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = getShareUrl();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.mUrl;
    }
    if (TextUtils.isEmpty(this.publicUin)) {
      return;
    }
    localObject1 = "";
    Object localObject3 = Uri.parse((String)localObject2);
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
      bdll.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    default: 
    case 7: 
      ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1010, 0, this.publicUin, (String)localObject2, this.msgid, (String)localObject3, false);
      return;
    }
  }
  
  public void a(Context paramContext, Uri paramUri, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
    localIntent.addFlags(268435456);
    try
    {
      ActivityInfo localActivityInfo = localIntent.resolveActivityInfo(getActivity().getPackageManager(), 0);
      paramUri = "";
      if (localActivityInfo != null) {
        paramUri = localActivityInfo.packageName;
      }
      aohr.a("scheme", paramString, paramUri, "1", "web", getActivity().getClass().getName());
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("WebLog_WebViewFragment", 1, "afterWebViewEngineHandleOverrideUrl error!", paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramContext = bhlq.a(paramContext, 230, null, paramString3, anzj.a(2131707660), anzj.a(2131707639), new oat(this, paramContext, paramUri, paramString1, paramString4), new oau(this, paramString4));
      paramContext.show();
      paramContext.setCancelable(false);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(DialogInterface paramDialogInterface, boolean paramBoolean, String paramString)
  {
    paramDialogInterface.dismiss();
    if (!paramBoolean) {
      if (this.mApp != null) {
        bdll.b(null, "dc01160", "Pb_account_lifeservice", this.mApp.getCurrentAccountUin(), "0X80090F3", "0X80090F3", 0, 0, "", "", "", paramString);
      }
    }
    while (this.mApp == null) {
      return;
    }
    bdll.b(null, "dc01160", "Pb_account_lifeservice", this.mApp.getCurrentAccountUin(), "0X80090F4", "0X80090F4", 0, 0, "", "", "", paramString);
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.publicUin;
    }
    if (str != null)
    {
      paramString = new Intent(super.getActivity(), AccountDetailActivity.class);
      paramString.putExtra("uin", str);
      paramString.putExtra("source", 111);
      super.startActivity(paramString);
    }
  }
  
  public void activityFinish()
  {
    super.activityFinish();
    if (this.jdField_a_of_type_Int == 1001) {
      ThreadManager.executeOnSubThread(new PublicAccountBrowser.PublicAccountBrowserFragment.5(this));
    }
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getScheme();
    if ((super.getActivity().isResume()) && ((System.currentTimeMillis() - this.mLastTouchTime < 1000L) || (this.authConfig.a(paramWebView.getUrl(), str).booleanValue())))
    {
      long l = System.currentTimeMillis();
      boolean bool = akxe.a().a(paramString, this);
      QLog.i("WebLog_WebViewFragment", 1, "TryPayIntercept result:" + bool + " cost:" + (System.currentTimeMillis() - l) + " ms.");
      if (!bool) {}
    }
    else
    {
      return true;
    }
    if ("2909288299".equalsIgnoreCase(this.publicUin))
    {
      paramString = a(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        paramWebView = paramWebView.getUrl();
        a(getActivity(), paramWebView, localUri, "QQ", paramString, this.publicUin);
        return true;
      }
    }
    a(getActivity(), localUri, paramWebView.getUrl());
    return true;
  }
  
  public bipn createComponentsProvider()
  {
    return new bipn(this, 127, new oas(this));
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if ((this.intent.getIntExtra("reqType", -1) == 5) && (!this.mUIStyleHandler.a.jdField_a_of_type_Boolean))
    {
      oar localoar = new oar(this);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localoar);
      this.mSwiftTitleUI.c.setText(2131691700);
      this.mSwiftTitleUI.c.setOnClickListener(localoar);
    }
    a(paramBundle);
    return i;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    a();
    return super.doOnCreate(paramBundle);
  }
  
  public String getUAMark()
  {
    return "PA";
  }
  
  public void initFinish()
  {
    if ((this.mUrl != null) && (this.mApp != null) && (this.authConfig != null) && (!TextUtils.isEmpty(this.publicUin)) && (!TextUtils.isEmpty(this.authConfig.a(this.mUrl)))) {
      this.mUrl = Uri.parse(this.mUrl).buildUpon().appendQueryParameter("puin", this.publicUin).appendQueryParameter("uin", this.mApp.getAccount()).toString();
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == -8) {
      zyx.a(1, 2131694654);
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "shouldOverride: " + noe.b(paramString, new String[0]));
    }
    Object localObject = paramWebView.getUrl();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).startsWith("http://s.p.qq.com/pub/jump"))) {}
    for (int i = 1; (this.b) || (!this.jdField_a_of_type_Boolean) || (i != 0); i = 0)
    {
      this.e = false;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("https://www.urlshare.cn/")))
      {
        localObject = getActivity();
        if ((localObject instanceof PublicAccountBrowser)) {
          PublicAccountBrowser.a((PublicAccountBrowser)localObject, paramString);
        }
      }
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    if (!this.d)
    {
      paramWebView = new Intent(super.getActivity(), PublicAccountBrowser.class);
      if (this.mApp != null) {
        paramWebView.putExtra("uin", this.mApp.getCurrentAccountUin());
      }
      paramWebView.putExtra("url", paramString);
      super.startActivity(paramWebView);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment
 * JD-Core Version:    0.7.0.1
 */
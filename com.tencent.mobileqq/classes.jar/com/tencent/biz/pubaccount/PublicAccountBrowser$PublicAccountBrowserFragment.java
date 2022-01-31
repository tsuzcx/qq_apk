package com.tencent.biz.pubaccount;

import aiuv;
import alud;
import amcw;
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
import azqs;
import bdgm;
import bdgz;
import bdin;
import bdjz;
import beft;
import beho;
import beir;
import bejh;
import bejk;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import myl;
import ndq;
import nqk;
import nql;
import nqm;
import nqn;
import nrt;
import syb;
import ybk;

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
    return "即将离开\"QQ\"\r\n打开" + alud.a(2131709177);
  }
  
  private void a(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (!bdin.d(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication()))) {
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 2131694766, 0).b(super.b());
    }
    if (!this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean)
    {
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("assignBackText");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      }
      if (this.c) {
        break label201;
      }
      this.jdField_a_of_type_Beft.c.setText("");
      this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840106);
      this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(super.getText(2131692826));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1001)
      {
        this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Beft.c.setText(alud.a(2131709133));
        this.jdField_a_of_type_Beft.c.setOnClickListener(this);
        this.jdField_a_of_type_Beft.c.setVisibility(0);
      }
      return;
      label201:
      this.jdField_a_of_type_Beft.c.setVisibility(8);
      this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      int i = (int)bdgz.a(BaseApplicationImpl.getApplication(), 8.0F);
      if (this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).setMargins(i, 0, i, 0);
      }
    }
  }
  
  private void i()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin_name");
    this.h = this.jdField_a_of_type_AndroidOsBundle.getInt("uin_type");
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
      QLog.d("WebLog_WebViewFragment", 2, "get a url:" + ndq.b((String)localObject1, new String[0]));
    }
    localObject2 = localObject1;
    if (((String)localObject1).startsWith("http://browserApp.p.qq.com/"))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("?")) {
        localObject2 = (String)localObject1 + "?";
      }
      localObject2 = (String)localObject2 + "&openid=" + str1 + "&token=" + str2;
      this.jdField_a_of_type_AndroidContentIntent.putExtra("url", (String)localObject2);
    }
    localObject1 = Uri.parse((String)localObject2);
    if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()))
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("_wv");
      if (localObject1 == null) {}
    }
    try
    {
      this.jdField_a_of_type_Bejk.jdField_a_of_type_Long = Long.parseLong(((String)localObject1).trim());
      this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.jdField_a_of_type_Long = this.jdField_a_of_type_Bejk.jdField_a_of_type_Long;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("call_from");
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("call_from");
      this.i = this.jdField_a_of_type_AndroidOsBundle.getString("puin");
      this.j = this.jdField_a_of_type_AndroidOsBundle.getString("msg_id");
      if (this.j == null) {
        this.j = "";
      }
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hide_operation_bar"))
      {
        bool1 = true;
        this.b = bool1;
        if ((!((String)localObject2).startsWith("http://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("http://s.p.qq.com/pub/show"))) {
          break label696;
        }
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
        if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("hide_operation_bar"))
        {
          if (this.jdField_a_of_type_Boolean) {
            break label701;
          }
          bool1 = true;
          this.b = bool1;
          localObject1 = this.jdField_a_of_type_AndroidContentIntent;
          if (this.b) {
            break label706;
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
        localObject1 = (beir)this.jdField_a_of_type_Beho.a(4);
        if ((!this.c) && ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x2378) == 9080L) && (!((beir)localObject1).a())) {
          this.c = true;
        }
        localObject1 = localObject2;
        if (syb.f((String)localObject2)) {
          localObject1 = syb.a((String)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 1, "initParams url = " + (String)localObject1);
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", (String)localObject1);
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
          label696:
          bool1 = false;
          continue;
          label701:
          bool1 = false;
          continue;
          label706:
          bool1 = false;
        }
      }
    }
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if ((this.jdField_a_of_type_AndroidContentIntent.getIntExtra("reqType", -1) == 5) && (!this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean))
    {
      nqk localnqk = new nqk(this);
      this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localnqk);
      this.jdField_a_of_type_Beft.c.setText(2131692040);
      this.jdField_a_of_type_Beft.c.setOnClickListener(localnqk);
    }
    a(paramBundle);
    return i;
  }
  
  public beho a()
  {
    return new beho(this, 127, new nql(this));
  }
  
  public String a()
  {
    return "PA";
  }
  
  public void a()
  {
    if ((this.g != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_Myl != null) && (!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Myl.a(this.g)))) {
      this.g = Uri.parse(this.g).buildUpon().appendQueryParameter("puin", this.i).appendQueryParameter("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).toString();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = f();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.g;
    }
    if (TextUtils.isEmpty(this.i)) {
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
      azqs.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    default: 
    case 7: 
      nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1010, 0, this.i, (String)localObject2, this.j, (String)localObject3, false);
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
      amcw.a("scheme", paramString, paramUri, "1", "web", getActivity().getClass().getName());
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
      paramContext = bdgm.a(paramContext, 230, null, paramString3, alud.a(2131709175), alud.a(2131709154), new nqm(this, paramContext, paramUri, paramString1, paramString4), new nqn(this, paramString4));
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
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        azqs.b(null, "dc01160", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X80090F3", "0X80090F3", 0, 0, "", "", "", paramString);
      }
    }
    while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    azqs.b(null, "dc01160", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X80090F4", "0X80090F4", 0, 0, "", "", "", paramString);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == -8) {
      ybk.a(1, 2131695724);
    }
    super.a(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.i;
    }
    if (str != null)
    {
      paramString = new Intent(super.getActivity(), AccountDetailActivity.class);
      paramString.putExtra("uin", str);
      paramString.putExtra("source", 111);
      super.startActivity(paramString);
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    i();
    return super.a(paramBundle);
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getScheme();
    if ((super.getActivity().isResume()) && ((System.currentTimeMillis() - this.jdField_e_of_type_Long < 1000L) || (this.jdField_a_of_type_Myl.a(paramWebView.getUrl(), str).booleanValue())))
    {
      long l = System.currentTimeMillis();
      boolean bool = aiuv.a().a(paramString, this);
      QLog.i("WebLog_WebViewFragment", 1, "TryPayIntercept result:" + bool + " cost:" + (System.currentTimeMillis() - l) + " ms.");
      if (!bool) {}
    }
    else
    {
      return true;
    }
    if ("2909288299".equalsIgnoreCase(this.i))
    {
      paramString = a(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        paramWebView = paramWebView.getUrl();
        a(getActivity(), paramWebView, localUri, "QQ", paramString, this.i);
        return true;
      }
    }
    a(getActivity(), localUri, paramWebView.getUrl());
    return true;
  }
  
  public boolean b(WebView paramWebView, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {
      return super.b(paramWebView, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "shouldOverride: " + ndq.b(paramString, new String[0]));
    }
    Object localObject = paramWebView.getUrl();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).startsWith("http://s.p.qq.com/pub/jump"))) {}
    for (int i = 1; (this.b) || (!this.jdField_a_of_type_Boolean) || (i != 0); i = 0)
    {
      this.jdField_e_of_type_Boolean = false;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("https://www.urlshare.cn/")))
      {
        localObject = getActivity();
        if ((localObject instanceof PublicAccountBrowser)) {
          PublicAccountBrowser.c((PublicAccountBrowser)localObject, paramString);
        }
      }
      return super.b(paramWebView, paramString);
    }
    if (!this.d)
    {
      paramWebView = new Intent(super.getActivity(), PublicAccountBrowser.class);
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        paramWebView.putExtra("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      }
      paramWebView.putExtra("url", paramString);
      super.startActivity(paramWebView);
      return true;
    }
    return super.b(paramWebView, paramString);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Int == 1001) {
      ThreadManager.executeOnSubThread(new PublicAccountBrowser.PublicAccountBrowserFragment.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment
 * JD-Core Version:    0.7.0.1
 */
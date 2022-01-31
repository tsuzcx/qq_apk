package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import pam;
import pan;
import pao;
import pap;
import paq;
import par;

public class PubAccountUIPlugin
  extends WebViewPlugin
  implements View.OnClickListener
{
  public static int b;
  public static int c;
  public static int d = 10002;
  public static int e = 10003;
  public static int f = 10004;
  public static int g = 5;
  public int a;
  public ViewGroup a;
  private PubAccountUIPlugin.PAArticleInfo jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  public boolean a;
  public ViewGroup b;
  public boolean b;
  boolean c;
  
  static
  {
    jdField_b_of_type_Int = 10000;
    jdField_c_of_type_Int = 10001;
  }
  
  public PubAccountUIPlugin()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 40;
    this.mPluginNameSpace = "pubAccountUI";
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.size();
    return (i - ViewUtils.a(12.0F) * 2 - ViewUtils.a(24.0F) * j) / (j - 1);
  }
  
  private static String a(int paramInt)
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", "click");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("btnId", paramInt);
      ((JSONObject)localObject2).put("data", localJSONObject);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PubAccountUIPlugin", 2, "getClickBottomBarCallBackResult json error!");
    }
    return localObject1;
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo = new PubAccountUIPlugin.PAArticleInfo();
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_b_of_type_Boolean) {}
    for (this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_Int = -16777216;; this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_Int = -1)
    {
      PubAccountUIPlugin.PAArticleButton localPAArticleButton = new PubAccountUIPlugin.PAArticleButton();
      localPAArticleButton.jdField_a_of_type_Int = 10000;
      this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.add(localPAArticleButton);
      return;
    }
  }
  
  private void a(PubAccountUIPlugin.PAArticleButton paramPAArticleButton, int paramInt)
  {
    Object localObject1 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.a(24.0F), ViewUtils.a(24.0F));
    if ((paramPAArticleButton.jdField_a_of_type_JavaLangString != null) || (!TextUtils.isEmpty(paramPAArticleButton.jdField_a_of_type_JavaLangString)))
    {
      Object localObject2 = new ColorDrawable(Color.parseColor("#dddfe2"));
      localObject2 = URLDrawable.getDrawable(paramPAArticleButton.jdField_a_of_type_JavaLangString, ViewUtils.a(24.0F), ViewUtils.a(24.0F), (Drawable)localObject2, (Drawable)localObject2, true);
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if (paramInt != 0) {
        break label592;
      }
      localLayoutParams.leftMargin = 0;
      label121:
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(15);
      ((URLImageView)localObject1).setLayoutParams(localLayoutParams);
      ((URLImageView)localObject1).setTag(paramPAArticleButton);
      ((URLImageView)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
      if ((paramPAArticleButton.jdField_b_of_type_JavaLangString != null) && (paramInt != this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.size() - 1))
      {
        localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        localObject2 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (localLayoutParams.leftMargin + ViewUtils.a(27.0F));
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(9);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        ((TextView)localObject1).setGravity(16);
        ((TextView)localObject1).setText(paramPAArticleButton.jdField_b_of_type_JavaLangString);
        if (paramPAArticleButton.jdField_b_of_type_Int == 0) {
          break label611;
        }
        ((TextView)localObject1).setTextColor(paramPAArticleButton.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setTextSize(11.0F);
      ((TextView)localObject1).setTag(paramPAArticleButton);
      ((TextView)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
      do
      {
        return;
        if (paramPAArticleButton.jdField_a_of_type_Int == jdField_b_of_type_Int)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839663));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839662));
          break;
        }
        if (paramPAArticleButton.jdField_a_of_type_Int == jdField_c_of_type_Int)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839665));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839664));
          break;
        }
        if (paramPAArticleButton.jdField_a_of_type_Int == d)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839672));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839671));
          break;
        }
        if (paramPAArticleButton.jdField_a_of_type_Int == e)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839669));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839668));
          break;
        }
      } while (paramPAArticleButton.jdField_a_of_type_Int != f);
      if (this.jdField_b_of_type_Boolean)
      {
        ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839667));
        break;
      }
      ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839666));
      break;
      label592:
      localLayoutParams.leftMargin = ((a() + ViewUtils.a(24.0F)) * paramInt);
      break label121;
      label611:
      if (this.jdField_b_of_type_Boolean) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
      } else {
        ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
      }
    }
  }
  
  private void a(URLImageView paramURLImageView, URLDrawable paramURLDrawable)
  {
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 0.1F, 1.0F, 0.1F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(300L);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.1F, 1.2F, 0.1F, 1.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(100L);
    ScaleAnimation localScaleAnimation3 = new ScaleAnimation(1.2F, 0.9F, 1.2F, 0.9F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation3.setDuration(100L);
    ScaleAnimation localScaleAnimation4 = new ScaleAnimation(0.9F, 1.1F, 0.9F, 1.1F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation4.setDuration(100L);
    ScaleAnimation localScaleAnimation5 = new ScaleAnimation(1.1F, 0.95F, 1.1F, 0.95F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation5.setDuration(100L);
    ScaleAnimation localScaleAnimation6 = new ScaleAnimation(0.95F, 1.0F, 0.95F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation6.setDuration(100L);
    paramURLImageView.startAnimation(localScaleAnimation1);
    localScaleAnimation1.setAnimationListener(new pan(this, paramURLImageView, paramURLDrawable, localScaleAnimation2));
    localScaleAnimation2.setAnimationListener(new pao(this, paramURLImageView, localScaleAnimation3));
    localScaleAnimation3.setAnimationListener(new pap(this, paramURLImageView, localScaleAnimation4));
    localScaleAnimation4.setAnimationListener(new paq(this, paramURLImageView, localScaleAnimation5));
    localScaleAnimation5.setAnimationListener(new par(this, paramURLImageView, localScaleAnimation6));
  }
  
  private boolean a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + str, 0).getBoolean("public_account_bottom_bar", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountUIPlugin", 2, "config is false");
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("mp.qq.com"));
  }
  
  private void b()
  {
    int i = 0;
    if (this.mRuntime.a() != null)
    {
      localObject = (ViewGroup)LayoutInflater.from(this.mRuntime.a()).inflate(2130969501, null);
      if (this.mRuntime.a().jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup != null) {
        this.mRuntime.a().jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131366720));
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        break;
      }
      return;
      ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131366728)).inflate();
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    Object localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131363612);
    if (this.jdField_b_of_type_Boolean) {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#333333"));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131366721));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new pam(this));
      this.jdField_b_of_type_AndroidViewViewGroup.setEnabled(false);
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      int j = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.size();
      while (i < j)
      {
        a((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i), i);
        i += 1;
      }
      break;
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#dedfe0"));
    }
  }
  
  private void b(PubAccountUIPlugin.PAArticleInfo paramPAArticleInfo)
  {
    if (paramPAArticleInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramPAArticleInfo.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_Int = paramPAArticleInfo.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(paramPAArticleInfo.jdField_a_of_type_Int);
        localStringBuilder.append("color=" + Integer.toHexString(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_Int));
      }
      if (paramPAArticleInfo.jdField_a_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaLangString = paramPAArticleInfo.jdField_a_of_type_JavaLangString;
        localStringBuilder.append(";callback=" + this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaLangString);
      }
      int j;
      int i;
      if (paramPAArticleInfo.jdField_a_of_type_JavaUtilList != null)
      {
        if (paramPAArticleInfo.jdField_a_of_type_JavaUtilList.size() > g) {}
        for (this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList = paramPAArticleInfo.jdField_a_of_type_JavaUtilList.subList(0, g);; this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList = paramPAArticleInfo.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_b_of_type_AndroidViewViewGroup.removeAllViews();
          j = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          while (i < j)
          {
            a((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i), i);
            localStringBuilder.append(";buttonInfo index=" + i + ";id=" + ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int + ";icon=" + ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString + ";text=" + ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString + ";textColor=" + Integer.toHexString(((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int));
            i += 1;
          }
        }
      }
      if (paramPAArticleInfo.b != null)
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.b = paramPAArticleInfo.b;
        j = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.b.size();
        i = 0;
        while (i < j)
        {
          paramPAArticleInfo = URLDrawable.getDrawable((String)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.b.get(i), ViewUtils.a(24.0F), ViewUtils.a(24.0F), null, null, true);
          if ((paramPAArticleInfo != null) && (paramPAArticleInfo.getStatus() == 2)) {
            paramPAArticleInfo.restartDownload();
          }
          localStringBuilder.append(";emoIcons index=" + i + ",url=" + (String)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.b.get(i));
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountUIPlugin", 2, "updatePAArticleBottomBar" + localStringBuilder.toString());
      }
    }
  }
  
  private boolean b(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("mp.qq.com")))
      {
        Uri localUri2 = Uri.parse(paramString);
        Uri localUri1 = localUri2;
        if (paramString.contains("www.urlshare.cn/umirror_url_check")) {
          localUri1 = Uri.parse(localUri2.getQueryParameter("url"));
        }
        paramString = localUri1.getQueryParameter("_pflag");
        if (paramString != null) {
          try
          {
            long l = Long.parseLong(paramString, 10);
            if (((l & 0x7) == 1L) || ((l & 0x7) == 2L))
            {
              if ((l & 0x7) == 2L) {
                this.jdField_b_of_type_Boolean = true;
              }
              return true;
            }
          }
          catch (NumberFormatException paramString)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("PubAccountUIPlugin", 4, "_pflag param not found");
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("PubAccountUIPlugin", 1, "isPflagRulesNeedShowBottomBar exception: " + paramString);
      }
    }
    return false;
  }
  
  public void a(PubAccountUIPlugin.PAArticleButton paramPAArticleButton)
  {
    if (!this.jdField_a_of_type_Boolean) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList == null) || (paramPAArticleButton == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountUIPlugin", 2, "updateButton buttonInfo id=" + paramPAArticleButton.jdField_a_of_type_Int + ",icon=" + paramPAArticleButton.jdField_a_of_type_JavaLangString + ",text=" + paramPAArticleButton.jdField_b_of_type_JavaLangString + ",textColor=" + Integer.toHexString(paramPAArticleButton.jdField_b_of_type_Int));
    }
    int k = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    label122:
    int j;
    TextView localTextView;
    Object localObject2;
    label162:
    Object localObject1;
    if (i < k) {
      if (((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramPAArticleButton.jdField_a_of_type_Int)
      {
        j = 0;
        localTextView = null;
        localObject2 = null;
        if (j < this.jdField_b_of_type_AndroidViewViewGroup.getChildCount())
        {
          localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(j);
          if ((!(((View)localObject1).getTag() instanceof PubAccountUIPlugin.PAArticleButton)) || (((PubAccountUIPlugin.PAArticleButton)((View)localObject1).getTag()).jdField_a_of_type_Int != paramPAArticleButton.jdField_a_of_type_Int)) {
            break label759;
          }
          if ((localObject1 instanceof TextView))
          {
            localTextView = (TextView)localObject1;
            localObject1 = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      localObject2 = localObject1;
      break label162;
      localObject1 = (URLImageView)localObject1;
      continue;
      if ((localObject2 == null) && (localTextView == null)) {
        break;
      }
      if ((paramPAArticleButton.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramPAArticleButton.jdField_a_of_type_JavaLangString)))
      {
        ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString = paramPAArticleButton.jdField_a_of_type_JavaLangString;
        if (paramPAArticleButton.jdField_a_of_type_Int != jdField_c_of_type_Int) {
          break label552;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label535;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839665);
        label333:
        localObject1 = URLDrawable.getDrawable(paramPAArticleButton.jdField_a_of_type_JavaLangString, ViewUtils.a(24.0F), ViewUtils.a(24.0F), (Drawable)localObject1, (Drawable)localObject1, true);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 2)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
          QLog.d("PubAccountUIPlugin", 2, "updateButton download newImage Successed url = " + paramPAArticleButton.jdField_a_of_type_JavaLangString);
        }
        if (localObject2 != null) {
          a(localObject2, (URLDrawable)localObject1);
        }
      }
      localObject1 = localTextView;
      if (paramPAArticleButton.jdField_b_of_type_JavaLangString != null)
      {
        if (localTextView != null)
        {
          localTextView.setText(paramPAArticleButton.jdField_b_of_type_JavaLangString);
          label457:
          ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString = paramPAArticleButton.jdField_b_of_type_JavaLangString;
          localObject1 = localTextView;
        }
      }
      else
      {
        if (paramPAArticleButton.jdField_b_of_type_Int == 0) {
          break label724;
        }
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(paramPAArticleButton.jdField_b_of_type_Int);
          ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int = paramPAArticleButton.jdField_b_of_type_Int;
        }
      }
      for (;;)
      {
        i += 1;
        break label122;
        break;
        label535:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839664);
        break label333;
        label552:
        if (paramPAArticleButton.jdField_a_of_type_Int == d)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839672);
            break label333;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130839671);
          break label333;
        }
        localObject1 = null;
        break label333;
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        localObject1 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (((RelativeLayout.LayoutParams)localObject2.getLayoutParams()).leftMargin + ViewUtils.a(27.0F));
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(9);
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        localTextView.setGravity(16);
        localTextView.setTextSize(11.0F);
        localTextView.setTag(paramPAArticleButton);
        localTextView.setOnClickListener(this);
        localTextView.setText(paramPAArticleButton.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidViewViewGroup.addView(localTextView);
        break label457;
        label724:
        if (this.jdField_b_of_type_Boolean) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
        } else {
          ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
        }
      }
      label759:
      localObject1 = localObject2;
    }
  }
  
  public void a(PubAccountUIPlugin.PAArticleInfo paramPAArticleInfo)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      b(paramPAArticleInfo);
      return;
    }
    b();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    label7:
    int i;
    do
    {
      do
      {
        do
        {
          break label7;
          do
          {
            return;
          } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
          i = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
          if (!paramBoolean) {
            break;
          }
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        } while (paramInt == 0);
        localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
        localTranslateAnimation.setDuration(paramInt);
        localTranslateAnimation.setFillAfter(true);
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
        return;
      } while (paramBoolean);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    } while (paramInt == 0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
    localTranslateAnimation.setDuration(paramInt);
    localTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QQBrowserActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.mRuntime.a());
    }
    if ((this.mRuntime == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.mRuntime.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null)
    {
      QLog.e("PubAccountUIPlugin", 1, "handleEvent webViewFragment is null");
      return false;
    }
    if (paramLong == 8589934593L)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return false;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        a();
        a(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo);
        this.jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (paramLong == 8589934611L)
      {
        a(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo);
      }
      else if ((paramLong == 1L) && (a()) && (b(paramString)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.c = 0L;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_Int = -16777216;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof PubAccountUIPlugin.PAArticleButton))
    {
      paramView = (PubAccountUIPlugin.PAArticleButton)paramView.getTag();
      if (paramView.jdField_a_of_type_Int != jdField_b_of_type_Int) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.onBackPressed();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaLangString))
      {
        paramView = a(paramView.jdField_a_of_type_Int);
        if (paramView != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a().a(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaLangString, new String[] { paramView });
        }
      }
      return;
      label86:
      ArrayList localArrayList;
      SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler;
      if (paramView.jdField_a_of_type_Int == e)
      {
        localArrayList = new ArrayList();
        localArrayList.add("menuItem:openWithQQBrowser");
        localArrayList.add("menuItem:openWithSafari");
        localArrayList.add("menuItem:favorite");
        localArrayList.add("menuItem:copyUrl");
        localArrayList.add("menuItem:exposeArticle");
        localArrayList.add("menuItem:screenShotShare");
        localArrayList.add("menuItem:setFont");
        localArrayList.add("menuItem:share:kandian");
        localArrayList.add("menuItem:share:diandian");
        localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
        if (localSwiftBrowserShareMenuHandler != null)
        {
          localSwiftBrowserShareMenuHandler.a.addAll(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b();
          localSwiftBrowserShareMenuHandler.a.clear();
        }
      }
      else if (paramView.jdField_a_of_type_Int == f)
      {
        localArrayList = new ArrayList();
        localArrayList.add("menuItem:share:qq");
        localArrayList.add("menuItem:share:QZone");
        localArrayList.add("menuItem:share:appMessage");
        localArrayList.add("menuItem:share:timeline");
        localArrayList.add("menuItem:share:sinaWeibo");
        localArrayList.add("menuItem:share:qiDian");
        localArrayList.add("menuItem:share:qiYeQQ");
        localArrayList.add("menuItem:share:kandian");
        localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
        if (localSwiftBrowserShareMenuHandler != null)
        {
          localSwiftBrowserShareMenuHandler.a.addAll(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b();
          localSwiftBrowserShareMenuHandler.a.clear();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountUIPlugin
 * JD-Core Version:    0.7.0.1
 */
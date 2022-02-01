package com.tencent.biz.webviewplugin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
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
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class PubAccountUIPlugin
  extends WebViewPlugin
  implements View.OnClickListener, IPreCreatePluginChecker
{
  public static int b = 10000;
  public static int c = 10001;
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
  
  public PubAccountUIPlugin()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
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
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("type", "click");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("btnId", paramInt);
      ((JSONObject)localObject).put("data", localJSONObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      label48:
      break label48;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountUIPlugin", 2, "getClickBottomBarCallBackResult json error!");
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo = new PubAccountUIPlugin.PAArticleInfo();
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_Int = -16777216;
    } else {
      this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_Int = -1;
    }
    PubAccountUIPlugin.PAArticleButton localPAArticleButton = new PubAccountUIPlugin.PAArticleButton();
    localPAArticleButton.jdField_a_of_type_Int = 10000;
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.add(localPAArticleButton);
  }
  
  private void a(PubAccountUIPlugin.PAArticleButton paramPAArticleButton, int paramInt)
  {
    Object localObject1 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.a(24.0F), ViewUtils.a(24.0F));
    Object localObject2;
    if ((paramPAArticleButton.jdField_a_of_type_JavaLangString == null) && (TextUtils.isEmpty(paramPAArticleButton.jdField_a_of_type_JavaLangString)))
    {
      if (paramPAArticleButton.jdField_a_of_type_Int == jdField_b_of_type_Int)
      {
        if (this.jdField_b_of_type_Boolean) {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841672));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841671));
        }
      }
      else if (paramPAArticleButton.jdField_a_of_type_Int == jdField_c_of_type_Int)
      {
        if (this.jdField_b_of_type_Boolean) {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841674));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841673));
        }
      }
      else if (paramPAArticleButton.jdField_a_of_type_Int == d)
      {
        if (this.jdField_b_of_type_Boolean) {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841681));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841680));
        }
      }
      else if (paramPAArticleButton.jdField_a_of_type_Int == e)
      {
        if (this.jdField_b_of_type_Boolean) {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841678));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841677));
        }
      }
      else if (paramPAArticleButton.jdField_a_of_type_Int == f) {
        if (this.jdField_b_of_type_Boolean) {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841676));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841675));
        }
      }
    }
    else
    {
      localObject2 = new ColorDrawable(Color.parseColor("#dddfe2"));
      localObject2 = URLDrawable.getDrawable(paramPAArticleButton.jdField_a_of_type_JavaLangString, ViewUtils.a(24.0F), ViewUtils.a(24.0F), (Drawable)localObject2, (Drawable)localObject2, true);
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
        ((URLDrawable)localObject2).restartDownload();
      }
    }
    if (paramInt == 0) {
      localLayoutParams.leftMargin = 0;
    } else {
      localLayoutParams.leftMargin = ((a() + ViewUtils.a(24.0F)) * paramInt);
    }
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
      if (paramPAArticleButton.jdField_b_of_type_Int != 0) {
        ((TextView)localObject1).setTextColor(paramPAArticleButton.jdField_b_of_type_Int);
      } else if (this.jdField_b_of_type_Boolean) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
      } else {
        ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
      }
      ((TextView)localObject1).setTextSize(11.0F);
      ((TextView)localObject1).setTag(paramPAArticleButton);
      ((TextView)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
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
    localScaleAnimation1.setAnimationListener(new PubAccountUIPlugin.2(this, paramURLImageView, paramURLDrawable, localScaleAnimation2));
    localScaleAnimation2.setAnimationListener(new PubAccountUIPlugin.3(this, paramURLImageView, localScaleAnimation3));
    localScaleAnimation3.setAnimationListener(new PubAccountUIPlugin.4(this, paramURLImageView, localScaleAnimation4));
    localScaleAnimation4.setAnimationListener(new PubAccountUIPlugin.5(this, paramURLImageView, localScaleAnimation5));
    localScaleAnimation5.setAnimationListener(new PubAccountUIPlugin.6(this, paramURLImageView, localScaleAnimation6));
  }
  
  private boolean a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(str);
    if (!localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("public_account_bottom_bar", false))
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
    Object localObject = (WebViewFragment)this.mRuntime.a();
    if (localObject != null)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.mRuntime.a()).inflate(2131559953, null);
      if (((WebViewFragment)localObject).getUIStyleHandler().d != null) {
        ((WebViewFragment)localObject).getUIStyleHandler().d.addView(localViewGroup);
      }
    }
    else
    {
      ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131372242)).inflate();
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131373196));
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject == null) {
      return;
    }
    int i = 0;
    ((ViewGroup)localObject).setVisibility(0);
    localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131365759);
    if (this.jdField_b_of_type_Boolean) {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#333333"));
    } else {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#dedfe0"));
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131363728));
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new PubAccountUIPlugin.1(this));
    this.jdField_b_of_type_AndroidViewViewGroup.setEnabled(false);
    localObject = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(((PubAccountUIPlugin.PAArticleInfo)localObject).jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList != null)
      {
        int j = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.size();
        while (i < j)
        {
          a((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i), i);
          i += 1;
        }
      }
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("color=");
        ((StringBuilder)localObject).append(Integer.toHexString(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_Int));
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (paramPAArticleInfo.jdField_a_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaLangString = paramPAArticleInfo.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(";callback=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      Object localObject = paramPAArticleInfo.jdField_a_of_type_JavaUtilList;
      int j = 0;
      int k;
      int i;
      if (localObject != null)
      {
        if (paramPAArticleInfo.jdField_a_of_type_JavaUtilList.size() > g) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList = paramPAArticleInfo.jdField_a_of_type_JavaUtilList.subList(0, g);
        } else {
          this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList = paramPAArticleInfo.jdField_a_of_type_JavaUtilList;
        }
        this.jdField_b_of_type_AndroidViewViewGroup.removeAllViews();
        k = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        while (i < k)
        {
          a((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i), i);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(";buttonInfo index=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(";id=");
          ((StringBuilder)localObject).append(((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(";icon=");
          ((StringBuilder)localObject).append(((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(";text=");
          ((StringBuilder)localObject).append(((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject).append(";textColor=");
          ((StringBuilder)localObject).append(Integer.toHexString(((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int));
          localStringBuilder.append(((StringBuilder)localObject).toString());
          i += 1;
        }
      }
      if (paramPAArticleInfo.b != null)
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.b = paramPAArticleInfo.b;
        k = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.b.size();
        i = j;
        while (i < k)
        {
          paramPAArticleInfo = URLDrawable.getDrawable((String)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.b.get(i), ViewUtils.a(24.0F), ViewUtils.a(24.0F), null, null, true);
          if ((paramPAArticleInfo != null) && (paramPAArticleInfo.getStatus() == 2)) {
            paramPAArticleInfo.restartDownload();
          }
          paramPAArticleInfo = new StringBuilder();
          paramPAArticleInfo.append(";emoIcons index=");
          paramPAArticleInfo.append(i);
          paramPAArticleInfo.append(",url=");
          paramPAArticleInfo.append((String)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.b.get(i));
          localStringBuilder.append(paramPAArticleInfo.toString());
          i += 1;
        }
      }
      if (QLog.isColorLevel())
      {
        paramPAArticleInfo = new StringBuilder();
        paramPAArticleInfo.append("updatePAArticleBottomBar");
        paramPAArticleInfo.append(localStringBuilder.toString());
        QLog.d("PubAccountUIPlugin", 2, paramPAArticleInfo.toString());
      }
    }
  }
  
  /* Error */
  private boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +154 -> 158
    //   7: aload_1
    //   8: ldc_w 361
    //   11: invokevirtual 366	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +144 -> 158
    //   17: aload_1
    //   18: invokestatic 494	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   21: astore 5
    //   23: aload 5
    //   25: astore 4
    //   27: aload_1
    //   28: ldc_w 496
    //   31: invokevirtual 366	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +16 -> 50
    //   37: aload 5
    //   39: ldc_w 498
    //   42: invokevirtual 502	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokestatic 494	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: astore 4
    //   50: aload 4
    //   52: ldc_w 504
    //   55: invokevirtual 502	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +98 -> 158
    //   63: aload_1
    //   64: bipush 10
    //   66: invokestatic 510	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   69: ldc2_w 511
    //   72: land
    //   73: lstore_2
    //   74: lload_2
    //   75: lconst_1
    //   76: lcmp
    //   77: ifeq +11 -> 88
    //   80: lload_2
    //   81: ldc2_w 513
    //   84: lcmp
    //   85: ifne +73 -> 158
    //   88: lload_2
    //   89: ldc2_w 513
    //   92: lcmp
    //   93: ifne +8 -> 101
    //   96: aload_0
    //   97: iconst_1
    //   98: putfield 37	com/tencent/biz/webviewplugin/PubAccountUIPlugin:jdField_b_of_type_Boolean	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: invokestatic 517	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   106: ifeq +52 -> 158
    //   109: ldc 119
    //   111: iconst_4
    //   112: ldc_w 519
    //   115: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: goto +40 -> 158
    //   121: astore_1
    //   122: new 334	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   129: astore 4
    //   131: aload 4
    //   133: ldc_w 521
    //   136: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 4
    //   142: aload_1
    //   143: invokevirtual 524	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 119
    //   149: iconst_1
    //   150: aload 4
    //   152: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: goto -58 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	PubAccountUIPlugin
    //   0	164	1	paramString	String
    //   73	16	2	l	long
    //   25	126	4	localObject	Object
    //   21	17	5	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   0	23	121	java/lang/Exception
    //   27	50	121	java/lang/Exception
    //   50	59	121	java/lang/Exception
    //   63	74	121	java/lang/Exception
    //   96	101	121	java/lang/Exception
    //   103	118	121	java/lang/Exception
    //   63	74	160	java/lang/NumberFormatException
    //   96	101	160	java/lang/NumberFormatException
  }
  
  public void a(PubAccountUIPlugin.PAArticleButton paramPAArticleButton)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo;
    if ((localObject1 != null) && (((PubAccountUIPlugin.PAArticleInfo)localObject1).jdField_a_of_type_JavaUtilList != null) && (paramPAArticleButton != null))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateButton buttonInfo id=");
        ((StringBuilder)localObject1).append(paramPAArticleButton.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(",icon=");
        ((StringBuilder)localObject1).append(paramPAArticleButton.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(",text=");
        ((StringBuilder)localObject1).append(paramPAArticleButton.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(",textColor=");
        ((StringBuilder)localObject1).append(Integer.toHexString(paramPAArticleButton.jdField_b_of_type_Int));
        QLog.d("PubAccountUIPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      int k = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < k)
      {
        if (((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramPAArticleButton.jdField_a_of_type_Int)
        {
          Object localObject5 = null;
          Object localObject3 = null;
          Object localObject2 = localObject3;
          int j = 0;
          Object localObject4;
          while (j < this.jdField_b_of_type_AndroidViewViewGroup.getChildCount())
          {
            View localView = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(j);
            localObject1 = localObject3;
            localObject4 = localObject2;
            if ((localView.getTag() instanceof PubAccountUIPlugin.PAArticleButton))
            {
              localObject1 = localObject3;
              localObject4 = localObject2;
              if (((PubAccountUIPlugin.PAArticleButton)localView.getTag()).jdField_a_of_type_Int == paramPAArticleButton.jdField_a_of_type_Int) {
                if ((localView instanceof TextView))
                {
                  localObject4 = (TextView)localView;
                  localObject1 = localObject3;
                }
                else
                {
                  localObject1 = (URLImageView)localView;
                  localObject4 = localObject2;
                }
              }
            }
            j += 1;
            localObject3 = localObject1;
            localObject2 = localObject4;
          }
          if ((localObject3 == null) && (localObject2 == null)) {
            return;
          }
          if ((paramPAArticleButton.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramPAArticleButton.jdField_a_of_type_JavaLangString)))
          {
            ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString = paramPAArticleButton.jdField_a_of_type_JavaLangString;
            if (paramPAArticleButton.jdField_a_of_type_Int == jdField_c_of_type_Int)
            {
              if (this.jdField_b_of_type_Boolean) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841674);
              } else {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841673);
              }
            }
            else
            {
              localObject1 = localObject5;
              if (paramPAArticleButton.jdField_a_of_type_Int == d) {
                if (this.jdField_b_of_type_Boolean) {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841681);
                } else {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841680);
                }
              }
            }
            localObject1 = URLDrawable.getDrawable(paramPAArticleButton.jdField_a_of_type_JavaLangString, ViewUtils.a(24.0F), ViewUtils.a(24.0F), (Drawable)localObject1, (Drawable)localObject1, true);
            if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 2)) {
              ((URLDrawable)localObject1).restartDownload();
            }
            if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("updateButton download newImage Successed url = ");
              ((StringBuilder)localObject4).append(paramPAArticleButton.jdField_a_of_type_JavaLangString);
              QLog.d("PubAccountUIPlugin", 2, ((StringBuilder)localObject4).toString());
            }
            if (localObject3 != null) {
              a(localObject3, (URLDrawable)localObject1);
            }
          }
          localObject1 = localObject2;
          if (paramPAArticleButton.jdField_b_of_type_JavaLangString != null)
          {
            if (localObject2 != null)
            {
              ((TextView)localObject2).setText(paramPAArticleButton.jdField_b_of_type_JavaLangString);
            }
            else
            {
              localObject2 = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
              localObject1 = new RelativeLayout.LayoutParams(-2, -1);
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = (((RelativeLayout.LayoutParams)localObject3.getLayoutParams()).leftMargin + ViewUtils.a(27.0F));
              ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              ((RelativeLayout.LayoutParams)localObject1).addRule(9);
              ((RelativeLayout.LayoutParams)localObject1).addRule(15);
              ((TextView)localObject2).setGravity(16);
              ((TextView)localObject2).setTextSize(11.0F);
              ((TextView)localObject2).setTag(paramPAArticleButton);
              ((TextView)localObject2).setOnClickListener(this);
              ((TextView)localObject2).setText(paramPAArticleButton.jdField_b_of_type_JavaLangString);
              this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject2);
            }
            ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString = paramPAArticleButton.jdField_b_of_type_JavaLangString;
            localObject1 = localObject2;
          }
          if (paramPAArticleButton.jdField_b_of_type_Int != 0)
          {
            if (localObject1 != null)
            {
              ((TextView)localObject1).setTextColor(paramPAArticleButton.jdField_b_of_type_Int);
              ((PubAccountUIPlugin.PAArticleButton)this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int = paramPAArticleButton.jdField_b_of_type_Int;
            }
          }
          else if (this.jdField_b_of_type_Boolean) {
            ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
          } else {
            ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(PubAccountUIPlugin.PAArticleInfo paramPAArticleInfo)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup != null)
    {
      localViewGroup.setVisibility(0);
      b(paramPAArticleInfo);
      return;
    }
    b();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      int i = ((ViewGroup)localObject).getHeight();
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        if (paramInt != 0)
        {
          localObject = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
          ((TranslateAnimation)localObject).setDuration(paramInt);
          ((TranslateAnimation)localObject).setFillAfter(true);
          this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
        }
      }
      else if (!paramBoolean)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        if (paramInt != 0)
        {
          localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
          ((TranslateAnimation)localObject).setDuration(paramInt);
          ((TranslateAnimation)localObject).setFillAfter(true);
          this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
        }
      }
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 1L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QQBrowserActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.mRuntime.a());
    }
    if (this.mRuntime != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = ((WebViewFragment)this.mRuntime.a());
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
      else if (paramLong == 8589934611L)
      {
        a(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo);
      }
      else if ((paramLong == 1L) && (a()) && (b(paramString)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getUIStyleHandler().a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getUIStyleHandler().a.c = 0L;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getUIStyleHandler().jdField_b_of_type_Int = -16777216;
        }
      }
      return super.handleEvent(paramString, paramLong, paramMap);
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return a(paramString1);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof PubAccountUIPlugin.PAArticleButton))
    {
      Object localObject = (PubAccountUIPlugin.PAArticleButton)paramView.getTag();
      if (((PubAccountUIPlugin.PAArticleButton)localObject).jdField_a_of_type_Int == jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.onBackPressed();
      }
      else
      {
        ArrayList localArrayList;
        SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler;
        if (((PubAccountUIPlugin.PAArticleButton)localObject).jdField_a_of_type_Int == e)
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
          localArrayList.add("menuItem:exportTencentDocs");
          localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mComponentsProvider.a(4);
          if (localSwiftBrowserShareMenuHandler != null)
          {
            localSwiftBrowserShareMenuHandler.a.addAll(localArrayList);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.showActionSheet();
            localSwiftBrowserShareMenuHandler.a.clear();
          }
        }
        else if (((PubAccountUIPlugin.PAArticleButton)localObject).jdField_a_of_type_Int == f)
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
          localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mComponentsProvider.a(4);
          if (localSwiftBrowserShareMenuHandler != null)
          {
            localSwiftBrowserShareMenuHandler.a.addAll(localArrayList);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.showActionSheet();
            localSwiftBrowserShareMenuHandler.a.clear();
          }
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaLangString))
      {
        localObject = a(((PubAccountUIPlugin.PAArticleButton)localObject).jdField_a_of_type_Int);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountUIPlugin$PAArticleInfo.jdField_a_of_type_JavaLangString, new String[] { localObject });
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountUIPlugin
 * JD-Core Version:    0.7.0.1
 */
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
  public static int g = 10000;
  public static int h = 10001;
  public static int i = 10002;
  public static int j = 10003;
  public static int k = 10004;
  public static int l = 5;
  public boolean a = false;
  public boolean b = false;
  boolean c = false;
  public int d = 40;
  public ViewGroup e;
  public ViewGroup f;
  private QQBrowserActivity m;
  private WebViewFragment n;
  private PubAccountUIPlugin.PAArticleInfo o;
  
  public PubAccountUIPlugin()
  {
    this.mPluginNameSpace = "pubAccountUI";
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
  
  private void a(PubAccountUIPlugin.PAArticleButton paramPAArticleButton, int paramInt)
  {
    Object localObject1 = new URLImageView(this.m);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(24.0F), ViewUtils.dip2px(24.0F));
    Object localObject2;
    if ((paramPAArticleButton.b == null) && (TextUtils.isEmpty(paramPAArticleButton.b)))
    {
      if (paramPAArticleButton.a == g)
      {
        if (this.b) {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842587));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842586));
        }
      }
      else if (paramPAArticleButton.a == h)
      {
        if (this.b) {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842589));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842588));
        }
      }
      else if (paramPAArticleButton.a == i)
      {
        if (this.b) {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842596));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842595));
        }
      }
      else if (paramPAArticleButton.a == j)
      {
        if (this.b) {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842593));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842592));
        }
      }
      else if (paramPAArticleButton.a == k) {
        if (this.b) {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842591));
        } else {
          ((URLImageView)localObject1).setImageDrawable(this.m.getResources().getDrawable(2130842590));
        }
      }
    }
    else
    {
      localObject2 = new ColorDrawable(Color.parseColor("#dddfe2"));
      localObject2 = URLDrawable.getDrawable(paramPAArticleButton.b, ViewUtils.dip2px(24.0F), ViewUtils.dip2px(24.0F), (Drawable)localObject2, (Drawable)localObject2, true);
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
        ((URLDrawable)localObject2).restartDownload();
      }
    }
    if (paramInt == 0) {
      localLayoutParams.leftMargin = 0;
    } else {
      localLayoutParams.leftMargin = ((d() + ViewUtils.dip2px(24.0F)) * paramInt);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    ((URLImageView)localObject1).setLayoutParams(localLayoutParams);
    ((URLImageView)localObject1).setTag(paramPAArticleButton);
    ((URLImageView)localObject1).setOnClickListener(this);
    this.f.addView((View)localObject1);
    if ((paramPAArticleButton.c != null) && (paramInt != this.o.c.size() - 1))
    {
      localObject1 = new TextView(this.m);
      localObject2 = new RelativeLayout.LayoutParams(-2, -1);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = (localLayoutParams.leftMargin + ViewUtils.dip2px(27.0F));
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setText(paramPAArticleButton.c);
      if (paramPAArticleButton.d != 0) {
        ((TextView)localObject1).setTextColor(paramPAArticleButton.d);
      } else if (this.b) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
      } else {
        ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
      }
      ((TextView)localObject1).setTextSize(11.0F);
      ((TextView)localObject1).setTag(paramPAArticleButton);
      ((TextView)localObject1).setOnClickListener(this);
      this.f.addView((View)localObject1);
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
    this.o = new PubAccountUIPlugin.PAArticleInfo();
    this.o.c = new ArrayList();
    if (this.b) {
      this.o.a = -16777216;
    } else {
      this.o.a = -1;
    }
    PubAccountUIPlugin.PAArticleButton localPAArticleButton = new PubAccountUIPlugin.PAArticleButton();
    localPAArticleButton.a = 10000;
    this.o.c.add(localPAArticleButton);
  }
  
  private void b(PubAccountUIPlugin.PAArticleInfo paramPAArticleInfo)
  {
    if (paramPAArticleInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramPAArticleInfo.a != 0)
      {
        this.o.a = paramPAArticleInfo.a;
        this.e.setBackgroundColor(paramPAArticleInfo.a);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("color=");
        ((StringBuilder)localObject).append(Integer.toHexString(this.o.a));
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (paramPAArticleInfo.b != null)
      {
        this.o.b = paramPAArticleInfo.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(";callback=");
        ((StringBuilder)localObject).append(this.o.b);
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      Object localObject = paramPAArticleInfo.c;
      int i2 = 0;
      int i3;
      int i1;
      if (localObject != null)
      {
        if (paramPAArticleInfo.c.size() > l) {
          this.o.c = paramPAArticleInfo.c.subList(0, l);
        } else {
          this.o.c = paramPAArticleInfo.c;
        }
        this.f.removeAllViews();
        i3 = this.o.c.size();
        i1 = 0;
        while (i1 < i3)
        {
          a((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1), i1);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(";buttonInfo index=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(";id=");
          ((StringBuilder)localObject).append(((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1)).a);
          ((StringBuilder)localObject).append(";icon=");
          ((StringBuilder)localObject).append(((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1)).b);
          ((StringBuilder)localObject).append(";text=");
          ((StringBuilder)localObject).append(((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1)).c);
          ((StringBuilder)localObject).append(";textColor=");
          ((StringBuilder)localObject).append(Integer.toHexString(((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1)).d));
          localStringBuilder.append(((StringBuilder)localObject).toString());
          i1 += 1;
        }
      }
      if (paramPAArticleInfo.d != null)
      {
        this.o.d = paramPAArticleInfo.d;
        i3 = this.o.d.size();
        i1 = i2;
        while (i1 < i3)
        {
          paramPAArticleInfo = URLDrawable.getDrawable((String)this.o.d.get(i1), ViewUtils.dip2px(24.0F), ViewUtils.dip2px(24.0F), null, null, true);
          if ((paramPAArticleInfo != null) && (paramPAArticleInfo.getStatus() == 2)) {
            paramPAArticleInfo.restartDownload();
          }
          paramPAArticleInfo = new StringBuilder();
          paramPAArticleInfo.append(";emoIcons index=");
          paramPAArticleInfo.append(i1);
          paramPAArticleInfo.append(",url=");
          paramPAArticleInfo.append((String)this.o.d.get(i1));
          localStringBuilder.append(paramPAArticleInfo.toString());
          i1 += 1;
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
    //   1: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +154 -> 158
    //   7: aload_1
    //   8: ldc_w 350
    //   11: invokevirtual 355	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +144 -> 158
    //   17: aload_1
    //   18: invokestatic 428	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   21: astore 5
    //   23: aload 5
    //   25: astore 4
    //   27: aload_1
    //   28: ldc_w 430
    //   31: invokevirtual 355	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +16 -> 50
    //   37: aload 5
    //   39: ldc_w 432
    //   42: invokevirtual 436	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokestatic 428	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: astore 4
    //   50: aload 4
    //   52: ldc_w 438
    //   55: invokevirtual 436	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +98 -> 158
    //   63: aload_1
    //   64: bipush 10
    //   66: invokestatic 444	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   69: ldc2_w 445
    //   72: land
    //   73: lstore_2
    //   74: lload_2
    //   75: lconst_1
    //   76: lcmp
    //   77: ifeq +11 -> 88
    //   80: lload_2
    //   81: ldc2_w 447
    //   84: lcmp
    //   85: ifne +73 -> 158
    //   88: lload_2
    //   89: ldc2_w 447
    //   92: lcmp
    //   93: ifne +8 -> 101
    //   96: aload_0
    //   97: iconst_1
    //   98: putfield 45	com/tencent/biz/webviewplugin/PubAccountUIPlugin:b	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: invokestatic 451	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   106: ifeq +52 -> 158
    //   109: ldc 88
    //   111: iconst_4
    //   112: ldc_w 453
    //   115: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: goto +40 -> 158
    //   121: astore_1
    //   122: new 323	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   129: astore 4
    //   131: aload 4
    //   133: ldc_w 455
    //   136: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 4
    //   142: aload_1
    //   143: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 88
    //   149: iconst_1
    //   150: aload 4
    //   152: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: goto -58 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	PubAccountUIPlugin
    //   0	164	1	paramString	String
    //   73	16	2	l1	long
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
  
  private void c()
  {
    Object localObject = (WebViewFragment)this.mRuntime.f();
    if (localObject != null)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.mRuntime.d()).inflate(2131625996, null);
      if (((WebViewFragment)localObject).getUIStyleHandler().x != null) {
        ((WebViewFragment)localObject).getUIStyleHandler().x.addView(localViewGroup);
      }
    }
    else
    {
      ((ViewStub)this.m.findViewById(2131439747)).inflate();
    }
    this.e = ((ViewGroup)this.m.findViewById(2131440805));
    localObject = this.e;
    if (localObject == null) {
      return;
    }
    int i1 = 0;
    ((ViewGroup)localObject).setVisibility(0);
    localObject = (ImageView)this.m.findViewById(2131432003);
    if (this.b) {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#333333"));
    } else {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#dedfe0"));
    }
    this.f = ((ViewGroup)this.m.findViewById(2131429651));
    this.f.setOnClickListener(new PubAccountUIPlugin.1(this));
    this.f.setEnabled(false);
    localObject = this.o;
    if (localObject != null)
    {
      this.e.setBackgroundColor(((PubAccountUIPlugin.PAArticleInfo)localObject).a);
      if (this.o.c != null)
      {
        int i2 = this.o.c.size();
        while (i1 < i2)
        {
          a((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1), i1);
          i1 += 1;
        }
      }
    }
  }
  
  private int d()
  {
    int i1 = this.m.getResources().getDisplayMetrics().widthPixels;
    int i2 = this.o.c.size();
    return (i1 - ViewUtils.dip2px(12.0F) * 2 - ViewUtils.dip2px(24.0F) * i2) / (i2 - 1);
  }
  
  public void a(PubAccountUIPlugin.PAArticleButton paramPAArticleButton)
  {
    if (!this.a) {
      return;
    }
    Object localObject1 = this.o;
    if ((localObject1 != null) && (((PubAccountUIPlugin.PAArticleInfo)localObject1).c != null) && (paramPAArticleButton != null))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateButton buttonInfo id=");
        ((StringBuilder)localObject1).append(paramPAArticleButton.a);
        ((StringBuilder)localObject1).append(",icon=");
        ((StringBuilder)localObject1).append(paramPAArticleButton.b);
        ((StringBuilder)localObject1).append(",text=");
        ((StringBuilder)localObject1).append(paramPAArticleButton.c);
        ((StringBuilder)localObject1).append(",textColor=");
        ((StringBuilder)localObject1).append(Integer.toHexString(paramPAArticleButton.d));
        QLog.d("PubAccountUIPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      int i3 = this.o.c.size();
      int i1 = 0;
      while (i1 < i3)
      {
        if (((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1)).a == paramPAArticleButton.a)
        {
          Object localObject5 = null;
          Object localObject3 = null;
          Object localObject2 = localObject3;
          int i2 = 0;
          Object localObject4;
          while (i2 < this.f.getChildCount())
          {
            View localView = this.f.getChildAt(i2);
            localObject1 = localObject3;
            localObject4 = localObject2;
            if ((localView.getTag() instanceof PubAccountUIPlugin.PAArticleButton))
            {
              localObject1 = localObject3;
              localObject4 = localObject2;
              if (((PubAccountUIPlugin.PAArticleButton)localView.getTag()).a == paramPAArticleButton.a) {
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
            i2 += 1;
            localObject3 = localObject1;
            localObject2 = localObject4;
          }
          if ((localObject3 == null) && (localObject2 == null)) {
            return;
          }
          if ((paramPAArticleButton.b != null) && (!TextUtils.isEmpty(paramPAArticleButton.b)))
          {
            ((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1)).b = paramPAArticleButton.b;
            if (paramPAArticleButton.a == h)
            {
              if (this.b) {
                localObject1 = this.m.getResources().getDrawable(2130842589);
              } else {
                localObject1 = this.m.getResources().getDrawable(2130842588);
              }
            }
            else
            {
              localObject1 = localObject5;
              if (paramPAArticleButton.a == i) {
                if (this.b) {
                  localObject1 = this.m.getResources().getDrawable(2130842596);
                } else {
                  localObject1 = this.m.getResources().getDrawable(2130842595);
                }
              }
            }
            localObject1 = URLDrawable.getDrawable(paramPAArticleButton.b, ViewUtils.dip2px(24.0F), ViewUtils.dip2px(24.0F), (Drawable)localObject1, (Drawable)localObject1, true);
            if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 2)) {
              ((URLDrawable)localObject1).restartDownload();
            }
            if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("updateButton download newImage Successed url = ");
              ((StringBuilder)localObject4).append(paramPAArticleButton.b);
              QLog.d("PubAccountUIPlugin", 2, ((StringBuilder)localObject4).toString());
            }
            if (localObject3 != null) {
              a(localObject3, (URLDrawable)localObject1);
            }
          }
          localObject1 = localObject2;
          if (paramPAArticleButton.c != null)
          {
            if (localObject2 != null)
            {
              ((TextView)localObject2).setText(paramPAArticleButton.c);
            }
            else
            {
              localObject2 = new TextView(this.m);
              localObject1 = new RelativeLayout.LayoutParams(-2, -1);
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = (((RelativeLayout.LayoutParams)localObject3.getLayoutParams()).leftMargin + ViewUtils.dip2px(27.0F));
              ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              ((RelativeLayout.LayoutParams)localObject1).addRule(9);
              ((RelativeLayout.LayoutParams)localObject1).addRule(15);
              ((TextView)localObject2).setGravity(16);
              ((TextView)localObject2).setTextSize(11.0F);
              ((TextView)localObject2).setTag(paramPAArticleButton);
              ((TextView)localObject2).setOnClickListener(this);
              ((TextView)localObject2).setText(paramPAArticleButton.c);
              this.f.addView((View)localObject2);
            }
            ((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1)).c = paramPAArticleButton.c;
            localObject1 = localObject2;
          }
          if (paramPAArticleButton.d != 0)
          {
            if (localObject1 != null)
            {
              ((TextView)localObject1).setTextColor(paramPAArticleButton.d);
              ((PubAccountUIPlugin.PAArticleButton)this.o.c.get(i1)).d = paramPAArticleButton.d;
            }
          }
          else if (this.b) {
            ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
          } else {
            ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void a(PubAccountUIPlugin.PAArticleInfo paramPAArticleInfo)
  {
    if (!this.a) {
      return;
    }
    ViewGroup localViewGroup = this.e;
    if (localViewGroup != null)
    {
      localViewGroup.setVisibility(0);
      b(paramPAArticleInfo);
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.a) {
      return;
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      int i1 = ((ViewGroup)localObject).getHeight();
      if (paramBoolean)
      {
        this.e.setVisibility(0);
        if (paramInt != 0)
        {
          localObject = new TranslateAnimation(0.0F, 0.0F, i1, 0.0F);
          ((TranslateAnimation)localObject).setDuration(paramInt);
          ((TranslateAnimation)localObject).setFillAfter(true);
          this.e.startAnimation((Animation)localObject);
        }
      }
      else if (!paramBoolean)
      {
        this.e.setVisibility(8);
        if (paramInt != 0)
        {
          localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, i1);
          ((TranslateAnimation)localObject).setDuration(paramInt);
          ((TranslateAnimation)localObject).setFillAfter(true);
          this.e.startAnimation((Animation)localObject);
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
    if ((this.mRuntime != null) && ((this.mRuntime.d() instanceof QQBrowserActivity))) {
      this.m = ((QQBrowserActivity)this.mRuntime.d());
    }
    if (this.mRuntime != null)
    {
      if (this.m == null) {
        return false;
      }
      this.n = ((WebViewFragment)this.mRuntime.f());
      if (this.n == null)
      {
        QLog.e("PubAccountUIPlugin", 1, "handleEvent webViewFragment is null");
        return false;
      }
      if (paramLong == 8589934593L)
      {
        if (!this.a) {
          return false;
        }
        if (!this.c)
        {
          b();
          a(this.o);
          this.c = true;
        }
      }
      else if (paramLong == 8589934611L)
      {
        a(this.o);
      }
      else if ((paramLong == 1L) && (a()) && (b(paramString)))
      {
        this.a = true;
        this.n.getUIStyleHandler().f.a = true;
        this.n.getUIStyleHandler().f.e = 0L;
        if (this.b) {
          this.n.getUIStyleHandler().F = -16777216;
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
      if (((PubAccountUIPlugin.PAArticleButton)localObject).a == g)
      {
        this.m.onBackPressed();
      }
      else
      {
        ArrayList localArrayList;
        SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler;
        if (((PubAccountUIPlugin.PAArticleButton)localObject).a == j)
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
          localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.n.mComponentsProvider.a(4);
          if (localSwiftBrowserShareMenuHandler != null)
          {
            localSwiftBrowserShareMenuHandler.i.addAll(localArrayList);
            this.n.showActionSheet();
            localSwiftBrowserShareMenuHandler.i.clear();
          }
        }
        else if (((PubAccountUIPlugin.PAArticleButton)localObject).a == k)
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
          localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.n.mComponentsProvider.a(4);
          if (localSwiftBrowserShareMenuHandler != null)
          {
            localSwiftBrowserShareMenuHandler.i.addAll(localArrayList);
            this.n.showActionSheet();
            localSwiftBrowserShareMenuHandler.i.clear();
          }
        }
      }
      if (!TextUtils.isEmpty(this.o.b))
      {
        localObject = a(((PubAccountUIPlugin.PAArticleButton)localObject).a);
        if (localObject != null) {
          this.n.getWebView().callJs(this.o.b, new String[] { localObject });
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountUIPlugin
 * JD-Core Version:    0.7.0.1
 */
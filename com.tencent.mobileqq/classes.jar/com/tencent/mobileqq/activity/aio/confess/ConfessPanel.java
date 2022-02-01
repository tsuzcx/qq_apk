package com.tencent.mobileqq.activity.aio.confess;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.ResetPanelInterface;
import com.tencent.widget.XPanelContainer;

public class ConfessPanel
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, ResetPanelInterface
{
  public static int b = -1;
  public static final int c;
  public static int d;
  public QQAppInterface a;
  private boolean e = false;
  private int f;
  private boolean g = false;
  private FrameLayout h;
  private ConfessWebViewBuilder i;
  private TouchWebView j;
  private BaseChatPie k;
  private Context l;
  private int m;
  private int n;
  private boolean o = false;
  
  static
  {
    int i1 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().widthPixels;
    c = a(i1);
    d = i1;
  }
  
  public ConfessPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ConfessPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a(int paramInt)
  {
    return (int)(paramInt * 1.0F / 1.132931F);
  }
  
  public static int a(Resources paramResources, int paramInt1, int paramInt2)
  {
    int i2 = paramInt1 + paramInt2;
    int i3 = paramResources.getDisplayMetrics().heightPixels;
    int i1;
    if (i2 <= i3)
    {
      i1 = i2;
      if (i2 <= i3 * 0.6F) {}
    }
    else
    {
      i1 = (int)(i3 * 0.6F);
    }
    i2 = i1;
    if (i1 < XPanelContainer.b + paramInt2) {
      i2 = XPanelContainer.b + paramInt2;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPanel", 2, String.format("adjustPanelHeight [maxPanelH,toolbarH,screenH,ExternalH,dstHeight]=[%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i3), Integer.valueOf(XPanelContainer.b), Integer.valueOf(i2) }));
    }
    return i2;
  }
  
  public static int a(BaseChatPie paramBaseChatPie)
  {
    InputLinearLayout localInputLinearLayout = paramBaseChatPie.X;
    paramBaseChatPie = paramBaseChatPie.W;
    int i1 = 0;
    if (localInputLinearLayout != null) {
      i1 = 0 + localInputLinearLayout.getHeight();
    }
    int i2 = i1;
    if (paramBaseChatPie != null) {
      i2 = i1 + paramBaseChatPie.getHeight();
    }
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("getToolbarHeight =");
      paramBaseChatPie.append(i2);
      QLog.d("ConfessPanel", 2, paramBaseChatPie.toString());
    }
    return i2;
  }
  
  private void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramBaseChatPie == null) {
      return;
    }
    this.m = a(paramBaseChatPie);
    this.n = (a(getResources(), paramInt, this.m) - this.m);
  }
  
  private void c()
  {
    if (!this.g)
    {
      this.i = new ConfessWebViewBuilder(this.l, this.k.aX(), this.a);
      this.j = this.i.a(this.h);
      this.j.getSettings().setMediaPlaybackRequiresUserGesture(false);
      this.j.getPluginEngine().a(this.i);
      this.g = true;
    }
  }
  
  private void d()
  {
    if (this.g)
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeAllViewsInLayout();
        }
        this.j.removeAllViews();
      }
      localObject = this.i;
      if (localObject != null) {
        ((ConfessWebViewBuilder)localObject).a();
      }
      this.j = null;
      this.g = false;
    }
  }
  
  public void a()
  {
    QLog.d("ConfessPanel", 2, "unInit");
    d();
    this.a = null;
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, requestCode = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.o)
    {
      localObject = this.j.getPluginEngine().a(WebViewUtil.a("QQApi"), true);
      if (localObject != null) {
        ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)1, -1);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.a = paramQQAppInterface;
    this.l = paramContext;
    this.k = paramBaseChatPie;
    a(this.k, c);
    b = XPanelContainer.a;
    this.h = ((FrameLayout)findViewById(2131431205));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHide :");
      localStringBuilder.append(paramBoolean);
      QLog.d("ConfessPanel", 2, localStringBuilder.toString());
    }
    this.e = false;
    this.f = 0;
    if (!paramBoolean) {
      XPanelContainer.a = b;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set mExternalPanelheight :");
    localStringBuilder.append(XPanelContainer.a);
    QLog.d("ConfessPanel", 2, localStringBuilder.toString());
    if (this.o) {
      d();
    }
    setVisibility(8);
  }
  
  public void b()
  {
    b = XPanelContainer.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onShow mOriginPanelHeight:");
    ((StringBuilder)localObject).append(b);
    QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
    this.e = true;
    this.f = getPanelHeight();
    XPanelContainer.a = this.f;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set mExternalPanelheight :");
    ((StringBuilder)localObject).append(XPanelContainer.a);
    QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
    if ((this.o) && (!this.g)) {
      c();
    }
    if (this.o)
    {
      localObject = this.k.aX().getIntent().getStringExtra("url");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onShow url :");
        localStringBuilder.append((String)localObject);
        QLog.d("ConfessPanel", 2, localStringBuilder.toString());
      }
      this.i.a((String)localObject);
    }
  }
  
  public int getDefaultExternalPanelheight()
  {
    this.f = getPanelHeight();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDefaultExternalPanelheight , orginal:");
    localStringBuilder.append(XPanelContainer.a);
    localStringBuilder.append(" return:");
    localStringBuilder.append(this.f);
    QLog.d("ConfessPanel", 2, localStringBuilder.toString());
    return this.f;
  }
  
  public int getPanelHeight()
  {
    if ((BaseApplicationImpl.sApplication != null) && (BaseApplicationImpl.sApplication.getResources() != null))
    {
      localObject = getParent();
      if ((localObject instanceof View))
      {
        int i1 = ((View)localObject).getWidth();
        if ((d != i1) && (i1 > 0))
        {
          d = i1;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getPanelHeight , sLastScreenWidth:");
          ((StringBuilder)localObject).append(d);
          ((StringBuilder)localObject).append(" winwidth:");
          ((StringBuilder)localObject).append(i1);
          QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
          int i2 = a(i1);
          a(this.k, i2);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getPanelHeight , sLastScreenWidth:");
          ((StringBuilder)localObject).append(d);
          ((StringBuilder)localObject).append(" winwidth:");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(" nWinHeight:");
          ((StringBuilder)localObject).append(i2);
          QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
          return this.n;
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPanelHeight , use max height:");
    ((StringBuilder)localObject).append(this.n);
    QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
    return this.n;
  }
  
  public void onClick(View paramView) {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.e)
    {
      if (XPanelContainer.a == this.f) {
        XPanelContainer.a = b;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetachedFromWindow, set mExternalPanelheight :");
      localStringBuilder.append(XPanelContainer.a);
      QLog.d("ConfessPanel", 2, localStringBuilder.toString());
    }
    this.e = false;
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessPanel
 * JD-Core Version:    0.7.0.1
 */
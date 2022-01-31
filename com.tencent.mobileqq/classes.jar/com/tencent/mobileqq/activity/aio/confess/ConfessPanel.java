package com.tencent.mobileqq.activity.aio.confess;

import adcx;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import bfxf;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.XPanelContainer;

public class ConfessPanel
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, bfxf
{
  public static int a;
  public static final int b;
  public static int c;
  private adcx jdField_a_of_type_Adcx;
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public QQAppInterface a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private int d;
  private int e;
  private int f;
  
  static
  {
    jdField_a_of_type_Int = -1;
    int i = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().widthPixels;
    jdField_b_of_type_Int = a(i);
    jdField_c_of_type_Int = i;
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
    int j = paramInt1 + paramInt2;
    int k = paramResources.getDisplayMetrics().heightPixels;
    int i;
    if (j <= k)
    {
      i = j;
      if (j <= k * 0.6F) {}
    }
    else
    {
      i = (int)(k * 0.6F);
    }
    j = i;
    if (i < XPanelContainer.jdField_b_of_type_Int + paramInt2) {
      j = XPanelContainer.jdField_b_of_type_Int + paramInt2;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPanel", 2, String.format("adjustPanelHeight [maxPanelH,toolbarH,screenH,ExternalH,dstHeight]=[%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(XPanelContainer.jdField_b_of_type_Int), Integer.valueOf(j) }));
    }
    return j;
  }
  
  public static int a(BaseChatPie paramBaseChatPie)
  {
    int i = 0;
    InputLinearLayout localInputLinearLayout = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
    paramBaseChatPie = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
    if (localInputLinearLayout != null) {
      i = 0 + localInputLinearLayout.getHeight();
    }
    int j = i;
    if (paramBaseChatPie != null) {
      j = i + paramBaseChatPie.getHeight();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPanel", 2, "getToolbarHeight =" + j);
    }
    return j;
  }
  
  private void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramBaseChatPie == null) {
      return;
    }
    this.e = a(paramBaseChatPie);
    this.f = (a(getResources(), paramInt, this.e) - this.e);
  }
  
  private void c()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Adcx = new adcx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = this.jdField_a_of_type_Adcx.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine().a(this.jdField_a_of_type_Adcx);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeAllViewsInLayout();
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.removeAllViews();
      }
      if (this.jdField_a_of_type_Adcx != null) {
        this.jdField_a_of_type_Adcx.a();
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public int a()
  {
    this.d = b();
    QLog.d("ConfessPanel", 2, "getDefaultExternalPanelheight , orginal:" + XPanelContainer.jdField_a_of_type_Int + " return:" + this.d);
    return this.d;
  }
  
  public void a()
  {
    QLog.d("ConfessPanel", 2, "unInit");
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPanel", 2, "onActivityResult, requestCode = " + paramInt);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      WebViewPlugin localWebViewPlugin = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine().a(42, true);
      if (localWebViewPlugin != null) {
        localWebViewPlugin.onActivityResult(paramIntent, (byte)1, -1);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, jdField_b_of_type_Int);
    jdField_a_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131364605));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPanel", 2, "onHide :" + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = false;
    this.d = 0;
    if (!paramBoolean) {
      XPanelContainer.jdField_a_of_type_Int = jdField_a_of_type_Int;
    }
    QLog.d("ConfessPanel", 2, "set mExternalPanelheight :" + XPanelContainer.jdField_a_of_type_Int);
    if (this.jdField_c_of_type_Boolean) {
      d();
    }
    setVisibility(8);
  }
  
  public int b()
  {
    if ((BaseApplicationImpl.sApplication != null) && (BaseApplicationImpl.sApplication.getResources() != null))
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof View))
      {
        int i = ((View)localViewParent).getWidth();
        if ((jdField_c_of_type_Int != i) && (i > 0))
        {
          jdField_c_of_type_Int = i;
          QLog.d("ConfessPanel", 2, "getPanelHeight , sLastScreenWidth:" + jdField_c_of_type_Int + " winwidth:" + i);
          int j = a(i);
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, j);
          QLog.d("ConfessPanel", 2, "getPanelHeight , sLastScreenWidth:" + jdField_c_of_type_Int + " winwidth:" + i + " nWinHeight:" + j);
          return this.f;
        }
      }
    }
    QLog.d("ConfessPanel", 2, "getPanelHeight , use max height:" + this.f);
    return this.f;
  }
  
  public void b()
  {
    jdField_a_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    QLog.d("ConfessPanel", 2, "onShow mOriginPanelHeight:" + jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    this.d = b();
    XPanelContainer.jdField_a_of_type_Int = this.d;
    QLog.d("ConfessPanel", 2, "set mExternalPanelheight :" + XPanelContainer.jdField_a_of_type_Int);
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      c();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getStringExtra("url");
      if (QLog.isColorLevel()) {
        QLog.d("ConfessPanel", 2, "onShow url :" + str);
      }
      this.jdField_a_of_type_Adcx.a(str);
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Boolean)
    {
      if (XPanelContainer.jdField_a_of_type_Int == this.d) {
        XPanelContainer.jdField_a_of_type_Int = jdField_a_of_type_Int;
      }
      QLog.d("ConfessPanel", 2, "onDetachedFromWindow, set mExternalPanelheight :" + XPanelContainer.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessPanel
 * JD-Core Version:    0.7.0.1
 */
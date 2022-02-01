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
  public static int a = -1;
  public static final int b;
  public static int c;
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private ConfessWebViewBuilder jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessWebViewBuilder;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public QQAppInterface a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private boolean c;
  private int d;
  private int e;
  private int f;
  
  static
  {
    int i = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().widthPixels;
    jdField_b_of_type_Int = a(i);
    jdField_c_of_type_Int = i;
  }
  
  public ConfessPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public ConfessPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
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
    InputLinearLayout localInputLinearLayout = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
    paramBaseChatPie = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
    int i = 0;
    if (localInputLinearLayout != null) {
      i = 0 + localInputLinearLayout.getHeight();
    }
    int j = i;
    if (paramBaseChatPie != null) {
      j = i + paramBaseChatPie.getHeight();
    }
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("getToolbarHeight =");
      paramBaseChatPie.append(j);
      QLog.d("ConfessPanel", 2, paramBaseChatPie.toString());
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessWebViewBuilder = new ConfessWebViewBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessWebViewBuilder.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessWebViewBuilder);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeAllViewsInLayout();
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.removeAllViews();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessWebViewBuilder;
      if (localObject != null) {
        ((ConfessWebViewBuilder)localObject).a();
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public int a()
  {
    this.d = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDefaultExternalPanelheight , orginal:");
    localStringBuilder.append(XPanelContainer.jdField_a_of_type_Int);
    localStringBuilder.append(" return:");
    localStringBuilder.append(this.d);
    QLog.d("ConfessPanel", 2, localStringBuilder.toString());
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, requestCode = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine().a(WebViewUtil.a("QQApi"), true);
      if (localObject != null) {
        ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)1, -1);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, jdField_b_of_type_Int);
    jdField_a_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365070));
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
    this.jdField_a_of_type_Boolean = false;
    this.d = 0;
    if (!paramBoolean) {
      XPanelContainer.jdField_a_of_type_Int = jdField_a_of_type_Int;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set mExternalPanelheight :");
    localStringBuilder.append(XPanelContainer.jdField_a_of_type_Int);
    QLog.d("ConfessPanel", 2, localStringBuilder.toString());
    if (this.jdField_c_of_type_Boolean) {
      d();
    }
    setVisibility(8);
  }
  
  public int b()
  {
    if ((BaseApplicationImpl.sApplication != null) && (BaseApplicationImpl.sApplication.getResources() != null))
    {
      localObject = getParent();
      if ((localObject instanceof View))
      {
        int i = ((View)localObject).getWidth();
        if ((jdField_c_of_type_Int != i) && (i > 0))
        {
          jdField_c_of_type_Int = i;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getPanelHeight , sLastScreenWidth:");
          ((StringBuilder)localObject).append(jdField_c_of_type_Int);
          ((StringBuilder)localObject).append(" winwidth:");
          ((StringBuilder)localObject).append(i);
          QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
          int j = a(i);
          a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, j);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getPanelHeight , sLastScreenWidth:");
          ((StringBuilder)localObject).append(jdField_c_of_type_Int);
          ((StringBuilder)localObject).append(" winwidth:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" nWinHeight:");
          ((StringBuilder)localObject).append(j);
          QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
          return this.f;
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPanelHeight , use max height:");
    ((StringBuilder)localObject).append(this.f);
    QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
    return this.f;
  }
  
  public void b()
  {
    jdField_a_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onShow mOriginPanelHeight:");
    ((StringBuilder)localObject).append(jdField_a_of_type_Int);
    QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Boolean = true;
    this.d = b();
    XPanelContainer.jdField_a_of_type_Int = this.d;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set mExternalPanelheight :");
    ((StringBuilder)localObject).append(XPanelContainer.jdField_a_of_type_Int);
    QLog.d("ConfessPanel", 2, ((StringBuilder)localObject).toString());
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      c();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getIntent().getStringExtra("url");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onShow url :");
        localStringBuilder.append((String)localObject);
        QLog.d("ConfessPanel", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessWebViewBuilder.a((String)localObject);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetachedFromWindow, set mExternalPanelheight :");
      localStringBuilder.append(XPanelContainer.jdField_a_of_type_Int);
      QLog.d("ConfessPanel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessPanel
 * JD-Core Version:    0.7.0.1
 */
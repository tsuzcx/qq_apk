package com.tencent.biz.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import aobw;
import bhzg;
import com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import yxh;

@TargetApi(9)
public class CustomScrollView
  extends RelativeLayout
  implements TouchWebView.OnOverScrollHandler
{
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private bhzg jdField_a_of_type_Bhzg;
  private PublicAccountCompactSwipeBackLayout jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout;
  private boolean jdField_a_of_type_Boolean = true;
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " springBack y:" + paramInt);
    }
    if (this.jdField_a_of_type_Bhzg.a(getScrollX(), getScrollY(), 0, 0, -paramInt, 0)) {
      invalidate();
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
    this.jdField_a_of_type_Bhzg = new bhzg(getContext());
    try
    {
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.a(paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.a(paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.b(paramBoolean);
    }
  }
  
  public void computeScroll()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " computeScroll:");
    }
    if ((this.jdField_a_of_type_Bhzg != null) && (this.jdField_a_of_type_Bhzg.b()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.jdField_a_of_type_Bhzg.a();
      int m = this.jdField_a_of_type_Bhzg.b();
      if (((i != k) || (j != m)) && (Build.VERSION.SDK_INT >= 9)) {
        overScrollBy(k - i, m - j, i, j, 0, 0, 0, 5000, false);
      }
      postInvalidate();
    }
  }
  
  public void onBack()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, "onBack:");
    }
    if (this.jdField_a_of_type_Bhzg.a(getScrollX(), getScrollY(), 0, 0, 0, 0)) {
      invalidate();
    }
  }
  
  public void onOverScroll(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " onOverScroll y:" + paramInt);
    }
    if ((this.jdField_a_of_type_Boolean) && (Build.VERSION.SDK_INT >= 9))
    {
      if (getScrollY() + paramInt <= 0) {
        break label91;
      }
      paramInt = -getScrollY();
    }
    label91:
    for (;;)
    {
      if (a()) {
        overScrollBy(0, paramInt, getScrollX(), getScrollY(), 0, 0, 0, 5000, true);
      }
      return;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " onOverScrolled");
    }
    if (!this.jdField_a_of_type_Bhzg.a())
    {
      super.scrollTo(paramInt1, paramInt2);
      if ((paramBoolean1) || (paramBoolean2)) {
        this.jdField_a_of_type_Bhzg.a(getScrollX(), getScrollY(), 0, 0, 0, 0);
      }
    }
    for (;;)
    {
      awakenScrollBars();
      return;
      super.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void setOnFlingGesture(yxh paramyxh)
  {
    if ((paramyxh instanceof WebViewFragment))
    {
      Object localObject = ((WebViewFragment)paramyxh).getActivity();
      if ((localObject != null) && ((localObject instanceof QQBrowserActivity)))
      {
        localObject = ((QQBrowserActivity)localObject).a();
        if (localObject != null)
        {
          localObject = ((aobw)localObject).a();
          if ((localObject instanceof PublicAccountCompactSwipeBackLayout)) {
            this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout = ((PublicAccountCompactSwipeBackLayout)localObject);
          }
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.setWebViewFragment((WebViewFragment)paramyxh);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.ui.CustomScrollView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import ubc;

public class PublicAccountCompactSwipeBackLayout
  extends SwipePostTableLayout
{
  protected WebViewFragment a;
  protected ubc a;
  private boolean g = true;
  private boolean h;
  
  public PublicAccountCompactSwipeBackLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Ubc = new ubc();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Ubc.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Ubc.a(paramString, new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setWebViewFragment(WebViewFragment paramWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = paramWebViewFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */
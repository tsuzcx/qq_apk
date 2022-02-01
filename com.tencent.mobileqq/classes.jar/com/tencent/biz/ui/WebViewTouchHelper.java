package com.tencent.biz.ui;

import com.tencent.widget.OverScroller;
import com.tencent.widget.ScrollView;

public class WebViewTouchHelper
{
  private static final String jdField_a_of_type_JavaLangString = "WebViewTouchHelper";
  private float jdField_a_of_type_Float;
  public int a;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  public OverScroller a;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  public boolean a;
  
  public WebViewTouchHelper(ScrollView paramScrollView, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    this.jdField_a_of_type_ComTencentWidgetScrollView = paramScrollView;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentWidgetScrollView != null)
    {
      TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if (localTouchWebView == null) {
        return;
      }
      if ((this.jdField_a_of_type_Float > 0.0F) && (!localTouchWebView.canScrollVertically(-1)) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetScrollView.canScrollVertically(-1))) {
        this.jdField_a_of_type_ComTencentWidgetScrollView.fling((int)-this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.WebViewTouchHelper
 * JD-Core Version:    0.7.0.1
 */
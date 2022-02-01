package com.tencent.biz.lebasearch;

import android.widget.LinearLayout;
import com.tencent.biz.lebasearch.widget.LebaSearchBounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;

class LebaSearchPluginManagerActivity$4
  implements BounceScrollView.OnScrollChangedListener
{
  LebaSearchPluginManagerActivity$4(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
    double d2 = this.a.b;
    double d3 = LebaSearchPluginManagerActivity.jdField_a_of_type_Double;
    Double.isNaN(d2);
    Double.isNaN(d1);
    double d4 = this.a.jdField_a_of_type_Float * 56.0F;
    Double.isNaN(d4);
    paramInt1 = (int)(d1 - d2 * (1.0D - d3) + d4);
    this.a.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.setMaxOverScrollY(paramInt1);
    if (LebaSearchPluginManagerActivity.a(this.a))
    {
      this.a.a(paramInt2);
      LebaSearchPluginManagerActivity.b(this.a, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity.4
 * JD-Core Version:    0.7.0.1
 */
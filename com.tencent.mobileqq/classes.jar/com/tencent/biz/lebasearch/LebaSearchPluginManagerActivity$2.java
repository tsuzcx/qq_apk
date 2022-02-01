package com.tencent.biz.lebasearch;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.Window;

class LebaSearchPluginManagerActivity$2
  implements View.OnLayoutChangeListener
{
  LebaSearchPluginManagerActivity$2(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = this.a.getWindow().getDecorView().getBottom() - this.a.getWindow().getDecorView().getTop();
    if (paramInt1 != this.a.b) {
      LebaSearchPluginManagerActivity.a(this.a, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity.2
 * JD-Core Version:    0.7.0.1
 */
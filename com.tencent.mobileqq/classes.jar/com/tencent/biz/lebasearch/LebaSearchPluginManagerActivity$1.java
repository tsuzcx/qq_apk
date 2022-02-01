package com.tencent.biz.lebasearch;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

class LebaSearchPluginManagerActivity$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  LebaSearchPluginManagerActivity$1(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i = this.a.getWindow().getDecorView().getBottom();
    int j = this.a.getWindow().getDecorView().getTop();
    LebaSearchPluginManagerActivity.a(this.a, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity.1
 * JD-Core Version:    0.7.0.1
 */
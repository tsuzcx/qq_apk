package com.tencent.gdtad.basics.motivevideo;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.gdtad.log.GdtLog;

class GdtMotiveVideoDialog$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GdtMotiveVideoDialog$4(GdtMotiveVideoDialog paramGdtMotiveVideoDialog, ViewGroup paramViewGroup, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGlobalLayout: l=");
    localStringBuilder.append(this.a.getLeft());
    localStringBuilder.append(",t=");
    localStringBuilder.append(this.a.getTop());
    localStringBuilder.append(",r=");
    localStringBuilder.append(this.a.getRight());
    localStringBuilder.append(",b=");
    localStringBuilder.append(this.a.getBottom());
    GdtLog.a("GdtMotiveVideoDialog", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGlobalLayout: ");
    localStringBuilder.append(this.b);
    GdtLog.a("GdtMotiveVideoDialog", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog.4
 * JD-Core Version:    0.7.0.1
 */
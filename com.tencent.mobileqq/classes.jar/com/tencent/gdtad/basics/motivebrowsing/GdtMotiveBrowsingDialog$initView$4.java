package com.tencent.gdtad.basics.motivebrowsing;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingDialog$initView$4", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingDialog$initView$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GdtMotiveBrowsingDialog$initView$4(ViewGroup paramViewGroup) {}
  
  public void onGlobalLayout()
  {
    this.b.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGlobalLayout:");
    localStringBuilder.append(GdtMotiveBrowsingDialog.c(this.a));
    localStringBuilder.append(" l=");
    localStringBuilder.append(this.b.getLeft());
    localStringBuilder.append(",t=");
    localStringBuilder.append(this.b.getTop());
    localStringBuilder.append(",r=");
    localStringBuilder.append(this.b.getRight());
    localStringBuilder.append(",b=");
    localStringBuilder.append(this.b.getBottom());
    QLog.i("GdtMotiveBrowsingDialog", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog.initView.4
 * JD-Core Version:    0.7.0.1
 */
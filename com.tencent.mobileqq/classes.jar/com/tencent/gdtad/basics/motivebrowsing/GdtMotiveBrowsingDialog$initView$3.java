package com.tencent.gdtad.basics.motivebrowsing;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingDialog$initView$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingDialog$initView$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GdtMotiveBrowsingDialog$initView$3(ViewGroup paramViewGroup) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGlobalLayout:");
    localStringBuilder.append(GdtMotiveBrowsingDialog.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingDialog));
    localStringBuilder.append(" l=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
    localStringBuilder.append(",t=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewViewGroup.getTop());
    localStringBuilder.append(",r=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewViewGroup.getRight());
    localStringBuilder.append(",b=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewViewGroup.getBottom());
    QLog.i("GdtMotiveBrowsingDialog", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog.initView.3
 * JD-Core Version:    0.7.0.1
 */
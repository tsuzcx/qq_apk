package com.tencent.gdtad.api.motivebrowsing;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingDialog$initView$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingDialog$initView$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GdtMotiveBrowsingDialog$initView$3(ViewGroup paramViewGroup) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    QLog.i("GdtMotiveBrowsingDialog", 1, "onGlobalLayout:" + GdtMotiveBrowsingDialog.a(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog) + " l=" + this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + ",t=" + this.jdField_a_of_type_AndroidViewViewGroup.getTop() + ",r=" + this.jdField_a_of_type_AndroidViewViewGroup.getRight() + ",b=" + this.jdField_a_of_type_AndroidViewViewGroup.getBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog.initView.3
 * JD-Core Version:    0.7.0.1
 */
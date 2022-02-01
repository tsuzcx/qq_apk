package com.tencent.gdtad.basics.motivebrowsing;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"}, k=3, mv={1, 1, 16})
final class GdtMotiveBrowsingDialog$initView$3
  implements DialogInterface.OnShowListener
{
  GdtMotiveBrowsingDialog$initView$3(GdtMotiveBrowsingDialog paramGdtMotiveBrowsingDialog) {}
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = GdtMotiveBrowsingDialog.b(this.a);
    Object localObject1 = null;
    if (paramDialogInterface != null) {
      paramDialogInterface = Integer.valueOf(paramDialogInterface.getRequestedOrientation());
    } else {
      paramDialogInterface = null;
    }
    if (paramDialogInterface.intValue() == 0)
    {
      paramDialogInterface = GdtMotiveBrowsingDialog.c(this.a);
      if (paramDialogInterface != null) {
        paramDialogInterface = Integer.valueOf(paramDialogInterface.getMeasuredHeight());
      } else {
        paramDialogInterface = null;
      }
      Object localObject2 = GdtMotiveBrowsingDialog.c(this.a);
      if (localObject2 != null) {
        localObject1 = Integer.valueOf(((View)localObject2).getMeasuredWidth());
      }
      if ((paramDialogInterface != null) && (paramDialogInterface.intValue() != 0) && (localObject1 != null))
      {
        if (((Integer)localObject1).intValue() == 0) {
          return;
        }
        localObject2 = GdtMotiveBrowsingDialog.c(this.a);
        if (localObject2 != null) {
          ((View)localObject2).setPivotX(0.0F);
        }
        localObject2 = GdtMotiveBrowsingDialog.c(this.a);
        if (localObject2 != null) {
          ((View)localObject2).setPivotY(0.0F);
        }
        localObject2 = GdtMotiveBrowsingDialog.c(this.a);
        if (localObject2 != null)
        {
          localObject2 = ((View)localObject2).animate();
          if (localObject2 != null)
          {
            localObject2 = ((ViewPropertyAnimator)localObject2).translationY(paramDialogInterface.intValue() * 1.0F);
            if (localObject2 != null) {
              ((ViewPropertyAnimator)localObject2).rotation(-90.0F);
            }
          }
        }
        paramDialogInterface = new FrameLayout.LayoutParams(paramDialogInterface.intValue(), ((Integer)localObject1).intValue());
        paramDialogInterface.leftMargin = 0;
        paramDialogInterface.topMargin = 0;
        localObject1 = GdtMotiveBrowsingDialog.c(this.a);
        if (localObject1 != null) {
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)paramDialogInterface);
        }
        paramDialogInterface = GdtMotiveBrowsingDialog.c(this.a);
        if (paramDialogInterface != null) {
          paramDialogInterface.requestLayout();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog.initView.3
 * JD-Core Version:    0.7.0.1
 */
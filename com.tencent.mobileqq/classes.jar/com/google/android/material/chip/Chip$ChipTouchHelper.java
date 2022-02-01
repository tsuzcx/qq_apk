package com.google.android.material.chip;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R.string;
import java.util.List;

class Chip$ChipTouchHelper
  extends ExploreByTouchHelper
{
  Chip$ChipTouchHelper(Chip paramChip1, Chip paramChip2)
  {
    super(paramChip2);
  }
  
  protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    if ((Chip.b(this.a)) && (Chip.c(this.a).contains(paramFloat1, paramFloat2))) {
      return 1;
    }
    return 0;
  }
  
  protected void getVisibleVirtualViews(@NonNull List<Integer> paramList)
  {
    paramList.add(Integer.valueOf(0));
    if ((Chip.b(this.a)) && (this.a.c()) && (Chip.d(this.a) != null)) {
      paramList.add(Integer.valueOf(1));
    }
  }
  
  protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 == 16)
    {
      if (paramInt1 == 0) {
        return this.a.performClick();
      }
      if (paramInt1 == 1) {
        return this.a.b();
      }
    }
    return false;
  }
  
  protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramAccessibilityNodeInfoCompat.setCheckable(this.a.d());
    paramAccessibilityNodeInfoCompat.setClickable(this.a.isClickable());
    if ((!this.a.d()) && (!this.a.isClickable()))
    {
      paramAccessibilityNodeInfoCompat.setClassName("android.view.View");
    }
    else
    {
      if (this.a.d()) {
        localObject = "android.widget.CompoundButton";
      } else {
        localObject = "android.widget.Button";
      }
      paramAccessibilityNodeInfoCompat.setClassName((CharSequence)localObject);
    }
    Object localObject = this.a.getText();
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramAccessibilityNodeInfoCompat.setText((CharSequence)localObject);
      return;
    }
    paramAccessibilityNodeInfoCompat.setContentDescription((CharSequence)localObject);
  }
  
  protected void onPopulateNodeForVirtualView(int paramInt, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramInt == 1)
    {
      Object localObject = this.a.getCloseIconContentDescription();
      if (localObject != null)
      {
        paramAccessibilityNodeInfoCompat.setContentDescription((CharSequence)localObject);
      }
      else
      {
        localObject = this.a.getText();
        Context localContext = this.a.getContext();
        paramInt = R.string.t;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          localObject = "";
        }
        paramAccessibilityNodeInfoCompat.setContentDescription(localContext.getString(paramInt, new Object[] { localObject }).trim());
      }
      paramAccessibilityNodeInfoCompat.setBoundsInParent(Chip.e(this.a));
      paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
      paramAccessibilityNodeInfoCompat.setEnabled(this.a.isEnabled());
      return;
    }
    paramAccessibilityNodeInfoCompat.setContentDescription("");
    paramAccessibilityNodeInfoCompat.setBoundsInParent(Chip.f());
  }
  
  protected void onVirtualViewKeyboardFocusChanged(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      Chip.a(this.a, paramBoolean);
      this.a.refreshDrawableState();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.chip.Chip.ChipTouchHelper
 * JD-Core Version:    0.7.0.1
 */
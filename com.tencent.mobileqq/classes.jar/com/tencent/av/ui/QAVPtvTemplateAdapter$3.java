package com.tencent.av.ui;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class QAVPtvTemplateAdapter$3
  extends AccessibilityDelegateCompat
{
  QAVPtvTemplateAdapter$3(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, int paramInt) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    boolean bool = true;
    paramAccessibilityNodeInfoCompat.setCheckable(true);
    if (this.a != this.b.j) {
      bool = false;
    }
    paramAccessibilityNodeInfoCompat.setChecked(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter.3
 * JD-Core Version:    0.7.0.1
 */
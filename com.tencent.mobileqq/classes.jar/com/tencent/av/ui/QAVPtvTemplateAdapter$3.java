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
    boolean bool = true;
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setCheckable(true);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.d) {}
    for (;;)
    {
      paramAccessibilityNodeInfoCompat.setChecked(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter.3
 * JD-Core Version:    0.7.0.1
 */
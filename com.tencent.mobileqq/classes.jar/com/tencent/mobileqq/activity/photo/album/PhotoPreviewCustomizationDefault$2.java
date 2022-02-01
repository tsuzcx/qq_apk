package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.widget.NumberCheckBox;

class PhotoPreviewCustomizationDefault$2
  extends View.AccessibilityDelegate
{
  PhotoPreviewCustomizationDefault$2(PhotoPreviewCustomizationDefault paramPhotoPreviewCustomizationDefault) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setCheckable(true);
    paramAccessibilityNodeInfo.setChecked(this.a.s().m.isChecked());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault.2
 * JD-Core Version:    0.7.0.1
 */
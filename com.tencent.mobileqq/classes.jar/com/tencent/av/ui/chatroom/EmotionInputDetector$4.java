package com.tencent.av.ui.chatroom;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.text.TextUtils;

class EmotionInputDetector$4
  extends AccessibilityDelegateCompat
{
  EmotionInputDetector$4(EmotionInputDetector paramEmotionInputDetector) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramView = TextUtils.emoticonToTextForTalkBack(((EditText)paramView).getText().toString());
    paramAccessibilityNodeInfoCompat.setText(paramView);
    paramAccessibilityNodeInfoCompat.setContentDescription(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector.4
 * JD-Core Version:    0.7.0.1
 */
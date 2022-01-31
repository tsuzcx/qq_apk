package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityRecordCompatJellyBean
{
  public static void setSource(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setSource(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityRecordCompatJellyBean
 * JD-Core Version:    0.7.0.1
 */
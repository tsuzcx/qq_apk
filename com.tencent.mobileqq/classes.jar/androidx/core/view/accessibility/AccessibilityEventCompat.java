package androidx.core.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

public final class AccessibilityEventCompat
{
  public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
  public static final int CONTENT_CHANGE_TYPE_PANE_APPEARED = 16;
  public static final int CONTENT_CHANGE_TYPE_PANE_DISAPPEARED = 32;
  public static final int CONTENT_CHANGE_TYPE_PANE_TITLE = 8;
  public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
  public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
  public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
  public static final int TYPES_ALL_MASK = -1;
  public static final int TYPE_ANNOUNCEMENT = 16384;
  public static final int TYPE_ASSIST_READING_CONTEXT = 16777216;
  public static final int TYPE_GESTURE_DETECTION_END = 524288;
  public static final int TYPE_GESTURE_DETECTION_START = 262144;
  @Deprecated
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
  @Deprecated
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
  public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
  public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
  public static final int TYPE_VIEW_CONTEXT_CLICKED = 8388608;
  @Deprecated
  public static final int TYPE_VIEW_HOVER_ENTER = 128;
  @Deprecated
  public static final int TYPE_VIEW_HOVER_EXIT = 256;
  @Deprecated
  public static final int TYPE_VIEW_SCROLLED = 4096;
  @Deprecated
  public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
  public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
  public static final int TYPE_WINDOWS_CHANGED = 4194304;
  @Deprecated
  public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
  
  @Deprecated
  public static void appendRecord(AccessibilityEvent paramAccessibilityEvent, AccessibilityRecordCompat paramAccessibilityRecordCompat)
  {
    paramAccessibilityEvent.appendRecord((AccessibilityRecord)paramAccessibilityRecordCompat.getImpl());
  }
  
  @Deprecated
  public static AccessibilityRecordCompat asRecord(AccessibilityEvent paramAccessibilityEvent)
  {
    return new AccessibilityRecordCompat(paramAccessibilityEvent);
  }
  
  public static int getAction(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramAccessibilityEvent.getAction();
    }
    return 0;
  }
  
  public static int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramAccessibilityEvent.getContentChangeTypes();
    }
    return 0;
  }
  
  public static int getMovementGranularity(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramAccessibilityEvent.getMovementGranularity();
    }
    return 0;
  }
  
  @Deprecated
  public static AccessibilityRecordCompat getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    return new AccessibilityRecordCompat(paramAccessibilityEvent.getRecord(paramInt));
  }
  
  @Deprecated
  public static int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
  {
    return paramAccessibilityEvent.getRecordCount();
  }
  
  public static void setAction(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramAccessibilityEvent.setAction(paramInt);
    }
  }
  
  public static void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramAccessibilityEvent.setContentChangeTypes(paramInt);
    }
  }
  
  public static void setMovementGranularity(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramAccessibilityEvent.setMovementGranularity(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityEventCompat
 * JD-Core Version:    0.7.0.1
 */
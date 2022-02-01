package androidx.core.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;

public class AccessibilityNodeInfoCompat$AccessibilityActionCompat
{
  public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
  public static final AccessibilityActionCompat ACTION_CLICK;
  public static final AccessibilityActionCompat ACTION_COLLAPSE;
  public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
  public static final AccessibilityActionCompat ACTION_COPY;
  public static final AccessibilityActionCompat ACTION_CUT;
  public static final AccessibilityActionCompat ACTION_DISMISS;
  public static final AccessibilityActionCompat ACTION_EXPAND;
  public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
  public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
  public static final AccessibilityActionCompat ACTION_LONG_CLICK;
  public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;
  public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
  public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
  @NonNull
  public static final AccessibilityActionCompat ACTION_PAGE_DOWN;
  @NonNull
  public static final AccessibilityActionCompat ACTION_PAGE_LEFT;
  @NonNull
  public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;
  @NonNull
  public static final AccessibilityActionCompat ACTION_PAGE_UP;
  public static final AccessibilityActionCompat ACTION_PASTE;
  public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
  public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
  public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
  public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
  public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
  public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
  public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
  public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
  public static final AccessibilityActionCompat ACTION_SCROLL_UP;
  public static final AccessibilityActionCompat ACTION_SELECT;
  public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
  public static final AccessibilityActionCompat ACTION_SET_SELECTION;
  public static final AccessibilityActionCompat ACTION_SET_TEXT;
  public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
  public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
  private static final String TAG = "A11yActionCompat";
  final Object mAction;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected final AccessibilityViewCommand mCommand;
  private final int mId;
  private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;
  
  static
  {
    ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
    ACTION_SELECT = new AccessibilityActionCompat(4, null);
    ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
    ACTION_CLICK = new AccessibilityActionCompat(16, null);
    ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
    ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
    ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
    ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
    ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
    ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null, AccessibilityViewCommand.MoveHtmlArguments.class);
    ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null, AccessibilityViewCommand.MoveHtmlArguments.class);
    ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
    ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
    ACTION_COPY = new AccessibilityActionCompat(16384, null);
    ACTION_PASTE = new AccessibilityActionCompat(32768, null);
    ACTION_CUT = new AccessibilityActionCompat(65536, null);
    ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null, AccessibilityViewCommand.SetSelectionArguments.class);
    ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
    ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
    ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
    ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null, AccessibilityViewCommand.SetTextArguments.class);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
      ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(localAccessibilityAction, 16908342, null, null, null);
      if (Build.VERSION.SDK_INT < 23) {
        break label732;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
      label343:
      ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(localAccessibilityAction, 16908343, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
      if (Build.VERSION.SDK_INT < 23) {
        break label737;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
      label372:
      ACTION_SCROLL_UP = new AccessibilityActionCompat(localAccessibilityAction, 16908344, null, null, null);
      if (Build.VERSION.SDK_INT < 23) {
        break label742;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
      label400:
      ACTION_SCROLL_LEFT = new AccessibilityActionCompat(localAccessibilityAction, 16908345, null, null, null);
      if (Build.VERSION.SDK_INT < 23) {
        break label747;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
      label428:
      ACTION_SCROLL_DOWN = new AccessibilityActionCompat(localAccessibilityAction, 16908346, null, null, null);
      if (Build.VERSION.SDK_INT < 23) {
        break label752;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
      label456:
      ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(localAccessibilityAction, 16908347, null, null, null);
      if (Build.VERSION.SDK_INT < 29) {
        break label757;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
      label484:
      ACTION_PAGE_UP = new AccessibilityActionCompat(localAccessibilityAction, 16908358, null, null, null);
      if (Build.VERSION.SDK_INT < 29) {
        break label762;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
      label512:
      ACTION_PAGE_DOWN = new AccessibilityActionCompat(localAccessibilityAction, 16908359, null, null, null);
      if (Build.VERSION.SDK_INT < 29) {
        break label767;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
      label540:
      ACTION_PAGE_LEFT = new AccessibilityActionCompat(localAccessibilityAction, 16908360, null, null, null);
      if (Build.VERSION.SDK_INT < 29) {
        break label772;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
      label568:
      ACTION_PAGE_RIGHT = new AccessibilityActionCompat(localAccessibilityAction, 16908361, null, null, null);
      if (Build.VERSION.SDK_INT < 23) {
        break label777;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
      label596:
      ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(localAccessibilityAction, 16908348, null, null, null);
      if (Build.VERSION.SDK_INT < 24) {
        break label782;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
      label624:
      ACTION_SET_PROGRESS = new AccessibilityActionCompat(localAccessibilityAction, 16908349, null, null, AccessibilityViewCommand.SetProgressArguments.class);
      if (Build.VERSION.SDK_INT < 26) {
        break label787;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
      label653:
      ACTION_MOVE_WINDOW = new AccessibilityActionCompat(localAccessibilityAction, 16908354, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
      if (Build.VERSION.SDK_INT < 28) {
        break label792;
      }
      localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
      label682:
      ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(localAccessibilityAction, 16908356, null, null, null);
      if (Build.VERSION.SDK_INT < 28) {
        break label797;
      }
    }
    label772:
    label777:
    label782:
    label787:
    label792:
    label797:
    for (AccessibilityNodeInfo.AccessibilityAction localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;; localAccessibilityAction = null)
    {
      ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(localAccessibilityAction, 16908357, null, null, null);
      return;
      localAccessibilityAction = null;
      break;
      label732:
      localAccessibilityAction = null;
      break label343;
      label737:
      localAccessibilityAction = null;
      break label372;
      label742:
      localAccessibilityAction = null;
      break label400;
      label747:
      localAccessibilityAction = null;
      break label428;
      label752:
      localAccessibilityAction = null;
      break label456;
      label757:
      localAccessibilityAction = null;
      break label484;
      label762:
      localAccessibilityAction = null;
      break label512;
      label767:
      localAccessibilityAction = null;
      break label540;
      localAccessibilityAction = null;
      break label568;
      localAccessibilityAction = null;
      break label596;
      localAccessibilityAction = null;
      break label624;
      localAccessibilityAction = null;
      break label653;
      localAccessibilityAction = null;
      break label682;
    }
  }
  
  public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence)
  {
    this(null, paramInt, paramCharSequence, null, null);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence, AccessibilityViewCommand paramAccessibilityViewCommand)
  {
    this(null, paramInt, paramCharSequence, paramAccessibilityViewCommand, null);
  }
  
  private AccessibilityNodeInfoCompat$AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence, Class<? extends AccessibilityViewCommand.CommandArguments> paramClass)
  {
    this(null, paramInt, paramCharSequence, null, paramClass);
  }
  
  AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object paramObject)
  {
    this(paramObject, 0, null, null, null);
  }
  
  AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object paramObject, int paramInt, CharSequence paramCharSequence, AccessibilityViewCommand paramAccessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> paramClass)
  {
    this.mId = paramInt;
    this.mCommand = paramAccessibilityViewCommand;
    if ((Build.VERSION.SDK_INT >= 21) && (paramObject == null)) {}
    for (this.mAction = new AccessibilityNodeInfo.AccessibilityAction(paramInt, paramCharSequence);; this.mAction = paramObject)
    {
      this.mViewCommandArgumentClass = paramClass;
      return;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public AccessibilityActionCompat createReplacementAction(CharSequence paramCharSequence, AccessibilityViewCommand paramAccessibilityViewCommand)
  {
    return new AccessibilityActionCompat(null, this.mId, paramCharSequence, paramAccessibilityViewCommand, this.mViewCommandArgumentClass);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof AccessibilityActionCompat));
      paramObject = (AccessibilityActionCompat)paramObject;
      if (this.mAction != null) {
        break;
      }
    } while (paramObject.mAction != null);
    while (this.mAction.equals(paramObject.mAction)) {
      return true;
    }
    return false;
  }
  
  public int getId()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getId();
    }
    return 0;
  }
  
  public CharSequence getLabel()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getLabel();
    }
    return null;
  }
  
  public int hashCode()
  {
    if (this.mAction != null) {
      return this.mAction.hashCode();
    }
    return 0;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean perform(View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    String str;
    if (this.mCommand != null)
    {
      str = null;
      if (this.mViewCommandArgumentClass == null) {
        break label138;
      }
    }
    for (;;)
    {
      try
      {
        AccessibilityViewCommand.CommandArguments localCommandArguments = (AccessibilityViewCommand.CommandArguments)this.mViewCommandArgumentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (this.mViewCommandArgumentClass != null) {}
      }
      catch (Exception localException1)
      {
        try
        {
          localCommandArguments.setBundle(paramBundle);
          paramBundle = localCommandArguments;
          bool = this.mCommand.perform(paramView, paramBundle);
          return bool;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            paramBundle = localException1;
            Exception localException2 = localException3;
          }
        }
        localException1 = localException1;
        paramBundle = str;
      }
      for (str = "null";; str = this.mViewCommandArgumentClass.getName())
      {
        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + str, localException1);
        break;
      }
      label138:
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat
 * JD-Core Version:    0.7.0.1
 */
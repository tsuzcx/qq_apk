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
  public static final AccessibilityActionCompat ACTION_FOCUS;
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
    Object localObject2 = null;
    ACTION_FOCUS = new AccessibilityActionCompat(1, null);
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
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
    } else {
      localObject1 = null;
    }
    ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(localObject1, 16908342, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
    } else {
      localObject1 = null;
    }
    ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(localObject1, 16908343, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
    } else {
      localObject1 = null;
    }
    ACTION_SCROLL_UP = new AccessibilityActionCompat(localObject1, 16908344, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
    } else {
      localObject1 = null;
    }
    ACTION_SCROLL_LEFT = new AccessibilityActionCompat(localObject1, 16908345, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
    } else {
      localObject1 = null;
    }
    ACTION_SCROLL_DOWN = new AccessibilityActionCompat(localObject1, 16908346, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
    } else {
      localObject1 = null;
    }
    ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(localObject1, 16908347, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
    } else {
      localObject1 = null;
    }
    ACTION_PAGE_UP = new AccessibilityActionCompat(localObject1, 16908358, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
    } else {
      localObject1 = null;
    }
    ACTION_PAGE_DOWN = new AccessibilityActionCompat(localObject1, 16908359, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
    } else {
      localObject1 = null;
    }
    ACTION_PAGE_LEFT = new AccessibilityActionCompat(localObject1, 16908360, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
    } else {
      localObject1 = null;
    }
    ACTION_PAGE_RIGHT = new AccessibilityActionCompat(localObject1, 16908361, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
    } else {
      localObject1 = null;
    }
    ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(localObject1, 16908348, null, null, null);
    if (Build.VERSION.SDK_INT >= 24) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
    } else {
      localObject1 = null;
    }
    ACTION_SET_PROGRESS = new AccessibilityActionCompat(localObject1, 16908349, null, null, AccessibilityViewCommand.SetProgressArguments.class);
    if (Build.VERSION.SDK_INT >= 26) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
    } else {
      localObject1 = null;
    }
    ACTION_MOVE_WINDOW = new AccessibilityActionCompat(localObject1, 16908354, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
    if (Build.VERSION.SDK_INT >= 28) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
    } else {
      localObject1 = null;
    }
    ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(localObject1, 16908356, null, null, null);
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 28) {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
    }
    ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(localObject1, 16908357, null, null, null);
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
    if ((Build.VERSION.SDK_INT >= 21) && (paramObject == null)) {
      this.mAction = new AccessibilityNodeInfo.AccessibilityAction(paramInt, paramCharSequence);
    } else {
      this.mAction = paramObject;
    }
    this.mViewCommandArgumentClass = paramClass;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public AccessibilityActionCompat createReplacementAction(CharSequence paramCharSequence, AccessibilityViewCommand paramAccessibilityViewCommand)
  {
    return new AccessibilityActionCompat(null, this.mId, paramCharSequence, paramAccessibilityViewCommand, this.mViewCommandArgumentClass);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof AccessibilityActionCompat)) {
      return false;
    }
    paramObject = (AccessibilityActionCompat)paramObject;
    Object localObject = this.mAction;
    if (localObject == null)
    {
      if (paramObject.mAction != null) {
        return false;
      }
    }
    else if (!localObject.equals(paramObject.mAction)) {
      return false;
    }
    return true;
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
    Object localObject = this.mAction;
    if (localObject != null) {
      return localObject.hashCode();
    }
    return 0;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean perform(View paramView, Bundle paramBundle)
  {
    if (this.mCommand != null)
    {
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject4 = this.mViewCommandArgumentClass;
      Bundle localBundle;
      if (localObject4 != null)
      {
        try
        {
          localObject1 = (AccessibilityViewCommand.CommandArguments)((Class)localObject4).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
          try
          {
            ((AccessibilityViewCommand.CommandArguments)localObject1).setBundle(paramBundle);
          }
          catch (Exception localException2)
          {
            paramBundle = (Bundle)localObject1;
            localObject1 = localException2;
          }
          localObject3 = this.mViewCommandArgumentClass;
        }
        catch (Exception localException1)
        {
          paramBundle = localException2;
        }
        Object localObject3;
        if (localObject3 == null) {
          localObject3 = "null";
        } else {
          localObject3 = ((Class)localObject3).getName();
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("Failed to execute command with argument class ViewCommandArgument: ");
        ((StringBuilder)localObject4).append((String)localObject3);
        Log.e("A11yActionCompat", ((StringBuilder)localObject4).toString(), localException1);
        localBundle = paramBundle;
      }
      return this.mCommand.perform(paramView, localBundle);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat
 * JD-Core Version:    0.7.0.1
 */
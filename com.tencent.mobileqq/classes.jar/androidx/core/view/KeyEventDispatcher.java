package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class KeyEventDispatcher
{
  private static boolean sActionBarFieldsFetched = false;
  private static Method sActionBarOnMenuKeyMethod = null;
  private static boolean sDialogFieldsFetched = false;
  private static Field sDialogKeyListenerField = null;
  
  private static boolean actionBarOnMenuKeyEventPre28(ActionBar paramActionBar, KeyEvent paramKeyEvent)
  {
    if (!sActionBarFieldsFetched) {}
    try
    {
      sActionBarOnMenuKeyMethod = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      label27:
      sActionBarFieldsFetched = true;
      if (sActionBarOnMenuKeyMethod != null) {}
      try
      {
        boolean bool = ((Boolean)sActionBarOnMenuKeyMethod.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue();
        return bool;
      }
      catch (InvocationTargetException paramActionBar)
      {
        return false;
      }
      catch (IllegalAccessException paramActionBar)
      {
        label62:
        break label62;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
  }
  
  private static boolean activitySuperDispatchKeyEventPre28(Activity paramActivity, KeyEvent paramKeyEvent)
  {
    paramActivity.onUserInteraction();
    Object localObject = paramActivity.getWindow();
    if (((Window)localObject).hasFeature(8))
    {
      ActionBar localActionBar = paramActivity.getActionBar();
      if ((paramKeyEvent.getKeyCode() != 82) || (localActionBar == null) || (!actionBarOnMenuKeyEventPre28(localActionBar, paramKeyEvent))) {}
    }
    do
    {
      do
      {
        return true;
      } while (((Window)localObject).superDispatchKeyEvent(paramKeyEvent));
      localObject = ((Window)localObject).getDecorView();
    } while (ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)localObject, paramKeyEvent));
    if (localObject != null) {}
    for (localObject = ((View)localObject).getKeyDispatcherState();; localObject = null) {
      return paramKeyEvent.dispatch(paramActivity, (KeyEvent.DispatcherState)localObject, paramActivity);
    }
  }
  
  private static boolean dialogSuperDispatchKeyEventPre28(Dialog paramDialog, KeyEvent paramKeyEvent)
  {
    Object localObject = getDialogKeyListenerPre28(paramDialog);
    if ((localObject != null) && (((DialogInterface.OnKeyListener)localObject).onKey(paramDialog, paramKeyEvent.getKeyCode(), paramKeyEvent))) {}
    do
    {
      do
      {
        return true;
        localObject = paramDialog.getWindow();
      } while (((Window)localObject).superDispatchKeyEvent(paramKeyEvent));
      localObject = ((Window)localObject).getDecorView();
    } while (ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)localObject, paramKeyEvent));
    if (localObject != null) {}
    for (localObject = ((View)localObject).getKeyDispatcherState();; localObject = null) {
      return paramKeyEvent.dispatch(paramDialog, (KeyEvent.DispatcherState)localObject, paramDialog);
    }
  }
  
  public static boolean dispatchBeforeHierarchy(@NonNull View paramView, @NonNull KeyEvent paramKeyEvent)
  {
    return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(paramView, paramKeyEvent);
  }
  
  public static boolean dispatchKeyEvent(@NonNull KeyEventDispatcher.Component paramComponent, @Nullable View paramView, @Nullable Window.Callback paramCallback, @NonNull KeyEvent paramKeyEvent)
  {
    if (paramComponent == null) {}
    do
    {
      return false;
      if (Build.VERSION.SDK_INT >= 28) {
        return paramComponent.superDispatchKeyEvent(paramKeyEvent);
      }
      if ((paramCallback instanceof Activity)) {
        return activitySuperDispatchKeyEventPre28((Activity)paramCallback, paramKeyEvent);
      }
      if ((paramCallback instanceof Dialog)) {
        return dialogSuperDispatchKeyEventPre28((Dialog)paramCallback, paramKeyEvent);
      }
    } while (((paramView == null) || (!ViewCompat.dispatchUnhandledKeyEventBeforeCallback(paramView, paramKeyEvent))) && (!paramComponent.superDispatchKeyEvent(paramKeyEvent)));
    return true;
  }
  
  private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog paramDialog)
  {
    if (!sDialogFieldsFetched) {}
    try
    {
      sDialogKeyListenerField = Dialog.class.getDeclaredField("mOnKeyListener");
      sDialogKeyListenerField.setAccessible(true);
      label23:
      sDialogFieldsFetched = true;
      if (sDialogKeyListenerField != null) {
        try
        {
          paramDialog = (DialogInterface.OnKeyListener)sDialogKeyListenerField.get(paramDialog);
          return paramDialog;
        }
        catch (IllegalAccessException paramDialog) {}
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.KeyEventDispatcher
 * JD-Core Version:    0.7.0.1
 */
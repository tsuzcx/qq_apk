package androidx.appcompat.app;

import android.os.Build.VERSION;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.SupportActionModeWrapper.CallbackWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.List;

class AppCompatDelegateImpl$AppCompatWindowCallback
  extends WindowCallbackWrapper
{
  AppCompatDelegateImpl$AppCompatWindowCallback(AppCompatDelegateImpl paramAppCompatDelegateImpl, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.this$0.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (this.this$0.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
  }
  
  public void onContentChanged() {}
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) && (!(paramMenu instanceof MenuBuilder))) {
      return false;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    super.onMenuOpened(paramInt, paramMenu);
    this.this$0.onMenuOpened(paramInt);
    return true;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
    this.this$0.onPanelClosed(paramInt);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    MenuBuilder localMenuBuilder;
    if ((paramMenu instanceof MenuBuilder)) {
      localMenuBuilder = (MenuBuilder)paramMenu;
    } else {
      localMenuBuilder = null;
    }
    if ((paramInt == 0) && (localMenuBuilder == null)) {
      return false;
    }
    if (localMenuBuilder != null) {
      localMenuBuilder.setOverrideVisibleItems(true);
    }
    boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
    if (localMenuBuilder != null) {
      localMenuBuilder.setOverrideVisibleItems(false);
    }
    return bool;
  }
  
  @RequiresApi(24)
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = this.this$0.getPanelState(0, true);
    if ((localPanelFeatureState != null) && (localPanelFeatureState.menu != null))
    {
      super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.menu, paramInt);
      return;
    }
    super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return null;
    }
    if (this.this$0.isHandleNativeActionModesEnabled()) {
      return startAsSupportActionMode(paramCallback);
    }
    return super.onWindowStartingActionMode(paramCallback);
  }
  
  @RequiresApi(23)
  public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    if ((this.this$0.isHandleNativeActionModesEnabled()) && (paramInt == 0)) {
      return startAsSupportActionMode(paramCallback);
    }
    return super.onWindowStartingActionMode(paramCallback, paramInt);
  }
  
  final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback paramCallback)
  {
    paramCallback = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, paramCallback);
    androidx.appcompat.view.ActionMode localActionMode = this.this$0.startSupportActionMode(paramCallback);
    if (localActionMode != null) {
      return paramCallback.getActionModeWrapper(localActionMode);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback
 * JD-Core Version:    0.7.0.1
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import java.lang.ref.WeakReference;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar$ActionModeImpl
  extends ActionMode
  implements MenuBuilder.Callback
{
  private final Context mActionModeContext;
  private ActionMode.Callback mCallback;
  private WeakReference<View> mCustomView;
  private final MenuBuilder mMenu;
  
  public WindowDecorActionBar$ActionModeImpl(WindowDecorActionBar paramWindowDecorActionBar, Context paramContext, ActionMode.Callback paramCallback)
  {
    this.mActionModeContext = paramContext;
    this.mCallback = paramCallback;
    this.mMenu = new MenuBuilder(paramContext).setDefaultShowAsAction(1);
    this.mMenu.setCallback(this);
  }
  
  public boolean dispatchOnCreate()
  {
    this.mMenu.stopDispatchingItemsChanged();
    try
    {
      boolean bool = this.mCallback.onCreateActionMode(this, this.mMenu);
      return bool;
    }
    finally
    {
      this.mMenu.startDispatchingItemsChanged();
    }
  }
  
  public void finish()
  {
    if (this.this$0.mActionMode != this) {
      return;
    }
    if (!WindowDecorActionBar.checkShowingFlags(this.this$0.mHiddenByApp, this.this$0.mHiddenBySystem, false))
    {
      WindowDecorActionBar localWindowDecorActionBar = this.this$0;
      localWindowDecorActionBar.mDeferredDestroyActionMode = this;
      localWindowDecorActionBar.mDeferredModeDestroyCallback = this.mCallback;
    }
    else
    {
      this.mCallback.onDestroyActionMode(this);
    }
    this.mCallback = null;
    this.this$0.animateToMode(false);
    this.this$0.mContextView.closeMode();
    this.this$0.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
    this.this$0.mOverlayLayout.setHideOnContentScrollEnabled(this.this$0.mHideOnContentScroll);
    this.this$0.mActionMode = null;
  }
  
  public View getCustomView()
  {
    WeakReference localWeakReference = this.mCustomView;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    return this.mMenu;
  }
  
  public MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(this.mActionModeContext);
  }
  
  public CharSequence getSubtitle()
  {
    return this.this$0.mContextView.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return this.this$0.mContextView.getTitle();
  }
  
  public void invalidate()
  {
    if (this.this$0.mActionMode != this) {
      return;
    }
    this.mMenu.stopDispatchingItemsChanged();
    try
    {
      this.mCallback.onPrepareActionMode(this, this.mMenu);
      return;
    }
    finally
    {
      this.mMenu.startDispatchingItemsChanged();
    }
  }
  
  public boolean isTitleOptional()
  {
    return this.this$0.mContextView.isTitleOptional();
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
  
  public boolean onMenuItemSelected(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    paramMenuBuilder = this.mCallback;
    if (paramMenuBuilder != null) {
      return paramMenuBuilder.onActionItemClicked(this, paramMenuItem);
    }
    return false;
  }
  
  public void onMenuModeChange(@NonNull MenuBuilder paramMenuBuilder)
  {
    if (this.mCallback == null) {
      return;
    }
    invalidate();
    this.this$0.mContextView.showOverflowMenu();
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (this.mCallback == null) {
      return false;
    }
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return true;
    }
    new MenuPopupHelper(this.this$0.getThemedContext(), paramSubMenuBuilder).show();
    return true;
  }
  
  public void setCustomView(View paramView)
  {
    this.this$0.mContextView.setCustomView(paramView);
    this.mCustomView = new WeakReference(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(this.this$0.mContext.getResources().getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.this$0.mContextView.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.this$0.mContext.getResources().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.this$0.mContextView.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.this$0.mContextView.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.WindowDecorActionBar.ActionModeImpl
 * JD-Core Version:    0.7.0.1
 */
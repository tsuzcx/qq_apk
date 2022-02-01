package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi(16)
class MenuItemWrapperICS$ActionProviderWrapperJB
  extends MenuItemWrapperICS.ActionProviderWrapper
  implements android.view.ActionProvider.VisibilityListener
{
  private androidx.core.view.ActionProvider.VisibilityListener mListener;
  
  MenuItemWrapperICS$ActionProviderWrapperJB(MenuItemWrapperICS paramMenuItemWrapperICS, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramMenuItemWrapperICS, paramContext, paramActionProvider);
  }
  
  public boolean isVisible()
  {
    return this.mInner.isVisible();
  }
  
  public void onActionProviderVisibilityChanged(boolean paramBoolean)
  {
    androidx.core.view.ActionProvider.VisibilityListener localVisibilityListener = this.mListener;
    if (localVisibilityListener != null) {
      localVisibilityListener.onActionProviderVisibilityChanged(paramBoolean);
    }
  }
  
  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return this.mInner.onCreateActionView(paramMenuItem);
  }
  
  public boolean overridesItemVisibility()
  {
    return this.mInner.overridesItemVisibility();
  }
  
  public void refreshVisibility()
  {
    this.mInner.refreshVisibility();
  }
  
  public void setVisibilityListener(androidx.core.view.ActionProvider.VisibilityListener paramVisibilityListener)
  {
    this.mListener = paramVisibilityListener;
    ActionProvider localActionProvider = this.mInner;
    if (paramVisibilityListener != null) {
      paramVisibilityListener = this;
    } else {
      paramVisibilityListener = null;
    }
    localActionProvider.setVisibilityListener(paramVisibilityListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.MenuItemWrapperICS.ActionProviderWrapperJB
 * JD-Core Version:    0.7.0.1
 */
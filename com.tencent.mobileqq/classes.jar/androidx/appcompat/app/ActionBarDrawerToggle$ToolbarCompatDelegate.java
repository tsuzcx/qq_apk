package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;

class ActionBarDrawerToggle$ToolbarCompatDelegate
  implements ActionBarDrawerToggle.Delegate
{
  final CharSequence mDefaultContentDescription;
  final Drawable mDefaultUpIndicator;
  final Toolbar mToolbar;
  
  ActionBarDrawerToggle$ToolbarCompatDelegate(Toolbar paramToolbar)
  {
    this.mToolbar = paramToolbar;
    this.mDefaultUpIndicator = paramToolbar.getNavigationIcon();
    this.mDefaultContentDescription = paramToolbar.getNavigationContentDescription();
  }
  
  public Context getActionBarThemedContext()
  {
    return this.mToolbar.getContext();
  }
  
  public Drawable getThemeUpIndicator()
  {
    return this.mDefaultUpIndicator;
  }
  
  public boolean isNavigationVisible()
  {
    return true;
  }
  
  public void setActionBarDescription(@StringRes int paramInt)
  {
    if (paramInt == 0)
    {
      this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
      return;
    }
    this.mToolbar.setNavigationContentDescription(paramInt);
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt)
  {
    this.mToolbar.setNavigationIcon(paramDrawable);
    setActionBarDescription(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ActionBarDrawerToggle.ToolbarCompatDelegate
 * JD-Core Version:    0.7.0.1
 */
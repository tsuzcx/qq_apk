package androidx.appcompat.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private final ActionBarDrawerToggle.Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private boolean mDrawerSlideAnimationEnabled = true;
  private boolean mHasCustomUpIndicator;
  private Drawable mHomeAsUpIndicator;
  private final int mOpenDrawerContentDescRes;
  private DrawerArrowDrawable mSlider;
  View.OnClickListener mToolbarNavigationClickListener;
  private boolean mWarnedForDisplayHomeAsUp = false;
  
  ActionBarDrawerToggle(Activity paramActivity, Toolbar paramToolbar, DrawerLayout paramDrawerLayout, DrawerArrowDrawable paramDrawerArrowDrawable, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    if (paramToolbar != null)
    {
      this.mActivityImpl = new ActionBarDrawerToggle.ToolbarCompatDelegate(paramToolbar);
      paramToolbar.setNavigationOnClickListener(new ActionBarDrawerToggle.1(this));
    }
    else if ((paramActivity instanceof ActionBarDrawerToggle.DelegateProvider))
    {
      this.mActivityImpl = ((ActionBarDrawerToggle.DelegateProvider)paramActivity).getDrawerToggleDelegate();
    }
    else
    {
      this.mActivityImpl = new ActionBarDrawerToggle.FrameworkActionBarDelegate(paramActivity);
    }
    this.mDrawerLayout = paramDrawerLayout;
    this.mOpenDrawerContentDescRes = paramInt1;
    this.mCloseDrawerContentDescRes = paramInt2;
    if (paramDrawerArrowDrawable == null) {
      this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
    } else {
      this.mSlider = paramDrawerArrowDrawable;
    }
    this.mHomeAsUpIndicator = getThemeUpIndicator();
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    this(paramActivity, null, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, Toolbar paramToolbar, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    this(paramActivity, paramToolbar, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  private void setPosition(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.mSlider.setVerticalMirror(true);
    } else if (paramFloat == 0.0F) {
      this.mSlider.setVerticalMirror(false);
    }
    this.mSlider.setProgress(paramFloat);
  }
  
  @NonNull
  public DrawerArrowDrawable getDrawerArrowDrawable()
  {
    return this.mSlider;
  }
  
  Drawable getThemeUpIndicator()
  {
    return this.mActivityImpl.getThemeUpIndicator();
  }
  
  public View.OnClickListener getToolbarNavigationClickListener()
  {
    return this.mToolbarNavigationClickListener;
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return this.mDrawerIndicatorEnabled;
  }
  
  public boolean isDrawerSlideAnimationEnabled()
  {
    return this.mDrawerSlideAnimationEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mHasCustomUpIndicator) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    }
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    if (this.mDrawerSlideAnimationEnabled)
    {
      setPosition(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    setPosition(0.0F);
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.mDrawerIndicatorEnabled))
    {
      toggle();
      return true;
    }
    return false;
  }
  
  void setActionBarDescription(int paramInt)
  {
    this.mActivityImpl.setActionBarDescription(paramInt);
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if ((!this.mWarnedForDisplayHomeAsUp) && (!this.mActivityImpl.isNavigationVisible()))
    {
      Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
      this.mWarnedForDisplayHomeAsUp = true;
    }
    this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
  }
  
  public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable paramDrawerArrowDrawable)
  {
    this.mSlider = paramDrawerArrowDrawable;
    syncState();
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (paramBoolean)
      {
        DrawerArrowDrawable localDrawerArrowDrawable = this.mSlider;
        int i;
        if (this.mDrawerLayout.isDrawerOpen(8388611)) {
          i = this.mCloseDrawerContentDescRes;
        } else {
          i = this.mOpenDrawerContentDescRes;
        }
        setActionBarUpIndicator(localDrawerArrowDrawable, i);
      }
      else
      {
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
      }
      this.mDrawerIndicatorEnabled = paramBoolean;
    }
  }
  
  public void setDrawerSlideAnimationEnabled(boolean paramBoolean)
  {
    this.mDrawerSlideAnimationEnabled = paramBoolean;
    if (!paramBoolean) {
      setPosition(0.0F);
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = this.mDrawerLayout.getResources().getDrawable(paramInt);
    } else {
      localDrawable = null;
    }
    setHomeAsUpIndicator(localDrawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      this.mHasCustomUpIndicator = false;
    }
    else
    {
      this.mHomeAsUpIndicator = paramDrawable;
      this.mHasCustomUpIndicator = true;
    }
    if (!this.mDrawerIndicatorEnabled) {
      setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }
  }
  
  public void setToolbarNavigationClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mToolbarNavigationClickListener = paramOnClickListener;
  }
  
  public void syncState()
  {
    if (this.mDrawerLayout.isDrawerOpen(8388611)) {
      setPosition(1.0F);
    } else {
      setPosition(0.0F);
    }
    if (this.mDrawerIndicatorEnabled)
    {
      DrawerArrowDrawable localDrawerArrowDrawable = this.mSlider;
      int i;
      if (this.mDrawerLayout.isDrawerOpen(8388611)) {
        i = this.mCloseDrawerContentDescRes;
      } else {
        i = this.mOpenDrawerContentDescRes;
      }
      setActionBarUpIndicator(localDrawerArrowDrawable, i);
    }
  }
  
  void toggle()
  {
    int i = this.mDrawerLayout.getDrawerLockMode(8388611);
    if ((this.mDrawerLayout.isDrawerVisible(8388611)) && (i != 2))
    {
      this.mDrawerLayout.closeDrawer(8388611);
      return;
    }
    if (i != 1) {
      this.mDrawerLayout.openDrawer(8388611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ActionBarDrawerToggle
 * JD-Core Version:    0.7.0.1
 */
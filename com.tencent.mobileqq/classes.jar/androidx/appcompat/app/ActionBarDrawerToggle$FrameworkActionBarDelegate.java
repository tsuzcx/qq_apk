package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

class ActionBarDrawerToggle$FrameworkActionBarDelegate
  implements ActionBarDrawerToggle.Delegate
{
  private final Activity mActivity;
  private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;
  
  ActionBarDrawerToggle$FrameworkActionBarDelegate(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public Context getActionBarThemedContext()
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null) {
      return localActionBar.getThemedContext();
    }
    return this.mActivity;
  }
  
  public Drawable getThemeUpIndicator()
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      TypedArray localTypedArray = getActionBarThemedContext().obtainStyledAttributes(null, new int[] { 16843531 }, 16843470, 0);
      Drawable localDrawable = localTypedArray.getDrawable(0);
      localTypedArray.recycle();
      return localDrawable;
    }
    return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
  }
  
  public boolean isNavigationVisible()
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
  }
  
  public void setActionBarDescription(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      ActionBar localActionBar = this.mActivity.getActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
    else
    {
      this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
    }
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
        return;
      }
      localActionBar.setDisplayShowHomeEnabled(true);
      this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mActivity, paramDrawable, paramInt);
      localActionBar.setDisplayShowHomeEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ActionBarDrawerToggle.FrameworkActionBarDelegate
 * JD-Core Version:    0.7.0.1
 */
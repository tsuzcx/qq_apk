package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R.attr;
import androidx.appcompat.widget.TintTypedArray;

class AppCompatDelegateImpl$ActionBarDrawableToggleImpl
  implements ActionBarDrawerToggle.Delegate
{
  AppCompatDelegateImpl$ActionBarDrawableToggleImpl(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  public Context getActionBarThemedContext()
  {
    return this.this$0.getActionBarThemedContext();
  }
  
  public Drawable getThemeUpIndicator()
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[] { R.attr.homeAsUpIndicator });
    Drawable localDrawable = localTintTypedArray.getDrawable(0);
    localTintTypedArray.recycle();
    return localDrawable;
  }
  
  public boolean isNavigationVisible()
  {
    ActionBar localActionBar = this.this$0.getSupportActionBar();
    return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
  }
  
  public void setActionBarDescription(int paramInt)
  {
    ActionBar localActionBar = this.this$0.getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = this.this$0.getSupportActionBar();
    if (localActionBar != null)
    {
      localActionBar.setHomeAsUpIndicator(paramDrawable);
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.ActionBarDrawableToggleImpl
 * JD-Core Version:    0.7.0.1
 */
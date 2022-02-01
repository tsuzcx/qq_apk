package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

public abstract interface FragmentManager$BackStackEntry
{
  @Deprecated
  @Nullable
  public abstract CharSequence getBreadCrumbShortTitle();
  
  @Deprecated
  @StringRes
  public abstract int getBreadCrumbShortTitleRes();
  
  @Deprecated
  @Nullable
  public abstract CharSequence getBreadCrumbTitle();
  
  @Deprecated
  @StringRes
  public abstract int getBreadCrumbTitleRes();
  
  public abstract int getId();
  
  @Nullable
  public abstract String getName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager.BackStackEntry
 * JD-Core Version:    0.7.0.1
 */
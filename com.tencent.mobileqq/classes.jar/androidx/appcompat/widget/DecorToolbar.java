package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.core.view.ViewPropertyAnimatorCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract interface DecorToolbar
{
  public abstract void animateToVisibility(int paramInt);
  
  public abstract boolean canShowOverflowMenu();
  
  public abstract void collapseActionView();
  
  public abstract void dismissPopupMenus();
  
  public abstract Context getContext();
  
  public abstract View getCustomView();
  
  public abstract int getDisplayOptions();
  
  public abstract int getDropdownItemCount();
  
  public abstract int getDropdownSelectedPosition();
  
  public abstract int getHeight();
  
  public abstract Menu getMenu();
  
  public abstract int getNavigationMode();
  
  public abstract CharSequence getSubtitle();
  
  public abstract CharSequence getTitle();
  
  public abstract ViewGroup getViewGroup();
  
  public abstract int getVisibility();
  
  public abstract boolean hasEmbeddedTabs();
  
  public abstract boolean hasExpandedActionView();
  
  public abstract boolean hasIcon();
  
  public abstract boolean hasLogo();
  
  public abstract boolean hideOverflowMenu();
  
  public abstract void initIndeterminateProgress();
  
  public abstract void initProgress();
  
  public abstract boolean isOverflowMenuShowPending();
  
  public abstract boolean isOverflowMenuShowing();
  
  public abstract boolean isTitleTruncated();
  
  public abstract void restoreHierarchyState(SparseArray<Parcelable> paramSparseArray);
  
  public abstract void saveHierarchyState(SparseArray<Parcelable> paramSparseArray);
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setCollapsible(boolean paramBoolean);
  
  public abstract void setCustomView(View paramView);
  
  public abstract void setDefaultNavigationContentDescription(int paramInt);
  
  public abstract void setDefaultNavigationIcon(Drawable paramDrawable);
  
  public abstract void setDisplayOptions(int paramInt);
  
  public abstract void setDropdownParams(SpinnerAdapter paramSpinnerAdapter, AdapterView.OnItemSelectedListener paramOnItemSelectedListener);
  
  public abstract void setDropdownSelectedPosition(int paramInt);
  
  public abstract void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView);
  
  public abstract void setHomeButtonEnabled(boolean paramBoolean);
  
  public abstract void setIcon(int paramInt);
  
  public abstract void setIcon(Drawable paramDrawable);
  
  public abstract void setLogo(int paramInt);
  
  public abstract void setLogo(Drawable paramDrawable);
  
  public abstract void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback);
  
  public abstract void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1);
  
  public abstract void setMenuPrepared();
  
  public abstract void setNavigationContentDescription(int paramInt);
  
  public abstract void setNavigationContentDescription(CharSequence paramCharSequence);
  
  public abstract void setNavigationIcon(int paramInt);
  
  public abstract void setNavigationIcon(Drawable paramDrawable);
  
  public abstract void setNavigationMode(int paramInt);
  
  public abstract void setSubtitle(CharSequence paramCharSequence);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract void setVisibility(int paramInt);
  
  public abstract void setWindowCallback(Window.Callback paramCallback);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
  
  public abstract ViewPropertyAnimatorCompat setupAnimatorToVisibility(int paramInt, long paramLong);
  
  public abstract boolean showOverflowMenu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.DecorToolbar
 * JD-Core Version:    0.7.0.1
 */
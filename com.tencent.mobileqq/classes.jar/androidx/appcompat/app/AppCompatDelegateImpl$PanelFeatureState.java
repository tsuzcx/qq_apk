package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;

public final class AppCompatDelegateImpl$PanelFeatureState
{
  int background;
  View createdPanelView;
  ViewGroup decorView;
  int featureId;
  Bundle frozenActionViewState;
  Bundle frozenMenuState;
  int gravity;
  boolean isHandled;
  boolean isOpen;
  boolean isPrepared;
  ListMenuPresenter listMenuPresenter;
  Context listPresenterContext;
  MenuBuilder menu;
  public boolean qwertyMode;
  boolean refreshDecorView;
  boolean refreshMenuContent;
  View shownPanelView;
  boolean wasLastOpen;
  int windowAnimations;
  int x;
  int y;
  
  AppCompatDelegateImpl$PanelFeatureState(int paramInt)
  {
    this.featureId = paramInt;
    this.refreshDecorView = false;
  }
  
  void applyFrozenState()
  {
    MenuBuilder localMenuBuilder = this.menu;
    if (localMenuBuilder != null)
    {
      Bundle localBundle = this.frozenMenuState;
      if (localBundle != null)
      {
        localMenuBuilder.restorePresenterStates(localBundle);
        this.frozenMenuState = null;
      }
    }
  }
  
  public void clearMenuPresenters()
  {
    MenuBuilder localMenuBuilder = this.menu;
    if (localMenuBuilder != null) {
      localMenuBuilder.removeMenuPresenter(this.listMenuPresenter);
    }
    this.listMenuPresenter = null;
  }
  
  MenuView getListMenuView(MenuPresenter.Callback paramCallback)
  {
    if (this.menu == null) {
      return null;
    }
    if (this.listMenuPresenter == null)
    {
      this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, 2131558416);
      this.listMenuPresenter.setCallback(paramCallback);
      this.menu.addMenuPresenter(this.listMenuPresenter);
    }
    return this.listMenuPresenter.getMenuView(this.decorView);
  }
  
  public boolean hasPanelItems()
  {
    View localView = this.shownPanelView;
    boolean bool = false;
    if (localView == null) {
      return false;
    }
    if (this.createdPanelView != null) {
      return true;
    }
    if (this.listMenuPresenter.getAdapter().getCount() > 0) {
      bool = true;
    }
    return bool;
  }
  
  void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AppCompatDelegateImpl.PanelFeatureState.SavedState)paramParcelable;
    this.featureId = paramParcelable.featureId;
    this.wasLastOpen = paramParcelable.isOpen;
    this.frozenMenuState = paramParcelable.menuState;
    this.shownPanelView = null;
    this.decorView = null;
  }
  
  Parcelable onSaveInstanceState()
  {
    AppCompatDelegateImpl.PanelFeatureState.SavedState localSavedState = new AppCompatDelegateImpl.PanelFeatureState.SavedState();
    localSavedState.featureId = this.featureId;
    localSavedState.isOpen = this.isOpen;
    if (this.menu != null)
    {
      localSavedState.menuState = new Bundle();
      this.menu.savePresenterStates(localSavedState.menuState);
    }
    return localSavedState;
  }
  
  void setMenu(MenuBuilder paramMenuBuilder)
  {
    Object localObject = this.menu;
    if (paramMenuBuilder == localObject) {
      return;
    }
    if (localObject != null) {
      ((MenuBuilder)localObject).removeMenuPresenter(this.listMenuPresenter);
    }
    this.menu = paramMenuBuilder;
    if (paramMenuBuilder != null)
    {
      localObject = this.listMenuPresenter;
      if (localObject != null) {
        paramMenuBuilder.addMenuPresenter((MenuPresenter)localObject);
      }
    }
  }
  
  void setStyle(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    Resources.Theme localTheme = paramContext.getResources().newTheme();
    localTheme.setTo(paramContext.getTheme());
    localTheme.resolveAttribute(2131034119, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    localTheme.resolveAttribute(2131034928, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      localTheme.applyStyle(localTypedValue.resourceId, true);
    } else {
      localTheme.applyStyle(2131755631, true);
    }
    paramContext = new ContextThemeWrapper(paramContext, 0);
    paramContext.getTheme().setTo(localTheme);
    this.listPresenterContext = paramContext;
    paramContext = paramContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    this.background = paramContext.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
    this.windowAnimations = paramContext.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState
 * JD-Core Version:    0.7.0.1
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenuItem;
import java.lang.reflect.Method;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuItemWrapperICS
  extends BaseMenuWrapper
  implements MenuItem
{
  static final String LOG_TAG = "MenuItemWrapper";
  private Method mSetExclusiveCheckableMethod;
  private final SupportMenuItem mWrappedObject;
  
  public MenuItemWrapperICS(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext);
    if (paramSupportMenuItem != null)
    {
      this.mWrappedObject = paramSupportMenuItem;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public boolean collapseActionView()
  {
    return this.mWrappedObject.collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return this.mWrappedObject.expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    androidx.core.view.ActionProvider localActionProvider = this.mWrappedObject.getSupportActionProvider();
    if ((localActionProvider instanceof MenuItemWrapperICS.ActionProviderWrapper)) {
      return ((MenuItemWrapperICS.ActionProviderWrapper)localActionProvider).mInner;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = this.mWrappedObject.getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof MenuItemWrapperICS.CollapsibleActionViewWrapper)) {
      localView1 = ((MenuItemWrapperICS.CollapsibleActionViewWrapper)localView2).getWrappedView();
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return this.mWrappedObject.getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return this.mWrappedObject.getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return this.mWrappedObject.getContentDescription();
  }
  
  public int getGroupId()
  {
    return this.mWrappedObject.getGroupId();
  }
  
  public Drawable getIcon()
  {
    return this.mWrappedObject.getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return this.mWrappedObject.getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.mWrappedObject.getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return this.mWrappedObject.getIntent();
  }
  
  public int getItemId()
  {
    return this.mWrappedObject.getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.mWrappedObject.getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return this.mWrappedObject.getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return this.mWrappedObject.getNumericShortcut();
  }
  
  public int getOrder()
  {
    return this.mWrappedObject.getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return getSubMenuWrapper(this.mWrappedObject.getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return this.mWrappedObject.getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return this.mWrappedObject.getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return this.mWrappedObject.getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return this.mWrappedObject.hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return this.mWrappedObject.isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return this.mWrappedObject.isCheckable();
  }
  
  public boolean isChecked()
  {
    return this.mWrappedObject.isChecked();
  }
  
  public boolean isEnabled()
  {
    return this.mWrappedObject.isEnabled();
  }
  
  public boolean isVisible()
  {
    return this.mWrappedObject.isVisible();
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 16) {
      localObject = new MenuItemWrapperICS.ActionProviderWrapperJB(this, this.mContext, paramActionProvider);
    } else {
      localObject = new MenuItemWrapperICS.ActionProviderWrapper(this, this.mContext, paramActionProvider);
    }
    SupportMenuItem localSupportMenuItem = this.mWrappedObject;
    if (paramActionProvider == null) {
      localObject = null;
    }
    localSupportMenuItem.setSupportActionProvider((androidx.core.view.ActionProvider)localObject);
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    this.mWrappedObject.setActionView(paramInt);
    View localView = this.mWrappedObject.getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      this.mWrappedObject.setActionView(new MenuItemWrapperICS.CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new MenuItemWrapperICS.CollapsibleActionViewWrapper(paramView);
    }
    this.mWrappedObject.setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.mWrappedObject.setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.mWrappedObject.setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    this.mWrappedObject.setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    this.mWrappedObject.setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setContentDescription(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    this.mWrappedObject.setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    try
    {
      if (this.mSetExclusiveCheckableMethod == null) {
        this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
      }
      this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.mWrappedObject.setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.mWrappedObject.setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.mWrappedObject.setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.mWrappedObject.setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.mWrappedObject.setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    this.mWrappedObject.setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.mWrappedObject.setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    SupportMenuItem localSupportMenuItem = this.mWrappedObject;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new MenuItemWrapperICS.OnActionExpandListenerWrapper(this, paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localSupportMenuItem.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    SupportMenuItem localSupportMenuItem = this.mWrappedObject;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new MenuItemWrapperICS.OnMenuItemClickListenerWrapper(this, paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localSupportMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.mWrappedObject.setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.mWrappedObject.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    this.mWrappedObject.setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    this.mWrappedObject.setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    this.mWrappedObject.setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setTooltipText(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return this.mWrappedObject.setVisible(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.MenuItemWrapperICS
 * JD-Core Version:    0.7.0.1
 */
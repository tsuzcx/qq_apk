package androidx.appcompat.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.lang.reflect.Constructor;

class SupportMenuInflater$MenuState
{
  private static final int defaultGroupId = 0;
  private static final int defaultItemCategory = 0;
  private static final int defaultItemCheckable = 0;
  private static final boolean defaultItemChecked = false;
  private static final boolean defaultItemEnabled = true;
  private static final int defaultItemId = 0;
  private static final int defaultItemOrder = 0;
  private static final boolean defaultItemVisible = true;
  private int groupCategory;
  private int groupCheckable;
  private boolean groupEnabled;
  private int groupId;
  private int groupOrder;
  private boolean groupVisible;
  ActionProvider itemActionProvider;
  private String itemActionProviderClassName;
  private String itemActionViewClassName;
  private int itemActionViewLayout;
  private boolean itemAdded;
  private int itemAlphabeticModifiers;
  private char itemAlphabeticShortcut;
  private int itemCategoryOrder;
  private int itemCheckable;
  private boolean itemChecked;
  private CharSequence itemContentDescription;
  private boolean itemEnabled;
  private int itemIconResId;
  private ColorStateList itemIconTintList = null;
  private PorterDuff.Mode itemIconTintMode = null;
  private int itemId;
  private String itemListenerMethodName;
  private int itemNumericModifiers;
  private char itemNumericShortcut;
  private int itemShowAsAction;
  private CharSequence itemTitle;
  private CharSequence itemTitleCondensed;
  private CharSequence itemTooltipText;
  private boolean itemVisible;
  private Menu menu;
  
  public SupportMenuInflater$MenuState(SupportMenuInflater paramSupportMenuInflater, Menu paramMenu)
  {
    this.menu = paramMenu;
    resetGroup();
  }
  
  private char getShortcut(String paramString)
  {
    if (paramString == null) {
      return '\000';
    }
    return paramString.charAt(0);
  }
  
  private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = Class.forName(paramString, false, this.this$0.mContext.getClassLoader()).getConstructor(paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("Cannot instantiate class: ");
      paramArrayOfObject.append(paramString);
      Log.w("SupportMenuInflater", paramArrayOfObject.toString(), paramArrayOfClass);
    }
    return null;
  }
  
  private void setItem(MenuItem paramMenuItem)
  {
    Object localObject = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
    int j = this.itemCheckable;
    int i = 0;
    if (j >= 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
    j = this.itemShowAsAction;
    if (j >= 0) {
      paramMenuItem.setShowAsAction(j);
    }
    if (this.itemListenerMethodName != null) {
      if (!this.this$0.mContext.isRestricted()) {
        paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
      } else {
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
    }
    boolean bool = paramMenuItem instanceof MenuItemImpl;
    if (bool) {
      localObject = (MenuItemImpl)paramMenuItem;
    }
    if (this.itemCheckable >= 2) {
      if (bool) {
        ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
      } else if ((paramMenuItem instanceof MenuItemWrapperICS)) {
        ((MenuItemWrapperICS)paramMenuItem).setExclusiveCheckable(true);
      }
    }
    localObject = this.itemActionViewClassName;
    if (localObject != null)
    {
      paramMenuItem.setActionView((View)newInstance((String)localObject, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
      i = 1;
    }
    j = this.itemActionViewLayout;
    if (j > 0) {
      if (i == 0) {
        paramMenuItem.setActionView(j);
      } else {
        Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
    }
    localObject = this.itemActionProvider;
    if (localObject != null) {
      MenuItemCompat.setActionProvider(paramMenuItem, (ActionProvider)localObject);
    }
    MenuItemCompat.setContentDescription(paramMenuItem, this.itemContentDescription);
    MenuItemCompat.setTooltipText(paramMenuItem, this.itemTooltipText);
    MenuItemCompat.setAlphabeticShortcut(paramMenuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
    MenuItemCompat.setNumericShortcut(paramMenuItem, this.itemNumericShortcut, this.itemNumericModifiers);
    localObject = this.itemIconTintMode;
    if (localObject != null) {
      MenuItemCompat.setIconTintMode(paramMenuItem, (PorterDuff.Mode)localObject);
    }
    localObject = this.itemIconTintList;
    if (localObject != null) {
      MenuItemCompat.setIconTintList(paramMenuItem, (ColorStateList)localObject);
    }
  }
  
  public void addItem()
  {
    this.itemAdded = true;
    setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
  }
  
  public SubMenu addSubMenuItem()
  {
    this.itemAdded = true;
    SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
    setItem(localSubMenu.getItem());
    return localSubMenu;
  }
  
  public boolean hasAddedItem()
  {
    return this.itemAdded;
  }
  
  public void readGroup(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = this.this$0.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
    this.groupId = paramAttributeSet.getResourceId(R.styleable.MenuGroup_android_id, 0);
    this.groupCategory = paramAttributeSet.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
    this.groupOrder = paramAttributeSet.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
    this.groupCheckable = paramAttributeSet.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
    this.groupVisible = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_visible, true);
    this.groupEnabled = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_enabled, true);
    paramAttributeSet.recycle();
  }
  
  public void readItem(AttributeSet paramAttributeSet)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void resetGroup()
  {
    this.groupId = 0;
    this.groupCategory = 0;
    this.groupOrder = 0;
    this.groupCheckable = 0;
    this.groupVisible = true;
    this.groupEnabled = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.SupportMenuInflater.MenuState
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class h
  implements MenuItem
{
  private boolean a;
  private boolean b;
  private boolean c = false;
  private int d;
  private int e;
  private CharSequence f;
  private TextUtils.TruncateAt g;
  private CharSequence h = null;
  private boolean i = false;
  private int j;
  private int k;
  private int l;
  private Drawable m;
  private ContextMenu.ContextMenuInfo n;
  private MenuItem.OnMenuItemClickListener o;
  private Intent p;
  private Context q;
  
  public h(Context paramContext, int paramInt1, int paramInt2)
  {
    this.q = paramContext;
    this.d = paramInt1;
    this.e = paramInt2;
    this.l = paramContext.getResources().getColor(2131165265);
  }
  
  public TextUtils.TruncateAt a()
  {
    return this.g;
  }
  
  public MenuItem a(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    return this;
  }
  
  public MenuItem a(Drawable paramDrawable, int paramInt)
  {
    this.m = paramDrawable;
    this.l = paramInt;
    return this;
  }
  
  public MenuItem a(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
    return this;
  }
  
  public MenuItem a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public void a(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.n = paramContextMenuInfo;
  }
  
  public MenuItem b(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public CharSequence b()
  {
    return this.h;
  }
  
  public MenuItem c(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public MenuItem d(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public boolean expandActionView()
  {
    return false;
  }
  
  public boolean f()
  {
    return this.i;
  }
  
  public int g()
  {
    return this.l;
  }
  
  public ActionProvider getActionProvider()
  {
    return null;
  }
  
  public View getActionView()
  {
    return null;
  }
  
  public char getAlphabeticShortcut()
  {
    return '\000';
  }
  
  public int getGroupId()
  {
    return this.e;
  }
  
  public Drawable getIcon()
  {
    Drawable localDrawable = this.m;
    Object localObject = localDrawable;
    if (localDrawable == null)
    {
      if (this.k != 0)
      {
        localObject = this.q;
        if (localObject != null) {
          return ((Context)localObject).getResources().getDrawable(this.k);
        }
      }
      localObject = null;
    }
    return localObject;
  }
  
  public Intent getIntent()
  {
    return this.p;
  }
  
  public int getItemId()
  {
    return this.d;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.n;
  }
  
  public char getNumericShortcut()
  {
    return '\000';
  }
  
  public int getOrder()
  {
    return 0;
  }
  
  public SubMenu getSubMenu()
  {
    return null;
  }
  
  public CharSequence getTitle()
  {
    CharSequence localCharSequence = this.f;
    Object localObject = localCharSequence;
    if (localCharSequence == null)
    {
      int i1 = this.j;
      if (i1 != 0)
      {
        localObject = this.q;
        if (localObject != null) {
          return ((Context)localObject).getString(i1);
        }
      }
      localObject = null;
    }
    return localObject;
  }
  
  public CharSequence getTitleCondensed()
  {
    return null;
  }
  
  public boolean h()
  {
    MenuItem.OnMenuItemClickListener localOnMenuItemClickListener = this.o;
    if (localOnMenuItemClickListener != null) {
      return localOnMenuItemClickListener.onMenuItemClick(this);
    }
    return false;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isActionViewExpanded()
  {
    return false;
  }
  
  public boolean isCheckable()
  {
    return false;
  }
  
  public boolean isChecked()
  {
    return false;
  }
  
  public boolean isEnabled()
  {
    return true;
  }
  
  public boolean isVisible()
  {
    return true;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    return null;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    return null;
  }
  
  public MenuItem setActionView(View paramView)
  {
    return null;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.m = paramDrawable;
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.p = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    return null;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.o = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    return null;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.h
 * JD-Core Version:    0.7.0.1
 */
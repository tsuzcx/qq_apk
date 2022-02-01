package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
  implements ContextMenu
{
  private List<MenuItem> a;
  private CharSequence b;
  private Context c;
  
  public g(Context paramContext)
  {
    this.c = paramContext;
    this.a = new ArrayList();
  }
  
  public MenuItem add(int paramInt)
  {
    h localh = new h(this.c, 0, 0);
    localh.setTitle(paramInt);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, int paramInt2)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramInt2);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramInt2);
    localh.setIcon(paramInt3);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h localh = new h(this.c, paramInt2, paramInt1);
    localh.setTitle(paramInt4);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    h localh = new h(this.c, paramInt2, paramInt1);
    localh.setTitle(paramCharSequence);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence, int paramInt4)
  {
    h localh = new h(this.c, paramInt2, paramInt1);
    localh.setTitle(paramCharSequence);
    localh.setIcon(paramInt4);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    h localh = new h(this.c, paramInt1, 0);
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 0);
    localh.setTitle(paramCharSequence);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt, CharSequence paramCharSequence)
  {
    h localh = new h(this.c, paramInt, 0);
    localh.setTitle(paramCharSequence);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramCharSequence);
    localh.setIcon(paramInt2);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramCharSequence);
    localh.a(paramInt2, paramInt3);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramCharSequence);
    localh.a(paramInt2, paramInt3);
    localh.a(paramBoolean);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramCharSequence);
    localh.setIcon(paramInt2);
    localh.a(paramBoolean);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    h localh = new h(this.c, paramInt, 0);
    localh.setTitle(paramCharSequence);
    localh.setIcon(paramDrawable);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, CharSequence paramCharSequence, Drawable paramDrawable, int paramInt2)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramCharSequence);
    localh.setIcon(paramDrawable);
    localh.a(paramDrawable, paramInt2);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramCharSequence1);
    localh.a(paramCharSequence2);
    localh.setIcon(paramInt2);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramCharSequence1);
    localh.a(paramCharSequence2);
    localh.a(paramInt2, paramInt3);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, int paramInt2, boolean paramBoolean)
  {
    h localh = new h(this.c, paramInt1, 0);
    localh.setTitle(paramCharSequence1);
    localh.a(paramCharSequence2);
    localh.a(paramDrawable, paramInt2);
    localh.a(paramBoolean);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, boolean paramBoolean)
  {
    h localh = new h(this.c, paramInt, 0);
    localh.setTitle(paramCharSequence1);
    localh.a(paramCharSequence2);
    localh.setIcon(paramDrawable);
    localh.a(paramBoolean);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    h localh = new h(this.c, paramInt, 0);
    localh.setTitle(paramCharSequence);
    localh.a(paramBoolean);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    h localh = new h(this.c, paramInt, 0);
    localh.b(paramBoolean1);
    localh.c(paramBoolean2);
    localh.setTitle(paramCharSequence);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(int paramInt, boolean paramBoolean)
  {
    h localh = new h(this.c, paramInt, 0);
    localh.d(paramBoolean);
    this.a.add(localh);
    return localh;
  }
  
  public MenuItem add(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null) {
      this.a.add(paramMenuItem);
    }
    return null;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    h localh = new h(this.c, 0, 0);
    localh.setTitle(paramCharSequence);
    this.a.add(localh);
    return localh;
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    return 0;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return null;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public void clear()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      localh.a(null);
      localh.setOnMenuItemClickListener(null);
    }
    this.a.clear();
    this.b = null;
  }
  
  public void clearHeader() {}
  
  public void close() {}
  
  public MenuItem findItem(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        return localMenuItem;
      }
    }
    return null;
  }
  
  public CharSequence getHeaderTitle()
  {
    return this.b;
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.a.get(paramInt);
  }
  
  public List<MenuItem> getItemList()
  {
    return this.a;
  }
  
  public boolean hasVisibleItems()
  {
    return false;
  }
  
  public boolean isMenuEmpty()
  {
    return this.a.size() == 0;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return false;
  }
  
  public void removeGroup(int paramInt) {}
  
  public void removeItem(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        localArrayList.add(localMenuItem);
      }
    }
    this.a.removeAll(localArrayList);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean) {}
  
  public void setGroupVisible(int paramInt, boolean paramBoolean) {}
  
  public ContextMenu setHeaderIcon(int paramInt)
  {
    return this;
  }
  
  public ContextMenu setHeaderIcon(Drawable paramDrawable)
  {
    return this;
  }
  
  public ContextMenu setHeaderTitle(int paramInt)
  {
    if (paramInt > 0) {
      return setHeaderTitle(this.c.getString(paramInt));
    }
    return this;
  }
  
  public ContextMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return this;
    }
    this.b = paramCharSequence;
    return this;
  }
  
  public ContextMenu setHeaderView(View paramView)
  {
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean) {}
  
  public int size()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.g
 * JD-Core Version:    0.7.0.1
 */
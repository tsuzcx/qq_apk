package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashSet;
import java.util.Iterator;

public class c
{
  private HashSet<View.OnClickListener> a = new HashSet();
  private HashSet<View.OnClickListener> b = new HashSet();
  private HashSet<View.OnClickListener> c = new HashSet();
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null) {
      return;
    }
    this.b.add(paramOnClickListener);
  }
  
  public boolean a(View paramView)
  {
    if (this.b.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    return true;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null) {
      return;
    }
    this.a.add(paramOnClickListener);
  }
  
  public boolean b(View paramView)
  {
    if (this.a.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    return true;
  }
  
  public void c(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null) {
      return;
    }
    this.c.add(paramOnClickListener);
  }
  
  public boolean c(View paramView)
  {
    if (this.c.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.c
 * JD-Core Version:    0.7.0.1
 */
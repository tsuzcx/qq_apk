package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.graphics.drawable.Drawable;
import java.util.LinkedList;

public abstract class j
  extends f
{
  private final LinkedList<j.a> b = new j.1(this);
  
  private void a()
  {
    j.a locala = (j.a)this.b.peekFirst();
    Object localObject2 = null;
    Object localObject1;
    if (locala == null) {
      localObject1 = null;
    } else {
      localObject1 = j.a.a(locala);
    }
    a((CharSequence)localObject1);
    if (locala == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = j.a.b(locala);
    }
    a((Drawable)localObject1);
    int i;
    if (locala == null) {
      i = -2147483648;
    } else {
      i = j.a.c(locala);
    }
    a(i);
  }
  
  public final i.a c()
  {
    j.a locala = new j.a(this);
    this.b.addFirst(locala);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.j
 * JD-Core Version:    0.7.0.1
 */
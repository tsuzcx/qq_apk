package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class c$1$1
  implements View.OnApplyWindowInsetsListener
{
  c$1$1(c.1 param1) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    synchronized (this.a.b)
    {
      c.a(this.a.b, new WindowInsets(paramWindowInsets));
      synchronized (c.a(this.a.b))
      {
        LinkedList localLinkedList = new LinkedList(c.a(this.a.b));
        ??? = localLinkedList.iterator();
        while (((Iterator)???).hasNext()) {
          ((View.OnApplyWindowInsetsListener)((Iterator)???).next()).onApplyWindowInsets(paramView, paramWindowInsets);
        }
        return paramView.onApplyWindowInsets(paramWindowInsets);
      }
    }
    for (;;)
    {
      throw paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c.1.1
 * JD-Core Version:    0.7.0.1
 */
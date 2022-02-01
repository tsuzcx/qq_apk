package com.tencent.mm.plugin.appbrand.page;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class o$12
  implements Iterator<m>
{
  final ListIterator<m> a = o.c(this.b).listIterator();
  
  o$12(o paramo) {}
  
  public m a()
  {
    return (m)this.a.next();
  }
  
  public boolean hasNext()
  {
    return this.a.hasNext();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.12
 * JD-Core Version:    0.7.0.1
 */
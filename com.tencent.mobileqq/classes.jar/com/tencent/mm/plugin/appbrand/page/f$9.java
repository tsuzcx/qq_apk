package com.tencent.mm.plugin.appbrand.page;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class f$9
  implements Iterator<u>
{
  private final Iterator<u> b = f.d(this.a).values().iterator();
  
  f$9(f paramf) {}
  
  public u a()
  {
    return (u)this.b.next();
  }
  
  public boolean hasNext()
  {
    return this.b.hasNext();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f.9
 * JD-Core Version:    0.7.0.1
 */
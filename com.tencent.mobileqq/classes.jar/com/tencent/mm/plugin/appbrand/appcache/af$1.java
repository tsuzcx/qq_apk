package com.tencent.mm.plugin.appbrand.appcache;

import java.util.Iterator;
import java.util.LinkedList;

class af$1
  implements Iterator<ModulePkgInfo>
{
  private boolean b = false;
  private Iterator<ModulePkgInfo> c = null;
  
  af$1(af paramaf) {}
  
  public ModulePkgInfo a()
  {
    if (!this.b)
    {
      this.b = true;
      return this.a;
    }
    return (ModulePkgInfo)this.c.next();
  }
  
  public boolean hasNext()
  {
    if (!this.b) {
      return true;
    }
    if (this.c == null) {
      this.c = this.a.e.iterator();
    }
    return this.c.hasNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.af.1
 * JD-Core Version:    0.7.0.1
 */
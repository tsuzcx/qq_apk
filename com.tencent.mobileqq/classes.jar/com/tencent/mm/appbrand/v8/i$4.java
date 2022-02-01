package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextNodeJS;

class i$4
  implements j.a
{
  i$4(i parami) {}
  
  public boolean a()
  {
    return i.b(this.a).handleMessage();
  }
  
  public void b()
  {
    if (i.b(this.a) != null) {
      i.b(this.a).wakeUpUVLoop();
    }
  }
  
  public void c()
  {
    if (i.b(this.a) != null) {
      i.b(this.a).closeUVLoop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i.4
 * JD-Core Version:    0.7.0.1
 */
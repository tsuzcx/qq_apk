package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.wxa.qw.jn;

class m$8
  implements Runnable
{
  m$8(m paramm, int paramInt, jn paramjn) {}
  
  public void run()
  {
    m localm = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmdId ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", errCode ");
    localStringBuilder.append(this.b.a);
    m.a(localm, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.m.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.beacon.base.net;

import com.tencent.beacon.base.net.a.b;
import com.tencent.beacon.base.net.a.f;

class c
  implements b<a>
{
  c(d paramd, f paramf, b paramb) {}
  
  public void a(a parama)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpRequest: ");
      localStringBuilder.append(this.a.h());
      localStringBuilder.append(" request success!");
      com.tencent.beacon.base.util.c.a("[BeaconNet]", localStringBuilder.toString(), new Object[0]);
      this.b.a(parama);
      d.a(this.c);
      return;
    }
    catch (Exception parama)
    {
      a(new e(this.a.h(), "453", 200, parama.getMessage(), parama));
    }
  }
  
  public void a(e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("httpRequest: ");
    localStringBuilder.append(parame.toString());
    com.tencent.beacon.base.util.c.a("[BeaconNet]", localStringBuilder.toString(), new Object[0]);
    this.c.a(parame);
    this.b.a(parame);
    d.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.map.sdk.a;

public final class pr
  implements hb
{
  private final pn a;
  
  public pr(pn parampn)
  {
    this.a = parampn;
  }
  
  public final void a(int paramInt)
  {
    if (this.a != null)
    {
      if (paramInt != kc.c.c) {
        return;
      }
      pn localpn = this.a;
      paramInt = localpn.az.c();
      localpn.ae = true;
      localpn.af = true;
      if (paramInt <= localpn.ac) {
        localpn.af = false;
      } else if (paramInt >= localpn.ab) {
        localpn.ae = false;
      }
      hj localhj;
      if (localpn.r != null)
      {
        localhj = new hj();
        localhj.a = 0;
        localhj.b = localpn.ae;
        localhj.c = localpn.af;
        localpn.r.a(localhj);
      }
      localpn = this.a;
      if (localpn.r != null)
      {
        localhj = new hj();
        localhj.a = 0;
        localhj.b = localpn.ae;
        localhj.c = localpn.af;
        localpn.r.a(localhj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pr
 * JD-Core Version:    0.7.0.1
 */
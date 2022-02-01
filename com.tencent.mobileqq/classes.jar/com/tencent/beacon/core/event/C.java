package com.tencent.beacon.core.event;

final class C
  implements TunnelModule.a
{
  C(boolean paramBoolean) {}
  
  public void a(h paramh)
  {
    n localn = paramh.c();
    if (localn != null) {
      localn.b(this.a);
    }
    paramh = paramh.e();
    if (paramh != null) {
      paramh.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.C
 * JD-Core Version:    0.7.0.1
 */
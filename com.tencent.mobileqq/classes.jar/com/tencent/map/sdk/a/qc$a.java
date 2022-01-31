package com.tencent.map.sdk.a;

final class qc$a
{
  boolean a = true;
  private int c;
  
  qc$a(qc paramqc, int paramInt)
  {
    this.c = paramInt;
    if (this.c > 3) {
      this.c = 3;
    }
    if (this.c <= 0) {
      this.c = 1;
    }
  }
  
  final boolean a()
  {
    return (this.a) && (this.c > 0);
  }
  
  final void b()
  {
    this.c -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.qc.a
 * JD-Core Version:    0.7.0.1
 */
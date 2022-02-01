package com.huawei.hms.update.a;

import java.io.File;

class d$1
  extends b
{
  private long d = 0L;
  private int e = d.a(this.c).b();
  
  d$1(d paramd, File paramFile, int paramInt1, int paramInt2, String paramString)
  {
    super(paramFile, paramInt1);
  }
  
  private void a(int paramInt)
  {
    d.a(this.c).a(this.c.b(), paramInt, this.b);
    d.a(this.c, 2100, paramInt, this.a);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    this.e += paramInt2;
    if (this.e > 209715200) {}
    do
    {
      return;
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.d) > 1000L)
      {
        this.d = l;
        a(this.e);
      }
    } while (this.e != this.a);
    a(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.a.d.1
 * JD-Core Version:    0.7.0.1
 */
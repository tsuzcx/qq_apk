package com.tencent.liteav.videoencoder;

class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean) {}
  
  public void run()
  {
    b.a(this.d, com.tencent.liteav.basic.opengl.b.a(null, null, null, this.a, this.b));
    boolean[] arrayOfBoolean = this.c;
    int i;
    if (b.a(this.d) != null) {
      i = 1;
    } else {
      i = 0;
    }
    arrayOfBoolean[0] = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.a;

class h$w
  implements h.x
{
  private byte[] a = new byte[8];
  private int b = 0;
  private float[] c = new float[16];
  private int d = 0;
  
  private void a(byte paramByte)
  {
    int i = this.b;
    byte[] arrayOfByte1 = this.a;
    if (i == arrayOfByte1.length)
    {
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length * 2];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
      this.a = arrayOfByte2;
    }
    arrayOfByte1 = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte1[i] = paramByte;
  }
  
  private void a(int paramInt)
  {
    float[] arrayOfFloat1 = this.c;
    if (arrayOfFloat1.length < this.d + paramInt)
    {
      float[] arrayOfFloat2 = new float[arrayOfFloat1.length * 2];
      System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, arrayOfFloat1.length);
      this.c = arrayOfFloat2;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a((byte)0);
    a(2);
    float[] arrayOfFloat = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a((byte)3);
    a(4);
    float[] arrayOfFloat = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat2;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat3;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat4;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a((byte)2);
    a(6);
    float[] arrayOfFloat = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat2;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat3;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat4;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat5;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat6;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
  {
    if (paramBoolean1) {
      i = 2;
    } else {
      i = 0;
    }
    a((byte)(i | 0x4 | paramBoolean2));
    a(5);
    float[] arrayOfFloat = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat2;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat3;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat4;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat5;
  }
  
  void a(h.x paramx)
  {
    int j = 0;
    int i = 0;
    while (j < this.b)
    {
      int k = this.a[j];
      float[] arrayOfFloat;
      float f1;
      if (k != 0)
      {
        if (k != 1)
        {
          float f2;
          float f3;
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 8)
              {
                boolean bool1;
                if ((k & 0x2) != 0) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                boolean bool2;
                if ((k & 0x1) != 0) {
                  bool2 = true;
                } else {
                  bool2 = false;
                }
                arrayOfFloat = this.c;
                k = i + 1;
                f1 = arrayOfFloat[i];
                i = k + 1;
                f2 = arrayOfFloat[k];
                k = i + 1;
                f3 = arrayOfFloat[i];
                i = k + 1;
                paramx.a(f1, f2, f3, bool1, bool2, arrayOfFloat[k], arrayOfFloat[i]);
                i += 1;
              }
              else
              {
                paramx.b();
              }
            }
            else
            {
              arrayOfFloat = this.c;
              k = i + 1;
              f1 = arrayOfFloat[i];
              i = k + 1;
              f2 = arrayOfFloat[k];
              k = i + 1;
              paramx.a(f1, f2, arrayOfFloat[i], arrayOfFloat[k]);
              i = k + 1;
            }
          }
          else
          {
            arrayOfFloat = this.c;
            k = i + 1;
            f1 = arrayOfFloat[i];
            i = k + 1;
            f2 = arrayOfFloat[k];
            k = i + 1;
            f3 = arrayOfFloat[i];
            i = k + 1;
            float f4 = arrayOfFloat[k];
            k = i + 1;
            float f5 = arrayOfFloat[i];
            i = k + 1;
            paramx.a(f1, f2, f3, f4, f5, arrayOfFloat[k]);
          }
        }
        else
        {
          arrayOfFloat = this.c;
          k = i + 1;
          f1 = arrayOfFloat[i];
          i = k + 1;
          paramx.b(f1, arrayOfFloat[k]);
        }
      }
      else
      {
        arrayOfFloat = this.c;
        k = i + 1;
        f1 = arrayOfFloat[i];
        i = k + 1;
        paramx.a(f1, arrayOfFloat[k]);
      }
      j += 1;
    }
  }
  
  boolean a()
  {
    return this.b == 0;
  }
  
  public void b()
  {
    a((byte)8);
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    a((byte)1);
    a(2);
    float[] arrayOfFloat = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    i = this.d;
    this.d = (i + 1);
    arrayOfFloat[i] = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.h.w
 * JD-Core Version:    0.7.0.1
 */
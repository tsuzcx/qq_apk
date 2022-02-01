package com.tencent.luggage.wxa.b;

class e$a
{
  private final byte[] a = new byte[32];
  
  private int b(Object paramObject)
  {
    return paramObject.hashCode() & this.a.length - 1;
  }
  
  int a(Object paramObject)
  {
    int i = b(paramObject);
    return (this.a[i] & 0xFF) - 1;
  }
  
  void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.a;
      if (i >= arrayOfByte.length) {
        break;
      }
      int j = arrayOfByte[i];
      int k = paramInt + 1;
      if (j == k) {
        arrayOfByte[i] = 0;
      } else if (arrayOfByte[i] > k) {
        arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
      }
      i += 1;
    }
  }
  
  void a(String paramString, int paramInt)
  {
    int i = b(paramString);
    if (paramInt < 255)
    {
      this.a[i] = ((byte)(paramInt + 1));
      return;
    }
    this.a[i] = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.e.a
 * JD-Core Version:    0.7.0.1
 */
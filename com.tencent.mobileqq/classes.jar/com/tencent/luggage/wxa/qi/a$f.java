package com.tencent.luggage.wxa.qi;

import com.tencent.luggage.wxa.qz.o;

class a$f
{
  private int[] a = { 1, 1, 1, 1 };
  
  int a()
  {
    return this.a[3];
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    int i = b(paramBoolean, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("request setMostRecentState [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], lastState=");
    ((StringBuilder)localObject).append(this.a[3]);
    ((StringBuilder)localObject).append(",newState=");
    ((StringBuilder)localObject).append(i);
    o.d("MicroMsg.Music.ExoMusicPlayer", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject[3] == i) {
      return;
    }
    localObject[0] = localObject[1];
    localObject[1] = localObject[2];
    localObject[2] = localObject[3];
    localObject[3] = i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MostRecentState [");
    ((StringBuilder)localObject).append(this.a[0]);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.a[1]);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.a[2]);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.a[3]);
    ((StringBuilder)localObject).append("]");
    o.f("MicroMsg.Music.ExoMusicPlayer", ((StringBuilder)localObject).toString());
  }
  
  boolean a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 268435455;
    } else {
      i = -1;
    }
    int k = this.a.length - paramArrayOfInt.length;
    int j = k;
    paramBoolean = true;
    for (;;)
    {
      int[] arrayOfInt = this.a;
      if (j >= arrayOfInt.length) {
        break;
      }
      boolean bool;
      if ((arrayOfInt[j] & i) == (paramArrayOfInt[(j - k)] & i)) {
        bool = true;
      } else {
        bool = false;
      }
      paramBoolean &= bool;
      j += 1;
    }
    return paramBoolean;
  }
  
  int b(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = -268435456;
    } else {
      i = 0;
    }
    return i | paramInt;
  }
  
  boolean b()
  {
    return (this.a[3] & 0xF0000000) != 0;
  }
  
  void c()
  {
    this.a = new int[] { 1, 1, 1, 1 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qi.a.f
 * JD-Core Version:    0.7.0.1
 */
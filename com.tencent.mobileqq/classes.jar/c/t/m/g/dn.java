package c.t.m.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class dn
{
  private static dn a = new dn();
  private static Comparator<byte[]> f = new dn.1();
  private final List<byte[]> b = new ArrayList(32);
  private final List<byte[]> c = new ArrayList(32);
  private int d = 0;
  private int e = 10240;
  
  public static dn a()
  {
    return a;
  }
  
  private void b()
  {
    try
    {
      while (this.d > this.e)
      {
        byte[] arrayOfByte = (byte[])this.b.remove(0);
        this.c.remove(arrayOfByte);
        this.d -= arrayOfByte.length;
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length <= this.e)
        {
          Arrays.fill(paramArrayOfByte, (byte)0);
          this.b.add(paramArrayOfByte);
          int j = Collections.binarySearch(this.c, paramArrayOfByte, f);
          int i = j;
          if (j < 0) {
            i = -j - 1;
          }
          this.c.add(i, paramArrayOfByte);
          this.d += paramArrayOfByte.length;
          b();
          return;
        }
      }
      finally {}
    }
  }
  
  public final byte[] a(int paramInt)
  {
    int i = 0;
    try
    {
      while (i < this.c.size())
      {
        arrayOfByte = (byte[])this.c.get(i);
        if (arrayOfByte.length == paramInt)
        {
          this.d -= arrayOfByte.length;
          this.c.remove(i);
          this.b.remove(arrayOfByte);
          return arrayOfByte;
        }
        i += 1;
      }
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dn
 * JD-Core Version:    0.7.0.1
 */
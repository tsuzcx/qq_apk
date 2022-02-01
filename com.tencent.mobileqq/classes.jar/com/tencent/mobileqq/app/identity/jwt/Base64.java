package com.tencent.mobileqq.app.identity.jwt;

public class Base64
  extends BaseNCodec
{
  static final byte[] a = { 13, 10 };
  private static final byte[] d = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] e = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] f = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  private final byte[] g;
  private final byte[] h = f;
  private final byte[] i;
  private final int j;
  private final int k;
  
  public Base64()
  {
    this(0);
  }
  
  public Base64(int paramInt)
  {
    this(paramInt, a);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(3, 4, paramInt, m);
    if (paramArrayOfByte != null)
    {
      if (!b(paramArrayOfByte))
      {
        if (paramInt > 0)
        {
          this.k = (paramArrayOfByte.length + 4);
          this.i = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, this.i, 0, paramArrayOfByte.length);
        }
        else
        {
          this.k = 4;
          this.i = null;
        }
      }
      else
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("lineSeparator must not contain base64 characters: [");
        localStringBuilder.append(paramArrayOfByte);
        localStringBuilder.append("]");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    else
    {
      this.k = 4;
      this.i = null;
    }
    this.j = (this.k - 1);
    if (paramBoolean) {
      paramArrayOfByte = e;
    } else {
      paramArrayOfByte = d;
    }
    this.g = paramArrayOfByte;
  }
  
  public static byte[] a(String paramString)
  {
    return new Base64().b(paramString);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext)
  {
    if (paramContext.e) {
      return;
    }
    if (paramInt2 < 0) {
      paramContext.e = true;
    }
    int m = 0;
    while (m < paramInt2)
    {
      byte[] arrayOfByte1 = a(this.j, paramContext);
      int n = paramArrayOfByte[paramInt1];
      if (n == 61)
      {
        paramContext.e = true;
        break;
      }
      if (n >= 0)
      {
        byte[] arrayOfByte2 = f;
        if (n < arrayOfByte2.length)
        {
          n = arrayOfByte2[n];
          if (n >= 0)
          {
            paramContext.f = ((paramContext.f + 1) % 4);
            paramContext.a = ((paramContext.a << 6) + n);
            if (paramContext.f == 0)
            {
              n = paramContext.c;
              paramContext.c = (n + 1);
              arrayOfByte1[n] = ((byte)(paramContext.a >> 16 & 0xFF));
              n = paramContext.c;
              paramContext.c = (n + 1);
              arrayOfByte1[n] = ((byte)(paramContext.a >> 8 & 0xFF));
              n = paramContext.c;
              paramContext.c = (n + 1);
              arrayOfByte1[n] = ((byte)(paramContext.a & 0xFF));
            }
          }
        }
      }
      m += 1;
      paramInt1 += 1;
    }
    if ((paramContext.e) && (paramContext.f != 0))
    {
      paramArrayOfByte = a(this.j, paramContext);
      paramInt1 = paramContext.f;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 == 3)
          {
            paramContext.a >>= 2;
            paramInt1 = paramContext.c;
            paramContext.c = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = ((byte)(paramContext.a >> 8 & 0xFF));
            paramInt1 = paramContext.c;
            paramContext.c = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = ((byte)(paramContext.a & 0xFF));
            return;
          }
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("Impossible modulus ");
          paramArrayOfByte.append(paramContext.f);
          throw new IllegalStateException(paramArrayOfByte.toString());
        }
        paramContext.a >>= 4;
        paramInt1 = paramContext.c;
        paramContext.c = (paramInt1 + 1);
        paramArrayOfByte[paramInt1] = ((byte)(paramContext.a & 0xFF));
      }
    }
  }
  
  protected boolean a(byte paramByte)
  {
    if (paramByte >= 0)
    {
      byte[] arrayOfByte = this.h;
      if ((paramByte < arrayOfByte.length) && (arrayOfByte[paramByte] != -1)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.Base64
 * JD-Core Version:    0.7.0.1
 */
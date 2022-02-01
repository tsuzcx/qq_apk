public class bodp
{
  public static void a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m = 0;
    int i = 0;
    int i7 = paramInt1 * paramInt2;
    int j = 0;
    int i4 = 0;
    int n;
    int k;
    int i5;
    int i1;
    if (i4 < paramInt2)
    {
      n = (i4 >> 1) * paramInt1 / 2 + i7;
      k = i7 * 5 / 4 + (i4 >> 1) * paramInt1 / 2;
      i5 = 0;
      if (i5 < paramInt1)
      {
        i1 = (paramArrayOfByte[j] & 0xFF) - 16;
        if (i1 >= 0) {
          break label361;
        }
        i1 = 0;
      }
    }
    label194:
    label202:
    label361:
    for (;;)
    {
      int i2;
      if ((i5 & 0x1) == 0)
      {
        i = paramArrayOfByte[n];
        i2 = paramArrayOfByte[k];
        m = n + 1;
        n = (i2 & 0xFF) - 128;
        i = (i & 0xFF) - 128;
        k += 1;
      }
      for (;;)
      {
        i1 *= 1192;
        i2 = i1 + n * 1634;
        int i3 = i1 - n * 833 - i * 400;
        int i6 = i1 + i * 2066;
        if (i2 < 0)
        {
          i1 = 0;
          if (i3 >= 0) {
            break label296;
          }
          i2 = 0;
          if (i6 >= 0) {
            break label314;
          }
          i3 = 0;
        }
        for (;;)
        {
          paramArrayOfInt[j] = (i3 >> 10 & 0xFF | i2 >> 2 & 0xFF00 | i1 << 6 & 0xFF0000 | 0xFF000000);
          i1 = j + 1;
          j = n;
          i5 += 1;
          n = m;
          m = i;
          i = j;
          j = i1;
          break;
          i1 = i2;
          if (i2 <= 262143) {
            break label194;
          }
          i1 = 262143;
          break label194;
          i2 = i3;
          if (i3 <= 262143) {
            break label202;
          }
          i2 = 262143;
          break label202;
          i3 = i6;
          if (i6 > 262143) {
            i3 = 262143;
          }
        }
        i4 += 1;
        break;
        return;
        i2 = m;
        m = n;
        n = i;
        i = i2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodp
 * JD-Core Version:    0.7.0.1
 */
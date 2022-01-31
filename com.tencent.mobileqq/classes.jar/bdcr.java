public class bdcr
{
  private static char[] a = new char[32];
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  
  public static String a(long paramLong)
  {
    return a(paramLong, 160);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    double d = l;
    int i;
    int m;
    int j;
    label64:
    int k;
    label96:
    char[] arrayOfChar;
    if (l < 1048576L) {
      if (l < 1024L)
      {
        i = 66;
        m = (int)(0.005D + d);
        if (m >= 100) {
          break label259;
        }
        if (m >= 10) {
          break label253;
        }
        j = 1;
        if (i == 66) {
          break label319;
        }
        if ((alnq.a() <= 18.0F) || (paramInt >= 160)) {
          break label293;
        }
        k = j + 2;
        j = m;
        if (k <= a.length) {
          break label332;
        }
        arrayOfChar = new char[k];
        label111:
        m = k - 1;
        arrayOfChar[m] = 'B';
        if (i == 66) {
          break label411;
        }
        if ((alnq.a() <= 18.0F) || (paramInt >= 160)) {
          break label340;
        }
        paramInt = m - 1;
        arrayOfChar[paramInt] = i;
      }
    }
    for (;;)
    {
      paramInt -= 1;
      arrayOfChar[paramInt] = b[(j % 10)];
      m = j / 10;
      j = m;
      if (m <= 0)
      {
        return new String(arrayOfChar, 0, k);
        d /= 1024.0D;
        i = 75;
        break;
        if (l < 1073741824L)
        {
          d /= 1048576.0D;
          i = 77;
          break;
        }
        d /= 1073741824.0D;
        i = 71;
        break;
        label253:
        j = 2;
        break label64;
        label259:
        if (m < 1000)
        {
          j = 3;
          break label64;
        }
        if (m < 10000)
        {
          j = 4;
          break label64;
        }
        j = 5;
        break label64;
        label293:
        m = (int)(d * 100.0D + 0.5D);
        k = j + 5;
        j = m;
        break label96;
        label319:
        k = j + 1;
        j = m;
        break label96;
        label332:
        arrayOfChar = a;
        break label111;
        label340:
        paramInt = m - 1;
        arrayOfChar[paramInt] = i;
        paramInt -= 1;
        arrayOfChar[paramInt] = b[(j % 10)];
        j /= 10;
        paramInt -= 1;
        arrayOfChar[paramInt] = b[(j % 10)];
        j /= 10;
        paramInt -= 1;
        arrayOfChar[paramInt] = '.';
        continue;
        label411:
        paramInt = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcr
 * JD-Core Version:    0.7.0.1
 */
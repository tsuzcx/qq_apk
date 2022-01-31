public class blln
{
  public static String a(long paramLong)
  {
    int m = 0;
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    String str4 = "";
    int j = Math.round((float)(l % 3600000L % 60000L) / 1000.0F);
    int i = (int)(l % 3600000L) / 60000;
    int k = (int)(l / 3600000L);
    if (j == 60)
    {
      i += 1;
      j = 0;
    }
    for (;;)
    {
      if (i == 60)
      {
        k += 1;
        i = m;
      }
      for (;;)
      {
        String str1;
        String str2;
        if (j < 10)
        {
          str1 = "0" + j;
          if (i >= 10) {
            break label249;
          }
          str2 = "0" + i;
          label138:
          if (k >= 10) {
            break label273;
          }
        }
        label273:
        for (String str3 = "0" + k;; str3 = "" + k)
        {
          if (k > 0) {
            str4 = str3 + ":";
          }
          return str4 + str2 + ":" + str1;
          str1 = "" + j;
          break;
          label249:
          str2 = "" + i;
          break label138;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blln
 * JD-Core Version:    0.7.0.1
 */
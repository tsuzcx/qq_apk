package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  private static final int SECONDS_PER_DAY = 86400;
  private static final int SECONDS_PER_HOUR = 3600;
  private static final int SECONDS_PER_MINUTE = 60;
  private static char[] sFormatStr = new char[24];
  private static final Object sFormatSync = new Object();
  
  private static int accumField(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((paramInt1 <= 99) && ((!paramBoolean) || (paramInt3 < 3)))
    {
      if ((paramInt1 <= 9) && ((!paramBoolean) || (paramInt3 < 2)))
      {
        if ((!paramBoolean) && (paramInt1 <= 0)) {
          return 0;
        }
        return paramInt2 + 1;
      }
      return paramInt2 + 2;
    }
    return paramInt2 + 3;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter)
  {
    if (paramLong1 == 0L)
    {
      paramPrintWriter.print("--");
      return;
    }
    formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter)
  {
    formatDuration(paramLong, paramPrintWriter, 0);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt)
  {
    synchronized (sFormatSync)
    {
      paramInt = formatDurationLocked(paramLong, paramInt);
      paramPrintWriter.print(new String(sFormatStr, 0, paramInt));
      return;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder)
  {
    synchronized (sFormatSync)
    {
      int i = formatDurationLocked(paramLong, 0);
      paramStringBuilder.append(sFormatStr, 0, i);
      return;
    }
  }
  
  private static int formatDurationLocked(long paramLong, int paramInt)
  {
    if (sFormatStr.length < paramInt) {
      sFormatStr = new char[paramInt];
    }
    char[] arrayOfChar = sFormatStr;
    if (paramLong == 0L)
    {
      while (paramInt - 1 > 0) {
        arrayOfChar[0] = ' ';
      }
      arrayOfChar[0] = '0';
      return 1;
    }
    int i;
    if (paramLong > 0L)
    {
      i = 43;
    }
    else
    {
      i = 45;
      paramLong = -paramLong;
    }
    int i4 = (int)(paramLong % 1000L);
    int j = (int)Math.floor(paramLong / 1000L);
    if (j > 86400)
    {
      m = j / 86400;
      j -= 86400 * m;
    }
    else
    {
      m = 0;
    }
    int n;
    if (j > 3600)
    {
      n = j / 3600;
      j -= n * 3600;
    }
    else
    {
      n = 0;
    }
    int i1;
    int k;
    if (j > 60)
    {
      i1 = j / 60;
      k = j - i1 * 60;
    }
    else
    {
      i1 = 0;
      k = j;
    }
    boolean bool;
    if (paramInt != 0)
    {
      j = accumField(m, 1, false, 0);
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      j += accumField(n, 1, bool, 2);
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      j += accumField(i1, 1, bool, 2);
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      i2 = j + accumField(k, 1, bool, 2);
      if (i2 > 0) {
        j = 3;
      } else {
        j = 0;
      }
      i2 += accumField(i4, 2, true, j) + 1;
      j = 0;
      for (;;)
      {
        i3 = j;
        if (i2 >= paramInt) {
          break;
        }
        arrayOfChar[j] = ' ';
        j += 1;
        i2 += 1;
      }
    }
    int i3 = 0;
    arrayOfChar[i3] = i;
    int i2 = i3 + 1;
    if (paramInt != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int m = printField(arrayOfChar, m, 'd', i2, false, 0);
    if (m != i2) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt != 0) {
      j = 2;
    } else {
      j = 0;
    }
    m = printField(arrayOfChar, n, 'h', m, bool, j);
    if (m != i2) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt != 0) {
      j = 2;
    } else {
      j = 0;
    }
    m = printField(arrayOfChar, i1, 'm', m, bool, j);
    if (m != i2) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt != 0) {
      j = 2;
    } else {
      j = 0;
    }
    j = printField(arrayOfChar, k, 's', m, bool, j);
    if ((paramInt != 0) && (j != i2)) {
      paramInt = 3;
    } else {
      paramInt = 0;
    }
    paramInt = printField(arrayOfChar, i4, 'm', j, true, paramInt);
    arrayOfChar[paramInt] = 's';
    return paramInt + 1;
  }
  
  private static int printField(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i;
    if (!paramBoolean)
    {
      i = paramInt2;
      if (paramInt1 <= 0) {}
    }
    else
    {
      int j;
      if (((paramBoolean) && (paramInt3 >= 3)) || (paramInt1 > 99))
      {
        j = paramInt1 / 100;
        paramArrayOfChar[paramInt2] = ((char)(j + 48));
        i = paramInt2 + 1;
        paramInt1 -= j * 100;
      }
      else
      {
        i = paramInt2;
      }
      if (((!paramBoolean) || (paramInt3 < 2)) && (paramInt1 <= 9))
      {
        j = i;
        paramInt3 = paramInt1;
        if (paramInt2 == i) {}
      }
      else
      {
        paramInt2 = paramInt1 / 10;
        paramArrayOfChar[i] = ((char)(paramInt2 + 48));
        j = i + 1;
        paramInt3 = paramInt1 - paramInt2 * 10;
      }
      paramArrayOfChar[j] = ((char)(paramInt3 + 48));
      paramInt1 = j + 1;
      paramArrayOfChar[paramInt1] = paramChar;
      i = paramInt1 + 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.util.TimeUtils
 * JD-Core Version:    0.7.0.1
 */
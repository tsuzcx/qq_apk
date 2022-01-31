import android.graphics.Paint;
import java.util.ArrayList;

public class atsd
{
  public static void a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList)
  {
    paramString = paramString.toCharArray();
    int i1 = 0;
    int i = -1;
    int n = 0;
    int j = 0;
    paramInt1 = 0;
    int i2 = paramInt2;
    paramInt2 = j;
    if (paramInt1 < paramString.length)
    {
      char c = paramString[paramInt1];
      int i3 = paramInt2 + (int)paramPaint.measureText(c + "");
      int k;
      int m;
      if (c == '\n')
      {
        paramArrayList.add(new String(paramString, i1, paramInt1 - i1));
        i = -1;
        k = paramInt1 + 1;
        paramInt2 = 0;
        j = k;
        m = paramInt3;
      }
      for (;;)
      {
        paramInt1 = k + 1;
        i1 = j;
        i2 = m;
        break;
        if ((i3 > i2) && (paramInt1 > 0))
        {
          if ((c == ' ') || (c == '\t'))
          {
            paramArrayList.add(new String(paramString, i1, paramInt1 - i1));
            paramInt2 = paramInt1 + 1;
            j = 0;
            i = -1;
            paramInt1 = paramInt2;
          }
          for (;;)
          {
            m = paramInt3;
            k = paramInt2;
            paramInt2 = j;
            j = paramInt1;
            break;
            if (i == -1)
            {
              paramInt2 = paramInt1;
              if (paramInt1 > i1 + 1) {
                paramInt2 = paramInt1 - 1;
              }
              paramArrayList.add(new String(paramString, i1, paramInt2 - i1));
              j = 0;
              paramInt1 = paramInt2;
            }
            else
            {
              j = i3 - n;
              paramArrayList.add(new String(paramString, i1, i - i1));
              k = i + 1;
              i = -1;
              paramInt2 = paramInt1;
              paramInt1 = k;
            }
          }
        }
        if (c != ' ')
        {
          k = paramInt1;
          paramInt2 = i3;
          j = i1;
          m = i2;
          if (c != '\t') {}
        }
        else
        {
          n = i3;
          i = paramInt1;
          k = paramInt1;
          paramInt2 = i3;
          j = i1;
          m = i2;
        }
      }
    }
    paramArrayList.add(new String(paramString, i1, paramString.length - i1));
  }
  
  public static String[] a(String paramString, Paint paramPaint, int paramInt1, int paramInt2)
  {
    return a(paramString, paramPaint, paramInt1, paramInt2, 99999);
  }
  
  public static String[] a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return new String[] { paramString };
    }
    if ((int)paramPaint.measureText(paramString) <= paramInt1) {
      return new String[] { paramString };
    }
    ArrayList localArrayList = new ArrayList();
    char[] arrayOfChar = paramString.toCharArray();
    int n = 0;
    int i = 0;
    int m = 32;
    int k = 0;
    int j = paramInt1;
    paramInt1 = n;
    if (paramInt1 < arrayOfChar.length)
    {
      n = arrayOfChar[paramInt1];
      if ((n == 13) && (paramInt1 < arrayOfChar.length - 1) && (arrayOfChar[(paramInt1 + 1)] == '\n'))
      {
        m = 1;
        label113:
        if ((n != 10) && (paramInt1 != arrayOfChar.length - 1) && (m == 0)) {
          break label357;
        }
        if (paramInt1 != arrayOfChar.length - 1) {
          break label239;
        }
        paramString = new String(arrayOfChar, k, paramInt1 + 1 - k);
        label161:
        k = (int)paramPaint.measureText(paramString);
        if (k > j) {
          break label258;
        }
        localArrayList.add(paramString);
        label183:
        j = paramInt1;
        if (m != 0) {
          j = paramInt1 + 1;
        }
        k = j + 1;
        m = i + 1;
        i = paramInt2;
        paramInt1 = j;
        j = i;
        i = m;
      }
    }
    label258:
    label357:
    for (;;)
    {
      paramInt1 += 1;
      m = n;
      break;
      m = 0;
      break label113;
      label239:
      paramString = new String(arrayOfChar, k, paramInt1 - k);
      break label161;
      a(paramString, paramPaint, k, j, paramInt2, localArrayList);
      break label183;
      if ((i > 1) && ((m == 10) || (m == 10))) {
        localArrayList.add("");
      }
      paramInt1 = paramInt3;
      if (paramInt3 < 1) {
        paramInt1 = 1;
      }
      while (localArrayList.size() > paramInt1) {
        localArrayList.remove(localArrayList.size() - 1);
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsd
 * JD-Core Version:    0.7.0.1
 */
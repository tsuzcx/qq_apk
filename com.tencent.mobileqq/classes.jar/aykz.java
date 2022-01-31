import android.text.Editable.Factory;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class aykz
  extends ayku
{
  public static Editable.Factory c = new ayla();
  
  public aykz(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public aykz(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public String a()
  {
    int i = 0;
    int m = length();
    char[] arrayOfChar = new char[m];
    getChars(0, m, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(m);
    aykr[] arrayOfaykr = (aykr[])getSpans(0, m, aykr.class);
    Arrays.sort(arrayOfaykr, new aylb(this));
    int n = arrayOfaykr.length;
    int j = 0;
    aykr localaykr;
    int i1;
    int k;
    if (j < n)
    {
      localaykr = arrayOfaykr[j];
      i1 = getSpanStart(localaykr);
      k = getSpanEnd(localaykr);
      if ((localaykr != null) && (i1 < k) && (k > 0)) {}
    }
    else
    {
      if (i < m) {
        localStringBuilder.append(arrayOfChar, i, m - i);
      }
      return localStringBuilder.toString();
    }
    if (i1 > i) {
      localStringBuilder.append(arrayOfChar, i, i1 - i);
    }
    switch (localaykr.c)
    {
    }
    for (;;)
    {
      j += 1;
      i = k;
      break;
      try
      {
        localStringBuilder.append(aylc.b(localaykr.a));
      }
      catch (Exception localException1)
      {
        try
        {
          String str = toString();
          if ((TextUtils.isEmpty(str)) || (str.length() < k)) {
            continue;
          }
          localStringBuilder.append(str.substring(i1, k));
        }
        catch (Exception localException2)
        {
          QLog.e("QzoneTextBuilder", 1, localException2.getStackTrace());
        }
      }
      continue;
      localStringBuilder.append(localException2.a());
      continue;
      localStringBuilder.append(ayjy.a[(localException2.a & 0x7FFFFFFF)]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykz
 * JD-Core Version:    0.7.0.1
 */
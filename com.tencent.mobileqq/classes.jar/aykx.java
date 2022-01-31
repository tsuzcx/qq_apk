import android.text.Editable.Factory;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class aykx
  extends ayks
{
  public static Editable.Factory c = new ayky();
  
  public aykx(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public aykx(CharSequence paramCharSequence, int paramInt1, int paramInt2)
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
    aykp[] arrayOfaykp = (aykp[])getSpans(0, m, aykp.class);
    Arrays.sort(arrayOfaykp, new aykz(this));
    int n = arrayOfaykp.length;
    int j = 0;
    aykp localaykp;
    int i1;
    int k;
    if (j < n)
    {
      localaykp = arrayOfaykp[j];
      i1 = getSpanStart(localaykp);
      k = getSpanEnd(localaykp);
      if ((localaykp != null) && (i1 < k) && (k > 0)) {}
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
    switch (localaykp.c)
    {
    }
    for (;;)
    {
      j += 1;
      i = k;
      break;
      try
      {
        localStringBuilder.append(ayla.b(localaykp.a));
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
      localStringBuilder.append(ayjw.a[(localException2.a & 0x7FFFFFFF)]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykx
 * JD-Core Version:    0.7.0.1
 */
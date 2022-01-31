import android.text.Editable.Factory;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class baiv
  extends baiq
{
  public static Editable.Factory c = new baiw();
  
  public baiv(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public baiv(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public String a()
  {
    int j = 0;
    int m = length();
    char[] arrayOfChar = new char[m];
    getChars(0, m, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(m);
    bain[] arrayOfbain = (bain[])getSpans(0, m, bain.class);
    Arrays.sort(arrayOfbain, new baix(this));
    int n = arrayOfbain.length;
    int i = 0;
    bain localbain;
    int i1;
    int k;
    if (i < n)
    {
      localbain = arrayOfbain[i];
      i1 = getSpanStart(localbain);
      k = getSpanEnd(localbain);
      if ((localbain != null) && (i1 < k) && (k > 0)) {}
    }
    else
    {
      if (j < m) {
        localStringBuilder.append(arrayOfChar, j, m - j);
      }
      return localStringBuilder.toString();
    }
    if (i1 > j) {
      localStringBuilder.append(arrayOfChar, j, i1 - j);
    }
    switch (localbain.c)
    {
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      try
      {
        localStringBuilder.append(baiy.b(localbain.a));
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
      j = 0x7FFFFFFF & localException2.a;
      if (j < bjwo.b.length) {
        localStringBuilder.append(bjwo.b[j]);
      } else {
        QLog.e("QzoneTextBuilder", 1, "不支持的表情");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baiv
 * JD-Core Version:    0.7.0.1
 */
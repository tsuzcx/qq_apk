import android.text.Editable.Factory;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class behe
  extends begz
{
  public static Editable.Factory c = new behf();
  
  public behe(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public behe(CharSequence paramCharSequence, int paramInt1, int paramInt2)
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
    begw[] arrayOfbegw = (begw[])getSpans(0, m, begw.class);
    Arrays.sort(arrayOfbegw, new behg(this));
    int n = arrayOfbegw.length;
    int i = 0;
    Object localObject;
    int i1;
    int k;
    if (i < n)
    {
      localObject = arrayOfbegw[i];
      i1 = getSpanStart(localObject);
      k = getSpanEnd(localObject);
      if ((localObject != null) && (i1 < k) && (k > 0)) {}
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
    switch (((begw)localObject).c)
    {
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      j = askx.a(((begw)localObject).a);
      if (j != -1)
      {
        localStringBuilder.append(String.valueOf(Character.toChars(j)));
      }
      else
      {
        try
        {
          localObject = toString();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).length() < k)) {
            continue;
          }
          localStringBuilder.append(((String)localObject).substring(i1, k));
        }
        catch (Exception localException)
        {
          QLog.e("QzoneTextBuilder", 1, localException.getStackTrace());
        }
        continue;
        localStringBuilder.append(localException.a());
        continue;
        String str = asle.a(0x7FFFFFFF & localException.a);
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append(str);
        } else {
          QLog.e("QzoneTextBuilder", 1, "不支持的表情");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behe
 * JD-Core Version:    0.7.0.1
 */
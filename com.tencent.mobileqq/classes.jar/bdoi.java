import android.text.Editable.Factory;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class bdoi
  extends bdod
{
  public static Editable.Factory c = new bdoj();
  
  public bdoi(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public bdoi(CharSequence paramCharSequence, int paramInt1, int paramInt2)
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
    bdoa[] arrayOfbdoa = (bdoa[])getSpans(0, m, bdoa.class);
    Arrays.sort(arrayOfbdoa, new bdok(this));
    int n = arrayOfbdoa.length;
    int i = 0;
    Object localObject;
    int i1;
    int k;
    if (i < n)
    {
      localObject = arrayOfbdoa[i];
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
    switch (((bdoa)localObject).c)
    {
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      j = arvj.a(((bdoa)localObject).a);
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
        String str = arvq.a(0x7FFFFFFF & localException.a);
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
 * Qualified Name:     bdoi
 * JD-Core Version:    0.7.0.1
 */
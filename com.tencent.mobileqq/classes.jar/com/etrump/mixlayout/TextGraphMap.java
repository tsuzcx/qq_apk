package com.etrump.mixlayout;

import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;

public class TextGraphMap
{
  private CharSequence a;
  private LongSparseArray<CharacterStyle> b;
  
  public TextGraphMap(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    if ((paramCharSequence instanceof Spanned))
    {
      Spanned localSpanned = (Spanned)paramCharSequence;
      int j = paramCharSequence.length();
      int i = 0;
      paramCharSequence = (CharacterStyle[])localSpanned.getSpans(0, j, CharacterStyle.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        this.b = new LongSparseArray(paramCharSequence.length);
        while (i < paramCharSequence.length)
        {
          Object localObject = paramCharSequence[i];
          if (((localObject instanceof EmoticonSpan)) || ((localObject instanceof SignatureActionSpan)))
          {
            j = localSpanned.getSpanStart(localObject);
            int k = localSpanned.getSpanEnd(localObject);
            this.b.b(a(j, k), localObject);
          }
          i += 1;
        }
      }
    }
  }
  
  private static int a(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  private static long a(int paramInt1, int paramInt2)
  {
    return (paramInt1 << 32) + (paramInt2 & 0xFFFFFFFF);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" > ");
    localStringBuilder.append(this.a.length());
    localStringBuilder.append(":");
    localStringBuilder.append(this.a);
    QLog.e("ETTextView", 1, localStringBuilder.toString());
  }
  
  private static int b(long paramLong)
  {
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return paramInt;
    }
    int j = 0;
    if ((paramInt >= 0) && (paramInt <= ((CharSequence)localObject).length()))
    {
      localObject = this.b;
      int i = paramInt;
      if (localObject != null)
      {
        int k = ((LongSparseArray)localObject).b();
        i = paramInt;
        while (j < k)
        {
          long l = this.b.b(j);
          int m = a(l);
          int n = b(l);
          if (m < paramInt) {
            if (n <= paramInt)
            {
              i -= n - m - 1;
              j += 1;
            }
            else
            {
              return i - (paramInt - m);
            }
          }
        }
      }
      return i;
    }
    if (paramInt > 0) {
      a("convertToGraphIndex", paramInt, 0);
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return paramInt;
    }
    int j = 0;
    if ((paramInt >= 0) && (paramInt <= ((CharSequence)localObject).length()))
    {
      localObject = this.b;
      if (localObject != null)
      {
        int m = ((LongSparseArray)localObject).b();
        int i = paramInt;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          long l = this.b.b(j);
          k = a(l);
          int n = b(l);
          if (k >= i)
          {
            k = i;
            break;
          }
          i += n - k - 1;
          j += 1;
        }
      }
      int k = paramInt;
      if (k > this.a.length())
      {
        a("convertToTextIndex2", paramInt, k);
        return -1;
      }
      return k;
    }
    if (paramInt > 0) {
      a("convertToTextIndex1", paramInt, 0);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.TextGraphMap
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class SafeTextView
  extends TextView
{
  public SafeTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SafeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SafeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = paramString;
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return paramString;
      }
      if (!a(paramString)) {
        return paramString;
      }
      localObject1 = null;
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        Object localObject2 = localObject1;
        if (a(c))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder(paramString.length());
          }
          ((StringBuilder)localObject2).append(c);
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject1 == null) {
        return "";
      }
      if (((StringBuilder)localObject1).length() == j) {
        return paramString;
      }
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  private static boolean a(char paramChar)
  {
    return (paramChar == 0) || (paramChar == '\t') || (paramChar == '\n') || (paramChar == '\r') || ((paramChar >= ' ') && (paramChar <= 55295)) || ((paramChar >= 57344) && (paramChar <= 65533));
  }
  
  public static boolean a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!a(paramString.charAt(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable1)
    {
      label7:
      label30:
      break label7;
    }
    try
    {
      setText(a(getText().toString()));
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable2)
    {
      break label30;
    }
    setText("");
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    try
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    catch (Throwable paramCharSequence)
    {
      label7:
      label25:
      break label7;
    }
    try
    {
      super.setText(a(getText().toString()), paramBufferType);
      return;
    }
    catch (Throwable paramCharSequence)
    {
      break label25;
    }
    setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.SafeTextView
 * JD-Core Version:    0.7.0.1
 */
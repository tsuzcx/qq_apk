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
  
  public static boolean containsEmoji(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (!isNormalCharacter(paramString.charAt(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String filterEmoji(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    int j;
    Object localObject1;
    do
    {
      do
      {
        return paramString;
      } while (!containsEmoji(paramString));
      j = paramString.length();
      localObject1 = null;
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        Object localObject2 = localObject1;
        if (isNormalCharacter(c))
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
    } while (localObject1.length() == j);
    return localObject1.toString();
  }
  
  private static boolean isNormalCharacter(char paramChar)
  {
    return (paramChar == 0) || (paramChar == '\t') || (paramChar == '\n') || (paramChar == '\r') || ((paramChar >= ' ') && (paramChar <= 55295)) || ((paramChar >= 57344) && (paramChar <= 65533));
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
      try
      {
        setText(filterEmoji(getText().toString()));
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      catch (Throwable localThrowable2)
      {
        setText("");
        super.onMeasure(paramInt1, paramInt2);
      }
    }
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
      try
      {
        super.setText(filterEmoji(getText().toString()), paramBufferType);
        return;
      }
      catch (Throwable paramCharSequence)
      {
        setText("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.SafeTextView
 * JD-Core Version:    0.7.0.1
 */
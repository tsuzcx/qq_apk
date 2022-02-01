package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class HtmlChangeUtil$SpanBuilder
{
  int a;
  private int b;
  private int c;
  
  public static SpanBuilder a(int paramInt, Object... paramVarArgs)
  {
    SpanBuilder localSpanBuilder = new SpanBuilder();
    localSpanBuilder.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localSpanBuilder;
    case 1: 
    case 2: 
      localSpanBuilder.b = ((Integer)paramVarArgs[0]).intValue();
      return localSpanBuilder;
    }
    localSpanBuilder.c = ((Integer)paramVarArgs[0]).intValue();
    return localSpanBuilder;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new HtmlChangeUtil.MyBackgroundColorSpan(this.b);
    case 2: 
      return new ForegroundColorSpan(this.b);
    case 5: 
      return new StrikethroughSpan();
    case 4: 
      return new StyleSpan(this.c);
    }
    return new UnderlineSpan();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.HtmlChangeUtil.SpanBuilder
 * JD-Core Version:    0.7.0.1
 */
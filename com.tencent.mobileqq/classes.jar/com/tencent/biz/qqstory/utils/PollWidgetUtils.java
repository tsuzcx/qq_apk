package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.text.Layout;
import android.widget.TextView;

public class PollWidgetUtils
{
  public static PollWidgetUtils.IPollWidget a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return new PollWidgetUtils.WidgetWrapper(paramContext);
  }
  
  public static String a(TextView paramTextView, int paramInt)
  {
    Layout localLayout = paramTextView.getLayout();
    String str = paramTextView.getText().toString();
    paramTextView = str;
    if (localLayout != null)
    {
      paramTextView = str;
      if (localLayout.getLineCount() > paramInt) {
        paramTextView = str.substring(0, localLayout.getLineStart(paramInt));
      }
    }
    return paramTextView;
  }
  
  public static float[] a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double d1 = paramFloat1;
    double d2 = paramFloat3;
    Double.isNaN(d2);
    d2 = d2 * 3.141592653589793D / 180.0D;
    double d3 = Math.cos(d2);
    Double.isNaN(d1);
    paramFloat1 = (float)(d3 * d1);
    d3 = paramFloat2;
    double d4 = Math.sin(d2);
    Double.isNaN(d3);
    paramFloat2 = (float)(d4 * d3);
    d4 = Math.sin(d2);
    Double.isNaN(d1);
    paramFloat3 = (float)(d1 * d4);
    d1 = Math.cos(d2);
    Double.isNaN(d3);
    return new float[] { paramFloat1 - paramFloat2, paramFloat3 + (float)(d3 * d1) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils
 * JD-Core Version:    0.7.0.1
 */
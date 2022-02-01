package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser.CustomImageSpan;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import java.util.Iterator;
import java.util.List;

public class RichTextUtils
{
  private static final String TAG = "RichNativeText";
  private static final String ellipsis = "…";
  
  public static void addClickSpan(TextView paramTextView, SpannableStringBuilder paramSpannableStringBuilder, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSpannableStringBuilder.setSpan(new RichTextUtils.ClickSpan(paramString, paramInt1), paramInt2, paramInt3, 33);
    paramTextView.setMovementMethod(CommonLinkMovementMethod.a());
  }
  
  public static void addEllipsis2Text(TextView paramTextView, TruncateAttr paramTruncateAttr)
  {
    addEllipsis2Text(paramTextView, paramTextView.getText(), paramTruncateAttr);
  }
  
  private static void addEllipsis2Text(TextView paramTextView, CharSequence paramCharSequence, TruncateAttr paramTruncateAttr)
  {
    for (;;)
    {
      int j;
      try
      {
        int k = paramTruncateAttr.maxLines;
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramTruncateAttr.text);
        addMoreTextSpan(paramTextView, localSpannableStringBuilder, paramTruncateAttr, 0, localSpannableStringBuilder.length());
        if (paramTextView.getLineCount() > k)
        {
          int i = paramTextView.getLayout().getLineEnd(k - 1);
          j = i;
          if (isBeyondMaxLines(paramTextView, k, paramCharSequence, localSpannableStringBuilder, 0, i))
          {
            j = i;
            if (isBeyondMaxLines(paramTextView, k, paramCharSequence, localSpannableStringBuilder, 0, i))
            {
              i -= 1;
              continue;
            }
          }
          else
          {
            if (isBeyondMaxLines(paramTextView, k, paramCharSequence, localSpannableStringBuilder, 0, j)) {
              break label173;
            }
            j += 1;
            continue;
          }
          localSpannableStringBuilder.clear();
          addMoreText(paramTextView, localSpannableStringBuilder, paramCharSequence, j, paramTruncateAttr);
          paramTextView.setText(localSpannableStringBuilder);
          return;
        }
      }
      catch (Exception paramTextView)
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("getBlockText error! msg=");
        paramCharSequence.append(paramTextView);
        LogUtil.QLog.e("RichNativeText", 1, paramCharSequence.toString());
      }
      return;
      label173:
      j -= 1;
    }
  }
  
  public static void addFontSizeSpan(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(paramInt1), paramInt2, paramInt3, 33);
  }
  
  public static void addFontWeightSpan(SpannableStringBuilder paramSpannableStringBuilder, String paramString, int paramInt1, int paramInt2)
  {
    if ("bold".equals(paramString)) {
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramInt1, paramInt2, 33);
    }
  }
  
  public static void addMore2Text(TextView paramTextView, TruncateAttr paramTruncateAttr)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new RichTextUtils.1(paramTextView, paramTruncateAttr));
  }
  
  private static void addMoreText(TextView paramTextView, SpannableStringBuilder paramSpannableStringBuilder, CharSequence paramCharSequence, int paramInt, TruncateAttr paramTruncateAttr)
  {
    paramSpannableStringBuilder.append(paramCharSequence.subSequence(0, paramInt));
    paramInt = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append("…").append(paramTruncateAttr.text);
    addMoreTextSpan(paramTextView, paramSpannableStringBuilder, paramTruncateAttr, paramInt, paramSpannableStringBuilder.length());
  }
  
  private static void addMoreTextSpan(TextView paramTextView, SpannableStringBuilder paramSpannableStringBuilder, TruncateAttr paramTruncateAttr, int paramInt1, int paramInt2)
  {
    addClickSpan(paramTextView, paramSpannableStringBuilder, paramTruncateAttr.href, paramTruncateAttr.color, paramInt1, paramInt2);
    double d1 = paramTruncateAttr.fontSize;
    double d2 = paramTruncateAttr.nodeRatio;
    Double.isNaN(d1);
    addFontSizeSpan(paramSpannableStringBuilder, (int)(d1 * d2), paramInt1, paramInt2);
    addFontWeightSpan(paramSpannableStringBuilder, paramTruncateAttr.fontWeight, paramInt1, paramInt2);
  }
  
  public static void adjustImageSpan(TextView paramTextView, TruncateAttr paramTruncateAttr)
  {
    int i = paramTextView.getLineCount();
    boolean bool = true;
    if (i > 1) {
      bool = false;
    }
    paramTextView = paramTruncateAttr.imageSpans.iterator();
    while (paramTextView.hasNext())
    {
      paramTruncateAttr = (RichTextParser.CustomImageSpan)paramTextView.next();
      if (paramTruncateAttr != null) {
        paramTruncateAttr.isSingleLine = bool;
      }
    }
  }
  
  private static boolean isBeyondMaxLines(TextView paramTextView, int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    paramCharSequence1 = paramCharSequence1.subSequence(paramInt2, paramInt3);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence1).append("…").append(paramCharSequence2);
    paramTextView.setText(localSpannableStringBuilder);
    return paramTextView.getLineCount() > paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ad.tangram.views.canvas.components.keyElements;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdUIUtils;

public class a
  extends TextView
{
  public static final String FINAL_TEXT = "权限详情 | 隐私协议";
  private static final String MAX_APP_NAME = "应用名称:最长25个字最长25个字最长25个字最长25个字最长25个字";
  private static final String TAG = "AdAutoLayoutTextView";
  private boolean ended;
  private boolean marked;
  
  public a(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public a(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public a(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private String formatString(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (paramString1.length() > 35)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1.substring(0, 35));
        localStringBuilder.append(" | ");
        paramString1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" | ");
        paramString1 = localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" | ");
      paramString2 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" | ");
      paramString3 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString3);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private void init(Context paramContext)
  {
    setTextSize(0, 24.0F);
    setPadding(AdUIUtils.getValueDependsOnScreenWidth(paramContext, 750, 20), AdUIUtils.getValueDependsOnScreenWidth(paramContext, 750, 9), AdUIUtils.getValueDependsOnScreenWidth(paramContext, 750, 20), AdUIUtils.getValueDependsOnScreenWidth(paramContext, 750, 9));
    setGravity(17);
    setSingleLine(false);
    setMaxLines(3);
    if (Build.VERSION.SDK_INT >= 26)
    {
      setAutoSizeTextTypeWithDefaults(1);
      setAutoSizeTextTypeUniformWithConfiguration(1, 24, 1, 0);
    }
    getViewTreeObserver().addOnPreDrawListener(new a.1(this));
  }
  
  private void setTextWithSpan(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-16776961), paramCharSequence.length() - 11, paramCharSequence.length(), 33);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF7A8499")), 0, paramCharSequence.length() - 11, 33);
    setText(localSpannableStringBuilder);
  }
  
  public void setTextContent(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = formatString(paramString1, paramString2, paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    setText(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.keyElements.a
 * JD-Core Version:    0.7.0.1
 */
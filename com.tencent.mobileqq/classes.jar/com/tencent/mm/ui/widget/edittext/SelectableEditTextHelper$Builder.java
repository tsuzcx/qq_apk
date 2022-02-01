package com.tencent.mm.ui.widget.edittext;

import android.widget.TextView;
import androidx.annotation.ColorInt;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectableEditTextHelper$Builder
{
  private TextView a;
  private int b = 2131165923;
  private int c = 2131167937;
  private float d = 18.0F;
  private boolean e = true;
  private Set<String> f = new HashSet();
  private Set<String> g = new HashSet();
  private String h;
  
  public SelectableEditTextHelper$Builder(TextView paramTextView)
  {
    this.a = paramTextView;
  }
  
  public SelectableEditTextHelper build()
  {
    return new SelectableEditTextHelper(this);
  }
  
  public Builder enable(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public Builder setCursorHandleColor(@ColorInt int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder setCursorHandleSizeInDp(float paramFloat)
  {
    this.d = paramFloat;
    return this;
  }
  
  public Builder setLanguage(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public Builder setNeedReuseBrands(List<String> paramList)
  {
    if (paramList != null) {
      this.g.addAll(paramList);
    }
    return this;
  }
  
  public Builder setNeedReuseItems(List<String> paramList)
  {
    if (paramList != null) {
      this.f.addAll(paramList);
    }
    return this;
  }
  
  public Builder setSelectedColor(@ColorInt int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.Builder
 * JD-Core Version:    0.7.0.1
 */
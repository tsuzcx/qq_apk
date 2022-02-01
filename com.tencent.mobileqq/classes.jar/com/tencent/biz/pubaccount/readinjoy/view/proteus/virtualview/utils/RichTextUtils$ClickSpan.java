package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;

public class RichTextUtils$ClickSpan
  extends ClickableSpan
{
  private String href;
  int textColor;
  
  public RichTextUtils$ClickSpan(String paramString, int paramInt)
  {
    this.href = paramString;
    this.textColor = paramInt;
  }
  
  private void doHyperLinkClick(View paramView, String paramString)
  {
    if ((paramView instanceof NativeTextImp)) {
      ((NativeTextImp)paramView).setHyperLinkClick(true);
    }
    if (CustomMethodsRegister.customMethodInterface != null) {
      CustomMethodsRegister.customMethodInterface.invoke("HyperLinkClick", new Object[] { paramString, paramView });
    }
  }
  
  public void onClick(@NonNull View paramView)
  {
    doHyperLinkClick(paramView, this.href);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.textColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils.ClickSpan
 * JD-Core Version:    0.7.0.1
 */
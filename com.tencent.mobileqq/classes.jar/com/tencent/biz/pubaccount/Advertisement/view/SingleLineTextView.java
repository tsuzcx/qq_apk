package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class SingleLineTextView
  extends TextView
{
  private static final char[] a = { '…' };
  private static final String b = new String(a);
  private StringBuilder c = new StringBuilder();
  
  public SingleLineTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SingleLineTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SingleLineTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = getPaint();
    CharSequence localCharSequence = getText();
    float f1 = ((TextPaint)localObject).measureText(localCharSequence.toString());
    float f2 = paramInt3 - paramInt1;
    if (f1 > f2)
    {
      paramInt1 = ((TextPaint)localObject).breakText(localCharSequence, 0, localCharSequence.length(), true, f2 - ((TextPaint)localObject).measureText(b), null);
      localObject = this.c;
      localObject = ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      ((StringBuilder)localObject).append(localCharSequence.subSequence(0, paramInt1));
      ((StringBuilder)localObject).append(b);
      setText(this.c.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.SingleLineTextView
 * JD-Core Version:    0.7.0.1
 */
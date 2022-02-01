package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class LetterSpacingTextView
  extends TextView
{
  private float a = 0.0F;
  private CharSequence b = "";
  
  public LetterSpacingTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LetterSpacingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public LetterSpacingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    if (this.b == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.b.length())
    {
      localStringBuilder.append(this.b.charAt(i));
      j = i + 1;
      i = j;
      if (j < this.b.length())
      {
        localStringBuilder.append(" ");
        i = j;
      }
    }
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    int j = localStringBuilder.toString().length();
    i = 1;
    if (j > 1) {
      while (i < localStringBuilder.toString().length())
      {
        localSpannableString.setSpan(new ScaleXSpan(this.a), i, i + 1, 33);
        i += 2;
      }
    }
    super.setText(localSpannableString, TextView.BufferType.SPANNABLE);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public float getSpacing()
  {
    return this.a;
  }
  
  public CharSequence getText()
  {
    return this.b;
  }
  
  public void setSpacing(float paramFloat)
  {
    this.a = paramFloat;
    a();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.b = paramCharSequence;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.LetterSpacingTextView
 * JD-Core Version:    0.7.0.1
 */
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
  private float jdField_a_of_type_Float = 0.0F;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  
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
    if ((this == null) || (this.jdField_a_of_type_JavaLangCharSequence == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaLangCharSequence.length())
    {
      localStringBuilder.append(this.jdField_a_of_type_JavaLangCharSequence.charAt(i));
      if (i + 1 < this.jdField_a_of_type_JavaLangCharSequence.length()) {
        localStringBuilder.append(" ");
      }
      i += 1;
    }
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (localStringBuilder.toString().length() > 1)
    {
      i = 1;
      while (i < localStringBuilder.toString().length())
      {
        localSpannableString.setSpan(new ScaleXSpan(this.jdField_a_of_type_Float), i, i + 1, 33);
        i += 2;
      }
    }
    super.setText(localSpannableString, TextView.BufferType.SPANNABLE);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public CharSequence getText()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public void setSpacing(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    a();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.LetterSpacingTextView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import bdaq;

public class ReadInJoyVideoTopicTextView
  extends TextView
{
  private final int jdField_a_of_type_Int = 14;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private final int b = 8;
  
  public ReadInJoyVideoTopicTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ReadInJoyVideoTopicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ReadInJoyVideoTopicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt)
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangString);
    Object localObject = new ForegroundColorSpan(Color.parseColor("#737373"));
    int j = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.5F);
    int i;
    if (paramInt == 1)
    {
      localObject = getResources().getDrawable(2130842785);
      paramInt = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
      ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
      setCompoundDrawablePadding(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 3.0F));
      setCompoundDrawables((Drawable)localObject, null, null, null);
      i = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 4.5F);
      setTextSize(2, 12.0F);
    }
    for (;;)
    {
      setTextColor(Color.parseColor("#737373"));
      setText(localSpannableString);
      setIncludeFontPadding(false);
      setPadding(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), i, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), i);
      setClickable(true);
      setFocusable(true);
      setBackgroundResource(2130842782);
      setSingleLine(true);
      setGravity(17);
      return;
      i = j;
      if (paramInt == 2)
      {
        localSpannableString.setSpan(localObject, 0, this.jdField_a_of_type_JavaLangString.length(), 34);
        setHeight(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 27.0F));
        setTextSize(2, 14.0F);
        i = j;
      }
    }
  }
  
  public int a()
  {
    Rect localRect = new Rect();
    getPaint().getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), localRect);
    return localRect.width() + bdaq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F) * 2;
  }
  
  public void setSubChannelText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(2);
  }
  
  public void setTopicText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoTopicTextView
 * JD-Core Version:    0.7.0.1
 */
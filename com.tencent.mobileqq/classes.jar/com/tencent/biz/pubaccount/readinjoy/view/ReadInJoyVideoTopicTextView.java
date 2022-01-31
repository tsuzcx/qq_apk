package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;

public class ReadInJoyVideoTopicTextView
  extends TextView
{
  private final int jdField_a_of_type_Int = 12;
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
    ForegroundColorSpan localForegroundColorSpan1 = new ForegroundColorSpan(Color.parseColor("#ff07D0B0"));
    ForegroundColorSpan localForegroundColorSpan2 = new ForegroundColorSpan(Color.parseColor("#ff777777"));
    if (paramInt == 1)
    {
      localSpannableString.setSpan(localForegroundColorSpan1, 0, 1, 34);
      localSpannableString.setSpan(localForegroundColorSpan2, 1, this.jdField_a_of_type_JavaLangString.length(), 34);
    }
    for (;;)
    {
      setText(localSpannableString);
      setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      setClickable(true);
      setFocusable(true);
      setTextSize(2, 12.0F);
      setBackgroundResource(2130840883);
      setSingleLine(true);
      getPaint().setFakeBoldText(true);
      setHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      setGravity(17);
      return;
      if (paramInt == 2) {
        localSpannableString.setSpan(localForegroundColorSpan2, 0, this.jdField_a_of_type_JavaLangString.length(), 34);
      }
    }
  }
  
  public int a()
  {
    Rect localRect = new Rect();
    getPaint().getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), localRect);
    return localRect.width() + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F) * 2;
  }
  
  public void setSubChannelText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(2);
  }
  
  public void setTopicText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = ("# " + paramString);
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoTopicTextView
 * JD-Core Version:    0.7.0.1
 */
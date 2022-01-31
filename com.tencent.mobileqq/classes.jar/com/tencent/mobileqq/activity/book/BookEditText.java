package com.tencent.mobileqq.activity.book;

import afbw;
import afbx;
import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import java.io.UnsupportedEncodingException;

public class BookEditText
  extends EditText
{
  private int jdField_a_of_type_Int = 80;
  private afbx jdField_a_of_type_Afbx;
  private boolean jdField_a_of_type_Boolean;
  private InputFilter[] jdField_a_of_type_ArrayOfAndroidTextInputFilter = { new afbw(this) };
  
  public BookEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BookEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setInputType(131072);
    setSingleLine(false);
    setHorizontallyScrolling(false);
    setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      int i = paramString.toString().getBytes("utf8").length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramString.toString().getBytes().length;
  }
  
  public void setCanInputWhenLenghtLimit(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setInputListener(afbx paramafbx)
  {
    this.jdField_a_of_type_Afbx = paramafbx;
  }
  
  public void setTextLengthLimit(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.book.BookEditText
 * JD-Core Version:    0.7.0.1
 */
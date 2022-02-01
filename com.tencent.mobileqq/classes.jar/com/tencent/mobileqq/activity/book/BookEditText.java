package com.tencent.mobileqq.activity.book;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import java.io.UnsupportedEncodingException;

public class BookEditText
  extends EditText
{
  private int a = 80;
  private boolean b = false;
  private InputFilter[] c = { new BookEditText.1(this) };
  private BookEditText.BookEditTextInputListener d;
  
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
    setFilters(this.c);
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
    this.b = paramBoolean;
  }
  
  public void setInputListener(BookEditText.BookEditTextInputListener paramBookEditTextInputListener)
  {
    this.d = paramBookEditTextInputListener;
  }
  
  public void setTextLengthLimit(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.book.BookEditText
 * JD-Core Version:    0.7.0.1
 */
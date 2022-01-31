package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.MessageProgressView;
import ovj;

public class AutoStartProgressBar
  extends MessageProgressView
{
  public static int a;
  public static int b = -1;
  public String a;
  public boolean a;
  public int c = 100;
  
  static
  {
    jdField_a_of_type_Int = 50;
  }
  
  public AutoStartProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoStartProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AutoStartProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private double a(int paramInt)
  {
    if (paramInt == b) {
      return Math.pow(10.0D - (1.0D - this.e * 1.0D / this.c) * 100.0D, 2.5D);
    }
    return 0.0D;
  }
  
  public void a()
  {
    if (!a(this.jdField_a_of_type_JavaLangString))
    {
      this.e = 0;
      this.jdField_a_of_type_Boolean = false;
      new ovj(this, null).start();
    }
  }
  
  public void b()
  {
    setAnimProgress(100, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setKey(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AutoStartProgressBar
 * JD-Core Version:    0.7.0.1
 */
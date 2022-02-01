package com.tencent.mobileqq.bubble;

import android.graphics.Rect;
import java.util.Arrays;

public class BubbleInfo$CommonAttrs
{
  public int a;
  public Rect a;
  public AnimationConfig a;
  public String a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public boolean b;
  public int c = 50;
  public int d = -1;
  public int e = 1;
  
  public BubbleInfo$CommonAttrs()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommonAttrs [key=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mRect=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRect);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", align=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mBigImgPath=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", repeatCount=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mAnimationPath=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs
 * JD-Core Version:    0.7.0.1
 */
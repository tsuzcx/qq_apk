package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.mobileqq.utils.ListUtils;
import java.util.ArrayList;

public class AioAnimationRule
{
  public int a;
  public AioAnimationRule.BussinessData a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<AioAnimationRule.JumpImage> b;
  public int c = 0;
  public int d = -1;
  public int e = -1;
  
  public AioAnimationRule()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public AioAnimationRule(AioAnimationRule paramAioAnimationRule)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramAioAnimationRule.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramAioAnimationRule.jdField_b_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList = paramAioAnimationRule.jdField_a_of_type_JavaUtilArrayList;
    this.c = paramAioAnimationRule.c;
    this.d = paramAioAnimationRule.d;
    this.e = paramAioAnimationRule.e;
    this.jdField_a_of_type_Boolean = paramAioAnimationRule.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_JavaUtilArrayList = paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData = paramAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData;
    this.jdField_a_of_type_JavaLangString = paramAioAnimationRule.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramAioAnimationRule.jdField_b_of_type_JavaLangString;
  }
  
  void a(int paramInt)
  {
    if (ListUtils.a(this.jdField_b_of_type_JavaUtilArrayList)) {}
    for (;;)
    {
      return;
      int i = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
      int j = 0;
      while ((j < paramInt) && (i >= 0))
      {
        ((AioAnimationRule.JumpImage)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = true;
        j += 1;
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationRule
 * JD-Core Version:    0.7.0.1
 */
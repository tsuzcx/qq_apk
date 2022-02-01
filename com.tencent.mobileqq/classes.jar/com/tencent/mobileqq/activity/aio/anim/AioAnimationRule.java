package com.tencent.mobileqq.activity.aio.anim;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.anim.egg.EggKeyword;
import com.tencent.mobileqq.utils.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class AioAnimationRule
{
  public int a;
  public long a;
  public AioAnimationRule.BussinessData a;
  public String a;
  public ArrayList<EggKeyword> a;
  public boolean a;
  public int b;
  public long b;
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
    this.jdField_b_of_type_Long = paramAioAnimationRule.jdField_b_of_type_Long;
    this.jdField_a_of_type_Long = paramAioAnimationRule.jdField_a_of_type_Long;
  }
  
  void a(int paramInt)
  {
    if (ListUtils.a(this.jdField_b_of_type_JavaUtilArrayList)) {
      return;
    }
    int i = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    int j = 0;
    while ((j < paramInt) && (i >= 0))
    {
      ((AioAnimationRule.JumpImage)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = true;
      j += 1;
      i -= 1;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Int);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EggKeyword localEggKeyword = (EggKeyword)((Iterator)localObject).next();
      localStringBuilder.append(localEggKeyword.a());
      localStringBuilder.append(".");
      localStringBuilder.append(localEggKeyword.a());
      localStringBuilder.append(".");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(super.toString());
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationRule
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.bubble;

import android.util.SparseArray;
import java.util.ArrayList;

public class AnimationConfig
{
  public int a;
  public SparseArray<AnimationConfig.AnimationStep> a;
  public String a;
  public ArrayList<BubbleNewAnimConf> a;
  public boolean a;
  public int[] a;
  public String[] a;
  public int b;
  public String b;
  public boolean b;
  public int[] b;
  public int c;
  public String c;
  public boolean c;
  public int[] c;
  public int d;
  public String d;
  public int e = -1;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j = 0;
  public int k;
  
  public AnimationConfig()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static void a(AnimationConfig paramAnimationConfig)
  {
    if (paramAnimationConfig == null) {}
    AnimationConfig.AnimationStep localAnimationStep;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.size() > 0) || ((paramAnimationConfig.e != 10) && (paramAnimationConfig.e != 11)) || (paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.size() != 3));
        localObject2 = (AnimationConfig.AnimationStep)paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.get(0);
        localObject1 = (AnimationConfig.AnimationStep)paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.get(1);
        localAnimationStep = (AnimationConfig.AnimationStep)paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.get(2);
      } while ((localObject2 == null) || (localObject1 == null) || (localAnimationStep == null));
      if (paramAnimationConfig.e == 10)
      {
        localPathAnimConf1 = new BubbleNewAnimConf.PathAnimConf();
        localPathAnimConf1.jdField_a_of_type_JavaLangString = "step1";
        localPathAnimConf1.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject2).jdField_a_of_type_JavaLangString;
        localPathAnimConf1.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject2).jdField_a_of_type_Int;
        localPathAnimConf1.jdField_a_of_type_Float = 0.1F;
        localPathAnimConf1.jdField_b_of_type_Float = 0.0F;
        localPathAnimConf1.c = 0.1F;
        localPathAnimConf1.d = 0.0F;
        localPathAnimConf1.jdField_a_of_type_Long = (((AnimationConfig.AnimationStep)localObject2).jdField_a_of_type_Int * 125);
        paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf1);
        localPathAnimConf1 = new BubbleNewAnimConf.PathAnimConf();
        localPathAnimConf1.jdField_a_of_type_JavaLangString = "step2";
        localPathAnimConf1.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_JavaLangString;
        localPathAnimConf1.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_Int;
        localPathAnimConf1.jdField_a_of_type_Float = 0.1F;
        localPathAnimConf1.jdField_b_of_type_Float = 0.0F;
        localPathAnimConf1.c = 0.9F;
        localPathAnimConf1.d = 0.0F;
        localPathAnimConf1.jdField_a_of_type_Long = 600L;
        paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf1);
        localPathAnimConf2 = new BubbleNewAnimConf.PathAnimConf();
        localPathAnimConf2.jdField_a_of_type_JavaLangString = "step3";
        localPathAnimConf2.jdField_b_of_type_JavaLangString = localAnimationStep.jdField_a_of_type_JavaLangString;
        localPathAnimConf2.jdField_b_of_type_Int = localAnimationStep.jdField_a_of_type_Int;
        localPathAnimConf2.jdField_a_of_type_Float = 0.9F;
        localPathAnimConf2.jdField_b_of_type_Float = 0.0F;
        localPathAnimConf2.c = 0.9F;
        localPathAnimConf2.d = 0.0F;
        localPathAnimConf2.jdField_a_of_type_Long = (localAnimationStep.jdField_a_of_type_Int * 125);
        paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf2);
        paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf1.a());
      }
    } while (paramAnimationConfig.e != 11);
    BubbleNewAnimConf.PathAnimConf localPathAnimConf1 = new BubbleNewAnimConf.PathAnimConf();
    localPathAnimConf1.jdField_a_of_type_JavaLangString = "step1";
    localPathAnimConf1.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject2).jdField_a_of_type_JavaLangString;
    localPathAnimConf1.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject2).jdField_a_of_type_Int;
    localPathAnimConf1.jdField_a_of_type_Float = 0.1F;
    localPathAnimConf1.jdField_b_of_type_Float = 0.0F;
    localPathAnimConf1.c = 0.1F;
    localPathAnimConf1.d = 0.0F;
    localPathAnimConf1.jdField_a_of_type_Long = (((AnimationConfig.AnimationStep)localObject2).jdField_a_of_type_Int * 125);
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf1);
    Object localObject2 = new BubbleNewAnimConf.PathAnimConf();
    ((BubbleNewAnimConf.PathAnimConf)localObject2).jdField_a_of_type_JavaLangString = "step2";
    ((BubbleNewAnimConf.PathAnimConf)localObject2).jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_JavaLangString;
    ((BubbleNewAnimConf.PathAnimConf)localObject2).jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_Int;
    ((BubbleNewAnimConf.PathAnimConf)localObject2).jdField_a_of_type_Float = 0.1F;
    ((BubbleNewAnimConf.PathAnimConf)localObject2).jdField_b_of_type_Float = 0.0F;
    ((BubbleNewAnimConf.PathAnimConf)localObject2).c = 0.9F;
    ((BubbleNewAnimConf.PathAnimConf)localObject2).d = 0.0F;
    ((BubbleNewAnimConf.PathAnimConf)localObject2).jdField_a_of_type_Long = 800L;
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    BubbleNewAnimConf.PathAnimConf localPathAnimConf2 = new BubbleNewAnimConf.PathAnimConf();
    localPathAnimConf2.jdField_a_of_type_JavaLangString = "step3";
    localPathAnimConf2.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_JavaLangString;
    localPathAnimConf2.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_Int;
    localPathAnimConf2.jdField_a_of_type_Float = 0.9F;
    localPathAnimConf2.jdField_b_of_type_Float = 0.0F;
    localPathAnimConf2.c = 1.0F;
    localPathAnimConf2.d = 0.1F;
    localPathAnimConf2.e = 0.95F;
    localPathAnimConf2.f = 0.0F;
    localPathAnimConf2.g = 1.0F;
    localPathAnimConf2.jdField_h_of_type_Float = 0.05F;
    localPathAnimConf2.jdField_h_of_type_Int = 0;
    localPathAnimConf2.i = -90;
    localPathAnimConf2.jdField_a_of_type_Long = 600L;
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf2);
    BubbleNewAnimConf.PathAnimConf localPathAnimConf3 = new BubbleNewAnimConf.PathAnimConf();
    localPathAnimConf3.jdField_a_of_type_JavaLangString = "step4";
    localPathAnimConf3.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_JavaLangString;
    localPathAnimConf3.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_Int;
    localPathAnimConf3.jdField_a_of_type_Float = 1.0F;
    localPathAnimConf3.jdField_b_of_type_Float = 0.1F;
    localPathAnimConf3.c = 1.0F;
    localPathAnimConf3.d = 0.9F;
    localPathAnimConf3.jdField_h_of_type_Int = -90;
    localPathAnimConf3.i = -90;
    localPathAnimConf3.jdField_a_of_type_Long = 800L;
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf3);
    BubbleNewAnimConf.PathAnimConf localPathAnimConf4 = new BubbleNewAnimConf.PathAnimConf();
    localPathAnimConf4.jdField_a_of_type_JavaLangString = "step5";
    localPathAnimConf4.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_JavaLangString;
    localPathAnimConf4.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_Int;
    localPathAnimConf4.jdField_a_of_type_Float = 1.0F;
    localPathAnimConf4.jdField_b_of_type_Float = 0.9F;
    localPathAnimConf4.c = 0.9F;
    localPathAnimConf4.d = 1.0F;
    localPathAnimConf4.e = 1.0F;
    localPathAnimConf4.f = 0.95F;
    localPathAnimConf4.g = 0.95F;
    localPathAnimConf4.jdField_h_of_type_Float = 1.0F;
    localPathAnimConf4.jdField_h_of_type_Int = -90;
    localPathAnimConf4.i = -180;
    localPathAnimConf4.jdField_a_of_type_Long = 600L;
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf4);
    BubbleNewAnimConf.PathAnimConf localPathAnimConf5 = new BubbleNewAnimConf.PathAnimConf();
    localPathAnimConf5.jdField_a_of_type_JavaLangString = "step6";
    localPathAnimConf5.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_JavaLangString;
    localPathAnimConf5.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_Int;
    localPathAnimConf5.jdField_a_of_type_Float = 0.9F;
    localPathAnimConf5.jdField_b_of_type_Float = 1.0F;
    localPathAnimConf5.c = 0.1F;
    localPathAnimConf5.d = 1.0F;
    localPathAnimConf5.jdField_h_of_type_Int = -180;
    localPathAnimConf5.i = -180;
    localPathAnimConf5.jdField_a_of_type_Long = 800L;
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf5);
    BubbleNewAnimConf.PathAnimConf localPathAnimConf6 = new BubbleNewAnimConf.PathAnimConf();
    localPathAnimConf6.jdField_a_of_type_JavaLangString = "step7";
    localPathAnimConf6.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_JavaLangString;
    localPathAnimConf6.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_Int;
    localPathAnimConf6.jdField_a_of_type_Float = 0.1F;
    localPathAnimConf6.jdField_b_of_type_Float = 1.0F;
    localPathAnimConf6.c = 0.0F;
    localPathAnimConf6.d = 0.9F;
    localPathAnimConf6.e = 0.05F;
    localPathAnimConf6.f = 1.0F;
    localPathAnimConf6.g = 0.0F;
    localPathAnimConf6.jdField_h_of_type_Float = 0.95F;
    localPathAnimConf6.jdField_h_of_type_Int = -180;
    localPathAnimConf6.i = -270;
    localPathAnimConf6.jdField_a_of_type_Long = 600L;
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf6);
    BubbleNewAnimConf.PathAnimConf localPathAnimConf7 = new BubbleNewAnimConf.PathAnimConf();
    localPathAnimConf7.jdField_a_of_type_JavaLangString = "step8";
    localPathAnimConf7.jdField_b_of_type_JavaLangString = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_JavaLangString;
    localPathAnimConf7.jdField_b_of_type_Int = ((AnimationConfig.AnimationStep)localObject1).jdField_a_of_type_Int;
    localPathAnimConf7.jdField_a_of_type_Float = 0.0F;
    localPathAnimConf7.jdField_b_of_type_Float = 0.9F;
    localPathAnimConf7.c = 0.0F;
    localPathAnimConf7.d = 0.1F;
    localPathAnimConf7.jdField_h_of_type_Int = -270;
    localPathAnimConf7.i = -270;
    localPathAnimConf7.jdField_a_of_type_Long = 800L;
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf7);
    Object localObject1 = new BubbleNewAnimConf.PathAnimConf();
    ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_a_of_type_JavaLangString = "turnback";
    ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_b_of_type_JavaLangString = localAnimationStep.jdField_a_of_type_JavaLangString;
    ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_b_of_type_Int = localAnimationStep.jdField_a_of_type_Int;
    ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_a_of_type_Float = 0.0F;
    ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_b_of_type_Float = 0.1F;
    ((BubbleNewAnimConf.PathAnimConf)localObject1).c = 0.0F;
    ((BubbleNewAnimConf.PathAnimConf)localObject1).d = 0.1F;
    ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_h_of_type_Int = -270;
    ((BubbleNewAnimConf.PathAnimConf)localObject1).i = -270;
    ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_a_of_type_Long = (localAnimationStep.jdField_a_of_type_Int * 125);
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf7.a());
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf6.a());
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf5.a());
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf4.a());
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf3.a());
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf2.a());
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(((BubbleNewAnimConf.PathAnimConf)localObject2).a());
    paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.add(localPathAnimConf1.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.AnimationConfig
 * JD-Core Version:    0.7.0.1
 */
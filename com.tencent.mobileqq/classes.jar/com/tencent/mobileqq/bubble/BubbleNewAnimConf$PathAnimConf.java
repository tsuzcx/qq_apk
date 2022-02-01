package com.tencent.mobileqq.bubble;

public class BubbleNewAnimConf$PathAnimConf
  extends BubbleNewAnimConf
{
  public float a;
  public float b;
  public boolean b;
  public float c;
  public boolean c;
  public float d;
  public float e;
  public int e;
  public float f;
  public int f;
  public float g;
  public int g;
  public float h;
  public int h;
  public int i = 0;
  public int j = 1;
  
  public BubbleNewAnimConf$PathAnimConf()
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 100;
    this.jdField_g_of_type_Int = 100;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public PathAnimConf a()
  {
    PathAnimConf localPathAnimConf = new PathAnimConf();
    localPathAnimConf.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
    localPathAnimConf.jdField_b_of_type_Float = this.d;
    localPathAnimConf.jdField_c_of_type_Float = this.jdField_a_of_type_Float;
    localPathAnimConf.d = this.jdField_b_of_type_Float;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("reverse");
    localPathAnimConf.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_b_of_type_Boolean ^= true;
    localPathAnimConf.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localPathAnimConf.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localPathAnimConf.jdField_f_of_type_Int = this.jdField_g_of_type_Int;
    localPathAnimConf.jdField_g_of_type_Int = this.jdField_f_of_type_Int;
    localPathAnimConf.jdField_h_of_type_Int = this.i;
    localPathAnimConf.i = this.jdField_h_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      localPathAnimConf.jdField_e_of_type_Float = this.jdField_e_of_type_Float;
      localPathAnimConf.jdField_g_of_type_Float = this.jdField_g_of_type_Float;
      localPathAnimConf.jdField_f_of_type_Float = this.jdField_f_of_type_Float;
      localPathAnimConf.jdField_h_of_type_Float = this.jdField_h_of_type_Float;
    }
    else
    {
      localPathAnimConf.jdField_e_of_type_Float = this.jdField_g_of_type_Float;
      localPathAnimConf.jdField_g_of_type_Float = this.jdField_e_of_type_Float;
      localPathAnimConf.jdField_f_of_type_Float = this.jdField_h_of_type_Float;
      localPathAnimConf.jdField_h_of_type_Float = this.jdField_f_of_type_Float;
    }
    localPathAnimConf.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
    localPathAnimConf.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
    localPathAnimConf.j = this.j;
    localPathAnimConf.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localPathAnimConf.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    return localPathAnimConf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAnimConf.PathAnimConf
 * JD-Core Version:    0.7.0.1
 */
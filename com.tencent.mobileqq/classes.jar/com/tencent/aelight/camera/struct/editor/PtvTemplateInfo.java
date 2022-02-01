package com.tencent.aelight.camera.struct.editor;

import java.util.ArrayList;

public class PtvTemplateInfo
{
  public static int j = 1;
  public String A = "";
  public double a;
  public int a;
  public long a;
  public String a;
  public ArrayList<DoodleInfo> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d = 0;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h = 0;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public String j = "";
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y = "";
  public String z = "";
  
  public PtvTemplateInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_i_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public String a(int paramInt)
  {
    if (paramInt != 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("LBS_NORMAL_FILTER_");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LBS_MACDONALD_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PtvTemplateInfo{id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodleInfo=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append('\'');
    localStringBuilder.append(",usable=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.editor.PtvTemplateInfo
 * JD-Core Version:    0.7.0.1
 */
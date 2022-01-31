package com.tencent.mobileqq.app.soso;

import java.util.LinkedList;
import java.util.List;

public final class SosoInterface$SosoLocation
{
  public double a;
  public float a;
  public int a;
  public long a;
  public String a;
  public List a;
  public double b;
  public float b;
  public String b;
  public double c;
  public String c;
  public double d;
  public String d;
  public double e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public SosoInterface$SosoLocation() {}
  
  public SosoInterface$SosoLocation(int paramInt, double paramDouble1, double paramDouble2)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Double = paramDouble1;
      this.jdField_b_of_type_Double = paramDouble2;
    }
    while (paramInt != 0) {
      return;
    }
    this.jdField_c_of_type_Double = paramDouble1;
    this.jdField_d_of_type_Double = paramDouble2;
  }
  
  public SosoLocation a()
  {
    SosoLocation localSosoLocation = new SosoLocation();
    localSosoLocation.jdField_a_of_type_Double = this.jdField_a_of_type_Double;
    localSosoLocation.jdField_b_of_type_Double = this.jdField_b_of_type_Double;
    localSosoLocation.jdField_c_of_type_Double = this.jdField_c_of_type_Double;
    localSosoLocation.jdField_d_of_type_Double = this.jdField_d_of_type_Double;
    localSosoLocation.jdField_e_of_type_Double = this.jdField_e_of_type_Double;
    localSosoLocation.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    localSosoLocation.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localSosoLocation.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localSosoLocation.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localSosoLocation.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localSosoLocation.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localSosoLocation.f = this.f;
    localSosoLocation.g = this.g;
    localSosoLocation.h = this.h;
    localSosoLocation.i = this.i;
    localSosoLocation.j = this.j;
    localSosoLocation.k = this.k;
    localSosoLocation.l = this.l;
    localSosoLocation.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localSosoLocation.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localSosoLocation.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
    localSosoLocation.m = this.m;
    LinkedList localLinkedList = new LinkedList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localLinkedList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    localSosoLocation.jdField_a_of_type_JavaUtilList = localLinkedList;
    return localSosoLocation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.device.qfind;

import java.util.List;

public class PeerInfo
{
  private static int e;
  public int a;
  public long a;
  public String a;
  public List<String> a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c = 0;
  public boolean c;
  public int d;
  public boolean d;
  
  public PeerInfo()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    e += 1;
    this.jdField_a_of_type_Int = e;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.c = 0;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString.replaceAll(":", ""));
    localStringBuilder.append("0000");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.PeerInfo
 * JD-Core Version:    0.7.0.1
 */
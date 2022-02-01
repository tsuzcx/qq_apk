package com.tencent.av;

public class VideoPackageUtils$VideoPacket
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public int d;
  public long d;
  public int e = 0;
  
  public VideoPackageUtils$VideoPacket()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPacket{roomId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", bodyType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", fromuin=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", subServiceType=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", business_flag=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", terminal_switch_flag =");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", u32AccountType =");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", uint64_group_uin =");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", str_from_nation =");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", str_from_mobile =");
    boolean bool;
    if (this.jdField_a_of_type_JavaLangString != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoPackageUtils.VideoPacket
 * JD-Core Version:    0.7.0.1
 */
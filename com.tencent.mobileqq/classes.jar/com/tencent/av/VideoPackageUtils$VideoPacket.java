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
    StringBuilder localStringBuilder = new StringBuilder().append("VideoPacket{roomId=").append(this.jdField_a_of_type_Long).append(", bodyType=").append(this.jdField_a_of_type_Int).append(", uin=").append(this.jdField_b_of_type_Long).append(", fromuin=").append(this.jdField_c_of_type_Long).append(", subServiceType=").append(this.jdField_b_of_type_Int).append(", seq=").append(this.jdField_c_of_type_Int).append(", business_flag=").append(this.jdField_d_of_type_Int).append(", terminal_switch_flag =").append(this.jdField_a_of_type_Boolean).append(", u32AccountType =").append(this.e).append(", uint64_group_uin =").append(this.jdField_d_of_type_Long).append(", str_from_nation =").append(this.jdField_b_of_type_JavaLangString).append(", str_from_mobile =");
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (boolean bool = true;; bool = false) {
      return bool + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoPackageUtils.VideoPacket
 * JD-Core Version:    0.7.0.1
 */
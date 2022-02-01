class bdkf
{
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public final long e;
  public String e;
  public long f = 0L;
  public long g = 0L;
  
  public bdkf()
  {
    this.jdField_e_of_type_Long = 2L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 1L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append("${count_unknown}");
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(2L);
    localStringBuilder.append('|');
    localStringBuilder.append(this.f);
    localStringBuilder.append('|');
    localStringBuilder.append(this.g);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkf
 * JD-Core Version:    0.7.0.1
 */
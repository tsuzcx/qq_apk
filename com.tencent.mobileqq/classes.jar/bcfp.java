public class bcfp
  extends bcfq
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  
  public bcfp()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(this.jdField_b_of_type_Long).append("|");
    localStringBuilder.append(this.i).append("|");
    localStringBuilder.append(this.j).append("|");
    localStringBuilder.append(this.k).append("|");
    localStringBuilder.append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_b_of_type_Int).append("|");
    if (paramInt == 0) {
      localStringBuilder.append("${count_unknown}").append("|");
    }
    for (;;)
    {
      localStringBuilder.append(this.jdField_a_of_type_Long).append("|");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append("|");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString).append("|");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString).append("|");
      localStringBuilder.append(this.d).append("|");
      localStringBuilder.append(this.e).append("|");
      localStringBuilder.append(this.f).append("|");
      localStringBuilder.append(this.g).append("|");
      localStringBuilder.append(this.h).append("|");
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_c_of_type_Int).append("|");
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(64);
    localStringBuffer.append(this.jdField_b_of_type_Long).append("|");
    localStringBuffer.append(this.i).append("|");
    localStringBuffer.append(this.j).append("|");
    localStringBuffer.append(this.k).append("|");
    localStringBuffer.append(this.jdField_a_of_type_Int).append("|");
    localStringBuffer.append(this.jdField_b_of_type_Int).append("|");
    localStringBuffer.append(this.jdField_c_of_type_Int).append("|");
    localStringBuffer.append(this.jdField_a_of_type_Long).append("|");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuffer.append(this.jdField_c_of_type_JavaLangString).append("|");
    localStringBuffer.append(this.d).append("|");
    localStringBuffer.append(this.e).append("|");
    localStringBuffer.append(this.f).append("|");
    localStringBuffer.append(this.g).append("|");
    localStringBuffer.append(this.h).append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfp
 * JD-Core Version:    0.7.0.1
 */
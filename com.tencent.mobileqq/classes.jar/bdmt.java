public class bdmt
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public String c = "0";
  public String d = "default_via";
  public String e;
  public String f;
  public String g;
  public String h;
  
  public bdmt()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static bdmt a(bdmt parambdmt)
  {
    bdmt localbdmt = new bdmt();
    if (parambdmt == null) {
      return localbdmt;
    }
    localbdmt.e = parambdmt.e;
    localbdmt.f = parambdmt.f;
    localbdmt.g = parambdmt.g;
    localbdmt.jdField_a_of_type_Long = parambdmt.jdField_a_of_type_Long;
    localbdmt.h = parambdmt.h;
    localbdmt.jdField_a_of_type_Int = parambdmt.jdField_a_of_type_Int;
    localbdmt.jdField_b_of_type_Int = parambdmt.jdField_b_of_type_Int;
    localbdmt.c = parambdmt.c;
    localbdmt.jdField_b_of_type_JavaLangString = parambdmt.jdField_b_of_type_JavaLangString;
    localbdmt.jdField_a_of_type_JavaLangString = parambdmt.jdField_a_of_type_JavaLangString;
    localbdmt.d = parambdmt.d;
    return localbdmt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pageId=" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\nmoduleId=" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\npositionId=" + this.c);
    localStringBuilder.append("\nvia=" + this.d);
    localStringBuilder.append("\nurl=" + this.e);
    localStringBuilder.append("\npackageName=" + this.f);
    localStringBuilder.append("\niconUrl=" + this.g);
    localStringBuilder.append("\nlength=" + this.jdField_a_of_type_Long);
    localStringBuilder.append("\nname=" + this.h);
    localStringBuilder.append("\nprogress=" + this.jdField_a_of_type_Int);
    localStringBuilder.append("\nstate=" + this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdmt
 * JD-Core Version:    0.7.0.1
 */
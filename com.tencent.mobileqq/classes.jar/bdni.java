public class bdni
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
  
  public bdni()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static bdni a(bdni parambdni)
  {
    bdni localbdni = new bdni();
    if (parambdni == null) {
      return localbdni;
    }
    localbdni.e = parambdni.e;
    localbdni.f = parambdni.f;
    localbdni.g = parambdni.g;
    localbdni.jdField_a_of_type_Long = parambdni.jdField_a_of_type_Long;
    localbdni.h = parambdni.h;
    localbdni.jdField_a_of_type_Int = parambdni.jdField_a_of_type_Int;
    localbdni.jdField_b_of_type_Int = parambdni.jdField_b_of_type_Int;
    localbdni.c = parambdni.c;
    localbdni.jdField_b_of_type_JavaLangString = parambdni.jdField_b_of_type_JavaLangString;
    localbdni.jdField_a_of_type_JavaLangString = parambdni.jdField_a_of_type_JavaLangString;
    localbdni.d = parambdni.d;
    return localbdni;
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
 * Qualified Name:     bdni
 * JD-Core Version:    0.7.0.1
 */
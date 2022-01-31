public class bcis
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
  
  public bcis()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static bcis a(bcis parambcis)
  {
    bcis localbcis = new bcis();
    if (parambcis == null) {
      return localbcis;
    }
    localbcis.e = parambcis.e;
    localbcis.f = parambcis.f;
    localbcis.g = parambcis.g;
    localbcis.jdField_a_of_type_Long = parambcis.jdField_a_of_type_Long;
    localbcis.h = parambcis.h;
    localbcis.jdField_a_of_type_Int = parambcis.jdField_a_of_type_Int;
    localbcis.jdField_b_of_type_Int = parambcis.jdField_b_of_type_Int;
    localbcis.c = parambcis.c;
    localbcis.jdField_b_of_type_JavaLangString = parambcis.jdField_b_of_type_JavaLangString;
    localbcis.jdField_a_of_type_JavaLangString = parambcis.jdField_a_of_type_JavaLangString;
    localbcis.d = parambcis.d;
    return localbcis;
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
 * Qualified Name:     bcis
 * JD-Core Version:    0.7.0.1
 */
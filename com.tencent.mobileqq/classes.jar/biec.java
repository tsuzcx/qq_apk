public class biec
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
  
  public biec()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static biec a(biec parambiec)
  {
    biec localbiec = new biec();
    if (parambiec == null) {
      return localbiec;
    }
    localbiec.e = parambiec.e;
    localbiec.f = parambiec.f;
    localbiec.g = parambiec.g;
    localbiec.jdField_a_of_type_Long = parambiec.jdField_a_of_type_Long;
    localbiec.h = parambiec.h;
    localbiec.jdField_a_of_type_Int = parambiec.jdField_a_of_type_Int;
    localbiec.jdField_b_of_type_Int = parambiec.jdField_b_of_type_Int;
    localbiec.c = parambiec.c;
    localbiec.jdField_b_of_type_JavaLangString = parambiec.jdField_b_of_type_JavaLangString;
    localbiec.jdField_a_of_type_JavaLangString = parambiec.jdField_a_of_type_JavaLangString;
    localbiec.d = parambiec.d;
    return localbiec;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biec
 * JD-Core Version:    0.7.0.1
 */
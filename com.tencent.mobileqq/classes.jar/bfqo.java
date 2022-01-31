public class bfqo
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
  
  public bfqo()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static bfqo a(bfqo parambfqo)
  {
    bfqo localbfqo = new bfqo();
    if (parambfqo == null) {
      return localbfqo;
    }
    localbfqo.e = parambfqo.e;
    localbfqo.f = parambfqo.f;
    localbfqo.g = parambfqo.g;
    localbfqo.jdField_a_of_type_Long = parambfqo.jdField_a_of_type_Long;
    localbfqo.h = parambfqo.h;
    localbfqo.jdField_a_of_type_Int = parambfqo.jdField_a_of_type_Int;
    localbfqo.jdField_b_of_type_Int = parambfqo.jdField_b_of_type_Int;
    localbfqo.c = parambfqo.c;
    localbfqo.jdField_b_of_type_JavaLangString = parambfqo.jdField_b_of_type_JavaLangString;
    localbfqo.jdField_a_of_type_JavaLangString = parambfqo.jdField_a_of_type_JavaLangString;
    localbfqo.d = parambfqo.d;
    return localbfqo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfqo
 * JD-Core Version:    0.7.0.1
 */
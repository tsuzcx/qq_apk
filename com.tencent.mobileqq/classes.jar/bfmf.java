public class bfmf
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
  
  public bfmf()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static bfmf a(bfmf parambfmf)
  {
    bfmf localbfmf = new bfmf();
    if (parambfmf == null) {
      return localbfmf;
    }
    localbfmf.e = parambfmf.e;
    localbfmf.f = parambfmf.f;
    localbfmf.g = parambfmf.g;
    localbfmf.jdField_a_of_type_Long = parambfmf.jdField_a_of_type_Long;
    localbfmf.h = parambfmf.h;
    localbfmf.jdField_a_of_type_Int = parambfmf.jdField_a_of_type_Int;
    localbfmf.jdField_b_of_type_Int = parambfmf.jdField_b_of_type_Int;
    localbfmf.c = parambfmf.c;
    localbfmf.jdField_b_of_type_JavaLangString = parambfmf.jdField_b_of_type_JavaLangString;
    localbfmf.jdField_a_of_type_JavaLangString = parambfmf.jdField_a_of_type_JavaLangString;
    localbfmf.d = parambfmf.d;
    return localbfmf;
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
 * Qualified Name:     bfmf
 * JD-Core Version:    0.7.0.1
 */
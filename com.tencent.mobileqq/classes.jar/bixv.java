public class bixv
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
  
  public bixv()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static bixv a(bixv parambixv)
  {
    bixv localbixv = new bixv();
    if (parambixv == null) {
      return localbixv;
    }
    localbixv.e = parambixv.e;
    localbixv.f = parambixv.f;
    localbixv.g = parambixv.g;
    localbixv.jdField_a_of_type_Long = parambixv.jdField_a_of_type_Long;
    localbixv.h = parambixv.h;
    localbixv.jdField_a_of_type_Int = parambixv.jdField_a_of_type_Int;
    localbixv.jdField_b_of_type_Int = parambixv.jdField_b_of_type_Int;
    localbixv.c = parambixv.c;
    localbixv.jdField_b_of_type_JavaLangString = parambixv.jdField_b_of_type_JavaLangString;
    localbixv.jdField_a_of_type_JavaLangString = parambixv.jdField_a_of_type_JavaLangString;
    localbixv.d = parambixv.d;
    return localbixv;
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
 * Qualified Name:     bixv
 * JD-Core Version:    0.7.0.1
 */
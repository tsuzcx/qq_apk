public class bjyu
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
  
  public bjyu()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static bjyu a(bjyu parambjyu)
  {
    bjyu localbjyu = new bjyu();
    if (parambjyu == null) {
      return localbjyu;
    }
    localbjyu.e = parambjyu.e;
    localbjyu.f = parambjyu.f;
    localbjyu.g = parambjyu.g;
    localbjyu.jdField_a_of_type_Long = parambjyu.jdField_a_of_type_Long;
    localbjyu.h = parambjyu.h;
    localbjyu.jdField_a_of_type_Int = parambjyu.jdField_a_of_type_Int;
    localbjyu.jdField_b_of_type_Int = parambjyu.jdField_b_of_type_Int;
    localbjyu.c = parambjyu.c;
    localbjyu.jdField_b_of_type_JavaLangString = parambjyu.jdField_b_of_type_JavaLangString;
    localbjyu.jdField_a_of_type_JavaLangString = parambjyu.jdField_a_of_type_JavaLangString;
    localbjyu.d = parambjyu.d;
    return localbjyu;
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
 * Qualified Name:     bjyu
 * JD-Core Version:    0.7.0.1
 */
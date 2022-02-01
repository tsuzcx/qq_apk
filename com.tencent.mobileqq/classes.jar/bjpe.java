public class bjpe
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
  
  public bjpe()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static bjpe a(bjpe parambjpe)
  {
    bjpe localbjpe = new bjpe();
    if (parambjpe == null) {
      return localbjpe;
    }
    localbjpe.e = parambjpe.e;
    localbjpe.f = parambjpe.f;
    localbjpe.g = parambjpe.g;
    localbjpe.jdField_a_of_type_Long = parambjpe.jdField_a_of_type_Long;
    localbjpe.h = parambjpe.h;
    localbjpe.jdField_a_of_type_Int = parambjpe.jdField_a_of_type_Int;
    localbjpe.jdField_b_of_type_Int = parambjpe.jdField_b_of_type_Int;
    localbjpe.c = parambjpe.c;
    localbjpe.jdField_b_of_type_JavaLangString = parambjpe.jdField_b_of_type_JavaLangString;
    localbjpe.jdField_a_of_type_JavaLangString = parambjpe.jdField_a_of_type_JavaLangString;
    localbjpe.d = parambjpe.d;
    return localbjpe;
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
 * Qualified Name:     bjpe
 * JD-Core Version:    0.7.0.1
 */
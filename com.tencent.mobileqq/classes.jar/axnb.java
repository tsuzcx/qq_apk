public class axnb
{
  axmy jdField_a_of_type_Axmy;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public axnb(String paramString, axmy paramaxmy)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = ("lib" + paramString + ".so");
    if (paramaxmy != null)
    {
      this.jdField_a_of_type_Axmy = paramaxmy;
      return;
    }
    this.jdField_a_of_type_Axmy = new axmz().a();
  }
  
  public boolean a(axnb paramaxnb)
  {
    if (!ahiy.c(paramaxnb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return this.jdField_a_of_type_Axmy.a(paramaxnb.jdField_a_of_type_Axmy);
  }
  
  public String toString()
  {
    return "LoadItem{name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", lops=" + this.jdField_a_of_type_Axmy + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnb
 * JD-Core Version:    0.7.0.1
 */
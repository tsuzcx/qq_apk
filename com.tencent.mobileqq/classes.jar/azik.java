public class azik
{
  azih jdField_a_of_type_Azih;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public azik(String paramString, azih paramazih)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = ("lib" + paramString + ".so");
    if (paramazih != null)
    {
      this.jdField_a_of_type_Azih = paramazih;
      return;
    }
    this.jdField_a_of_type_Azih = new azii().a();
  }
  
  public boolean a(azik paramazik)
  {
    if (!ajaf.c(paramazik.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return this.jdField_a_of_type_Azih.a(paramazik.jdField_a_of_type_Azih);
  }
  
  public String toString()
  {
    return "LoadItem{name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", lops=" + this.jdField_a_of_type_Azih + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azik
 * JD-Core Version:    0.7.0.1
 */
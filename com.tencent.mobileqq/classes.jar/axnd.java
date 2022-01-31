public class axnd
{
  axna jdField_a_of_type_Axna;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public axnd(String paramString, axna paramaxna)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = ("lib" + paramString + ".so");
    if (paramaxna != null)
    {
      this.jdField_a_of_type_Axna = paramaxna;
      return;
    }
    this.jdField_a_of_type_Axna = new axnb().a();
  }
  
  public boolean a(axnd paramaxnd)
  {
    if (!ahiw.c(paramaxnd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return this.jdField_a_of_type_Axna.a(paramaxnd.jdField_a_of_type_Axna);
  }
  
  public String toString()
  {
    return "LoadItem{name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", lops=" + this.jdField_a_of_type_Axna + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnd
 * JD-Core Version:    0.7.0.1
 */
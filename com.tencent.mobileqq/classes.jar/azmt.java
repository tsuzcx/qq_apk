public class azmt
{
  azmq jdField_a_of_type_Azmq;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public azmt(String paramString, azmq paramazmq)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = ("lib" + paramString + ".so");
    if (paramazmq != null)
    {
      this.jdField_a_of_type_Azmq = paramazmq;
      return;
    }
    this.jdField_a_of_type_Azmq = new azmr().a();
  }
  
  public boolean a(azmt paramazmt)
  {
    if (!ajeu.c(paramazmt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return this.jdField_a_of_type_Azmq.a(paramazmt.jdField_a_of_type_Azmq);
  }
  
  public String toString()
  {
    return "LoadItem{name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", lops=" + this.jdField_a_of_type_Azmq + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmt
 * JD-Core Version:    0.7.0.1
 */
public class besd
{
  besa jdField_a_of_type_Besa;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public besd(String paramString, besa parambesa)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = ("lib" + paramString + ".so");
    if (parambesa != null)
    {
      this.jdField_a_of_type_Besa = parambesa;
      return;
    }
    this.jdField_a_of_type_Besa = new besb().a();
  }
  
  public boolean a(besd parambesd)
  {
    if (!agwj.c(parambesd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return this.jdField_a_of_type_Besa.a(parambesd.jdField_a_of_type_Besa);
  }
  
  public String toString()
  {
    return "LoadItem{name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", lops=" + this.jdField_a_of_type_Besa + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besd
 * JD-Core Version:    0.7.0.1
 */
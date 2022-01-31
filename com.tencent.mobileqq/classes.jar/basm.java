import java.util.ArrayList;

public class basm
{
  public int a;
  public basm a;
  public String a;
  public ArrayList<basm> a;
  public String b;
  
  private basm() {}
  
  public basm(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    basm localbasm = this;
    while (localbasm.jdField_a_of_type_Basm != null)
    {
      localbasm = localbasm.jdField_a_of_type_Basm;
      str = localbasm.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(basm parambasm)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambasm);
  }
  
  public boolean a(basm parambasm)
  {
    if ((parambasm != null) && (parambasm.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Basm = parambasm;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     basm
 * JD-Core Version:    0.7.0.1
 */
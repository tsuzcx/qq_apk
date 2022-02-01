import java.util.ArrayList;

public class bgss
{
  public int a;
  public bgss a;
  public String a;
  public ArrayList<bgss> a;
  public String b;
  
  private bgss() {}
  
  public bgss(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    bgss localbgss = this;
    while (localbgss.jdField_a_of_type_Bgss != null)
    {
      localbgss = localbgss.jdField_a_of_type_Bgss;
      str = localbgss.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(bgss parambgss)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambgss);
  }
  
  public boolean a(bgss parambgss)
  {
    if ((parambgss != null) && (parambgss.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Bgss = parambgss;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgss
 * JD-Core Version:    0.7.0.1
 */
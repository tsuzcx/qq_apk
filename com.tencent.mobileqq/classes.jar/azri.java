import java.util.ArrayList;

public class azri
{
  public int a;
  public azri a;
  public String a;
  public ArrayList<azri> a;
  public String b;
  
  private azri() {}
  
  public azri(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    azri localazri = this;
    while (localazri.jdField_a_of_type_Azri != null)
    {
      localazri = localazri.jdField_a_of_type_Azri;
      str = localazri.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(azri paramazri)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramazri);
  }
  
  public boolean a(azri paramazri)
  {
    if ((paramazri != null) && (paramazri.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Azri = paramazri;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azri
 * JD-Core Version:    0.7.0.1
 */
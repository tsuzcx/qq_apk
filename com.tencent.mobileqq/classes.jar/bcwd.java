import java.util.ArrayList;

public class bcwd
{
  public int a;
  public bcwd a;
  public String a;
  public ArrayList<bcwd> a;
  public String b;
  
  private bcwd() {}
  
  public bcwd(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    bcwd localbcwd = this;
    while (localbcwd.jdField_a_of_type_Bcwd != null)
    {
      localbcwd = localbcwd.jdField_a_of_type_Bcwd;
      str = localbcwd.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(bcwd parambcwd)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambcwd);
  }
  
  public boolean a(bcwd parambcwd)
  {
    if ((parambcwd != null) && (parambcwd.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Bcwd = parambcwd;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwd
 * JD-Core Version:    0.7.0.1
 */
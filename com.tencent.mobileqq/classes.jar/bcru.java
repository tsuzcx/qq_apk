import java.util.ArrayList;

public class bcru
{
  public int a;
  public bcru a;
  public String a;
  public ArrayList<bcru> a;
  public String b;
  
  private bcru() {}
  
  public bcru(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    bcru localbcru = this;
    while (localbcru.jdField_a_of_type_Bcru != null)
    {
      localbcru = localbcru.jdField_a_of_type_Bcru;
      str = localbcru.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(bcru parambcru)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambcru);
  }
  
  public boolean a(bcru parambcru)
  {
    if ((parambcru != null) && (parambcru.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Bcru = parambcru;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcru
 * JD-Core Version:    0.7.0.1
 */
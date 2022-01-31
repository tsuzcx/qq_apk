import java.util.ArrayList;

public class bata
{
  public int a;
  public bata a;
  public String a;
  public ArrayList<bata> a;
  public String b;
  
  private bata() {}
  
  public bata(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    bata localbata = this;
    while (localbata.jdField_a_of_type_Bata != null)
    {
      localbata = localbata.jdField_a_of_type_Bata;
      str = localbata.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(bata parambata)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambata);
  }
  
  public boolean a(bata parambata)
  {
    if ((parambata != null) && (parambata.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Bata = parambata;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bata
 * JD-Core Version:    0.7.0.1
 */
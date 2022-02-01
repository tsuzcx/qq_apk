import java.util.ArrayList;

public class bfkb
{
  public int a;
  public bfkb a;
  public String a;
  public ArrayList<bfkb> a;
  public String b;
  
  private bfkb() {}
  
  public bfkb(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    bfkb localbfkb = this;
    while (localbfkb.jdField_a_of_type_Bfkb != null)
    {
      localbfkb = localbfkb.jdField_a_of_type_Bfkb;
      str = localbfkb.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(bfkb parambfkb)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambfkb);
  }
  
  public boolean a(bfkb parambfkb)
  {
    if ((parambfkb != null) && (parambfkb.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Bfkb = parambfkb;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkb
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;

public class bhap
{
  public int a;
  public bhap a;
  public String a;
  public ArrayList<bhap> a;
  public String b;
  
  private bhap() {}
  
  public bhap(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    bhap localbhap = this;
    while (localbhap.jdField_a_of_type_Bhap != null)
    {
      localbhap = localbhap.jdField_a_of_type_Bhap;
      str = localbhap.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(bhap parambhap)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambhap);
  }
  
  public boolean a(bhap parambhap)
  {
    if ((parambhap != null) && (parambhap.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Bhap = parambhap;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhap
 * JD-Core Version:    0.7.0.1
 */
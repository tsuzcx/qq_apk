import java.util.ArrayList;

public class bgao
{
  public int a;
  public bgao a;
  public String a;
  public ArrayList<bgao> a;
  public String b;
  
  private bgao() {}
  
  public bgao(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    bgao localbgao = this;
    while (localbgao.jdField_a_of_type_Bgao != null)
    {
      localbgao = localbgao.jdField_a_of_type_Bgao;
      str = localbgao.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(bgao parambgao)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambgao);
  }
  
  public boolean a(bgao parambgao)
  {
    if ((parambgao != null) && (parambgao.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Bgao = parambgao;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgao
 * JD-Core Version:    0.7.0.1
 */
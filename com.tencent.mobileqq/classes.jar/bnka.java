import java.util.ArrayList;
import java.util.List;

public class bnka
  implements Cloneable
{
  public int a;
  public String a;
  public List<bnke> a;
  public boolean a;
  public int b;
  public String b;
  
  public bnka()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public bnka(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public bnka a()
  {
    bnka localbnka = new bnka();
    localbnka.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbnka.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbnka.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbnka.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbnka.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbnka.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbnka.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbnka;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnka
 * JD-Core Version:    0.7.0.1
 */
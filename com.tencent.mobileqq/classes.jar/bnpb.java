import java.util.ArrayList;
import java.util.List;

public class bnpb
  implements Cloneable
{
  public int a;
  public String a;
  public List<bnpf> a;
  public boolean a;
  public int b;
  public String b;
  
  public bnpb()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public bnpb(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public bnpb a()
  {
    bnpb localbnpb = new bnpb();
    localbnpb.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbnpb.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbnpb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbnpb.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbnpb.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbnpb.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbnpb.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbnpb;
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
 * Qualified Name:     bnpb
 * JD-Core Version:    0.7.0.1
 */
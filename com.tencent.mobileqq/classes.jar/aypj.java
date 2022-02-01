import java.util.ArrayList;
import java.util.List;

public class aypj
  implements aypg
{
  private static volatile aypj jdField_a_of_type_Aypj;
  private aypg jdField_a_of_type_Aypg;
  private List<aypk> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static aypj a()
  {
    if (jdField_a_of_type_Aypj == null) {}
    try
    {
      if (jdField_a_of_type_Aypj == null) {
        jdField_a_of_type_Aypj = new aypj();
      }
      return jdField_a_of_type_Aypj;
    }
    finally {}
  }
  
  public List<aypk> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    new ayph().a(this);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(aypg paramaypg)
  {
    this.jdField_a_of_type_Aypg = paramaypg;
  }
  
  public void a(List<aypk> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Aypg != null) {
      this.jdField_a_of_type_Aypg.a(paramList);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aypg = null;
    jdField_a_of_type_Aypj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypj
 * JD-Core Version:    0.7.0.1
 */
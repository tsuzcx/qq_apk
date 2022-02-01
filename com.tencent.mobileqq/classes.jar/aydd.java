import java.util.ArrayList;
import java.util.List;

public class aydd
  implements ayda
{
  private static volatile aydd jdField_a_of_type_Aydd;
  private ayda jdField_a_of_type_Ayda;
  private List<ayde> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static aydd a()
  {
    if (jdField_a_of_type_Aydd == null) {}
    try
    {
      if (jdField_a_of_type_Aydd == null) {
        jdField_a_of_type_Aydd = new aydd();
      }
      return jdField_a_of_type_Aydd;
    }
    finally {}
  }
  
  public List<ayde> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    new aydb().a(this);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(ayda paramayda)
  {
    this.jdField_a_of_type_Ayda = paramayda;
  }
  
  public void a(List<ayde> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Ayda != null) {
      this.jdField_a_of_type_Ayda.a(paramList);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ayda = null;
    jdField_a_of_type_Aydd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydd
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.List;

public class axje
  implements axjb
{
  private static volatile axje jdField_a_of_type_Axje;
  private axjb jdField_a_of_type_Axjb;
  private List<axjf> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static axje a()
  {
    if (jdField_a_of_type_Axje == null) {}
    try
    {
      if (jdField_a_of_type_Axje == null) {
        jdField_a_of_type_Axje = new axje();
      }
      return jdField_a_of_type_Axje;
    }
    finally {}
  }
  
  public List<axjf> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    new axjc().a(this);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(axjb paramaxjb)
  {
    this.jdField_a_of_type_Axjb = paramaxjb;
  }
  
  public void a(List<axjf> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Axjb != null) {
      this.jdField_a_of_type_Axjb.a(paramList);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Axjb = null;
    jdField_a_of_type_Axje = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axje
 * JD-Core Version:    0.7.0.1
 */
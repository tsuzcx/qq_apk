import java.util.ArrayList;
import java.util.List;

public class ayvw
  implements ayvt
{
  private static volatile ayvw jdField_a_of_type_Ayvw;
  private ayvt jdField_a_of_type_Ayvt;
  private List<ayvx> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static ayvw a()
  {
    if (jdField_a_of_type_Ayvw == null) {}
    try
    {
      if (jdField_a_of_type_Ayvw == null) {
        jdField_a_of_type_Ayvw = new ayvw();
      }
      return jdField_a_of_type_Ayvw;
    }
    finally {}
  }
  
  public List<ayvx> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    new ayvu().a(this);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(ayvt paramayvt)
  {
    this.jdField_a_of_type_Ayvt = paramayvt;
  }
  
  public void a(List<ayvx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Ayvt != null) {
      this.jdField_a_of_type_Ayvt.a(paramList);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ayvt = null;
    jdField_a_of_type_Ayvw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvw
 * JD-Core Version:    0.7.0.1
 */
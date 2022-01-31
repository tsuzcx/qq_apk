import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import java.util.ArrayList;

public class ansg
{
  public int a;
  public long a;
  public ansg a;
  public ArrayList a;
  public boolean a;
  
  private ansg()
  {
    this.jdField_a_of_type_Ansg = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static ansg a()
  {
    ansg localansg = new ansg();
    localansg.a();
    return localansg;
  }
  
  public String a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "LBS_REQ_OK";
    case 1: 
      return "LBS_REQ_PENDING";
    }
    return "LBS_REQ_PERM_OK";
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Ansg == null) {
      this.jdField_a_of_type_Ansg = new ansg();
    }
  }
  
  public boolean a(String paramString)
  {
    LbsFilterStatusManager.a("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.jdField_a_of_type_JavaUtilArrayList.toString() }), null);
    return this.jdField_a_of_type_JavaUtilArrayList.contains(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ansg.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Ansg.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Ansg.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Ansg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Ansg.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansg
 * JD-Core Version:    0.7.0.1
 */
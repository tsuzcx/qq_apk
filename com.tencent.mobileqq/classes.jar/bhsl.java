import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class bhsl
{
  private static ArrayList<bhsl> a;
  public int a;
  public bhsm a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bhsl a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbhsl = (bhsl)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbhsl.b();
        return localbhsl;
      }
      bhsl localbhsl = new bhsl();
      return localbhsl;
    }
  }
  
  public static bhsl a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    bhsl localbhsl = a();
    localbhsl.jdField_a_of_type_Bhsm = bhsm.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localbhsl.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localbhsl.jdField_a_of_type_Int = paramInt5;
    return localbhsl;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bhsm = null;
    this.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() < 5) {
        jdField_a_of_type_JavaUtilArrayList.add(this);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhsl
 * JD-Core Version:    0.7.0.1
 */
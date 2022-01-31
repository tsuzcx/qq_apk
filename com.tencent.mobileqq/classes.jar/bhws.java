import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class bhws
{
  private static ArrayList<bhws> a;
  public int a;
  public bhwt a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bhws a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbhws = (bhws)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbhws.b();
        return localbhws;
      }
      bhws localbhws = new bhws();
      return localbhws;
    }
  }
  
  public static bhws a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    bhws localbhws = a();
    localbhws.jdField_a_of_type_Bhwt = bhwt.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localbhws.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localbhws.jdField_a_of_type_Int = paramInt5;
    return localbhws;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bhwt = null;
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
 * Qualified Name:     bhws
 * JD-Core Version:    0.7.0.1
 */
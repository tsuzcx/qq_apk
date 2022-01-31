import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class beje
{
  private static ArrayList<beje> a;
  public int a;
  public bejf a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static beje a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbeje = (beje)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbeje.b();
        return localbeje;
      }
      beje localbeje = new beje();
      return localbeje;
    }
  }
  
  public static beje a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    beje localbeje = a();
    localbeje.jdField_a_of_type_Bejf = bejf.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localbeje.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localbeje.jdField_a_of_type_Int = paramInt5;
    return localbeje;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bejf = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beje
 * JD-Core Version:    0.7.0.1
 */
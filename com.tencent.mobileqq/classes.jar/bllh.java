import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class bllh
{
  private static ArrayList<bllh> a;
  public int a;
  public blli a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bllh a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbllh = (bllh)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbllh.b();
        return localbllh;
      }
      bllh localbllh = new bllh();
      return localbllh;
    }
  }
  
  public static bllh a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    bllh localbllh = a();
    localbllh.jdField_a_of_type_Blli = blli.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localbllh.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localbllh.jdField_a_of_type_Int = paramInt5;
    return localbllh;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Blli = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllh
 * JD-Core Version:    0.7.0.1
 */
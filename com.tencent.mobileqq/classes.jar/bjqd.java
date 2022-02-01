import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class bjqd
{
  private static ArrayList<bjqd> a;
  public int a;
  public bjqe a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bjqd a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbjqd = (bjqd)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbjqd.b();
        return localbjqd;
      }
      bjqd localbjqd = new bjqd();
      return localbjqd;
    }
  }
  
  public static bjqd a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    bjqd localbjqd = a();
    localbjqd.jdField_a_of_type_Bjqe = bjqe.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localbjqd.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localbjqd.jdField_a_of_type_Int = paramInt5;
    return localbjqd;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bjqe = null;
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
 * Qualified Name:     bjqd
 * JD-Core Version:    0.7.0.1
 */
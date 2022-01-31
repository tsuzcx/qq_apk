import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class bfrp
{
  private static ArrayList<bfrp> a;
  public int a;
  public bfrq a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bfrp a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbfrp = (bfrp)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbfrp.b();
        return localbfrp;
      }
      bfrp localbfrp = new bfrp();
      return localbfrp;
    }
  }
  
  public static bfrp a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    bfrp localbfrp = a();
    localbfrp.jdField_a_of_type_Bfrq = bfrq.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localbfrp.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localbfrp.jdField_a_of_type_Int = paramInt5;
    return localbfrp;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bfrq = null;
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
 * Qualified Name:     bfrp
 * JD-Core Version:    0.7.0.1
 */
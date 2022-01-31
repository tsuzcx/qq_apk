import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class bfqy
{
  private static ArrayList<bfqy> a;
  public int a;
  public bfqz a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bfqy a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbfqy = (bfqy)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbfqy.b();
        return localbfqy;
      }
      bfqy localbfqy = new bfqy();
      return localbfqy;
    }
  }
  
  public static bfqy a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    bfqy localbfqy = a();
    localbfqy.jdField_a_of_type_Bfqz = bfqz.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localbfqy.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localbfqy.jdField_a_of_type_Int = paramInt5;
    return localbfqy;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bfqz = null;
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
 * Qualified Name:     bfqy
 * JD-Core Version:    0.7.0.1
 */
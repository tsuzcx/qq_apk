import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class bkke
{
  private static ArrayList<bkke> a;
  public int a;
  public bkkf a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bkke a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbkke = (bkke)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbkke.b();
        return localbkke;
      }
      bkke localbkke = new bkke();
      return localbkke;
    }
  }
  
  public static bkke a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    bkke localbkke = a();
    localbkke.jdField_a_of_type_Bkkf = bkkf.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localbkke.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localbkke.jdField_a_of_type_Int = paramInt5;
    return localbkke;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bkkf = null;
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
 * Qualified Name:     bkke
 * JD-Core Version:    0.7.0.1
 */
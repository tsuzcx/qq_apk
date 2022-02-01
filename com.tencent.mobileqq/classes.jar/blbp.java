import com.tencent.widget.ExpandableListConnector.GroupMetadata;
import java.util.ArrayList;

public class blbp
{
  private static ArrayList<blbp> a;
  public int a;
  public blbq a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static blbp a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localblbp = (blbp)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localblbp.b();
        return localblbp;
      }
      blbp localblbp = new blbp();
      return localblbp;
    }
  }
  
  public static blbp a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    blbp localblbp = a();
    localblbp.jdField_a_of_type_Blbq = blbq.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localblbp.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localblbp.jdField_a_of_type_Int = paramInt5;
    return localblbp;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Blbq = null;
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
 * Qualified Name:     blbp
 * JD-Core Version:    0.7.0.1
 */
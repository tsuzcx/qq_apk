import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bapk
{
  private static final Comparator<bapi> jdField_a_of_type_JavaUtilComparator = new bapl();
  private List<bapi> jdField_a_of_type_JavaUtilList;
  
  public List<bapi> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new bapj();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((bapj)localObject).a(paramArrayOfInt[i]);
      while (((bapj)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((bapj)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((bapj)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (bapi)paramArrayOfInt.next();
      ((bapi)localObject).jdField_a_of_type_Long = ((int)((float)((bapi)localObject).jdField_a_of_type_Long / ((bapi)localObject).jdField_a_of_type_Int));
      ((bapi)localObject).b = ((int)((float)((bapi)localObject).b / ((bapi)localObject).jdField_a_of_type_Int));
      ((bapi)localObject).c = ((int)((float)((bapi)localObject).c / ((bapi)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bapk
 * JD-Core Version:    0.7.0.1
 */
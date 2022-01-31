import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bbrv
{
  private static final Comparator<bbrt> jdField_a_of_type_JavaUtilComparator = new bbrw();
  private List<bbrt> jdField_a_of_type_JavaUtilList;
  
  public List<bbrt> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new bbru();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((bbru)localObject).a(paramArrayOfInt[i]);
      while (((bbru)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((bbru)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((bbru)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (bbrt)paramArrayOfInt.next();
      ((bbrt)localObject).jdField_a_of_type_Long = ((int)((float)((bbrt)localObject).jdField_a_of_type_Long / ((bbrt)localObject).jdField_a_of_type_Int));
      ((bbrt)localObject).b = ((int)((float)((bbrt)localObject).b / ((bbrt)localObject).jdField_a_of_type_Int));
      ((bbrt)localObject).c = ((int)((float)((bbrt)localObject).c / ((bbrt)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrv
 * JD-Core Version:    0.7.0.1
 */
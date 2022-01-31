import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bduy
{
  private static final Comparator<bduw> jdField_a_of_type_JavaUtilComparator = new bduz();
  private List<bduw> jdField_a_of_type_JavaUtilList;
  
  public List<bduw> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new bdux();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((bdux)localObject).a(paramArrayOfInt[i]);
      while (((bdux)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((bdux)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((bdux)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (bduw)paramArrayOfInt.next();
      ((bduw)localObject).jdField_a_of_type_Long = ((int)((float)((bduw)localObject).jdField_a_of_type_Long / ((bduw)localObject).jdField_a_of_type_Int));
      ((bduw)localObject).b = ((int)((float)((bduw)localObject).b / ((bduw)localObject).jdField_a_of_type_Int));
      ((bduw)localObject).c = ((int)((float)((bduw)localObject).c / ((bduw)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduy
 * JD-Core Version:    0.7.0.1
 */
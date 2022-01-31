import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bdqp
{
  private static final Comparator<bdqn> jdField_a_of_type_JavaUtilComparator = new bdqq();
  private List<bdqn> jdField_a_of_type_JavaUtilList;
  
  public List<bdqn> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new bdqo();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((bdqo)localObject).a(paramArrayOfInt[i]);
      while (((bdqo)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((bdqo)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((bdqo)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (bdqn)paramArrayOfInt.next();
      ((bdqn)localObject).jdField_a_of_type_Long = ((int)((float)((bdqn)localObject).jdField_a_of_type_Long / ((bdqn)localObject).jdField_a_of_type_Int));
      ((bdqn)localObject).b = ((int)((float)((bdqn)localObject).b / ((bdqn)localObject).jdField_a_of_type_Int));
      ((bdqn)localObject).c = ((int)((float)((bdqn)localObject).c / ((bdqn)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqp
 * JD-Core Version:    0.7.0.1
 */
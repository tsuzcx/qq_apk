import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class biaf
{
  private static final Comparator<biad> jdField_a_of_type_JavaUtilComparator = new biag();
  private List<biad> jdField_a_of_type_JavaUtilList;
  
  public List<biad> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new biae();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((biae)localObject).a(paramArrayOfInt[i]);
      while (((biae)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((biae)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((biae)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (biad)paramArrayOfInt.next();
      ((biad)localObject).jdField_a_of_type_Long = ((int)((float)((biad)localObject).jdField_a_of_type_Long / ((biad)localObject).jdField_a_of_type_Int));
      ((biad)localObject).b = ((int)((float)((biad)localObject).b / ((biad)localObject).jdField_a_of_type_Int));
      ((biad)localObject).c = ((int)((float)((biad)localObject).c / ((biad)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biaf
 * JD-Core Version:    0.7.0.1
 */
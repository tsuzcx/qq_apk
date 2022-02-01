import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bgzz
{
  private static final Comparator<bgzx> jdField_a_of_type_JavaUtilComparator = new bhaa();
  private List<bgzx> jdField_a_of_type_JavaUtilList;
  
  public List<bgzx> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new bgzy();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((bgzy)localObject).a(paramArrayOfInt[i]);
      while (((bgzy)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((bgzy)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((bgzy)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (bgzx)paramArrayOfInt.next();
      ((bgzx)localObject).jdField_a_of_type_Long = ((int)((float)((bgzx)localObject).jdField_a_of_type_Long / ((bgzx)localObject).jdField_a_of_type_Int));
      ((bgzx)localObject).b = ((int)((float)((bgzx)localObject).b / ((bgzx)localObject).jdField_a_of_type_Int));
      ((bgzx)localObject).c = ((int)((float)((bgzx)localObject).c / ((bgzx)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzz
 * JD-Core Version:    0.7.0.1
 */
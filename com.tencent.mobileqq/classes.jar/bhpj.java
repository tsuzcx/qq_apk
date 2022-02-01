import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bhpj
{
  private static final Comparator<bhph> jdField_a_of_type_JavaUtilComparator = new bhpk();
  private List<bhph> jdField_a_of_type_JavaUtilList;
  
  public List<bhph> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new bhpi();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((bhpi)localObject).a(paramArrayOfInt[i]);
      while (((bhpi)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((bhpi)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((bhpi)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (bhph)paramArrayOfInt.next();
      ((bhph)localObject).jdField_a_of_type_Long = ((int)((float)((bhph)localObject).jdField_a_of_type_Long / ((bhph)localObject).jdField_a_of_type_Int));
      ((bhph)localObject).b = ((int)((float)((bhph)localObject).b / ((bhph)localObject).jdField_a_of_type_Int));
      ((bhph)localObject).c = ((int)((float)((bhph)localObject).c / ((bhph)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpj
 * JD-Core Version:    0.7.0.1
 */
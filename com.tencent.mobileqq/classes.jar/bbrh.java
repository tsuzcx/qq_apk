import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bbrh
{
  private static final Comparator<bbrf> jdField_a_of_type_JavaUtilComparator = new bbri();
  private List<bbrf> jdField_a_of_type_JavaUtilList;
  
  public List<bbrf> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new bbrg();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((bbrg)localObject).a(paramArrayOfInt[i]);
      while (((bbrg)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((bbrg)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((bbrg)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (bbrf)paramArrayOfInt.next();
      ((bbrf)localObject).jdField_a_of_type_Long = ((int)((float)((bbrf)localObject).jdField_a_of_type_Long / ((bbrf)localObject).jdField_a_of_type_Int));
      ((bbrf)localObject).b = ((int)((float)((bbrf)localObject).b / ((bbrf)localObject).jdField_a_of_type_Int));
      ((bbrf)localObject).c = ((int)((float)((bbrf)localObject).c / ((bbrf)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrh
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bggp
{
  private static final Comparator<bggn> jdField_a_of_type_JavaUtilComparator = new bggq();
  private List<bggn> jdField_a_of_type_JavaUtilList;
  
  public List<bggn> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new bggo();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((bggo)localObject).a(paramArrayOfInt[i]);
      while (((bggo)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((bggo)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((bggo)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (bggn)paramArrayOfInt.next();
      ((bggn)localObject).jdField_a_of_type_Long = ((int)((float)((bggn)localObject).jdField_a_of_type_Long / ((bggn)localObject).jdField_a_of_type_Int));
      ((bggn)localObject).b = ((int)((float)((bggn)localObject).b / ((bggn)localObject).jdField_a_of_type_Int));
      ((bggn)localObject).c = ((int)((float)((bggn)localObject).c / ((bggn)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggp
 * JD-Core Version:    0.7.0.1
 */
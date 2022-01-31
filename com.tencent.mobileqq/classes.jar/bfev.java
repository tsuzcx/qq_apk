import java.util.Iterator;
import java.util.List;

public class bfev
{
  bfer jdField_a_of_type_Bfer;
  List<bfer> jdField_a_of_type_JavaUtilList;
  
  bfev(bfer parambfer, List<bfer> paramList)
  {
    this.jdField_a_of_type_Bfer = paramList;
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((bfer)localIterator.next()).c());
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Bfer.e();
      }
      return;
    }
  }
  
  public boolean a(bfer parambfer)
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambfer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfev
 * JD-Core Version:    0.7.0.1
 */
import java.util.Iterator;
import java.util.List;

public class bffm
{
  bffi jdField_a_of_type_Bffi;
  List<bffi> jdField_a_of_type_JavaUtilList;
  
  bffm(bffi parambffi, List<bffi> paramList)
  {
    this.jdField_a_of_type_Bffi = paramList;
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
      } while (((bffi)localIterator.next()).c());
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Bffi.e();
      }
      return;
    }
  }
  
  public boolean a(bffi parambffi)
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambffi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffm
 * JD-Core Version:    0.7.0.1
 */
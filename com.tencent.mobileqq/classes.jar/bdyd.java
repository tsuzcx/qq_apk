import java.util.Iterator;
import java.util.List;

public class bdyd
{
  bdxz jdField_a_of_type_Bdxz;
  List<bdxz> jdField_a_of_type_JavaUtilList;
  
  bdyd(bdxz parambdxz, List<bdxz> paramList)
  {
    this.jdField_a_of_type_Bdxz = paramList;
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
      } while (((bdxz)localIterator.next()).c());
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Bdxz.e();
      }
      return;
    }
  }
  
  public boolean a(bdxz parambdxz)
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambdxz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdyd
 * JD-Core Version:    0.7.0.1
 */
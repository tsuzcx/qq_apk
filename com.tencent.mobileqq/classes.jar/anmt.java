import java.util.Iterator;
import java.util.List;

public class anmt
{
  anmp jdField_a_of_type_Anmp;
  List<anmp> jdField_a_of_type_JavaUtilList;
  
  anmt(anmp paramanmp, List<anmp> paramList)
  {
    this.jdField_a_of_type_Anmp = paramList;
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
      } while (((anmp)localIterator.next()).a());
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Anmp.c();
      }
      return;
    }
  }
  
  public boolean a(anmp paramanmp)
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramanmp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmt
 * JD-Core Version:    0.7.0.1
 */
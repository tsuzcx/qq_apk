import java.util.Iterator;
import java.util.List;

public class bhhr
{
  bhhn jdField_a_of_type_Bhhn;
  List<bhhn> jdField_a_of_type_JavaUtilList;
  
  bhhr(bhhn parambhhn, List<bhhn> paramList)
  {
    this.jdField_a_of_type_Bhhn = paramList;
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
      } while (((bhhn)localIterator.next()).d());
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Bhhn.g();
      }
      return;
    }
  }
  
  public boolean a(bhhn parambhhn)
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambhhn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhr
 * JD-Core Version:    0.7.0.1
 */
import java.util.Iterator;
import java.util.List;

public class bhly
{
  bhlu jdField_a_of_type_Bhlu;
  List<bhlu> jdField_a_of_type_JavaUtilList;
  
  bhly(bhlu parambhlu, List<bhlu> paramList)
  {
    this.jdField_a_of_type_Bhlu = paramList;
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
      } while (((bhlu)localIterator.next()).d());
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Bhlu.g();
      }
      return;
    }
  }
  
  public boolean a(bhlu parambhlu)
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambhlu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhly
 * JD-Core Version:    0.7.0.1
 */
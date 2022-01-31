import java.util.ArrayList;
import java.util.List;

public class axqd
{
  int jdField_a_of_type_Int = 0;
  axqe jdField_a_of_type_Axqe = new axqe(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public axqd()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Axqe;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      axqe localaxqe = ((axqe)localObject).a(c);
      if (localaxqe == null)
      {
        localaxqe = new axqe(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((axqe)localObject).a(localaxqe);
      }
      for (localObject = localaxqe;; localObject = localaxqe)
      {
        i += 1;
        break;
        localaxqe.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axqd
 * JD-Core Version:    0.7.0.1
 */
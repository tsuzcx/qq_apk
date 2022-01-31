import java.util.ArrayList;
import java.util.List;

public class axqb
{
  int jdField_a_of_type_Int = 0;
  axqc jdField_a_of_type_Axqc = new axqc(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public axqb()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Axqc;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      axqc localaxqc = ((axqc)localObject).a(c);
      if (localaxqc == null)
      {
        localaxqc = new axqc(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((axqc)localObject).a(localaxqc);
      }
      for (localObject = localaxqc;; localObject = localaxqc)
      {
        i += 1;
        break;
        localaxqc.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axqb
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.List;

public class bdkq
{
  int jdField_a_of_type_Int = 0;
  bdkr jdField_a_of_type_Bdkr = new bdkr(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bdkq()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Bdkr;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      bdkr localbdkr = ((bdkr)localObject).a(c);
      if (localbdkr == null)
      {
        localbdkr = new bdkr(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((bdkr)localObject).a(localbdkr);
      }
      for (localObject = localbdkr;; localObject = localbdkr)
      {
        i += 1;
        break;
        localbdkr.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkq
 * JD-Core Version:    0.7.0.1
 */
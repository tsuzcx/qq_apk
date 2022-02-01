import java.util.ArrayList;
import java.util.List;

public class bdkf
{
  int jdField_a_of_type_Int = 0;
  bdkg jdField_a_of_type_Bdkg = new bdkg(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bdkf()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Bdkg;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      bdkg localbdkg = ((bdkg)localObject).a(c);
      if (localbdkg == null)
      {
        localbdkg = new bdkg(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((bdkg)localObject).a(localbdkg);
      }
      for (localObject = localbdkg;; localObject = localbdkg)
      {
        i += 1;
        break;
        localbdkg.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkf
 * JD-Core Version:    0.7.0.1
 */
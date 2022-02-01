import java.util.ArrayList;
import java.util.List;

public class bcdk
{
  int jdField_a_of_type_Int = 0;
  bcdl jdField_a_of_type_Bcdl = new bcdl(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bcdk()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Bcdl;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      bcdl localbcdl = ((bcdl)localObject).a(c);
      if (localbcdl == null)
      {
        localbcdl = new bcdl(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((bcdl)localObject).a(localbcdl);
      }
      for (localObject = localbcdl;; localObject = localbcdl)
      {
        i += 1;
        break;
        localbcdl.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdk
 * JD-Core Version:    0.7.0.1
 */
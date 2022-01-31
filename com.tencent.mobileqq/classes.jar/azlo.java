import java.util.ArrayList;
import java.util.List;

public class azlo
{
  int jdField_a_of_type_Int = 0;
  azlp jdField_a_of_type_Azlp = new azlp(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public azlo()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Azlp;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      azlp localazlp = ((azlp)localObject).a(c);
      if (localazlp == null)
      {
        localazlp = new azlp(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((azlp)localObject).a(localazlp);
      }
      for (localObject = localazlp;; localObject = localazlp)
      {
        i += 1;
        break;
        localazlp.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlo
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.List;

public class azpx
{
  int jdField_a_of_type_Int = 0;
  azpy jdField_a_of_type_Azpy = new azpy(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public azpx()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Azpy;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      azpy localazpy = ((azpy)localObject).a(c);
      if (localazpy == null)
      {
        localazpy = new azpy(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((azpy)localObject).a(localazpy);
      }
      for (localObject = localazpy;; localObject = localazpy)
      {
        i += 1;
        break;
        localazpy.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpx
 * JD-Core Version:    0.7.0.1
 */
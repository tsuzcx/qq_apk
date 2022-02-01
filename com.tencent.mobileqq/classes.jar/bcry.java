import java.util.ArrayList;
import java.util.List;

public class bcry
{
  int jdField_a_of_type_Int = 0;
  bcrz jdField_a_of_type_Bcrz = new bcrz(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bcry()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Bcrz;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      bcrz localbcrz = ((bcrz)localObject).a(c);
      if (localbcrz == null)
      {
        localbcrz = new bcrz(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((bcrz)localObject).a(localbcrz);
      }
      for (localObject = localbcrz;; localObject = localbcrz)
      {
        i += 1;
        break;
        localbcrz.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcry
 * JD-Core Version:    0.7.0.1
 */
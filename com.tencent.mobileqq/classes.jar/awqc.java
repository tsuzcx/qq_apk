import java.util.ArrayList;
import java.util.List;

public class awqc
{
  int jdField_a_of_type_Int = 0;
  awqd jdField_a_of_type_Awqd = new awqd(this.jdField_a_of_type_Int, '&');
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public awqc()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Awqd;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      awqd localawqd = ((awqd)localObject).a(c);
      if (localawqd == null)
      {
        localawqd = new awqd(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((awqd)localObject).a(localawqd);
      }
      for (localObject = localawqd;; localObject = localawqd)
      {
        i += 1;
        break;
        localawqd.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awqc
 * JD-Core Version:    0.7.0.1
 */
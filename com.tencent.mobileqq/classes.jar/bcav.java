import java.util.ArrayList;
import java.util.List;

public class bcav
{
  protected static volatile bcav a;
  protected List<bcaw> a;
  protected boolean a;
  
  public bcav()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bcav a()
  {
    if (jdField_a_of_type_Bcav == null) {
      jdField_a_of_type_Bcav = new bcav();
    }
    return jdField_a_of_type_Bcav;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      b(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bcaw[] arrayOfbcaw = new bcaw[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbcaw);
      if (arrayOfbcaw != null)
      {
        int j = arrayOfbcaw.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbcaw[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcav
 * JD-Core Version:    0.7.0.1
 */
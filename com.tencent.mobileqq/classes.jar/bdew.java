import java.util.ArrayList;
import java.util.List;

public class bdew
{
  protected static volatile bdew a;
  protected List<bdex> a;
  protected boolean a;
  
  public bdew()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bdew a()
  {
    if (jdField_a_of_type_Bdew == null) {
      jdField_a_of_type_Bdew = new bdew();
    }
    return jdField_a_of_type_Bdew;
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
      bdex[] arrayOfbdex = new bdex[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbdex);
      if (arrayOfbdex != null)
      {
        int j = arrayOfbdex.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbdex[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdew
 * JD-Core Version:    0.7.0.1
 */
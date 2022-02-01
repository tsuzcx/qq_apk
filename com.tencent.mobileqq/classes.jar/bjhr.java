import java.util.ArrayList;
import java.util.List;

public class bjhr
{
  protected static volatile bjhr a;
  protected List<bjhs> a;
  protected boolean a;
  
  public bjhr()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bjhr a()
  {
    if (jdField_a_of_type_Bjhr == null) {
      jdField_a_of_type_Bjhr = new bjhr();
    }
    return jdField_a_of_type_Bjhr;
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
      bjhs[] arrayOfbjhs = new bjhs[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbjhs);
      if (arrayOfbjhs != null)
      {
        int j = arrayOfbjhs.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbjhs[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhr
 * JD-Core Version:    0.7.0.1
 */
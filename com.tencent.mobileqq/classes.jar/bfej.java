import java.util.ArrayList;
import java.util.List;

public class bfej
{
  protected static volatile bfej a;
  protected List<bfek> a;
  protected boolean a;
  
  public bfej()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bfej a()
  {
    if (jdField_a_of_type_Bfej == null) {
      jdField_a_of_type_Bfej = new bfej();
    }
    return jdField_a_of_type_Bfej;
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
      bfek[] arrayOfbfek = new bfek[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbfek);
      if (arrayOfbfek != null)
      {
        int j = arrayOfbfek.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbfek[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfej
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.List;

public class bhwp
{
  protected static volatile bhwp a;
  protected List<bhwq> a;
  protected boolean a;
  
  public bhwp()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bhwp a()
  {
    if (jdField_a_of_type_Bhwp == null) {
      jdField_a_of_type_Bhwp = new bhwp();
    }
    return jdField_a_of_type_Bhwp;
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
      bhwq[] arrayOfbhwq = new bhwq[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbhwq);
      if (arrayOfbhwq != null)
      {
        int j = arrayOfbhwq.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbhwq[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwp
 * JD-Core Version:    0.7.0.1
 */
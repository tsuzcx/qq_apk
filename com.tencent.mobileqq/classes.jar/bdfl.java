import java.util.ArrayList;
import java.util.List;

public class bdfl
{
  protected static volatile bdfl a;
  protected List<bdfm> a;
  protected boolean a;
  
  public bdfl()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bdfl a()
  {
    if (jdField_a_of_type_Bdfl == null) {
      jdField_a_of_type_Bdfl = new bdfl();
    }
    return jdField_a_of_type_Bdfl;
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
      bdfm[] arrayOfbdfm = new bdfm[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbdfm);
      if (arrayOfbdfm != null)
      {
        int j = arrayOfbdfm.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbdfm[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdfl
 * JD-Core Version:    0.7.0.1
 */
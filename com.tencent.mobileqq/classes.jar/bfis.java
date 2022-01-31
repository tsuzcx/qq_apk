import java.util.ArrayList;
import java.util.List;

public class bfis
{
  protected static volatile bfis a;
  protected List<bfit> a;
  protected boolean a;
  
  public bfis()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bfis a()
  {
    if (jdField_a_of_type_Bfis == null) {
      jdField_a_of_type_Bfis = new bfis();
    }
    return jdField_a_of_type_Bfis;
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
      bfit[] arrayOfbfit = new bfit[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbfit);
      if (arrayOfbfit != null)
      {
        int j = arrayOfbfit.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbfit[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfis
 * JD-Core Version:    0.7.0.1
 */
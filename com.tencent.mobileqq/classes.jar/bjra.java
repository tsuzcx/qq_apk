import java.util.ArrayList;
import java.util.List;

public class bjra
{
  protected static volatile bjra a;
  protected List<bjrb> a;
  protected boolean a;
  
  public bjra()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bjra a()
  {
    if (jdField_a_of_type_Bjra == null) {
      jdField_a_of_type_Bjra = new bjra();
    }
    return jdField_a_of_type_Bjra;
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
      bjrb[] arrayOfbjrb = new bjrb[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbjrb);
      if (arrayOfbjrb != null)
      {
        int j = arrayOfbjrb.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbjrb[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjra
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.List;

public class biqb
{
  protected static volatile biqb a;
  protected List<biqc> a;
  protected boolean a;
  
  public biqb()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static biqb a()
  {
    if (jdField_a_of_type_Biqb == null) {
      jdField_a_of_type_Biqb = new biqb();
    }
    return jdField_a_of_type_Biqb;
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
      biqc[] arrayOfbiqc = new biqc[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbiqc);
      if (arrayOfbiqc != null)
      {
        int j = arrayOfbiqc.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbiqc[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqb
 * JD-Core Version:    0.7.0.1
 */
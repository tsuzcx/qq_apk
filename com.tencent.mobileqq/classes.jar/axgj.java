import java.util.ArrayList;
import java.util.Iterator;

public class axgj
{
  private axgk<Integer, axgl> a;
  protected String a;
  
  public axgj()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Axgk = new axgk(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_Axgk.a(Integer.valueOf(paramInt));
      if (localArrayList != null) {
        localArrayList.clear();
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_Axgk.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          axgl localaxgl = (axgl)((Iterator)localObject).next();
          if (localaxgl != null) {
            localaxgl.a(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(axgl paramaxgl)
  {
    try
    {
      this.jdField_a_of_type_Axgk.a(paramaxgl);
      return;
    }
    finally
    {
      paramaxgl = finally;
      throw paramaxgl;
    }
  }
  
  public void a(axgl paramaxgl, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_Axgk.a(Integer.valueOf(k), paramaxgl);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgj
 * JD-Core Version:    0.7.0.1
 */
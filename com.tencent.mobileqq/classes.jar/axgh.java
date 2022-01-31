import java.util.ArrayList;
import java.util.Iterator;

public class axgh
{
  private axgi<Integer, axgj> a;
  protected String a;
  
  public axgh()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Axgi = new axgi(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_Axgi.a(Integer.valueOf(paramInt));
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
      Object localObject = this.jdField_a_of_type_Axgi.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          axgj localaxgj = (axgj)((Iterator)localObject).next();
          if (localaxgj != null) {
            localaxgj.a(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(axgj paramaxgj)
  {
    try
    {
      this.jdField_a_of_type_Axgi.a(paramaxgj);
      return;
    }
    finally
    {
      paramaxgj = finally;
      throw paramaxgj;
    }
  }
  
  public void a(axgj paramaxgj, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_Axgi.a(Integer.valueOf(k), paramaxgj);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgh
 * JD-Core Version:    0.7.0.1
 */
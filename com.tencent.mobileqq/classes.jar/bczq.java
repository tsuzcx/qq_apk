import java.util.ArrayList;
import java.util.Iterator;

public class bczq
{
  private bczr<Integer, bczs> a;
  protected String a;
  
  public bczq()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Bczr = new bczr(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_Bczr.a(Integer.valueOf(paramInt));
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
      Object localObject = this.jdField_a_of_type_Bczr.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bczs localbczs = (bczs)((Iterator)localObject).next();
          if (localbczs != null) {
            localbczs.a(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(bczs parambczs)
  {
    try
    {
      this.jdField_a_of_type_Bczr.a(parambczs);
      return;
    }
    finally
    {
      parambczs = finally;
      throw parambczs;
    }
  }
  
  public void a(bczs parambczs, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_Bczr.a(Integer.valueOf(k), parambczs);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczq
 * JD-Core Version:    0.7.0.1
 */
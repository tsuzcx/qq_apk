import java.util.ArrayList;
import java.util.Iterator;

public class bcgy
{
  private bcgz<Integer, bcha> a;
  protected String a;
  
  public bcgy()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Bcgz = new bcgz(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_Bcgz.a(Integer.valueOf(paramInt));
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
      Object localObject = this.jdField_a_of_type_Bcgz.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bcha localbcha = (bcha)((Iterator)localObject).next();
          if (localbcha != null) {
            localbcha.a(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(bcha parambcha)
  {
    try
    {
      this.jdField_a_of_type_Bcgz.a(parambcha);
      return;
    }
    finally
    {
      parambcha = finally;
      throw parambcha;
    }
  }
  
  public void a(bcha parambcha, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_Bcgz.a(Integer.valueOf(k), parambcha);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgy
 * JD-Core Version:    0.7.0.1
 */
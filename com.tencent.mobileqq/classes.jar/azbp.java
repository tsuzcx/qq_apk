import java.util.ArrayList;
import java.util.Iterator;

public class azbp
{
  private azbq<Integer, azbr> a;
  protected String a;
  
  public azbp()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Azbq = new azbq(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_Azbq.a(Integer.valueOf(paramInt));
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
      Object localObject = this.jdField_a_of_type_Azbq.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          azbr localazbr = (azbr)((Iterator)localObject).next();
          if (localazbr != null) {
            localazbr.a(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(azbr paramazbr)
  {
    try
    {
      this.jdField_a_of_type_Azbq.a(paramazbr);
      return;
    }
    finally
    {
      paramazbr = finally;
      throw paramazbr;
    }
  }
  
  public void a(azbr paramazbr, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_Azbq.a(Integer.valueOf(k), paramazbr);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbp
 * JD-Core Version:    0.7.0.1
 */
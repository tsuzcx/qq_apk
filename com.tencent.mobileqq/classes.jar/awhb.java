import java.util.ArrayList;
import java.util.Iterator;

public class awhb
{
  private awhc<Integer, awhd> a;
  protected String a;
  
  public awhb()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Awhc = new awhc(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_Awhc.a(Integer.valueOf(paramInt));
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
      Object localObject = this.jdField_a_of_type_Awhc.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          awhd localawhd = (awhd)((Iterator)localObject).next();
          if (localawhd != null) {
            localawhd.a(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(awhd paramawhd)
  {
    try
    {
      this.jdField_a_of_type_Awhc.a(paramawhd);
      return;
    }
    finally
    {
      paramawhd = finally;
      throw paramawhd;
    }
  }
  
  public void a(awhd paramawhd, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_Awhc.a(Integer.valueOf(k), paramawhd);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awhb
 * JD-Core Version:    0.7.0.1
 */
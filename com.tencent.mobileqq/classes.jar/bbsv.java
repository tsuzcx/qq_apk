import java.util.ArrayList;
import java.util.Iterator;

public class bbsv
{
  private bbsw<Integer, bbsx> a;
  protected String a;
  
  public bbsv()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Bbsw = new bbsw(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_Bbsw.a(Integer.valueOf(paramInt));
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
      Object localObject = this.jdField_a_of_type_Bbsw.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bbsx localbbsx = (bbsx)((Iterator)localObject).next();
          if (localbbsx != null) {
            localbbsx.notify(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(bbsx parambbsx)
  {
    try
    {
      this.jdField_a_of_type_Bbsw.a(parambbsx);
      return;
    }
    finally
    {
      parambbsx = finally;
      throw parambbsx;
    }
  }
  
  public void a(bbsx parambbsx, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_Bbsw.a(Integer.valueOf(k), parambbsx);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsv
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.Iterator;

public class azfy
{
  private azfz<Integer, azga> a;
  protected String a;
  
  public azfy()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Azfz = new azfz(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_Azfz.a(Integer.valueOf(paramInt));
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
      Object localObject = this.jdField_a_of_type_Azfz.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          azga localazga = (azga)((Iterator)localObject).next();
          if (localazga != null) {
            localazga.a(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(azga paramazga)
  {
    try
    {
      this.jdField_a_of_type_Azfz.a(paramazga);
      return;
    }
    finally
    {
      paramazga = finally;
      throw paramazga;
    }
  }
  
  public void a(azga paramazga, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_Azfz.a(Integer.valueOf(k), paramazga);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfy
 * JD-Core Version:    0.7.0.1
 */
import android.util.AndroidRuntimeException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdma
{
  private final List<bdmb> a = new ArrayList();
  
  bdma(bdli parambdli)
  {
    parambdli = (bdcv)parambdli.getClass().getAnnotation(bdcv.class);
    if (parambdli == null) {}
    do
    {
      return;
      parambdli = parambdli.a();
    } while (parambdli == null);
    int j = parambdli.length;
    int i = 0;
    label49:
    bdmb localbdmb;
    Object localObject;
    if (i < j)
    {
      String str = parambdli[i];
      try
      {
        localbdmb = new bdmb();
        localObject = Class.forName(str);
        if (!bdlq.class.isAssignableFrom((Class)localObject)) {
          throw new AndroidRuntimeException("RuntimeLoaderConfig requires child class of BaseAppRuntimeLoader, current class is " + str);
        }
      }
      catch (Throwable localThrowable)
      {
        bdnw.d("RuntimeLoaderConfiguration", "", localThrowable);
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      localbdmb.jdField_a_of_type_JavaLangClass = ((Class)localObject);
      localObject = localbdmb.jdField_a_of_type_JavaLangClass.getField("CREATOR");
      if ((((Field)localObject).getModifiers() & 0x8) == 0) {
        throw new AndroidRuntimeException("RuntimeLoader protocol requires the CREATOR object to be static on class " + localThrowable);
      }
      if (!bdlr.class.isAssignableFrom(((Field)localObject).getType())) {
        throw new AndroidRuntimeException("RuntimeLoader requires a BaseAppRuntimeLoader.Creator object called CREATOR on class " + localThrowable);
      }
      localbdmb.jdField_a_of_type_Bdlr = ((bdlr)((Field)localObject).get(null));
      this.a.add(localbdmb);
    }
  }
  
  public List<bdmb> a()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bdmb localbdmb = (bdmb)localIterator.next();
      if (localbdmb != null) {
        localStringBuilder.append("***Loader:").append(localbdmb.jdField_a_of_type_JavaLangClass.getName()).append(", Creator:").append(localbdmb.jdField_a_of_type_Bdlr.getClass().getName()).append("***");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdma
 * JD-Core Version:    0.7.0.1
 */
import android.util.AndroidRuntimeException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class berb
{
  private final List<berc> a = new ArrayList();
  
  berb(beqf parambeqf)
  {
    parambeqf = (behl)parambeqf.getClass().getAnnotation(behl.class);
    if (parambeqf == null) {}
    do
    {
      return;
      parambeqf = parambeqf.a();
    } while (parambeqf == null);
    int j = parambeqf.length;
    int i = 0;
    label49:
    berc localberc;
    Object localObject;
    if (i < j)
    {
      String str = parambeqf[i];
      try
      {
        localberc = new berc();
        localObject = Class.forName(str);
        if (!beqm.class.isAssignableFrom((Class)localObject)) {
          throw new AndroidRuntimeException("RuntimeLoaderConfig requires child class of BaseAppRuntimeLoader, current class is " + str);
        }
      }
      catch (Throwable localThrowable)
      {
        betc.c("RuntimeLoaderConfiguration", "", localThrowable);
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      localberc.jdField_a_of_type_JavaLangClass = ((Class)localObject);
      localObject = localberc.jdField_a_of_type_JavaLangClass.getField("CREATOR");
      if ((((Field)localObject).getModifiers() & 0x8) == 0) {
        throw new AndroidRuntimeException("RuntimeLoader protocol requires the CREATOR object to be static on class " + localThrowable);
      }
      if (!beqn.class.isAssignableFrom(((Field)localObject).getType())) {
        throw new AndroidRuntimeException("RuntimeLoader requires a BaseAppRuntimeLoader.Creator object called CREATOR on class " + localThrowable);
      }
      localberc.jdField_a_of_type_Beqn = ((beqn)((Field)localObject).get(null));
      this.a.add(localberc);
    }
  }
  
  public List<berc> a()
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
      berc localberc = (berc)localIterator.next();
      if (localberc != null) {
        localStringBuilder.append("***Loader:").append(localberc.jdField_a_of_type_JavaLangClass.getName()).append(", Creator:").append(localberc.jdField_a_of_type_Beqn.getClass().getName()).append("***");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berb
 * JD-Core Version:    0.7.0.1
 */
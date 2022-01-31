import android.util.AndroidRuntimeException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class beqk
{
  private final List<beql> a = new ArrayList();
  
  beqk(bepo parambepo)
  {
    parambepo = (begu)parambepo.getClass().getAnnotation(begu.class);
    if (parambepo == null) {}
    do
    {
      return;
      parambepo = parambepo.a();
    } while (parambepo == null);
    int j = parambepo.length;
    int i = 0;
    label49:
    beql localbeql;
    Object localObject;
    if (i < j)
    {
      String str = parambepo[i];
      try
      {
        localbeql = new beql();
        localObject = Class.forName(str);
        if (!bepv.class.isAssignableFrom((Class)localObject)) {
          throw new AndroidRuntimeException("RuntimeLoaderConfig requires child class of BaseAppRuntimeLoader, current class is " + str);
        }
      }
      catch (Throwable localThrowable)
      {
        besl.c("RuntimeLoaderConfiguration", "", localThrowable);
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      localbeql.jdField_a_of_type_JavaLangClass = ((Class)localObject);
      localObject = localbeql.jdField_a_of_type_JavaLangClass.getField("CREATOR");
      if ((((Field)localObject).getModifiers() & 0x8) == 0) {
        throw new AndroidRuntimeException("RuntimeLoader protocol requires the CREATOR object to be static on class " + localThrowable);
      }
      if (!bepw.class.isAssignableFrom(((Field)localObject).getType())) {
        throw new AndroidRuntimeException("RuntimeLoader requires a BaseAppRuntimeLoader.Creator object called CREATOR on class " + localThrowable);
      }
      localbeql.jdField_a_of_type_Bepw = ((bepw)((Field)localObject).get(null));
      this.a.add(localbeql);
    }
  }
  
  public List<beql> a()
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
      beql localbeql = (beql)localIterator.next();
      if (localbeql != null) {
        localStringBuilder.append("***Loader:").append(localbeql.jdField_a_of_type_JavaLangClass.getName()).append(", Creator:").append(localbeql.jdField_a_of_type_Bepw.getClass().getName()).append("***");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqk
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import java.util.HashMap;

public class bdkq
{
  protected static bdkq a;
  protected Context a;
  protected bdkp a;
  protected final HashMap<String, bdkn> a;
  
  protected bdkq(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bdkp = new bdkr(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bdkq a(Context paramContext)
  {
    if (jdField_a_of_type_Bdkq != null) {
      return jdField_a_of_type_Bdkq;
    }
    try
    {
      if (jdField_a_of_type_Bdkq == null) {
        jdField_a_of_type_Bdkq = new bdkq(paramContext);
      }
      paramContext = jdField_a_of_type_Bdkq;
      return paramContext;
    }
    finally {}
  }
  
  public bdkn a(Class<? extends bdkj> paramClass, long paramLong, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        throw new RuntimeException("call initiate(Context context) before this");
      }
    }
    if (paramString == null) {
      throw new RuntimeException("invalid table name");
    }
    Object localObject = bdkn.a(paramLong, paramString);
    localObject = (bdkn)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bdkn(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bdkp);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends bdkj>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdkq
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import java.util.HashMap;

public class bdkb
{
  protected static bdkb a;
  protected Context a;
  protected bdka a;
  protected final HashMap<String, bdjy> a;
  
  protected bdkb(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bdka = new bdkc(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bdkb a(Context paramContext)
  {
    if (jdField_a_of_type_Bdkb != null) {
      return jdField_a_of_type_Bdkb;
    }
    try
    {
      if (jdField_a_of_type_Bdkb == null) {
        jdField_a_of_type_Bdkb = new bdkb(paramContext);
      }
      paramContext = jdField_a_of_type_Bdkb;
      return paramContext;
    }
    finally {}
  }
  
  public bdjy a(Class<? extends bdju> paramClass, long paramLong, String paramString)
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
    Object localObject = bdjy.a(paramLong, paramString);
    localObject = (bdjy)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bdjy(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bdka);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends bdju>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdkb
 * JD-Core Version:    0.7.0.1
 */
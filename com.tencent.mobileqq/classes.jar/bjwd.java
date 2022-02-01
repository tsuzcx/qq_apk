import android.content.Context;
import java.util.HashMap;

public class bjwd
{
  protected static bjwd a;
  protected Context a;
  protected bjwc a;
  protected final HashMap<String, bjwa> a;
  
  protected bjwd(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bjwc = new bjwe(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bjwd a(Context paramContext)
  {
    if (jdField_a_of_type_Bjwd != null) {
      return jdField_a_of_type_Bjwd;
    }
    try
    {
      if (jdField_a_of_type_Bjwd == null) {
        jdField_a_of_type_Bjwd = new bjwd(paramContext);
      }
      paramContext = jdField_a_of_type_Bjwd;
      return paramContext;
    }
    finally {}
  }
  
  public bjwa a(Class<? extends bjvw> paramClass, long paramLong, String paramString)
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
    Object localObject = bjwa.a(paramLong, paramString);
    localObject = (bjwa)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bjwa(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bjwc);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends bjvw>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwd
 * JD-Core Version:    0.7.0.1
 */
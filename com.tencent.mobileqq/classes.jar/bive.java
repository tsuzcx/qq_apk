import android.content.Context;
import java.util.HashMap;

public class bive
{
  protected static bive a;
  protected Context a;
  protected bivd a;
  protected final HashMap<String, bivb> a;
  
  protected bive(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bivd = new bivf(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bive a(Context paramContext)
  {
    if (jdField_a_of_type_Bive != null) {
      return jdField_a_of_type_Bive;
    }
    try
    {
      if (jdField_a_of_type_Bive == null) {
        jdField_a_of_type_Bive = new bive(paramContext);
      }
      paramContext = jdField_a_of_type_Bive;
      return paramContext;
    }
    finally {}
  }
  
  public bivb a(Class<? extends biux> paramClass, long paramLong, String paramString)
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
    Object localObject = bivb.a(paramLong, paramString);
    localObject = (bivb)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bivb(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bivd);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends biux>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bive
 * JD-Core Version:    0.7.0.1
 */
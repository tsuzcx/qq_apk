import android.content.Context;
import java.util.HashMap;

public class bfjn
{
  protected static bfjn a;
  protected Context a;
  protected bfjm a;
  protected final HashMap<String, bfjk> a;
  
  protected bfjn(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bfjm = new bfjo(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bfjn a(Context paramContext)
  {
    if (jdField_a_of_type_Bfjn != null) {
      return jdField_a_of_type_Bfjn;
    }
    try
    {
      if (jdField_a_of_type_Bfjn == null) {
        jdField_a_of_type_Bfjn = new bfjn(paramContext);
      }
      paramContext = jdField_a_of_type_Bfjn;
      return paramContext;
    }
    finally {}
  }
  
  public bfjk a(Class<? extends bfjg> paramClass, long paramLong, String paramString)
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
    Object localObject = bfjk.a(paramLong, paramString);
    localObject = (bfjk)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bfjk(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bfjm);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends bfjg>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfjn
 * JD-Core Version:    0.7.0.1
 */
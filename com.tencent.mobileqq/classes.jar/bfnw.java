import android.content.Context;
import java.util.HashMap;

public class bfnw
{
  protected static bfnw a;
  protected Context a;
  protected bfnv a;
  protected final HashMap<String, bfnt> a;
  
  protected bfnw(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bfnv = new bfnx(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bfnw a(Context paramContext)
  {
    if (jdField_a_of_type_Bfnw != null) {
      return jdField_a_of_type_Bfnw;
    }
    try
    {
      if (jdField_a_of_type_Bfnw == null) {
        jdField_a_of_type_Bfnw = new bfnw(paramContext);
      }
      paramContext = jdField_a_of_type_Bfnw;
      return paramContext;
    }
    finally {}
  }
  
  public bfnt a(Class<? extends bfnp> paramClass, long paramLong, String paramString)
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
    Object localObject = bfnt.a(paramLong, paramString);
    localObject = (bfnt)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bfnt(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bfnv);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends bfnp>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfnw
 * JD-Core Version:    0.7.0.1
 */
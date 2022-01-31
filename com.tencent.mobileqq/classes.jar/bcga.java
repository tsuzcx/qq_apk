import android.content.Context;
import java.util.HashMap;

public class bcga
{
  protected static bcga a;
  protected Context a;
  protected bcfz a;
  protected final HashMap<String, bcfx> a;
  
  protected bcga(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bcfz = new bcgb(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bcga a(Context paramContext)
  {
    if (jdField_a_of_type_Bcga != null) {
      return jdField_a_of_type_Bcga;
    }
    try
    {
      if (jdField_a_of_type_Bcga == null) {
        jdField_a_of_type_Bcga = new bcga(paramContext);
      }
      paramContext = jdField_a_of_type_Bcga;
      return paramContext;
    }
    finally {}
  }
  
  public bcfx a(Class<? extends bcft> paramClass, long paramLong, String paramString)
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
    Object localObject = bcfx.a(paramLong, paramString);
    localObject = (bcfx)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bcfx(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bcfz);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends bcft>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcga
 * JD-Core Version:    0.7.0.1
 */
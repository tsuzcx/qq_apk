import android.content.Context;
import com.tencent.open.component.cache.database.DbCacheData;
import java.lang.Class<+Lcom.tencent.open.component.cache.database.DbCacheData;>;
import java.util.HashMap;

public class bjmn
{
  protected static bjmn a;
  protected Context a;
  protected bjmm a;
  protected final HashMap<String, bjmk> a;
  
  protected bjmn(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bjmm = new bjmo(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bjmn a(Context paramContext)
  {
    if (jdField_a_of_type_Bjmn != null) {
      return jdField_a_of_type_Bjmn;
    }
    try
    {
      if (jdField_a_of_type_Bjmn == null) {
        jdField_a_of_type_Bjmn = new bjmn(paramContext);
      }
      paramContext = jdField_a_of_type_Bjmn;
      return paramContext;
    }
    finally {}
  }
  
  public bjmk a(Class<? extends DbCacheData> paramClass, long paramLong, String paramString)
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
    Object localObject = bjmk.a(paramLong, paramString);
    localObject = (bjmk)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bjmk(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bjmm);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends DbCacheData>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmn
 * JD-Core Version:    0.7.0.1
 */
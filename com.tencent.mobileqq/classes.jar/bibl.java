import android.content.Context;
import com.tencent.open.component.cache.database.DbCacheData;
import java.lang.Class<+Lcom.tencent.open.component.cache.database.DbCacheData;>;
import java.util.HashMap;

public class bibl
{
  protected static bibl a;
  protected Context a;
  protected bibk a;
  protected final HashMap<String, bibi> a;
  
  protected bibl(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bibk = new bibm(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static bibl a(Context paramContext)
  {
    if (jdField_a_of_type_Bibl != null) {
      return jdField_a_of_type_Bibl;
    }
    try
    {
      if (jdField_a_of_type_Bibl == null) {
        jdField_a_of_type_Bibl = new bibl(paramContext);
      }
      paramContext = jdField_a_of_type_Bibl;
      return paramContext;
    }
    finally {}
  }
  
  public bibi a(Class<? extends DbCacheData> paramClass, long paramLong, String paramString)
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
    Object localObject = bibi.a(paramLong, paramString);
    localObject = (bibi)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new bibi(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_Bibk);
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
 * Qualified Name:     bibl
 * JD-Core Version:    0.7.0.1
 */
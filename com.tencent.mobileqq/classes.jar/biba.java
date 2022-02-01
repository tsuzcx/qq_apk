import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class biba
{
  private static final biba jdField_a_of_type_Biba = new biba();
  private static final Map<String, bibe> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static biba a()
  {
    return jdField_a_of_type_Biba;
  }
  
  public bibe a(@NonNull String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    bibe localbibe;
    do
    {
      do
      {
        return localObject;
        localbibe = (bibe)jdField_a_of_type_JavaUtilMap.get(paramString);
        localObject = localbibe;
      } while (localbibe != null);
      localbibe = bibe.a(paramString);
      localObject = localbibe;
    } while (localbibe == null);
    jdField_a_of_type_JavaUtilMap.put(paramString, localbibe);
    return localbibe;
  }
  
  public void a(@NonNull String paramString, Object paramObject)
  {
    paramObject = bibe.a(paramObject);
    if (paramObject == null) {}
    while (paramObject.a(a(paramString))) {
      return;
    }
    jdField_a_of_type_JavaUtilMap.put(paramString, paramObject);
    paramObject.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biba
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

public class bizh
{
  public Context a;
  public bize a;
  private Map<String, Object> a;
  
  public bizh(Context paramContext, bize parambize)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bize = parambize;
  }
  
  public Object a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    if (TextUtils.equals(paramString, "intchk")) {
      localObject1 = new bizk(this);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject1);
      return localObject1;
      if (TextUtils.equals(paramString, "app_scan")) {
        localObject1 = new bizj(this);
      } else if (TextUtils.equals(paramString, "sig_check")) {
        localObject1 = new bizm(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizh
 * JD-Core Version:    0.7.0.1
 */
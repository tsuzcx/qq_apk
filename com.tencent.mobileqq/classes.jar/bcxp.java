import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

public class bcxp
{
  public Context a;
  public bcxm a;
  private Map<String, Object> a;
  
  public bcxp(Context paramContext, bcxm parambcxm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bcxm = parambcxm;
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
      localObject1 = new bcxs(this);
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
        localObject1 = new bcxr(this);
      } else if (TextUtils.equals(paramString, "sig_check")) {
        localObject1 = new bcxu(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcxp
 * JD-Core Version:    0.7.0.1
 */
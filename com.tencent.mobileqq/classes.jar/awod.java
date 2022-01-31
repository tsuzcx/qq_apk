import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class awod
{
  public static int a;
  public static SparseArray<String> a;
  public static String a;
  private static AtomicBoolean a;
  
  static
  {
    jdField_a_of_type_Int = 50;
    jdField_a_of_type_JavaLangString = alpo.a(2131717151);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        QLog.e("VipProfileDiyCardConfig", 1, "parseJson, app null");
        return;
      }
      finally {}
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        localJSONObject = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "card.diyFontConfig.json", true, null);
        if (localJSONObject == null) {
          break label217;
        }
        localJSONArray = localJSONObject.optJSONArray("fontList");
        if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
          if (jdField_a_of_type_AndroidUtilSparseArray == null)
          {
            jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
            break label227;
          }
        }
      }
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        paramAppRuntime = localJSONArray.optJSONObject(i);
        int j = paramAppRuntime.optInt("id");
        String str = paramAppRuntime.optString("imgUrl");
        if (TextUtils.isEmpty(str)) {
          break label232;
        }
        paramAppRuntime = str;
        if (!str.startsWith("http:"))
        {
          paramAppRuntime = str;
          if (!str.startsWith("https:")) {
            paramAppRuntime = "http:" + str;
          }
        }
        jdField_a_of_type_AndroidUtilSparseArray.put(j, paramAppRuntime);
        break label232;
        jdField_a_of_type_AndroidUtilSparseArray.clear();
      }
      else
      {
        jdField_a_of_type_Int = localJSONObject.optInt("maxTextLength", jdField_a_of_type_Int);
        jdField_a_of_type_JavaLangString = localJSONObject.optString("inputTip", jdField_a_of_type_JavaLangString);
        label217:
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        break;
      }
      label227:
      int i = 0;
      continue;
      label232:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awod
 * JD-Core Version:    0.7.0.1
 */
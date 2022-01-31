import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class ammv
{
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static ammv a(alzs[] paramArrayOfalzs)
  {
    Object localObject1;
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0))
    {
      QLog.e("TdsReaderView_TdsReaderConfigBean", 1, "parse error, confFiles is no-valid.");
      localObject1 = null;
      return localObject1;
    }
    ammv localammv = new ammv();
    int j = paramArrayOfalzs.length;
    int i = 0;
    for (;;)
    {
      localObject1 = localammv;
      if (i >= j) {
        break;
      }
      localObject1 = paramArrayOfalzs[i];
      try
      {
        localObject1 = new JSONObject(((alzs)localObject1).a);
        if (localObject1 != null)
        {
          if (((JSONObject)localObject1).has("has_gray")) {
            localammv.jdField_a_of_type_Boolean = ((JSONObject)localObject1).optBoolean("has_gray");
          }
          a((JSONObject)localObject1, localammv.jdField_a_of_type_JavaUtilMap);
        }
        i += 1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("TdsReaderView_TdsReaderConfigBean", 1, "parse error", localJSONException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if ((paramJSONObject == null) || (paramMap == null)) {}
    do
    {
      return;
      if (paramJSONObject.has("facade_plugin_name")) {
        paramMap.put("facade_plugin_name", paramJSONObject.optString("facade_plugin_name"));
      }
      if (paramJSONObject.has("facade_plugin_name_prefix")) {
        paramMap.put("facade_plugin_name_prefix", paramJSONObject.optString("facade_plugin_name_prefix"));
      }
      if (paramJSONObject.has("facade_plugin_url")) {
        paramMap.put("facade_plugin_url", paramJSONObject.optString("facade_plugin_url"));
      }
      if (paramJSONObject.has("facade_plugin_md5")) {
        paramMap.put("facade_plugin_md5", paramJSONObject.optString("facade_plugin_md5"));
      }
      if (paramJSONObject.has("facade_plugin_entry_class")) {
        paramMap.put("facade_plugin_entry_class", paramJSONObject.optString("facade_plugin_entry_class"));
      }
      if (paramJSONObject.has("pre_load_info")) {
        paramMap.put("pre_load_info", paramJSONObject.optString("pre_load_info"));
      }
      if (paramJSONObject.has("global_required_res_info")) {
        paramMap.put("global_required_res_info", paramJSONObject.optString("global_required_res_info"));
      }
      if (paramJSONObject.has("docs_plugin_info")) {
        paramMap.put("docs_plugin_info", paramJSONObject.optString("docs_plugin_info"));
      }
      if (paramJSONObject.has("docs_font_info")) {
        paramMap.put("docs_font_info", paramJSONObject.optString("docs_font_info"));
      }
      if (paramJSONObject.has("sheets_plugin_info")) {
        paramMap.put("sheets_plugin_info", paramJSONObject.optString("sheets_plugin_info"));
      }
      if (paramJSONObject.has("slides_plugin_info")) {
        paramMap.put("slides_plugin_info", paramJSONObject.optString("slides_plugin_info"));
      }
    } while (!paramJSONObject.has("slides_res_info"));
    paramMap.put("slides_res_info", paramJSONObject.optString("slides_res_info"));
  }
  
  public static void a(boolean paramBoolean, ammv paramammv)
  {
    if (paramammv == null) {
      QLog.w("TdsReaderView_TdsReaderConfigBean", 1, "source error, configBean is null.");
    }
    int i;
    do
    {
      return;
      if (!paramammv.jdField_a_of_type_JavaUtilMap.isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          TdsReaderGlobal.a(paramBoolean, paramammv.jdField_a_of_type_JavaUtilMap);
        }
        if (!paramammv.jdField_a_of_type_Boolean) {
          break;
        }
        ammy.b();
        return;
      }
    } while (i == 0);
    TdsReaderGlobal.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ammv
 * JD-Core Version:    0.7.0.1
 */
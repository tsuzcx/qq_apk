import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class andc
{
  private int jdField_a_of_type_Int = -1;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static andc a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0))
    {
      QLog.e("TencentDocUrl2DocConfigBean", 1, "parse error, confFiles is no-valid.");
      return null;
    }
    andc localandc = new andc();
    int k = paramArrayOfamph.length;
    int i = 0;
    while (i < k)
    {
      Object localObject1 = paramArrayOfamph[i];
      try
      {
        localObject1 = new JSONObject(((amph)localObject1).a);
        if ((localObject1 != null) && (((JSONObject)localObject1).has("url_2_doc_enable")))
        {
          if (((JSONObject)localObject1).optBoolean("url_2_doc_enable"))
          {
            j = 1;
            localandc.jdField_a_of_type_Int = j;
          }
        }
        else
        {
          if ((localObject1 == null) || (!((JSONObject)localObject1).has("support_host"))) {
            break label189;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("support_host");
          if (localObject1 == null) {
            break label189;
          }
          j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            String str = ((JSONArray)localObject1).optString(j);
            if (!TextUtils.isEmpty(str)) {
              localandc.jdField_a_of_type_JavaUtilList.add(str);
            }
            j += 1;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("TencentDocUrl2DocConfigBean", 1, "parse error", localJSONException);
          Object localObject2 = null;
          continue;
          int j = 0;
        }
        label189:
        i += 1;
      }
    }
    return localandc;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     andc
 * JD-Core Version:    0.7.0.1
 */
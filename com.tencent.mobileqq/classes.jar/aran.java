import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aran
{
  public List<String> a = new ArrayList();
  
  public static aran a(aqxa[] paramArrayOfaqxa)
  {
    aran localaran = new aran();
    int k;
    int i;
    try
    {
      k = paramArrayOfaqxa.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaqxa)
    {
      boolean bool;
      QLog.d("EmoticonSearchTagsConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaqxa);
    }
    Object localObject1 = ((aqxa)localObject1).a;
    bool = TextUtils.isEmpty((CharSequence)localObject1);
    if (!bool)
    {
      try
      {
        Object localObject2 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject2).has("keyWords"))
        {
          localObject2 = ((JSONObject)localObject2).optJSONArray("keyWords");
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            localaran.a.add(((JSONArray)localObject2).optString(j, ""));
            j += 1;
          }
        }
        if (!QLog.isColorLevel()) {
          break label173;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      QLog.i("EmoticonSearchTagsConfProcessor", 2, "parse S$EConfBean: " + (String)localObject1);
    }
    label173:
    label178:
    for (;;)
    {
      return localaran;
      for (;;)
      {
        if (i >= k) {
          break label178;
        }
        localObject1 = paramArrayOfaqxa[i];
        if (localObject1 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("mConfig:");
    if (this.a == null) {}
    for (String str = "null";; str = this.a.toString())
    {
      localStringBuilder.append(str);
      return super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aran
 * JD-Core Version:    0.7.0.1
 */
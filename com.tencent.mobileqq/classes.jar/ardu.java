import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ardu
{
  public List<String> a = new ArrayList();
  
  public static ardu a(araj[] paramArrayOfaraj)
  {
    ardu localardu = new ardu();
    int k;
    int i;
    try
    {
      k = paramArrayOfaraj.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaraj)
    {
      boolean bool;
      QLog.d("EmoticonSearchTagsConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaraj);
    }
    Object localObject1 = ((araj)localObject1).a;
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
            localardu.a.add(((JSONArray)localObject2).optString(j, ""));
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
      return localardu;
      for (;;)
      {
        if (i >= k) {
          break label178;
        }
        localObject1 = paramArrayOfaraj[i];
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
 * Qualified Name:     ardu
 * JD-Core Version:    0.7.0.1
 */
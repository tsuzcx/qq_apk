import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arjm
{
  @NonNull
  public final arjn a;
  @NonNull
  public final arjn b;
  @NonNull
  public final arjn c;
  
  private arjm()
  {
    this(a(null, ""), a(null, ""), a(null, ""));
  }
  
  private arjm(arjn paramarjn1, arjn paramarjn2, arjn paramarjn3)
  {
    this.a = paramarjn1;
    this.b = paramarjn2;
    this.c = paramarjn3;
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, toString());
    }
  }
  
  @NonNull
  public static arjm a()
  {
    return new arjm();
  }
  
  @NonNull
  public static arjm a(@Nullable String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        return new arjm(a(paramString, "AIO"), a(paramString, "group"), a(paramString, "download"));
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("KC.ConfigProcessor", 1, "json parse error:" + paramString);
        paramString = null;
      }
    }
  }
  
  @NonNull
  private static arjn a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = false;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        Object localObject = paramJSONObject.optJSONObject(paramString);
        paramJSONObject = ((JSONObject)localObject).optString("content", null);
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyWords");
        localObject = ((JSONObject)localObject).optJSONArray("actionUrls");
        String[] arrayOfString1 = new String[localJSONArray.length()];
        String[] arrayOfString2 = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString1[i] = localJSONArray.optString(i, null);
          arrayOfString2[i] = ((JSONArray)localObject).optString(i, null);
          i += 1;
        }
        if (paramJSONObject != null) {
          bool = true;
        }
        paramJSONObject = new arjn(paramString, bool, paramJSONObject, arrayOfString1, arrayOfString2);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("KC.ConfigProcessor", 1, "json parse error:" + paramJSONObject);
      }
    }
    return new arjn();
  }
  
  public String toString()
  {
    return "KingCardConfig{aio=" + this.a + ", group=" + this.b + ", download=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjm
 * JD-Core Version:    0.7.0.1
 */
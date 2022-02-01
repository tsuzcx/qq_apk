import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class armi
{
  @NonNull
  public final armj a;
  @NonNull
  public final armj b;
  @NonNull
  public final armj c;
  
  private armi()
  {
    this(a(null, ""), a(null, ""), a(null, ""));
  }
  
  private armi(armj paramarmj1, armj paramarmj2, armj paramarmj3)
  {
    this.a = paramarmj1;
    this.b = paramarmj2;
    this.c = paramarmj3;
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, toString());
    }
  }
  
  @NonNull
  public static armi a()
  {
    return new armi();
  }
  
  @NonNull
  public static armi a(@Nullable String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        return new armi(a(paramString, "AIO"), a(paramString, "group"), a(paramString, "download"));
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
  private static armj a(JSONObject paramJSONObject, String paramString)
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
        paramJSONObject = new armj(paramString, bool, paramJSONObject, arrayOfString1, arrayOfString2);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("KC.ConfigProcessor", 1, "json parse error:" + paramJSONObject);
      }
    }
    return new armj();
  }
  
  public String toString()
  {
    return "KingCardConfig{aio=" + this.a + ", group=" + this.b + ", download=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armi
 * JD-Core Version:    0.7.0.1
 */
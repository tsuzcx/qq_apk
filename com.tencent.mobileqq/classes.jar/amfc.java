import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amfc
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public static amfc a(alzs[] paramArrayOfalzs)
  {
    amfc localamfc = new amfc();
    int j;
    int i;
    try
    {
      j = paramArrayOfalzs.length;
      i = 0;
    }
    catch (Throwable paramArrayOfalzs)
    {
      boolean bool;
      QLog.d("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfalzs);
    }
    Object localObject = ((alzs)localObject).a;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("config_url")) {
          localamfc.a = localJSONObject.optString("config_url");
        }
        if (localJSONObject.has("config_md5")) {
          localamfc.b = localJSONObject.optString("config_md5");
        }
        if (localJSONObject.has("android_sysface_res_url")) {
          localamfc.c = localJSONObject.optString("android_sysface_res_url");
        }
        if (localJSONObject.has("android_sysface_res_md5")) {
          localamfc.d = localJSONObject.optString("android_sysface_res_md5");
        }
        if (localJSONObject.has("emoji_res_url")) {
          localamfc.e = localJSONObject.optString("emoji_res_url");
        }
        if (localJSONObject.has("emoji_res_md5")) {
          localamfc.f = localJSONObject.optString("emoji_res_md5");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean: " + (String)localObject);
      }
    }
    label255:
    for (;;)
    {
      return localamfc;
      for (;;)
      {
        if (i >= j) {
          break label255;
        }
        localObject = paramArrayOfalzs[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    new StringBuilder().append(", mConfigUrl:").append(this.a).append(", mConfigMD5:").append(this.b).append(", mSysFaceUrl").append(this.c).append(", mSysFaceMD5").append(this.d).append(", mEmojiUrl").append(this.e).append(", mEmojiMD5").append(this.f);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfc
 * JD-Core Version:    0.7.0.1
 */
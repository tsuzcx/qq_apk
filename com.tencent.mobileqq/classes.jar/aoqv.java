import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqv
{
  public aoqu a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public aoqv()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aoqu = new aoqu();
  }
  
  public static aoqv a(aoko[] paramArrayOfaoko)
  {
    aoqv localaoqv = new aoqv();
    int j;
    int i;
    try
    {
      j = paramArrayOfaoko.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaoko)
    {
      boolean bool;
      QLog.d("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaoko);
      return localaoqv;
    }
    Object localObject = ((aoko)localObject).jdField_a_of_type_JavaLangString;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("config_url")) {
          localaoqv.jdField_a_of_type_JavaLangString = localJSONObject.optString("config_url");
        }
        if (localJSONObject.has("config_md5")) {
          localaoqv.b = localJSONObject.optString("config_md5");
        }
        if (localJSONObject.has("sysface_res_url")) {
          localaoqv.c = localJSONObject.optString("sysface_res_url");
        }
        if (localJSONObject.has("sysface_res_md5")) {
          localaoqv.d = localJSONObject.optString("sysface_res_md5");
        }
        if (localJSONObject.has("emoji_res_url")) {
          localaoqv.e = localJSONObject.optString("emoji_res_url");
        }
        if (localJSONObject.has("emoji_res_md5")) {
          localaoqv.f = localJSONObject.optString("emoji_res_md5");
        }
        localaoqv.jdField_a_of_type_Aoqu = aoqu.a(localJSONObject);
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
    label277:
    for (;;)
    {
      localaoqv.jdField_a_of_type_Aoqu.a();
      return localaoqv;
      for (;;)
      {
        if (i >= j) {
          break label277;
        }
        localObject = paramArrayOfaoko[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    new StringBuilder().append(", mConfigUrl:").append(this.jdField_a_of_type_JavaLangString).append(", mConfigMD5:").append(this.b).append(", mSysFaceUrl").append(this.c).append(", mSysFaceMD5").append(this.d).append(", mEmojiUrl").append(this.e).append(", mEmojiMD5").append(this.f).append(", mEmoticonGuideConfBean").append(this.jdField_a_of_type_Aoqu.toString());
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqv
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aomm
{
  public aoml a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public aomm()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aoml = new aoml();
  }
  
  public static aomm a(aogf[] paramArrayOfaogf)
  {
    aomm localaomm = new aomm();
    int j;
    int i;
    try
    {
      j = paramArrayOfaogf.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaogf)
    {
      boolean bool;
      QLog.d("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaogf);
      return localaomm;
    }
    Object localObject = ((aogf)localObject).jdField_a_of_type_JavaLangString;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("config_url")) {
          localaomm.jdField_a_of_type_JavaLangString = localJSONObject.optString("config_url");
        }
        if (localJSONObject.has("config_md5")) {
          localaomm.b = localJSONObject.optString("config_md5");
        }
        if (localJSONObject.has("sysface_res_url")) {
          localaomm.c = localJSONObject.optString("sysface_res_url");
        }
        if (localJSONObject.has("sysface_res_md5")) {
          localaomm.d = localJSONObject.optString("sysface_res_md5");
        }
        if (localJSONObject.has("emoji_res_url")) {
          localaomm.e = localJSONObject.optString("emoji_res_url");
        }
        if (localJSONObject.has("emoji_res_md5")) {
          localaomm.f = localJSONObject.optString("emoji_res_md5");
        }
        localaomm.jdField_a_of_type_Aoml = aoml.a(localJSONObject);
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
      localaomm.jdField_a_of_type_Aoml.a();
      return localaomm;
      for (;;)
      {
        if (i >= j) {
          break label277;
        }
        localObject = paramArrayOfaogf[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    new StringBuilder().append(", mConfigUrl:").append(this.jdField_a_of_type_JavaLangString).append(", mConfigMD5:").append(this.b).append(", mSysFaceUrl").append(this.c).append(", mSysFaceMD5").append(this.d).append(", mEmojiUrl").append(this.e).append(", mEmojiMD5").append(this.f).append(", mEmoticonGuideConfBean").append(this.jdField_a_of_type_Aoml.toString());
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomm
 * JD-Core Version:    0.7.0.1
 */
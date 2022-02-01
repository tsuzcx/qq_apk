import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqsp
{
  public aqsn a;
  public aqso a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public aqsp()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aqso = new aqso();
    this.jdField_a_of_type_Aqsn = new aqsn();
  }
  
  public static aqsp a(aqlg[] paramArrayOfaqlg)
  {
    aqsp localaqsp = new aqsp();
    int j;
    int i;
    try
    {
      j = paramArrayOfaqlg.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaqlg)
    {
      boolean bool;
      QLog.d("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaqlg);
      return localaqsp;
    }
    Object localObject = ((aqlg)localObject).jdField_a_of_type_JavaLangString;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("config_url")) {
          localaqsp.jdField_a_of_type_JavaLangString = localJSONObject.optString("config_url");
        }
        if (localJSONObject.has("config_md5")) {
          localaqsp.b = localJSONObject.optString("config_md5");
        }
        if (localJSONObject.has("sysface_res_url")) {
          localaqsp.c = localJSONObject.optString("sysface_res_url");
        }
        if (localJSONObject.has("sysface_res_md5")) {
          localaqsp.d = localJSONObject.optString("sysface_res_md5");
        }
        if (localJSONObject.has("emoji_res_url")) {
          localaqsp.e = localJSONObject.optString("emoji_res_url");
        }
        if (localJSONObject.has("emoji_res_md5")) {
          localaqsp.f = localJSONObject.optString("emoji_res_md5");
        }
        localaqsp.jdField_a_of_type_Aqso = aqso.a(localJSONObject);
        localaqsp.jdField_a_of_type_Aqsn = aqsn.a(localJSONObject);
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
    label283:
    for (;;)
    {
      localaqsp.a();
      return localaqsp;
      for (;;)
      {
        if (i >= j) {
          break label283;
        }
        localObject = paramArrayOfaqlg[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Aqso.a())
    {
      String str = this.jdField_a_of_type_Aqso.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
      str = this.jdField_a_of_type_Aqso.b;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
    }
  }
  
  public String toString()
  {
    new StringBuilder().append(", mConfigUrl:").append(this.jdField_a_of_type_JavaLangString).append(", mConfigMD5:").append(this.b).append(", mSysFaceUrl").append(this.c).append(", mSysFaceMD5").append(this.d).append(", mEmojiUrl").append(this.e).append(", mEmojiMD5").append(this.f).append(", mEmoticonGuideConfBean").append(this.jdField_a_of_type_Aqso.toString());
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsp
 * JD-Core Version:    0.7.0.1
 */
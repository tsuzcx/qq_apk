import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arib
{
  public arhz a;
  public aria a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public arib()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aria = new aria();
    this.jdField_a_of_type_Arhz = new arhz();
  }
  
  public static arib a(araj[] paramArrayOfaraj)
  {
    arib localarib = new arib();
    int j;
    int i;
    try
    {
      j = paramArrayOfaraj.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaraj)
    {
      boolean bool;
      QLog.d("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaraj);
      return localarib;
    }
    Object localObject = ((araj)localObject).jdField_a_of_type_JavaLangString;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("config_url")) {
          localarib.jdField_a_of_type_JavaLangString = localJSONObject.optString("config_url");
        }
        if (localJSONObject.has("config_md5")) {
          localarib.b = localJSONObject.optString("config_md5");
        }
        if (localJSONObject.has("sysface_res_url")) {
          localarib.c = localJSONObject.optString("sysface_res_url");
        }
        if (localJSONObject.has("sysface_res_md5")) {
          localarib.d = localJSONObject.optString("sysface_res_md5");
        }
        if (localJSONObject.has("emoji_res_url")) {
          localarib.e = localJSONObject.optString("emoji_res_url");
        }
        if (localJSONObject.has("emoji_res_md5")) {
          localarib.f = localJSONObject.optString("emoji_res_md5");
        }
        localarib.jdField_a_of_type_Aria = aria.a(localJSONObject);
        localarib.jdField_a_of_type_Arhz = arhz.a(localJSONObject);
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
      localarib.a();
      return localarib;
      for (;;)
      {
        if (i >= j) {
          break label283;
        }
        localObject = paramArrayOfaraj[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Aria.a())
    {
      String str = this.jdField_a_of_type_Aria.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
      str = this.jdField_a_of_type_Aria.b;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
    }
  }
  
  public String toString()
  {
    new StringBuilder().append(", mConfigUrl:").append(this.jdField_a_of_type_JavaLangString).append(", mConfigMD5:").append(this.b).append(", mSysFaceUrl").append(this.c).append(", mSysFaceMD5").append(this.d).append(", mEmojiUrl").append(this.e).append(", mEmojiMD5").append(this.f).append(", mEmoticonGuideConfBean").append(this.jdField_a_of_type_Aria.toString());
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arib
 * JD-Core Version:    0.7.0.1
 */
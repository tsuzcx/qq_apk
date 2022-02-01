import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqbu
{
  public aqbs a;
  public aqbt a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public aqbu()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aqbt = new aqbt();
    this.jdField_a_of_type_Aqbs = new aqbs();
  }
  
  public static aqbu a(aptx[] paramArrayOfaptx)
  {
    aqbu localaqbu = new aqbu();
    int j;
    int i;
    try
    {
      j = paramArrayOfaptx.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaptx)
    {
      boolean bool;
      QLog.d("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaptx);
      return localaqbu;
    }
    Object localObject = ((aptx)localObject).jdField_a_of_type_JavaLangString;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("config_url")) {
          localaqbu.jdField_a_of_type_JavaLangString = localJSONObject.optString("config_url");
        }
        if (localJSONObject.has("config_md5")) {
          localaqbu.b = localJSONObject.optString("config_md5");
        }
        if (localJSONObject.has("sysface_res_url")) {
          localaqbu.c = localJSONObject.optString("sysface_res_url");
        }
        if (localJSONObject.has("sysface_res_md5")) {
          localaqbu.d = localJSONObject.optString("sysface_res_md5");
        }
        if (localJSONObject.has("emoji_res_url")) {
          localaqbu.e = localJSONObject.optString("emoji_res_url");
        }
        if (localJSONObject.has("emoji_res_md5")) {
          localaqbu.f = localJSONObject.optString("emoji_res_md5");
        }
        localaqbu.jdField_a_of_type_Aqbt = aqbt.a(localJSONObject);
        localaqbu.jdField_a_of_type_Aqbs = aqbs.a(localJSONObject);
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
      localaqbu.a();
      return localaqbu;
      for (;;)
      {
        if (i >= j) {
          break label283;
        }
        localObject = paramArrayOfaptx[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Aqbt.a())
    {
      String str = this.jdField_a_of_type_Aqbt.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
      str = this.jdField_a_of_type_Aqbt.b;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
    }
  }
  
  public String toString()
  {
    new StringBuilder().append(", mConfigUrl:").append(this.jdField_a_of_type_JavaLangString).append(", mConfigMD5:").append(this.b).append(", mSysFaceUrl").append(this.c).append(", mSysFaceMD5").append(this.d).append(", mEmojiUrl").append(this.e).append(", mEmojiMD5").append(this.f).append(", mEmoticonGuideConfBean").append(this.jdField_a_of_type_Aqbt.toString());
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbu
 * JD-Core Version:    0.7.0.1
 */
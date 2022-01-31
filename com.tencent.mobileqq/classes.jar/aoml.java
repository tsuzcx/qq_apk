import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class aoml
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c = -1;
  public int d = -1;
  public int e;
  public int f;
  
  public aoml()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static aoml a(JSONObject paramJSONObject)
  {
    aoml localaoml = new aoml();
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        do
        {
          return localaoml;
          paramJSONObject = paramJSONObject.optJSONObject("emoticon_guide_config");
        } while (paramJSONObject == null);
        if (QLog.isColorLevel()) {
          QLog.i("QQSysAndEmojiConfProcessor", 2, "parse GuideConfBean: ");
        }
        if (paramJSONObject.has("emoticon_guide_url")) {
          localaoml.jdField_a_of_type_JavaLangString = paramJSONObject.optString("emoticon_guide_url");
        }
        if (paramJSONObject.has("emoticon_guide_night_url")) {
          localaoml.jdField_b_of_type_JavaLangString = paramJSONObject.optString("emoticon_guide_night_url");
        }
        if (paramJSONObject.has("emoticon_guide_serverid")) {
          localaoml.c = paramJSONObject.optInt("emoticon_guide_serverid", -1);
        }
        if (paramJSONObject.has("emoticon_guide_serverid_type")) {
          localaoml.d = paramJSONObject.optInt("emoticon_guide_serverid_type", -1);
        }
        if (paramJSONObject.has("emoticon_guide_width")) {
          localaoml.e = paramJSONObject.optInt("emoticon_guide_width", 0);
        }
        if (paramJSONObject.has("emoticon_guide_height")) {
          localaoml.f = paramJSONObject.optInt("emoticon_guide_height", 0);
        }
        if (paramJSONObject.has("emoticon_guide_open")) {
          localaoml.jdField_a_of_type_Int = paramJSONObject.optInt("emoticon_guide_open", 0);
        }
        if (paramJSONObject.has("emoticon_guide_version")) {
          localaoml.jdField_b_of_type_Int = paramJSONObject.optInt("emoticon_guide_version", 0);
        }
      } while (!paramJSONObject.has("emoticon_guide_invalid_time"));
      paramJSONObject = paramJSONObject.optString("emoticon_guide_invalid_time", null);
    } while (TextUtils.isEmpty(paramJSONObject));
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    try
    {
      localaoml.jdField_a_of_type_Long = localSimpleDateFormat.parse(paramJSONObject).getTime();
      return localaoml;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "parse invalidTime failed!", paramJSONObject);
    }
    return localaoml;
  }
  
  boolean a()
  {
    int i = bdiv.c("key_emoticon_guide_version");
    if (this.jdField_b_of_type_Int > i)
    {
      bdiv.a("key_emoticon_guide_version", Integer.valueOf(this.jdField_b_of_type_Int));
      bdiv.a("key_show_emoticon_guide", Boolean.valueOf(true));
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSysAndEmojiConfProcessor", 2, "currentTimeMillis: " + System.currentTimeMillis() + " mInvalidTime: " + this.jdField_a_of_type_Long);
    }
    return (this.jdField_a_of_type_Int == 1) && (System.currentTimeMillis() < this.jdField_a_of_type_Long);
  }
  
  public String toString()
  {
    return "{mOpen=" + this.jdField_a_of_type_Int + ", mDrawableUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mNightDrawableUrl=" + this.jdField_b_of_type_JavaLangString + ", mServerId=" + this.c + ", mEmoType=" + this.d + ", mInvalidTime=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoml
 * JD-Core Version:    0.7.0.1
 */
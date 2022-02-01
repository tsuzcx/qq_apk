import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqbs
{
  public String a = "";
  public String b = "";
  
  public static aqbs a(JSONObject paramJSONObject)
  {
    aqbs localaqbs = new aqbs();
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return localaqbs;
        paramJSONObject = paramJSONObject.optJSONObject("anim_emoticon_count");
      } while (paramJSONObject == null);
      if (QLog.isColorLevel()) {
        QLog.i("QQSysAndEmojiConfProcessor", 2, "parse AnimCountConfBean: ");
      }
      if (paramJSONObject.has("model")) {
        localaqbs.a = paramJSONObject.optString("model");
      }
    } while (!paramJSONObject.has("version"));
    localaqbs.b = paramJSONObject.optString("version");
    return localaqbs;
  }
  
  public String toString()
  {
    return "{mAnimEmoVersion=" + this.b + ", mAnimEmoModel=" + this.a + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbs
 * JD-Core Version:    0.7.0.1
 */
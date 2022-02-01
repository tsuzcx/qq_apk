import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqsn
{
  public String a = "";
  public String b = "";
  
  public static aqsn a(JSONObject paramJSONObject)
  {
    aqsn localaqsn = new aqsn();
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return localaqsn;
        paramJSONObject = paramJSONObject.optJSONObject("anim_emoticon_count");
      } while (paramJSONObject == null);
      if (QLog.isColorLevel()) {
        QLog.i("QQSysAndEmojiConfProcessor", 2, "parse AnimCountConfBean: ");
      }
      if (paramJSONObject.has("model")) {
        localaqsn.a = paramJSONObject.optString("model");
      }
    } while (!paramJSONObject.has("version"));
    localaqsn.b = paramJSONObject.optString("version");
    return localaqsn;
  }
  
  public String toString()
  {
    return "{mAnimEmoVersion=" + this.b + ", mAnimEmoModel=" + this.a + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsn
 * JD-Core Version:    0.7.0.1
 */
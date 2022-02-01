import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arev
{
  public String a = "";
  public String b = "";
  
  public static arev a(JSONObject paramJSONObject)
  {
    arev localarev = new arev();
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return localarev;
        paramJSONObject = paramJSONObject.optJSONObject("anim_emoticon_count");
      } while (paramJSONObject == null);
      if (QLog.isColorLevel()) {
        QLog.i("QQSysAndEmojiConfProcessor", 2, "parse AnimCountConfBean: ");
      }
      if (paramJSONObject.has("model")) {
        localarev.a = paramJSONObject.optString("model");
      }
    } while (!paramJSONObject.has("version"));
    localarev.b = paramJSONObject.optString("version");
    return localarev;
  }
  
  public String toString()
  {
    return "{mAnimEmoVersion=" + this.b + ", mAnimEmoModel=" + this.a + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arev
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arhz
{
  public String a = "";
  public String b = "";
  
  public static arhz a(JSONObject paramJSONObject)
  {
    arhz localarhz = new arhz();
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return localarhz;
        paramJSONObject = paramJSONObject.optJSONObject("anim_emoticon_count");
      } while (paramJSONObject == null);
      if (QLog.isColorLevel()) {
        QLog.i("QQSysAndEmojiConfProcessor", 2, "parse AnimCountConfBean: ");
      }
      if (paramJSONObject.has("model")) {
        localarhz.a = paramJSONObject.optString("model");
      }
    } while (!paramJSONObject.has("version"));
    localarhz.b = paramJSONObject.optString("version");
    return localarhz;
  }
  
  public String toString()
  {
    return "{mAnimEmoVersion=" + this.b + ", mAnimEmoModel=" + this.a + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhz
 * JD-Core Version:    0.7.0.1
 */
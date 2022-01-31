import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class babr
{
  public JSONObject a = new JSONObject();
  
  public boolean a()
  {
    JSONObject localJSONObject = this.a.optJSONObject("plugin");
    if (localJSONObject != null) {
      return localJSONObject.optInt("preload", 0) == 1;
    }
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return "StudyRoomConfBean{data=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babr
 * JD-Core Version:    0.7.0.1
 */
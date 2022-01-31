import android.os.Bundle;
import org.json.JSONObject;

class bjun
  implements bjup
{
  bjun(bjul parambjul) {}
  
  public void a(JSONObject paramJSONObject, Bundle paramBundle)
  {
    paramJSONObject.put("status", paramBundle.getInt("status", 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjun
 * JD-Core Version:    0.7.0.1
 */
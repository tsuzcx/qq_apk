import android.os.Bundle;
import org.json.JSONObject;

class bmnf
  implements bmnh
{
  bmnf(bmnd parambmnd) {}
  
  public void a(JSONObject paramJSONObject, Bundle paramBundle)
  {
    paramJSONObject.put("status", paramBundle.getInt("status", 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnf
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import org.json.JSONObject;

class bhsl
  implements bhsn
{
  bhsl(bhsj parambhsj) {}
  
  public void a(JSONObject paramJSONObject, Bundle paramBundle)
  {
    paramJSONObject.put("status", paramBundle.getInt("status", 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhsl
 * JD-Core Version:    0.7.0.1
 */
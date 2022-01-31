import com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera;
import org.json.JSONException;
import org.json.JSONObject;

public class bhfz
  implements bhgd
{
  public bhfz(MiniAppCamera paramMiniAppCamera, bgkd parambgkd) {}
  
  public void a(String paramString)
  {
    if (bglo.a(paramString))
    {
      this.jdField_a_of_type_Bgkd.b();
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempImagePath", bgjm.a().e(paramString));
      this.jdField_a_of_type_Bgkd.a.a(this.jdField_a_of_type_Bgkd.b, localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfz
 * JD-Core Version:    0.7.0.1
 */
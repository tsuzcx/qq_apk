import com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera;
import org.json.JSONException;
import org.json.JSONObject;

public class bhkg
  implements bhkk
{
  public bhkg(MiniAppCamera paramMiniAppCamera, bgok parambgok) {}
  
  public void a(String paramString)
  {
    if (bgpv.a(paramString))
    {
      this.jdField_a_of_type_Bgok.b();
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempImagePath", bgnt.a().e(paramString));
      this.jdField_a_of_type_Bgok.a.a(this.jdField_a_of_type_Bgok.b, localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkg
 * JD-Core Version:    0.7.0.1
 */
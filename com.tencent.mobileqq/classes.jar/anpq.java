import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class anpq
  implements MiniAppCmdInterface
{
  anpq(anpp paramanpp, anpr paramanpr) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        anpp.a(this.jdField_a_of_type_Anpp, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Anpp.a(anpp.a(this.jdField_a_of_type_Anpp));
        if (this.jdField_a_of_type_Anpr != null) {
          this.jdField_a_of_type_Anpr.a(true, anpp.a(this.jdField_a_of_type_Anpp));
        }
      }
    }
    while (this.jdField_a_of_type_Anpr == null) {
      return;
    }
    this.jdField_a_of_type_Anpr.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anpq
 * JD-Core Version:    0.7.0.1
 */
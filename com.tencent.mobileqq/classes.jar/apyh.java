import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class apyh
  implements MiniAppCmdInterface
{
  apyh(apyg paramapyg, apyi paramapyi) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        apyg.a(this.jdField_a_of_type_Apyg, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Apyg.a(apyg.a(this.jdField_a_of_type_Apyg));
        if (this.jdField_a_of_type_Apyi != null) {
          this.jdField_a_of_type_Apyi.a(true, apyg.a(this.jdField_a_of_type_Apyg));
        }
      }
    }
    while (this.jdField_a_of_type_Apyi == null) {
      return;
    }
    this.jdField_a_of_type_Apyi.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyh
 * JD-Core Version:    0.7.0.1
 */
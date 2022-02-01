import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class asxa
  implements MiniAppCmdInterface
{
  asxa(aswz paramaswz, asxb paramasxb) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        aswz.a(this.jdField_a_of_type_Aswz, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Aswz.a(aswz.a(this.jdField_a_of_type_Aswz));
        if (this.jdField_a_of_type_Asxb != null) {
          this.jdField_a_of_type_Asxb.a(true, aswz.a(this.jdField_a_of_type_Aswz));
        }
      }
    }
    while (this.jdField_a_of_type_Asxb == null) {
      return;
    }
    this.jdField_a_of_type_Asxb.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxa
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class ashm
  implements MiniAppCmdInterface
{
  ashm(ashl paramashl, ashn paramashn) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        ashl.a(this.jdField_a_of_type_Ashl, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Ashl.a(ashl.a(this.jdField_a_of_type_Ashl));
        if (this.jdField_a_of_type_Ashn != null) {
          this.jdField_a_of_type_Ashn.a(true, ashl.a(this.jdField_a_of_type_Ashl));
        }
      }
    }
    while (this.jdField_a_of_type_Ashn == null) {
      return;
    }
    this.jdField_a_of_type_Ashn.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashm
 * JD-Core Version:    0.7.0.1
 */
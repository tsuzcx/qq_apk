import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class asnj
  implements MiniAppCmdInterface
{
  asnj(asni paramasni, asnk paramasnk) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        asni.a(this.jdField_a_of_type_Asni, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Asni.a(asni.a(this.jdField_a_of_type_Asni));
        if (this.jdField_a_of_type_Asnk != null) {
          this.jdField_a_of_type_Asnk.a(true, asni.a(this.jdField_a_of_type_Asni));
        }
      }
    }
    while (this.jdField_a_of_type_Asnk == null) {
      return;
    }
    this.jdField_a_of_type_Asnk.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnj
 * JD-Core Version:    0.7.0.1
 */
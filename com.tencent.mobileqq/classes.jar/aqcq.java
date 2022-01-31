import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class aqcq
  implements MiniAppCmdInterface
{
  aqcq(aqcp paramaqcp, aqcr paramaqcr) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        aqcp.a(this.jdField_a_of_type_Aqcp, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Aqcp.a(aqcp.a(this.jdField_a_of_type_Aqcp));
        if (this.jdField_a_of_type_Aqcr != null) {
          this.jdField_a_of_type_Aqcr.a(true, aqcp.a(this.jdField_a_of_type_Aqcp));
        }
      }
    }
    while (this.jdField_a_of_type_Aqcr == null) {
      return;
    }
    this.jdField_a_of_type_Aqcr.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcq
 * JD-Core Version:    0.7.0.1
 */
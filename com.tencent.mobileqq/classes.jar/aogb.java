import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class aogb
  implements MiniAppCmdInterface
{
  aogb(aoga paramaoga, aogc paramaogc) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        aoga.a(this.jdField_a_of_type_Aoga, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Aoga.a(aoga.a(this.jdField_a_of_type_Aoga));
        if (this.jdField_a_of_type_Aogc != null) {
          this.jdField_a_of_type_Aogc.a(true, aoga.a(this.jdField_a_of_type_Aoga));
        }
      }
    }
    while (this.jdField_a_of_type_Aogc == null) {
      return;
    }
    this.jdField_a_of_type_Aogc.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogb
 * JD-Core Version:    0.7.0.1
 */
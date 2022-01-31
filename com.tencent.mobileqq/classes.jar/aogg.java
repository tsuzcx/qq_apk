import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class aogg
  implements MiniAppCmdInterface
{
  aogg(aogf paramaogf, aogh paramaogh) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        aogf.a(this.jdField_a_of_type_Aogf, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Aogf.a(aogf.a(this.jdField_a_of_type_Aogf));
        if (this.jdField_a_of_type_Aogh != null) {
          this.jdField_a_of_type_Aogh.a(true, aogf.a(this.jdField_a_of_type_Aogf));
        }
      }
    }
    while (this.jdField_a_of_type_Aogh == null) {
      return;
    }
    this.jdField_a_of_type_Aogh.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogg
 * JD-Core Version:    0.7.0.1
 */
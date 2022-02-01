import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class arjd
  implements MiniAppCmdInterface
{
  arjd(arjc paramarjc, arje paramarje) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        arjc.a(this.jdField_a_of_type_Arjc, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_Arjc.a(arjc.a(this.jdField_a_of_type_Arjc));
        if (this.jdField_a_of_type_Arje != null) {
          this.jdField_a_of_type_Arje.a(true, arjc.a(this.jdField_a_of_type_Arjc));
        }
      }
    }
    while (this.jdField_a_of_type_Arje == null) {
      return;
    }
    this.jdField_a_of_type_Arje.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjd
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aqpb
  implements MiniAppCmdInterface
{
  aqpb(aqoz paramaqoz, BaseChatPie paramBaseChatPie) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optInt("retCode") == -12998002)) {
      this.jdField_a_of_type_Aqoz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarJumpController", 2, "onCmdListener() isSuc = " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpb
 * JD-Core Version:    0.7.0.1
 */
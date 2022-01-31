import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.agent.AuthorityActivity;
import org.json.JSONObject;

public class bbtz
  implements DialogInterface.OnClickListener
{
  public bbtz(AuthorityActivity paramAuthorityActivity, int paramInt, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbtz
 * JD-Core Version:    0.7.0.1
 */
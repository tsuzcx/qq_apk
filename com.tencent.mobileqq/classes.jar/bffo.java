import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import org.json.JSONObject;

class bffo
  implements DialogInterface.OnClickListener
{
  bffo(bffm parambffm, preAuth.PreAuthResponse paramPreAuthResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_Bffm.a.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse.ret.get(), this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffo
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import org.json.JSONObject;

class bims
  implements DialogInterface.OnClickListener
{
  bims(bimq parambimq, preAuth.PreAuthResponse paramPreAuthResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_Bimq.a.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse.ret.get(), this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bims
 * JD-Core Version:    0.7.0.1
 */
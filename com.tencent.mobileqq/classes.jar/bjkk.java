import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import org.json.JSONObject;

class bjkk
  implements DialogInterface.OnClickListener
{
  bjkk(bjki parambjki, SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_Bjki.a.a(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$GetAuthApiListResponse.ret.get(), this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjkk
 * JD-Core Version:    0.7.0.1
 */
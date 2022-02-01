import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import org.json.JSONObject;

class bjkm
  implements DialogInterface.OnClickListener
{
  bjkm(bjki parambjki, SdkAuthorize.AuthorizeResponse paramAuthorizeResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_Bjki.a.a(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.ret.get(), this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjkm
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.utils.Utils;
import cooperation.weiyun.channel.pb.WeiyunPB.QqSdkFileUploadMsgRsp;

class bgtq
  implements bgun<WeiyunPB.QqSdkFileUploadMsgRsp>
{
  bgtq(bgto parambgto, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback, UploadFile paramUploadFile) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.QqSdkFileUploadMsgRsp paramQqSdkFileUploadMsgRsp)
  {
    this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, paramInt, paramString);
  }
  
  public void a(WeiyunPB.QqSdkFileUploadMsgRsp paramQqSdkFileUploadMsgRsp)
  {
    if (paramQqSdkFileUploadMsgRsp == null)
    {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, 1828004, ajjy.a(2131649284));
      return;
    }
    Object localObject1 = paramQqSdkFileUploadMsgRsp.pdir_key.get();
    Object localObject3 = paramQqSdkFileUploadMsgRsp.ppdir_key.get();
    Object localObject2;
    label57:
    boolean bool;
    String str;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject3 != null) {
        break label240;
      }
      localObject2 = null;
      if ((localObject1 != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirKey))) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirKey = ((String)localObject1);
      }
      if ((localObject3 != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pPDirKey))) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pPDirKey = ((String)localObject2);
      }
      bgtw.a((String)localObject2, (String)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile;
      bool = paramQqSdkFileUploadMsgRsp.file_exist.get();
      localObject3 = paramQqSdkFileUploadMsgRsp.file_id.get();
      str = paramQqSdkFileUploadMsgRsp.server_name.get();
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        break label250;
      }
    }
    label240:
    label250:
    for (localObject1 = paramQqSdkFileUploadMsgRsp.inside_upload_ip.get();; localObject1 = paramQqSdkFileUploadMsgRsp.outside_upload_ip.get())
    {
      ((UploadFile)localObject2).setServerInfo(bool, (String)localObject3, str, (String)localObject1, paramQqSdkFileUploadMsgRsp.server_port.get(), Utils.bytes2HexStr(paramQqSdkFileUploadMsgRsp.check_key.get().toByteArray()).toLowerCase(), paramQqSdkFileUploadMsgRsp.channel_count.get(), Integer.toString(paramQqSdkFileUploadMsgRsp.file_version.get()));
      this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, true, 0, null);
      return;
      localObject1 = bgwl.a((ByteStringMicro)localObject1);
      break;
      localObject2 = bgwl.a((ByteStringMicro)localObject3);
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtq
 * JD-Core Version:    0.7.0.1
 */
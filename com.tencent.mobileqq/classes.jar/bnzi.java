import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.utils.Utils;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskPicBackupRsp;

class bnzi
  implements boae<WeiyunPB.DiskPicBackupRsp>
{
  bnzi(bnzh parambnzh, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback, UploadFile paramUploadFile) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskPicBackupRsp paramDiskPicBackupRsp)
  {
    this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, paramInt, paramString);
  }
  
  public void a(WeiyunPB.DiskPicBackupRsp paramDiskPicBackupRsp)
  {
    if (paramDiskPicBackupRsp == null)
    {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, 1828004, anzj.a(2131713857));
      return;
    }
    Object localObject1 = paramDiskPicBackupRsp.pdir_key.get();
    Object localObject2 = paramDiskPicBackupRsp.ppdir_key.get();
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirKey = bocc.a((ByteStringMicro)localObject1);
    }
    if (localObject2 != null) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pPDirKey = bocc.a((ByteStringMicro)localObject2);
    }
    if (!TextUtils.isEmpty(paramDiskPicBackupRsp.backup_path.get())) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirName = paramDiskPicBackupRsp.backup_path.get();
    }
    localObject2 = this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile;
    boolean bool = paramDiskPicBackupRsp.file_exist.get();
    String str1 = paramDiskPicBackupRsp.file_id.get();
    String str2 = paramDiskPicBackupRsp.server_name.get();
    if (WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {}
    for (localObject1 = paramDiskPicBackupRsp.inside_upload_ip.get();; localObject1 = paramDiskPicBackupRsp.outside_upload_ip.get())
    {
      ((UploadFile)localObject2).setServerInfo(bool, str1, str2, (String)localObject1, paramDiskPicBackupRsp.server_port.get(), Utils.bytes2HexStr(paramDiskPicBackupRsp.check_key.get().toByteArray()).toLowerCase(), paramDiskPicBackupRsp.channel_count.get(), Integer.toString(paramDiskPicBackupRsp.file_version.get()));
      this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, true, 0, null);
      bobx.a(BaseApplicationImpl.getApplication().getApplicationContext(), String.valueOf(this.jdField_a_of_type_Bnzh.getCurrentUin()), "upload_coupon_count", String.valueOf(paramDiskPicBackupRsp.coupon_count.get()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzi
 * JD-Core Version:    0.7.0.1
 */
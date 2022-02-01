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

class bmrg
  implements bmsc<WeiyunPB.DiskPicBackupRsp>
{
  bmrg(bmrf parambmrf, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback, UploadFile paramUploadFile) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskPicBackupRsp paramDiskPicBackupRsp)
  {
    this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, paramInt, paramString);
  }
  
  public void a(WeiyunPB.DiskPicBackupRsp paramDiskPicBackupRsp)
  {
    if (paramDiskPicBackupRsp == null)
    {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, 1828004, anvx.a(2131714436));
      return;
    }
    Object localObject1 = paramDiskPicBackupRsp.pdir_key.get();
    Object localObject2 = paramDiskPicBackupRsp.ppdir_key.get();
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirKey = bmua.a((ByteStringMicro)localObject1);
    }
    if (localObject2 != null) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pPDirKey = bmua.a((ByteStringMicro)localObject2);
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
      bmtv.a(BaseApplicationImpl.getApplication().getApplicationContext(), String.valueOf(this.jdField_a_of_type_Bmrf.getCurrentUin()), "upload_coupon_count", String.valueOf(paramDiskPicBackupRsp.coupon_count.get()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrg
 * JD-Core Version:    0.7.0.1
 */
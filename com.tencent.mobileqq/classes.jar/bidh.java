import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadType;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskPicBackupReq;
import cooperation.weiyun.channel.pb.WeiyunPB.FileExtInfo;
import cooperation.weiyun.channel.pb.WeiyunPB.QqSdkFileUploadMsgReq;
import mqq.app.AppRuntime;

class bidh
  implements WeiyunTransmissionGlobal.HostInterface
{
  private final String a;
  
  bidh(String paramString)
  {
    this.a = paramString;
  }
  
  public void fetchUploadServerInfo(UploadFile paramUploadFile, UploadType paramUploadType, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback)
  {
    if (paramUploadFile.cmdType == 1)
    {
      localObject = new WeiyunPB.DiskPicBackupReq();
      if (paramUploadFile.fileName != null) {
        ((WeiyunPB.DiskPicBackupReq)localObject).filename.set(paramUploadFile.fileName);
      }
      ((WeiyunPB.DiskPicBackupReq)localObject).file_exist_option.set(paramUploadType.ordinal());
      ((WeiyunPB.DiskPicBackupReq)localObject).upload_type.set(0);
      ((WeiyunPB.DiskPicBackupReq)localObject).auto_create_user.set(false);
      ((WeiyunPB.DiskPicBackupReq)localObject).auto_flag.set(paramUploadFile.autoBackupFlag);
      ((WeiyunPB.DiskPicBackupReq)localObject).backup_dir_name.set(Build.MODEL);
      if ((paramUploadFile.isCompress) && (!TextUtils.isEmpty(paramUploadFile.compressedPath)))
      {
        if (paramUploadFile.compressedSha != null) {
          ((WeiyunPB.DiskPicBackupReq)localObject).file_sha.set(bige.a(paramUploadFile.compressedSha));
        }
        ((WeiyunPB.DiskPicBackupReq)localObject).file_size.set(paramUploadFile.compressedSize);
        ((WeiyunPB.DiskPicBackupReq)localObject).first_256k_crc.set((int)bifx.a(paramUploadFile.compressedPath, 262144L));
        if (!TextUtils.isEmpty(paramUploadFile.mimeType))
        {
          paramUploadType = new WeiyunPB.FileExtInfo();
          paramUploadType.take_time.set(paramUploadFile.takenTime);
          paramUploadType.latitude.set(paramUploadFile.latitude);
          paramUploadType.longitude.set(paramUploadFile.longitude);
          if (!paramUploadFile.mimeType.startsWith("image")) {
            break label311;
          }
          paramUploadType.group_id.set(1);
          ((WeiyunPB.DiskPicBackupReq)localObject).ext_info.set(paramUploadType);
        }
        bieh.a((WeiyunPB.DiskPicBackupReq)localObject, new bidi(this, paramUploadServerInfoCallback, paramUploadFile));
      }
    }
    label311:
    while (paramUploadFile.cmdType != 0) {
      for (;;)
      {
        return;
        if (paramUploadFile.sha != null) {
          ((WeiyunPB.DiskPicBackupReq)localObject).file_sha.set(bige.a(paramUploadFile.sha));
        }
        ((WeiyunPB.DiskPicBackupReq)localObject).file_size.set(paramUploadFile.fileSize);
        ((WeiyunPB.DiskPicBackupReq)localObject).first_256k_crc.set((int)bifx.a(paramUploadFile.localPath, 262144L));
        continue;
        if (!paramUploadFile.mimeType.startsWith("video")) {}
      }
    }
    Object localObject = new WeiyunPB.QqSdkFileUploadMsgReq();
    if (paramUploadFile.fileName != null) {
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).filename.set(paramUploadFile.fileName);
    }
    ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_exist_option.set(paramUploadType.ordinal());
    ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).upload_type.set(0);
    ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).auto_create_user.set(false);
    ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).pdir_key.set(bige.a(paramUploadFile.pDirKey));
    ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).ppdir_key.set(bige.a(paramUploadFile.pPDirKey));
    ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).use_mutil_channel.set(WeiyunTransmissionGlobal.getInstance().isNativeUpload());
    if ((paramUploadFile.isCompress) && (!TextUtils.isEmpty(paramUploadFile.compressedPath)))
    {
      if (paramUploadFile.compressedSha != null) {
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_sha.set(bige.a(paramUploadFile.compressedSha));
      }
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_size.set(paramUploadFile.compressedSize);
      if (!TextUtils.isEmpty(paramUploadFile.mimeType))
      {
        paramUploadType = new WeiyunPB.FileExtInfo();
        paramUploadType.take_time.set(paramUploadFile.takenTime);
        paramUploadType.latitude.set(paramUploadFile.latitude);
        paramUploadType.longitude.set(paramUploadFile.longitude);
        if (!paramUploadFile.mimeType.startsWith("image")) {
          break label619;
        }
        paramUploadType.group_id.set(1);
      }
    }
    for (;;)
    {
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).ext_info.set(paramUploadType);
      bieh.a((WeiyunPB.QqSdkFileUploadMsgReq)localObject, new bidj(this, paramUploadServerInfoCallback, paramUploadFile));
      return;
      if (paramUploadFile.sha != null) {
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_sha.set(bige.a(paramUploadFile.sha));
      }
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_size.set(paramUploadFile.fileSize);
      break;
      label619:
      if (!paramUploadFile.mimeType.startsWith("video")) {}
    }
  }
  
  public int getCurrentIsp()
  {
    return 0;
  }
  
  public String getCurrentUid()
  {
    return this.a + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public long getCurrentUin()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  public NetworkInfo getRecentNetworkInfo()
  {
    return AppNetConnInfo.getRecentNetworkInfo();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidh
 * JD-Core Version:    0.7.0.1
 */
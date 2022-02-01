import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.bigbrother.ServerApi.ErrorInfo;
import com.tencent.mobileqq.bigbrother.ServerApi.RspPreDownloadRecmd;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class aqjq
  implements BusinessObserver
{
  aqjq(RockDownloaderTask paramRockDownloaderTask) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "type=", Integer.valueOf(paramInt), " success=", Boolean.valueOf(paramBoolean), " bundle=", paramBundle });
    }
    Object localObject;
    if (1 == paramInt)
    {
      if ((!paramBoolean) || (paramBundle == null)) {
        break label816;
      }
      localObject = paramBundle.getByteArray("BUNDLE_KEY_RESPONSE_BYTE");
      paramBundle = new ServerApi.RspPreDownloadRecmd();
      if (localObject == null)
      {
        if (this.a.getRockDownloadListener() != null)
        {
          this.a.getRockDownloadListener().onDownloadFail(this.a.getDownloadInfo(), anzj.a(2131712372), 10003);
          this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
        }
        aqjp.a(this.a, "0x800A1E6");
      }
    }
    else
    {
      return;
    }
    try
    {
      paramBundle.mergeFrom((byte[])localObject);
      localObject = (ServerApi.ErrorInfo)paramBundle.err_info.get();
      if (localObject == null) {
        break label757;
      }
      if (((ServerApi.ErrorInfo)localObject).err_code.get() != 0) {
        break label395;
      }
      paramBoolean = aqjp.a(paramBundle, this.a);
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "backend isGetPermission=", Boolean.valueOf(paramBoolean) });
      }
      if (!paramBoolean)
      {
        aqjp.a(this.a, "0x800A1E9");
        if (this.a.getRockDownloadListener() == null) {
          break label387;
        }
        this.a.getRockDownloadListener().onPermissionDeny(this.a.getDownloadInfo());
        this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "InvalidProtocolBufferMicroException,", paramBundle);
      }
      if (this.a.getRockDownloadListener() != null)
      {
        this.a.getRockDownloadListener().onDownloadFail(this.a.getDownloadInfo(), "GET_PERMISSION_ERROR_BYTE_INFO", 10003);
        this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
      }
      aqjp.a(this.a, "0x800A1E6");
      return;
    }
    aqjp.a(this.a, "0x800A1E4");
    if (this.a.getRockDownloadListener() != null) {
      this.a.getRockDownloadListener().onPermissionPermit(this.a.getDownloadInfo());
    }
    label387:
    aqjp.c(this.a);
    return;
    label395:
    if (((ServerApi.ErrorInfo)localObject).err_code.get() == 10006)
    {
      if (this.a.getRockDownloadListener() != null)
      {
        this.a.getRockDownloadListener().onPermissionDeny(this.a.getDownloadInfo());
        this.a.getRockDownloadListener().onDownloadFail(this.a.getDownloadInfo(), ((ServerApi.ErrorInfo)localObject).err_msg.get(), ((ServerApi.ErrorInfo)localObject).err_code.get());
        this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
      }
      aqjp.a(this.a, "0x800A1E6");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "GET_DOWNLOAD_CONFIG error!! ", " ", paramBundle.download_url.get(), " ", Integer.valueOf(paramBundle.start_time.get()), " ", Integer.valueOf(paramBundle.end_time.get()), " ", Integer.valueOf(paramBundle.interval.get()), " ", Integer.valueOf(paramBundle.quota_num.get()), " ", Integer.valueOf(paramBundle.daily_num.get()), " ", ((ServerApi.ErrorInfo)localObject).err_msg.get(), " ", Integer.valueOf(((ServerApi.ErrorInfo)localObject).err_code.get()), " ", ((ServerApi.ErrorInfo)localObject).jump_url.get() });
    }
    if (this.a.getRockDownloadListener() != null)
    {
      this.a.getRockDownloadListener().onDownloadFail(this.a.getDownloadInfo(), ((ServerApi.ErrorInfo)localObject).err_msg.get(), ((ServerApi.ErrorInfo)localObject).err_code.get());
      this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
    }
    aqjp.a(this.a, "0x800A1E6");
    return;
    label757:
    if (this.a.getRockDownloadListener() != null)
    {
      this.a.getRockDownloadListener().onDownloadFail(this.a.getDownloadInfo(), "GET_PERMISSION_ERROR_NULL_ERROR_INFO", 10003);
      this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
    }
    aqjp.a(this.a, "0x800A1E6");
    return;
    label816:
    if (this.a.getRockDownloadListener() != null)
    {
      this.a.getRockDownloadListener().onDownloadFail(this.a.getDownloadInfo(), "GET_PERMISSION_ERROR", 10003);
      this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
    }
    aqjp.a(this.a, "0x800A1E6");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjq
 * JD-Core Version:    0.7.0.1
 */
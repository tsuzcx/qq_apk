import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

final class bkjj
  implements UploadManager.IUploadStatusListener
{
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramStatusInfo.state != 6) {
        break label26;
      }
      bkmk.a(paramString, "actFileWyUp", paramStatusInfo, false, paramLong);
    }
    label26:
    while (paramStatusInfo.state != 5) {
      return;
    }
    bkmk.a(paramString, "actFileWyUp", paramStatusInfo, true, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjj
 * JD-Core Version:    0.7.0.1
 */
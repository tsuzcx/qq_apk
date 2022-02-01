import com.tencent.plato.mqq.network.ProgressListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;

final class bkoi
  implements ProgressListener
{
  bkoi(UploaderProxy.UploadListener paramUploadListener) {}
  
  public void onProgress(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.a.onUploadProgress((int)(100.0D * paramLong1 / paramLong2), (int)paramLong1, (int)paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkoi
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class apku
  extends aplr
{
  apku(apkr paramapkr) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "download success " + paramInt);
    }
    if (apkr.a(this.a) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mFaceCallback onDownloadSuccess error mHandler is null ");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    localMessage.arg1 = paramInt;
    apkr.a(this.a).sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "download process " + paramInt1 + " : " + paramInt2);
    }
    if (apkr.a(this.a) == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    apkr.a(this.a).sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "download error " + paramInt1 + " : " + paramInt2);
    }
    if (apkr.a(this.a) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mFaceCallback onDownloadError error mHandler is null ");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    apkr.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apku
 * JD-Core Version:    0.7.0.1
 */
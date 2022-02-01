import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aoei
  extends aofk
{
  aoei(aoee paramaoee) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onMiniDownloadSuccess success " + paramInt);
    }
    if (aoee.a(this.a) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "onMiniDownloadSuccess error mHandler is null ");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 10;
    localMessage.arg1 = paramInt;
    aoee.a(this.a).sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onMiniDownloadProcess process " + paramInt1 + " : " + paramInt2);
    }
    if (aoee.a(this.a) == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 11;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    aoee.a(this.a).sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onMiniDownloadError " + paramInt1 + " : " + paramInt2);
    }
    if (aoee.a(this.a) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "onMiniDownloadError error mHandler is null ");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 12;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    aoee.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoei
 * JD-Core Version:    0.7.0.1
 */
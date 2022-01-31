import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class amyp
  extends amzw
{
  amyp(amyk paramamyk) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadSuccess");
    }
    Message localMessage = amyk.a(this.a).obtainMessage();
    localMessage.what = 100;
    localMessage.sendToTarget();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadProcess process=" + paramInt);
    }
    Message localMessage = amyk.a(this.a).obtainMessage();
    localMessage.what = 102;
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadFail");
    }
    Message localMessage = amyk.a(this.a).obtainMessage();
    localMessage.what = 101;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyp
 * JD-Core Version:    0.7.0.1
 */
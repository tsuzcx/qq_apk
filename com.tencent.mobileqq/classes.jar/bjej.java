import android.os.Handler;
import android.os.Message;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2;
import cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.2.1;
import cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.2.2;

public class bjej
  extends bjoi
{
  public bjej(QZoneLiveVideoDownLoadActivtyV2 paramQZoneLiveVideoDownLoadActivtyV2) {}
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.arg1 = 1;
    this.a.a.sendMessage(localMessage);
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadSoTimeout", 60000);
    this.a.a.sendEmptyMessageDelayed(1009, i);
  }
  
  public void a(float paramFloat)
  {
    this.a.runOnUiThread(new QZoneLiveVideoDownLoadActivtyV2.2.1(this, paramFloat));
  }
  
  public void a(int paramInt)
  {
    this.a.a.obtainMessage(1008).sendToTarget();
  }
  
  public void b()
  {
    this.a.runOnUiThread(new QZoneLiveVideoDownLoadActivtyV2.2.2(this));
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjej
 * JD-Core Version:    0.7.0.1
 */
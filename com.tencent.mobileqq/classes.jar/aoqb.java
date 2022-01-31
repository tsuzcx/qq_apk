import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;

class aoqb
  implements Runnable
{
  aoqb(aopy paramaopy) {}
  
  public void run()
  {
    boolean bool = CameraCompatibleList.a(CameraCompatibleList.y);
    if (bool)
    {
      RMVideoStateMgr.a().a(1102, "已经获取权限，需要重新进入打开摄像头", true);
      return;
    }
    try
    {
      if ((!this.a.d) && (this.a.f)) {
        RMVideoStateMgr.a().a(1102, "初始化失败,code=1102", true);
      }
      RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoInitState", 2, "[ERR_CODE_INIT_TIMEOUT]初始化失败,code=1102 mIsReadAVCodec=" + this.a.a + " mIsReadCamera=" + this.a.b + " black=" + bool + " rmStateMgr.mIsAudioReady=" + localRMVideoStateMgr.d + " rmStateMgr.mVideoCacheDir=" + localRMVideoStateMgr.a);
      }
      RMVideoStateMgr.b(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoqb
 * JD-Core Version:    0.7.0.1
 */
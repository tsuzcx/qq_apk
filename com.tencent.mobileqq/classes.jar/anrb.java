import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;
import java.io.File;
import java.io.IOException;

class anrb
  implements Runnable
{
  anrb(anqz paramanqz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit,run start");
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.d())
    {
      RMVideoStateMgr.b(null);
      if (!localRMVideoStateMgr.d()) {
        return;
      }
    }
    File localFile = new File(GloableValue.b + File.separator + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      label84:
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoInitState", 2, "[@] delayInit, post timeout runnable");
      }
      localRMVideoStateMgr.a.postDelayed(this.a.a, 20000L);
      localRMVideoStateMgr.k();
      localRMVideoStateMgr.l();
      localRMVideoStateMgr.j();
      try
      {
        AVCodec.get().init();
        this.a.c = true;
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] delayInit,run finish");
        }
        this.a.g = false;
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
          this.a.c = false;
        }
      }
    }
    catch (IOException localIOException)
    {
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrb
 * JD-Core Version:    0.7.0.1
 */
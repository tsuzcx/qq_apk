import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class blfa
  implements blfk
{
  public blfa(AudioDeviceInterface paramAudioDeviceInterface) {}
  
  public void a(int paramInt)
  {
    try
    {
      AudioDeviceInterface.access$000(this.a).lock();
      AudioDeviceInterface.access$102(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
      }
      AudioDeviceInterface.access$200(this.a).signalAll();
      AudioDeviceInterface.access$000(this.a).unlock();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      AudioDeviceInterface.access$400(this.a, paramString);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong, int paramInt, String paramString) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      AudioDeviceInterface.access$000(this.a).lock();
      AudioDeviceInterface.access$102(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
      }
      AudioDeviceInterface.access$200(this.a).signalAll();
      AudioDeviceInterface.access$000(this.a).unlock();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(long paramLong, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    if (AudioDeviceInterface.access$300(this.a)) {
      AudioDeviceInterface.access$400(this.a, paramString1);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfa
 * JD-Core Version:    0.7.0.1
 */
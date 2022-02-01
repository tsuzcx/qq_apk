import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.TraeAudioManagerLooper;

public class bjll
  implements bjls
{
  public bjll(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "_ringPlayer onCompletion, _activeMode[" + this.a.this$0.a + "], _preRingMode[" + this.a.b + "], seq[" + paramLong + "]");
    }
    TraeAudioManager.b(paramLong, null, -1L, true);
    this.a.c(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjll
 * JD-Core Version:    0.7.0.1
 */
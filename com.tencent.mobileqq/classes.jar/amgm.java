import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.sharp.jni.TraeMediaPlayer.OnCompletionListener;
import java.util.TimerTask;

public class amgm
  extends TimerTask
{
  public amgm(TraeMediaPlayer paramTraeMediaPlayer, long paramLong) {}
  
  public void run()
  {
    if (TraeMediaPlayer.a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeMediaPlay", 1, "playRing, onCompletion, seq[" + this.jdField_a_of_type_Long + "]");
      }
      if (TraeMediaPlayer.a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer) != null) {
        TraeMediaPlayer.a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgm
 * JD-Core Version:    0.7.0.1
 */
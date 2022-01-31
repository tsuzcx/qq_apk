import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeMediaPlayer.OnCompletionListener;

class amge
  implements TraeMediaPlayer.OnCompletionListener
{
  amge(amgd paramamgd) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + this.a.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a + " _preRingMode:" + this.a.jdField_b_of_type_Int);
    }
    TraeAudioManager.a("TraeMediaPlayer_OnCompletionListener", null, -1L, true);
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amge
 * JD-Core Version:    0.7.0.1
 */
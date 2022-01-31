import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.TraeAudioManagerLooper;

public class bfld
  implements AudioManager.OnAudioFocusChangeListener
{
  public bfld(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  @TargetApi(8)
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "focusChange:" + paramInt + " _focusSteamType:" + this.a.c + " currMode:" + this.a.this$0.jdField_a_of_type_AndroidMediaAudioManager.getMode() + " _activeMode:" + this.a.this$0.jdField_a_of_type_Int);
    }
    if (paramInt == -1) {}
    while ((paramInt == -2) || (paramInt == -3) || (paramInt != 1)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfld
 * JD-Core Version:    0.7.0.1
 */
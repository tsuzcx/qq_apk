import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class anbj
  implements AudioManager.OnAudioFocusChangeListener
{
  anbj(anbh paramanbh) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(anbh.a, 2, new Object[] { "[onAudioFocusChange],focusChange:", Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbj
 * JD-Core Version:    0.7.0.1
 */
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class bdsi
  implements AudioManager.OnAudioFocusChangeListener
{
  bdsi(bdsg parambdsg) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "transient focus loss.");
      }
      synchronized (this.a.a)
      {
        if (this.a.a.a == 4) {
          this.a.a();
        }
        return;
      }
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "gained focus");
      }
      if (this.a.b)
      {
        this.a.c();
        this.a.b = false;
      }
    }
    else if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "Audio focus Loss");
      }
      this.a.b();
      synchronized (this.a.a)
      {
        this.a.a.a = 6;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsi
 * JD-Core Version:    0.7.0.1
 */
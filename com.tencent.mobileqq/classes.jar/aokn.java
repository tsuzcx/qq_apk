import android.media.AudioManager.OnAudioFocusChangeListener;

class aokn
  implements AudioManager.OnAudioFocusChangeListener
{
  aokn(aokm paramaokm) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((aokm.a(this.a) != null) && (paramInt == -1) && (aokm.a(this.a) != null)) {
      aokm.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aokn
 * JD-Core Version:    0.7.0.1
 */
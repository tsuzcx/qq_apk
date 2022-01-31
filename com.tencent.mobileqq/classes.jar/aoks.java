import android.media.AudioManager.OnAudioFocusChangeListener;

class aoks
  implements AudioManager.OnAudioFocusChangeListener
{
  aoks(aokr paramaokr) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((aokr.a(this.a) != null) && (paramInt == -1) && (aokr.a(this.a) != null)) {
      aokr.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoks
 * JD-Core Version:    0.7.0.1
 */
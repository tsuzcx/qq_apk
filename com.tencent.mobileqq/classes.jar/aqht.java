import android.media.AudioManager.OnAudioFocusChangeListener;

class aqht
  implements AudioManager.OnAudioFocusChangeListener
{
  aqht(aqhs paramaqhs) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((aqhs.a(this.a) != null) && (paramInt == -1) && (aqhs.a(this.a) != null)) {
      aqhs.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqht
 * JD-Core Version:    0.7.0.1
 */
import android.media.AudioManager.OnAudioFocusChangeListener;

class atct
  implements AudioManager.OnAudioFocusChangeListener
{
  atct(atcs paramatcs) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((atcs.a(this.a) != null) && (paramInt == -1) && (atcs.a(this.a) != null)) {
      atcs.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atct
 * JD-Core Version:    0.7.0.1
 */
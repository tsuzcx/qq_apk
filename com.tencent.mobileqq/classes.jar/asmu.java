import android.media.AudioManager.OnAudioFocusChangeListener;

class asmu
  implements AudioManager.OnAudioFocusChangeListener
{
  asmu(asmt paramasmt) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((asmt.a(this.a) != null) && (paramInt == -1) && (asmt.a(this.a) != null)) {
      asmt.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmu
 * JD-Core Version:    0.7.0.1
 */
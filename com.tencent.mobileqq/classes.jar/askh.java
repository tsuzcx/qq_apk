import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;

public class askh
  implements AudioManager.OnAudioFocusChangeListener
{
  public askh(SmallVideoFragment paramSmallVideoFragment) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (SmallVideoFragment.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     askh
 * JD-Core Version:    0.7.0.1
 */
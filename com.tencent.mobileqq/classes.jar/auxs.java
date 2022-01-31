import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;

public class auxs
  implements CompoundButton.OnCheckedChangeListener
{
  public auxs(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StickyNotePublishFragment.a(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxs
 * JD-Core Version:    0.7.0.1
 */
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;

public class awpe
  implements CompoundButton.OnCheckedChangeListener
{
  public awpe(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StickyNotePublishFragment.a(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpe
 * JD-Core Version:    0.7.0.1
 */
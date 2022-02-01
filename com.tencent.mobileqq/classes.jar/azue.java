import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class azue
  implements CompoundButton.OnCheckedChangeListener
{
  public azue(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StickyNotePublishFragment.a(this.a, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azue
 * JD-Core Version:    0.7.0.1
 */
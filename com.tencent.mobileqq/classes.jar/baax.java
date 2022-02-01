import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class baax
  implements View.OnClickListener
{
  public baax(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(0);
    this.a.b(false);
    StickyNotePublishFragment.a(this.a).setImageResource(2130844828);
    StickyNotePublishFragment.a(this.a).setContentDescription(this.a.getActivity().getString(2131690197));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baax
 * JD-Core Version:    0.7.0.1
 */
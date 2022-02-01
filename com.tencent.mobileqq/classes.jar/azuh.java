import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class azuh
  implements View.OnClickListener
{
  public azuh(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(0);
    this.a.b(false);
    StickyNotePublishFragment.a(this.a).setImageResource(2130844773);
    StickyNotePublishFragment.a(this.a).setContentDescription(this.a.getActivity().getString(2131690260));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azuh
 * JD-Core Version:    0.7.0.1
 */
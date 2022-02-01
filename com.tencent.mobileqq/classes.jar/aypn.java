import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aypn
  implements View.OnClickListener
{
  public aypn(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(1);
    StickyNotePublishFragment.a(this.a).setImageResource(2130837535);
    StickyNotePublishFragment.a(this.a).setContentDescription(this.a.getActivity().getString(2131690223));
    bcef.b(null, "dc00898", "", "", "0X800AB2D", "0X800AB2D", 0, 0, "0", "0", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypn
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;

public class baas
  implements View.OnClickListener
{
  public baas(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(0);
    StickyNotePublishFragment.a(this.a).requestFocus();
    blgx.a(StickyNotePublishFragment.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baas
 * JD-Core Version:    0.7.0.1
 */
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;

public class awtm
  implements View.OnTouchListener
{
  public awtm(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (StickyNotePublishFragment.a(this.a))
    {
      StickyNotePublishFragment.a(this.a).setVisibility(8);
      bhsj.b(StickyNotePublishFragment.a(this.a));
      return false;
    }
    if (StickyNotePublishFragment.a(this.a) == 0)
    {
      StickyNotePublishFragment.a(this.a).setVisibility(8);
      StickyNotePublishFragment.a(this.a).setVisibility(8);
      StickyNotePublishFragment.a(this.a).setVisibility(8);
      StickyNotePublishFragment.a(this.a).setVisibility(0);
      StickyNotePublishFragment.a(this.a).requestFocus();
      bhsj.a(StickyNotePublishFragment.a(this.a));
      return false;
    }
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a, 0);
    this.a.a(false);
    this.a.b(false);
    this.a.c(true);
    this.a.c(0, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awtm
 * JD-Core Version:    0.7.0.1
 */
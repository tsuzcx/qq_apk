import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.widget.XEditTextEx;

public class azic
  extends Editable.Factory
{
  public azic(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bdoi)) {
      return (Editable)paramCharSequence;
    }
    return new bdoi(paramCharSequence, 3, (int)(StickyNotePublishFragment.a(this.a).getTextSize() / StickyNotePublishFragment.a(this.a).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azic
 * JD-Core Version:    0.7.0.1
 */
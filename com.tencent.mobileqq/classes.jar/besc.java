import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorView;

public class besc
  extends InputConnectionWrapper
{
  public besc(WriteTogetherEditorView paramWriteTogetherEditorView, InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    return super.commitText(benq.a(paramCharSequence), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besc
 * JD-Core Version:    0.7.0.1
 */
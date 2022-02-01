import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorView;

public class beqo
  extends InputConnectionWrapper
{
  public beqo(WriteTogetherEditorView paramWriteTogetherEditorView, InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    return super.commitText(bemv.a(paramCharSequence), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqo
 * JD-Core Version:    0.7.0.1
 */
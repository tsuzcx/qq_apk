import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import java.util.List;

public class bnsi
  implements TAVCut.Callback
{
  public bnsi(AEEditorActivity paramAEEditorActivity) {}
  
  public void onDone(int paramInt)
  {
    bnrh.b("AEEditorActivity", "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AEEditorActivity.a(this.a).add(new bnsj(this.a, -8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsi
 * JD-Core Version:    0.7.0.1
 */
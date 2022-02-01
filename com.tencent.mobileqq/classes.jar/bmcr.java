import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import java.util.List;

public class bmcr
  implements TAVCut.Callback
{
  public bmcr(AEEditorActivity paramAEEditorActivity) {}
  
  public void onDone(int paramInt)
  {
    bmbx.b("AEEditorActivity", "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AEEditorActivity.a(this.a).add(new bmcs(this.a, -8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcr
 * JD-Core Version:    0.7.0.1
 */
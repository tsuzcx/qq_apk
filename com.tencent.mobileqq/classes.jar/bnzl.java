import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import java.util.List;

public class bnzl
  implements TAVCut.Callback
{
  public bnzl(AEEditorActivity paramAEEditorActivity) {}
  
  public void onDone(int paramInt)
  {
    bnzb.b(AEEditorActivity.a(), "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AEEditorActivity.a(this.a).add(new bnzm(this.a, -8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzl
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import java.util.List;

public class bljv
  implements TAVCut.Callback
{
  public bljv(AEEditorActivity paramAEEditorActivity) {}
  
  public void onDone(int paramInt)
  {
    bljn.b(AEEditorActivity.a(), "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AEEditorActivity.a(this.a).add(new bljw(this.a, -8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljv
 * JD-Core Version:    0.7.0.1
 */
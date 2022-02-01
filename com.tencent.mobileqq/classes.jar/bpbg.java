import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import java.util.List;

public class bpbg
  implements TAVCut.Callback
{
  public bpbg(AEEditorActivity paramAEEditorActivity) {}
  
  public void onDone(int paramInt)
  {
    bpam.b(AEEditorActivity.a(), "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AEEditorActivity.a(this.a).add(new bpbh(this.a, -8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbg
 * JD-Core Version:    0.7.0.1
 */
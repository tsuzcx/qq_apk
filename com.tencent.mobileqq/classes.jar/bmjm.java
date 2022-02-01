import android.graphics.Point;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.timeline.ScaleScrollLayout;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class bmjm
  implements bmog
{
  public bmjm(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(@Nullable CutModelKt paramCutModelKt)
  {
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {}
    for (Point localPoint = AEEditorMultiCutEditFragment.a(this.a).a();; localPoint = null)
    {
      if ((localPoint != null) && (paramCutModelKt != null) && (AEEditorMultiCutEditFragment.a(this.a).size() > 1))
      {
        AEEditorMultiCutEditFragment.a(this.a).b();
        AEEditorMultiCutEditFragment.a(this.a).a(paramCutModelKt.getUuid(), localPoint);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjm
 * JD-Core Version:    0.7.0.1
 */
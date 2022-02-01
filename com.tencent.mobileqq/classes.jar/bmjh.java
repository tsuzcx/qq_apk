import android.view.View;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

public class bmjh
  implements bmoc
{
  public bmjh(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AEEditorMultiCutEditFragment.a(this.a).setScrollX(paramView.getScrollX());
    AEEditorMultiCutEditFragment.a(this.a).postInvalidate();
    if (AEEditorMultiCutEditFragment.a(this.a).a()) {
      AEEditorMultiCutEditFragment.a(this.a).b();
    }
    AEEditorMultiCutEditFragment.c(this.a, AEEditorMultiCutEditFragment.a(this.a).b(paramView.getScrollX()));
    this.a.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjh
 * JD-Core Version:    0.7.0.1
 */
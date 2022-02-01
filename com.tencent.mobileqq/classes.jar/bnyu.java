import android.animation.Animator;
import android.arch.lifecycle.MutableLiveData;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weishi.module.edit.cut.CutExtKt;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.reorder.ReorderContainerView;
import dov.com.qq.im.aeeditor.view.timeline.ScaleScrollLayout;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.LinkedList;

public class bnyu
  implements boee
{
  public bnyu(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=16)
  public void a(@NonNull String paramString, int paramInt)
  {
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(4);
    }
    if (AEEditorMultiCutEditFragment.a(this.a) != null)
    {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(0);
      AEEditorMultiCutEditFragment.a(this.a).setHandleView(null);
    }
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(0);
    }
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(0);
    }
    AEEditorMultiCutEditFragment.a(this.a, true);
    if ((AEEditorMultiCutEditFragment.a(this.a) != null) && (!paramString.isEmpty()) && (paramInt != -1))
    {
      long l = CutExtKt.calculateReorderSeek(AEEditorMultiCutEditFragment.a(this.a), new LinkedList(), paramString, paramInt);
      if (l >= 0L) {
        AEEditorMultiCutEditFragment.a(this.a, l);
      }
      AEEditorMultiCutEditFragment.a(this.a).a.postValue(bnzu.a(paramString, paramInt, AEEditorMultiCutEditFragment.a(this.a), AEEditorMultiCutEditFragment.a(this.a).getMediaModel()));
      bnqm.a().E();
    }
  }
  
  @RequiresApi(api=19)
  public void a(@NonNull String paramString, @NonNull Point paramPoint)
  {
    AEEditorMultiCutEditFragment.a(this.a).setVisibility(8);
    AEEditorMultiCutEditFragment.a(this.a).setVisibility(8);
    AEEditorMultiCutEditFragment.a(this.a, false);
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {}
    for (int i = AEEditorMultiCutEditFragment.a(this.a).a(paramString, paramPoint);; i = -1)
    {
      bnrh.b("AEEditorMultiCutEditFragment", "dragIndex: " + i);
      if (i != -1)
      {
        int j = this.a.getResources().getDimensionPixelSize(2131296303);
        int k = paramPoint.x;
        int m = this.a.getResources().getDimensionPixelSize(2131296327);
        paramString = boef.a(this.a.a.a(), i, k - m, j);
        paramString.setDuration(200L);
        AEEditorMultiCutEditFragment.a(this.a).a();
        paramString.addListener(new bnyv(this, i));
        paramString.start();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyu
 * JD-Core Version:    0.7.0.1
 */
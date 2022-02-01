import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

public class bnyw
  implements View.OnClickListener
{
  public bnyw(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (bnrf.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((AEEditorMultiCutEditFragment.a(this.a) == null) || (!AEEditorMultiCutEditFragment.a(this.a).isShowing())) && (this.a.a != null))
      {
        CutModelKt localCutModelKt = this.a.a.a();
        if ((localCutModelKt == null) || (localCutModelKt.getResource() == null) || (localCutModelKt.getResource().getType() == 2)) {
          bnrh.a("AEEditorMultiCutEditFragment", "[mIvSpeedBtn.onClick] type==IMAGE_TYPE");
        } else {
          AEEditorMultiCutEditFragment.a(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyw
 * JD-Core Version:    0.7.0.1
 */
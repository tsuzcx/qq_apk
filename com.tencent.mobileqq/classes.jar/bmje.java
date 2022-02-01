import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

public class bmje
  implements View.OnClickListener
{
  public bmje(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (bmbv.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((AEEditorMultiCutEditFragment.a(this.a) == null) || (!AEEditorMultiCutEditFragment.a(this.a).isShowing())) && (this.a.a != null))
      {
        CutModelKt localCutModelKt = this.a.a.a();
        if ((localCutModelKt == null) || (localCutModelKt.getResource() == null) || (localCutModelKt.getResource().getType() == 2)) {
          bmbx.a("AEEditorMultiCutEditFragment", "[mIvSpeedBtn.onClick] type==IMAGE_TYPE");
        } else {
          AEEditorMultiCutEditFragment.a(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmje
 * JD-Core Version:    0.7.0.1
 */
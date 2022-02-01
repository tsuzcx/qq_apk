import android.os.Bundle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.MediaModel;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.List;

public class bnzl
  implements bodd
{
  public bnzl(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void aD_()
  {
    this.a.a().a(this.a.getActivity(), true);
  }
  
  public void aE_()
  {
    long l = this.a.a.a();
    bnqm.a().a(l / 1000L, AEEditorMultiCutEditFragment.a(this.a).size(), bnzw.a(AEEditorMultiCutEditFragment.a(this.a)));
    if (l < 2000L)
    {
      QQToast.a(this.a.getActivity(), 2131689707, 0).a();
      return;
    }
    this.a.getArguments().putString("editor_filter_id", "");
    Object localObject;
    if (AEEditorMultiCutEditFragment.b(this.a))
    {
      localObject = "video_edit_clip_start_time";
      if (!AEEditorMultiCutEditFragment.b(this.a)) {
        break label242;
      }
    }
    label242:
    for (String str = "video_edit_clip_end_time";; str = "endtime")
    {
      this.a.getArguments().putLong((String)localObject, 0L);
      this.a.getArguments().putLong(str, Math.min(60000000L, AEEditorMultiCutEditFragment.a(this.a).getDuration().getTimeUs()));
      if ((AEEditorMultiCutEditFragment.a(this.a) != null) && (AEEditorMultiCutEditFragment.a(this.a).getMediaModel() != null)) {
        this.a.getArguments().putSerializable("resource_model", AEEditorMultiCutEditFragment.a(this.a).getMediaModel().getMediaResourceModel());
      }
      localObject = new Bundle(this.a.getArguments());
      this.a.a().d(this.a.a(), (Bundle)localObject);
      return;
      localObject = "starttime";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzl
 * JD-Core Version:    0.7.0.1
 */
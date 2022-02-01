import android.os.Bundle;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

public class bpfo
  implements bpkp
{
  public bpfo(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void aQ_()
  {
    this.a.a().a(this.a.getActivity(), true);
  }
  
  public void aR_()
  {
    bozr.a().a(1);
    Object localObject;
    String str1;
    label33:
    String str2;
    if (AEEditorVideoClipFragment.a(this.a))
    {
      localObject = "video_edit_clip_start_time";
      if (!AEEditorVideoClipFragment.a(this.a)) {
        break label190;
      }
      str1 = "video_edit_clip_end_time";
      if (!AEEditorVideoClipFragment.a(this.a)) {
        break label196;
      }
      str2 = "video_edit_clip_speed";
      label46:
      if (AEEditorVideoClipFragment.a(this.a) == null) {
        break label202;
      }
      this.a.getArguments().putLong((String)localObject, AEEditorVideoClipFragment.a(this.a).getStartUs());
      this.a.getArguments().putLong(str1, AEEditorVideoClipFragment.a(this.a).getEndUs());
    }
    for (;;)
    {
      localObject = new Bundle(this.a.getArguments());
      ((Bundle)localObject).putString("select_path", AEEditorVideoClipFragment.a(this.a));
      if (this.a.a != null) {
        ((Bundle)localObject).putFloat(str2, this.a.a.floatValue());
      }
      this.a.getArguments().putString("editor_filter_id", "");
      this.a.a().c(this.a.a(), (Bundle)localObject);
      return;
      localObject = "starttime";
      break;
      label190:
      str1 = "endtime";
      break label33;
      label196:
      str2 = "speed";
      break label46;
      label202:
      if (AEEditorVideoClipFragment.a(this.a) != null)
      {
        this.a.getArguments().putLong((String)localObject, 0L);
        this.a.getArguments().putLong(str1, Math.min(60000000L, AEEditorVideoClipFragment.a(this.a).getDuration().getTimeUs()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfo
 * JD-Core Version:    0.7.0.1
 */
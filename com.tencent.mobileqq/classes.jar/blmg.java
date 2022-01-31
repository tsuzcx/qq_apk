import android.os.Bundle;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

public class blmg
  implements blpv
{
  public blmg(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void aS_()
  {
    this.a.a().a(this.a.getActivity(), true);
  }
  
  public void aT_()
  {
    bliu.a().a(1);
    Bundle localBundle = new Bundle(this.a.getArguments());
    localBundle.putString("select_path", AEEditorVideoClipFragment.a(this.a));
    if (AEEditorVideoClipFragment.a(this.a) != null)
    {
      localBundle.putLong("starttime", AEEditorVideoClipFragment.a(this.a).getStartUs());
      localBundle.putLong("endtime", AEEditorVideoClipFragment.a(this.a).getEndUs());
    }
    for (;;)
    {
      this.a.a().c(this.a.a(), localBundle);
      return;
      if ((AEEditorVideoClipFragment.a(this.a) != null) && (AEEditorVideoClipFragment.a(this.a).getDuration().getTimeUs() > 60000000L))
      {
        localBundle.putLong("starttime", 0L);
        localBundle.putLong("endtime", 60000000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmg
 * JD-Core Version:    0.7.0.1
 */
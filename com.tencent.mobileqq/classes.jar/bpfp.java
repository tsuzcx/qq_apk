import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.player.MoviePlayer;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

public class bpfp
  implements bpfl
{
  public bpfp(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void a()
  {
    AEEditorVideoClipFragment.a(this.a);
  }
  
  public void a(CMTime paramCMTime)
  {
    if (AEEditorVideoClipFragment.a(this.a) != null) {
      AEEditorVideoClipFragment.a(this.a).seekToTime(paramCMTime);
    }
  }
  
  public void a(CMTimeRange paramCMTimeRange)
  {
    AEEditorVideoClipFragment.a(this.a, paramCMTimeRange);
    Object localObject = Long.valueOf(paramCMTimeRange.getStartUs());
    long l = paramCMTimeRange.getEndUs();
    if ((localObject != null) && (localObject != null))
    {
      paramCMTimeRange = CMTime.convertTimeScale(CMTime.fromMs(((Long)localObject).longValue() / 1000L), 1000);
      localObject = CMTime.convertTimeScale(CMTime.fromMs(Long.valueOf(l).longValue() / 1000L), 1000).sub(paramCMTimeRange);
      AEEditorVideoClipFragment.a(this.a).setPlayRange(new CMTimeRange(paramCMTimeRange, (CMTime)localObject));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (AEEditorVideoClipFragment.a(this.a) != null)
    {
      if ((!AEEditorVideoClipFragment.a(this.a).isPlaying()) || (paramBoolean)) {
        break label58;
      }
      AEEditorVideoClipFragment.a(this.a).pause();
      AEEditorVideoClipFragment.a(this.a, false);
      AEEditorVideoClipFragment.a(this.a).setAutoPlay(false);
    }
    label58:
    while ((AEEditorVideoClipFragment.a(this.a).isPlaying()) || (!paramBoolean)) {
      return;
    }
    AEEditorVideoClipFragment.a(this.a).play();
    AEEditorVideoClipFragment.a(this.a, true);
    AEEditorVideoClipFragment.a(this.a).setAutoPlay(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfp
 * JD-Core Version:    0.7.0.1
 */
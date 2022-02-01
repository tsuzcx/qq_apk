import android.widget.ImageView;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

public class bnyy
  implements boeo
{
  public bnyy(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a()
  {
    if ((AEEditorMultiCutEditFragment.a(this.a) != null) && (AEEditorMultiCutEditFragment.a(this.a).a())) {
      AEEditorMultiCutEditFragment.a(this.a).b();
    }
    this.a.a.f();
  }
  
  public void a(int paramInt)
  {
    long l = AEEditorMultiCutEditFragment.a(this.a).a(paramInt);
    if (AEEditorMultiCutEditFragment.a(this.a).a()) {
      AEEditorMultiCutEditFragment.a(this.a).b();
    }
    this.a.a.a(paramInt, 0);
    AEEditorMultiCutEditFragment.c(this.a, l);
  }
  
  public void b(int paramInt)
  {
    this.a.a.a(paramInt, 0);
    this.a.a.setScrollByPassive(false);
    paramInt = (int)(this.a.a.a() * (float)(AEEditorMultiCutEditFragment.a(this.a).getPosition().getTimeUs() / 1000L));
    if (this.a.a.getWidth() / 2 - paramInt >= AEEditorMultiCutEditFragment.a(this.a))
    {
      AEEditorMultiCutEditFragment.c(this.a).setVisibility(0);
      return;
    }
    AEEditorMultiCutEditFragment.c(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyy
 * JD-Core Version:    0.7.0.1
 */
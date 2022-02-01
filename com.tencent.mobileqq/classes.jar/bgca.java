import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

class bgca
  implements bdyi
{
  final WeakReference<SpriteVideoView> a;
  
  private bgca(SpriteVideoView paramSpriteVideoView)
  {
    this.a = new WeakReference(paramSpriteVideoView);
  }
  
  public void a()
  {
    SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.a.get();
    if (localSpriteVideoView != null) {
      localSpriteVideoView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgca
 * JD-Core Version:    0.7.0.1
 */